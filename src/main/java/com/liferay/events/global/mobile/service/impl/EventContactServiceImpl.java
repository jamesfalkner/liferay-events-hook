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

import com.google.code.geocoder.Geocoder;
import com.google.code.geocoder.GeocoderRequestBuilder;
import com.google.code.geocoder.model.GeocodeResponse;
import com.google.code.geocoder.model.GeocoderRequest;
import com.google.code.geocoder.model.GeocoderStatus;
import com.liferay.events.global.mobile.InvalidSignatureException;
import com.liferay.events.global.mobile.NoSuchEventContactException;
import com.liferay.events.global.mobile.NoSuchGeoCacheException;
import com.liferay.events.global.mobile.Utils;
import com.liferay.events.global.mobile.model.EventContact;
import com.liferay.events.global.mobile.model.GeoCache;
import com.liferay.events.global.mobile.service.EventContactLocalServiceUtil;
import com.liferay.events.global.mobile.service.GeoCacheLocalServiceUtil;
import com.liferay.events.global.mobile.service.base.EventContactServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.util.*;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.GroupConstants;
import com.liferay.portal.security.ac.AccessControlled;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.model.DLFolderConstants;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;
import org.apache.commons.lang.StringUtils;

import java.io.*;
import java.util.*;

/**
 * The implementation of the contact remote service.
 * <p/>
 * <p>
 * <p/>
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author James Falkner
 */
