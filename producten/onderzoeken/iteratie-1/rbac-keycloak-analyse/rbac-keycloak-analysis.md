# RBAC Keycloak Analyse Spike

## Onderzoeksvragen en Bevindingen

### Hoe flexibel is het rolbeheer in elke applicatie?

#### Google Workspace
- **Aangepaste Rol Creatie**:
  - Beschikbaar in Enterprise en Education Enterprise edities
  - Vereist Super Admin of "Manage Roles" rechten
  - Maximum van 100 aangepaste rollen per organisatie
  - Sommige rechten zijn gereserveerd voor vooraf gedefinieerde rollen
  - Aangepaste rollen hebben altijd minder rechten dan admin rollen

- **Rechten Granulariteit**:
  - Meer dan 1.000 verschillende rechten beschikbaar
  - Fijnmazige controle over specifieke diensten
  - Kan toegang tot specifieke functies binnen diensten beheren
  - Ondersteunt zowel brede als specifieke rechten sets

- **Rol Toewijzing Flexibiliteit**:
  - Kan toewijzen aan:
    - Individuele gebruikers
    - Groepen
    - Organisatorische eenheden (OUs)
  - Ondersteunt rol overerving via OUs
  - Meerdere rollen per gebruiker/groep mogelijk
  - Tijdelijke of permanente toewijzingen

- **Dynamische Rol Updates**:
  - Real-time rol wijzigingen
  - Direct effect na toewijzing
  - Ondersteuning voor bulk rolbeheer
  - Admin SDK (Software Development Kit) voor programmatisch beheer
  - Geautomatiseerde roltoewijzingen mogelijk

- **Vereisten**:
  - Enterprise of Education Enterprise licentie vereist
  - Correcte Admin Console setup
  - Juiste organisatorische structuur
  - API toegang voor Admin SDK gebruik

#### Nexus Repository
- **Aangepaste Rol Creatie**:
  - Ondersteunt aangepaste rol creatie via UI (User Interface) en API (Application Programming Interface)
  - Rollen kunnen worden gemaakt op repository, repository groep, of globaal niveau
  - Geen harde limiet op aantal aangepaste rollen
  - Kan meerdere rechten combineren in enkele rollen
  - Aangepaste rollen hebben altijd minder rechten dan admin rollen

- **Rechten Granulariteit**:
  - Fijnmazige rechten voor:
    - Repository toegang
    - Component beheer
    - Beveiligingsinstellingen
    - Gebruikersbeheer
  - Kan rechten instellen op repository of component niveau
  - Ondersteunt zowel lees- als schrijfrechten

- **Rol Toewijzing Flexibiliteit**:
  - Kan toewijzen aan:
    - Individuele gebruikers
    - Groepen
    - LDAP (Lightweight Directory Access Protocol) groepen
  - Ondersteunt rol overerving
  - Meerdere rollen per gebruiker/groep
  - Kan rollen toewijzen aan specifieke repositories

- **Dynamische Rol Updates**:
  - Real-time rol wijzigingen
  - API beschikbaar voor programmatisch beheer
  - Ondersteunt bulk roltoewijzingen
  - Wijzigingen hebben direct effect

#### Jenkins
- **Aangepaste Rol Creatie**:
  - Role-based Authorization Strategy plugin vereist
  - Ondersteunt globale en project-specifieke rollen
  - Kan rollen maken met specifieke rechten
  - Geen harde limiet op aantal rollen
  - Aangepaste rollen hebben altijd minder rechten dan admin rollen

- **Rechten Granulariteit**:
  - Zeer fijnmazige rechten
  - Kan beheren:
    - Job toegang
    - Build rechten
    - Weergave rechten
    - Systeem configuratie
    - Credential beheer
  - Ondersteunt patroon-gebaseerde rechten

- **Rol Toewijzing Flexibiliteit**:
  - Kan toewijzen aan:
    - Individuele gebruikers
    - Groepen
    - LDAP groepen
  - Ondersteunt rol overerving
  - Meerdere rollen per gebruiker/groep
  - Project-specifieke roltoewijzingen

- **Dynamische Rol Updates**:
  - Wijzigingen vereisen plugin herladen
  - API beschikbaar voor programmatisch beheer
  - Ondersteunt bulk roltoewijzingen
  - Wijzigingen hebben effect na herladen

#### Gitea
- **Aangepaste Rol Creatie**:
  - Ingebouwd rolbeheer
  - Ondersteunt organisatie en repository rollen
  - Kan aangepaste rollen maken met specifieke rechten
  - Geen harde limiet op aantal rollen
  - Aangepaste rollen hebben altijd minder rechten dan admin rollen

- **Rechten Granulariteit**:
  - Fijnmazige rechten voor:
    - Repository toegang
    - Issue beheer
    - Pull request beheer
    - Wiki toegang
    - Instellingen beheer
  - Kan rechten instellen op repository of organisatie niveau

