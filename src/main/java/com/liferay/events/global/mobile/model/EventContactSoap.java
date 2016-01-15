package com.liferay.events.global.mobile.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.events.global.mobile.service.http.EventContactServiceSoap}.
 *
 * @author James Falkner
 * @see com.liferay.events.global.mobile.service.http.EventContactServiceSoap
 * @generated
 */
public class EventContactSoap implements Serializable {
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
    private String _userName;
    private Date _createDate;
    private Date _modifiedDate;

    public EventContactSoap() {
    }

    public static EventContactSoap toSoapModel(EventContact model) {
        EventContactSoap soapModel = new EventContactSoap();

        soapModel.setGivenName(model.getGivenName());
        soapModel.setFullName(model.getFullName());
        soapModel.setEmailAddress(model.getEmailAddress());
        soapModel.setCity(model.getCity());
        soapModel.setCountry(model.getCountry());
        soapModel.setLat(model.getLat());
        soapModel.setLng(model.getLng());
        soapModel.setJobTitle(model.getJobTitle());
        soapModel.setCompany(model.getCompany());
        soapModel.setIndustry(model.getIndustry());
        soapModel.setInterests(model.getInterests());
        soapModel.setDesires(model.getDesires());
        soapModel.setExpertise(model.getExpertise());
        soapModel.setAttendeeType(model.getAttendeeType());
        soapModel.setInterestedIds(model.getInterestedIds());
        soapModel.setPicUrl(model.getPicUrl());
        soapModel.setEventId(model.getEventId());
        soapModel.setVerified(model.getVerified());
        soapModel.setEventContactId(model.getEventContactId());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setUserId(model.getUserId());
        soapModel.setUserName(model.getUserName());
        soapModel.setCreateDate(model.getCreateDate());
        soapModel.setModifiedDate(model.getModifiedDate());

        return soapModel;
    }

    public static EventContactSoap[] toSoapModels(EventContact[] models) {
        EventContactSoap[] soapModels = new EventContactSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static EventContactSoap[][] toSoapModels(EventContact[][] models) {
        EventContactSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new EventContactSoap[models.length][models[0].length];
        } else {
            soapModels = new EventContactSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static EventContactSoap[] toSoapModels(List<EventContact> models) {
        List<EventContactSoap> soapModels = new ArrayList<EventContactSoap>(models.size());

        for (EventContact model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new EventContactSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _eventContactId;
    }

    public void setPrimaryKey(long pk) {
        setEventContactId(pk);
    }

    public String getGivenName() {
        return _givenName;
    }

    public void setGivenName(String givenName) {
        _givenName = givenName;
    }

    public String getFullName() {
        return _fullName;
    }

    public void setFullName(String fullName) {
        _fullName = fullName;
    }

    public String getEmailAddress() {
        return _emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        _emailAddress = emailAddress;
    }

    public String getCity() {
        return _city;
    }

    public void setCity(String city) {
        _city = city;
    }

    public String getCountry() {
        return _country;
    }

    public void setCountry(String country) {
        _country = country;
    }

    public double getLat() {
        return _lat;
    }

    public void setLat(double lat) {
        _lat = lat;
    }

    public double getLng() {
        return _lng;
    }

    public void setLng(double lng) {
        _lng = lng;
    }

    public String getJobTitle() {
        return _jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        _jobTitle = jobTitle;
    }

    public String getCompany() {
        return _company;
    }

    public void setCompany(String company) {
        _company = company;
    }

    public String getIndustry() {
        return _industry;
    }

    public void setIndustry(String industry) {
        _industry = industry;
    }

    public String getInterests() {
        return _interests;
    }

    public void setInterests(String interests) {
        _interests = interests;
    }

    public String getDesires() {
        return _desires;
    }

    public void setDesires(String desires) {
        _desires = desires;
    }

    public String getExpertise() {
        return _expertise;
    }

    public void setExpertise(String expertise) {
        _expertise = expertise;
    }

    public String getAttendeeType() {
        return _attendeeType;
    }

    public void setAttendeeType(String attendeeType) {
        _attendeeType = attendeeType;
    }

    public String getInterestedIds() {
        return _interestedIds;
    }

    public void setInterestedIds(String interestedIds) {
        _interestedIds = interestedIds;
    }

    public String getPicUrl() {
        return _picUrl;
    }

    public void setPicUrl(String picUrl) {
        _picUrl = picUrl;
    }

    public String getEventId() {
        return _eventId;
    }

    public void setEventId(String eventId) {
        _eventId = eventId;
    }

    public boolean getVerified() {
        return _verified;
    }

    public boolean isVerified() {
        return _verified;
    }

    public void setVerified(boolean verified) {
        _verified = verified;
    }

    public long getEventContactId() {
        return _eventContactId;
    }

    public void setEventContactId(long eventContactId) {
        _eventContactId = eventContactId;
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
