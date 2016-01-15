<#--
Copyright 2016 Liferay, Inc. All rights reserved.
http://www.liferay.com

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
-->

<#-- @ftlvariable name="entries" type="java.util.List<com.liferay.portlet.asset.model.AssetEntry>" -->
<#-- @ftlvariable name="entry" type="com.liferay.portlet.asset.model.AssetEntry" -->
<#-- @ftlvariable name="members" type="java.util.List<com.liferay.portal.model.User>" -->
<#-- @ftlvariable name="member" type="com.liferay.portal.model.User" -->
<#-- @ftlvariable name="locale" type="java.util.Locale" -->
<#-- @ftlvariable name="utilLocator" type="com.liferay.portal.template.UtilLocator" -->
<#-- @ftlvariable name="userService" type="com.liferay.portal.service.UserLocalService" -->
<#-- @ftlvariable name="groupService" type="com.liferay.portal.service.GroupLocalService" -->
<#-- @ftlvariable name="scopeGroupId" type="java.lang.Long" -->
<#-- @ftlvariable name="htmlUtil" type="com.liferay.portal.kernel.util.HtmlUtil" -->
<#-- @ftlvariable name="languageUtil" type="com.liferay.portal.kernel.language.LanguageUtil" -->
<#-- @ftlvariable name="stringUtil" type="com.liferay.portal.kernel.util.StringUtil" -->
<#-- @ftlvariable name="themeDisplay" type="com.liferay.portal.theme.ThemeDisplay" -->
<#-- @ftlvariable name="getterUtil" type="com.liferay.portal.kernel.util.GetterUtil" -->
<#-- @ftlvariable name="httpUtil" type="com.liferay.portal.kernel.util.HttpUtil" -->
<#-- @ftlvariable name="validator" type="com.liferay.portal.kernel.util.Validator" -->
<#-- @ftlvariable name="request" type="java.util.HashMap" -->
<#-- @ftlvariable name="portal" type="com.liferay.portal.util.Portal" -->
<#-- @ftlvariable name="objectUtil" type="com.liferay.portal.freemarker.LiferayObjectConstructor" -->

<#-- @ftlvariable name="questionObj" type="com.liferay.events.global.mobile.model.EventPollQuestion" -->
<#-- @ftlvariable name="questionService" type="com.liferay.events.global.mobile.service.EventPollQuestionLocalServiceUtil" -->
<#-- @ftlvariable name="answerService" type="com.liferay.events.global.mobile.service.EventPollAnswerLocalServiceUtil" -->
<#-- @ftlvariable name="questionIdStr" type="java.lang.Long" -->

<style type="text/css" xmlns:aui="http://www.w3.org/1999/html">
	.bigslide {
		list-style-type: none;
		font-size: 2em;
		height: 2em;
		font-weight: bold;
	}

	.toasterror {
		width: 200px;
		height: 20px;
		height: auto;
		position: absolute;
		left: 50%;
		margin-left: -100px;
		bottom: 10px;
		background-color: #383838;
		color: #F0F0F0;
		font-family: Calibri;
		font-size: 20px;
		padding: 10px;
		text-align: center;
		border-radius: 2px;
		-webkit-box-shadow: 0px 0px 24px -1px rgba(56, 56, 56, 1);
		-moz-box-shadow: 0px 0px 24px -1px rgba(56, 56, 56, 1);
		box-shadow: 0px 0px 24px -1px rgba(56, 56, 56, 1);
	}
</style>


<#--<#assign portalURL = httpUtil.getProtocol(request['attributes']['CURRENT_URL']) + "://" + getterUtil.getString(request['theme-display']['portal-url']) />-->
<#--<#assign mainPath = getterUtil.getString(request['theme-display']['path-main']) />-->
<#--<#assign scopeGroupId = getterUtil.getLong(request['theme-display']['scope-group-id']) />-->
<#--<#assign companyId = getterUtil.getLong(request['theme-display']['company-id']) />-->

