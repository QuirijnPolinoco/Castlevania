# Planning

## Algemene planning

De onderstaande tabel geeft een overzicht van welke week wanneer begint en wat het projectteam zich mee bezig zal
houden. Deze tabel houdt wel rekening met vrije weken, maar geen rekening met losse vrije dagen.

| Weeknummer | Week van | Bezigheid               |
|------------|----------|-------------------------|
| 1          | 14 april | Project startup (PSU)   |
| 2          | 21 april | Iteratie 1              |
| 3          | 5 mei    | Iteratie 1              |
| 4          | 12 mei   | Iteratie 2              |
| 5          | 19 mei   | Iteratie 2              |
| 6          | 26 mei   | Iteratie 3              |
| 7          | 2 juni   | Iteratie 3              |
| 8          | 9 juni   | Transitie en oplevering |
| 9          | 16 juni  | Beoordelingsmoment      |

## Projectmijlpalen en Oplevermomenten

De onderstaande tabel geeft een overzicht van de belangrijkste mijlpalen en opleveringen binnen het project, inclusief
de bijbehorende deadlines en status. De datums zijn afgestemd op de projectstartup van maandag 14 april 2025.

| Mijlpaal/Oplevering                  | Geplande datum         | Beschrijving                                                                            | Status      |
|--------------------------------------|------------------------|-----------------------------------------------------------------------------------------|-------------|
| Planbord en platforms ingericht      | Maandag 21 april 17:30 | Planbord ingericht, eerste spikes gedefinieerd, platforms voor USM en guidebook gekozen | In progress |
| Plan van Aanpak opgeleverd           | Dinsdag 22 april 22:00 | Plan van Aanpak gereed, geplaatst op GitHub en ingeleverd op iSAS                       | In progress |
| TT werk gereed op GitHub             | Vrijdag 23 mei 22:00   | TT werk (groep en individueel) gereed voor beoordeling op GitHub                        | In progress |
| Alle producten gereed op GitHub/iSAS | Vrijdag 13 juni 22:00  | Alle producten gereed voor beoordeling op GitHub en export van de repository in iSAS    | In progress |

## Belangrijke afspraken

De onderstaande tabel geeft een overzicht van de belangrijke afspraken binnen het project, inclusief de bijbehorende
data en betrokkenen. De onderstaande data worden aangepast zodra de afspraken ingeplanned zijn.

| Datum       | Tijd | Onderwerp                | Betrokkenen                |
|-------------|------|--------------------------|----------------------------|
| Eind week 3 | x    | Eerste presentatie       | Projectteam, Opdrachtgever |
| Eind week 5 | x    | Tweede presentatie       | Projectteam, Opdrachtgever |
| Eind week 7 | x    | Derde presentatie        | Projectteam, Opdrachtgever |
| Eind week 8 | x    | Opleveringspresentatie   | Projectteam, Opdrachtgever |
| Week 9      | x    | Eindpresentatie (30 min) | Projectteam, Beoordelaars  |

[Source van bovenstaande van data](https://aim-ene.github.io/pexe/docs/Tijdlijn)

## 9.1 Planning voor iteratie 1

Doel: opbouwen van basiskennis en eerste technische verkenning.

| Type        | Titel                                         | Beschrijving                                                              | Timebox |  
|-------------|-----------------------------------------------|---------------------------------------------------------------------------|---------|  
| Kennis      | Security features in Keycloak                 | MFA, policies en "least privilege" configureren                           | 32 uur  |  
| Functioneel | Minimale rollen & rechten definiëren          | Uitwerken van basale gebruikersrollen en bijbehorende rechten             | 32 uur  |  
| Kennis      | RBAC model vs projecteisen                    | Analyse van hoe RBAC in Keycloak aansluit bij de eisen van de casus       | 40 uur  |  
| Technisch   | Gebruikersdata migreren uit losse applicaties | Methodes verkennen + PoC/script maken voor migratie uit Gitea, Jira, etc. | 44 uur  |  
| Kennis   | SCIM / API synchronisatie                     | Onderzoek SCIM of custom API-sync tussen Keycloak en andere tools         | 40 uur  |  

## 9.2 Planning voor iteratie 2

Doel: Verdiepen in authenticatiestromen, integratiemogelijkheden en functionele randvoorwaarden voor een toekomstbestendige Keycloak-implementatie.

| Type        | Titel                                         | Beschrijving                                                          | Timebox |  
|-------------|-----------------------------------------------|-----------------------------------------------------------------------|---------|  
| Kennis | Keycloak integratie met CI/CD pipeline     | Onderzoek hoe Keycloak Geintergreerd kan worden met de CI/CD pipeline | 32 uur  |  
| Technisch   | Prototype maken voor SCIM / API synchronisatie   | prototype ontwikkelen voor SCIM of custom API-sync tussen Keycloak en andere tools       | 44 uur  |  
| Kennis      | OAuth2 flows en use cases binnen Keycloak     | Verdiepen in verschillende OAuth2-authenticatieflows (Auth code implicit, Client credentials, ect)      | 36 uur  |  
| Functioneel | Verificatie- en aanmeldstromen vergelijken | Vergelijken van verschillende standaard login/verificatieflows (Bijv. met en zonder MFA, social login) en hun implicaties voor gebruikerservaring en veiligheid | 40 uur  |  
| Functioneel      | Functionele impact en eisen bij Keycloak-uitval    | Onderzoeken wat de functionele gevolgen zijn voor eindgebruikers en applicaties als Keycloak tijdelijk niet beschikbaar is. Wat zijn de minimale eisen aan beschikbaarheid, fallback-functionaliteit en gebruikerservaring?  | 40 uur  |  

## 9.3 Planning voor iteratie 3

Doel: technische implementatie en integratie van gekozen oplossing.

| Type        | Titel                                          | Beschrijving                                                           | Timebox |  
|-------------|------------------------------------------------|------------------------------------------------------------------------|---------|  
| Technisch   | Keycloak multi-applicatiegebruik en RBAC model | Keycloak opzetten voor meerdere apps + verkenning van rollenstructuur  | 44 uur  |  
| Technisch   | SSO integratie met Keycloak                    | Proof-of-concept met SSO tussen Keycloak en bijv. Gitea of Jenkins     | 44 uur  |  
| Technisch   | OAuth2 integratie met Spring Boot              | Spring Boot koppelen aan Keycloak via OAuth2                           | 44 uur  |  
| Functioneel | Logging en auditing met Keycloak               | Onderzoek toegangsinzichten, audit logs en compliance opties           | 32 uur  |  
| Functioneel | Eindgebruikersvriendelijkheid beheeroplossing  | Beoordeling beheerportal op eenvoud + gebruiksgemak (voor niet-IT'ers) | 32 uur  |  
