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
<%@ include file="init.jsp" %>

<h1>Liferay Events Mobile App Ratings</h1>
<em>Click on an event below to see ratings for that event.</em>
<hr>
<%
    try {
        String className = "com.liferay.events.Ratings";
        final long companyId = PortalUtil.getCompanyId(request);
        String currentUrl = request.getRequestURL().toString();
        String event = request.getParameter("event");
        String deleteAll = request.getParameter("deleteAll");
        String nameCol = "Name";
        String rateCol = "Rate";
        String idCol = "Id";
        String dateCol = "CreateDate";

        List<ExpandoTable> allTables = ExpandoTableLocalServiceUtil.getExpandoTables(-1, -1);
        for (ExpandoTable tbl : allTables) {
            if (!className.equals(tbl.getClassName())) {
                continue;
            }
            try {
                if (ExpandoColumnLocalServiceUtil.getColumn(tbl.getTableId(), dateCol) == null) {
                    continue;
                }
            } catch (Exception ex) {
                continue;
            }
            String name = tbl.getName();
            if (name.startsWith("CUSTOM")) continue;
            String evtUrl = currentUrl + "?event=" + HtmlUtil.escapeURL(name);
%>
<p><a href="<%= evtUrl %>">Ratings for <%=name %>
</a></p>
<%
    }


    if (Validator.isNotNull(event)) {
        ExpandoTable table = ExpandoTableLocalServiceUtil.getTable(companyId, className, event);

        if (deleteAll != null) {
            ExpandoValueLocalServiceUtil.deleteTableValues(table.getTableId());

            List<ExpandoRow> rows = ExpandoRowLocalServiceUtil.getRows(companyId, className, event, -1, -1);
            for (ExpandoRow row : rows) {
                ExpandoRowLocalServiceUtil.deleteRow(row.getRowId());
            }
            ExpandoTableLocalServiceUtil.deleteTable(table.getTableId());
            response.sendRedirect(currentUrl);
        }
        // now get the data
        int rowCount = ExpandoRowLocalServiceUtil.getRowsCount(table.getTableId());
        List<ExpandoRow> rows = ExpandoRowLocalServiceUtil.getRows(companyId, className, event, -1, -1);
        List<String> idList = new ArrayList<String>();
        final Map<String, Map<String, Integer>> map = new HashMap<String, Map<String, Integer>>();
        for (ExpandoRow row : rows) {
            long itemClassPK = row.getClassPK();
            String itemId = ExpandoValueLocalServiceUtil.getData(companyId, className, event, idCol, itemClassPK, "");
            String itemRate = ExpandoValueLocalServiceUtil.getData(companyId, className, event, rateCol, itemClassPK, "");
            if (!idList.contains(itemId)) idList.add(itemId);
            if (map.containsKey(itemId)) {
                Map<String, Integer> ratingMap = map.get(itemId);
                if (ratingMap.containsKey(itemRate)) {
                    ratingMap.put(itemRate, ratingMap.get(itemRate) + 1);
                } else {
                    ratingMap.put(itemRate, 1);
                }
            } else {
                Map<String, Integer> newMap = new HashMap<String, Integer>();
                newMap.put(itemRate, 1);
                map.put(itemId, newMap);
            }
        }
%>


<h2><%= event %> Ratings</h2>

<h3>Photostream Summary</h3>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Likes</th>
    </tr>
    <%
        Collections.sort(idList, new Comparator<String>() {
            @Override
            public int compare(String s, String s2) {
                Map<String, Integer> r1 = map.get(s);
                Map<String, Integer> r2 = map.get(s2);

                if (r1 == null && r2 != null) return 1;
                if (r1 != null && r2 == null) return -1;
                if (r1 == null || r2 == null) return 0;

                Integer r1likes = r1.get("like");
                Integer r2likes = r2.get("like");

                if (r1likes == null && r2likes != null) return 1;
                if (r1likes != null && r2likes == null) return -1;
                if (r1likes == null && r2likes == null) return 0;

                return r2likes - r1likes;
            }
        });

        for (String mid : idList) {
            if (!mid.startsWith("PHOTO:")) {
                continue;
            }
            Map<String, Integer> ratingMap = map.get(mid);
            String pid = mid.substring(6);
            String flickrUrl = "http://flickr.com/photos/liferay/" + pid;
    %>
    <tr>
        <td><a target="_blank" href="<%= flickrUrl %>"><%= pid %>
        </a>
        </td>
        <td>
            <%= ratingMap.get("like") %>
        </td>
    </tr>

    <% } %>
</table>

<h3>Session Summary</h3>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Ratings</th>
        <th>Graph</th>
    </tr>
    <% Collections.sort(idList);
        for (String mid : idList) {
            if (mid.startsWith("PHOTO:")) {
                continue;
            }
            int likes = 0;
            int dislikes = 0;
            int totalRatings = 0;
    %>
    <tr>
        <td><%= mid %>
        </td>
        <td>
            <table border="1">
                <tr>
                    <th>Rating</th>
                    <th>Count</th>
                </tr>
                <% Map<String, Integer> ratingMap = map.get(mid);
                    List<String> ratingNames = new ArrayList<String>();
                    ratingNames.addAll(ratingMap.keySet());
                    Collections.sort(ratingNames);
                    for (String ratingName : ratingNames) {
                        Integer ratingCount = ratingMap.get(ratingName);
                        if (ratingName.equals("like")) likes += ratingCount;
                        if (ratingName.equals("dislike")) dislikes += ratingCount;
                        totalRatings += ratingCount;
                %>
                <tr>
                    <td><%=ratingName%>
                    </td>
                    <td><%=ratingCount%>
                    </td>
                </tr>
                <%
                    }
                %>
            </table>
            <%
                long likePercent = Math.round(100.0 * ((double) likes / (double) totalRatings));
                long dislikePercent = Math.round(100.0 * ((double) dislikes / (double) totalRatings));
            %>
        </td>
        <td style="vertical-align: middle;">
            <div style="box-shadow:inset 0 2px 3px #bbb; margin: 0 auto 20px auto; padding: 0; border: 1px solid;border-radius: 4px; width: 300px; height: 20px">
                <div style="text-align: center; float: left;width: <%= likePercent%>%; height: 100%; background-color: green"><%=likePercent > 0 ? likePercent + "%" : ""%>
                </div>
                <div style="text-align: center; float: right;width: <%=dislikePercent%>%; height: 100%; background-color: red"><%=dislikePercent > 0 ? dislikePercent + "%" : ""%>
                </div>
            </div>
        </td>
    </tr>

    <% } %>
</table>

<h1>Just the likes and dislikes</h1>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Likes</th>
        <th>Dislikes</th>
    </tr>
    <% Collections.sort(idList);
        for (String mid : idList) {
            if (mid.startsWith("PHOTO:")) {
                continue;
            }
            int likes = 0;
            int dislikes = 0;
    %>
    <tr>
        <td><%= mid %>
        </td>
        <% Map<String, Integer> ratingMap = map.get(mid);
            List<String> ratingNames = new ArrayList<String>();
            ratingNames.addAll(ratingMap.keySet());
            Collections.sort(ratingNames);
            for (String ratingName : ratingNames) {
                Integer ratingCount = ratingMap.get(ratingName);
                if (ratingName.equals("like")) likes += ratingCount;
                if (ratingName.equals("dislike")) dislikes += ratingCount;
            }
        %>
        <td><%= likes %>
        </td>
        <td><%= dislikes %>
        </td>
    </tr>
    <% } %>
</table>

<h3>Raw Data</h3>
Parameters: id, name, rate

<p>
    Row Count : <%=rowCount%>
</p>

<button onclick="if (confirm('Delete All ratings Results? You won\'t be able to get them back!')) location.href='<%=currentUrl%>?deleteAll=true&event=<%= HtmlUtil.escapeURL(event)%>'">
    Delete All <%= event %> ratings
</button>
<div>
    <table border="1">
        <thead>
        <tr>
        <th>ClassPK</th>
        <th>Name</th>
        <th>Id</th>
        <th>Rate</th>
        <th>Date</th>
        </tr>
        </thead>
        <tbody>
        <%
            for (ExpandoRow row : rows) {
                long itemClassPK = row.getClassPK();

                String itemName = ExpandoValueLocalServiceUtil.getData(companyId, className, event, nameCol, itemClassPK, "");
                String itemId = ExpandoValueLocalServiceUtil.getData(companyId, className, event, idCol, itemClassPK, "");
                String itemRate = ExpandoValueLocalServiceUtil.getData(companyId, className, event, rateCol, itemClassPK, "");
                Date itemDate = ExpandoValueLocalServiceUtil.getData(companyId, className, event, dateCol, itemClassPK, new Date());
        %>
        <tr>
            <td><%=itemClassPK%>
            </td>
            <td><%=itemName%>
            </td>
            <td><%=itemId%>
            </td>
            <td><%=itemRate%>
            </td>
            <td><%=itemDate%>
            </td>
        </tr>
        <%}%>
        </tbody>
    </table>

</div>
<%
    }

} catch (Exception ex) {
%>
Error: <%= ex.getLocalizedMessage() %>"
<%
    }


%>
