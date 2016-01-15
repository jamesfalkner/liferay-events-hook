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

<%@ include file="sig.jspf" %>

<%
    try {
        String event = request.getParameter("event");
        String fromStr = request.getParameter("from");
        String toStr = request.getParameter("to");
        Date fromDate = null;
        Date toDate = null;
        if (Validator.isNotNull(fromStr)) {
            fromDate = new Date(Long.parseLong(fromStr));
        }
        if (Validator.isNotNull(toStr)) {
            toDate = new Date(Long.parseLong(toStr));
        }
        final long companyId = PortalUtil.getCompanyId(request);

        String className = "com.liferay.events.BeaconData";

        if (Validator.isNotNull(event)) {

            ExpandoTable table;


            table = ExpandoTableLocalServiceUtil.getTable(companyId, className, event);


            List<ExpandoValue> dateStampOrig = ExpandoValueLocalServiceUtil.getColumnValues(companyId, className, event, "date", -1, -1);

            List<ExpandoValue> dateStamps = new ArrayList<ExpandoValue>();
            dateStamps.addAll(dateStampOrig);

            Collections.sort(dateStamps, new Comparator<ExpandoValue>() {
                @Override
                public int compare(ExpandoValue ev1, ExpandoValue ev2) {
                    try {
                        Date d1 = ev1.getDate();
                        Date d2 = ev2.getDate();
                        return d1.compareTo(d2);
                    } catch (Exception ex) {
                        return 0;
                    }
                }
            });

            JSONObject result = JSONFactoryUtil.createJSONObject();
            result.put("stat", "ok");
            if (Validator.isNotNull(fromDate)) {
                result.put("from", fromDate.getTime());
            } else {
                result.put("from", dateStamps.get(0).getDate().getTime());
            }
            if (Validator.isNotNull(toDate)) {
                result.put("to", toDate.getTime());
            } else {
                result.put("to", dateStamps.get(dateStamps.size() - 1).getDate().getTime());
            }


            JSONArray resArr = JSONFactoryUtil.createJSONArray();

            int resSize = 0;
            for (ExpandoValue dateVal : dateStamps) {
                JSONObject obj = JSONFactoryUtil.createJSONObject();
                Date rowDate = dateVal.getDate();
                if (fromDate != null && rowDate.before(fromDate)) {
                    continue;
                }
                if (toDate != null && rowDate.after(toDate)) {
                    continue;
                }

                resSize++;
                String rowId = ExpandoValueLocalServiceUtil.getValue(companyId, className, table.getName(), "id", dateVal.getClassPK()).getString();
                String rowRegions = ExpandoValueLocalServiceUtil.getValue(companyId, className, table.getName(), "regions", dateVal.getClassPK()).getString();
                String rowBeacons = ExpandoValueLocalServiceUtil.getValue(companyId, className, table.getName(), "beacons", dateVal.getClassPK()).getString();
                obj.put("date", rowDate.getTime());
                obj.put("regions", JSONFactoryUtil.createJSONArray(rowRegions));
                obj.put("beacons", JSONFactoryUtil.createJSONArray(rowBeacons));
                obj.put("id", rowId);
                resArr.put(obj);
            }

            result.put("size", resSize);

            result.put("resultSet", resArr);

            %> <%= result %> <%

        } else {

            %> { "stat", "error: no event specified"} <%
        }
    } catch (Exception ex) {

        %> { "stat", "error: <%= HtmlUtil.escapeJS(ex.getLocalizedMessage())%>"} <%

    }
%>
