<%@ page import="com.liferay.events.global.mobile.model.EventPollQuestion" %>
<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>

<portlet:defineObjects/>
<liferay-theme:defineObjects/>


<%
    ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

    EventPollQuestion q = (EventPollQuestion) row.getObject();
%>

<liferay-ui:icon-menu>

    <portlet:renderURL var="editQuestionURL">
        <portlet:param name="questionId"
                       value="<%= String.valueOf(q.getQuestionId()) %>"/>
        <portlet:param name="mvcPath" value="/html/polls/edit.jsp"/>
    </portlet:renderURL>

    <liferay-ui:icon image="edit" message="Edit"
                     url='<%=editQuestionURL %>'/>

    <portlet:renderURL var="addAnswerURL">
        <portlet:param name="questionId"
                       value="<%= String.valueOf(q.getQuestionId()) %>"/>
        <portlet:param name="mvcPath" value="/html/polls/answer.jsp"/>
    </portlet:renderURL>

    <liferay-ui:icon image="reply" message="Answer"
                     url='<%=addAnswerURL %>'/>

    <portlet:resourceURL var="exportCSVURL">
        <portlet:param name="cmd" value="exportAnswersCSV" />
        <portlet:param name="questionId"
                       value="<%= String.valueOf(q.getQuestionId()) %>"/>
    </portlet:resourceURL>

    <liferay-ui:icon image="export" message="Export Answers to CSV"
                     url='<%=exportCSVURL %>'/>

    <portlet:resourceURL var="exportXLSXURL">
        <portlet:param name="cmd" value="exportAnswersXLSX" />
        <portlet:param name="questionId"
                       value="<%= String.valueOf(q.getQuestionId()) %>"/>
    </portlet:resourceURL>

    <liferay-ui:icon image="export" message="Export Answers to Excel (XLSX)"
                     url='<%=exportXLSXURL %>'/>


    <portlet:actionURL name="deleteEntry" var="deleteURL">
        <portlet:param name="questionId"
                       value="<%= String.valueOf(q.getQuestionId()) %>"/>
    </portlet:actionURL>

    <liferay-ui:icon image="delete" message="Delete Question"
                     url='<%=deleteURL %>'/>

    <portlet:actionURL name="generateChoices" var="generateChoicesURL">
        <portlet:param name="questionId"
                       value="<%= String.valueOf(q.getQuestionId()) %>"/>
    </portlet:actionURL>

    <liferay-ui:icon message="Generate Fake Answers" url="<%=generateChoicesURL %>"/>

    <portlet:actionURL name="deleteAnswers" var="deleteAnswersURL">
        <portlet:param name="questionId"
                       value="<%= String.valueOf(q.getQuestionId()) %>"/>
    </portlet:actionURL>

    <liferay-ui:icon-delete message="Delete all Answers" url="<%=deleteAnswersURL %>"/>


</liferay-ui:icon-menu>
