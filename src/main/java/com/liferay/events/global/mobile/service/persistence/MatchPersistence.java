package com.liferay.events.global.mobile.service.persistence;

import com.liferay.events.global.mobile.model.Match;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the match service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author James Falkner
 * @see MatchPersistenceImpl
 * @see MatchUtil
 * @generated
 */
public interface MatchPersistence extends BasePersistence<Match> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link MatchUtil} to access the match persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the matchs where eventId = &#63; and contactId1 = &#63;.
    *
    * @param eventId the event ID
    * @param contactId1 the contact id1
    * @return the matching matchs
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.liferay.events.global.mobile.model.Match> findByID1_E(
        java.lang.String eventId, long contactId1)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the matchs where eventId = &#63; and contactId1 = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.events.global.mobile.model.impl.MatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param eventId the event ID
    * @param contactId1 the contact id1
    * @param start the lower bound of the range of matchs
    * @param end the upper bound of the range of matchs (not inclusive)
    * @return the range of matching matchs
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.liferay.events.global.mobile.model.Match> findByID1_E(
        java.lang.String eventId, long contactId1, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the matchs where eventId = &#63; and contactId1 = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.events.global.mobile.model.impl.MatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param eventId the event ID
    * @param contactId1 the contact id1
    * @param start the lower bound of the range of matchs
    * @param end the upper bound of the range of matchs (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching matchs
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.liferay.events.global.mobile.model.Match> findByID1_E(
        java.lang.String eventId, long contactId1, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first match in the ordered set where eventId = &#63; and contactId1 = &#63;.
    *
    * @param eventId the event ID
    * @param contactId1 the contact id1
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching match
    * @throws com.liferay.events.global.mobile.NoSuchMatchException if a matching match could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.events.global.mobile.model.Match findByID1_E_First(
        java.lang.String eventId, long contactId1,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.events.global.mobile.NoSuchMatchException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first match in the ordered set where eventId = &#63; and contactId1 = &#63;.
    *
    * @param eventId the event ID
    * @param contactId1 the contact id1
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching match, or <code>null</code> if a matching match could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.events.global.mobile.model.Match fetchByID1_E_First(
        java.lang.String eventId, long contactId1,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last match in the ordered set where eventId = &#63; and contactId1 = &#63;.
    *
    * @param eventId the event ID
    * @param contactId1 the contact id1
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching match
    * @throws com.liferay.events.global.mobile.NoSuchMatchException if a matching match could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.events.global.mobile.model.Match findByID1_E_Last(
        java.lang.String eventId, long contactId1,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.events.global.mobile.NoSuchMatchException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last match in the ordered set where eventId = &#63; and contactId1 = &#63;.
    *
    * @param eventId the event ID
    * @param contactId1 the contact id1
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching match, or <code>null</code> if a matching match could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.events.global.mobile.model.Match fetchByID1_E_Last(
        java.lang.String eventId, long contactId1,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the matchs before and after the current match in the ordered set where eventId = &#63; and contactId1 = &#63;.
    *
    * @param matchId the primary key of the current match
    * @param eventId the event ID
    * @param contactId1 the contact id1
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next match
    * @throws com.liferay.events.global.mobile.NoSuchMatchException if a match with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.events.global.mobile.model.Match[] findByID1_E_PrevAndNext(
        long matchId, java.lang.String eventId, long contactId1,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.events.global.mobile.NoSuchMatchException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the matchs where eventId = &#63; and contactId1 = &#63; from the database.
    *
    * @param eventId the event ID
    * @param contactId1 the contact id1
    * @throws SystemException if a system exception occurred
    */
    public void removeByID1_E(java.lang.String eventId, long contactId1)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of matchs where eventId = &#63; and contactId1 = &#63;.
    *
    * @param eventId the event ID
    * @param contactId1 the contact id1
    * @return the number of matching matchs
    * @throws SystemException if a system exception occurred
    */
    public int countByID1_E(java.lang.String eventId, long contactId1)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the matchs where eventId = &#63; and contactId2 = &#63;.
    *
    * @param eventId the event ID
    * @param contactId2 the contact id2
    * @return the matching matchs
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.liferay.events.global.mobile.model.Match> findByID2_E(
        java.lang.String eventId, long contactId2)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the matchs where eventId = &#63; and contactId2 = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.events.global.mobile.model.impl.MatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param eventId the event ID
    * @param contactId2 the contact id2
    * @param start the lower bound of the range of matchs
    * @param end the upper bound of the range of matchs (not inclusive)
    * @return the range of matching matchs
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.liferay.events.global.mobile.model.Match> findByID2_E(
        java.lang.String eventId, long contactId2, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the matchs where eventId = &#63; and contactId2 = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.events.global.mobile.model.impl.MatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param eventId the event ID
    * @param contactId2 the contact id2
    * @param start the lower bound of the range of matchs
    * @param end the upper bound of the range of matchs (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching matchs
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.liferay.events.global.mobile.model.Match> findByID2_E(
        java.lang.String eventId, long contactId2, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first match in the ordered set where eventId = &#63; and contactId2 = &#63;.
    *
    * @param eventId the event ID
    * @param contactId2 the contact id2
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching match
    * @throws com.liferay.events.global.mobile.NoSuchMatchException if a matching match could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.events.global.mobile.model.Match findByID2_E_First(
        java.lang.String eventId, long contactId2,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.events.global.mobile.NoSuchMatchException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first match in the ordered set where eventId = &#63; and contactId2 = &#63;.
    *
    * @param eventId the event ID
    * @param contactId2 the contact id2
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching match, or <code>null</code> if a matching match could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.events.global.mobile.model.Match fetchByID2_E_First(
        java.lang.String eventId, long contactId2,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last match in the ordered set where eventId = &#63; and contactId2 = &#63;.
    *
    * @param eventId the event ID
    * @param contactId2 the contact id2
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching match
    * @throws com.liferay.events.global.mobile.NoSuchMatchException if a matching match could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.events.global.mobile.model.Match findByID2_E_Last(
        java.lang.String eventId, long contactId2,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.events.global.mobile.NoSuchMatchException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last match in the ordered set where eventId = &#63; and contactId2 = &#63;.
    *
    * @param eventId the event ID
    * @param contactId2 the contact id2
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching match, or <code>null</code> if a matching match could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.events.global.mobile.model.Match fetchByID2_E_Last(
        java.lang.String eventId, long contactId2,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the matchs before and after the current match in the ordered set where eventId = &#63; and contactId2 = &#63;.
    *
    * @param matchId the primary key of the current match
    * @param eventId the event ID
    * @param contactId2 the contact id2
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next match
    * @throws com.liferay.events.global.mobile.NoSuchMatchException if a match with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.events.global.mobile.model.Match[] findByID2_E_PrevAndNext(
        long matchId, java.lang.String eventId, long contactId2,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.events.global.mobile.NoSuchMatchException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the matchs where eventId = &#63; and contactId2 = &#63; from the database.
    *
    * @param eventId the event ID
    * @param contactId2 the contact id2
    * @throws SystemException if a system exception occurred
    */
    public void removeByID2_E(java.lang.String eventId, long contactId2)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of matchs where eventId = &#63; and contactId2 = &#63;.
    *
    * @param eventId the event ID
    * @param contactId2 the contact id2
    * @return the number of matching matchs
    * @throws SystemException if a system exception occurred
    */
    public int countByID2_E(java.lang.String eventId, long contactId2)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the match in the entity cache if it is enabled.
    *
    * @param match the match
    */
    public void cacheResult(com.liferay.events.global.mobile.model.Match match);

    /**
    * Caches the matchs in the entity cache if it is enabled.
    *
    * @param matchs the matchs
    */
    public void cacheResult(
        java.util.List<com.liferay.events.global.mobile.model.Match> matchs);

    /**
    * Creates a new match with the primary key. Does not add the match to the database.
    *
    * @param matchId the primary key for the new match
    * @return the new match
    */
    public com.liferay.events.global.mobile.model.Match create(long matchId);

    /**
    * Removes the match with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param matchId the primary key of the match
    * @return the match that was removed
    * @throws com.liferay.events.global.mobile.NoSuchMatchException if a match with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.events.global.mobile.model.Match remove(long matchId)
        throws com.liferay.events.global.mobile.NoSuchMatchException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.liferay.events.global.mobile.model.Match updateImpl(
        com.liferay.events.global.mobile.model.Match match)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the match with the primary key or throws a {@link com.liferay.events.global.mobile.NoSuchMatchException} if it could not be found.
    *
    * @param matchId the primary key of the match
    * @return the match
    * @throws com.liferay.events.global.mobile.NoSuchMatchException if a match with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.events.global.mobile.model.Match findByPrimaryKey(
        long matchId)
        throws com.liferay.events.global.mobile.NoSuchMatchException,
            com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the match with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param matchId the primary key of the match
    * @return the match, or <code>null</code> if a match with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.liferay.events.global.mobile.model.Match fetchByPrimaryKey(
        long matchId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the matchs.
    *
    * @return the matchs
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.liferay.events.global.mobile.model.Match> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the matchs.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.events.global.mobile.model.impl.MatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of matchs
    * @param end the upper bound of the range of matchs (not inclusive)
    * @return the range of matchs
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.liferay.events.global.mobile.model.Match> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the matchs.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.events.global.mobile.model.impl.MatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of matchs
    * @param end the upper bound of the range of matchs (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matchs
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.liferay.events.global.mobile.model.Match> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the matchs from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of matchs.
    *
    * @return the number of matchs
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
