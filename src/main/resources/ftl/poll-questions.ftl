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

<#-- @ftlvariable name="questionService" type="com.liferay.events.global.mobile.service.EventPollQuestionLocalServiceUtil" -->
<#-- @ftlvariable name="answerService" type="com.liferay.events.global.mobile.service.EventPollAnswerLocalServiceUtil" -->
<#-- @ftlvariable name="questionIdStr" type="java.lang.Long" -->

<style type="text/css" xmlns:aui="http://www.w3.org/1999/html">

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

<script src="//code.jquery.com/jquery-1.7.2.min.js"></script>

<#if event_id.data?has_content>

<h3>${languageUtil.get(locale, "model.resource.com.liferay.portlet.polls")}</h3>

<hr>

<div id="therearenone" class="portlet-msg-info">${htmlUtil.escape(languageUtil.get(locale, 'searching,-please-wait'))}</div>

<table id="questionTable" class="table table-striped table-bordered">
	<tr>
		<th>
                ${languageUtil.get(locale, "owner")}
		</th>
		<th>
                ${languageUtil.get(locale, "polls-question")}
		</th>
	</tr>
</table>

<script type="text/javascript">

	var lastSuccess = new Date().getTime();
	var questions = [];

	function startPollPoll() {
		fetchPolls();
		setInterval(fetchPolls, 5000);
	}

	function fetchPolls() {

		AUI().use('array-extras', function (A) {
			Liferay.Service(
			    '/liferay-events-hook.eventpollquestion/get-questions',
			    {
				    eventId: '${event_id.data?js_string}',
				    enabled: true
			    },
			    function (obj) {
				    if (obj && obj.exception) {
					    var errmsg = obj.exception + ' ' + obj.message;
					    if (lastSuccess < (new Date().getTime() - 15000)) {
						    toastNotification('${htmlUtil.escape(languageUtil.get(locale, 'request-timeout'))}');
						    lastSuccess = new Date().getTime();
					    }

				    } else {
					    lastSuccess = new Date().getTime();
					    populateQuestionTable(obj);
				    }

			    }, function (errmsg) {
				    if (lastSuccess < (new Date().getTime() - 15000)) {
					    toastNotification('${htmlUtil.escape(languageUtil.get(locale, 'request-timeout'))}');
					    lastSuccess = new Date().getTime();
				    }

			    });
		});
	}

	var first = true;
	function populateQuestionTable(questionArr) {
		if (questionArr.length > 0) {
			$('#therearenone').fadeOut(400, function () {
				$(this).remove();
			});
		}
		questionArr.forEach(function (q) {
			var existing = getQuestion(q.questionId);
			if (!existing) {
				addQuestion(q);
				var link = '${answer_url_base.data}?questionId=' + q.questionId;

				$('#questionTable tr:first').after(
				    $('<tr>')
					.append($('<td>')
					    .text(q.sponsorName))
					.append($('<td>')
					    .append($('<a>').attr('href', link).text(q.shortTitle ? q.shortTitle : q.question))));

				if (!first) {
					$('#questionTable tr:nth-child(2) td').animate({
						"font-size": '1.5em'//'#ff0000'
					}, {
						duration: 400,
						complete: function () {
							$(this).animate({
								"font-size": '1em'
							}, {
								duration: 400
							})
						}
					});
				}
			}
		});
		first = false;

	}

	function addQuestion(q) {
		questions.push(q);
	}

	function getQuestion(id) {
		for (var i = 0; i < questions.length; i++) {
			if (questions[i].questionId == id) {
				return questions[i];
			}
		}
		return null;
	}

	function toastNotification(msg) {
		var toast = $('<div class="toasterror" style="display:none">' + msg + '</div>');

		$(document.body).append(toast);
		toast.stop().fadeIn(400).delay(3000).fadeOut(400);
	}

	$('document').ready(function () {
		startPollPoll();
	})

</script>

<#else>
<div class="portlet-msg-error">You need to Edit this Article and configure an Event ID!</div>

</#if>
