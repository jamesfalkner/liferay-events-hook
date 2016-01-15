package com.liferay.events.global.mobile.model;

import com.liferay.events.global.mobile.service.ClpSerializer;
import com.liferay.events.global.mobile.service.EventPollQuestionLocalServiceUtil;

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


public class EventPollQuestionClp extends BaseModelImpl<EventPollQuestion>
    implements EventPollQuestion {
    private String _eventId;
    private String _sponsorName;
    private String _shortTitle;
    private String _question;
    private String _questionType;
    private String _choices;
    private boolean _anonymousResults;
    private boolean _showResponseCount;
    private String _chartType;
    private boolean _askForId;
    private String _idIntro;
    private Date _createDate;
    private boolean _enabled;
    private boolean _autoEnable;
    private Date _enableTriggerDate;
    private String _enableTriggerTimezone;
    private String _picUrl;
    private long _questionId;
    private BaseModel<?> _eventPollQuestionRemoteModel;
    private Class<?> _clpSerializerClass = com.liferay.events.global.mobile.service.ClpSerializer.class;

    public EventPollQuestionClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return EventPollQuestion.class;
    }

    @Override
    public String getModelClassName() {
        return EventPollQuestion.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _questionId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setQuestionId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _questionId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("eventId", getEventId());
        attributes.put("sponsorName", getSponsorName());
        attributes.put("shortTitle", getShortTitle());
        attributes.put("question", getQuestion());
        attributes.put("questionType", getQuestionType());
        attributes.put("choices", getChoices());
        attributes.put("anonymousResults", getAnonymousResults());
        attributes.put("showResponseCount", getShowResponseCount());
        attributes.put("chartType", getChartType());
        attributes.put("askForId", getAskForId());
        attributes.put("idIntro", getIdIntro());
        attributes.put("createDate", getCreateDate());
        attributes.put("enabled", getEnabled());
        attributes.put("autoEnable", getAutoEnable());
        attributes.put("enableTriggerDate", getEnableTriggerDate());
        attributes.put("enableTriggerTimezone", getEnableTriggerTimezone());
        attributes.put("picUrl", getPicUrl());
        attributes.put("questionId", getQuestionId());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        String eventId = (String) attributes.get("eventId");

        if (eventId != null) {
            setEventId(eventId);
        }

        String sponsorName = (String) attributes.get("sponsorName");

        if (sponsorName != null) {
            setSponsorName(sponsorName);
        }

        String shortTitle = (String) attributes.get("shortTitle");

        if (shortTitle != null) {
            setShortTitle(shortTitle);
        }

        String question = (String) attributes.get("question");

        if (question != null) {
            setQuestion(question);
        }

        String questionType = (String) attributes.get("questionType");

        if (questionType != null) {
            setQuestionType(questionType);
        }

        String choices = (String) attributes.get("choices");

        if (choices != null) {
            setChoices(choices);
        }

        Boolean anonymousResults = (Boolean) attributes.get("anonymousResults");

        if (anonymousResults != null) {
            setAnonymousResults(anonymousResults);
        }

        Boolean showResponseCount = (Boolean) attributes.get(
                "showResponseCount");

        if (showResponseCount != null) {
            setShowResponseCount(showResponseCount);
        }

        String chartType = (String) attributes.get("chartType");

        if (chartType != null) {
            setChartType(chartType);
        }

        Boolean askForId = (Boolean) attributes.get("askForId");

        if (askForId != null) {
            setAskForId(askForId);
        }

        String idIntro = (String) attributes.get("idIntro");

        if (idIntro != null) {
            setIdIntro(idIntro);
        }

        Date createDate = (Date) attributes.get("createDate");

        if (createDate != null) {
            setCreateDate(createDate);
        }

        Boolean enabled = (Boolean) attributes.get("enabled");

        if (enabled != null) {
            setEnabled(enabled);
        }

        Boolean autoEnable = (Boolean) attributes.get("autoEnable");

        if (autoEnable != null) {
            setAutoEnable(autoEnable);
        }

        Date enableTriggerDate = (Date) attributes.get("enableTriggerDate");

        if (enableTriggerDate != null) {
            setEnableTriggerDate(enableTriggerDate);
        }

        String enableTriggerTimezone = (String) attributes.get(
                "enableTriggerTimezone");

        if (enableTriggerTimezone != null) {
            setEnableTriggerTimezone(enableTriggerTimezone);
        }

        String picUrl = (String) attributes.get("picUrl");

        if (picUrl != null) {
            setPicUrl(picUrl);
        }

        Long questionId = (Long) attributes.get("questionId");

        if (questionId != null) {
            setQuestionId(questionId);
        }
    }

    @Override
    public String getEventId() {
        return _eventId;
    }

    @Override
    public void setEventId(String eventId) {
        _eventId = eventId;

        if (_eventPollQuestionRemoteModel != null) {
            try {
                Class<?> clazz = _eventPollQuestionRemoteModel.getClass();

                Method method = clazz.getMethod("setEventId", String.class);

                method.invoke(_eventPollQuestionRemoteModel, eventId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getSponsorName() {
        return _sponsorName;
    }

    @Override
    public void setSponsorName(String sponsorName) {
        _sponsorName = sponsorName;

        if (_eventPollQuestionRemoteModel != null) {
            try {
                Class<?> clazz = _eventPollQuestionRemoteModel.getClass();

                Method method = clazz.getMethod("setSponsorName", String.class);

                method.invoke(_eventPollQuestionRemoteModel, sponsorName);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getShortTitle() {
        return _shortTitle;
    }

    @Override
    public void setShortTitle(String shortTitle) {
        _shortTitle = shortTitle;

        if (_eventPollQuestionRemoteModel != null) {
            try {
                Class<?> clazz = _eventPollQuestionRemoteModel.getClass();

                Method method = clazz.getMethod("setShortTitle", String.class);

                method.invoke(_eventPollQuestionRemoteModel, shortTitle);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getQuestion() {
        return _question;
    }

    @Override
    public void setQuestion(String question) {
        _question = question;

        if (_eventPollQuestionRemoteModel != null) {
            try {
                Class<?> clazz = _eventPollQuestionRemoteModel.getClass();

                Method method = clazz.getMethod("setQuestion", String.class);

                method.invoke(_eventPollQuestionRemoteModel, question);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getQuestionType() {
        return _questionType;
    }

    @Override
    public void setQuestionType(String questionType) {
        _questionType = questionType;

        if (_eventPollQuestionRemoteModel != null) {
            try {
                Class<?> clazz = _eventPollQuestionRemoteModel.getClass();

                Method method = clazz.getMethod("setQuestionType", String.class);

                method.invoke(_eventPollQuestionRemoteModel, questionType);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getChoices() {
        return _choices;
    }

    @Override
    public void setChoices(String choices) {
        _choices = choices;

        if (_eventPollQuestionRemoteModel != null) {
            try {
                Class<?> clazz = _eventPollQuestionRemoteModel.getClass();

                Method method = clazz.getMethod("setChoices", String.class);

                method.invoke(_eventPollQuestionRemoteModel, choices);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public boolean getAnonymousResults() {
        return _anonymousResults;
    }

    @Override
    public boolean isAnonymousResults() {
        return _anonymousResults;
    }

    @Override
    public void setAnonymousResults(boolean anonymousResults) {
        _anonymousResults = anonymousResults;

        if (_eventPollQuestionRemoteModel != null) {
            try {
                Class<?> clazz = _eventPollQuestionRemoteModel.getClass();

                Method method = clazz.getMethod("setAnonymousResults",
                        boolean.class);

                method.invoke(_eventPollQuestionRemoteModel, anonymousResults);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public boolean getShowResponseCount() {
        return _showResponseCount;
    }

    @Override
    public boolean isShowResponseCount() {
        return _showResponseCount;
    }

    @Override
    public void setShowResponseCount(boolean showResponseCount) {
        _showResponseCount = showResponseCount;

        if (_eventPollQuestionRemoteModel != null) {
            try {
                Class<?> clazz = _eventPollQuestionRemoteModel.getClass();

                Method method = clazz.getMethod("setShowResponseCount",
                        boolean.class);

                method.invoke(_eventPollQuestionRemoteModel, showResponseCount);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getChartType() {
        return _chartType;
    }

    @Override
    public void setChartType(String chartType) {
        _chartType = chartType;

        if (_eventPollQuestionRemoteModel != null) {
            try {
                Class<?> clazz = _eventPollQuestionRemoteModel.getClass();

                Method method = clazz.getMethod("setChartType", String.class);

                method.invoke(_eventPollQuestionRemoteModel, chartType);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public boolean getAskForId() {
        return _askForId;
    }

    @Override
    public boolean isAskForId() {
        return _askForId;
    }

    @Override
    public void setAskForId(boolean askForId) {
        _askForId = askForId;

        if (_eventPollQuestionRemoteModel != null) {
            try {
                Class<?> clazz = _eventPollQuestionRemoteModel.getClass();

                Method method = clazz.getMethod("setAskForId", boolean.class);

                method.invoke(_eventPollQuestionRemoteModel, askForId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getIdIntro() {
        return _idIntro;
    }

    @Override
    public void setIdIntro(String idIntro) {
        _idIntro = idIntro;

        if (_eventPollQuestionRemoteModel != null) {
            try {
                Class<?> clazz = _eventPollQuestionRemoteModel.getClass();

                Method method = clazz.getMethod("setIdIntro", String.class);

                method.invoke(_eventPollQuestionRemoteModel, idIntro);
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

        if (_eventPollQuestionRemoteModel != null) {
            try {
                Class<?> clazz = _eventPollQuestionRemoteModel.getClass();

                Method method = clazz.getMethod("setCreateDate", Date.class);

                method.invoke(_eventPollQuestionRemoteModel, createDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public boolean getEnabled() {
        return _enabled;
    }

    @Override
    public boolean isEnabled() {
        return _enabled;
    }

    @Override
    public void setEnabled(boolean enabled) {
        _enabled = enabled;

        if (_eventPollQuestionRemoteModel != null) {
            try {
                Class<?> clazz = _eventPollQuestionRemoteModel.getClass();

                Method method = clazz.getMethod("setEnabled", boolean.class);

                method.invoke(_eventPollQuestionRemoteModel, enabled);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public boolean getAutoEnable() {
        return _autoEnable;
    }

    @Override
    public boolean isAutoEnable() {
        return _autoEnable;
    }

    @Override
    public void setAutoEnable(boolean autoEnable) {
        _autoEnable = autoEnable;

        if (_eventPollQuestionRemoteModel != null) {
            try {
                Class<?> clazz = _eventPollQuestionRemoteModel.getClass();

                Method method = clazz.getMethod("setAutoEnable", boolean.class);

                method.invoke(_eventPollQuestionRemoteModel, autoEnable);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getEnableTriggerDate() {
        return _enableTriggerDate;
    }

    @Override
    public void setEnableTriggerDate(Date enableTriggerDate) {
        _enableTriggerDate = enableTriggerDate;

        if (_eventPollQuestionRemoteModel != null) {
            try {
                Class<?> clazz = _eventPollQuestionRemoteModel.getClass();

                Method method = clazz.getMethod("setEnableTriggerDate",
                        Date.class);

                method.invoke(_eventPollQuestionRemoteModel, enableTriggerDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getEnableTriggerTimezone() {
        return _enableTriggerTimezone;
    }

    @Override
    public void setEnableTriggerTimezone(String enableTriggerTimezone) {
        _enableTriggerTimezone = enableTriggerTimezone;

        if (_eventPollQuestionRemoteModel != null) {
            try {
                Class<?> clazz = _eventPollQuestionRemoteModel.getClass();

                Method method = clazz.getMethod("setEnableTriggerTimezone",
                        String.class);

                method.invoke(_eventPollQuestionRemoteModel,
                    enableTriggerTimezone);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getPicUrl() {
        return _picUrl;
    }

    @Override
    public void setPicUrl(String picUrl) {
        _picUrl = picUrl;

        if (_eventPollQuestionRemoteModel != null) {
            try {
                Class<?> clazz = _eventPollQuestionRemoteModel.getClass();

                Method method = clazz.getMethod("setPicUrl", String.class);

                method.invoke(_eventPollQuestionRemoteModel, picUrl);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getQuestionId() {
        return _questionId;
    }

    @Override
    public void setQuestionId(long questionId) {
        _questionId = questionId;

        if (_eventPollQuestionRemoteModel != null) {
            try {
                Class<?> clazz = _eventPollQuestionRemoteModel.getClass();

                Method method = clazz.getMethod("setQuestionId", long.class);

                method.invoke(_eventPollQuestionRemoteModel, questionId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getEventPollQuestionRemoteModel() {
        return _eventPollQuestionRemoteModel;
    }

    public void setEventPollQuestionRemoteModel(
        BaseModel<?> eventPollQuestionRemoteModel) {
        _eventPollQuestionRemoteModel = eventPollQuestionRemoteModel;
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

        Class<?> remoteModelClass = _eventPollQuestionRemoteModel.getClass();

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

        Object returnValue = method.invoke(_eventPollQuestionRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            EventPollQuestionLocalServiceUtil.addEventPollQuestion(this);
        } else {
            EventPollQuestionLocalServiceUtil.updateEventPollQuestion(this);
        }
    }

    @Override
    public EventPollQuestion toEscapedModel() {
        return (EventPollQuestion) ProxyUtil.newProxyInstance(EventPollQuestion.class.getClassLoader(),
            new Class[] { EventPollQuestion.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        EventPollQuestionClp clone = new EventPollQuestionClp();

        clone.setEventId(getEventId());
        clone.setSponsorName(getSponsorName());
        clone.setShortTitle(getShortTitle());
        clone.setQuestion(getQuestion());
        clone.setQuestionType(getQuestionType());
        clone.setChoices(getChoices());
        clone.setAnonymousResults(getAnonymousResults());
        clone.setShowResponseCount(getShowResponseCount());
        clone.setChartType(getChartType());
        clone.setAskForId(getAskForId());
        clone.setIdIntro(getIdIntro());
        clone.setCreateDate(getCreateDate());
        clone.setEnabled(getEnabled());
        clone.setAutoEnable(getAutoEnable());
        clone.setEnableTriggerDate(getEnableTriggerDate());
        clone.setEnableTriggerTimezone(getEnableTriggerTimezone());
        clone.setPicUrl(getPicUrl());
        clone.setQuestionId(getQuestionId());

        return clone;
    }

    @Override
    public int compareTo(EventPollQuestion eventPollQuestion) {
        long primaryKey = eventPollQuestion.getPrimaryKey();

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

        if (!(obj instanceof EventPollQuestionClp)) {
            return false;
        }

        EventPollQuestionClp eventPollQuestion = (EventPollQuestionClp) obj;

        long primaryKey = eventPollQuestion.getPrimaryKey();

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
        StringBundler sb = new StringBundler(37);

        sb.append("{eventId=");
        sb.append(getEventId());
        sb.append(", sponsorName=");
        sb.append(getSponsorName());
        sb.append(", shortTitle=");
        sb.append(getShortTitle());
        sb.append(", question=");
        sb.append(getQuestion());
        sb.append(", questionType=");
        sb.append(getQuestionType());
        sb.append(", choices=");
        sb.append(getChoices());
        sb.append(", anonymousResults=");
        sb.append(getAnonymousResults());
        sb.append(", showResponseCount=");
        sb.append(getShowResponseCount());
        sb.append(", chartType=");
        sb.append(getChartType());
        sb.append(", askForId=");
        sb.append(getAskForId());
        sb.append(", idIntro=");
        sb.append(getIdIntro());
        sb.append(", createDate=");
        sb.append(getCreateDate());
        sb.append(", enabled=");
        sb.append(getEnabled());
        sb.append(", autoEnable=");
        sb.append(getAutoEnable());
        sb.append(", enableTriggerDate=");
        sb.append(getEnableTriggerDate());
        sb.append(", enableTriggerTimezone=");
        sb.append(getEnableTriggerTimezone());
        sb.append(", picUrl=");
        sb.append(getPicUrl());
        sb.append(", questionId=");
        sb.append(getQuestionId());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(58);

        sb.append("<model><model-name>");
        sb.append("com.liferay.events.global.mobile.model.EventPollQuestion");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>eventId</column-name><column-value><![CDATA[");
        sb.append(getEventId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>sponsorName</column-name><column-value><![CDATA[");
        sb.append(getSponsorName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>shortTitle</column-name><column-value><![CDATA[");
        sb.append(getShortTitle());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>question</column-name><column-value><![CDATA[");
        sb.append(getQuestion());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>questionType</column-name><column-value><![CDATA[");
        sb.append(getQuestionType());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>choices</column-name><column-value><![CDATA[");
        sb.append(getChoices());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>anonymousResults</column-name><column-value><![CDATA[");
        sb.append(getAnonymousResults());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>showResponseCount</column-name><column-value><![CDATA[");
        sb.append(getShowResponseCount());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>chartType</column-name><column-value><![CDATA[");
        sb.append(getChartType());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>askForId</column-name><column-value><![CDATA[");
        sb.append(getAskForId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>idIntro</column-name><column-value><![CDATA[");
        sb.append(getIdIntro());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>createDate</column-name><column-value><![CDATA[");
        sb.append(getCreateDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>enabled</column-name><column-value><![CDATA[");
        sb.append(getEnabled());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>autoEnable</column-name><column-value><![CDATA[");
        sb.append(getAutoEnable());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>enableTriggerDate</column-name><column-value><![CDATA[");
        sb.append(getEnableTriggerDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>enableTriggerTimezone</column-name><column-value><![CDATA[");
        sb.append(getEnableTriggerTimezone());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>picUrl</column-name><column-value><![CDATA[");
        sb.append(getPicUrl());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>questionId</column-name><column-value><![CDATA[");
        sb.append(getQuestionId());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
