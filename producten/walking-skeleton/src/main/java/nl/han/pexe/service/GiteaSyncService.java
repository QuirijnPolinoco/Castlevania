package nl.han.pexe.service;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;

import java.util.*;

@Service
public class GiteaSyncService {

    private final String KEYCLOAK_USERNAME = "admin";
    private final String KEYCLOAK_PASSWORD = "admin";
    private final String KEYCLOAK_BASE_URL = "http://localhost:8081";
    private final String REALM = "BDrealm";

    private final String GITEA_BASE_URL = "http://localhost:3000/api/v1";
    private final String ORGANIZATION = "bold-digital";
    private final String GITEA_USER = "admin";
    private final String GITEA_PASSWORD = "admin";

    private final RestTemplate restTemplate = new RestTemplate();

    public void syncGroupsToGitea() {
        String tokenUrl = KEYCLOAK_BASE_URL + "/realms/master/protocol/openid-connect/token";

        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("grant_type", "password");
        formData.add("client_id", "admin-cli");
        formData.add("username", KEYCLOAK_USERNAME);
        formData.add("password", KEYCLOAK_PASSWORD);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(formData, headers);
        Map<String, Object> tokenResponse = restTemplate.postForObject(tokenUrl, request, Map.class);
        String accessToken = (String) tokenResponse.get("access_token");

        headers = new HttpHeaders();
        headers.setBearerAuth(accessToken);
        HttpEntity<Void> authEntity = new HttpEntity<>(headers);

        String groupsUrl = KEYCLOAK_BASE_URL + "/admin/realms/" + REALM + "/groups";
        ResponseEntity<List> groupsResponse = restTemplate.exchange(groupsUrl, HttpMethod.GET, authEntity, List.class);
        List<Map<String, Object>> groups = groupsResponse.getBody();

        restTemplate.getInterceptors().add(new BasicAuthenticationInterceptor(GITEA_USER, GITEA_PASSWORD));
        String teamsUrl = GITEA_BASE_URL + "/orgs/" + ORGANIZATION + "/teams";
        ResponseEntity<List> teamsResponse = restTemplate.getForEntity(teamsUrl, List.class);
        List<Map<String, Object>> teams = teamsResponse.getBody();

        Map<String, Map<String, Object>> teamsByName = new HashMap<>();
        for (Map<String, Object> team : teams) {
            teamsByName.put((String) team.get("name"), team);
        }

        for (Map<String, Object> group : groups) {
            String groupId = (String) group.get("id");
            String groupName = (String) group.get("name");

            String membersUrl = KEYCLOAK_BASE_URL + "/admin/realms/" + REALM + "/groups/" + groupId + "/members";
            ResponseEntity<List> membersResponse = restTemplate.exchange(membersUrl, HttpMethod.GET, authEntity, List.class);
            List<Map<String, Object>> groupMembers = membersResponse.getBody();

            Map<String, Object> team = teamsByName.get(groupName);
            if (team == null) continue;

            int teamId = (Integer) team.get("id");
            String teamMembersUrl = GITEA_BASE_URL + "/teams/" + teamId + "/members";
            ResponseEntity<List> teamMembersResponse = restTemplate.getForEntity(teamMembersUrl, List.class);
            List<Map<String, Object>> teamMembers = teamMembersResponse.getBody();

            Set<String> teamMemberUsernames = new HashSet<>();
            for (Map<String, Object> member : teamMembers) {
                teamMemberUsernames.add((String) member.get("username"));
            }

            for (Map<String, Object> groupMember : groupMembers) {
                String username = (String) groupMember.get("username");
                if (teamMemberUsernames.contains(username)) continue;

                String addMemberUrl = GITEA_BASE_URL + "/teams/" + teamId + "/members/" + username;
                ResponseEntity<Void> addResponse = restTemplate.exchange(addMemberUrl, HttpMethod.PUT, null, Void.class);

                if (addResponse.getStatusCode().is2xxSuccessful()) {
                    System.out.println("User " + username + " successfully added to team " + team.get("name"));
                } else {
                    System.out.println("User " + username + " could not be added to team " + team.get("name") +
                            ": " + addResponse.getStatusCode());
                }
            }
        }
    }
}
