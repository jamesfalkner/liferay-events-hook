package com.liferay.events.global.mobile.service.base;

import com.liferay.events.global.mobile.service.EventPollQuestionLocalServiceUtil;

import java.util.Arrays;

/**
 * @author James Falkner
 * @generated
 */
public class EventPollQuestionLocalServiceClpInvoker {
    private String _methodName0;
    private String[] _methodParameterTypes0;
    private String _methodName1;
    private String[] _methodParameterTypes1;
    private String _methodName2;
    private String[] _methodParameterTypes2;
    private String _methodName3;
    private String[] _methodParameterTypes3;
    private String _methodName4;
    private String[] _methodParameterTypes4;
    private String _methodName5;
    private String[] _methodParameterTypes5;
    private String _methodName6;
    private String[] _methodParameterTypes6;
    private String _methodName7;
    private String[] _methodParameterTypes7;
    private String _methodName8;
    private String[] _methodParameterTypes8;
    private String _methodName9;
    private String[] _methodParameterTypes9;
    private String _methodName10;
    private String[] _methodParameterTypes10;
    private String _methodName11;
    private String[] _methodParameterTypes11;
    private String _methodName12;
    private String[] _methodParameterTypes12;
    private String _methodName13;
    private String[] _methodParameterTypes13;
    private String _methodName14;
    private String[] _methodParameterTypes14;
    private String _methodName15;
    private String[] _methodParameterTypes15;
    private String _methodName62;
    private String[] _methodParameterTypes62;
    private String _methodName63;
    private String[] _methodParameterTypes63;
    private String _methodName68;
    private String[] _methodParameterTypes68;
    private String _methodName69;
    private String[] _methodParameterTypes69;
    private String _methodName70;
    private String[] _methodParameterTypes70;
    private String _methodName71;
    private String[] _methodParameterTypes71;
    private String _methodName72;
    private String[] _methodParameterTypes72;
    private String _methodName73;
    private String[] _methodParameterTypes73;
    private String _methodName74;
    private String[] _methodParameterTypes74;

    public EventPollQuestionLocalServiceClpInvoker() {
        _methodName0 = "addEventPollQuestion";

        _methodParameterTypes0 = new String[] {
                "com.liferay.events.global.mobile.model.EventPollQuestion"
            };

        _methodName1 = "createEventPollQuestion";

        _methodParameterTypes1 = new String[] { "long" };

        _methodName2 = "deleteEventPollQuestion";

        _methodParameterTypes2 = new String[] { "long" };

        _methodName3 = "deleteEventPollQuestion";

        _methodParameterTypes3 = new String[] {
                "com.liferay.events.global.mobile.model.EventPollQuestion"
            };

        _methodName4 = "dynamicQuery";

        _methodParameterTypes4 = new String[] {  };

        _methodName5 = "dynamicQuery";

        _methodParameterTypes5 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery"
            };

        _methodName6 = "dynamicQuery";

