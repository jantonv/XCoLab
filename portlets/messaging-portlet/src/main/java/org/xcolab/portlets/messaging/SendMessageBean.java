package org.xcolab.portlets.messaging;

import com.ext.portlet.messaging.MessageUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.util.mail.MailEngineException;
import org.xcolab.enums.MemberRole;
import org.xcolab.utils.SendMessagePermissionChecker;

import javax.faces.event.ActionEvent;
import javax.mail.internet.AddressException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class SendMessageBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private final static Log _log = LogFactoryUtil.getLog(SendMessageBean.class);

    private List<User> users;
    private String recipients;
    private String subject;
    private String content;
    private MessagingBean messagingBean;
    private MessageBean replyMessage;
    private final SendMessagePermissionChecker permissionChecker;

    //honeypot is a field supposed to be left blank by humans, and to be filled in by bots, in order to protect from spam.
    private String messageHoneypot;
    private final int messageHoneypotPosition;


    public SendMessageBean() throws SystemException {
        this.messageHoneypotPosition = ((new Random()).nextInt(10)) % 2;

        users = UserLocalServiceUtil.getUsers(0, Integer.MAX_VALUE);

        permissionChecker = new SendMessagePermissionChecker(Helper.getLiferayUser());
        List<MemberRole> blacklist = permissionChecker.getBlacklistedMemberRoles();
        List<Long> blacklistedUsers = new ArrayList<>();

        // Get all the userIds which are not accessible for the current user
        for (MemberRole mr : blacklist) {
            for (String name : mr.getRoleNames()) {
                try {
                    Role role = RoleLocalServiceUtil.getRole(GetterUtil.getLong(Helper.getLiferayCompanyId()), name);
                    List<User> users = UserLocalServiceUtil.getRoleUsers(role.getRoleId());
                    for (User user : users) {
                        blacklistedUsers.add(user.getUserId());
                    }
                } catch (PortalException | SystemException e) {
                    // Ignore the role if it cannot get resolved
                }
            }
        }

        DynamicQuery userQuery = DynamicQueryFactoryUtil.forClass(User.class, PortalClassLoaderUtil.getClassLoader());
        if (!blacklistedUsers.isEmpty()) {
            userQuery.add(RestrictionsFactoryUtil.not(RestrictionsFactoryUtil.in("userId", blacklistedUsers)));
        }
        users = UserLocalServiceUtil.dynamicQuery(userQuery);

        Collections.sort(new ArrayList(users), new Comparator<User>() {

            @Override
            public int compare(User o1, User o2) {
                return o1.getScreenName().compareTo(o2.getScreenName());
            }
        });
    }

    public List<User> getUsersList() {
        return users;
    }

    public void send(ActionEvent e) throws AddressException, SystemException, PortalException, MailEngineException,
            UnsupportedEncodingException {
        if (messageHoneypot != null && !messageHoneypot.isEmpty()) {
            _log.info("Message was not sent because honeypot was filled - text: " + content + " honeypot: "
                    + messageHoneypot);
            //trick bot into thinking message was sent
            messagingBean.messageSent();
            return;
        }

        List<Long> recipientIds = new ArrayList<>();

        for (String recipientId : recipients.split(",")) {
            if (!recipientId.trim().equals("")) {
                if (permissionChecker.canSendToUser(UserLocalServiceUtil.getUserById(Long.parseLong(recipientId)))) {
                    recipientIds.add(Long.parseLong(recipientId));
                }
            }
        }

        boolean success = MessageUtil.checkLimitAndSendMessage(subject, content, Helper.getLiferayUser(), recipientIds);
        if (success) {
            messagingBean.messageSent();
        }
    }

    public void cancel(ActionEvent e) throws PortalException, SystemException {
        messagingBean.toggleSendMessage((MessageBean) null);
    }

    public void testAction(ActionEvent e) {
        System.out.println("test");
    }

    public void init() {
        content = "";
        subject = "";
        recipients = "";
    }

    public void init(MessageBean replyMessage) throws PortalException, SystemException {
        recipients = String.valueOf(replyMessage.getFrom().getUserId());

        subject = "RE: " + replyMessage.getSubject();
        content =
                "\n\n-- original message begin --\n\n" + replyMessage.getContent() + "\n\n-- original message end --\n";
        this.replyMessage = replyMessage;
    }

    public String getRecipients() {
        return recipients;
    }

    public void setRecipients(String recipients) {
        this.recipients = recipients;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public MessagingBean getMessagingBean() {
        return messagingBean;
    }

    public void setMessagingBean(MessagingBean messagingBean) throws PortalException, SystemException {
        this.messagingBean = messagingBean;
        messagingBean.setSendMessageBean(this);
    }

    public MessageBean getReplyMessage() {
        return replyMessage;
    }

    // to force screen unblocking
    public int getUnblockScreen() {
        return new Random().nextInt();
    }

    public String getMessageHoneypot() {
        return messageHoneypot;
    }

    public void setMessageHoneypot(String messageHoneypot) {
        this.messageHoneypot = messageHoneypot;
    }

    public int getMessageHoneypotPosition() {
        return messageHoneypotPosition;
    }

}
