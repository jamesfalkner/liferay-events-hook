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

import com.liferay.events.global.mobile.InvalidSignatureException;
import com.liferay.events.global.mobile.Utils;
import com.liferay.events.global.mobile.model.EventContact;
import com.liferay.events.global.mobile.model.Match;
import com.liferay.events.global.mobile.portlet.Candidate;
import com.liferay.events.global.mobile.service.EventContactLocalServiceUtil;
import com.liferay.events.global.mobile.service.MatchLocalServiceUtil;
import com.liferay.events.global.mobile.service.base.MatchServiceBaseImpl;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.GroupConstants;
import com.liferay.portal.security.ac.AccessControlled;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import java.util.*;

/**
 * The implementation of the match remote service.
 * <p/>
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.events.global.mobile.service.MatchService} interface.
 * <p/>
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author James Falkner
 * @see com.liferay.events.global.mobile.service.base.MatchServiceBaseImpl
 * @see com.liferay.events.global.mobile.service.MatchServiceUtil
 */
public class MatchServiceImpl extends MatchServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.liferay.events.global.mobile.service.MatchServiceUtil} to access the match remote service.
	 */
	@AccessControlled(guestAccessEnabled = true)
	@Override
	public EventContact recordInterest(final String eventId, final long contactId, final long targetContactId, String signature) throws Exception {

		Map<String, String> args = new HashMap<String, String>() {{
			put("eventId", StringUtil.valueOf(eventId));
			put("contactId", StringUtil.valueOf(contactId));
			put("targetContactId", StringUtil.valueOf(targetContactId));
		}};

		if (!Utils.isValidSignature(args, signature)) {
			throw new InvalidSignatureException("invalid signature");
		}

		final String groupName = GroupConstants.GUEST;
		final long companyId = PortalUtil.getDefaultCompanyId();
		final long guestGroupId = GroupLocalServiceUtil.getGroup(companyId, groupName).getGroupId();


		return EventContactLocalServiceUtil.recordInterest(getUserId(), guestGroupId, new ServiceContext(), eventId, contactId, targetContactId);

	}

	@AccessControlled(guestAccessEnabled = true)
	@Override
	public boolean unlink(final String eventId, final long contactId, final long targetContactId, String signature) throws Exception {
		Map<String, String> args = new HashMap<String, String>() {{
			put("eventId", StringUtil.valueOf(eventId));
			put("contactId", StringUtil.valueOf(contactId));
			put("targetContactId", StringUtil.valueOf(targetContactId));
		}};

		if (!Utils.isValidSignature(args, signature)) {
			throw new InvalidSignatureException("invalid signature");
		}


		return MatchLocalServiceUtil.unlink(eventId, contactId, targetContactId);
	}

	@AccessControlled(guestAccessEnabled = true)
	@Override
	public List<EventContact> getMatches(final String eventId, final long contactId, String signature) throws Exception {
		Map<String, String> args = new HashMap<String, String>() {{
			put("eventId", StringUtil.valueOf(eventId));
			put("contactId", StringUtil.valueOf(contactId));
		}};

		if (!Utils.isValidSignature(args, signature)) {
			throw new InvalidSignatureException("invalid signature");
		}

		List<Match> matches = MatchLocalServiceUtil.getMatches(eventId, contactId);

		List<EventContact> result = new ArrayList<EventContact>(matches.size());
		for (Match m : matches) {
			long theOtherGuy = m.getContactId1() == contactId ? m.getContactId2() : m.getContactId1();
			result.add(EventContactLocalServiceUtil.getVerifiedContact(theOtherGuy, true));
		}
		return result;

	}

	@AccessControlled(guestAccessEnabled = true)
	@Override
	public List<Candidate> getCandidates(final String eventId, final long contactId, final int max, final List<Long> uninterestedIds, String signature) throws Exception {
		Map<String, String> args = new HashMap<String, String>() {{
			put("eventId", StringUtil.valueOf(eventId));
			put("contactId", StringUtil.valueOf(contactId));
			put("max", StringUtil.valueOf(max));
			put("uninterestedIds", StringUtil.merge(uninterestedIds, StringPool.COMMA));
		}};

		if (!Utils.isValidSignature(args, signature)) {
			throw new InvalidSignatureException("invalid signature");
		}
		try {
			Set<Long> finalUninterestedIds = new HashSet<Long>();
			finalUninterestedIds.addAll(uninterestedIds);
			finalUninterestedIds.add(contactId);
			List<Match> alreadyMatched = MatchLocalServiceUtil.getMatches(eventId, contactId);
			for (Match m : alreadyMatched) {
				finalUninterestedIds.add(m.getContactId1());
				finalUninterestedIds.add(m.getContactId2());
			}

			List<EventContact> possibles = eventContactLocalService.getInterested(eventId, finalUninterestedIds);

			EventContact me = EventContactLocalServiceUtil.getVerifiedContact(contactId, true);

			final List<Long> hasInterest = new ArrayList<Long>();

			Map<String, String> eventConfig = Utils.getEventConfig(eventId);

			List<Candidate> result = new ArrayList<Candidate>();
			if (Validator.isNotNull(possibles)) {
				for (EventContact contact : possibles) {
					Candidate c = new Candidate();
					c.setPicUrl(contact.getPicUrl());
					c.setIndustry(contact.getIndustry());
					c.setJobTitle(contact.getJobTitle());
					c.setCity(contact.getCity());
					c.setCountry(contact.getCountry());
					c.setName(contact.getGivenName());
					c.setAttendeeType(contact.getAttendeeType());
					c.setEventContactId(contact.getEventContactId());
					c.setDistance(Utils.getDistanceBetween(contact.getLat(), me.getLat(), contact.getLng(), me.getLng()));
					c.setLikeness(Utils.getLikeness(me, contact, eventConfig));
					c.setLikenessDescription(Utils.getJSONLikenessDescription(me, contact));
					result.add(c);

					for (long interestedId : StringUtil.split(contact.getInterestedIds(), StringPool.COMMA, 0L)) {
						if (Validator.equals(interestedId, contactId)) {
							hasInterest.add(contact.getEventContactId());
						}
					}
				}
			}

			// favor people that have already said they like me, or those that have higher likeness to me
			Collections.sort(result, new Comparator<Candidate>() {
				@Override
				public int compare(Candidate c1, Candidate c2) {
					boolean has1 = hasInterest.contains(c1.getEventContactId());
					boolean has2 = hasInterest.contains(c2.getEventContactId());
					if (has1 && !has2) {
						return -1;
					} else if (!has1 && has2) {
						return 1;
					} else {
						if (c1.getLikeness() > c2.getLikeness()) {
							return -1;
						} else if (c1.getLikeness() < c2.getLikeness()) {
							return 1;
						} else {
							return 0;
						}
					}
				}
			});

			return (max <= result.size() ? result.subList(0, max) : result);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

}