- **Rol Toewijzing Flexibiliteit**:
  - Kan toewijzen aan:
    - Individuele gebruikers
    - Teams
    - Organisatie leden
  - Ondersteunt rol overerving
  - Meerdere rollen per gebruiker/team
  - Organisatie-brede roltoewijzingen

- **Dynamische Rol Updates**:
  - Real-time rol wijzigingen
  - API beschikbaar voor programmatisch beheer
  - Wijzigingen hebben direct effect
  - Ondersteunt bulk roltoewijzingen

#### Atlassian Producten (Jira/Confluence)
- **Aangepaste Rol Creatie**:
  - Ondersteunt aangepaste rollen in Jira en Confluence
  - Kan project-specifieke rollen maken
  - Geen harde limiet op aantal rollen
  - Vereist admin rechten
  - Aangepaste rollen hebben altijd minder rechten dan admin rollen

- **Rechten Granulariteit**:
  - Zeer fijnmazige rechten
  - Kan beheren:
    - Project toegang
    - Issue beheer
    - Space toegang
    - Content beheer
    - Administratie rechten
  - Ondersteunt zowel globale als project-specifieke rechten

- **Rol Toewijzing Flexibiliteit**:
  - Kan toewijzen aan:
    - Individuele gebruikers
    - Groepen
    - Applicatie rollen
  - Ondersteunt rol overerving
  - Meerdere rollen per gebruiker/groep
  - Project-specifieke roltoewijzingen

- **Dynamische Rol Updates**:
  - Real-time rol wijzigingen
  - API beschikbaar voor programmatisch beheer
  - Wijzigingen hebben direct effect
  - Ondersteunt bulk roltoewijzingen

#### 1Password
- **Aangepaste Rol Creatie**:
  - Ondersteunt aangepaste rollen in Business en Enterprise plannen
  - Kan rollen maken met specifieke kluis toegang
  - Beperkt tot vooraf gedefinieerde rechten sets
  - Maximum van 100 aangepaste rollen
  - Aangepaste rollen hebben altijd minder rechten dan admin rollen

- **Rechten Granulariteit**:
  - Kluis-niveau rechten
  - Kan beheren:
    - Kluis toegang
    - Item beheer
    - Gebruikersbeheer
    - Groepsbeheer
  - Beperkt tot vooraf gedefinieerde rechten combinaties

- **Rol Toewijzing Flexibiliteit**:
  - Kan toewijzen aan:
    - Individuele gebruikers
    - Groepen
  - Ondersteunt rol overerving
  - Meerdere rollen per gebruiker/groep
  - Kluis-specifieke roltoewijzingen

- **Dynamische Rol Updates**:
  - Real-time rol wijzigingen
  - API beschikbaar voor programmatisch beheer
  - Wijzigingen hebben direct effect
  - Ondersteunt bulk roltoewijzingen

#### Email (Generiek)
- **Aangepaste Rol Creatie**:
  - Hangt af van email provider
  - Meestal beperkt tot vooraf gedefinieerde rollen
  - Basis rechten sets
  - Beperkte aanpassingsmogelijkheden
  - Aangepaste rollen hebben altijd minder rechten dan admin rollen

- **Rechten Granulariteit**:
  - Basis rechten niveaus:
    - Volledige toegang
    - Verzenden namens
    - Alleen-lezen
    - Geen toegang
  - Beperkte fijnmazige controle
  - Provider-afhankelijke mogelijkheden

- **Rol Toewijzing Flexibiliteit**:
  - Kan toewijzen aan:
    - Individuele gebruikers
    - Groepen
  - Beperkte rol combinaties
  - Basis overervingsopties
  - Provider-specifieke beperkingen

- **Dynamische Rol Updates**:
  - Wijzigingen kunnen sync tijd vereisen
  - Beperkte API ondersteuning
  - Wijzigingen zijn mogelijk niet direct
  - Basis bulk beheer

#### Slack
- **Aangepaste Rol Creatie**:
  - Ondersteunt aangepaste rollen in Enterprise Grid
  - Beperkt tot vooraf gedefinieerde rechten sets
  - Kan rollen maken met specifieke kanaal toegang
  - Maximum van 100 aangepaste rollen
  - Aangepaste rollen hebben altijd minder rechten dan admin rollen

- **Rechten Granulariteit**:
  - Kanaal-niveau rechten
  - Kan beheren:
    - Kanaal toegang
    - Bericht rechten
    - Bestandsdeling
    - App beheer
  - Beperkt tot vooraf gedefinieerde rechten combinaties

- **Rol Toewijzing Flexibiliteit**:
  - Kan toewijzen aan:
    - Individuele gebruikers
    - Gebruikersgroepen
  - Ondersteunt rol overerving
  - Meerdere rollen per gebruiker/groep
  - Workspace-brede roltoewijzingen

