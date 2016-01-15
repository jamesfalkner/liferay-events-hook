package com.liferay.events.global.mobile.service.base;

import com.liferay.events.global.mobile.service.MessageServiceUtil;

import java.util.Arrays;

/**
 * @author James Falkner
 * @generated
 */
public class MessageServiceClpInvoker {
    private String _methodName46;
    private String[] _methodParameterTypes46;
    private String _methodName47;
    private String[] _methodParameterTypes47;
    private String _methodName52;
    private String[] _methodParameterTypes52;
    private String _methodName53;
    private String[] _methodParameterTypes53;

    public MessageServiceClpInvoker() {
        _methodName46 = "getBeanIdentifier";

        _methodParameterTypes46 = new String[] {  };

        _methodName47 = "setBeanIdentifier";

        _methodParameterTypes47 = new String[] { "java.lang.String" };

        _methodName52 = "sendMessage";

        _methodParameterTypes52 = new String[] {
                "java.lang.String", "long", "long", "java.lang.String",
                "java.lang.String"
            };

        _methodName53 = "getMessages";

        _methodParameterTypes53 = new String[] {
                "java.lang.String", "long", "long", "java.lang.String"
            };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName46.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes46, parameterTypes)) {
            return MessageServiceUtil.getBeanIdentifier();
        }

        if (_methodName47.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes47, parameterTypes)) {
            MessageServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName52.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes52, parameterTypes)) {
            return MessageServiceUtil.sendMessage((java.lang.String) arguments[0],
                ((Long) arguments[1]).longValue(),
                ((Long) arguments[2]).longValue(),
                (java.lang.String) arguments[3], (java.lang.String) arguments[4]);
        }

        if (_methodName53.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes53, parameterTypes)) {
            return MessageServiceUtil.getMessages((java.lang.String) arguments[0],
                ((Long) arguments[1]).longValue(),
                ((Long) arguments[2]).longValue(),
                (java.lang.String) arguments[3]);
        }

        throw new UnsupportedOperationException();
    }
}
