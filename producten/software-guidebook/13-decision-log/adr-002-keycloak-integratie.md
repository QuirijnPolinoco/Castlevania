## ADR-002: Keycloak Integratie Strategie per Applicatie

**Datum:** 13-05-2025

### Status
Geaccepteerd

### Context
Het project vereist een gedetailleerde integratiestrategie voor Keycloak met verschillende applicaties (Google Workspace, Nexus, Jenkins, Gitea, Atlassian producten). Elke applicatie heeft specifieke vereisten voor rolbeheer en authenticatie. We moeten een gestructureerde aanpak ontwikkelen voor de integratie van Keycloak met elke applicatie, rekening houdend met hun unieke kenmerken en beperkingen.

### Considered Options

| Applicatie | Integratie Methode | Rol Mapping | Authenticatie | Uitdagingen |
|------------|-------------------|-------------|---------------|-------------|
| Google Workspace | Custom Adapter | Attribute-based | OAuth 2.0 | Complexe rolhiërarchie |
| Nexus Repository | SAML Adapter | Role Mapping | SAML | Repository-specifieke rechten |
| Jenkins | Keycloak Plugin | Role Strategy | OAuth 2.0 | Project-specifieke rollen |
| Gitea | OAuth 2.0 | Scope-based | OAuth 2.0 | Organisatie structuur |
| Atlassian | SAML SSO | Group Mapping | SAML | Project rollen |
| 1Password | OAuth 2.0 | Vault Mapping | OAuth 2.0 | Kluis toegang |
| Email | LDAP Sync | Group Sync | LDAP | Basis rechten |
| Slack | OAuth 2.0 | Channel Mapping | OAuth 2.0 | Workspace structuur |
| GlassFrog | Custom Adapter | Role Sync | OAuth 2.0 | Circle structuur |


### Decision

1. **Technische Overwegingen**:
   - Google Workspace vereist een custom adapter vanwege de complexe OU structuur en specifieke API vereisten
   - Nexus Repository gebruikt SAML voor betere ondersteuning van repository-specifieke rechten
   - Jenkins en Gitea gebruiken OAuth 2.0 voor betere ondersteuning van real-time rolupdates
   - Atlassian producten gebruiken SAML SSO voor betere integratie met hun bestaande authenticatiesysteem
   - Overige applicaties gebruiken standaard protocollen waar mogelijk, met LDAP sync als fallback

2. **Organisatorische Overwegingen**:
   - Minimale custom ontwikkelingen door gebruik van bestaande adapters en plugins
   - Consistente gebruikerservaring door gebruik van SSO waar mogelijk
   - Efficiënt gebruikersbeheer door real-time synchronisatie
   - Flexibele roltoewijzing per applicatie

3. **Risico Overwegingen**:
   - Beperkte custom ontwikkelingen tot alleen waar noodzakelijk
   - Gebruik van bewezen protocollen en integratiemethoden
   - Real-time synchronisatie voor directe toegangscontrole
   - Fallback opties voor kritieke systemen

### Consequences
De applicatie-specifieke integratieaanpak biedt optimale integratie per applicatie door gebruik van de meest geschikte methode, wat resulteert in minimale custom ontwikkelingen door gebruik van bestaande oplossingen. Dit zorgt voor een consistente gebruikerservaring door SSO waar mogelijk en efficiënt gebruikersbeheer door real-time synchronisatie. De flexibele roltoewijzing per applicatie, gecombineerd met bewezen protocollen, zorgt voor betere beveiliging. De kennisoverdracht wordt vereenvoudigd door gebruik van standaard methoden, terwijl de community ondersteuning zorgt voor snelle probleemoplossing en updates.

De implementatie brengt echter ook uitdagingen met zich mee. De complexiteit in het beheren van verschillende integratiemethoden vereist specifieke expertise, terwijl de noodzaak voor custom ontwikkelingen voor specifieke applicaties extra ontwikkeltijd vergt. De afhankelijkheid van applicatie-specifieke plugins vormt een risico voor toekomstige updates, en real-time synchronisatie kan impact hebben op de prestaties. Het team moet een leercurve doorlopen voor de verschillende integratiemethoden, en elke integratie vereist uitgebreide testing. Daarnaast zijn er beperkingen in de flexibiliteit van standaard integraties en kunnen enterprise features extra kosten met zich meebrengen. 