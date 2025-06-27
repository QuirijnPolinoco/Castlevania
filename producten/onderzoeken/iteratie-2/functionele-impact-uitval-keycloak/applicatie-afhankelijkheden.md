# ADR-XXX: Applicatie Afhankelijkheden bij Keycloak Uitval

## Status

Concept

## Context

Keycloak wordt gebruikt als centrale authenticatie- en autorisatieoplossing voor verschillende applicaties in ons systeem. Om de robuustheid van onze applicaties te waarborgen, is het belangrijk te begrijpen hoe elke applicatie afhankelijk is van Keycloak en wat de impact is wanneer Keycloak tijdelijk niet beschikbaar is. Deze ADR documenteert de afhankelijkheden en impact per applicatie.

## Considered Options

In geval van Keycloak uitval zijn er verschillende applicaties die worden beïnvloed:

| Applicatie          | Keycloak Gebruik | Impact bij Uitval | Gedeeltelijke Beschikbaarheid |
| ------------------- | ---------------- | ----------------- | ----------------------------- |
| Google Workspace    | ++               | ++                | -                             |
| Nexus Repository    | ++               | +                 | +                             |
| Jenkins             | ++               | +                 | +                             |
| Gitea               | +                | +                 | ++                            |
| Atlassian Producten | ++               | ++                | -                             |
| 1Password           | ++               | ++                | -                             |
| Email               | +                | +                 | ++                            |
| Slack               | +                | +                 | ++                            |
| GlassFrog           | +                | +                 | ++                            |

Legenda:

-   ++ : Zeer hoge afhankelijkheid/impact / Zeer beperkte beschikbaarheid
-   \+ : Hoge afhankelijkheid/impact / Beperkte beschikbaarheid
-   0 : Gemiddelde afhankelijkheid/impact / Gedeeltelijke beschikbaarheid
-   \- : Lage afhankelijkheid/impact / Goede beschikbaarheid
-   -- : Zeer lage afhankelijkheid/impact / Volledige beschikbaarheid

### Toelichting per applicatie:

**Google Workspace - Afhankelijkheid (++):**
De hoge impact bij Keycloak uitval komt voornamelijk door de strikte MFA vereisten en complexe rolhiërarchie. Gebruikers moeten verplicht MFA gebruiken, wat direct afhankelijk is van Keycloak's authenticatieservice. Daarnaast vereist de organisatiestructuur met verschillende afdelingen en toegangsniveaus continue validatie van rolrechten. Bij uitval kunnen gebruikers niet meer authenticeren met MFA en verliezen ze geleidelijk toegang naarmate hun tokens verlopen.

**Nexus Repository - Afhankelijkheid (++):**
De impact is significant vanwege de strikte beveiligingseisen voor repository toegang. Nexus vereist real-time validatie van repository permissies en gebruikt SAML voor strikte authenticatie. Bij uitval kunnen ontwikkelaars geen nieuwe packages meer publiceren of configuraties wijzigen, wat de ontwikkelworkflow direct beïnvloedt. De lokale cache van permissies biedt enige verlichting maar raakt snel verouderd.

**Jenkins - Afhankelijkheid (++):**
Jenkins heeft een hoge impact door de project-specifieke rolstructuur en continue validatie van build rechten. Elke build job vereist specifieke permissies die real-time worden gevalideerd. Bij uitval kunnen nieuwe builds niet meer worden gestart en verliezen gebruikers geleidelijk toegang tot projecten. De lokale gebruikersauthenticatie biedt beperkte verlichting maar mist de project-specifieke rechten.

**Gitea - Afhankelijkheid (+):**
De impact is relatief beperkt omdat Gitea een eenvoudigere rolstructuur heeft en lokale authenticatie ondersteunt. De belangrijkste impact zit in het verlies van SSO en gecentraliseerd gebruikersbeheer. Repository toegang blijft grotendeels werken met bestaande tokens, en lokale authenticatie kan worden gebruikt als fallback.

**Atlassian Producten - Afhankelijkheid (++):**
De impact is zeer hoog door de strikte SSO vereisten en complexe project-rolstructuur. Jira en Confluence vereisen continue validatie van projectrechten en gebruiken SAML voor strikte authenticatie. Bij uitval kunnen gebruikers niet meer tussen projecten navigeren en verliezen ze geleidelijk toegang naarmate hun tokens verlopen.

