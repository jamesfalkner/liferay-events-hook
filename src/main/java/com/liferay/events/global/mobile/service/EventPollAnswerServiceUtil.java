package com.liferay.events.global.mobile.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for EventPollAnswer. This utility wraps
 * {@link com.liferay.events.global.mobile.service.impl.EventPollAnswerServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author James Falkner
 * @see EventPollAnswerService
 * @see com.liferay.events.global.mobile.service.base.EventPollAnswerServiceBaseImpl
 * @see com.liferay.events.global.mobile.service.impl.EventPollAnswerServiceImpl
 * @generated
 */
public class EventPollAnswerServiceUtil {
    private static EventPollAnswerService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.liferay.events.global.mobile.service.impl.EventPollAnswerServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

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

    public static com.liferay.events.global.mobile.model.EventPollAnswer submitAnswer(
        long questionId, java.lang.String clientId, java.lang.String payload,
        java.lang.String answer, java.lang.String signature)
        throws com.liferay.events.global.mobile.InvalidSignatureException,
            com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .submitAnswer(questionId, clientId, payload, answer,
            signature);
    }

    public static java.util.List<java.lang.String> getAnswers(long questionId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getAnswers(questionId);
    }

    public static void clearService() {
        _service = null;
    }

    public static EventPollAnswerService getService() {
        if (_service == null) {
            InvokableService invokableService = (InvokableService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    EventPollAnswerService.class.getName());

            if (invokableService instanceof EventPollAnswerService) {
                _service = (EventPollAnswerService) invokableService;
            } else {
                _service = new EventPollAnswerServiceClp(invokableService);
            }

            ReferenceRegistry.registerReference(EventPollAnswerServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(EventPollAnswerService service) {
    }
}
