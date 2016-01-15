package com.liferay.events.global.mobile.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for EventPollQuestion. This utility wraps
 * {@link com.liferay.events.global.mobile.service.impl.EventPollQuestionLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author James Falkner
 * @see EventPollQuestionLocalService
 * @see com.liferay.events.global.mobile.service.base.EventPollQuestionLocalServiceBaseImpl
 * @see com.liferay.events.global.mobile.service.impl.EventPollQuestionLocalServiceImpl
 * @generated
 */
public class EventPollQuestionLocalServiceUtil {
    private static EventPollQuestionLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.liferay.events.global.mobile.service.impl.EventPollQuestionLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the event poll question to the database. Also notifies the appropriate model listeners.
    *
    * @param eventPollQuestion the event poll question
    * @return the event poll question that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.events.global.mobile.model.EventPollQuestion addEventPollQuestion(
        com.liferay.events.global.mobile.model.EventPollQuestion eventPollQuestion)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addEventPollQuestion(eventPollQuestion);
    }

    /**
    * Creates a new event poll question with the primary key. Does not add the event poll question to the database.
    *
    * @param questionId the primary key for the new event poll question
    * @return the new event poll question
    */
    public static com.liferay.events.global.mobile.model.EventPollQuestion createEventPollQuestion(
        long questionId) {
        return getService().createEventPollQuestion(questionId);
    }

    /**
    * Deletes the event poll question with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param questionId the primary key of the event poll question
    * @return the event poll question that was removed
    * @throws PortalException if a event poll question with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.events.global.mobile.model.EventPollQuestion deleteEventPollQuestion(
        long questionId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteEventPollQuestion(questionId);
    }

    /**
    * Deletes the event poll question from the database. Also notifies the appropriate model listeners.
    *
    * @param eventPollQuestion the event poll question
    * @return the event poll question that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.events.global.mobile.model.EventPollQuestion deleteEventPollQuestion(
        com.liferay.events.global.mobile.model.EventPollQuestion eventPollQuestion)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteEventPollQuestion(eventPollQuestion);
    }

    public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return getService().dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery);
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
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
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
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery, projection);
    }

    public static com.liferay.events.global.mobile.model.EventPollQuestion fetchEventPollQuestion(
        long questionId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchEventPollQuestion(questionId);
    }

    /**
    * Returns the event poll question with the primary key.
    *
    * @param questionId the primary key of the event poll question
    * @return the event poll question
    * @throws PortalException if a event poll question with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.events.global.mobile.model.EventPollQuestion getEventPollQuestion(
        long questionId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getEventPollQuestion(questionId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
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
    public static java.util.List<com.liferay.events.global.mobile.model.EventPollQuestion> getEventPollQuestions(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getEventPollQuestions(start, end);
    }

    /**
    * Returns the number of event poll questions.
    *
    * @return the number of event poll questions
    * @throws SystemException if a system exception occurred
    */
    public static int getEventPollQuestionsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getEventPollQuestionsCount();
    }

    /**
    * Updates the event poll question in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param eventPollQuestion the event poll question
    * @return the event poll question that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.liferay.events.global.mobile.model.EventPollQuestion updateEventPollQuestion(
        com.liferay.events.global.mobile.model.EventPollQuestion eventPollQuestion)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateEventPollQuestion(eventPollQuestion);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public static java.lang.String getBeanIdentifier() {
        return getService().getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public static void setBeanIdentifier(java.lang.String beanIdentifier) {
        getService().setBeanIdentifier(beanIdentifier);
    }

    public static java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return getService().invokeMethod(name, parameterTypes, arguments);
    }

    public static void deleteAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getService().deleteAll();
    }

    public static java.util.List<java.lang.String> getAllEvents()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getAllEvents();
    }

    public static java.util.List<com.liferay.events.global.mobile.model.EventPollQuestion> getAllQuestionsForEvent(
        java.lang.String eventId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getAllQuestionsForEvent(eventId, start, end);
    }

    public static int getAllQuestionsForEventCount(java.lang.String eventId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getAllQuestionsForEventCount(eventId);
    }

    public static java.util.List<com.liferay.events.global.mobile.model.EventPollQuestion> getAutoEnabled(
        java.util.Date beforeDate)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getAutoEnabled(beforeDate);
    }

    public static com.liferay.events.global.mobile.model.EventPollQuestion addQuestion(
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
        return getService()
                   .addQuestion(eventId, sponsorName, shortTitle, question,
            questionType, chartType, askForId, idIntro, choices,
            anonymousResults, showResponseCount, picUrl, enabled, autoEnable,
            enableTriggerDate, enableTriggerTimezone, serviceContext);
    }

    public static com.liferay.events.global.mobile.model.EventPollQuestion updateQuestion(
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
        return getService()
                   .updateQuestion(questionId, enabled, autoEnable,
            enableTriggerDate, enableTriggerTimezone, eventId, sponsorName,
            shortTitle, question, chartType, askForId, idIntro, questionType,
            choices, anonymousResults, showResponseCount, picUrl, serviceContext);
    }

    public static void clearService() {
        _service = null;
    }

    public static EventPollQuestionLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    EventPollQuestionLocalService.class.getName());

            if (invokableLocalService instanceof EventPollQuestionLocalService) {
                _service = (EventPollQuestionLocalService) invokableLocalService;
            } else {
                _service = new EventPollQuestionLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(EventPollQuestionLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(EventPollQuestionLocalService service) {
    }
}
