package com.liferay.events.global.mobile.model;

import com.liferay.events.global.mobile.service.ClpSerializer;
import com.liferay.events.global.mobile.service.MessageLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class MessageClp extends BaseModelImpl<Message> implements Message {
    private long _fromId;
    private long _toId;
    private String _content;
    private boolean _read;
    private String _eventId;
    private long _messageId;
    private long _groupId;
    private long _companyId;
    private long _userId;
    private String _userUuid;
    private String _userName;
    private Date _createDate;
    private Date _modifiedDate;
    private BaseModel<?> _messageRemoteModel;
    private Class<?> _clpSerializerClass = com.liferay.events.global.mobile.service.ClpSerializer.class;

    public MessageClp() {
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
    public long getPrimaryKey() {
        return _messageId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setMessageId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _messageId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
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

    @Override
    public long getFromId() {
        return _fromId;
    }

    @Override
    public void setFromId(long fromId) {
        _fromId = fromId;

        if (_messageRemoteModel != null) {
            try {
                Class<?> clazz = _messageRemoteModel.getClass();

                Method method = clazz.getMethod("setFromId", long.class);

                method.invoke(_messageRemoteModel, fromId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getToId() {
        return _toId;
    }

    @Override
    public void setToId(long toId) {
        _toId = toId;

        if (_messageRemoteModel != null) {
            try {
                Class<?> clazz = _messageRemoteModel.getClass();

                Method method = clazz.getMethod("setToId", long.class);

                method.invoke(_messageRemoteModel, toId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getContent() {
        return _content;
    }

    @Override
    public void setContent(String content) {
        _content = content;

        if (_messageRemoteModel != null) {
            try {
                Class<?> clazz = _messageRemoteModel.getClass();

                Method method = clazz.getMethod("setContent", String.class);

                method.invoke(_messageRemoteModel, content);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public boolean getRead() {
        return _read;
    }

    @Override
    public boolean isRead() {
        return _read;
    }

    @Override
    public void setRead(boolean read) {
        _read = read;

        if (_messageRemoteModel != null) {
            try {
                Class<?> clazz = _messageRemoteModel.getClass();

                Method method = clazz.getMethod("setRead", boolean.class);

                method.invoke(_messageRemoteModel, read);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getEventId() {
        return _eventId;
    }

    @Override
    public void setEventId(String eventId) {
        _eventId = eventId;

        if (_messageRemoteModel != null) {
            try {
                Class<?> clazz = _messageRemoteModel.getClass();

                Method method = clazz.getMethod("setEventId", String.class);

                method.invoke(_messageRemoteModel, eventId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getMessageId() {
        return _messageId;
    }

    @Override
    public void setMessageId(long messageId) {
        _messageId = messageId;

        if (_messageRemoteModel != null) {
            try {
                Class<?> clazz = _messageRemoteModel.getClass();

                Method method = clazz.getMethod("setMessageId", long.class);

                method.invoke(_messageRemoteModel, messageId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getGroupId() {
        return _groupId;
    }

    @Override
    public void setGroupId(long groupId) {
        _groupId = groupId;

        if (_messageRemoteModel != null) {
            try {
                Class<?> clazz = _messageRemoteModel.getClass();

                Method method = clazz.getMethod("setGroupId", long.class);

                method.invoke(_messageRemoteModel, groupId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getCompanyId() {
        return _companyId;
    }

    @Override
    public void setCompanyId(long companyId) {
        _companyId = companyId;

        if (_messageRemoteModel != null) {
            try {
                Class<?> clazz = _messageRemoteModel.getClass();

                Method method = clazz.getMethod("setCompanyId", long.class);

                method.invoke(_messageRemoteModel, companyId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getUserId() {
        return _userId;
    }

    @Override
    public void setUserId(long userId) {
        _userId = userId;

        if (_messageRemoteModel != null) {
            try {
                Class<?> clazz = _messageRemoteModel.getClass();

                Method method = clazz.getMethod("setUserId", long.class);

                method.invoke(_messageRemoteModel, userId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getUserUuid() throws SystemException {
        return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
    }

    @Override
    public void setUserUuid(String userUuid) {
        _userUuid = userUuid;
    }

    @Override
    public String getUserName() {
        return _userName;
    }

    @Override
    public void setUserName(String userName) {
        _userName = userName;

        if (_messageRemoteModel != null) {
            try {
                Class<?> clazz = _messageRemoteModel.getClass();

                Method method = clazz.getMethod("setUserName", String.class);

                method.invoke(_messageRemoteModel, userName);
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

        if (_messageRemoteModel != null) {
            try {
                Class<?> clazz = _messageRemoteModel.getClass();

                Method method = clazz.getMethod("setCreateDate", Date.class);

                method.invoke(_messageRemoteModel, createDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getModifiedDate() {
        return _modifiedDate;
    }

    @Override
    public void setModifiedDate(Date modifiedDate) {
        _modifiedDate = modifiedDate;

        if (_messageRemoteModel != null) {
            try {
                Class<?> clazz = _messageRemoteModel.getClass();

                Method method = clazz.getMethod("setModifiedDate", Date.class);

                method.invoke(_messageRemoteModel, modifiedDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getMessageRemoteModel() {
        return _messageRemoteModel;
    }

    public void setMessageRemoteModel(BaseModel<?> messageRemoteModel) {
        _messageRemoteModel = messageRemoteModel;
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

        Class<?> remoteModelClass = _messageRemoteModel.getClass();

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

        Object returnValue = method.invoke(_messageRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            MessageLocalServiceUtil.addMessage(this);
        } else {
            MessageLocalServiceUtil.updateMessage(this);
        }
    }

    @Override
    public Message toEscapedModel() {
        return (Message) ProxyUtil.newProxyInstance(Message.class.getClassLoader(),
            new Class[] { Message.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        MessageClp clone = new MessageClp();

        clone.setFromId(getFromId());
        clone.setToId(getToId());
        clone.setContent(getContent());
        clone.setRead(getRead());
        clone.setEventId(getEventId());
        clone.setMessageId(getMessageId());
        clone.setGroupId(getGroupId());
        clone.setCompanyId(getCompanyId());
        clone.setUserId(getUserId());
        clone.setUserName(getUserName());
        clone.setCreateDate(getCreateDate());
        clone.setModifiedDate(getModifiedDate());

        return clone;
    }

    @Override
    public int compareTo(Message message) {
        long primaryKey = message.getPrimaryKey();

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

        if (!(obj instanceof MessageClp)) {
            return false;
        }

        MessageClp message = (MessageClp) obj;

        long primaryKey = message.getPrimaryKey();

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
        StringBundler sb = new StringBundler(25);

        sb.append("{fromId=");
        sb.append(getFromId());
        sb.append(", toId=");
        sb.append(getToId());
        sb.append(", content=");
        sb.append(getContent());
        sb.append(", read=");
        sb.append(getRead());
        sb.append(", eventId=");
        sb.append(getEventId());
        sb.append(", messageId=");
        sb.append(getMessageId());
        sb.append(", groupId=");
        sb.append(getGroupId());
        sb.append(", companyId=");
        sb.append(getCompanyId());
        sb.append(", userId=");
        sb.append(getUserId());
        sb.append(", userName=");
        sb.append(getUserName());
        sb.append(", createDate=");
        sb.append(getCreateDate());
        sb.append(", modifiedDate=");
        sb.append(getModifiedDate());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(40);

        sb.append("<model><model-name>");
        sb.append("com.liferay.events.global.mobile.model.Message");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>fromId</column-name><column-value><![CDATA[");
        sb.append(getFromId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>toId</column-name><column-value><![CDATA[");
        sb.append(getToId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>content</column-name><column-value><![CDATA[");
        sb.append(getContent());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>read</column-name><column-value><![CDATA[");
        sb.append(getRead());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>eventId</column-name><column-value><![CDATA[");
        sb.append(getEventId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>messageId</column-name><column-value><![CDATA[");
        sb.append(getMessageId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>groupId</column-name><column-value><![CDATA[");
        sb.append(getGroupId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>companyId</column-name><column-value><![CDATA[");
        sb.append(getCompanyId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userId</column-name><column-value><![CDATA[");
        sb.append(getUserId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userName</column-name><column-value><![CDATA[");
        sb.append(getUserName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>createDate</column-name><column-value><![CDATA[");
        sb.append(getCreateDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
        sb.append(getModifiedDate());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
