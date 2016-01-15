/**
 * Copyright 2016 Liferay, Inc. All rights reserved.
 * http://www.liferay.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * @author James Falkner
 */

package com.liferay.events.global.mobile.service.impl;

import com.liferay.events.global.mobile.InvalidSignatureException;
import com.liferay.events.global.mobile.UnmatchedException;
import com.liferay.events.global.mobile.Utils;
import com.liferay.events.global.mobile.model.EventContact;
import com.liferay.events.global.mobile.model.Message;
import com.liferay.events.global.mobile.service.EventContactLocalServiceUtil;
import com.liferay.events.global.mobile.service.MatchLocalServiceUtil;
import com.liferay.events.global.mobile.service.MessageLocalServiceUtil;
import com.liferay.events.global.mobile.service.base.MessageServiceBaseImpl;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.GroupConstants;
import com.liferay.portal.security.ac.AccessControlled;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The implementation of the message remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.events.global.mobile.service.MessageService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author James Falkner
 * @see com.liferay.events.global.mobile.service.base.MessageServiceBaseImpl
 * @see com.liferay.events.global.mobile.service.MessageServiceUtil
 */
public class MessageServiceImpl extends MessageServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.liferay.events.global.mobile.service.MessageServiceUtil} to access the message remote service.
     */

	@AccessControlled(guestAccessEnabled = true)
	@Override
	public Message sendMessage(final String eventId, final long contactId, final long targetContactId, final String message, String signature) throws Exception {
		Map<String, String> args = new HashMap<String, String>() {{
			put("eventId", StringUtil.valueOf(eventId));
			put("contactId", StringUtil.valueOf(contactId));
			put("targetContactId", StringUtil.valueOf(targetContactId));
			put("message", StringUtil.valueOf(message));
		}};

		if (!Utils.isValidSignature(args, signature)) {
			throw new InvalidSignatureException("invalid signature");
		}

		if (!MatchLocalServiceUtil.matches(eventId, contactId, targetContactId)) {
			throw new UnmatchedException("Sender has not been matched with recipient");
		}

		EventContact sender = EventContactLocalServiceUtil.getEventContact(contactId);
		EventContact targetContact = EventContactLocalServiceUtil.getEventContact(targetContactId);

		final String groupName = GroupConstants.GUEST;
		final long companyId = PortalUtil.getDefaultCompanyId();
		final long guestGroupId = GroupLocalServiceUtil.getGroup(companyId, groupName).getGroupId();

		Message result = MessageLocalServiceUtil.addMessage(getUserId(), guestGroupId, new ServiceContext(),
				eventId, contactId, targetContactId, Utils.removeUnicode(message));

		JSONObject payloadObj = JSONFactoryUtil.createJSONObject();
		payloadObj.put("eventId", eventId);
		payloadObj.put("screen", "");
		payloadObj.put("body", Utils.removeUnicode(message));
		payloadObj.put("sound", "default");
		payloadObj.put("title", sender.getFullName());
		payloadObj.put("smallIcon", "ic_stat_lrlogo.png");
		payloadObj.put("ticker", message);
		payloadObj.put("badge", 1);
		payloadObj.put("vibrate", true);
		payloadObj.put("screen", "connectChat");
		payloadObj.put("screenDetail", String.valueOf(contactId));

		try {

			Map<String, String> postArgs = new HashMap<String, String>();
			final PostMethod postMethod = new PostMethod("http://localhost:8080/api/jsonws/push-notifications-portlet.pushnotificationsdevice/send-push-notification");

			postArgs.put("channel", eventId);
			postArgs.put("emailAddress", targetContact.getEmailAddress());
			postArgs.put("payload", payloadObj.toString());
			String sig = Utils.generateSig(postArgs);

			postMethod.addParameter("channel", eventId);
			postMethod.addParameter("emailAddress", targetContact.getEmailAddress());
			postMethod.addParameter("payload", payloadObj.toString());
			postMethod.addParameter("signature", sig);
			final HttpClient httpClient = new HttpClient();
			httpClient.executeMethod(postMethod);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return result;
	}

	@AccessControlled(guestAccessEnabled = true)
	@Override
	public List<Message> getMessages(final String eventId, final long contactId, final long beginDate, String signature) throws Exception {
		Map<String, String> args = new HashMap<String, String>() {{
			put("eventId", StringUtil.valueOf(eventId));
			put("beginDate", StringUtil.valueOf(beginDate));
			put("contactId", StringUtil.valueOf(contactId));
		}};

		if (!Utils.isValidSignature(args, signature)) {
			throw new InvalidSignatureException("invalid signature");
		}

		return MessageLocalServiceUtil.getContactMessages(eventId, contactId, beginDate);
	}



}
