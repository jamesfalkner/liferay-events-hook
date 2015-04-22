<%@ include file="init.jsp" %>

<h1>Liferay Events Mobile App Beacon Data</h1>
<em>Click on an event below to see beacon data for that event.</em>
<hr>

<%
    try {
        String event = request.getParameter("event");
        final long companyId = PortalUtil.getCompanyId(request);

        String className = "com.liferay.events.BeaconData";
        String currentUrl = request.getRequestURL().toString();

        List<ExpandoTable> allTables = ExpandoTableLocalServiceUtil.getExpandoTables(-1, -1);
        for (ExpandoTable tbl: allTables) {
            if (!className.equals(tbl.getClassName())) {
                continue;
            }

            String name = tbl.getName();
            String evtUrl = currentUrl + "?event=" + HtmlUtil.escapeURL(name);
%>

<p><a href="<%= evtUrl %>">Raw Beacon Data for <%=name %></a></p>
<%
    }

    if (Validator.isNotNull(event)) {

        ExpandoTable table = ExpandoTableLocalServiceUtil.getTable(companyId, className, event);
        List<ExpandoRow> allRows = ExpandoRowLocalServiceUtil.getRows(companyId, className, event, -1, -1);

%>
<h3><%= allRows.size()%> total pings</h3>

<table border="1">
    <tr><th>Timestamp</th><th>Device ID</th><th>Regions Seen</th><th>Beacons Seen</th></tr>

<%

    for (ExpandoRow row : allRows) {
        Date rowDate = ExpandoValueLocalServiceUtil.getValue(companyId, className, table.getName(), "date", row.getClassPK()).getDate();
        String rowId = ExpandoValueLocalServiceUtil.getValue(companyId, className, table.getName(), "id", row.getClassPK()).getString();
        String rowRegions = ExpandoValueLocalServiceUtil.getValue(companyId, className, table.getName(), "regions", row.getClassPK()).getString();
        String rowBeacons = ExpandoValueLocalServiceUtil.getValue(companyId, className, table.getName(), "beacons", row.getClassPK()).getString();

        %><tr><td><%=rowDate%></td><td><%=rowId%></td><td><%=rowRegions%></td><td><%=rowBeacons%></td></tr> <%

    }
%> </table> <%
    }

} catch (Exception ex) {
%>
Error: <%= ex.getLocalizedMessage() %>"
<%
    }
%>
