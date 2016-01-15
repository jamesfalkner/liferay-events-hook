package com.liferay.events.global.mobile.service.http;

import com.liferay.events.global.mobile.service.EventContactServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link com.liferay.events.global.mobile.service.EventContactServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.liferay.events.global.mobile.model.EventContactSoap}.
 * If the method in the service utility returns a
 * {@link com.liferay.events.global.mobile.model.EventContact}, that is translated to a
 * {@link com.liferay.events.global.mobile.model.EventContactSoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author James Falkner
 * @see EventContactServiceHttp
 * @see com.liferay.events.global.mobile.model.EventContactSoap
 * @see com.liferay.events.global.mobile.service.EventContactServiceUtil
 * @generated
 */
public class EventContactServiceSoap {
    private static Log _log = LogFactoryUtil.getLog(EventContactServiceSoap.class);

    public static com.liferay.events.global.mobile.model.EventContactSoap getContact(
        java.lang.String eventId, java.lang.String emailAddress,
        java.lang.String signature) throws RemoteException {
        try {
            com.liferay.events.global.mobile.model.EventContact returnValue = EventContactServiceUtil.getContact(eventId,
                    emailAddress, signature);

            return com.liferay.events.global.mobile.model.EventContactSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.liferay.events.global.mobile.model.EventContactSoap validateProfile(
        java.lang.String eventId, java.lang.String givenName,
        java.lang.String fullName, java.lang.String emailAddress,
        java.lang.String city, java.lang.String countryCode,
        java.lang.String countryName, java.lang.String picUrl,
        java.lang.String company, java.lang.String industry,
        java.lang.String jobTitle, java.lang.String desires,
        java.lang.String expertise, java.lang.String otherInterests,
        java.lang.String attendeeType, java.lang.String signature)
        throws RemoteException {
        try {
            com.liferay.events.global.mobile.model.EventContact returnValue = EventContactServiceUtil.validateProfile(eventId,
                    givenName, fullName, emailAddress, city, countryCode,
                    countryName, picUrl, company, industry, jobTitle, desires,
                    expertise, otherInterests, attendeeType, signature);

            return com.liferay.events.global.mobile.model.EventContactSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.liferay.events.global.mobile.model.EventContactSoap updateProfilePic(
        java.lang.String eventId, long contactId, java.lang.String mimeType,
        java.lang.String extension, java.lang.String bytes,
        java.lang.String signature) throws RemoteException {
        try {
            com.liferay.events.global.mobile.model.EventContact returnValue = EventContactServiceUtil.updateProfilePic(eventId,
                    contactId, mimeType, extension, bytes, signature);

            return com.liferay.events.global.mobile.model.EventContactSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.liferay.events.global.mobile.model.EventContactSoap updateProfile(
        java.lang.String eventId, long contactId, java.lang.String city,
        java.lang.String country, java.lang.String jobTitle,
        java.lang.String company, java.lang.String industry,
        java.lang.String interests, java.lang.String desires,
        java.lang.String expertise, java.lang.String source,
        java.lang.String picUrl, java.lang.String givenName,
        java.lang.String fullName, java.lang.String signature)
        throws RemoteException {
        try {
            com.liferay.events.global.mobile.model.EventContact returnValue = EventContactServiceUtil.updateProfile(eventId,
                    contactId, city, country, jobTitle, company, industry,
                    interests, desires, expertise, source, picUrl, givenName,
                    fullName, signature);

            return com.liferay.events.global.mobile.model.EventContactSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }
}
