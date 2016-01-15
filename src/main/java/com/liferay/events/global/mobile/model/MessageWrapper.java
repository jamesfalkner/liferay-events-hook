package com.liferay.events.global.mobile.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Message}.
 * </p>
 *
 * @author James Falkner
 * @see Message
 * @generated
 */
public class MessageWrapper implements Message, ModelWrapper<Message> {
    private Message _message;

    public MessageWrapper(Message message) {
        _message = message;
    }

    @Override
    public Class<?> getModelClass() {
        return Message.class;
    }

    @Override
    public String getModelClassName() {
        return Message.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("fromId", getFromId());
        attributes.put("toId", getToId());
        attributes.put("content", getContent());
        attributes.put("read", getRead());
        attributes.put("eventId", getEventId());
        attributes.put("messageId", getMessageId());
        attributes.put("groupId", getGroupId());
        attributes.put("companyId", getCompanyId());
        attributes.put("userId", getUserId());
        attributes.put("userName", getUserName());
        attributes.put("createDate", getCreateDate());
        attributes.put("modifiedDate", getModifiedDate());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long fromId = (Long) attributes.get("fromId");

        if (fromId != null) {
            setFromId(fromId);
        }

        Long toId = (Long) attributes.get("toId");

        if (toId != null) {
            setToId(toId);
        }

        String content = (String) attributes.get("content");

        if (content != null) {
            setContent(content);
        }

        Boolean read = (Boolean) attributes.get("read");

        if (read != null) {
            setRead(read);
        }

        String eventId = (String) attributes.get("eventId");

        if (eventId != null) {
            setEventId(eventId);
        }

        Long messageId = (Long) attributes.get("messageId");

        if (messageId != null) {
            setMessageId(messageId);
        }

        Long groupId = (Long) attributes.get("groupId");

        if (groupId != null) {
            setGroupId(groupId);
        }

        Long companyId = (Long) attributes.get("companyId");

        if (companyId != null) {
            setCompanyId(companyId);
        }

        Long userId = (Long) attributes.get("userId");

        if (userId != null) {
            setUserId(userId);
        }

        String userName = (String) attributes.get("userName");

        if (userName != null) {
            setUserName(userName);
        }

        Date createDate = (Date) attributes.get("createDate");

        if (createDate != null) {
            setCreateDate(createDate);
        }

        Date modifiedDate = (Date) attributes.get("modifiedDate");

        if (modifiedDate != null) {
            setModifiedDate(modifiedDate);
        }
    }

    /**
    * Returns the primary key of this message.
    *
    * @return the primary key of this message
    */
    @Override
    public long getPrimaryKey() {
        return _message.getPrimaryKey();
    }

    /**
    * Sets the primary key of this message.
    *
    * @param primaryKey the primary key of this message
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _message.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the from ID of this message.
    *
    * @return the from ID of this message
    */
    @Override
    public long getFromId() {
        return _message.getFromId();
    }

    /**
    * Sets the from ID of this message.
    *
    * @param fromId the from ID of this message
    */
    @Override
    public void setFromId(long fromId) {
        _message.setFromId(fromId);
    }

    /**
    * Returns the to ID of this message.
    *
    * @return the to ID of this message
    */
    @Override
    public long getToId() {
        return _message.getToId();
    }

    /**
    * Sets the to ID of this message.
    *
    * @param toId the to ID of this message
    */
    @Override
    public void setToId(long toId) {
        _message.setToId(toId);
    }

    /**
    * Returns the content of this message.
    *
    * @return the content of this message
    */
    @Override
    public java.lang.String getContent() {
        return _message.getContent();
    }

    /**
    * Sets the content of this message.
    *
    * @param content the content of this message
    */
    @Override
    public void setContent(java.lang.String content) {
        _message.setContent(content);
    }

    /**
    * Returns the read of this message.
    *
    * @return the read of this message
    */
    @Override
    public boolean getRead() {
        return _message.getRead();
    }

    /**
    * Returns <code>true</code> if this message is read.
    *
    * @return <code>true</code> if this message is read; <code>false</code> otherwise
    */
    @Override
    public boolean isRead() {
        return _message.isRead();
    }

    /**
    * Sets whether this message is read.
    *
    * @param read the read of this message
    */
    @Override
    public void setRead(boolean read) {
        _message.setRead(read);
    }

    /**
    * Returns the event ID of this message.
    *
    * @return the event ID of this message
    */
    @Override
    public java.lang.String getEventId() {
        return _message.getEventId();
    }

