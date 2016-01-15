package com.liferay.events.global.mobile.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link MatchService}.
 *
 * @author James Falkner
 * @see MatchService
 * @generated
 */
public class MatchServiceWrapper implements MatchService,
    ServiceWrapper<MatchService> {
    private MatchService _matchService;

    public MatchServiceWrapper(MatchService matchService) {
        _matchService = matchService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _matchService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _matchService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _matchService.invokeMethod(name, parameterTypes, arguments);
    }

    @Override
    public com.liferay.events.global.mobile.model.EventContact recordInterest(
        java.lang.String eventId, long contactId, long targetContactId,
        java.lang.String signature) throws java.lang.Exception {
        return _matchService.recordInterest(eventId, contactId,
            targetContactId, signature);
    }

    @Override
    public boolean unlink(java.lang.String eventId, long contactId,
        long targetContactId, java.lang.String signature)
        throws java.lang.Exception {
        return _matchService.unlink(eventId, contactId, targetContactId,
            signature);
    }

    @Override
    public java.util.List<com.liferay.events.global.mobile.model.EventContact> getMatches(
        java.lang.String eventId, long contactId, java.lang.String signature)
        throws java.lang.Exception {
        return _matchService.getMatches(eventId, contactId, signature);
    }

    @Override
    public java.util.List<com.liferay.events.global.mobile.portlet.Candidate> getCandidates(
        java.lang.String eventId, long contactId, int max,
        java.util.List<java.lang.Long> uninterestedIds,
        java.lang.String signature) throws java.lang.Exception {
        return _matchService.getCandidates(eventId, contactId, max,
            uninterestedIds, signature);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public MatchService getWrappedMatchService() {
        return _matchService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedMatchService(MatchService matchService) {
        _matchService = matchService;
    }

    @Override
    public MatchService getWrappedService() {
        return _matchService;
    }

    @Override
    public void setWrappedService(MatchService matchService) {
        _matchService = matchService;
    }
}
