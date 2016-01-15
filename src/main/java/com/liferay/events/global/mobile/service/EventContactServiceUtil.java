package com.liferay.events.global.mobile.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for EventContact. This utility wraps
 * {@link com.liferay.events.global.mobile.service.impl.EventContactServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author James Falkner
 * @see EventContactService
 * @see com.liferay.events.global.mobile.service.base.EventContactServiceBaseImpl
 * @see com.liferay.events.global.mobile.service.impl.EventContactServiceImpl
 * @generated
 */
public class EventContactServiceUtil {
    private static EventContactService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.liferay.events.global.mobile.service.impl.EventContactServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

    public static com.liferay.events.global.mobile.model.EventContact getContact(
        java.lang.String eventId, java.lang.String emailAddress,
        java.lang.String signature) throws java.lang.Exception {
        return getService().getContact(eventId, emailAddress, signature);
    }

    public static com.liferay.events.global.mobile.model.EventContact validateProfile(
        java.lang.String eventId, java.lang.String givenName,
        java.lang.String fullName, java.lang.String emailAddress,
        java.lang.String city, java.lang.String countryCode,
        java.lang.String countryName, java.lang.String picUrl,
        java.lang.String company, java.lang.String industry,
        java.lang.String jobTitle, java.lang.String desires,
        java.lang.String expertise, java.lang.String otherInterests,
        java.lang.String attendeeType, java.lang.String signature)
        throws java.lang.Exception {
        return getService()
                   .validateProfile(eventId, givenName, fullName, emailAddress,
            city, countryCode, countryName, picUrl, company, industry,
            jobTitle, desires, expertise, otherInterests, attendeeType,
            signature);
    }

    public static com.liferay.events.global.mobile.model.EventContact updateProfilePic(
        java.lang.String eventId, long contactId, java.lang.String mimeType,
        java.lang.String extension, java.lang.String bytes,
        java.lang.String signature) throws java.lang.Exception {
        return getService()
                   .updateProfilePic(eventId, contactId, mimeType, extension,
            bytes, signature);
    }

    public static com.liferay.events.global.mobile.model.EventContact updateProfile(
        java.lang.String eventId, long contactId, java.lang.String city,
        java.lang.String country, java.lang.String jobTitle,
        java.lang.String company, java.lang.String industry,
        java.lang.String interests, java.lang.String desires,
        java.lang.String expertise, java.lang.String source,
        java.lang.String picUrl, java.lang.String givenName,
        java.lang.String fullName, java.lang.String signature)
        throws java.lang.Exception {
        return getService()
                   .updateProfile(eventId, contactId, city, country, jobTitle,
            company, industry, interests, desires, expertise, source, picUrl,
            givenName, fullName, signature);
    }

    public static void clearService() {
        _service = null;
    }

    public static EventContactService getService() {
        if (_service == null) {
            InvokableService invokableService = (InvokableService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    EventContactService.class.getName());

            if (invokableService instanceof EventContactService) {
                _service = (EventContactService) invokableService;
            } else {
                _service = new EventContactServiceClp(invokableService);
            }

            ReferenceRegistry.registerReference(EventContactServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(EventContactService service) {
    }
}
