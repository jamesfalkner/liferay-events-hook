package com.liferay.events.global.mobile.service.impl;
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

import com.liferay.events.global.mobile.NoSuchEventPollAnswerException;
import com.liferay.events.global.mobile.model.EventPollAnswer;
import com.liferay.events.global.mobile.service.base.EventPollAnswerLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The implementation of the event poll answer local service.
 * <p/>
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.events.global.mobile.service.EventPollAnswerLocalService} interface.
 * <p/>
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author James Falkner
 * @see com.liferay.events.global.mobile.service.base.EventPollAnswerLocalServiceBaseImpl
 * @see com.liferay.events.global.mobile.service.EventPollAnswerLocalServiceUtil
 */
public class EventPollAnswerLocalServiceImpl
		extends EventPollAnswerLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.liferay.events.global.mobile.service.EventPollAnswerLocalServiceUtil} to access the event poll answer local service.
	 */
	public void deleteAll() throws SystemException {
		eventPollAnswerPersistence.removeAll();

	}

	public List<EventPollAnswer> getAllAnswerObjs(long questionId) throws SystemException {
		return eventPollAnswerPersistence.findByEventPollAnswer_Q(questionId);
	}

	public List<String> getAllAnswers(long questionId) throws SystemException {
		List<String> results = new ArrayList<String>();

		for (EventPollAnswer a : eventPollAnswerPersistence.findByEventPollAnswer_Q(questionId)) {
			results.add(a.getAnswer());
		}

		return results;
	}

	public void deleteAnswersForQuestion(long questionId) throws SystemException, NoSuchEventPollAnswerException {
		for (EventPollAnswer a : eventPollAnswerPersistence.findByEventPollAnswer_Q(questionId)) {
			eventPollAnswerPersistence.remove(a.getAnswerId());
		}
	}

	public long countAnswers(long questionId) throws SystemException {
		return eventPollAnswerPersistence.countByEventPollAnswer_Q(questionId);
	}

	public EventPollAnswer addAnswer(long questionId, String clientId, String payload, String answer, ServiceContext serviceContext) throws PortalException, SystemException {

		Date now = new Date();

		long aId = counterLocalService.increment(EventPollAnswer.class.getName());

		EventPollAnswer a = eventPollAnswerPersistence.create(aId);

		a.setAnswer(answer);
		a.setClientId(clientId);
		a.setPayload(payload);
		a.setQuestionId(questionId);
		a.setCreateDate(serviceContext.getCreateDate(now));

		super.addEventPollAnswer(a);

		return a;
	}


}
