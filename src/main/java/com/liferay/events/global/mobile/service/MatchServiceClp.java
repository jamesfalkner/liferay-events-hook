package com.liferay.events.global.mobile.service;

import com.liferay.portal.service.InvokableService;

/**
 * @author James Falkner
 * @generated
 */
public class MatchServiceClp implements MatchService {
    private InvokableService _invokableService;
    private String _methodName0;
    private String[] _methodParameterTypes0;
    private String _methodName1;
    private String[] _methodParameterTypes1;
    private String _methodName3;
    private String[] _methodParameterTypes3;
    private String _methodName4;
    private String[] _methodParameterTypes4;
    private String _methodName5;
    private String[] _methodParameterTypes5;
    private String _methodName6;
    private String[] _methodParameterTypes6;

    public MatchServiceClp(InvokableService invokableService) {
        _invokableService = invokableService;

        _methodName0 = "getBeanIdentifier";

        _methodParameterTypes0 = new String[] {  };

        _methodName1 = "setBeanIdentifier";

        _methodParameterTypes1 = new String[] { "java.lang.String" };

        _methodName3 = "recordInterest";

        _methodParameterTypes3 = new String[] {
                "java.lang.String", "long", "long", "java.lang.String"
            };

        _methodName4 = "unlink";

        _methodParameterTypes4 = new String[] {
                "java.lang.String", "long", "long", "java.lang.String"
            };

        _methodName5 = "getMatches";

        _methodParameterTypes5 = new String[] {
                "java.lang.String", "long", "java.lang.String"
            };

        _methodName6 = "getCandidates";

        _methodParameterTypes6 = new String[] {
                "java.lang.String", "long", "int", "java.util.List",
                "java.lang.String"
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
    public com.liferay.events.global.mobile.model.EventContact recordInterest(
        java.lang.String eventId, long contactId, long targetContactId,
        java.lang.String signature) throws java.lang.Exception {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName3,
                    _methodParameterTypes3,
                    new Object[] {
                        ClpSerializer.translateInput(eventId),
                        
                    contactId,
                        
                    targetContactId,
                        
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

        return (com.liferay.events.global.mobile.model.EventContact) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public boolean unlink(java.lang.String eventId, long contactId,
        long targetContactId, java.lang.String signature)
        throws java.lang.Exception {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName4,
                    _methodParameterTypes4,
                    new Object[] {
                        ClpSerializer.translateInput(eventId),
                        
                    contactId,
                        
                    targetContactId,
                        
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

        return ((Boolean) returnObj).booleanValue();
    }

    @Override
    public java.util.List<com.liferay.events.global.mobile.model.EventContact> getMatches(
        java.lang.String eventId, long contactId, java.lang.String signature)
        throws java.lang.Exception {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName5,
                    _methodParameterTypes5,
                    new Object[] {
                        ClpSerializer.translateInput(eventId),
                        
                    contactId,
                        
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

        return (java.util.List<com.liferay.events.global.mobile.model.EventContact>) ClpSerializer.translateOutput(returnObj);
    }

    @Override
    public java.util.List<com.liferay.events.global.mobile.portlet.Candidate> getCandidates(
        java.lang.String eventId, long contactId, int max,
        java.util.List<java.lang.Long> uninterestedIds,
        java.lang.String signature) throws java.lang.Exception {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName6,
                    _methodParameterTypes6,
                    new Object[] {
                        ClpSerializer.translateInput(eventId),
                        
                    contactId,
                        
                    max,
                        
                    ClpSerializer.translateInput(uninterestedIds),
                        
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

        return (java.util.List<com.liferay.events.global.mobile.portlet.Candidate>) ClpSerializer.translateOutput(returnObj);
    }
}
