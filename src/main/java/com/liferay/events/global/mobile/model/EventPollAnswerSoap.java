package com.liferay.events.global.mobile.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.events.global.mobile.service.http.EventPollAnswerServiceSoap}.
 *
 * @author James Falkner
 * @see com.liferay.events.global.mobile.service.http.EventPollAnswerServiceSoap
 * @generated
 */
public class EventPollAnswerSoap implements Serializable {
    private long _questionId;
    private String _clientId;
    private String _payload;
    private String _answer;
    private Date _createDate;
    private long _answerId;

    public EventPollAnswerSoap() {
    }

    public static EventPollAnswerSoap toSoapModel(EventPollAnswer model) {
        EventPollAnswerSoap soapModel = new EventPollAnswerSoap();

        soapModel.setQuestionId(model.getQuestionId());
        soapModel.setClientId(model.getClientId());
        soapModel.setPayload(model.getPayload());
        soapModel.setAnswer(model.getAnswer());
        soapModel.setCreateDate(model.getCreateDate());
        soapModel.setAnswerId(model.getAnswerId());

        return soapModel;
    }

    public static EventPollAnswerSoap[] toSoapModels(EventPollAnswer[] models) {
        EventPollAnswerSoap[] soapModels = new EventPollAnswerSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static EventPollAnswerSoap[][] toSoapModels(
        EventPollAnswer[][] models) {
        EventPollAnswerSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new EventPollAnswerSoap[models.length][models[0].length];
        } else {
            soapModels = new EventPollAnswerSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static EventPollAnswerSoap[] toSoapModels(
        List<EventPollAnswer> models) {
        List<EventPollAnswerSoap> soapModels = new ArrayList<EventPollAnswerSoap>(models.size());

        for (EventPollAnswer model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new EventPollAnswerSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _answerId;
    }

    public void setPrimaryKey(long pk) {
        setAnswerId(pk);
    }

    public long getQuestionId() {
        return _questionId;
    }

    public void setQuestionId(long questionId) {
        _questionId = questionId;
    }

    public String getClientId() {
        return _clientId;
    }

    public void setClientId(String clientId) {
        _clientId = clientId;
    }

    public String getPayload() {
        return _payload;
    }

    public void setPayload(String payload) {
        _payload = payload;
    }

    public String getAnswer() {
        return _answer;
    }

    public void setAnswer(String answer) {
        _answer = answer;
    }

    public Date getCreateDate() {
        return _createDate;
    }

    public void setCreateDate(Date createDate) {
        _createDate = createDate;
    }

    public long getAnswerId() {
        return _answerId;
    }

    public void setAnswerId(long answerId) {
        _answerId = answerId;
    }
}
