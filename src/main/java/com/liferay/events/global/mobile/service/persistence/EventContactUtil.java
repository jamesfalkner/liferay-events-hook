package com.liferay.events.global.mobile.service.persistence;

import com.liferay.events.global.mobile.model.EventContact;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the event contact service. This utility wraps {@link EventContactPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author James Falkner
 * @see EventContactPersistence
 * @see EventContactPersistenceImpl
 * @generated
 */
public class EventContactUtil {
    private static EventContactPersistence _persistence;

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
    public static void clearCache(EventContact eventContact) {
        getPersistence().clearCache(eventContact);
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
    public static List<EventContact> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<EventContact> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<EventContact> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static EventContact update(EventContact eventContact)
        throws SystemException {
        return getPersistence().update(eventContact);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static EventContact update(EventContact eventContact,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(eventContact, serviceContext);
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
    public static com.liferay.events.global.mobile.model.EventContact findByE_V(
        long eventContactId, boolean verified)
        throws com.liferay.events.global.mobile.NoSuchEventContactException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByE_V(eventContactId, verified);
    }

    /**
    * Returns the event contact where eventContactId = &#63; and verified = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param eventContactId the event contact ID
    * @param verified the verified
    * @return the matching event contact, or <code>null</code> if a matching event contact could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.events.global.mobile.model.EventContact fetchByE_V(
        long eventContactId, boolean verified)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByE_V(eventContactId, verified);
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
    public static com.liferay.events.global.mobile.model.EventContact fetchByE_V(
        long eventContactId, boolean verified, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByE_V(eventContactId, verified, retrieveFromCache);
    }

    /**
    * Removes the event contact where eventContactId = &#63; and verified = &#63; from the database.
    *
    * @param eventContactId the event contact ID
    * @param verified the verified
    * @return the event contact that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.events.global.mobile.model.EventContact removeByE_V(
        long eventContactId, boolean verified)
        throws com.liferay.events.global.mobile.NoSuchEventContactException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().removeByE_V(eventContactId, verified);
    }

    /**
    * Returns the number of event contacts where eventContactId = &#63; and verified = &#63;.
    *
    * @param eventContactId the event contact ID
    * @param verified the verified
    * @return the number of matching event contacts
    * @throws SystemException if a system exception occurred
    */
    public static int countByE_V(long eventContactId, boolean verified)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByE_V(eventContactId, verified);
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
    public static com.liferay.events.global.mobile.model.EventContact findByEmailAddress_E_V(
        java.lang.String eventId, java.lang.String emailAddress,
        boolean verified)
        throws com.liferay.events.global.mobile.NoSuchEventContactException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByEmailAddress_E_V(eventId, emailAddress, verified);
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
    public static com.liferay.events.global.mobile.model.EventContact fetchByEmailAddress_E_V(
        java.lang.String eventId, java.lang.String emailAddress,
        boolean verified)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByEmailAddress_E_V(eventId, emailAddress, verified);
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
    public static com.liferay.events.global.mobile.model.EventContact fetchByEmailAddress_E_V(
        java.lang.String eventId, java.lang.String emailAddress,
        boolean verified, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByEmailAddress_E_V(eventId, emailAddress, verified,
            retrieveFromCache);
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
    public static com.liferay.events.global.mobile.model.EventContact removeByEmailAddress_E_V(
        java.lang.String eventId, java.lang.String emailAddress,
        boolean verified)
        throws com.liferay.events.global.mobile.NoSuchEventContactException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .removeByEmailAddress_E_V(eventId, emailAddress, verified);
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
    public static int countByEmailAddress_E_V(java.lang.String eventId,
        java.lang.String emailAddress, boolean verified)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .countByEmailAddress_E_V(eventId, emailAddress, verified);
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
    public static com.liferay.events.global.mobile.model.EventContact findByEmailAddress_E(
        java.lang.String eventId, java.lang.String emailAddress)
        throws com.liferay.events.global.mobile.NoSuchEventContactException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByEmailAddress_E(eventId, emailAddress);
    }

    /**
    * Returns the event contact where eventId = &#63; and emailAddress = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param eventId the event ID
    * @param emailAddress the email address
    * @return the matching event contact, or <code>null</code> if a matching event contact could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.events.global.mobile.model.EventContact fetchByEmailAddress_E(
        java.lang.String eventId, java.lang.String emailAddress)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByEmailAddress_E(eventId, emailAddress);
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
    public static com.liferay.events.global.mobile.model.EventContact fetchByEmailAddress_E(
        java.lang.String eventId, java.lang.String emailAddress,
        boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByEmailAddress_E(eventId, emailAddress,
            retrieveFromCache);
    }

    /**
    * Removes the event contact where eventId = &#63; and emailAddress = &#63; from the database.
    *
    * @param eventId the event ID
    * @param emailAddress the email address
    * @return the event contact that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.events.global.mobile.model.EventContact removeByEmailAddress_E(
        java.lang.String eventId, java.lang.String emailAddress)
        throws com.liferay.events.global.mobile.NoSuchEventContactException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().removeByEmailAddress_E(eventId, emailAddress);
    }

    /**
    * Returns the number of event contacts where eventId = &#63; and emailAddress = &#63;.
    *
    * @param eventId the event ID
    * @param emailAddress the email address
    * @return the number of matching event contacts
    * @throws SystemException if a system exception occurred
    */
    public static int countByEmailAddress_E(java.lang.String eventId,
        java.lang.String emailAddress)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByEmailAddress_E(eventId, emailAddress);
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
    public static java.util.List<com.liferay.events.global.mobile.model.EventContact> findByNotInterested_E_V(
        java.lang.String eventId, boolean verified, long eventContactId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByNotInterested_E_V(eventId, verified, eventContactId);
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
    public static java.util.List<com.liferay.events.global.mobile.model.EventContact> findByNotInterested_E_V(
        java.lang.String eventId, boolean verified, long eventContactId,
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByNotInterested_E_V(eventId, verified, eventContactId,
            start, end);
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
    public static java.util.List<com.liferay.events.global.mobile.model.EventContact> findByNotInterested_E_V(
        java.lang.String eventId, boolean verified, long eventContactId,
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByNotInterested_E_V(eventId, verified, eventContactId,
            start, end, orderByComparator);
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
    public static com.liferay.events.global.mobile.model.EventContact findByNotInterested_E_V_First(
        java.lang.String eventId, boolean verified, long eventContactId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.events.global.mobile.NoSuchEventContactException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByNotInterested_E_V_First(eventId, verified,
            eventContactId, orderByComparator);
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
    public static com.liferay.events.global.mobile.model.EventContact fetchByNotInterested_E_V_First(
        java.lang.String eventId, boolean verified, long eventContactId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByNotInterested_E_V_First(eventId, verified,
            eventContactId, orderByComparator);
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
    public static com.liferay.events.global.mobile.model.EventContact findByNotInterested_E_V_Last(
        java.lang.String eventId, boolean verified, long eventContactId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.events.global.mobile.NoSuchEventContactException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByNotInterested_E_V_Last(eventId, verified,
            eventContactId, orderByComparator);
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
    public static com.liferay.events.global.mobile.model.EventContact fetchByNotInterested_E_V_Last(
        java.lang.String eventId, boolean verified, long eventContactId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByNotInterested_E_V_Last(eventId, verified,
            eventContactId, orderByComparator);
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
    public static java.util.List<com.liferay.events.global.mobile.model.EventContact> findByNotInterested_E_V(
        java.lang.String eventId, boolean verified, long[] eventContactIds)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByNotInterested_E_V(eventId, verified, eventContactIds);
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
    public static java.util.List<com.liferay.events.global.mobile.model.EventContact> findByNotInterested_E_V(
        java.lang.String eventId, boolean verified, long[] eventContactIds,
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByNotInterested_E_V(eventId, verified, eventContactIds,
            start, end);
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
    public static java.util.List<com.liferay.events.global.mobile.model.EventContact> findByNotInterested_E_V(
        java.lang.String eventId, boolean verified, long[] eventContactIds,
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByNotInterested_E_V(eventId, verified, eventContactIds,
            start, end, orderByComparator);
    }

    /**
    * Removes all the event contacts where eventId = &#63; and verified = &#63; and eventContactId &ne; &#63; from the database.
    *
    * @param eventId the event ID
    * @param verified the verified
    * @param eventContactId the event contact ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByNotInterested_E_V(java.lang.String eventId,
        boolean verified, long eventContactId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence()
            .removeByNotInterested_E_V(eventId, verified, eventContactId);
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
    public static int countByNotInterested_E_V(java.lang.String eventId,
        boolean verified, long eventContactId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .countByNotInterested_E_V(eventId, verified, eventContactId);
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
    public static int countByNotInterested_E_V(java.lang.String eventId,
        boolean verified, long[] eventContactIds)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .countByNotInterested_E_V(eventId, verified, eventContactIds);
    }

    /**
    * Caches the event contact in the entity cache if it is enabled.
    *
    * @param eventContact the event contact
    */
    public static void cacheResult(
        com.liferay.events.global.mobile.model.EventContact eventContact) {
        getPersistence().cacheResult(eventContact);
    }

    /**
    * Caches the event contacts in the entity cache if it is enabled.
    *
    * @param eventContacts the event contacts
    */
    public static void cacheResult(
        java.util.List<com.liferay.events.global.mobile.model.EventContact> eventContacts) {
        getPersistence().cacheResult(eventContacts);
    }

    /**
    * Creates a new event contact with the primary key. Does not add the event contact to the database.
    *
    * @param eventContactId the primary key for the new event contact
    * @return the new event contact
    */
    public static com.liferay.events.global.mobile.model.EventContact create(
        long eventContactId) {
        return getPersistence().create(eventContactId);
    }

    /**
    * Removes the event contact with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param eventContactId the primary key of the event contact
    * @return the event contact that was removed
    * @throws com.liferay.events.global.mobile.NoSuchEventContactException if a event contact with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.events.global.mobile.model.EventContact remove(
        long eventContactId)
        throws com.liferay.events.global.mobile.NoSuchEventContactException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(eventContactId);
    }

    public static com.liferay.events.global.mobile.model.EventContact updateImpl(
        com.liferay.events.global.mobile.model.EventContact eventContact)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(eventContact);
    }

    /**
    * Returns the event contact with the primary key or throws a {@link com.liferay.events.global.mobile.NoSuchEventContactException} if it could not be found.
    *
    * @param eventContactId the primary key of the event contact
    * @return the event contact
    * @throws com.liferay.events.global.mobile.NoSuchEventContactException if a event contact with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.events.global.mobile.model.EventContact findByPrimaryKey(
        long eventContactId)
        throws com.liferay.events.global.mobile.NoSuchEventContactException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(eventContactId);
    }

    /**
    * Returns the event contact with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param eventContactId the primary key of the event contact
    * @return the event contact, or <code>null</code> if a event contact with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.events.global.mobile.model.EventContact fetchByPrimaryKey(
        long eventContactId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(eventContactId);
    }

    /**
    * Returns all the event contacts.
    *
    * @return the event contacts
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.events.global.mobile.model.EventContact> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<com.liferay.events.global.mobile.model.EventContact> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
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
    public static java.util.List<com.liferay.events.global.mobile.model.EventContact> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the event contacts from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of event contacts.
    *
    * @return the number of event contacts
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static EventContactPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (EventContactPersistence) PortletBeanLocatorUtil.locate(com.liferay.events.global.mobile.service.ClpSerializer.getServletContextName(),
                    EventContactPersistence.class.getName());

            ReferenceRegistry.registerReference(EventContactUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(EventContactPersistence persistence) {
    }
}
