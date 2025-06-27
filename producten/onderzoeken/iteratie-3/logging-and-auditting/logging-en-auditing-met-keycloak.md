# Logging en auditing met keycloak

Voor dit onderzoek zijn Docker-containers gebruikt.
- [Keycloak container documentatie](https://www.keycloak.org/server/containers)
- [Gitea container documentatie](https://docs.gitea.com/installation/install-with-docker)

## Binnen keycloak
Keycloak bevat zelf logging-functionaliteiten. Dit wordt gedaan door middel van Events. Als een event op treed, wordt deze gelogd.
De logging-opties binnen keycloak worden ingesteld via de Realm-settings->Events op de admin-panel. 
Er staan een groot aantal default events klaar on startup. Deze kunnen aan of uitgezet worden.
Op een dev omgeving staan de logs worden initieel alleen opgeslagen in de terminal. In productie draait Keycloak via een Java-container, waarin logconfiguraties via logbestanden ingesteld kunnen worden.

### Database
Indien Keycloak verbonden is aan een database, heeft Keycloak ook een optie om logs op te slaan in zijn database. Dit kan ingesteld worden onder 'Realm settings'. Hierbij kan voor admin- of user-events aangeven worden of deze opgeslagen moeten worden, en hoelang het in de database moet komen te staan. De table waar dat in komt te staan heet "event_entity" voor user logs en "admin_event_entity" voor admin logs.
Een user-event zijn gebeurtenissen veroorzaakt door gebruikers, zoals inloggen, uitloggen, wachtwoord wijzigen.
En de admin-events zijn wijzigingen die beheerders doen in de Keycloak Admin Console, zoals gebruikers aanmaken of client-instellingen wijzigen.
<br> De tabel-schema ziet er als volgt uit voor de event_entity:


| Kolomnaam      | Type               | Beschrijving                                  |
| -------------- | ------------------ |-----------------------------------------------|
| `id`           | UUID               | Unieke ID voor het event                      |
| `event_time`   | BIGINT (timestamp) | Tijdstip van het event                        |
| `type`         | VARCHAR            | Type event (bijv. `LOGIN`, `LOGOUT`)          |
| `realm_id`     | VARCHAR            | Realm waarin het event plaatsvond             |
| `client_id`    | VARCHAR            | Client-ID die het event triggerde             |
| `user_id`      | VARCHAR            | Gebruikers-ID waarop het event betrekking had |
| `ip_address`   | VARCHAR            | IP-adres van de gebruiker                     |
| `error`        | VARCHAR (nullable) | Foutmelding indien van toepassing             |
| `details_json` | TEXT               | Extra details in JSON-formaat                 |

En zo voor de admin_event_entity:

| Kolomnaam          | Type               | Beschrijving                               |
| ------------------ |--------------------| ------------------------------------------ |
| `id`               | UUID               | Unieke ID van het admin-event              |
| `admin_event_time` | BIGINT (timestamp) | Tijdstip van het event                     |
| `realm_id`         | VARCHAR            | Realm waarin het event plaatsvond          |
| `auth_realm_id`    | VARCHAR            | Realm van de admin-gebruiker               |
| `auth_client_id`   | VARCHAR            | Client waarmee de admin was ingelogd       |
| `auth_user_id`     | VARCHAR            | ID van de admin-gebruiker                  |
| `resource_type`    | VARCHAR            | Type resource (bijv. `USER`, `CLIENT`)     |
| `operation_type`   | VARCHAR            | Actie (`CREATE`, `UPDATE`, `DELETE`, etc.) |
| `resource_path`    | VARCHAR            | Pad naar de bewerkte resource              |
| `representation`   | TEXT               | JSON-representatie van de resource         |
| `error`            | VARCHAR (nullable) | Foutmelding indien aanwezig                |

Naast dat ze in de database beschikbaar zijn, zijn ze nu ook onder "Events" te vinden in de admin-panel.

### Event Listener SPI
Keycloak ondersteunt een Event Listener Service Provider Interface (SPI), waarmee je eigen event-handlers kunt schrijven (bijv. voor loggen naar een extern systeem).

Standaard meegeleverde listeners:
- `jboss-logging`: logt naar stdout of logbestanden
- `email`: stuurt e-mails op bepaalde events

Deze zijn te vinden onder "Manage Realms->Events".<br>
#### Custom Event Listeners
Events kunnen custom gebouwt worden in Java. Keycloak heeft een [library](https://www.keycloak.org/docs-api/latest/javadocs/org/keycloak/events/package-summary.html) gemaakt voor custom events. Er is een [prototype](throwaway-prototype-logging%2Fkeycloak-extension%2Fpom.xml) beschikbaar.<br>
Om deze library te kunnen gebruiken moet er een EventListenerProviderFactory gemaakt worden. Deze instantieerd alle events.<br> Events zelf worden aangemaakt met de EventListenerProvider. Er wordt verschil gemaakt tussen admin en niet-admin events. Hierin kan de logica voor het event en wat er moet gebeuren als het optreed. Hier moet ook een id worden opgegeven. Dit is de naam die de Event(s) zal hebben.
<br>In de resources folder moet een folder aangemaakt worden "META-INF" met daarin "services" en daarin het bestand org.keycloak.events.EventListenerProviderFactory.
Dit bestand moet het path naar de EventListenerProviderFactory bevatten.
Hierna kan het project gepackaged worden. De .jar moet dan in "/opt/keycloak/providers/" gezet worden.

Dan moet Keycloak weten dat er gebruik van gemaakt wordt door dit toe te voegen aan de Docker compose file:
```yaml
command:
   start-dev
   --spi-events-listener-provider=<id-van-event>
   --spi-events-listener-test-event-listener-enabled=true
```

## Buiten Keycloak

Hoewel Keycloak zelf uitgebreide logging- en audit-mogelijkheden biedt, is het in veel situaties wenselijk om logging buiten Keycloak af te handelen. Denk hierbij aan centrale logging-oplossingen, monitoringtools of integratie met bestaande SIEM-systemen (Security Information and Event Management). Dit maakt het mogelijk om logs van meerdere systemen op één plek te verzamelen, te analyseren en te correleren. Dit is in grotere of productieomgevingen essentieel is voor security en debugging.
<br>In dit hoofdstuk wordt ingegaan op methoden en tools die buiten Keycloak vallen, maar wel relevant zijn voor het monitoren en auditen van Keycloak-activiteit. Hierbij kan gedacht worden aan tools zoals Loki/Grafana, Elasticsearch, Fluentd of Filebeat in combinatie met Kibana. Daarnaast kunnen logbestanden van de container, of aangepaste event listeners doorgegeven worden aan externe systemen.

Om een onderzoek te kunnen doen moet de optie wel een mogelijkheid hebben om lokaal in een Docker-container te maken. Indien dit niet mogelijk is, wordt de optie niet opgenomen.
Dan blijven de volgende opties over:
- Grafana + Loki + Pomtail

### Grafana Loki Pomtail
Dit is een combinatie van de services Grafana, Loki en Pomtail.<br>
- Grafana is het dashboard
- Loki is een log database
- Pomtail is een logscraper

De test Docker-compose file is [hier](docker%20compose/docker-compose.yml) beschikbaar.
Keycloak slaat login-attempts niet op in zijn logs. Dit zorgt ervoor dat deze niet zichtbaar zijn bunnen Grafana.
De custom event wordt daarintegen wel opgeslagen in de logs. Dit zorgt ervoor dat deze dus wel zichtbaar ik in Grafana.



## Conclusie
Keycloak heeft uit zichzelf al veel logging opties. Indien deze opties niet voldoende zijn, kunnen er meer logging mogelijkheden aangemaakt worden door middel van Event Listener SPI's.
De logs kunnen overzichtelijk 

## Bronnen
[Keycloak event documentation](https://www.keycloak.org/docs-api/latest/javadocs/org/keycloak/events/package-summary.html)
[Keycloak Containers](https://www.keycloak.org/server/containers)
[Keycloak Database Documentation](https://www.keycloak.org/server/db)

