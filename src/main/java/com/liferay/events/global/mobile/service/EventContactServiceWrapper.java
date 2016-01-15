package com.liferay.events.global.mobile.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EventContactService}.
 *
 * @author James Falkner
 * @see EventContactService
 * @generated
 */
public class EventContactServiceWrapper implements EventContactService,
    ServiceWrapper<EventContactService> {
    private EventContactService _eventContactService;

    public EventContactServiceWrapper(EventContactService eventContactService) {
        _eventContactService = eventContactService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _eventContactService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _eventContactService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _eventContactService.invokeMethod(name, parameterTypes, arguments);
    }

    @Override
    public com.liferay.events.global.mobile.model.EventContact getContact(
        java.lang.String eventId, java.lang.String emailAddress,
        java.lang.String signature) throws java.lang.Exception {
        return _eventContactService.getContact(eventId, emailAddress, signature);
    }

    @Override
    public com.liferay.events.global.mobile.model.EventContact validateProfile(
        java.lang.String eventId, java.lang.String givenName,
        java.lang.String fullName, java.lang.String emailAddress,
        java.lang.String city, java.lang.String countryCode,
        java.lang.String countryName, java.lang.String picUrl,
        java.lang.String company, java.lang.String industry,
        java.lang.String jobTitle, java.lang.String desires,
        java.lang.String expertise, java.lang.String otherInterests,
        java.lang.String attendeeType, java.lang.String signature)
        throws java.lang.Exception {
        return _eventContactService.validateProfile(eventId, givenName,
            fullName, emailAddress, city, countryCode, countryName, picUrl,
            company, industry, jobTitle, desires, expertise, otherInterests,
            attendeeType, signature);
    }

    @Override
    public com.liferay.events.global.mobile.model.EventContact updateProfilePic(
        java.lang.String eventId, long contactId, java.lang.String mimeType,
        java.lang.String extension, java.lang.String bytes,
        java.lang.String signature) throws java.lang.Exception {
        return _eventContactService.updateProfilePic(eventId, contactId,
            mimeType, extension, bytes, signature);
    }

    @Override
    public com.liferay.events.global.mobile.model.EventContact updateProfile(
        java.lang.String eventId, long contactId, java.lang.String city,
        java.lang.String country, java.lang.String jobTitle,
        java.lang.String company, java.lang.String industry,
        java.lang.String interests, java.lang.String desires,
        java.lang.String expertise, java.lang.String source,
        java.lang.String picUrl, java.lang.String givenName,
        java.lang.String fullName, java.lang.String signature)
        throws java.lang.Exception {
        return _eventContactService.updateProfile(eventId, contactId, city,
            country, jobTitle, company, industry, interests, desires,
            expertise, source, picUrl, givenName, fullName, signature);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public EventContactService getWrappedEventContactService() {
        return _eventContactService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedEventContactService(
        EventContactService eventContactService) {
        _eventContactService = eventContactService;
    }

    @Override
    public EventContactService getWrappedService() {
        return _eventContactService;
    }

    @Override
    public void setWrappedService(EventContactService eventContactService) {
        _eventContactService = eventContactService;
    }
}
