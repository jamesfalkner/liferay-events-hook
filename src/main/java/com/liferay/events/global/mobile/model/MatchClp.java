package com.liferay.events.global.mobile.model;

import com.liferay.events.global.mobile.service.ClpSerializer;
import com.liferay.events.global.mobile.service.MatchLocalServiceUtil;

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


public class MatchClp extends BaseModelImpl<Match> implements Match {
    private long _contactId1;
    private long _contactId2;
    private String _eventId;
    private long _matchId;
    private long _groupId;
    private long _companyId;
    private long _userId;
    private String _userUuid;
    private String _userName;
    private Date _createDate;
    private Date _modifiedDate;
    private BaseModel<?> _matchRemoteModel;
    private Class<?> _clpSerializerClass = com.liferay.events.global.mobile.service.ClpSerializer.class;

    public MatchClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return Match.class;
    }

    @Override
    public String getModelClassName() {
        return Match.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _matchId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setMatchId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _matchId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("contactId1", getContactId1());
        attributes.put("contactId2", getContactId2());
        attributes.put("eventId", getEventId());
        attributes.put("matchId", getMatchId());
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
        Long contactId1 = (Long) attributes.get("contactId1");

        if (contactId1 != null) {
            setContactId1(contactId1);
        }

        Long contactId2 = (Long) attributes.get("contactId2");

        if (contactId2 != null) {
            setContactId2(contactId2);
        }

        String eventId = (String) attributes.get("eventId");

        if (eventId != null) {
            setEventId(eventId);
        }

        Long matchId = (Long) attributes.get("matchId");

        if (matchId != null) {
            setMatchId(matchId);
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
    public long getContactId1() {
        return _contactId1;
    }

    @Override
    public void setContactId1(long contactId1) {
        _contactId1 = contactId1;

        if (_matchRemoteModel != null) {
            try {
                Class<?> clazz = _matchRemoteModel.getClass();

                Method method = clazz.getMethod("setContactId1", long.class);

                method.invoke(_matchRemoteModel, contactId1);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getContactId2() {
        return _contactId2;
    }

    @Override
    public void setContactId2(long contactId2) {
        _contactId2 = contactId2;

        if (_matchRemoteModel != null) {
            try {
                Class<?> clazz = _matchRemoteModel.getClass();

                Method method = clazz.getMethod("setContactId2", long.class);

                method.invoke(_matchRemoteModel, contactId2);
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

        if (_matchRemoteModel != null) {
            try {
                Class<?> clazz = _matchRemoteModel.getClass();

                Method method = clazz.getMethod("setEventId", String.class);

                method.invoke(_matchRemoteModel, eventId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getMatchId() {
        return _matchId;
    }

    @Override
    public void setMatchId(long matchId) {
        _matchId = matchId;

        if (_matchRemoteModel != null) {
            try {
                Class<?> clazz = _matchRemoteModel.getClass();

                Method method = clazz.getMethod("setMatchId", long.class);

                method.invoke(_matchRemoteModel, matchId);
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

        if (_matchRemoteModel != null) {
            try {
                Class<?> clazz = _matchRemoteModel.getClass();

                Method method = clazz.getMethod("setGroupId", long.class);

                method.invoke(_matchRemoteModel, groupId);
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

        if (_matchRemoteModel != null) {
            try {
                Class<?> clazz = _matchRemoteModel.getClass();

                Method method = clazz.getMethod("setCompanyId", long.class);

                method.invoke(_matchRemoteModel, companyId);
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

        if (_matchRemoteModel != null) {
            try {
                Class<?> clazz = _matchRemoteModel.getClass();

                Method method = clazz.getMethod("setUserId", long.class);

                method.invoke(_matchRemoteModel, userId);
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

        if (_matchRemoteModel != null) {
            try {
                Class<?> clazz = _matchRemoteModel.getClass();

                Method method = clazz.getMethod("setUserName", String.class);

                method.invoke(_matchRemoteModel, userName);
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

        if (_matchRemoteModel != null) {
            try {
                Class<?> clazz = _matchRemoteModel.getClass();

                Method method = clazz.getMethod("setCreateDate", Date.class);

                method.invoke(_matchRemoteModel, createDate);
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

        if (_matchRemoteModel != null) {
            try {
                Class<?> clazz = _matchRemoteModel.getClass();

                Method method = clazz.getMethod("setModifiedDate", Date.class);

                method.invoke(_matchRemoteModel, modifiedDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getMatchRemoteModel() {
        return _matchRemoteModel;
    }

    public void setMatchRemoteModel(BaseModel<?> matchRemoteModel) {
        _matchRemoteModel = matchRemoteModel;
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

        Class<?> remoteModelClass = _matchRemoteModel.getClass();

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

        Object returnValue = method.invoke(_matchRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            MatchLocalServiceUtil.addMatch(this);
        } else {
            MatchLocalServiceUtil.updateMatch(this);
        }
    }

    @Override
    public Match toEscapedModel() {
        return (Match) ProxyUtil.newProxyInstance(Match.class.getClassLoader(),
            new Class[] { Match.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        MatchClp clone = new MatchClp();

        clone.setContactId1(getContactId1());
        clone.setContactId2(getContactId2());
        clone.setEventId(getEventId());
        clone.setMatchId(getMatchId());
        clone.setGroupId(getGroupId());
        clone.setCompanyId(getCompanyId());
        clone.setUserId(getUserId());
        clone.setUserName(getUserName());
        clone.setCreateDate(getCreateDate());
        clone.setModifiedDate(getModifiedDate());

        return clone;
    }

    @Override
    public int compareTo(Match match) {
        long primaryKey = match.getPrimaryKey();

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

        if (!(obj instanceof MatchClp)) {
            return false;
        }

        MatchClp match = (MatchClp) obj;

        long primaryKey = match.getPrimaryKey();

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
        StringBundler sb = new StringBundler(21);

        sb.append("{contactId1=");
        sb.append(getContactId1());
        sb.append(", contactId2=");
        sb.append(getContactId2());
        sb.append(", eventId=");
        sb.append(getEventId());
        sb.append(", matchId=");
        sb.append(getMatchId());
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
        StringBundler sb = new StringBundler(34);

        sb.append("<model><model-name>");
        sb.append("com.liferay.events.global.mobile.model.Match");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>contactId1</column-name><column-value><![CDATA[");
        sb.append(getContactId1());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>contactId2</column-name><column-value><![CDATA[");
        sb.append(getContactId2());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>eventId</column-name><column-value><![CDATA[");
        sb.append(getEventId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>matchId</column-name><column-value><![CDATA[");
        sb.append(getMatchId());
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
