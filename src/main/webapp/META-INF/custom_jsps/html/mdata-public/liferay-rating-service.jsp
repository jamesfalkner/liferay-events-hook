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
%@ include file="sig.jspf" %>

<%
    try {
        String event = request.getParameter("event");
        String name = request.getParameter("name");
        String rate = request.getParameter("rate");
        String id = request.getParameter("id");
        String cmd = request.getParameter("cmd");
        final long companyId = PortalUtil.getCompanyId(request);

        if (Validator.isNull(cmd)) {
            cmd = "rate";
        }

        if (Validator.isNull(event) || Validator.isNull(name) || Validator.isNull(rate) || Validator.isNull(id)) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid signature.");
            return;
        }

        String className = "com.liferay.events.Ratings";
        int stringColumnType = 15;
        int dateColumnType = 3;

        String nameCol = "Name";
        String rateCol = "Rate";
        String idCol = "Id";
        String dateCol = "CreateDate";


        ExpandoTable table;
        ExpandoColumn dateColObj;


        try {
            table = ExpandoTableLocalServiceUtil.getTable(companyId, className, event);
            dateColObj = ExpandoColumnLocalServiceUtil.getColumn(table.getTableId(), dateCol);
        } catch (Exception ex) {
            table = ExpandoTableLocalServiceUtil.addTable(companyId, className, event);
            dateColObj = ExpandoColumnLocalServiceUtil.addColumn(table.getTableId(), dateCol, dateColumnType);

            ExpandoColumnLocalServiceUtil.addColumn(table.getTableId(), nameCol, stringColumnType);
            ExpandoColumnLocalServiceUtil.addColumn(table.getTableId(), rateCol, stringColumnType);
            ExpandoColumnLocalServiceUtil.addColumn(table.getTableId(), idCol, stringColumnType);

        }

        Date date = new Date();
        long classPK = (table.getTableId() + name + rate + id).hashCode();

        if (cmd.equals("rate")) {
            if (ExpandoValueLocalServiceUtil.getValue(table.getTableId(), dateColObj.getColumnId(), classPK) != null) {
%> { "stat" : "error: already rated" } <%
} else {
    ExpandoValueLocalServiceUtil.addValue(companyId, className, event, nameCol, classPK, name);
    ExpandoValueLocalServiceUtil.addValue(companyId, className, event, rateCol, classPK, rate);
    ExpandoValueLocalServiceUtil.addValue(companyId, className, event, idCol, classPK, id);
    ExpandoValueLocalServiceUtil.addValue(companyId, className, event, dateCol, classPK, date);
%> { "stat" : "ok" } <%
    }
} else if (cmd.equals("get")) {
    List<ExpandoValue> allVals = ExpandoValueLocalServiceUtil.getColumnValues(companyId, className, event, idCol, id, -1, -1);
%> { "stat" : "ok", "count" : <%= allVals.size() %> } <%
    } else {
        response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid command.");
        return;
    }
} catch (Exception ex) {
%>
{ "stat": "error: <%= ex.getLocalizedMessage() %>" }
<%
    }
%>
