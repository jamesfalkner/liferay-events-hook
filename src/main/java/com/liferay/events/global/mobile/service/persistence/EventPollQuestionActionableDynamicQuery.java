package com.liferay.events.global.mobile.service.persistence;

import com.liferay.events.global.mobile.model.EventPollQuestion;
import com.liferay.events.global.mobile.service.EventPollQuestionLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author James Falkner
 * @generated
 */
public abstract class EventPollQuestionActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public EventPollQuestionActionableDynamicQuery() throws SystemException {
        setBaseLocalService(EventPollQuestionLocalServiceUtil.getService());
        setClass(EventPollQuestion.class);

        setClassLoader(com.liferay.events.global.mobile.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("questionId");
    }
}
