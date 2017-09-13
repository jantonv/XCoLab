package org.xcolab.view.pages.contestmanagement.controller.manager;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.xcolab.client.contest.pojo.Contest;
import org.xcolab.client.members.pojo.Member;
import org.xcolab.util.html.LabelValue;
import org.xcolab.view.auth.MemberAuthUtil;
import org.xcolab.view.errors.AccessDeniedPage;
import org.xcolab.view.pages.contestmanagement.entities.ContestManagerTabs;
import org.xcolab.view.pages.contestmanagement.entities.ContestMassAction;
import org.xcolab.view.pages.contestmanagement.entities.ContestMassActions;
import org.xcolab.view.pages.contestmanagement.entities.MassActionRequiresConfirmationException;
import org.xcolab.view.pages.contestmanagement.entities.massactions.OrderMassAction;
import org.xcolab.view.pages.contestmanagement.wrappers.ContestOverviewWrapper;
import org.xcolab.view.pages.contestmanagement.wrappers.MassActionConfirmationWrapper;
import org.xcolab.view.taglibs.xcolab.wrapper.TabWrapper;
import org.xcolab.view.util.entity.flash.AlertMessage;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.xcolab.view.pages.contestmanagement.utils.MassActionUtil.getContests;

@Controller
@RequestMapping("/admin/contest")
public class OverviewTabController extends AbstractTabController {

    static final private ContestManagerTabs tab = ContestManagerTabs.OVERVIEW;
    static final private String TAB_VIEW = "contestmanagement/manager/overviewTab";

    static final private String CONFIRM_VIEW_PATH =
            "contestmanagement/manager/massActionConfirmation/confirmMassAction";

    @ModelAttribute("currentTabWrapped")
    @Override
    public TabWrapper populateCurrentTabWrapped(HttpServletRequest request) {
        tabWrapper = new TabWrapper(tab, request, tabContext);
        request.getSession().setAttribute("tabWrapper", tabWrapper);
        return tabWrapper;
    }



    @ModelAttribute("massActionsItems")
    public List<LabelValue> populateMassActionsItems(HttpServletRequest request) {
        List<LabelValue> contestMassActionItems = new ArrayList<>();

        for (ContestMassActions contestMassAction : ContestMassActions.values()) {
            contestMassActionItems.add(new LabelValue((long) contestMassAction.ordinal(),
                    contestMassAction.getAction().getDisplayName()));
        }

        return contestMassActionItems;
    }

    @GetMapping({"", "manager"})
    public String showAdminTabController(HttpServletRequest request, HttpServletResponse response,
            Model model, Member member) {
        if (!tabWrapper.getCanView()) {
            return new AccessDeniedPage(member).toViewName(response);
        }
        setPageAttributes(request, model, tab);
        model.addAttribute("contestOverviewWrapper", new ContestOverviewWrapper(request));
        return TAB_VIEW;
    }

    @PostMapping("manager/update")
    public String updateContestOverviewTabController(HttpServletRequest request,
            HttpServletResponse response, Model model, Member member,
            @ModelAttribute ContestOverviewWrapper updateContestOverviewWrapper)
            throws IOException, InvocationTargetException, IllegalAccessException {
        if (!tabWrapper.getCanEdit()) {
            return new AccessDeniedPage(member).toViewName(response);
        }

        try {
            executeMassAction(request, response, updateContestOverviewWrapper);
            AlertMessage.CHANGES_SAVED.flash(request);
            return "redirect:/admin/contest/manager";
        } catch (MassActionRequiresConfirmationException e) {
            return showConfirmationView(model, updateContestOverviewWrapper);
        }
    }

    @PostMapping("manager/updateOrder")
    public void updateContestOrder(HttpServletRequest request, HttpServletResponse response,
            Model model, Member member,
            @ModelAttribute ContestOverviewWrapper updateContestOverviewWrapper)
            throws IOException, InvocationTargetException, IllegalAccessException {
        if (!tabWrapper.getCanEdit()) {
            response.sendError(403);
        }
        List<Contest> contests = updateContestOverviewWrapper.getContestWrappers();
        OrderMassAction orderMassAction = (OrderMassAction) ContestMassActions.ORDER.getAction();
        orderMassAction.execute(contests);
    }

    @PostMapping("api/massAction")
    public void getExportController(HttpServletRequest request, Model model,
            @ModelAttribute ContestOverviewWrapper updateContestOverviewWrapper,
            HttpServletResponse response) throws InvocationTargetException, IllegalAccessException {
        if (!tabWrapper.getCanEdit()) {
            return;
        }
        try {
            executeMassAction(request, response, updateContestOverviewWrapper);
        } catch (MassActionRequiresConfirmationException | IOException ignored) {
        }
    }

    private String showConfirmationView(Model model,
            ContestOverviewWrapper contestOverviewWrapper) throws IllegalStateException {
        List<Long> contestIds = contestOverviewWrapper.getSelectedContestIds();
        int massActionIndex = contestOverviewWrapper.getSelectedMassAction().intValue();
        model.addAttribute("massActionConfirmationWrapper",
                new MassActionConfirmationWrapper(contestIds, massActionIndex));

        return CONFIRM_VIEW_PATH;
    }

    private ContestMassActions getMassActionWrapper(ContestOverviewWrapper contestOverviewWrapper)
            throws IllegalArgumentException {
        int massActionIndex = contestOverviewWrapper.getSelectedMassAction().intValue();
        if (massActionIndex > ContestMassActions.values().length) {
            throw new IllegalArgumentException("Illegal mass action index");
        }
        return ContestMassActions.values()[massActionIndex];
    }

    private void executeMassAction(HttpServletRequest request, HttpServletResponse response,
            ContestOverviewWrapper contestOverviewWrapper)
            throws MassActionRequiresConfirmationException, IOException {
        contestOverviewWrapper.setMemberId(MemberAuthUtil.getMemberId(request));

        ContestMassActions actionWrapper = getMassActionWrapper(contestOverviewWrapper);
        ContestMassAction action = actionWrapper.getAction();
        List<Long> contestIds = contestOverviewWrapper.getSelectedContestIds();
        List<Contest> contests = getContests(contestIds);

        action.execute(contests, false, contestOverviewWrapper, response);
    }

}
