# ADR-XXX: Gebruikerservaring en Communicatie bij Keycloak-uitval

## Status
Concept

## Context
Bij uitval van Keycloak als centrale authenticatie- en autorisatieoplossing is het essentieel om de impact op gebruikers te minimaliseren en duidelijke communicatie te voeren. Dit document beschrijft de functionele impact op gebruikers en de benodigde communicatie tijdens Keycloak-uitval.

## Gebruikerservaring Analyse

### Gebruikersscenario's en Impact

| Scenario | Impact | Gebruikerservaring | Communicatie |
|----------|---------|-------------------|--------------|
| Inloggen | ++ | ++ | ++ |
| Actieve sessie | + | + | ++ |
| Token verlopen | ++ | + | ++ |
| Wachtwoord reset | ++ | ++ | + |
| MFA verificatie | ++ | ++ | + |

Legenda:
- ++ : Zeer hoge impact / Zeer slechte ervaring / Zeer intensieve communicatie
- + : Hoge impact / Slechte ervaring / Intensieve communicatie
- 0 : Gemiddelde impact / Acceptabele ervaring / Standaard communicatie
- - : Lage impact / Goede ervaring / Minimale communicatie
- -- : Zeer lage impact / Zeer goede ervaring / Geen extra communicatie

### Impact per Gebruikersrol

| Rol | Impact | Gebruikerservaring | Communicatie |
|-----|---------|-------------------|--------------|
| Reguliere gebruiker | ++ | ++ | + |
| Beheerder | ++ | ++ | ++ |
| Systeembeheerder | ++ | ++ | ++ |
| Externe gebruiker | + | + | + |

### Verwachte Gebruikerservaring per Scenario

#### Inlogscenario
- Duidelijke foutmelding met uitleg over Keycloak-uitval
- Alternatieve toegangsmethoden indien beschikbaar
- Status-indicator van authenticatiesysteem
- Link naar statuspagina voor meer informatie

#### Actieve Sessie Scenario
- Waarschuwing bij bijna verlopen sessie
- Duidelijke instructies voor werkcontinuïteit
- Informatie over verwachte hersteltijd
- Contactgegevens voor support

## Foutmeldingen en Communicatie

### Inventarisatie en Evaluatie Foutmeldingen

| Foutmelding Type | Prioriteit | Gebruikerservaring | Communicatie |
|------------------|------------|-------------------|--------------|
| Inlogfout | ++ | ++ | ++ |
| Sessie verlopen | ++ | + | ++ |
| MFA fout | + | ++ | + |
| Wachtwoord reset | + | ++ | + |

### Aanbevelingen Verbeterde Foutmeldingen

1. **Standaardisatie**
   - Uniforme foutmeldingen in alle applicaties
   - Consistente terminologie en stijl
   - Duidelijke visuele indicatie van foutstatus

2. **Gebruiksvriendelijkheid**
   - Niet-technische taal
   - Concrete vervolgstappen
   - Duidelijke contactinformatie

3. **Informativiteit**
   - Verwachte hersteltijd
   - Alternatieve toegangsmethoden
   - Impact op gebruikerswerkzaamheden

## Statuspagina

### Statuspagina Informatie en Updates

| Informatie Type | Update Frequentie | Prioriteit | Gebruikerservaring | Communicatie |
|----------------|-------------------|------------|-------------------|--------------|
| Algemene status | Real-time | ++ | ++ | ++ |
| Getroffen applicaties | Elke 5 minuten | ++ | + | ++ |
| Bekende workarounds | Bij wijziging | + | ++ | + |
| Herstelstatus | Elke 30 minuten | + | + | ++ |
| Contactinformatie | Bij wijziging | + | + | + |

### Aanbevelingen Statuspagina Updates

1. **Automatische Updates**
   - Real-time monitoring integratie
   - Automatische statuswijzigingen
   - Proactieve notificaties

2. **Informatie Structuur**
   - Duidelijke categorisering
   - Prioritering van informatie
   - Consistente update frequentie

3. **Gebruikerservaring**
   - Responsive design
   - Toegankelijke informatie
   - Duidelijke navigatie

## Applicatie-UI

### UI-elementen en Fallback States

