/**
 * This class is generated by jOOQ
 */
package org.xcolab.client.proposals.pojo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.core.ParameterizedTypeReference;
import org.xcolab.util.http.client.types.TypeProvider;

import javax.annotation.Generated;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.8.2"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProposalVote implements Serializable {

    private static final long serialVersionUID = 1984862370;


    public static final TypeProvider<ProposalVote> TYPES =
            new TypeProvider<>(ProposalVote.class,
                    new ParameterizedTypeReference<List<ProposalVote>>() {
                    });

    private Long      proposalid;
    private Long      contestphaseid;
    private Long      userid;
    private Timestamp createdate;
    private Boolean   isvalid;
    private Timestamp confirmationemailsenddate;
    private String    confirmationtoken;

    public ProposalVote() {}

    public ProposalVote(ProposalVote value) {
        this.proposalid = value.proposalid;
        this.contestphaseid = value.contestphaseid;
        this.userid = value.userid;
        this.createdate = value.createdate;
        this.isvalid = value.isvalid;
        this.confirmationemailsenddate = value.confirmationemailsenddate;
        this.confirmationtoken = value.confirmationtoken;
    }

    public ProposalVote(
        Long      proposalid,
        Long      contestphaseid,
        Long      userid,
        Timestamp createdate,
        Boolean   isvalid,
        Timestamp confirmationemailsenddate,
        String    confirmationtoken
    ) {
        this.proposalid = proposalid;
        this.contestphaseid = contestphaseid;
        this.userid = userid;
        this.createdate = createdate;
        this.isvalid = isvalid;
        this.confirmationemailsenddate = confirmationemailsenddate;
        this.confirmationtoken = confirmationtoken;
    }

    public Long getProposalId() {
        return this.proposalid;
    }

    public void setProposalId(Long proposalid) {
        this.proposalid = proposalid;
    }

    public Long getContestPhaseId() {
        return this.contestphaseid;
    }

    public void setContestPhaseId(Long contestphaseid) {
        this.contestphaseid = contestphaseid;
    }

    public Long getUserId() {
        return this.userid;
    }

    public void setUserId(Long userid) {
        this.userid = userid;
    }

    public Timestamp getCreateDate() {
        return this.createdate;
    }

    public void setCreateDate(Timestamp createdate) {
        this.createdate = createdate;
    }

    public Boolean getIsValid() {
        return this.isvalid;
    }

    public void setIsValid(Boolean isvalid) {
        this.isvalid = isvalid;
    }

    public Timestamp getConfirmationEmailSendDate() {
        return this.confirmationemailsenddate;
    }

    public void setConfirmationEmailSendDate(Timestamp confirmationemailsenddate) {
        this.confirmationemailsenddate = confirmationemailsenddate;
    }

    public String getConfirmationToken() {
        return this.confirmationtoken;
    }

    public void setConfirmationToken(String confirmationtoken) {
        this.confirmationtoken = confirmationtoken;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final ProposalVote other = (ProposalVote) obj;
        if (proposalid == null) {
            if (other.proposalid != null)
                return false;
        }
        else if (!proposalid.equals(other.proposalid))
            return false;
        if (contestphaseid == null) {
            if (other.contestphaseid != null)
                return false;
        }
        else if (!contestphaseid.equals(other.contestphaseid))
            return false;
        if (userid == null) {
            if (other.userid != null)
                return false;
        }
        else if (!userid.equals(other.userid))
            return false;
        if (createdate == null) {
            if (other.createdate != null)
                return false;
        }
        else if (!createdate.equals(other.createdate))
            return false;
        if (isvalid == null) {
            if (other.isvalid != null)
                return false;
        }
        else if (!isvalid.equals(other.isvalid))
            return false;
        if (confirmationemailsenddate == null) {
            if (other.confirmationemailsenddate != null)
                return false;
        }
        else if (!confirmationemailsenddate.equals(other.confirmationemailsenddate))
            return false;
        if (confirmationtoken == null) {
            if (other.confirmationtoken != null)
                return false;
        }
        else if (!confirmationtoken.equals(other.confirmationtoken))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((proposalid == null) ? 0 : proposalid.hashCode());
        result = prime * result + ((contestphaseid == null) ? 0 : contestphaseid.hashCode());
        result = prime * result + ((userid == null) ? 0 : userid.hashCode());
        result = prime * result + ((createdate == null) ? 0 : createdate.hashCode());
        result = prime * result + ((isvalid == null) ? 0 : isvalid.hashCode());
        result = prime * result + ((confirmationemailsenddate == null) ? 0 : confirmationemailsenddate.hashCode());
        result = prime * result + ((confirmationtoken == null) ? 0 : confirmationtoken.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("ProposalVote (");

        sb.append(proposalid);
        sb.append(", ").append(contestphaseid);
        sb.append(", ").append(userid);
        sb.append(", ").append(createdate);
        sb.append(", ").append(isvalid);
        sb.append(", ").append(confirmationemailsenddate);
        sb.append(", ").append(confirmationtoken);

        sb.append(")");
        return sb.toString();
    }
}
