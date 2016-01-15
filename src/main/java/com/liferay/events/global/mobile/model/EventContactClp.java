package com.liferay.events.global.mobile.model;

import com.liferay.events.global.mobile.service.ClpSerializer;
import com.liferay.events.global.mobile.service.EventContactLocalServiceUtil;

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


public class EventContactClp extends BaseModelImpl<EventContact>
    implements EventContact {
    private String _givenName;
    private String _fullName;
    private String _emailAddress;
    private String _city;
    private String _country;
    private double _lat;
    private double _lng;
    private String _jobTitle;
    private String _company;
    private String _industry;
    private String _interests;
    private String _desires;
    private String _expertise;
    private String _attendeeType;
    private String _interestedIds;
    private String _picUrl;
    private String _eventId;
    private boolean _verified;
    private long _eventContactId;
    private long _groupId;
    private long _companyId;
    private long _userId;
    private String _userUuid;
    private String _userName;
    private Date _createDate;
    private Date _modifiedDate;
    private BaseModel<?> _eventContactRemoteModel;
    private Class<?> _clpSerializerClass = com.liferay.events.global.mobile.service.ClpSerializer.class;

    public EventContactClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return EventContact.class;
    }

    @Override
    public String getModelClassName() {
        return EventContact.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _eventContactId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setEventContactId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _eventContactId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("givenName", getGivenName());
        attributes.put("fullName", getFullName());
        attributes.put("emailAddress", getEmailAddress());
        attributes.put("city", getCity());
        attributes.put("country", getCountry());
        attributes.put("lat", getLat());
        attributes.put("lng", getLng());
        attributes.put("jobTitle", getJobTitle());
        attributes.put("company", getCompany());
        attributes.put("industry", getIndustry());
        attributes.put("interests", getInterests());
        attributes.put("desires", getDesires());
        attributes.put("expertise", getExpertise());
        attributes.put("attendeeType", getAttendeeType());
        attributes.put("interestedIds", getInterestedIds());
        attributes.put("picUrl", getPicUrl());
        attributes.put("eventId", getEventId());
        attributes.put("verified", getVerified());
        attributes.put("eventContactId", getEventContactId());
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
        String givenName = (String) attributes.get("givenName");

        if (givenName != null) {
            setGivenName(givenName);
        }

        String fullName = (String) attributes.get("fullName");

        if (fullName != null) {
            setFullName(fullName);
        }

        String emailAddress = (String) attributes.get("emailAddress");

        if (emailAddress != null) {
            setEmailAddress(emailAddress);
        }

        String city = (String) attributes.get("city");

        if (city != null) {
            setCity(city);
        }

        String country = (String) attributes.get("country");

        if (country != null) {
            setCountry(country);
        }

        Double lat = (Double) attributes.get("lat");

        if (lat != null) {
            setLat(lat);
        }

        Double lng = (Double) attributes.get("lng");

        if (lng != null) {
            setLng(lng);
        }

        String jobTitle = (String) attributes.get("jobTitle");

        if (jobTitle != null) {
            setJobTitle(jobTitle);
        }

        String company = (String) attributes.get("company");

        if (company != null) {
            setCompany(company);
        }

        String industry = (String) attributes.get("industry");

        if (industry != null) {
            setIndustry(industry);
        }

        String interests = (String) attributes.get("interests");

        if (interests != null) {
            setInterests(interests);
        }

        String desires = (String) attributes.get("desires");

        if (desires != null) {
            setDesires(desires);
        }

        String expertise = (String) attributes.get("expertise");

        if (expertise != null) {
            setExpertise(expertise);
        }

        String attendeeType = (String) attributes.get("attendeeType");

        if (attendeeType != null) {
            setAttendeeType(attendeeType);
        }

        String interestedIds = (String) attributes.get("interestedIds");

        if (interestedIds != null) {
            setInterestedIds(interestedIds);
        }

        String picUrl = (String) attributes.get("picUrl");

        if (picUrl != null) {
            setPicUrl(picUrl);
        }

        String eventId = (String) attributes.get("eventId");

        if (eventId != null) {
            setEventId(eventId);
        }

        Boolean verified = (Boolean) attributes.get("verified");

        if (verified != null) {
            setVerified(verified);
        }

        Long eventContactId = (Long) attributes.get("eventContactId");

        if (eventContactId != null) {
            setEventContactId(eventContactId);
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
    public String getGivenName() {
        return _givenName;
    }

    @Override
    public void setGivenName(String givenName) {
        _givenName = givenName;

        if (_eventContactRemoteModel != null) {
            try {
                Class<?> clazz = _eventContactRemoteModel.getClass();

                Method method = clazz.getMethod("setGivenName", String.class);

                method.invoke(_eventContactRemoteModel, givenName);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getFullName() {
        return _fullName;
    }

    @Override
    public void setFullName(String fullName) {
        _fullName = fullName;

        if (_eventContactRemoteModel != null) {
            try {
                Class<?> clazz = _eventContactRemoteModel.getClass();

                Method method = clazz.getMethod("setFullName", String.class);

                method.invoke(_eventContactRemoteModel, fullName);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getEmailAddress() {
        return _emailAddress;
    }

    @Override
    public void setEmailAddress(String emailAddress) {
        _emailAddress = emailAddress;

        if (_eventContactRemoteModel != null) {
            try {
                Class<?> clazz = _eventContactRemoteModel.getClass();

                Method method = clazz.getMethod("setEmailAddress", String.class);

                method.invoke(_eventContactRemoteModel, emailAddress);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getCity() {
        return _city;
    }

    @Override
    public void setCity(String city) {
        _city = city;

        if (_eventContactRemoteModel != null) {
            try {
                Class<?> clazz = _eventContactRemoteModel.getClass();

                Method method = clazz.getMethod("setCity", String.class);

                method.invoke(_eventContactRemoteModel, city);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getCountry() {
        return _country;
    }

    @Override
    public void setCountry(String country) {
        _country = country;

        if (_eventContactRemoteModel != null) {
            try {
                Class<?> clazz = _eventContactRemoteModel.getClass();

                Method method = clazz.getMethod("setCountry", String.class);

                method.invoke(_eventContactRemoteModel, country);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public double getLat() {
        return _lat;
    }

    @Override
    public void setLat(double lat) {
        _lat = lat;

        if (_eventContactRemoteModel != null) {
            try {
                Class<?> clazz = _eventContactRemoteModel.getClass();

                Method method = clazz.getMethod("setLat", double.class);

                method.invoke(_eventContactRemoteModel, lat);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public double getLng() {
        return _lng;
    }

    @Override
    public void setLng(double lng) {
        _lng = lng;

        if (_eventContactRemoteModel != null) {
            try {
                Class<?> clazz = _eventContactRemoteModel.getClass();

                Method method = clazz.getMethod("setLng", double.class);

                method.invoke(_eventContactRemoteModel, lng);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getJobTitle() {
        return _jobTitle;
    }

    @Override
    public void setJobTitle(String jobTitle) {
        _jobTitle = jobTitle;

        if (_eventContactRemoteModel != null) {
            try {
                Class<?> clazz = _eventContactRemoteModel.getClass();

                Method method = clazz.getMethod("setJobTitle", String.class);

                method.invoke(_eventContactRemoteModel, jobTitle);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getCompany() {
        return _company;
    }

    @Override
    public void setCompany(String company) {
        _company = company;

        if (_eventContactRemoteModel != null) {
            try {
                Class<?> clazz = _eventContactRemoteModel.getClass();

                Method method = clazz.getMethod("setCompany", String.class);

                method.invoke(_eventContactRemoteModel, company);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getIndustry() {
        return _industry;
    }

    @Override
    public void setIndustry(String industry) {
        _industry = industry;

        if (_eventContactRemoteModel != null) {
            try {
                Class<?> clazz = _eventContactRemoteModel.getClass();

                Method method = clazz.getMethod("setIndustry", String.class);

                method.invoke(_eventContactRemoteModel, industry);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getInterests() {
        return _interests;
    }

    @Override
    public void setInterests(String interests) {
        _interests = interests;

        if (_eventContactRemoteModel != null) {
            try {
                Class<?> clazz = _eventContactRemoteModel.getClass();

                Method method = clazz.getMethod("setInterests", String.class);

                method.invoke(_eventContactRemoteModel, interests);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getDesires() {
        return _desires;
    }

    @Override
    public void setDesires(String desires) {
        _desires = desires;

        if (_eventContactRemoteModel != null) {
            try {
                Class<?> clazz = _eventContactRemoteModel.getClass();

                Method method = clazz.getMethod("setDesires", String.class);

                method.invoke(_eventContactRemoteModel, desires);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getExpertise() {
        return _expertise;
    }

    @Override
    public void setExpertise(String expertise) {
        _expertise = expertise;

        if (_eventContactRemoteModel != null) {
            try {
                Class<?> clazz = _eventContactRemoteModel.getClass();

                Method method = clazz.getMethod("setExpertise", String.class);

                method.invoke(_eventContactRemoteModel, expertise);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getAttendeeType() {
        return _attendeeType;
    }

    @Override
    public void setAttendeeType(String attendeeType) {
        _attendeeType = attendeeType;

        if (_eventContactRemoteModel != null) {
            try {
                Class<?> clazz = _eventContactRemoteModel.getClass();

                Method method = clazz.getMethod("setAttendeeType", String.class);

                method.invoke(_eventContactRemoteModel, attendeeType);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getInterestedIds() {
        return _interestedIds;
    }

    @Override
    public void setInterestedIds(String interestedIds) {
        _interestedIds = interestedIds;

        if (_eventContactRemoteModel != null) {
            try {
                Class<?> clazz = _eventContactRemoteModel.getClass();

                Method method = clazz.getMethod("setInterestedIds", String.class);

                method.invoke(_eventContactRemoteModel, interestedIds);
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

        if (_eventContactRemoteModel != null) {
            try {
                Class<?> clazz = _eventContactRemoteModel.getClass();

                Method method = clazz.getMethod("setPicUrl", String.class);

                method.invoke(_eventContactRemoteModel, picUrl);
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

        if (_eventContactRemoteModel != null) {
            try {
                Class<?> clazz = _eventContactRemoteModel.getClass();

                Method method = clazz.getMethod("setEventId", String.class);

                method.invoke(_eventContactRemoteModel, eventId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public boolean getVerified() {
        return _verified;
    }

    @Override
    public boolean isVerified() {
        return _verified;
    }

    @Override
    public void setVerified(boolean verified) {
        _verified = verified;

        if (_eventContactRemoteModel != null) {
            try {
                Class<?> clazz = _eventContactRemoteModel.getClass();

                Method method = clazz.getMethod("setVerified", boolean.class);

                method.invoke(_eventContactRemoteModel, verified);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getEventContactId() {
        return _eventContactId;
    }

    @Override
    public void setEventContactId(long eventContactId) {
        _eventContactId = eventContactId;

        if (_eventContactRemoteModel != null) {
            try {
                Class<?> clazz = _eventContactRemoteModel.getClass();

                Method method = clazz.getMethod("setEventContactId", long.class);

                method.invoke(_eventContactRemoteModel, eventContactId);
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

        if (_eventContactRemoteModel != null) {
            try {
                Class<?> clazz = _eventContactRemoteModel.getClass();

                Method method = clazz.getMethod("setGroupId", long.class);

                method.invoke(_eventContactRemoteModel, groupId);
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

        if (_eventContactRemoteModel != null) {
            try {
                Class<?> clazz = _eventContactRemoteModel.getClass();

                Method method = clazz.getMethod("setCompanyId", long.class);

                method.invoke(_eventContactRemoteModel, companyId);
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

        if (_eventContactRemoteModel != null) {
            try {
                Class<?> clazz = _eventContactRemoteModel.getClass();

                Method method = clazz.getMethod("setUserId", long.class);

                method.invoke(_eventContactRemoteModel, userId);
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

        if (_eventContactRemoteModel != null) {
            try {
                Class<?> clazz = _eventContactRemoteModel.getClass();

                Method method = clazz.getMethod("setUserName", String.class);

                method.invoke(_eventContactRemoteModel, userName);
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

        if (_eventContactRemoteModel != null) {
            try {
                Class<?> clazz = _eventContactRemoteModel.getClass();

                Method method = clazz.getMethod("setCreateDate", Date.class);

                method.invoke(_eventContactRemoteModel, createDate);
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

        if (_eventContactRemoteModel != null) {
            try {
                Class<?> clazz = _eventContactRemoteModel.getClass();

                Method method = clazz.getMethod("setModifiedDate", Date.class);

                method.invoke(_eventContactRemoteModel, modifiedDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getEventContactRemoteModel() {
        return _eventContactRemoteModel;
    }

    public void setEventContactRemoteModel(BaseModel<?> eventContactRemoteModel) {
        _eventContactRemoteModel = eventContactRemoteModel;
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

        Class<?> remoteModelClass = _eventContactRemoteModel.getClass();

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

        Object returnValue = method.invoke(_eventContactRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            EventContactLocalServiceUtil.addEventContact(this);
        } else {
            EventContactLocalServiceUtil.updateEventContact(this);
        }
    }

    @Override
    public EventContact toEscapedModel() {
        return (EventContact) ProxyUtil.newProxyInstance(EventContact.class.getClassLoader(),
            new Class[] { EventContact.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        EventContactClp clone = new EventContactClp();

        clone.setGivenName(getGivenName());
        clone.setFullName(getFullName());
        clone.setEmailAddress(getEmailAddress());
        clone.setCity(getCity());
        clone.setCountry(getCountry());
        clone.setLat(getLat());
        clone.setLng(getLng());
        clone.setJobTitle(getJobTitle());
        clone.setCompany(getCompany());
        clone.setIndustry(getIndustry());
        clone.setInterests(getInterests());
        clone.setDesires(getDesires());
        clone.setExpertise(getExpertise());
        clone.setAttendeeType(getAttendeeType());
        clone.setInterestedIds(getInterestedIds());
        clone.setPicUrl(getPicUrl());
        clone.setEventId(getEventId());
        clone.setVerified(getVerified());
        clone.setEventContactId(getEventContactId());
        clone.setGroupId(getGroupId());
        clone.setCompanyId(getCompanyId());
        clone.setUserId(getUserId());
        clone.setUserName(getUserName());
        clone.setCreateDate(getCreateDate());
        clone.setModifiedDate(getModifiedDate());

        return clone;
    }

    @Override
    public int compareTo(EventContact eventContact) {
        long primaryKey = eventContact.getPrimaryKey();

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

        if (!(obj instanceof EventContactClp)) {
            return false;
        }

        EventContactClp eventContact = (EventContactClp) obj;

        long primaryKey = eventContact.getPrimaryKey();

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
        StringBundler sb = new StringBundler(51);

        sb.append("{givenName=");
        sb.append(getGivenName());
        sb.append(", fullName=");
        sb.append(getFullName());
        sb.append(", emailAddress=");
        sb.append(getEmailAddress());
        sb.append(", city=");
        sb.append(getCity());
        sb.append(", country=");
        sb.append(getCountry());
        sb.append(", lat=");
        sb.append(getLat());
        sb.append(", lng=");
        sb.append(getLng());
        sb.append(", jobTitle=");
        sb.append(getJobTitle());
        sb.append(", company=");
        sb.append(getCompany());
        sb.append(", industry=");
        sb.append(getIndustry());
        sb.append(", interests=");
        sb.append(getInterests());
        sb.append(", desires=");
        sb.append(getDesires());
        sb.append(", expertise=");
        sb.append(getExpertise());
        sb.append(", attendeeType=");
        sb.append(getAttendeeType());
        sb.append(", interestedIds=");
        sb.append(getInterestedIds());
        sb.append(", picUrl=");
        sb.append(getPicUrl());
        sb.append(", eventId=");
        sb.append(getEventId());
        sb.append(", verified=");
        sb.append(getVerified());
        sb.append(", eventContactId=");
        sb.append(getEventContactId());
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
        StringBundler sb = new StringBundler(79);

        sb.append("<model><model-name>");
        sb.append("com.liferay.events.global.mobile.model.EventContact");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>givenName</column-name><column-value><![CDATA[");
        sb.append(getGivenName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>fullName</column-name><column-value><![CDATA[");
        sb.append(getFullName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>emailAddress</column-name><column-value><![CDATA[");
        sb.append(getEmailAddress());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>city</column-name><column-value><![CDATA[");
        sb.append(getCity());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>country</column-name><column-value><![CDATA[");
        sb.append(getCountry());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>lat</column-name><column-value><![CDATA[");
        sb.append(getLat());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>lng</column-name><column-value><![CDATA[");
        sb.append(getLng());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>jobTitle</column-name><column-value><![CDATA[");
        sb.append(getJobTitle());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>company</column-name><column-value><![CDATA[");
        sb.append(getCompany());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>industry</column-name><column-value><![CDATA[");
        sb.append(getIndustry());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>interests</column-name><column-value><![CDATA[");
        sb.append(getInterests());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>desires</column-name><column-value><![CDATA[");
        sb.append(getDesires());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>expertise</column-name><column-value><![CDATA[");
        sb.append(getExpertise());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>attendeeType</column-name><column-value><![CDATA[");
        sb.append(getAttendeeType());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>interestedIds</column-name><column-value><![CDATA[");
        sb.append(getInterestedIds());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>picUrl</column-name><column-value><![CDATA[");
        sb.append(getPicUrl());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>eventId</column-name><column-value><![CDATA[");
        sb.append(getEventId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>verified</column-name><column-value><![CDATA[");
        sb.append(getVerified());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>eventContactId</column-name><column-value><![CDATA[");
        sb.append(getEventContactId());
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
