package com.liferay.events.global.mobile.service.base;

import com.liferay.events.global.mobile.service.EventPollQuestionServiceUtil;

import java.util.Arrays;

/**
 * @author James Falkner
 * @generated
 */
public class EventPollQuestionServiceClpInvoker {
    private String _methodName46;
    private String[] _methodParameterTypes46;
    private String _methodName47;
    private String[] _methodParameterTypes47;
    private String _methodName52;
    private String[] _methodParameterTypes52;

    public EventPollQuestionServiceClpInvoker() {
        _methodName46 = "getBeanIdentifier";

        _methodParameterTypes46 = new String[] {  };

        _methodName47 = "setBeanIdentifier";

        _methodParameterTypes47 = new String[] { "java.lang.String" };

        _methodName52 = "getQuestions";

        _methodParameterTypes52 = new String[] { "java.lang.String", "boolean" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName46.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes46, parameterTypes)) {
            return EventPollQuestionServiceUtil.getBeanIdentifier();
        }

        if (_methodName47.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes47, parameterTypes)) {
            EventPollQuestionServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName52.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes52, parameterTypes)) {
            return EventPollQuestionServiceUtil.getQuestions((java.lang.String) arguments[0],
                ((Boolean) arguments[1]).booleanValue());
        }

        throw new UnsupportedOperationException();
    }
}
