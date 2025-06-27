# 11. Deployment

## 11.1 Vereisten

- Docker & Docker Compose
- GitHub desktop of command line interface
- Toegang tot de repository met de Keycloak fallback prototype code
- Maven 3.9.9
- Java 17 of hoger

---

## 11.2 Installatie

**Stap 1:** Clone de repository: [Repository URL](https://github.com/AIM-ENE-feb25/castlevania)
- Gebruik de volgende commando's om de repository te klonen en naar de juiste map te navigeren.

```bash

git clone [repository-url](https://github.com/AIM-ENE-feb25/castlevania)

cd producten/walking-skeleton/

```

**Stap 2:** Start de containers:

Start Docker op en voer het volgende commando uit in de terminal om de containers te starten:

```bash

docker-compose up

```

**Stap 3:** Wacht tot alle services gestart zijn (ongeveer 30 seconden)

**Stap 4:** Start de Spring boot applicatie
Voer het volgende commando uit in de terminal om de Spring Boot applicatie te starten:

```bash
mvn spring-boot:run
```

---

## 11.3 Configuratie

### 11.3.1 Keycloak Instances

- Primary instance: http://localhost:8081

- Secondary instance: http://localhost:8082

- Admin console: http://localhost:8081/admin

- Admin credentials: admin/admin

#### 11.3.1.2 Keycloak Logging Deployment

Indien een custom keycloak logging optie toegevoegd moet worden, kan dit toegevoegd worden dmv. een Maven project
bestand.
Voor het maken van de benodigde Maven project, zie [code](#logging-keycloak-code).

Binnen de Maven project, in de resources folder, moet een file genaamd "
org.keycloak.events.EventListenerProviderFactory" komen.
Hierin moet de path naar de EventListenerProviderFactory staan, zodat keycloak weet waar hij dat kan vinden.

Hierna moet het gepackaged worden. Dit kan door de volgende command uit te voeren binnen het project:

```shell
mvn clean package
```

Binnen de target folder staat een .jar bestand. Deze moet insert worden binnen de keycloak instance(s). Dit moet in de "
/opt/keycloak/providers/" folder van keycloak komen.
Dan moet het volgende aan het docker compose stuk van keycloak worden toegevoegd:

```yaml
command:
  start-dev
  --spi-events-listener-provider=<id-van-event>
  --spi-events-listener-<id-van-event>-enabled=true
```

Het ID is wat bij de code is ingevoerd.

### 11.3.2 HaProxy

- Load balancer: http://localhost

- Health check endpoint: /health

- Sticky sessions: AUTH_SESSION_ID cookie

### 11.3.3 PostgreSQL

- Database: keycloak

- Username: keycloak

- Password: password

- Port: 5432 (intern)

### 11.3.4 Jira setup

```
Database Type: PostgreSQL
Hostname: jira-db
Port: 5432
Database: jiradb
Username: jira
Password: jira
Schema: public
```

### 11.3.5 Jenkins setup

```
JAVA_OPTS=-Djenkins.install.runSetupWizard=false
```

### 11.3.6 Gitea setup

```
USER_UID: 1000
USER_GID: 1000
GITEA__database__DB_TYPE: postgres
GITEA__database__HOST: postgres:5432
GITEA__database__NAME: keycloak
GITEA__database__USER: keycloak
GITEA__database__PASSWD: password
```

### 11.3.7 Mailhog setup

**Geen speciale environment variabels die nodig zijn hierbij**

---

## 11.4 Verificatie

1. Controleer of alle containers draaien:

```bash

docker-compose ps

```

2. Test de health checks:

```bash

curl http://localhost/health

```

3. Verifieer de load balancing:

```bash

curl -I http://localhost

```

---

## 11.5 Troubleshooting

### 11.5.1 Container Issues

- Check container logs: `docker-compose logs [service-name]`

- Verifieer container status: `docker-compose ps`

- Herstart specifieke service: `docker-compose restart [service-name]`

### 11.5.2 HaProxy Issues

- Check HaProxy configuratie: `docker-compose exec haproxy haproxy -c -f /usr/local/etc/haproxy/haproxy.cfg`

- Bekijk HaProxy logs: `docker-compose logs haproxy`

### 11.5.3 Keycloak Issues

- Check Keycloak logs: `docker-compose logs keycloak-primary`

- Verifieer database connectie: `docker-compose logs postgres`

## 11.6 Keycloak basic configuratie

### 11.6.1 Realm aanmaken

1. Ga naar de Keycloak admin
   console: [Realm instelling op master](http://localhost:8081/admin/master/console/#/master/realms)
2. Klik op "Create realm" om een nieuwe realm aan te maken.
3. Voer een naam in of import een realm via een bestaan JSON bestand.

### 11.6.2 Client aanmaken

1. Ga naar de Keycloak admin
   console: [Realm instelling op master](http://localhost:8081/admin/master/console/#/master/realms)
2. Selecteer de realm die je hebt aangemaakt.
3. Klik op "Clients" in het menu aan de linkerkant.
4. Klik op "Create client" om een nieuwe client aan te maken.
5. Kies de gewenste authenticatie methode (bijvoorbeeld `openid-connect` of `saml`).
6. Vul de vereiste informatie in, zoals de client ID, redirect URI's en andere instellingen.

### 11.6.3 Gebruiker aanmaken

1. Ga naar de Keycloak admin
   console: [Realm instelling op master](http://localhost:8081/admin/master/console/#/master/realms)
2. Selecteer de realm die je hebt aangemaakt.
3. Klik op "Users" in het menu aan de linkerkant.
4. Klik op "Add user" om een nieuwe gebruiker aan te maken.
5. Vul de vereiste informatie in, zoals gebruikersnaam, e-mailadres en wachtwoord.
6. Klik op "Save
7. Nadat de gebruiker is aangemaakt, kun je extra informatie toevoegen, zoals rollen en groepen. En het is belangrijk
   dat een temporary wachtwoord wordt ingesteld voor de gebruiker.

### 11.6.4 Groepen aanmaken
1. Ga naar de Keycloak admin
   console: [Realm instelling op master](http://localhost:8081/admin/master/console/#/master/realms)
2. Selecteer de realm die je hebt aangemaakt.
3. Klik op "Groups" in het menu aan de linkerkant.
4. Klik op "Create group" om een nieuwe groep aan te maken.
5. Voer een naam in voor de groep en klik op "Save".
6. Nadat de groep is aangemaakt, kun je gebruikers toevoegen aan de groep door naar de gebruikerslijst te gaan en
   de gewenste gebruikers te selecteren. Klik vervolgens op "Add to group" en kies de groep waaraan je de gebruikers wilt
   toevoegen.
7. Je kunt ook rollen toewijzen aan de groep door naar de "Roles" tab te gaan en de gewenste rollen te selecteren.
   Klik vervolgens op "Add selected" om de rollen toe te wijzen aan de groep.

### 11.6.5 Realm instellingen
1. Ga naar de Keycloak admin
   console: [Realm instelling op master](http://localhost:8081/admin/master/console/#/master/realms)
2. Selecteer de realm die je hebt aangemaakt.
3. Klik op "Realm settings" in het menu aan de linkerkant.
4. Hier kun je verschillende instellingen configureren, zoals de naam van de realm, het thema, de
   authenticatie methoden en andere opties zoals: Email instellingen, login instellingen en meer.

## 11.7 Client opzetten via Keycloak voor Gitea bijvoorbeeld

Om een client op te zetten via Keycloak, volg je deze stappen:
We vertellen hier ook hoe je de client kunt gebruiken in een externe applicatie zoals Gitea of Jenkins.

1. Log in op de Keycloak admin console.
2. Selecteer de gewenste realm (bijvoorbeeld `bold`).
3. Klik op "Clients" in het menu aan de linkerkant.
4. Klik op "Create client" om een nieuwe client aan te maken.
5. Kies de gewenste authenticatie methode (bijvoorbeeld `openid-connect` of `saml`).
    - Meeste externe applicaties gebruiken `openid-connect`. Hiervoor is er een onderzoek
      gedaan. [Onderzoek](../onderzoeken/iteratie-1/rbac-keycloak-analyse/rbac-keycloak.md) (Hoofdstuk ADR-002)
6. Vul de vereiste informatie in, zoals de client ID, redirect URI's en andere instellingen.
7. Zorg ervoor dat als je met `openid-connect` werkt, je de juiste scopes en rollen configureert voor de client. Vooral
   de client authenticatie moet je `Token exchange` aanzetten.
8. Klik op "Save" om de client aan te maken.
9. Configureer de client verder indien nodig, zoals het instellen van toegangsrechten, secret keys en andere
   instellingen.
10. Ga naar de gewenste externe applicatie (bijvoorbeeld Gitea of Jenkins) en configureer deze om de nieuwe client te
    gebruiken
    voor authenticatie via Keycloak.
11. Met dit voorbeeld gebruiken we even Gitea, login met de admin gebruiker en ga naar de instellingen van Gitea.
12. Ga naar "Authentication sources" en klik op "Add Authentication Source".
13. Kies "OpenID Connect" als type en vul de vereiste informatie in, zoals de client ID, secret key en
    de Keycloak server URL.
14. Voer de Auto Discovery URL in, bijvoorbeeld
    `http://keycloak:8080/auth/realms/bold/.well-known/openid-configuration`.
    - Deze link is te vinden via Realm instellingen in Keycloak. Als je helemaal naar beneden scrollt, dan zie je
      de link staan voor zowel `SAML` en `OpenID`.
15. Voeg als additional scopes `openid`, `email` en `profile` toe.
16. Klik op "Save" om de authenticatiebron toe te voegen.
17. Test de authenticatie door in te loggen op de externe applicatie met een gebruiker die is geregistreerd in Keycloak.

## 11.8 Keycloak en Sprintboot OAuth2 integratie

1. Ga naar `localhost:8080` en log in als admin.
    Met Username: `Admin` en Wachtwoord: `Admin`
    
2. Maak een nieuwe realm aan, bijvoorbeeld `bold`.
3. Maak een nieuwe client aan:
   - Ga naar de `Clients` sectie en klik op `Create`.
   - Vul de volgende gegevens in:
     - Client ID: `spring-boot-app`
     - Client Protocol: `openid-connect`
     - Redirect URI: `http://localhost:8080/login/oauth2/code/keycloak`
     - Web Origins: `http://localhost:8080`
     - Base URL: `http://localhost:8080/`
     - Access Type: `confidential`
   - Klik op `Save`.

4. Zorg ervoor dat Client authentication is ingesteld op:
   - Standard flow: enabled
   - Standard Token Exchange: enabled
   - Direct Access Grants: enabled
   - OAuth 2.0 Device Authorization Grant: enabled

5. Nadat je de client hebt aangemaakt, ga je naar de `Client scopes` sectie en voeg je de volgende scopes toe:
   - `profile`
   - `email`

6. Ga naar je springboot applicatie map.
7. Controleer of je client secret is ingesteld in Keycloak en niet leeg is en noteer deze in de applicatie.properties van de Spring
   Boot applicatie bij client secret. Je kan de client secret vinden in de `Credentials` tab van de client.

8. Je kunt nu naar de Spring Boot applicatie gaan op http://localhost:8081/secure en inloggen met de gebruiker alice en het
   wachtwoord alicepass.

9. En je daarna uitloggen via de http://localhost:8081/logout endpoint.


## 11.9 Jira data export naar Keycloak
1. Ga naar de instantie van Jira (default: http://localhost:8083).
2. Setup de database zoals [hier](#1134-jira-setup) is gemeld
3. Start de Spring Boot applicatie zoal [hier](#112-installatie) is beschreven.
4. Ivm met prototyping staan alle inloggegevens en keycloak gegevens hardcoded in de classes. Verander deze naar de juiste waarden.
5. Stuur een GET-request naar de endpoint <base-url>/transferJiraData waarbij base-url de url is van de Spring Boot applicatie (default: http://localhost:8080)

## 11.10 Gitea synchroniseren met Keycloak

Hiervoor moet een POST request gestuurd worden naar <http://localhost:8080/sync-gitea>. Geen data vereist. Wat wel nodig is, is een access token van Keycloak. Deze moet meegegeven worden in de authorization header, bijvoorbeeld: `Authorization: Bearer <TOKEN>`.

Om het uit te voeren kan je dit hierboven allemaal zelf doen, of je maakt gebruikt van het handige [shell script](../walking-skeleton/scripts/sync-gitea.sh).
