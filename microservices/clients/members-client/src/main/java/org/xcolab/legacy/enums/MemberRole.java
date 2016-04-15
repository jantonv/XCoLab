package org.xcolab.legacy.enums;

import org.apache.commons.lang.WordUtils;
import org.xcolab.pojo.MemberCategory;
import org.xcolab.pojo.Role_;
import org.xcolab.service.client.MembersClient;

import java.util.Arrays;
import java.util.List;

public enum MemberRole {
    /**
     * Important:
     * Whenever these roles are modified (which should never happen) these Ids should be updated as well
     */
    DEFAULT(0L, "Default"),
	ALL(0L, "All"),
    GUEST(10119L, "Guest"),
    MEMBER(10122L, "User", "Member"),
    FELLOW(193261L, "Fellow"),
    ADVISOR(193260L, "Advisor"),
    EXPERT(44201L, "Experts"),
    JUDGE(1251483L, "Judges", "Judge"),
    STAFF(31704L, new Long[]{10118L}, "Staff", "Moderator", "Administrator"),
    MODERATOR(31213L, "Staff"),
    CATALYST(1430078L, "Catalyst"),
    CONTEST_MANAGER(1958405L, "Contest Manager"),
    IMPACT_ASSESSMENT_FELLOW(1975251L, "Impact Assessment Fellow");

    private final String[] roleNames;
    private final long roleId;
    private final List<Long> otherRoleIds;

    MemberRole(Long roleId, String... roleNames) {
        this(roleId, new Long[0], roleNames);
    }

    MemberRole(Long roleId, Long[] otherRoleIds, String... roleNames) {
        this.roleNames = roleNames;
        this.roleId = roleId;
        this.otherRoleIds = Arrays.asList(otherRoleIds);
    }

    public String getPrintName() throws NoSuchMemberRoleException {
        return WordUtils.capitalizeFully((getMemberCategory().getDisplayName()));
    }

    public String getImageUrl() throws NoSuchMemberRoleException {
        return getMemberCategory().getImageName();
    }

    public MemberCategory getMemberCategory()throws NoSuchMemberRoleException{
        final MemberCategory memberCategory = MembersClient.getMemberCategory(roleId);
        if (memberCategory == null) {
            throw new NoSuchMemberRoleException(String.format("No member category with roleId %d exists", roleId));
        }
        return memberCategory;
    }

    public String[] getRoleNames() {
        return roleNames.clone();
    }

    public long getRoleId() {
        return roleId;
    }

    public static MemberRole fromRoleId(long roleId) throws NoSuchMemberRoleException {
        for (MemberRole memberRole : MemberRole.values()) {
            if (roleId == memberRole.getRoleId() || memberRole.getOtherRoleIds().contains(roleId)) {
                return memberRole;
            }
        }
        throw new NoSuchMemberRoleException("Unknown role id given: " + roleId);
    }

    public static MemberRole fromRoleName(String roleName)  {
        for (MemberRole memberRole : MemberRole.values()) {
            if (isStringInList(roleName, memberRole.getRoleNames())) {
                return memberRole;
            }
        }
        return null;
    }

    public static MemberRole getHighestRole(List<Role_> roles) throws NoSuchMemberRoleException{
        MemberRole role = MemberRole.MEMBER;

        for (Role_ r: roles) {
            final String roleString = r.getName();

                MemberRole currentRole = MemberRole.fromRoleName(roleString);
                if (currentRole != null) {
                    if (currentRole.getMemberCategory().getSortOrder() > role.getMemberCategory().getSortOrder()) {
                        role = currentRole;
                    }
                }

        }

        if (role == MemberRole.MODERATOR) {
            role = MemberRole.STAFF;
        }

        return role;
    }

    private static boolean isStringInList(String name, String[] names) {
        for (String n : names) {
            if (name.equalsIgnoreCase(n)) {
                return true;
            }
        }
        return false;
    }

    public List<Long> getOtherRoleIds() {
        return otherRoleIds;
    }

    public static class NoSuchMemberRoleException extends Exception {
        public NoSuchMemberRoleException(String message) {
            super(message);
        }
    }
}