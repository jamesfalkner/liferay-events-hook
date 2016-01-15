package com.liferay.events.global.mobile.service;

import com.liferay.portal.service.InvokableService;

/**
 * @author James Falkner
 * @generated
 */
public class MessageServiceClp implements MessageService {
    private InvokableService _invokableService;
    private String _methodName0;
    private String[] _methodParameterTypes0;
    private String _methodName1;
    private String[] _methodParameterTypes1;
    private String _methodName3;
    private String[] _methodParameterTypes3;
    private String _methodName4;
    private String[] _methodParameterTypes4;

    public MessageServiceClp(InvokableService invokableService) {
        _invokableService = invokableService;

        _methodName0 = "getBeanIdentifier";

        _methodParameterTypes0 = new String[] {  };

        _methodName1 = "setBeanIdentifier";

        _methodParameterTypes1 = new String[] { "java.lang.String" };

        _methodName3 = "sendMessage";

        _methodParameterTypes3 = new String[] {
                "java.lang.String", "long", "long", "java.lang.String",
                "java.lang.String"
            };

        _methodName4 = "getMessages";

        _methodParameterTypes4 = new String[] {
                "java.lang.String", "long", "long", "java.lang.String"
            };
    }

    @Override
    public java.lang.String getBeanIdentifier() {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName0,
                    _methodParameterTypes0, new Object[] {  });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.lang.String) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        try {
            _invokableService.invokeMethod(_methodName1,
                _methodParameterTypes1,
                new Object[] { ClpSerializer.translateInput(beanIdentifier) });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        throw new UnsupportedOperationException();
    }

    @Override
    public com.liferay.events.global.mobile.model.Message sendMessage(
        java.lang.String eventId, long contactId, long targetContactId,
        java.lang.String message, java.lang.String signature)
        throws java.lang.Exception {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName3,
                    _methodParameterTypes3,
                    new Object[] {
                        ClpSerializer.translateInput(eventId),
                        
                    contactId,
                        
                    targetContactId,
                        
                    ClpSerializer.translateInput(message),
                        
                    ClpSerializer.translateInput(signature)
                    });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof java.lang.Exception) {
                throw (java.lang.Exception) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (com.liferay.events.global.mobile.model.Message) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public java.util.List<com.liferay.events.global.mobile.model.Message> getMessages(
        java.lang.String eventId, long contactId, long beginDate,
        java.lang.String signature) throws java.lang.Exception {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName4,
                    _methodParameterTypes4,
                    new Object[] {
                        ClpSerializer.translateInput(eventId),
                        
                    contactId,
                        
                    beginDate,
                        
                    ClpSerializer.translateInput(signature)
                    });
        } catch (Throwable t) {
            t = ClpSerializer.translateThrowable(t);

            if (t instanceof java.lang.Exception) {
                throw (java.lang.Exception) t;
            }

            if (t instanceof RuntimeException) {
                throw (RuntimeException) t;
            } else {
                throw new RuntimeException(t.getClass().getName() +
                    " is not a valid exception");
            }
        }

        return (java.util.List<com.liferay.events.global.mobile.model.Message>) ClpSerializer.translateOutput(returnObj);
    }
}
