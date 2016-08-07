package org.xcolab.service.members.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.xcolab.model.tables.pojos.Member;
import org.xcolab.model.tables.pojos.Message;
import org.xcolab.service.members.domain.messaging.MessageDao;
import org.xcolab.service.members.exceptions.NotFoundException;
import org.xcolab.service.members.service.messaging.MessagingService;
import org.xcolab.service.utils.ControllerUtils;
import org.xcolab.service.utils.PaginationHelper;
import org.xcolab.util.exceptions.InternalException;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

@RestController
public class MessagingController {

    private static final Logger log = LoggerFactory.getLogger(MessagingController.class);

    @Autowired
    private MessagingService messagingService;

    @Autowired
    private MessageDao messageDao;

    @RequestMapping(value = "/messages", method = {RequestMethod.GET, RequestMethod.HEAD})
    public List<Message> getMemberMessages(HttpServletResponse response,
            @RequestParam(required = false) Integer startRecord,
            @RequestParam(required = false) Integer limitRecord,
            @RequestParam(required = false) Long recipientId,
            @RequestParam(required = false) Long senderId,
            @RequestParam(required = false) Boolean isArchived,
            @RequestParam(required = false) Boolean isOpened,
            @RequestParam(required = false) String sort,
            @RequestParam(required = false, defaultValue = "true") boolean includeCount) {

        final PaginationHelper paginationHelper = new PaginationHelper(startRecord, limitRecord,
                sort);

        if (includeCount) {
            response.setHeader(ControllerUtils.COUNT_HEADER_NAME,
                    Integer.toString(messageDao.countByGiven(senderId, recipientId, isArchived, isOpened)));
        }
        return messageDao.findByGiven(paginationHelper, senderId, recipientId, isArchived, isOpened);
    }

    @RequestMapping(value = "/messages/{messageId}", method = RequestMethod.GET)
    public Message getMessage(@PathVariable long messageId) throws NotFoundException {
         return messageDao.getMessage(messageId);
    }

    @RequestMapping(value = "/messages/{messageId}/recipients", method = RequestMethod.GET)
    public List<Member> getMessageRecipients(@PathVariable long messageId) {
        return messageDao.getRecipients(messageId);
    }

    @RequestMapping(value = "/messages", method = RequestMethod.POST)
    public Message createMessage(@RequestBody Message message) {
        return messagingService.createMessage(message).orElseGet(() -> {
            log.warn("Could not retrieve id of created message: " + message);
            return message;
        });
    }

    @RequestMapping(value = "/messages/{messageId}/recipients", method = RequestMethod.POST)
    public String createMessageRecipient(@PathVariable long messageId,
            @RequestParam long recipientId) {
        messagingService.createRecipient(messageId, recipientId);
        return "";
    }

    @RequestMapping(value = "/messages/{messageId}/recipients/{memberId}", method = RequestMethod.PUT)
    public boolean updateRecipientStatus(@PathVariable long messageId, @PathVariable long memberId,
            @RequestParam(required = false) Boolean isArchived,
            @RequestParam(required = false) Boolean isOpened) {
        boolean success = true;
        if (isOpened != null) {
            success = messageDao.setOpened(messageId, memberId, isOpened);
        }
        if (isArchived != null) {
            success = success && messageDao.setArchived(messageId, memberId, isArchived);
        }
        return success;
    }
}
