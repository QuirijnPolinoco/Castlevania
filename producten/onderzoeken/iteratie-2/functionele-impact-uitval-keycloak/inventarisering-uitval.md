# ADR-XXX: Functionele Impact van Uitval Keycloak

## Status
Concept

## Context
Keycloak wordt gebruikt als centrale authenticatie- en autorisatieoplossing in ons systeem. Om de robuustheid van onze applicatie te waarborgen, is het belangrijk te begrijpen wat er gebeurt wanneer Keycloak tijdelijk niet beschikbaar is. Deze ADR documenteert de functionele impact op verschillende aspecten van de authenticatie en autorisatie.

## Considered Options
In geval van Keycloak uitval zijn er verschillende functionele gebieden die worden beïnvloed:

| Functioneel Gebied | Impact bij Uitval | Mitigatie Mogelijkheden |
|-------------------|-------------------|------------------------|
| Gebruikerssessies | ++ | -- |
| Login Flows | ++ | - |
| Access Tokens | + | ++ |
| Rol-gebaseerde Autorisaties | + | + |
| SSO Functionaliteit | ++ | -- |
| Account Management | ++ | - |
| Multi-factor Authenticatie | ++ | - |
| Externe Identity Providers | ++ | 0 |
| Audit Logging | + | + |

Legenda:
- ++ : Zeer hoge impact / Zeer goede mitigatiemogelijkheden  
- \+ : Hoge impact / Goede mitigatiemogelijkheden
- 0 : Gemiddelde impact / Gemiddelde mitigatiemogelijkheden
- \- : Lage impact / Beperkte mitigatiemogelijkheden
- -- : Zeer lage impact / Zeer beperkte mitigatiemogelijkheden

### Toelichting per gebied:

**Gebruikerssessies - Impact (++):**
De impact op gebruikerssessies is zeer hoog omdat bestaande sessies weliswaar blijven werken tot tokens verlopen, maar er kunnen geen nieuwe sessies worden gestart, wat resulteert in een geleidelijke degradatie van het systeem naarmate meer gebruikers uit het systeem vallen.

**Gebruikerssessies - Mitigatie (--):**
Er zijn slechte mitigatiemogelijkheden via verhoogde token levensduur en client-side validatie, deze brengen beveiligingsrisico's met zich mee en vereisen aanpassingen in applicatiecode.

**Login Flows - Impact (++):**
Login flows worden zeer sterk beïnvloed omdat alle nieuwe authenticatiepogingen direct falen. Dit heeft een onmiddellijke zichtbare impact op gebruikers en blokkeert de toegang voor nieuwe sessies.

**Login Flows - Mitigatie (-):**
Er zijn beperkte mitigatiemogelijkheden voor login flows omdat Keycloak geen ingebouwde fallback authenticatiemechanismen biedt. Alternatieve authenticatieroutes vereisen significante architecturale aanpassingen.

**Access Tokens - Impact (+):**
De impact op access tokens is hoog maar niet zeer hoog omdat tokens geldig blijven tot hun vervaldatum indien lokaal gevalideerd, maar vernieuwing is niet mogelijk tijdens uitval.

**Access Tokens - Mitigatie (++):**
Er zijn zeer goede mitigatiemogelijkheden via offline token validatie, token caching, en configuratie van langere levensduur. Deze kunnen relatief eenvoudig worden geïmplementeerd.

**Rol-gebaseerde Autorisaties - Impact (+):**
De impact op autorisaties is hoog omdat bestaande rollen in tokens blijven werken maar dynamische rol-updates of complexe autorisatiechecks zullen falen.

**Rol-gebaseerde Autorisaties - Mitigatie (+):**
Er zijn goede mitigatiemogelijkheden via het cachen van autorisatiedata en het implementeren van graceful degradation, maar deze vereisen extra ontwikkelinspanning.

**SSO Functionaliteit - Impact (++):**
De Single Sign-On functionaliteit wordt volledig uitgeschakeld bij Keycloak-uitval. Gebruikers kunnen niet meer naadloos tussen applicaties navigeren en moeten opnieuw authenticeren bij elke app als hun token verloopt.

**SSO Functionaliteit - Mitigatie (--):**
Er zijn zeer beperkte mogelijkheden om SSO-functionaliteit te behouden tijdens Keycloak-uitval, omdat het concept inherent afhankelijk is van een centrale authenticatieserver.

