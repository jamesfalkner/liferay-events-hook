<%@ page import="com.liferay.events.global.mobile.model.EventPollQuestion" %>
<%@ page import="com.liferay.events.global.mobile.service.EventPollQuestionLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.events.global.mobile.model.PollQuestionType" %>
<%@ page import="com.liferay.portal.kernel.json.JSONArray" %>
<%@ page import="com.liferay.portal.kernel.json.JSONFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<portlet:defineObjects/>
<liferay-theme:defineObjects/>

<style type="text/css">
    .widebody {
        width: 600px;
    }
</style>

<%
    EventPollQuestion q = null;

    long questionId = ParamUtil.getLong(request, "questionId");

    if (questionId > 0) {
        q = EventPollQuestionLocalServiceUtil.getEventPollQuestion(questionId);
    }
%>

<portlet:renderURL var="viewURL">
    <portlet:param name="mvcPath" value="/html/polls/view.jsp"/>
</portlet:renderURL>

<portlet:actionURL name="addAnswer" var="addAnswerURL"/>

<h2>Question: <%= q.getQuestion() %></h2>
<aui:form id="addAnswerForm" action="<%= addAnswerURL %>" name="addAnswerForm" onSubmit="mergeAnswers();">

    <aui:fieldset>

        <c:choose>
            <c:when test="<%= q.getQuestionType().equalsIgnoreCase(PollQuestionType.QUESTION_TYPE_SINGLE.getTypeName()) %>">
                <aui:select label="Your Answer" name="answer">
                    <%
                        JSONArray arr = JSONFactoryUtil.createJSONArray(q.getChoices());
                        for (int i = 0; i < arr.length(); i++) {
                            String choice = arr.getString(i);
                            %> <aui:option value="<%= choice %>" label="<%= choice %>" /> <%
                        }
                    %>
                </aui:select>

            </c:when>
            <c:when test="<%= q.getQuestionType().equalsIgnoreCase(PollQuestionType.QUESTION_TYPE_MULTIPLE.getTypeName()) %>">
                <aui:field-wrapper name="thewrapper">
                    <%
                        JSONArray arr = JSONFactoryUtil.createJSONArray(q.getChoices());
                        for (int i = 0; i < arr.length(); i++) {
                            String choice = arr.getString(i);
                    %> <aui:input name='<%= i + "_multianswer" %>' type="checkbox" inlineLabel="right" label="<%= choice %>" /> <%
                    }
                     %>

                </aui:field-wrapper>
            </c:when>
            <c:when test="<%= q.getQuestionType().equalsIgnoreCase(PollQuestionType.QUESTION_TYPE_TEXT.getTypeName()) %>">
                <aui:input label="Your Answer" name="answer" type="textarea" />
            </c:when>
            <c:when test="<%= q.getQuestionType().equalsIgnoreCase(PollQuestionType.QUESTION_TYPE_RANKING.getTypeName()) %>">
                <aui:input label="Your Answer" name="answer" type="text" />

            </c:when>
            <c:when test="<%= q.getQuestionType().equalsIgnoreCase(PollQuestionType.QUESTION_TYPE_RATING.getTypeName()) %>">
                <aui:input label="Your Answer" name="answer" type="text" />

            </c:when>
            <c:otherwise>
                <h3>Not a valid question type</h3>
            </c:otherwise>
        </c:choose>


        <aui:input cssClass="widebody" type="hidden" name="questionId"
                   value='<%= q.getQuestionId() %>'/>
        <aui:input cssClass="widebody" type="hidden" name="clientId"
                   value='TEST_CONSOLE'/>
    </aui:fieldset>

    <aui:button-row>
        <aui:button type="submit" value="save"></aui:button>
        <aui:button type="cancel" onClick="<%= viewURL %>"></aui:button>
    </aui:button-row>
</aui:form>

<script type="text/javascript">

    function addHidden(theForm, key, value) {
        // Create a hidden input element, and append it to the form:
        var input = document.createElement('input');
        input.type = 'hidden';
        input.name = key;
        input.value = value;
        theForm.appendChild(input);
    }

    function mergeAnswers() {
        var fm = document.getElementById("<portlet:namespace/>addAnswerForm");

        <c:if test="<%= q.getQuestionType().equalsIgnoreCase(PollQuestionType.QUESTION_TYPE_MULTIPLE.getTypeName()) %>">

         var answers = [];
            var choices = [];

            <%
                    JSONArray arr = JSONFactoryUtil.createJSONArray(q.getChoices());
                    for (int i = 0; i < arr.length(); i++) {
                        String choice = arr.getString(i);
                        %> choices.push('<%= HtmlUtil.escapeJS(choice) %>');<%
                }  %>

        for (var i = 0; i < choices.length; i++) {
            var el = document.getElementById('<portlet:namespace/>' + i + "_multianswer");
            if (el && el.getAttribute("value") != "false") {
                answers.push(choices[i]);
            }
        }

        addHidden(fm, "<portlet:namespace/>answer", JSON.stringify(answers));
        </c:if>

    }
</script>
