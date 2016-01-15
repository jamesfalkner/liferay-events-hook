package com.liferay.events.global.mobile.model.impl;

import com.liferay.events.global.mobile.model.EventPollAnswer;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EventPollAnswer in entity cache.
 *
 * @author James Falkner
 * @see EventPollAnswer
 * @generated
 */
public class EventPollAnswerCacheModel implements CacheModel<EventPollAnswer>,
    Externalizable {
    public long questionId;
    public String clientId;
    public String payload;
    public String answer;
    public long createDate;
    public long answerId;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(13);

        sb.append("{questionId=");
        sb.append(questionId);
        sb.append(", clientId=");
        sb.append(clientId);
        sb.append(", payload=");
        sb.append(payload);
        sb.append(", answer=");
        sb.append(answer);
        sb.append(", createDate=");
        sb.append(createDate);
        sb.append(", answerId=");
        sb.append(answerId);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public EventPollAnswer toEntityModel() {
        EventPollAnswerImpl eventPollAnswerImpl = new EventPollAnswerImpl();

        eventPollAnswerImpl.setQuestionId(questionId);

        if (clientId == null) {
            eventPollAnswerImpl.setClientId(StringPool.BLANK);
        } else {
            eventPollAnswerImpl.setClientId(clientId);
        }

        if (payload == null) {
            eventPollAnswerImpl.setPayload(StringPool.BLANK);
        } else {
            eventPollAnswerImpl.setPayload(payload);
        }

        if (answer == null) {
            eventPollAnswerImpl.setAnswer(StringPool.BLANK);
        } else {
            eventPollAnswerImpl.setAnswer(answer);
        }

        if (createDate == Long.MIN_VALUE) {
            eventPollAnswerImpl.setCreateDate(null);
        } else {
            eventPollAnswerImpl.setCreateDate(new Date(createDate));
        }

        eventPollAnswerImpl.setAnswerId(answerId);

        eventPollAnswerImpl.resetOriginalValues();

        return eventPollAnswerImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        questionId = objectInput.readLong();
        clientId = objectInput.readUTF();
        payload = objectInput.readUTF();
        answer = objectInput.readUTF();
        createDate = objectInput.readLong();
        answerId = objectInput.readLong();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(questionId);

        if (clientId == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(clientId);
        }

        if (payload == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(payload);
        }

        if (answer == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(answer);
        }

        objectOutput.writeLong(createDate);
        objectOutput.writeLong(answerId);
    }
}
