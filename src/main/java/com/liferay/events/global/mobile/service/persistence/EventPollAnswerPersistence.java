package com.liferay.events.global.mobile.service.persistence;

import com.liferay.events.global.mobile.model.EventPollAnswer;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the event poll answer service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author James Falkner
 * @see EventPollAnswerPersistenceImpl
 * @see EventPollAnswerUtil
 * @generated
 */
public interface EventPollAnswerPersistence extends BasePersistence<EventPollAnswer> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link EventPollAnswerUtil} to access the event poll answer persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the event poll answers where questionId = &#63;.
    *
    * @param questionId the question ID
    * @return the matching event poll answers
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.liferay.events.global.mobile.model.EventPollAnswer> findByEventPollAnswer_Q(
        long questionId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.liferay.events.global.mobile.model.EventPollAnswer> findByEventPollAnswer_Q(
        long questionId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.liferay.events.global.mobile.model.EventPollAnswer> findByEventPollAnswer_Q(
        long questionId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first event poll answer in the ordered set where questionId = &#63;.
    *
    * @param questionId the question ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching event poll answer
    * @throws com.liferay.events.global.mobile.NoSuchEventPollAnswerException if a matching event poll answer could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.events.global.mobile.model.EventPollAnswer findByEventPollAnswer_Q_First(
        long questionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.events.global.mobile.NoSuchEventPollAnswerException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first event poll answer in the ordered set where questionId = &#63;.
    *
    * @param questionId the question ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching event poll answer, or <code>null</code> if a matching event poll answer could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.events.global.mobile.model.EventPollAnswer fetchByEventPollAnswer_Q_First(
        long questionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last event poll answer in the ordered set where questionId = &#63;.
    *
    * @param questionId the question ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching event poll answer
    * @throws com.liferay.events.global.mobile.NoSuchEventPollAnswerException if a matching event poll answer could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.events.global.mobile.model.EventPollAnswer findByEventPollAnswer_Q_Last(
        long questionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.events.global.mobile.NoSuchEventPollAnswerException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last event poll answer in the ordered set where questionId = &#63;.
    *
    * @param questionId the question ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching event poll answer, or <code>null</code> if a matching event poll answer could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.events.global.mobile.model.EventPollAnswer fetchByEventPollAnswer_Q_Last(
        long questionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.liferay.events.global.mobile.model.EventPollAnswer[] findByEventPollAnswer_Q_PrevAndNext(
        long answerId, long questionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.events.global.mobile.NoSuchEventPollAnswerException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the event poll answers where questionId = &#63; from the database.
    *
    * @param questionId the question ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByEventPollAnswer_Q(long questionId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of event poll answers where questionId = &#63;.
    *
    * @param questionId the question ID
    * @return the number of matching event poll answers
    * @throws SystemException if a system exception occurred
    */
    public int countByEventPollAnswer_Q(long questionId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the event poll answers where questionId = &#63; and clientId = &#63;.
    *
    * @param questionId the question ID
    * @param clientId the client ID
    * @return the matching event poll answers
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.liferay.events.global.mobile.model.EventPollAnswer> findByEventPollAnswer_Q_C(
        long questionId, java.lang.String clientId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.liferay.events.global.mobile.model.EventPollAnswer> findByEventPollAnswer_Q_C(
        long questionId, java.lang.String clientId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.liferay.events.global.mobile.model.EventPollAnswer> findByEventPollAnswer_Q_C(
        long questionId, java.lang.String clientId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.liferay.events.global.mobile.model.EventPollAnswer findByEventPollAnswer_Q_C_First(
        long questionId, java.lang.String clientId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.events.global.mobile.NoSuchEventPollAnswerException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first event poll answer in the ordered set where questionId = &#63; and clientId = &#63;.
    *
    * @param questionId the question ID
    * @param clientId the client ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching event poll answer, or <code>null</code> if a matching event poll answer could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.events.global.mobile.model.EventPollAnswer fetchByEventPollAnswer_Q_C_First(
        long questionId, java.lang.String clientId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.liferay.events.global.mobile.model.EventPollAnswer findByEventPollAnswer_Q_C_Last(
        long questionId, java.lang.String clientId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.events.global.mobile.NoSuchEventPollAnswerException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last event poll answer in the ordered set where questionId = &#63; and clientId = &#63;.
    *
    * @param questionId the question ID
    * @param clientId the client ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching event poll answer, or <code>null</code> if a matching event poll answer could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.events.global.mobile.model.EventPollAnswer fetchByEventPollAnswer_Q_C_Last(
        long questionId, java.lang.String clientId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.liferay.events.global.mobile.model.EventPollAnswer[] findByEventPollAnswer_Q_C_PrevAndNext(
        long answerId, long questionId, java.lang.String clientId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.events.global.mobile.NoSuchEventPollAnswerException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the event poll answers where questionId = &#63; and clientId = &#63; from the database.
    *
    * @param questionId the question ID
    * @param clientId the client ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByEventPollAnswer_Q_C(long questionId,
        java.lang.String clientId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of event poll answers where questionId = &#63; and clientId = &#63;.
    *
    * @param questionId the question ID
    * @param clientId the client ID
    * @return the number of matching event poll answers
    * @throws SystemException if a system exception occurred
    */
    public int countByEventPollAnswer_Q_C(long questionId,
        java.lang.String clientId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the event poll answer in the entity cache if it is enabled.
    *
    * @param eventPollAnswer the event poll answer
    */
    public void cacheResult(
        com.liferay.events.global.mobile.model.EventPollAnswer eventPollAnswer);

    /**
    * Caches the event poll answers in the entity cache if it is enabled.
    *
    * @param eventPollAnswers the event poll answers
    */
    public void cacheResult(
        java.util.List<com.liferay.events.global.mobile.model.EventPollAnswer> eventPollAnswers);

    /**
    * Creates a new event poll answer with the primary key. Does not add the event poll answer to the database.
    *
    * @param answerId the primary key for the new event poll answer
    * @return the new event poll answer
    */
    public com.liferay.events.global.mobile.model.EventPollAnswer create(
        long answerId);

    /**
    * Removes the event poll answer with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param answerId the primary key of the event poll answer
    * @return the event poll answer that was removed
    * @throws com.liferay.events.global.mobile.NoSuchEventPollAnswerException if a event poll answer with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.events.global.mobile.model.EventPollAnswer remove(
        long answerId)
        throws com.liferay.events.global.mobile.NoSuchEventPollAnswerException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.liferay.events.global.mobile.model.EventPollAnswer updateImpl(
        com.liferay.events.global.mobile.model.EventPollAnswer eventPollAnswer)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the event poll answer with the primary key or throws a {@link com.liferay.events.global.mobile.NoSuchEventPollAnswerException} if it could not be found.
    *
    * @param answerId the primary key of the event poll answer
    * @return the event poll answer
    * @throws com.liferay.events.global.mobile.NoSuchEventPollAnswerException if a event poll answer with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.events.global.mobile.model.EventPollAnswer findByPrimaryKey(
        long answerId)
        throws com.liferay.events.global.mobile.NoSuchEventPollAnswerException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the event poll answer with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param answerId the primary key of the event poll answer
    * @return the event poll answer, or <code>null</code> if a event poll answer with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.events.global.mobile.model.EventPollAnswer fetchByPrimaryKey(
        long answerId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the event poll answers.
    *
    * @return the event poll answers
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.liferay.events.global.mobile.model.EventPollAnswer> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.liferay.events.global.mobile.model.EventPollAnswer> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.liferay.events.global.mobile.model.EventPollAnswer> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the event poll answers from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of event poll answers.
    *
    * @return the number of event poll answers
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
