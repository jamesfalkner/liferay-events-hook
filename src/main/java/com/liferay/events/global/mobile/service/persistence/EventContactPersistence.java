package com.liferay.events.global.mobile.service.persistence;

import com.liferay.events.global.mobile.model.EventContact;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the event contact service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author James Falkner
 * @see EventContactPersistenceImpl
 * @see EventContactUtil
 * @generated
 */
public interface EventContactPersistence extends BasePersistence<EventContact> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link EventContactUtil} to access the event contact persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns the event contact where eventContactId = &#63; and verified = &#63; or throws a {@link com.liferay.events.global.mobile.NoSuchEventContactException} if it could not be found.
    *
    * @param eventContactId the event contact ID
    * @param verified the verified
    * @return the matching event contact
    * @throws com.liferay.events.global.mobile.NoSuchEventContactException if a matching event contact could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.events.global.mobile.model.EventContact findByE_V(
        long eventContactId, boolean verified)
        throws com.liferay.events.global.mobile.NoSuchEventContactException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the event contact where eventContactId = &#63; and verified = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param eventContactId the event contact ID
    * @param verified the verified
    * @return the matching event contact, or <code>null</code> if a matching event contact could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.events.global.mobile.model.EventContact fetchByE_V(
        long eventContactId, boolean verified)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the event contact where eventContactId = &#63; and verified = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param eventContactId the event contact ID
    * @param verified the verified
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching event contact, or <code>null</code> if a matching event contact could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.events.global.mobile.model.EventContact fetchByE_V(
        long eventContactId, boolean verified, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the event contact where eventContactId = &#63; and verified = &#63; from the database.
    *
    * @param eventContactId the event contact ID
    * @param verified the verified
    * @return the event contact that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.events.global.mobile.model.EventContact removeByE_V(
        long eventContactId, boolean verified)
        throws com.liferay.events.global.mobile.NoSuchEventContactException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of event contacts where eventContactId = &#63; and verified = &#63;.
    *
    * @param eventContactId the event contact ID
    * @param verified the verified
    * @return the number of matching event contacts
    * @throws SystemException if a system exception occurred
    */
    public int countByE_V(long eventContactId, boolean verified)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.liferay.events.global.mobile.model.EventContact findByEmailAddress_E_V(
        java.lang.String eventId, java.lang.String emailAddress,
        boolean verified)
        throws com.liferay.events.global.mobile.NoSuchEventContactException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the event contact where eventId = &#63; and emailAddress = &#63; and verified = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param eventId the event ID
    * @param emailAddress the email address
    * @param verified the verified
    * @return the matching event contact, or <code>null</code> if a matching event contact could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.events.global.mobile.model.EventContact fetchByEmailAddress_E_V(
        java.lang.String eventId, java.lang.String emailAddress,
        boolean verified)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.liferay.events.global.mobile.model.EventContact fetchByEmailAddress_E_V(
        java.lang.String eventId, java.lang.String emailAddress,
        boolean verified, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the event contact where eventId = &#63; and emailAddress = &#63; and verified = &#63; from the database.
    *
    * @param eventId the event ID
    * @param emailAddress the email address
    * @param verified the verified
    * @return the event contact that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.events.global.mobile.model.EventContact removeByEmailAddress_E_V(
        java.lang.String eventId, java.lang.String emailAddress,
        boolean verified)
        throws com.liferay.events.global.mobile.NoSuchEventContactException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of event contacts where eventId = &#63; and emailAddress = &#63; and verified = &#63;.
    *
    * @param eventId the event ID
    * @param emailAddress the email address
    * @param verified the verified
    * @return the number of matching event contacts
    * @throws SystemException if a system exception occurred
    */
    public int countByEmailAddress_E_V(java.lang.String eventId,
        java.lang.String emailAddress, boolean verified)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the event contact where eventId = &#63; and emailAddress = &#63; or throws a {@link com.liferay.events.global.mobile.NoSuchEventContactException} if it could not be found.
    *
    * @param eventId the event ID
    * @param emailAddress the email address
    * @return the matching event contact
    * @throws com.liferay.events.global.mobile.NoSuchEventContactException if a matching event contact could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.events.global.mobile.model.EventContact findByEmailAddress_E(
        java.lang.String eventId, java.lang.String emailAddress)
        throws com.liferay.events.global.mobile.NoSuchEventContactException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the event contact where eventId = &#63; and emailAddress = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param eventId the event ID
    * @param emailAddress the email address
    * @return the matching event contact, or <code>null</code> if a matching event contact could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.events.global.mobile.model.EventContact fetchByEmailAddress_E(
        java.lang.String eventId, java.lang.String emailAddress)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the event contact where eventId = &#63; and emailAddress = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param eventId the event ID
    * @param emailAddress the email address
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching event contact, or <code>null</code> if a matching event contact could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.events.global.mobile.model.EventContact fetchByEmailAddress_E(
        java.lang.String eventId, java.lang.String emailAddress,
        boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the event contact where eventId = &#63; and emailAddress = &#63; from the database.
    *
    * @param eventId the event ID
    * @param emailAddress the email address
    * @return the event contact that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.events.global.mobile.model.EventContact removeByEmailAddress_E(
        java.lang.String eventId, java.lang.String emailAddress)
        throws com.liferay.events.global.mobile.NoSuchEventContactException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of event contacts where eventId = &#63; and emailAddress = &#63;.
    *
    * @param eventId the event ID
    * @param emailAddress the email address
    * @return the number of matching event contacts
    * @throws SystemException if a system exception occurred
    */
    public int countByEmailAddress_E(java.lang.String eventId,
        java.lang.String emailAddress)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the event contacts where eventId = &#63; and verified = &#63; and eventContactId &ne; &#63;.
    *
    * @param eventId the event ID
    * @param verified the verified
    * @param eventContactId the event contact ID
    * @return the matching event contacts
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.liferay.events.global.mobile.model.EventContact> findByNotInterested_E_V(
        java.lang.String eventId, boolean verified, long eventContactId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.liferay.events.global.mobile.model.EventContact> findByNotInterested_E_V(
        java.lang.String eventId, boolean verified, long eventContactId,
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.liferay.events.global.mobile.model.EventContact> findByNotInterested_E_V(
        java.lang.String eventId, boolean verified, long eventContactId,
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.liferay.events.global.mobile.model.EventContact findByNotInterested_E_V_First(
        java.lang.String eventId, boolean verified, long eventContactId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.events.global.mobile.NoSuchEventContactException,
            com.liferay.portal.kernel.exception.SystemException;

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
    public com.liferay.events.global.mobile.model.EventContact fetchByNotInterested_E_V_First(
        java.lang.String eventId, boolean verified, long eventContactId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.liferay.events.global.mobile.model.EventContact findByNotInterested_E_V_Last(
        java.lang.String eventId, boolean verified, long eventContactId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.events.global.mobile.NoSuchEventContactException,
            com.liferay.portal.kernel.exception.SystemException;

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
    public com.liferay.events.global.mobile.model.EventContact fetchByNotInterested_E_V_Last(
        java.lang.String eventId, boolean verified, long eventContactId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.liferay.events.global.mobile.model.EventContact> findByNotInterested_E_V(
        java.lang.String eventId, boolean verified, long[] eventContactIds)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.liferay.events.global.mobile.model.EventContact> findByNotInterested_E_V(
        java.lang.String eventId, boolean verified, long[] eventContactIds,
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.liferay.events.global.mobile.model.EventContact> findByNotInterested_E_V(
        java.lang.String eventId, boolean verified, long[] eventContactIds,
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the event contacts where eventId = &#63; and verified = &#63; and eventContactId &ne; &#63; from the database.
    *
    * @param eventId the event ID
    * @param verified the verified
    * @param eventContactId the event contact ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByNotInterested_E_V(java.lang.String eventId,
        boolean verified, long eventContactId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of event contacts where eventId = &#63; and verified = &#63; and eventContactId &ne; &#63;.
    *
    * @param eventId the event ID
    * @param verified the verified
    * @param eventContactId the event contact ID
    * @return the number of matching event contacts
    * @throws SystemException if a system exception occurred
    */
    public int countByNotInterested_E_V(java.lang.String eventId,
        boolean verified, long eventContactId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of event contacts where eventId = &#63; and verified = &#63; and eventContactId &ne; all &#63;.
    *
    * @param eventId the event ID
    * @param verified the verified
    * @param eventContactIds the event contact IDs
    * @return the number of matching event contacts
    * @throws SystemException if a system exception occurred
    */
    public int countByNotInterested_E_V(java.lang.String eventId,
        boolean verified, long[] eventContactIds)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the event contact in the entity cache if it is enabled.
    *
    * @param eventContact the event contact
    */
    public void cacheResult(
        com.liferay.events.global.mobile.model.EventContact eventContact);

    /**
    * Caches the event contacts in the entity cache if it is enabled.
    *
    * @param eventContacts the event contacts
    */
    public void cacheResult(
        java.util.List<com.liferay.events.global.mobile.model.EventContact> eventContacts);

    /**
    * Creates a new event contact with the primary key. Does not add the event contact to the database.
    *
    * @param eventContactId the primary key for the new event contact
    * @return the new event contact
    */
    public com.liferay.events.global.mobile.model.EventContact create(
        long eventContactId);

    /**
    * Removes the event contact with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param eventContactId the primary key of the event contact
    * @return the event contact that was removed
    * @throws com.liferay.events.global.mobile.NoSuchEventContactException if a event contact with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.events.global.mobile.model.EventContact remove(
        long eventContactId)
        throws com.liferay.events.global.mobile.NoSuchEventContactException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.liferay.events.global.mobile.model.EventContact updateImpl(
        com.liferay.events.global.mobile.model.EventContact eventContact)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the event contact with the primary key or throws a {@link com.liferay.events.global.mobile.NoSuchEventContactException} if it could not be found.
    *
    * @param eventContactId the primary key of the event contact
    * @return the event contact
    * @throws com.liferay.events.global.mobile.NoSuchEventContactException if a event contact with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.events.global.mobile.model.EventContact findByPrimaryKey(
        long eventContactId)
        throws com.liferay.events.global.mobile.NoSuchEventContactException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the event contact with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param eventContactId the primary key of the event contact
    * @return the event contact, or <code>null</code> if a event contact with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.events.global.mobile.model.EventContact fetchByPrimaryKey(
        long eventContactId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the event contacts.
    *
    * @return the event contacts
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.liferay.events.global.mobile.model.EventContact> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.liferay.events.global.mobile.model.EventContact> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.liferay.events.global.mobile.model.EventContact> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the event contacts from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of event contacts.
    *
    * @return the number of event contacts
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
