package org.xcolab.view.pages.proposals.view.proposal.tabs;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.xcolab.client.admin.enums.ConfigurationAttributeKey;
import org.xcolab.client.contest.ContestClientUtil;
import org.xcolab.client.contest.pojo.Contest;
import org.xcolab.client.contest.pojo.ContestType;
import org.xcolab.client.contest.pojo.phases.ContestPhase;
import org.xcolab.client.contest.pojo.templates.PlanSectionDefinition;
import org.xcolab.client.flagging.FlaggingClient;
import org.xcolab.client.members.pojo.Member;
import org.xcolab.client.proposals.ProposalClient;
import org.xcolab.client.proposals.ProposalMoveClient;
import org.xcolab.client.proposals.pojo.ContestTypeProposal;
import org.xcolab.client.proposals.pojo.Proposal;
import org.xcolab.client.proposals.pojo.phases.ProposalMoveHistory;
import org.xcolab.view.util.entity.EntityGroupingUtil;
import org.xcolab.view.util.entity.enums.ContestPhaseTypeValue;
import org.xcolab.view.util.entity.flash.AlertMessage;
import org.xcolab.util.enums.flagging.TargetType;
import org.xcolab.util.enums.proposal.MoveType;
import org.xcolab.view.errors.ErrorText;
import org.xcolab.view.pages.proposals.exceptions.ProposalsAuthorizationException;
import org.xcolab.view.pages.proposals.permissions.ProposalsPermissions;
import org.xcolab.view.pages.proposals.requests.JudgeProposalFeedbackBean;
import org.xcolab.view.pages.proposals.requests.UpdateProposalDetailsBean;
import org.xcolab.view.pages.proposals.utils.context.ClientHelper;
import org.xcolab.view.pages.proposals.utils.context.ProposalsContext;
import org.xcolab.view.pages.proposals.utils.context.ProposalsContextUtil;
import org.xcolab.view.pages.proposals.view.proposal.AddUpdateProposalControllerUtil;
import org.xcolab.view.pages.proposals.wrappers.ProposalJudgeWrapper;
import org.xcolab.view.pages.proposals.tabs.ProposalTab;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
@RequestMapping("/contests/{contestYear}/{contestUrlName}")
public class ProposalDescriptionTabController extends BaseProposalTabController {

    private final ProposalsContext proposalsContext;

    @Autowired
    public ProposalDescriptionTabController(ProposalsContext proposalsContext) {
        Assert.notNull(proposalsContext, "ProposalsContext bean is required");
        this.proposalsContext = proposalsContext;
    }

    @GetMapping("c/{proposalUrlString}/{proposalId}")
    public String showProposalDetails(HttpServletRequest request, HttpServletResponse response,
            Model model, @PathVariable Long contestYear,
            @PathVariable String contestUrlName, @PathVariable Long proposalId,
            @RequestParam(defaultValue = "false") boolean voted,
            @RequestParam(defaultValue = "false") boolean edit,
            @RequestParam(required = false) Integer version,
            @RequestParam(required = false) Long moveFromContestPhaseId,
            @RequestParam(required = false) String moveType,
            @Valid JudgeProposalFeedbackBean judgeProposalFeedbackBean,
            BindingResult bindingResult) {
        return showProposalDetails(request, model, voted, edit, moveFromContestPhaseId, moveType);
    }

