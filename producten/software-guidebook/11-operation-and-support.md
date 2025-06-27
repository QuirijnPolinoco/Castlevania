# 12. Operation and support

Dit hoofdstuk beschrijft de operationele en ondersteuningsaspecten van de software. Het is belangrijk om deze aspecten
goed te documenteren, zodat je weet hoe
de software gebruikt wordt en hoe je deze kunt ondersteunen.

## 12.1 Docker gebruik

Voor de prototypes die beschikbaar zijn gesteld in de repository, is het gebruik van Docker essentieel. Docker biedt een
gestandaardiseerde omgeving waarin
de applicaties kunnen draaien, wat zorgt voor consistentie en eenvoud in deployment. De Dockerfiles en
docker-compose.yml bestanden zijn opgenomen in de
Walking skeleton map in de repository. De Docker file bevat configuratie van het hoofd applicatie zoals Keycloak, maar
biedt ook de mogelijkheid om te werken met Jira, Jenkins, Postgres en Gitea.

Het is wel belangrijk om te weten dat alle Docker containers draaien op de Keycloak-network. Dit netwerk heeft ook een
alias `keycloak` die gebruikt wordt in
Gitea en Jenkins voor de SSO-integratie. Dit zorgt ervoor dat de applicaties elkaar kunnen vinden en communiceren binnen
het netwerk.

### 12.1.1 Docker hostname

De Docker containers zijn geconfigureerd om te draaien op de hostname `keycloak`. Dit betekent dat alle applicaties die
geïntegreerd zijn met Keycloak, zoals Gitea en Jenkins, deze hostname gebruiken voor Single Sign-On (SSO) integratie.

Het is wel van belang om te weten dat je deze hostname niet kan gebruiken in je lokale browser, maar je moet gebruik
maken van `localhost:8081, localhost:8082 of localhost` om in te kunnen loggen met Keycloak.

Als je probeert in te loggen met Gitea "`localhost:3000`" dan word je verstuurd naar de Gitea omgeving, daaruit kun je
kiezen
om in te loggen met Keycloak je wordt verwezen naar `keycloak:8080` en dat werkt niet, omdat je geen localhost hebt
gebruikt in je URL in de browser. Als je `keycloak:8080` veranderd naar `localhost:8081` dan kan je inloggen met
Keycloak en je wordt dan
doorverwezen naar een 500 internal server error, dit heeft te maken met Gitea die een bepaalde pagina niet kan vinden,
dit probleem komt ook voor bij Jenkins.

## 12.2 Requirements

### 12.2.1 Welke requirements worden afgedekt?

De volgende requirements worden afgedekt door de software:

- **Authenticatie en autorisatie**: De software biedt een centrale authenticatie- en autorisatieoplossing via Keycloak,
  die
  Single Sign-On (SSO) functionaliteit ondersteunt voor alle geïntegreerde applicaties.
- **Integratie met bestaande systemen**: De software integreert met verschillende interne en externe systemen, zoals
  Gitea, Jenkins en Jira, voor een naadloze gebruikerservaring.
- **Beveiliging**: De software maakt gebruik van gestandaardiseerde protocollen zoals OAuth2, OIDC en SAML2 voor veilige
  communicatie en authenticatie.
- **Schaalbaarheid en hoge beschikbaarheid**: De architectuur is ontworpen met het oog op schaalbaarheid door load
  balancing
  en hoge beschikbaarheid door redundantie.
- **Documentatie en ondersteuning**: Er is uitgebreide documentatie beschikbaar over de architectuur, configuratie en
  gebruik van de software, evenals ondersteuning via de elaboratiegroep.
- **Docker ondersteuning**: De software is gecontaineriseerd met Docker, wat zorgt voor een gestandaardiseerde
  omgeving en eenvoud in deployment. De Dockerfiles en docker-compose.yml bestanden zijn beschikbaar in de repository.
- **HAproxy**: De software maakt gebruik van HAproxy zodat je geen zorgen hoeft te maken over de load balancing en geen
  zorgen hoeft te maken als een van de Keycloak servers uitvalt.

