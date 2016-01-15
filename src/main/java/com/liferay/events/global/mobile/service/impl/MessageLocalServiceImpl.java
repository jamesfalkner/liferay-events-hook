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

import com.liferay.events.global.mobile.model.Message;
import com.liferay.events.global.mobile.service.base.MessageLocalServiceBaseImpl;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the message local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.events.global.mobile.service.MessageLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author James Falkner
 * @see com.liferay.events.global.mobile.service.base.MessageLocalServiceBaseImpl
 * @see com.liferay.events.global.mobile.service.MessageLocalServiceUtil
 */
public class MessageLocalServiceImpl extends MessageLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.liferay.events.global.mobile.service.MessageLocalServiceUtil} to access the message local service.
     */

	public void deleteAll() throws SystemException {
		messagePersistence.removeAll();
	}

	public Message addMessage(long userId, long groupId, ServiceContext serviceContext, String eventId, long contactId, long targetContactId, String message) throws PortalException, SystemException {

		User user = userPersistence.findByPrimaryKey(userId);

		Date now = new Date();

		long messageId = counterLocalService.increment(Message.class.getName());

		Message messageObj = messagePersistence.create(messageId);

		messageObj.setRead(false);
		messageObj.setEventId(eventId);
		messageObj.setGroupId(groupId);
		messageObj.setCompanyId(user.getCompanyId());
		messageObj.setUserId(user.getUserId());
		messageObj.setCreateDate(serviceContext.getCreateDate(now));
		messageObj.setModifiedDate(serviceContext.getModifiedDate(now));

		messageObj.setFromId(contactId);
		messageObj.setToId(targetContactId);
		messageObj.setContent(message);

		super.addMessage(messageObj);

		return messageObj;

	}

	public List<Message> getContactMessages(String eventId, long contactId, long beginDate) throws PortalException, SystemException {

		DynamicQuery q = DynamicQueryFactoryUtil.forClass(Message.class, Message.class.getClassLoader());
		q.add(RestrictionsFactoryUtil.eq("eventId", eventId));
		q.add(RestrictionsFactoryUtil.or(RestrictionsFactoryUtil.eq("fromId", contactId),
				RestrictionsFactoryUtil.eq("toId", contactId)));
		if (beginDate > 0) {
			q.add(RestrictionsFactoryUtil.gt("createDate", new Date(beginDate)));
		}

		return dynamicQuery(q);

	}
}
