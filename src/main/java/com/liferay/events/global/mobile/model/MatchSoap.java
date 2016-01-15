package com.liferay.events.global.mobile.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.events.global.mobile.service.http.MatchServiceSoap}.
 *
 * @author James Falkner
 * @see com.liferay.events.global.mobile.service.http.MatchServiceSoap
 * @generated
 */
public class MatchSoap implements Serializable {
    private long _contactId1;
    private long _contactId2;
    private String _eventId;
    private long _matchId;
    private long _groupId;
    private long _companyId;
    private long _userId;
    private String _userName;
    private Date _createDate;
    private Date _modifiedDate;

    public MatchSoap() {
    }

    public static MatchSoap toSoapModel(Match model) {
        MatchSoap soapModel = new MatchSoap();

        soapModel.setContactId1(model.getContactId1());
        soapModel.setContactId2(model.getContactId2());
        soapModel.setEventId(model.getEventId());
        soapModel.setMatchId(model.getMatchId());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setUserId(model.getUserId());
        soapModel.setUserName(model.getUserName());
        soapModel.setCreateDate(model.getCreateDate());
        soapModel.setModifiedDate(model.getModifiedDate());

        return soapModel;
    }

    public static MatchSoap[] toSoapModels(Match[] models) {
        MatchSoap[] soapModels = new MatchSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static MatchSoap[][] toSoapModels(Match[][] models) {
        MatchSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new MatchSoap[models.length][models[0].length];
        } else {
            soapModels = new MatchSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static MatchSoap[] toSoapModels(List<Match> models) {
        List<MatchSoap> soapModels = new ArrayList<MatchSoap>(models.size());

        for (Match model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new MatchSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _matchId;
    }

    public void setPrimaryKey(long pk) {
        setMatchId(pk);
    }

    public long getContactId1() {
        return _contactId1;
    }

    public void setContactId1(long contactId1) {
        _contactId1 = contactId1;
    }

    public long getContactId2() {
        return _contactId2;
    }

    public void setContactId2(long contactId2) {
        _contactId2 = contactId2;
    }

    public String getEventId() {
        return _eventId;
    }

    public void setEventId(String eventId) {
        _eventId = eventId;
    }

    public long getMatchId() {
        return _matchId;
    }

    public void setMatchId(long matchId) {
        _matchId = matchId;
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
