# ADR-XXX: Minimale Functionele Vereisten bij Keycloak Uitval

## Status

Concept

## Context

Bij uitval van Keycloak moeten bepaalde kritieke bedrijfsprocessen kunnen blijven functioneren. Deze ADR definieert per applicatie welke minimale functionaliteit beschikbaar moet blijven en hoe dit gerealiseerd kan worden zonder actieve Keycloak-verbinding. Hierbij wordt rekening gehouden met beveiligingsvereisten en bedrijfscontinuïteit.

## Considered Options

### Evaluatie van Implementatiestrategieën

| Strategie               | Bedrijfscontinuïteit | Beveiliging | Implementatie Complexiteit | Gebruikerservaring | Onderhoud |
| ----------------------- | -------------------- | ----------- | -------------------------- | ------------------ | --------- |
| Lokale Token Validatie  | ++                   | +           | 0                          | ++                 | -         |
| Offline Caching         | +                    | -           | +                          | +                  | --        |
| Fallback Authenticatie  | ++                   | --          | ++                         | ++                 | -         |
| Volledige Offline Modus | ++                   | --          | --                         | ++                 | --        |

**Legenda:**

-   ++ Zeer positief
-   -   Positief
-   0 Neutraal
-   -   Negatief
-   -- Zeer negatief

#### Toelichting per strategie:

**Lokale Token Validatie**

-   Voordelen: Hoge beschikbaarheid, goede beveiliging
-   Nadelen: Complexe token management, regelmatig onderhoud nodig

**Offline Caching**

-   Voordelen: Snelle toegang, eenvoudige implementatie
-   Nadelen: Beveiligingsrisico's, complexe cache invalidatie

**Fallback Authenticatie**

-   Voordelen: Hoge beschikbaarheid, goede gebruikerservaring
-   Nadelen: Beveiligingsrisico's, dubbele authenticatie logica

**Volledige Offline Modus**

-   Voordelen: Maximale beschikbaarheid, beste gebruikerservaring
-   Nadelen: Hoge beveiligingsrisico's, complexe synchronisatie

Per applicatie zijn de volgende minimale functionele vereisten geformuleerd:

### Google Workspace

**Minimale Vereisten:**

-   Email toegang voor bestaande sessies
-   Document toegang voor bestaande sessies
-   Basis communicatiefunctionaliteit

**Implementatie:**

-   Lokale token validatie voor bestaande sessies
-   Verlengde token levensduur voor kritieke gebruikers
-   Offline toegang tot Google Drive documenten

**Beperkingen:**

-   Geen nieuwe gebruikers kunnen inloggen
-   Geen MFA validatie mogelijk
-   Geen rolwijzigingen mogelijk
-   Geen nieuwe documenten delen mogelijk

### Nexus Repository

**Minimale Vereisten:**

-   Lees-toegang tot bestaande repositories
-   Download van bestaande packages
-   Basis repository beheer

**Implementatie:**

-   Lokale cache van repository permissies
-   Offline token validatie voor bestaande sessies
-   Caching van package metadata

**Beperkingen:**

-   Geen nieuwe packages publiceren
-   Geen nieuwe repositories aanmaken
-   Geen gebruikersbeheer mogelijk
-   Beperkte schrijftoegang

### Jenkins

**Minimale Vereisten:**

-   Bestaande builds kunnen blijven draaien
-   Build resultaten bekijken
-   Basis job configuratie

**Implementatie:**

-   Lokale gebruikersauthenticatie
-   Caching van job permissies
-   Offline token validatie

**Beperkingen:**

-   Geen nieuwe builds starten
-   Geen nieuwe jobs aanmaken
-   Beperkte configuratie mogelijkheden
-   Geen gebruikersbeheer

### Gitea

**Minimale Vereisten:**

-   Repository toegang voor bestaande sessies
-   Code bekijken en downloaden
-   Basis issue tracking

**Implementatie:**

-   Lokale authenticatie
-   Offline token validatie
-   Caching van repository permissies

**Beperkingen:**

-   Geen nieuwe commits
-   Geen nieuwe repositories
-   Beperkt gebruikersbeheer
-   Geen nieuwe issues aanmaken

### Atlassian Producten

**Minimale Vereisten:**