        _methodParameterTypes6 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
            };

        _methodName7 = "dynamicQuery";

        _methodParameterTypes7 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };

        _methodName8 = "dynamicQueryCount";

        _methodParameterTypes8 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery"
            };

        _methodName9 = "dynamicQueryCount";

        _methodParameterTypes9 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery",
                "com.liferay.portal.kernel.dao.orm.Projection"
            };

        _methodName10 = "fetchEventPollQuestion";

        _methodParameterTypes10 = new String[] { "long" };

        _methodName11 = "getEventPollQuestion";

        _methodParameterTypes11 = new String[] { "long" };

        _methodName12 = "getPersistedModel";

        _methodParameterTypes12 = new String[] { "java.io.Serializable" };

        _methodName13 = "getEventPollQuestions";

        _methodParameterTypes13 = new String[] { "int", "int" };

        _methodName14 = "getEventPollQuestionsCount";

        _methodParameterTypes14 = new String[] {  };

        _methodName15 = "updateEventPollQuestion";

        _methodParameterTypes15 = new String[] {
                "com.liferay.events.global.mobile.model.EventPollQuestion"
            };

        _methodName62 = "getBeanIdentifier";

        _methodParameterTypes62 = new String[] {  };

        _methodName63 = "setBeanIdentifier";

        _methodParameterTypes63 = new String[] { "java.lang.String" };

        _methodName68 = "deleteAll";

        _methodParameterTypes68 = new String[] {  };

        _methodName69 = "getAllEvents";

        _methodParameterTypes69 = new String[] {  };

        _methodName70 = "getAllQuestionsForEvent";

        _methodParameterTypes70 = new String[] { "java.lang.String", "int", "int" };

        _methodName71 = "getAllQuestionsForEventCount";

        _methodParameterTypes71 = new String[] { "java.lang.String" };

        _methodName72 = "getAutoEnabled";

        _methodParameterTypes72 = new String[] { "java.util.Date" };

        _methodName73 = "addQuestion";

        _methodParameterTypes73 = new String[] {
                "java.lang.String", "java.lang.String", "java.lang.String",
                "java.lang.String", "java.lang.String", "java.lang.String",
                "boolean", "java.lang.String", "java.lang.String", "boolean",
                "boolean", "java.lang.String", "boolean", "boolean",
                "java.util.Date", "java.lang.String",
                "com.liferay.portal.service.ServiceContext"
            };

        _methodName74 = "updateQuestion";

        _methodParameterTypes74 = new String[] {
                "long", "boolean", "boolean", "java.util.Date",
                "java.lang.String", "java.lang.String", "java.lang.String",
                "java.lang.String", "java.lang.String", "java.lang.String",
                "boolean", "java.lang.String", "java.lang.String",
                "java.lang.String", "boolean", "boolean", "java.lang.String",
                "com.liferay.portal.service.ServiceContext"
            };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName0.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
            return EventPollQuestionLocalServiceUtil.addEventPollQuestion((com.liferay.events.global.mobile.model.EventPollQuestion) arguments[0]);
        }

        if (_methodName1.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
            return EventPollQuestionLocalServiceUtil.createEventPollQuestion(((Long) arguments[0]).longValue());
        }

        if (_methodName2.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
            return EventPollQuestionLocalServiceUtil.deleteEventPollQuestion(((Long) arguments[0]).longValue());
        }

        if (_methodName3.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
            return EventPollQuestionLocalServiceUtil.deleteEventPollQuestion((com.liferay.events.global.mobile.model.EventPollQuestion) arguments[0]);
        }

        if (_methodName4.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
            return EventPollQuestionLocalServiceUtil.dynamicQuery();
        }

        if (_methodName5.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
            return EventPollQuestionLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName6.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
            return EventPollQuestionLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName7.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
            return EventPollQuestionLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                (com.liferay.portal.kernel.util.OrderByComparator) arguments[3]);
        }

        if (_methodName8.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
            return EventPollQuestionLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName9.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
            return EventPollQuestionLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                (com.liferay.portal.kernel.dao.orm.Projection) arguments[1]);
        }

        if (_methodName10.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
            return EventPollQuestionLocalServiceUtil.fetchEventPollQuestion(((Long) arguments[0]).longValue());
        }

        if (_methodName11.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
            return EventPollQuestionLocalServiceUtil.getEventPollQuestion(((Long) arguments[0]).longValue());
        }

        if (_methodName12.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
            return EventPollQuestionLocalServiceUtil.getPersistedModel((java.io.Serializable) arguments[0]);
        }

        if (_methodName13.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
            return EventPollQuestionLocalServiceUtil.getEventPollQuestions(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue());
        }

        if (_methodName14.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
            return EventPollQuestionLocalServiceUtil.getEventPollQuestionsCount();
        }

        if (_methodName15.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
            return EventPollQuestionLocalServiceUtil.updateEventPollQuestion((com.liferay.events.global.mobile.model.EventPollQuestion) arguments[0]);
        }

        if (_methodName62.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes62, parameterTypes)) {
            return EventPollQuestionLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName63.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes63, parameterTypes)) {
            EventPollQuestionLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName68.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes68, parameterTypes)) {
            EventPollQuestionLocalServiceUtil.deleteAll();

            return null;
        }

        if (_methodName69.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes69, parameterTypes)) {
            return EventPollQuestionLocalServiceUtil.getAllEvents();
        }

        if (_methodName70.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes70, parameterTypes)) {
            return EventPollQuestionLocalServiceUtil.getAllQuestionsForEvent((java.lang.String) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName71.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes71, parameterTypes)) {
            return EventPollQuestionLocalServiceUtil.getAllQuestionsForEventCount((java.lang.String) arguments[0]);
        }

        if (_methodName72.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes72, parameterTypes)) {
            return EventPollQuestionLocalServiceUtil.getAutoEnabled((java.util.Date) arguments[0]);
        }

        if (_methodName73.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes73, parameterTypes)) {
            return EventPollQuestionLocalServiceUtil.addQuestion((java.lang.String) arguments[0],
                (java.lang.String) arguments[1],
                (java.lang.String) arguments[2],
                (java.lang.String) arguments[3],
                (java.lang.String) arguments[4],
                (java.lang.String) arguments[5],
                ((Boolean) arguments[6]).booleanValue(),
                (java.lang.String) arguments[7],
                (java.lang.String) arguments[8],
                ((Boolean) arguments[9]).booleanValue(),
                ((Boolean) arguments[10]).booleanValue(),
                (java.lang.String) arguments[11],
                ((Boolean) arguments[12]).booleanValue(),
                ((Boolean) arguments[13]).booleanValue(),
                (java.util.Date) arguments[14],
                (java.lang.String) arguments[15],
                (com.liferay.portal.service.ServiceContext) arguments[16]);
        }

        if (_methodName74.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes74, parameterTypes)) {
            return EventPollQuestionLocalServiceUtil.updateQuestion(((Long) arguments[0]).longValue(),
                ((Boolean) arguments[1]).booleanValue(),
                ((Boolean) arguments[2]).booleanValue(),
                (java.util.Date) arguments[3], (java.lang.String) arguments[4],
                (java.lang.String) arguments[5],
                (java.lang.String) arguments[6],
                (java.lang.String) arguments[7],
                (java.lang.String) arguments[8],
                (java.lang.String) arguments[9],
                ((Boolean) arguments[10]).booleanValue(),
                (java.lang.String) arguments[11],
                (java.lang.String) arguments[12],
                (java.lang.String) arguments[13],
                ((Boolean) arguments[14]).booleanValue(),
                ((Boolean) arguments[15]).booleanValue(),
                (java.lang.String) arguments[16],
                (com.liferay.portal.service.ServiceContext) arguments[17]);
        }

        throw new UnsupportedOperationException();
    }
}
