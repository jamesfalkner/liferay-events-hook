package com.liferay.events.global.mobile.model;

import com.liferay.events.global.mobile.service.ClpSerializer;
import com.liferay.events.global.mobile.service.EventPollAnswerLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class EventPollAnswerClp extends BaseModelImpl<EventPollAnswer>
    implements EventPollAnswer {
    private long _questionId;
    private String _clientId;
    private String _payload;
    private String _answer;
    private Date _createDate;
    private long _answerId;
    private BaseModel<?> _eventPollAnswerRemoteModel;
    private Class<?> _clpSerializerClass = com.liferay.events.global.mobile.service.ClpSerializer.class;

    public EventPollAnswerClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return EventPollAnswer.class;
    }

    @Override
    public String getModelClassName() {
        return EventPollAnswer.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _answerId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setAnswerId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _answerId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("questionId", getQuestionId());
        attributes.put("clientId", getClientId());
        attributes.put("payload", getPayload());
        attributes.put("answer", getAnswer());
        attributes.put("createDate", getCreateDate());
        attributes.put("answerId", getAnswerId());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long questionId = (Long) attributes.get("questionId");

        if (questionId != null) {
            setQuestionId(questionId);
        }

        String clientId = (String) attributes.get("clientId");

        if (clientId != null) {
            setClientId(clientId);
        }

        String payload = (String) attributes.get("payload");

        if (payload != null) {
            setPayload(payload);
        }

        String answer = (String) attributes.get("answer");

        if (answer != null) {
            setAnswer(answer);
        }

        Date createDate = (Date) attributes.get("createDate");

        if (createDate != null) {
            setCreateDate(createDate);
        }

        Long answerId = (Long) attributes.get("answerId");

        if (answerId != null) {
            setAnswerId(answerId);
        }
    }

    @Override
    public long getQuestionId() {
        return _questionId;
    }

    @Override
    public void setQuestionId(long questionId) {
        _questionId = questionId;

        if (_eventPollAnswerRemoteModel != null) {
            try {
                Class<?> clazz = _eventPollAnswerRemoteModel.getClass();

                Method method = clazz.getMethod("setQuestionId", long.class);

                method.invoke(_eventPollAnswerRemoteModel, questionId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getClientId() {
        return _clientId;
    }

    @Override
    public void setClientId(String clientId) {
        _clientId = clientId;

        if (_eventPollAnswerRemoteModel != null) {
            try {
                Class<?> clazz = _eventPollAnswerRemoteModel.getClass();

                Method method = clazz.getMethod("setClientId", String.class);

                method.invoke(_eventPollAnswerRemoteModel, clientId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getPayload() {
        return _payload;
    }

    @Override
    public void setPayload(String payload) {
        _payload = payload;

        if (_eventPollAnswerRemoteModel != null) {
            try {
                Class<?> clazz = _eventPollAnswerRemoteModel.getClass();

                Method method = clazz.getMethod("setPayload", String.class);

                method.invoke(_eventPollAnswerRemoteModel, payload);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getAnswer() {
        return _answer;
    }

    @Override
    public void setAnswer(String answer) {
        _answer = answer;

        if (_eventPollAnswerRemoteModel != null) {
            try {
                Class<?> clazz = _eventPollAnswerRemoteModel.getClass();

                Method method = clazz.getMethod("setAnswer", String.class);

                method.invoke(_eventPollAnswerRemoteModel, answer);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getCreateDate() {
        return _createDate;
    }

    @Override
    public void setCreateDate(Date createDate) {
        _createDate = createDate;

        if (_eventPollAnswerRemoteModel != null) {
            try {
                Class<?> clazz = _eventPollAnswerRemoteModel.getClass();

                Method method = clazz.getMethod("setCreateDate", Date.class);

                method.invoke(_eventPollAnswerRemoteModel, createDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getAnswerId() {
        return _answerId;
    }

    @Override
    public void setAnswerId(long answerId) {
        _answerId = answerId;

        if (_eventPollAnswerRemoteModel != null) {
            try {
                Class<?> clazz = _eventPollAnswerRemoteModel.getClass();

                Method method = clazz.getMethod("setAnswerId", long.class);

                method.invoke(_eventPollAnswerRemoteModel, answerId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getEventPollAnswerRemoteModel() {
        return _eventPollAnswerRemoteModel;
    }

    public void setEventPollAnswerRemoteModel(
        BaseModel<?> eventPollAnswerRemoteModel) {
        _eventPollAnswerRemoteModel = eventPollAnswerRemoteModel;
    }

    public Object invokeOnRemoteModel(String methodName,
        Class<?>[] parameterTypes, Object[] parameterValues)
        throws Exception {
        Object[] remoteParameterValues = new Object[parameterValues.length];

        for (int i = 0; i < parameterValues.length; i++) {
            if (parameterValues[i] != null) {
                remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
            }
        }

        Class<?> remoteModelClass = _eventPollAnswerRemoteModel.getClass();

        ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

        Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            if (parameterTypes[i].isPrimitive()) {
                remoteParameterTypes[i] = parameterTypes[i];
            } else {
                String parameterTypeName = parameterTypes[i].getName();

                remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
            }
        }

        Method method = remoteModelClass.getMethod(methodName,
                remoteParameterTypes);

        Object returnValue = method.invoke(_eventPollAnswerRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            EventPollAnswerLocalServiceUtil.addEventPollAnswer(this);
        } else {
            EventPollAnswerLocalServiceUtil.updateEventPollAnswer(this);
        }
    }

    @Override
    public EventPollAnswer toEscapedModel() {
        return (EventPollAnswer) ProxyUtil.newProxyInstance(EventPollAnswer.class.getClassLoader(),
            new Class[] { EventPollAnswer.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        EventPollAnswerClp clone = new EventPollAnswerClp();

        clone.setQuestionId(getQuestionId());
        clone.setClientId(getClientId());
        clone.setPayload(getPayload());
        clone.setAnswer(getAnswer());
        clone.setCreateDate(getCreateDate());
        clone.setAnswerId(getAnswerId());

        return clone;
    }

    @Override
    public int compareTo(EventPollAnswer eventPollAnswer) {
        long primaryKey = eventPollAnswer.getPrimaryKey();

        if (getPrimaryKey() < primaryKey) {
            return -1;
        } else if (getPrimaryKey() > primaryKey) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof EventPollAnswerClp)) {
            return false;
        }

        EventPollAnswerClp eventPollAnswer = (EventPollAnswerClp) obj;

        long primaryKey = eventPollAnswer.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    public Class<?> getClpSerializerClass() {
        return _clpSerializerClass;
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(13);

        sb.append("{questionId=");
        sb.append(getQuestionId());
        sb.append(", clientId=");
        sb.append(getClientId());
        sb.append(", payload=");
        sb.append(getPayload());
        sb.append(", answer=");
        sb.append(getAnswer());
        sb.append(", createDate=");
        sb.append(getCreateDate());
        sb.append(", answerId=");
        sb.append(getAnswerId());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(22);

        sb.append("<model><model-name>");
        sb.append("com.liferay.events.global.mobile.model.EventPollAnswer");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>questionId</column-name><column-value><![CDATA[");
        sb.append(getQuestionId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>clientId</column-name><column-value><![CDATA[");
        sb.append(getClientId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>payload</column-name><column-value><![CDATA[");
        sb.append(getPayload());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>answer</column-name><column-value><![CDATA[");
        sb.append(getAnswer());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>createDate</column-name><column-value><![CDATA[");
        sb.append(getCreateDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>answerId</column-name><column-value><![CDATA[");
        sb.append(getAnswerId());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
