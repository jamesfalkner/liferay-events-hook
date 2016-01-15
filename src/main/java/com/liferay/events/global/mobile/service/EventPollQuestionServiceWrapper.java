package com.liferay.events.global.mobile.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EventPollQuestionService}.
 *
 * @author James Falkner
 * @see EventPollQuestionService
 * @generated
 */
public class EventPollQuestionServiceWrapper implements EventPollQuestionService,
    ServiceWrapper<EventPollQuestionService> {
    private EventPollQuestionService _eventPollQuestionService;

    public EventPollQuestionServiceWrapper(
        EventPollQuestionService eventPollQuestionService) {
        _eventPollQuestionService = eventPollQuestionService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _eventPollQuestionService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _eventPollQuestionService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _eventPollQuestionService.invokeMethod(name, parameterTypes,
            arguments);
    }

    @Override
    public java.util.List<com.liferay.events.global.mobile.model.EventPollQuestion> getQuestions(
        java.lang.String eventId, boolean enabled) throws java.lang.Exception {
        return _eventPollQuestionService.getQuestions(eventId, enabled);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public EventPollQuestionService getWrappedEventPollQuestionService() {
        return _eventPollQuestionService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedEventPollQuestionService(
        EventPollQuestionService eventPollQuestionService) {
        _eventPollQuestionService = eventPollQuestionService;
    }

    @Override
    public EventPollQuestionService getWrappedService() {
        return _eventPollQuestionService;
    }

    @Override
    public void setWrappedService(
        EventPollQuestionService eventPollQuestionService) {
        _eventPollQuestionService = eventPollQuestionService;
    }
}
