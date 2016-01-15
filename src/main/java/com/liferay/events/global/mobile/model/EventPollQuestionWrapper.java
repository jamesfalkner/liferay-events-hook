package com.liferay.events.global.mobile.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link EventPollQuestion}.
 * </p>
 *
 * @author James Falkner
 * @see EventPollQuestion
 * @generated
 */
public class EventPollQuestionWrapper implements EventPollQuestion,
    ModelWrapper<EventPollQuestion> {
    private EventPollQuestion _eventPollQuestion;

    public EventPollQuestionWrapper(EventPollQuestion eventPollQuestion) {
        _eventPollQuestion = eventPollQuestion;
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

    /**
    * Returns the primary key of this event poll question.
    *
    * @return the primary key of this event poll question
    */
    @Override
    public long getPrimaryKey() {
        return _eventPollQuestion.getPrimaryKey();
    }

    /**
    * Sets the primary key of this event poll question.
    *
    * @param primaryKey the primary key of this event poll question
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _eventPollQuestion.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the event ID of this event poll question.
    *
    * @return the event ID of this event poll question
    */
    @Override
    public java.lang.String getEventId() {
        return _eventPollQuestion.getEventId();
    }

    /**
    * Sets the event ID of this event poll question.
    *
    * @param eventId the event ID of this event poll question
    */
    @Override
    public void setEventId(java.lang.String eventId) {
        _eventPollQuestion.setEventId(eventId);
    }

    /**
    * Returns the sponsor name of this event poll question.
    *
    * @return the sponsor name of this event poll question
    */
    @Override
    public java.lang.String getSponsorName() {
        return _eventPollQuestion.getSponsorName();
    }

    /**
    * Sets the sponsor name of this event poll question.
    *
    * @param sponsorName the sponsor name of this event poll question
    */
    @Override
    public void setSponsorName(java.lang.String sponsorName) {
        _eventPollQuestion.setSponsorName(sponsorName);
    }

    /**
    * Returns the short title of this event poll question.
    *
    * @return the short title of this event poll question
    */
    @Override
    public java.lang.String getShortTitle() {
        return _eventPollQuestion.getShortTitle();
    }

    /**
    * Sets the short title of this event poll question.
    *
    * @param shortTitle the short title of this event poll question
    */
    @Override
    public void setShortTitle(java.lang.String shortTitle) {
        _eventPollQuestion.setShortTitle(shortTitle);
    }

    /**
    * Returns the question of this event poll question.
    *
    * @return the question of this event poll question
    */
    @Override
    public java.lang.String getQuestion() {
        return _eventPollQuestion.getQuestion();
    }

    /**
    * Sets the question of this event poll question.
    *
    * @param question the question of this event poll question
    */
    @Override
    public void setQuestion(java.lang.String question) {
        _eventPollQuestion.setQuestion(question);
    }

    /**
    * Returns the question type of this event poll question.
    *
    * @return the question type of this event poll question
    */
    @Override
    public java.lang.String getQuestionType() {
        return _eventPollQuestion.getQuestionType();
    }

    /**
    * Sets the question type of this event poll question.
    *
    * @param questionType the question type of this event poll question
    */
    @Override
    public void setQuestionType(java.lang.String questionType) {
        _eventPollQuestion.setQuestionType(questionType);
    }

    /**
    * Returns the choices of this event poll question.
    *
    * @return the choices of this event poll question
    */
    @Override
    public java.lang.String getChoices() {
        return _eventPollQuestion.getChoices();
    }

    /**
    * Sets the choices of this event poll question.
    *
    * @param choices the choices of this event poll question
    */
    @Override
    public void setChoices(java.lang.String choices) {
        _eventPollQuestion.setChoices(choices);
    }

    /**
    * Returns the anonymous results of this event poll question.
    *
    * @return the anonymous results of this event poll question
    */
    @Override
    public boolean getAnonymousResults() {
        return _eventPollQuestion.getAnonymousResults();
    }

    /**
    * Returns <code>true</code> if this event poll question is anonymous results.
    *
    * @return <code>true</code> if this event poll question is anonymous results; <code>false</code> otherwise
    */
    @Override
    public boolean isAnonymousResults() {
        return _eventPollQuestion.isAnonymousResults();
    }

    /**
    * Sets whether this event poll question is anonymous results.
    *
    * @param anonymousResults the anonymous results of this event poll question
    */
    @Override
    public void setAnonymousResults(boolean anonymousResults) {
        _eventPollQuestion.setAnonymousResults(anonymousResults);
    }

    /**
    * Returns the show response count of this event poll question.
    *
    * @return the show response count of this event poll question
    */
    @Override
    public boolean getShowResponseCount() {
        return _eventPollQuestion.getShowResponseCount();
    }

    /**
    * Returns <code>true</code> if this event poll question is show response count.
    *
    * @return <code>true</code> if this event poll question is show response count; <code>false</code> otherwise
    */
    @Override
    public boolean isShowResponseCount() {
        return _eventPollQuestion.isShowResponseCount();
    }

    /**
    * Sets whether this event poll question is show response count.
    *
    * @param showResponseCount the show response count of this event poll question
    */
    @Override
    public void setShowResponseCount(boolean showResponseCount) {
        _eventPollQuestion.setShowResponseCount(showResponseCount);
    }

    /**
    * Returns the chart type of this event poll question.
    *
    * @return the chart type of this event poll question
    */
    @Override
    public java.lang.String getChartType() {
        return _eventPollQuestion.getChartType();
    }

    /**
    * Sets the chart type of this event poll question.
    *
    * @param chartType the chart type of this event poll question
    */
    @Override
    public void setChartType(java.lang.String chartType) {
        _eventPollQuestion.setChartType(chartType);
    }

    /**
    * Returns the ask for ID of this event poll question.
    *
    * @return the ask for ID of this event poll question
    */
    @Override
    public boolean getAskForId() {
        return _eventPollQuestion.getAskForId();
    }

    /**
    * Returns <code>true</code> if this event poll question is ask for ID.
    *
    * @return <code>true</code> if this event poll question is ask for ID; <code>false</code> otherwise
    */
    @Override
    public boolean isAskForId() {
        return _eventPollQuestion.isAskForId();
    }

    /**
    * Sets whether this event poll question is ask for ID.
    *
    * @param askForId the ask for ID of this event poll question
    */
    @Override
    public void setAskForId(boolean askForId) {
        _eventPollQuestion.setAskForId(askForId);
    }

    /**
    * Returns the id intro of this event poll question.
    *
    * @return the id intro of this event poll question
    */
    @Override
    public java.lang.String getIdIntro() {
        return _eventPollQuestion.getIdIntro();
    }

    /**
    * Sets the id intro of this event poll question.
    *
    * @param idIntro the id intro of this event poll question
    */
    @Override
    public void setIdIntro(java.lang.String idIntro) {
        _eventPollQuestion.setIdIntro(idIntro);
    }

    /**
    * Returns the create date of this event poll question.
    *
    * @return the create date of this event poll question
    */
    @Override
    public java.util.Date getCreateDate() {
        return _eventPollQuestion.getCreateDate();
    }

    /**
    * Sets the create date of this event poll question.
    *
    * @param createDate the create date of this event poll question
    */
    @Override
    public void setCreateDate(java.util.Date createDate) {
        _eventPollQuestion.setCreateDate(createDate);
    }

    /**
    * Returns the enabled of this event poll question.
    *
    * @return the enabled of this event poll question
    */
    @Override
    public boolean getEnabled() {
        return _eventPollQuestion.getEnabled();
    }

    /**
    * Returns <code>true</code> if this event poll question is enabled.
    *
    * @return <code>true</code> if this event poll question is enabled; <code>false</code> otherwise
    */
    @Override
    public boolean isEnabled() {
        return _eventPollQuestion.isEnabled();
    }

    /**
    * Sets whether this event poll question is enabled.
    *
    * @param enabled the enabled of this event poll question
    */
    @Override
    public void setEnabled(boolean enabled) {
        _eventPollQuestion.setEnabled(enabled);
    }

    /**
    * Returns the auto enable of this event poll question.
    *
    * @return the auto enable of this event poll question
    */
    @Override
    public boolean getAutoEnable() {
        return _eventPollQuestion.getAutoEnable();
    }

    /**
    * Returns <code>true</code> if this event poll question is auto enable.
    *
    * @return <code>true</code> if this event poll question is auto enable; <code>false</code> otherwise
    */
    @Override
    public boolean isAutoEnable() {
        return _eventPollQuestion.isAutoEnable();
    }

    /**
    * Sets whether this event poll question is auto enable.
    *
    * @param autoEnable the auto enable of this event poll question
    */
    @Override
    public void setAutoEnable(boolean autoEnable) {
        _eventPollQuestion.setAutoEnable(autoEnable);
    }

    /**
    * Returns the enable trigger date of this event poll question.
    *
    * @return the enable trigger date of this event poll question
    */
    @Override
    public java.util.Date getEnableTriggerDate() {
        return _eventPollQuestion.getEnableTriggerDate();
    }

    /**
    * Sets the enable trigger date of this event poll question.
    *
    * @param enableTriggerDate the enable trigger date of this event poll question
    */
    @Override
    public void setEnableTriggerDate(java.util.Date enableTriggerDate) {
        _eventPollQuestion.setEnableTriggerDate(enableTriggerDate);
    }

    /**
    * Returns the enable trigger timezone of this event poll question.
    *
    * @return the enable trigger timezone of this event poll question
    */
    @Override
    public java.lang.String getEnableTriggerTimezone() {
        return _eventPollQuestion.getEnableTriggerTimezone();
    }

    /**
    * Sets the enable trigger timezone of this event poll question.
    *
    * @param enableTriggerTimezone the enable trigger timezone of this event poll question
    */
    @Override
    public void setEnableTriggerTimezone(java.lang.String enableTriggerTimezone) {
        _eventPollQuestion.setEnableTriggerTimezone(enableTriggerTimezone);
    }

    /**
    * Returns the pic url of this event poll question.
    *
    * @return the pic url of this event poll question
    */
    @Override
    public java.lang.String getPicUrl() {
        return _eventPollQuestion.getPicUrl();
    }

    /**
    * Sets the pic url of this event poll question.
    *
    * @param picUrl the pic url of this event poll question
    */
    @Override
    public void setPicUrl(java.lang.String picUrl) {
        _eventPollQuestion.setPicUrl(picUrl);
    }

    /**
    * Returns the question ID of this event poll question.
    *
    * @return the question ID of this event poll question
    */
    @Override
    public long getQuestionId() {
        return _eventPollQuestion.getQuestionId();
    }

    /**
    * Sets the question ID of this event poll question.
    *
    * @param questionId the question ID of this event poll question
    */
    @Override
    public void setQuestionId(long questionId) {
        _eventPollQuestion.setQuestionId(questionId);
    }

    @Override
    public boolean isNew() {
        return _eventPollQuestion.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _eventPollQuestion.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _eventPollQuestion.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _eventPollQuestion.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _eventPollQuestion.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _eventPollQuestion.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _eventPollQuestion.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _eventPollQuestion.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _eventPollQuestion.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _eventPollQuestion.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _eventPollQuestion.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new EventPollQuestionWrapper((EventPollQuestion) _eventPollQuestion.clone());
    }

    @Override
    public int compareTo(
        com.liferay.events.global.mobile.model.EventPollQuestion eventPollQuestion) {
        return _eventPollQuestion.compareTo(eventPollQuestion);
    }

    @Override
    public int hashCode() {
        return _eventPollQuestion.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.liferay.events.global.mobile.model.EventPollQuestion> toCacheModel() {
        return _eventPollQuestion.toCacheModel();
    }

    @Override
    public com.liferay.events.global.mobile.model.EventPollQuestion toEscapedModel() {
        return new EventPollQuestionWrapper(_eventPollQuestion.toEscapedModel());
    }

    @Override
    public com.liferay.events.global.mobile.model.EventPollQuestion toUnescapedModel() {
        return new EventPollQuestionWrapper(_eventPollQuestion.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _eventPollQuestion.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _eventPollQuestion.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _eventPollQuestion.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof EventPollQuestionWrapper)) {
            return false;
        }

        EventPollQuestionWrapper eventPollQuestionWrapper = (EventPollQuestionWrapper) obj;

        if (Validator.equals(_eventPollQuestion,
                    eventPollQuestionWrapper._eventPollQuestion)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public EventPollQuestion getWrappedEventPollQuestion() {
        return _eventPollQuestion;
    }

    @Override
    public EventPollQuestion getWrappedModel() {
        return _eventPollQuestion;
    }

    @Override
    public void resetOriginalValues() {
        _eventPollQuestion.resetOriginalValues();
    }
}
