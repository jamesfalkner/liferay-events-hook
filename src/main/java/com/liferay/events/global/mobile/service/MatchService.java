package com.liferay.events.global.mobile.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.security.ac.AccessControlled;
import com.liferay.portal.service.BaseService;
import com.liferay.portal.service.InvokableService;

import java.util.*;

/**
 * Provides the remote service interface for Match. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author James Falkner
 * @see MatchServiceUtil
 * @see com.liferay.events.global.mobile.service.base.MatchServiceBaseImpl
 * @see com.liferay.events.global.mobile.service.impl.MatchServiceImpl
 * @generated
 */
@AccessControlled
@JSONWebService
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface MatchService extends BaseService, InvokableService {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link MatchServiceUtil} to access the match remote service. Add custom service methods to {@link com.liferay.events.global.mobile.service.impl.MatchServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
     */

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier();

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier);

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable;

    @com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
    public com.liferay.events.global.mobile.model.EventContact recordInterest(
        java.lang.String eventId, long contactId, long targetContactId,
        java.lang.String signature) throws java.lang.Exception;

    @com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
    public boolean unlink(java.lang.String eventId, long contactId,
        long targetContactId, java.lang.String signature)
        throws java.lang.Exception;

    @com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.liferay.events.global.mobile.model.EventContact> getMatches(
        java.lang.String eventId, long contactId, java.lang.String signature)
        throws java.lang.Exception;

    @com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public java.util.List<com.liferay.events.global.mobile.portlet.Candidate> getCandidates(
        java.lang.String eventId, long contactId, int max,
        java.util.List<java.lang.Long> uninterestedIds,
        java.lang.String signature) throws java.lang.Exception;
}
