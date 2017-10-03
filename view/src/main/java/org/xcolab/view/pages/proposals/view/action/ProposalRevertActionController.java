package org.xcolab.view.pages.proposals.view.action;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.xcolab.client.contest.pojo.templates.PlanSectionDefinition;
import org.xcolab.client.members.pojo.Member;
import org.xcolab.client.proposals.ProposalAttributeClientUtil;
import org.xcolab.client.proposals.ProposalClientUtil;
import org.xcolab.client.proposals.enums.ProposalAttributeKeys;
import org.xcolab.client.proposals.exceptions.ProposalNotFoundException;
import org.xcolab.client.proposals.pojo.Proposal;
import org.xcolab.client.proposals.pojo.phases.Proposal2Phase;
import org.xcolab.util.enums.proposal.PlanSectionTypeKeys;
import org.xcolab.view.auth.MemberAuthUtil;
import org.xcolab.view.pages.proposals.exceptions.ProposalsAuthorizationException;
import org.xcolab.view.pages.proposals.utils.context.ProposalContext;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/contests/{contestYear}/{contestUrlName}")
public class ProposalRevertActionController {

    @PostMapping("/c/{proposalUrlString}/{proposalId}/proposalRevert")
    public void showProposalRevert(HttpServletRequest request, HttpServletResponse response,
            Model model, ProposalContext proposalContext, Member currentMember)
            throws ProposalsAuthorizationException, IOException {

        if (proposalContext.getProposal() != null && !proposalContext.getPermissions()
                .getCanEdit()) {
            throw new ProposalsAuthorizationException(
                    "User is not allowed to edit proposal, user: " + currentMember.getUserId()
                            + ", proposal: " + proposalContext.getProposal().getProposalId());
        }

        long memberId = MemberAuthUtil.getMemberId(request);

        if (proposalContext.getProposal() != null) {
            Proposal oldProposalVersionToBeBecomeCurrent = proposalContext.getProposal();
            updateProposalSpecialAttributes(memberId, oldProposalVersionToBeBecomeCurrent);

            updateProposalAttributes(proposalContext, memberId,
                    oldProposalVersionToBeBecomeCurrent);

            response.sendRedirect(oldProposalVersionToBeBecomeCurrent.getProposalUrl());
        }
    }