| Applicatie | UI-element | Prioriteit | Gebruikerservaring | Communicatie |
|------------|------------|------------|-------------------|--------------|
| Alle | Inlogscherm | ++ | ++ | ++ |
| Alle | Navigatiemenu | + | + | + |
| Alle | Gebruikersprofiel | + | + | 0 |
| Beheer | Dashboard | ++ | ++ | ++ |

### Aanbevelingen UI-aanpassingen

1. **Consistente Stijl**
   - Uniforme foutmeldingen
   - Duidelijke statusindicatoren
   - Herkenbare waarschuwingskleuren

2. **Gebruiksvriendelijkheid**
   - Intuïtieve navigatie
   - Duidelijke actieknoppen
   - Toegankelijke informatie

3. **Fallback States**
   - Graceful degradation
   - Alternatieve functionaliteit
   - Duidelijke beperkingen

## Communicatiestrategie

### Communicatiekanalen en Responstijden

| Gebruikersgroep | Update Frequentie | Prioriteit | Gebruikerservaring | Communicatie |
|-----------------|-------------------|------------|-------------------|--------------|
| Reguliere gebruikers | 30 minuten | + | + | ++ |
| Beheerders | 15 minuten | ++ | ++ | ++ |
| Systeembeheerders | 5 minuten | ++ | ++ | ++ |
| Externe gebruikers | 60 minuten | + | + | + |

### Proactieve Communicatie

1. **Automatische Detectie**
   - Real-time monitoring
   - Proactieve waarschuwingen
   - Snelle escalatie

2. **Gebruikersnotificaties**
   - In-app meldingen
   - E-mail notificaties
   - Statuspagina updates

3. **Beheerderscommunicatie**
   - Directe notificaties
   - Gedetailleerde status
   - Escalatieprocedures

## Implementatie Aanbevelingen

### Implementatiecomplexiteit en Prioritering

| Component | Tijdsduur | Resources | Prioriteit | Gebruikerservaring | Communicatie |
|-----------|-----------|-----------|------------|-------------------|--------------|
| Monitoring | 2 weken | 2 developers | ++ | ++ | ++ |
| UI Aanpassingen | 1 week | 1 developer | ++ | ++ | + |
| Communicatie | 3 dagen | 1 developer | + | + | ++ |

### Technische Vereisten

1. **Monitoring**
   - Real-time Keycloak health checks
   - Automatische notificaties
   - Status tracking

2. **UI Aanpassingen**
   - Responsive error handling
   - Fallback authenticatie
   - Status indicators

3. **Communicatie**
   - Multi-channel notificaties
   - Automatische updates
   - Escalatie workflows

## Bronnen

- [Best Practices for Error Messages](https://www.nngroup.com/articles/error-message-guidelines/)
- [UI/UX Design Guidelines](https://www.nngroup.com/articles/ten-usability-heuristics/)
-   [Common problems with Keycloak: Prevent Keycloak from becoming a single point of failure](https://www.intension.de/en/infoblog/problems-with-keycloak/)
-   [Keycloak Health Checks and Monitoring](https://www.keycloak.org/observability/health)
-   [Keycloak Rolling Updates](https://www.keycloak.org/operator/rolling-updates)
-   [Keycloak Token Exchange](https://www.keycloak.org/securing-apps/token-exchange)
-   [Keycloak User Session Management](https://www.keycloak.org/docs/latest/server_admin/#managing-user-sessions)
-   [Keycloak Upgrading Guide](https://www.keycloak.org/docs/latest/upgrading/index.html)
-   [Keycloak Issues - Session Management](https://github.com/mauriciovigolo/keycloak-angular/issues/297)
-   [Keycloak reserve proxy (load balancer)](https://www.keycloak.org/server/reverseproxy)
-   [Keycloak Availability](https://www.keycloak.org/high-availability/introduction)
-   [Keycloak Deploy load balancer](https://www.keycloak.org/high-availability/deploy-aws-accelerator-loadbalancer)
-   [Keycloak Caching](https://www.keycloak.org/server/caching)
-   [Keycloak Offline](https://wjw465150.gitbooks.io/keycloak-documentation/content/server_admin/topics/sessions/offline.html)
-   [Keycloak Persistent user session](https://www.keycloak.org/2024/06/persistent-user-sessions-in-preview)

