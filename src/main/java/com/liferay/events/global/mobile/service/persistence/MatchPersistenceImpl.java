package com.liferay.events.global.mobile.service.persistence;

import com.liferay.events.global.mobile.NoSuchMatchException;
import com.liferay.events.global.mobile.model.Match;
import com.liferay.events.global.mobile.model.impl.MatchImpl;
import com.liferay.events.global.mobile.model.impl.MatchModelImpl;
import com.liferay.events.global.mobile.service.persistence.MatchPersistence;

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
 * The persistence implementation for the match service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author James Falkner
 * @see MatchPersistence
 * @see MatchUtil
 * @generated
 */
public class MatchPersistenceImpl extends BasePersistenceImpl<Match>
    implements MatchPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link MatchUtil} to access the match persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = MatchImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(MatchModelImpl.ENTITY_CACHE_ENABLED,
            MatchModelImpl.FINDER_CACHE_ENABLED, MatchImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(MatchModelImpl.ENTITY_CACHE_ENABLED,
            MatchModelImpl.FINDER_CACHE_ENABLED, MatchImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MatchModelImpl.ENTITY_CACHE_ENABLED,
            MatchModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ID1_E = new FinderPath(MatchModelImpl.ENTITY_CACHE_ENABLED,
            MatchModelImpl.FINDER_CACHE_ENABLED, MatchImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByID1_E",
            new String[] {
                String.class.getName(), Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ID1_E = new FinderPath(MatchModelImpl.ENTITY_CACHE_ENABLED,
            MatchModelImpl.FINDER_CACHE_ENABLED, MatchImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByID1_E",
            new String[] { String.class.getName(), Long.class.getName() },
            MatchModelImpl.EVENTID_COLUMN_BITMASK |
            MatchModelImpl.CONTACTID1_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_ID1_E = new FinderPath(MatchModelImpl.ENTITY_CACHE_ENABLED,
            MatchModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByID1_E",
            new String[] { String.class.getName(), Long.class.getName() });
    private static final String _FINDER_COLUMN_ID1_E_EVENTID_1 = "match.eventId IS NULL AND ";
    private static final String _FINDER_COLUMN_ID1_E_EVENTID_2 = "match.eventId = ? AND ";
    private static final String _FINDER_COLUMN_ID1_E_EVENTID_3 = "(match.eventId IS NULL OR match.eventId = '') AND ";
    private static final String _FINDER_COLUMN_ID1_E_CONTACTID1_2 = "match.contactId1 = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ID2_E = new FinderPath(MatchModelImpl.ENTITY_CACHE_ENABLED,
            MatchModelImpl.FINDER_CACHE_ENABLED, MatchImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByID2_E",
            new String[] {
                String.class.getName(), Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ID2_E = new FinderPath(MatchModelImpl.ENTITY_CACHE_ENABLED,
            MatchModelImpl.FINDER_CACHE_ENABLED, MatchImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByID2_E",
            new String[] { String.class.getName(), Long.class.getName() },
            MatchModelImpl.EVENTID_COLUMN_BITMASK |
            MatchModelImpl.CONTACTID2_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_ID2_E = new FinderPath(MatchModelImpl.ENTITY_CACHE_ENABLED,
            MatchModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByID2_E",
            new String[] { String.class.getName(), Long.class.getName() });
    private static final String _FINDER_COLUMN_ID2_E_EVENTID_1 = "match.eventId IS NULL AND ";
    private static final String _FINDER_COLUMN_ID2_E_EVENTID_2 = "match.eventId = ? AND ";
    private static final String _FINDER_COLUMN_ID2_E_EVENTID_3 = "(match.eventId IS NULL OR match.eventId = '') AND ";
    private static final String _FINDER_COLUMN_ID2_E_CONTACTID2_2 = "match.contactId2 = ?";
    private static final String _SQL_SELECT_MATCH = "SELECT match FROM Match match";
    private static final String _SQL_SELECT_MATCH_WHERE = "SELECT match FROM Match match WHERE ";
    private static final String _SQL_COUNT_MATCH = "SELECT COUNT(match) FROM Match match";
    private static final String _SQL_COUNT_MATCH_WHERE = "SELECT COUNT(match) FROM Match match WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "match.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Match exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Match exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(MatchPersistenceImpl.class);
    private static Match _nullMatch = new MatchImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Match> toCacheModel() {
                return _nullMatchCacheModel;
            }
        };

    private static CacheModel<Match> _nullMatchCacheModel = new CacheModel<Match>() {
            @Override
            public Match toEntityModel() {
                return _nullMatch;
            }
        };

    public MatchPersistenceImpl() {
        setModelClass(Match.class);
    }

    /**
     * Returns all the matchs where eventId = &#63; and contactId1 = &#63;.
     *
     * @param eventId the event ID
     * @param contactId1 the contact id1
     * @return the matching matchs
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Match> findByID1_E(String eventId, long contactId1)
        throws SystemException {
        return findByID1_E(eventId, contactId1, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the matchs where eventId = &#63; and contactId1 = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.events.global.mobile.model.impl.MatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param eventId the event ID
     * @param contactId1 the contact id1
     * @param start the lower bound of the range of matchs
     * @param end the upper bound of the range of matchs (not inclusive)
     * @return the range of matching matchs
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Match> findByID1_E(String eventId, long contactId1, int start,
        int end) throws SystemException {
        return findByID1_E(eventId, contactId1, start, end, null);
    }

    /**
     * Returns an ordered range of all the matchs where eventId = &#63; and contactId1 = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.events.global.mobile.model.impl.MatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param eventId the event ID
     * @param contactId1 the contact id1
     * @param start the lower bound of the range of matchs
     * @param end the upper bound of the range of matchs (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching matchs
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Match> findByID1_E(String eventId, long contactId1, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ID1_E;
            finderArgs = new Object[] { eventId, contactId1 };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ID1_E;
            finderArgs = new Object[] {
                    eventId, contactId1,
                    
                    start, end, orderByComparator
                };
        }

        List<Match> list = (List<Match>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Match match : list) {
                if (!Validator.equals(eventId, match.getEventId()) ||
                        (contactId1 != match.getContactId1())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(4 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(4);
            }

            query.append(_SQL_SELECT_MATCH_WHERE);

            boolean bindEventId = false;

            if (eventId == null) {
                query.append(_FINDER_COLUMN_ID1_E_EVENTID_1);
            } else if (eventId.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_ID1_E_EVENTID_3);
            } else {
                bindEventId = true;

                query.append(_FINDER_COLUMN_ID1_E_EVENTID_2);
            }

            query.append(_FINDER_COLUMN_ID1_E_CONTACTID1_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(MatchModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindEventId) {
                    qPos.add(eventId);
                }

                qPos.add(contactId1);

                if (!pagination) {
                    list = (List<Match>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Match>(list);
                } else {
                    list = (List<Match>) QueryUtil.list(q, getDialect(), start,
                            end);
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
     * Returns the first match in the ordered set where eventId = &#63; and contactId1 = &#63;.
     *
     * @param eventId the event ID
     * @param contactId1 the contact id1
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching match
     * @throws com.liferay.events.global.mobile.NoSuchMatchException if a matching match could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Match findByID1_E_First(String eventId, long contactId1,
        OrderByComparator orderByComparator)
        throws NoSuchMatchException, SystemException {
        Match match = fetchByID1_E_First(eventId, contactId1, orderByComparator);

        if (match != null) {
            return match;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("eventId=");
        msg.append(eventId);

        msg.append(", contactId1=");
        msg.append(contactId1);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchMatchException(msg.toString());
    }

    /**
     * Returns the first match in the ordered set where eventId = &#63; and contactId1 = &#63;.
     *
     * @param eventId the event ID
     * @param contactId1 the contact id1
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching match, or <code>null</code> if a matching match could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Match fetchByID1_E_First(String eventId, long contactId1,
        OrderByComparator orderByComparator) throws SystemException {
        List<Match> list = findByID1_E(eventId, contactId1, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last match in the ordered set where eventId = &#63; and contactId1 = &#63;.
     *
     * @param eventId the event ID
     * @param contactId1 the contact id1
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching match
     * @throws com.liferay.events.global.mobile.NoSuchMatchException if a matching match could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Match findByID1_E_Last(String eventId, long contactId1,
        OrderByComparator orderByComparator)
        throws NoSuchMatchException, SystemException {
        Match match = fetchByID1_E_Last(eventId, contactId1, orderByComparator);

        if (match != null) {
            return match;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("eventId=");
        msg.append(eventId);

        msg.append(", contactId1=");
        msg.append(contactId1);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchMatchException(msg.toString());
    }

    /**
     * Returns the last match in the ordered set where eventId = &#63; and contactId1 = &#63;.
     *
     * @param eventId the event ID
     * @param contactId1 the contact id1
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching match, or <code>null</code> if a matching match could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Match fetchByID1_E_Last(String eventId, long contactId1,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByID1_E(eventId, contactId1);

        if (count == 0) {
            return null;
        }

        List<Match> list = findByID1_E(eventId, contactId1, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the matchs before and after the current match in the ordered set where eventId = &#63; and contactId1 = &#63;.
     *
     * @param matchId the primary key of the current match
     * @param eventId the event ID
     * @param contactId1 the contact id1
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next match
     * @throws com.liferay.events.global.mobile.NoSuchMatchException if a match with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Match[] findByID1_E_PrevAndNext(long matchId, String eventId,
        long contactId1, OrderByComparator orderByComparator)
        throws NoSuchMatchException, SystemException {
        Match match = findByPrimaryKey(matchId);

        Session session = null;

        try {
            session = openSession();

            Match[] array = new MatchImpl[3];

            array[0] = getByID1_E_PrevAndNext(session, match, eventId,
                    contactId1, orderByComparator, true);

            array[1] = match;

            array[2] = getByID1_E_PrevAndNext(session, match, eventId,
                    contactId1, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Match getByID1_E_PrevAndNext(Session session, Match match,
        String eventId, long contactId1, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_MATCH_WHERE);

        boolean bindEventId = false;

        if (eventId == null) {
            query.append(_FINDER_COLUMN_ID1_E_EVENTID_1);
        } else if (eventId.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_ID1_E_EVENTID_3);
        } else {
            bindEventId = true;

            query.append(_FINDER_COLUMN_ID1_E_EVENTID_2);
        }

        query.append(_FINDER_COLUMN_ID1_E_CONTACTID1_2);

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(MatchModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindEventId) {
            qPos.add(eventId);
        }

        qPos.add(contactId1);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(match);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Match> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the matchs where eventId = &#63; and contactId1 = &#63; from the database.
     *
     * @param eventId the event ID
     * @param contactId1 the contact id1
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByID1_E(String eventId, long contactId1)
        throws SystemException {
        for (Match match : findByID1_E(eventId, contactId1, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(match);
        }
    }

    /**
     * Returns the number of matchs where eventId = &#63; and contactId1 = &#63;.
     *
     * @param eventId the event ID
     * @param contactId1 the contact id1
     * @return the number of matching matchs
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByID1_E(String eventId, long contactId1)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_ID1_E;

        Object[] finderArgs = new Object[] { eventId, contactId1 };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_MATCH_WHERE);

            boolean bindEventId = false;

            if (eventId == null) {
                query.append(_FINDER_COLUMN_ID1_E_EVENTID_1);
            } else if (eventId.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_ID1_E_EVENTID_3);
            } else {
                bindEventId = true;

                query.append(_FINDER_COLUMN_ID1_E_EVENTID_2);
            }

            query.append(_FINDER_COLUMN_ID1_E_CONTACTID1_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindEventId) {
                    qPos.add(eventId);
                }

                qPos.add(contactId1);

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
     * Returns all the matchs where eventId = &#63; and contactId2 = &#63;.
     *
     * @param eventId the event ID
     * @param contactId2 the contact id2
     * @return the matching matchs
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Match> findByID2_E(String eventId, long contactId2)
        throws SystemException {
        return findByID2_E(eventId, contactId2, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the matchs where eventId = &#63; and contactId2 = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.events.global.mobile.model.impl.MatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param eventId the event ID
     * @param contactId2 the contact id2
     * @param start the lower bound of the range of matchs
     * @param end the upper bound of the range of matchs (not inclusive)
     * @return the range of matching matchs
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Match> findByID2_E(String eventId, long contactId2, int start,
        int end) throws SystemException {
        return findByID2_E(eventId, contactId2, start, end, null);
    }

    /**
     * Returns an ordered range of all the matchs where eventId = &#63; and contactId2 = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.events.global.mobile.model.impl.MatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param eventId the event ID
     * @param contactId2 the contact id2
     * @param start the lower bound of the range of matchs
     * @param end the upper bound of the range of matchs (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching matchs
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Match> findByID2_E(String eventId, long contactId2, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ID2_E;
            finderArgs = new Object[] { eventId, contactId2 };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ID2_E;
            finderArgs = new Object[] {
                    eventId, contactId2,
                    
                    start, end, orderByComparator
                };
        }

        List<Match> list = (List<Match>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Match match : list) {
                if (!Validator.equals(eventId, match.getEventId()) ||
                        (contactId2 != match.getContactId2())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(4 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(4);
            }

            query.append(_SQL_SELECT_MATCH_WHERE);

            boolean bindEventId = false;

            if (eventId == null) {
                query.append(_FINDER_COLUMN_ID2_E_EVENTID_1);
            } else if (eventId.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_ID2_E_EVENTID_3);
            } else {
                bindEventId = true;

                query.append(_FINDER_COLUMN_ID2_E_EVENTID_2);
            }

            query.append(_FINDER_COLUMN_ID2_E_CONTACTID2_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(MatchModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindEventId) {
                    qPos.add(eventId);
                }

                qPos.add(contactId2);

                if (!pagination) {
                    list = (List<Match>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Match>(list);
                } else {
                    list = (List<Match>) QueryUtil.list(q, getDialect(), start,
                            end);
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
     * Returns the first match in the ordered set where eventId = &#63; and contactId2 = &#63;.
     *
     * @param eventId the event ID
     * @param contactId2 the contact id2
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching match
     * @throws com.liferay.events.global.mobile.NoSuchMatchException if a matching match could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Match findByID2_E_First(String eventId, long contactId2,
        OrderByComparator orderByComparator)
        throws NoSuchMatchException, SystemException {
        Match match = fetchByID2_E_First(eventId, contactId2, orderByComparator);

        if (match != null) {
            return match;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("eventId=");
        msg.append(eventId);

        msg.append(", contactId2=");
        msg.append(contactId2);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchMatchException(msg.toString());
    }

    /**
     * Returns the first match in the ordered set where eventId = &#63; and contactId2 = &#63;.
     *
     * @param eventId the event ID
     * @param contactId2 the contact id2
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching match, or <code>null</code> if a matching match could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Match fetchByID2_E_First(String eventId, long contactId2,
        OrderByComparator orderByComparator) throws SystemException {
        List<Match> list = findByID2_E(eventId, contactId2, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last match in the ordered set where eventId = &#63; and contactId2 = &#63;.
     *
     * @param eventId the event ID
     * @param contactId2 the contact id2
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching match
     * @throws com.liferay.events.global.mobile.NoSuchMatchException if a matching match could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Match findByID2_E_Last(String eventId, long contactId2,
        OrderByComparator orderByComparator)
        throws NoSuchMatchException, SystemException {
        Match match = fetchByID2_E_Last(eventId, contactId2, orderByComparator);

        if (match != null) {
            return match;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("eventId=");
        msg.append(eventId);

        msg.append(", contactId2=");
        msg.append(contactId2);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchMatchException(msg.toString());
    }

    /**
     * Returns the last match in the ordered set where eventId = &#63; and contactId2 = &#63;.
     *
     * @param eventId the event ID
     * @param contactId2 the contact id2
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching match, or <code>null</code> if a matching match could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Match fetchByID2_E_Last(String eventId, long contactId2,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByID2_E(eventId, contactId2);

        if (count == 0) {
            return null;
        }

        List<Match> list = findByID2_E(eventId, contactId2, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the matchs before and after the current match in the ordered set where eventId = &#63; and contactId2 = &#63;.
     *
     * @param matchId the primary key of the current match
     * @param eventId the event ID
     * @param contactId2 the contact id2
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next match
     * @throws com.liferay.events.global.mobile.NoSuchMatchException if a match with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Match[] findByID2_E_PrevAndNext(long matchId, String eventId,
        long contactId2, OrderByComparator orderByComparator)
        throws NoSuchMatchException, SystemException {
        Match match = findByPrimaryKey(matchId);

        Session session = null;

        try {
            session = openSession();

            Match[] array = new MatchImpl[3];

            array[0] = getByID2_E_PrevAndNext(session, match, eventId,
                    contactId2, orderByComparator, true);

            array[1] = match;

            array[2] = getByID2_E_PrevAndNext(session, match, eventId,
                    contactId2, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Match getByID2_E_PrevAndNext(Session session, Match match,
        String eventId, long contactId2, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_MATCH_WHERE);

        boolean bindEventId = false;

        if (eventId == null) {
            query.append(_FINDER_COLUMN_ID2_E_EVENTID_1);
        } else if (eventId.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_ID2_E_EVENTID_3);
        } else {
            bindEventId = true;

            query.append(_FINDER_COLUMN_ID2_E_EVENTID_2);
        }

        query.append(_FINDER_COLUMN_ID2_E_CONTACTID2_2);

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(MatchModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindEventId) {
            qPos.add(eventId);
        }

        qPos.add(contactId2);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(match);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Match> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the matchs where eventId = &#63; and contactId2 = &#63; from the database.
     *
     * @param eventId the event ID
     * @param contactId2 the contact id2
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByID2_E(String eventId, long contactId2)
        throws SystemException {
        for (Match match : findByID2_E(eventId, contactId2, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(match);
        }
    }

    /**
     * Returns the number of matchs where eventId = &#63; and contactId2 = &#63;.
     *
     * @param eventId the event ID
     * @param contactId2 the contact id2
     * @return the number of matching matchs
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByID2_E(String eventId, long contactId2)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_ID2_E;

        Object[] finderArgs = new Object[] { eventId, contactId2 };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_MATCH_WHERE);

            boolean bindEventId = false;

            if (eventId == null) {
                query.append(_FINDER_COLUMN_ID2_E_EVENTID_1);
            } else if (eventId.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_ID2_E_EVENTID_3);
            } else {
                bindEventId = true;

                query.append(_FINDER_COLUMN_ID2_E_EVENTID_2);
            }

            query.append(_FINDER_COLUMN_ID2_E_CONTACTID2_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindEventId) {
                    qPos.add(eventId);
                }

                qPos.add(contactId2);

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
     * Caches the match in the entity cache if it is enabled.
     *
     * @param match the match
     */
    @Override
    public void cacheResult(Match match) {
        EntityCacheUtil.putResult(MatchModelImpl.ENTITY_CACHE_ENABLED,
            MatchImpl.class, match.getPrimaryKey(), match);

        match.resetOriginalValues();
    }

    /**
     * Caches the matchs in the entity cache if it is enabled.
     *
     * @param matchs the matchs
     */
    @Override
    public void cacheResult(List<Match> matchs) {
        for (Match match : matchs) {
            if (EntityCacheUtil.getResult(MatchModelImpl.ENTITY_CACHE_ENABLED,
                        MatchImpl.class, match.getPrimaryKey()) == null) {
                cacheResult(match);
            } else {
                match.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all matchs.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(MatchImpl.class.getName());
        }

        EntityCacheUtil.clearCache(MatchImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the match.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Match match) {
        EntityCacheUtil.removeResult(MatchModelImpl.ENTITY_CACHE_ENABLED,
            MatchImpl.class, match.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<Match> matchs) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Match match : matchs) {
            EntityCacheUtil.removeResult(MatchModelImpl.ENTITY_CACHE_ENABLED,
                MatchImpl.class, match.getPrimaryKey());
        }
    }

    /**
     * Creates a new match with the primary key. Does not add the match to the database.
     *
     * @param matchId the primary key for the new match
     * @return the new match
     */
    @Override
    public Match create(long matchId) {
        Match match = new MatchImpl();

        match.setNew(true);
        match.setPrimaryKey(matchId);

        return match;
    }

    /**
     * Removes the match with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param matchId the primary key of the match
     * @return the match that was removed
     * @throws com.liferay.events.global.mobile.NoSuchMatchException if a match with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Match remove(long matchId)
        throws NoSuchMatchException, SystemException {
        return remove((Serializable) matchId);
    }

    /**
     * Removes the match with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the match
     * @return the match that was removed
     * @throws com.liferay.events.global.mobile.NoSuchMatchException if a match with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Match remove(Serializable primaryKey)
        throws NoSuchMatchException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Match match = (Match) session.get(MatchImpl.class, primaryKey);

            if (match == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchMatchException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(match);
        } catch (NoSuchMatchException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Match removeImpl(Match match) throws SystemException {
        match = toUnwrappedModel(match);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(match)) {
                match = (Match) session.get(MatchImpl.class,
                        match.getPrimaryKeyObj());
            }

            if (match != null) {
                session.delete(match);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (match != null) {
            clearCache(match);
        }

        return match;
    }

    @Override
    public Match updateImpl(com.liferay.events.global.mobile.model.Match match)
        throws SystemException {
        match = toUnwrappedModel(match);

        boolean isNew = match.isNew();

        MatchModelImpl matchModelImpl = (MatchModelImpl) match;

        Session session = null;

        try {
            session = openSession();

            if (match.isNew()) {
                session.save(match);

                match.setNew(false);
            } else {
                session.merge(match);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !MatchModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((matchModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ID1_E.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        matchModelImpl.getOriginalEventId(),
                        matchModelImpl.getOriginalContactId1()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ID1_E, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ID1_E,
                    args);

                args = new Object[] {
                        matchModelImpl.getEventId(),
                        matchModelImpl.getContactId1()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ID1_E, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ID1_E,
                    args);
            }

            if ((matchModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ID2_E.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        matchModelImpl.getOriginalEventId(),
                        matchModelImpl.getOriginalContactId2()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ID2_E, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ID2_E,
                    args);

                args = new Object[] {
                        matchModelImpl.getEventId(),
                        matchModelImpl.getContactId2()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_ID2_E, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ID2_E,
                    args);
            }
        }

        EntityCacheUtil.putResult(MatchModelImpl.ENTITY_CACHE_ENABLED,
            MatchImpl.class, match.getPrimaryKey(), match);

        return match;
    }

    protected Match toUnwrappedModel(Match match) {
        if (match instanceof MatchImpl) {
            return match;
        }

        MatchImpl matchImpl = new MatchImpl();

        matchImpl.setNew(match.isNew());
        matchImpl.setPrimaryKey(match.getPrimaryKey());

        matchImpl.setContactId1(match.getContactId1());
        matchImpl.setContactId2(match.getContactId2());
        matchImpl.setEventId(match.getEventId());
        matchImpl.setMatchId(match.getMatchId());
        matchImpl.setGroupId(match.getGroupId());
        matchImpl.setCompanyId(match.getCompanyId());
        matchImpl.setUserId(match.getUserId());
        matchImpl.setUserName(match.getUserName());
        matchImpl.setCreateDate(match.getCreateDate());
        matchImpl.setModifiedDate(match.getModifiedDate());

        return matchImpl;
    }

    /**
     * Returns the match with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the match
     * @return the match
     * @throws com.liferay.events.global.mobile.NoSuchMatchException if a match with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Match findByPrimaryKey(Serializable primaryKey)
        throws NoSuchMatchException, SystemException {
        Match match = fetchByPrimaryKey(primaryKey);

        if (match == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchMatchException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return match;
    }

    /**
     * Returns the match with the primary key or throws a {@link com.liferay.events.global.mobile.NoSuchMatchException} if it could not be found.
     *
     * @param matchId the primary key of the match
     * @return the match
     * @throws com.liferay.events.global.mobile.NoSuchMatchException if a match with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Match findByPrimaryKey(long matchId)
        throws NoSuchMatchException, SystemException {
        return findByPrimaryKey((Serializable) matchId);
    }

    /**
     * Returns the match with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the match
     * @return the match, or <code>null</code> if a match with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Match fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Match match = (Match) EntityCacheUtil.getResult(MatchModelImpl.ENTITY_CACHE_ENABLED,
                MatchImpl.class, primaryKey);

        if (match == _nullMatch) {
            return null;
        }

        if (match == null) {
            Session session = null;

            try {
                session = openSession();

                match = (Match) session.get(MatchImpl.class, primaryKey);

                if (match != null) {
                    cacheResult(match);
                } else {
                    EntityCacheUtil.putResult(MatchModelImpl.ENTITY_CACHE_ENABLED,
                        MatchImpl.class, primaryKey, _nullMatch);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(MatchModelImpl.ENTITY_CACHE_ENABLED,
                    MatchImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return match;
    }

    /**
     * Returns the match with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param matchId the primary key of the match
     * @return the match, or <code>null</code> if a match with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Match fetchByPrimaryKey(long matchId) throws SystemException {
        return fetchByPrimaryKey((Serializable) matchId);
    }

    /**
     * Returns all the matchs.
     *
     * @return the matchs
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Match> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the matchs.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.events.global.mobile.model.impl.MatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of matchs
     * @param end the upper bound of the range of matchs (not inclusive)
     * @return the range of matchs
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Match> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the matchs.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.events.global.mobile.model.impl.MatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of matchs
     * @param end the upper bound of the range of matchs (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matchs
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Match> findAll(int start, int end,
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

        List<Match> list = (List<Match>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_MATCH);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_MATCH;

                if (pagination) {
                    sql = sql.concat(MatchModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Match>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Match>(list);
                } else {
                    list = (List<Match>) QueryUtil.list(q, getDialect(), start,
                            end);
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
     * Removes all the matchs from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Match match : findAll()) {
            remove(match);
        }
    }

    /**
     * Returns the number of matchs.
     *
     * @return the number of matchs
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

                Query q = session.createQuery(_SQL_COUNT_MATCH);

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
     * Initializes the match persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.liferay.events.global.mobile.model.Match")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Match>> listenersList = new ArrayList<ModelListener<Match>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Match>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(MatchImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
