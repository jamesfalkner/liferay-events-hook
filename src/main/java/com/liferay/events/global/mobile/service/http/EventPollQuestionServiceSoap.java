package com.liferay.events.global.mobile.service.http;

import com.liferay.events.global.mobile.service.EventPollQuestionServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link com.liferay.events.global.mobile.service.EventPollQuestionServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.liferay.events.global.mobile.model.EventPollQuestionSoap}.
 * If the method in the service utility returns a
 * {@link com.liferay.events.global.mobile.model.EventPollQuestion}, that is translated to a
 * {@link com.liferay.events.global.mobile.model.EventPollQuestionSoap}. Methods that SOAP cannot
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
 * @see EventPollQuestionServiceHttp
 * @see com.liferay.events.global.mobile.model.EventPollQuestionSoap
 * @see com.liferay.events.global.mobile.service.EventPollQuestionServiceUtil
 * @generated
 */
public class EventPollQuestionServiceSoap {
    private static Log _log = LogFactoryUtil.getLog(EventPollQuestionServiceSoap.class);

    public static com.liferay.events.global.mobile.model.EventPollQuestionSoap[] getQuestions(
        java.lang.String eventId, boolean enabled) throws RemoteException {
        try {
            java.util.List<com.liferay.events.global.mobile.model.EventPollQuestion> returnValue =
                EventPollQuestionServiceUtil.getQuestions(eventId, enabled);

            return com.liferay.events.global.mobile.model.EventPollQuestionSoap.toSoapModels(returnValue);
        } catch (Exception e) {
            _log.error(e, e);

            throw new RemoteException(e.getMessage());
        }
    }
}
