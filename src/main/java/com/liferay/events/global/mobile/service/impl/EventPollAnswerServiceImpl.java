package com.liferay.events.global.mobile.service.impl;

import com.liferay.events.global.mobile.InvalidSignatureException;
import com.liferay.events.global.mobile.Utils;
import com.liferay.events.global.mobile.model.EventPollAnswer;
import com.liferay.events.global.mobile.model.EventPollQuestion;
import com.liferay.events.global.mobile.model.PollQuestionType;
import com.liferay.events.global.mobile.service.EventPollAnswerLocalServiceUtil;
import com.liferay.events.global.mobile.service.EventPollQuestionLocalServiceUtil;
import com.liferay.events.global.mobile.service.base.EventPollAnswerServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.security.ac.AccessControlled;
import com.liferay.portal.service.ServiceContext;

import java.io.IOException;
import java.util.List;

/**
 * The implementation of the event poll answer remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.events.global.mobile.service.EventPollAnswerService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author James Falkner
 * @see com.liferay.events.global.mobile.service.base.EventPollAnswerServiceBaseImpl
 * @see com.liferay.events.global.mobile.service.EventPollAnswerServiceUtil
 */
public class EventPollAnswerServiceImpl extends EventPollAnswerServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.liferay.events.global.mobile.service.EventPollAnswerServiceUtil} to access the event poll answer remote service.
     */


    @AccessControlled(guestAccessEnabled = true)
    @Override
    public EventPollAnswer submitAnswer(final long questionId, final String clientId, final String payload, final String answer, String signature) throws InvalidSignatureException, SystemException, PortalException {

        EventPollQuestion q = EventPollQuestionLocalServiceUtil.getEventPollQuestion(questionId);

        if (!q.isEnabled()) {
            throw new PortalException("Event question " + questionId + " has expired!");
        }

        String newAns = answer;
        if (Validator.equals(q.getQuestionType(), PollQuestionType.QUESTION_TYPE_TEXT.getTypeName())) {
            // strip stop words
            try {
                newAns = Utils.removeStopWords(answer);
                newAns = Utils.removeUnicode(newAns);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return EventPollAnswerLocalServiceUtil.addAnswer(questionId, clientId, payload, newAns, new ServiceContext());

    }

    @AccessControlled(guestAccessEnabled = true)
    @Override
    public List<String> getAnswers(final long questionId) throws SystemException {

        return EventPollAnswerLocalServiceUtil.getAllAnswers(questionId);

    }
}
