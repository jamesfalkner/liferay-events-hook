package com.liferay.events.global.mobile.service.persistence;

import com.liferay.events.global.mobile.model.Match;
import com.liferay.events.global.mobile.service.MatchLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author James Falkner
 * @generated
 */
public abstract class MatchActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public MatchActionableDynamicQuery() throws SystemException {
        setBaseLocalService(MatchLocalServiceUtil.getService());
        setClass(Match.class);

        setClassLoader(com.liferay.events.global.mobile.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("matchId");
    }
}
