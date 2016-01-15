package com.liferay.events.global.mobile.service.persistence;

import com.liferay.events.global.mobile.model.EventPollAnswer;
import com.liferay.events.global.mobile.service.EventPollAnswerLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author James Falkner
 * @generated
 */
public abstract class EventPollAnswerActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public EventPollAnswerActionableDynamicQuery() throws SystemException {
        setBaseLocalService(EventPollAnswerLocalServiceUtil.getService());
        setClass(EventPollAnswer.class);

        setClassLoader(com.liferay.events.global.mobile.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("answerId");
    }
}
