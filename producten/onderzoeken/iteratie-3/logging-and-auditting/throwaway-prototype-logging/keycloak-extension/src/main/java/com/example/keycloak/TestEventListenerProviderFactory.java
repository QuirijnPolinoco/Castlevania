package com.example.keycloak;

import org.keycloak.Config;
import org.keycloak.events.EventListenerProvider;
import org.keycloak.events.EventListenerProviderFactory;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.KeycloakSessionFactory;

public class TestEventListenerProviderFactory implements EventListenerProviderFactory {
    public TestEventListenerProviderFactory() {
    }

    public EventListenerProvider create(KeycloakSession session) {
        return new TestEventListenerProvider(session);
    }

    public void init(Config.Scope scope) {
    }

    public void postInit(KeycloakSessionFactory factory) {
    }

    public void close() {
    }

    public String getId() {
        return "test-event-listener";
    }
}
