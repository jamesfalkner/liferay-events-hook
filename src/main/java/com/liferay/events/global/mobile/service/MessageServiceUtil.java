package com.liferay.events.global.mobile.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for Message. This utility wraps
 * {@link com.liferay.events.global.mobile.service.impl.MessageServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author James Falkner
 * @see MessageService
 * @see com.liferay.events.global.mobile.service.base.MessageServiceBaseImpl
 * @see com.liferay.events.global.mobile.service.impl.MessageServiceImpl
 * @generated
 */
public class MessageServiceUtil {
    private static MessageService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.liferay.events.global.mobile.service.impl.MessageServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

    public static com.liferay.events.global.mobile.model.Message sendMessage(
        java.lang.String eventId, long contactId, long targetContactId,
        java.lang.String message, java.lang.String signature)
        throws java.lang.Exception {
        return getService()
                   .sendMessage(eventId, contactId, targetContactId, message,
            signature);
    }

    public static java.util.List<com.liferay.events.global.mobile.model.Message> getMessages(
        java.lang.String eventId, long contactId, long beginDate,
        java.lang.String signature) throws java.lang.Exception {
        return getService().getMessages(eventId, contactId, beginDate, signature);
    }

    public static void clearService() {
        _service = null;
    }

    public static MessageService getService() {
        if (_service == null) {
            InvokableService invokableService = (InvokableService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    MessageService.class.getName());

            if (invokableService instanceof MessageService) {
                _service = (MessageService) invokableService;
            } else {
                _service = new MessageServiceClp(invokableService);
            }

            ReferenceRegistry.registerReference(MessageServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(MessageService service) {
    }
}
