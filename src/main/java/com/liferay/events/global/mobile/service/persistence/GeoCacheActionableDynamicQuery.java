package com.liferay.events.global.mobile.service.persistence;

import com.liferay.events.global.mobile.model.GeoCache;
import com.liferay.events.global.mobile.service.GeoCacheLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author James Falkner
 * @generated
 */
public abstract class GeoCacheActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public GeoCacheActionableDynamicQuery() throws SystemException {
        setBaseLocalService(GeoCacheLocalServiceUtil.getService());
        setClass(GeoCache.class);

        setClassLoader(com.liferay.events.global.mobile.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("geoCacheId");
    }
}
