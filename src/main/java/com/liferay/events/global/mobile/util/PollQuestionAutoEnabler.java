/**
 * Copyright 2016 Liferay, Inc. All rights reserved.
 * http://www.liferay.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * @author James Falkner
 */
package com.liferay.events.global.mobile.util;

import com.liferay.events.global.mobile.model.EventPollQuestion;
import com.liferay.events.global.mobile.service.EventPollQuestionLocalServiceUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;

import java.util.Date;
import java.util.List;

public class PollQuestionAutoEnabler implements MessageListener {
	@Override
	public void receive(Message message) throws MessageListenerException {
		try {
			List<EventPollQuestion> questions = EventPollQuestionLocalServiceUtil.getAutoEnabled(new Date());
			for (EventPollQuestion question : questions) {
				question.setEnabled(true);
				question.setAutoEnable(false);
				EventPollQuestionLocalServiceUtil.updateEventPollQuestion(question);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new MessageListenerException(e);
		}
	}
}
