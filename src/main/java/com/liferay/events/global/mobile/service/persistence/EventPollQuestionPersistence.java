package com.liferay.events.global.mobile.service.persistence;

import com.liferay.events.global.mobile.model.EventPollQuestion;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the event poll question service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author James Falkner
 * @see EventPollQuestionPersistenceImpl
 * @see EventPollQuestionUtil
 * @generated
 */
public interface EventPollQuestionPersistence extends BasePersistence<EventPollQuestion> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link EventPollQuestionUtil} to access the event poll question persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the event poll questions where autoEnable = &#63; and enabled = &#63; and enableTriggerDate &le; &#63;.
    *
    * @param autoEnable the auto enable
    * @param enabled the enabled
    * @param enableTriggerDate the enable trigger date
    * @return the matching event poll questions
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.liferay.events.global.mobile.model.EventPollQuestion> findByEventPollQuestion_A_E_D(
        boolean autoEnable, boolean enabled, java.util.Date enableTriggerDate)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.liferay.events.global.mobile.model.EventPollQuestion> findByEventPollQuestion_A_E_D(
        boolean autoEnable, boolean enabled, java.util.Date enableTriggerDate,
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.liferay.events.global.mobile.model.EventPollQuestion> findByEventPollQuestion_A_E_D(
        boolean autoEnable, boolean enabled, java.util.Date enableTriggerDate,
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.liferay.events.global.mobile.model.EventPollQuestion findByEventPollQuestion_A_E_D_First(
        boolean autoEnable, boolean enabled, java.util.Date enableTriggerDate,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.events.global.mobile.NoSuchEventPollQuestionException,
            com.liferay.portal.kernel.exception.SystemException;

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
    public com.liferay.events.global.mobile.model.EventPollQuestion fetchByEventPollQuestion_A_E_D_First(
        boolean autoEnable, boolean enabled, java.util.Date enableTriggerDate,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.liferay.events.global.mobile.model.EventPollQuestion findByEventPollQuestion_A_E_D_Last(
        boolean autoEnable, boolean enabled, java.util.Date enableTriggerDate,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.events.global.mobile.NoSuchEventPollQuestionException,
            com.liferay.portal.kernel.exception.SystemException;

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
    public com.liferay.events.global.mobile.model.EventPollQuestion fetchByEventPollQuestion_A_E_D_Last(
        boolean autoEnable, boolean enabled, java.util.Date enableTriggerDate,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.liferay.events.global.mobile.model.EventPollQuestion[] findByEventPollQuestion_A_E_D_PrevAndNext(
        long questionId, boolean autoEnable, boolean enabled,
        java.util.Date enableTriggerDate,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.events.global.mobile.NoSuchEventPollQuestionException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the event poll questions where autoEnable = &#63; and enabled = &#63; and enableTriggerDate &le; &#63; from the database.
    *
    * @param autoEnable the auto enable
    * @param enabled the enabled
    * @param enableTriggerDate the enable trigger date
    * @throws SystemException if a system exception occurred
    */
    public void removeByEventPollQuestion_A_E_D(boolean autoEnable,
        boolean enabled, java.util.Date enableTriggerDate)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of event poll questions where autoEnable = &#63; and enabled = &#63; and enableTriggerDate &le; &#63;.
    *
    * @param autoEnable the auto enable
    * @param enabled the enabled
    * @param enableTriggerDate the enable trigger date
    * @return the number of matching event poll questions
    * @throws SystemException if a system exception occurred
    */
    public int countByEventPollQuestion_A_E_D(boolean autoEnable,
        boolean enabled, java.util.Date enableTriggerDate)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the event poll questions where eventId = &#63;.
    *
    * @param eventId the event ID
    * @return the matching event poll questions
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.liferay.events.global.mobile.model.EventPollQuestion> findByEventPollQuestion_E(
        java.lang.String eventId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.liferay.events.global.mobile.model.EventPollQuestion> findByEventPollQuestion_E(
        java.lang.String eventId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.liferay.events.global.mobile.model.EventPollQuestion> findByEventPollQuestion_E(
        java.lang.String eventId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first event poll question in the ordered set where eventId = &#63;.
    *
    * @param eventId the event ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching event poll question
    * @throws com.liferay.events.global.mobile.NoSuchEventPollQuestionException if a matching event poll question could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.events.global.mobile.model.EventPollQuestion findByEventPollQuestion_E_First(
        java.lang.String eventId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.events.global.mobile.NoSuchEventPollQuestionException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first event poll question in the ordered set where eventId = &#63;.
    *
    * @param eventId the event ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching event poll question, or <code>null</code> if a matching event poll question could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.events.global.mobile.model.EventPollQuestion fetchByEventPollQuestion_E_First(
        java.lang.String eventId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last event poll question in the ordered set where eventId = &#63;.
    *
    * @param eventId the event ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching event poll question
    * @throws com.liferay.events.global.mobile.NoSuchEventPollQuestionException if a matching event poll question could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.events.global.mobile.model.EventPollQuestion findByEventPollQuestion_E_Last(
        java.lang.String eventId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.events.global.mobile.NoSuchEventPollQuestionException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last event poll question in the ordered set where eventId = &#63;.
    *
    * @param eventId the event ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching event poll question, or <code>null</code> if a matching event poll question could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.events.global.mobile.model.EventPollQuestion fetchByEventPollQuestion_E_Last(
        java.lang.String eventId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.liferay.events.global.mobile.model.EventPollQuestion[] findByEventPollQuestion_E_PrevAndNext(
        long questionId, java.lang.String eventId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.events.global.mobile.NoSuchEventPollQuestionException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the event poll questions where eventId = &#63; from the database.
    *
    * @param eventId the event ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByEventPollQuestion_E(java.lang.String eventId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of event poll questions where eventId = &#63;.
    *
    * @param eventId the event ID
    * @return the number of matching event poll questions
    * @throws SystemException if a system exception occurred
    */
    public int countByEventPollQuestion_E(java.lang.String eventId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the event poll questions where eventId = &#63; and enabled = &#63;.
    *
    * @param eventId the event ID
    * @param enabled the enabled
    * @return the matching event poll questions
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.liferay.events.global.mobile.model.EventPollQuestion> findByEventPollQuestion_E_E(
        java.lang.String eventId, boolean enabled)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.liferay.events.global.mobile.model.EventPollQuestion> findByEventPollQuestion_E_E(
        java.lang.String eventId, boolean enabled, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.liferay.events.global.mobile.model.EventPollQuestion> findByEventPollQuestion_E_E(
        java.lang.String eventId, boolean enabled, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.liferay.events.global.mobile.model.EventPollQuestion findByEventPollQuestion_E_E_First(
        java.lang.String eventId, boolean enabled,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.events.global.mobile.NoSuchEventPollQuestionException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first event poll question in the ordered set where eventId = &#63; and enabled = &#63;.
    *
    * @param eventId the event ID
    * @param enabled the enabled
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching event poll question, or <code>null</code> if a matching event poll question could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.events.global.mobile.model.EventPollQuestion fetchByEventPollQuestion_E_E_First(
        java.lang.String eventId, boolean enabled,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.liferay.events.global.mobile.model.EventPollQuestion findByEventPollQuestion_E_E_Last(
        java.lang.String eventId, boolean enabled,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.events.global.mobile.NoSuchEventPollQuestionException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last event poll question in the ordered set where eventId = &#63; and enabled = &#63;.
    *
    * @param eventId the event ID
    * @param enabled the enabled
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching event poll question, or <code>null</code> if a matching event poll question could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.events.global.mobile.model.EventPollQuestion fetchByEventPollQuestion_E_E_Last(
        java.lang.String eventId, boolean enabled,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.liferay.events.global.mobile.model.EventPollQuestion[] findByEventPollQuestion_E_E_PrevAndNext(
        long questionId, java.lang.String eventId, boolean enabled,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.events.global.mobile.NoSuchEventPollQuestionException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the event poll questions where eventId = &#63; and enabled = &#63; from the database.
    *
    * @param eventId the event ID
    * @param enabled the enabled
    * @throws SystemException if a system exception occurred
    */
    public void removeByEventPollQuestion_E_E(java.lang.String eventId,
        boolean enabled)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of event poll questions where eventId = &#63; and enabled = &#63;.
    *
    * @param eventId the event ID
    * @param enabled the enabled
    * @return the number of matching event poll questions
    * @throws SystemException if a system exception occurred
    */
    public int countByEventPollQuestion_E_E(java.lang.String eventId,
        boolean enabled)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the event poll question in the entity cache if it is enabled.
    *
    * @param eventPollQuestion the event poll question
    */
    public void cacheResult(
        com.liferay.events.global.mobile.model.EventPollQuestion eventPollQuestion);

    /**
    * Caches the event poll questions in the entity cache if it is enabled.
    *
    * @param eventPollQuestions the event poll questions
    */
    public void cacheResult(
        java.util.List<com.liferay.events.global.mobile.model.EventPollQuestion> eventPollQuestions);

    /**
    * Creates a new event poll question with the primary key. Does not add the event poll question to the database.
    *
    * @param questionId the primary key for the new event poll question
    * @return the new event poll question
    */
    public com.liferay.events.global.mobile.model.EventPollQuestion create(
        long questionId);

    /**
    * Removes the event poll question with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param questionId the primary key of the event poll question
    * @return the event poll question that was removed
    * @throws com.liferay.events.global.mobile.NoSuchEventPollQuestionException if a event poll question with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.events.global.mobile.model.EventPollQuestion remove(
        long questionId)
        throws com.liferay.events.global.mobile.NoSuchEventPollQuestionException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.liferay.events.global.mobile.model.EventPollQuestion updateImpl(
        com.liferay.events.global.mobile.model.EventPollQuestion eventPollQuestion)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the event poll question with the primary key or throws a {@link com.liferay.events.global.mobile.NoSuchEventPollQuestionException} if it could not be found.
    *
    * @param questionId the primary key of the event poll question
    * @return the event poll question
    * @throws com.liferay.events.global.mobile.NoSuchEventPollQuestionException if a event poll question with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.events.global.mobile.model.EventPollQuestion findByPrimaryKey(
        long questionId)
        throws com.liferay.events.global.mobile.NoSuchEventPollQuestionException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the event poll question with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param questionId the primary key of the event poll question
    * @return the event poll question, or <code>null</code> if a event poll question with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.events.global.mobile.model.EventPollQuestion fetchByPrimaryKey(
        long questionId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the event poll questions.
    *
    * @return the event poll questions
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.liferay.events.global.mobile.model.EventPollQuestion> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.liferay.events.global.mobile.model.EventPollQuestion> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.liferay.events.global.mobile.model.EventPollQuestion> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the event poll questions from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of event poll questions.
    *
    * @return the number of event poll questions
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
