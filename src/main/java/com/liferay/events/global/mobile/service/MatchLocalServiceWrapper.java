package com.liferay.events.global.mobile.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link MatchLocalService}.
 *
 * @author James Falkner
 * @see MatchLocalService
 * @generated
 */
public class MatchLocalServiceWrapper implements MatchLocalService,
    ServiceWrapper<MatchLocalService> {
    private MatchLocalService _matchLocalService;

    public MatchLocalServiceWrapper(MatchLocalService matchLocalService) {
        _matchLocalService = matchLocalService;
    }

    /**
    * Adds the match to the database. Also notifies the appropriate model listeners.
    *
    * @param match the match
    * @return the match that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.liferay.events.global.mobile.model.Match addMatch(
        com.liferay.events.global.mobile.model.Match match)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _matchLocalService.addMatch(match);
    }

    /**
    * Creates a new match with the primary key. Does not add the match to the database.
    *
    * @param matchId the primary key for the new match
    * @return the new match
    */
    @Override
    public com.liferay.events.global.mobile.model.Match createMatch(
        long matchId) {
        return _matchLocalService.createMatch(matchId);
    }

    /**
    * Deletes the match with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param matchId the primary key of the match
    * @return the match that was removed
    * @throws PortalException if a match with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.liferay.events.global.mobile.model.Match deleteMatch(
        long matchId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _matchLocalService.deleteMatch(matchId);
    }

    /**
    * Deletes the match from the database. Also notifies the appropriate model listeners.
    *
    * @param match the match
    * @return the match that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.liferay.events.global.mobile.model.Match deleteMatch(
        com.liferay.events.global.mobile.model.Match match)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _matchLocalService.deleteMatch(match);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _matchLocalService.dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _matchLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.events.global.mobile.model.impl.MatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _matchLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.events.global.mobile.model.impl.MatchModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _matchLocalService.dynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _matchLocalService.dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _matchLocalService.dynamicQueryCount(dynamicQuery, projection);
    }

    @Override
    public com.liferay.events.global.mobile.model.Match fetchMatch(long matchId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _matchLocalService.fetchMatch(matchId);
    }

    /**
    * Returns the match with the primary key.
    *
    * @param matchId the primary key of the match
    * @return the match
    * @throws PortalException if a match with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.liferay.events.global.mobile.model.Match getMatch(long matchId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _matchLocalService.getMatch(matchId);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _matchLocalService.getPersistedModel(primaryKeyObj);
    }

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
    @Override
    public java.util.List<com.liferay.events.global.mobile.model.Match> getMatchs(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _matchLocalService.getMatchs(start, end);
    }

    /**
    * Returns the number of matchs.
    *
    * @return the number of matchs
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getMatchsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _matchLocalService.getMatchsCount();
    }

    /**
    * Updates the match in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param match the match
    * @return the match that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.liferay.events.global.mobile.model.Match updateMatch(
        com.liferay.events.global.mobile.model.Match match)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _matchLocalService.updateMatch(match);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _matchLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _matchLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _matchLocalService.invokeMethod(name, parameterTypes, arguments);
    }

    @Override
    public void deleteAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        _matchLocalService.deleteAll();
    }

    @Override
    public com.liferay.events.global.mobile.model.Match addMatch(long groupId,
        long userId, com.liferay.portal.service.ServiceContext serviceContext,
        java.lang.String eventId, long contactId, long targetContactId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _matchLocalService.addMatch(groupId, userId, serviceContext,
            eventId, contactId, targetContactId);
    }

    @Override
    public boolean matches(java.lang.String eventId, long contactId,
        long targetContactId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _matchLocalService.matches(eventId, contactId, targetContactId);
    }

    @Override
    public java.util.List<com.liferay.events.global.mobile.model.Match> getMatches(
        java.lang.String eventId, long contactId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _matchLocalService.getMatches(eventId, contactId);
    }

    @Override
    public boolean unlink(java.lang.String eventId, long contactId,
        long targetContactId) throws java.lang.Exception {
        return _matchLocalService.unlink(eventId, contactId, targetContactId);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public MatchLocalService getWrappedMatchLocalService() {
        return _matchLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedMatchLocalService(MatchLocalService matchLocalService) {
        _matchLocalService = matchLocalService;
    }

    @Override
    public MatchLocalService getWrappedService() {
        return _matchLocalService;
    }

    @Override
    public void setWrappedService(MatchLocalService matchLocalService) {
        _matchLocalService = matchLocalService;
    }
}
