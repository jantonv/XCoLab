<jsp:root xmlns:c="http://java.sun.com/jsp/jstl/core"
        xmlns:jsp="http://java.sun.com/JSP/Page"
        version="2.0">

    <div id="content">
        <c:choose>
            <c:when test="${success}">
                <jsp:useBean id="proposal" type="org.xcolab.portlets.proposals.wrappers.ProposalWrapper" scope="request"/>
                <div class="success-message">
                    Thank you for confirming your vote for the proposal ${proposal.name}. Your vote has been counted.
                </div>
            </c:when>
            <c:otherwise>
                <div class="error-message">
                    <c:choose>
                        <c:when test="${error == 'NoSuchProposalVote'}">
                            The vote you are trying to confirm does not exist.
                        </c:when>
                        <c:when test="${error == 'TokenError'}">
                            Sorry, the confirmation token does not match. Please try again or contact the administrator.
                        </c:when>
                        <c:otherwise>
                            An internal error has occurred, please contact the administrator.
                        </c:otherwise>
                    </c:choose>
                </div>
            </c:otherwise>
        </c:choose>
    </div>
</jsp:root>