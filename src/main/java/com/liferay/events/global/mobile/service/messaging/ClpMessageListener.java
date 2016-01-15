package com.liferay.events.global.mobile.service.messaging;

import com.liferay.events.global.mobile.service.ClpSerializer;
import com.liferay.events.global.mobile.service.EventContactLocalServiceUtil;
import com.liferay.events.global.mobile.service.EventContactServiceUtil;
import com.liferay.events.global.mobile.service.EventPollAnswerLocalServiceUtil;
import com.liferay.events.global.mobile.service.EventPollAnswerServiceUtil;
import com.liferay.events.global.mobile.service.EventPollQuestionLocalServiceUtil;
import com.liferay.events.global.mobile.service.EventPollQuestionServiceUtil;
import com.liferay.events.global.mobile.service.GeoCacheLocalServiceUtil;
import com.liferay.events.global.mobile.service.MatchLocalServiceUtil;
import com.liferay.events.global.mobile.service.MatchServiceUtil;
import com.liferay.events.global.mobile.service.MessageLocalServiceUtil;
import com.liferay.events.global.mobile.service.MessageServiceUtil;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;


public class ClpMessageListener extends BaseMessageListener {
    public static String getServletContextName() {
        return ClpSerializer.getServletContextName();
    }

    @Override
    protected void doReceive(Message message) throws Exception {
        String command = message.getString("command");
        String servletContextName = message.getString("servletContextName");

        if (command.equals("undeploy") &&
                servletContextName.equals(getServletContextName())) {
            EventContactLocalServiceUtil.clearService();

            EventContactServiceUtil.clearService();
            EventPollAnswerLocalServiceUtil.clearService();

            EventPollAnswerServiceUtil.clearService();
            EventPollQuestionLocalServiceUtil.clearService();

            EventPollQuestionServiceUtil.clearService();
            GeoCacheLocalServiceUtil.clearService();

            MatchLocalServiceUtil.clearService();

            MatchServiceUtil.clearService();
            MessageLocalServiceUtil.clearService();

            MessageServiceUtil.clearService();
        }
    }
}
