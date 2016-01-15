package com.liferay.events.global.mobile.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link MessageService}.
 *
 * @author James Falkner
 * @see MessageService
 * @generated
 */
public class MessageServiceWrapper implements MessageService,
    ServiceWrapper<MessageService> {
    private MessageService _messageService;

    public MessageServiceWrapper(MessageService messageService) {
        _messageService = messageService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _messageService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _messageService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _messageService.invokeMethod(name, parameterTypes, arguments);
    }

    @Override
    public com.liferay.events.global.mobile.model.Message sendMessage(
        java.lang.String eventId, long contactId, long targetContactId,
        java.lang.String message, java.lang.String signature)
        throws java.lang.Exception {
        return _messageService.sendMessage(eventId, contactId, targetContactId,
            message, signature);
    }

    @Override
    public java.util.List<com.liferay.events.global.mobile.model.Message> getMessages(
        java.lang.String eventId, long contactId, long beginDate,
        java.lang.String signature) throws java.lang.Exception {
        return _messageService.getMessages(eventId, contactId, beginDate,
            signature);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public MessageService getWrappedMessageService() {
        return _messageService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedMessageService(MessageService messageService) {
        _messageService = messageService;
    }

    @Override
    public MessageService getWrappedService() {
        return _messageService;
    }

    @Override
    public void setWrappedService(MessageService messageService) {
        _messageService = messageService;
    }
}
