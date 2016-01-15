package com.liferay.events.global.mobile.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link EventPollAnswer}.
 * </p>
 *
 * @author James Falkner
 * @see EventPollAnswer
 * @generated
 */
public class EventPollAnswerWrapper implements EventPollAnswer,
    ModelWrapper<EventPollAnswer> {
    private EventPollAnswer _eventPollAnswer;

    public EventPollAnswerWrapper(EventPollAnswer eventPollAnswer) {
        _eventPollAnswer = eventPollAnswer;
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

    /**
    * Returns the primary key of this event poll answer.
    *
    * @return the primary key of this event poll answer
    */
    @Override
    public long getPrimaryKey() {
        return _eventPollAnswer.getPrimaryKey();
    }

    /**
    * Sets the primary key of this event poll answer.
    *
    * @param primaryKey the primary key of this event poll answer
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _eventPollAnswer.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the question ID of this event poll answer.
    *
    * @return the question ID of this event poll answer
    */
    @Override
    public long getQuestionId() {
        return _eventPollAnswer.getQuestionId();
    }

    /**
    * Sets the question ID of this event poll answer.
    *
    * @param questionId the question ID of this event poll answer
    */
    @Override
    public void setQuestionId(long questionId) {
        _eventPollAnswer.setQuestionId(questionId);
    }

    /**
    * Returns the client ID of this event poll answer.
    *
    * @return the client ID of this event poll answer
    */
    @Override
    public java.lang.String getClientId() {
        return _eventPollAnswer.getClientId();
    }

    /**
    * Sets the client ID of this event poll answer.
    *
    * @param clientId the client ID of this event poll answer
    */
    @Override
    public void setClientId(java.lang.String clientId) {
        _eventPollAnswer.setClientId(clientId);
    }

    /**
    * Returns the payload of this event poll answer.
    *
    * @return the payload of this event poll answer
    */
    @Override
    public java.lang.String getPayload() {
        return _eventPollAnswer.getPayload();
    }

    /**
    * Sets the payload of this event poll answer.
    *
    * @param payload the payload of this event poll answer
    */
    @Override
    public void setPayload(java.lang.String payload) {
        _eventPollAnswer.setPayload(payload);
    }

    /**
    * Returns the answer of this event poll answer.
    *
    * @return the answer of this event poll answer
    */
    @Override
    public java.lang.String getAnswer() {
        return _eventPollAnswer.getAnswer();
    }

    /**
    * Sets the answer of this event poll answer.
    *
    * @param answer the answer of this event poll answer
    */
    @Override
    public void setAnswer(java.lang.String answer) {
        _eventPollAnswer.setAnswer(answer);
    }

    /**
    * Returns the create date of this event poll answer.
    *
    * @return the create date of this event poll answer
    */
    @Override
    public java.util.Date getCreateDate() {
        return _eventPollAnswer.getCreateDate();
    }

    /**
    * Sets the create date of this event poll answer.
    *
    * @param createDate the create date of this event poll answer
    */
    @Override
    public void setCreateDate(java.util.Date createDate) {
        _eventPollAnswer.setCreateDate(createDate);
    }

    /**
    * Returns the answer ID of this event poll answer.
    *
    * @return the answer ID of this event poll answer
    */
    @Override
    public long getAnswerId() {
        return _eventPollAnswer.getAnswerId();
    }

    /**
    * Sets the answer ID of this event poll answer.
    *
    * @param answerId the answer ID of this event poll answer
    */
    @Override
    public void setAnswerId(long answerId) {
        _eventPollAnswer.setAnswerId(answerId);
    }

    @Override
    public boolean isNew() {
        return _eventPollAnswer.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _eventPollAnswer.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _eventPollAnswer.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _eventPollAnswer.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _eventPollAnswer.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _eventPollAnswer.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _eventPollAnswer.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _eventPollAnswer.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _eventPollAnswer.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _eventPollAnswer.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _eventPollAnswer.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new EventPollAnswerWrapper((EventPollAnswer) _eventPollAnswer.clone());
    }

    @Override
    public int compareTo(
        com.liferay.events.global.mobile.model.EventPollAnswer eventPollAnswer) {
        return _eventPollAnswer.compareTo(eventPollAnswer);
    }

    @Override
    public int hashCode() {
        return _eventPollAnswer.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.liferay.events.global.mobile.model.EventPollAnswer> toCacheModel() {
        return _eventPollAnswer.toCacheModel();
    }

    @Override
    public com.liferay.events.global.mobile.model.EventPollAnswer toEscapedModel() {
        return new EventPollAnswerWrapper(_eventPollAnswer.toEscapedModel());
    }

    @Override
    public com.liferay.events.global.mobile.model.EventPollAnswer toUnescapedModel() {
        return new EventPollAnswerWrapper(_eventPollAnswer.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _eventPollAnswer.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _eventPollAnswer.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _eventPollAnswer.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof EventPollAnswerWrapper)) {
            return false;
        }

        EventPollAnswerWrapper eventPollAnswerWrapper = (EventPollAnswerWrapper) obj;

        if (Validator.equals(_eventPollAnswer,
                    eventPollAnswerWrapper._eventPollAnswer)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public EventPollAnswer getWrappedEventPollAnswer() {
        return _eventPollAnswer;
    }

    @Override
    public EventPollAnswer getWrappedModel() {
        return _eventPollAnswer;
    }

    @Override
    public void resetOriginalValues() {
        _eventPollAnswer.resetOriginalValues();
    }
}
