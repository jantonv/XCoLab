package org.xcolab.service.members.service.messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.xcolab.model.tables.pojos.Member;
import org.xcolab.model.tables.pojos.MessagingUserPreferences;
import org.xcolab.service.members.domain.member.MemberDao;
import org.xcolab.service.members.domain.messaging.MessageDao;
import org.xcolab.service.members.service.role.RoleService;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

/**
 * Class responsible for handling verification if user is allowed to send
 * messages or maybe daily limit has been reached.
 * 
 * @author janusz
 */
@Service
public class MessageLimitManager {

    private static final Map<Long, Object> mutexes = new HashMap<>();
    private static final int MESSAGES_DAILY_LIMIT = 15;
    private static final int MESSAGES_DAILY_LIMIT_FIRST_DAYS = 2;
	private static final Map<Long, LocalDateTime> lastValidationDateMap = new HashMap<>();

    private final MessagingUserPreferencesService messagingUserPreferencesService;
    private final MessageDao messageDao;
    private final RoleService roleService;
    private final MemberDao memberDao;

    @Autowired
    private MessageLimitManager(MessagingUserPreferencesService messagingUserPreferencesService,
            MessageDao messageDao, RoleService roleService, MemberDao memberDao) {
        this.messagingUserPreferencesService = messagingUserPreferencesService;
        this.messageDao = messageDao;
        this.roleService = roleService;
        this.memberDao = memberDao;
    }

    /**
     * Method responsible for checking if user is allowed to send given number
     * of messages.
     * 
     * @param messagesToSend
     *            number of messages that user wants to send
     */
    public boolean canSendMessages(int messagesToSend, long memberId) {
        synchronized (getMutex(memberId)) {

            int messageLimit = getMessageLimit(memberId);

            final Timestamp yesterday = Timestamp.from(Instant.now().minus(Duration.ofDays(1)));

            long count = messageDao.countByGiven(memberId, null, null, null, yesterday);

            return messageLimit >= count + messagesToSend;
        }
    }

    public int getNumberOfMessagesLeft(long memberId) {
        int messageLimit = getMessageLimit(memberId);

        final Timestamp yesterday = Timestamp.from(Instant.now().minus(Duration.ofDays(1)));

        int count = messageDao.countByGiven(memberId, null, null, null, yesterday);

        return  messageLimit - count;
    }

    public int getMessageLimit(long memberId) {
        if (roleService.isAdmin(memberId)) {
            return Integer.MAX_VALUE;
        }

        MessagingUserPreferences messagingPreferences = messagingUserPreferencesService.getByMemberId(memberId);

        int messagesLimit;
        if (messagingPreferences.getDailyMessageLimit() != null) {
            messagesLimit = messagingPreferences.getDailyMessageLimit();
        } else {
            final Member member = memberDao.getMember(memberId)
                    .orElseThrow(() -> new IllegalStateException("Can't check limit for member "
                            + memberId + ": member does not exist"));

            if (isMoreThan2DaysOld(member)) {
                messagesLimit = MESSAGES_DAILY_LIMIT;
            } else {
                messagesLimit = MESSAGES_DAILY_LIMIT_FIRST_DAYS;;
            }
        }
        return messagesLimit;
    }

    private boolean isMoreThan2DaysOld(Member member) {
        return member.getCreateDate().toInstant()
                .plus(2, ChronoUnit.DAYS).isBefore(Instant.now());
    }

    public synchronized Object getMutex(long senderId) {
        return mutexes.computeIfAbsent(senderId, k -> new Object());
    }

	public boolean wasReportedRecently(Long memberId) {
        final LocalDateTime lastEmailSendDate = lastValidationDateMap.get(memberId);

        final LocalDateTime now = LocalDateTime.now();
        if (lastEmailSendDate == null || lastEmailSendDate.plusHours(24).isBefore(now)) {
            lastValidationDateMap.put(memberId, now);
            return false;
        } else {
            return true;
        }
	}
}
