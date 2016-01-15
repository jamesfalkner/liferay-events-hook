package com.liferay.events.global.mobile.service.persistence;

import com.liferay.events.global.mobile.model.Message;
import com.liferay.events.global.mobile.service.MessageLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author James Falkner
 * @generated
 */
public abstract class MessageActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public MessageActionableDynamicQuery() throws SystemException {
        setBaseLocalService(MessageLocalServiceUtil.getService());
        setClass(Message.class);

        setClassLoader(com.liferay.events.global.mobile.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("messageId");
    }
}
