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

/**
 * Portions of this file derived from Apache Commons Lang
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.liferay.events.global.mobile;

import com.liferay.events.global.mobile.model.EventContact;
import com.liferay.events.global.mobile.service.EventContactService;
import com.liferay.events.global.mobile.service.impl.EventContactServiceImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.*;
import com.liferay.portal.model.GroupConstants;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.dynamicdatalists.model.DDLRecord;
import com.liferay.portlet.dynamicdatalists.model.DDLRecordSet;
import com.liferay.portlet.dynamicdatalists.service.DDLRecordSetLocalServiceUtil;
import com.liferay.portlet.dynamicdatamapping.storage.Field;
import com.liferay.util.portlet.PortletProps;
import org.apache.commons.lang.StringUtils;
import org.apache.lucene.analysis.CharArraySet;
import org.apache.lucene.analysis.StopFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.standard.StandardTokenizer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.util.Version;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

public class Utils {

	public static boolean flag = true;
	public static final String[] FIRSTS = new String[]{"Gabriel", "Adam", "Raphaël", "Victor", "Maxime", "Louise", "Chloé", "Rachel", "Eddy"};
	public static final String[] LASTS = new String[]{"André", "Martin", "Laurent", "Roux", "Petit", "Durand", "Fournier", "François"};
	public static final String[] ATTENDEE_TYPE = new String[]{"attendee", "gold sponsor", "silver sponsor", "platinum sponsor", "exhibitor"};
	public static final String[] ADDRS = new String[]{"London, gb", "New York, us", "Delhi, in", "Tokyo, jp", "Paris, fr", "Frankfurt, de", "Atlanta, us"};
	public static final String[] COMPANIES = new String[]{"Liferay", "IBM", "Software AG", "SAP", "Apple"};
	public static final String[] JOBTITLES = new String[]{"CEO", "CTO", "Software Architect", "Developer", "VP Engineering", "Community Manager"};
	public static final String[] INDUSTRY = new String[]{"Automotive", "Financial", "Education", "Government", "Computer Software", "Consulting"};
	public static final String[] INTEREST_NAMES = new String[]{"liferay", "portal", "enterprise", "open source", "community manager", "cms", "content management", "workflow",
			"digital business", "enterprise social network", "digital marketing"};
	public static final String[] EXPERTISE = new String[]{"Content Management", "Audience Engagement", "Digital Marketing", "Digital Business"};

	public static final String[] GRAVATAR_IDS = new String[]{
			"205e460b479e2e5b48aec07710c08d50", "6ea52ba884713c11a9f814dde6867c97", "84987b436214f52ec0b04cd1f8a73c3c",
			"c63392ca320086522cf4d55cbf1d3808", "8f0c9789bd69a98b3103bcefa878f1bb", "86debe7ed7ece0f968097a768dcbd5cb",
			"4d346581a3340e32cf93703c9ce46bd4", "75fb365927cb3f5f7b677682d6249406", "3cb9afe63d364690c0e188fb16473277",
			"5b3b5ce04dd402124aba53142b3e47f6", "6cf147a5459184fdd93a2328d03ebcb4", "aac7e0386facd070f6d4b817c257a958",
			"1a33e7a69df4f675fcd799edca088ac2", "4f293e41d789d759831dc43550b7a9ff", "aa19dcc345fb0f1a6ddaf9b9863a678f",
			"f45143c409f3deed51a65a238654f7f4", "24038397a5d55c66d086e0a1721a5ade", "3751204a1a48ba86eb6bb83a96640318",
			"16aeda409d2a00b51ac4c5058a3a8435", "777ec1b95dbc49dd05d724da9bef1edd"
	};
	private static String sigSharedSecret = null;

	public static String generateSig(Map<String, String> args) {
		if (Validator.isNull(sigSharedSecret)) {
			sigSharedSecret = PortletProps.get("liferay.events.shared.secret");
			if (sigSharedSecret == null) {
				sigSharedSecret = "some-hard-to-guess-string";
			}
		}

		List<String> sortedArgs = new SortedArrayList<String>();
		sortedArgs.addAll(args.keySet());

		String preSig = sigSharedSecret;
		for (String paramName : sortedArgs) {
			preSig += (paramName + "=" + args.get(paramName));
		}

		return DigesterUtil.digestHex(Digester.SHA_256, preSig);

	}
	public static boolean isValidSignature(Map<String, String> args, String sig) throws SystemException {

		if (!Utils.flag) return false;

		if (Validator.isNull(sigSharedSecret)) {
			//sigSharedSecret = PrefsPropsUtil.getString("liferay.events.shared.secret", "some hard-to-guess string");
			sigSharedSecret = PortletProps.get("liferay.events.shared.secret");
			if (sigSharedSecret == null) {
				sigSharedSecret = "some-hard-to-guess-string";
			}
		}

		List<String> sortedArgs = new SortedArrayList<String>();
		sortedArgs.addAll(args.keySet());

		String preSig = sigSharedSecret;
		for (String paramName : sortedArgs) {
			preSig += (paramName + "=" + args.get(paramName));
		}

		String shaSig = DigesterUtil.digestHex(Digester.SHA_256, preSig);

		return shaSig.equals(sig);

	}

	public static String getJSONLikenessDescription(EventContact me, EventContact targetContact) throws JSONException {


		JSONArray result = JSONFactoryUtil.createJSONArray();

		Map<String, Double> desires1 = getJSONWordWeightsFromString(me.getDesires());
		Map<String, Double> desires2 = getJSONWordWeightsFromString(targetContact.getDesires());
		Map<String, Double> expertise1 = getJSONWordWeightsFromString(me.getExpertise());
		Map<String, Double> expertise2 = getJSONWordWeightsFromString(targetContact.getExpertise());


		// how many of my desires do they have expertise in?
		Set<String> common1 = new HashSet<String>(desires1.keySet());
		common1.retainAll(expertise2.keySet());

		// how many of my expertises do they desire?
		Set<String> common2 = new HashSet<String>(desires2.keySet());
		common2.retainAll(expertise1.keySet());

		if (common1.size() > 0) {
			JSONObject bit = JSONFactoryUtil.createJSONObject();

			List<String> myNeeds = new ArrayList<String>(common1);
			JSONArray args = JSONFactoryUtil.createJSONArray();
			args.put(targetContact.getGivenName());
			args.put(StringUtils.join(myNeeds.size() > 5 ? myNeeds.subList(0, 5) : myNeeds, " " + StringPool.SLASH + " "));

			bit.put("key", "HAS_EXPERTISE_IN_MY_AREAS");
			bit.put("args", args);
			result.put(bit);
		}

		if (common2.size() > 0) {
			JSONObject bit = JSONFactoryUtil.createJSONObject();
			JSONArray args =  JSONFactoryUtil.createJSONArray();

			List<String> myExpertise = new ArrayList<String>(common2);
			args.put(targetContact.getGivenName());
			args.put(StringUtils.join(myExpertise.size() > 5 ? myExpertise.subList(0, 5) : myExpertise, " " + StringPool.SLASH + " "));

			bit.put("key", "HAS_NEEDS_IN_MY_AREAS");
			bit.put("args", args);
			result.put(bit);

		}

		double industrySimilarity = getJaroWinklerDistance(me.getIndustry(), targetContact.getIndustry());
		double jobTitleSimilarity = getJaroWinklerDistance(me.getJobTitle(), targetContact.getJobTitle());
		double locationDistance;

		if (me.getLat() == 0 || me.getLng() == 0 || targetContact.getLat() == 0 || targetContact.getLng() == 0) {
			locationDistance = 100000;
		} else {
			locationDistance = getDistanceBetween(me.getLat(), me.getLng(), targetContact.getLat(), targetContact.getLng());
		}

		double locationSimilarity = 1.0 - (locationDistance / 1000.0);
		if (locationSimilarity < 0) locationSimilarity = 0;

		if (locationSimilarity > .5 && me.getCountry().equals(targetContact.getCountry())) {

			JSONObject bit = JSONFactoryUtil.createJSONObject();
			JSONArray args =  JSONFactoryUtil.createJSONArray();
			args.put(targetContact.getGivenName());
			args.put(targetContact.getCity());
			bit.put("key", "IS_NEARBY");
			bit.put("args", args);
			result.put(bit);

		} else if (me.getCountry().equals(targetContact.getCountry())) {
			JSONObject bit = JSONFactoryUtil.createJSONObject();
			JSONArray args =  JSONFactoryUtil.createJSONArray();
			args.put(targetContact.getGivenName());
			bit.put("key", "LIVES_WORKS_IN_COUNTRY");
			bit.put("args", args);
			result.put(bit);

		}

		if (industrySimilarity > .7) {
			JSONObject bit = JSONFactoryUtil.createJSONObject();
			JSONArray args =  JSONFactoryUtil.createJSONArray();
			args.put(targetContact.getGivenName());
			args.put(targetContact.getIndustry());
			bit.put("key", "SIMILAR_INDUSTRY");
			bit.put("args", args);
			result.put(bit);

		}
		if (jobTitleSimilarity > .7) {
			JSONObject bit = JSONFactoryUtil.createJSONObject();
			JSONArray args =  JSONFactoryUtil.createJSONArray();
			args.put(targetContact.getGivenName());
			args.put(targetContact.getJobTitle());
			bit.put("key", "SIMILAR_JOB");
			bit.put("args", args);
			result.put(bit);

		}

		JSONArray words1o = JSONFactoryUtil.createJSONArray(me.getInterests());
		JSONArray words2o = JSONFactoryUtil.createJSONArray(targetContact.getInterests());

		List<String> words1 = new ArrayList<String>();
		List<String> words2 = new ArrayList<String>();
		final Map<String, Integer> count1 = new HashMap<String, Integer>();
		final Map<String, Integer> count2 = new HashMap<String, Integer>();
		final Map<String, Double> weight1 = new HashMap<String, Double>();
		final Map<String, Double> weight2 = new HashMap<String, Double>();

		for (int i = 0; i < words1o.length(); i++) {
			JSONObject o = words1o.getJSONObject(i);

			String word = o.getString("word");
			int count = o.getInt("count");
			double weight = o.getDouble("weight");

			words1.add(word);
			count1.put(word, count);
			weight1.put(word, weight);
		}

		for (int i = 0; i < words2o.length(); i++) {
			JSONObject o = words2o.getJSONObject(i);

			String word = o.getString("word");
			int count = o.getInt("count");
			double weight = o.getDouble("weight");

			words2.add(word);
			count2.put(word, count);
			weight2.put(word, weight);
		}


		Set<String> commonWords = new HashSet<String>(words1);
		commonWords.retainAll(words2);

		List<String> sortedCommon = new SortedArrayList<String>(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return (int) Math.floor(((((double) count1.get(o2) * weight1.get(o2)) + ((double) count2.get(o2) * weight2.get(o2))) -
						(((double) count1.get(o1) * weight1.get(o1)) + ((double) count2.get(o1) * weight2.get(o1)))));

			}
		});

		sortedCommon.addAll(commonWords);

		if (!sortedCommon.isEmpty()) {
			JSONObject bit = JSONFactoryUtil.createJSONObject();
			JSONArray args =  JSONFactoryUtil.createJSONArray();
			args.put(StringUtils.join(sortedCommon.size() > 5 ? sortedCommon.subList(0, 5) : sortedCommon, " / "));
			bit.put("key", "SIMILAR_SKILLS_INTERESTS");
			bit.put("args", args);
			result.put(bit);

		}

		if (result.length() <= 0) {
			List<String> sortedTargetWords = new SortedArrayList<String>(new Comparator<String>() {
				@Override
				public int compare(String a, String b) {
					return (int) Math.floor(((weight2.get(b) * (double) count2.get(b)) - (weight2.get(a) * (double) count2.get(a))));
				}
			});
			sortedTargetWords.addAll(words2);

			if (!sortedTargetWords.isEmpty()) {
				JSONObject bit = JSONFactoryUtil.createJSONObject();
				JSONArray args =  JSONFactoryUtil.createJSONArray();
				args.put(StringUtils.join(sortedTargetWords.size() > 3 ? sortedTargetWords.subList(0, 3) : sortedTargetWords, " / "));
				bit.put("key", "MIGHT_BE_INTERESTED");
				bit.put("args", args);
				result.put(bit);

			}
		}
		return result.toString();
	}

	public static double getLikeness(EventContact me, EventContact targetContact, Map<String, String> eventConfig) throws JSONException {


		double percentInterestMatch = getInterestLikeness(me, targetContact);
		double percentExpertiseMatch = getExpertiseMatch(me, targetContact);
		double industrySimilarity = getJaroWinklerDistance(me.getIndustry(), targetContact.getIndustry());
		double jobTitleSimilarity = getJaroWinklerDistance(me.getJobTitle(), targetContact.getJobTitle());

		double locationDistance;

		if (me.getLat() == 0 || me.getLng() == 0 || targetContact.getLat() == 0 || targetContact.getLng() == 0) {
			locationDistance = 100000;
		} else {
			locationDistance = getDistanceBetween(me.getLat(), me.getLng(), targetContact.getLat(), targetContact.getLng());
		}

		double locationSimilarity = 1 - (locationDistance / 500);
		if (locationSimilarity < 0) locationSimilarity = 0;

		double finalMatch =
				GetterUtil.getDouble(eventConfig.get("expertise_match_weight"), 0.50) * percentExpertiseMatch +
						GetterUtil.getDouble(eventConfig.get("interest_match_weight"), 0.30) * percentInterestMatch +
						GetterUtil.getDouble(eventConfig.get("location_match_weight"), 0.05) * locationSimilarity +
						GetterUtil.getDouble(eventConfig.get("job_title_match_weight"), 0.05) * jobTitleSimilarity +
						GetterUtil.getDouble(eventConfig.get("industry_match_weight"), 0.10) * industrySimilarity;

		String bonusStr = eventConfig.get("bonus_match_map");
		String attendeeType = targetContact.getAttendeeType();

		if (Validator.isNotNull(bonusStr) && Validator.isNotNull(attendeeType)) {
			JSONArray arr = JSONFactoryUtil.createJSONArray(bonusStr);
			for (int i = 0; i < arr.length(); i++) {
				String bonusType = arr.getJSONObject(i).getString("type");
				Double bonus =  arr.getJSONObject(i).getDouble("bonus");
				if (attendeeType.contains(bonusType)) {
					finalMatch += bonus;
				}
			}
		}

		if (finalMatch > 1.0) {
			finalMatch = 1.0;
		}

		return finalMatch;
	}

	private static double getExpertiseMatch(EventContact me, EventContact targetContact) throws JSONException {

		Map<String, Double> desires1 = getJSONWordWeightsFromString(me.getDesires());
		Map<String, Double> desires2 = getJSONWordWeightsFromString(targetContact.getDesires());
		Map<String, Double> expertise1 = getJSONWordWeightsFromString(me.getExpertise());
		Map<String, Double> expertise2 = getJSONWordWeightsFromString(targetContact.getExpertise());


		// how many of my desires do they have expertise in?
		Set<String> common1 = new HashSet<String>(desires1.keySet());
		common1.retainAll(expertise2.keySet());

		// how matchy is it?
		double common1Val = 0.0;
		double uncommon1Val = 0.0;

		for (String desire1 : desires1.keySet()) {
			if (expertise2.containsKey(desire1)) {
				common1Val += (desires1.get(desire1) + expertise2.get(desire1));
			} else {
				uncommon1Val += desires1.get(desire1);
			}
		}

		// now look the other way
		for (String desire2 : desires2.keySet()) {
			if (expertise1.containsKey(desire2)) {
				common1Val += (desires2.get(desire2) + expertise1.get(desire2));
			} else {
				uncommon1Val += desires2.get(desire2);
			}
		}

		if ((common1Val + uncommon1Val) <= 0.0) {
			return 0.0;
		} else {
			return common1Val / (common1Val + uncommon1Val);
		}
	}

	public static double getInterestLikeness(EventContact me, EventContact targetContact) throws JSONException {


		JSONArray words1o = JSONFactoryUtil.createJSONArray(me.getInterests());
		JSONArray words2o = JSONFactoryUtil.createJSONArray(targetContact.getInterests());

		List<String> words1 = new ArrayList<String>();
		List<String> words2 = new ArrayList<String>();
		Map<String, Integer> count1 = new HashMap<String, Integer>();
		Map<String, Integer> count2 = new HashMap<String, Integer>();
		Map<String, Double> weight1 = new HashMap<String, Double>();
		Map<String, Double> weight2 = new HashMap<String, Double>();

		for (int i = 0; i < words1o.length(); i++) {
			JSONObject o = words1o.getJSONObject(i);

			String word = o.getString("word");
			int count = o.getInt("count");
			double weight = o.getDouble("weight");

			words1.add(word);
			count1.put(word, count);
			weight1.put(word, weight);
		}

		for (int i = 0; i < words2o.length(); i++) {
			JSONObject o = words2o.getJSONObject(i);

			String word = o.getString("word");
			int count = o.getInt("count");
			double weight = o.getDouble("weight");

			words2.add(word);
			count2.put(word, count);
			weight2.put(word, weight);
		}


		Set<String> commonWords = new HashSet<String>(words1);
		commonWords.retainAll(words2);


		Set<String> uncommonWords = new HashSet<String>(words1);
		uncommonWords.addAll(words2);
		uncommonWords.removeAll(commonWords);

		double matchedScore = 0.0;
		double unmatchedScore = 0.0;

		for (String commonWord : commonWords) {
			matchedScore += (((double) count1.get(commonWord) * weight1.get(commonWord)) + (((double) count2.get(commonWord) * weight2.get(commonWord))));
		}

		for (String uncommonWord : uncommonWords) {
			if (words1.contains(uncommonWord)) {
				unmatchedScore += ((double) count1.get(uncommonWord) * weight1.get(uncommonWord));
			} else {
				unmatchedScore += ((double) count2.get(uncommonWord) * weight2.get(uncommonWord));
			}
		}

		return unmatchedScore > 0 ? ((matchedScore * 2.0) / (unmatchedScore + (matchedScore * 2.0))) : 1.0;
	}
	// http://stackoverflow.com/questions/3694380/calculating-distance-between-two-points-using-latitude-longitude-what-am-i-doi

	// distance in km
	public static double getDistanceBetween(double lat1, double lon1, double lat2, double lon2) {
		if (lat1 == lat2 && lon1 == lon2) {
			return 0;
		}
		double theta = lon1 - lon2;
		double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
		if (dist == 0) {
			return 0;
		}
		dist = Math.acos(dist);
		dist = rad2deg(dist);
		return (dist * 60 * 1.1515 * 1.609344);
	}

	public static Map<String, String> getEventConfig(String eventId) throws SystemException, PortalException {
		final String groupName = GroupConstants.GUEST;
		final long companyId = PortalUtil.getDefaultCompanyId();
		final long guestGroupId = GroupLocalServiceUtil.getGroup(companyId, groupName).getGroupId();

		Map<String, String> eventConfig = new HashMap<String, String>();

		for (DDLRecordSet set : DDLRecordSetLocalServiceUtil.getRecordSets(guestGroupId)) {
			if (set.getName().toLowerCase().contains("event config") &&
					set.getDDMStructure().hasField("event_id")) {
				for (DDLRecord record : set.getRecords()) {
					if (GetterUtil.getString(record.getFieldValue("event_id")).equals(eventId)) {
						for (Field field : record.getFields()) {
							String fieldName = field.getName();
							String fieldValue = GetterUtil.getString(record.getFieldValue(fieldName));
							eventConfig.put(fieldName, fieldValue);
						}
						break;
					}
				}
				break;
			}
		}

		return eventConfig;
	}

	/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
	/*::  This function converts decimal degrees to radians             :*/
	/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
	private static double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}

	/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
	/*::  This function converts radians to decimal degrees             :*/
	/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
	private static double rad2deg(double rad) {
		return (rad * 180.0 / Math.PI);
	}

	public static double getJaroWinklerDistance(final CharSequence first, final CharSequence second) {
		final double DEFAULT_SCALING_FACTOR = 0.1;

		if (first == null || second == null) {
			throw new IllegalArgumentException("Strings must not be null");
		}

		final double jaro = score(first, second);
		final int cl = commonPrefixLength(first, second);

		return Math.round((jaro + (DEFAULT_SCALING_FACTOR * cl * (1.0 - jaro))) * 100.0) / 100.0;
	}

	/**
	 * Calculates the number of characters from the beginning of the strings that match exactly one-to-one,
	 * up to a maximum of four (4) characters.
	 *
	 * @param first  The first string.
	 * @param second The second string.
	 * @return A number between 0 and 4.
	 */
	private static int commonPrefixLength(final CharSequence first, final CharSequence second) {
		final int result = StringUtils.getCommonPrefix(new String[]{first.toString(), second.toString()}).length();

		// Limit the result to 4.
		return result > 4 ? 4 : result;
	}

	/**
	 * This method returns the Jaro-Winkler score for string matching.
	 *
	 * @param first  the first string to be matched
	 * @param second the second string to be machted
	 * @return matching score without scaling factor impact
	 */
	private static double score(final CharSequence first, final CharSequence second) {
		String shorter;
		String longer;

		// Determine which String is longer.
		if (first.length() > second.length()) {
			longer = first.toString().toLowerCase();
			shorter = second.toString().toLowerCase();
		} else {
			longer = second.toString().toLowerCase();
			shorter = first.toString().toLowerCase();
		}

		// Calculate the half length() distance of the shorter String.
		final int halflength = shorter.length() / 2 + 1;

		// Find the set of matching characters between the shorter and longer strings. Note that
		// the set of matching characters may be different depending on the order of the strings.
		final String m1 = getSetOfMatchingCharacterWithin(shorter, longer, halflength);
		final String m2 = getSetOfMatchingCharacterWithin(longer, shorter, halflength);

		// If one or both of the sets of common characters is empty, then
		// there is no similarity between the two strings.
		if (m1.length() == 0 || m2.length() == 0) {
			return 0.0;
		}

		// If the set of common characters is not the same size, then
		// there is no similarity between the two strings, either.
		if (m1.length() != m2.length()) {
			return 0.0;
		}

		// Calculate the number of transposition between the two sets
		// of common characters.
		final int transpositions = transpositions(m1, m2);

		// Calculate the distance.
		return (m1.length() / ((double) shorter.length()) +
				m2.length() / ((double) longer.length()) +
				(m1.length() - transpositions) / ((double) m1.length())) / 3.0;
	}

	/**
	 * Calculates the number of transposition between two strings.
	 *
	 * @param first  The first string.
	 * @param second The second string.
	 * @return The number of transposition between the two strings.
	 */
	private static int transpositions(final CharSequence first, final CharSequence second) {
		int transpositions = 0;
		for (int i = 0; i < first.length(); i++) {
			if (first.charAt(i) != second.charAt(i)) {
				transpositions++;
			}
		}
		return transpositions / 2;
	}


	/**
	 * Gets a set of matching characters between two strings.
	 * <p/>
	 * <p><Two characters from the first string and the second string are considered matching if the character's
	 * respective positions are no farther than the limit value.</p>
	 *
	 * @param first  The first string.
	 * @param second The second string.
	 * @param limit  The maximum distance to consider.
	 * @return A string contain the set of common characters.
	 */
	private static String getSetOfMatchingCharacterWithin(final CharSequence first, final CharSequence second, final int limit) {
		final StringBuilder common = new StringBuilder();
		final StringBuilder copy = new StringBuilder(second);

		for (int i = 0; i < first.length(); i++) {
			final char ch = first.charAt(i);
			boolean found = false;

			// See if the character is within the limit positions away from the original position of that character.
			for (int j = Math.max(0, i - limit); !found && j < Math.min(i + limit, second.length()); j++) {
				if (copy.charAt(j) == ch) {
					found = true;
					common.append(ch);
					copy.setCharAt(j, '*');
				}
			}
		}
		return common.toString();
	}


	public static String mergeExpertiseJSONValues(String newValues, String existingValues) throws JSONException {


		Map<String, Double> newMap = getJSONWordWeightsFromString(newValues);
		Map<String, Double> existing = getJSONWordWeightsFromString(existingValues);

		for (String newWord : newMap.keySet()) {
			if (!existing.containsKey(newWord)) {
				existing.put(newWord, newMap.get(newWord));
			}
		}

		JSONArray res = JSONFactoryUtil.createJSONArray();
		for (String word : existing.keySet()) {
			JSONObject obj = JSONFactoryUtil.createJSONObject();
			obj.put("word", word);
			obj.put("weight", existing.get(word));
			res.put(obj);
		}

		return res.toString();
	}

	public static Map<String, Double> getJSONWordWeightsFromString(String values) throws JSONException {

		Map<String, Double> result = new HashMap<String, Double>();

		if (Validator.isNull(values)) {
			return result;
		}
		JSONArray valueArr = JSONFactoryUtil.createJSONArray(values);
		for (int i = 0; i < valueArr.length(); i++) {
			JSONObject obj = valueArr.getJSONObject(i);
			result.put(obj.getString("word"), obj.getDouble("weight"));
		}

		return result;
	}

	public static String removeUnicode(String input) {
		if (Validator.isNull(input)) {
			return null;
		}
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < input.length(); i++) {
			if (i < (input.length() - 1)) {
				// Emojis are two characters long in java, e.g. a rocket emoji is "\uD83D\uDE80";
				if (Character.isSurrogatePair(input.charAt(i), input.charAt(i + 1))) {
					i += 1; //also skip the second character of the emoji
					continue;
				}
			}
			sb.append(input.charAt(i));
		}
		return sb.toString();
	}

	public static String removeStopWords(String words) throws IOException {
		if (Validator.isNull(EventContactServiceImpl.stopWords)) {
			EventContactServiceImpl.stopWords = new TreeSet<String>();
			BufferedReader r = new BufferedReader(new InputStreamReader(EventContactService.class.getClassLoader().getResourceAsStream("stopwords/words.txt")));
			String nextLine;

			while ((nextLine = r.readLine()) != null) {
				String word = nextLine.trim();
				if (Validator.isNotNull(word)) {
					EventContactServiceImpl.stopWords.add(nextLine.trim());
				}
			}
			r.close();
		}
		// remove punctuation and stuff

		final CharArraySet stopSet = new CharArraySet(Version.LUCENE_35, EventContactServiceImpl.stopWords, true);

		TokenStream tokenStream = new StopFilter(Version.LUCENE_35,
				new StandardTokenizer(Version.LUCENE_35, new StringReader(words)), stopSet);


		StringBuilder sb = new StringBuilder();
		CharTermAttribute charTermAttribute = tokenStream.addAttribute(CharTermAttribute.class);

		tokenStream.reset();

		while (tokenStream.incrementToken()) {
			String term = charTermAttribute.toString();
			sb.append(term).append(" ");
		}

		return sb.toString();
	}
}
