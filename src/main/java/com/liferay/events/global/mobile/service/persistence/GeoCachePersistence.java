package com.liferay.events.global.mobile.service.persistence;

import com.liferay.events.global.mobile.model.GeoCache;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the geo cache service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author James Falkner
 * @see GeoCachePersistenceImpl
 * @see GeoCacheUtil
 * @generated
 */
public interface GeoCachePersistence extends BasePersistence<GeoCache> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link GeoCacheUtil} to access the geo cache persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns the geo cache where address = &#63; or throws a {@link com.liferay.events.global.mobile.NoSuchGeoCacheException} if it could not be found.
    *
    * @param address the address
    * @return the matching geo cache
    * @throws com.liferay.events.global.mobile.NoSuchGeoCacheException if a matching geo cache could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.events.global.mobile.model.GeoCache findByGeoByAddress(
        java.lang.String address)
        throws com.liferay.events.global.mobile.NoSuchGeoCacheException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the geo cache where address = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param address the address
    * @return the matching geo cache, or <code>null</code> if a matching geo cache could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.events.global.mobile.model.GeoCache fetchByGeoByAddress(
        java.lang.String address)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the geo cache where address = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param address the address
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching geo cache, or <code>null</code> if a matching geo cache could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.events.global.mobile.model.GeoCache fetchByGeoByAddress(
        java.lang.String address, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the geo cache where address = &#63; from the database.
    *
    * @param address the address
    * @return the geo cache that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.events.global.mobile.model.GeoCache removeByGeoByAddress(
        java.lang.String address)
        throws com.liferay.events.global.mobile.NoSuchGeoCacheException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of geo caches where address = &#63;.
    *
    * @param address the address
    * @return the number of matching geo caches
    * @throws SystemException if a system exception occurred
    */
    public int countByGeoByAddress(java.lang.String address)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the geo cache in the entity cache if it is enabled.
    *
    * @param geoCache the geo cache
    */
    public void cacheResult(
        com.liferay.events.global.mobile.model.GeoCache geoCache);

    /**
    * Caches the geo caches in the entity cache if it is enabled.
    *
    * @param geoCaches the geo caches
    */
    public void cacheResult(
        java.util.List<com.liferay.events.global.mobile.model.GeoCache> geoCaches);

    /**
    * Creates a new geo cache with the primary key. Does not add the geo cache to the database.
    *
    * @param geoCacheId the primary key for the new geo cache
    * @return the new geo cache
    */
    public com.liferay.events.global.mobile.model.GeoCache create(
        long geoCacheId);

    /**
    * Removes the geo cache with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param geoCacheId the primary key of the geo cache
    * @return the geo cache that was removed
    * @throws com.liferay.events.global.mobile.NoSuchGeoCacheException if a geo cache with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.events.global.mobile.model.GeoCache remove(
        long geoCacheId)
        throws com.liferay.events.global.mobile.NoSuchGeoCacheException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.liferay.events.global.mobile.model.GeoCache updateImpl(
        com.liferay.events.global.mobile.model.GeoCache geoCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the geo cache with the primary key or throws a {@link com.liferay.events.global.mobile.NoSuchGeoCacheException} if it could not be found.
    *
    * @param geoCacheId the primary key of the geo cache
    * @return the geo cache
    * @throws com.liferay.events.global.mobile.NoSuchGeoCacheException if a geo cache with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.events.global.mobile.model.GeoCache findByPrimaryKey(
        long geoCacheId)
        throws com.liferay.events.global.mobile.NoSuchGeoCacheException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the geo cache with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param geoCacheId the primary key of the geo cache
    * @return the geo cache, or <code>null</code> if a geo cache with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.events.global.mobile.model.GeoCache fetchByPrimaryKey(
        long geoCacheId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the geo caches.
    *
    * @return the geo caches
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.liferay.events.global.mobile.model.GeoCache> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.liferay.events.global.mobile.model.GeoCache> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.liferay.events.global.mobile.model.GeoCache> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the geo caches from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of geo caches.
    *
    * @return the number of geo caches
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