**1Password - Afhankelijkheid (++):**
De impact is kritiek vanwege de strikte beveiligingseisen voor kluis toegang. 1Password vereist real-time validatie van kluis permissies en gebruikt OAuth2 voor strikte authenticatie. Bij uitval kunnen gebruikers geen nieuwe items meer toevoegen of bestaande items wijzigen, wat direct impact heeft op de beveiliging van gevoelige gegevens.

**Email - Afhankelijkheid (+):**
De impact is beperkt omdat email voornamelijk afhankelijk is van LDAP synchronisatie en basis authenticatie. De belangrijkste impact zit in het verlies van gecentraliseerd gebruikersbeheer en groepsbeheer. Email functionaliteit blijft grotendeels werken met bestaande configuratie.

**Slack - Afhankelijkheid (+):**
De impact is beperkt omdat Slack een eenvoudigere rolstructuur heeft en lokale authenticatie ondersteunt. De belangrijkste impact zit in het verlies van SSO en gecentraliseerd gebruikersbeheer. Basis communicatie blijft werken met bestaande tokens.

**GlassFrog - Afhankelijkheid (+):**
De impact is beperkt omdat GlassFrog een eenvoudige rolstructuur heeft en lokale authenticatie ondersteunt. De belangrijkste impact zit in het verlies van SSO en gecentraliseerd gebruikersbeheer. Basis functionaliteit blijft werken met bestaande tokens.

## Decision

Na analyse van de applicatie-afhankelijkheden en hun specifieke impact bij Keycloak uitval, adviseren wij een gelaagde aanpak voor het waarborgen van bedrijfscontinuïteit. Deze aanpak richt zich op drie hoofdgebieden: technische robuustheid, functionele beschikbaarheid en risicobeheer.

Voor de technische implementatie is het essentieel om lokale token validatie te implementeren in alle applicaties. Dit vermindert de directe afhankelijkheid van Keycloak en zorgt voor betere beschikbaarheid tijdens uitval. De token levensduur moet per applicatie worden geconfigureerd, waarbij we een balans vinden tussen beveiliging en beschikbaarheid. Voor kritieke applicaties zoals Google Workspace en 1Password, waar MFA en strikte beveiligingseisen gelden, moeten we fallback authenticatiemechanismen implementeren die voldoen aan de beveiligingsvereisten.

Op functioneel gebied moeten we applicaties categoriseren op basis van hun kritiekheid voor de bedrijfsvoering. Voor hoog-kritieke applicaties zoals Google Workspace en Atlassian producten, waar SSO en complexe rolstructuren essentieel zijn, moeten we uitgebreide beschikbaarheidsstrategieën ontwikkelen. Dit omvat duidelijke foutmeldingen voor gebruikers en een robuust monitoring systeem dat proactief waarschuwt bij Keycloak-afhankelijkheidsproblemen.

Voor risicobeheer moeten we per applicatie de balans tussen beveiliging en beschikbaarheid zorgvuldig afwegen. Dit betekent regelmatige tests van het gedrag tijdens Keycloak-uitval en gedetailleerde documentatie van herstelprocedures. Voor applicaties met strikte compliance-eisen, zoals 1Password en Google Workspace, moeten we extra aandacht besteden aan het waarborgen van beveiligingsniveaus tijdens uitval.

## Consequences

**Positief**:

-   Duidelijk inzicht in applicatie-afhankelijkheden
-   Gestructureerde aanpak voor beschikbaarheid
-   Betere voorbereiding op uitval
-   Geoptimaliseerde gebruikerservaring tijdens uitval

**Negatief**:

-   Extra ontwikkelingsinspanning voor fallback mechanismen
-   Complexiteit in het beheren van verschillende strategieën
-   Mogelijke beveiligingsrisico's bij fallback opties
-   Extra monitoring en onderhoud vereist

## Bronnen

-   [Common problems with Keycloak: Prevent Keycloak from becoming a single point of failure](https://www.intension.de/en/infoblog/problems-with-keycloak/)
-   [Keycloak Health Checks and Monitoring](https://www.keycloak.org/observability/health)
-   [Keycloak Rolling Updates](https://www.keycloak.org/operator/rolling-updates)
-   [Keycloak Token Exchange](https://www.keycloak.org/securing-apps/token-exchange)
-   [Keycloak User Session Management](https://www.keycloak.org/docs/latest/server_admin/#managing-user-sessions)
-   [Keycloak Upgrading Guide](https://www.keycloak.org/docs/latest/upgrading/index.html)
-   [Keycloak Issues - Session Management](https://github.com/mauriciovigolo/keycloak-angular/issues/297)