- **Dynamische Rol Updates**:
  - Real-time rol wijzigingen
  - API beschikbaar voor programmatisch beheer
  - Wijzigingen hebben direct effect
  - Ondersteunt bulk roltoewijzingen

#### GlassFrog
- **Aangepaste Rol Creatie**:
  - Rol-gebaseerd door ontwerp
  - Beperkt tot vooraf gedefinieerde rollen
  - Focus op organisatorische rollen
  - Geen aangepaste rol creatie mogelijk
  - Aangepaste rollen hebben altijd minder rechten dan admin rollen

- **Rechten Granulariteit**:
  - Rol-gebaseerde rechten
  - Kan beheren:
    - Circle toegang
    - Roltoewijzingen
    - Vergadering beheer
    - Document toegang
  - Beperkt tot vooraf gedefinieerde rechten sets

- **Rol Toewijzing Flexibiliteit**:
  - Kan toewijzen aan:
    - Individuele gebruikers
    - Rol invullers
  - Ondersteunt rol overerving
  - Één rol per persoon per circle
  - Circle-specifieke roltoewijzingen

- **Dynamische Rol Updates**:
  - Real-time rol wijzigingen
  - Beperkte API ondersteuning
  - Wijzigingen hebben direct effect
  - Handmatig rolbeheer

### Hoe werkt RBAC in Keycloak?

#### Basis RBAC Structuur
- **Realms**:
  - Hoogste niveau van isolatie
  - Elke realm heeft zijn eigen users, roles en permissions
  - Kan meerdere realms hebben voor verschillende organisaties/omgevingen

- **Clients**:
  - Applicaties die zijn geïntegreerd met Keycloak
  - Elke client kan zijn eigen roles en permissions hebben
  - Ondersteunt verschillende authentication flows

- **Roles**:
  - **Client Roles**: Specifiek voor een bepaalde client
  - **Realm Roles**: Beschikbaar voor alle clients binnen een realm
  - **Composite Roles**: Roles die andere roles bevatten
  - **Default Roles**: Automatisch toegewezen aan nieuwe users

#### Role Assignment en Beheer
- **Role Assignment**:
  - Kan roles toewijzen aan:
    - Individuele users
    - Groups
    - Client-specifieke roles
  - Ondersteunt zowel directe als indirecte role assignment
  - Kan roles toewijzen via UI of API

- **Role Inheritance**:
  - Ondersteunt composite roles (roles binnen roles)
  - Kan roles combineren voor complexe permission structures
  - Automatische inheritance of permissions

#### Permissions en Policies
- **Scope-based Permissions**:
  - Kan permissions definiëren op resource niveau
  - Ondersteunt fine-grained access control
  - Kan permissions koppelen aan specifieke actions

- **Policy Enforcement**:
  - UMA (User-Managed Access) 2.0 ondersteuning
  - Kan policies definiëren voor resource access
  - Ondersteunt verschillende evaluation strategies

#### Integratie en API
- **API Support**:
  - REST API voor role management
  - Admin CLI voor script-based management
  - Support voor verschillende integration patterns

- **Protocol Support**:
  - OpenID Connect
  - OAuth 2.0
  - SAML 2.0

- **Integration Features**:
  - LDAP user federation
  - Kerberos integration
  - Social identity providers

#### Dynamisch Role Management
- **Real-time Updates**:
  - Wijzigingen hebben direct effect
  - Ondersteunt bulk operations
  - Kan roles dynamisch toewijzen/verwijderen

- **Event Handling**:
  - Kan events afvuren bij role changes
  - Ondersteunt webhooks voor notifications
  - Kan actions automatiseren bij role changes

### Ondersteunt Keycloak geneste rollen?
Ja, Keycloak ondersteunt geneste rollen via zijn "Composite Roles" functionaliteit. Hier is een gedetailleerde uitleg:

1. **Composite Roles Structuur**:
   - Keycloak staat toe dat rollen andere rollen bevatten, wat een hiërarchische structuur creëert
   - Een composite role kan rechten erven van meerdere andere rollen
   - Deze overerving is automatisch en transitief (als role A role B bevat, en role B bevat role C, dan krijgt role A automatisch de rechten van role C)

2. **Soorten Rollen in Keycloak**:
   - **Client Roles**: Specifiek voor een bepaalde client applicatie
   - **Realm Roles**: Beschikbaar voor alle clients binnen een realm
   - **Composite Roles**: Kan zowel client als realm roles combineren
   - **Default Roles**: Automatisch toegewezen aan nieuwe gebruikers

3. **Role Inheritance Functionaliteiten**:
   - Ondersteunt zowel directe als indirecte roltoewijzing
   - Kan rollen combineren voor complexe permission structures
   - Automatische overerving van rechten van bevatte rollen
   - Kan worden beheerd via zowel UI als API

