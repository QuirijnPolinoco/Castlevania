## ADR-008: Gebruikersrollen & Machtigingen Definitie

**Datum:** 23-04-2025

### Status

Besloten

### Context

Tijdens een gesprek met de domeinexpert werd duidelijk dat veel rollen en verantwoordelijkheden regelmatig veranderen.
De domeinexpert of een HR-vertegenwoordiger is verantwoordelijk voor het aanpassen van rollen en machtigingen in het systeem.
Dit benadrukt de behoefte aan een flexibel en duidelijk gedefinieerd rollen- en machtigingenmodel.
Er zijn verschillende manieren om gebruikersrollen en machtigingen te beheren.
De keuze ligt tussen het gebruik van **Role-Based Access Control (RBAC)** via Keycloak en **Attribute-Based Access Control (ABAC)** binnen de applicatie zelf.

### Probleemstelling

Door frequente wijzigingen in rollen en verantwoordelijkheden moet het systeem flexibel genoeg zijn
om deze wijzigingen efficiënt door te voeren zonder complexe configuraties of risico's voor de beveiliging.

### Alternatieven

#### Optie 1: RBAC via Keycloak
RBAC (Role-Based Access Control) maakt gebruik van vooraf gedefinieerde rollen om machtigingen te beheren.

**Voordelen:**
- Eenvoudige roltoewijzing en -beheer via de Keycloak interface.
- Duidelijke scheiding tussen rollen, waardoor de beveiliging beter beheersbaar is.
- Makkelijk te implementeren en onderhouden.
- Standaard ondersteund in Keycloak, wat consistentie biedt binnen het project.

**Nadelen:**
- Minder flexibiliteit bij complexe autorisatiescenario's.
- Elke nieuwe rol vereist een update in Keycloak, wat tijd kan kosten.

#### Optie 2: ABAC binnen de applicatie
ABAC (Attribute-Based Access Control) maakt gebruik van attributen (zoals gebruikerskenmerken) om machtigingen dynamisch te bepalen.

**Voordelen:**
- Flexibele regelconfiguratie, geschikt voor complexe autorisatiescenario's.
- Toegangscontrole kan per verzoek worden bepaald, wat fijnmazige controle mogelijk maakt.

**Nadelen:**
- Complexe configuratie en onderhoud.
- Moeilijk te beheren bij grote aantallen gebruikers en attributen.
- Geen standaard ondersteuning binnen Keycloak, wat maatwerk vereist.

### Overwegingen

| Criterium                  | RBAC via Keycloak | ABAC binnen de applicatie |
|---------------------------|--------------------|----------------------------|
| Flexibiliteit             | -                  | +                          |
| Eenvoud van beheer        | +                  | -                          |
| Complexiteit bij wijzigingen | 0                 | -                          |
| Ondersteuning in Keycloak | +                  | -                          |
| Fijnmazige toegang        | -                  | +                          |
| Implementatiecomplexiteit | +                  | -                          |
| Onderhoudbaarheid         | +                  | ?                          |
| Beveiligingsrisico        | 0                  | ?                          |

Legenda:
- "+ = Positief (voordeel)"
- "0 = Neutraal"
- "- = Negatief (nadeel)"
- "? = Onzeker"


RBAC via Keycloak biedt eenvoud en beheersbaarheid, terwijl ABAC flexibiliteit biedt voor geavanceerde scenario's.
Omdat het project voornamelijk gebruikmaakt van vaste rollen
(zoals Backend Developer, Frontend Developer, Product Owner, en HR/CO), is de eenvoudige en goed ondersteunde RBAC-methode beter geschikt.

De flexibiliteit van ABAC wordt in dit geval niet als essentieel beschouwd, aangezien de meeste rollen vaststaan en incidenteel worden aangepast door de HR/CO.

### Decision

We kiezen voor **RBAC via Keycloak** om gebruikersrollen te beheren.
Dit biedt een goede balans tussen eenvoud en beheerbaarheid zonder de implementatie onnodig complex te maken.

### Gedefinieerde Rollen:

- Backend Developer: Toegang tot server-side logica, API's en systeemintegraties.
- Frontend Developer: Toegang tot client-side ontwikkeling en UI-implementatie.
- Product Owner: Toezicht op productontwikkeling en prioriteitstelling.
- HR / CO: Beheer van gebruikersrechten en machtigingen.


### Rechtvaardiging

- **Backend Developer:** Volledige toegang tot de codebase en deployment om backend-iteraties te faciliteren. Geen machtigingenbeheer om risico's te beperken.
- **Frontend Developer:** Toegang tot UI-ontwikkeling zonder rechten om te deployen, wat stabiliteit verhoogt.
- **Product Owner:** Leesrechten voor zichtbaarheid, zonder schrijf- of deploymentrechten om per ongeluk wijzigen te voorkomen.
- **HR / CO:** Machtigingen aanpassen zonder toegang tot technische functies, om administratieve taken te scheiden van ontwikkeling.

### Consequences

De rollen worden geïmplementeerd in Keycloak als standaardrollen.
Bij wijzigingen in verantwoordelijkheden kan de HR-persoon of de CO de rollen eenvoudig aanpassen via de Keycloak interface.
Door te kiezen voor RBAC in plaats van ABAC blijft het systeem eenvoudig en beheersbaar, zonder in te boeten aan noodzakelijke flexibiliteit.
In toekomstige uitbreidingen kan ABAC overwogen worden als de complexiteit van rollen significant toeneemt.