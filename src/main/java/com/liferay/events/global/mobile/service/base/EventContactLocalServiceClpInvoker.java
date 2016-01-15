package com.liferay.events.global.mobile.service.base;

import com.liferay.events.global.mobile.service.EventContactLocalServiceUtil;

import java.util.Arrays;

/**
 * @author James Falkner
 * @generated
 */
public class EventContactLocalServiceClpInvoker {
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

    public EventContactLocalServiceClpInvoker() {
        _methodName0 = "addEventContact";

        _methodParameterTypes0 = new String[] {
                "com.liferay.events.global.mobile.model.EventContact"
            };

        _methodName1 = "createEventContact";

        _methodParameterTypes1 = new String[] { "long" };

        _methodName2 = "deleteEventContact";

        _methodParameterTypes2 = new String[] { "long" };

        _methodName3 = "deleteEventContact";

        _methodParameterTypes3 = new String[] {
                "com.liferay.events.global.mobile.model.EventContact"
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

        _methodName10 = "fetchEventContact";

        _methodParameterTypes10 = new String[] { "long" };

        _methodName11 = "getEventContact";

        _methodParameterTypes11 = new String[] { "long" };

        _methodName12 = "getPersistedModel";

        _methodParameterTypes12 = new String[] { "java.io.Serializable" };

        _methodName13 = "getEventContacts";

        _methodParameterTypes13 = new String[] { "int", "int" };

        _methodName14 = "getEventContactsCount";

        _methodParameterTypes14 = new String[] {  };

        _methodName15 = "updateEventContact";

        _methodParameterTypes15 = new String[] {
                "com.liferay.events.global.mobile.model.EventContact"
            };

        _methodName62 = "getBeanIdentifier";

        _methodParameterTypes62 = new String[] {  };

        _methodName63 = "setBeanIdentifier";

        _methodParameterTypes63 = new String[] { "java.lang.String" };

        _methodName68 = "deleteAll";

        _methodParameterTypes68 = new String[] {  };

        _methodName69 = "addEventContact";

        _methodParameterTypes69 = new String[] {
                "long", "long", "com.liferay.portal.service.ServiceContext",
                "java.lang.String", "java.lang.String", "java.lang.String",
                "java.lang.String", "java.lang.String", "java.lang.String",
                "java.lang.String", "double", "double", "java.lang.String",
                "java.lang.String", "java.lang.String", "java.lang.String",
                "java.lang.String", "java.lang.String", "java.lang.String"
            };

        _methodName70 = "getVerifiedContactByEmailAddress";

        _methodParameterTypes70 = new String[] {
                "java.lang.String", "java.lang.String", "boolean"
            };

        _methodName71 = "getContactByEmailAddress";

        _methodParameterTypes71 = new String[] {
                "java.lang.String", "java.lang.String"
            };

        _methodName72 = "getVerifiedContact";

        _methodParameterTypes72 = new String[] { "long", "boolean" };

        _methodName73 = "recordInterest";

        _methodParameterTypes73 = new String[] {
                "long", "long", "com.liferay.portal.service.ServiceContext",
                "java.lang.String", "long", "long"
            };

        _methodName74 = "getInterested";

        _methodParameterTypes74 = new String[] {
                "java.lang.String", "java.util.Collection"
            };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName0.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
            return EventContactLocalServiceUtil.addEventContact((com.liferay.events.global.mobile.model.EventContact) arguments[0]);
        }

        if (_methodName1.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
            return EventContactLocalServiceUtil.createEventContact(((Long) arguments[0]).longValue());
        }

        if (_methodName2.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
            return EventContactLocalServiceUtil.deleteEventContact(((Long) arguments[0]).longValue());
        }

        if (_methodName3.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
            return EventContactLocalServiceUtil.deleteEventContact((com.liferay.events.global.mobile.model.EventContact) arguments[0]);
        }

        if (_methodName4.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
            return EventContactLocalServiceUtil.dynamicQuery();
        }

        if (_methodName5.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
            return EventContactLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName6.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
            return EventContactLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName7.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
            return EventContactLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                (com.liferay.portal.kernel.util.OrderByComparator) arguments[3]);
        }

        if (_methodName8.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
            return EventContactLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName9.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
            return EventContactLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                (com.liferay.portal.kernel.dao.orm.Projection) arguments[1]);
        }

        if (_methodName10.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
            return EventContactLocalServiceUtil.fetchEventContact(((Long) arguments[0]).longValue());
        }

        if (_methodName11.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
            return EventContactLocalServiceUtil.getEventContact(((Long) arguments[0]).longValue());
        }

        if (_methodName12.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
            return EventContactLocalServiceUtil.getPersistedModel((java.io.Serializable) arguments[0]);
        }

        if (_methodName13.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
            return EventContactLocalServiceUtil.getEventContacts(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue());
        }

        if (_methodName14.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
            return EventContactLocalServiceUtil.getEventContactsCount();
        }

        if (_methodName15.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
            return EventContactLocalServiceUtil.updateEventContact((com.liferay.events.global.mobile.model.EventContact) arguments[0]);
        }

        if (_methodName62.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes62, parameterTypes)) {
            return EventContactLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName63.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes63, parameterTypes)) {
            EventContactLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName68.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes68, parameterTypes)) {
            EventContactLocalServiceUtil.deleteAll();

            return null;
        }

        if (_methodName69.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes69, parameterTypes)) {
            return EventContactLocalServiceUtil.addEventContact(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue(),
                (com.liferay.portal.service.ServiceContext) arguments[2],
                (java.lang.String) arguments[3],
                (java.lang.String) arguments[4],
                (java.lang.String) arguments[5],
                (java.lang.String) arguments[6],
                (java.lang.String) arguments[7],
                (java.lang.String) arguments[8],
                (java.lang.String) arguments[9],
                ((Double) arguments[10]).doubleValue(),
                ((Double) arguments[11]).doubleValue(),
                (java.lang.String) arguments[12],
                (java.lang.String) arguments[13],
                (java.lang.String) arguments[14],
                (java.lang.String) arguments[15],
                (java.lang.String) arguments[16],
                (java.lang.String) arguments[17],
                (java.lang.String) arguments[18]);
        }

        if (_methodName70.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes70, parameterTypes)) {
            return EventContactLocalServiceUtil.getVerifiedContactByEmailAddress((java.lang.String) arguments[0],
                (java.lang.String) arguments[1],
                ((Boolean) arguments[2]).booleanValue());
        }

        if (_methodName71.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes71, parameterTypes)) {
            return EventContactLocalServiceUtil.getContactByEmailAddress((java.lang.String) arguments[0],
                (java.lang.String) arguments[1]);
        }

        if (_methodName72.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes72, parameterTypes)) {
            return EventContactLocalServiceUtil.getVerifiedContact(((Long) arguments[0]).longValue(),
                ((Boolean) arguments[1]).booleanValue());
        }

        if (_methodName73.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes73, parameterTypes)) {
            return EventContactLocalServiceUtil.recordInterest(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue(),
                (com.liferay.portal.service.ServiceContext) arguments[2],
                (java.lang.String) arguments[3],
                ((Long) arguments[4]).longValue(),
                ((Long) arguments[5]).longValue());
        }

        if (_methodName74.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes74, parameterTypes)) {
            return EventContactLocalServiceUtil.getInterested((java.lang.String) arguments[0],
                (java.util.Collection<java.lang.Long>) arguments[1]);
        }

        throw new UnsupportedOperationException();
    }
}
