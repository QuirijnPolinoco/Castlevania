## ADR-001: Keycloak als Centrale RBAC/IAM Oplossing

**Datum:** 12-05-2025

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
