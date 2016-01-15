package com.liferay.events.global.mobile.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.*;
import com.liferay.portal.security.ac.AccessControlled;
import com.liferay.portal.service.BaseService;
import com.liferay.portal.service.InvokableService;

import java.io.*;

import java.util.*;

/**
 * Provides the remote service interface for EventContact. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author James Falkner
 * @see EventContactServiceUtil
 * @see com.liferay.events.global.mobile.service.base.EventContactServiceBaseImpl
 * @see com.liferay.events.global.mobile.service.impl.EventContactServiceImpl
 * @generated
 */
@AccessControlled
@JSONWebService
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
    PortalException.class, SystemException.class}
)
public interface EventContactService extends BaseService, InvokableService {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link EventContactServiceUtil} to access the event contact remote service. Add custom service methods to {@link com.liferay.events.global.mobile.service.impl.EventContactServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
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
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public com.liferay.events.global.mobile.model.EventContact getContact(
        java.lang.String eventId, java.lang.String emailAddress,
        java.lang.String signature) throws java.lang.Exception;

    @com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
    public com.liferay.events.global.mobile.model.EventContact validateProfile(
        java.lang.String eventId, java.lang.String givenName,
        java.lang.String fullName, java.lang.String emailAddress,
        java.lang.String city, java.lang.String countryCode,
        java.lang.String countryName, java.lang.String picUrl,
        java.lang.String company, java.lang.String industry,
        java.lang.String jobTitle, java.lang.String desires,
        java.lang.String expertise, java.lang.String otherInterests,
        java.lang.String attendeeType, java.lang.String signature)
        throws java.lang.Exception;

    @com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
    public com.liferay.events.global.mobile.model.EventContact updateProfilePic(
        java.lang.String eventId, long contactId, java.lang.String mimeType,
        java.lang.String extension, java.lang.String bytes,
        java.lang.String signature) throws java.lang.Exception;

    @com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
    public com.liferay.events.global.mobile.model.EventContact updateProfile(
        java.lang.String eventId, long contactId, java.lang.String city,
        java.lang.String country, java.lang.String jobTitle,
        java.lang.String company, java.lang.String industry,
        java.lang.String interests, java.lang.String desires,
        java.lang.String expertise, java.lang.String source,
        java.lang.String picUrl, java.lang.String givenName,
        java.lang.String fullName, java.lang.String signature)
        throws java.lang.Exception;
}