4. **Implementatie Details**:
   - Composite roles kunnen worden gemaakt en beheerd via:
     - Keycloak Admin Console (UI)
     - REST API
     - Admin CLI
   - Wijzigingen aan composite roles hebben direct effect
   - Ondersteunt bulk operaties voor rolbeheer

5. **Gebruikssituaties**:
   - Creëren van hiërarchische rolstructuren (bijv. "Manager" role die "Employee" role bevat)
   - Combineren van meerdere rolrechten in een enkele role
   - Opbouwen van complexe permission structures voor verschillende organisatieniveaus
   - Implementeren van role-based access control over meerdere applicaties

6. **Voordelen**:
   - Flexibel rolbeheer
   - Verminderde rolduplicatie
   - Eenvoudiger onderhoud van rolhiërarchieën
   - Ondersteuning voor complexe organisatiestructuren
   - Real-time permission updates

7. **Beperkingen**:
   - Hoewel Keycloak geneste rollen ondersteunt, is het belangrijk om te voorkomen dat er te complexe rolhiërarchieën worden gecreëerd omdat deze moeilijk te beheren kunnen worden
   - Circulaire afhankelijkheden tussen rollen moeten worden vermeden
   - Prestaties kunnen worden beïnvloed bij zeer diepe rolhiërarchieën

Deze ondersteuning voor geneste rollen maakt Keycloak bijzonder geschikt voor complexe organisatiestructuren waar rollen rechten moeten erven van meerdere bronnen of waar hiërarchische rolrelaties vereist zijn.

### Hoe goed ondersteunt Keycloak's RBAC-implementatie dynamische rolwijzigingen?

Keycloak biedt robuuste ondersteuning voor dynamische rolwijzigingen via zijn uitgebreide session management en token exchange mogelijkheden. Het systeem is ontworpen om rolwijzigingen in real-time te verwerken terwijl de beveiliging en prestaties behouden blijven.

#### Session Management en Token Exchange
Keycloak's dynamische rolbeheer is voornamelijk gebouwd rond zijn session management systeem. Wanneer rollen worden gewijzigd, kan het systeem deze wijzigingen op verschillende manieren verwerken:

1. **Token Exchange**: Keycloak ondersteunt token exchange, waardoor dynamische rolupdates mogelijk zijn zonder dat gebruikers opnieuw moeten authenticeren. Dit is vooral nuttig in microservices-architecturen waar rolwijzigingen moeten worden doorgevoerd in meerdere services. Het token exchange proces is beveiligd en kan worden geconfigureerd om de originele gebruikerscontext te behouden terwijl de rechten worden bijgewerkt.

2. **Session Management**: Het systeem biedt uitgebreide session management mogelijkheden. Beheerders kunnen actieve gebruikerssessies bekijken en beheren, inclusief de mogelijkheid om sessies ongeldig te maken wanneer rolwijzigingen direct effect moeten hebben. Dit is cruciaal voor beveiligingsgevoelige omgevingen waar rolwijzigingen direct van kracht moeten worden.

#### Auditing en Monitoring
Het auditing systeem in Keycloak is geschikt voor het bijhouden van rolwijzigingen. Het biedt:

1. **Uitgebreide Event Logging**: Elke rolwijziging wordt gelogd met gedetailleerde informatie over wie de wijziging heeft aangebracht, wanneer deze is aangebracht en welke specifieke wijzigingen hebben plaatsgevonden.

2. **Real-time Monitoring**: De Admin Console biedt real-time inzicht in rolwijzigingen en hun effecten op gebruikerssessies. Dit stelt beheerders in staat om snel problemen te identificeren en te reageren die kunnen ontstaan door rolwijzigingen.

#### Prestaties en Schaalbaarheid
Keycloak's architectuur ondersteunt dynamische rolwijzigingen op schaal:

1. **Horizontale Schaling**: Het systeem kan worden geïmplementeerd in een gedistribueerde omgeving, waardoor het mogelijk is om grote aantallen rolwijzigingen te verwerken over meerdere instanties.

2. **Caching en Prestaties**: Rolwijzigingen worden efficiënt verwerkt door een combinatie van caching-mechanismen en geoptimaliseerde token generatie. Dit zorgt ervoor dat rolupdates de systeemprestaties niet beïnvloeden.

#### Integratiemogelijkheden
De integratiemogelijkheden van het systeem zijn cruciaal voor dynamisch rolbeheer:

1. **User Federation**: Keycloak ondersteunt verschillende user federation opties, waardoor rolwijzigingen kunnen worden gesynchroniseerd met externe systemen zoals LDAP of Active Directory. Dit zorgt voor consistentie in de gehele authenticatie-infrastructuur.

2. **API Ondersteuning**: De REST API biedt programmatische toegang tot rolbeheerfuncties, waardoor automatisering van rolwijzigingen en integratie met bestaande systemen mogelijk is.

