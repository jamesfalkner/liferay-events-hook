package com.liferay.events.global.mobile.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EventPollAnswerService}.
 *
 * @author James Falkner
 * @see EventPollAnswerService
 * @generated
 */
public class EventPollAnswerServiceWrapper implements EventPollAnswerService,
    ServiceWrapper<EventPollAnswerService> {
    private EventPollAnswerService _eventPollAnswerService;

    public EventPollAnswerServiceWrapper(
        EventPollAnswerService eventPollAnswerService) {
        _eventPollAnswerService = eventPollAnswerService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _eventPollAnswerService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _eventPollAnswerService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _eventPollAnswerService.invokeMethod(name, parameterTypes,
            arguments);
    }

    @Override
    public com.liferay.events.global.mobile.model.EventPollAnswer submitAnswer(
        long questionId, java.lang.String clientId, java.lang.String payload,
        java.lang.String answer, java.lang.String signature)
        throws com.liferay.events.global.mobile.InvalidSignatureException,
            com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _eventPollAnswerService.submitAnswer(questionId, clientId,
            payload, answer, signature);
    }

    @Override
    public java.util.List<java.lang.String> getAnswers(long questionId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _eventPollAnswerService.getAnswers(questionId);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public EventPollAnswerService getWrappedEventPollAnswerService() {
        return _eventPollAnswerService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedEventPollAnswerService(
        EventPollAnswerService eventPollAnswerService) {
        _eventPollAnswerService = eventPollAnswerService;
    }

    @Override
    public EventPollAnswerService getWrappedService() {
        return _eventPollAnswerService;
    }

    @Override
    public void setWrappedService(EventPollAnswerService eventPollAnswerService) {
        _eventPollAnswerService = eventPollAnswerService;
    }
}
