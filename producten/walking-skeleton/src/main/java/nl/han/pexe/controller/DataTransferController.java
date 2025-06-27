package nl.han.pexe.controller;

import nl.han.pexe.JsonParser.JiraUserParser;
import nl.han.pexe.domain.UserData;
import nl.han.pexe.service.KeycloakUserService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;

@Controller
public class DataTransferController {

    private final KeycloakUserService keycloakUserService;
    private final JiraUserParser jiraUserParser = new JiraUserParser();


    public DataTransferController(KeycloakUserService keycloakUserService){
        this.keycloakUserService = keycloakUserService;
    }

    @GetMapping("transferJiraData")
    @ResponseBody
    public List<UserData> transferJiraData() throws Exception {
        String username = "klaas";
        String password = "klaaspass";
        String auth = username + ":" + password;
        String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes(StandardCharsets.UTF_8));
        String authHeader = "Basic " + encodedAuth;

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", authHeader);
        headers.set("Accept", "application/json");

        HttpEntity<String> entity = new HttpEntity<>(headers);

        RestTemplate restTemplate = new RestTemplate();
        String jiraUrl = "http://localhost:8083/rest/api/2/user/search?username=.";
        ResponseEntity<String> response = restTemplate.exchange(jiraUrl, HttpMethod.GET, entity, String.class);
        List<UserData> users = jiraUserParser.parseUsers(response.getBody());
        for(UserData user : users) {
            keycloakUserService.createUser(user);
        }
        return users;

    }

}