#### Real-time Rol Updates
- **Direct Effect**:
  - Rolwijzigingen hebben direct effect na toewijzing
  - Wijzigingen worden real-time doorgevoerd in alle geïntegreerde applicaties
  - Token updates worden automatisch verwerkt via session management
  - Gebruikerssessies kunnen worden beheerd en ongeldig gemaakt indien nodig

- **Bulk Operaties**:
  - Ondersteuning voor bulk roltoewijzingen via Admin REST API
  - Kan meerdere gebruikers gelijktijdig bijwerken
  - Efficiënte verwerking van grootschalige rolwijzigingen
  - Token exchange mogelijkheden voor rolupdates

#### Dynamische Rolbeheer Functies
- **Roltoewijzingsmethoden**:
  - UI-gebaseerd rolbeheer via Admin Console
  - REST API voor programmatische controle
  - Admin CLI voor script-gebaseerd beheer
  - Token exchange voor dynamische rolupdates

- **Automatiseringsmogelijkheden**:
  - Uitgebreid event auditing systeem
  - Aangepaste event listeners voor rolwijzigingen
  - Integratie met externe systemen via federation
  - Geautomatiseerde rolprovisioning via API

#### Rolwijziging Triggers
- **Event-gebaseerde Updates**:
  - Gebruikersattribuutwijzigingen worden bijgehouden in audit logs
  - Groepslidmaatschapswijzigingen
  - Session-gebaseerde rolupdates
  - Token exchange voor rolwijzigingen

- **Integratiepunten**:
  - LDAP/Active Directory synchronisatie
  - Aangepaste user storage federation
  - Externe identity providers
  - API-gebaseerde integraties met token exchange

#### Prestatieoverwegingen
- **Schaalbaarheid**:
  - Horizontale schaling ondersteuning
  - Caching-mechanismen voor rolopzoekingen
  - Geoptimaliseerde token generatie en exchange
  - Gedistribueerde implementatie met juiste tuning

- **Beperkingen**:
  - Token grootte overwegingen bij veel rollen
  - Session management overhead
  - Netwerklatentie in gedistribueerde setups
  - Database prestaties bij frequente updates

#### Monitoring en Auditing
- **Wijzigingsregistratie**:
  - Uitgebreid audit logging systeem
  - Gedetailleerde event tracking
  - Gebruikerssession monitoring
  - Rolwijzigingsgeschiedenis

- **Probleemoplossing**:
  - Real-time monitoring via Admin Console
  - Gedetailleerde audit logs voor debugging
  - Prestatiemetrieken en tuning
  - Session management tools


## Architectuur Beslissingsdocumenten

### ADR-001: Keycloak RBAC Flexibiliteitsanalyse

**Datum**: 2025-05-07
**Status**: Geaccepteerd

#### Context
Het project vereist een gecentraliseerde rolbeheeroplossing die complexe organisatiestructuren kan verwerken en kan integreren met meerdere applicaties (Google Workspace, Nexus, Jenkins, Gitea, Atlassian producten). De oplossing moet fijnmazige toegangscontrole, dynamische rolupdates en naleving van compliance-eisen ondersteunen. Keycloak is geïdentificeerd als een potentiële oplossing, maar de RBAC-mogelijkheden moeten worden geëvalueerd tegen onze specifieke vereisten.

#### Considered options

| Vereiste | Keycloak | Aangepaste IAM |
|----------|----------|----------------|
| Rolhiërarchie Ondersteuning | ++ | ++ |
| Dynamische Rolupdates | ++ | + |
| Multi-applicatie Integratie | + | - |
| Fijnmazige Permissies | 0 | ++ |
| Protocol Ondersteuning | ++ | - |
| Prestaties bij Schaal | + | ++ |
| Compliance Functionaliteiten | 0 | ++ |
| Ontwikkelingsinspanning | + | -- |
| Onderhoudslast | + | -- |
| Community Ondersteuning | ++ | - |

Legenda:
- ++ : Uitstekende fit / Sterk voordeel
- + : Goede fit / Voordeel
- 0 : Neutraal / Gemiddeld
- - : Slechte fit / Nadeel
- -- : Zeer slechte fit / Sterk nadeel

#### Decision
Na analyse van beide opties, kiezen we voor Keycloak als onze RBAC-oplossing. Deze keuze is gebaseerd op de volgende afwegingen:

1. **Technische Overwegingen**:
   - Keycloak biedt ingebouwde ondersteuning voor complexe rolhiërarchieën via composite roles, wat essentieel is voor onze organisatiestructuur
   - De bestaande protocolondersteuning (OAuth2, OIDC, SAML) vermindert de ontwikkelingsinspanning voor integratie met onze applicaties
   - De community-ondersteuning en actieve ontwikkeling zorgen voor regelmatige updates en bugfixes
   - De schaalbare architectuur is bewezen in productieomgevingen

