package com.liferay.events.global.mobile.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for Match. This utility wraps
 * {@link com.liferay.events.global.mobile.service.impl.MatchServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author James Falkner
 * @see MatchService
 * @see com.liferay.events.global.mobile.service.base.MatchServiceBaseImpl
 * @see com.liferay.events.global.mobile.service.impl.MatchServiceImpl
 * @generated
 */
public class MatchServiceUtil {
    private static MatchService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.liferay.events.global.mobile.service.impl.MatchServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

    public static com.liferay.events.global.mobile.model.EventContact recordInterest(
        java.lang.String eventId, long contactId, long targetContactId,
        java.lang.String signature) throws java.lang.Exception {
        return getService()
                   .recordInterest(eventId, contactId, targetContactId,
            signature);
    }

    public static boolean unlink(java.lang.String eventId, long contactId,
        long targetContactId, java.lang.String signature)
        throws java.lang.Exception {
        return getService()
                   .unlink(eventId, contactId, targetContactId, signature);
    }

    public static java.util.List<com.liferay.events.global.mobile.model.EventContact> getMatches(
        java.lang.String eventId, long contactId, java.lang.String signature)
        throws java.lang.Exception {
        return getService().getMatches(eventId, contactId, signature);
    }

    public static java.util.List<com.liferay.events.global.mobile.portlet.Candidate> getCandidates(
        java.lang.String eventId, long contactId, int max,
        java.util.List<java.lang.Long> uninterestedIds,
        java.lang.String signature) throws java.lang.Exception {
        return getService()
                   .getCandidates(eventId, contactId, max, uninterestedIds,
            signature);
    }

    public static void clearService() {
        _service = null;
    }

    public static MatchService getService() {
        if (_service == null) {
            InvokableService invokableService = (InvokableService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    MatchService.class.getName());

            if (invokableService instanceof MatchService) {
                _service = (MatchService) invokableService;
            } else {
                _service = new MatchServiceClp(invokableService);
            }

            ReferenceRegistry.registerReference(MatchServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(MatchService service) {
    }
}
