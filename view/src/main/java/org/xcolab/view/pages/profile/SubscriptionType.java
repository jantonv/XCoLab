package org.xcolab.view.pages.profile;

import org.xcolab.client.activities.pojo.ActivitySubscription;
import org.xcolab.client.admin.ContestTypeClient;
import org.xcolab.client.admin.attributes.configuration.ConfigurationAttributeKey;
import org.xcolab.client.admin.pojo.ContestType;
import org.xcolab.util.activities.enums.ActivityCategory;

public enum SubscriptionType {
    DISCUSSION(ActivityEntryType.DISCUSSION.getPrimaryTypeId()),
    PROPOSAL(ActivityEntryType.PROPOSAL.getPrimaryTypeId()),
    CONTEST(ActivityEntryType.CONTEST.getPrimaryTypeId());

    private final Long className;

    SubscriptionType(Long className) {
        this.className = className;
    }

    public static SubscriptionType getSubscriptionType(ActivitySubscription subscription) {
        for (SubscriptionType type : SubscriptionType.values()) {
            if (type.className.equals(subscription.getClassNameId())) {
                return type;
            }
        }
        return null;
    }

    public String getPrintName() {
        if (this == SubscriptionType.DISCUSSION) {
            return "Discussion";
        } else {
            final long contestTypeId = ConfigurationAttributeKey
                    .DEFAULT_CONTEST_TYPE_ID.get();
            ContestType contestType = ContestTypeClient.getContestType(contestTypeId);

            if (this == SubscriptionType.PROPOSAL) {
                return contestType != null ? contestType.getProposalName() : "Proposal";
            }
            if (this == SubscriptionType.CONTEST) {
                return contestType != null ? contestType.getContestName() : "Contest";
            }
            return "Other";
        }
    }
}
