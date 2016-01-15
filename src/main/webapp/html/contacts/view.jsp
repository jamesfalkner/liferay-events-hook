<%@ page import="com.liferay.portal.kernel.util.StringUtil" %>
<%@ page import="com.liferay.events.global.mobile.service.EventContactLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>
<%@ page import="com.liferay.events.global.mobile.service.MatchLocalServiceUtil" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>

<portlet:defineObjects/>
<liferay-theme:defineObjects/>

<portlet:actionURL name="randomData" var="randomDataURL"/>

<h1>Contacts</h1>
<liferay-ui:search-container emptyResultsMessage="There are no visits to display">
    <liferay-ui:search-container-results
            results="<%= EventContactLocalServiceUtil.getEventContacts(searchContainer.getStart(), searchContainer.getEnd()) %>"
            total="<%= EventContactLocalServiceUtil.getEventContactsCount() %>"
            />

    <liferay-ui:search-container-row
            className="com.liferay.events.global.mobile.model.EventContact"
            keyProperty="eventContactId"
            modelVar="eventContact" escapedModel="<%= true %>"
            >

        <liferay-ui:search-container-column-text
                name="Event ID"
                value="<%= HtmlUtil.escape(eventContact.getEventId()) %>"
                />
        <liferay-ui:search-container-column-text
                name="Verified"
                value="<%= StringUtil.valueOf(eventContact.getVerified()) %>"
                />
        <liferay-ui:search-container-column-text
                name="Full Name"
                value='<%= HtmlUtil.escape(eventContact.getFullName() + " (" + eventContact.getAttendeeType() + ")") %>'
                />
        <liferay-ui:search-container-column-text
                name="Location"
                value='<%= HtmlUtil.escape(eventContact.getCity() + ", " + eventContact.getCountry()) %>'
                />
        <liferay-ui:search-container-column-text
                name="Job & Company"
                value='<%= HtmlUtil.escape(eventContact.getJobTitle() + ", " + eventContact.getCompany()) %>'
                />
        <liferay-ui:search-container-column-text
                name="Contact ID"
                value="<%= StringUtil.valueOf(eventContact.getEventContactId()) %>"
                />
        <%--<liferay-ui:search-container-column-text--%>
                <%--name="Secret"--%>
                <%--value="<%= HtmlUtil.escape(eventContact.getSecret()) %>"--%>
                <%--/>--%>

        <liferay-ui:search-container-column-text
                name="Picture"
                >

            <img style="width: 30px; height: 30px;" src="<%= eventContact.getPicUrl()%>"/>
        </liferay-ui:search-container-column-text>

        <liferay-ui:search-container-column-text
                name="Email"
                value="<%= HtmlUtil.escape(eventContact.getEmailAddress()) %>"
                />

        <liferay-ui:search-container-column-text
                name="Interests"
                value="<%= eventContact.getInterests() %>"
                />
        <liferay-ui:search-container-column-text
                name="Desires"
                value="<%= eventContact.getDesires() %>"
                />
        <liferay-ui:search-container-column-text
                name="Expertise"
                value="<%= eventContact.getExpertise() %>"
                />
        <liferay-ui:search-container-column-text
                name="Interested IDs"
                value="<%= HtmlUtil.escape(eventContact.getInterestedIds()) %>"
                />

        <liferay-ui:search-container-column-date
                name="Created"
                value="<%= eventContact.getCreateDate() %>"
                />

        <liferay-ui:search-container-column-jsp path="/html/contacts/actions.jsp" />
    </liferay-ui:search-container-row>

    <liferay-ui:search-iterator/>
</liferay-ui:search-container>

<h1>Matches</h1>
<liferay-ui:search-container emptyResultsMessage="There are no matches to display">
    <liferay-ui:search-container-results
            results="<%=MatchLocalServiceUtil.getMatchs(searchContainer.getStart(), searchContainer.getEnd()) %>"
            total="<%= MatchLocalServiceUtil.getMatchsCount() %>"
            />

    <liferay-ui:search-container-row
            className="com.liferay.events.global.mobile.model.Match"
            keyProperty="matchId"
            modelVar="match" escapedModel="<%= true %>"
            >

        <liferay-ui:search-container-column-text
                name="Event ID"
                value="<%= HtmlUtil.escape(match.getEventId()) %>"
                />
        <liferay-ui:search-container-column-text
                name="Contact 1"
                >
            <em><%= EventContactLocalServiceUtil.getEventContact(match.getContactId1()).getFullName() %></em>
            <img style="width: 50px; height: 50px;" src="<%= EventContactLocalServiceUtil.getEventContact(match.getContactId1()).getPicUrl() %>"/>
        </liferay-ui:search-container-column-text>


        <liferay-ui:search-container-column-text
                name="Contact 2"
                >
            <em><%= EventContactLocalServiceUtil.getEventContact(match.getContactId2()).getFullName() %></em>
            <img style="width: 50px; height: 50px;" src="<%= EventContactLocalServiceUtil.getEventContact(match.getContactId2()).getPicUrl() %>" />
        </liferay-ui:search-container-column-text>

        <liferay-ui:search-container-column-date
                name="Date"
                value="<%= match.getCreateDate() %>"
                />


    </liferay-ui:search-container-row>

    <liferay-ui:search-iterator/>
</liferay-ui:search-container>


<h1>Generate Fake Data</h1>
<aui:form action='<%=randomDataURL %>' method="post">
    <aui:fieldset>
        <aui:input inlineField="<%= true %>" label="Event ID" name='eventId' value="lrfs2015"/>
        <aui:input inlineField="<%= true %>" label="Number of Contacts" name='amount' value="1000"/>
        <aui:select helpMessage="Fake attendees can either be pre-verified (so they show up for matching), or be unverified and require sign-in first, or random" name="validationStyle" label="Verified Flag Setting">
            <aui:option selected="true" value="unverified">Unverified</aui:option>
            <aui:option selected="false" value="verified">Verified</aui:option>
            <aui:option selected="false" value="random">Random</aui:option>
        </aui:select>
        <aui:input helpMessage="Check this to clear all attendee data first, before generating new data"  type="checkbox" label="Clear All" name="clear" value="false"/>
        <aui:button type="submit" value="Generate Contacts"/>
    </aui:fieldset>
</aui:form>

<h1>Check Validity</h1>
<em>Click here to fix up blank desires and expertise</em>
<portlet:actionURL name="checkValidity" var="checkValidityURL"/>
<aui:form action='<%=checkValidityURL %>' method="post">
    <aui:button type="submit" value="Re-Verify Validity"/>
</aui:form>

<h1>Wipe event data</h1>
<em>Deletes all event data associated with a specific event</em>
<portlet:actionURL name="deleteEventData" var="deleteEventDataURL"/>
<aui:form action='<%=deleteEventDataURL %>' method="post">
    <aui:input inlineField="<%= true %>" label="Event ID" name="eventId" value=""/>
    <aui:button type="submit" value="Delete Specific Event Data"/>
</aui:form>