### 12.2.2 Welke requirements worden niet afgedekt?

De volgende requirements worden niet afgedekt door de software:

- **Gebruikersinterface**: De software biedt geen specifieke gebruikersinterface voor de eindgebruikers, aangezien het
  zich richt op de backend authenticatie en autorisatie. Alleen de Keycloak admin console en de externe applicaties zijn
  beschikbaar voor beheer.

## 12.3 Errors bekijken

Om fouten te bekijken in verandering die je door brengt tijdens het ontwikkelen van de software, kun je de logs bekijken
via terminal en of via Docker. Natuurlijk is ook een pipeline mogelijk om de logs te bekijken in een CI/CD-omgeving,
maar dat gaat alleen over de code die je schrijft.

Je kunt logs van Keycloak, Gitea of Jenkins bekijken via de terminal of via de Docker app als je op een specifieke
container klikt.

## 12.4 Code veranderingen

Als je aan de slag gaat met programmeren en je maakt veranderingen in de code, dan is het belangrijk om te weten dat je
jouw
applicatie opnieuw moet opstarten om wijzigingen te kunnen zien. Dit moet je doen, omdat er geen live server is opzet

## 12.6 Health Checks en Monitoring

### 12.6.1 HAProxy Health Checks
HAProxy voert automatisch health checks uit op de Keycloak instances om de beschikbaarheid te garanderen. Deze checks zijn geconfigureerd in de HAProxy configuratie:

```haproxy
backend keycloak_backend
    option httpchk GET /health/ready
    http-check expect status 200
    http-check expect ! rstatus ^5
    default-server inter 2s fall 3 rise 2
```

Deze configuratie zorgt voor:
- **Frequentie**: Health checks elke 2 seconden (`inter 2s`)
- **Failover**: Server wordt als 'down' gemarkeerd na 3 mislukte checks (`fall 3`)
- **Herstel**: Server wordt weer als 'up' gemarkeerd na 2 succesvolle checks (`rise 2`)
- **Endpoint**: Controleert de `/health/ready` endpoint van Keycloak
- **Verwachting**: Verwacht een HTTP 200 status code
- **Foutdetectie**: Detecteert 5xx server errors

### 12.6.2 Keycloak Health Status
Keycloak biedt verschillende health check endpoints:
- `/health/ready`: Controleert of Keycloak klaar is voor gebruik
- `/health/live`: Controleert of Keycloak actief is
- `/health/started`: Controleert of Keycloak is gestart

Deze endpoints zijn beschikbaar op de management port (9000) van elke Keycloak instance.

### 12.6.3 Monitoring in Docker
Je kunt de health status van de containers monitoren via Docker:

```bash
# Bekijk de status van alle containers
docker-compose ps

# Bekijk de logs van HAProxy
docker-compose logs haproxy

# Bekijk de logs van Keycloak instances
docker-compose logs keycloak-primary
docker-compose logs keycloak-secondary
```

### 12.6.4 Troubleshooting Health Checks
Als er problemen zijn met de health checks:

1. **Controleer HAProxy logs**:
   ```bash
   docker-compose logs haproxy | grep "health"
   ```

2. **Verifieer Keycloak health endpoints**:
   ```bash
   curl http://localhost:8081/health/ready
   curl http://localhost:8082/health/ready
   ```

3. **Controleer management port**:
   - Zorg dat port 9000 bereikbaar is voor health checks
   - Verifieer dat de Keycloak instances luisteren op deze port

4. **Controleer netwerk connectiviteit**:
   ```bash
   docker-compose exec haproxy ping keycloak-primary
   docker-compose exec haproxy ping keycloak-secondary
   ```

### 12.6.5 Automatische Failover
Het systeem voert automatisch failover uit wanneer:
- Een Keycloak instance niet meer reageert
- De health check endpoint een fout retourneert
- De server 3 opeenvolgende health checks faalt

De failover is transparant voor gebruikers dankzij:
- Sticky sessions via AUTH_SESSION_ID cookie
- Automatische herverdeling van verkeer
- Behoud van actieve sessies