**Account Management - Impact (++):**
Gebruikers kunnen hun accountgegevens niet beheren, wachtwoorden wijzigen of persoonlijke informatie updaten tijdens een Keycloak-uitval.

**Account Management - Mitigatie (-):**
Mitigatiemogelijkheden zijn beperkt; mogelijk kunnen niet-kritieke accountwijzigingen worden uitgesteld of in een wachtrij worden geplaatst tot Keycloak weer beschikbaar is.

**Multi-factor Authenticatie - Impact (++):**
MFA-verificatie faalt volledig omdat verificatieverzoeken niet kunnen worden gevalideerd, wat betekent dat gebruikers die MFA nodig hebben geen toegang kunnen krijgen.

**Multi-factor Authenticatie - Mitigatie (-):**
Er zijn weinig effectieve mitigatiemogelijkheden zonder de beveiligingsvoordelen van MFA op te offeren. Noodtoegangscodes kunnen worden overwogen als zeer beperkte fallback.

**Externe Identity Providers - Impact (++):**
Authenticatie via externe providers (Google, Facebook, SAML federaties) is niet mogelijk tijdens uitval als Keycloak als broker fungeert.

**Externe Identity Providers - Mitigatie (0):**
Gemiddelde mitigatiemogelijkheden via directe integratie met externe providers als bypass voor Keycloak, maar dit verhoogt de complexiteit aanzienlijk.

**Audit Logging - Impact (+):**
Authenticatie- en autorisatie-events worden niet gelogd in Keycloak tijdens uitval, wat compliance-uitdagingen kan opleveren.

**Audit Logging - Mitigatie (+):**
Goede mitigatiemogelijkheden via lokale logging in applicaties die later gesynchroniseerd kan worden met Keycloak audit logs.

Hieronder worden deze gebieden in detail geanalyseerd:

### Gedrag van Sessies
- Bestaande gebruikerssessies blijven actief totdat het bijbehorende token verloopt, aangezien Keycloak tokens na uitgifte niet meer actief valideert bij elke request
- Sessie-timeout gebeurt volgens de originele vervaltijd van het token (standaard 5-60 minuten, afhankelijk van configuratie)
- Bij korte uitval (<token levensduur) ondervinden ingelogde gebruikers minimale impact
- Bij langere uitval (>token levensduur) worden alle gebruikers geleidelijk uitgelogd naarmate hun tokens verlopen
- Sessie-verlenging is niet mogelijk tijdens een uitval omdat de token refresh endpoint niet beschikbaar is

### Login Flows
- Alle login pogingen falen tijdens Keycloak uitval omdat de authenticatieserver niet bereikbaar is
- Standaard ontvangen gebruikers een generieke foutmelding zonder duidelijke uitleg
- Er zijn geen ingebouwde fallback authenticatiemechanismen in Keycloak
- Single Sign-On (SSO) functionaliteit is volledig uitgeschakeld
- Social logins en externe identity providers zijn niet functioneel
- Backend-for-Frontend (BFF) patronen kunnen extra kwetsbaarheid toevoegen omdat ze vaak afhankelijk zijn van server-side token validatie

### Access Tokens
- Access tokens blijven geldig tot hun vervaldatum en kunnen lokaal gevalideerd worden op signature zonder verbinding met Keycloak
- De standaard levensduur van access tokens varieert van 5-60 minuten, afhankelijk van de beveiligingsconfiguratie
- Tokens kunnen niet worden vernieuwd via refresh tokens omdat de token endpoint niet beschikbaar is
- Offline validatie van tokens blijft mogelijk met lokale validatie van JWT signatures als asymmetrische encryptie wordt gebruikt
- Applicaties die token introspection gebruiken (validatie via Keycloak API) zullen direct falen
- Voor verschillende token types geldt:
  - Access tokens: blijven werken tot vervaldatum indien lokaal gevalideerd
  - ID tokens: blijven geldig voor client-side gebruikersinformatie
  - Refresh tokens: onbruikbaar tijdens uitval, kunnen niet worden gebruikt om nieuwe tokens te krijgen

