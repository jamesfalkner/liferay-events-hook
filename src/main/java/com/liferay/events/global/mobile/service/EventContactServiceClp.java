package com.liferay.events.global.mobile.service;

import com.liferay.portal.service.InvokableService;

/**
 * @author James Falkner
 * @generated
 */
public class EventContactServiceClp implements EventContactService {
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

    public EventContactServiceClp(InvokableService invokableService) {
        _invokableService = invokableService;

        _methodName0 = "getBeanIdentifier";

        _methodParameterTypes0 = new String[] {  };

        _methodName1 = "setBeanIdentifier";

        _methodParameterTypes1 = new String[] { "java.lang.String" };

        _methodName3 = "getContact";

        _methodParameterTypes3 = new String[] {
                "java.lang.String", "java.lang.String", "java.lang.String"
            };

        _methodName4 = "validateProfile";

        _methodParameterTypes4 = new String[] {
                "java.lang.String", "java.lang.String", "java.lang.String",
                "java.lang.String", "java.lang.String", "java.lang.String",
                "java.lang.String", "java.lang.String", "java.lang.String",
                "java.lang.String", "java.lang.String", "java.lang.String",
                "java.lang.String", "java.lang.String", "java.lang.String",
                "java.lang.String"
            };

        _methodName5 = "updateProfilePic";

        _methodParameterTypes5 = new String[] {
                "java.lang.String", "long", "java.lang.String",
                "java.lang.String", "java.lang.String", "java.lang.String"
            };

        _methodName6 = "updateProfile";

        _methodParameterTypes6 = new String[] {
                "java.lang.String", "long", "java.lang.String",
                "java.lang.String", "java.lang.String", "java.lang.String",
                "java.lang.String", "java.lang.String", "java.lang.String",
                "java.lang.String", "java.lang.String", "java.lang.String",
                "java.lang.String", "java.lang.String", "java.lang.String"
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
    public com.liferay.events.global.mobile.model.EventContact getContact(
        java.lang.String eventId, java.lang.String emailAddress,
        java.lang.String signature) throws java.lang.Exception {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName3,
                    _methodParameterTypes3,
                    new Object[] {
                        ClpSerializer.translateInput(eventId),
                        
                    ClpSerializer.translateInput(emailAddress),
                        
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
    public com.liferay.events.global.mobile.model.EventContact validateProfile(
        java.lang.String eventId, java.lang.String givenName,
        java.lang.String fullName, java.lang.String emailAddress,
        java.lang.String city, java.lang.String countryCode,
        java.lang.String countryName, java.lang.String picUrl,
        java.lang.String company, java.lang.String industry,
        java.lang.String jobTitle, java.lang.String desires,
        java.lang.String expertise, java.lang.String otherInterests,
        java.lang.String attendeeType, java.lang.String signature)
        throws java.lang.Exception {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName4,
                    _methodParameterTypes4,
                    new Object[] {
                        ClpSerializer.translateInput(eventId),
                        
                    ClpSerializer.translateInput(givenName),
                        
                    ClpSerializer.translateInput(fullName),
                        
                    ClpSerializer.translateInput(emailAddress),
                        
                    ClpSerializer.translateInput(city),
                        
                    ClpSerializer.translateInput(countryCode),
                        
                    ClpSerializer.translateInput(countryName),
                        
                    ClpSerializer.translateInput(picUrl),
                        
                    ClpSerializer.translateInput(company),
                        
                    ClpSerializer.translateInput(industry),
                        
                    ClpSerializer.translateInput(jobTitle),
                        
                    ClpSerializer.translateInput(desires),
                        
                    ClpSerializer.translateInput(expertise),
                        
                    ClpSerializer.translateInput(otherInterests),
                        
                    ClpSerializer.translateInput(attendeeType),
                        
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
    public com.liferay.events.global.mobile.model.EventContact updateProfilePic(
        java.lang.String eventId, long contactId, java.lang.String mimeType,
        java.lang.String extension, java.lang.String bytes,
        java.lang.String signature) throws java.lang.Exception {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName5,
                    _methodParameterTypes5,
                    new Object[] {
                        ClpSerializer.translateInput(eventId),
                        
                    contactId,
                        
                    ClpSerializer.translateInput(mimeType),
                        
                    ClpSerializer.translateInput(extension),
                        
                    ClpSerializer.translateInput(bytes),
                        
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
    public com.liferay.events.global.mobile.model.EventContact updateProfile(
        java.lang.String eventId, long contactId, java.lang.String city,
        java.lang.String country, java.lang.String jobTitle,
        java.lang.String company, java.lang.String industry,
        java.lang.String interests, java.lang.String desires,
        java.lang.String expertise, java.lang.String source,
        java.lang.String picUrl, java.lang.String givenName,
        java.lang.String fullName, java.lang.String signature)
        throws java.lang.Exception {
        Object returnObj = null;

        try {
            returnObj = _invokableService.invokeMethod(_methodName6,
                    _methodParameterTypes6,
                    new Object[] {
                        ClpSerializer.translateInput(eventId),
                        
                    contactId,
                        
                    ClpSerializer.translateInput(city),
                        
                    ClpSerializer.translateInput(country),
                        
                    ClpSerializer.translateInput(jobTitle),
                        
                    ClpSerializer.translateInput(company),
                        
                    ClpSerializer.translateInput(industry),
                        
                    ClpSerializer.translateInput(interests),
                        
                    ClpSerializer.translateInput(desires),
                        
                    ClpSerializer.translateInput(expertise),
                        
                    ClpSerializer.translateInput(source),
                        
                    ClpSerializer.translateInput(picUrl),
                        
                    ClpSerializer.translateInput(givenName),
                        
                    ClpSerializer.translateInput(fullName),
                        
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
}
