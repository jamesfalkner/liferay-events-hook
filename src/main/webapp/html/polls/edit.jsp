<%@ page import="com.liferay.events.global.mobile.model.EventPollQuestion" %>
<%@ page import="com.liferay.events.global.mobile.service.EventPollQuestionLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.*" %>
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
    EventPollQuestion q = null;

    long questionId = ParamUtil.getLong(request, "questionId");

    if (questionId > 0) {
        q = EventPollQuestionLocalServiceUtil.getEventPollQuestion(questionId);
    }

    DateFormat fmt = new SimpleDateFormat("yyyy/MM/dd");
    DateFormat timefmt = new SimpleDateFormat("HH:mm");

    TimeZone tz = ( timeZone != null) ? timeZone : TimeZone.getDefault();

    fmt.setTimeZone(tz);
    timefmt.setTimeZone(tz);

    if (q != null) {
        tz = TimeZone.getTimeZone(q.getEnableTriggerTimezone());
        fmt.setTimeZone(TimeZone.getTimeZone(q.getEnableTriggerTimezone()));
        timefmt.setTimeZone(TimeZone.getTimeZone(q.getEnableTriggerTimezone()));
    }

    String dateStr = fmt.format((q != null && q.getEnableTriggerDate() != null) ? q.getEnableTriggerDate() : new Date());
    String timeStr = timefmt.format((q != null && q.getEnableTriggerDate() != null) ? q.getEnableTriggerDate() : new Date());

%>

<portlet:renderURL var="viewURL">
    <portlet:param name="mvcPath" value="/html/polls/view.jsp"/>
</portlet:renderURL>

<portlet:actionURL name="updateEventPollQuestion" var="updateEventPollQuestionURL"/>

