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

import com.liferay.events.global.mobile.model.EventPollQuestion;
import com.liferay.events.global.mobile.model.PollQuestionType;
import com.liferay.events.global.mobile.service.base.EventPollQuestionLocalServiceBaseImpl;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceContext;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the event poll question local service.
 * <p/>
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.events.global.mobile.service.EventPollQuestionLocalService} interface.
 * <p/>
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author James Falkner
 * @see com.liferay.events.global.mobile.service.base.EventPollQuestionLocalServiceBaseImpl
 * @see com.liferay.events.global.mobile.service.EventPollQuestionLocalServiceUtil
 */
public class EventPollQuestionLocalServiceImpl
		extends EventPollQuestionLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.liferay.events.global.mobile.service.EventPollQuestionLocalServiceUtil} to access the event poll question local service.
	 */
	public void deleteAll() throws SystemException {
		eventPollQuestionPersistence.removeAll();
	}

	public List<String> getAllEvents() throws SystemException {

		DynamicQuery q = DynamicQueryFactoryUtil.forClass(EventPollQuestion.class, EventPollQuestion.class.getClassLoader());

		q.setProjection(ProjectionFactoryUtil.distinct(ProjectionFactoryUtil.property("eventId")));

		return (List<String>)dynamicQuery(q);
	}

	public List<EventPollQuestion> getAllQuestionsForEvent(String eventId, int start, int end) throws SystemException {
		return eventPollQuestionPersistence.findByEventPollQuestion_E(eventId, start, end);
	}
	public int getAllQuestionsForEventCount(String eventId) throws SystemException {
		return eventPollQuestionPersistence.countByEventPollQuestion_E(eventId);
	}

	public List<EventPollQuestion> getAutoEnabled(Date beforeDate) throws SystemException {

		return eventPollQuestionPersistence.findByEventPollQuestion_A_E_D(true, false, beforeDate);
	}

	@Override
	public EventPollQuestion addQuestion(String eventId,
										 String sponsorName, String shortTitle, String question, String questionType,
										 String chartType, boolean askForId, String idIntro, String choices,
										 boolean anonymousResults, boolean showResponseCount, String picUrl, boolean enabled,
										 boolean autoEnable, Date enableTriggerDate, String enableTriggerTimezone, ServiceContext serviceContext) throws PortalException, SystemException {

		String resolvedTypeName = null;

		for (PollQuestionType c : PollQuestionType.values()) {
			if (c.getTypeName().equalsIgnoreCase(questionType)) {
				resolvedTypeName = questionType;
			}
		}

		if (Validator.isNull(resolvedTypeName)) {
			throw new PortalException("Type name " + questionType + " invalid");
		}

		Date now = new Date();

		long qId = counterLocalService.increment(EventPollQuestion.class.getName());

		EventPollQuestion q = eventPollQuestionPersistence.create(qId);

		q.setEnabled(enabled);
		q.setAutoEnable(autoEnable);
		q.setEnableTriggerDate(enableTriggerDate);
		q.setEnableTriggerTimezone(enableTriggerTimezone);
		q.setEventId(eventId);
		q.setShortTitle(shortTitle);
		q.setQuestion(question);
		q.setChartType(chartType);
		q.setAskForId(askForId);
		q.setShowResponseCount(showResponseCount);
		q.setIdIntro(idIntro);
		q.setSponsorName(sponsorName);
		q.setPicUrl(picUrl);
		q.setQuestionType(resolvedTypeName);
		q.setChoices(choices);
		q.setAnonymousResults(anonymousResults);
		q.setCreateDate(serviceContext.getCreateDate(now));

		super.addEventPollQuestion(q);

		return q;
	}

	@Override
	public EventPollQuestion updateQuestion(long questionId, boolean enabled, boolean autoEnable, Date enableTriggerDate, String enableTriggerTimezone,
											String eventId,
										 String sponsorName, String shortTitle, String question, String chartType,
											boolean askForId, String idIntro,  String questionType, String choices,
											boolean anonymousResults, boolean showResponseCount, String picUrl, ServiceContext serviceContext) throws PortalException, SystemException {

		String resolvedTypeName = null;

		for (PollQuestionType c : PollQuestionType.values()) {
			if (c.getTypeName().equalsIgnoreCase(questionType)) {
				resolvedTypeName = questionType;
			}
		}

		if (Validator.isNull(resolvedTypeName)) {
			throw new PortalException("Type name " + questionType + " invalid");
		}

		EventPollQuestion q = eventPollQuestionPersistence.fetchByPrimaryKey(questionId);

		q.setEnabled(enabled);
		q.setAutoEnable(autoEnable);
		q.setEnableTriggerDate(enableTriggerDate);
		q.setEnableTriggerTimezone(enableTriggerTimezone);
		q.setAnonymousResults(anonymousResults);
		q.setEventId(eventId);
		q.setSponsorName(sponsorName);
		q.setShowResponseCount(showResponseCount);
		q.setShortTitle(shortTitle);
		q.setChartType(chartType);
		q.setAskForId(askForId);
		q.setIdIntro(idIntro);
		q.setQuestion(question);
		q.setPicUrl(picUrl);
		q.setQuestionType(resolvedTypeName);
		q.setChoices(choices);

		super.updateEventPollQuestion(q);
		return q;
	}

}
