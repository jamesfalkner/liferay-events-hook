<%@ page import="com.liferay.events.global.mobile.model.EventContact" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.security.permission.ActionKeys" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>

<portlet:defineObjects/>
<liferay-theme:defineObjects/>


<%
    String mvcPath = ParamUtil.getString(request, "mvcPath");

    ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

    EventContact entry = (EventContact) row.getObject();
%>

<liferay-ui:icon-menu>

    <portlet:renderURL var="editURL">
        <portlet:param name="eventContactId"
                       value="<%= String.valueOf(entry.getEventContactId()) %>"/>
        <portlet:param name="mvcPath" value="/html/contacts/edit.jsp"/>
    </portlet:renderURL>

    <liferay-ui:icon image="edit" message="Edit"
                     url='<%= editURL.toString() %>'/>


    <portlet:actionURL name="deleteEntry" var="deleteURL">
        <portlet:param name="eventContactId"
                       value="<%= String.valueOf(entry.getEventContactId()) %>"/>
    </portlet:actionURL>

    <liferay-ui:icon-delete url="<%=deleteURL.toString() %>"/>

</liferay-ui:icon-menu>
