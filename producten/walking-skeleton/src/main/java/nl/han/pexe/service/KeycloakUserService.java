package nl.han.pexe.service;

import nl.han.pexe.domain.UserData;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class KeycloakUserService {

    private final RestTemplate restTemplate = new RestTemplate();

    private final String KEYCLOAK_URL = "http://localhost:8081";
    private final String ADMIN_USERNAME = "admin";
    private final String ADMIN_PASSWORD = "admin";
    private final String CLIENT_ID = "admin-cli";

    private final String REALM = "BDrealm";

    public void createUser(UserData userData) {
        String accessToken = getAccessToken();
        String createUserUrl = KEYCLOAK_URL + "/admin/realms/" + REALM + "/users";
        Map<String, Object> user = new HashMap<>();
        user.put("username", userData.name());
        user.put("enabled", true);
        user.put("firstName", userData.name());
        user.put("email", userData.email());
        user.put("requiredActions", List.of("UPDATE_PASSWORD"));

        Map<String, Object> credential = new HashMap<>();
        credential.put("type", "password");
        credential.put("value", userData.name());
        credential.put("temporary", false);

        user.put("credentials", List.of(credential));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(accessToken);

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(user, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(createUserUrl, request, String.class);
        System.out.println(response);
    }

    private String getAccessToken() {
        String tokenUrl = KEYCLOAK_URL + "/realms/" + "master" + "/protocol/openid-connect/token";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> form = new LinkedMultiValueMap<>();
        form.add("client_id", CLIENT_ID);
        form.add("username", ADMIN_USERNAME);
        form.add("password", ADMIN_PASSWORD);
        form.add("grant_type", "password");

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(form, headers);
        ResponseEntity<Map> response = restTemplate.postForEntity(tokenUrl, request, Map.class);
        return (String) response.getBody().get("access_token");
    }
}