<#--&lt;#&ndash; Make a temp themeDisplay object (actual java object) to use later on &ndash;&gt;-->
<#--<#assign themeDisplay = objectUtil("com.liferay.portal.theme.ThemeDisplay") />-->
<#--<#assign V = themeDisplay.setPathImage(getterUtil.getString(request['theme-display']['path-image'])) />-->
<#--<#assign V = themeDisplay.setPathMain(getterUtil.getString(request['theme-display']['path-main'])) />-->
<#--<#assign V = themeDisplay.setPortalURL(portalURL) />-->
<#--<#assign V = themeDisplay.setPermissionChecker(permissionChecker) />-->
<#--<#assign V = themeDisplay.setScopeGroupId(scopeGroupId) />-->

<#assign questionIdStr = httpUtil.getParameter(request['attributes']['CURRENT_URL'], 'questionId') />
<#assign userService = utilLocator.findUtil("com.liferay.portal.service.UserLocalService") />
<#assign questionService = utilLocator.findUtil("liferay-events-hook", "com.liferay.events.global.mobile.service.EventPollQuestionLocalService") />
<#assign answerService = utilLocator.findUtil("liferay-events-hook", "com.liferay.events.global.mobile.service.EventPollAnswerLocalService") />

<script src="//code.jquery.com/jquery-1.7.2.min.js"></script>
<script src="//code.jquery.com/ui/1.8.21/jquery-ui.min.js"></script>
<script src="/html/js/jquery.ui.touch-punch.min.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">


<#if questionIdStr?has_content>
  <#assign questionId = getterUtil.getLong(questionIdStr) />
  <#assign questionObj = questionService.getEventPollQuestion(questionId) />

<h2>${questionObj.question?html}</h2><br>

<div id="successdiv" style="display:none;" class="portlet-msg-success">${languageUtil.get(locale, "thank-you-for-your-vote")}&nbsp;<a
    href="${questions_url.data}">${languageUtil.get(locale, "back-to-vote")}</a></div>

<div id="container"></div>

  <#switch questionObj.questionType>
    <#case 'single'>
      <#assign choices = questionObj.choices?eval />

    <div id="radiocontainer">
      <#list choices as choice>
	      <div>
		      <label style="font-size: 2em;"><input id="radio${choice_index}" type="radio" name="radiogroup" title="${choice?html}"
                                                            <#if choice_index = 0>checked</#if>>&nbsp;&nbsp;&nbsp;${choice?html}</label>
	      </div>
	      <br><br>
      </#list>

    </div>


      <#break>
    <#case 'multiple'>
      <#assign choices = questionObj.choices?eval />

    <div id="checkboxcontainer">
      <#list choices as choice>
	      <div>
		      <label style="font-size: 2em;"><input id="checkbox${choice_index}" type="checkbox" name="${choice?html}"
							    title="${choice?html}"/>&nbsp;&nbsp;&nbsp;${choice?html}</label>
	      </div>
	      <br><br>
      </#list>

    </div>

      <#break>
    <#case 'rating'>

      <#assign choices = questionObj.choices?eval />


    <div style="width: 90%" id="slider"></div>
    <div><span id="slidervalue" style="margin: auto; font-size: 2em; color: dodgerblue; font-weight: bold;">--</span></div>
    <script type="text/javascript">
	    $(function () {

		    function setLabel(e) {
			    $('#slidervalue').text(Math.floor($('#slider').slider('value')));
		    }

		    $("#slider").slider({
			    animate: 'fast',
			    min: ${choices[0]},
			    max: ${choices[1]},
			    step: 0.02,
			    slide: setLabel,
			    change: setLabel,
			    stop: setLabel,
			    start: setLabel
		    });
		    $('#slidervalue').text(Math.floor($('#slider').slider('value')));

	    });
    </script>

      <#break>
    <#case 'ranking'>
      <#assign choices = questionObj.choices?eval />

    <ul id="ranking_ul">
      <#list choices as choice>
	      <li class="bigslide ui-state-default">
		      <span class="ui-icon ui-icon-arrowthick-2-n-s"></span>${choice?html}</li>
      </#list>
    </ul>

    <script type="text/javascript">
	    $(document).ready(function () {
		    $("#ranking_ul").sortable().disableSelection();

	    });
    </script>

      <#break>
    <#case 'text'>
    <textarea id="textarea" placeholder="${languageUtil.get(locale, "answer")}" style="height:200px;width: 95%"></textarea>


      <#break>
    <#default>
    <#--default code here-->
  </#switch>

