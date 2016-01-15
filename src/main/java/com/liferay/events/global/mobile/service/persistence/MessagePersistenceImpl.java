package com.liferay.events.global.mobile.service.persistence;

import com.liferay.events.global.mobile.NoSuchMessageException;
import com.liferay.events.global.mobile.model.Message;
import com.liferay.events.global.mobile.model.impl.MessageImpl;
import com.liferay.events.global.mobile.model.impl.MessageModelImpl;
import com.liferay.events.global.mobile.service.persistence.MessagePersistence;

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
import com.liferay.portal.kernel.util.SetUtil;
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
import java.util.Set;

/**
 * The persistence implementation for the message service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author James Falkner
 * @see MessagePersistence
 * @see MessageUtil
 * @generated
 */
public class MessagePersistenceImpl extends BasePersistenceImpl<Message>
    implements MessagePersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link MessageUtil} to access the message persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = MessageImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(MessageModelImpl.ENTITY_CACHE_ENABLED,
            MessageModelImpl.FINDER_CACHE_ENABLED, MessageImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(MessageModelImpl.ENTITY_CACHE_ENABLED,
            MessageModelImpl.FINDER_CACHE_ENABLED, MessageImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MessageModelImpl.ENTITY_CACHE_ENABLED,
            MessageModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TARGETCONTACTID_E =
        new FinderPath(MessageModelImpl.ENTITY_CACHE_ENABLED,
            MessageModelImpl.FINDER_CACHE_ENABLED, MessageImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTargetContactId_E",
            new String[] {
                String.class.getName(), Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TARGETCONTACTID_E =
        new FinderPath(MessageModelImpl.ENTITY_CACHE_ENABLED,
            MessageModelImpl.FINDER_CACHE_ENABLED, MessageImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "findByTargetContactId_E",
            new String[] { String.class.getName(), Long.class.getName() },
            MessageModelImpl.EVENTID_COLUMN_BITMASK |
            MessageModelImpl.TOID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_TARGETCONTACTID_E = new FinderPath(MessageModelImpl.ENTITY_CACHE_ENABLED,
            MessageModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByTargetContactId_E",
            new String[] { String.class.getName(), Long.class.getName() });
    private static final String _FINDER_COLUMN_TARGETCONTACTID_E_EVENTID_1 = "message.eventId IS NULL AND ";
    private static final String _FINDER_COLUMN_TARGETCONTACTID_E_EVENTID_2 = "message.eventId = ? AND ";
    private static final String _FINDER_COLUMN_TARGETCONTACTID_E_EVENTID_3 = "(message.eventId IS NULL OR message.eventId = '') AND ";
    private static final String _FINDER_COLUMN_TARGETCONTACTID_E_TOID_2 = "message.toId = ?";
    private static final String _SQL_SELECT_MESSAGE = "SELECT message FROM Message message";
    private static final String _SQL_SELECT_MESSAGE_WHERE = "SELECT message FROM Message message WHERE ";
    private static final String _SQL_COUNT_MESSAGE = "SELECT COUNT(message) FROM Message message";
    private static final String _SQL_COUNT_MESSAGE_WHERE = "SELECT COUNT(message) FROM Message message WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "message.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Message exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Message exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(MessagePersistenceImpl.class);
    private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
                "read"
            });
    private static Message _nullMessage = new MessageImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Message> toCacheModel() {
                return _nullMessageCacheModel;
            }
        };

    private static CacheModel<Message> _nullMessageCacheModel = new CacheModel<Message>() {
            @Override
            public Message toEntityModel() {
                return _nullMessage;
            }
        };

    public MessagePersistenceImpl() {
        setModelClass(Message.class);
    }

    /**
     * Returns all the messages where eventId = &#63; and toId = &#63;.
     *
     * @param eventId the event ID
     * @param toId the to ID
     * @return the matching messages
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Message> findByTargetContactId_E(String eventId, long toId)
        throws SystemException {
        return findByTargetContactId_E(eventId, toId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the messages where eventId = &#63; and toId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.events.global.mobile.model.impl.MessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param eventId the event ID
     * @param toId the to ID
     * @param start the lower bound of the range of messages
     * @param end the upper bound of the range of messages (not inclusive)
     * @return the range of matching messages
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Message> findByTargetContactId_E(String eventId, long toId,
        int start, int end) throws SystemException {
        return findByTargetContactId_E(eventId, toId, start, end, null);
    }

    /**
     * Returns an ordered range of all the messages where eventId = &#63; and toId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.events.global.mobile.model.impl.MessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param eventId the event ID
     * @param toId the to ID
     * @param start the lower bound of the range of messages
     * @param end the upper bound of the range of messages (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching messages
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Message> findByTargetContactId_E(String eventId, long toId,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TARGETCONTACTID_E;
            finderArgs = new Object[] { eventId, toId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TARGETCONTACTID_E;
            finderArgs = new Object[] {
                    eventId, toId,
                    
                    start, end, orderByComparator
                };
        }

        List<Message> list = (List<Message>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Message message : list) {
                if (!Validator.equals(eventId, message.getEventId()) ||
                        (toId != message.getToId())) {
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

            query.append(_SQL_SELECT_MESSAGE_WHERE);

            boolean bindEventId = false;

            if (eventId == null) {
                query.append(_FINDER_COLUMN_TARGETCONTACTID_E_EVENTID_1);
            } else if (eventId.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_TARGETCONTACTID_E_EVENTID_3);
            } else {
                bindEventId = true;

                query.append(_FINDER_COLUMN_TARGETCONTACTID_E_EVENTID_2);
            }

            query.append(_FINDER_COLUMN_TARGETCONTACTID_E_TOID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(MessageModelImpl.ORDER_BY_JPQL);
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

                qPos.add(toId);

                if (!pagination) {
                    list = (List<Message>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Message>(list);
                } else {
                    list = (List<Message>) QueryUtil.list(q, getDialect(),
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
     * Returns the first message in the ordered set where eventId = &#63; and toId = &#63;.
     *
     * @param eventId the event ID
     * @param toId the to ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching message
     * @throws com.liferay.events.global.mobile.NoSuchMessageException if a matching message could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Message findByTargetContactId_E_First(String eventId, long toId,
        OrderByComparator orderByComparator)
        throws NoSuchMessageException, SystemException {
        Message message = fetchByTargetContactId_E_First(eventId, toId,
                orderByComparator);

        if (message != null) {
            return message;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("eventId=");
        msg.append(eventId);

        msg.append(", toId=");
        msg.append(toId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchMessageException(msg.toString());
    }

    /**
     * Returns the first message in the ordered set where eventId = &#63; and toId = &#63;.
     *
     * @param eventId the event ID
     * @param toId the to ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching message, or <code>null</code> if a matching message could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Message fetchByTargetContactId_E_First(String eventId, long toId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Message> list = findByTargetContactId_E(eventId, toId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last message in the ordered set where eventId = &#63; and toId = &#63;.
     *
     * @param eventId the event ID
     * @param toId the to ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching message
     * @throws com.liferay.events.global.mobile.NoSuchMessageException if a matching message could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Message findByTargetContactId_E_Last(String eventId, long toId,
        OrderByComparator orderByComparator)
        throws NoSuchMessageException, SystemException {
        Message message = fetchByTargetContactId_E_Last(eventId, toId,
                orderByComparator);

        if (message != null) {
            return message;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("eventId=");
        msg.append(eventId);

        msg.append(", toId=");
        msg.append(toId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchMessageException(msg.toString());
    }

    /**
     * Returns the last message in the ordered set where eventId = &#63; and toId = &#63;.
     *
     * @param eventId the event ID
     * @param toId the to ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching message, or <code>null</code> if a matching message could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Message fetchByTargetContactId_E_Last(String eventId, long toId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByTargetContactId_E(eventId, toId);

        if (count == 0) {
            return null;
        }

        List<Message> list = findByTargetContactId_E(eventId, toId, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the messages before and after the current message in the ordered set where eventId = &#63; and toId = &#63;.
     *
     * @param messageId the primary key of the current message
     * @param eventId the event ID
     * @param toId the to ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next message
     * @throws com.liferay.events.global.mobile.NoSuchMessageException if a message with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Message[] findByTargetContactId_E_PrevAndNext(long messageId,
        String eventId, long toId, OrderByComparator orderByComparator)
        throws NoSuchMessageException, SystemException {
        Message message = findByPrimaryKey(messageId);

        Session session = null;

        try {
            session = openSession();

            Message[] array = new MessageImpl[3];

            array[0] = getByTargetContactId_E_PrevAndNext(session, message,
                    eventId, toId, orderByComparator, true);

            array[1] = message;

            array[2] = getByTargetContactId_E_PrevAndNext(session, message,
                    eventId, toId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Message getByTargetContactId_E_PrevAndNext(Session session,
        Message message, String eventId, long toId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_MESSAGE_WHERE);

        boolean bindEventId = false;

        if (eventId == null) {
            query.append(_FINDER_COLUMN_TARGETCONTACTID_E_EVENTID_1);
        } else if (eventId.equals(StringPool.BLANK)) {
            query.append(_FINDER_COLUMN_TARGETCONTACTID_E_EVENTID_3);
        } else {
            bindEventId = true;

            query.append(_FINDER_COLUMN_TARGETCONTACTID_E_EVENTID_2);
        }

        query.append(_FINDER_COLUMN_TARGETCONTACTID_E_TOID_2);

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
            query.append(MessageModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (bindEventId) {
            qPos.add(eventId);
        }

        qPos.add(toId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(message);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Message> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the messages where eventId = &#63; and toId = &#63; from the database.
     *
     * @param eventId the event ID
     * @param toId the to ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByTargetContactId_E(String eventId, long toId)
        throws SystemException {
        for (Message message : findByTargetContactId_E(eventId, toId,
                QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(message);
        }
    }

    /**
     * Returns the number of messages where eventId = &#63; and toId = &#63;.
     *
     * @param eventId the event ID
     * @param toId the to ID
     * @return the number of matching messages
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByTargetContactId_E(String eventId, long toId)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_TARGETCONTACTID_E;

        Object[] finderArgs = new Object[] { eventId, toId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_MESSAGE_WHERE);

            boolean bindEventId = false;

            if (eventId == null) {
                query.append(_FINDER_COLUMN_TARGETCONTACTID_E_EVENTID_1);
            } else if (eventId.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_TARGETCONTACTID_E_EVENTID_3);
            } else {
                bindEventId = true;

                query.append(_FINDER_COLUMN_TARGETCONTACTID_E_EVENTID_2);
            }

            query.append(_FINDER_COLUMN_TARGETCONTACTID_E_TOID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindEventId) {
                    qPos.add(eventId);
                }

                qPos.add(toId);

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
     * Caches the message in the entity cache if it is enabled.
     *
     * @param message the message
     */
    @Override
    public void cacheResult(Message message) {
        EntityCacheUtil.putResult(MessageModelImpl.ENTITY_CACHE_ENABLED,
            MessageImpl.class, message.getPrimaryKey(), message);

        message.resetOriginalValues();
    }

    /**
     * Caches the messages in the entity cache if it is enabled.
     *
     * @param messages the messages
     */
    @Override
    public void cacheResult(List<Message> messages) {
        for (Message message : messages) {
            if (EntityCacheUtil.getResult(
                        MessageModelImpl.ENTITY_CACHE_ENABLED,
                        MessageImpl.class, message.getPrimaryKey()) == null) {
                cacheResult(message);
            } else {
                message.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all messages.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(MessageImpl.class.getName());
        }

        EntityCacheUtil.clearCache(MessageImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the message.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Message message) {
        EntityCacheUtil.removeResult(MessageModelImpl.ENTITY_CACHE_ENABLED,
            MessageImpl.class, message.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<Message> messages) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Message message : messages) {
            EntityCacheUtil.removeResult(MessageModelImpl.ENTITY_CACHE_ENABLED,
                MessageImpl.class, message.getPrimaryKey());
        }
    }

    /**
     * Creates a new message with the primary key. Does not add the message to the database.
     *
     * @param messageId the primary key for the new message
     * @return the new message
     */
    @Override
    public Message create(long messageId) {
        Message message = new MessageImpl();

        message.setNew(true);
        message.setPrimaryKey(messageId);

        return message;
    }

    /**
     * Removes the message with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param messageId the primary key of the message
     * @return the message that was removed
     * @throws com.liferay.events.global.mobile.NoSuchMessageException if a message with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Message remove(long messageId)
        throws NoSuchMessageException, SystemException {
        return remove((Serializable) messageId);
    }

    /**
     * Removes the message with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the message
     * @return the message that was removed
     * @throws com.liferay.events.global.mobile.NoSuchMessageException if a message with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Message remove(Serializable primaryKey)
        throws NoSuchMessageException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Message message = (Message) session.get(MessageImpl.class,
                    primaryKey);

            if (message == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchMessageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(message);
        } catch (NoSuchMessageException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Message removeImpl(Message message) throws SystemException {
        message = toUnwrappedModel(message);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(message)) {
                message = (Message) session.get(MessageImpl.class,
                        message.getPrimaryKeyObj());
            }

            if (message != null) {
                session.delete(message);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (message != null) {
            clearCache(message);
        }

        return message;
    }

    @Override
    public Message updateImpl(
        com.liferay.events.global.mobile.model.Message message)
        throws SystemException {
        message = toUnwrappedModel(message);

        boolean isNew = message.isNew();

        MessageModelImpl messageModelImpl = (MessageModelImpl) message;

        Session session = null;

        try {
            session = openSession();

            if (message.isNew()) {
                session.save(message);

                message.setNew(false);
            } else {
                session.merge(message);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !MessageModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((messageModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TARGETCONTACTID_E.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        messageModelImpl.getOriginalEventId(),
                        messageModelImpl.getOriginalToId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TARGETCONTACTID_E,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TARGETCONTACTID_E,
                    args);

                args = new Object[] {
                        messageModelImpl.getEventId(),
                        messageModelImpl.getToId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TARGETCONTACTID_E,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TARGETCONTACTID_E,
                    args);
            }
        }

        EntityCacheUtil.putResult(MessageModelImpl.ENTITY_CACHE_ENABLED,
            MessageImpl.class, message.getPrimaryKey(), message);

        return message;
    }

    protected Message toUnwrappedModel(Message message) {
        if (message instanceof MessageImpl) {
            return message;
        }

        MessageImpl messageImpl = new MessageImpl();

        messageImpl.setNew(message.isNew());
        messageImpl.setPrimaryKey(message.getPrimaryKey());

        messageImpl.setFromId(message.getFromId());
        messageImpl.setToId(message.getToId());
        messageImpl.setContent(message.getContent());
        messageImpl.setRead(message.isRead());
        messageImpl.setEventId(message.getEventId());
        messageImpl.setMessageId(message.getMessageId());
        messageImpl.setGroupId(message.getGroupId());
        messageImpl.setCompanyId(message.getCompanyId());
        messageImpl.setUserId(message.getUserId());
        messageImpl.setUserName(message.getUserName());
        messageImpl.setCreateDate(message.getCreateDate());
        messageImpl.setModifiedDate(message.getModifiedDate());

        return messageImpl;
    }

    /**
     * Returns the message with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the message
     * @return the message
     * @throws com.liferay.events.global.mobile.NoSuchMessageException if a message with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Message findByPrimaryKey(Serializable primaryKey)
        throws NoSuchMessageException, SystemException {
        Message message = fetchByPrimaryKey(primaryKey);

        if (message == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchMessageException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return message;
    }

    /**
     * Returns the message with the primary key or throws a {@link com.liferay.events.global.mobile.NoSuchMessageException} if it could not be found.
     *
     * @param messageId the primary key of the message
     * @return the message
     * @throws com.liferay.events.global.mobile.NoSuchMessageException if a message with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Message findByPrimaryKey(long messageId)
        throws NoSuchMessageException, SystemException {
        return findByPrimaryKey((Serializable) messageId);
    }

    /**
     * Returns the message with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the message
     * @return the message, or <code>null</code> if a message with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Message fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Message message = (Message) EntityCacheUtil.getResult(MessageModelImpl.ENTITY_CACHE_ENABLED,
                MessageImpl.class, primaryKey);

        if (message == _nullMessage) {
            return null;
        }

        if (message == null) {
            Session session = null;

            try {
                session = openSession();

                message = (Message) session.get(MessageImpl.class, primaryKey);

                if (message != null) {
                    cacheResult(message);
                } else {
                    EntityCacheUtil.putResult(MessageModelImpl.ENTITY_CACHE_ENABLED,
                        MessageImpl.class, primaryKey, _nullMessage);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(MessageModelImpl.ENTITY_CACHE_ENABLED,
                    MessageImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return message;
    }

    /**
     * Returns the message with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param messageId the primary key of the message
     * @return the message, or <code>null</code> if a message with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Message fetchByPrimaryKey(long messageId) throws SystemException {
        return fetchByPrimaryKey((Serializable) messageId);
    }

    /**
     * Returns all the messages.
     *
     * @return the messages
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Message> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the messages.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.events.global.mobile.model.impl.MessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of messages
     * @param end the upper bound of the range of messages (not inclusive)
     * @return the range of messages
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Message> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the messages.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.events.global.mobile.model.impl.MessageModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of messages
     * @param end the upper bound of the range of messages (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of messages
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Message> findAll(int start, int end,
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

        List<Message> list = (List<Message>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_MESSAGE);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_MESSAGE;

                if (pagination) {
                    sql = sql.concat(MessageModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Message>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Message>(list);
                } else {
                    list = (List<Message>) QueryUtil.list(q, getDialect(),
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
     * Removes all the messages from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Message message : findAll()) {
            remove(message);
        }
    }

    /**
     * Returns the number of messages.
     *
     * @return the number of messages
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

                Query q = session.createQuery(_SQL_COUNT_MESSAGE);

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

    @Override
    protected Set<String> getBadColumnNames() {
        return _badColumnNames;
    }

    /**
     * Initializes the message persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.liferay.events.global.mobile.model.Message")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Message>> listenersList = new ArrayList<ModelListener<Message>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Message>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(MessageImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
