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

import com.liferay.events.global.mobile.model.EventPollAnswer;
import com.liferay.events.global.mobile.model.EventPollQuestion;
import com.liferay.events.global.mobile.model.PollQuestionType;
import com.liferay.events.global.mobile.service.EventPollAnswerLocalServiceUtil;
import com.liferay.events.global.mobile.service.EventPollQuestionLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.PortletResponseUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.opencsv.CSVWriter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.portlet.*;
import java.io.*;
import java.util.*;

public class PollsPortlet extends MVCPortlet {

	@ProcessAction(name = "updateEventPollQuestion")
	public void updateEventPollQuestion(ActionRequest request, ActionResponse response)
			throws Exception {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				EventPollQuestion.class.getName(), request);

		boolean enabled = ParamUtil.getBoolean(request, "enabled");
		boolean autoEnable = ParamUtil.getBoolean(request, "autoEnable");
		long questionId = ParamUtil.getLong(request, "questionId");
		String eventId = ParamUtil.getString(request, "eventId");
		String shortTitle = ParamUtil.getString(request, "shortTitle");
		String sponsorName = ParamUtil.getString(request, "sponsorName");
		String question = ParamUtil.getString(request, "question");
		String questionType = ParamUtil.getString(request, "questionType");
		String chartType = ParamUtil.getString(request, "chartType");
		boolean anonymousResults = ParamUtil.getBoolean(request, "anonymousResults");
		boolean showResponseCount = ParamUtil.getBoolean(request, "showResponseCount");
		boolean askForId = ParamUtil.getBoolean(request, "askForId");
		String choices = ParamUtil.getString(request, "choices");
		String idIntro = ParamUtil.getString(request, "idIntro");
		String picUrl = ParamUtil.getString(request, "picUrl");

		String dateStr = ParamUtil.getString(request, "datePicker");
		String timeStr = ParamUtil.getString(request, "timePicker");
		String[] parts = dateStr.split("[^0-9]");

		int year = Integer.parseInt(parts[0]);
		int month = Integer.parseInt(parts[1]);
		int day = Integer.parseInt(parts[2]);

		parts = timeStr.split("[^0-9]");
		int hour = Integer.parseInt(parts[0]);
		int minute = Integer.parseInt(parts[1]);

		String tz = ParamUtil.getString(request, "tz");

		Calendar c = Calendar.getInstance(TimeZone.getTimeZone(tz));
		c.set(Calendar.DAY_OF_MONTH, day);
		c.set(Calendar.MONTH, month - 1);
		c.set(Calendar.YEAR, year);
		c.set(Calendar.HOUR_OF_DAY, hour);
		c.set(Calendar.MINUTE, minute);
		c.set(Calendar.SECOND, 0);

