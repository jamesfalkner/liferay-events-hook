package com.liferay.events.global.mobile.service.persistence;

import com.liferay.events.global.mobile.NoSuchEventPollQuestionException;
import com.liferay.events.global.mobile.model.EventPollQuestion;
import com.liferay.events.global.mobile.model.impl.EventPollQuestionImpl;
import com.liferay.events.global.mobile.model.impl.EventPollQuestionModelImpl;
import com.liferay.events.global.mobile.service.persistence.EventPollQuestionPersistence;

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
import com.liferay.portal.kernel.util.CalendarUtil;
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
import java.util.Date;
import java.util.List;

/**
 * The persistence implementation for the event poll question service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author James Falkner
 * @see EventPollQuestionPersistence
 * @see EventPollQuestionUtil
 * @generated
 */
public class EventPollQuestionPersistenceImpl extends BasePersistenceImpl<EventPollQuestion>
    implements EventPollQuestionPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link EventPollQuestionUtil} to access the event poll question persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = EventPollQuestionImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EventPollQuestionModelImpl.ENTITY_CACHE_ENABLED,
            EventPollQuestionModelImpl.FINDER_CACHE_ENABLED,
            EventPollQuestionImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EventPollQuestionModelImpl.ENTITY_CACHE_ENABLED,
            EventPollQuestionModelImpl.FINDER_CACHE_ENABLED,
            EventPollQuestionImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EventPollQuestionModelImpl.ENTITY_CACHE_ENABLED,
            EventPollQuestionModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EVENTPOLLQUESTION_A_E_D =
        new FinderPath(EventPollQuestionModelImpl.ENTITY_CACHE_ENABLED,
            EventPollQuestionModelImpl.FINDER_CACHE_ENABLED,
            EventPollQuestionImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByEventPollQuestion_A_E_D",
            new String[] {
                Boolean.class.getName(), Boolean.class.getName(),
                Date.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_EVENTPOLLQUESTION_A_E_D =
        new FinderPath(EventPollQuestionModelImpl.ENTITY_CACHE_ENABLED,
            EventPollQuestionModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "countByEventPollQuestion_A_E_D",
            new String[] {
                Boolean.class.getName(), Boolean.class.getName(),
                Date.class.getName()
            });
    private static final String _FINDER_COLUMN_EVENTPOLLQUESTION_A_E_D_AUTOENABLE_2 =
        "eventPollQuestion.autoEnable = ? AND ";
    private static final String _FINDER_COLUMN_EVENTPOLLQUESTION_A_E_D_ENABLED_2 =
        "eventPollQuestion.enabled = ? AND ";
    private static final String _FINDER_COLUMN_EVENTPOLLQUESTION_A_E_D_ENABLETRIGGERDATE_1 =
        "eventPollQuestion.enableTriggerDate <= NULL";
    private static final String _FINDER_COLUMN_EVENTPOLLQUESTION_A_E_D_ENABLETRIGGERDATE_2 =
        "eventPollQuestion.enableTriggerDate <= ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EVENTPOLLQUESTION_E =
        new FinderPath(EventPollQuestionModelImpl.ENTITY_CACHE_ENABLED,
            EventPollQuestionModelImpl.FINDER_CACHE_ENABLED,
            EventPollQuestionImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByEventPollQuestion_E",
            new String[] {
                String.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTPOLLQUESTION_E =
        new FinderPath(EventPollQuestionModelImpl.ENTITY_CACHE_ENABLED,
            EventPollQuestionModelImpl.FINDER_CACHE_ENABLED,
            EventPollQuestionImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findByEventPollQuestion_E",
            new String[] { String.class.getName() },
            EventPollQuestionModelImpl.EVENTID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_EVENTPOLLQUESTION_E = new FinderPath(EventPollQuestionModelImpl.ENTITY_CACHE_ENABLED,
            EventPollQuestionModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByEventPollQuestion_E",
            new String[] { String.class.getName() });
    private static final String _FINDER_COLUMN_EVENTPOLLQUESTION_E_EVENTID_1 = "eventPollQuestion.eventId IS NULL";
    private static final String _FINDER_COLUMN_EVENTPOLLQUESTION_E_EVENTID_2 = "eventPollQuestion.eventId = ?";
    private static final String _FINDER_COLUMN_EVENTPOLLQUESTION_E_EVENTID_3 = "(eventPollQuestion.eventId IS NULL OR eventPollQuestion.eventId = '')";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EVENTPOLLQUESTION_E_E =
        new FinderPath(EventPollQuestionModelImpl.ENTITY_CACHE_ENABLED,
            EventPollQuestionModelImpl.FINDER_CACHE_ENABLED,
            EventPollQuestionImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByEventPollQuestion_E_E",
            new String[] {
                String.class.getName(), Boolean.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTPOLLQUESTION_E_E =
        new FinderPath(EventPollQuestionModelImpl.ENTITY_CACHE_ENABLED,
            EventPollQuestionModelImpl.FINDER_CACHE_ENABLED,
            EventPollQuestionImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findByEventPollQuestion_E_E",
            new String[] { String.class.getName(), Boolean.class.getName() },
            EventPollQuestionModelImpl.EVENTID_COLUMN_BITMASK |
            EventPollQuestionModelImpl.ENABLED_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_EVENTPOLLQUESTION_E_E = new FinderPath(EventPollQuestionModelImpl.ENTITY_CACHE_ENABLED,
            EventPollQuestionModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByEventPollQuestion_E_E",
            new String[] { String.class.getName(), Boolean.class.getName() });
    private static final String _FINDER_COLUMN_EVENTPOLLQUESTION_E_E_EVENTID_1 = "eventPollQuestion.eventId IS NULL AND ";
    private static final String _FINDER_COLUMN_EVENTPOLLQUESTION_E_E_EVENTID_2 = "eventPollQuestion.eventId = ? AND ";
    private static final String _FINDER_COLUMN_EVENTPOLLQUESTION_E_E_EVENTID_3 = "(eventPollQuestion.eventId IS NULL OR eventPollQuestion.eventId = '') AND ";
    private static final String _FINDER_COLUMN_EVENTPOLLQUESTION_E_E_ENABLED_2 = "eventPollQuestion.enabled = ?";
    private static final String _SQL_SELECT_EVENTPOLLQUESTION = "SELECT eventPollQuestion FROM EventPollQuestion eventPollQuestion";
    private static final String _SQL_SELECT_EVENTPOLLQUESTION_WHERE = "SELECT eventPollQuestion FROM EventPollQuestion eventPollQuestion WHERE ";
    private static final String _SQL_COUNT_EVENTPOLLQUESTION = "SELECT COUNT(eventPollQuestion) FROM EventPollQuestion eventPollQuestion";
    private static final String _SQL_COUNT_EVENTPOLLQUESTION_WHERE = "SELECT COUNT(eventPollQuestion) FROM EventPollQuestion eventPollQuestion WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "eventPollQuestion.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No EventPollQuestion exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No EventPollQuestion exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(EventPollQuestionPersistenceImpl.class);
    private static EventPollQuestion _nullEventPollQuestion = new EventPollQuestionImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<EventPollQuestion> toCacheModel() {
                return _nullEventPollQuestionCacheModel;
            }
        };

    private static CacheModel<EventPollQuestion> _nullEventPollQuestionCacheModel =
        new CacheModel<EventPollQuestion>() {
            @Override
            public EventPollQuestion toEntityModel() {
                return _nullEventPollQuestion;
            }
        };

    public EventPollQuestionPersistenceImpl() {
        setModelClass(EventPollQuestion.class);
    }

    /**
     * Returns all the event poll questions where autoEnable = &#63; and enabled = &#63; and enableTriggerDate &le; &#63;.
     *
     * @param autoEnable the auto enable
     * @param enabled the enabled
     * @param enableTriggerDate the enable trigger date
     * @return the matching event poll questions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<EventPollQuestion> findByEventPollQuestion_A_E_D(
        boolean autoEnable, boolean enabled, Date enableTriggerDate)
        throws SystemException {
        return findByEventPollQuestion_A_E_D(autoEnable, enabled,
            enableTriggerDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the event poll questions where autoEnable = &#63; and enabled = &#63; and enableTriggerDate &le; &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.events.global.mobile.model.impl.EventPollQuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param autoEnable the auto enable
     * @param enabled the enabled
     * @param enableTriggerDate the enable trigger date
     * @param start the lower bound of the range of event poll questions
     * @param end the upper bound of the range of event poll questions (not inclusive)
     * @return the range of matching event poll questions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<EventPollQuestion> findByEventPollQuestion_A_E_D(
        boolean autoEnable, boolean enabled, Date enableTriggerDate, int start,
        int end) throws SystemException {
        return findByEventPollQuestion_A_E_D(autoEnable, enabled,
            enableTriggerDate, start, end, null);
    }

    /**
     * Returns an ordered range of all the event poll questions where autoEnable = &#63; and enabled = &#63; and enableTriggerDate &le; &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.events.global.mobile.model.impl.EventPollQuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param autoEnable the auto enable
     * @param enabled the enabled
     * @param enableTriggerDate the enable trigger date
     * @param start the lower bound of the range of event poll questions
     * @param end the upper bound of the range of event poll questions (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching event poll questions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<EventPollQuestion> findByEventPollQuestion_A_E_D(
        boolean autoEnable, boolean enabled, Date enableTriggerDate, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EVENTPOLLQUESTION_A_E_D;
        finderArgs = new Object[] {
                autoEnable, enabled, enableTriggerDate,
                
                start, end, orderByComparator
            };

        List<EventPollQuestion> list = (List<EventPollQuestion>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (EventPollQuestion eventPollQuestion : list) {
                if ((autoEnable != eventPollQuestion.getAutoEnable()) ||
                        (enabled != eventPollQuestion.getEnabled()) ||
                        (enableTriggerDate.getTime() < eventPollQuestion.getEnableTriggerDate()
                                                                            .getTime())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(5 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(5);
            }

            query.append(_SQL_SELECT_EVENTPOLLQUESTION_WHERE);

            query.append(_FINDER_COLUMN_EVENTPOLLQUESTION_A_E_D_AUTOENABLE_2);

            query.append(_FINDER_COLUMN_EVENTPOLLQUESTION_A_E_D_ENABLED_2);

            boolean bindEnableTriggerDate = false;

            if (enableTriggerDate == null) {
                query.append(_FINDER_COLUMN_EVENTPOLLQUESTION_A_E_D_ENABLETRIGGERDATE_1);
            } else {
                bindEnableTriggerDate = true;

                query.append(_FINDER_COLUMN_EVENTPOLLQUESTION_A_E_D_ENABLETRIGGERDATE_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(EventPollQuestionModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(autoEnable);

                qPos.add(enabled);

                if (bindEnableTriggerDate) {
                    qPos.add(CalendarUtil.getTimestamp(enableTriggerDate));
                }

                if (!pagination) {
                    list = (List<EventPollQuestion>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<EventPollQuestion>(list);
                } else {
                    list = (List<EventPollQuestion>) QueryUtil.list(q,
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
     * Returns the first event poll question in the ordered set where autoEnable = &#63; and enabled = &#63; and enableTriggerDate &le; &#63;.
     *
     * @param autoEnable the auto enable
     * @param enabled the enabled
     * @param enableTriggerDate the enable trigger date
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching event poll question
     * @throws com.liferay.events.global.mobile.NoSuchEventPollQuestionException if a matching event poll question could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EventPollQuestion findByEventPollQuestion_A_E_D_First(
        boolean autoEnable, boolean enabled, Date enableTriggerDate,
        OrderByComparator orderByComparator)
        throws NoSuchEventPollQuestionException, SystemException {
        EventPollQuestion eventPollQuestion = fetchByEventPollQuestion_A_E_D_First(autoEnable,
                enabled, enableTriggerDate, orderByComparator);

        if (eventPollQuestion != null) {
            return eventPollQuestion;
        }

        StringBundler msg = new StringBundler(8);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("autoEnable=");
        msg.append(autoEnable);

        msg.append(", enabled=");
        msg.append(enabled);

        msg.append(", enableTriggerDate=");
        msg.append(enableTriggerDate);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchEventPollQuestionException(msg.toString());
    }

    /**
     * Returns the first event poll question in the ordered set where autoEnable = &#63; and enabled = &#63; and enableTriggerDate &le; &#63;.
     *
     * @param autoEnable the auto enable
     * @param enabled the enabled
     * @param enableTriggerDate the enable trigger date
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching event poll question, or <code>null</code> if a matching event poll question could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EventPollQuestion fetchByEventPollQuestion_A_E_D_First(
        boolean autoEnable, boolean enabled, Date enableTriggerDate,
        OrderByComparator orderByComparator) throws SystemException {
        List<EventPollQuestion> list = findByEventPollQuestion_A_E_D(autoEnable,
                enabled, enableTriggerDate, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last event poll question in the ordered set where autoEnable = &#63; and enabled = &#63; and enableTriggerDate &le; &#63;.
     *
     * @param autoEnable the auto enable
     * @param enabled the enabled
     * @param enableTriggerDate the enable trigger date
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching event poll question
     * @throws com.liferay.events.global.mobile.NoSuchEventPollQuestionException if a matching event poll question could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EventPollQuestion findByEventPollQuestion_A_E_D_Last(
        boolean autoEnable, boolean enabled, Date enableTriggerDate,
        OrderByComparator orderByComparator)
        throws NoSuchEventPollQuestionException, SystemException {
        EventPollQuestion eventPollQuestion = fetchByEventPollQuestion_A_E_D_Last(autoEnable,
                enabled, enableTriggerDate, orderByComparator);

        if (eventPollQuestion != null) {
            return eventPollQuestion;
        }

        StringBundler msg = new StringBundler(8);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("autoEnable=");
        msg.append(autoEnable);

        msg.append(", enabled=");
        msg.append(enabled);

        msg.append(", enableTriggerDate=");
        msg.append(enableTriggerDate);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchEventPollQuestionException(msg.toString());
    }

    /**
     * Returns the last event poll question in the ordered set where autoEnable = &#63; and enabled = &#63; and enableTriggerDate &le; &#63;.
     *
     * @param autoEnable the auto enable
     * @param enabled the enabled
     * @param enableTriggerDate the enable trigger date
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching event poll question, or <code>null</code> if a matching event poll question could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EventPollQuestion fetchByEventPollQuestion_A_E_D_Last(
        boolean autoEnable, boolean enabled, Date enableTriggerDate,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByEventPollQuestion_A_E_D(autoEnable, enabled,
                enableTriggerDate);

        if (count == 0) {
            return null;
        }

        List<EventPollQuestion> list = findByEventPollQuestion_A_E_D(autoEnable,
                enabled, enableTriggerDate, count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the event poll questions before and after the current event poll question in the ordered set where autoEnable = &#63; and enabled = &#63; and enableTriggerDate &le; &#63;.
     *
     * @param questionId the primary key of the current event poll question
     * @param autoEnable the auto enable
     * @param enabled the enabled
     * @param enableTriggerDate the enable trigger date
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next event poll question
     * @throws com.liferay.events.global.mobile.NoSuchEventPollQuestionException if a event poll question with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EventPollQuestion[] findByEventPollQuestion_A_E_D_PrevAndNext(
        long questionId, boolean autoEnable, boolean enabled,
        Date enableTriggerDate, OrderByComparator orderByComparator)
        throws NoSuchEventPollQuestionException, SystemException {
        EventPollQuestion eventPollQuestion = findByPrimaryKey(questionId);

        Session session = null;

        try {
            session = openSession();

            EventPollQuestion[] array = new EventPollQuestionImpl[3];

            array[0] = getByEventPollQuestion_A_E_D_PrevAndNext(session,
                    eventPollQuestion, autoEnable, enabled, enableTriggerDate,
                    orderByComparator, true);

            array[1] = eventPollQuestion;

            array[2] = getByEventPollQuestion_A_E_D_PrevAndNext(session,
                    eventPollQuestion, autoEnable, enabled, enableTriggerDate,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected EventPollQuestion getByEventPollQuestion_A_E_D_PrevAndNext(
        Session session, EventPollQuestion eventPollQuestion,
        boolean autoEnable, boolean enabled, Date enableTriggerDate,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_EVENTPOLLQUESTION_WHERE);

        query.append(_FINDER_COLUMN_EVENTPOLLQUESTION_A_E_D_AUTOENABLE_2);

        query.append(_FINDER_COLUMN_EVENTPOLLQUESTION_A_E_D_ENABLED_2);

        boolean bindEnableTriggerDate = false;

        if (enableTriggerDate == null) {
            query.append(_FINDER_COLUMN_EVENTPOLLQUESTION_A_E_D_ENABLETRIGGERDATE_1);
        } else {
            bindEnableTriggerDate = true;

            query.append(_FINDER_COLUMN_EVENTPOLLQUESTION_A_E_D_ENABLETRIGGERDATE_2);
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
            query.append(EventPollQuestionModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(autoEnable);

        qPos.add(enabled);

        if (bindEnableTriggerDate) {
            qPos.add(CalendarUtil.getTimestamp(enableTriggerDate));
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(eventPollQuestion);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<EventPollQuestion> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the event poll questions where autoEnable = &#63; and enabled = &#63; and enableTriggerDate &le; &#63; from the database.
     *
     * @param autoEnable the auto enable
     * @param enabled the enabled
     * @param enableTriggerDate the enable trigger date
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByEventPollQuestion_A_E_D(boolean autoEnable,
        boolean enabled, Date enableTriggerDate) throws SystemException {
        for (EventPollQuestion eventPollQuestion : findByEventPollQuestion_A_E_D(
                autoEnable, enabled, enableTriggerDate, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(eventPollQuestion);
        }
    }

    /**
     * Returns the number of event poll questions where autoEnable = &#63; and enabled = &#63; and enableTriggerDate &le; &#63;.
     *
     * @param autoEnable the auto enable
     * @param enabled the enabled
     * @param enableTriggerDate the enable trigger date
     * @return the number of matching event poll questions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByEventPollQuestion_A_E_D(boolean autoEnable,
        boolean enabled, Date enableTriggerDate) throws SystemException {
        FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_EVENTPOLLQUESTION_A_E_D;

        Object[] finderArgs = new Object[] {
                autoEnable, enabled, enableTriggerDate
            };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(4);

            query.append(_SQL_COUNT_EVENTPOLLQUESTION_WHERE);

            query.append(_FINDER_COLUMN_EVENTPOLLQUESTION_A_E_D_AUTOENABLE_2);

            query.append(_FINDER_COLUMN_EVENTPOLLQUESTION_A_E_D_ENABLED_2);

            boolean bindEnableTriggerDate = false;

            if (enableTriggerDate == null) {
                query.append(_FINDER_COLUMN_EVENTPOLLQUESTION_A_E_D_ENABLETRIGGERDATE_1);
            } else {
                bindEnableTriggerDate = true;

                query.append(_FINDER_COLUMN_EVENTPOLLQUESTION_A_E_D_ENABLETRIGGERDATE_2);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(autoEnable);

                qPos.add(enabled);

                if (bindEnableTriggerDate) {
                    qPos.add(CalendarUtil.getTimestamp(enableTriggerDate));
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
     * Returns all the event poll questions where eventId = &#63;.
     *
     * @param eventId the event ID
     * @return the matching event poll questions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<EventPollQuestion> findByEventPollQuestion_E(String eventId)
        throws SystemException {
        return findByEventPollQuestion_E(eventId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the event poll questions where eventId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.events.global.mobile.model.impl.EventPollQuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param eventId the event ID
     * @param start the lower bound of the range of event poll questions
     * @param end the upper bound of the range of event poll questions (not inclusive)
     * @return the range of matching event poll questions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<EventPollQuestion> findByEventPollQuestion_E(String eventId,
        int start, int end) throws SystemException {
        return findByEventPollQuestion_E(eventId, start, end, null);
    }

    /**
     * Returns an ordered range of all the event poll questions where eventId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.events.global.mobile.model.impl.EventPollQuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param eventId the event ID
     * @param start the lower bound of the range of event poll questions
     * @param end the upper bound of the range of event poll questions (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching event poll questions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<EventPollQuestion> findByEventPollQuestion_E(String eventId,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTPOLLQUESTION_E;
            finderArgs = new Object[] { eventId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EVENTPOLLQUESTION_E;
            finderArgs = new Object[] { eventId, start, end, orderByComparator };
        }

        List<EventPollQuestion> list = (List<EventPollQuestion>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (EventPollQuestion eventPollQuestion : list) {
                if (!Validator.equals(eventId, eventPollQuestion.getEventId())) {
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

            query.append(_SQL_SELECT_EVENTPOLLQUESTION_WHERE);

            boolean bindEventId = false;

            if (eventId == null) {
                query.append(_FINDER_COLUMN_EVENTPOLLQUESTION_E_EVENTID_1);
            } else if (eventId.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_EVENTPOLLQUESTION_E_EVENTID_3);
            } else {
                bindEventId = true;

                query.append(_FINDER_COLUMN_EVENTPOLLQUESTION_E_EVENTID_2);
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(EventPollQuestionModelImpl.ORDER_BY_JPQL);
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

                if (!pagination) {
                    list = (List<EventPollQuestion>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<EventPollQuestion>(list);
                } else {
                    list = (List<EventPollQuestion>) QueryUtil.list(q,
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
     * Returns the first event poll question in the ordered set where eventId = &#63;.
     *
     * @param eventId the event ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching event poll question
     * @throws com.liferay.events.global.mobile.NoSuchEventPollQuestionException if a matching event poll question could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EventPollQuestion findByEventPollQuestion_E_First(String eventId,
        OrderByComparator orderByComparator)
        throws NoSuchEventPollQuestionException, SystemException {
        EventPollQuestion eventPollQuestion = fetchByEventPollQuestion_E_First(eventId,
                orderByComparator);

        if (eventPollQuestion != null) {
            return eventPollQuestion;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("eventId=");
        msg.append(eventId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchEventPollQuestionException(msg.toString());
    }

    /**
     * Returns the first event poll question in the ordered set where eventId = &#63;.
     *
     * @param eventId the event ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching event poll question, or <code>null</code> if a matching event poll question could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EventPollQuestion fetchByEventPollQuestion_E_First(String eventId,
        OrderByComparator orderByComparator) throws SystemException {
        List<EventPollQuestion> list = findByEventPollQuestion_E(eventId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last event poll question in the ordered set where eventId = &#63;.
     *
     * @param eventId the event ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching event poll question
     * @throws com.liferay.events.global.mobile.NoSuchEventPollQuestionException if a matching event poll question could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EventPollQuestion findByEventPollQuestion_E_Last(String eventId,
        OrderByComparator orderByComparator)
        throws NoSuchEventPollQuestionException, SystemException {
        EventPollQuestion eventPollQuestion = fetchByEventPollQuestion_E_Last(eventId,
                orderByComparator);

        if (eventPollQuestion != null) {
            return eventPollQuestion;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("eventId=");
        msg.append(eventId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchEventPollQuestionException(msg.toString());
    }

    /**
     * Returns the last event poll question in the ordered set where eventId = &#63;.
     *
     * @param eventId the event ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching event poll question, or <code>null</code> if a matching event poll question could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EventPollQuestion fetchByEventPollQuestion_E_Last(String eventId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByEventPollQuestion_E(eventId);

        if (count == 0) {
            return null;
        }

        List<EventPollQuestion> list = findByEventPollQuestion_E(eventId,
                count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the event poll questions before and after the current event poll question in the ordered set where eventId = &#63;.
     *
     * @param questionId the primary key of the current event poll question
     * @param eventId the event ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next event poll question
     * @throws com.liferay.events.global.mobile.NoSuchEventPollQuestionException if a event poll question with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EventPollQuestion[] findByEventPollQuestion_E_PrevAndNext(
        long questionId, String eventId, OrderByComparator orderByComparator)
        throws NoSuchEventPollQuestionException, SystemException {
        EventPollQuestion eventPollQuestion = findByPrimaryKey(questionId);

        Session session = null;

        try {
            session = openSession();

            EventPollQuestion[] array = new EventPollQuestionImpl[3];

            array[0] = getByEventPollQuestion_E_PrevAndNext(session,
                    eventPollQuestion, eventId, orderByComparator, true);

            array[1] = eventPollQuestion;

            array[2] = getByEventPollQuestion_E_PrevAndNext(session,
                    eventPollQuestion, eventId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected EventPollQuestion getByEventPollQuestion_E_PrevAndNext(
        Session session, EventPollQuestion eventPollQuestion, String eventId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_EVENTPOLLQUESTION_WHERE);

        boolean bindEventId = false;

        if (eventId == null) {
            query.append(_FINDER_COLUMN_EVENTPOLLQUESTION_E_EVENTID_1);
        } else if (eventId.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_EVENTPOLLQUESTION_E_EVENTID_3);
        } else {
            bindEventId = true;

            query.append(_FINDER_COLUMN_EVENTPOLLQUESTION_E_EVENTID_2);
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
            query.append(EventPollQuestionModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindEventId) {
            qPos.add(eventId);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(eventPollQuestion);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<EventPollQuestion> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the event poll questions where eventId = &#63; from the database.
     *
     * @param eventId the event ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByEventPollQuestion_E(String eventId)
        throws SystemException {
        for (EventPollQuestion eventPollQuestion : findByEventPollQuestion_E(
                eventId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(eventPollQuestion);
        }
    }

    /**
     * Returns the number of event poll questions where eventId = &#63;.
     *
     * @param eventId the event ID
     * @return the number of matching event poll questions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByEventPollQuestion_E(String eventId)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_EVENTPOLLQUESTION_E;

        Object[] finderArgs = new Object[] { eventId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_EVENTPOLLQUESTION_WHERE);

            boolean bindEventId = false;

            if (eventId == null) {
                query.append(_FINDER_COLUMN_EVENTPOLLQUESTION_E_EVENTID_1);
            } else if (eventId.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_EVENTPOLLQUESTION_E_EVENTID_3);
            } else {
                bindEventId = true;

                query.append(_FINDER_COLUMN_EVENTPOLLQUESTION_E_EVENTID_2);
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
     * Returns all the event poll questions where eventId = &#63; and enabled = &#63;.
     *
     * @param eventId the event ID
     * @param enabled the enabled
     * @return the matching event poll questions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<EventPollQuestion> findByEventPollQuestion_E_E(String eventId,
        boolean enabled) throws SystemException {
        return findByEventPollQuestion_E_E(eventId, enabled, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the event poll questions where eventId = &#63; and enabled = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.events.global.mobile.model.impl.EventPollQuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param eventId the event ID
     * @param enabled the enabled
     * @param start the lower bound of the range of event poll questions
     * @param end the upper bound of the range of event poll questions (not inclusive)
     * @return the range of matching event poll questions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<EventPollQuestion> findByEventPollQuestion_E_E(String eventId,
        boolean enabled, int start, int end) throws SystemException {
        return findByEventPollQuestion_E_E(eventId, enabled, start, end, null);
    }

    /**
     * Returns an ordered range of all the event poll questions where eventId = &#63; and enabled = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.events.global.mobile.model.impl.EventPollQuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param eventId the event ID
     * @param enabled the enabled
     * @param start the lower bound of the range of event poll questions
     * @param end the upper bound of the range of event poll questions (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching event poll questions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<EventPollQuestion> findByEventPollQuestion_E_E(String eventId,
        boolean enabled, int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTPOLLQUESTION_E_E;
            finderArgs = new Object[] { eventId, enabled };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EVENTPOLLQUESTION_E_E;
            finderArgs = new Object[] {
                    eventId, enabled,
                    
                    start, end, orderByComparator
                };
        }

        List<EventPollQuestion> list = (List<EventPollQuestion>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (EventPollQuestion eventPollQuestion : list) {
                if (!Validator.equals(eventId, eventPollQuestion.getEventId()) ||
                        (enabled != eventPollQuestion.getEnabled())) {
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

            query.append(_SQL_SELECT_EVENTPOLLQUESTION_WHERE);

            boolean bindEventId = false;

            if (eventId == null) {
                query.append(_FINDER_COLUMN_EVENTPOLLQUESTION_E_E_EVENTID_1);
            } else if (eventId.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_EVENTPOLLQUESTION_E_E_EVENTID_3);
            } else {
                bindEventId = true;

                query.append(_FINDER_COLUMN_EVENTPOLLQUESTION_E_E_EVENTID_2);
            }

            query.append(_FINDER_COLUMN_EVENTPOLLQUESTION_E_E_ENABLED_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(EventPollQuestionModelImpl.ORDER_BY_JPQL);
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

                qPos.add(enabled);

                if (!pagination) {
                    list = (List<EventPollQuestion>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<EventPollQuestion>(list);
                } else {
                    list = (List<EventPollQuestion>) QueryUtil.list(q,
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
     * Returns the first event poll question in the ordered set where eventId = &#63; and enabled = &#63;.
     *
     * @param eventId the event ID
     * @param enabled the enabled
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching event poll question
     * @throws com.liferay.events.global.mobile.NoSuchEventPollQuestionException if a matching event poll question could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EventPollQuestion findByEventPollQuestion_E_E_First(String eventId,
        boolean enabled, OrderByComparator orderByComparator)
        throws NoSuchEventPollQuestionException, SystemException {
        EventPollQuestion eventPollQuestion = fetchByEventPollQuestion_E_E_First(eventId,
                enabled, orderByComparator);

        if (eventPollQuestion != null) {
            return eventPollQuestion;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("eventId=");
        msg.append(eventId);

        msg.append(", enabled=");
        msg.append(enabled);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchEventPollQuestionException(msg.toString());
    }

    /**
     * Returns the first event poll question in the ordered set where eventId = &#63; and enabled = &#63;.
     *
     * @param eventId the event ID
     * @param enabled the enabled
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching event poll question, or <code>null</code> if a matching event poll question could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EventPollQuestion fetchByEventPollQuestion_E_E_First(
        String eventId, boolean enabled, OrderByComparator orderByComparator)
        throws SystemException {
        List<EventPollQuestion> list = findByEventPollQuestion_E_E(eventId,
                enabled, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last event poll question in the ordered set where eventId = &#63; and enabled = &#63;.
     *
     * @param eventId the event ID
     * @param enabled the enabled
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching event poll question
     * @throws com.liferay.events.global.mobile.NoSuchEventPollQuestionException if a matching event poll question could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EventPollQuestion findByEventPollQuestion_E_E_Last(String eventId,
        boolean enabled, OrderByComparator orderByComparator)
        throws NoSuchEventPollQuestionException, SystemException {
        EventPollQuestion eventPollQuestion = fetchByEventPollQuestion_E_E_Last(eventId,
                enabled, orderByComparator);

        if (eventPollQuestion != null) {
            return eventPollQuestion;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("eventId=");
        msg.append(eventId);

        msg.append(", enabled=");
        msg.append(enabled);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchEventPollQuestionException(msg.toString());
    }

    /**
     * Returns the last event poll question in the ordered set where eventId = &#63; and enabled = &#63;.
     *
     * @param eventId the event ID
     * @param enabled the enabled
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching event poll question, or <code>null</code> if a matching event poll question could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EventPollQuestion fetchByEventPollQuestion_E_E_Last(String eventId,
        boolean enabled, OrderByComparator orderByComparator)
        throws SystemException {
        int count = countByEventPollQuestion_E_E(eventId, enabled);

        if (count == 0) {
            return null;
        }

        List<EventPollQuestion> list = findByEventPollQuestion_E_E(eventId,
                enabled, count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the event poll questions before and after the current event poll question in the ordered set where eventId = &#63; and enabled = &#63;.
     *
     * @param questionId the primary key of the current event poll question
     * @param eventId the event ID
     * @param enabled the enabled
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next event poll question
     * @throws com.liferay.events.global.mobile.NoSuchEventPollQuestionException if a event poll question with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EventPollQuestion[] findByEventPollQuestion_E_E_PrevAndNext(
        long questionId, String eventId, boolean enabled,
        OrderByComparator orderByComparator)
        throws NoSuchEventPollQuestionException, SystemException {
        EventPollQuestion eventPollQuestion = findByPrimaryKey(questionId);

        Session session = null;

        try {
            session = openSession();

            EventPollQuestion[] array = new EventPollQuestionImpl[3];

            array[0] = getByEventPollQuestion_E_E_PrevAndNext(session,
                    eventPollQuestion, eventId, enabled, orderByComparator, true);

            array[1] = eventPollQuestion;

            array[2] = getByEventPollQuestion_E_E_PrevAndNext(session,
                    eventPollQuestion, eventId, enabled, orderByComparator,
                    false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected EventPollQuestion getByEventPollQuestion_E_E_PrevAndNext(
        Session session, EventPollQuestion eventPollQuestion, String eventId,
        boolean enabled, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_EVENTPOLLQUESTION_WHERE);

        boolean bindEventId = false;

        if (eventId == null) {
            query.append(_FINDER_COLUMN_EVENTPOLLQUESTION_E_E_EVENTID_1);
        } else if (eventId.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_EVENTPOLLQUESTION_E_E_EVENTID_3);
        } else {
            bindEventId = true;

            query.append(_FINDER_COLUMN_EVENTPOLLQUESTION_E_E_EVENTID_2);
        }

        query.append(_FINDER_COLUMN_EVENTPOLLQUESTION_E_E_ENABLED_2);

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
            query.append(EventPollQuestionModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindEventId) {
            qPos.add(eventId);
        }

        qPos.add(enabled);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(eventPollQuestion);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<EventPollQuestion> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the event poll questions where eventId = &#63; and enabled = &#63; from the database.
     *
     * @param eventId the event ID
     * @param enabled the enabled
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByEventPollQuestion_E_E(String eventId, boolean enabled)
        throws SystemException {
        for (EventPollQuestion eventPollQuestion : findByEventPollQuestion_E_E(
                eventId, enabled, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(eventPollQuestion);
        }
    }

    /**
     * Returns the number of event poll questions where eventId = &#63; and enabled = &#63;.
     *
     * @param eventId the event ID
     * @param enabled the enabled
     * @return the number of matching event poll questions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByEventPollQuestion_E_E(String eventId, boolean enabled)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_EVENTPOLLQUESTION_E_E;

        Object[] finderArgs = new Object[] { eventId, enabled };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_EVENTPOLLQUESTION_WHERE);

            boolean bindEventId = false;

            if (eventId == null) {
                query.append(_FINDER_COLUMN_EVENTPOLLQUESTION_E_E_EVENTID_1);
            } else if (eventId.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_EVENTPOLLQUESTION_E_E_EVENTID_3);
            } else {
                bindEventId = true;

                query.append(_FINDER_COLUMN_EVENTPOLLQUESTION_E_E_EVENTID_2);
            }

            query.append(_FINDER_COLUMN_EVENTPOLLQUESTION_E_E_ENABLED_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindEventId) {
                    qPos.add(eventId);
                }

                qPos.add(enabled);

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
     * Caches the event poll question in the entity cache if it is enabled.
     *
     * @param eventPollQuestion the event poll question
     */
    @Override
    public void cacheResult(EventPollQuestion eventPollQuestion) {
        EntityCacheUtil.putResult(EventPollQuestionModelImpl.ENTITY_CACHE_ENABLED,
            EventPollQuestionImpl.class, eventPollQuestion.getPrimaryKey(),
            eventPollQuestion);

        eventPollQuestion.resetOriginalValues();
    }

    /**
     * Caches the event poll questions in the entity cache if it is enabled.
     *
     * @param eventPollQuestions the event poll questions
     */
    @Override
    public void cacheResult(List<EventPollQuestion> eventPollQuestions) {
        for (EventPollQuestion eventPollQuestion : eventPollQuestions) {
            if (EntityCacheUtil.getResult(
                        EventPollQuestionModelImpl.ENTITY_CACHE_ENABLED,
                        EventPollQuestionImpl.class,
                        eventPollQuestion.getPrimaryKey()) == null) {
                cacheResult(eventPollQuestion);
            } else {
                eventPollQuestion.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all event poll questions.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(EventPollQuestionImpl.class.getName());
        }

        EntityCacheUtil.clearCache(EventPollQuestionImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the event poll question.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(EventPollQuestion eventPollQuestion) {
        EntityCacheUtil.removeResult(EventPollQuestionModelImpl.ENTITY_CACHE_ENABLED,
            EventPollQuestionImpl.class, eventPollQuestion.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<EventPollQuestion> eventPollQuestions) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (EventPollQuestion eventPollQuestion : eventPollQuestions) {
            EntityCacheUtil.removeResult(EventPollQuestionModelImpl.ENTITY_CACHE_ENABLED,
                EventPollQuestionImpl.class, eventPollQuestion.getPrimaryKey());
        }
    }

    /**
     * Creates a new event poll question with the primary key. Does not add the event poll question to the database.
     *
     * @param questionId the primary key for the new event poll question
     * @return the new event poll question
     */
    @Override
    public EventPollQuestion create(long questionId) {
        EventPollQuestion eventPollQuestion = new EventPollQuestionImpl();

        eventPollQuestion.setNew(true);
        eventPollQuestion.setPrimaryKey(questionId);

        return eventPollQuestion;
    }

    /**
     * Removes the event poll question with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param questionId the primary key of the event poll question
     * @return the event poll question that was removed
     * @throws com.liferay.events.global.mobile.NoSuchEventPollQuestionException if a event poll question with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EventPollQuestion remove(long questionId)
        throws NoSuchEventPollQuestionException, SystemException {
        return remove((Serializable) questionId);
    }

    /**
     * Removes the event poll question with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the event poll question
     * @return the event poll question that was removed
     * @throws com.liferay.events.global.mobile.NoSuchEventPollQuestionException if a event poll question with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EventPollQuestion remove(Serializable primaryKey)
        throws NoSuchEventPollQuestionException, SystemException {
        Session session = null;

        try {
            session = openSession();

            EventPollQuestion eventPollQuestion = (EventPollQuestion) session.get(EventPollQuestionImpl.class,
                    primaryKey);

            if (eventPollQuestion == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchEventPollQuestionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(eventPollQuestion);
        } catch (NoSuchEventPollQuestionException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected EventPollQuestion removeImpl(EventPollQuestion eventPollQuestion)
        throws SystemException {
        eventPollQuestion = toUnwrappedModel(eventPollQuestion);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(eventPollQuestion)) {
                eventPollQuestion = (EventPollQuestion) session.get(EventPollQuestionImpl.class,
                        eventPollQuestion.getPrimaryKeyObj());
            }

            if (eventPollQuestion != null) {
                session.delete(eventPollQuestion);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (eventPollQuestion != null) {
            clearCache(eventPollQuestion);
        }

        return eventPollQuestion;
    }

    @Override
    public EventPollQuestion updateImpl(
        com.liferay.events.global.mobile.model.EventPollQuestion eventPollQuestion)
        throws SystemException {
        eventPollQuestion = toUnwrappedModel(eventPollQuestion);

        boolean isNew = eventPollQuestion.isNew();

        EventPollQuestionModelImpl eventPollQuestionModelImpl = (EventPollQuestionModelImpl) eventPollQuestion;

        Session session = null;

        try {
            session = openSession();

            if (eventPollQuestion.isNew()) {
                session.save(eventPollQuestion);

                eventPollQuestion.setNew(false);
            } else {
                session.merge(eventPollQuestion);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !EventPollQuestionModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((eventPollQuestionModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTPOLLQUESTION_E.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        eventPollQuestionModelImpl.getOriginalEventId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EVENTPOLLQUESTION_E,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTPOLLQUESTION_E,
                    args);

                args = new Object[] { eventPollQuestionModelImpl.getEventId() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EVENTPOLLQUESTION_E,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTPOLLQUESTION_E,
                    args);
            }

            if ((eventPollQuestionModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTPOLLQUESTION_E_E.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        eventPollQuestionModelImpl.getOriginalEventId(),
                        eventPollQuestionModelImpl.getOriginalEnabled()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EVENTPOLLQUESTION_E_E,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTPOLLQUESTION_E_E,
                    args);

                args = new Object[] {
                        eventPollQuestionModelImpl.getEventId(),
                        eventPollQuestionModelImpl.getEnabled()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EVENTPOLLQUESTION_E_E,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTPOLLQUESTION_E_E,
                    args);
            }
        }

        EntityCacheUtil.putResult(EventPollQuestionModelImpl.ENTITY_CACHE_ENABLED,
            EventPollQuestionImpl.class, eventPollQuestion.getPrimaryKey(),
            eventPollQuestion);

        return eventPollQuestion;
    }

    protected EventPollQuestion toUnwrappedModel(
        EventPollQuestion eventPollQuestion) {
        if (eventPollQuestion instanceof EventPollQuestionImpl) {
            return eventPollQuestion;
        }

        EventPollQuestionImpl eventPollQuestionImpl = new EventPollQuestionImpl();

        eventPollQuestionImpl.setNew(eventPollQuestion.isNew());
        eventPollQuestionImpl.setPrimaryKey(eventPollQuestion.getPrimaryKey());

        eventPollQuestionImpl.setEventId(eventPollQuestion.getEventId());
        eventPollQuestionImpl.setSponsorName(eventPollQuestion.getSponsorName());
        eventPollQuestionImpl.setShortTitle(eventPollQuestion.getShortTitle());
        eventPollQuestionImpl.setQuestion(eventPollQuestion.getQuestion());
        eventPollQuestionImpl.setQuestionType(eventPollQuestion.getQuestionType());
        eventPollQuestionImpl.setChoices(eventPollQuestion.getChoices());
        eventPollQuestionImpl.setAnonymousResults(eventPollQuestion.isAnonymousResults());
        eventPollQuestionImpl.setShowResponseCount(eventPollQuestion.isShowResponseCount());
        eventPollQuestionImpl.setChartType(eventPollQuestion.getChartType());
        eventPollQuestionImpl.setAskForId(eventPollQuestion.isAskForId());
        eventPollQuestionImpl.setIdIntro(eventPollQuestion.getIdIntro());
        eventPollQuestionImpl.setCreateDate(eventPollQuestion.getCreateDate());
        eventPollQuestionImpl.setEnabled(eventPollQuestion.isEnabled());
        eventPollQuestionImpl.setAutoEnable(eventPollQuestion.isAutoEnable());
        eventPollQuestionImpl.setEnableTriggerDate(eventPollQuestion.getEnableTriggerDate());
        eventPollQuestionImpl.setEnableTriggerTimezone(eventPollQuestion.getEnableTriggerTimezone());
        eventPollQuestionImpl.setPicUrl(eventPollQuestion.getPicUrl());
        eventPollQuestionImpl.setQuestionId(eventPollQuestion.getQuestionId());

        return eventPollQuestionImpl;
    }

    /**
     * Returns the event poll question with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the event poll question
     * @return the event poll question
     * @throws com.liferay.events.global.mobile.NoSuchEventPollQuestionException if a event poll question with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EventPollQuestion findByPrimaryKey(Serializable primaryKey)
        throws NoSuchEventPollQuestionException, SystemException {
        EventPollQuestion eventPollQuestion = fetchByPrimaryKey(primaryKey);

        if (eventPollQuestion == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchEventPollQuestionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return eventPollQuestion;
    }

    /**
     * Returns the event poll question with the primary key or throws a {@link com.liferay.events.global.mobile.NoSuchEventPollQuestionException} if it could not be found.
     *
     * @param questionId the primary key of the event poll question
     * @return the event poll question
     * @throws com.liferay.events.global.mobile.NoSuchEventPollQuestionException if a event poll question with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EventPollQuestion findByPrimaryKey(long questionId)
        throws NoSuchEventPollQuestionException, SystemException {
        return findByPrimaryKey((Serializable) questionId);
    }

    /**
     * Returns the event poll question with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the event poll question
     * @return the event poll question, or <code>null</code> if a event poll question with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EventPollQuestion fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        EventPollQuestion eventPollQuestion = (EventPollQuestion) EntityCacheUtil.getResult(EventPollQuestionModelImpl.ENTITY_CACHE_ENABLED,
                EventPollQuestionImpl.class, primaryKey);

        if (eventPollQuestion == _nullEventPollQuestion) {
            return null;
        }

        if (eventPollQuestion == null) {
            Session session = null;

            try {
                session = openSession();

                eventPollQuestion = (EventPollQuestion) session.get(EventPollQuestionImpl.class,
                        primaryKey);

                if (eventPollQuestion != null) {
                    cacheResult(eventPollQuestion);
                } else {
                    EntityCacheUtil.putResult(EventPollQuestionModelImpl.ENTITY_CACHE_ENABLED,
                        EventPollQuestionImpl.class, primaryKey,
                        _nullEventPollQuestion);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(EventPollQuestionModelImpl.ENTITY_CACHE_ENABLED,
                    EventPollQuestionImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return eventPollQuestion;
    }

    /**
     * Returns the event poll question with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param questionId the primary key of the event poll question
     * @return the event poll question, or <code>null</code> if a event poll question with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EventPollQuestion fetchByPrimaryKey(long questionId)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) questionId);
    }

    /**
     * Returns all the event poll questions.
     *
     * @return the event poll questions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<EventPollQuestion> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the event poll questions.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.events.global.mobile.model.impl.EventPollQuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of event poll questions
     * @param end the upper bound of the range of event poll questions (not inclusive)
     * @return the range of event poll questions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<EventPollQuestion> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the event poll questions.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.events.global.mobile.model.impl.EventPollQuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of event poll questions
     * @param end the upper bound of the range of event poll questions (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of event poll questions
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<EventPollQuestion> findAll(int start, int end,
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

        List<EventPollQuestion> list = (List<EventPollQuestion>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_EVENTPOLLQUESTION);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_EVENTPOLLQUESTION;

                if (pagination) {
                    sql = sql.concat(EventPollQuestionModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<EventPollQuestion>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<EventPollQuestion>(list);
                } else {
                    list = (List<EventPollQuestion>) QueryUtil.list(q,
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
     * Removes all the event poll questions from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (EventPollQuestion eventPollQuestion : findAll()) {
            remove(eventPollQuestion);
        }
    }

    /**
     * Returns the number of event poll questions.
     *
     * @return the number of event poll questions
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

                Query q = session.createQuery(_SQL_COUNT_EVENTPOLLQUESTION);

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
     * Initializes the event poll question persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.liferay.events.global.mobile.model.EventPollQuestion")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<EventPollQuestion>> listenersList = new ArrayList<ModelListener<EventPollQuestion>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<EventPollQuestion>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(EventPollQuestionImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
