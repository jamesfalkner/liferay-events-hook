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
package com.liferay.events.global.mobile.portlet;

import com.google.code.geocoder.Geocoder;
import com.google.code.geocoder.GeocoderRequestBuilder;
import com.google.code.geocoder.model.GeocodeResponse;
import com.google.code.geocoder.model.GeocoderRequest;
import com.google.code.geocoder.model.GeocoderStatus;
import com.liferay.events.global.mobile.NoSuchGeoCacheException;
import com.liferay.events.global.mobile.Utils;
import com.liferay.events.global.mobile.model.EventContact;
import com.liferay.events.global.mobile.model.GeoCache;
import com.liferay.events.global.mobile.model.Match;
import com.liferay.events.global.mobile.model.Message;
import com.liferay.events.global.mobile.service.EventContactLocalServiceUtil;
import com.liferay.events.global.mobile.service.GeoCacheLocalServiceUtil;
import com.liferay.events.global.mobile.service.MatchLocalServiceUtil;
import com.liferay.events.global.mobile.service.MessageLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.GroupConstants;
import com.liferay.portal.service.CountryServiceUtil;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.ProcessAction;
import java.util.*;

public class ContactsPortlet extends MVCPortlet {

	@ProcessAction(name = "checkValidity")
	public void checkValidity(ActionRequest request, ActionResponse response)
			throws Exception {

		for (EventContact ec : EventContactLocalServiceUtil.getEventContacts(QueryUtil.ALL_POS, QueryUtil.ALL_POS)) {
			if (Validator.isNull(ec.getDesires())) {
				ec.setDesires(JSONFactoryUtil.createJSONArray().toString());
			}
			if (Validator.isNull(ec.getExpertise())) {
				ec.setExpertise(JSONFactoryUtil.createJSONArray().toString());
			}
			if (Validator.isNull(ec.getInterests())) {
				ec.setInterests(JSONFactoryUtil.createJSONArray().toString());
			}

			EventContactLocalServiceUtil.updateEventContact(ec);
		}
	}

	@ProcessAction(name = "deleteEventData")
	public void deleteEventData(ActionRequest request, ActionResponse response)
			throws Exception {

		String eventId = ParamUtil.getString(request, "eventId");
		if (Validator.isNull(eventId)) {
			throw new Exception("no event specified");
		}

		for (EventContact ec : EventContactLocalServiceUtil.getEventContacts(QueryUtil.ALL_POS, QueryUtil.ALL_POS)) {
			if (eventId.equals(ec.getEventId())) {
				EventContactLocalServiceUtil.deleteEventContact(ec.getEventContactId());
			}
		}
		for (Message m : MessageLocalServiceUtil.getMessages(QueryUtil.ALL_POS, QueryUtil.ALL_POS)) {
			if (eventId.equals(m.getEventId())) {
				MessageLocalServiceUtil.deleteMessage(m.getMessageId());
			}
		}

		for (Match m : MatchLocalServiceUtil.getMatchs(QueryUtil.ALL_POS, QueryUtil.ALL_POS)) {
			if (eventId.equals(m.getEventId())) {
				MatchLocalServiceUtil.deleteMatch(m.getMatchId());
			}
		}
	}


	@ProcessAction(name = "updateEventContact")
	public void updateEventContact(ActionRequest request, ActionResponse response) throws SystemException, PortalException {
		long id = ParamUtil.getLong(request, "eventContactId");

		try {


			EventContact ec = EventContactLocalServiceUtil.getEventContact(id);

			ec.setGivenName(ParamUtil.getString(request, "givenName"));
			ec.setFullName(ParamUtil.getString(request, "fullName"));
			ec.setEmailAddress(ParamUtil.getString(request, "emailAddress"));
			ec.setCity(ParamUtil.getString(request, "city"));
			ec.setCountry(CountryServiceUtil.getCountryByA2(ParamUtil.getString(request, "country").toUpperCase()).getA2());
			ec.setJobTitle(ParamUtil.getString(request, "jobTitle"));
			ec.setCompany(ParamUtil.getString(request, "company"));
			ec.setIndustry(ParamUtil.getString(request, "industry"));
			ec.setAttendeeType(ParamUtil.getString(request, "attendeeType"));
			ec.setPicUrl(ParamUtil.getString(request, "picUrl"));
			ec.setIndustry(ParamUtil.getString(request, "industry"));
			ec.setEventId(ParamUtil.getString(request, "eventId"));
			ec.setInterests(JSONFactoryUtil.createJSONArray(ParamUtil.getString(request, "interests")).toString());
			ec.setDesires(JSONFactoryUtil.createJSONArray(ParamUtil.getString(request, "desires")).toString());
			ec.setExpertise(JSONFactoryUtil.createJSONArray(ParamUtil.getString(request, "expertise")).toString());

			EventContactLocalServiceUtil.updateEventContact(ec);
		} catch (Exception ex) {
			SessionErrors.add(request, "Uh oh: " + ex);
		}
	}

