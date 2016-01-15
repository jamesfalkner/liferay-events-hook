package com.liferay.events.global.mobile.service.persistence;

import com.liferay.events.global.mobile.model.EventPollAnswer;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the event poll answer service. This utility wraps {@link EventPollAnswerPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author James Falkner
 * @see EventPollAnswerPersistence
 * @see EventPollAnswerPersistenceImpl
 * @generated
 */
public class EventPollAnswerUtil {
    private static EventPollAnswerPersistence _persistence;

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
    public static void clearCache(EventPollAnswer eventPollAnswer) {
        getPersistence().clearCache(eventPollAnswer);
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
    public static List<EventPollAnswer> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<EventPollAnswer> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<EventPollAnswer> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static EventPollAnswer update(EventPollAnswer eventPollAnswer)
        throws SystemException {
        return getPersistence().update(eventPollAnswer);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static EventPollAnswer update(EventPollAnswer eventPollAnswer,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(eventPollAnswer, serviceContext);
    }

    /**
    * Returns all the event poll answers where questionId = &#63;.
    *
    * @param questionId the question ID
    * @return the matching event poll answers
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.events.global.mobile.model.EventPollAnswer> findByEventPollAnswer_Q(
        long questionId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByEventPollAnswer_Q(questionId);
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
    public static java.util.List<com.liferay.events.global.mobile.model.EventPollAnswer> findByEventPollAnswer_Q(
        long questionId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByEventPollAnswer_Q(questionId, start, end);
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
    public static java.util.List<com.liferay.events.global.mobile.model.EventPollAnswer> findByEventPollAnswer_Q(
        long questionId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByEventPollAnswer_Q(questionId, start, end,
            orderByComparator);
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
    public static com.liferay.events.global.mobile.model.EventPollAnswer findByEventPollAnswer_Q_First(
        long questionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.events.global.mobile.NoSuchEventPollAnswerException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByEventPollAnswer_Q_First(questionId, orderByComparator);
    }

    /**
    * Returns the first event poll answer in the ordered set where questionId = &#63;.
    *
    * @param questionId the question ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching event poll answer, or <code>null</code> if a matching event poll answer could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.events.global.mobile.model.EventPollAnswer fetchByEventPollAnswer_Q_First(
        long questionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByEventPollAnswer_Q_First(questionId, orderByComparator);
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
    public static com.liferay.events.global.mobile.model.EventPollAnswer findByEventPollAnswer_Q_Last(
        long questionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.events.global.mobile.NoSuchEventPollAnswerException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByEventPollAnswer_Q_Last(questionId, orderByComparator);
    }

    /**
    * Returns the last event poll answer in the ordered set where questionId = &#63;.
    *
    * @param questionId the question ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching event poll answer, or <code>null</code> if a matching event poll answer could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.events.global.mobile.model.EventPollAnswer fetchByEventPollAnswer_Q_Last(
        long questionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByEventPollAnswer_Q_Last(questionId, orderByComparator);
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
    public static com.liferay.events.global.mobile.model.EventPollAnswer[] findByEventPollAnswer_Q_PrevAndNext(
        long answerId, long questionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.events.global.mobile.NoSuchEventPollAnswerException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByEventPollAnswer_Q_PrevAndNext(answerId, questionId,
            orderByComparator);
    }

    /**
    * Removes all the event poll answers where questionId = &#63; from the database.
    *
    * @param questionId the question ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByEventPollAnswer_Q(long questionId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByEventPollAnswer_Q(questionId);
    }

    /**
    * Returns the number of event poll answers where questionId = &#63;.
    *
    * @param questionId the question ID
    * @return the number of matching event poll answers
    * @throws SystemException if a system exception occurred
    */
    public static int countByEventPollAnswer_Q(long questionId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByEventPollAnswer_Q(questionId);
    }

    /**
    * Returns all the event poll answers where questionId = &#63; and clientId = &#63;.
    *
    * @param questionId the question ID
    * @param clientId the client ID
    * @return the matching event poll answers
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.events.global.mobile.model.EventPollAnswer> findByEventPollAnswer_Q_C(
        long questionId, java.lang.String clientId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByEventPollAnswer_Q_C(questionId, clientId);
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
    public static java.util.List<com.liferay.events.global.mobile.model.EventPollAnswer> findByEventPollAnswer_Q_C(
        long questionId, java.lang.String clientId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByEventPollAnswer_Q_C(questionId, clientId, start, end);
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
    public static java.util.List<com.liferay.events.global.mobile.model.EventPollAnswer> findByEventPollAnswer_Q_C(
        long questionId, java.lang.String clientId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByEventPollAnswer_Q_C(questionId, clientId, start, end,
            orderByComparator);
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
    public static com.liferay.events.global.mobile.model.EventPollAnswer findByEventPollAnswer_Q_C_First(
        long questionId, java.lang.String clientId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.events.global.mobile.NoSuchEventPollAnswerException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByEventPollAnswer_Q_C_First(questionId, clientId,
            orderByComparator);
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
    public static com.liferay.events.global.mobile.model.EventPollAnswer fetchByEventPollAnswer_Q_C_First(
        long questionId, java.lang.String clientId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByEventPollAnswer_Q_C_First(questionId, clientId,
            orderByComparator);
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
    public static com.liferay.events.global.mobile.model.EventPollAnswer findByEventPollAnswer_Q_C_Last(
        long questionId, java.lang.String clientId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.events.global.mobile.NoSuchEventPollAnswerException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByEventPollAnswer_Q_C_Last(questionId, clientId,
            orderByComparator);
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
    public static com.liferay.events.global.mobile.model.EventPollAnswer fetchByEventPollAnswer_Q_C_Last(
        long questionId, java.lang.String clientId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByEventPollAnswer_Q_C_Last(questionId, clientId,
            orderByComparator);
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
    public static com.liferay.events.global.mobile.model.EventPollAnswer[] findByEventPollAnswer_Q_C_PrevAndNext(
        long answerId, long questionId, java.lang.String clientId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.events.global.mobile.NoSuchEventPollAnswerException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByEventPollAnswer_Q_C_PrevAndNext(answerId, questionId,
            clientId, orderByComparator);
    }

    /**
    * Removes all the event poll answers where questionId = &#63; and clientId = &#63; from the database.
    *
    * @param questionId the question ID
    * @param clientId the client ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByEventPollAnswer_Q_C(long questionId,
        java.lang.String clientId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByEventPollAnswer_Q_C(questionId, clientId);
    }

    /**
    * Returns the number of event poll answers where questionId = &#63; and clientId = &#63;.
    *
    * @param questionId the question ID
    * @param clientId the client ID
    * @return the number of matching event poll answers
    * @throws SystemException if a system exception occurred
    */
    public static int countByEventPollAnswer_Q_C(long questionId,
        java.lang.String clientId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByEventPollAnswer_Q_C(questionId, clientId);
    }

    /**
    * Caches the event poll answer in the entity cache if it is enabled.
    *
    * @param eventPollAnswer the event poll answer
    */
    public static void cacheResult(
        com.liferay.events.global.mobile.model.EventPollAnswer eventPollAnswer) {
        getPersistence().cacheResult(eventPollAnswer);
    }

    /**
    * Caches the event poll answers in the entity cache if it is enabled.
    *
    * @param eventPollAnswers the event poll answers
    */
    public static void cacheResult(
        java.util.List<com.liferay.events.global.mobile.model.EventPollAnswer> eventPollAnswers) {
        getPersistence().cacheResult(eventPollAnswers);
    }

    /**
    * Creates a new event poll answer with the primary key. Does not add the event poll answer to the database.
    *
    * @param answerId the primary key for the new event poll answer
    * @return the new event poll answer
    */
    public static com.liferay.events.global.mobile.model.EventPollAnswer create(
        long answerId) {
        return getPersistence().create(answerId);
    }

    /**
    * Removes the event poll answer with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param answerId the primary key of the event poll answer
    * @return the event poll answer that was removed
    * @throws com.liferay.events.global.mobile.NoSuchEventPollAnswerException if a event poll answer with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.events.global.mobile.model.EventPollAnswer remove(
        long answerId)
        throws com.liferay.events.global.mobile.NoSuchEventPollAnswerException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().remove(answerId);
    }

    public static com.liferay.events.global.mobile.model.EventPollAnswer updateImpl(
        com.liferay.events.global.mobile.model.EventPollAnswer eventPollAnswer)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(eventPollAnswer);
    }

    /**
    * Returns the event poll answer with the primary key or throws a {@link com.liferay.events.global.mobile.NoSuchEventPollAnswerException} if it could not be found.
    *
    * @param answerId the primary key of the event poll answer
    * @return the event poll answer
    * @throws com.liferay.events.global.mobile.NoSuchEventPollAnswerException if a event poll answer with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.events.global.mobile.model.EventPollAnswer findByPrimaryKey(
        long answerId)
        throws com.liferay.events.global.mobile.NoSuchEventPollAnswerException,
            com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByPrimaryKey(answerId);
    }

    /**
    * Returns the event poll answer with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param answerId the primary key of the event poll answer
    * @return the event poll answer, or <code>null</code> if a event poll answer with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.events.global.mobile.model.EventPollAnswer fetchByPrimaryKey(
        long answerId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(answerId);
    }

    /**
    * Returns all the event poll answers.
    *
    * @return the event poll answers
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.liferay.events.global.mobile.model.EventPollAnswer> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<com.liferay.events.global.mobile.model.EventPollAnswer> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
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
    public static java.util.List<com.liferay.events.global.mobile.model.EventPollAnswer> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the event poll answers from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of event poll answers.
    *
    * @return the number of event poll answers
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static EventPollAnswerPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (EventPollAnswerPersistence) PortletBeanLocatorUtil.locate(com.liferay.events.global.mobile.service.ClpSerializer.getServletContextName(),
                    EventPollAnswerPersistence.class.getName());

            ReferenceRegistry.registerReference(EventPollAnswerUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(EventPollAnswerPersistence persistence) {
    }
}
