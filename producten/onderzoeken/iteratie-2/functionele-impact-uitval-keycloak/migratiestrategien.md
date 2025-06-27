# ADR-XXX: Migratiestrategieën voor Keycloak Uitval

## Status

Concept

## Context

Bij uitval van Keycloak als centrale authenticatie- en autorisatieoplossing is het essentieel om passende fallback-mechanismen en technische mitigaties te implementeren. Deze ADR beschrijft de verschillende strategieën die kunnen worden toegepast om de impact van Keycloak-uitval te minimaliseren, inclusief een analyse van de risico's, haalbaarheid en complexiteit van elke aanpak.

## Considered Options

| Evaluatiepunt | Load-balanced/Failover | Token-caching | Offline Sessies |
|---------------|----------------------|---------------|----------------|
| Beschikbaarheid | ++ | + | ++ |
| Beveiliging | ++ | + | - |
| Implementatie Complexiteit | + | 0 | ++ |
| Keycloak Ondersteuning | ++ | + | - |
| Operationele Complexiteit | + | - | ++ |

Legenda:
- ++ : Zeer positief
- \+ : Positief
- 0 : Neutraal
- \- : Negatief
- -- : Zeer negatief

### Load-balanced en Failover Keycloak-instances

De implementatie van een load-balanced en failover Keycloak-architectuur biedt de meest robuuste oplossing voor het waarborgen van beschikbaarheid. Deze aanpak omvat het opzetten van meerdere Keycloak-instances achter een load balancer, waarbij automatische failover wordt geïmplementeerd bij uitval van een instance.

De haalbaarheid van deze oplossing is hoog, aangezien Keycloak standaard ondersteuning biedt voor clustering en load balancing. De complexiteit van implementatie is echter aanzienlijk, met name in de initiële setup en configuratie van de load balancer en database replicatie. Risico's zijn beperkt tot mogelijke synchronisatieproblemen tussen instances en een verhoogde operationele complexiteit.

### Token-caching bij Clients

Token-caching bij clients vormt een effectieve mitigatiestrategie voor korte periodes van Keycloak-uitval. Deze aanpak omvat het implementeren van lokale token validatie en caching van autorisatiebeslissingen bij client applicaties. De haalbaarheid is hoog, met name voor applicaties die reeds JWT tokens gebruiken, aangezien deze tokens lokaal kunnen worden gevalideerd zonder directe Keycloak-afhankelijkheid.

De implementatiecomplexiteit varieert per applicatie, maar is over het algemeen beheersbaar. Risico's zijn voornamelijk gerelateerd aan de beveiliging van gecachte tokens en het beheer van token levensduur. Een te lange cache-periode kan beveiligingsrisico's met zich meebrengen, terwijl een te korte periode de effectiviteit van de mitigatie vermindert.

### Offline Sessies en Fallback Authenticatie

Voor kritieke applicaties kan de implementatie van offline sessies en fallback authenticatiemechanismen worden overwogen. Deze strategie stelt applicaties in staat om te blijven functioneren met beperkte functionaliteit tijdens Keycloak-uitval. De haalbaarheid is afhankelijk van de specifieke beveiligingsvereisten van elke applicatie.

De complexiteit van implementatie is hoog, met name bij het ontwikkelen van veilige fallback-mechanismen die voldoen aan beveiligingsstandaarden. Risico's omvatten potentiële beveiligingskwetsbaarheden in fallback-mechanismen en de mogelijkheid van ongeautoriseerde toegang tijdens uitvalperiodes.

## Decision

Op basis van de analyse van de verschillende strategieën, adviseren wij een gelaagde aanpak die de sterke punten van elke strategie combineert:

1. **Primaire Mitigatie**: Implementeer een load-balanced Keycloak-architectuur met automatische failover voor maximale beschikbaarheid van de authenticatieservice.

2. **Secundaire Mitigatie**: Implementeer token-caching bij clients met zorgvuldig geconfigureerde cache-periodes, gebalanceerd tussen beveiliging en beschikbaarheid.

3. **Tertiaire Mitigatie**: Ontwikkel fallback authenticatiemechanismen voor kritieke applicaties, met strikte beveiligingscontroles en duidelijke beperkingen in functionaliteit.

Deze gelaagde aanpak biedt de beste balans tussen beschikbaarheid, beveiliging en implementatiecomplexiteit. De primaire mitigatie zorgt voor hoge beschikbaarheid van de Keycloak-service zelf, terwijl de secundaire en tertiaire mitigaties de impact van eventuele uitval minimaliseren.

## Consequences

**Positief**:

- Verhoogde systeemresilientie tegen Keycloak-uitval
- Betere gebruikerservaring tijdens verstoringen
- Geoptimaliseerde balans tussen beveiliging en beschikbaarheid
- Duidelijke escalatiepaden bij verschillende niveaus van uitval

**Negatief**:

- Aanzienlijke initiële investering in infrastructuur en ontwikkeling
- Verhoogde operationele complexiteit
- Extra monitoring en onderhoud vereist
- Potentiële beveiligingsrisico's bij fallback-mechanismen

## Bronnen

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