    /**
    * Sets the event ID of this message.
    *
    * @param eventId the event ID of this message
    */
    @Override
    public void setEventId(java.lang.String eventId) {
        _message.setEventId(eventId);
    }

    /**
    * Returns the message ID of this message.
    *
    * @return the message ID of this message
    */
    @Override
    public long getMessageId() {
        return _message.getMessageId();
    }

    /**
    * Sets the message ID of this message.
    *
    * @param messageId the message ID of this message
    */
    @Override
    public void setMessageId(long messageId) {
        _message.setMessageId(messageId);
    }

    /**
    * Returns the group ID of this message.
    *
    * @return the group ID of this message
    */
    @Override
    public long getGroupId() {
        return _message.getGroupId();
    }

    /**
    * Sets the group ID of this message.
    *
    * @param groupId the group ID of this message
    */
    @Override
    public void setGroupId(long groupId) {
        _message.setGroupId(groupId);
    }

    /**
    * Returns the company ID of this message.
    *
    * @return the company ID of this message
    */
    @Override
    public long getCompanyId() {
        return _message.getCompanyId();
    }

    /**
    * Sets the company ID of this message.
    *
    * @param companyId the company ID of this message
    */
    @Override
    public void setCompanyId(long companyId) {
        _message.setCompanyId(companyId);
    }

    /**
    * Returns the user ID of this message.
    *
    * @return the user ID of this message
    */
    @Override
    public long getUserId() {
        return _message.getUserId();
    }

    /**
    * Sets the user ID of this message.
    *
    * @param userId the user ID of this message
    */
    @Override
    public void setUserId(long userId) {
        _message.setUserId(userId);
    }

    /**
    * Returns the user uuid of this message.
    *
    * @return the user uuid of this message
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _message.getUserUuid();
    }

    /**
    * Sets the user uuid of this message.
    *
    * @param userUuid the user uuid of this message
    */
    @Override
    public void setUserUuid(java.lang.String userUuid) {
        _message.setUserUuid(userUuid);
    }

    /**
    * Returns the user name of this message.
    *
    * @return the user name of this message
    */
    @Override
    public java.lang.String getUserName() {
        return _message.getUserName();
    }

    /**
    * Sets the user name of this message.
    *
    * @param userName the user name of this message
    */
    @Override
    public void setUserName(java.lang.String userName) {
        _message.setUserName(userName);
    }

    /**
    * Returns the create date of this message.
    *
    * @return the create date of this message
    */
    @Override
    public java.util.Date getCreateDate() {
        return _message.getCreateDate();
    }

    /**
    * Sets the create date of this message.
    *
    * @param createDate the create date of this message
    */
    @Override
    public void setCreateDate(java.util.Date createDate) {
        _message.setCreateDate(createDate);
    }

    /**
    * Returns the modified date of this message.
    *
    * @return the modified date of this message
    */
    @Override
    public java.util.Date getModifiedDate() {
        return _message.getModifiedDate();
    }

    /**
    * Sets the modified date of this message.
    *
    * @param modifiedDate the modified date of this message
    */
    @Override
    public void setModifiedDate(java.util.Date modifiedDate) {
        _message.setModifiedDate(modifiedDate);
    }

    @Override
    public boolean isNew() {
        return _message.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _message.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _message.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _message.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _message.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _message.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _message.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _message.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _message.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _message.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _message.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new MessageWrapper((Message) _message.clone());
    }

    @Override
    public int compareTo(com.liferay.events.global.mobile.model.Message message) {
        return _message.compareTo(message);
    }

    @Override
    public int hashCode() {
        return _message.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.liferay.events.global.mobile.model.Message> toCacheModel() {
        return _message.toCacheModel();
    }

    @Override
    public com.liferay.events.global.mobile.model.Message toEscapedModel() {
        return new MessageWrapper(_message.toEscapedModel());
    }

    @Override
    public com.liferay.events.global.mobile.model.Message toUnescapedModel() {
        return new MessageWrapper(_message.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _message.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _message.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _message.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof MessageWrapper)) {
            return false;
        }

        MessageWrapper messageWrapper = (MessageWrapper) obj;

        if (Validator.equals(_message, messageWrapper._message)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Message getWrappedMessage() {
        return _message;
    }

    @Override
    public Message getWrappedModel() {
        return _message;
    }

    @Override
    public void resetOriginalValues() {
        _message.resetOriginalValues();
    }
}
