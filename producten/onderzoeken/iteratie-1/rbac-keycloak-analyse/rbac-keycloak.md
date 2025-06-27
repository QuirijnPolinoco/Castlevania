# 13. Decision Log

## ADR-001: Keycloak als Centrale RBAC/IAM Oplossing

### Status
Geaccepteerd

### Context
Het project vereist een gecentraliseerde rolbeheeroplossing die complexe organisatiestructuren kan verwerken en kan integreren met meerdere applicaties (Google Workspace, Nexus, Jenkins, Gitea, Atlassian producten). De oplossing moet fijnmazige toegangscontrole, dynamische rolupdates en naleving van compliance-eisen ondersteunen. We moeten kiezen tussen het gebruik van Keycloak als bestaande IAM oplossing of het ontwikkelen van een custom IAM systeem.

### Considered Options

| Forces | Keycloak | Custom IAM |
|--------|----------|------------|
| Rolhiërarchie Ondersteuning | ++ | ++ |
| Dynamische Rolupdates | ++ | + |
| Multi-applicatie Integratie | ++ | - |
| Protocol Ondersteuning | ++ | - |
| Prestaties bij Schaal | + | ++ |
| Compliance Functionaliteiten | + | ++ |
| Ontwikkelingsinspanning | + | -- |
| Onderhoudslast | + | -- |
| Community Ondersteuning | ++ | - |
| Integratie Flexibiliteit | + | ++ |
| Aanpasbaarheid | 0 | ++ |
| Beveiligingsaudit | ++ | - |
| Kosten | + | -- |
| Rol Granulariteit | + | ++ |
| Time-to-market | ++ | -- |

Legenda:
- ++ : Uitstekende fit / Sterk voordeel
- \+ : Goede fit / Voordeel
- 0 : Neutraal / Gemiddeld
- \- : Slechte fit / Nadeel
- -- : Zeer slechte fit / Sterk nadeel

### Decision
Na analyse van beide opties is het advies om gebruik te maken van Keycloak. Deze keuze is gebaseerd op de volgende afwegingen:

1. **Technische Overwegingen**:
   - Keycloak biedt ingebouwde ondersteuning voor complexe rolhiërarchieën via composite roles
   - De bestaande protocolondersteuning (OAuth2, OIDC, SAML) vermindert de ontwikkelingsinspanning
   - De real-time rolupdates en token exchange functionaliteit zijn cruciaal voor onze dynamische organisatie
   - De schaalbare architectuur is bewezen in productieomgevingen
   - De community-ondersteuning en actieve ontwikkeling zorgen voor regelmatige updates

2. **Organisatorische Overwegingen**:
   - De ontwikkelings- en onderhoudskosten zijn significant lager dan bij een custom oplossing
   - De time-to-market is korter door gebruik van bestaande, bewezen code
   - De leercurve voor het team is beheersbaar door uitgebreide documentatie
   - De compliance-functionaliteiten kunnen worden uitgebreid waar nodig
   - De community-ondersteuning zorgt voor snelle probleemoplossing

3. **Risico Overwegingen**:
   - De beveiliging is geauditeerd en wordt regelmatig getest door de community
   - De afhankelijkheid van externe ontwikkelingen wordt gecompenseerd door de actieve community
   - De beperkingen in specifieke use-cases kunnen worden opgelost met custom ontwikkelingen

### Consequences
De applicatie-specifieke integratieaanpak biedt optimale integratie per applicatie door gebruik van de meest geschikte methode, wat resulteert in minimale custom ontwikkelingen door gebruik van bestaande oplossingen. Dit zorgt voor een consistente gebruikerservaring door SSO waar mogelijk en efficiënt gebruikersbeheer door real-time synchronisatie. De flexibele roltoewijzing per applicatie, gecombineerd met bewezen protocollen, zorgt voor betere beveiliging. De kennisoverdracht wordt vereenvoudigd door gebruik van standaard methoden, terwijl de community ondersteuning zorgt voor snelle probleemoplossing en updates.

De implementatie brengt echter ook uitdagingen met zich mee. De complexiteit in het beheren van verschillende integratiemethoden vereist specifieke expertise, terwijl de noodzaak voor custom ontwikkelingen voor specifieke applicaties extra ontwikkeltijd vergt. De afhankelijkheid van applicatie-specifieke plugins vormt een risico voor toekomstige updates, en real-time synchronisatie kan impact hebben op de prestaties. Het team moet een leercurve doorlopen voor de verschillende integratiemethoden, en elke integratie vereist uitgebreide testing. Daarnaast zijn er beperkingen in de flexibiliteit van standaard integraties en kunnen enterprise features extra kosten met zich meebrengen.

## ADR-002: Keycloak Integratie Strategie per Applicatie

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

## ADR-003: Keycloak Performance en Schaalbaarheid

### Status
Geaccepteerd

### Context
Het project vereist een schaalbare en performante Keycloak implementatie die kan omgaan met een groeiend aantal gebruikers, applicaties en rolwijzigingen. De oplossing moet voldoen aan de performance eisen van real-time rolupdates en token exchange, terwijl de systeemprestaties behouden blijven.

### Considered Options

