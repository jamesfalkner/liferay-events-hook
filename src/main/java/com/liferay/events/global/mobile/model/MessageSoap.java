package com.liferay.events.global.mobile.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.events.global.mobile.service.http.MessageServiceSoap}.
 *
 * @author James Falkner
 * @see com.liferay.events.global.mobile.service.http.MessageServiceSoap
 * @generated
 */
public class MessageSoap implements Serializable {
    private long _fromId;
    private long _toId;
    private String _content;
    private boolean _read;
    private String _eventId;
    private long _messageId;
    private long _groupId;
    private long _companyId;
    private long _userId;
    private String _userName;
    private Date _createDate;
    private Date _modifiedDate;

    public MessageSoap() {
    }

    public static MessageSoap toSoapModel(Message model) {
        MessageSoap soapModel = new MessageSoap();

        soapModel.setFromId(model.getFromId());
        soapModel.setToId(model.getToId());
        soapModel.setContent(model.getContent());
        soapModel.setRead(model.getRead());
        soapModel.setEventId(model.getEventId());
        soapModel.setMessageId(model.getMessageId());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setUserId(model.getUserId());
        soapModel.setUserName(model.getUserName());
        soapModel.setCreateDate(model.getCreateDate());
        soapModel.setModifiedDate(model.getModifiedDate());

        return soapModel;
    }

    public static MessageSoap[] toSoapModels(Message[] models) {
        MessageSoap[] soapModels = new MessageSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static MessageSoap[][] toSoapModels(Message[][] models) {
        MessageSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new MessageSoap[models.length][models[0].length];
        } else {
            soapModels = new MessageSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static MessageSoap[] toSoapModels(List<Message> models) {
        List<MessageSoap> soapModels = new ArrayList<MessageSoap>(models.size());

        for (Message model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new MessageSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _messageId;
    }

    public void setPrimaryKey(long pk) {
        setMessageId(pk);
    }

    public long getFromId() {
        return _fromId;
    }

    public void setFromId(long fromId) {
        _fromId = fromId;
    }

    public long getToId() {
        return _toId;
    }

    public void setToId(long toId) {
        _toId = toId;
    }

    public String getContent() {
        return _content;
    }

    public void setContent(String content) {
        _content = content;
    }

    public boolean getRead() {
        return _read;
    }

    public boolean isRead() {
        return _read;
    }

    public void setRead(boolean read) {
        _read = read;
    }

    public String getEventId() {
        return _eventId;
    }

    public void setEventId(String eventId) {
        _eventId = eventId;
    }

    public long getMessageId() {
        return _messageId;
    }

    public void setMessageId(long messageId) {
        _messageId = messageId;
    }

    public long getGroupId() {
        return _groupId;
    }

    public void setGroupId(long groupId) {
        _groupId = groupId;
    }

    public long getCompanyId() {
        return _companyId;
    }

    public void setCompanyId(long companyId) {
        _companyId = companyId;
    }

    public long getUserId() {
        return _userId;
    }

    public void setUserId(long userId) {
        _userId = userId;
    }

    public String getUserName() {
        return _userName;
    }

    public void setUserName(String userName) {
        _userName = userName;
    }

    public Date getCreateDate() {
        return _createDate;
    }

    public void setCreateDate(Date createDate) {
        _createDate = createDate;
    }

    public Date getModifiedDate() {
        return _modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        _modifiedDate = modifiedDate;
    }
}
