package com.liferay.events.global.mobile.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EventPollQuestionLocalService}.
 *
 * @author James Falkner
 * @see EventPollQuestionLocalService
 * @generated
 */
public class EventPollQuestionLocalServiceWrapper
    implements EventPollQuestionLocalService,
        ServiceWrapper<EventPollQuestionLocalService> {
    private EventPollQuestionLocalService _eventPollQuestionLocalService;

    public EventPollQuestionLocalServiceWrapper(
        EventPollQuestionLocalService eventPollQuestionLocalService) {
        _eventPollQuestionLocalService = eventPollQuestionLocalService;
    }

    /**
    * Adds the event poll question to the database. Also notifies the appropriate model listeners.
    *
    * @param eventPollQuestion the event poll question
    * @return the event poll question that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.liferay.events.global.mobile.model.EventPollQuestion addEventPollQuestion(
        com.liferay.events.global.mobile.model.EventPollQuestion eventPollQuestion)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _eventPollQuestionLocalService.addEventPollQuestion(eventPollQuestion);
    }

    /**
    * Creates a new event poll question with the primary key. Does not add the event poll question to the database.
    *
    * @param questionId the primary key for the new event poll question
    * @return the new event poll question
    */
    @Override
    public com.liferay.events.global.mobile.model.EventPollQuestion createEventPollQuestion(
        long questionId) {
        return _eventPollQuestionLocalService.createEventPollQuestion(questionId);
    }

    /**
    * Deletes the event poll question with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param questionId the primary key of the event poll question
    * @return the event poll question that was removed
    * @throws PortalException if a event poll question with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.liferay.events.global.mobile.model.EventPollQuestion deleteEventPollQuestion(
        long questionId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _eventPollQuestionLocalService.deleteEventPollQuestion(questionId);
    }

    /**
    * Deletes the event poll question from the database. Also notifies the appropriate model listeners.
    *
    * @param eventPollQuestion the event poll question
    * @return the event poll question that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.liferay.events.global.mobile.model.EventPollQuestion deleteEventPollQuestion(
        com.liferay.events.global.mobile.model.EventPollQuestion eventPollQuestion)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _eventPollQuestionLocalService.deleteEventPollQuestion(eventPollQuestion);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _eventPollQuestionLocalService.dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _eventPollQuestionLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.events.global.mobile.model.impl.EventPollQuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _eventPollQuestionLocalService.dynamicQuery(dynamicQuery, start,
            end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.events.global.mobile.model.impl.EventPollQuestionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _eventPollQuestionLocalService.dynamicQuery(dynamicQuery, start,
            end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _eventPollQuestionLocalService.dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _eventPollQuestionLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public com.liferay.events.global.mobile.model.EventPollQuestion fetchEventPollQuestion(
        long questionId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _eventPollQuestionLocalService.fetchEventPollQuestion(questionId);
    }

    /**
    * Returns the event poll question with the primary key.
    *
    * @param questionId the primary key of the event poll question
    * @return the event poll question
    * @throws PortalException if a event poll question with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.liferay.events.global.mobile.model.EventPollQuestion getEventPollQuestion(
        long questionId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _eventPollQuestionLocalService.getEventPollQuestion(questionId);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _eventPollQuestionLocalService.getPersistedModel(primaryKeyObj);
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
    public java.util.List<com.liferay.events.global.mobile.model.EventPollQuestion> getEventPollQuestions(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _eventPollQuestionLocalService.getEventPollQuestions(start, end);
    }

    /**
    * Returns the number of event poll questions.
    *
    * @return the number of event poll questions
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getEventPollQuestionsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _eventPollQuestionLocalService.getEventPollQuestionsCount();
    }

    /**
    * Updates the event poll question in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param eventPollQuestion the event poll question
    * @return the event poll question that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.liferay.events.global.mobile.model.EventPollQuestion updateEventPollQuestion(
        com.liferay.events.global.mobile.model.EventPollQuestion eventPollQuestion)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _eventPollQuestionLocalService.updateEventPollQuestion(eventPollQuestion);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _eventPollQuestionLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _eventPollQuestionLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _eventPollQuestionLocalService.invokeMethod(name,
            parameterTypes, arguments);
    }

    @Override
    public void deleteAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        _eventPollQuestionLocalService.deleteAll();
    }

    @Override
    public java.util.List<java.lang.String> getAllEvents()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _eventPollQuestionLocalService.getAllEvents();
    }

    @Override
    public java.util.List<com.liferay.events.global.mobile.model.EventPollQuestion> getAllQuestionsForEvent(
        java.lang.String eventId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _eventPollQuestionLocalService.getAllQuestionsForEvent(eventId,
            start, end);
    }

    @Override
    public int getAllQuestionsForEventCount(java.lang.String eventId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _eventPollQuestionLocalService.getAllQuestionsForEventCount(eventId);
    }

    @Override
    public java.util.List<com.liferay.events.global.mobile.model.EventPollQuestion> getAutoEnabled(
        java.util.Date beforeDate)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _eventPollQuestionLocalService.getAutoEnabled(beforeDate);
    }

    @Override
    public com.liferay.events.global.mobile.model.EventPollQuestion addQuestion(
        java.lang.String eventId, java.lang.String sponsorName,
        java.lang.String shortTitle, java.lang.String question,
        java.lang.String questionType, java.lang.String chartType,
        boolean askForId, java.lang.String idIntro, java.lang.String choices,
        boolean anonymousResults, boolean showResponseCount,
        java.lang.String picUrl, boolean enabled, boolean autoEnable,
        java.util.Date enableTriggerDate,
        java.lang.String enableTriggerTimezone,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _eventPollQuestionLocalService.addQuestion(eventId, sponsorName,
            shortTitle, question, questionType, chartType, askForId, idIntro,
            choices, anonymousResults, showResponseCount, picUrl, enabled,
            autoEnable, enableTriggerDate, enableTriggerTimezone, serviceContext);
    }

    @Override
    public com.liferay.events.global.mobile.model.EventPollQuestion updateQuestion(
        long questionId, boolean enabled, boolean autoEnable,
        java.util.Date enableTriggerDate,
        java.lang.String enableTriggerTimezone, java.lang.String eventId,
        java.lang.String sponsorName, java.lang.String shortTitle,
        java.lang.String question, java.lang.String chartType,
        boolean askForId, java.lang.String idIntro,
        java.lang.String questionType, java.lang.String choices,
        boolean anonymousResults, boolean showResponseCount,
        java.lang.String picUrl,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _eventPollQuestionLocalService.updateQuestion(questionId,
            enabled, autoEnable, enableTriggerDate, enableTriggerTimezone,
            eventId, sponsorName, shortTitle, question, chartType, askForId,
            idIntro, questionType, choices, anonymousResults,
            showResponseCount, picUrl, serviceContext);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public EventPollQuestionLocalService getWrappedEventPollQuestionLocalService() {
        return _eventPollQuestionLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedEventPollQuestionLocalService(
        EventPollQuestionLocalService eventPollQuestionLocalService) {
        _eventPollQuestionLocalService = eventPollQuestionLocalService;
    }

    @Override
    public EventPollQuestionLocalService getWrappedService() {
        return _eventPollQuestionLocalService;
    }

    @Override
    public void setWrappedService(
        EventPollQuestionLocalService eventPollQuestionLocalService) {
        _eventPollQuestionLocalService = eventPollQuestionLocalService;
    }
}
