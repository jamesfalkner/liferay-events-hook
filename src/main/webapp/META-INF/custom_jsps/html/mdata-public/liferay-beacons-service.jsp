<%@ include file="sig.jspf" %>

<%
    try {

        String event = request.getParameter("event");
        String id = request.getParameter("id");
        String currentRegions = request.getParameter("currentRegions");
        String currentBeacons = request.getParameter("currentBeacons");
        final long companyId = PortalUtil.getCompanyId(request);

        if (Validator.isNull(event) || Validator.isNull(id)) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid signature.");
            return;
        }

        if (currentBeacons == null) {
            currentBeacons = "[]";
        }

        if (currentRegions == null) {
            currentRegions = "[]";
        }
        String className = "com.liferay.events.BeaconData";
        int stringColumnType = 15;
        int dateColumnType = 3;

        String idCol = "id";
        String regionsCol = "regions";
        String beaconsCol = "beacons";
        String dateCol = "date";


        ExpandoTable table;
        ExpandoColumn regionsColObj;
        ExpandoColumn beaconsColObj;


        try {
            table = ExpandoTableLocalServiceUtil.getTable(companyId, className, event);
            ExpandoColumnLocalServiceUtil.getColumn(table.getTableId(), dateCol);
            regionsColObj = ExpandoColumnLocalServiceUtil.getColumn(table.getTableId(), regionsCol);
            beaconsColObj = ExpandoColumnLocalServiceUtil.getColumn(table.getTableId(), beaconsCol);
            ExpandoColumnLocalServiceUtil.getColumn(table.getTableId(), idCol);
        } catch (Exception ex) {
            table = ExpandoTableLocalServiceUtil.addTable(companyId, className, event);
            ExpandoColumnLocalServiceUtil.addColumn(table.getTableId(), dateCol, dateColumnType);
            beaconsColObj = ExpandoColumnLocalServiceUtil.addColumn(table.getTableId(), beaconsCol, stringColumnType);
            regionsColObj = ExpandoColumnLocalServiceUtil.addColumn(table.getTableId(), regionsCol, stringColumnType);
            ExpandoColumnLocalServiceUtil.addColumn(table.getTableId(), idCol, stringColumnType);

        }

        Date date = new Date();
        long classPK = (event + id + date.getTime()).hashCode();

        ExpandoValue curBeaconVal = ExpandoValueLocalServiceUtil.getValue(table.getTableId(), beaconsColObj.getColumnId(), classPK);
        ExpandoValue curRegionVal = ExpandoValueLocalServiceUtil.getValue(table.getTableId(), regionsColObj.getColumnId(), classPK);
        if (curBeaconVal != null) {
            curBeaconVal.setString(currentBeacons);
            curRegionVal.setString(currentRegions);
            ExpandoValueLocalServiceUtil.updateExpandoValue(curBeaconVal);
            ExpandoValueLocalServiceUtil.updateExpandoValue(curRegionVal);
        } else {
            System.out.println("adding new regions and beacons " + currentRegions + "|" + currentBeacons);
            ExpandoValueLocalServiceUtil.addValue(companyId, className, event, dateCol, classPK, date);
            ExpandoValueLocalServiceUtil.addValue(companyId, className, event, idCol, classPK, id);
            ExpandoValueLocalServiceUtil.addValue(companyId, className, event, beaconsCol, classPK, currentBeacons);
            ExpandoValueLocalServiceUtil.addValue(companyId, className, event, regionsCol, classPK, currentRegions);
        }

%> { "stat" : "ok" } <%
} catch (Exception ex) {
%>
{ "stat": "error: <%= ex.getLocalizedMessage() %>" }
<%
    }
%>
