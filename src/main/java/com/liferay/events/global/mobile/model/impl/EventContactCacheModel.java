package com.liferay.events.global.mobile.model.impl;

import com.liferay.events.global.mobile.model.EventContact;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EventContact in entity cache.
 *
 * @author James Falkner
 * @see EventContact
 * @generated
 */
public class EventContactCacheModel implements CacheModel<EventContact>,
    Externalizable {
    public String givenName;
    public String fullName;
    public String emailAddress;
    public String city;
    public String country;
    public double lat;
    public double lng;
    public String jobTitle;
    public String company;
    public String industry;
    public String interests;
    public String desires;
    public String expertise;
    public String attendeeType;
    public String interestedIds;
    public String picUrl;
    public String eventId;
    public boolean verified;
    public long eventContactId;
    public long groupId;
    public long companyId;
    public long userId;
    public String userName;
    public long createDate;
    public long modifiedDate;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(51);

        sb.append("{givenName=");
        sb.append(givenName);
        sb.append(", fullName=");
        sb.append(fullName);
        sb.append(", emailAddress=");
        sb.append(emailAddress);
        sb.append(", city=");
        sb.append(city);
        sb.append(", country=");
        sb.append(country);
        sb.append(", lat=");
        sb.append(lat);
        sb.append(", lng=");
        sb.append(lng);
        sb.append(", jobTitle=");
        sb.append(jobTitle);
        sb.append(", company=");
        sb.append(company);
        sb.append(", industry=");
        sb.append(industry);
        sb.append(", interests=");
        sb.append(interests);
        sb.append(", desires=");
        sb.append(desires);
        sb.append(", expertise=");
        sb.append(expertise);
        sb.append(", attendeeType=");
        sb.append(attendeeType);
        sb.append(", interestedIds=");
        sb.append(interestedIds);
        sb.append(", picUrl=");
        sb.append(picUrl);
        sb.append(", eventId=");
        sb.append(eventId);
        sb.append(", verified=");
        sb.append(verified);
        sb.append(", eventContactId=");
        sb.append(eventContactId);
        sb.append(", groupId=");
        sb.append(groupId);
        sb.append(", companyId=");
        sb.append(companyId);
        sb.append(", userId=");
        sb.append(userId);
        sb.append(", userName=");
        sb.append(userName);
        sb.append(", createDate=");
        sb.append(createDate);
        sb.append(", modifiedDate=");
        sb.append(modifiedDate);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public EventContact toEntityModel() {
        EventContactImpl eventContactImpl = new EventContactImpl();

        if (givenName == null) {
            eventContactImpl.setGivenName(StringPool.BLANK);
        } else {
            eventContactImpl.setGivenName(givenName);
        }

        if (fullName == null) {
            eventContactImpl.setFullName(StringPool.BLANK);
        } else {
            eventContactImpl.setFullName(fullName);
        }

        if (emailAddress == null) {
            eventContactImpl.setEmailAddress(StringPool.BLANK);
        } else {
            eventContactImpl.setEmailAddress(emailAddress);
        }

        if (city == null) {
            eventContactImpl.setCity(StringPool.BLANK);
        } else {
            eventContactImpl.setCity(city);
        }

        if (country == null) {
            eventContactImpl.setCountry(StringPool.BLANK);
        } else {
            eventContactImpl.setCountry(country);
        }

        eventContactImpl.setLat(lat);
        eventContactImpl.setLng(lng);

        if (jobTitle == null) {
            eventContactImpl.setJobTitle(StringPool.BLANK);
        } else {
            eventContactImpl.setJobTitle(jobTitle);
        }

        if (company == null) {
            eventContactImpl.setCompany(StringPool.BLANK);
        } else {
            eventContactImpl.setCompany(company);
        }

        if (industry == null) {
            eventContactImpl.setIndustry(StringPool.BLANK);
        } else {
            eventContactImpl.setIndustry(industry);
        }

        if (interests == null) {
            eventContactImpl.setInterests(StringPool.BLANK);
        } else {
            eventContactImpl.setInterests(interests);
        }

        if (desires == null) {
            eventContactImpl.setDesires(StringPool.BLANK);
        } else {
            eventContactImpl.setDesires(desires);
        }

        if (expertise == null) {
            eventContactImpl.setExpertise(StringPool.BLANK);
        } else {
            eventContactImpl.setExpertise(expertise);
        }

        if (attendeeType == null) {
            eventContactImpl.setAttendeeType(StringPool.BLANK);
        } else {
            eventContactImpl.setAttendeeType(attendeeType);
        }

        if (interestedIds == null) {
            eventContactImpl.setInterestedIds(StringPool.BLANK);
        } else {
            eventContactImpl.setInterestedIds(interestedIds);
        }

        if (picUrl == null) {
            eventContactImpl.setPicUrl(StringPool.BLANK);
        } else {
            eventContactImpl.setPicUrl(picUrl);
        }

        if (eventId == null) {
            eventContactImpl.setEventId(StringPool.BLANK);
        } else {
            eventContactImpl.setEventId(eventId);
        }

        eventContactImpl.setVerified(verified);
        eventContactImpl.setEventContactId(eventContactId);
        eventContactImpl.setGroupId(groupId);
        eventContactImpl.setCompanyId(companyId);
        eventContactImpl.setUserId(userId);

        if (userName == null) {
            eventContactImpl.setUserName(StringPool.BLANK);
        } else {
            eventContactImpl.setUserName(userName);
        }

        if (createDate == Long.MIN_VALUE) {
            eventContactImpl.setCreateDate(null);
        } else {
            eventContactImpl.setCreateDate(new Date(createDate));
        }

        if (modifiedDate == Long.MIN_VALUE) {
            eventContactImpl.setModifiedDate(null);
        } else {
            eventContactImpl.setModifiedDate(new Date(modifiedDate));
        }

        eventContactImpl.resetOriginalValues();

        return eventContactImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        givenName = objectInput.readUTF();
        fullName = objectInput.readUTF();
        emailAddress = objectInput.readUTF();
        city = objectInput.readUTF();
        country = objectInput.readUTF();
        lat = objectInput.readDouble();
        lng = objectInput.readDouble();
        jobTitle = objectInput.readUTF();
        company = objectInput.readUTF();
        industry = objectInput.readUTF();
        interests = objectInput.readUTF();
        desires = objectInput.readUTF();
        expertise = objectInput.readUTF();
        attendeeType = objectInput.readUTF();
        interestedIds = objectInput.readUTF();
        picUrl = objectInput.readUTF();
        eventId = objectInput.readUTF();
        verified = objectInput.readBoolean();
        eventContactId = objectInput.readLong();
        groupId = objectInput.readLong();
        companyId = objectInput.readLong();
        userId = objectInput.readLong();
        userName = objectInput.readUTF();
        createDate = objectInput.readLong();
        modifiedDate = objectInput.readLong();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        if (givenName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(givenName);
        }

        if (fullName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(fullName);
        }

        if (emailAddress == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(emailAddress);
        }

        if (city == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(city);
        }

        if (country == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(country);
        }

        objectOutput.writeDouble(lat);
        objectOutput.writeDouble(lng);

        if (jobTitle == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(jobTitle);
        }

        if (company == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(company);
        }

        if (industry == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(industry);
        }

        if (interests == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(interests);
        }

        if (desires == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(desires);
        }

        if (expertise == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(expertise);
        }

        if (attendeeType == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(attendeeType);
        }

        if (interestedIds == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(interestedIds);
        }

        if (picUrl == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(picUrl);
        }

        if (eventId == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(eventId);
        }

        objectOutput.writeBoolean(verified);
        objectOutput.writeLong(eventContactId);
        objectOutput.writeLong(groupId);
        objectOutput.writeLong(companyId);
        objectOutput.writeLong(userId);

        if (userName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(userName);
        }

        objectOutput.writeLong(createDate);
        objectOutput.writeLong(modifiedDate);
    }
}
