package org.xcolab.portlets.loginregister;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;

import com.liferay.portal.CookieNotSupportedException;
import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.PasswordExpiredException;
import com.liferay.portal.UserEmailAddressException;
import com.liferay.portal.UserIdException;
import com.liferay.portal.UserLockoutException;
import com.liferay.portal.UserPasswordException;
import com.liferay.portal.UserScreenNameException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.security.auth.AuthException;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

@Controller
@RequestMapping(value="view", params="isLoggingIn=true")
public class LoginController {

    @ActionMapping
    public void doLogin(ActionRequest request, ActionResponse response) throws IOException {

        ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(
                WebKeys.THEME_DISPLAY); 
        
        HttpServletRequest httpRequest = PortletUtils.getOryginalRequest(request);
        
        String redirect = httpRequest.getParameter("redirect");
        String referer = httpRequest.getHeader("referer");
        redirect = ! StringUtils.isBlank(redirect) ? redirect : referer;
        
        redirect = ! StringUtils.isBlank(redirect) ? redirect : themeDisplay.getURLHome();
        
        
        

        redirect = Helper.removeParamFromRequestStr(redirect, "signinRegError");
        redirect = Helper.removeParamFromRequestStr(redirect, "isSigningInPopup");
        redirect = Helper.removeParamFromRequestStr(redirect, "isSigningIn");
        redirect = Helper.removeParamFromRequestStr(redirect, "isRegistering");
        redirect = Helper.removeParamFromRequestStr(redirect, "isPasswordReminder");
        
        try {
            LoginUtil.logUserIn(request, response, request.getParameter("login"), request.getParameter("password"));
        }
        catch (Exception e) {
            if (e instanceof AuthException) {
                Throwable cause = e.getCause();

                if (cause instanceof PasswordExpiredException ||
                    cause instanceof UserLockoutException) {

                    SessionErrors.add(
                        request, cause.getClass().getName());
                }
                else {
                    SessionErrors.add(request, e.getClass().getName());
                }
            }
            else if (e instanceof CookieNotSupportedException ||
                     e instanceof NoSuchUserException ||
                     e instanceof PasswordExpiredException ||
                     e instanceof UserEmailAddressException ||
                     e instanceof UserIdException ||
                     e instanceof UserLockoutException ||
                     e instanceof UserPasswordException ||
                     e instanceof UserScreenNameException) {

                SessionErrors.add(request, e.getClass().getName());
            }
            else {
                PortalUtil.sendError(e, request, response);
            }
        }
        
        if (! SessionErrors.isEmpty(request)) {
            // url parameters
            Map<String, String> parameters = new HashMap<String, String>();
            //boolean isSigningInPopup = ParamUtil.getBoolean(actionRequest, "isSigningInPopup");

            parameters.put("isSigningIn", "true");

            redirect = Helper.modifyRedirectUrl(redirect, request, parameters);
            
        }

        SessionErrors.clear(request);
        SessionMessages.clear(request);
        
        response.sendRedirect(redirect);
    }
}
