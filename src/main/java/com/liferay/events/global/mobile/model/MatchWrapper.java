package com.liferay.events.global.mobile.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Match}.
 * </p>
 *
 * @author James Falkner
 * @see Match
 * @generated
 */
public class MatchWrapper implements Match, ModelWrapper<Match> {
    private Match _match;

    public MatchWrapper(Match match) {
        _match = match;
    }

    @Override
    public Class<?> getModelClass() {
        return Match.class;
    }

    @Override
    public String getModelClassName() {
        return Match.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("contactId1", getContactId1());
        attributes.put("contactId2", getContactId2());
        attributes.put("eventId", getEventId());
        attributes.put("matchId", getMatchId());
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
        Long contactId1 = (Long) attributes.get("contactId1");

        if (contactId1 != null) {
            setContactId1(contactId1);
        }

        Long contactId2 = (Long) attributes.get("contactId2");

        if (contactId2 != null) {
            setContactId2(contactId2);
        }

        String eventId = (String) attributes.get("eventId");

        if (eventId != null) {
            setEventId(eventId);
        }

        Long matchId = (Long) attributes.get("matchId");

        if (matchId != null) {
            setMatchId(matchId);
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
    * Returns the primary key of this match.
    *
    * @return the primary key of this match
    */
    @Override
    public long getPrimaryKey() {
        return _match.getPrimaryKey();
    }

    /**
    * Sets the primary key of this match.
    *
    * @param primaryKey the primary key of this match
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _match.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the contact id1 of this match.
    *
    * @return the contact id1 of this match
    */
    @Override
    public long getContactId1() {
        return _match.getContactId1();
    }

    /**
    * Sets the contact id1 of this match.
    *
    * @param contactId1 the contact id1 of this match
    */
    @Override
    public void setContactId1(long contactId1) {
        _match.setContactId1(contactId1);
    }

    /**
    * Returns the contact id2 of this match.
    *
    * @return the contact id2 of this match
    */
    @Override
    public long getContactId2() {
        return _match.getContactId2();
    }

    /**
    * Sets the contact id2 of this match.
    *
    * @param contactId2 the contact id2 of this match
    */
    @Override
    public void setContactId2(long contactId2) {
        _match.setContactId2(contactId2);
    }

    /**
    * Returns the event ID of this match.
    *
    * @return the event ID of this match
    */
    @Override
    public java.lang.String getEventId() {
        return _match.getEventId();
    }

    /**
    * Sets the event ID of this match.
    *
    * @param eventId the event ID of this match
    */
    @Override
    public void setEventId(java.lang.String eventId) {
        _match.setEventId(eventId);
    }

    /**
    * Returns the match ID of this match.
    *
    * @return the match ID of this match
    */
    @Override
    public long getMatchId() {
        return _match.getMatchId();
    }

    /**
    * Sets the match ID of this match.
    *
    * @param matchId the match ID of this match
    */
    @Override
    public void setMatchId(long matchId) {
        _match.setMatchId(matchId);
    }

    /**
    * Returns the group ID of this match.
    *
    * @return the group ID of this match
    */
    @Override
    public long getGroupId() {
        return _match.getGroupId();
    }

    /**
    * Sets the group ID of this match.
    *
    * @param groupId the group ID of this match
    */
    @Override
    public void setGroupId(long groupId) {
        _match.setGroupId(groupId);
    }

    /**
    * Returns the company ID of this match.
    *
    * @return the company ID of this match
    */
    @Override
    public long getCompanyId() {
        return _match.getCompanyId();
    }

    /**
    * Sets the company ID of this match.
    *
    * @param companyId the company ID of this match
    */
    @Override
    public void setCompanyId(long companyId) {
        _match.setCompanyId(companyId);
    }

    /**
    * Returns the user ID of this match.
    *
    * @return the user ID of this match
    */
    @Override
    public long getUserId() {
        return _match.getUserId();
    }

    /**
    * Sets the user ID of this match.
    *
    * @param userId the user ID of this match
    */
    @Override
    public void setUserId(long userId) {
        _match.setUserId(userId);
    }

    /**
    * Returns the user uuid of this match.
    *
    * @return the user uuid of this match
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _match.getUserUuid();
    }

    /**
    * Sets the user uuid of this match.
    *
    * @param userUuid the user uuid of this match
    */
    @Override
    public void setUserUuid(java.lang.String userUuid) {
        _match.setUserUuid(userUuid);
    }

    /**
    * Returns the user name of this match.
    *
    * @return the user name of this match
    */
    @Override
    public java.lang.String getUserName() {
        return _match.getUserName();
    }

    /**
    * Sets the user name of this match.
    *
    * @param userName the user name of this match
    */
    @Override
    public void setUserName(java.lang.String userName) {
        _match.setUserName(userName);
    }

    /**
    * Returns the create date of this match.
    *
    * @return the create date of this match
    */
    @Override
    public java.util.Date getCreateDate() {
        return _match.getCreateDate();
    }

    /**
    * Sets the create date of this match.
    *
    * @param createDate the create date of this match
    */
    @Override
    public void setCreateDate(java.util.Date createDate) {
        _match.setCreateDate(createDate);
    }

    /**
    * Returns the modified date of this match.
    *
    * @return the modified date of this match
    */
    @Override
    public java.util.Date getModifiedDate() {
        return _match.getModifiedDate();
    }

    /**
    * Sets the modified date of this match.
    *
    * @param modifiedDate the modified date of this match
    */
    @Override
    public void setModifiedDate(java.util.Date modifiedDate) {
        _match.setModifiedDate(modifiedDate);
    }

    @Override
    public boolean isNew() {
        return _match.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _match.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _match.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _match.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _match.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _match.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _match.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _match.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _match.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _match.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _match.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new MatchWrapper((Match) _match.clone());
    }

    @Override
    public int compareTo(com.liferay.events.global.mobile.model.Match match) {
        return _match.compareTo(match);
    }

    @Override
    public int hashCode() {
        return _match.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.liferay.events.global.mobile.model.Match> toCacheModel() {
        return _match.toCacheModel();
    }

    @Override
    public com.liferay.events.global.mobile.model.Match toEscapedModel() {
        return new MatchWrapper(_match.toEscapedModel());
    }

    @Override
    public com.liferay.events.global.mobile.model.Match toUnescapedModel() {
        return new MatchWrapper(_match.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _match.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _match.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _match.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof MatchWrapper)) {
            return false;
        }

        MatchWrapper matchWrapper = (MatchWrapper) obj;

        if (Validator.equals(_match, matchWrapper._match)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Match getWrappedMatch() {
        return _match;
    }

    @Override
    public Match getWrappedModel() {
        return _match;
    }

    @Override
    public void resetOriginalValues() {
        _match.resetOriginalValues();
    }
}
