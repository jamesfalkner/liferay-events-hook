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
package com.liferay.events.global.mobile.portlet;

import com.liferay.events.global.mobile.Utils;
import com.liferay.events.global.mobile.service.MatchLocalServiceUtil;
import com.liferay.events.global.mobile.service.MessageLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.model.GroupConstants;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.ProcessAction;

public class MessagesPortlet extends MVCPortlet {

	@ProcessAction(name = "toggle")
	public void toggle(ActionRequest req, ActionResponse resp) {
		Utils.flag = !Utils.flag;
	}

	@ProcessAction(name = "addMessage")
	public void addMessage(ActionRequest request, ActionResponse response)
			throws SystemException, PortalException {

		String eventId = GetterUtil.getString(request.getParameter("eventId"));
		String content = GetterUtil.getString(request.getParameter("content"));
		long toId = GetterUtil.getLong(request.getParameter("toId"), 0);
		long fromId = GetterUtil.getLong(request.getParameter("fromId"), 0);

		if (!MatchLocalServiceUtil.matches(eventId, toId, fromId)) {
			throw new PortalException("Sender has not been matched with recipient");
		}

		final String groupName = GroupConstants.GUEST;
		final long companyId = PortalUtil.getDefaultCompanyId();
		final long guestGroupId = GroupLocalServiceUtil.getGroup(companyId, groupName).getGroupId();

		MessageLocalServiceUtil.addMessage(PortalUtil.getUserId(request), guestGroupId, new ServiceContext(),
				eventId, fromId, toId, content);

	}
}

