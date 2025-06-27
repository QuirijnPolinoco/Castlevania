package com.example.keycloak;

import org.jboss.logging.Logger;
import org.keycloak.events.Event;
import org.keycloak.events.EventBuilder;
import org.keycloak.events.EventListenerProvider;
import org.keycloak.events.admin.AdminEvent;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.UserModel;
import org.keycloak.events.EventType;

public class TestEventListenerProvider implements EventListenerProvider {
    private final KeycloakSession session;
    private static final Logger logger = Logger.getLogger(TestEventListenerProvider.class);

    public TestEventListenerProvider(KeycloakSession session) {
        this.session = session;
    }

    public void onEvent(Event event) {
        if (event.getType() == EventType.LOGIN) {
            UserModel user = session.users().getUserById(session.getContext().getRealm(), event.getUserId());
            if (user != null) {
                // Create a new event builder instance
                EventBuilder eventBuilder = new EventBuilder(session.getContext().getRealm(), session, session.getContext().getConnection());

                eventBuilder.event(EventType.LOGIN)
                        .user(user)
                        .detail("MyCustomAttribute", "Login Event Captured")
                        .success();
                logger.info("Custom login event created for user ID: " + event.getUserId());
            }
        }
    }

    public void onEvent(AdminEvent adminEvent, boolean b) {
    }

    public void close() {
    }
}
