package nl.han.pexe.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

import java.io.IOException;
import java.security.Principal;
import java.util.Map;

@RestController
public class CustomOidcUserController {

    @GetMapping("/")
    public String home() {
        return "Publieke pagina – geen login nodig. maar je kunt wel inloggen via /secure!.";
    }

    @GetMapping("/secure")
    public String securePage(@AuthenticationPrincipal OidcUser oidcUser, Principal principal) {
        return "Welkom, " + principal.getName() + " – je bent ingelogd" + " " + "met" + " " + oidcUser.getEmail() + " " + "via OAuth2.";
    }

    @GetMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String keycloakLogoutUrl = "http://localhost:8080/realms/BDrealm/protocol/openid-connect/logout" +
                "?redirect_uri=http://localhost:8081";

        response.sendRedirect(keycloakLogoutUrl);
    }
    

    @GetMapping("/roles")
    public String roles(@AuthenticationPrincipal OidcUser oidcUser) {
        return "Welkom, " + oidcUser.getName() + " " + "Je hebt de volgende rollen: " + oidcUser.getAuthorities().toString();
    }

    @GetMapping("/userinfo")
    public Map<String, Object> userInfo(@AuthenticationPrincipal OidcUser user) {
        return user.getClaims();
    }

    @GetMapping("/admin")
    @PreAuthorize("hasAuthority('ROLE_admin')")
    public String adminPage() {
        return "Welkom Admin!";
    }
}
