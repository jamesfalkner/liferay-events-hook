package com.liferay.events.global.mobile.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link GeoCacheLocalService}.
 *
 * @author James Falkner
 * @see GeoCacheLocalService
 * @generated
 */
public class GeoCacheLocalServiceWrapper implements GeoCacheLocalService,
    ServiceWrapper<GeoCacheLocalService> {
    private GeoCacheLocalService _geoCacheLocalService;

    public GeoCacheLocalServiceWrapper(
        GeoCacheLocalService geoCacheLocalService) {
        _geoCacheLocalService = geoCacheLocalService;
    }

    /**
    * Adds the geo cache to the database. Also notifies the appropriate model listeners.
    *
    * @param geoCache the geo cache
    * @return the geo cache that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.liferay.events.global.mobile.model.GeoCache addGeoCache(
        com.liferay.events.global.mobile.model.GeoCache geoCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _geoCacheLocalService.addGeoCache(geoCache);
    }

    /**
    * Creates a new geo cache with the primary key. Does not add the geo cache to the database.
    *
    * @param geoCacheId the primary key for the new geo cache
    * @return the new geo cache
    */
    @Override
    public com.liferay.events.global.mobile.model.GeoCache createGeoCache(
        long geoCacheId) {
        return _geoCacheLocalService.createGeoCache(geoCacheId);
    }

    /**
    * Deletes the geo cache with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param geoCacheId the primary key of the geo cache
    * @return the geo cache that was removed
    * @throws PortalException if a geo cache with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.liferay.events.global.mobile.model.GeoCache deleteGeoCache(
        long geoCacheId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _geoCacheLocalService.deleteGeoCache(geoCacheId);
    }

    /**
    * Deletes the geo cache from the database. Also notifies the appropriate model listeners.
    *
    * @param geoCache the geo cache
    * @return the geo cache that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.liferay.events.global.mobile.model.GeoCache deleteGeoCache(
        com.liferay.events.global.mobile.model.GeoCache geoCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _geoCacheLocalService.deleteGeoCache(geoCache);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _geoCacheLocalService.dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _geoCacheLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.events.global.mobile.model.impl.GeoCacheModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _geoCacheLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.events.global.mobile.model.impl.GeoCacheModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _geoCacheLocalService.dynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _geoCacheLocalService.dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _geoCacheLocalService.dynamicQueryCount(dynamicQuery, projection);
    }

    @Override
    public com.liferay.events.global.mobile.model.GeoCache fetchGeoCache(
        long geoCacheId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _geoCacheLocalService.fetchGeoCache(geoCacheId);
    }

    /**
    * Returns the geo cache with the primary key.
    *
    * @param geoCacheId the primary key of the geo cache
    * @return the geo cache
    * @throws PortalException if a geo cache with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.liferay.events.global.mobile.model.GeoCache getGeoCache(
        long geoCacheId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _geoCacheLocalService.getGeoCache(geoCacheId);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _geoCacheLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the geo caches.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.events.global.mobile.model.impl.GeoCacheModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of geo caches
    * @param end the upper bound of the range of geo caches (not inclusive)
    * @return the range of geo caches
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.liferay.events.global.mobile.model.GeoCache> getGeoCaches(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _geoCacheLocalService.getGeoCaches(start, end);
    }

    /**
    * Returns the number of geo caches.
    *
    * @return the number of geo caches
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getGeoCachesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _geoCacheLocalService.getGeoCachesCount();
    }

    /**
    * Updates the geo cache in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param geoCache the geo cache
    * @return the geo cache that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.liferay.events.global.mobile.model.GeoCache updateGeoCache(
        com.liferay.events.global.mobile.model.GeoCache geoCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _geoCacheLocalService.updateGeoCache(geoCache);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _geoCacheLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _geoCacheLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _geoCacheLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    @Override
    public com.liferay.events.global.mobile.model.GeoCache addGeoCache(
        java.lang.String addr, double lat, double lng)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _geoCacheLocalService.addGeoCache(addr, lat, lng);
    }

    @Override
    public com.liferay.events.global.mobile.model.GeoCache findGeoCacheByAddress(
        java.lang.String addr)
        throws com.liferay.events.global.mobile.NoSuchGeoCacheException,
            com.liferay.portal.kernel.exception.SystemException {
        return _geoCacheLocalService.findGeoCacheByAddress(addr);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public GeoCacheLocalService getWrappedGeoCacheLocalService() {
        return _geoCacheLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedGeoCacheLocalService(
        GeoCacheLocalService geoCacheLocalService) {
        _geoCacheLocalService = geoCacheLocalService;
    }

    @Override
    public GeoCacheLocalService getWrappedService() {
        return _geoCacheLocalService;
    }

    @Override
    public void setWrappedService(GeoCacheLocalService geoCacheLocalService) {
        _geoCacheLocalService = geoCacheLocalService;
    }
}
