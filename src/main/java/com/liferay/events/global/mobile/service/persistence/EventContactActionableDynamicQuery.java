package com.liferay.events.global.mobile.service.persistence;

import com.liferay.events.global.mobile.model.EventContact;
import com.liferay.events.global.mobile.service.EventContactLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author James Falkner
 * @generated
 */
public abstract class EventContactActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public EventContactActionableDynamicQuery() throws SystemException {
        setBaseLocalService(EventContactLocalServiceUtil.getService());
        setClass(EventContact.class);

        setClassLoader(com.liferay.events.global.mobile.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("eventContactId");
    }
}
