<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@ page import="com.liferay.portal.kernel.util.StringPool" %>
<%@ page import="com.liferay.portal.kernel.util.Constants" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0" %>
<%@ taglib prefix="liferay-portlet" uri="http://liferay.com/tld/portlet" %>

<portlet:defineObjects/>
<liferay-theme:defineObjects/>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />

<%
    String answerBaseUrl = GetterUtil.getString(portletPreferences.getValue("answerBaseUrl", ""));
%>

<aui:form action="<%= configurationURL %>" method="post" name="fm">
    <aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />

    <blockquote>
        This should be set to a full canonical URL that points to a page that hosts the
        <code>poll-answer.ftl</code> template. This url will be appended with <code>?questionId=id</code> to form
        a full URL to a webpage on which each question can be answered, which is then passed to google URL
        shortener.
    </blockquote>
    <aui:input name="preferences--answerBaseUrl--" type="text" value="<%= answerBaseUrl %>" />

    <aui:button-row>
        <aui:button type="submit" />
    </aui:button-row>
</aui:form>