2. **Organisatorische Overwegingen**:
   - De ontwikkelings- en onderhoudskosten zijn significant lager dan bij een custom oplossing
   - De time-to-market is korter door gebruik van bestaande, bewezen code
   - De leercurve voor het team is beheersbaar door uitgebreide documentatie
   - De compliance-functionaliteiten kunnen worden uitgebreid waar nodig

3. **Risico Overwegingen**:
   - De beveiliging is geauditeerd en wordt regelmatig getest door de community
   - De afhankelijkheid van externe ontwikkelingen wordt gecompenseerd door de actieve community
   - De beperkingen in fijnmazige controle kunnen worden opgelost met custom ontwikkelingen waar nodig

Op basis van deze afwegingen implementeren we Keycloak met de volgende strategie:

1. **Rolbeheer**:
   - Implementatie van samengestelde rollen voor hiërarchische structuren, wat essentieel is voor onze organisatiestructuur met verschillende afdelingen en teams
   - Gebruik van groepen als alternatief voor OU-achtige functionaliteit, wat ons in staat stelt om gebruikers logisch te groeperen
   - Implementatie van aangepaste roltoewijzing voor applicatiespecifieke vereisten, zoals specifieke rechten in Jenkins of Nexus

2. **Permissiebeheer**:
   - Gebruik van UMA 2.0 voor resource-niveau permissies, wat nodig is voor fijnmazige toegangscontrole op repository-niveau
   - Implementatie van aangepaste permissiemappers voor fijnmazige controle, specifiek voor applicaties die dit vereisen
   - Gebruik van scope-gebaseerde permissies voor basis toegangscontrole, wat voldoet aan onze algemene beveiligingseisen

3. **Integratiestrategie**:
   - Benutting van bestaande protocolondersteuning (OAuth2, OIDC, SAML) voor naadloze integratie met onze applicaties
   - Ontwikkeling van aangepaste adapters voor applicaties met unieke vereisten, zoals Google Workspace en Atlassian producten
   - Implementatie van token exchange voor dynamische rolupdates, wat essentieel is voor real-time toegangscontrole

4. **Prestatieoptimalisatie**:
   - Ontwerp van rolhiërarchie met prestaties in gedachten, rekening houdend met de verwachte schaal van het systeem
   - Implementatie van cachingstrategieën voor snelle rolopzoekingen
   - Monitoring en optimalisatie van tokenformaten voor efficiënte verwerking

#### Consequences

**Positief**:
De applicatie-specifieke integratieaanpak biedt optimale integratie per applicatie door gebruik van de meest geschikte methode, wat resulteert in minimale custom ontwikkelingen door gebruik van bestaande oplossingen. Dit zorgt voor een consistente gebruikerservaring door SSO waar mogelijk en efficiënt gebruikersbeheer door real-time synchronisatie. De flexibele roltoewijzing per applicatie, gecombineerd met bewezen protocollen, zorgt voor betere beveiliging. De kennisoverdracht wordt vereenvoudigd door gebruik van standaard methoden, terwijl de community ondersteuning zorgt voor snelle probleemoplossing en updates.

**Negatief**:
De implementatie brengt echter ook uitdagingen met zich mee. De complexiteit in het beheren van verschillende integratiemethoden vereist specifieke expertise, terwijl de noodzaak voor custom ontwikkelingen voor specifieke applicaties extra ontwikkeltijd vergt. De afhankelijkheid van applicatie-specifieke plugins vormt een risico voor toekomstige updates, en real-time synchronisatie kan impact hebben op de prestaties. Het team moet een leercurve doorlopen voor de verschillende integratiemethoden, en elke integratie vereist uitgebreide testing. Daarnaast zijn er beperkingen in de flexibiliteit van standaard integraties en kunnen enterprise features extra kosten met zich meebrengen.

### ADR-002: Keycloak Integratie voor Applicatie Rolbeheer

**Datum**: 2025-05-08
**Status**: Geaccepteerd

#### Context
Het project vereist een gecentraliseerde rolbeheeroplossing die naadloos kan integreren met verschillende applicaties (Google Workspace, Nexus, Jenkins, Gitea, Atlassian producten). We moeten kiezen tussen het gebruik van Keycloak als bestaande IAM oplossing of het ontwikkelen van een custom IAM systeem. De keuze moet gebaseerd zijn op integratiemogelijkheden, ontwikkelingsinspanning, en onderhoudslast.

#### Considered options