		if (questionId > 0) {
			try {
				EventPollQuestionLocalServiceUtil.updateQuestion(questionId, enabled, autoEnable, c.getTime(), tz, eventId, sponsorName, shortTitle,
						question, chartType, askForId, idIntro, questionType, choices, anonymousResults, showResponseCount, picUrl,
						serviceContext);
				SessionMessages.add(request, "entryAdded");

				response.setRenderParameter("questionId",
						Long.toString(questionId));
			} catch (Exception e) {

				SessionErrors.add(request, e.getClass().getName());

				PortalUtil.copyRequestParameters(request, response);

				response.setRenderParameter("mvcPath",
						"/html/polls/edit.jsp");
				e.printStackTrace();
			}

		} else {
			try {
				EventPollQuestionLocalServiceUtil.addQuestion(eventId, sponsorName, shortTitle, question,
						questionType, chartType, askForId, idIntro, choices, anonymousResults,
						showResponseCount, picUrl, enabled, autoEnable, c.getTime(), tz, serviceContext);

				SessionMessages.add(request, "entryAdded");

				response.setRenderParameter("questionId",
						Long.toString(questionId));

			} catch (Exception e) {
				SessionErrors.add(request, e.getClass().getName());

				PortalUtil.copyRequestParameters(request, response);

				response.setRenderParameter("mvcPath",
						"/html/polls/edit.jsp");
				e.printStackTrace();
			}

		}


	}

	@ProcessAction(name = "deleteEntry")
	public void deleteEntry(ActionRequest request, ActionResponse response)
			throws Exception {

		long questionId = ParamUtil.getLong(request, "questionId");
		EventPollAnswerLocalServiceUtil.deleteAnswersForQuestion(questionId);
		EventPollQuestionLocalServiceUtil.deleteEventPollQuestion(questionId);


	}

	@ProcessAction(name = "deleteAnswers")
	public void deleteAnswers(ActionRequest request, ActionResponse response)
			throws Exception {

		long questionId = ParamUtil.getLong(request, "questionId");

		EventPollAnswerLocalServiceUtil.deleteAnswersForQuestion(questionId);
	}

	@ProcessAction(name = "toggleEnable")
	public void toggleEnable(ActionRequest request, ActionResponse response)
			throws Exception {

		long questionId = ParamUtil.getLong(request, "questionId");
		EventPollQuestion q = EventPollQuestionLocalServiceUtil.getEventPollQuestion(questionId);
		q.setEnabled(!q.getEnabled());
		EventPollQuestionLocalServiceUtil.updateEventPollQuestion(q);
	}

	@ProcessAction(name = "addAnswer")
	public void addAnswer(ActionRequest request, ActionResponse response)
			throws Exception {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				EventPollQuestion.class.getName(), request);

		long questionId = ParamUtil.getLong(request, "questionId");
		String answer = ParamUtil.getString(request, "answer");
		String clientId = ParamUtil.getString(request, "clientId");
		String payload = ParamUtil.getString(request, "payload");

		try {
			EventPollAnswerLocalServiceUtil.addAnswer(questionId, clientId, payload, answer, serviceContext);
			SessionMessages.add(request, "entryAdded");

			response.setRenderParameter("questionId",
					Long.toString(questionId));
		} catch (Exception e) {

			SessionErrors.add(request, e.getClass().getName());

			PortalUtil.copyRequestParameters(request, response);

			response.setRenderParameter("mvcPath",
					"/html/polls/edit.jsp");
			e.printStackTrace();
		}
	}

	@Override
	public void serveResource(ResourceRequest request, ResourceResponse response) throws PortletException, IOException {
		// do search and return result
		String cmd = ParamUtil.getString(request, "cmd");
		long questionId = ParamUtil.getLong(request, "questionId");

		EventPollQuestion question;
		List<EventPollAnswer> answers;
		try {
			question = EventPollQuestionLocalServiceUtil.getEventPollQuestion(questionId);
			answers = EventPollAnswerLocalServiceUtil.getAllAnswerObjs(questionId);
		} catch (SystemException e) {
			throw new PortletException("Cannot get answers for questionId " + questionId);
		} catch (PortalException e) {
			throw new PortletException("Cannot get question or answers for questionId " + questionId);
		}


		if (Validator.equals(cmd, "exportAnswersCSV")) {

			File f = FileUtil.createTempFile();

			CSVWriter writer = new CSVWriter(new FileWriter(f), ',');

			// find out all headers
			List<String> headers = new ArrayList<String>();
			headers.add("ID");
			headers.add("RAW ANSWER");

			Set<String> payloadHeaders = new HashSet<String>();

			for (EventPollAnswer answer : answers) {
				JSONObject payloadObj = null;

				try {
					payloadObj = JSONFactoryUtil.createJSONObject(answer.getPayload());
					if (Validator.isNull(payloadObj)) {
						continue;
					}
				} catch (JSONException e) {
					throw new PortletException("cannot read payload: " + answer.getPayload());
				}
				Iterator<String> keyIt = payloadObj.keys();

				while (keyIt.hasNext()) {
					String key = keyIt.next();
					payloadHeaders.add(key);
				}
			}

			headers.addAll(payloadHeaders);

			Map<String, Integer> headerCols = new HashMap<String, Integer>();
			for (int i = 0; i < headers.size(); i++) {
				headerCols.put(headers.get(i), i);
			}

			// now print them
			writer.writeNext(headers.toArray(new String[]{}));

			for (EventPollAnswer answer : answers) {
				List<String> vals = new ArrayList<String>();

				JSONObject payloadObj = null;

				try {
					payloadObj = JSONFactoryUtil.createJSONObject(answer.getPayload());
					if (Validator.isNull(payloadObj)) {
						continue;
					}
				} catch (JSONException e) {
					throw new PortletException("cannot read payload: " + answer.getPayload());
				}

				for (String headerCol : headers) {
					String val;
					if (headerCol.equals("ID")) {
						val = String.valueOf(answer.getAnswerId());
					} else if (headerCol.equals("RAW ANSWER")) {
						val = String.valueOf(answer.getAnswer());
					} else {
						val = payloadObj.getString(headerCol);
					}

					if (Validator.isNull(val)) {
						val = "";
					}
					vals.add(val);
				}

				writer.writeNext(vals.toArray(new String[]{}));
			}
			writer.flush();
			writer.close();
			PortletResponseUtil.sendFile(request, response, question.getShortTitle().replaceAll("[^0-9A-Za-z]", "-") + ".csv", new FileInputStream(f));

		} else if (Validator.equals(cmd, "exportAnswersXLSX")) {

			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet("Poll Answers");

			Row headerRow = sheet.createRow(0);
			Cell headerCell = headerRow.createCell(0);
			headerCell.setCellValue("ID");

			headerCell = headerRow.createCell(1);
			headerCell.setCellValue("Raw Answer");

			HashMap<String, Integer> rowMap = new HashMap<String, Integer>();

			int currentRow = 1;
			int nextHeaderCol = 2;
			for (EventPollAnswer answer : answers) {
				Row row = sheet.createRow(currentRow);
				currentRow++;
				JSONObject payloadObj = null;
				long answerId = answer.getAnswerId();
				Cell idCell = row.createCell(0);
				idCell.setCellValue(String.valueOf(answerId));

				try {
					payloadObj = JSONFactoryUtil.createJSONObject(answer.getPayload());
					if (Validator.isNull(payloadObj)) {
						continue;
					}
				} catch (JSONException e) {
					throw new PortletException("cannot read payload: " + answer.getPayload());
				}

				Cell answerCell = row.createCell(1);
				answerCell.setCellValue(String.valueOf(answer.getAnswer()));


				Iterator<String> keyIt = payloadObj.keys();

				while (keyIt.hasNext()) {
					String key = keyIt.next();
					Integer headerCol = rowMap.get(key);
					if (Validator.isNull(headerCol)) {
						rowMap.put(key, nextHeaderCol);
						Cell nextHeaderCell = headerRow.createCell(nextHeaderCol);
						nextHeaderCell.setCellValue(key.toUpperCase());
						headerCol = nextHeaderCol;
						nextHeaderCol++;
					}
					Cell cell = row.createCell(headerCol);
					cell.setCellValue(payloadObj.getString(key));
				}
			}

			File f = FileUtil.createTempFile();
			FileOutputStream fos = new FileOutputStream(f);
			workbook.write(fos);
			fos.flush();
			fos.close();
			PortletResponseUtil.sendFile(request, response, question.getShortTitle().replaceAll("[^0-9A-Za-z]", "-") + ".xlsx", new FileInputStream(f));

		}
	}

	public static final int ANSWER_COUNT = 53;

	@ProcessAction(name = "generateChoices")
	public void generateChoices(ActionRequest request, ActionResponse response)
			throws Exception {


		long questionId = ParamUtil.getLong(request, "questionId");

		EventPollQuestion q = EventPollQuestionLocalServiceUtil.getEventPollQuestion(questionId);

		if (q.getQuestionType().equals(PollQuestionType.QUESTION_TYPE_SINGLE.getTypeName()) ||
				q.getQuestionType().equals(PollQuestionType.QUESTION_TYPE_MULTIPLE.getTypeName())) {
			JSONArray choices = JSONFactoryUtil.createJSONArray(q.getChoices());

			// pick an answer to tend toward
			int tend = (int) Math.floor(Math.random() * (double) choices.length());

			for (int i = 0; i < ANSWER_COUNT; i++) {
				JSONArray answers = JSONFactoryUtil.createJSONArray();

				if (q.getQuestionType().equals("multiple")) {
					int count = (int) (Math.random() * (double) choices.length());
					for (int j = 0; j < count; j++) {
						String ans = choices.getString((int) (Math.random() * (double) choices.length()));
						if (Math.random() > .7) {
							ans = choices.getString(tend);
						}
						answers.put(ans);
					}
				} else if (q.getQuestionType().equals("single")) {
					String ans = choices.getString((int) (Math.random() * (double) choices.length()));
					if (Math.random() > .7) {
						ans = choices.getString(tend);
					}
					answers.put(ans);
				} else {
					throw new Exception("Invalid question type: must be single or multiple");
				}


				EventPollAnswerLocalServiceUtil.addAnswer(questionId, "FAKE_GEN", "{}", answers.toString(), new ServiceContext());

				Thread.sleep(500 + (long) (1000.0 * Math.random()));
			}
		} else if (q.getQuestionType().equals(PollQuestionType.QUESTION_TYPE_RATING.getTypeName())) {
			JSONArray choices = JSONFactoryUtil.createJSONArray(q.getChoices());

			int min = choices.getInt(0);
			int max = choices.getInt(1);

			for (int i = 0; i < ANSWER_COUNT; i++) {
				int inc = (int) Math.floor(Math.random() * (double) ((max - min) + 1));
				if (Math.random() > .5) {
					inc = 4;
				}
				int ansNum = min + inc;
				EventPollAnswerLocalServiceUtil.addAnswer(questionId, "FAKE_GEN", "{}", String.valueOf(ansNum), new ServiceContext());
				Thread.sleep(500 + (long) (1000.0 * Math.random()));

			}
		} else if (q.getQuestionType().equals(PollQuestionType.QUESTION_TYPE_RANKING.getTypeName())) {
			JSONArray choices = JSONFactoryUtil.createJSONArray(q.getChoices());
			List<String> ans = new ArrayList<String>();
			List<String> unshuffled = new ArrayList<String>();
			for (int i = 0; i < choices.length(); i++) {
				ans.add(choices.getString(i));
			}
			unshuffled.addAll(ans);

			for (int i = 0; i < ANSWER_COUNT; i++) {
				Collections.shuffle(ans);

				JSONArray res = JSONFactoryUtil.createJSONArray();
				for (String s : (Math.random() > .2) ? ans : unshuffled) {
					res.put(s);
				}
				EventPollAnswerLocalServiceUtil.addAnswer(questionId, "FAKE_GEN", "{}", res.toString(), new ServiceContext());
				Thread.sleep(500 + (long) (1000.0 * Math.random()));

			}


		} else if (q.getQuestionType().equals(PollQuestionType.QUESTION_TYPE_TEXT.getTypeName())) {


			for (int i = 0; i < ANSWER_COUNT; i++) {

				int cnt = (int) (Math.floor((double) 8 * Math.random()));

				List<String> ansStr = new ArrayList<String>();

				for (int j = 0; j < cnt; j++) {
					ansStr.add(DEMO_WORDS[(int) (Math.floor((double) DEMO_WORDS.length * Math.random()))]);
				}

				if (Math.random() > .5) {
					ansStr.add("digital");
				}
				EventPollAnswerLocalServiceUtil.addAnswer(questionId, "FAKE_GEN",
						"{}", StringUtil.merge(ansStr, " "), new ServiceContext());
				Thread.sleep(500 + (long) (1000.0 * Math.random()));
			}


		}
	}

	public static final String[] DEMO_WORDS = new String[]{

			"			application servers databases",
			"			databases and operating",
			"			systems to eliminate",
			"			eliminate new spending",
			"			existing application servers",
			"			runs on your",
			"			get it now",
			"			it now liferay",
			"			solutions that deliver",
			"			products liferay portal",
			"			spending on infrastructure",
			"			your existing application",
			"			integrates with your",
			"			your existing applications",
			"			customize and integrates",
			"			easy to customize",
			"			environments is easy",
			"			your enterprise trial",
			"			existing applications start",
			"			start your enterprise",
			"			delivering value today",
			"			start delivering value",
			"			applications start delivering",
			"			non-microsoft environments is",
			"			runs in non-microsoft",
			"			enterprise trial request",
			"			websphere reg cpu",
			"			trial request demo",
			"			single websphere reg",
			"			cost of single",
			"			reg cpu more",
			"			cpu more flexible",
			"			reg liferay runs",
			"			sharepoint reg liferay",
			"			reg unlike sharepoint",
			"			flexible than sharepoint",
			"			value today get",
			"			today get immediate",
			"			has in store",
			"			store for your",
			"	liferay portal has",
			"	possibilities liferay portal",
			"	the possibilities liferay",
			"	your organization get",
			"	organization get enterprise",
			"	trial learn more",
			"	edition trial learn",
			"	enterprise edition trial",
			"	get enterprise edition",
			"	discover the possibilities",
			"	support and feature",
			"	edition to discover",
			"	subscription start your",
			"	our enterprise edition",
			"	access to our",
			"	get immediate access",
			"	less than the",
			"	enterprise subscription start",
			"	feature options available",
			"	available with liferay",
			"	liferay portal enterprise",
			"	portal enterprise subscription",
			"	more about support",
			"	week to get",
			"	top ten owasp-recommended",
			"	ten owasp-recommended security",
			"	implements top ten",
			"	availability implements top",
			"	high availability implements",
			"	owasp-recommended security practices",
			"	security practices options",
			"	other scalability solutions",
			"	scalability solutions deployable",
			"	rac and other",
			"	terracotta oracle rac",
			"	options for terracotta",
			"	configuration for high",
			"	methodologies clusterable configuration",
			"	users daily page",
			"	daily page hits",
			"	millions of users",
			"	scalable supporting millions",
			"	highly scalable supporting",
			"	hits and more",
			"	more supports both",
			"	scaling methodologies clusterable",
			"	vertical scaling methodologies",
			"	horizontal and vertical",
			"	supports both horizontal",
			"	deployable to the",
			"	cloud and available",
			"	strategic growth simpler",
			"	simpler than websphere",
			"	future strategic growth",
			"	drive future strategic",
			"	enough to drive",
			"	websphere reg deploy",
			"	reg deploy liferay",
			"	solution for portals",
			"	content and collaboration",
	};
}

