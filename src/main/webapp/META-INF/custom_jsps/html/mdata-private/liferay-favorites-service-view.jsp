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

<h1>Liferay Events Mobile App Favorited Sessions</h1>
<em>Click on an event below to see favorites data for that event.</em>
<hr>

<%
try {
	String event = request.getParameter("event");
	String deleteAll = request.getParameter("deleteAll");
	final long companyId = PortalUtil.getCompanyId(request);

	String className = "com.liferay.events.Favorites";
	String currentUrl = request.getRequestURL().toString();

	String idCol = "id";
	String favoritesCol = "favorites";
	String dateCol = "CreateDate";

	List<ExpandoTable> allTables = ExpandoTableLocalServiceUtil.getExpandoTables(-1, -1);
	for (ExpandoTable tbl: allTables) {
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
<p><a href="<%= evtUrl %>">Favorites for <%=name %></a></p>
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

        List<ExpandoValue> allFavs = ExpandoValueLocalServiceUtil.getColumnValues(companyId, className, table.getName(), favoritesCol, -1, -1);
		final Map<String, Integer> favMap = new HashMap<String, Integer>();

        int nonZeroCount = 0;

		for (ExpandoValue favVal : allFavs) {
			String favStr = favVal.getString();
			JSONArray favArr = JSONFactoryUtil.createJSONArray(favStr);
			int len = favArr.length();
            if (len > 0) nonZeroCount++;
			for (int i = 0; i < len; i++) {
				String nextFav = favArr.getString(i);
				if (favMap.containsKey(nextFav)) {
					favMap.put(nextFav, favMap.get(nextFav) + 1);
				} else {
					favMap.put(nextFav, 1);
				}
			}
		}

		List<String> sortedList = new SortedArrayList<String>();
		sortedList.addAll(favMap.keySet());

		%>

<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="//code.highcharts.com/highcharts.js"></script>
<script src="//code.highcharts.com/modules/exporting.js"></script>

<div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>

<h3><%= allFavs.size()%> total records</h3>
<h3><%= nonZeroCount %> non-empty favoritors</h3>

		<button onclick="if (confirm('Delete All favorites Results? You won\'t be able to get them back!')) location.href='<%=currentUrl%>?deleteAll=true&event=<%= HtmlUtil.escapeURL(event)%>'">Delete All <%= event %> favorites</button>
		<table border="1">
			<tr>
				<th>Session</th>
				<th>Favorited Count</th>
			</tr>
			<%
				for (String mid : sortedList) {
			%>
			<tr>
				<td><%= mid %>
				</td>
				<td>
					<%= favMap.get(mid) %>
				</td>
			</tr>

			<% } %>
		</table>

<h3>All favorite records</h3>
<table border="1">
    <tr>
        <th>Date</th>
        <th>Date (ms)</th>
        <th>ID</th>
        <th>Recorded Favorites</th>
    </tr>
    <%
        for (ExpandoRow row : ExpandoRowLocalServiceUtil.getRows(companyId, className, table.getName(), -1, -1)) {
            long pk = row.getClassPK();
            String allId = ExpandoValueLocalServiceUtil.getData(companyId, className, table.getName(), idCol, pk, "");
            Date allDate = ExpandoValueLocalServiceUtil.getData(companyId, className, table.getName(), dateCol, pk, new Date());
            String allFav = ExpandoValueLocalServiceUtil.getData(companyId, className, table.getName(), favoritesCol, pk, "");
    %>
    <tr>
        <td><%= allDate %></td>
        <td><%= allDate.getTime() %></td>
        <td><%= allId %></td>
        <td><%= HtmlUtil.escape(allFav) %></td>
    </tr>

    <% } %>
</table>


        <script type="text/javascript">
            $(function () {
                $('#container').highcharts({
                    chart: {
                        type: 'column',
                        margin: [ 50, 50, 100, 80]
                    },
                    title: {
                        text: 'Favorites for <%= event %>'
                    },
                    xAxis: {
                        categories: [

                                <%
                                Iterator<String> it = sortedList.iterator();
                                while (it.hasNext()) {
                                    %> '<%= HtmlUtil.escapeJS(it.next()) %>' <%

                                    if (it.hasNext()) { %>,<% }
                                }
                                %>
                        ],
                        labels: {
                            rotation: -45,
                            align: 'right',
                            style: {
                                fontSize: '8px',
                                fontFamily: 'Verdana, sans-serif'
                            }
                        }
                    },
                    yAxis: {
                        min: 0,
                        title: {
                            text: 'Favorites Count'
                        }
                    },
                    legend: {
                        enabled: false
                    },
                    series: [{
                        name: 'Favorites Count',
                        data: [


                            <%
                            it = sortedList.iterator();
                            while (it.hasNext()) {
                            %> <%= favMap.get(it.next()) %> <%

                                    if (it.hasNext()) { %>,<% }
                                }
                                %>



                        ],
                        dataLabels: {
                            enabled: true,
                            rotation: -90,
                            color: '#FFFFFF',
                            align: 'right',
                            x: 4,
                            y: 10,
                            style: {
                                fontSize: '13px',
                                fontFamily: 'Verdana, sans-serif',
                                textShadow: '0 0 3px black'
                            }
                        }
                    }]
                });
            });



        </script>


		<%
	}

} catch (Exception ex) {
%>
	Error: <%= ex.getLocalizedMessage() %>"
<%
}
%>
