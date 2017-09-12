package org.xcolab.view.pages.contestmanagement.utils;

import org.xcolab.client.admin.attributes.configuration.ConfigurationAttributeKey;
import org.xcolab.client.contest.ContestClientUtil;
import org.xcolab.client.contest.enums.ContestStatus;
import org.xcolab.client.contest.exceptions.ContestNotFoundException;
import org.xcolab.client.contest.pojo.Contest;
import org.xcolab.client.contest.pojo.phases.ContestPhase;
import org.xcolab.client.contest.pojo.phases.ContestPhaseType;
import org.xcolab.client.emails.EmailClient;
import org.xcolab.client.members.MessagingClient;
import org.xcolab.client.members.pojo.Member;
import org.xcolab.client.proposals.ProposalClientUtil;
import org.xcolab.client.proposals.pojo.Proposal;
import org.xcolab.util.html.HtmlUtil;
import org.xcolab.view.auth.MemberAuthUtil;
import org.xcolab.view.pages.contestmanagement.beans.ContestFlagTextToolTipBean;
import org.xcolab.view.pages.contestmanagement.beans.ContestModelSettingsBean;
import org.xcolab.view.pages.contestmanagement.beans.MassMessageBean;
import org.xcolab.view.pages.contestmanagement.entities.MassActionRequiresConfirmationException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ContestMassActionMethods {

    private static final List<String> CSV_EXPORT_HEADER =
            Arrays.asList("Contest", "Proposal Title", "Proposal Link", "Username", "First Name",
                    "Last Name", "Email Address", "Role", "Last phase");

    public static void reportOfPeopleInCurrentPhase(List<Long> contestList,
            Object ResourceResponseObject, HttpServletRequest request) throws IOException {

        HttpServletResponse response = (HttpServletResponse) ResourceResponseObject;
        CsvExportHelper csvExportHelper = new CsvExportHelper();
        csvExportHelper.addRowToExportData(CSV_EXPORT_HEADER);

        for (Long contestId : contestList) {
            Contest c = ContestClientUtil.getContest(contestId);
            if (!c.getIsSharedContestInForeignColab()) {
                List<Proposal> proposalsInActiveContestPhase =
                        getProposalsInActiveContestPhase(contestId);
                ContestPhase activeContestPhase = ContestClientUtil.getActivePhase(contestId);
                csvExportHelper
                        .addProposalAndAuthorDetailsToExportData(proposalsInActiveContestPhase,
                                activeContestPhase);
            }
        }

        String exportFileName = "reportOfPeopleInCurrentPhase";
        csvExportHelper.initiateDownload(exportFileName, response);
    }

    public static List<Proposal> getProposalsInActiveContestPhase(Long contestPK) {
        ContestPhase activeContestPhase = ContestClientUtil.getActivePhase(contestPK);
        return ProposalClientUtil
                .getActiveProposalsInContestPhase(activeContestPhase.getContestPhasePK());
    }

    public static void changeSubscriptionStatus(List<Long> contestList,
            Object subscriptionStatusObject,
            HttpServletRequest request) {
        long memberId = MemberAuthUtil.getMemberId(request);
        for (Long contestId : contestList) {
            Contest contest = ContestClientUtil.getContest(contestId);
            if (!contest.getIsSharedContestInForeignColab()) {
                boolean subscriptionStatus = (boolean) subscriptionStatusObject;
                if (subscriptionStatus) {
                    ContestClientUtil.subscribeMemberToContest(contestId, memberId);
                } else {
                    ContestClientUtil.unsubscribeMemberFromContest(contestId, memberId);
                }
            }
        }
    }

    public static void setModelSettings(List<Long> contestList, Object modelSettings,
            HttpServletRequest request) {
        for (Long contestId : contestList) {
            try {
                Contest contest = ContestClientUtil.getContest(contestId);
                if (!contest.getIsSharedContestInForeignColab()) {
                    ContestModelSettingsBean contestModelSettingsBean =
                            (ContestModelSettingsBean) modelSettings;
                    contestModelSettingsBean.persist(contest);
                }
            } catch (ContestNotFoundException ignored) {

            }
        }
    }
}
