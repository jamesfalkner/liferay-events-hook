package com.liferay.events.global.mobile.service.base;

import com.liferay.events.global.mobile.service.MatchServiceUtil;

import java.util.Arrays;

/**
 * @author James Falkner
 * @generated
 */
public class MatchServiceClpInvoker {
    private String _methodName46;
    private String[] _methodParameterTypes46;
    private String _methodName47;
    private String[] _methodParameterTypes47;
    private String _methodName52;
    private String[] _methodParameterTypes52;
    private String _methodName53;
    private String[] _methodParameterTypes53;
    private String _methodName54;
    private String[] _methodParameterTypes54;
    private String _methodName55;
    private String[] _methodParameterTypes55;

    public MatchServiceClpInvoker() {
        _methodName46 = "getBeanIdentifier";

        _methodParameterTypes46 = new String[] {  };

        _methodName47 = "setBeanIdentifier";

        _methodParameterTypes47 = new String[] { "java.lang.String" };

        _methodName52 = "recordInterest";

        _methodParameterTypes52 = new String[] {
                "java.lang.String", "long", "long", "java.lang.String"
            };

        _methodName53 = "unlink";

        _methodParameterTypes53 = new String[] {
                "java.lang.String", "long", "long", "java.lang.String"
            };

        _methodName54 = "getMatches";

        _methodParameterTypes54 = new String[] {
                "java.lang.String", "long", "java.lang.String"
            };

        _methodName55 = "getCandidates";

        _methodParameterTypes55 = new String[] {
                "java.lang.String", "long", "int", "java.util.List",
                "java.lang.String"
            };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName46.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes46, parameterTypes)) {
            return MatchServiceUtil.getBeanIdentifier();
        }

        if (_methodName47.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes47, parameterTypes)) {
            MatchServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName52.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes52, parameterTypes)) {
            return MatchServiceUtil.recordInterest((java.lang.String) arguments[0],
                ((Long) arguments[1]).longValue(),
                ((Long) arguments[2]).longValue(),
                (java.lang.String) arguments[3]);
        }

        if (_methodName53.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes53, parameterTypes)) {
            return MatchServiceUtil.unlink((java.lang.String) arguments[0],
                ((Long) arguments[1]).longValue(),
                ((Long) arguments[2]).longValue(),
                (java.lang.String) arguments[3]);
        }

        if (_methodName54.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes54, parameterTypes)) {
            return MatchServiceUtil.getMatches((java.lang.String) arguments[0],
                ((Long) arguments[1]).longValue(),
                (java.lang.String) arguments[2]);
        }

        if (_methodName55.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes55, parameterTypes)) {
            return MatchServiceUtil.getCandidates((java.lang.String) arguments[0],
                ((Long) arguments[1]).longValue(),
                ((Integer) arguments[2]).intValue(),
                (java.util.List<java.lang.Long>) arguments[3],
                (java.lang.String) arguments[4]);
        }

        throw new UnsupportedOperationException();
    }
}
