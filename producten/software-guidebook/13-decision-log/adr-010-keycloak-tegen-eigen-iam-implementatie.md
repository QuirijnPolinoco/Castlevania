## ADR-010: Keycloak tegen eigen IAM-Implementatie

**Datum:** 21-05-2025

### Status
Accepted

### Context

Voor het IAM-systeem is een robuuste en flexibele authenticatieoplossing vereist. Keycloak biedt uitgebreide
mogelijkheden voor gebruiksbeheer en beveiliging, maar sommige functionaliteiten vereisen extra configuratie of externe
integraties.

### Considered Options

| Forces                        | Keycloak | Custom oplossing |
|-------------------------------|----------|------------------|
| Beveiliging                   | ++       | ++               |
| Flexibiliteit                 | ++       | ++               |
| Ondersteuning voor SSO & MFA  | ++       | +-               |
| Complexiteit van configuratie | -+       | --               |
| Onderhoud & beheer            | +-       | --               |
| Login methodes                | ++       | +-               |
| AVG                           | ++       | 0                |
| Logging- en Auditing          | +-       | 0                |

### Decision

We kiezen voor Keycloak als IAM-oplossing vanwege de uitgebreide ondersteuning voor SSO, MFA en identity brokering.
Hoewel sommige functionaliteiten extra configuratie vereisen, biedt Keycloak een solide basis voor veilige en schaalbare
authenticatie.

### Consequences

- **Voordelen**
    - Robuuste beveiliging en flexibiliteit
    - Ondersteuning voor moderne authenticatiemethodes zoals WebAuthn en federated login.
    - Open-source en uitbreidbaar via SPI
- **Nadelen**
    - Extra configuratie vereist voor sommige functies zoals SMS-authenticatie en Magic Link login.
    - Complexiteit bij beheer en onderhoud.

*Legenda:*

- ++ Zeer tevreden
- +- Tevreden
- 0 Neutraal
- -+ Ontevreden
- -- Zeer ontevreden