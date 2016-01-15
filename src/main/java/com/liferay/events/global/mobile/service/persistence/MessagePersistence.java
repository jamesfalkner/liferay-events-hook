package com.liferay.events.global.mobile.service.persistence;

import com.liferay.events.global.mobile.model.Message;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the message service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author James Falkner
 * @see MessagePersistenceImpl
 * @see MessageUtil
 * @generated
 */
public interface MessagePersistence extends BasePersistence<Message> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link MessageUtil} to access the message persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the messages where eventId = &#63; and toId = &#63;.
    *
    * @param eventId the event ID
    * @param toId the to ID
    * @return the matching messages
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.liferay.events.global.mobile.model.Message> findByTargetContactId_E(
        java.lang.String eventId, long toId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.liferay.events.global.mobile.model.Message> findByTargetContactId_E(
        java.lang.String eventId, long toId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.liferay.events.global.mobile.model.Message> findByTargetContactId_E(
        java.lang.String eventId, long toId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.liferay.events.global.mobile.model.Message findByTargetContactId_E_First(
        java.lang.String eventId, long toId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.events.global.mobile.NoSuchMessageException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first message in the ordered set where eventId = &#63; and toId = &#63;.
    *
    * @param eventId the event ID
    * @param toId the to ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching message, or <code>null</code> if a matching message could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.events.global.mobile.model.Message fetchByTargetContactId_E_First(
        java.lang.String eventId, long toId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.liferay.events.global.mobile.model.Message findByTargetContactId_E_Last(
        java.lang.String eventId, long toId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.events.global.mobile.NoSuchMessageException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last message in the ordered set where eventId = &#63; and toId = &#63;.
    *
    * @param eventId the event ID
    * @param toId the to ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching message, or <code>null</code> if a matching message could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.events.global.mobile.model.Message fetchByTargetContactId_E_Last(
        java.lang.String eventId, long toId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.liferay.events.global.mobile.model.Message[] findByTargetContactId_E_PrevAndNext(
        long messageId, java.lang.String eventId, long toId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.events.global.mobile.NoSuchMessageException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the messages where eventId = &#63; and toId = &#63; from the database.
    *
    * @param eventId the event ID
    * @param toId the to ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByTargetContactId_E(java.lang.String eventId, long toId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of messages where eventId = &#63; and toId = &#63;.
    *
    * @param eventId the event ID
    * @param toId the to ID
    * @return the number of matching messages
    * @throws SystemException if a system exception occurred
    */
    public int countByTargetContactId_E(java.lang.String eventId, long toId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the message in the entity cache if it is enabled.
    *
    * @param message the message
    */
    public void cacheResult(
        com.liferay.events.global.mobile.model.Message message);

    /**
    * Caches the messages in the entity cache if it is enabled.
    *
    * @param messages the messages
    */
    public void cacheResult(
        java.util.List<com.liferay.events.global.mobile.model.Message> messages);

    /**
    * Creates a new message with the primary key. Does not add the message to the database.
    *
    * @param messageId the primary key for the new message
    * @return the new message
    */
    public com.liferay.events.global.mobile.model.Message create(long messageId);

    /**
    * Removes the message with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param messageId the primary key of the message
    * @return the message that was removed
    * @throws com.liferay.events.global.mobile.NoSuchMessageException if a message with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.events.global.mobile.model.Message remove(long messageId)
        throws com.liferay.events.global.mobile.NoSuchMessageException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.liferay.events.global.mobile.model.Message updateImpl(
        com.liferay.events.global.mobile.model.Message message)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the message with the primary key or throws a {@link com.liferay.events.global.mobile.NoSuchMessageException} if it could not be found.
    *
    * @param messageId the primary key of the message
    * @return the message
    * @throws com.liferay.events.global.mobile.NoSuchMessageException if a message with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.events.global.mobile.model.Message findByPrimaryKey(
        long messageId)
        throws com.liferay.events.global.mobile.NoSuchMessageException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the message with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param messageId the primary key of the message
    * @return the message, or <code>null</code> if a message with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.events.global.mobile.model.Message fetchByPrimaryKey(
        long messageId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the messages.
    *
    * @return the messages
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.liferay.events.global.mobile.model.Message> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.liferay.events.global.mobile.model.Message> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.liferay.events.global.mobile.model.Message> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the messages from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of messages.
    *
    * @return the number of messages
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
