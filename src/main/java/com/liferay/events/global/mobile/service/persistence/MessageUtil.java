package com.liferay.events.global.mobile.service.persistence;

import com.liferay.events.global.mobile.model.Message;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the message service. This utility wraps {@link MessagePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author James Falkner
 * @see MessagePersistence
 * @see MessagePersistenceImpl
 * @generated
 */
public class MessageUtil {
    private static MessagePersistence _persistence;

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
    public static void clearCache(Message message) {
        getPersistence().clearCache(message);
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
    public static List<Message> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Message> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Message> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static Message update(Message message) throws SystemException {
        return getPersistence().update(message);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static Message update(Message message, ServiceContext serviceContext)
        throws SystemException {
        return getPersistence().update(message, serviceContext);
    }

    /**
    * Returns all the messages where eventId = &#63; and toId = &#63;.
    *
    * @param eventId the event ID
    * @param toId the to ID
    * @return the matching messages
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.events.global.mobile.model.Message> findByTargetContactId_E(
        java.lang.String eventId, long toId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByTargetContactId_E(eventId, toId);
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
    public static java.util.List<com.liferay.events.global.mobile.model.Message> findByTargetContactId_E(
        java.lang.String eventId, long toId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByTargetContactId_E(eventId, toId, start, end);
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
    public static java.util.List<com.liferay.events.global.mobile.model.Message> findByTargetContactId_E(
        java.lang.String eventId, long toId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByTargetContactId_E(eventId, toId, start, end,
            orderByComparator);
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
    public static com.liferay.events.global.mobile.model.Message findByTargetContactId_E_First(
        java.lang.String eventId, long toId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.events.global.mobile.NoSuchMessageException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByTargetContactId_E_First(eventId, toId,
            orderByComparator);
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
    public static com.liferay.events.global.mobile.model.Message fetchByTargetContactId_E_First(
        java.lang.String eventId, long toId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByTargetContactId_E_First(eventId, toId,
            orderByComparator);
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
    public static com.liferay.events.global.mobile.model.Message findByTargetContactId_E_Last(
        java.lang.String eventId, long toId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.events.global.mobile.NoSuchMessageException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByTargetContactId_E_Last(eventId, toId,
            orderByComparator);
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
    public static com.liferay.events.global.mobile.model.Message fetchByTargetContactId_E_Last(
        java.lang.String eventId, long toId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByTargetContactId_E_Last(eventId, toId,
            orderByComparator);
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
    public static com.liferay.events.global.mobile.model.Message[] findByTargetContactId_E_PrevAndNext(
        long messageId, java.lang.String eventId, long toId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.events.global.mobile.NoSuchMessageException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByTargetContactId_E_PrevAndNext(messageId, eventId,
            toId, orderByComparator);
    }

    /**
    * Removes all the messages where eventId = &#63; and toId = &#63; from the database.
    *
    * @param eventId the event ID
    * @param toId the to ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByTargetContactId_E(java.lang.String eventId,
        long toId) throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByTargetContactId_E(eventId, toId);
    }

    /**
    * Returns the number of messages where eventId = &#63; and toId = &#63;.
    *
    * @param eventId the event ID
    * @param toId the to ID
    * @return the number of matching messages
    * @throws SystemException if a system exception occurred
    */
    public static int countByTargetContactId_E(java.lang.String eventId,
        long toId) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByTargetContactId_E(eventId, toId);
    }

    /**
    * Caches the message in the entity cache if it is enabled.
    *
    * @param message the message
    */
    public static void cacheResult(
        com.liferay.events.global.mobile.model.Message message) {
        getPersistence().cacheResult(message);
    }

    /**
    * Caches the messages in the entity cache if it is enabled.
    *
    * @param messages the messages
    */
    public static void cacheResult(
        java.util.List<com.liferay.events.global.mobile.model.Message> messages) {
        getPersistence().cacheResult(messages);
    }

    /**
    * Creates a new message with the primary key. Does not add the message to the database.
    *
    * @param messageId the primary key for the new message
    * @return the new message
    */
    public static com.liferay.events.global.mobile.model.Message create(
        long messageId) {
        return getPersistence().create(messageId);
    }

    /**
    * Removes the message with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param messageId the primary key of the message
    * @return the message that was removed
    * @throws com.liferay.events.global.mobile.NoSuchMessageException if a message with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.events.global.mobile.model.Message remove(
        long messageId)
        throws com.liferay.events.global.mobile.NoSuchMessageException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(messageId);
    }

    public static com.liferay.events.global.mobile.model.Message updateImpl(
        com.liferay.events.global.mobile.model.Message message)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(message);
    }

    /**
    * Returns the message with the primary key or throws a {@link com.liferay.events.global.mobile.NoSuchMessageException} if it could not be found.
    *
    * @param messageId the primary key of the message
    * @return the message
    * @throws com.liferay.events.global.mobile.NoSuchMessageException if a message with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.events.global.mobile.model.Message findByPrimaryKey(
        long messageId)
        throws com.liferay.events.global.mobile.NoSuchMessageException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(messageId);
    }

    /**
    * Returns the message with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param messageId the primary key of the message
    * @return the message, or <code>null</code> if a message with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.events.global.mobile.model.Message fetchByPrimaryKey(
        long messageId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(messageId);
    }

    /**
    * Returns all the messages.
    *
    * @return the messages
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.events.global.mobile.model.Message> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<com.liferay.events.global.mobile.model.Message> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
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
    public static java.util.List<com.liferay.events.global.mobile.model.Message> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the messages from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of messages.
    *
    * @return the number of messages
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static MessagePersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (MessagePersistence) PortletBeanLocatorUtil.locate(com.liferay.events.global.mobile.service.ClpSerializer.getServletContextName(),
                    MessagePersistence.class.getName());

            ReferenceRegistry.registerReference(MessageUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(MessagePersistence persistence) {
    }
}