### Rol-gebaseerde Autorisaties
- Autorisatiebeslissingen gebaseerd op rollen in de JWT tokens blijven functioneren omdat deze informatie in het token zelf is opgeslagen
- Autorisaties die runtime checks tegen Keycloak vereisen zullen mislukken
- Caching van rolgegevens kan de impact verminderen, maar raakt uiteindelijk verouderd
- Role mappings kunnen niet worden bijgewerkt tijdens een uitval
- Fine-grained authorization checks die de Authorization Services API gebruiken zullen falen
- Applicaties die volledig vertrouwen op offline validatie van rol-claims in tokens ondervinden minimale impact

### SSO en Externe Providers
- Single Sign-On werkt niet voor nieuwe sessies, wat resulteert in een verslechterde gebruikerservaring 
- Gebruikers moeten zich apart aanmelden bij elke applicatie wanneer hun bestaande tokens verlopen
- Federatie met externe identity providers is niet mogelijk tijdens uitval
- SAML en sociale login integraties zijn niet functioneel
- Organisaties die sterk afhankelijk zijn van federated authentication ondervinden significante verstoring

### Account Management en MFA
- Gebruikers kunnen hun profielinformatie niet bijwerken
- Wachtwoordresets zijn niet mogelijk tijdens uitval
- Multi-factor authenticatie verificaties kunnen niet worden gevalideerd
- Nieuwe registraties kunnen niet worden verwerkt
- Admin-beheertaken voor gebruikersaccounts zijn niet mogelijk

## Decision
Op basis van het onderzoek naar het gedrag van Keycloak tijdens uitval adviseren wij de volgende maatregelen:

1. **Technische Overwegingen**:
   - Implementeer lokale token validatie voor alle applicaties om afhankelijkheid van de Keycloak server te verminderen
   - Configureer een passende token levensduur: lang genoeg om korte uitval te overbruggen, kort genoeg voor adequate beveiliging
   - Implementeer token introspection caching met time-to-live instellingen die corresponderen met de beveiligingsvereisten
   - Zorg voor graceful degradation van applicaties tijdens authenticatieproblemen

2. **Functionele Overwegingen**:
   - Voorzie gebruikers van duidelijke foutmeldingen tijdens authenticatieproblemen die de actuele servicestatus aangeven
   - Implementeer een degradatiestrategie voor kritische functionaliteit: bepaal welke functies beschikbaar moeten blijven en welke geblokkeerd kunnen worden
   - Overweeg een fallback authenticatiemechanisme voor kritieke systemen
   - Ontwikkel een monitoring systeem dat proactief waarschuwt bij Keycloak-uitval

3. **Risico Overwegingen**:
   - Balanceer de token levensduur: langere tokens verbeteren beschikbaarheid maar vergroten beveiligingsrisico's
   - Test regelmatig het gedrag van alle applicaties tijdens gesimuleerde Keycloak-uitval
   - Documenteer duidelijk welke functionaliteit beperkt is tijdens uitval en wat de herstelprocedures zijn
   - Evalueer de impact op compliance en regulatorische vereisten van verminderde authenticatie/autorisatie capaciteiten

## Consequences
Implementatie van de voorgestelde maatregelen zal de volgende positieve gevolgen hebben:
- Verhoogde robuustheid van het authenticatie- en autorisatiesysteem tegen uitval
- Verbeterde gebruikerservaring door duidelijke communicatie tijdens verstoringen
- Mogelijkheid om kernfunctionaliteit beschikbaar te houden tijdens authenticatieproblemen
- Betere voorspelbaarheid van systeemgedrag tijdens Keycloak-uitval

De implementatie brengt echter ook uitdagingen met zich mee:
- Verhoogde complexiteit in client applicaties door implementatie van lokale token validatie
- Potentiële beveiligingsrisico's bij het verlengen van token levensduur
- Extra ontwikkel- en testinspanning voor het implementeren van graceful degradation
- Noodzaak voor uitgebreide monitoring en alarmeringssystemen
- Mogelijke compliance-uitdagingen bij het werken met gedegradeerde authenticatie

## Bronnen
1. Keycloak Documentatie, "Server Administration Guide - Token Settings": https://www.keycloak.org/docs/latest/server_admin/#mitigating_security_threats
2. NIST Special Publication 800-63B, "Digital Identity Guidelines": https://pages.nist.gov/800-63-3/sp800-63b.html
3. Spring Security Documentation, "OAuth 2.0 Resource Server": https://docs.spring.io/spring-security/reference/servlet/oauth2/resource-server/index.html
4. "Circuit Breaking Pattern in Distributed Systems": https://martinfowler.com/bliki/CircuitBreaker.html