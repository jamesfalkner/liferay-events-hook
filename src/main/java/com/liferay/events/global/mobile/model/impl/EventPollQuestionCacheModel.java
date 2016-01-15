package com.liferay.events.global.mobile.model.impl;

import com.liferay.events.global.mobile.model.EventPollQuestion;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EventPollQuestion in entity cache.
 *
 * @author James Falkner
 * @see EventPollQuestion
 * @generated
 */
public class EventPollQuestionCacheModel implements CacheModel<EventPollQuestion>,
    Externalizable {
    public String eventId;
    public String sponsorName;
    public String shortTitle;
    public String question;
    public String questionType;
    public String choices;
    public boolean anonymousResults;
    public boolean showResponseCount;
    public String chartType;
    public boolean askForId;
    public String idIntro;
    public long createDate;
    public boolean enabled;
    public boolean autoEnable;
    public long enableTriggerDate;
    public String enableTriggerTimezone;
    public String picUrl;
    public long questionId;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(37);

        sb.append("{eventId=");
        sb.append(eventId);
        sb.append(", sponsorName=");
        sb.append(sponsorName);
        sb.append(", shortTitle=");
        sb.append(shortTitle);
        sb.append(", question=");
        sb.append(question);
        sb.append(", questionType=");
        sb.append(questionType);
        sb.append(", choices=");
        sb.append(choices);
        sb.append(", anonymousResults=");
        sb.append(anonymousResults);
        sb.append(", showResponseCount=");
        sb.append(showResponseCount);
        sb.append(", chartType=");
        sb.append(chartType);
        sb.append(", askForId=");
        sb.append(askForId);
        sb.append(", idIntro=");
        sb.append(idIntro);
        sb.append(", createDate=");
        sb.append(createDate);
        sb.append(", enabled=");
        sb.append(enabled);
        sb.append(", autoEnable=");
        sb.append(autoEnable);
        sb.append(", enableTriggerDate=");
        sb.append(enableTriggerDate);
        sb.append(", enableTriggerTimezone=");
        sb.append(enableTriggerTimezone);
        sb.append(", picUrl=");
        sb.append(picUrl);
        sb.append(", questionId=");
        sb.append(questionId);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public EventPollQuestion toEntityModel() {
        EventPollQuestionImpl eventPollQuestionImpl = new EventPollQuestionImpl();

        if (eventId == null) {
            eventPollQuestionImpl.setEventId(StringPool.BLANK);
        } else {
            eventPollQuestionImpl.setEventId(eventId);
        }

        if (sponsorName == null) {
            eventPollQuestionImpl.setSponsorName(StringPool.BLANK);
        } else {
            eventPollQuestionImpl.setSponsorName(sponsorName);
        }

        if (shortTitle == null) {
            eventPollQuestionImpl.setShortTitle(StringPool.BLANK);
        } else {
            eventPollQuestionImpl.setShortTitle(shortTitle);
        }

        if (question == null) {
            eventPollQuestionImpl.setQuestion(StringPool.BLANK);
        } else {
            eventPollQuestionImpl.setQuestion(question);
        }

        if (questionType == null) {
            eventPollQuestionImpl.setQuestionType(StringPool.BLANK);
        } else {
            eventPollQuestionImpl.setQuestionType(questionType);
        }

        if (choices == null) {
            eventPollQuestionImpl.setChoices(StringPool.BLANK);
        } else {
            eventPollQuestionImpl.setChoices(choices);
        }

        eventPollQuestionImpl.setAnonymousResults(anonymousResults);
        eventPollQuestionImpl.setShowResponseCount(showResponseCount);

        if (chartType == null) {
            eventPollQuestionImpl.setChartType(StringPool.BLANK);
        } else {
            eventPollQuestionImpl.setChartType(chartType);
        }

        eventPollQuestionImpl.setAskForId(askForId);

        if (idIntro == null) {
            eventPollQuestionImpl.setIdIntro(StringPool.BLANK);
        } else {
            eventPollQuestionImpl.setIdIntro(idIntro);
        }

        if (createDate == Long.MIN_VALUE) {
            eventPollQuestionImpl.setCreateDate(null);
        } else {
            eventPollQuestionImpl.setCreateDate(new Date(createDate));
        }

        eventPollQuestionImpl.setEnabled(enabled);
        eventPollQuestionImpl.setAutoEnable(autoEnable);

        if (enableTriggerDate == Long.MIN_VALUE) {
            eventPollQuestionImpl.setEnableTriggerDate(null);
        } else {
            eventPollQuestionImpl.setEnableTriggerDate(new Date(
                    enableTriggerDate));
        }

        if (enableTriggerTimezone == null) {
            eventPollQuestionImpl.setEnableTriggerTimezone(StringPool.BLANK);
        } else {
            eventPollQuestionImpl.setEnableTriggerTimezone(enableTriggerTimezone);
        }

        if (picUrl == null) {
            eventPollQuestionImpl.setPicUrl(StringPool.BLANK);
        } else {
            eventPollQuestionImpl.setPicUrl(picUrl);
        }

        eventPollQuestionImpl.setQuestionId(questionId);

        eventPollQuestionImpl.resetOriginalValues();

        return eventPollQuestionImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        eventId = objectInput.readUTF();
        sponsorName = objectInput.readUTF();
        shortTitle = objectInput.readUTF();
        question = objectInput.readUTF();
        questionType = objectInput.readUTF();
        choices = objectInput.readUTF();
        anonymousResults = objectInput.readBoolean();
        showResponseCount = objectInput.readBoolean();
        chartType = objectInput.readUTF();
        askForId = objectInput.readBoolean();
        idIntro = objectInput.readUTF();
        createDate = objectInput.readLong();
        enabled = objectInput.readBoolean();
        autoEnable = objectInput.readBoolean();
        enableTriggerDate = objectInput.readLong();
        enableTriggerTimezone = objectInput.readUTF();
        picUrl = objectInput.readUTF();
        questionId = objectInput.readLong();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        if (eventId == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(eventId);
        }

        if (sponsorName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(sponsorName);
        }

        if (shortTitle == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(shortTitle);
        }

        if (question == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(question);
        }

        if (questionType == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(questionType);
        }

        if (choices == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(choices);
        }

        objectOutput.writeBoolean(anonymousResults);
        objectOutput.writeBoolean(showResponseCount);

        if (chartType == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(chartType);
        }

        objectOutput.writeBoolean(askForId);

        if (idIntro == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(idIntro);
        }

        objectOutput.writeLong(createDate);
        objectOutput.writeBoolean(enabled);
        objectOutput.writeBoolean(autoEnable);
        objectOutput.writeLong(enableTriggerDate);

        if (enableTriggerTimezone == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(enableTriggerTimezone);
        }

        if (picUrl == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(picUrl);
        }

        objectOutput.writeLong(questionId);
    }
}