| Aspect | Keycloak | Custom IAM |
|--------|----------|------------|
| Ontwikkelingsinspanning | + | -- |
| Onderhoudslast | + | -- |
| Integratie Flexibiliteit | + | ++ |
| Community Ondersteuning | ++ | - |
| Aanpasbaarheid | 0 | ++ |
| Beveiligingsaudit | ++ | - |
| Schaalbaarheid | + | ++ |
| Kosten | + | -- |
| Rol Granulariteit | + | ++ |
| Dynamische Updates | ++ | + |
| Multi-applicatie Support | ++ | - |
| Protocol Ondersteuning | ++ | - |
| Compliance | + | ++ |

Legenda:
- ++ : Uitstekende fit / Sterk voordeel
- + : Goede fit / Voordeel
- 0 : Neutraal / Gemiddeld
- - : Slechte fit / Nadeel
- -- : Zeer slechte fit / Sterk nadeel

#### Decision
Na analyse van beide opties kiezen we voor Keycloak als onze IAM-oplossing. Deze keuze is gebaseerd op de volgende afwegingen:

1. **Technische Overwegingen**:
   - Keycloak biedt ingebouwde ondersteuning voor meerdere authenticatieprotocollen, wat essentieel is voor onze diverse applicatielandschap
   - De bestaande adapters en plugins verminderen de ontwikkelingsinspanning voor integratie
   - De real-time rolupdates en token exchange functionaliteit zijn cruciaal voor onze dynamische organisatie
   - De schaalbare architectuur is bewezen in productieomgevingen

2. **Organisatorische Overwegingen**:
   - De ontwikkelings- en onderhoudskosten zijn significant lager dan bij een custom oplossing
   - De implementatietijd is korter door gebruik van bestaande, bewezen code
   - De community-ondersteuning zorgt voor snelle probleemoplossing
   - De documentatie is uitgebreid en actueel

3. **Risico Overwegingen**:
   - De beveiliging is geauditeerd en wordt regelmatig getest door de community
   - De afhankelijkheid van externe ontwikkelingen wordt gecompenseerd door de actieve community
   - De beperkingen in specifieke use-cases kunnen worden opgelost met custom ontwikkelingen

#### Consequences

**Positief**:
De applicatie-specifieke integratieaanpak biedt optimale integratie per applicatie door gebruik van de meest geschikte methode, wat resulteert in minimale custom ontwikkelingen door gebruik van bestaande oplossingen. Dit zorgt voor een consistente gebruikerservaring door SSO waar mogelijk en efficiënt gebruikersbeheer door real-time synchronisatie. De flexibele roltoewijzing per applicatie, gecombineerd met bewezen protocollen, zorgt voor betere beveiliging. De kennisoverdracht wordt vereenvoudigd door gebruik van standaard methoden, terwijl de community ondersteuning zorgt voor snelle probleemoplossing en updates.

**Negatief**:
De implementatie brengt echter ook uitdagingen met zich mee. De complexiteit in het beheren van verschillende integratiemethoden vereist specifieke expertise, terwijl de noodzaak voor custom ontwikkelingen voor specifieke applicaties extra ontwikkeltijd vergt. De afhankelijkheid van applicatie-specifieke plugins vormt een risico voor toekomstige updates, en real-time synchronisatie kan impact hebben op de prestaties. Het team moet een leercurve doorlopen voor de verschillende integratiemethoden, en elke integratie vereist uitgebreide testing. Daarnaast zijn er beperkingen in de flexibiliteit van standaard integraties en kunnen enterprise features extra kosten met zich meebrengen.

### ADR-003: Keycloak Integratie Strategie per Applicatie

**Datum**: 2025-05-08
**Status**: Geaccepteerd

#### Context
Het project vereist een gedetailleerde integratiestrategie voor Keycloak met verschillende applicaties (Google Workspace, Nexus, Jenkins, Gitea, Atlassian producten). Elke applicatie heeft specifieke vereisten voor rolbeheer en authenticatie. We moeten een gestructureerde aanpak ontwikkelen voor de integratie van Keycloak met elke applicatie, rekening houdend met hun unieke kenmerken en beperkingen.

#### Considered options

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

#### Decision
Na analyse van de integratiemogelijkheden per applicatie kiezen we voor een applicatie-specifieke aanpak waarbij we de meest geschikte integratiemethode per applicatie selecteren. Deze keuze is gebaseerd op de volgende afwegingen:

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

#### Consequences

**Positief**:
De applicatie-specifieke integratieaanpak biedt optimale integratie per applicatie door gebruik van de meest geschikte methode, wat resulteert in minimale custom ontwikkelingen door gebruik van bestaande oplossingen. Dit zorgt voor een consistente gebruikerservaring door SSO waar mogelijk en efficiënt gebruikersbeheer door real-time synchronisatie. De flexibele roltoewijzing per applicatie, gecombineerd met bewezen protocollen, zorgt voor betere beveiliging. De kennisoverdracht wordt vereenvoudigd door gebruik van standaard methoden, terwijl de community ondersteuning zorgt voor snelle probleemoplossing en updates.

