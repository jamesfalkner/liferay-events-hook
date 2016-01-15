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

import com.liferay.events.global.mobile.NoSuchGeoCacheException;
import com.liferay.events.global.mobile.model.GeoCache;
import com.liferay.events.global.mobile.model.Match;
import com.liferay.events.global.mobile.service.base.GeoCacheLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.Date;

/**
 * The implementation of the geo cache local service.
 * <p/>
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.events.global.mobile.service.GeoCacheLocalService} interface.
 * <p/>
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author James Falkner
 * @see com.liferay.events.global.mobile.service.base.GeoCacheLocalServiceBaseImpl
 * @see com.liferay.events.global.mobile.service.GeoCacheLocalServiceUtil
 */
public class GeoCacheLocalServiceImpl extends GeoCacheLocalServiceBaseImpl {
	/*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.liferay.events.global.mobile.service.GeoCacheLocalServiceUtil} to access the geo cache local service.
     */

	public GeoCache addGeoCache(String addr, double lat, double lng) throws SystemException {

		Date now = new Date();

		long geoCacheId = counterLocalService.increment(Match.class.getName());

		GeoCache geoCache = geoCachePersistence.create(geoCacheId);
		geoCache.setAddress(addr);
		geoCache.setLat(lat);
		geoCache.setLng(lng);
		geoCache.setCreateDate(now);
		super.addGeoCache(geoCache);
		return geoCache;
	}

	public GeoCache findGeoCacheByAddress(String addr) throws SystemException, NoSuchGeoCacheException {
		return geoCachePersistence.findByGeoByAddress(addr);
	}
}