    private void updateProposalAttributes(ProposalContext proposalContext, long userId,
            Proposal oldProposalVersionToBeBecomeCurrent) {
        boolean updateProposalReferences = false;
        for (PlanSectionDefinition section : oldProposalVersionToBeBecomeCurrent.getSections()) {
            String newSectionValue = section.getStringValue();
            if (section.getType() == PlanSectionTypeKeys.TEXT
                    || section.getType() == PlanSectionTypeKeys.PROPOSAL_LIST_TEXT_REFERENCE
                    || section.getType() == PlanSectionTypeKeys.DROPDOWN_MENU
                    || section.getType() == PlanSectionTypeKeys.CHECKBOX_OPTION) {

                ProposalAttributeClientUtil.setProposalAttribute(userId,
                        oldProposalVersionToBeBecomeCurrent.getProposalId(),
                        ProposalAttributeKeys.SECTION, section.getSectionDefinitionId(),
                        newSectionValue);

                if (section.getType() == PlanSectionTypeKeys.PROPOSAL_LIST_TEXT_REFERENCE) {
                    updateProposalReferences = true;
                }
            }
            if (section.getType() == PlanSectionTypeKeys.ONTOLOGY_REFERENCE) {
                if (StringUtils.isNumeric(newSectionValue)) {
                    long newNumericVal = Long.parseLong(newSectionValue);
                    if (newNumericVal != section.getNumericValue()) {
                        ProposalAttributeClientUtil.setProposalAttribute(userId,
                                oldProposalVersionToBeBecomeCurrent.getProposalId(),
                                ProposalAttributeKeys.SECTION, section.getSectionDefinitionId(),
                                newNumericVal);
                    }
                }
            }
            if (section.getType() == PlanSectionTypeKeys.PROPOSAL_REFERENCE) {
                if (StringUtils.isNumeric(newSectionValue) && StringUtils
                        .isNotBlank(newSectionValue)) {
                    final long newNumericValue = Long.parseLong(newSectionValue);
                    if (section.getNumericValue() != newNumericValue) {
                        ProposalAttributeClientUtil.setProposalAttribute(userId,
                                oldProposalVersionToBeBecomeCurrent.getProposalId(),
                                ProposalAttributeKeys.SECTION, section.getSectionDefinitionId(),
                                newNumericValue);
                        updateProposalReferences = true;
                    }
                } else if (StringUtils.isBlank(newSectionValue)) {
                    ProposalAttributeClientUtil.setProposalAttribute(userId,
                            oldProposalVersionToBeBecomeCurrent.getProposalId(),
                            ProposalAttributeKeys.SECTION, section.getSectionDefinitionId(), 0L);
                }
            }
            if (section.getType() == PlanSectionTypeKeys.PROPOSAL_LIST_REFERENCE) {
                StringBuilder cleanedReferences = new StringBuilder();
                if (StringUtils.isNotBlank(newSectionValue)) {
                    String[] referencedProposals = newSectionValue.split(",");
                    for (String referencedProposal : referencedProposals) {
                        if (StringUtils.isNotBlank(referencedProposal) && StringUtils
                                .isNumeric(referencedProposal)) {
                            cleanedReferences.append(referencedProposal).append(",");
                        }
                    }
                }
                if (!section.getStringValue().equals(cleanedReferences.toString())) {
                    ProposalAttributeClientUtil.setProposalAttribute(userId,
                            oldProposalVersionToBeBecomeCurrent.getProposalId(),
                            ProposalAttributeKeys.SECTION, section.getSectionDefinitionId(),
                            cleanedReferences.toString());
                    updateProposalReferences = true;
                }
            }
        }

        //this code was on the proposal add/update controller, if the user could edit and save ,
        // he might just want to revert
        // and leave it like that , so this code must be executed as well.
        final Proposal2Phase p2p = proposalContext.getProposal2Phase();
        try {
            if (p2p != null && p2p.getVersionTo() != -1) {
                // we are in a completed phase - need to adjust the end version
                final Proposal updatedProposal = proposalContext.getClients().getProposalClient()
                        .getProposal(oldProposalVersionToBeBecomeCurrent.getProposalId());
                p2p.setVersionTo(updatedProposal.getCurrentVersion());
                proposalContext.getClients().getProposalPhaseClient().updateProposal2Phase(p2p);
            }
            // extra check to reset dependencies from the old versions
            if (updateProposalReferences) {
                ProposalClientUtil.populateTableWithProposal(
                        oldProposalVersionToBeBecomeCurrent.getWrapped().getProposalId());
            }
        } catch (ProposalNotFoundException ignored) {

        }
    }

    private void updateProposalSpecialAttributes(long userId,
            Proposal oldProposalVersionToBeBecomeCurrent) {
        ProposalAttributeClientUtil
                .setProposalAttribute(userId, oldProposalVersionToBeBecomeCurrent.getProposalId(),
                        ProposalAttributeKeys.NAME,
                        0L, oldProposalVersionToBeBecomeCurrent.getName());
        ProposalAttributeClientUtil
                .setProposalAttribute(userId, oldProposalVersionToBeBecomeCurrent.getProposalId(),
                        ProposalAttributeKeys.PITCH,
                        0L, oldProposalVersionToBeBecomeCurrent.getPitch());
        ProposalAttributeClientUtil
                .setProposalAttribute(userId, oldProposalVersionToBeBecomeCurrent.getProposalId(),
                        ProposalAttributeKeys.DESCRIPTION,
                        0L, oldProposalVersionToBeBecomeCurrent.getDescription());
        ProposalAttributeClientUtil
                .setProposalAttribute(userId, oldProposalVersionToBeBecomeCurrent.getProposalId(),
                        ProposalAttributeKeys.TEAM,
                        0L, oldProposalVersionToBeBecomeCurrent.getTeam());
        ProposalAttributeClientUtil
                .setProposalAttribute(userId, oldProposalVersionToBeBecomeCurrent.getProposalId(),
                        ProposalAttributeKeys.IMAGE_ID,
                        0L, oldProposalVersionToBeBecomeCurrent.getImageId());
    }
}
