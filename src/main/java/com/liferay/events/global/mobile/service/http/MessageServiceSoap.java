package com.liferay.events.global.mobile.service.http;

import com.liferay.events.global.mobile.service.MessageServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link com.liferay.events.global.mobile.service.MessageServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.liferay.events.global.mobile.model.MessageSoap}.
 * If the method in the service utility returns a
 * {@link com.liferay.events.global.mobile.model.Message}, that is translated to a
 * {@link com.liferay.events.global.mobile.model.MessageSoap}. Methods that SOAP cannot
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
 * @see MessageServiceHttp
 * @see com.liferay.events.global.mobile.model.MessageSoap
 * @see com.liferay.events.global.mobile.service.MessageServiceUtil
 * @generated
 */
public class MessageServiceSoap {
    private static Log _log = LogFactoryUtil.getLog(MessageServiceSoap.class);

    public static com.liferay.events.global.mobile.model.MessageSoap sendMessage(
        java.lang.String eventId, long contactId, long targetContactId,
        java.lang.String message, java.lang.String signature)
        throws RemoteException {
        try {
            com.liferay.events.global.mobile.model.Message returnValue = MessageServiceUtil.sendMessage(eventId,
                    contactId, targetContactId, message, signature);

            return com.liferay.events.global.mobile.model.MessageSoap.toSoapModel(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }

    public static com.liferay.events.global.mobile.model.MessageSoap[] getMessages(
        java.lang.String eventId, long contactId, long beginDate,
        java.lang.String signature) throws RemoteException {
        try {
            java.util.List<com.liferay.events.global.mobile.model.Message> returnValue =
                MessageServiceUtil.getMessages(eventId, contactId, beginDate,
                    signature);

            return com.liferay.events.global.mobile.model.MessageSoap.toSoapModels(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }
}
