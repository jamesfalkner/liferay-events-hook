/**
 * Copyright 2016 Liferay, Inc. All rights reserved.
 * http://www.liferay.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * @author James Falkner
 */
package com.liferay.events.global.mobile.service.impl;

import com.liferay.events.global.mobile.model.EventContact;
import com.liferay.events.global.mobile.model.Match;
import com.liferay.events.global.mobile.service.MatchLocalServiceUtil;
import com.liferay.events.global.mobile.service.base.MatchLocalServiceBaseImpl;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The implementation of the match local service.
 * <p/>
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.events.global.mobile.service.MatchLocalService} interface.
 * <p/>
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author James Falkner
 * @see com.liferay.events.global.mobile.service.base.MatchLocalServiceBaseImpl
 * @see com.liferay.events.global.mobile.service.MatchLocalServiceUtil
 */
public class MatchLocalServiceImpl extends MatchLocalServiceBaseImpl {
	/*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.liferay.events.global.mobile.service.MatchLocalServiceUtil} to access the match local service.
     */

	public void deleteAll() throws SystemException {
		matchPersistence.removeAll();
	}

	public Match addMatch(long groupId, long userId, ServiceContext serviceContext, String eventId, long contactId, long targetContactId) throws PortalException, SystemException {

		User user = userPersistence.findByPrimaryKey(userId);

		Date now = new Date();

		long matchId = counterLocalService.increment(Match.class.getName());

		Match match = matchPersistence.create(matchId);

		match.setEventId(eventId);
		match.setContactId1(contactId);
		match.setContactId2(targetContactId);
		match.setGroupId(groupId);
		match.setCompanyId(user.getCompanyId());
		match.setUserId(user.getUserId());
		match.setCreateDate(serviceContext.getCreateDate(now));
		match.setModifiedDate(serviceContext.getModifiedDate(now));

		super.addMatch(match);

		return match;
	}

	public boolean matches(String eventId, long contactId, long targetContactId) throws SystemException {

		return (getMatch(eventId, contactId, targetContactId).size() > 0);
	}

	public List<Match> getMatches(String eventId, long contactId) throws SystemException {

		DynamicQuery q = DynamicQueryFactoryUtil.forClass(Match.class, Match.class.getClassLoader());
		q.add(RestrictionsFactoryUtil.eq("eventId", eventId));
		q.add(RestrictionsFactoryUtil.or(RestrictionsFactoryUtil.eq("contactId1", contactId),
				RestrictionsFactoryUtil.eq("contactId2", contactId)));

		return MatchLocalServiceUtil.dynamicQuery(q);

	}

	private List<Match> getMatch(String eventId, long contact1, long contact2) throws SystemException {
		DynamicQuery q = DynamicQueryFactoryUtil.forClass(Match.class, Match.class.getClassLoader());
		q.add(RestrictionsFactoryUtil.eq("eventId", eventId));
		q.add(RestrictionsFactoryUtil.or(
				RestrictionsFactoryUtil.and(
						RestrictionsFactoryUtil.eq("contactId1", contact1),
						RestrictionsFactoryUtil.eq("contactId2", contact2)),

				RestrictionsFactoryUtil.and(
						RestrictionsFactoryUtil.eq("contactId2", contact1),
						RestrictionsFactoryUtil.eq("contactId1", contact2))));
		return matchLocalService.dynamicQuery(q);
	}

	public boolean unlink(final String eventId, final long contactId, final long targetContactId) throws Exception {
		List<Match> matches = getMatch(eventId, contactId, targetContactId);
		if ((matches == null) || matches.size() < 1) {
			return true;
		}

		EventContact contact = eventContactLocalService.getEventContact(contactId);

		String[] ids = StringUtil.split(contact.getInterestedIds(), StringPool.COMMA);

		List<String> idList = new ArrayList<String>(ids.length);

		for (Match match : matches) {
			matchLocalService.deleteMatch(match.getMatchId());
			idList.remove(String.valueOf(targetContactId));
		}

		contact.setInterestedIds(StringUtil.merge(idList, StringPool.COMMA));
		eventContactLocalService.updateEventContact(contact);

		return true;
	}

}
