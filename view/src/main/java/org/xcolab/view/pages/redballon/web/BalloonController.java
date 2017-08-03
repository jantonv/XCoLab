package org.xcolab.view.pages.redballon.web;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import org.xcolab.client.admin.attributes.configuration.ConfigurationAttributeKey;
import org.xcolab.client.balloons.BalloonsClient;
import org.xcolab.client.balloons.exceptions.BalloonLinkNotFoundException;
import org.xcolab.client.balloons.exceptions.BalloonTextNotFoundException;
import org.xcolab.client.balloons.pojo.BalloonLink;
import org.xcolab.client.balloons.pojo.BalloonText;
import org.xcolab.client.balloons.pojo.BalloonUserTracking;
import org.xcolab.client.members.pojo.Member;
import org.xcolab.entity.utils.LinkUtils;
import org.xcolab.view.pages.redballon.utils.BalloonService;
import org.xcolab.view.pages.redballon.web.beans.UserEmailBean;

import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

@Controller
public class BalloonController {

    private static final String HOME_VIEW = "redballoon/view";
    private static final String SHARE_VIEW = "redballoon/sharePage";

    private final BalloonService balloonService;

    @Autowired
    public BalloonController(BalloonService balloonService) {
        this.balloonService = balloonService;
    }

    @GetMapping("/snp/{context}")
    public String showBalloon(HttpServletRequest request, HttpServletResponse response,
            Model model, Member member, @PathVariable String context) {
        if (!context.equals(ConfigurationAttributeKey.SNP_CONTEXT.get())) {
            return "redirect:/snp/" + ConfigurationAttributeKey.SNP_CONTEXT.get();
        }

        BalloonUserTracking but = balloonService.getOrCreateBalloonUserTracking(request, response,
                null, null, context);
        try {
            BalloonLink balloonLink = BalloonsClient.getLinkByBalloonUserTrackingUuid(but.getUuid_());
            return "redirect:" + balloonLink.getTargetUrl();
        } catch (BalloonLinkNotFoundException e) {
            // user has no link -> continue and show page
        }

        if (but.getBalloonTextId() != null && but.getBalloonTextId() > 0) {
            BalloonText text;
            try {
                text = BalloonsClient.getBalloonText(but.getBalloonTextId());

            } catch (BalloonTextNotFoundException e) {
                text = null;
            }

            model.addAttribute("balloonText", text);
        }

        if (!model.containsAttribute("userEmailBean")) {
            UserEmailBean ueb = new UserEmailBean();

            if (member != null && member.getId_() > 0) {
                ueb.setEmail(member.getEmailAddress());
            }
            model.addAttribute("userEmailBean", ueb);
        }
        return HOME_VIEW;
    }

    @PostMapping("/snp/{context}")
    public String requestLink(HttpServletRequest request, HttpServletResponse response,
            Model model, Member member, @PathVariable String context,
            @Valid UserEmailBean userEmailBean, BindingResult bindingResult)
            throws BalloonTextNotFoundException {

        if (!context.equals(ConfigurationAttributeKey.SNP_CONTEXT.get())) {
            return "redirect:/snp/" + ConfigurationAttributeKey.SNP_CONTEXT.get();
        }

        populateModelWithModalTexts(model);

        if (userEmailBean == null || bindingResult.hasErrors()) {
            return showBalloon(request, response, model, member, context);
        }

        BalloonUserTracking but = balloonService
                .getOrCreateBalloonUserTracking(request, response, null, null, context);

        try {
            BalloonLink balloonLink = BalloonsClient.getLinkByBalloonUserTrackingUuid(but.getUuid_());
            return "redirect:" + balloonLink.getTargetUrl();
        } catch (BalloonLinkNotFoundException e) {
            // user has no link -> continue and create one
        }

        but.setEmail(userEmailBean.getEmail());
        but.setFormFiledDate(new Timestamp(new Date().getTime()));

        BalloonsClient.updateBalloonUserTracking(but);

        // create link to be used by user
        final BalloonLink link = balloonService
                .createBalloonLink(context, userEmailBean.getEmail(), but);

        return "redirect:" + link.getTargetUrl();
    }

    @GetMapping(BalloonService.SNP_LINK_URL)
    public String showLink(HttpServletRequest request, HttpServletResponse response,
            Model model, Member member,
            @PathVariable(required = false) String linkUuid,
            @PathVariable(required = false) String context)
            throws ParserConfigurationException {

        if (!context.equals(ConfigurationAttributeKey.SNP_CONTEXT.get())) {
            return "redirect:/snp/" + ConfigurationAttributeKey.SNP_CONTEXT.get();
        }

        populateModelWithModalTexts(model);

        BalloonUserTracking but = null;
        if (linkUuid != null) {

            BalloonLink link;
            try {
                link = BalloonsClient.getBalloonLink(linkUuid);
            } catch (BalloonLinkNotFoundException e) {
                link = null;
            }

            if (link != null) {
                model.addAttribute("balloonLink", link);

                // get user tracking information, if user is new, then owner of this link should be set as a parent
                but = balloonService.getOrCreateBalloonUserTracking(request, response, link.getBalloonUserUuid(), linkUuid,
                        context);

                link.setVisits(link.getVisits() + 1);
                BalloonsClient.updateBalloonLink(link);

            }
        }

        if (but == null) {
            // user wasn't following any link so we need to create new root of a reference tree
            but = balloonService.getOrCreateBalloonUserTracking(request, response, null, null,
                    context);
        }
        if (but.getBalloonTextId() != null && but.getBalloonTextId() > 0) {
            BalloonText text;
            try {
                text = BalloonsClient.getBalloonText(but.getBalloonTextId());

            } catch (BalloonTextNotFoundException e) {
                text = null;
            }

            model.addAttribute("balloonText", text);
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();

            Element element = doc.createElement("meta");

            element.setAttribute("property", "og:title");
            element.setAttribute("content", text != null ? text.getShareTitle() : "");


            model.addAttribute("meta1", element);
            element = doc.createElement("meta");
            element.setAttribute("property", "og:description");
            element.setAttribute("content", text != null ? text.getShareDescription() : "");


            model.addAttribute("meta2", element);
        }

        if (StringUtils.isNotBlank(but.getEmail())) {
            try {
                BalloonLink bl = BalloonsClient.getLinkByBalloonUserTrackingUuid(but.getUuid_());
                model.addAttribute("shareLink", LinkUtils.getAbsoluteUrl(bl.getTargetUrl()));
                model.addAttribute("balloonLink", bl);
                return SHARE_VIEW;
            } catch (BalloonLinkNotFoundException e) {
                //fall through
            }
        }

        return showBalloon(request, response, model, member, context);
    }

    private void populateModelWithModalTexts(Model model) {
        final String lang = LocaleContextHolder.getLocale().getLanguage();

        final String consentFormText = ConfigurationAttributeKey.SNP_CONSENT_FORM_TEXT.get(lang);
        final String exampleText = ConfigurationAttributeKey.SNP_EXAMPLE_TEXT.get(lang);
        model.addAttribute("consentFormText", consentFormText);
        model.addAttribute("exampleText", exampleText);
    }
}
