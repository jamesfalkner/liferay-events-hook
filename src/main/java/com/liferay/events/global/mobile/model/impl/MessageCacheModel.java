package com.liferay.events.global.mobile.model.impl;

import com.liferay.events.global.mobile.model.Message;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Message in entity cache.
 *
 * @author James Falkner
 * @see Message
 * @generated
 */
public class MessageCacheModel implements CacheModel<Message>, Externalizable {
    public long fromId;
    public long toId;
    public String content;
    public boolean read;
    public String eventId;
    public long messageId;
    public long groupId;
    public long companyId;
    public long userId;
    public String userName;
    public long createDate;
    public long modifiedDate;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(25);

        sb.append("{fromId=");
        sb.append(fromId);
        sb.append(", toId=");
        sb.append(toId);
        sb.append(", content=");
        sb.append(content);
        sb.append(", read=");
        sb.append(read);
        sb.append(", eventId=");
        sb.append(eventId);
        sb.append(", messageId=");
        sb.append(messageId);
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
    public Message toEntityModel() {
        MessageImpl messageImpl = new MessageImpl();

        messageImpl.setFromId(fromId);
        messageImpl.setToId(toId);

        if (content == null) {
            messageImpl.setContent(StringPool.BLANK);
        } else {
            messageImpl.setContent(content);
        }

        messageImpl.setRead(read);

        if (eventId == null) {
            messageImpl.setEventId(StringPool.BLANK);
        } else {
            messageImpl.setEventId(eventId);
        }

        messageImpl.setMessageId(messageId);
        messageImpl.setGroupId(groupId);
        messageImpl.setCompanyId(companyId);
        messageImpl.setUserId(userId);

        if (userName == null) {
            messageImpl.setUserName(StringPool.BLANK);
        } else {
            messageImpl.setUserName(userName);
        }

        if (createDate == Long.MIN_VALUE) {
            messageImpl.setCreateDate(null);
        } else {
            messageImpl.setCreateDate(new Date(createDate));
        }

        if (modifiedDate == Long.MIN_VALUE) {
            messageImpl.setModifiedDate(null);
        } else {
            messageImpl.setModifiedDate(new Date(modifiedDate));
        }

        messageImpl.resetOriginalValues();

        return messageImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        fromId = objectInput.readLong();
        toId = objectInput.readLong();
        content = objectInput.readUTF();
        read = objectInput.readBoolean();
        eventId = objectInput.readUTF();
        messageId = objectInput.readLong();
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
        objectOutput.writeLong(fromId);
        objectOutput.writeLong(toId);

        if (content == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(content);
        }

        objectOutput.writeBoolean(read);

        if (eventId == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(eventId);
        }

        objectOutput.writeLong(messageId);
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