	@ProcessAction(name = "deleteEntry")
	public void deleteEntry(ActionRequest request, ActionResponse response) throws SystemException, PortalException {

		long entryId = ParamUtil.getLong(request, "eventContactId");



		DynamicQuery q = DynamicQueryFactoryUtil.forClass(Match.class, Match.class.getClassLoader());
		q.add(RestrictionsFactoryUtil.or(RestrictionsFactoryUtil.eq("contactId1", entryId),
				RestrictionsFactoryUtil.eq("contactId2", entryId)));

		List<Match> matches = MatchLocalServiceUtil.dynamicQuery(q);

		for (Match match : matches) {
			MatchLocalServiceUtil.deleteMatch(match.getMatchId());
		}

		// delete their messages
		q = DynamicQueryFactoryUtil.forClass(Message.class, Message.class.getClassLoader());
		q.add(RestrictionsFactoryUtil.or(RestrictionsFactoryUtil.eq("toId", entryId),
				RestrictionsFactoryUtil.eq("fromId", entryId)));

		List<Message> messages = MessageLocalServiceUtil.dynamicQuery(q);


		for (Message message : messages) {
			MessageLocalServiceUtil.deleteMessage(message.getMessageId());
		}

		EventContactLocalServiceUtil.deleteEventContact(entryId);

	}