    private String showProposalDetails(HttpServletRequest request, Model model,
            boolean voted, boolean edit, Long moveFromContestPhaseId, String moveType) {
        setCommonModelAndPageAttributes(request, model, ProposalTab.DESCRIPTION);

        boolean editValidated = false;
        final ProposalsPermissions proposalsPermissions = proposalsContext.getPermissions(request);
        if (edit && proposalsPermissions.getCanEdit()) {
            editValidated = true;
        }
        model.addAttribute("edit", editValidated);
        model.addAttribute("voted", voted);
        model.addAttribute("reportTargets", FlaggingClient.listReportTargets(TargetType.PROPOSAL));

        final Proposal proposal = proposalsContext.getProposal(request);
        final Proposal proposalWrapped = proposalsContext.getProposalWrapped(request);

        final ClientHelper clients = ProposalsContextUtil.getClients(request);
        final ProposalClient proposalClient = clients.getProposalClient();
        final Contest baseContest = proposalClient
                .getCurrentContestForProposal(proposal.getProposalId());

        if (voted) {
            setVotingDeadline(request, model, baseContest);
        }

        final boolean isMove = moveFromContestPhaseId != null && moveType != null;
        if (isMove) {
            // get base proposal from base contest
            ContestPhase baseContestPhase =
                    ContestClientUtil.getActivePhase(baseContest.getContestPK());

            Proposal baseProposalWrapped = new Proposal(proposal, proposal.getCurrentVersion(),
                    baseContest, baseContestPhase, null);

            UpdateProposalDetailsBean updateProposalDetailsBean = new UpdateProposalDetailsBean(
                    proposalWrapped, baseProposalWrapped, true, MoveType.valueOf(moveType));
            updateProposalDetailsBean.setMoveFromContestPhaseId(moveFromContestPhaseId);
            updateProposalDetailsBean.setMoveToContestId(baseContestPhase.getContestPhasePK());

            model.addAttribute("hasUnmappedSections",
                    hasUnmappedSections(proposalWrapped, baseProposalWrapped));
            model.addAttribute("baseProposal", baseProposalWrapped);
            model.addAttribute("baseContest", baseContest);
            model.addAttribute("isMove", true);

            if (!model.containsAttribute("updateProposalDetailsBean")) {
                model.addAttribute("updateProposalDetailsBean", updateProposalDetailsBean);
            }
        } else if (!model.containsAttribute("updateProposalDetailsBean")) {
            model.addAttribute("updateProposalDetailsBean", new UpdateProposalDetailsBean(
                    proposalWrapped));
        }

        if (editValidated || isMove) {
            request.setAttribute("imageUploadServiceUrl",
                    ConfigurationAttributeKey.IMAGE_UPLOAD_EXTERNAL_SERVICE_URL.get());
            request.setAttribute("imageUploadHelpText",
                    ConfigurationAttributeKey.IMAGE_UPLOAD_HELP_TEXT.get());

            model.addAttribute("mustFilterContent",
                    ConfigurationAttributeKey.FILTER_PROFANITY.get());

            return "proposals/proposalDetails_edit";
        }

        if (proposalsPermissions.getCanJudgeActions()) {
            setJudgeProposalBean(model, request);
        }

        setLinkedProposals(request, model, proposal);
        final Contest contest = proposalsContext.getContest(request);
        populateMoveHistory(request, model, proposal, contest);

        return "proposals/proposalDetails";
    }

    private boolean hasUnmappedSections(Proposal proposalWrapped, Proposal baseProposalWrapped) {
        Set<Long> newContestSections = proposalWrapped.getSections().stream()
                .map(PlanSectionDefinition::getSectionDefinitionId)
                .collect(Collectors.toSet());

        return baseProposalWrapped.getSections().stream()
                .filter(section -> StringUtils.isNotBlank(section.getContent()))
                .anyMatch(section -> !newContestSections.contains(section.getSectionDefinitionId()));
    }

    private void populateMoveHistory(HttpServletRequest request, Model model, Proposal proposal,
            Contest contest) {

        final ClientHelper clients = ProposalsContextUtil.getClients(request);
        final ProposalMoveClient proposalMoveClient = clients.getProposalMoveClient();
        List<ProposalMoveHistory> sourceMoveHistories = proposalMoveClient
                        .getBySourceProposalIdContestId(proposal.getProposalId(),
                                contest.getContestPK());
        model.addAttribute("sourceMoveHistories", sourceMoveHistories);

        ProposalMoveHistory targetMoveHistory = proposalMoveClient
                        .getByTargetProposalIdContestId(proposal.getProposalId(),
                                contest.getContestPK());
        if (targetMoveHistory != null) {
            model.addAttribute("targetMoveHistory", targetMoveHistory);
        }
    }

    private void setLinkedProposals(HttpServletRequest request, Model model, Proposal proposal) {
        final ClientHelper clients = ProposalsContextUtil.getClients(request);
        final ProposalClient proposalClient = clients.getProposalClient();
        List<Proposal> linkedProposals = proposalClient
                        .getSubproposals(proposal.getProposalId(), true);
        Map<ContestType, List<Proposal>> proposalsByContestType =
                EntityGroupingUtil.groupByContestType(linkedProposals);
        Map<Long, ContestTypeProposal> contestTypeProposalWrappersByContestTypeId = new HashMap<>();

        for (ContestType contestType : clients.getContestClient()
                .getActiveContestTypes()) {
            contestTypeProposalWrappersByContestTypeId.put(contestType.getId_(),
                    new ContestTypeProposal(contestType));
            final List<Proposal> proposalsInContestType = proposalsByContestType.get(contestType);
            if (proposalsInContestType != null) {
                for (Proposal p : proposalsInContestType) {
                    contestTypeProposalWrappersByContestTypeId.get(contestType.getId_())
                            .getProposals().add((p));
                }
            }
        }
        model.addAttribute("linkedProposalContestTypeProposalWrappersByContestTypeId",
                contestTypeProposalWrappersByContestTypeId);
    }

