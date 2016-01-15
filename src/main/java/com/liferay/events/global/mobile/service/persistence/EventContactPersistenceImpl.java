package com.liferay.events.global.mobile.service.persistence;

import com.liferay.events.global.mobile.NoSuchEventContactException;
import com.liferay.events.global.mobile.model.EventContact;
import com.liferay.events.global.mobile.model.impl.EventContactImpl;
import com.liferay.events.global.mobile.model.impl.EventContactModelImpl;
import com.liferay.events.global.mobile.service.persistence.EventContactPersistence;

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
import com.liferay.portal.kernel.util.ArrayUtil;
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
 * The persistence implementation for the event contact service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author James Falkner
 * @see EventContactPersistence
 * @see EventContactUtil
 * @generated
 */
public class EventContactPersistenceImpl extends BasePersistenceImpl<EventContact>
    implements EventContactPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link EventContactUtil} to access the event contact persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = EventContactImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EventContactModelImpl.ENTITY_CACHE_ENABLED,
            EventContactModelImpl.FINDER_CACHE_ENABLED, EventContactImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EventContactModelImpl.ENTITY_CACHE_ENABLED,
            EventContactModelImpl.FINDER_CACHE_ENABLED, EventContactImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EventContactModelImpl.ENTITY_CACHE_ENABLED,
            EventContactModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_FETCH_BY_E_V = new FinderPath(EventContactModelImpl.ENTITY_CACHE_ENABLED,
            EventContactModelImpl.FINDER_CACHE_ENABLED, EventContactImpl.class,
            FINDER_CLASS_NAME_ENTITY, "fetchByE_V",
            new String[] { Long.class.getName(), Boolean.class.getName() },
            EventContactModelImpl.EVENTCONTACTID_COLUMN_BITMASK |
            EventContactModelImpl.VERIFIED_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_E_V = new FinderPath(EventContactModelImpl.ENTITY_CACHE_ENABLED,
            EventContactModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByE_V",
            new String[] { Long.class.getName(), Boolean.class.getName() });
    private static final String _FINDER_COLUMN_E_V_EVENTCONTACTID_2 = "eventContact.eventContactId = ? AND ";
    private static final String _FINDER_COLUMN_E_V_VERIFIED_2 = "eventContact.verified = ?";
    public static final FinderPath FINDER_PATH_FETCH_BY_EMAILADDRESS_E_V = new FinderPath(EventContactModelImpl.ENTITY_CACHE_ENABLED,
            EventContactModelImpl.FINDER_CACHE_ENABLED, EventContactImpl.class,
            FINDER_CLASS_NAME_ENTITY, "fetchByEmailAddress_E_V",
            new String[] {
                String.class.getName(), String.class.getName(),
                Boolean.class.getName()
            },
            EventContactModelImpl.EVENTID_COLUMN_BITMASK |
            EventContactModelImpl.EMAILADDRESS_COLUMN_BITMASK |
            EventContactModelImpl.VERIFIED_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_EMAILADDRESS_E_V = new FinderPath(EventContactModelImpl.ENTITY_CACHE_ENABLED,
            EventContactModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByEmailAddress_E_V",
            new String[] {
                String.class.getName(), String.class.getName(),
                Boolean.class.getName()
            });
    private static final String _FINDER_COLUMN_EMAILADDRESS_E_V_EVENTID_1 = "eventContact.eventId IS NULL AND ";
    private static final String _FINDER_COLUMN_EMAILADDRESS_E_V_EVENTID_2 = "eventContact.eventId = ? AND ";
    private static final String _FINDER_COLUMN_EMAILADDRESS_E_V_EVENTID_3 = "(eventContact.eventId IS NULL OR eventContact.eventId = '') AND ";
    private static final String _FINDER_COLUMN_EMAILADDRESS_E_V_EMAILADDRESS_1 = "eventContact.emailAddress IS NULL AND ";
    private static final String _FINDER_COLUMN_EMAILADDRESS_E_V_EMAILADDRESS_2 = "eventContact.emailAddress = ? AND ";
    private static final String _FINDER_COLUMN_EMAILADDRESS_E_V_EMAILADDRESS_3 = "(eventContact.emailAddress IS NULL OR eventContact.emailAddress = '') AND ";
    private static final String _FINDER_COLUMN_EMAILADDRESS_E_V_VERIFIED_2 = "eventContact.verified = ?";
    public static final FinderPath FINDER_PATH_FETCH_BY_EMAILADDRESS_E = new FinderPath(EventContactModelImpl.ENTITY_CACHE_ENABLED,
            EventContactModelImpl.FINDER_CACHE_ENABLED, EventContactImpl.class,
            FINDER_CLASS_NAME_ENTITY, "fetchByEmailAddress_E",
            new String[] { String.class.getName(), String.class.getName() },
            EventContactModelImpl.EVENTID_COLUMN_BITMASK |
            EventContactModelImpl.EMAILADDRESS_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_EMAILADDRESS_E = new FinderPath(EventContactModelImpl.ENTITY_CACHE_ENABLED,
            EventContactModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEmailAddress_E",
            new String[] { String.class.getName(), String.class.getName() });
    private static final String _FINDER_COLUMN_EMAILADDRESS_E_EVENTID_1 = "eventContact.eventId IS NULL AND ";
    private static final String _FINDER_COLUMN_EMAILADDRESS_E_EVENTID_2 = "eventContact.eventId = ? AND ";
    private static final String _FINDER_COLUMN_EMAILADDRESS_E_EVENTID_3 = "(eventContact.eventId IS NULL OR eventContact.eventId = '') AND ";
    private static final String _FINDER_COLUMN_EMAILADDRESS_E_EMAILADDRESS_1 = "eventContact.emailAddress IS NULL";
    private static final String _FINDER_COLUMN_EMAILADDRESS_E_EMAILADDRESS_2 = "eventContact.emailAddress = ?";
    private static final String _FINDER_COLUMN_EMAILADDRESS_E_EMAILADDRESS_3 = "(eventContact.emailAddress IS NULL OR eventContact.emailAddress = '')";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NOTINTERESTED_E_V =
        new FinderPath(EventContactModelImpl.ENTITY_CACHE_ENABLED,
            EventContactModelImpl.FINDER_CACHE_ENABLED, EventContactImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByNotInterested_E_V",
            new String[] {
                String.class.getName(), Boolean.class.getName(),
                Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_NOTINTERESTED_E_V =
        new FinderPath(EventContactModelImpl.ENTITY_CACHE_ENABLED,
            EventContactModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByNotInterested_E_V",
            new String[] {
                String.class.getName(), Boolean.class.getName(),
                Long.class.getName()
            });
    private static final String _FINDER_COLUMN_NOTINTERESTED_E_V_EVENTID_1 = "eventContact.eventId IS NULL AND ";
    private static final String _FINDER_COLUMN_NOTINTERESTED_E_V_EVENTID_2 = "eventContact.eventId = ? AND ";
    private static final String _FINDER_COLUMN_NOTINTERESTED_E_V_EVENTID_3 = "(eventContact.eventId IS NULL OR eventContact.eventId = '') AND ";
    private static final String _FINDER_COLUMN_NOTINTERESTED_E_V_EVENTID_4 = "(" +
        removeConjunction(_FINDER_COLUMN_NOTINTERESTED_E_V_EVENTID_1) + ")";
    private static final String _FINDER_COLUMN_NOTINTERESTED_E_V_EVENTID_5 = "(" +
        removeConjunction(_FINDER_COLUMN_NOTINTERESTED_E_V_EVENTID_2) + ")";
    private static final String _FINDER_COLUMN_NOTINTERESTED_E_V_EVENTID_6 = "(" +
        removeConjunction(_FINDER_COLUMN_NOTINTERESTED_E_V_EVENTID_3) + ")";
    private static final String _FINDER_COLUMN_NOTINTERESTED_E_V_VERIFIED_2 = "eventContact.verified = ? AND ";
    private static final String _FINDER_COLUMN_NOTINTERESTED_E_V_VERIFIED_5 = "(" +
        removeConjunction(_FINDER_COLUMN_NOTINTERESTED_E_V_VERIFIED_2) + ")";
    private static final String _FINDER_COLUMN_NOTINTERESTED_E_V_EVENTCONTACTID_2 =
        "eventContact.eventContactId != ?";
    private static final String _FINDER_COLUMN_NOTINTERESTED_E_V_EVENTCONTACTID_5 =
        "(" +
        removeConjunction(_FINDER_COLUMN_NOTINTERESTED_E_V_EVENTCONTACTID_2) +
        ")";
    private static final String _SQL_SELECT_EVENTCONTACT = "SELECT eventContact FROM EventContact eventContact";
    private static final String _SQL_SELECT_EVENTCONTACT_WHERE = "SELECT eventContact FROM EventContact eventContact WHERE ";
    private static final String _SQL_COUNT_EVENTCONTACT = "SELECT COUNT(eventContact) FROM EventContact eventContact";
    private static final String _SQL_COUNT_EVENTCONTACT_WHERE = "SELECT COUNT(eventContact) FROM EventContact eventContact WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "eventContact.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No EventContact exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No EventContact exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(EventContactPersistenceImpl.class);
    private static EventContact _nullEventContact = new EventContactImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<EventContact> toCacheModel() {
                return _nullEventContactCacheModel;
            }
        };

    private static CacheModel<EventContact> _nullEventContactCacheModel = new CacheModel<EventContact>() {
            @Override
            public EventContact toEntityModel() {
                return _nullEventContact;
            }
        };

    public EventContactPersistenceImpl() {
        setModelClass(EventContact.class);
    }

    /**
     * Returns the event contact where eventContactId = &#63; and verified = &#63; or throws a {@link com.liferay.events.global.mobile.NoSuchEventContactException} if it could not be found.
     *
     * @param eventContactId the event contact ID
     * @param verified the verified
     * @return the matching event contact
     * @throws com.liferay.events.global.mobile.NoSuchEventContactException if a matching event contact could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EventContact findByE_V(long eventContactId, boolean verified)
        throws NoSuchEventContactException, SystemException {
        EventContact eventContact = fetchByE_V(eventContactId, verified);

        if (eventContact == null) {
            StringBundler msg = new StringBundler(6);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("eventContactId=");
            msg.append(eventContactId);

            msg.append(", verified=");
            msg.append(verified);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchEventContactException(msg.toString());
        }

        return eventContact;
    }

    /**
     * Returns the event contact where eventContactId = &#63; and verified = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param eventContactId the event contact ID
     * @param verified the verified
     * @return the matching event contact, or <code>null</code> if a matching event contact could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EventContact fetchByE_V(long eventContactId, boolean verified)
        throws SystemException {
        return fetchByE_V(eventContactId, verified, true);
    }

    /**
     * Returns the event contact where eventContactId = &#63; and verified = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param eventContactId the event contact ID
     * @param verified the verified
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching event contact, or <code>null</code> if a matching event contact could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EventContact fetchByE_V(long eventContactId, boolean verified,
        boolean retrieveFromCache) throws SystemException {
        Object[] finderArgs = new Object[] { eventContactId, verified };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_E_V,
                    finderArgs, this);
        }

        if (result instanceof EventContact) {
            EventContact eventContact = (EventContact) result;

            if ((eventContactId != eventContact.getEventContactId()) ||
                    (verified != eventContact.getVerified())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(4);

            query.append(_SQL_SELECT_EVENTCONTACT_WHERE);

            query.append(_FINDER_COLUMN_E_V_EVENTCONTACTID_2);

            query.append(_FINDER_COLUMN_E_V_VERIFIED_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(eventContactId);

                qPos.add(verified);

                List<EventContact> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_E_V,
                        finderArgs, list);
                } else {
                    if ((list.size() > 1) && _log.isWarnEnabled()) {
                        _log.warn(
                            "EventContactPersistenceImpl.fetchByE_V(long, boolean, boolean) with parameters (" +
                            StringUtil.merge(finderArgs) +
                            ") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
                    }

                    EventContact eventContact = list.get(0);

                    result = eventContact;

                    cacheResult(eventContact);

                    if ((eventContact.getEventContactId() != eventContactId) ||
                            (eventContact.getVerified() != verified)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_E_V,
                            finderArgs, eventContact);
                    }
                }
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_E_V,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        if (result instanceof List<?>) {
            return null;
        } else {
            return (EventContact) result;
        }
    }

    /**
     * Removes the event contact where eventContactId = &#63; and verified = &#63; from the database.
     *
     * @param eventContactId the event contact ID
     * @param verified the verified
     * @return the event contact that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EventContact removeByE_V(long eventContactId, boolean verified)
        throws NoSuchEventContactException, SystemException {
        EventContact eventContact = findByE_V(eventContactId, verified);

        return remove(eventContact);
    }

    /**
     * Returns the number of event contacts where eventContactId = &#63; and verified = &#63;.
     *
     * @param eventContactId the event contact ID
     * @param verified the verified
     * @return the number of matching event contacts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByE_V(long eventContactId, boolean verified)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_E_V;

        Object[] finderArgs = new Object[] { eventContactId, verified };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_EVENTCONTACT_WHERE);

            query.append(_FINDER_COLUMN_E_V_EVENTCONTACTID_2);

            query.append(_FINDER_COLUMN_E_V_VERIFIED_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(eventContactId);

                qPos.add(verified);

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
     * Returns the event contact where eventId = &#63; and emailAddress = &#63; and verified = &#63; or throws a {@link com.liferay.events.global.mobile.NoSuchEventContactException} if it could not be found.
     *
     * @param eventId the event ID
     * @param emailAddress the email address
     * @param verified the verified
     * @return the matching event contact
     * @throws com.liferay.events.global.mobile.NoSuchEventContactException if a matching event contact could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EventContact findByEmailAddress_E_V(String eventId,
        String emailAddress, boolean verified)
        throws NoSuchEventContactException, SystemException {
        EventContact eventContact = fetchByEmailAddress_E_V(eventId,
                emailAddress, verified);

        if (eventContact == null) {
            StringBundler msg = new StringBundler(8);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("eventId=");
            msg.append(eventId);

            msg.append(", emailAddress=");
            msg.append(emailAddress);

            msg.append(", verified=");
            msg.append(verified);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchEventContactException(msg.toString());
        }

        return eventContact;
    }

    /**
     * Returns the event contact where eventId = &#63; and emailAddress = &#63; and verified = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param eventId the event ID
     * @param emailAddress the email address
     * @param verified the verified
     * @return the matching event contact, or <code>null</code> if a matching event contact could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EventContact fetchByEmailAddress_E_V(String eventId,
        String emailAddress, boolean verified) throws SystemException {
        return fetchByEmailAddress_E_V(eventId, emailAddress, verified, true);
    }

    /**
     * Returns the event contact where eventId = &#63; and emailAddress = &#63; and verified = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param eventId the event ID
     * @param emailAddress the email address
     * @param verified the verified
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching event contact, or <code>null</code> if a matching event contact could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EventContact fetchByEmailAddress_E_V(String eventId,
        String emailAddress, boolean verified, boolean retrieveFromCache)
        throws SystemException {
        Object[] finderArgs = new Object[] { eventId, emailAddress, verified };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_EMAILADDRESS_E_V,
                    finderArgs, this);
        }

        if (result instanceof EventContact) {
            EventContact eventContact = (EventContact) result;

            if (!Validator.equals(eventId, eventContact.getEventId()) ||
                    !Validator.equals(emailAddress,
                        eventContact.getEmailAddress()) ||
                    (verified != eventContact.getVerified())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(5);

            query.append(_SQL_SELECT_EVENTCONTACT_WHERE);

            boolean bindEventId = false;

            if (eventId == null) {
                query.append(_FINDER_COLUMN_EMAILADDRESS_E_V_EVENTID_1);
            } else if (eventId.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_EMAILADDRESS_E_V_EVENTID_3);
            } else {
                bindEventId = true;

                query.append(_FINDER_COLUMN_EMAILADDRESS_E_V_EVENTID_2);
            }

            boolean bindEmailAddress = false;

            if (emailAddress == null) {
                query.append(_FINDER_COLUMN_EMAILADDRESS_E_V_EMAILADDRESS_1);
            } else if (emailAddress.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_EMAILADDRESS_E_V_EMAILADDRESS_3);
            } else {
                bindEmailAddress = true;

                query.append(_FINDER_COLUMN_EMAILADDRESS_E_V_EMAILADDRESS_2);
            }

            query.append(_FINDER_COLUMN_EMAILADDRESS_E_V_VERIFIED_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindEventId) {
                    qPos.add(eventId);
                }

                if (bindEmailAddress) {
                    qPos.add(emailAddress);
                }

                qPos.add(verified);

                List<EventContact> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAILADDRESS_E_V,
                        finderArgs, list);
                } else {
                    if ((list.size() > 1) && _log.isWarnEnabled()) {
                        _log.warn(
                            "EventContactPersistenceImpl.fetchByEmailAddress_E_V(String, String, boolean, boolean) with parameters (" +
                            StringUtil.merge(finderArgs) +
                            ") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
                    }

                    EventContact eventContact = list.get(0);

                    result = eventContact;

                    cacheResult(eventContact);

                    if ((eventContact.getEventId() == null) ||
                            !eventContact.getEventId().equals(eventId) ||
                            (eventContact.getEmailAddress() == null) ||
                            !eventContact.getEmailAddress().equals(emailAddress) ||
                            (eventContact.getVerified() != verified)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAILADDRESS_E_V,
                            finderArgs, eventContact);
                    }
                }
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EMAILADDRESS_E_V,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        if (result instanceof List<?>) {
            return null;
        } else {
            return (EventContact) result;
        }
    }

    /**
     * Removes the event contact where eventId = &#63; and emailAddress = &#63; and verified = &#63; from the database.
     *
     * @param eventId the event ID
     * @param emailAddress the email address
     * @param verified the verified
     * @return the event contact that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EventContact removeByEmailAddress_E_V(String eventId,
        String emailAddress, boolean verified)
        throws NoSuchEventContactException, SystemException {
        EventContact eventContact = findByEmailAddress_E_V(eventId,
                emailAddress, verified);

        return remove(eventContact);
    }

    /**
     * Returns the number of event contacts where eventId = &#63; and emailAddress = &#63; and verified = &#63;.
     *
     * @param eventId the event ID
     * @param emailAddress the email address
     * @param verified the verified
     * @return the number of matching event contacts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByEmailAddress_E_V(String eventId, String emailAddress,
        boolean verified) throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_EMAILADDRESS_E_V;

        Object[] finderArgs = new Object[] { eventId, emailAddress, verified };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(4);

            query.append(_SQL_COUNT_EVENTCONTACT_WHERE);

            boolean bindEventId = false;

            if (eventId == null) {
                query.append(_FINDER_COLUMN_EMAILADDRESS_E_V_EVENTID_1);
            } else if (eventId.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_EMAILADDRESS_E_V_EVENTID_3);
            } else {
                bindEventId = true;

                query.append(_FINDER_COLUMN_EMAILADDRESS_E_V_EVENTID_2);
            }

            boolean bindEmailAddress = false;

            if (emailAddress == null) {
                query.append(_FINDER_COLUMN_EMAILADDRESS_E_V_EMAILADDRESS_1);
            } else if (emailAddress.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_EMAILADDRESS_E_V_EMAILADDRESS_3);
            } else {
                bindEmailAddress = true;

                query.append(_FINDER_COLUMN_EMAILADDRESS_E_V_EMAILADDRESS_2);
            }

            query.append(_FINDER_COLUMN_EMAILADDRESS_E_V_VERIFIED_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindEventId) {
                    qPos.add(eventId);
                }

                if (bindEmailAddress) {
                    qPos.add(emailAddress);
                }

                qPos.add(verified);

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
     * Returns the event contact where eventId = &#63; and emailAddress = &#63; or throws a {@link com.liferay.events.global.mobile.NoSuchEventContactException} if it could not be found.
     *
     * @param eventId the event ID
     * @param emailAddress the email address
     * @return the matching event contact
     * @throws com.liferay.events.global.mobile.NoSuchEventContactException if a matching event contact could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EventContact findByEmailAddress_E(String eventId, String emailAddress)
        throws NoSuchEventContactException, SystemException {
        EventContact eventContact = fetchByEmailAddress_E(eventId, emailAddress);

        if (eventContact == null) {
            StringBundler msg = new StringBundler(6);

            msg.append(_NO_SUCH_ENTITY_WITH_KEY);

            msg.append("eventId=");
            msg.append(eventId);

            msg.append(", emailAddress=");
            msg.append(emailAddress);

            msg.append(StringPool.CLOSE_CURLY_BRACE);

            if (_log.isWarnEnabled()) {
                _log.warn(msg.toString());
            }

            throw new NoSuchEventContactException(msg.toString());
        }

        return eventContact;
    }

    /**
     * Returns the event contact where eventId = &#63; and emailAddress = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
     *
     * @param eventId the event ID
     * @param emailAddress the email address
     * @return the matching event contact, or <code>null</code> if a matching event contact could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EventContact fetchByEmailAddress_E(String eventId,
        String emailAddress) throws SystemException {
        return fetchByEmailAddress_E(eventId, emailAddress, true);
    }

    /**
     * Returns the event contact where eventId = &#63; and emailAddress = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
     *
     * @param eventId the event ID
     * @param emailAddress the email address
     * @param retrieveFromCache whether to use the finder cache
     * @return the matching event contact, or <code>null</code> if a matching event contact could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EventContact fetchByEmailAddress_E(String eventId,
        String emailAddress, boolean retrieveFromCache)
        throws SystemException {
        Object[] finderArgs = new Object[] { eventId, emailAddress };

        Object result = null;

        if (retrieveFromCache) {
            result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_EMAILADDRESS_E,
                    finderArgs, this);
        }

        if (result instanceof EventContact) {
            EventContact eventContact = (EventContact) result;

            if (!Validator.equals(eventId, eventContact.getEventId()) ||
                    !Validator.equals(emailAddress,
                        eventContact.getEmailAddress())) {
                result = null;
            }
        }

        if (result == null) {
            StringBundler query = new StringBundler(4);

            query.append(_SQL_SELECT_EVENTCONTACT_WHERE);

            boolean bindEventId = false;

            if (eventId == null) {
                query.append(_FINDER_COLUMN_EMAILADDRESS_E_EVENTID_1);
            } else if (eventId.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_EMAILADDRESS_E_EVENTID_3);
            } else {
                bindEventId = true;

                query.append(_FINDER_COLUMN_EMAILADDRESS_E_EVENTID_2);
            }

            boolean bindEmailAddress = false;

            if (emailAddress == null) {
                query.append(_FINDER_COLUMN_EMAILADDRESS_E_EMAILADDRESS_1);
            } else if (emailAddress.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_EMAILADDRESS_E_EMAILADDRESS_3);
            } else {
                bindEmailAddress = true;

                query.append(_FINDER_COLUMN_EMAILADDRESS_E_EMAILADDRESS_2);
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

                if (bindEmailAddress) {
                    qPos.add(emailAddress);
                }

                List<EventContact> list = q.list();

                if (list.isEmpty()) {
                    FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAILADDRESS_E,
                        finderArgs, list);
                } else {
                    if ((list.size() > 1) && _log.isWarnEnabled()) {
                        _log.warn(
                            "EventContactPersistenceImpl.fetchByEmailAddress_E(String, String, boolean) with parameters (" +
                            StringUtil.merge(finderArgs) +
                            ") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
                    }

                    EventContact eventContact = list.get(0);

                    result = eventContact;

                    cacheResult(eventContact);

                    if ((eventContact.getEventId() == null) ||
                            !eventContact.getEventId().equals(eventId) ||
                            (eventContact.getEmailAddress() == null) ||
                            !eventContact.getEmailAddress().equals(emailAddress)) {
                        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAILADDRESS_E,
                            finderArgs, eventContact);
                    }
                }
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EMAILADDRESS_E,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        if (result instanceof List<?>) {
            return null;
        } else {
            return (EventContact) result;
        }
    }

    /**
     * Removes the event contact where eventId = &#63; and emailAddress = &#63; from the database.
     *
     * @param eventId the event ID
     * @param emailAddress the email address
     * @return the event contact that was removed
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EventContact removeByEmailAddress_E(String eventId,
        String emailAddress)
        throws NoSuchEventContactException, SystemException {
        EventContact eventContact = findByEmailAddress_E(eventId, emailAddress);

        return remove(eventContact);
    }

    /**
     * Returns the number of event contacts where eventId = &#63; and emailAddress = &#63;.
     *
     * @param eventId the event ID
     * @param emailAddress the email address
     * @return the number of matching event contacts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByEmailAddress_E(String eventId, String emailAddress)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_EMAILADDRESS_E;

        Object[] finderArgs = new Object[] { eventId, emailAddress };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_EVENTCONTACT_WHERE);

            boolean bindEventId = false;

            if (eventId == null) {
                query.append(_FINDER_COLUMN_EMAILADDRESS_E_EVENTID_1);
            } else if (eventId.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_EMAILADDRESS_E_EVENTID_3);
            } else {
                bindEventId = true;

                query.append(_FINDER_COLUMN_EMAILADDRESS_E_EVENTID_2);
            }

            boolean bindEmailAddress = false;

            if (emailAddress == null) {
                query.append(_FINDER_COLUMN_EMAILADDRESS_E_EMAILADDRESS_1);
            } else if (emailAddress.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_EMAILADDRESS_E_EMAILADDRESS_3);
            } else {
                bindEmailAddress = true;

                query.append(_FINDER_COLUMN_EMAILADDRESS_E_EMAILADDRESS_2);
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

                if (bindEmailAddress) {
                    qPos.add(emailAddress);
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
     * Returns all the event contacts where eventId = &#63; and verified = &#63; and eventContactId &ne; &#63;.
     *
     * @param eventId the event ID
     * @param verified the verified
     * @param eventContactId the event contact ID
     * @return the matching event contacts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<EventContact> findByNotInterested_E_V(String eventId,
        boolean verified, long eventContactId) throws SystemException {
        return findByNotInterested_E_V(eventId, verified, eventContactId,
            QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the event contacts where eventId = &#63; and verified = &#63; and eventContactId &ne; &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.events.global.mobile.model.impl.EventContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param eventId the event ID
     * @param verified the verified
     * @param eventContactId the event contact ID
     * @param start the lower bound of the range of event contacts
     * @param end the upper bound of the range of event contacts (not inclusive)
     * @return the range of matching event contacts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<EventContact> findByNotInterested_E_V(String eventId,
        boolean verified, long eventContactId, int start, int end)
        throws SystemException {
        return findByNotInterested_E_V(eventId, verified, eventContactId,
            start, end, null);
    }

    /**
     * Returns an ordered range of all the event contacts where eventId = &#63; and verified = &#63; and eventContactId &ne; &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.events.global.mobile.model.impl.EventContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param eventId the event ID
     * @param verified the verified
     * @param eventContactId the event contact ID
     * @param start the lower bound of the range of event contacts
     * @param end the upper bound of the range of event contacts (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching event contacts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<EventContact> findByNotInterested_E_V(String eventId,
        boolean verified, long eventContactId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NOTINTERESTED_E_V;
        finderArgs = new Object[] {
                eventId, verified, eventContactId,
                
                start, end, orderByComparator
            };

        List<EventContact> list = (List<EventContact>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (EventContact eventContact : list) {
                if (!Validator.equals(eventId, eventContact.getEventId()) ||
                        (verified != eventContact.getVerified()) ||
                        (eventContactId == eventContact.getEventContactId())) {
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

            query.append(_SQL_SELECT_EVENTCONTACT_WHERE);

            boolean bindEventId = false;

            if (eventId == null) {
                query.append(_FINDER_COLUMN_NOTINTERESTED_E_V_EVENTID_1);
            } else if (eventId.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_NOTINTERESTED_E_V_EVENTID_3);
            } else {
                bindEventId = true;

                query.append(_FINDER_COLUMN_NOTINTERESTED_E_V_EVENTID_2);
            }

            query.append(_FINDER_COLUMN_NOTINTERESTED_E_V_VERIFIED_2);

            query.append(_FINDER_COLUMN_NOTINTERESTED_E_V_EVENTCONTACTID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(EventContactModelImpl.ORDER_BY_JPQL);
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

                qPos.add(verified);

                qPos.add(eventContactId);

                if (!pagination) {
                    list = (List<EventContact>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<EventContact>(list);
                } else {
                    list = (List<EventContact>) QueryUtil.list(q, getDialect(),
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
     * Returns the first event contact in the ordered set where eventId = &#63; and verified = &#63; and eventContactId &ne; &#63;.
     *
     * @param eventId the event ID
     * @param verified the verified
     * @param eventContactId the event contact ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching event contact
     * @throws com.liferay.events.global.mobile.NoSuchEventContactException if a matching event contact could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EventContact findByNotInterested_E_V_First(String eventId,
        boolean verified, long eventContactId,
        OrderByComparator orderByComparator)
        throws NoSuchEventContactException, SystemException {
        EventContact eventContact = fetchByNotInterested_E_V_First(eventId,
                verified, eventContactId, orderByComparator);

        if (eventContact != null) {
            return eventContact;
        }

        StringBundler msg = new StringBundler(8);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("eventId=");
        msg.append(eventId);

        msg.append(", verified=");
        msg.append(verified);

        msg.append(", eventContactId=");
        msg.append(eventContactId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchEventContactException(msg.toString());
    }

    /**
     * Returns the first event contact in the ordered set where eventId = &#63; and verified = &#63; and eventContactId &ne; &#63;.
     *
     * @param eventId the event ID
     * @param verified the verified
     * @param eventContactId the event contact ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching event contact, or <code>null</code> if a matching event contact could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EventContact fetchByNotInterested_E_V_First(String eventId,
        boolean verified, long eventContactId,
        OrderByComparator orderByComparator) throws SystemException {
        List<EventContact> list = findByNotInterested_E_V(eventId, verified,
                eventContactId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last event contact in the ordered set where eventId = &#63; and verified = &#63; and eventContactId &ne; &#63;.
     *
     * @param eventId the event ID
     * @param verified the verified
     * @param eventContactId the event contact ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching event contact
     * @throws com.liferay.events.global.mobile.NoSuchEventContactException if a matching event contact could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EventContact findByNotInterested_E_V_Last(String eventId,
        boolean verified, long eventContactId,
        OrderByComparator orderByComparator)
        throws NoSuchEventContactException, SystemException {
        EventContact eventContact = fetchByNotInterested_E_V_Last(eventId,
                verified, eventContactId, orderByComparator);

        if (eventContact != null) {
            return eventContact;
        }

        StringBundler msg = new StringBundler(8);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("eventId=");
        msg.append(eventId);

        msg.append(", verified=");
        msg.append(verified);

        msg.append(", eventContactId=");
        msg.append(eventContactId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchEventContactException(msg.toString());
    }

    /**
     * Returns the last event contact in the ordered set where eventId = &#63; and verified = &#63; and eventContactId &ne; &#63;.
     *
     * @param eventId the event ID
     * @param verified the verified
     * @param eventContactId the event contact ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching event contact, or <code>null</code> if a matching event contact could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EventContact fetchByNotInterested_E_V_Last(String eventId,
        boolean verified, long eventContactId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByNotInterested_E_V(eventId, verified, eventContactId);

        if (count == 0) {
            return null;
        }

        List<EventContact> list = findByNotInterested_E_V(eventId, verified,
                eventContactId, count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns all the event contacts where eventId = &#63; and verified = &#63; and eventContactId &ne; all &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.events.global.mobile.model.impl.EventContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param eventId the event ID
     * @param verified the verified
     * @param eventContactIds the event contact IDs
     * @return the matching event contacts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<EventContact> findByNotInterested_E_V(String eventId,
        boolean verified, long[] eventContactIds) throws SystemException {
        return findByNotInterested_E_V(eventId, verified, eventContactIds,
            QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the event contacts where eventId = &#63; and verified = &#63; and eventContactId &ne; all &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.events.global.mobile.model.impl.EventContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param eventId the event ID
     * @param verified the verified
     * @param eventContactIds the event contact IDs
     * @param start the lower bound of the range of event contacts
     * @param end the upper bound of the range of event contacts (not inclusive)
     * @return the range of matching event contacts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<EventContact> findByNotInterested_E_V(String eventId,
        boolean verified, long[] eventContactIds, int start, int end)
        throws SystemException {
        return findByNotInterested_E_V(eventId, verified, eventContactIds,
            start, end, null);
    }

    /**
     * Returns an ordered range of all the event contacts where eventId = &#63; and verified = &#63; and eventContactId &ne; all &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.events.global.mobile.model.impl.EventContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param eventId the event ID
     * @param verified the verified
     * @param eventContactIds the event contact IDs
     * @param start the lower bound of the range of event contacts
     * @param end the upper bound of the range of event contacts (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching event contacts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<EventContact> findByNotInterested_E_V(String eventId,
        boolean verified, long[] eventContactIds, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        if ((eventContactIds != null) && (eventContactIds.length == 1)) {
            return findByNotInterested_E_V(eventId, verified,
                eventContactIds[0], start, end, orderByComparator);
        }

        boolean pagination = true;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderArgs = new Object[] {
                    eventId, verified, StringUtil.merge(eventContactIds)
                };
        } else {
            finderArgs = new Object[] {
                    eventId, verified, StringUtil.merge(eventContactIds),
                    
                    start, end, orderByComparator
                };
        }

        List<EventContact> list = (List<EventContact>) FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_NOTINTERESTED_E_V,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (EventContact eventContact : list) {
                if (!Validator.equals(eventId, eventContact.getEventId()) ||
                        (verified != eventContact.getVerified()) ||
                        !ArrayUtil.contains(eventContactIds,
                            eventContact.getEventContactId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = new StringBundler();

            query.append(_SQL_SELECT_EVENTCONTACT_WHERE);

            boolean conjunctionable = false;

            if (conjunctionable) {
                query.append(WHERE_AND);
            }

            boolean bindEventId = false;

            if (eventId == null) {
                query.append(_FINDER_COLUMN_NOTINTERESTED_E_V_EVENTID_4);
            } else if (eventId.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_NOTINTERESTED_E_V_EVENTID_6);
            } else {
                bindEventId = true;

                query.append(_FINDER_COLUMN_NOTINTERESTED_E_V_EVENTID_5);
            }

            conjunctionable = true;

            if (conjunctionable) {
                query.append(WHERE_AND);
            }

            query.append(_FINDER_COLUMN_NOTINTERESTED_E_V_VERIFIED_5);

            conjunctionable = true;

            if ((eventContactIds == null) || (eventContactIds.length > 0)) {
                if (conjunctionable) {
                    query.append(WHERE_AND);
                }

                query.append(StringPool.OPEN_PARENTHESIS);

                for (int i = 0; i < eventContactIds.length; i++) {
                    query.append(_FINDER_COLUMN_NOTINTERESTED_E_V_EVENTCONTACTID_5);

                    if ((i + 1) < eventContactIds.length) {
                        query.append(WHERE_AND);
                    }
                }

                query.append(StringPool.CLOSE_PARENTHESIS);

                conjunctionable = true;
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(EventContactModelImpl.ORDER_BY_JPQL);
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

                qPos.add(verified);

                if (eventContactIds != null) {
                    qPos.add(eventContactIds);
                }

                if (!pagination) {
                    list = (List<EventContact>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<EventContact>(list);
                } else {
                    list = (List<EventContact>) QueryUtil.list(q, getDialect(),
                            start, end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_NOTINTERESTED_E_V,
                    finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_FIND_BY_NOTINTERESTED_E_V,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes all the event contacts where eventId = &#63; and verified = &#63; and eventContactId &ne; &#63; from the database.
     *
     * @param eventId the event ID
     * @param verified the verified
     * @param eventContactId the event contact ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByNotInterested_E_V(String eventId, boolean verified,
        long eventContactId) throws SystemException {
        for (EventContact eventContact : findByNotInterested_E_V(eventId,
                verified, eventContactId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
                null)) {
            remove(eventContact);
        }
    }

    /**
     * Returns the number of event contacts where eventId = &#63; and verified = &#63; and eventContactId &ne; &#63;.
     *
     * @param eventId the event ID
     * @param verified the verified
     * @param eventContactId the event contact ID
     * @return the number of matching event contacts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByNotInterested_E_V(String eventId, boolean verified,
        long eventContactId) throws SystemException {
        FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_NOTINTERESTED_E_V;

        Object[] finderArgs = new Object[] { eventId, verified, eventContactId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(4);

            query.append(_SQL_COUNT_EVENTCONTACT_WHERE);

            boolean bindEventId = false;

            if (eventId == null) {
                query.append(_FINDER_COLUMN_NOTINTERESTED_E_V_EVENTID_1);
            } else if (eventId.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_NOTINTERESTED_E_V_EVENTID_3);
            } else {
                bindEventId = true;

                query.append(_FINDER_COLUMN_NOTINTERESTED_E_V_EVENTID_2);
            }

            query.append(_FINDER_COLUMN_NOTINTERESTED_E_V_VERIFIED_2);

            query.append(_FINDER_COLUMN_NOTINTERESTED_E_V_EVENTCONTACTID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (bindEventId) {
                    qPos.add(eventId);
                }

                qPos.add(verified);

                qPos.add(eventContactId);

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
     * Returns the number of event contacts where eventId = &#63; and verified = &#63; and eventContactId &ne; all &#63;.
     *
     * @param eventId the event ID
     * @param verified the verified
     * @param eventContactIds the event contact IDs
     * @return the number of matching event contacts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByNotInterested_E_V(String eventId, boolean verified,
        long[] eventContactIds) throws SystemException {
        Object[] finderArgs = new Object[] {
                eventId, verified, StringUtil.merge(eventContactIds)
            };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_NOTINTERESTED_E_V,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler();

            query.append(_SQL_COUNT_EVENTCONTACT_WHERE);

            boolean conjunctionable = false;

            if (conjunctionable) {
                query.append(WHERE_AND);
            }

            boolean bindEventId = false;

            if (eventId == null) {
                query.append(_FINDER_COLUMN_NOTINTERESTED_E_V_EVENTID_4);
            } else if (eventId.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_NOTINTERESTED_E_V_EVENTID_6);
            } else {
                bindEventId = true;

                query.append(_FINDER_COLUMN_NOTINTERESTED_E_V_EVENTID_5);
            }

            conjunctionable = true;

            if (conjunctionable) {
                query.append(WHERE_AND);
            }

            query.append(_FINDER_COLUMN_NOTINTERESTED_E_V_VERIFIED_5);

            conjunctionable = true;

            if ((eventContactIds == null) || (eventContactIds.length > 0)) {
                if (conjunctionable) {
                    query.append(WHERE_AND);
                }

                query.append(StringPool.OPEN_PARENTHESIS);

                for (int i = 0; i < eventContactIds.length; i++) {
                    query.append(_FINDER_COLUMN_NOTINTERESTED_E_V_EVENTCONTACTID_5);

                    if ((i + 1) < eventContactIds.length) {
                        query.append(WHERE_AND);
                    }
                }

                query.append(StringPool.CLOSE_PARENTHESIS);

                conjunctionable = true;
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

                qPos.add(verified);

                if (eventContactIds != null) {
                    qPos.add(eventContactIds);
                }

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_NOTINTERESTED_E_V,
                    finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_WITH_PAGINATION_COUNT_BY_NOTINTERESTED_E_V,
                    finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Caches the event contact in the entity cache if it is enabled.
     *
     * @param eventContact the event contact
     */
    @Override
    public void cacheResult(EventContact eventContact) {
        EntityCacheUtil.putResult(EventContactModelImpl.ENTITY_CACHE_ENABLED,
            EventContactImpl.class, eventContact.getPrimaryKey(), eventContact);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_E_V,
            new Object[] {
                eventContact.getEventContactId(), eventContact.getVerified()
            }, eventContact);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAILADDRESS_E_V,
            new Object[] {
                eventContact.getEventId(), eventContact.getEmailAddress(),
                eventContact.getVerified()
            }, eventContact);

        FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAILADDRESS_E,
            new Object[] {
                eventContact.getEventId(), eventContact.getEmailAddress()
            }, eventContact);

        eventContact.resetOriginalValues();
    }

    /**
     * Caches the event contacts in the entity cache if it is enabled.
     *
     * @param eventContacts the event contacts
     */
    @Override
    public void cacheResult(List<EventContact> eventContacts) {
        for (EventContact eventContact : eventContacts) {
            if (EntityCacheUtil.getResult(
                        EventContactModelImpl.ENTITY_CACHE_ENABLED,
                        EventContactImpl.class, eventContact.getPrimaryKey()) == null) {
                cacheResult(eventContact);
            } else {
                eventContact.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all event contacts.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(EventContactImpl.class.getName());
        }

        EntityCacheUtil.clearCache(EventContactImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the event contact.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(EventContact eventContact) {
        EntityCacheUtil.removeResult(EventContactModelImpl.ENTITY_CACHE_ENABLED,
            EventContactImpl.class, eventContact.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        clearUniqueFindersCache(eventContact);
    }

    @Override
    public void clearCache(List<EventContact> eventContacts) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (EventContact eventContact : eventContacts) {
            EntityCacheUtil.removeResult(EventContactModelImpl.ENTITY_CACHE_ENABLED,
                EventContactImpl.class, eventContact.getPrimaryKey());

            clearUniqueFindersCache(eventContact);
        }
    }

    protected void cacheUniqueFindersCache(EventContact eventContact) {
        if (eventContact.isNew()) {
            Object[] args = new Object[] {
                    eventContact.getEventContactId(), eventContact.getVerified()
                };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_E_V, args,
                Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_E_V, args,
                eventContact);

            args = new Object[] {
                    eventContact.getEventId(), eventContact.getEmailAddress(),
                    eventContact.getVerified()
                };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EMAILADDRESS_E_V,
                args, Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAILADDRESS_E_V,
                args, eventContact);

            args = new Object[] {
                    eventContact.getEventId(), eventContact.getEmailAddress()
                };

            FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EMAILADDRESS_E,
                args, Long.valueOf(1));
            FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAILADDRESS_E,
                args, eventContact);
        } else {
            EventContactModelImpl eventContactModelImpl = (EventContactModelImpl) eventContact;

            if ((eventContactModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_E_V.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        eventContact.getEventContactId(),
                        eventContact.getVerified()
                    };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_E_V, args,
                    Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_E_V, args,
                    eventContact);
            }

            if ((eventContactModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_EMAILADDRESS_E_V.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        eventContact.getEventId(),
                        eventContact.getEmailAddress(),
                        eventContact.getVerified()
                    };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EMAILADDRESS_E_V,
                    args, Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAILADDRESS_E_V,
                    args, eventContact);
            }

            if ((eventContactModelImpl.getColumnBitmask() &
                    FINDER_PATH_FETCH_BY_EMAILADDRESS_E.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        eventContact.getEventId(),
                        eventContact.getEmailAddress()
                    };

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EMAILADDRESS_E,
                    args, Long.valueOf(1));
                FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_EMAILADDRESS_E,
                    args, eventContact);
            }
        }
    }

    protected void clearUniqueFindersCache(EventContact eventContact) {
        EventContactModelImpl eventContactModelImpl = (EventContactModelImpl) eventContact;

        Object[] args = new Object[] {
                eventContact.getEventContactId(), eventContact.getVerified()
            };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_E_V, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_E_V, args);

        if ((eventContactModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_E_V.getColumnBitmask()) != 0) {
            args = new Object[] {
                    eventContactModelImpl.getOriginalEventContactId(),
                    eventContactModelImpl.getOriginalVerified()
                };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_E_V, args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_E_V, args);
        }

        args = new Object[] {
                eventContact.getEventId(), eventContact.getEmailAddress(),
                eventContact.getVerified()
            };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMAILADDRESS_E_V, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EMAILADDRESS_E_V, args);

        if ((eventContactModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_EMAILADDRESS_E_V.getColumnBitmask()) != 0) {
            args = new Object[] {
                    eventContactModelImpl.getOriginalEventId(),
                    eventContactModelImpl.getOriginalEmailAddress(),
                    eventContactModelImpl.getOriginalVerified()
                };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMAILADDRESS_E_V,
                args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EMAILADDRESS_E_V,
                args);
        }

        args = new Object[] {
                eventContact.getEventId(), eventContact.getEmailAddress()
            };

        FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMAILADDRESS_E, args);
        FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EMAILADDRESS_E, args);

        if ((eventContactModelImpl.getColumnBitmask() &
                FINDER_PATH_FETCH_BY_EMAILADDRESS_E.getColumnBitmask()) != 0) {
            args = new Object[] {
                    eventContactModelImpl.getOriginalEventId(),
                    eventContactModelImpl.getOriginalEmailAddress()
                };

            FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMAILADDRESS_E,
                args);
            FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_EMAILADDRESS_E,
                args);
        }
    }

    /**
     * Creates a new event contact with the primary key. Does not add the event contact to the database.
     *
     * @param eventContactId the primary key for the new event contact
     * @return the new event contact
     */
    @Override
    public EventContact create(long eventContactId) {
        EventContact eventContact = new EventContactImpl();

        eventContact.setNew(true);
        eventContact.setPrimaryKey(eventContactId);

        return eventContact;
    }

    /**
     * Removes the event contact with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param eventContactId the primary key of the event contact
     * @return the event contact that was removed
     * @throws com.liferay.events.global.mobile.NoSuchEventContactException if a event contact with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EventContact remove(long eventContactId)
        throws NoSuchEventContactException, SystemException {
        return remove((Serializable) eventContactId);
    }

    /**
     * Removes the event contact with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the event contact
     * @return the event contact that was removed
     * @throws com.liferay.events.global.mobile.NoSuchEventContactException if a event contact with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EventContact remove(Serializable primaryKey)
        throws NoSuchEventContactException, SystemException {
        Session session = null;

        try {
            session = openSession();

            EventContact eventContact = (EventContact) session.get(EventContactImpl.class,
                    primaryKey);

            if (eventContact == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchEventContactException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(eventContact);
        } catch (NoSuchEventContactException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected EventContact removeImpl(EventContact eventContact)
        throws SystemException {
        eventContact = toUnwrappedModel(eventContact);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(eventContact)) {
                eventContact = (EventContact) session.get(EventContactImpl.class,
                        eventContact.getPrimaryKeyObj());
            }

            if (eventContact != null) {
                session.delete(eventContact);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (eventContact != null) {
            clearCache(eventContact);
        }

        return eventContact;
    }

    @Override
    public EventContact updateImpl(
        com.liferay.events.global.mobile.model.EventContact eventContact)
        throws SystemException {
        eventContact = toUnwrappedModel(eventContact);

        boolean isNew = eventContact.isNew();

        Session session = null;

        try {
            session = openSession();

            if (eventContact.isNew()) {
                session.save(eventContact);

                eventContact.setNew(false);
            } else {
                session.merge(eventContact);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !EventContactModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }

        EntityCacheUtil.putResult(EventContactModelImpl.ENTITY_CACHE_ENABLED,
            EventContactImpl.class, eventContact.getPrimaryKey(), eventContact);

        clearUniqueFindersCache(eventContact);
        cacheUniqueFindersCache(eventContact);

        return eventContact;
    }

    protected EventContact toUnwrappedModel(EventContact eventContact) {
        if (eventContact instanceof EventContactImpl) {
            return eventContact;
        }

        EventContactImpl eventContactImpl = new EventContactImpl();

        eventContactImpl.setNew(eventContact.isNew());
        eventContactImpl.setPrimaryKey(eventContact.getPrimaryKey());

        eventContactImpl.setGivenName(eventContact.getGivenName());
        eventContactImpl.setFullName(eventContact.getFullName());
        eventContactImpl.setEmailAddress(eventContact.getEmailAddress());
        eventContactImpl.setCity(eventContact.getCity());
        eventContactImpl.setCountry(eventContact.getCountry());
        eventContactImpl.setLat(eventContact.getLat());
        eventContactImpl.setLng(eventContact.getLng());
        eventContactImpl.setJobTitle(eventContact.getJobTitle());
        eventContactImpl.setCompany(eventContact.getCompany());
        eventContactImpl.setIndustry(eventContact.getIndustry());
        eventContactImpl.setInterests(eventContact.getInterests());
        eventContactImpl.setDesires(eventContact.getDesires());
        eventContactImpl.setExpertise(eventContact.getExpertise());
        eventContactImpl.setAttendeeType(eventContact.getAttendeeType());
        eventContactImpl.setInterestedIds(eventContact.getInterestedIds());
        eventContactImpl.setPicUrl(eventContact.getPicUrl());
        eventContactImpl.setEventId(eventContact.getEventId());
        eventContactImpl.setVerified(eventContact.isVerified());
        eventContactImpl.setEventContactId(eventContact.getEventContactId());
        eventContactImpl.setGroupId(eventContact.getGroupId());
        eventContactImpl.setCompanyId(eventContact.getCompanyId());
        eventContactImpl.setUserId(eventContact.getUserId());
        eventContactImpl.setUserName(eventContact.getUserName());
        eventContactImpl.setCreateDate(eventContact.getCreateDate());
        eventContactImpl.setModifiedDate(eventContact.getModifiedDate());

        return eventContactImpl;
    }

    /**
     * Returns the event contact with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the event contact
     * @return the event contact
     * @throws com.liferay.events.global.mobile.NoSuchEventContactException if a event contact with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EventContact findByPrimaryKey(Serializable primaryKey)
        throws NoSuchEventContactException, SystemException {
        EventContact eventContact = fetchByPrimaryKey(primaryKey);

        if (eventContact == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchEventContactException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return eventContact;
    }

    /**
     * Returns the event contact with the primary key or throws a {@link com.liferay.events.global.mobile.NoSuchEventContactException} if it could not be found.
     *
     * @param eventContactId the primary key of the event contact
     * @return the event contact
     * @throws com.liferay.events.global.mobile.NoSuchEventContactException if a event contact with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EventContact findByPrimaryKey(long eventContactId)
        throws NoSuchEventContactException, SystemException {
        return findByPrimaryKey((Serializable) eventContactId);
    }

    /**
     * Returns the event contact with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the event contact
     * @return the event contact, or <code>null</code> if a event contact with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EventContact fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        EventContact eventContact = (EventContact) EntityCacheUtil.getResult(EventContactModelImpl.ENTITY_CACHE_ENABLED,
                EventContactImpl.class, primaryKey);

        if (eventContact == _nullEventContact) {
            return null;
        }

        if (eventContact == null) {
            Session session = null;

            try {
                session = openSession();

                eventContact = (EventContact) session.get(EventContactImpl.class,
                        primaryKey);

                if (eventContact != null) {
                    cacheResult(eventContact);
                } else {
                    EntityCacheUtil.putResult(EventContactModelImpl.ENTITY_CACHE_ENABLED,
                        EventContactImpl.class, primaryKey, _nullEventContact);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(EventContactModelImpl.ENTITY_CACHE_ENABLED,
                    EventContactImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return eventContact;
    }

    /**
     * Returns the event contact with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param eventContactId the primary key of the event contact
     * @return the event contact, or <code>null</code> if a event contact with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public EventContact fetchByPrimaryKey(long eventContactId)
        throws SystemException {
        return fetchByPrimaryKey((Serializable) eventContactId);
    }

    /**
     * Returns all the event contacts.
     *
     * @return the event contacts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<EventContact> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the event contacts.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.events.global.mobile.model.impl.EventContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of event contacts
     * @param end the upper bound of the range of event contacts (not inclusive)
     * @return the range of event contacts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<EventContact> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the event contacts.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.events.global.mobile.model.impl.EventContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
     * </p>
     *
     * @param start the lower bound of the range of event contacts
     * @param end the upper bound of the range of event contacts (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of event contacts
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<EventContact> findAll(int start, int end,
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

        List<EventContact> list = (List<EventContact>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_EVENTCONTACT);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_EVENTCONTACT;

                if (pagination) {
                    sql = sql.concat(EventContactModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<EventContact>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<EventContact>(list);
                } else {
                    list = (List<EventContact>) QueryUtil.list(q, getDialect(),
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
     * Removes all the event contacts from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (EventContact eventContact : findAll()) {
            remove(eventContact);
        }
    }

    /**
     * Returns the number of event contacts.
     *
     * @return the number of event contacts
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

                Query q = session.createQuery(_SQL_COUNT_EVENTCONTACT);

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
     * Initializes the event contact persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.liferay.events.global.mobile.model.EventContact")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<EventContact>> listenersList = new ArrayList<ModelListener<EventContact>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<EventContact>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(EventContactImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
