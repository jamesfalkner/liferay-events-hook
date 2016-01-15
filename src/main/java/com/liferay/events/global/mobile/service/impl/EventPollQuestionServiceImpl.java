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
package com.liferay.events.global.mobile.service.impl;

import com.liferay.events.global.mobile.model.EventPollQuestion;
import com.liferay.events.global.mobile.service.base.EventPollQuestionServiceBaseImpl;
import com.liferay.portal.security.ac.AccessControlled;

import java.util.List;

/**
 * The implementation of the event poll question remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.events.global.mobile.service.EventPollQuestionService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author James Falkner
 * @see com.liferay.events.global.mobile.service.base.EventPollQuestionServiceBaseImpl
 * @see com.liferay.events.global.mobile.service.EventPollQuestionServiceUtil
 */
public class EventPollQuestionServiceImpl
    extends EventPollQuestionServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.liferay.events.global.mobile.service.EventPollQuestionServiceUtil} to access the event poll question remote service.
     */

    @AccessControlled(guestAccessEnabled = true)
    @Override
    public List<EventPollQuestion> getQuestions(final String eventId, final boolean enabled) throws Exception {

        return eventPollQuestionPersistence.findByEventPollQuestion_E_E(eventId, enabled);
    }

}
