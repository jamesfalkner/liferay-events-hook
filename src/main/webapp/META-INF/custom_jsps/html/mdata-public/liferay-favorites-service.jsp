<%@ include file="sig.jspf" %>

<%
    try {
        String event = request.getParameter("event");
        String id = request.getParameter("id");
        String favorites = request.getParameter("favorites");
        final long companyId = PortalUtil.getCompanyId(request);

        if (Validator.isNull(event) || Validator.isNull(id) || Validator.isNull(favorites)) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid signature.");
            return;
        }

        String className = "com.liferay.events.Favorites";
        int stringColumnType = 15;
        int dateColumnType = 3;

        String idCol = "id";
        String favoritesCol = "favorites";
        String dateCol = "CreateDate";


        ExpandoTable table;
        ExpandoColumn favoritesColObj;


        try {
            table = ExpandoTableLocalServiceUtil.getTable(companyId, className, event);
            ExpandoColumnLocalServiceUtil.getColumn(table.getTableId(), dateCol);
            favoritesColObj = ExpandoColumnLocalServiceUtil.getColumn(table.getTableId(), favoritesCol);
            ExpandoColumnLocalServiceUtil.getColumn(table.getTableId(), idCol);
        } catch (Exception ex) {
            table = ExpandoTableLocalServiceUtil.addTable(companyId, className, event);
            ExpandoColumnLocalServiceUtil.addColumn(table.getTableId(), dateCol, dateColumnType);
            favoritesColObj = ExpandoColumnLocalServiceUtil.addColumn(table.getTableId(), favoritesCol, stringColumnType);
            ExpandoColumnLocalServiceUtil.addColumn(table.getTableId(), idCol, stringColumnType);

        }

        Date date = new Date();
        long classPK = (event + id).hashCode();

        ExpandoValue curVal = ExpandoValueLocalServiceUtil.getValue(table.getTableId(), favoritesColObj.getColumnId(), classPK);
        if (curVal != null) {
            curVal.setString(favorites);
            ExpandoValueLocalServiceUtil.updateExpandoValue(curVal);
        } else {
            ExpandoValueLocalServiceUtil.addValue(companyId, className, event, dateCol, classPK, date);
            ExpandoValueLocalServiceUtil.addValue(companyId, className, event, idCol, classPK, id);
            ExpandoValueLocalServiceUtil.addValue(companyId, className, event, favoritesCol, classPK, favorites);
        }
%> { "stat" : "ok" } <%
} catch (Exception ex) {
%>
{ "stat": "error: <%= ex.getLocalizedMessage() %>" }
<%
    }
%>