	@ProcessAction(name = "randomData")
	public void randomData(ActionRequest request, ActionResponse response)
			throws SystemException, PortalException {

		String eventId = GetterUtil.getString(request.getParameter("eventId"));
		int amt = GetterUtil.getInteger(request.getParameter("amount"));
		if (amt < 0) {
			return;
		}

		if (Validator.isNull(eventId)) {
			throw new PortalException("Invalid eventId");
		}

		String validationStyle = GetterUtil.getString(request.getParameter("validationStyle"));
		if (Validator.isNull(validationStyle)) {
			throw new PortalException("Invalid eventId");
		}


		boolean clear = GetterUtil.getBoolean(request.getParameter("clear"));

		if (clear) {
			EventContactLocalServiceUtil.deleteAll();
			MessageLocalServiceUtil.deleteAll();
			MatchLocalServiceUtil.deleteAll();
		}

		final String groupName = GroupConstants.GUEST;
		final long companyId = PortalUtil.getDefaultCompanyId();
		final long guestGroupId = GroupLocalServiceUtil.getGroup(companyId, groupName).getGroupId();

		try {

			for (int i = 0; i < amt; i++) {

				int cnt = (int) Math.floor(Math.random() * 10);

				Set<String> intNames = new HashSet<String>();
				for (int j = 0; j < cnt; j++) {
					intNames.add(Utils.INTEREST_NAMES[(int) Math.floor(Math.random() * Utils.INTEREST_NAMES.length)]);
				}

				JSONArray finalInts = JSONFactoryUtil.createJSONArray();

				for (String intName : intNames) {
					JSONObject obj = JSONFactoryUtil.createJSONObject();
					obj.put("word", intName);
					obj.put("count", (int) Math.floor(Math.random() * 15));
					obj.put("weight", 1.0);
					obj.put("source", "internal");
					finalInts.put(obj);
				}

				JSONArray desireArr = JSONFactoryUtil.createJSONArray();
				JSONObject desireObj = JSONFactoryUtil.createJSONObject();
				desireObj.put("word", Utils.EXPERTISE[(int) Math.floor(Math.random() * Utils.EXPERTISE.length)]);
				desireObj.put("weight", Math.random());
				desireArr.put(desireObj);

				JSONArray expertiseArr = JSONFactoryUtil.createJSONArray();
				desireObj = JSONFactoryUtil.createJSONObject();
				desireObj.put("word", Utils.EXPERTISE[(int) Math.floor(Math.random() * Utils.EXPERTISE.length)]);
				desireObj.put("weight", Math.random());
				expertiseArr.put(desireObj);


				ServiceContext sc = new ServiceContext();
				sc.setCreateDate(new Date((long) (new Date().getTime() - (Math.random() * 10 * 60 * 1000))));

				String secret = "" + ((int) Math.floor(Math.random() * 10)) +
						((int) Math.floor(Math.random() * 10)) +
						((int) Math.floor(Math.random() * 10)) +
						((int) Math.floor(Math.random() * 10));

				String givenName = Utils.FIRSTS[(int) Math.floor(Math.random() * Utils.FIRSTS.length)];
				String addrRaw = Utils.ADDRS[(int) Math.floor(Math.random() * Utils.ADDRS.length)];
				String city = addrRaw.split(",")[0].trim();
				String countryCode = addrRaw.split(",")[1].trim();


				String country = CountryServiceUtil.getCountryByA2(countryCode.toUpperCase()).getName(Locale.ENGLISH);

				String addr = city + "," + country;

				double lat = 111.111;
				double lng = 222.222;

				try {
					GeoCache cache = GeoCacheLocalServiceUtil.findGeoCacheByAddress(addr);
					lat = cache.getLat();
					lng = cache.getLng();
				} catch (NoSuchGeoCacheException ex) {


					final Geocoder geocoder = new Geocoder();
					GeocoderRequest geocoderRequest = new GeocoderRequestBuilder().setAddress(addr).setLanguage("en").getGeocoderRequest();
					GeocodeResponse geocoderResponse = geocoder.geocode(geocoderRequest);
					if (geocoderResponse.getStatus() == GeocoderStatus.OK) {
						if (geocoderResponse.getResults().size() > 0) {
							double glat = geocoderResponse.getResults().get(0).getGeometry().getLocation().getLat().doubleValue();
							double glng = geocoderResponse.getResults().get(0).getGeometry().getLocation().getLng().doubleValue();
							lat = glat;
							lng = glng;
							GeoCacheLocalServiceUtil.addGeoCache(addr, lat, lng);

						}
						Thread.sleep(3000);
					} else {
						throw new Exception("geocode of " + addr + " failed");
					}
				}

				String id = Utils.GRAVATAR_IDS[(int) (Math.random() * (double) Utils.GRAVATAR_IDS.length)];

				String picUrl = "http://2.gravatar.com/avatar/" + id + "?s=80&d=identicon";

				String attendeeType = Utils.ATTENDEE_TYPE[(int) Math.floor(Math.random() * Utils.ATTENDEE_TYPE.length)];

				EventContact ec = EventContactLocalServiceUtil.addEventContact(PortalUtil.getUserId(request),
						guestGroupId,
						sc,
						eventId,
						givenName,
						givenName + " " + Utils.LASTS[(int) Math.floor(Math.random() * Utils.LASTS.length)],
						attendeeType,
						givenName.toLowerCase() + i + "@nowhere.com",
						city, countryCode,
						lat, lng,
						Utils.COMPANIES[(int) Math.floor(Math.random() * Utils.COMPANIES.length)],
						Utils.JOBTITLES[(int) Math.floor(Math.random() * Utils.JOBTITLES.length)],
						Utils.INDUSTRY[(int) Math.floor(Math.random() * Utils.INDUSTRY.length)],
						finalInts.toString(),
						(attendeeType.contains("sponsor") ? "[]" : desireArr.toString()),
						expertiseArr.toString(),
						picUrl);

				if (validationStyle.equals("verified") || (validationStyle.equals("random") && (Math.random() > 0.5))) {
					ec.setVerified(true);
					EventContactLocalServiceUtil.updateEventContact(ec);
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}

