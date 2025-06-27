## ADR-007: Vergelijking Keycloak met andere IAM-oplossingen

**Datum:** 13-05-2025

### Status
Accepted

### Context

Voor het implementeren van Identity & Access Management (IAM) in onze applicatie is er een keuze te maken tussen het
gebruik van een bestaande oplossing zoals Keycloak, of het bouwen van een eigen custom IAM-systeem.  
Deze ADR vergelijkt de twee opties op basis van relevante criteria.

#### Considered Options

| Forces                                 | Keycloak | Custom IAM |
|----------------------------------------|----------|------------|
| Authenticatie methoden (MFA, SSO, etc) | ++       | +-         |
| Security audits & compliance           | ++       | -+         |
| Snelheid van implementatie             | ++       | --         |
| Onderhoudsbelasting                    | +-       | --         |
| Flexibiliteit in features              | +-       | ++         |
| Integratie met externe services        | ++       | +-         |
| Beheer en configuratiegemak            | +-       | +-         |
| Beveiliging bij zero-day exploits      | +-       | -+         |
| Audit logging en monitoring            | ++       | +-         |
| Toekomstige schaalbaarheid             | ++       | +-         |
| Risico op fouten (bugs, exploits)      | ++       | --         |
| Kosten                                 | ++       | --         |
| Ondersteuning en community             | ++       | 0          |
| Onderhoudbaarheid                      | +-       | 0          |

### Decision

We kiezen voor Keycloak vanwege de uitgebreide standaardfunctionaliteit, korte implementatietijd en bewezen security.
Een custom IAM-oplossing biedt meer flexibiliteit, maar vereist te veel ontwikkel- en onderhoudswerk.

### Consequences

* Snelle implementatie met minder risico's

* Minder ontwikkelcapaciteit nodig voor IAM

* Beperkte controle over zeer specifieke functionaliteiten

* Afhankelijkheid van een externe open-source tool

*Legenda:*

* ++ Zeer tevreden
* +- Tevreden
* 0 Neutraal
* -+ Ontevreden
* -- Zeer ontevreden