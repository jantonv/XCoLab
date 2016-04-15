package org.xcolab.portlets.messaging.utils;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.theme.ThemeDisplay;
import org.xcolab.pojo.User_;
import org.xcolab.portlets.messaging.beans.MessageBean;
import org.xcolab.utils.MessageLimitManager;

import javax.portlet.PortletRequest;

public class MessagingPermissions {
    private final PermissionChecker permissionChecker;
    private final User user;
    private MessageBean message;
    private Boolean isRecipient;

    public MessagingPermissions(PortletRequest request)
            throws PortalException, SystemException {
        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

        permissionChecker = themeDisplay.getPermissionChecker();
        user = themeDisplay.getUser();
    }

    public MessagingPermissions(PortletRequest request, MessageBean message)
            throws PortalException, SystemException {
        this(request);
        this.message = message;
    }

    public boolean getCanSendMessage() {
        try {
            return MessageLimitManager.canSendMessages(1, user) || getCanAdminAll();
        } catch (PortalException | SystemException e) {
            return getCanAdminAll();
        }
    }

    public boolean getCanViewMessage() throws SystemException, PortalException {
        return message.getFrom().getUserId() == user.getUserId()
                || isRecipient();
    }

    public boolean isRecipient() {
        if (isRecipient == null) {
            for (User_ recipient : message.getTo()) {
                if (recipient.getUserId() == user.getUserId()) {
                    isRecipient = true;
                    return true;
                }
            }
            isRecipient = false;
        }
        return false;
    }

    /**
     * Returns true if user is admin (not only proposal contributor)
     */
    public boolean getCanAdminAll() {
        return permissionChecker.isOmniadmin();
    }

    public User getUser() {
        return user;
    }
}