<#if questionObj.askForId>

	<blockquote>${questionObj.idIntro}</blockquote>
	<label for="idName">${languageUtil.get(locale, "name")}</label><input type="text" id="idName"/>
	<label for="idEmail">${languageUtil.get(locale, "email-address")}</label><input type="text" id="idEmail"/>
	<label for="idCompany">${languageUtil.get(locale, "company")}</label><input type="text" id="idCompany"/>

</#if>

<br>
<a href="" class="btn btn-large btn-primary" title="Send" id="sendbtn"
   onclick="return (confirm('${languageUtil.get(locale, "confirm")}?') && getAndSendAnswer());">${languageUtil.get(locale, "send")}</a>

<br><br>
<div>
	<a href="${questions_url.data}">${languageUtil.get(locale, "back-to-vote")}</a>

</div>


<script type="text/javascript">

	function getAndSendAnswer() {

		var questionId = ${questionObj.questionId!0};
		var answer = getAnswer();

		if (!answer) {
			console.log("WARNING: no answer found");
		}

		sendAnswer(questionId, answer, function () {
			$('#successdiv').fadeIn();
			$('#sendbtn').fadeOut(400, function () {
				$(this).remove();
			});

		}, function (err) {
			toastNotification(err);
		});
		return false;
	}

	function sendAnswer(questionId, answer, onSuccess, onFailure) {

		AUI().use('array-extras', function (A) {

						var payloadObj = {};
	    if ($('#idName').val()) {
		    payloadObj.name = $('#idName').val();
	    }
	    if ($('#idEmail').val()) {
		    payloadObj.email = $('#idEmail').val();
	    }
	    if ($('#idCompany').val()) {
		    payloadObj.company = $('#idCompany').val();
	    }

			Liferay.Service(
			    '/liferay-events-hook.eventpollanswer/submit-answer',
			    {
				    questionId: questionId,
				    clientId: 'WEB_CLIENT',
				    answer: answer,
						payload: JSON.stringify(payloadObj),
				    signature: 'foo'
			    },
			    function (obj) {
				    if (obj && obj.answerId) {
					    onSuccess && onSuccess();
				    } else {

					    var msg = '${languageUtil.get(locale, "disabled")}';
					    if (obj && obj.exception) {
						    msg = (msg + (": " + obj.exception + " " + obj.message));
					    }
					    onFailure && onFailure(msg);
				    }
			    }
			);
		});
	}

	function getAnswer() {

          <#switch questionObj.questionType>
            <#case 'single'>
		    var result = [];
		    $('#radiocontainer :radio').each(function () {
			    var cb = $(this);
			    if (cb.is(':checked')) {
				    result.push(cb.attr('title').trim());
			    }
		    });
		    return JSON.stringify(result);

              <#break>
            <#case 'multiple'>
		    var result = [];
		    $('#checkboxcontainer :checkbox').each(function () {
			    var cb = $(this);
			    if (cb.is(':checked')) {
				    result.push(cb.attr('title').trim());
			    }
		    });
		    return JSON.stringify(result);
              <#break>
            <#case 'rating'>
		    return Math.floor($('#slider').slider('value'));
              <#break>
            <#case 'ranking'>

		    var result = [];
		    $("#ranking_ul > li").each(function () {
			    result.push($(this).text().trim());
		    });
		    return JSON.stringify(result);
              <#break>
            <#case 'text'>
		    return $('#textarea').attr('value').trim();

              <#break>
            <#default>
		    return null;
          </#switch>

	}

	function toastNotification(msg) {
		var toast = $('<div class="toasterror" style="display:none">' + msg + '</div>');

		$(document.body).append(toast);
		toast.stop().fadeIn(400).delay(3000).fadeOut(400);
	}

</script>

<#else>
<div class="portlet-msg-info">${languageUtil.get(locale, "there-are-no-results")}</div>

</#if>


