package org.xcolab.service.proposal.domain.proposal;

import org.xcolab.model.tables.pojos.Proposal;
import org.xcolab.service.contest.exceptions.NotFoundException;
import org.xcolab.service.utils.PaginationHelper;

import java.util.List;

public interface ProposalDao {

    List<Proposal> findByGiven(PaginationHelper paginationHelper, String filterText, List<Long> contestIds, Boolean visible, Long contestPhaseId, List<Integer> ribbon,
            List<Long> contestTypeIds, List<Long> contestTierIds, Boolean contestActive,
            Boolean contestPrivate, Long threadId);

    List<Long> findIdsByGiven(PaginationHelper paginationHelper, Long contestId, Boolean visible,
            Long contestPhaseId, Integer ribbon);

    List<Long> findThreadIdsByGiven(PaginationHelper paginationHelper, Long contestId, Boolean visible,
            Long contestPhaseId, Integer ribbon);

    List<Proposal> findLinkedProposalIdsByGivenProposalId(Long proposalId);

    Proposal create(Proposal proposal);

    Proposal get(Long proposalId) throws NotFoundException;

    boolean update(Proposal proposal);

    Integer getProposalMaterializedPoints(Long proposalId);

    Proposal getByGroupId(Long groupId) throws NotFoundException;
}
