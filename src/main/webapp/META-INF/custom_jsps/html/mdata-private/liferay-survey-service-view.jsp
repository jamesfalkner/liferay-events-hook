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
<%@ include file="init.jsp" %>

<h1>Liferay Events Mobile App Surveys</h1>
<em>Click on an event below to see survey answers for that event.</em>
<hr>
<%

    try {
        final String className = "com.liferay.events.Surveys";

        String currentUrl = request.getRequestURL().toString();
        final String event = request.getParameter("event");
        final long companyId = PortalUtil.getCompanyId(request);
        String deleteAll = request.getParameter("deleteAll");
        String deleteOne = request.getParameter("deleteOne");
        String includeRawForms = request.getParameter("rawForms");
        final String nameCol = "Name";
        final String answersCol = "Answers";
        final String dateCol = "CreateDate";
        final String surveyIdCol = "Survey ID";

        List<ExpandoTable> allTables = ExpandoTableLocalServiceUtil.getExpandoTables(-1, -1);
        for (ExpandoTable tbl : allTables) {
            if (!className.equals(tbl.getClassName())) {
                continue;
            }

            String name = tbl.getName();

            if (name.contains("FORM")) continue;
            String evtUrl = currentUrl + "?event=" + HtmlUtil.escapeURL(name);
%>
<p><a href="<%= evtUrl %>">Survey Data for <%=name %>
</a></p>
<%
    }


    if (Validator.isNotNull(event)) {
        ExpandoTable table, formTable;

        try {
            table = ExpandoTableLocalServiceUtil.getTable(companyId, className, event);
            formTable = ExpandoTableLocalServiceUtil.getTable(companyId, className, "FORMS_RESULT_" + event);
        } catch (Exception ex) {
%>Cannot find tables for <%= event %> <%
        return;
    }

    final Set<String> allBeaconFormIds = new HashSet<String>();

    DDLRecordSet recordSet = DDLRecordSetLocalServiceUtil.fetchDDLRecordSet(20906);

    if (Validator.isNotNull(recordSet)) {
        for (DDLRecord record : recordSet.getRecords()) {
            String eid = GetterUtil.getString(record.getFieldValue("event_id"));
            if (eid.equalsIgnoreCase(event)) {
                allBeaconFormIds.addAll(Arrays.asList(GetterUtil.getString(record.getFieldValue("all_form_ids")).split(",")));
            }
        }
    }

    if (deleteAll != null) {
        ExpandoValueLocalServiceUtil.deleteTableValues(table.getTableId());
        ExpandoValueLocalServiceUtil.deleteTableValues(formTable.getTableId());

        List<ExpandoRow> rows = ExpandoRowLocalServiceUtil.getRows(companyId, className, table.getName(), -1, -1);
        for (ExpandoRow row : rows) {
            ExpandoRowLocalServiceUtil.deleteRow(row.getRowId());
        }
        rows = ExpandoRowLocalServiceUtil.getRows(companyId, className, formTable.getName(), -1, -1);
        for (ExpandoRow row : rows) {
            ExpandoRowLocalServiceUtil.deleteRow(row.getRowId());
        }
        ExpandoTableLocalServiceUtil.deleteTable(table.getTableId());
        ExpandoTableLocalServiceUtil.deleteTable(formTable.getTableId());
        response.sendRedirect(currentUrl);
    }

    if (deleteOne != null) {
        long deleteOneClassPK = Long.parseLong(deleteOne);
        long rowId = ExpandoRowLocalServiceUtil.getRow(companyId, className, event, deleteOneClassPK).getRowId();
        ExpandoValueLocalServiceUtil.deleteRowValues(rowId);
        ExpandoRowLocalServiceUtil.deleteExpandoRow(rowId);
    }

    // first show the non-form data

    // now get the data
    List<ExpandoRow> rows = ExpandoRowLocalServiceUtil.getRows(companyId, className, event, -1, -1);

    List<ExpandoRow> rowCopy = new ArrayList<ExpandoRow>();
    rowCopy.addAll(rows);

    if (Validator.isNull(includeRawForms)) {
        CollectionUtils.filter(rowCopy, new Predicate() {
            public boolean evaluate(Object input) {
                try {
                    String sid = ExpandoValueLocalServiceUtil.getData(companyId, className, event, surveyIdCol, ((ExpandoRow) input).getClassPK(), "foo");
                    return (!allBeaconFormIds.contains(sid));
                } catch (Exception ex) {
                    return true;
                }
            }
        });
    }
    // sort it based on surveyId and then Date
    Collections.sort(rowCopy, new Comparator<ExpandoRow>() {
        @Override
        public int compare(ExpandoRow expandoRow, ExpandoRow expandoRow2) {
            try {
                String sid1 = ExpandoValueLocalServiceUtil.getData(companyId, className, event, surveyIdCol, expandoRow.getClassPK(), "sid1");
                String sid2 = ExpandoValueLocalServiceUtil.getData(companyId, className, event, surveyIdCol, expandoRow2.getClassPK(), "sid2");
                int sidResult = sid1.compareTo(sid2);
                if (sidResult != 0) {
                    return sidResult;
                }
                Date d1 = ExpandoValueLocalServiceUtil.getData(companyId, className, event, dateCol, expandoRow.getClassPK(), new Date());
                Date d2 = ExpandoValueLocalServiceUtil.getData(companyId, className, event, dateCol, expandoRow2.getClassPK(), new Date());
                long diff = d2.getTime() - d1.getTime();
                if (diff < 0) return -1;
                else if (diff > 0) return 1;
                else return 0;
            } catch (Exception e) {
                return 0;
            }
        }
    });

    // collect all possible questionIds
    Set<String> questions = new LinkedHashSet<String>();
    for (ExpandoRow row : rows) {
        String answerJson = ExpandoValueLocalServiceUtil.getData(companyId, className, event, answersCol, row.getClassPK(), "");
        JSONArray ansJsonObj = JSONFactoryUtil.createJSONArray(answerJson);
        int len = ansJsonObj.length();
        for (int i = 0; i < len; i++) {
            JSONObject ansObj = ansJsonObj.getJSONObject(i);
            questions.add(ansObj.getString("questionId"));
        }
    }

    // now show table with headers of the questions
%>
<h2><%= event %> Session and Event Survey Results</h2>
<em><%= rows.size() %> Total Response(s)</em>
<%
    if (Validator.isNull(includeRawForms)) {
        String rawUrl = currentUrl + "?event=" + HtmlUtil.escapeURL(event) + "&rawForms=yes";
%>(Raw beacon form data omitted, <a href="<%= rawUrl %>">show me the raw data</a>)<%
    }
%>

<hr>
<button onclick="if (confirm('Delete All Survey Results? You won\'t be able to get them back!')) location.href='<%=currentUrl%>?deleteAll=true&event=<%= HtmlUtil.escapeURL(event)%>'">
    Delete All <%= event %> surveys
</button>
<table border="1">
    <tr>
        <th>
            Date Submitted
        </th>
        <th>
            Survey ID
        </th>
        <th>
            Device ID
        </th>
        <%
            for (String question : questions) {
        %>
        <th><%= question %>
        </th>
        <%
            }
        %>
        <th>Action</th>
    </tr>
    <%
        for (ExpandoRow row : rowCopy) {
            long rowClassPK = row.getClassPK();
            String devId = ExpandoValueLocalServiceUtil.getData(companyId, className, event, nameCol, row.getClassPK(), "");
            String sid = ExpandoValueLocalServiceUtil.getData(companyId, className, event, surveyIdCol, row.getClassPK(), "");

            Date date = ExpandoValueLocalServiceUtil.getData(companyId, className, event, dateCol, row.getClassPK(), new Date());

    %>
    <tr>
        <td><%= date %>
        </td>
        <td><%= sid %>
        </td>
        <td><%= devId %>
        </td>
        <%
            String answerJson = ExpandoValueLocalServiceUtil.getData(companyId, className, event, answersCol, row.getClassPK(), "");
            JSONArray ansJsonObj = JSONFactoryUtil.createJSONArray(answerJson);
            int len = ansJsonObj.length();
            for (String question : questions) {
                boolean answered = false;
                for (int i = 0; i < len; i++) {
                    JSONObject ansObj = ansJsonObj.getJSONObject(i);
                    if (ansObj.getString("questionId").equals(question)) {
                        answered = true;
        %>
        <td><%= ansObj.getString("answer")%>
        </td>
        <%
                }
            }
            if (!answered) {
        %>
        <td>--</td>
        <%
                }
            }
        %>
        <td>
            <button onclick="if (confirm('Delete this response?')) location.href='<%=currentUrl%>?deleteOne=<%= rowClassPK %>&event=<%= HtmlUtil.escapeURL(event)%>'">
                Delete
            </button>

        </td>

    </tr>
    <%
        }

    %>
</table>
<%

    // -----------------------------------------------------------------------------------------------------------------
    // now show beacon form result data
    rows = ExpandoRowLocalServiceUtil.getRows(companyId, className, "FORMS_RESULT_" + event, -1, -1);

    rowCopy = new ArrayList<ExpandoRow>();
    rowCopy.addAll(rows);
    // sort it based on how many correct
    Collections.sort(rowCopy, new Comparator<ExpandoRow>() {
        @Override
        public int compare(ExpandoRow expandoRow, ExpandoRow expandoRow2) {
            try {
                String[] c1 = ExpandoValueLocalServiceUtil.getData(companyId, className, "FORMS_RESULT_" + event, "correct_form_ids", expandoRow.getClassPK(), new String[0]);
                String[] c2 = ExpandoValueLocalServiceUtil.getData(companyId, className, "FORMS_RESULT_" + event, "correct_form_ids", expandoRow2.getClassPK(), new String[0]);
                return c2.length - c1.length;
            } catch (Exception e) {
                return 0;
            }
        }
    });


    // forms table: [date, name, email, correct_form_ids] classPk: hash(name+"-"+email)

%>
<h2><%= event %> Beacon Form Results</h2>
<em><%= rows.size() %> Total Response(s)</em>
<table border="1">
    <tr>
        <th>
            Entry #
        </th>
        <th>
            Final Form Date
        </th>
        <th>
            ID
        </th>
        <th>
            Name
        </th>
        <th>
            Email
        </th>
        <th>
            Company
        </th>
        <th>
            Correct Forms
        </th>
    </tr>

    <%
        int entryNo = 1;
        for (ExpandoRow row : rowCopy) {
            Date date = ExpandoValueLocalServiceUtil.getData(companyId, className, "FORMS_RESULT_" + event, "date", row.getClassPK(), new Date());
            String id = ExpandoValueLocalServiceUtil.getData(companyId, className, "FORMS_RESULT_" + event, "id", row.getClassPK(), "---");
            String name = ExpandoValueLocalServiceUtil.getData(companyId, className, "FORMS_RESULT_" + event, "name", row.getClassPK(), "---");
            String email = ExpandoValueLocalServiceUtil.getData(companyId, className, "FORMS_RESULT_" + event, "email", row.getClassPK(), "---");
            String userCompany = ExpandoValueLocalServiceUtil.getData(companyId, className, "FORMS_RESULT_" + event, "company", row.getClassPK(), "---");
            String[] fids = ExpandoValueLocalServiceUtil.getData(companyId, className, "FORMS_RESULT_" + event, "correct_form_ids", row.getClassPK(), new String[]{});

    %>
    <tr>
        <td><%= entryNo++ %>
        </td>
        <td><%= date %>
        </td>
        <td><%= id %>
        </td>
        <td><%= name %>
        </td>
        <td><%= email %>
        </td>
        <td><%= userCompany %>
        </td>
        <%

            Set<String> userFids = new HashSet<String>();
            userFids.addAll(Arrays.asList(fids));
            if (userFids.equals(allBeaconFormIds)) {
        %>
        <td>**ALL**</td>
        <%
        } else {
        %>
        <td><%= userFids %>
        </td>
        <%
            }
        %></tr>
    <%
        }
    %>
</table>
<%
    }

} catch (Exception ex) {
%>
Error: <%= ex.getLocalizedMessage() %>"
<%
    }

%>