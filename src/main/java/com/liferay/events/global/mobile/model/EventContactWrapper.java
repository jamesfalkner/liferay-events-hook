package com.liferay.events.global.mobile.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link EventContact}.
 * </p>
 *
 * @author James Falkner
 * @see EventContact
 * @generated
 */
public class EventContactWrapper implements EventContact,
    ModelWrapper<EventContact> {
    private EventContact _eventContact;

    public EventContactWrapper(EventContact eventContact) {
        _eventContact = eventContact;
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

    /**
    * Returns the primary key of this event contact.
    *
    * @return the primary key of this event contact
    */
    @Override
    public long getPrimaryKey() {
        return _eventContact.getPrimaryKey();
    }

    /**
    * Sets the primary key of this event contact.
    *
    * @param primaryKey the primary key of this event contact
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _eventContact.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the given name of this event contact.
    *
    * @return the given name of this event contact
    */
    @Override
    public java.lang.String getGivenName() {
        return _eventContact.getGivenName();
    }

    /**
    * Sets the given name of this event contact.
    *
    * @param givenName the given name of this event contact
    */
    @Override
    public void setGivenName(java.lang.String givenName) {
        _eventContact.setGivenName(givenName);
    }

    /**
    * Returns the full name of this event contact.
    *
    * @return the full name of this event contact
    */
    @Override
    public java.lang.String getFullName() {
        return _eventContact.getFullName();
    }

    /**
    * Sets the full name of this event contact.
    *
    * @param fullName the full name of this event contact
    */
    @Override
    public void setFullName(java.lang.String fullName) {
        _eventContact.setFullName(fullName);
    }

    /**
    * Returns the email address of this event contact.
    *
    * @return the email address of this event contact
    */
    @Override
    public java.lang.String getEmailAddress() {
        return _eventContact.getEmailAddress();
    }

    /**
    * Sets the email address of this event contact.
    *
    * @param emailAddress the email address of this event contact
    */
    @Override
    public void setEmailAddress(java.lang.String emailAddress) {
        _eventContact.setEmailAddress(emailAddress);
    }

    /**
    * Returns the city of this event contact.
    *
    * @return the city of this event contact
    */
    @Override
    public java.lang.String getCity() {
        return _eventContact.getCity();
    }

    /**
    * Sets the city of this event contact.
    *
    * @param city the city of this event contact
    */
    @Override
    public void setCity(java.lang.String city) {
        _eventContact.setCity(city);
    }

    /**
    * Returns the country of this event contact.
    *
    * @return the country of this event contact
    */
    @Override
    public java.lang.String getCountry() {
        return _eventContact.getCountry();
    }

    /**
    * Sets the country of this event contact.
    *
    * @param country the country of this event contact
    */
    @Override
    public void setCountry(java.lang.String country) {
        _eventContact.setCountry(country);
    }

    /**
    * Returns the lat of this event contact.
    *
    * @return the lat of this event contact
    */
    @Override
    public double getLat() {
        return _eventContact.getLat();
    }

    /**
    * Sets the lat of this event contact.
    *
    * @param lat the lat of this event contact
    */
    @Override
    public void setLat(double lat) {
        _eventContact.setLat(lat);
    }

    /**
    * Returns the lng of this event contact.
    *
    * @return the lng of this event contact
    */
    @Override
    public double getLng() {
        return _eventContact.getLng();
    }

    /**
    * Sets the lng of this event contact.
    *
    * @param lng the lng of this event contact
    */
    @Override
    public void setLng(double lng) {
        _eventContact.setLng(lng);
    }

    /**
    * Returns the job title of this event contact.
    *
    * @return the job title of this event contact
    */
    @Override
    public java.lang.String getJobTitle() {
        return _eventContact.getJobTitle();
    }

    /**
    * Sets the job title of this event contact.
    *
    * @param jobTitle the job title of this event contact
    */
    @Override
    public void setJobTitle(java.lang.String jobTitle) {
        _eventContact.setJobTitle(jobTitle);
    }

    /**
    * Returns the company of this event contact.
    *
    * @return the company of this event contact
    */
    @Override
    public java.lang.String getCompany() {
        return _eventContact.getCompany();
    }

    /**
    * Sets the company of this event contact.
    *
    * @param company the company of this event contact
    */
    @Override
    public void setCompany(java.lang.String company) {
        _eventContact.setCompany(company);
    }

    /**
    * Returns the industry of this event contact.
    *
    * @return the industry of this event contact
    */
    @Override
    public java.lang.String getIndustry() {
        return _eventContact.getIndustry();
    }

    /**
    * Sets the industry of this event contact.
    *
    * @param industry the industry of this event contact
    */
    @Override
    public void setIndustry(java.lang.String industry) {
        _eventContact.setIndustry(industry);
    }

    /**
    * Returns the interests of this event contact.
    *
    * @return the interests of this event contact
    */
    @Override
    public java.lang.String getInterests() {
        return _eventContact.getInterests();
    }

    /**
    * Sets the interests of this event contact.
    *
    * @param interests the interests of this event contact
    */
    @Override
    public void setInterests(java.lang.String interests) {
        _eventContact.setInterests(interests);
    }

    /**
    * Returns the desires of this event contact.
    *
    * @return the desires of this event contact
    */
    @Override
    public java.lang.String getDesires() {
        return _eventContact.getDesires();
    }

    /**
    * Sets the desires of this event contact.
    *
    * @param desires the desires of this event contact
    */
    @Override
    public void setDesires(java.lang.String desires) {
        _eventContact.setDesires(desires);
    }

    /**
    * Returns the expertise of this event contact.
    *
    * @return the expertise of this event contact
    */
    @Override
    public java.lang.String getExpertise() {
        return _eventContact.getExpertise();
    }

    /**
    * Sets the expertise of this event contact.
    *
    * @param expertise the expertise of this event contact
    */
    @Override
    public void setExpertise(java.lang.String expertise) {
        _eventContact.setExpertise(expertise);
    }

    /**
    * Returns the attendee type of this event contact.
    *
    * @return the attendee type of this event contact
    */
    @Override
    public java.lang.String getAttendeeType() {
        return _eventContact.getAttendeeType();
    }

    /**
    * Sets the attendee type of this event contact.
    *
    * @param attendeeType the attendee type of this event contact
    */
    @Override
    public void setAttendeeType(java.lang.String attendeeType) {
        _eventContact.setAttendeeType(attendeeType);
    }

    /**
    * Returns the interested IDs of this event contact.
    *
    * @return the interested IDs of this event contact
    */
    @Override
    public java.lang.String getInterestedIds() {
        return _eventContact.getInterestedIds();
    }

    /**
    * Sets the interested IDs of this event contact.
    *
    * @param interestedIds the interested IDs of this event contact
    */
    @Override
    public void setInterestedIds(java.lang.String interestedIds) {
        _eventContact.setInterestedIds(interestedIds);
    }

    /**
    * Returns the pic url of this event contact.
    *
    * @return the pic url of this event contact
    */
    @Override
    public java.lang.String getPicUrl() {
        return _eventContact.getPicUrl();
    }

    /**
    * Sets the pic url of this event contact.
    *
    * @param picUrl the pic url of this event contact
    */
    @Override
    public void setPicUrl(java.lang.String picUrl) {
        _eventContact.setPicUrl(picUrl);
    }

    /**
    * Returns the event ID of this event contact.
    *
    * @return the event ID of this event contact
    */
    @Override
    public java.lang.String getEventId() {
        return _eventContact.getEventId();
    }

    /**
    * Sets the event ID of this event contact.
    *
    * @param eventId the event ID of this event contact
    */
    @Override
    public void setEventId(java.lang.String eventId) {
        _eventContact.setEventId(eventId);
    }

    /**
    * Returns the verified of this event contact.
    *
    * @return the verified of this event contact
    */
    @Override
    public boolean getVerified() {
        return _eventContact.getVerified();
    }

    /**
    * Returns <code>true</code> if this event contact is verified.
    *
    * @return <code>true</code> if this event contact is verified; <code>false</code> otherwise
    */
    @Override
    public boolean isVerified() {
        return _eventContact.isVerified();
    }

    /**
    * Sets whether this event contact is verified.
    *
    * @param verified the verified of this event contact
    */
    @Override
    public void setVerified(boolean verified) {
        _eventContact.setVerified(verified);
    }

    /**
    * Returns the event contact ID of this event contact.
    *
    * @return the event contact ID of this event contact
    */
    @Override
    public long getEventContactId() {
        return _eventContact.getEventContactId();
    }

    /**
    * Sets the event contact ID of this event contact.
    *
    * @param eventContactId the event contact ID of this event contact
    */
    @Override
    public void setEventContactId(long eventContactId) {
        _eventContact.setEventContactId(eventContactId);
    }

    /**
    * Returns the group ID of this event contact.
    *
    * @return the group ID of this event contact
    */
    @Override
    public long getGroupId() {
        return _eventContact.getGroupId();
    }

    /**
    * Sets the group ID of this event contact.
    *
    * @param groupId the group ID of this event contact
    */
    @Override
    public void setGroupId(long groupId) {
        _eventContact.setGroupId(groupId);
    }

    /**
    * Returns the company ID of this event contact.
    *
    * @return the company ID of this event contact
    */
    @Override
    public long getCompanyId() {
        return _eventContact.getCompanyId();
    }

    /**
    * Sets the company ID of this event contact.
    *
    * @param companyId the company ID of this event contact
    */
    @Override
    public void setCompanyId(long companyId) {
        _eventContact.setCompanyId(companyId);
    }

    /**
    * Returns the user ID of this event contact.
    *
    * @return the user ID of this event contact
    */
    @Override
    public long getUserId() {
        return _eventContact.getUserId();
    }

    /**
    * Sets the user ID of this event contact.
    *
    * @param userId the user ID of this event contact
    */
    @Override
    public void setUserId(long userId) {
        _eventContact.setUserId(userId);
    }

    /**
    * Returns the user uuid of this event contact.
    *
    * @return the user uuid of this event contact
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _eventContact.getUserUuid();
    }

    /**
    * Sets the user uuid of this event contact.
    *
    * @param userUuid the user uuid of this event contact
    */
    @Override
    public void setUserUuid(java.lang.String userUuid) {
        _eventContact.setUserUuid(userUuid);
    }

    /**
    * Returns the user name of this event contact.
    *
    * @return the user name of this event contact
    */
    @Override
    public java.lang.String getUserName() {
        return _eventContact.getUserName();
    }

    /**
    * Sets the user name of this event contact.
    *
    * @param userName the user name of this event contact
    */
    @Override
    public void setUserName(java.lang.String userName) {
        _eventContact.setUserName(userName);
    }

    /**
    * Returns the create date of this event contact.
    *
    * @return the create date of this event contact
    */
    @Override
    public java.util.Date getCreateDate() {
        return _eventContact.getCreateDate();
    }

    /**
    * Sets the create date of this event contact.
    *
    * @param createDate the create date of this event contact
    */
    @Override
    public void setCreateDate(java.util.Date createDate) {
        _eventContact.setCreateDate(createDate);
    }

    /**
    * Returns the modified date of this event contact.
    *
    * @return the modified date of this event contact
    */
    @Override
    public java.util.Date getModifiedDate() {
        return _eventContact.getModifiedDate();
    }

    /**
    * Sets the modified date of this event contact.
    *
    * @param modifiedDate the modified date of this event contact
    */
    @Override
    public void setModifiedDate(java.util.Date modifiedDate) {
        _eventContact.setModifiedDate(modifiedDate);
    }

    @Override
    public boolean isNew() {
        return _eventContact.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _eventContact.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _eventContact.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _eventContact.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _eventContact.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _eventContact.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _eventContact.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _eventContact.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _eventContact.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _eventContact.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _eventContact.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new EventContactWrapper((EventContact) _eventContact.clone());
    }

    @Override
    public int compareTo(
        com.liferay.events.global.mobile.model.EventContact eventContact) {
        return _eventContact.compareTo(eventContact);
    }

    @Override
    public int hashCode() {
        return _eventContact.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.liferay.events.global.mobile.model.EventContact> toCacheModel() {
        return _eventContact.toCacheModel();
    }

    @Override
    public com.liferay.events.global.mobile.model.EventContact toEscapedModel() {
        return new EventContactWrapper(_eventContact.toEscapedModel());
    }

    @Override
    public com.liferay.events.global.mobile.model.EventContact toUnescapedModel() {
        return new EventContactWrapper(_eventContact.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _eventContact.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _eventContact.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _eventContact.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof EventContactWrapper)) {
            return false;
        }

        EventContactWrapper eventContactWrapper = (EventContactWrapper) obj;

        if (Validator.equals(_eventContact, eventContactWrapper._eventContact)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public EventContact getWrappedEventContact() {
        return _eventContact;
    }

    @Override
    public EventContact getWrappedModel() {
        return _eventContact;
    }

    @Override
    public void resetOriginalValues() {
        _eventContact.resetOriginalValues();
    }
}
