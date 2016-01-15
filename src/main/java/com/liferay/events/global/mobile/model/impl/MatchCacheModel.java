package com.liferay.events.global.mobile.model.impl;

import com.liferay.events.global.mobile.model.Match;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Match in entity cache.
 *
 * @author James Falkner
 * @see Match
 * @generated
 */
public class MatchCacheModel implements CacheModel<Match>, Externalizable {
    public long contactId1;
    public long contactId2;
    public String eventId;
    public long matchId;
    public long groupId;
    public long companyId;
    public long userId;
    public String userName;
    public long createDate;
    public long modifiedDate;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(21);

        sb.append("{contactId1=");
        sb.append(contactId1);
        sb.append(", contactId2=");
        sb.append(contactId2);
        sb.append(", eventId=");
        sb.append(eventId);
        sb.append(", matchId=");
        sb.append(matchId);
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
    public Match toEntityModel() {
        MatchImpl matchImpl = new MatchImpl();

        matchImpl.setContactId1(contactId1);
        matchImpl.setContactId2(contactId2);

        if (eventId == null) {
            matchImpl.setEventId(StringPool.BLANK);
        } else {
            matchImpl.setEventId(eventId);
        }

        matchImpl.setMatchId(matchId);
        matchImpl.setGroupId(groupId);
        matchImpl.setCompanyId(companyId);
        matchImpl.setUserId(userId);

        if (userName == null) {
            matchImpl.setUserName(StringPool.BLANK);
        } else {
            matchImpl.setUserName(userName);
        }

        if (createDate == Long.MIN_VALUE) {
            matchImpl.setCreateDate(null);
        } else {
            matchImpl.setCreateDate(new Date(createDate));
        }

        if (modifiedDate == Long.MIN_VALUE) {
            matchImpl.setModifiedDate(null);
        } else {
            matchImpl.setModifiedDate(new Date(modifiedDate));
        }

        matchImpl.resetOriginalValues();

        return matchImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        contactId1 = objectInput.readLong();
        contactId2 = objectInput.readLong();
        eventId = objectInput.readUTF();
        matchId = objectInput.readLong();
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
        objectOutput.writeLong(contactId1);
        objectOutput.writeLong(contactId2);

        if (eventId == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(eventId);
        }

        objectOutput.writeLong(matchId);
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
