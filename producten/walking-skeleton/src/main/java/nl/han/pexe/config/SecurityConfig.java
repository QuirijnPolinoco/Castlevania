package nl.han.pexe.config;

import nl.han.pexe.service.CustomOidcUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.beans.factory.annotation.Autowired;

@EnableMethodSecurity
@Configuration
public class SecurityConfig {

    private final CustomOidcUserService customOidcUserService;

    @Autowired
    public SecurityConfig(CustomOidcUserService customOidcUserService) {
        this.customOidcUserService = customOidcUserService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers("/", "/public", "/transferJiraData").permitAll()
                        .requestMatchers("/sync-gitea").authenticated()
                        .anyRequest().authenticated()
                )
                .oauth2Login(oauth2 -> oauth2
                        .userInfoEndpoint(userInfo -> userInfo
                                .oidcUserService(customOidcUserService)
                        )
                )
                .oauth2ResourceServer(oauth2 -> oauth2
                        .jwt()
                );
        http
                .logout(logout -> logout
                        .logoutSuccessUrl("http://localhost:8081/realms/BDrealm/protocol/openid-connect/logout?redirect_uri=http://localhost:8081")
                        .invalidateHttpSession(true)
                        .clearAuthentication(true)
                        .deleteCookies("JSESSIONID")
                );



        return http.build();
    }
}
