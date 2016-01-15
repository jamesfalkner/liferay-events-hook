<%@ page import="com.liferay.events.global.mobile.model.EventContact" %>
<%@ page import="com.liferay.events.global.mobile.service.EventContactLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>

<portlet:defineObjects/>
<liferay-theme:defineObjects/>

<style type="text/css">
    .widebody {
        width: 600px;
    }
</style>

<%
    EventContact eventContact = null;

    long eventContactId = ParamUtil.getLong(request, "eventContactId");

    if (eventContactId > 0) {
        eventContact = EventContactLocalServiceUtil.getEventContact(eventContactId);
    }
%>

<portlet:renderURL var="viewURL">
    <portlet:param name="mvcPath" value="/html/contacts/view.jsp" />
</portlet:renderURL>

<portlet:actionURL name="updateEventContact" var="updateEventContactURL" />

<aui:form action="<%= updateEventContactURL %>" name="updateEventContact">
    <aui:model-context bean="<%= eventContact %>" model="<%= EventContact.class %>" />

    <aui:fieldset>
        <aui:input cssClass="widebody" type="hidden" name="eventContactId"
                   value='<%= eventContact.getEventContactId() %>' />

        <%--<column name="givenName" type="String"/>--%>
        <%--<column name="fullName" type="String"/>--%>
        <%--<column name="secret" json-enabled="false" type="String"/>--%>
        <%--<column name="emailAddress" json-enabled="false" type="String"/>--%>
        <%--<column name="city" type="String"/>--%>
        <%--<column name="country" type="String"/>--%>
        <%--<column name="lat" type="double"/>--%>
        <%--<column name="lng" type="double"/>--%>
        <%--<column name="jobTitle" type="String"/>--%>
        <%--<column name="company" type="String"/>--%>
        <%--<column name="industry" type="String"/>--%>
        <%--<column name="interests"  type="String"/>--%>
        <%--<column name="desires"  type="String"/>--%>
        <%--<column name="expertise"  type="String"/>--%>
        <%--<column name="attendeeType"  type="String"/>--%>
        <%--<column name="interestedIds"  json-enabled="false" type="String"/>--%>
        <%--<column name="picUrl" type="String"/>--%>
        <%--<column name="eventId" type="String"/>--%>
        <%--<column name="verified" json-enabled="false" type="boolean"/>--%>


        <aui:input cssclass="widebody" name="givenName" />
        <aui:input cssClass="widebody" name="fullName" />
        <aui:input cssClass="widebody" helpMessage="Comma-separated list of possible secrets" name="secret" />
        <aui:input cssClass="widebody" name="emailAddress" />
        <aui:input cssClass="widebody" name="city" />
        <aui:input cssClass="widebody" helpMessage="Must be the 2-letter country code (e.g. fr, de, us, pt, es)" name="country" />
        <aui:input cssClass="widebody" name="jobTitle" />
        <aui:input cssClass="widebody" name="company" />
        <aui:input cssClass="widebody" name="industry" />
        <aui:input cssClass="widebody" helpMessage="Be very careful with this field! It must be a JSON-ified string" name="interests" />
        <aui:input cssClass="widebody" helpMessage="Be very careful with this field! It must be a JSON-ified string" name="desires" />
        <aui:input cssClass="widebody" helpMessage="Be very careful with this field! It must be a JSON-ified string" name="expertise" />
        <aui:input cssClass="widebody" name="attendeeType" />
        <aui:input cssClass="widebody" name="picUrl" />
        <aui:input cssClass="widebody" name="eventId" />

    </aui:fieldset>

    <aui:button-row>
        <aui:button type="submit"></aui:button>
        <aui:button type="cancel" onClick="<%= viewURL %>"></aui:button>
    </aui:button-row>
</aui:form>

