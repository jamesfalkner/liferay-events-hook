package com.liferay.events.global.mobile.service.persistence;

import com.liferay.events.global.mobile.NoSuchEventPollAnswerException;
import com.liferay.events.global.mobile.model.EventPollAnswer;
import com.liferay.events.global.mobile.model.impl.EventPollAnswerImpl;
import com.liferay.events.global.mobile.model.impl.EventPollAnswerModelImpl;
import com.liferay.events.global.mobile.service.persistence.EventPollAnswerPersistence;

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
 * The persistence implementation for the event poll answer service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author James Falkner
 * @see EventPollAnswerPersistence
 * @see EventPollAnswerUtil
 * @generated
 */
public class EventPollAnswerPersistenceImpl extends BasePersistenceImpl<EventPollAnswer>
    implements EventPollAnswerPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link EventPollAnswerUtil} to access the event poll answer persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = EventPollAnswerImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EventPollAnswerModelImpl.ENTITY_CACHE_ENABLED,
            EventPollAnswerModelImpl.FINDER_CACHE_ENABLED,
            EventPollAnswerImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EventPollAnswerModelImpl.ENTITY_CACHE_ENABLED,
            EventPollAnswerModelImpl.FINDER_CACHE_ENABLED,
            EventPollAnswerImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EventPollAnswerModelImpl.ENTITY_CACHE_ENABLED,
            EventPollAnswerModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EVENTPOLLANSWER_Q =
        new FinderPath(EventPollAnswerModelImpl.ENTITY_CACHE_ENABLED,
            EventPollAnswerModelImpl.FINDER_CACHE_ENABLED,
            EventPollAnswerImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByEventPollAnswer_Q",
            new String[] {
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTPOLLANSWER_Q =
        new FinderPath(EventPollAnswerModelImpl.ENTITY_CACHE_ENABLED,
            EventPollAnswerModelImpl.FINDER_CACHE_ENABLED,
            EventPollAnswerImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findByEventPollAnswer_Q", new String[] { Long.class.getName() },
            EventPollAnswerModelImpl.QUESTIONID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_EVENTPOLLANSWER_Q = new FinderPath(EventPollAnswerModelImpl.ENTITY_CACHE_ENABLED,
            EventPollAnswerModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByEventPollAnswer_Q", new String[] { Long.class.getName() });
    private static final String _FINDER_COLUMN_EVENTPOLLANSWER_Q_QUESTIONID_2 = "eventPollAnswer.questionId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EVENTPOLLANSWER_Q_C =
        new FinderPath(EventPollAnswerModelImpl.ENTITY_CACHE_ENABLED,
            EventPollAnswerModelImpl.FINDER_CACHE_ENABLED,
            EventPollAnswerImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByEventPollAnswer_Q_C",
            new String[] {
                Long.class.getName(), String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTPOLLANSWER_Q_C =
        new FinderPath(EventPollAnswerModelImpl.ENTITY_CACHE_ENABLED,
            EventPollAnswerModelImpl.FINDER_CACHE_ENABLED,
            EventPollAnswerImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findByEventPollAnswer_Q_C",
            new String[] { Long.class.getName(), String.class.getName() },
            EventPollAnswerModelImpl.QUESTIONID_COLUMN_BITMASK |
            EventPollAnswerModelImpl.CLIENTID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_EVENTPOLLANSWER_Q_C = new FinderPath(EventPollAnswerModelImpl.ENTITY_CACHE_ENABLED,
            EventPollAnswerModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByEventPollAnswer_Q_C",
            new String[] { Long.class.getName(), String.class.getName() });
    private static final String _FINDER_COLUMN_EVENTPOLLANSWER_Q_C_QUESTIONID_2 = "eventPollAnswer.questionId = ? AND ";
    private static final String _FINDER_COLUMN_EVENTPOLLANSWER_Q_C_CLIENTID_1 = "eventPollAnswer.clientId IS NULL";
    private static final String _FINDER_COLUMN_EVENTPOLLANSWER_Q_C_CLIENTID_2 = "eventPollAnswer.clientId = ?";
    private static final String _FINDER_COLUMN_EVENTPOLLANSWER_Q_C_CLIENTID_3 = "(eventPollAnswer.clientId IS NULL OR eventPollAnswer.clientId = '')";
    private static final String _SQL_SELECT_EVENTPOLLANSWER = "SELECT eventPollAnswer FROM EventPollAnswer eventPollAnswer";
    private static final String _SQL_SELECT_EVENTPOLLANSWER_WHERE = "SELECT eventPollAnswer FROM EventPollAnswer eventPollAnswer WHERE ";
    private static final String _SQL_COUNT_EVENTPOLLANSWER = "SELECT COUNT(eventPollAnswer) FROM EventPollAnswer eventPollAnswer";
    private static final String _SQL_COUNT_EVENTPOLLANSWER_WHERE = "SELECT COUNT(eventPollAnswer) FROM EventPollAnswer eventPollAnswer WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "eventPollAnswer.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No EventPollAnswer exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No EventPollAnswer exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(EventPollAnswerPersistenceImpl.class);
    private static EventPollAnswer _nullEventPollAnswer = new EventPollAnswerImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<EventPollAnswer> toCacheModel() {
                return _nullEventPollAnswerCacheModel;
            }
        };

    private static CacheModel<EventPollAnswer> _nullEventPollAnswerCacheModel = new CacheModel<EventPollAnswer>() {
            @Override
            public EventPollAnswer toEntityModel() {
                return _nullEventPollAnswer;
            }
        };

    public EventPollAnswerPersistenceImpl() {
        setModelClass(EventPollAnswer.class);
    }

    /**
     * Returns all the event poll answers where questionId = &#63;.
     *
     * @param questionId the question ID
     * @return the matching event poll answers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<EventPollAnswer> findByEventPollAnswer_Q(long questionId)
        throws SystemException {
        return findByEventPollAnswer_Q(questionId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the event poll answers where questionId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.events.global.mobile.model.impl.EventPollAnswerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param questionId the question ID
     * @param start the lower bound of the range of event poll answers
     * @param end the upper bound of the range of event poll answers (not inclusive)
     * @return the range of matching event poll answers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<EventPollAnswer> findByEventPollAnswer_Q(long questionId,
        int start, int end) throws SystemException {
        return findByEventPollAnswer_Q(questionId, start, end, null);
    }

    /**
     * Returns an ordered range of all the event poll answers where questionId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.events.global.mobile.model.impl.EventPollAnswerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param questionId the question ID
     * @param start the lower bound of the range of event poll answers
     * @param end the upper bound of the range of event poll answers (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching event poll answers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<EventPollAnswer> findByEventPollAnswer_Q(long questionId,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTPOLLANSWER_Q;
            finderArgs = new Object[] { questionId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EVENTPOLLANSWER_Q;
            finderArgs = new Object[] { questionId, start, end, orderByComparator };
        }

        List<EventPollAnswer> list = (List<EventPollAnswer>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (EventPollAnswer eventPollAnswer : list) {
                if ((questionId != eventPollAnswer.getQuestionId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(3);
            }

            query.append(_SQL_SELECT_EVENTPOLLANSWER_WHERE);

            query.append(_FINDER_COLUMN_EVENTPOLLANSWER_Q_QUESTIONID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(EventPollAnswerModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(questionId);

                if (!pagination) {
                    list = (List<EventPollAnswer>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<EventPollAnswer>(list);
                } else {
                    list = (List<EventPollAnswer>) QueryUtil.list(q,
                            getDialect(), start, end);
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
     * Returns the first event poll answer in the ordered set where questionId = &#63;.
     *
     * @param questionId the question ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching event poll answer
     * @throws com.liferay.events.global.mobile.NoSuchEventPollAnswerException if a matching event poll answer could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EventPollAnswer findByEventPollAnswer_Q_First(long questionId,
        OrderByComparator orderByComparator)
        throws NoSuchEventPollAnswerException, SystemException {
        EventPollAnswer eventPollAnswer = fetchByEventPollAnswer_Q_First(questionId,
                orderByComparator);

        if (eventPollAnswer != null) {
            return eventPollAnswer;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("questionId=");
        msg.append(questionId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchEventPollAnswerException(msg.toString());
    }

    /**
     * Returns the first event poll answer in the ordered set where questionId = &#63;.
     *
     * @param questionId the question ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching event poll answer, or <code>null</code> if a matching event poll answer could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EventPollAnswer fetchByEventPollAnswer_Q_First(long questionId,
        OrderByComparator orderByComparator) throws SystemException {
        List<EventPollAnswer> list = findByEventPollAnswer_Q(questionId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last event poll answer in the ordered set where questionId = &#63;.
     *
     * @param questionId the question ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching event poll answer
     * @throws com.liferay.events.global.mobile.NoSuchEventPollAnswerException if a matching event poll answer could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EventPollAnswer findByEventPollAnswer_Q_Last(long questionId,
        OrderByComparator orderByComparator)
        throws NoSuchEventPollAnswerException, SystemException {
        EventPollAnswer eventPollAnswer = fetchByEventPollAnswer_Q_Last(questionId,
                orderByComparator);

        if (eventPollAnswer != null) {
            return eventPollAnswer;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("questionId=");
        msg.append(questionId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchEventPollAnswerException(msg.toString());
    }

    /**
     * Returns the last event poll answer in the ordered set where questionId = &#63;.
     *
     * @param questionId the question ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching event poll answer, or <code>null</code> if a matching event poll answer could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EventPollAnswer fetchByEventPollAnswer_Q_Last(long questionId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByEventPollAnswer_Q(questionId);

        if (count == 0) {
            return null;
        }

        List<EventPollAnswer> list = findByEventPollAnswer_Q(questionId,
                count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the event poll answers before and after the current event poll answer in the ordered set where questionId = &#63;.
     *
     * @param answerId the primary key of the current event poll answer
     * @param questionId the question ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next event poll answer
     * @throws com.liferay.events.global.mobile.NoSuchEventPollAnswerException if a event poll answer with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EventPollAnswer[] findByEventPollAnswer_Q_PrevAndNext(
        long answerId, long questionId, OrderByComparator orderByComparator)
        throws NoSuchEventPollAnswerException, SystemException {
        EventPollAnswer eventPollAnswer = findByPrimaryKey(answerId);

        Session session = null;

        try {
            session = openSession();

            EventPollAnswer[] array = new EventPollAnswerImpl[3];

            array[0] = getByEventPollAnswer_Q_PrevAndNext(session,
                    eventPollAnswer, questionId, orderByComparator, true);

            array[1] = eventPollAnswer;

            array[2] = getByEventPollAnswer_Q_PrevAndNext(session,
                    eventPollAnswer, questionId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected EventPollAnswer getByEventPollAnswer_Q_PrevAndNext(
        Session session, EventPollAnswer eventPollAnswer, long questionId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_EVENTPOLLANSWER_WHERE);

        query.append(_FINDER_COLUMN_EVENTPOLLANSWER_Q_QUESTIONID_2);

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
            query.append(EventPollAnswerModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(questionId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(eventPollAnswer);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<EventPollAnswer> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the event poll answers where questionId = &#63; from the database.
     *
     * @param questionId the question ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByEventPollAnswer_Q(long questionId)
        throws SystemException {
        for (EventPollAnswer eventPollAnswer : findByEventPollAnswer_Q(
                questionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(eventPollAnswer);
        }
    }

    /**
     * Returns the number of event poll answers where questionId = &#63;.
     *
     * @param questionId the question ID
     * @return the number of matching event poll answers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByEventPollAnswer_Q(long questionId)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_EVENTPOLLANSWER_Q;

        Object[] finderArgs = new Object[] { questionId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_EVENTPOLLANSWER_WHERE);

            query.append(_FINDER_COLUMN_EVENTPOLLANSWER_Q_QUESTIONID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(questionId);

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
     * Returns all the event poll answers where questionId = &#63; and clientId = &#63;.
     *
     * @param questionId the question ID
     * @param clientId the client ID
     * @return the matching event poll answers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<EventPollAnswer> findByEventPollAnswer_Q_C(long questionId,
        String clientId) throws SystemException {
        return findByEventPollAnswer_Q_C(questionId, clientId,
            QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the event poll answers where questionId = &#63; and clientId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.events.global.mobile.model.impl.EventPollAnswerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param questionId the question ID
     * @param clientId the client ID
     * @param start the lower bound of the range of event poll answers
     * @param end the upper bound of the range of event poll answers (not inclusive)
     * @return the range of matching event poll answers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<EventPollAnswer> findByEventPollAnswer_Q_C(long questionId,
        String clientId, int start, int end) throws SystemException {
        return findByEventPollAnswer_Q_C(questionId, clientId, start, end, null);
    }

    /**
     * Returns an ordered range of all the event poll answers where questionId = &#63; and clientId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.events.global.mobile.model.impl.EventPollAnswerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param questionId the question ID
     * @param clientId the client ID
     * @param start the lower bound of the range of event poll answers
     * @param end the upper bound of the range of event poll answers (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching event poll answers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<EventPollAnswer> findByEventPollAnswer_Q_C(long questionId,
        String clientId, int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTPOLLANSWER_Q_C;
            finderArgs = new Object[] { questionId, clientId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EVENTPOLLANSWER_Q_C;
            finderArgs = new Object[] {
                    questionId, clientId,
                    
                    start, end, orderByComparator
                };
        }

        List<EventPollAnswer> list = (List<EventPollAnswer>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (EventPollAnswer eventPollAnswer : list) {
                if ((questionId != eventPollAnswer.getQuestionId()) ||
                        !Validator.equals(clientId,
                            eventPollAnswer.getClientId())) {
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

            query.append(_SQL_SELECT_EVENTPOLLANSWER_WHERE);

            query.append(_FINDER_COLUMN_EVENTPOLLANSWER_Q_C_QUESTIONID_2);

            boolean bindClientId = false;

            if (clientId == null) {
                query.append(_FINDER_COLUMN_EVENTPOLLANSWER_Q_C_CLIENTID_1);
            } else if (clientId.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_EVENTPOLLANSWER_Q_C_CLIENTID_3);
            } else {
                bindClientId = true;

                query.append(_FINDER_COLUMN_EVENTPOLLANSWER_Q_C_CLIENTID_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(EventPollAnswerModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(questionId);

                if (bindClientId) {
                    qPos.add(clientId);
                }

                if (!pagination) {
                    list = (List<EventPollAnswer>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<EventPollAnswer>(list);
                } else {
                    list = (List<EventPollAnswer>) QueryUtil.list(q,
                            getDialect(), start, end);
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
     * Returns the first event poll answer in the ordered set where questionId = &#63; and clientId = &#63;.
     *
     * @param questionId the question ID
     * @param clientId the client ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching event poll answer
     * @throws com.liferay.events.global.mobile.NoSuchEventPollAnswerException if a matching event poll answer could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EventPollAnswer findByEventPollAnswer_Q_C_First(long questionId,
        String clientId, OrderByComparator orderByComparator)
        throws NoSuchEventPollAnswerException, SystemException {
        EventPollAnswer eventPollAnswer = fetchByEventPollAnswer_Q_C_First(questionId,
                clientId, orderByComparator);

        if (eventPollAnswer != null) {
            return eventPollAnswer;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("questionId=");
        msg.append(questionId);

        msg.append(", clientId=");
        msg.append(clientId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchEventPollAnswerException(msg.toString());
    }

    /**
     * Returns the first event poll answer in the ordered set where questionId = &#63; and clientId = &#63;.
     *
     * @param questionId the question ID
     * @param clientId the client ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching event poll answer, or <code>null</code> if a matching event poll answer could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EventPollAnswer fetchByEventPollAnswer_Q_C_First(long questionId,
        String clientId, OrderByComparator orderByComparator)
        throws SystemException {
        List<EventPollAnswer> list = findByEventPollAnswer_Q_C(questionId,
                clientId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last event poll answer in the ordered set where questionId = &#63; and clientId = &#63;.
     *
     * @param questionId the question ID
     * @param clientId the client ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching event poll answer
     * @throws com.liferay.events.global.mobile.NoSuchEventPollAnswerException if a matching event poll answer could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EventPollAnswer findByEventPollAnswer_Q_C_Last(long questionId,
        String clientId, OrderByComparator orderByComparator)
        throws NoSuchEventPollAnswerException, SystemException {
        EventPollAnswer eventPollAnswer = fetchByEventPollAnswer_Q_C_Last(questionId,
                clientId, orderByComparator);

        if (eventPollAnswer != null) {
            return eventPollAnswer;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("questionId=");
        msg.append(questionId);

        msg.append(", clientId=");
        msg.append(clientId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchEventPollAnswerException(msg.toString());
    }

    /**
     * Returns the last event poll answer in the ordered set where questionId = &#63; and clientId = &#63;.
     *
     * @param questionId the question ID
     * @param clientId the client ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching event poll answer, or <code>null</code> if a matching event poll answer could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EventPollAnswer fetchByEventPollAnswer_Q_C_Last(long questionId,
        String clientId, OrderByComparator orderByComparator)
        throws SystemException {
        int count = countByEventPollAnswer_Q_C(questionId, clientId);

        if (count == 0) {
            return null;
        }

        List<EventPollAnswer> list = findByEventPollAnswer_Q_C(questionId,
                clientId, count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the event poll answers before and after the current event poll answer in the ordered set where questionId = &#63; and clientId = &#63;.
     *
     * @param answerId the primary key of the current event poll answer
     * @param questionId the question ID
     * @param clientId the client ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next event poll answer
     * @throws com.liferay.events.global.mobile.NoSuchEventPollAnswerException if a event poll answer with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EventPollAnswer[] findByEventPollAnswer_Q_C_PrevAndNext(
        long answerId, long questionId, String clientId,
        OrderByComparator orderByComparator)
        throws NoSuchEventPollAnswerException, SystemException {
        EventPollAnswer eventPollAnswer = findByPrimaryKey(answerId);

        Session session = null;

        try {
            session = openSession();

            EventPollAnswer[] array = new EventPollAnswerImpl[3];

            array[0] = getByEventPollAnswer_Q_C_PrevAndNext(session,
                    eventPollAnswer, questionId, clientId, orderByComparator,
                    true);

            array[1] = eventPollAnswer;

            array[2] = getByEventPollAnswer_Q_C_PrevAndNext(session,
                    eventPollAnswer, questionId, clientId, orderByComparator,
                    false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected EventPollAnswer getByEventPollAnswer_Q_C_PrevAndNext(
        Session session, EventPollAnswer eventPollAnswer, long questionId,
        String clientId, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_EVENTPOLLANSWER_WHERE);

        query.append(_FINDER_COLUMN_EVENTPOLLANSWER_Q_C_QUESTIONID_2);

        boolean bindClientId = false;

        if (clientId == null) {
            query.append(_FINDER_COLUMN_EVENTPOLLANSWER_Q_C_CLIENTID_1);
        } else if (clientId.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_EVENTPOLLANSWER_Q_C_CLIENTID_3);
        } else {
            bindClientId = true;

            query.append(_FINDER_COLUMN_EVENTPOLLANSWER_Q_C_CLIENTID_2);
        }

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
            query.append(EventPollAnswerModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(questionId);

        if (bindClientId) {
            qPos.add(clientId);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(eventPollAnswer);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<EventPollAnswer> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the event poll answers where questionId = &#63; and clientId = &#63; from the database.
     *
     * @param questionId the question ID
     * @param clientId the client ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByEventPollAnswer_Q_C(long questionId, String clientId)
        throws SystemException {
        for (EventPollAnswer eventPollAnswer : findByEventPollAnswer_Q_C(
                questionId, clientId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(eventPollAnswer);
        }
    }

    /**
     * Returns the number of event poll answers where questionId = &#63; and clientId = &#63;.
     *
     * @param questionId the question ID
     * @param clientId the client ID
     * @return the number of matching event poll answers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByEventPollAnswer_Q_C(long questionId, String clientId)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_EVENTPOLLANSWER_Q_C;

        Object[] finderArgs = new Object[] { questionId, clientId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_EVENTPOLLANSWER_WHERE);

            query.append(_FINDER_COLUMN_EVENTPOLLANSWER_Q_C_QUESTIONID_2);

            boolean bindClientId = false;

            if (clientId == null) {
                query.append(_FINDER_COLUMN_EVENTPOLLANSWER_Q_C_CLIENTID_1);
            } else if (clientId.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_EVENTPOLLANSWER_Q_C_CLIENTID_3);
            } else {
                bindClientId = true;

                query.append(_FINDER_COLUMN_EVENTPOLLANSWER_Q_C_CLIENTID_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(questionId);

                if (bindClientId) {
                    qPos.add(clientId);
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
     * Caches the event poll answer in the entity cache if it is enabled.
     *
     * @param eventPollAnswer the event poll answer
     */
    @Override
    public void cacheResult(EventPollAnswer eventPollAnswer) {
        EntityCacheUtil.putResult(EventPollAnswerModelImpl.ENTITY_CACHE_ENABLED,
            EventPollAnswerImpl.class, eventPollAnswer.getPrimaryKey(),
            eventPollAnswer);

        eventPollAnswer.resetOriginalValues();
    }

    /**
     * Caches the event poll answers in the entity cache if it is enabled.
     *
     * @param eventPollAnswers the event poll answers
     */
    @Override
    public void cacheResult(List<EventPollAnswer> eventPollAnswers) {
        for (EventPollAnswer eventPollAnswer : eventPollAnswers) {
            if (EntityCacheUtil.getResult(
                        EventPollAnswerModelImpl.ENTITY_CACHE_ENABLED,
                        EventPollAnswerImpl.class,
                        eventPollAnswer.getPrimaryKey()) == null) {
                cacheResult(eventPollAnswer);
            } else {
                eventPollAnswer.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all event poll answers.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(EventPollAnswerImpl.class.getName());
        }

        EntityCacheUtil.clearCache(EventPollAnswerImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the event poll answer.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(EventPollAnswer eventPollAnswer) {
        EntityCacheUtil.removeResult(EventPollAnswerModelImpl.ENTITY_CACHE_ENABLED,
            EventPollAnswerImpl.class, eventPollAnswer.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<EventPollAnswer> eventPollAnswers) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (EventPollAnswer eventPollAnswer : eventPollAnswers) {
            EntityCacheUtil.removeResult(EventPollAnswerModelImpl.ENTITY_CACHE_ENABLED,
                EventPollAnswerImpl.class, eventPollAnswer.getPrimaryKey());
        }
    }

    /**
     * Creates a new event poll answer with the primary key. Does not add the event poll answer to the database.
     *
     * @param answerId the primary key for the new event poll answer
     * @return the new event poll answer
     */
    @Override
    public EventPollAnswer create(long answerId) {
        EventPollAnswer eventPollAnswer = new EventPollAnswerImpl();

        eventPollAnswer.setNew(true);
        eventPollAnswer.setPrimaryKey(answerId);

        return eventPollAnswer;
    }

    /**
     * Removes the event poll answer with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param answerId the primary key of the event poll answer
     * @return the event poll answer that was removed
     * @throws com.liferay.events.global.mobile.NoSuchEventPollAnswerException if a event poll answer with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EventPollAnswer remove(long answerId)
        throws NoSuchEventPollAnswerException, SystemException {
        return remove((Serializable) answerId);
    }

    /**
     * Removes the event poll answer with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the event poll answer
     * @return the event poll answer that was removed
     * @throws com.liferay.events.global.mobile.NoSuchEventPollAnswerException if a event poll answer with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EventPollAnswer remove(Serializable primaryKey)
        throws NoSuchEventPollAnswerException, SystemException {
        Session session = null;

        try {
            session = openSession();

            EventPollAnswer eventPollAnswer = (EventPollAnswer) session.get(EventPollAnswerImpl.class,
                    primaryKey);

            if (eventPollAnswer == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchEventPollAnswerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(eventPollAnswer);
        } catch (NoSuchEventPollAnswerException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected EventPollAnswer removeImpl(EventPollAnswer eventPollAnswer)
        throws SystemException {
        eventPollAnswer = toUnwrappedModel(eventPollAnswer);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(eventPollAnswer)) {
                eventPollAnswer = (EventPollAnswer) session.get(EventPollAnswerImpl.class,
                        eventPollAnswer.getPrimaryKeyObj());
            }

            if (eventPollAnswer != null) {
                session.delete(eventPollAnswer);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (eventPollAnswer != null) {
            clearCache(eventPollAnswer);
        }

        return eventPollAnswer;
    }

    @Override
    public EventPollAnswer updateImpl(
        com.liferay.events.global.mobile.model.EventPollAnswer eventPollAnswer)
        throws SystemException {
        eventPollAnswer = toUnwrappedModel(eventPollAnswer);

        boolean isNew = eventPollAnswer.isNew();

        EventPollAnswerModelImpl eventPollAnswerModelImpl = (EventPollAnswerModelImpl) eventPollAnswer;

        Session session = null;

        try {
            session = openSession();

            if (eventPollAnswer.isNew()) {
                session.save(eventPollAnswer);

                eventPollAnswer.setNew(false);
            } else {
                session.merge(eventPollAnswer);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !EventPollAnswerModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((eventPollAnswerModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTPOLLANSWER_Q.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        eventPollAnswerModelImpl.getOriginalQuestionId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EVENTPOLLANSWER_Q,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTPOLLANSWER_Q,
                    args);

                args = new Object[] { eventPollAnswerModelImpl.getQuestionId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EVENTPOLLANSWER_Q,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTPOLLANSWER_Q,
                    args);
            }

            if ((eventPollAnswerModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTPOLLANSWER_Q_C.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        eventPollAnswerModelImpl.getOriginalQuestionId(),
                        eventPollAnswerModelImpl.getOriginalClientId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EVENTPOLLANSWER_Q_C,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTPOLLANSWER_Q_C,
                    args);

                args = new Object[] {
                        eventPollAnswerModelImpl.getQuestionId(),
                        eventPollAnswerModelImpl.getClientId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EVENTPOLLANSWER_Q_C,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTPOLLANSWER_Q_C,
                    args);
            }
        }

        EntityCacheUtil.putResult(EventPollAnswerModelImpl.ENTITY_CACHE_ENABLED,
            EventPollAnswerImpl.class, eventPollAnswer.getPrimaryKey(),
            eventPollAnswer);

        return eventPollAnswer;
    }

    protected EventPollAnswer toUnwrappedModel(EventPollAnswer eventPollAnswer) {
        if (eventPollAnswer instanceof EventPollAnswerImpl) {
            return eventPollAnswer;
        }

        EventPollAnswerImpl eventPollAnswerImpl = new EventPollAnswerImpl();

        eventPollAnswerImpl.setNew(eventPollAnswer.isNew());
        eventPollAnswerImpl.setPrimaryKey(eventPollAnswer.getPrimaryKey());

        eventPollAnswerImpl.setQuestionId(eventPollAnswer.getQuestionId());
        eventPollAnswerImpl.setClientId(eventPollAnswer.getClientId());
        eventPollAnswerImpl.setPayload(eventPollAnswer.getPayload());
        eventPollAnswerImpl.setAnswer(eventPollAnswer.getAnswer());
        eventPollAnswerImpl.setCreateDate(eventPollAnswer.getCreateDate());
        eventPollAnswerImpl.setAnswerId(eventPollAnswer.getAnswerId());

        return eventPollAnswerImpl;
    }

    /**
     * Returns the event poll answer with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the event poll answer
     * @return the event poll answer
     * @throws com.liferay.events.global.mobile.NoSuchEventPollAnswerException if a event poll answer with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EventPollAnswer findByPrimaryKey(Serializable primaryKey)
        throws NoSuchEventPollAnswerException, SystemException {
        EventPollAnswer eventPollAnswer = fetchByPrimaryKey(primaryKey);

        if (eventPollAnswer == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchEventPollAnswerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return eventPollAnswer;
    }

    /**
     * Returns the event poll answer with the primary key or throws a {@link com.liferay.events.global.mobile.NoSuchEventPollAnswerException} if it could not be found.
     *
     * @param answerId the primary key of the event poll answer
     * @return the event poll answer
     * @throws com.liferay.events.global.mobile.NoSuchEventPollAnswerException if a event poll answer with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EventPollAnswer findByPrimaryKey(long answerId)
        throws NoSuchEventPollAnswerException, SystemException {
        return findByPrimaryKey((Serializable) answerId);
    }

    /**
     * Returns the event poll answer with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the event poll answer
     * @return the event poll answer, or <code>null</code> if a event poll answer with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EventPollAnswer fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        EventPollAnswer eventPollAnswer = (EventPollAnswer) EntityCacheUtil.getResult(EventPollAnswerModelImpl.ENTITY_CACHE_ENABLED,
                EventPollAnswerImpl.class, primaryKey);

        if (eventPollAnswer == _nullEventPollAnswer) {
            return null;
        }

        if (eventPollAnswer == null) {
            Session session = null;

            try {
                session = openSession();

                eventPollAnswer = (EventPollAnswer) session.get(EventPollAnswerImpl.class,
                        primaryKey);

                if (eventPollAnswer != null) {
                    cacheResult(eventPollAnswer);
                } else {
                    EntityCacheUtil.putResult(EventPollAnswerModelImpl.ENTITY_CACHE_ENABLED,
                        EventPollAnswerImpl.class, primaryKey,
                        _nullEventPollAnswer);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(EventPollAnswerModelImpl.ENTITY_CACHE_ENABLED,
                    EventPollAnswerImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return eventPollAnswer;
    }

    /**
     * Returns the event poll answer with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param answerId the primary key of the event poll answer
     * @return the event poll answer, or <code>null</code> if a event poll answer with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EventPollAnswer fetchByPrimaryKey(long answerId)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) answerId);
    }

    /**
     * Returns all the event poll answers.
     *
     * @return the event poll answers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<EventPollAnswer> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the event poll answers.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.events.global.mobile.model.impl.EventPollAnswerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of event poll answers
     * @param end the upper bound of the range of event poll answers (not inclusive)
     * @return the range of event poll answers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<EventPollAnswer> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the event poll answers.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.events.global.mobile.model.impl.EventPollAnswerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of event poll answers
     * @param end the upper bound of the range of event poll answers (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of event poll answers
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<EventPollAnswer> findAll(int start, int end,
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

        List<EventPollAnswer> list = (List<EventPollAnswer>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_EVENTPOLLANSWER);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_EVENTPOLLANSWER;

                if (pagination) {
                    sql = sql.concat(EventPollAnswerModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<EventPollAnswer>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<EventPollAnswer>(list);
                } else {
                    list = (List<EventPollAnswer>) QueryUtil.list(q,
                            getDialect(), start, end);
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
     * Removes all the event poll answers from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (EventPollAnswer eventPollAnswer : findAll()) {
            remove(eventPollAnswer);
        }
    }

    /**
     * Returns the number of event poll answers.
     *
     * @return the number of event poll answers
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

                Query q = session.createQuery(_SQL_COUNT_EVENTPOLLANSWER);

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
     * Initializes the event poll answer persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.liferay.events.global.mobile.model.EventPollAnswer")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<EventPollAnswer>> listenersList = new ArrayList<ModelListener<EventPollAnswer>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<EventPollAnswer>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(EventPollAnswerImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
