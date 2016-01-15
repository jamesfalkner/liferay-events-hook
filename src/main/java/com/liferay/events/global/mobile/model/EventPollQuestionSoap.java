package com.liferay.events.global.mobile.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.events.global.mobile.service.http.EventPollQuestionServiceSoap}.
 *
 * @author James Falkner
 * @see com.liferay.events.global.mobile.service.http.EventPollQuestionServiceSoap
 * @generated
 */
public class EventPollQuestionSoap implements Serializable {
    private String _eventId;
    private String _sponsorName;
    private String _shortTitle;
    private String _question;
    private String _questionType;
    private String _choices;
    private boolean _anonymousResults;
    private boolean _showResponseCount;
    private String _chartType;
    private boolean _askForId;
    private String _idIntro;
    private Date _createDate;
    private boolean _enabled;
    private boolean _autoEnable;
    private Date _enableTriggerDate;
    private String _enableTriggerTimezone;
    private String _picUrl;
    private long _questionId;

    public EventPollQuestionSoap() {
    }

    public static EventPollQuestionSoap toSoapModel(EventPollQuestion model) {
        EventPollQuestionSoap soapModel = new EventPollQuestionSoap();

        soapModel.setEventId(model.getEventId());
        soapModel.setSponsorName(model.getSponsorName());
        soapModel.setShortTitle(model.getShortTitle());
        soapModel.setQuestion(model.getQuestion());
        soapModel.setQuestionType(model.getQuestionType());
        soapModel.setChoices(model.getChoices());
        soapModel.setAnonymousResults(model.getAnonymousResults());
        soapModel.setShowResponseCount(model.getShowResponseCount());
        soapModel.setChartType(model.getChartType());
        soapModel.setAskForId(model.getAskForId());
        soapModel.setIdIntro(model.getIdIntro());
        soapModel.setCreateDate(model.getCreateDate());
        soapModel.setEnabled(model.getEnabled());
        soapModel.setAutoEnable(model.getAutoEnable());
        soapModel.setEnableTriggerDate(model.getEnableTriggerDate());
        soapModel.setEnableTriggerTimezone(model.getEnableTriggerTimezone());
        soapModel.setPicUrl(model.getPicUrl());
        soapModel.setQuestionId(model.getQuestionId());

        return soapModel;
    }

    public static EventPollQuestionSoap[] toSoapModels(
        EventPollQuestion[] models) {
        EventPollQuestionSoap[] soapModels = new EventPollQuestionSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static EventPollQuestionSoap[][] toSoapModels(
        EventPollQuestion[][] models) {
        EventPollQuestionSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new EventPollQuestionSoap[models.length][models[0].length];
        } else {
            soapModels = new EventPollQuestionSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static EventPollQuestionSoap[] toSoapModels(
        List<EventPollQuestion> models) {
        List<EventPollQuestionSoap> soapModels = new ArrayList<EventPollQuestionSoap>(models.size());

        for (EventPollQuestion model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new EventPollQuestionSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _questionId;
    }

    public void setPrimaryKey(long pk) {
        setQuestionId(pk);
    }

    public String getEventId() {
        return _eventId;
    }

    public void setEventId(String eventId) {
        _eventId = eventId;
    }

    public String getSponsorName() {
        return _sponsorName;
    }

    public void setSponsorName(String sponsorName) {
        _sponsorName = sponsorName;
    }

    public String getShortTitle() {
        return _shortTitle;
    }

    public void setShortTitle(String shortTitle) {
        _shortTitle = shortTitle;
    }

    public String getQuestion() {
        return _question;
    }

    public void setQuestion(String question) {
        _question = question;
    }

    public String getQuestionType() {
        return _questionType;
    }

    public void setQuestionType(String questionType) {
        _questionType = questionType;
    }

    public String getChoices() {
        return _choices;
    }

    public void setChoices(String choices) {
        _choices = choices;
    }

    public boolean getAnonymousResults() {
        return _anonymousResults;
    }

    public boolean isAnonymousResults() {
        return _anonymousResults;
    }

    public void setAnonymousResults(boolean anonymousResults) {
        _anonymousResults = anonymousResults;
    }

    public boolean getShowResponseCount() {
        return _showResponseCount;
    }

    public boolean isShowResponseCount() {
        return _showResponseCount;
    }

    public void setShowResponseCount(boolean showResponseCount) {
        _showResponseCount = showResponseCount;
    }

    public String getChartType() {
        return _chartType;
    }

    public void setChartType(String chartType) {
        _chartType = chartType;
    }

    public boolean getAskForId() {
        return _askForId;
    }

    public boolean isAskForId() {
        return _askForId;
    }

    public void setAskForId(boolean askForId) {
        _askForId = askForId;
    }

    public String getIdIntro() {
        return _idIntro;
    }

    public void setIdIntro(String idIntro) {
        _idIntro = idIntro;
    }

    public Date getCreateDate() {
        return _createDate;
    }

    public void setCreateDate(Date createDate) {
        _createDate = createDate;
    }

    public boolean getEnabled() {
        return _enabled;
    }

    public boolean isEnabled() {
        return _enabled;
    }

    public void setEnabled(boolean enabled) {
        _enabled = enabled;
    }

    public boolean getAutoEnable() {
        return _autoEnable;
    }

    public boolean isAutoEnable() {
        return _autoEnable;
    }

    public void setAutoEnable(boolean autoEnable) {
        _autoEnable = autoEnable;
    }

    public Date getEnableTriggerDate() {
        return _enableTriggerDate;
    }

    public void setEnableTriggerDate(Date enableTriggerDate) {
        _enableTriggerDate = enableTriggerDate;
    }

    public String getEnableTriggerTimezone() {
        return _enableTriggerTimezone;
    }

    public void setEnableTriggerTimezone(String enableTriggerTimezone) {
        _enableTriggerTimezone = enableTriggerTimezone;
    }

    public String getPicUrl() {
        return _picUrl;
    }

    public void setPicUrl(String picUrl) {
        _picUrl = picUrl;
    }

    public long getQuestionId() {
        return _questionId;
    }

    public void setQuestionId(long questionId) {
        _questionId = questionId;
    }
}
