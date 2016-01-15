package com.liferay.events.global.mobile.service.persistence;

import com.liferay.events.global.mobile.model.GeoCache;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the geo cache service. This utility wraps {@link GeoCachePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author James Falkner
 * @see GeoCachePersistence
 * @see GeoCachePersistenceImpl
 * @generated
 */
public class GeoCacheUtil {
    private static GeoCachePersistence _persistence;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
     */
    public static void clearCache() {
        getPersistence().clearCache();
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
     */
    public static void clearCache(GeoCache geoCache) {
        getPersistence().clearCache(geoCache);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<GeoCache> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<GeoCache> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<GeoCache> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static GeoCache update(GeoCache geoCache) throws SystemException {
        return getPersistence().update(geoCache);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static GeoCache update(GeoCache geoCache,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(geoCache, serviceContext);
    }

    /**
    * Returns the geo cache where address = &#63; or throws a {@link com.liferay.events.global.mobile.NoSuchGeoCacheException} if it could not be found.
    *
    * @param address the address
    * @return the matching geo cache
    * @throws com.liferay.events.global.mobile.NoSuchGeoCacheException if a matching geo cache could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.events.global.mobile.model.GeoCache findByGeoByAddress(
        java.lang.String address)
        throws com.liferay.events.global.mobile.NoSuchGeoCacheException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByGeoByAddress(address);
    }

    /**
    * Returns the geo cache where address = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param address the address
    * @return the matching geo cache, or <code>null</code> if a matching geo cache could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.events.global.mobile.model.GeoCache fetchByGeoByAddress(
        java.lang.String address)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByGeoByAddress(address);
    }

    /**
    * Returns the geo cache where address = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param address the address
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching geo cache, or <code>null</code> if a matching geo cache could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.events.global.mobile.model.GeoCache fetchByGeoByAddress(
        java.lang.String address, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByGeoByAddress(address, retrieveFromCache);
    }

    /**
    * Removes the geo cache where address = &#63; from the database.
    *
    * @param address the address
    * @return the geo cache that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.events.global.mobile.model.GeoCache removeByGeoByAddress(
        java.lang.String address)
        throws com.liferay.events.global.mobile.NoSuchGeoCacheException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().removeByGeoByAddress(address);
    }

    /**
    * Returns the number of geo caches where address = &#63;.
    *
    * @param address the address
    * @return the number of matching geo caches
    * @throws SystemException if a system exception occurred
    */
    public static int countByGeoByAddress(java.lang.String address)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByGeoByAddress(address);
    }

    /**
    * Caches the geo cache in the entity cache if it is enabled.
    *
    * @param geoCache the geo cache
    */
    public static void cacheResult(
        com.liferay.events.global.mobile.model.GeoCache geoCache) {
        getPersistence().cacheResult(geoCache);
    }

    /**
    * Caches the geo caches in the entity cache if it is enabled.
    *
    * @param geoCaches the geo caches
    */
    public static void cacheResult(
        java.util.List<com.liferay.events.global.mobile.model.GeoCache> geoCaches) {
        getPersistence().cacheResult(geoCaches);
    }

    /**
    * Creates a new geo cache with the primary key. Does not add the geo cache to the database.
    *
    * @param geoCacheId the primary key for the new geo cache
    * @return the new geo cache
    */
    public static com.liferay.events.global.mobile.model.GeoCache create(
        long geoCacheId) {
        return getPersistence().create(geoCacheId);
    }

    /**
    * Removes the geo cache with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param geoCacheId the primary key of the geo cache
    * @return the geo cache that was removed
    * @throws com.liferay.events.global.mobile.NoSuchGeoCacheException if a geo cache with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.events.global.mobile.model.GeoCache remove(
        long geoCacheId)
        throws com.liferay.events.global.mobile.NoSuchGeoCacheException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(geoCacheId);
    }

    public static com.liferay.events.global.mobile.model.GeoCache updateImpl(
        com.liferay.events.global.mobile.model.GeoCache geoCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(geoCache);
    }

    /**
    * Returns the geo cache with the primary key or throws a {@link com.liferay.events.global.mobile.NoSuchGeoCacheException} if it could not be found.
    *
    * @param geoCacheId the primary key of the geo cache
    * @return the geo cache
    * @throws com.liferay.events.global.mobile.NoSuchGeoCacheException if a geo cache with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.events.global.mobile.model.GeoCache findByPrimaryKey(
        long geoCacheId)
        throws com.liferay.events.global.mobile.NoSuchGeoCacheException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(geoCacheId);
    }

    /**
    * Returns the geo cache with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param geoCacheId the primary key of the geo cache
    * @return the geo cache, or <code>null</code> if a geo cache with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.events.global.mobile.model.GeoCache fetchByPrimaryKey(
        long geoCacheId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(geoCacheId);
    }

    /**
    * Returns all the geo caches.
    *
    * @return the geo caches
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.events.global.mobile.model.GeoCache> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<com.liferay.events.global.mobile.model.GeoCache> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the geo caches.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.events.global.mobile.model.impl.GeoCacheModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of geo caches
    * @param end the upper bound of the range of geo caches (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of geo caches
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.events.global.mobile.model.GeoCache> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the geo caches from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of geo caches.
    *
    * @return the number of geo caches
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static GeoCachePersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (GeoCachePersistence) PortletBeanLocatorUtil.locate(com.liferay.events.global.mobile.service.ClpSerializer.getServletContextName(),
                    GeoCachePersistence.class.getName());

            ReferenceRegistry.registerReference(GeoCacheUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(GeoCachePersistence persistence) {
    }
}
