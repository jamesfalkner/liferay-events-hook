package com.liferay.events.global.mobile.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EventContactLocalService}.
 *
 * @author James Falkner
 * @see EventContactLocalService
 * @generated
 */
public class EventContactLocalServiceWrapper implements EventContactLocalService,
    ServiceWrapper<EventContactLocalService> {
    private EventContactLocalService _eventContactLocalService;

    public EventContactLocalServiceWrapper(
        EventContactLocalService eventContactLocalService) {
        _eventContactLocalService = eventContactLocalService;
    }

    /**
    * Adds the event contact to the database. Also notifies the appropriate model listeners.
    *
    * @param eventContact the event contact
    * @return the event contact that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.liferay.events.global.mobile.model.EventContact addEventContact(
        com.liferay.events.global.mobile.model.EventContact eventContact)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _eventContactLocalService.addEventContact(eventContact);
    }

    /**
    * Creates a new event contact with the primary key. Does not add the event contact to the database.
    *
    * @param eventContactId the primary key for the new event contact
    * @return the new event contact
    */
    @Override
    public com.liferay.events.global.mobile.model.EventContact createEventContact(
        long eventContactId) {
        return _eventContactLocalService.createEventContact(eventContactId);
    }

    /**
    * Deletes the event contact with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param eventContactId the primary key of the event contact
    * @return the event contact that was removed
    * @throws PortalException if a event contact with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.liferay.events.global.mobile.model.EventContact deleteEventContact(
        long eventContactId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _eventContactLocalService.deleteEventContact(eventContactId);
    }

    /**
    * Deletes the event contact from the database. Also notifies the appropriate model listeners.
    *
    * @param eventContact the event contact
    * @return the event contact that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.liferay.events.global.mobile.model.EventContact deleteEventContact(
        com.liferay.events.global.mobile.model.EventContact eventContact)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _eventContactLocalService.deleteEventContact(eventContact);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _eventContactLocalService.dynamicQuery();
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
        return _eventContactLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.events.global.mobile.model.impl.EventContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _eventContactLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.events.global.mobile.model.impl.EventContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _eventContactLocalService.dynamicQuery(dynamicQuery, start, end,
            orderByComparator);
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
        return _eventContactLocalService.dynamicQueryCount(dynamicQuery);
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
        return _eventContactLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public com.liferay.events.global.mobile.model.EventContact fetchEventContact(
        long eventContactId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _eventContactLocalService.fetchEventContact(eventContactId);
    }

    /**
    * Returns the event contact with the primary key.
    *
    * @param eventContactId the primary key of the event contact
    * @return the event contact
    * @throws PortalException if a event contact with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.liferay.events.global.mobile.model.EventContact getEventContact(
        long eventContactId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _eventContactLocalService.getEventContact(eventContactId);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _eventContactLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the event contacts.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.events.global.mobile.model.impl.EventContactModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of event contacts
    * @param end the upper bound of the range of event contacts (not inclusive)
    * @return the range of event contacts
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.liferay.events.global.mobile.model.EventContact> getEventContacts(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _eventContactLocalService.getEventContacts(start, end);
    }

    /**
    * Returns the number of event contacts.
    *
    * @return the number of event contacts
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getEventContactsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _eventContactLocalService.getEventContactsCount();
    }

    /**
    * Updates the event contact in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param eventContact the event contact
    * @return the event contact that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.liferay.events.global.mobile.model.EventContact updateEventContact(
        com.liferay.events.global.mobile.model.EventContact eventContact)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _eventContactLocalService.updateEventContact(eventContact);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _eventContactLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _eventContactLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _eventContactLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    @Override
    public void deleteAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        _eventContactLocalService.deleteAll();
    }

    @Override
    public com.liferay.events.global.mobile.model.EventContact addEventContact(
        long userId, long groupId,
        com.liferay.portal.service.ServiceContext serviceContext,
        java.lang.String eventId, java.lang.String givenName,
        java.lang.String fullName, java.lang.String attendeeType,
        java.lang.String emailAddress, java.lang.String city,
        java.lang.String country, double lat, double lng,
        java.lang.String company, java.lang.String jobTitle,
        java.lang.String industry, java.lang.String interests,
        java.lang.String desires, java.lang.String expertise,
        java.lang.String picUrl)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _eventContactLocalService.addEventContact(userId, groupId,
            serviceContext, eventId, givenName, fullName, attendeeType,
            emailAddress, city, country, lat, lng, company, jobTitle, industry,
            interests, desires, expertise, picUrl);
    }

    @Override
    public com.liferay.events.global.mobile.model.EventContact getVerifiedContactByEmailAddress(
        java.lang.String eventId, java.lang.String emailAddress,
        boolean verified)
        throws com.liferay.events.global.mobile.NoSuchEventContactException,
            com.liferay.portal.kernel.exception.SystemException {
        return _eventContactLocalService.getVerifiedContactByEmailAddress(eventId,
            emailAddress, verified);
    }

    @Override
    public com.liferay.events.global.mobile.model.EventContact getContactByEmailAddress(
        java.lang.String eventId, java.lang.String emailAddress)
        throws com.liferay.events.global.mobile.NoSuchEventContactException,
            com.liferay.portal.kernel.exception.SystemException {
        return _eventContactLocalService.getContactByEmailAddress(eventId,
            emailAddress);
    }

    @Override
    public com.liferay.events.global.mobile.model.EventContact getVerifiedContact(
        long eventContactId, boolean verified)
        throws com.liferay.events.global.mobile.NoSuchEventContactException,
            com.liferay.portal.kernel.exception.SystemException {
        return _eventContactLocalService.getVerifiedContact(eventContactId,
            verified);
    }

    @Override
    public com.liferay.events.global.mobile.model.EventContact recordInterest(
        long userId, long groupId,
        com.liferay.portal.service.ServiceContext serviceContext,
        java.lang.String eventId, long contactId, long targetContactId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _eventContactLocalService.recordInterest(userId, groupId,
            serviceContext, eventId, contactId, targetContactId);
    }

    @Override
    public java.util.List<com.liferay.events.global.mobile.model.EventContact> getInterested(
        java.lang.String eventId,
        java.util.Collection<java.lang.Long> uninterestedIds)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _eventContactLocalService.getInterested(eventId, uninterestedIds);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public EventContactLocalService getWrappedEventContactLocalService() {
        return _eventContactLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedEventContactLocalService(
        EventContactLocalService eventContactLocalService) {
        _eventContactLocalService = eventContactLocalService;
    }

    @Override
    public EventContactLocalService getWrappedService() {
        return _eventContactLocalService;
    }

    @Override
    public void setWrappedService(
        EventContactLocalService eventContactLocalService) {
        _eventContactLocalService = eventContactLocalService;
    }
}
