package org.xcolab.view.pages.proposals.view.contest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.xcolab.client.admin.attributes.configuration.ConfigurationAttributeKey;
import org.xcolab.client.contest.ContestClientUtil;
import org.xcolab.client.contest.enums.ContestStatus;
import org.xcolab.client.contest.pojo.Contest;
import org.xcolab.client.contest.pojo.phases.ContestPhase;
import org.xcolab.client.members.PermissionsClient;
import org.xcolab.client.members.pojo.Member;
import org.xcolab.client.proposals.ProposalClient;
import org.xcolab.client.proposals.ProposalPhaseClient;
import org.xcolab.client.proposals.exceptions.Proposal2PhaseNotFoundException;
import org.xcolab.client.proposals.pojo.Proposal;
import org.xcolab.client.proposals.pojo.phases.Proposal2Phase;
import org.xcolab.util.http.caching.CacheName;
import org.xcolab.view.pages.proposals.exceptions.ProposalIdOrContestIdInvalidException;
import org.xcolab.view.pages.proposals.exceptions.ProposalsAuthorizationException;
import org.xcolab.view.pages.proposals.utils.context.ClientHelper;
import org.xcolab.view.pages.proposals.utils.context.ProposalContext;
import org.xcolab.view.pages.proposals.view.proposal.BaseProposalsController;
import org.xcolab.view.pages.proposals.wrappers.ProposalJudgeWrapper;
import org.xcolab.view.pages.proposals.wrappers.SortedProposalList;
import org.xcolab.view.util.entity.enums.MemberRole;
import org.xcolab.view.util.pagination.SortFilterPage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ContestProposalsController extends BaseProposalsController {

    @GetMapping("/contests/{contestYear}/{contestUrlName}/phase/{phaseId}")
    public String showContestProposalsWithContestPhaseId(HttpServletRequest request,
            HttpServletResponse response, Model model, Member loggedInMember,
            ProposalContext proposalContext, @PathVariable String contestYear,
            @PathVariable String contestUrlName, @PathVariable String phaseId,
            final SortFilterPage sortFilterPage) {
        setBasePageAttributes(proposalContext, model);
        return showContestProposalsPage(model, proposalContext,
                sortFilterPage, loggedInMember);
    }

    @GetMapping("/contests/{contestYear}/{contestUrlName}")
    public String showContestProposals(HttpServletRequest request, HttpServletResponse response,
            Model model, Member loggedInMember, ProposalContext proposalContext,
            @PathVariable String contestYear, @PathVariable String contestUrlName,
            final SortFilterPage sortFilterPage) {
        setBasePageAttributes(proposalContext, model);
        return showContestProposalsPage(model, proposalContext, sortFilterPage, loggedInMember);
    }

    private String showContestProposalsPage(Model model, ProposalContext proposalContext,
            final SortFilterPage sortFilterPage, Member loggedInMember) {

        ContestPhase contestPhase = proposalContext.getContestPhase();
        Contest contest = proposalContext.getContest();

        if (contest == null || contestPhase == null) {
            throw new ProposalIdOrContestIdInvalidException();
        }

        final ClientHelper clients = proposalContext.getClients();
        final ProposalClient proposalClient = clients.getProposalClient();

        final List<Proposal> activeProposals;
        final ContestStatus phaseStatus = contestPhase.getStatus();
        switch (phaseStatus) {
            case OPEN_FOR_SUBMISSION:
            case OPEN_FOR_EDIT:
                activeProposals = proposalClient.getActiveProposalsInContestPhase(
                        contestPhase.getContestPhasePK());
                break;
            default:
                activeProposals = proposalClient.getActiveProposalsInContestPhase(
                        contestPhase.getContestPhasePK(), CacheName.PROPOSAL_LIST_CLOSED);
        }

        List<Proposal> proposals = new ArrayList<>();
        for (Proposal proposal : activeProposals) {

            try {
                final ProposalPhaseClient proposalPhaseClient = clients.getProposalPhaseClient();
                Proposal2Phase p2p = proposalPhaseClient.getProposal2PhaseByProposalIdContestPhaseId(proposal.getProposalId(), contestPhase.getContestPhasePK());
                Proposal proposalWrapper;

                if (loggedInMember != null && PermissionsClient.memberHasRole(loggedInMember.getUserId(), MemberRole.JUDGE.getRoleId())) {
                    proposalWrapper = new ProposalJudgeWrapper(proposal, p2p.getVersionTo() == -1 ? proposal.getCurrentVersion() : p2p.getVersionTo(), contest, contestPhase, p2p, loggedInMember);

                } else {
                    proposalWrapper = new Proposal(proposal, p2p.getVersionTo() == -1 ? proposal.getCurrentVersion() : p2p.getVersionTo(), contest, contestPhase, p2p);
                }

                proposals.add(proposalWrapper);
            } catch (Proposal2PhaseNotFoundException ignored) {

            }
        }

        model.addAttribute("sortFilterPage", sortFilterPage);
        model.addAttribute("proposals", new SortedProposalList(proposals, sortFilterPage,
                contestPhase));
        model.addAttribute("showCountdown",
                ConfigurationAttributeKey.SHOW_CONTEST_COUNTDOWN.get());
        model.addAttribute("defaultTimeZoneId",
            ConfigurationAttributeKey.DEFAULT_TIME_ZONE_ID.get());
        model.addAttribute("showContributorsColumn",
            ConfigurationAttributeKey.CONTESTS_ALLOW_OPEN_PROPOSALS.get());

        boolean showEditLink = false;
        if (loggedInMember != null) {
            showEditLink = PermissionsClient.canAdminAll(loggedInMember.getUserId())
                    || contest.getCanFellow(loggedInMember.getUserId());
        }
        model.addAttribute("showEditLink", showEditLink);

        setBasePageAttributes(proposalContext, model);
        return "/proposals/contestProposals";
    }

    @PostMapping("/contests/subscribeContest")
    public void handleAction(HttpServletRequest request, HttpServletResponse response,
            Model model, Member currentMember, ProposalContext proposalContext)
            throws ProposalsAuthorizationException, IOException {

        if (proposalContext.getPermissions().getCanSubscribeContest()) {
            long contestId = proposalContext.getContest().getContestPK();
            long memberId = currentMember.getUserId();
            if (ContestClientUtil.isMemberSubscribedToContest(contestId, memberId)) {
                ContestClientUtil.unsubscribeMemberFromContest(contestId, memberId);
            }
            else {
                ContestClientUtil.subscribeMemberToContest(contestId, memberId);

            }
            response.sendRedirect(proposalContext.getContest().getContestLinkUrl());
        } else {
            throw new ProposalsAuthorizationException("User isn't allowed to subscribe contest");
        }
    }

    @PostMapping("/contests/assignAllJudges")
    public void assignAllJudges(HttpServletRequest request, HttpServletResponse response,
            Member currentMember, ProposalContext proposalContext)
            throws ProposalsAuthorizationException, IOException {

    }

    @PostMapping("/contests/removeRemainingJudges")
    public void removeRemainingJudges(HttpServletRequest request, HttpServletResponse response,
            Member currentMember, ProposalContext proposalContext)
            throws ProposalsAuthorizationException, IOException {

    }

}


