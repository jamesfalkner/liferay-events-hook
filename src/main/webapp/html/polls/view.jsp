<%@ page import="com.liferay.events.global.mobile.service.EventPollQuestionLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>
<%@ page import="com.liferay.portal.kernel.util.StringUtil" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ page import="com.liferay.events.global.mobile.service.EventPollAnswerLocalServiceUtil" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.TimeZone" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>

<portlet:defineObjects/>
<liferay-theme:defineObjects/>

<h1>Questions</h1>

<aui:button-row>

    <portlet:renderURL var="addQuestionURL">
        <portlet:param name="mvcPath"
                       value="/html/polls/edit.jsp" />
    </portlet:renderURL>

    <aui:button onClick="<%=addQuestionURL %>"
                value="Add New Question" />

</aui:button-row>


<%
    List<String> allEvents = EventPollQuestionLocalServiceUtil.getAllEvents();
    SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM d yyyy @ HH:mm:ss z");
    for (String eventId : allEvents) {
%>

<h2><%= eventId %> Polls</h2>
<liferay-ui:search-container emptyResultsMessage="There are no questions to display">
    <liferay-ui:search-container-results
            results="<%= EventPollQuestionLocalServiceUtil.getAllQuestionsForEvent(eventId, searchContainer.getStart(), searchContainer.getEnd()) %>"
            total="<%= EventPollQuestionLocalServiceUtil.getAllQuestionsForEventCount(eventId) %>"
            />

    <liferay-ui:search-container-row
            className="com.liferay.events.global.mobile.model.EventPollQuestion"
            keyProperty="questionId"
            modelVar="question" escapedModel="<%= true %>"
            >

        <liferay-ui:search-container-column-text
                name="Picture"
                >

            <img style="width: 50px; height: 50px;" src="<%=Validator.isNotNull(question.getPicUrl()) ? question.getPicUrl() : "http://www.gravatar.com/avatar/20d50.jpg" %>"/>
        </liferay-ui:search-container-column-text>

        <liferay-ui:search-container-column-text
                name="Question Sponsor"
                value="<%= HtmlUtil.escape(question.getSponsorName()) %>"
                />
        <liferay-ui:search-container-column-text
                name="Enabled"
                >
            <code style='color: <%= question.getEnabled() ? "green" : "red"%>'><%= question.getEnabled() ? "ENABLED" : "DISABLED" %></code>&nbsp;&nbsp;
            <portlet:actionURL name="toggleEnable" var="toggleEnableURL">
                <portlet:param name="questionId"
                               value="<%= String.valueOf(question.getQuestionId()) %>"/>
            </portlet:actionURL>
            <a href="<%= toggleEnableURL %>"><%= question.getEnabled() ? "Disable" : "Enable"%></a>
        </liferay-ui:search-container-column-text>

        <%

            if (question.getAutoEnable()) {
                sdf.setTimeZone(TimeZone.getTimeZone(question.getEnableTriggerTimezone()));
            }

        %>
        <liferay-ui:search-container-column-text
                name="Auto Enable"
                >
            <span style='background-color: <%= question.getAutoEnable() ? "#ffdb99" : "transparent" %>; color: <%= question.getAutoEnable() ? "black" : "gray"%>'><%= question.getAutoEnable() ? sdf.format(question.getEnableTriggerDate()) : "DISABLED" %></span>
        </liferay-ui:search-container-column-text>



        <liferay-ui:search-container-column-text
                name="# of Answers"
                value='<%= String.valueOf(EventPollAnswerLocalServiceUtil.countAnswers(question.getQuestionId()))%>'
                />

        <liferay-ui:search-container-column-text
                name="Question"
                value='<%=(question.getQuestion()) %>'
                />
        <liferay-ui:search-container-column-text
                name="Short Title"
                value='<%=(question.getShortTitle()) %>'
                />
        <liferay-ui:search-container-column-text
                name="Type"
                value='<%= StringUtil.valueOf(question.getQuestionType()) %>'
                />
        <liferay-ui:search-container-column-text
                name="Chart Type"
                value='<%= StringUtil.valueOf(question.getChartType()) %>'
                />
        <liferay-ui:search-container-column-text
                name="Ask For ID?"
                value='<%= StringUtil.valueOf(question.getAskForId()) %>'
                />

        <liferay-ui:search-container-column-text
                name="ID Intro"
                value='<%= StringUtil.valueOf(question.getIdIntro()) %>'
                />
        <liferay-ui:search-container-column-text
                name="Choices"
                >
            <%= (question.getChoices())%>
                </liferay-ui:search-container-column-text>
        <liferay-ui:search-container-column-text
                name="Anonymous Results?"
                value='<%= StringUtil.valueOf(question.getAnonymousResults()) %>'
                />
        <liferay-ui:search-container-column-text
                name="Show Response Count?"
                value='<%= StringUtil.valueOf(question.getShowResponseCount()) %>'
                />
        <liferay-ui:search-container-column-date
                name="Created"
                value="<%= question.getCreateDate() %>"
                />

        <liferay-ui:search-container-column-jsp path="/html/polls/actions.jsp" />
    </liferay-ui:search-container-row>

    <liferay-ui:search-iterator/>
</liferay-ui:search-container>
<br><br>
<% } %>