| Aspect | Standalone | Clustered | Cloud Native |
|--------|------------|-----------|--------------|
| Schaalbaarheid | - | ++ | ++ |
| Performance | + | ++ | ++ |
| Complexiteit | + | - | -- |
| Kosten | + | - | -- |
| Onderhoud | + | - | -- |
| Recovery | - | ++ | ++ |
| Monitoring | 0 | + | ++ |
| Deployment | + | - | -- |

Legenda:
- ++ : Uitstekende fit / Sterk voordeel
- \+ : Goede fit / Voordeel
- 0 : Neutraal / Gemiddeld
- \- : Slechte fit / Nadeel
- -- : Zeer slechte fit / Sterk nadeel

### Decision

1. **Technische Overwegingen**:
   - Horizontale schaling mogelijkheid voor groeiende gebruikersaantallen
   - Hoge beschikbaarheid door redundantie
   - Betere performance door load balancing
   - Geoptimaliseerde caching mogelijkheden

2. **Organisatorische Overwegingen**:
   - Balans tussen complexiteit en schaalbaarheid
   - Beheersbare kosten
   - Bestaande infrastructuur kan worden hergebruikt
   - Team heeft ervaring met clustered systemen

3. **Risico Overwegingen**:
   - Uitgebreide monitoring mogelijkheden
   - Snelle recovery bij storingen
   - Gecontroleerde deployment processen
   - Bewezen technologie stack

### Consequences
De clustered implementatie biedt uitstekende schaalbaarheid en performance door horizontale uitbreidingsmogelijkheden en load balancing. De hoge beschikbaarheid wordt gewaarborgd door redundantie en geautomatiseerde failover. De geoptimaliseerde caching strategie zorgt voor snelle responsetijden, terwijl de monitoring mogelijkheden inzicht geven in de systeemprestaties. De recovery mogelijkheden zijn robuust, met geautomatiseerde backup en restore procedures.

De implementatie brengt echter ook uitdagingen met zich mee. De complexiteit van het cluster vereist specifieke expertise en zorgvuldig beheer. De initiële setup en configuratie vergt meer tijd en resources. De monitoring en maintenance overhead is significant, en de kosten voor hardware en licenties zijn hoger. Daarnaast vereist de clustered setup uitgebreide testing en validatie van de failover procedures.

## ADR-004: Keycloak Monitoring en Audit Strategie

### Status
Geaccepteerd

### Context
Het project vereist een uitgebreide monitoring en audit strategie voor Keycloak om beveiliging, compliance en performance te waarborgen. De oplossing moet inzicht bieden in gebruikersactiviteiten, rolwijzigingen, en systeemprestaties, terwijl deze informatie veilig wordt opgeslagen en beschikbaar is voor analyse.

### Considered Options

| Aspect | Built-in | Custom Solution | Enterprise Solution |
|--------|----------|-----------------|---------------------|
| Functionaliteit | 0 | ++ | ++ |
| Integratie | + | - | ++ |
| Kosten | + | -- | - |
| Onderhoud | + | -- | - |
| Compliance | 0 | ++ | ++ |
| Schaalbaarheid | 0 | ++ | ++ |
| Real-time | - | ++ | ++ |
| Customisatie | 0 | ++ | + |

Legenda:
- ++ : Uitstekende fit / Sterk voordeel
- \+ : Goede fit / Voordeel
- 0 : Neutraal / Gemiddeld
- \- : Slechte fit / Nadeel
- -- : Zeer slechte fit / Sterk nadeel

### Decision
Na analyse van de verschillende monitoring en audit opties kiezen we voor een hybride aanpak met de ingebouwde Keycloak functionaliteit aangevuld met een custom solution voor specifieke use-cases. Deze keuze is gebaseerd op de volgende afwegingen:

1. **Technische Overwegingen**:
   - Flexibele integratie met bestaande monitoring tools
   - Uitgebreide audit logging mogelijkheden
   - Real-time monitoring en alerting
   - Customisable rapportage

2. **Organisatorische Overwegingen**:
   - Balans tussen kosten en functionaliteit
   - Bestaande monitoring tools kunnen worden geïntegreerd
   - Gecontroleerde implementatie mogelijk

3. **Risico Overwegingen**:
   - Compliance vereisten worden afgedekt
   - Gegevens worden veilig opgeslagen
   - Audit trail is volledig en betrouwbaar
   - Performance impact is beheersbaar

### Consequences
De hybride monitoring en audit strategie biedt uitgebreide mogelijkheden voor het volgen van gebruikersactiviteiten en systeemprestaties. De flexibele integratie met bestaande tools zorgt voor een naadloze implementatie, terwijl de custom oplossingen specifieke use-cases afdekken. De real-time monitoring en alerting mogelijkheden zorgen voor snelle detectie van problemen, en de uitgebreide rapportage functionaliteit biedt inzicht in trends en patronen.

De implementatie brengt echter ook uitdagingen met zich mee. De ontwikkeling en onderhoud van custom monitoring oplossingen vergt extra resources en expertise. De integratie met bestaande tools kan complex zijn en vereist zorgvuldige planning. De opslag en verwerking van audit logs heeft impact op de systeemprestaties, en de compliance vereisten stellen hoge eisen aan de beveiliging en beschikbaarheid van de audit data.