public class EventContactServiceImpl extends EventContactServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.liferay.events.global.mobile.service.ContactServiceUtil} to access the contact remote service.
     */


	public static final int INTERESTS_MIN_WORD_LENGTH = 3;
	public static final int INTERESTS_MAX_WORD_LENGTH = 50;
	public static Set<String> stopWords = null;


	@AccessControlled(guestAccessEnabled = true)
	@Override
	public EventContact getContact(final String eventId, final String emailAddress, String signature) throws Exception {

		Map<String, String> args = new HashMap<String, String>() {{
			put("eventId", StringUtil.valueOf(eventId));
			put("emailAddress", StringUtil.valueOf(emailAddress));
		}};

		if (!Utils.isValidSignature(args, signature)) {
			throw new InvalidSignatureException("invalid signature");

		}

		return EventContactLocalServiceUtil.getVerifiedContactByEmailAddress(eventId, emailAddress, true);
	}


	@AccessControlled(guestAccessEnabled = true)
	@Override
	public EventContact validateProfile(final String eventId, final String givenName, final String fullName,
										final String emailAddress, final String city, final String countryCode, final String countryName,
										final String picUrl, final String company, final String industry,
										final String jobTitle, final String desires,
										final String expertise, final String otherInterests, final String attendeeType, String signature) throws Exception {
		try {
			Map<String, String> args = new HashMap<String, String>() {{
				put("eventId", StringUtil.valueOf(eventId));
				put("givenName", StringUtil.valueOf(givenName));
				put("fullName", StringUtil.valueOf(fullName));
				put("emailAddress", StringUtil.valueOf(emailAddress));
				put("city", StringUtil.valueOf(city));
				put("countryCode", StringUtil.valueOf(countryCode));
				put("countryName", StringUtil.valueOf(countryName));
				put("picUrl", StringUtil.valueOf(picUrl));

				put("company", StringUtil.valueOf(company));
				put("industry", StringUtil.valueOf(industry));
				put("jobTitle", StringUtil.valueOf(jobTitle));

				put("desires", StringUtil.valueOf(desires));
				put("expertise", StringUtil.valueOf(expertise));
				put("otherInterests", StringUtil.valueOf(otherInterests));
				put("attendeeType", StringUtil.valueOf(attendeeType));

			}};

			if (!Utils.isValidSignature(args, signature)) {
				throw new InvalidSignatureException("invalid signature");

			}

			EventContact contact = null;
			Map<String, String> eventConfig = Utils.getEventConfig(eventId);

			try {
				contact = EventContactLocalServiceUtil.getContactByEmailAddress(eventId, emailAddress);
				if (Validator.isNotNull(desires)) {
					contact.setDesires(Utils.mergeExpertiseJSONValues(desires, contact.getDesires()));
				}
				if (Validator.isNotNull(expertise)) {
					contact.setExpertise(Utils.mergeExpertiseJSONValues(expertise, contact.getExpertise()));
				}
				if (Validator.isNotNull(otherInterests)) {
					contact.setInterests(getJSONInterestsFromString(otherInterests, contact.getInterests(), "user", eventConfig));
				}
			} catch (NoSuchEventContactException ex) {

				GeoCache loc = getGeo(city, countryName);
				double lat = 0;
				double lng = 0;
				if (Validator.isNotNull(loc)) {
					lat = loc.getLat();
					lng = loc.getLng();
				}

				final String groupName = GroupConstants.GUEST;
				final long companyId = PortalUtil.getDefaultCompanyId();
				final long groupId = GroupLocalServiceUtil.getGroup(companyId, groupName).getGroupId();

				String interestsStr = getJSONInterestsFromString(otherInterests, null, "user", eventConfig);
				contact = EventContactLocalServiceUtil.addEventContact(getGuestOrUserId(), groupId,
						new ServiceContext(),
						eventId, Utils.removeUnicode(givenName), Utils.removeUnicode(fullName),
						attendeeType, Utils.removeUnicode(emailAddress), Utils.removeUnicode(city),
						countryCode, lat, lng, Utils.removeUnicode(company), Utils.removeUnicode(jobTitle),
						Utils.removeUnicode(industry), Utils.removeUnicode(interestsStr),
						Utils.removeUnicode(desires), Utils.removeUnicode(expertise), picUrl);
			}

			contact.setVerified(true);


			EventContactLocalServiceUtil.updateEventContact(contact);


			return contact;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}


	}

	@AccessControlled(guestAccessEnabled = true)
	@Override
	public EventContact updateProfilePic(final String eventId,
										 final long contactId,
										 final String mimeType,
										 final String extension,
										 final String bytes,
										 String signature) throws Exception {
		Map<String, String> args = new HashMap<String, String>() {{
			put("eventId", StringUtil.valueOf(eventId));
			put("extension", StringUtil.valueOf(extension));
			put("contactId", StringUtil.valueOf(contactId));
			put("mimeType", StringUtil.valueOf(mimeType));
			put("bytes", StringUtil.valueOf(bytes));
		}};

		if (!Utils.isValidSignature(args, signature)) {
			throw new InvalidSignatureException("invalid signature");

		}

		EventContact contact = EventContactLocalServiceUtil.getEventContact(contactId);

		if (Validator.isNull(contact)) {
			throw new InvalidSignatureException("No such contact");
		}


		final String groupName = GroupConstants.GUEST;
		final long companyId = PortalUtil.getDefaultCompanyId();
		final long guestGroupId = GroupLocalServiceUtil.getGroup(companyId, groupName).getGroupId();
		ServiceContext sc = new ServiceContext();
		sc.setAddGuestPermissions(true);
		sc.setAddGroupPermissions(true);
		sc.setWorkflowAction(WorkflowConstants.ACTION_PUBLISH);

		String[] permissions = {"VIEW"};

		sc.setGuestPermissions(permissions);
		sc.setGroupPermissions(permissions);

		DLFolder folder;
		try {
			folder = DLFolderLocalServiceUtil.getFolder(guestGroupId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, "profilePics");
		} catch (Exception ex) {

			folder = DLFolderLocalServiceUtil.addFolder(getUserId(), guestGroupId, guestGroupId, true,
					DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, "profilePics", "Profile Pics for Liferay Events", false, sc);
		}

		if (Validator.isNull(folder)) {
			throw new Exception("Cannot save picture to profilePics folder");
		}

		try {
			DLFileEntry existingPic = DLFileEntryLocalServiceUtil.getFileEntry(guestGroupId, folder.getFolderId(), eventId + "-" + contact.getFullName());
			DLFileEntryLocalServiceUtil.deleteDLFileEntry(existingPic);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		byte[] imgBytes = Base64.decode(bytes);

		FileEntry newEntry = DLAppLocalServiceUtil.addFileEntry(getUserId(), guestGroupId,
				folder.getFolderId(), eventId + "-" + contact.getEventContactId() + "." + extension,
				mimeType,
				eventId + "-" + contact.getFullName(),
				eventId + "-" + contact.getFullName() + " pic",
				"",
				imgBytes,
				sc);

		String newPicUrl = PortalUtil.getPathMain() + "/document_library/get_file?uuid=" + newEntry.getUuid() + "&groupId=" + guestGroupId;
		contact.setPicUrl(newPicUrl);
		EventContactLocalServiceUtil.updateEventContact(contact);
		return contact;
	}


	@AccessControlled(guestAccessEnabled = true)
	@Override
	public EventContact updateProfile(final String eventId,
									  final long contactId,
									  final String city,
									  final String country,
									  final String jobTitle,
									  final String company,
									  final String industry,
									  final String interests,
									  final String desires,
									  final String expertise,
									  final String source,
									  final String picUrl,
									  final String givenName,
									  final String fullName,
									  String signature) throws Exception {

		Map<String, String> args = new HashMap<String, String>() {{
			put("eventId", StringUtil.valueOf(eventId));
			put("contactId", StringUtil.valueOf(contactId));
			put("city", StringUtil.valueOf(city));
			put("country", StringUtil.valueOf(country));
			put("jobTitle", StringUtil.valueOf(jobTitle));
			put("company", StringUtil.valueOf(company));
			put("industry", StringUtil.valueOf(industry));
			put("interests", StringUtil.valueOf(interests));
			put("desires", StringUtil.valueOf(desires));
			put("expertise", StringUtil.valueOf(expertise));
			put("source", StringUtil.valueOf(source));
			put("picUrl", StringUtil.valueOf(picUrl));
			put("givenName", StringUtil.valueOf(givenName));
			put("fullName", StringUtil.valueOf(fullName));
		}};

		if (!Utils.isValidSignature(args, signature)) {
			throw new InvalidSignatureException("invalid signature");

		}

		EventContact contact = EventContactLocalServiceUtil.getEventContact(contactId);

		if (!contact.getVerified() || (!contact.getEventId().equals(eventId))) {
			throw new NoSuchEventContactException("User not verified for this event");
		}

		Map<String, String> eventConfig = Utils.getEventConfig(eventId);
		if (Validator.isNotNull(city)) {
			contact.setCity(Utils.removeUnicode(city));
		}
		if (Validator.isNotNull(country)) {
			contact.setCountry(Utils.removeUnicode(country));
		}
		if (Validator.isNotNull(jobTitle)) {
			contact.setJobTitle(Utils.removeUnicode(jobTitle));
		}
		if (Validator.isNotNull(company)) {
			contact.setCompany(Utils.removeUnicode(company));
		}
		if (Validator.isNotNull(industry)) {
			contact.setIndustry(Utils.removeUnicode(industry));
		}
		if (Validator.isNotNull(interests)) {
			contact.setInterests(getJSONInterestsFromString(Utils.removeUnicode(interests), contact.getInterests(), source, eventConfig));
		}
		if (Validator.isNotNull(desires)) {
			contact.setDesires(Utils.mergeExpertiseJSONValues(Utils.removeUnicode(desires), contact.getDesires()));
		}
		if (Validator.isNotNull(expertise)) {
			contact.setExpertise(Utils.mergeExpertiseJSONValues(Utils.removeUnicode(expertise), contact.getExpertise()));
		}
		if (Validator.isNotNull(picUrl)) {
			contact.setPicUrl(picUrl);
		}
		if (Validator.isNotNull(givenName)) {
			contact.setGivenName(Utils.removeUnicode(givenName));
		}
		if (Validator.isNotNull(fullName)) {
			contact.setFullName(Utils.removeUnicode(fullName));
		}

		String addr = "";

		if (Validator.isNotNull(city)) {
			addr = Utils.removeUnicode(city);
		}

		if (Validator.isNotNull(country)) {

			addr += "," + Utils.removeUnicode(country);
		}

		if (Validator.isNotNull(addr)) {

			try {
				GeoCache cache = GeoCacheLocalServiceUtil.findGeoCacheByAddress(addr);
				contact.setLat(cache.getLat());
				contact.setLng(cache.getLng());
			} catch (NoSuchGeoCacheException ex) {

				final Geocoder geocoder = new Geocoder();
				GeocoderRequest geocoderRequest = new GeocoderRequestBuilder().setAddress(addr).setLanguage("en").getGeocoderRequest();
				GeocodeResponse geocoderResponse = geocoder.geocode(geocoderRequest);
				if (geocoderResponse.getStatus() == GeocoderStatus.OK) {
					if (geocoderResponse.getResults().size() > 0) {
						double lat = geocoderResponse.getResults().get(0).getGeometry().getLocation().getLat().doubleValue();
						double lng = geocoderResponse.getResults().get(0).getGeometry().getLocation().getLng().doubleValue();
						contact.setLat(lat);
						contact.setLng(lng);
						GeoCacheLocalServiceUtil.addGeoCache(addr, lat, lng);
					}
				} else {
					System.out.println("Geocoder of " + addr + " failed");
				}
			}
		}

		eventContactLocalService.updateEventContact(contact);

		return contact;
	}


	private static String getJSONInterestsFromString(String interestStr, String existing, String source, Map<String, String> eventConfig) throws IOException, JSONException {

		String newStr = Utils.removeStopWords(interestStr);

		// remove newlines and other junk, make sure one space, lower case, etc
		newStr = newStr.replaceAll("[!\"#$%&'()*+,\\\\\\-./:;<=>?@\\[\\]^_`{|}~]", " ").
				replaceAll("\t", " ").
				replaceAll(" {2,} ", " ").
				replaceAll("\n + $ ", "").
				replaceAll(" ^\n +", "").
				replaceAll(" \n {2,}", " ").
				trim().
				toLowerCase();

		List<String> phrases = new ArrayList<String>();

		String weightStr = eventConfig.get("interest_weights");
		if (weightStr != null) {
			JSONArray weightArr = JSONFactoryUtil.createJSONArray(weightStr);
			int len = weightArr.length();
			for (int i = 0; i < len; i++) {
				String str = weightArr.getJSONObject(i).getString("word");
				phrases.add(str);
				newStr = newStr.replaceAll(str, "");
			}
		}

		List<String> words = new ArrayList<String>();

		words.addAll(Arrays.asList(newStr.split("\\s+")));
		//words.addAll(phrases);

		final Map<String, Integer> profileWordsMap = new TreeMap<String, Integer>() {
			@Override
			public Integer put(final String key, final Integer value) {
				if (containsKey(key)) {
					return super.put(key, get(key) + value);
				} else {
					return super.put(key, value);
				}
			}
		};

		for (String word : words) {
			if (word.length() < INTERESTS_MIN_WORD_LENGTH || word.length() >= INTERESTS_MAX_WORD_LENGTH) {
				continue;
			}
			profileWordsMap.put(word, 1);
		}

		// subtract one
		for (String phrase : phrases) {
			if (profileWordsMap.containsKey(phrase)) {

				int count = profileWordsMap.get(phrase);
				if (count <= 1) {
					profileWordsMap.remove(phrase);
				} else {
					profileWordsMap.put(phrase, -1);
				}
			}
		}

		JSONArray existArr = null;

		// put existing words in if any
		if (Validator.isNotNull(existing)) {
			existArr = JSONFactoryUtil.createJSONArray(existing);
		}

		JSONArray weightArr = JSONFactoryUtil.createJSONArray(eventConfig.get("interest_weights"));

		Map<String, Double> configuredWeights = new HashMap<String, Double>();
		for (int i = 0; i < weightArr.length(); i++) {
			JSONObject obj = weightArr.getJSONObject(i);
			configuredWeights.put(obj.getString("word"), obj.getDouble("weight"));
		}

		JSONArray arr = JSONFactoryUtil.createJSONArray();

		for (String s : profileWordsMap.keySet()) {
			JSONObject existingObj;
			Set<String> existingSrcs;

			if (Validator.isNotNull(existArr) && Validator.isNotNull((existingObj = getExistingWordRecord(s, existArr)))) {
				if (Validator.isNotNull(existingObj)) {
					existingSrcs = new HashSet<String>(Arrays.asList(StringUtils.split(existingObj.getString("source"), StringPool.COMMA)));
					existingSrcs.add(source);
					JSONObject obj = JSONFactoryUtil.createJSONObject();
					obj.put("word", s);
					obj.put("source", StringUtils.join(existingSrcs, StringPool.COMMA));
					obj.put("count", profileWordsMap.get(s) + existingObj.getInt(s));
					obj.put("weight", existingObj.getDouble("weight"));
					arr.put(obj);
				}
			} else {
				JSONObject obj = JSONFactoryUtil.createJSONObject();
				obj.put("word", s);
				obj.put("source", source);
				obj.put("count", profileWordsMap.get(s));
				obj.put("weight", configuredWeights.containsKey(s) ? configuredWeights.get(s) : 1.0);
				arr.put(obj);
			}
		}

		// put existing words that didn't show up in the profile
		if (Validator.isNotNull(existArr)) {
			for (int i = 0; i < existArr.length(); i++) {
				JSONObject existingObj = existArr.getJSONObject(i);
				if (!profileWordsMap.containsKey(existingObj.getString("word"))) {
					arr.put(existingObj);
				}
			}
		}
		return arr.toString();
	}

	private static JSONObject getExistingWordRecord(String s, JSONArray existArr) {
		int len = existArr.length();

		for (int i = 0; i < len; i++) {
			if (s.equals(existArr.getJSONObject(i).getString("word"))) {
				return existArr.getJSONObject(i);
			}
		}

		return null;
	}

	private static GeoCache getGeo(String city, String countryName) throws SystemException, PortalException, IOException, InterruptedException {

		String addr = (Validator.isNotNull(city) ? (city + ",") : "") + countryName;

		try {
			GeoCache cache = GeoCacheLocalServiceUtil.findGeoCacheByAddress(addr);
			return cache;

		} catch (NoSuchGeoCacheException ex) {
			final Geocoder geocoder = new Geocoder();
			GeocoderRequest geocoderRequest = new GeocoderRequestBuilder().setAddress(addr).setLanguage("en").getGeocoderRequest();
			GeocodeResponse geocoderResponse = geocoder.geocode(geocoderRequest);
			if (geocoderResponse.getStatus() == GeocoderStatus.OK) {
				if (geocoderResponse.getResults().size() > 0) {
					double glat = geocoderResponse.getResults().get(0).getGeometry().getLocation().getLat().doubleValue();
					double glng = geocoderResponse.getResults().get(0).getGeometry().getLocation().getLng().doubleValue();

					return GeoCacheLocalServiceUtil.addGeoCache(addr, glat, glng);
				}
				Thread.sleep(3000);
			}
			return null;
		}
	}
}


