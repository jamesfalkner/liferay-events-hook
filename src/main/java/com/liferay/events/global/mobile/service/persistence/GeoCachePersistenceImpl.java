package com.liferay.events.global.mobile.service.persistence;

import com.liferay.events.global.mobile.NoSuchGeoCacheException;
import com.liferay.events.global.mobile.model.GeoCache;
import com.liferay.events.global.mobile.model.impl.GeoCacheImpl;
import com.liferay.events.global.mobile.model.impl.GeoCacheModelImpl;
import com.liferay.events.global.mobile.service.persistence.GeoCachePersistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the geo cache service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author James Falkner
 * @see GeoCachePersistence
 * @see GeoCacheUtil
 * @generated
 */
public class GeoCachePersistenceImpl extends BasePersistenceImpl<GeoCache>
    implements GeoCachePersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link GeoCacheUtil} to access the geo cache persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = GeoCacheImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(GeoCacheModelImpl.ENTITY_CACHE_ENABLED,
            GeoCacheModelImpl.FINDER_CACHE_ENABLED, GeoCacheImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(GeoCacheModelImpl.ENTITY_CACHE_ENABLED,
            GeoCacheModelImpl.FINDER_CACHE_ENABLED, GeoCacheImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(GeoCacheModelImpl.ENTITY_CACHE_ENABLED,
            GeoCacheModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_FETCH_BY_GEOBYADDRESS = new FinderPath(GeoCacheModelImpl.ENTITY_CACHE_ENABLED,
            GeoCacheModelImpl.FINDER_CACHE_ENABLED, GeoCacheImpl.class,
            FINDER_CLASS_NAME_ENTITY, "fetchByGeoByAddress",
            new String[] { String.class.getName() },
            GeoCacheModelImpl.ADDRESS_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_GEOBYADDRESS = new FinderPath(GeoCacheModelImpl.ENTITY_CACHE_ENABLED,
            GeoCacheModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGeoByAddress",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_GEOBYADDRESS_ADDRESS_1 = "geoCache.address IS NULL";
    private static final String _FINDER_COLUMN_GEOBYADDRESS_ADDRESS_2 = "geoCache.address = ?";
    private static final String _FINDER_COLUMN_GEOBYADDRESS_ADDRESS_3 = "(geoCache.address IS NULL OR geoCache.address = '')";
    private static final String _SQL_SELECT_GEOCACHE = "SELECT geoCache FROM GeoCache geoCache";
    private static final String _SQL_SELECT_GEOCACHE_WHERE = "SELECT geoCache FROM GeoCache geoCache WHERE ";
    private static final String _SQL_COUNT_GEOCACHE = "SELECT COUNT(geoCache) FROM GeoCache geoCache";
    private static final String _SQL_COUNT_GEOCACHE_WHERE = "SELECT COUNT(geoCache) FROM GeoCache geoCache WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "geoCache.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No GeoCache exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No GeoCache exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(GeoCachePersistenceImpl.class);
    private static GeoCache _nullGeoCache = new GeoCacheImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<GeoCache> toCacheModel() {
                return _nullGeoCacheCacheModel;
            }
        };

    private static CacheModel<GeoCache> _nullGeoCacheCacheModel = new CacheModel<GeoCache>() {
            @Override
            public GeoCache toEntityModel() {
                return _nullGeoCache;
            }
        };

    public GeoCachePersistenceImpl() {
        setModelClass(GeoCache.class);
    }

    /**
     * Returns the geo cache where address = &#63; or throws a {@link com.liferay.events.global.mobile.NoSuchGeoCacheException} if it could not be found.
     *
     * @param address the address
     * @return the matching geo cache
     * @throws com.liferay.events.global.mobile.NoSuchGeoCacheException if a matching geo cache could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public GeoCache findByGeoByAddress(String address)
        throws NoSuchGeoCacheException, SystemException {
        GeoCache geoCache = fetchByGeoByAddress(address);

        if (geoCache == null) {
            StringBundler msg = new StringBundler(4);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("address=");
            msg.append(address);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchGeoCacheException(msg.toString());
        }

        return geoCache;
    }

    /**
     * Returns the geo cache where address = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param address the address
     * @return the matching geo cache, or <code>null</code> if a matching geo cache could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public GeoCache fetchByGeoByAddress(String address)
        throws SystemException {
        return fetchByGeoByAddress(address, true);
    }

    /**
     * Returns the geo cache where address = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param address the address
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching geo cache, or <code>null</code> if a matching geo cache could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public GeoCache fetchByGeoByAddress(String address,
        boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { address };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_GEOBYADDRESS,
                    finderArgs, this);
        }

        if (result instanceof GeoCache) {
            GeoCache geoCache = (GeoCache) result;

            if (!Validator.equals(address, geoCache.getAddress())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_SELECT_GEOCACHE_WHERE);

            boolean bindAddress = false;

            if (address == null) {
                query.append(_FINDER_COLUMN_GEOBYADDRESS_ADDRESS_1);
            } else if (address.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_GEOBYADDRESS_ADDRESS_3);
            } else {
                bindAddress = true;

                query.append(_FINDER_COLUMN_GEOBYADDRESS_ADDRESS_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindAddress) {
                    qPos.add(address);
                }

                List<GeoCache> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GEOBYADDRESS,
                        finderArgs, list);
                } else {
                    if ((list.size() > 1) && _log.isWarnEnabled()) {
                        _log.warn(
                            "GeoCachePersistenceImpl.fetchByGeoByAddress(String, boolean) with parameters (" +
                            StringUtil.merge(finderArgs) +
                            ") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
                    }

                    GeoCache geoCache = list.get(0);

                    result = geoCache;

                    cacheResult(geoCache);

                    if ((geoCache.getAddress() == null) ||
                            !geoCache.getAddress().equals(address)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GEOBYADDRESS,
                            finderArgs, geoCache);
                    }
                }
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_GEOBYADDRESS,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        if (result instanceof List<?>) {
            return null;
        } else {
            return (GeoCache) result;
        }
    }

    /**
     * Removes the geo cache where address = &#63; from the database.
     *
     * @param address the address
     * @return the geo cache that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public GeoCache removeByGeoByAddress(String address)
        throws NoSuchGeoCacheException, SystemException {
        GeoCache geoCache = findByGeoByAddress(address);

        return remove(geoCache);
    }

    /**
     * Returns the number of geo caches where address = &#63;.
     *
     * @param address the address
     * @return the number of matching geo caches
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByGeoByAddress(String address) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_GEOBYADDRESS;

        Object[] finderArgs = new Object[] { address };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_GEOCACHE_WHERE);

            boolean bindAddress = false;

            if (address == null) {
                query.append(_FINDER_COLUMN_GEOBYADDRESS_ADDRESS_1);
            } else if (address.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_GEOBYADDRESS_ADDRESS_3);
            } else {
                bindAddress = true;

                query.append(_FINDER_COLUMN_GEOBYADDRESS_ADDRESS_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindAddress) {
                    qPos.add(address);
                }

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Caches the geo cache in the entity cache if it is enabled.
     *
     * @param geoCache the geo cache
     */
    @Override
    public void cacheResult(GeoCache geoCache) {
        EntityCacheUtil.putResult(GeoCacheModelImpl.ENTITY_CACHE_ENABLED,
            GeoCacheImpl.class, geoCache.getPrimaryKey(), geoCache);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GEOBYADDRESS,
            new Object[] { geoCache.getAddress() }, geoCache);

        geoCache.resetOriginalValues();
    }

    /**
     * Caches the geo caches in the entity cache if it is enabled.
     *
     * @param geoCaches the geo caches
     */
    @Override
    public void cacheResult(List<GeoCache> geoCaches) {
        for (GeoCache geoCache : geoCaches) {
            if (EntityCacheUtil.getResult(
                        GeoCacheModelImpl.ENTITY_CACHE_ENABLED,
                        GeoCacheImpl.class, geoCache.getPrimaryKey()) == null) {
                cacheResult(geoCache);
            } else {
                geoCache.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all geo caches.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(GeoCacheImpl.class.getName());
        }

        EntityCacheUtil.clearCache(GeoCacheImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the geo cache.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(GeoCache geoCache) {
        EntityCacheUtil.removeResult(GeoCacheModelImpl.ENTITY_CACHE_ENABLED,
            GeoCacheImpl.class, geoCache.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(geoCache);
    }

    @Override
    public void clearCache(List<GeoCache> geoCaches) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (GeoCache geoCache : geoCaches) {
            EntityCacheUtil.removeResult(GeoCacheModelImpl.ENTITY_CACHE_ENABLED,
                GeoCacheImpl.class, geoCache.getPrimaryKey());

            clearUniqueFindersCache(geoCache);
        }
    }

    protected void cacheUniqueFindersCache(GeoCache geoCache) {
        if (geoCache.isNew()) {
            Object[] args = new Object[] { geoCache.getAddress() };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GEOBYADDRESS, args,
                Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GEOBYADDRESS, args,
                geoCache);
        } else {
            GeoCacheModelImpl geoCacheModelImpl = (GeoCacheModelImpl) geoCache;

            if ((geoCacheModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_GEOBYADDRESS.getColumnBitmask()) != 0) {
                Object[] args = new Object[] { geoCache.getAddress() };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_GEOBYADDRESS,
                    args, Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_GEOBYADDRESS,
                    args, geoCache);
            }
        }
    }

    protected void clearUniqueFindersCache(GeoCache geoCache) {
        GeoCacheModelImpl geoCacheModelImpl = (GeoCacheModelImpl) geoCache;

        Object[] args = new Object[] { geoCache.getAddress() };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GEOBYADDRESS, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_GEOBYADDRESS, args);

        if ((geoCacheModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_GEOBYADDRESS.getColumnBitmask()) != 0) {
            args = new Object[] { geoCacheModelImpl.getOriginalAddress() };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GEOBYADDRESS, args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_GEOBYADDRESS, args);
        }
    }

    /**
     * Creates a new geo cache with the primary key. Does not add the geo cache to the database.
     *
     * @param geoCacheId the primary key for the new geo cache
     * @return the new geo cache
     */
    @Override
    public GeoCache create(long geoCacheId) {
        GeoCache geoCache = new GeoCacheImpl();

        geoCache.setNew(true);
        geoCache.setPrimaryKey(geoCacheId);

        return geoCache;
    }

    /**
     * Removes the geo cache with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param geoCacheId the primary key of the geo cache
     * @return the geo cache that was removed
     * @throws com.liferay.events.global.mobile.NoSuchGeoCacheException if a geo cache with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public GeoCache remove(long geoCacheId)
        throws NoSuchGeoCacheException, SystemException {
        return remove((Serializable) geoCacheId);
    }

    /**
     * Removes the geo cache with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the geo cache
     * @return the geo cache that was removed
     * @throws com.liferay.events.global.mobile.NoSuchGeoCacheException if a geo cache with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public GeoCache remove(Serializable primaryKey)
        throws NoSuchGeoCacheException, SystemException {
        Session session = null;

        try {
            session = openSession();

            GeoCache geoCache = (GeoCache) session.get(GeoCacheImpl.class,
                    primaryKey);

            if (geoCache == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchGeoCacheException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(geoCache);
        } catch (NoSuchGeoCacheException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected GeoCache removeImpl(GeoCache geoCache) throws SystemException {
        geoCache = toUnwrappedModel(geoCache);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(geoCache)) {
                geoCache = (GeoCache) session.get(GeoCacheImpl.class,
                        geoCache.getPrimaryKeyObj());
            }

            if (geoCache != null) {
                session.delete(geoCache);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (geoCache != null) {
            clearCache(geoCache);
        }

        return geoCache;
    }

    @Override
    public GeoCache updateImpl(
        com.liferay.events.global.mobile.model.GeoCache geoCache)
        throws SystemException {
        geoCache = toUnwrappedModel(geoCache);

        boolean isNew = geoCache.isNew();

        Session session = null;

        try {
            session = openSession();

            if (geoCache.isNew()) {
                session.save(geoCache);

                geoCache.setNew(false);
            } else {
                session.merge(geoCache);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !GeoCacheModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }

        EntityCacheUtil.putResult(GeoCacheModelImpl.ENTITY_CACHE_ENABLED,
            GeoCacheImpl.class, geoCache.getPrimaryKey(), geoCache);

        clearUniqueFindersCache(geoCache);
        cacheUniqueFindersCache(geoCache);

        return geoCache;
    }

    protected GeoCache toUnwrappedModel(GeoCache geoCache) {
        if (geoCache instanceof GeoCacheImpl) {
            return geoCache;
        }

        GeoCacheImpl geoCacheImpl = new GeoCacheImpl();

        geoCacheImpl.setNew(geoCache.isNew());
        geoCacheImpl.setPrimaryKey(geoCache.getPrimaryKey());

        geoCacheImpl.setAddress(geoCache.getAddress());
        geoCacheImpl.setLat(geoCache.getLat());
        geoCacheImpl.setLng(geoCache.getLng());
        geoCacheImpl.setGeoCacheId(geoCache.getGeoCacheId());
        geoCacheImpl.setCreateDate(geoCache.getCreateDate());

        return geoCacheImpl;
    }

    /**
     * Returns the geo cache with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the geo cache
     * @return the geo cache
     * @throws com.liferay.events.global.mobile.NoSuchGeoCacheException if a geo cache with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public GeoCache findByPrimaryKey(Serializable primaryKey)
        throws NoSuchGeoCacheException, SystemException {
        GeoCache geoCache = fetchByPrimaryKey(primaryKey);

        if (geoCache == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchGeoCacheException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return geoCache;
    }

    /**
     * Returns the geo cache with the primary key or throws a {@link com.liferay.events.global.mobile.NoSuchGeoCacheException} if it could not be found.
     *
     * @param geoCacheId the primary key of the geo cache
     * @return the geo cache
     * @throws com.liferay.events.global.mobile.NoSuchGeoCacheException if a geo cache with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public GeoCache findByPrimaryKey(long geoCacheId)
        throws NoSuchGeoCacheException, SystemException {
        return findByPrimaryKey((Serializable) geoCacheId);
    }

    /**
     * Returns the geo cache with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the geo cache
     * @return the geo cache, or <code>null</code> if a geo cache with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public GeoCache fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        GeoCache geoCache = (GeoCache) EntityCacheUtil.getResult(GeoCacheModelImpl.ENTITY_CACHE_ENABLED,
                GeoCacheImpl.class, primaryKey);

        if (geoCache == _nullGeoCache) {
            return null;
        }

        if (geoCache == null) {
            Session session = null;

            try {
                session = openSession();

                geoCache = (GeoCache) session.get(GeoCacheImpl.class, primaryKey);

                if (geoCache != null) {
                    cacheResult(geoCache);
                } else {
                    EntityCacheUtil.putResult(GeoCacheModelImpl.ENTITY_CACHE_ENABLED,
                        GeoCacheImpl.class, primaryKey, _nullGeoCache);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(GeoCacheModelImpl.ENTITY_CACHE_ENABLED,
                    GeoCacheImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return geoCache;
    }

    /**
     * Returns the geo cache with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param geoCacheId the primary key of the geo cache
     * @return the geo cache, or <code>null</code> if a geo cache with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public GeoCache fetchByPrimaryKey(long geoCacheId)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) geoCacheId);
    }

    /**
     * Returns all the geo caches.
     *
     * @return the geo caches
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<GeoCache> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    public List<GeoCache> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
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
    @Override
    public List<GeoCache> findAll(int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
            finderArgs = FINDER_ARGS_EMPTY;
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
            finderArgs = new Object[] { start, end, orderByComparator };
        }

        List<GeoCache> list = (List<GeoCache>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_GEOCACHE);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_GEOCACHE;

                if (pagination) {
                    sql = sql.concat(GeoCacheModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<GeoCache>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<GeoCache>(list);
                } else {
                    list = (List<GeoCache>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes all the geo caches from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (GeoCache geoCache : findAll()) {
            remove(geoCache);
        }
    }

    /**
     * Returns the number of geo caches.
     *
     * @return the number of geo caches
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_GEOCACHE);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Initializes the geo cache persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.liferay.events.global.mobile.model.GeoCache")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<GeoCache>> listenersList = new ArrayList<ModelListener<GeoCache>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<GeoCache>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(GeoCacheImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
