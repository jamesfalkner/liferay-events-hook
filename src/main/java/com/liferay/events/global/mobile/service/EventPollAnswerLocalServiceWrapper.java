package com.liferay.events.global.mobile.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EventPollAnswerLocalService}.
 *
 * @author James Falkner
 * @see EventPollAnswerLocalService
 * @generated
 */
public class EventPollAnswerLocalServiceWrapper
    implements EventPollAnswerLocalService,
        ServiceWrapper<EventPollAnswerLocalService> {
    private EventPollAnswerLocalService _eventPollAnswerLocalService;

    public EventPollAnswerLocalServiceWrapper(
        EventPollAnswerLocalService eventPollAnswerLocalService) {
        _eventPollAnswerLocalService = eventPollAnswerLocalService;
    }

    /**
    * Adds the event poll answer to the database. Also notifies the appropriate model listeners.
    *
    * @param eventPollAnswer the event poll answer
    * @return the event poll answer that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.liferay.events.global.mobile.model.EventPollAnswer addEventPollAnswer(
        com.liferay.events.global.mobile.model.EventPollAnswer eventPollAnswer)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _eventPollAnswerLocalService.addEventPollAnswer(eventPollAnswer);
    }

    /**
    * Creates a new event poll answer with the primary key. Does not add the event poll answer to the database.
    *
    * @param answerId the primary key for the new event poll answer
    * @return the new event poll answer
    */
    @Override
    public com.liferay.events.global.mobile.model.EventPollAnswer createEventPollAnswer(
        long answerId) {
        return _eventPollAnswerLocalService.createEventPollAnswer(answerId);
    }

    /**
    * Deletes the event poll answer with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param answerId the primary key of the event poll answer
    * @return the event poll answer that was removed
    * @throws PortalException if a event poll answer with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.liferay.events.global.mobile.model.EventPollAnswer deleteEventPollAnswer(
        long answerId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _eventPollAnswerLocalService.deleteEventPollAnswer(answerId);
    }

    /**
    * Deletes the event poll answer from the database. Also notifies the appropriate model listeners.
    *
    * @param eventPollAnswer the event poll answer
    * @return the event poll answer that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.liferay.events.global.mobile.model.EventPollAnswer deleteEventPollAnswer(
        com.liferay.events.global.mobile.model.EventPollAnswer eventPollAnswer)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _eventPollAnswerLocalService.deleteEventPollAnswer(eventPollAnswer);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _eventPollAnswerLocalService.dynamicQuery();
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
        return _eventPollAnswerLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.events.global.mobile.model.impl.EventPollAnswerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _eventPollAnswerLocalService.dynamicQuery(dynamicQuery, start,
            end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.events.global.mobile.model.impl.EventPollAnswerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
        return _eventPollAnswerLocalService.dynamicQuery(dynamicQuery, start,
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
        return _eventPollAnswerLocalService.dynamicQueryCount(dynamicQuery);
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
        return _eventPollAnswerLocalService.dynamicQueryCount(dynamicQuery,
            projection);
    }

    @Override
    public com.liferay.events.global.mobile.model.EventPollAnswer fetchEventPollAnswer(
        long answerId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _eventPollAnswerLocalService.fetchEventPollAnswer(answerId);
    }

    /**
    * Returns the event poll answer with the primary key.
    *
    * @param answerId the primary key of the event poll answer
    * @return the event poll answer
    * @throws PortalException if a event poll answer with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.liferay.events.global.mobile.model.EventPollAnswer getEventPollAnswer(
        long answerId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _eventPollAnswerLocalService.getEventPollAnswer(answerId);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _eventPollAnswerLocalService.getPersistedModel(primaryKeyObj);
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
    @Override
    public java.util.List<com.liferay.events.global.mobile.model.EventPollAnswer> getEventPollAnswers(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _eventPollAnswerLocalService.getEventPollAnswers(start, end);
    }

    /**
    * Returns the number of event poll answers.
    *
    * @return the number of event poll answers
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getEventPollAnswersCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _eventPollAnswerLocalService.getEventPollAnswersCount();
    }

    /**
    * Updates the event poll answer in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param eventPollAnswer the event poll answer
    * @return the event poll answer that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.liferay.events.global.mobile.model.EventPollAnswer updateEventPollAnswer(
        com.liferay.events.global.mobile.model.EventPollAnswer eventPollAnswer)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _eventPollAnswerLocalService.updateEventPollAnswer(eventPollAnswer);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _eventPollAnswerLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _eventPollAnswerLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _eventPollAnswerLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    @Override
    public void deleteAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        _eventPollAnswerLocalService.deleteAll();
    }

    @Override
    public java.util.List<com.liferay.events.global.mobile.model.EventPollAnswer> getAllAnswerObjs(
        long questionId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _eventPollAnswerLocalService.getAllAnswerObjs(questionId);
    }

    @Override
    public java.util.List<java.lang.String> getAllAnswers(long questionId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _eventPollAnswerLocalService.getAllAnswers(questionId);
    }

    @Override
    public void deleteAnswersForQuestion(long questionId)
        throws com.liferay.events.global.mobile.NoSuchEventPollAnswerException,
            com.liferay.portal.kernel.exception.SystemException {
        _eventPollAnswerLocalService.deleteAnswersForQuestion(questionId);
    }

    @Override
    public long countAnswers(long questionId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _eventPollAnswerLocalService.countAnswers(questionId);
    }

    @Override
    public com.liferay.events.global.mobile.model.EventPollAnswer addAnswer(
        long questionId, java.lang.String clientId, java.lang.String payload,
        java.lang.String answer,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _eventPollAnswerLocalService.addAnswer(questionId, clientId,
            payload, answer, serviceContext);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public EventPollAnswerLocalService getWrappedEventPollAnswerLocalService() {
        return _eventPollAnswerLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedEventPollAnswerLocalService(
        EventPollAnswerLocalService eventPollAnswerLocalService) {
        _eventPollAnswerLocalService = eventPollAnswerLocalService;
    }

    @Override
    public EventPollAnswerLocalService getWrappedService() {
        return _eventPollAnswerLocalService;
    }

    @Override
    public void setWrappedService(
        EventPollAnswerLocalService eventPollAnswerLocalService) {
        _eventPollAnswerLocalService = eventPollAnswerLocalService;
    }
}