<aui:form id="EditForm" action="<%= updateEventPollQuestionURL %>" name="updateEventPollQuestion">
    <aui:model-context bean="<%= q %>" model="<%= EventPollQuestion.class %>"/>

    <aui:fieldset>

        <blockquote>
            Un-check this to disable the question for now (you can manually enable it later):
        </blockquote>


        <aui:input type="checkbox" label="Enabled" value='<%= (!Validator.isNull(q) && q.getEnabled()) %>' name="enabled"/>

        <blockquote>
            To schedule this question to auto-enable at a specific time, select the checkbox and fill out the time. At the specified time, the question will be enabled (only once) if it is not already enabled.
        </blockquote>

        <aui:input inlineField="true" type="checkbox" label="Auto-Enable" value='<%= (!Validator.isNull(q) && q.getAutoEnable()) %>' name="autoEnable"/>

        <i class="icon-calendar icon-white"></i>&nbsp;&nbsp;<input name="<portlet:namespace />datePicker" id="<portlet:namespace />datePicker" type="text"
        value='<%= dateStr %>'/>
        <i class="icon-time icon-white"></i>&nbsp;&nbsp;<input name="<portlet:namespace />timePicker" id="<portlet:namespace />timePicker" type="text"
        value='<%= timeStr %>'/>

        <aui:select inlineField="true" label="Timezone" name="tz">
            <%
                List<String> tzs = new ArrayList<String>();
                tzs.addAll(Arrays.asList(TimeZone.getAvailableIDs()));
                Collections.sort(tzs);
                for (String id : tzs) {
            %> <aui:option selected="<%= id.equals(tz.getID())%>" value="<%= id %>" label="<%= id %>"/> <%
            }
        %>
        </aui:select>


        <blockquote>
            Event ID: <code>brazil2015</code>or<code>lpsf-uk-2015</code>or<code>italy-2015</code>or<code>devcon-2015</code>or<code>spain2015</code>or<code>lpsf-de-2015</code>or<code>lrnas2015</code>or<code>lpsf-at-2015</code>.
            This must match the event id's used by the mobile app.
        </blockquote>

        <aui:input label="Event ID" cssClass="widebody" name="eventId"> <aui:validator name="required"/></aui:input>

        <blockquote>
            The speaker name that will be asking the question
        </blockquote>

        <aui:input label="Sponsor" cssClass="widebody" name="sponsorName"> <aui:validator name="required"/></aui:input>

        <aui:input cssClass="widebody" type="hidden" name="questionId"
                   value='<%= q == null ? questionId : q.getQuestionId() %>'/>

        <blockquote>
            What kind of response for this question:
        </blockquote>

        <aui:select label="Question Type" name="questionType">
            <aui:option value="multiple" label="Mutiple Answer"/>
            <aui:option value="single" label="Single Answer"/>
            <aui:option value="text" label="Text Answer"/>
            <aui:option value="ranking" label="Ranking (e.g. ordered response)"/>
            <aui:option value="rating" label="Rating (e.g. from 1 to 10)"/>
        </aui:select>

        <blockquote>
            For <em>single</em> and <em>multiple-choice</em> questions, choose a chart type for the result:
        </blockquote>

        <aui:select label="Chart Type" name="chartType">
            <aui:option value="bar" selected="true" label="Bar Chart"/>
            <aui:option value="pie" label="Pie Chart"/>

        </aui:select>

        <blockquote>
            The text of the question to ask:
        </blockquote>

        <aui:input cssclass="widebody" name="question" label="Question Text"><aui:validator name="required"/></aui:input>

        <blockquote>
            Enter the possible answers for this question according to the question type:
            <ul>
                <li>
                    single-choice, multiple-choice, and ranking questions: Enter answers like this: <code>["Choice A", "Choice B", "Choice C"]</code>
                </li>
                <li>
                    text question: <em>Leave Blank</em>
                </li>
                <li>
                    rating: <code>[1, 10]</code> for a rating of 1 to 10 (inclusive)
                </li>
            </ul>
        </blockquote>
        <aui:input type="textarea" cssClass="widebody" name="choices" label="Choices"/>

        <blockquote>
            A short title shown to attendees when viewing the list of all available questions:
        </blockquote>

        <aui:input cssclass="widebody" name="shortTitle" label="Short Title"><aui:validator name="required"/></aui:input>

        <blockquote>
            Select this if you want the poll to ask the user for identification (name, email, company) when submitting:
        </blockquote>

        <aui:input label="Ask For Id" type="checkbox" name="askForId" value='<%= (!Validator.isNull(q) && q.getAskForId()) %>'/>

        <blockquote>
            For poll questions that ask for ID, this text will be shown above the ID (email, name, company) fields
        </blockquote>

        <aui:input label="ID Instructions" cssClass="widebody" name="idIntro"/>

        <blockquote>
            If you want the choices to be replaced with anonymous text on the results, check this:
        </blockquote>

        <aui:input label="Anonymous Results" cssClass="widebody" name="anonymousResults" value='<%= (!Validator.isNull(q) && q.getAnonymousResults()) %>'/>

        <blockquote>
            If you want the responseCount (total # of participants in realtime), check this:
        </blockquote>
        <aui:input label="Show Response Count" cssClass="widebody" name="showResponseCount" value='<%= (!Validator.isNull(q) && q.getShowResponseCount()) %>'/>



        <blockquote>
            (Optional) A full URL of a picture to associate with the question (shown on the list of all quesions in the mobile app)
        </blockquote>

        <aui:input cssClass="widebody" name="picUrl" label="URL of Picture (optional)"> <aui:validator name="url"/></aui:input>

    </aui:fieldset>

    <aui:button-row>
        <aui:button type="submit"></aui:button>
        <aui:button type="cancel" onClick="<%= viewURL %>"></aui:button>
    </aui:button-row>
</aui:form>

<script type="text/javascript">
    YUI({lang: '<%= locale %>'}).use(
            'aui-datepicker',
            function(Y) {
                new Y.DatePicker(
                        {
                            trigger: '#<portlet:namespace />datePicker',
                            mask: '%Y/%m/%d',
                            popover: {
                                zIndex: 1
                            },
                            on: {
                                selectionChange: function(event) {
                                }
                            }
                        }
                );
            }
    );
    YUI({lang: '<%= locale %>'}).use(
            'aui-timepicker',
            function(Y) {
                new Y.TimePicker(
                        {
                            trigger: '#<portlet:namespace />timePicker',
                            mask: '%H:%M',
                            popover: {
                                zIndex: 1
                            },
                            on: {
                                selectionChange: function(event) {
                                }
                            }
                        }
                );
            }
    );

</script>