**Negatief**:
De implementatie brengt echter ook uitdagingen met zich mee. De complexiteit in het beheren van verschillende integratiemethoden vereist specifieke expertise, terwijl de noodzaak voor custom ontwikkelingen voor specifieke applicaties extra ontwikkeltijd vergt. De afhankelijkheid van applicatie-specifieke plugins vormt een risico voor toekomstige updates, en real-time synchronisatie kan impact hebben op de prestaties. Het team moet een leercurve doorlopen voor de verschillende integratiemethoden, en elke integratie vereist uitgebreide testing. Daarnaast zijn er beperkingen in de flexibiliteit van standaard integraties en kunnen enterprise features extra kosten met zich meebrengen.

## Onderzoek plan

### Fase 1: Application Role Management Analysis
- [x] Google Workspace role management capabilities
- [x] Nexus Repository role management capabilities
- [x] Jenkins role management capabilities
- [x] Gitea role management capabilities
- [x] Atlassian products role management capabilities

### Fase 2: Keycloak RBAC Analysis
- [x] Keycloak RBAC documentation review
- [x] Nested roles implementation
- [x] Role mapping capabilities
- [x] Integration possibilities
- [x] Dynamic role management features

### Fase 3: Gap Analysis
- [x] Compare flexibility requirements with capabilities
- [x] Identify limitations
- [x] Document integration challenges
- [x] Evaluate dynamic role management support

### Fase 4: Conclusion
- [x] Suitability assessment
- [x] Recommendations

## Onderzoek hulpmiddelen
- Keycloak Documentation: https://www.keycloak.org/documentation
- Application Documentation:
  - Google Workspace: https://support.google.com/a/topic/9025834
  - Nexus Repository: https://help.sonatype.com/repomanager3
  - Jenkins: https://www.jenkins.io/doc/
  - Gitea: https://docs.gitea.io/
  - Atlassian: https://www.atlassian.com/software

## Bronnen

### Google Workspace
- [Google Cloud RBAC Documentation](https://cloud.google.com/chronicle/docs/administration/rbac)
- [Google Workspace Admin Help - Manage custom roles](https://support.google.com/a/answer/7519580?hl=en)
- [Google Workspace Admin SDK - Manage Roles](https://developers.google.com/workspace/admin/directory/v1/guides/manage-roles)

### Nexus Repository
- [Nexus Repository Manager 3 Documentation](https://help.sonatype.com/repomanager3)
- [Nexus Repository Manager 3 Security](https://help.sonatype.com/repomanager3/security)
- [Sonatype Nexus Repository](https://www.sonatype.com/products/sonatype-nexus-repository)

### Jenkins
- [Jenkins Documentation](https://www.jenkins.io/doc/)
- [Role-based Authorization Strategy Plugin](https://plugins.jenkins.io/role-strategy/)

### Gitea
- [Gitea Documentation](https://docs.gitea.io/)
- [Gitea Permissions Guide](https://docs.gitea.com/usage/permissions)
- [Gitea RBAC Implementation](https://gitea.com/tango/rbac)

### Atlassian Products
- [Atlassian Documentation](https://www.atlassian.com/software)
- [Jira Software Documentation](https://www.atlassian.com/software/jira/guides)
- [Confluence Documentation](https://www.atlassian.com/software/confluence/guides)

### Keycloak
- [Keycloak Documentation](https://www.keycloak.org/documentation)
- [Keycloak Server Administration Guide - Roles](https://www.keycloak.org/docs/latest/server_admin/#_roles)
- [Keycloak REST API Documentation](https://www.keycloak.org/docs-api/latest/rest-api/index.html)
- [Keycloak Events and Audit](https://www.keycloak.org/docs/latest/server_admin/#configuring-auditing-to-track-events)
- [Keycloak Audit](https://skycloak.io/blog/auditing-in-keycloak-how-to-catch-them-all/)
- [Keycloak Performance and Scaling](https://www.keycloak.org/getting-started/getting-started-scaling-and-tuning)
- [Keycloak Token Management](https://www.keycloak.org/docs/latest/server_admin/#managing-user-sessions)
- [Keycloak config Token](https://www.keycloak.org/securing-apps/token-exchange)  
- [Keycloak User Federation](https://www.keycloak.org/docs/latest/server_admin/index.html#_user-storage-federation)

### General RBAC Information
- [Kubernetes RBAC Documentation](https://kubernetes.io/docs/reference/access-authn-authz/rbac/)
- [Microsoft Azure RBAC Overview](https://learn.microsoft.com/en-us/azure/role-based-access-control/overview)
- [Imperva RBAC Guide](https://www.imperva.com/learn/data-security/role-based-access-control-rbac/)
- [NIST RBAC Guide](https://csrc.nist.gov/projects/role-based-access-control)
- [RBAC Best Practices](https://www.csoonline.com/article/3060782/role-based-access-control-rbac-defined.html)