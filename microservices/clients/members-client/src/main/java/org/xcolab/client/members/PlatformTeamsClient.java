package org.xcolab.client.members;

import org.xcolab.client.members.pojo.Member;
import org.xcolab.client.members.pojo.PlatformTeam;
import org.xcolab.util.http.ServiceRequestUtils;
import org.xcolab.util.http.caching.CacheKeys;
import org.xcolab.util.http.caching.CacheName;
import org.xcolab.util.http.client.CoLabService;
import org.xcolab.util.http.client.RestResource;
import org.xcolab.util.http.client.RestResource1;
import org.xcolab.util.http.client.RestService;
import org.xcolab.util.http.exceptions.EntityNotFoundException;

import java.util.List;

public class PlatformTeamsClient {

    private static final RestService platformTeamService =
            new RestService(CoLabService.MEMBER, ServiceRequestUtils.getNamespace());

    private static final RestResource<PlatformTeam, Long> platformTeamResource =
            new RestResource1<>(platformTeamService, "platformteams", PlatformTeam.TYPES);

    private PlatformTeamsClient() {
    }

    public static List<PlatformTeam> listAllPlatformTeams() {
        return platformTeamResource.list().addRange(0, Integer.MAX_VALUE)
                .withCache(CacheName.PLATFORMTEAM).execute();
    }

    public static PlatformTeam getPlatformTeam(long teamId) throws EntityNotFoundException {
        return platformTeamResource.get(teamId)
                .withCache(CacheName.PLATFORMTEAM)
                .executeChecked();
    }

    public static PlatformTeam createPlatformTeam(String name) {
        PlatformTeam team = new PlatformTeam();
        team.setName(name);
        team = platformTeamResource.create(team).execute();
        ServiceRequestUtils.clearCache(CacheName.PLATFORMTEAM);
        return team;
    }

    public static boolean deletePlatformTeam(PlatformTeam team) {
        boolean result = platformTeamResource.delete(team.getId_())
                .execute();
        ServiceRequestUtils.clearCache(CacheName.PLATFORMTEAM);
        return result;
    }

    public static boolean updatePlatformTeam(PlatformTeam team) {
        ServiceRequestUtils.clearCache(CacheName.PLATFORMTEAM);
        return platformTeamResource.update(team, team.getId_())
                .cacheName(CacheName.PLATFORMTEAM)
                .execute();
    }

    public static List<Member> getTeamMembers(PlatformTeam team) {
        return platformTeamResource
                .service(team.getId_(), "members", Member.TYPES.getTypeReference())
                .getList();
    }

    public static boolean addMember(PlatformTeam team, Member member) {
        return platformTeamResource
                .service(team.getId_(), "members/" + member.getId_(), Boolean.class)
                .put();
    }

    public static boolean removeMember(PlatformTeam team, Member member) {
        return platformTeamResource
                .service(team.getId_(), "members/" + member.getId_(), Boolean.class)
                .delete();
    }


}