-   Bestaande tickets bekijken
-   Documentatie toegang
-   Basis project informatie

**Implementatie:**

-   Lokale token validatie
-   Caching van project permissies
-   Offline toegang tot documentatie

**Beperkingen:**

-   Geen nieuwe tickets aanmaken
-   Geen nieuwe projecten
-   Beperkt gebruikersbeheer
-   Geen nieuwe documentatie

### 1Password

**Minimale Vereisten:**

-   Toegang tot bestaande kluizen
-   Bekijken van opgeslagen items
-   Basis wachtwoord beheer

**Implementatie:**

-   Lokale cache van kluis permissies
-   Offline token validatie
-   Caching van kritieke gegevens

**Beperkingen:**

-   Geen nieuwe items toevoegen
-   Geen nieuwe kluizen aanmaken
-   Geen gebruikersbeheer
-   Beperkte wachtwoord wijzigingen

### Email

**Minimale Vereisten:**

-   Email ontvangen en verzenden
-   Basis contactbeheer
-   Agenda toegang

**Implementatie:**

-   Lokale authenticatie
-   Caching van email configuratie
-   Offline token validatie

**Beperkingen:**

-   Geen nieuwe gebruikers
-   Beperkt gebruikersbeheer
-   Geen nieuwe groepen

### Slack

**Minimale Vereisten:**

-   Berichten ontvangen en verzenden
-   Bestaande kanalen toegang
-   Basis bestandsdeling

**Implementatie:**

-   Lokale authenticatie
-   Caching van kanaal permissies
-   Offline token validatie

**Beperkingen:**

-   Geen nieuwe kanalen
-   Beperkt gebruikersbeheer
-   Geen nieuwe integraties

### GlassFrog

**Minimale Vereisten:**

-   Circle informatie bekijken
-   Basis documentatie toegang
-   Rol informatie bekijken

**Implementatie:**

-   Lokale authenticatie
-   Caching van circle permissies
-   Offline token validatie

**Beperkingen:**

-   Geen nieuwe circles
-   Beperkt gebruikersbeheer
-   Geen nieuwe documentatie

## Decision

Op basis van de analyse van minimale functionele vereisten per applicatie, adviseren wij de volgende implementatiestrategie:

1. **Kritieke Functionaliteit**:

    - Implementeer lokale token validatie voor alle applicaties
    - Configureer passende token levensduur per applicatie
    - Implementeer caching van kritieke permissies
    - Zorg voor offline toegang waar mogelijk

2. **Beveiligingsmaatregelen**:

    - Beperk schrijftoegang tijdens uitval
    - Implementeer audit logging voor offline acties
    - Zorg voor veilige token opslag
    - Monitor ongebruikelijke activiteiten

3. **Herstelprocedures**:
    - Documenteer herstelprocedures per applicatie
    - Implementeer automatische synchronisatie na herstel
    - Zorg voor backup van kritieke gegevens
    - Test regelmatig herstelprocedures

## Consequences

**Positief**:

-   Kritieke bedrijfsprocessen blijven functioneren
-   Duidelijke verwachtingen per applicatie
-   Gestructureerde aanpak voor uitval
-   Betere voorbereiding op incidenten

**Negatief**:

-   Extra ontwikkelingsinspanning voor offline functionaliteit
-   Complexiteit in het beheren van verschillende strategieën
-   Mogelijke beveiligingsrisico's bij offline toegang
-   Extra monitoring en onderhoud vereist

## Bronnen

-   [Common problems with Keycloak: Prevent Keycloak from becoming a single point of failure](https://www.intension.de/en/infoblog/problems-with-keycloak/)
-   [Keycloak Health Checks and Monitoring](https://www.keycloak.org/observability/health)
-   [Keycloak Rolling Updates](https://www.keycloak.org/operator/rolling-updates)
-   [Keycloak Token Exchange](https://www.keycloak.org/securing-apps/token-exchange)
-   [Keycloak User Session Management](https://www.keycloak.org/docs/latest/server_admin/#managing-user-sessions)
-   [Keycloak Upgrading Guide](https://www.keycloak.org/docs/latest/upgrading/index.html)
-   [Keycloak Issues - Session Management](https://github.com/mauriciovigolo/keycloak-angular/issues/297)
