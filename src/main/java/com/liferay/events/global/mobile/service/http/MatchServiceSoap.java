package com.liferay.events.global.mobile.service.http;

import com.liferay.events.global.mobile.service.MatchServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ListUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link com.liferay.events.global.mobile.service.MatchServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.liferay.events.global.mobile.model.MatchSoap}.
 * If the method in the service utility returns a
 * {@link com.liferay.events.global.mobile.model.Match}, that is translated to a
 * {@link com.liferay.events.global.mobile.model.MatchSoap}. Methods that SOAP cannot
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
 * @see MatchServiceHttp
 * @see com.liferay.events.global.mobile.model.MatchSoap
 * @see com.liferay.events.global.mobile.service.MatchServiceUtil
 * @generated
 */
public class MatchServiceSoap {
    private static Log _log = LogFactoryUtil.getLog(MatchServiceSoap.class);

    public static com.liferay.events.global.mobile.model.EventContactSoap recordInterest(
        java.lang.String eventId, long contactId, long targetContactId,
        java.lang.String signature) throws RemoteException {
        try {
            com.liferay.events.global.mobile.model.EventContact returnValue = MatchServiceUtil.recordInterest(eventId,
                    contactId, targetContactId, signature);

            return com.liferay.events.global.mobile.model.EventContactSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static boolean unlink(java.lang.String eventId, long contactId,
        long targetContactId, java.lang.String signature)
        throws RemoteException {
        try {
            boolean returnValue = MatchServiceUtil.unlink(eventId, contactId,
                    targetContactId, signature);

            return returnValue;
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.liferay.events.global.mobile.model.EventContactSoap[] getMatches(
        java.lang.String eventId, long contactId, java.lang.String signature)
        throws RemoteException {
        try {
            java.util.List<com.liferay.events.global.mobile.model.EventContact> returnValue =
                MatchServiceUtil.getMatches(eventId, contactId, signature);

            return com.liferay.events.global.mobile.model.EventContactSoap.toSoapModels(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

}
