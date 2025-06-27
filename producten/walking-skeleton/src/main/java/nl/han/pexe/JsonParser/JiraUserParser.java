package nl.han.pexe.JsonParser;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import nl.han.pexe.domain.UserData;

import java.util.ArrayList;
import java.util.List;

public class JiraUserParser {

    public List<UserData> parseUsers(String json) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(json);
        List<UserData> users = new ArrayList<>();

        for (JsonNode node : root) {
            String name = node.get("name").asText();
            String email = node.has("emailAddress") ? node.get("emailAddress").asText() : "";

            users.add(new UserData(name, email));
        }

        return users;
    }
}