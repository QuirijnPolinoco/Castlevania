# Technische risico's (5 stuks)
- Keycloak inrichten voor multi-applicatiebeheer
  → Onderzoek hoe je Keycloak configureert voor meerdere applicaties met verschillende rollen en permissies.

- Integratie Spring Boot-applicatie met OAuth / Keycloak
  → Verken hoe je een eigen Spring Boot-app laat samenwerken met Keycloak als Identity Provider.

- Gebruikersdata migreren: van losse apps naar centraal beheer
  → Hoe haal je bestaande gebruikers uit bijvoorbeeld Gitea, Jira, etc., en migreer je die naar een centrale oplossing?

- SSO (Single Sign-On) met Keycloak
  → Hoe stel je SSO in zodat gebruikers maar één keer hoeven in te loggen voor toegang tot alles?

- Spring Boot + Postman: Proof-of-concept centraal beheerportaal
  → Bouw een prototype in springboot waarbij de rechten worden beheerd met gebruik van Postman.

# Functionele risico's (5 stuks)
- Automatische synchronisatie van gebruikersgegevens tussen applicaties
  -> Onderzoek hoe je gebruikersinformatie (zoals, naam, functie, rechten) automatisch kunt synchroniseren tussen meerdere applicaties met behulp van Keycloak als centrale bron.

- Vergelijking oplossing 1 (Keycloak) vs. oplossing 2 (eigen applicatie)
  → Functionele voor- en nadelen, met focus op beheer, schaalbaarheid, gebruiksgemak.

- Beheer van rollen en permissies: functionele eisen per applicatie
  → Welke rollen bestaan er in Gitea, Jira, etc.? Wat zijn overeenkomsten/verschillen?

- Toekomstige uitbreidbaarheid van de oplossing
  → Wat gebeurt er als er nieuwe applicaties bijkomen? Is de gekozen oplossing makkelijk uit te breiden?

- Beveiligingsprincipes voor toegangsbeheer implementeren in keycloak
  -> Analyseer hoe je security-principes zoals "least privilege" en Multi-Factor Authentication (MFA) effectief kunt configureren en afdwingen binnen keycloak

# Kennisgerichte risico's (5 stuks)
- Wat is RBAC (Role-Based Access Control)?
  → Achtergrond, principes en toepassing in moderne IT-omgevingen.

- Keycloak deep dive: features, uitbreidbaarheid en community support
  → Wat kan Keycloak allemaal, en hoe wordt het in het veld gebruikt?

- Securityprincipes bij centraal gebruikersbeheer
  → Denk aan least privilege, audit logging, MFA, enz.

- Vergelijking IAM-oplossingen (Keycloak vs. Okta vs. Auth0)
  → Waarom zou je voor Keycloak kiezen (of juist niet)?

- Wat zijn best practices voor gebruikersmigratie?
  → Onderzoek hoe je veilig gebruikersdata overzet tussen systemen (anonymisatie, validatie, rollback).