    private void setJudgeProposalBean(Model model, HttpServletRequest request) {
        final JudgeProposalFeedbackBean judgeProposalFeedbackBean =
                (JudgeProposalFeedbackBean) model.asMap().get("judgeProposalFeedbackBean");
        if (judgeProposalFeedbackBean == null
                || judgeProposalFeedbackBean.getContestPhaseId() == null) {

            final Proposal proposal = proposalsContext.getProposalWrapped(request);
            final Member member = proposalsContext.getMember(request);
            final ContestPhase contestPhase = proposalsContext.getContestPhase(request);

            ProposalJudgeWrapper proposalJudgeWrapper = new ProposalJudgeWrapper(proposal, member);
            JudgeProposalFeedbackBean judgeProposalBean =
                    new JudgeProposalFeedbackBean(proposalJudgeWrapper);
            judgeProposalBean.setContestPhaseId(contestPhase.getContestPhasePK());

            model.addAttribute("judgeProposalFeedbackBean", judgeProposalBean);
        }
    }

    private void setVotingDeadline(HttpServletRequest request, Model model, Contest baseContest) {
        Date votingDeadline = getVotingDeadline(baseContest, request);
        if (votingDeadline != null) {
            final DateFormat customDateFormat = new SimpleDateFormat("MMMM dd, YYYY", Locale.US);
            model.addAttribute("votingDeadline", customDateFormat.format(votingDeadline));
        } else {
            model.addAttribute("votingDeadline", "");
        }
    }

    private Date getVotingDeadline(Contest contest, HttpServletRequest request) {
        List<ContestPhase> contestPhases = proposalsContext.getClients(request).getContestClient()
                .getAllContestPhases(contest.getContestPK());
        final ContestPhase activeVotingPhase = getActiveVotingPhase(contestPhases);
        if (activeVotingPhase != null) {
            return activeVotingPhase.getPhaseEndDate();
        }
        return null;
    }

    private ContestPhase getActiveVotingPhase(List<ContestPhase> contestPhases) {
        for (ContestPhase phase : contestPhases) {
            if (phase.getContestPhaseType() == ContestPhaseTypeValue.SELECTION_OF_WINNERS.getTypeId() ||
                    phase.getContestPhaseType() == ContestPhaseTypeValue.SELECTION_OF_WINNERS_NEW.getTypeId() ||
                    phase.getContestPhaseType() == ContestPhaseTypeValue.WINNERS_SELECTION.getTypeId() ||
                    phase.getContestPhaseType() == ContestPhaseTypeValue.VOTING_PHASE_SOLVE.getTypeId()
                    ) {
                if (phase.getPhaseActive()) {
                    return phase;
                }
            }
        }

        return null;
    }

    @PostMapping("c/{proposalUrlString}/{proposalId}")
    public String updateProposal(HttpServletRequest request, HttpServletResponse response, Model model,
            @PathVariable String contestYear, @PathVariable String contestUrlName,
            @PathVariable String proposalUrlString, @PathVariable String proposalId,
            @Valid UpdateProposalDetailsBean updateProposalDetailsBean, BindingResult result)
            throws ProposalsAuthorizationException, IOException {

        Proposal proposal = proposalsContext.getProposal(request);
        final ProposalsPermissions permissions = proposalsContext.getPermissions(request);
        if (proposal != null && !permissions.getCanEdit()) {
            return ErrorText.ACCESS_DENIED.flashAndReturnView(request);
        }

        if (result.hasErrors()) {
            AlertMessage.danger(
                    "Changes NOT saved. Please fix the errors before saving.")
                    .flash(request);
            return showProposalDetails(request, model, false, true, null, null);
        }

        return AddUpdateProposalControllerUtil
                .createOrUpdateProposal(request, updateProposalDetailsBean, proposal, proposalsContext);
    }
}