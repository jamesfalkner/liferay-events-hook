package com.liferay.events.global.mobile.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for GeoCache. This utility wraps
 * {@link com.liferay.events.global.mobile.service.impl.GeoCacheLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author James Falkner
 * @see GeoCacheLocalService
 * @see com.liferay.events.global.mobile.service.base.GeoCacheLocalServiceBaseImpl
 * @see com.liferay.events.global.mobile.service.impl.GeoCacheLocalServiceImpl
 * @generated
 */
public class GeoCacheLocalServiceUtil {
    private static GeoCacheLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.liferay.events.global.mobile.service.impl.GeoCacheLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the geo cache to the database. Also notifies the appropriate model listeners.
    *
    * @param geoCache the geo cache
    * @return the geo cache that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.events.global.mobile.model.GeoCache addGeoCache(
        com.liferay.events.global.mobile.model.GeoCache geoCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addGeoCache(geoCache);
    }

    /**
    * Creates a new geo cache with the primary key. Does not add the geo cache to the database.
    *
    * @param geoCacheId the primary key for the new geo cache
    * @return the new geo cache
    */
    public static com.liferay.events.global.mobile.model.GeoCache createGeoCache(
        long geoCacheId) {
        return getService().createGeoCache(geoCacheId);
    }

    /**
    * Deletes the geo cache with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param geoCacheId the primary key of the geo cache
    * @return the geo cache that was removed
    * @throws PortalException if a geo cache with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.events.global.mobile.model.GeoCache deleteGeoCache(
        long geoCacheId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteGeoCache(geoCacheId);
    }

    /**
    * Deletes the geo cache from the database. Also notifies the appropriate model listeners.
    *
    * @param geoCache the geo cache
    * @return the geo cache that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.events.global.mobile.model.GeoCache deleteGeoCache(
        com.liferay.events.global.mobile.model.GeoCache geoCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteGeoCache(geoCache);
    }

    public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return getService().dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery);
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
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
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
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery, projection);
    }

    public static com.liferay.events.global.mobile.model.GeoCache fetchGeoCache(
        long geoCacheId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchGeoCache(geoCacheId);
    }

    /**
    * Returns the geo cache with the primary key.
    *
    * @param geoCacheId the primary key of the geo cache
    * @return the geo cache
    * @throws PortalException if a geo cache with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.events.global.mobile.model.GeoCache getGeoCache(
        long geoCacheId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getGeoCache(geoCacheId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
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
    public static java.util.List<com.liferay.events.global.mobile.model.GeoCache> getGeoCaches(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getGeoCaches(start, end);
    }

    /**
    * Returns the number of geo caches.
    *
    * @return the number of geo caches
    * @throws SystemException if a system exception occurred
    */
    public static int getGeoCachesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getGeoCachesCount();
    }

    /**
    * Updates the geo cache in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param geoCache the geo cache
    * @return the geo cache that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.events.global.mobile.model.GeoCache updateGeoCache(
        com.liferay.events.global.mobile.model.GeoCache geoCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateGeoCache(geoCache);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public static java.lang.String getBeanIdentifier() {
        return getService().getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public static void setBeanIdentifier(java.lang.String beanIdentifier) {
        getService().setBeanIdentifier(beanIdentifier);
    }

    public static java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return getService().invokeMethod(name, parameterTypes, arguments);
    }

    public static com.liferay.events.global.mobile.model.GeoCache addGeoCache(
        java.lang.String addr, double lat, double lng)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addGeoCache(addr, lat, lng);
    }

    public static com.liferay.events.global.mobile.model.GeoCache findGeoCacheByAddress(
        java.lang.String addr)
        throws com.liferay.events.global.mobile.NoSuchGeoCacheException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().findGeoCacheByAddress(addr);
    }

    public static void clearService() {
        _service = null;
    }

    public static GeoCacheLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    GeoCacheLocalService.class.getName());

            if (invokableLocalService instanceof GeoCacheLocalService) {
                _service = (GeoCacheLocalService) invokableLocalService;
            } else {
                _service = new GeoCacheLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(GeoCacheLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(GeoCacheLocalService service) {
    }
}
