<%--
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
 */
--%>
<%@ page import="com.liferay.portlet.dynamicdatalists.model.DDLRecordSet" %>
<%@ include file="sig.jspf" %>


<%
    try {
        String cmd = request.getParameter("cmd");
        String event = request.getParameter("event");
        String name = request.getParameter("name");
        String surveyId = request.getParameter("surveyId");
        String answers = request.getParameter("answers");

        if (Validator.equals(cmd, "reset")) {
            if (Validator.isNull(event) || Validator.isNull(name)) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid signature.");
                return;
            }
        } else {

            if (Validator.isNull(event) || Validator.isNull(name) || Validator.isNull(surveyId) || Validator.isNull(answers)) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid signature.");
                return;
            }
        }

        if (Validator.isNotNull(answers)) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < answers.length(); i++) {
                if (i < (answers.length() - 1)) { // Emojis are two characters long in java, e.g. a rocket emoji is "\uD83D\uDE80";
                    if (Character.isSurrogatePair(answers.charAt(i), answers.charAt(i + 1))) {
                        i += 1; //also skip the second character of the emoji
                        continue;
                    }
                }
                sb.append(answers.charAt(i));
            }
            answers = sb.toString();
        }


        final long companyId = PortalUtil.getCompanyId(request);

        String className = "com.liferay.events.Surveys";
        String formsResultTableName = "FORMS_RESULT_" + event;
        int stringColumnType = 15;
        int stringArrayColumnType = 16;
        int dateColumnType = 3;

        String nameCol = "Name";
        String surveyIdCol = "Survey ID";
        String answersCol = "Answers";
        String dateCol = "CreateDate";


        ExpandoTable table;
        ExpandoTable formsTable;
        ExpandoColumn dateColObj;
        ExpandoColumn correctFormIdColObj;

        try {
            table = ExpandoTableLocalServiceUtil.getTable(companyId, className, event);
            dateColObj = ExpandoColumnLocalServiceUtil.getColumn(table.getTableId(), dateCol);
        } catch (Exception ex) {
            table = ExpandoTableLocalServiceUtil.addTable(companyId, className, event);
            dateColObj = ExpandoColumnLocalServiceUtil.addColumn(table.getTableId(), dateCol, dateColumnType);

            ExpandoColumnLocalServiceUtil.addColumn(table.getTableId(), nameCol, stringColumnType);
            ExpandoColumnLocalServiceUtil.addColumn(table.getTableId(), surveyIdCol, stringColumnType);
            ExpandoColumnLocalServiceUtil.addColumn(table.getTableId(), answersCol, stringColumnType);

        }

        // forms table: [date, name, email, company, correct_form_ids] classPk: hash(name+"-"+email)

        try {
            formsTable = ExpandoTableLocalServiceUtil.getTable(companyId, className, formsResultTableName);
            correctFormIdColObj = ExpandoColumnLocalServiceUtil.getColumn(formsTable.getTableId(), "correct_form_ids");

        } catch (Exception ex) {
            formsTable = ExpandoTableLocalServiceUtil.addTable(companyId, className, formsResultTableName);
            ExpandoColumnLocalServiceUtil.addColumn(formsTable.getTableId(), "id", stringColumnType);
            ExpandoColumnLocalServiceUtil.addColumn(formsTable.getTableId(), "date", dateColumnType);
            ExpandoColumnLocalServiceUtil.addColumn(formsTable.getTableId(), "name", stringColumnType);
            ExpandoColumnLocalServiceUtil.addColumn(formsTable.getTableId(), "email", stringColumnType);
            ExpandoColumnLocalServiceUtil.addColumn(formsTable.getTableId(), "company", stringColumnType);
            correctFormIdColObj = ExpandoColumnLocalServiceUtil.addColumn(formsTable.getTableId(), "correct_form_ids", stringArrayColumnType);
        }

        if (Validator.equals(cmd, "reset")) {

            final Set<String> allBeaconFormIds = new HashSet<String>();

            DDLRecordSet ddlConfig = DDLRecordSetLocalServiceUtil.fetchDDLRecordSet(20906);

            if (Validator.isNull(ddlConfig)) {
                %> { "stat" : "ok" } <%
                return;
            }
            for (DDLRecord record : ddlConfig.getRecords()) {
                String eid = GetterUtil.getString(record.getFieldValue("event_id"));
                if (eid.equalsIgnoreCase(event)) {
                    allBeaconFormIds.addAll(Arrays.asList(GetterUtil.getString(record.getFieldValue("all_form_ids")).split(",")));
                }
            }

            List<Long> toDelete = new ArrayList<Long>();
            for (ExpandoRow row : ExpandoRowLocalServiceUtil.getRows(companyId, className, event, -1, -1)) {
                String nm = ExpandoValueLocalServiceUtil.getData(companyId, className, event, nameCol, row.getClassPK(), "foo");
                String sid = ExpandoValueLocalServiceUtil.getData(companyId, className, event, surveyIdCol, row.getClassPK(), "foo");

                if (allBeaconFormIds.contains(sid) && nm.equalsIgnoreCase(name)) {
                    toDelete.add(row.getRowId());
                }
            }

            for (long rid : toDelete) {
                ExpandoValueLocalServiceUtil.deleteRowValues(rid);
                ExpandoRowLocalServiceUtil.deleteExpandoRow(rid);
            }

            toDelete.clear();

            for (ExpandoRow row : ExpandoRowLocalServiceUtil.getRows(companyId, className, formsResultTableName, -1, -1)) {
                String id = ExpandoValueLocalServiceUtil.getData(companyId, className, formsResultTableName, "id", row.getClassPK(), "foo");

                if (id.equalsIgnoreCase(name)) {
                    toDelete.add(row.getRowId());
                }
            }

            for (long rid : toDelete) {
                ExpandoValueLocalServiceUtil.deleteRowValues(rid);
                ExpandoRowLocalServiceUtil.deleteExpandoRow(rid);
            }
%> { "stat" : "ok" } <%
        return;
    }


    Date date = new Date();
    long classPK = (table.getTableId() + name + answers + surveyId).hashCode();

    if (ExpandoValueLocalServiceUtil.getValue(table.getTableId(), dateColObj.getColumnId(), classPK) != null) {
%> { "stat" : "error: already submitted these answers" } <%
} else {
    ExpandoValueLocalServiceUtil.addValue(companyId, className, event, nameCol, classPK, name);
    ExpandoValueLocalServiceUtil.addValue(companyId, className, event, answersCol, classPK, answers);
    ExpandoValueLocalServiceUtil.addValue(companyId, className, event, dateCol, classPK, date);
    ExpandoValueLocalServiceUtil.addValue(companyId, className, event, surveyIdCol, classPK, surveyId);

    JSONObject jsonResponse = JSONFactoryUtil.createJSONObject();
    JSONArray origAnswers = JSONFactoryUtil.createJSONArray(answers);

    Map<String, String> origAnswerMap = new HashMap<String, String>();
    for (int i = 0; i < origAnswers.length(); i++) {
        JSONObject ans = origAnswers.getJSONObject(i);
        origAnswerMap.put(ans.getString("questionId").trim(), ans.getString("answer").trim());
    }
    jsonResponse.put("stat", "ok");
    String quizResponseText = null;
    String quizFormStat = "fail";
    JSONObject extraData = null;

    DDLRecordSet ddlConfig = DDLRecordSetLocalServiceUtil.fetchDDLRecordSet(20906);

    if (Validator.isNotNull(ddlConfig)) {
        stopAll:
        for (DDLRecord record : ddlConfig.getRecords()) {
            String eid = GetterUtil.getString(record.getFieldValue("event_id"));
            String all_success_msg = GetterUtil.getString(record.getFieldValue("all_success_message"));
            String notification_emails = GetterUtil.getString(record.getFieldValue("notification_emails"));
            if (eid.equalsIgnoreCase(event)) {
                String[] allFormIds = GetterUtil.getString(record.getFieldValue("all_form_ids")).split(",");
                for (String formId : allFormIds) {
                    if (formId.equalsIgnoreCase(surveyId)) {
                        quizResponseText = "";

                        String userFullName = origAnswerMap.get("NAME");
                        String userEmail = origAnswerMap.get("EMAIL");
                        String userCompany = origAnswerMap.get("COMPANY");
                        if (Validator.isNull(userFullName) || Validator.isNull(userEmail) || Validator.isNull(userCompany)) {
                            quizResponseText = "You must specify your full name, email address, and company to participate!";
                            break stopAll;
                        }

                        boolean foundAns = false;
                        boolean allCorrect = true;
                        JSONArray correctAnswers = JSONFactoryUtil.createJSONArray(GetterUtil.getString(record.getFieldValue("answers")));
                        for (int i = 0; i < correctAnswers.length(); i++) {
                            JSONObject correctAnswerSet = correctAnswers.getJSONObject(i);
                            String correctAnswerSetFormId = correctAnswerSet.getString("form_id");
                            if (correctAnswerSetFormId.equalsIgnoreCase(surveyId)) {
                                foundAns = true;
                                JSONArray qaSet = correctAnswerSet.getJSONArray("qa");
                                for (int j = 0; j < qaSet.length(); j++) {
                                    String ques = qaSet.getJSONObject(j).getString("question");
                                    String ans = qaSet.getJSONObject(j).getString("answer");
                                    String successText = qaSet.getJSONObject(j).getString("successMessage");
                                    String failText = qaSet.getJSONObject(j).getString("failMessage");
                                    String userAns = origAnswerMap.get(ques);
                                    Pattern p = Pattern.compile(ans, Pattern.CASE_INSENSITIVE);
                                    if (Validator.isNotNull(userAns) && p.matcher(userAns).matches()) {
                                        // user got it right!
                                        quizResponseText += ("- " + successText + "\n\n");
                                    } else {
                                        // user got it wrong!
                                        quizResponseText += ("- " + failText + "\n\n");
                                        allCorrect = false;
                                    }
                                }
                                break;
                            }
                        }

                        if (foundAns && allCorrect) {
                            quizFormStat = "success";

                            String uid = userFullName + "-" + userEmail + "-" + userCompany;
                            Set curRightAnswers = new HashSet();

                            ExpandoValue curVal = ExpandoValueLocalServiceUtil.getValue(formsTable.getTableId(), correctFormIdColObj.getColumnId(), uid.hashCode());
                            if (curVal != null) {
                                curRightAnswers.addAll(Arrays.asList(curVal.getStringArray()));
                            }

                            curRightAnswers.add(surveyId);

                            if (curVal != null) {
                                curVal.setStringArray((String[]) curRightAnswers.toArray(new String[]{}));
                                ExpandoValueLocalServiceUtil.updateExpandoValue(curVal);

                                curVal = ExpandoValueLocalServiceUtil.getValue(companyId, className, formsResultTableName, "date", uid.hashCode());
                                curVal.setDate(date);
                                ExpandoValueLocalServiceUtil.updateExpandoValue(curVal);

                            } else {
                                // forms table: [date, name, email, company, correct_form_ids] classPk: hash(name+"-"+email)
                                ExpandoValueLocalServiceUtil.addValue(companyId, className, formsResultTableName, "id", uid.hashCode(), name);
                                ExpandoValueLocalServiceUtil.addValue(companyId, className, formsResultTableName, "date", uid.hashCode(), date);
                                ExpandoValueLocalServiceUtil.addValue(companyId, className, formsResultTableName, "name", uid.hashCode(), userFullName);
                                ExpandoValueLocalServiceUtil.addValue(companyId, className, formsResultTableName, "email", uid.hashCode(), userEmail);
                                ExpandoValueLocalServiceUtil.addValue(companyId, className, formsResultTableName, "company", uid.hashCode(), userCompany);
                                ExpandoValueLocalServiceUtil.addValue(companyId, className, formsResultTableName, "correct_form_ids", uid.hashCode(),
                                        (String[]) curRightAnswers.toArray(new String[]{}));
                            }

                            // if all correct!
                            Set allForms = new HashSet();
                            allForms.addAll(Arrays.asList(allFormIds));

                            if (allForms.equals(curRightAnswers)) {
                                // everything all correct!
                                extraData = JSONFactoryUtil.createJSONObject();
                                extraData.put("all_success_msg", all_success_msg);
                                if (Validator.isNotNull(notification_emails)) {
                                    String[] emails = notification_emails.split(",");
                                    InternetAddress from = new InternetAddress("james.falkner@liferay.com", "MDATA Webmaster");
                                    for (String email : emails) {
                                        InternetAddress to = new InternetAddress(email.trim());
                                        String sub = userFullName + "(" + userCompany + ") found " + event + " Mystery Object";
                                        StringBuilder body = new StringBuilder();
                                        body.append("NAME: " + userFullName + "\n");
                                        body.append("EMAIL: " + userEmail + "\n");
                                        body.append("COMPANY: " + userCompany + "\n");
                                        body.append("-------------------------------\n\n");
                                        body.append("All form answers:\n\n");

                                        for (String q : origAnswerMap.keySet()) {
                                            body.append(q).append(':').append(origAnswerMap.get(q)).append('\n');
                                        }
                                        MailMessage mailMessage = new MailMessage(
                                                from, to, sub, body.toString(), false);
                                        MailServiceUtil.sendEmail(mailMessage);

                                    }
                                }
                            }
                        }
                        break;
                    }
                }
                break;
            }
        }
    }

    JSONObject quizResp = JSONFactoryUtil.createJSONObject();
    quizResp.put("formstat", Validator.isNotNull(quizFormStat) ? quizFormStat : "fail");
    quizResp.put("message", Validator.isNotNull(quizResponseText) ? quizResponseText : "Ugh... Something is terribly wrong!");
    if (Validator.isNotNull(extraData)) {
        quizResp.put("extraData", extraData);
    }
    jsonResponse.put("response", quizResp);
%> <%= jsonResponse %> <%
    }
} catch (Exception ex) {
    ex.printStackTrace();
%>
{ "stat": "error: <%= ex.getLocalizedMessage() %> <%= Arrays.toString(ex.getStackTrace()) %>" }
<%
    }
%>
