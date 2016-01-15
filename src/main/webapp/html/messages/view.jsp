<%@ page import="com.liferay.events.global.mobile.service.EventContactLocalServiceUtil" %>
<%@ page import="com.liferay.events.global.mobile.service.MessageLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>
<%@ page import="com.liferay.portal.kernel.util.StringUtil" %>
<%@ page import="com.liferay.events.global.mobile.Utils" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>

<portlet:defineObjects/>
<liferay-theme:defineObjects/>

<portlet:actionURL name="addMessage" var="addURL"/>
<portlet:actionURL name="toggle" var="toggleURL"/>

<h1>Messages</h1>
<liferay-ui:search-container emptyResultsMessage="There are no messages to display">
    <liferay-ui:search-container-results
            results="<%= MessageLocalServiceUtil.getMessages(searchContainer.getStart(), searchContainer.getEnd()) %>"
            total="<%= MessageLocalServiceUtil.getMessagesCount() %>"
            />

    <liferay-ui:search-container-row
            className="com.liferay.events.global.mobile.model.MessageModel"
            keyProperty="messageId"
            modelVar="msg" escapedModel="<%= true %>"
            >

        <liferay-ui:search-container-column-text
                name="Event"
                value="<%= StringUtil.valueOf(msg.getEventId()) %>"
                />

        <liferay-ui:search-container-column-text
                name="Message ID"
                value="<%= StringUtil.valueOf(msg.getMessageId()) %>"
                />
        <liferay-ui:search-container-column-date
                name="Date"
                value="<%= msg.getCreateDate() %>"
                />
        <liferay-ui:search-container-column-text
                name="From"
                value='<%= HtmlUtil.escape(EventContactLocalServiceUtil.getEventContact(msg.getFromId()).getFullName()) + " (" + String.valueOf(msg.getFromId()) + ")" %>'
                />
        <liferay-ui:search-container-column-text
                name="To"
                value='<%= HtmlUtil.escape(EventContactLocalServiceUtil.getEventContact(msg.getToId()).getFullName()) + " (" + String.valueOf(msg.getToId()) + ")" %>'
                />

        <liferay-ui:search-container-column-text
                name="Read?"
                value="<%= StringUtil.valueOf(msg.getRead()) %>"
                />

        <liferay-ui:search-container-column-text
                name="Read?"
                title="THE TITLE"
                value="<%= StringUtil.valueOf(StringUtil.shorten(msg.getContent(), 300)) %>"
                />

    </liferay-ui:search-container-row>

    <liferay-ui:search-iterator/>
</liferay-ui:search-container>

<aui:form action='<%=addURL %>' method="post">
    <aui:fieldset>
        <aui:input label="Event ID" name='eventId' value="lrfs2015"/>
        <aui:input label="To ID" name='toId' value=""/>
        <aui:input label="From ID" name='fromId' value=""/>
        <aui:input label="Message" name='content' value=""/>
        <aui:button type="submit" value="Add Message"/>
    </aui:fieldset>
</aui:form>

<p>Services currently: <%= Utils.flag ? "ON" : "OFF" %></p>

<aui:form action='<%=toggleURL %>' method="post">
        <aui:button type="submit" value="Toggle Service Availability"/>
</aui:form>

