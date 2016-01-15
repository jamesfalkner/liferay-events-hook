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

import com.liferay.events.global.mobile.NoSuchEventContactException;
import com.liferay.events.global.mobile.Utils;
import com.liferay.events.global.mobile.model.EventContact;
import com.liferay.events.global.mobile.service.EventContactLocalServiceUtil;
import com.liferay.events.global.mobile.service.MatchLocalServiceUtil;
import com.liferay.events.global.mobile.service.base.EventContactLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;

import java.util.*;

/**
 * The implementation of the contact local service.
 * <p/>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author James Falkner
 */
public class EventContactLocalServiceImpl extends EventContactLocalServiceBaseImpl {

	public void deleteAll() throws SystemException {
		eventContactPersistence.removeAll();
	}

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.liferay.events.global.mobile.service.ContactLocalServiceUtil} to access the contact local service.
	 */
	public EventContact addEventContact(long userId, long groupId, ServiceContext serviceContext, String eventId,
										String givenName, String fullName, String attendeeType, String emailAddress,
										String city, String country, double lat, double lng, String company,
										String jobTitle, String industry, String interests, String desires,
										String expertise, String picUrl) throws PortalException, SystemException {

		User user = userPersistence.findByPrimaryKey(userId);

		Date now = new Date();

		long contactId = counterLocalService.increment(EventContact.class.getName());

		EventContact contact = eventContactPersistence.create(contactId);

		contact.setVerified(false);
		contact.setEventId(eventId);
		contact.setGivenName(givenName);
		contact.setFullName(fullName);
		contact.setAttendeeType(attendeeType);
		contact.setEmailAddress(emailAddress);
		contact.setLat(lat);
		contact.setLng(lng);
		contact.setCity(city);
		contact.setCountry(country);
		contact.setJobTitle(jobTitle);
		contact.setIndustry(industry);
		contact.setCompany(company);
		contact.setInterests(JSONFactoryUtil.createJSONArray(interests).toString());
		contact.setDesires(JSONFactoryUtil.createJSONArray(desires).toString());
		contact.setExpertise(JSONFactoryUtil.createJSONArray(expertise).toString());
		contact.setPicUrl(picUrl);
		contact.setGroupId(groupId);
		contact.setCompanyId(user.getCompanyId());
		contact.setUserId(user.getUserId());
		contact.setCreateDate(serviceContext.getCreateDate(now));
		contact.setModifiedDate(serviceContext.getModifiedDate(now));

		super.addEventContact(contact);

		return contact;
	}

	public EventContact getVerifiedContactByEmailAddress(String eventId, String emailAddress, boolean verified) throws NoSuchEventContactException, SystemException {
		return eventContactPersistence.findByEmailAddress_E_V(eventId, emailAddress, verified);
	}

	public EventContact getContactByEmailAddress(String eventId, String emailAddress) throws NoSuchEventContactException, SystemException {
		return eventContactPersistence.findByEmailAddress_E(eventId, emailAddress);
	}

	public EventContact getVerifiedContact(long eventContactId, boolean verified) throws NoSuchEventContactException, SystemException {
		return eventContactPersistence.findByE_V(eventContactId, verified);
	}

	public EventContact recordInterest(long userId, long groupId, ServiceContext serviceContext, String eventId, long contactId, long targetContactId) throws PortalException, SystemException {

		EventContact contact, targetContact;

		try {
			contact = EventContactLocalServiceUtil.getVerifiedContact(contactId, true);
			targetContact = EventContactLocalServiceUtil.getVerifiedContact(targetContactId, true);
		} catch (PortalException ex) {
			throw new NoSuchEventContactException(ex);
		}

		long[] ints = StringUtil.split(contact.getInterestedIds(), StringPool.COMMA, 0L);
		long[] targetInts = StringUtil.split(targetContact.getInterestedIds(), StringPool.COMMA, 0L);

		Set<Long> intSet = new HashSet<Long>(ints.length);
		for (Long l : ints) {
			intSet.add(l);
		}

		Set<Long> targetIntSet = new HashSet<Long>(targetInts.length);
		for (Long l : targetInts) {
			targetIntSet.add(l);
		}

		if (intSet.contains(targetContactId)) {
			// already recorded
			return targetContact;
		}

		intSet.add(targetContactId);
		contact.setInterestedIds(StringUtil.merge(intSet, StringPool.COMMA));
		EventContactLocalServiceUtil.updateEventContact(contact);

		if (targetIntSet.contains(contactId)) {
			MatchLocalServiceUtil.addMatch(groupId, userId, serviceContext, eventId, contactId, targetContactId);
			// its a match; send PN to target to targetContact
			JSONObject payloadObj = JSONFactoryUtil.createJSONObject();
			payloadObj.put("screen", "");
			payloadObj.put("eventId", eventId);
			payloadObj.put("body", "You are matched with " + contact.getFullName());
			payloadObj.put("sound", "default");
			payloadObj.put("title", "Liferay Events");
			payloadObj.put("smallIcon", "ic_stat_lrlogo.png");
			payloadObj.put("ticker", "New Notification from Liferay Events");
			payloadObj.put("badge", 1);
			payloadObj.put("vibrate", true);
			payloadObj.put("screen", "connectConnections");

			JSONArray nameArgs = JSONFactoryUtil.createJSONArray();
			nameArgs.put(contact.getFullName());


			payloadObj.put("localizedKey", "ITS_A_MATCH");
			payloadObj.put("localizedArgs", nameArgs.toString());

			try {

				Map<String, String> args = new HashMap<String, String>();
				final PostMethod postMethod = new PostMethod("http://localhost:8080/api/jsonws/push-notifications-portlet.pushnotificationsdevice/send-push-notification");

				args.put("channel", eventId);
				args.put("emailAddress", targetContact.getEmailAddress());
				args.put("payload", payloadObj.toString());
				String sig = Utils.generateSig(args);

				postMethod.addParameter("channel", eventId);
				postMethod.addParameter("emailAddress", targetContact.getEmailAddress());
				postMethod.addParameter("payload", payloadObj.toString());
				postMethod.addParameter("signature", sig);
				final HttpClient httpClient = new HttpClient();
				httpClient.executeMethod(postMethod);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
			return targetContact;
		}

		return null;
	}

	public List<EventContact> getInterested(String eventId, Collection<Long> uninterestedIds) throws PortalException, SystemException {
		return eventContactPersistence.findByNotInterested_E_V(eventId, true, ArrayUtil.toLongArray(uninterestedIds));
	}
}