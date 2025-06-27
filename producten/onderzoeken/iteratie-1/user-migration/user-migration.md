# User Migration
#### Beschrijving: Gebruikeraccounts overzetten van de externe applicaties naar keycloak of een lokale database.
#### Onderzoeksvraag: Hoe kunnen accountgegevens in bulk overgezet worden naar keycloak of een lokale database vanaf een externe applicatie?
#### Type spike: Technisch

Deze spike bevat een prototype. De controller van dit prototype staat [hier](../../walking-skeleton/src/main/java%2Fwalking-skeleton%2Frollen-beheer%2Fdatatransfer%2Fcontroller%2FDataTransferController.java). <br>
Alle admin- usernames en wachtwoorden staan nu als plaintext in de classes. Het is aanbevolen om deze data in een environment variables bestand te zetten ivm. security. 
<br>In dit prototype worden Docker containers gebruikt in plaats van een live omgeving. Daarom is de base-url altijd een localhost. 
## Ophalen data
De eerste stap bij het overzetten van data is om de data op te halen waar het momenteel opgeslagen wordt.
<br>
Aangezien Keycloak alleen username en password als required heeft bij het aanmaken van een account, kan alle data van één applicatie komen. 
Het ophalen van de data wordt gedaan via de API-endpoints van de desbetreffence applicatie. <br>
Er is gekozen om Jira te gebruiken om alle gebruikersdata op te halen. Zie de [desbetreffende ARD](../../software-guidebook%2F13-decision-log%2F0001-source-data-migration.md) voor meer uitleg.
Dit wordt gedaan door een POST-request te sturen naar ``` <Jira-base-url>/rest/api/2/user/search?username=.``` met een admin- username en password.
<br>Hierbij ontvangt de Spring Boot applicatie een string die een array met alle users in een JSON format bevat. Dit zou er dan bijvoorbeeld zo uitzien:
```JSON 
[  
{  
"self": "http://localhost:8080/rest/api/2/user?username=gort",  
"key": "JIRAUSER10101",  
"name": "gort",  
"emailAddress": "gert@gmail.com",  
"avatarUrls": {  
"48x48": "https://www.gravatar.com/avatar/e7992aa2b59230b746ed1c2d486ac0f3?d=mm&s=48",  
"24x24": "https://www.gravatar.com/avatar/e7992aa2b59230b746ed1c2d486ac0f3?d=mm&s=24",  
"16x16": "https://www.gravatar.com/avatar/e7992aa2b59230b746ed1c2d486ac0f3?d=mm&s=16",  
"32x32": "https://www.gravatar.com/avatar/e7992aa2b59230b746ed1c2d486ac0f3?d=mm&s=32"  
},  
"displayName": "gert jansen",  
"active": true,  
"deleted": false,  
"timeZone": "Etc/UTC",  
"locale": "en_US"  
},  
{  
"self": "http://localhost:8080/rest/api/2/user?username=jan",  
"key": "JIRAUSER10000",  
"name": "jan",  
"emailAddress": "jan@gmail.com",  
"avatarUrls": {  
"48x48": "http://localhost:8080/secure/useravatar?avatarId=10341",  
"24x24": "http://localhost:8080/secure/useravatar?size=small&avatarId=10341",  
"16x16": "http://localhost:8080/secure/useravatar?size=xsmall&avatarId=10341",  
"32x32": "http://localhost:8080/secure/useravatar?size=medium&avatarId=10341"  
},  
"displayName": "jan",  
"active": true,  
"deleted": false,  
"timeZone": "Etc/UTC",  
"locale": "en_US"  
},  
{  
"self": "http://localhost:8080/rest/api/2/user?username=peter",  
"key": "JIRAUSER10100",  
"name": "peter",  
"emailAddress": "peter@pan.nl",  
"avatarUrls": {  
"48x48": "https://www.gravatar.com/avatar/18e9e9adb844123fcf10b8a33d81d46f?d=mm&s=48",  
"24x24": "https://www.gravatar.com/avatar/18e9e9adb844123fcf10b8a33d81d46f?d=mm&s=24",  
"16x16": "https://www.gravatar.com/avatar/18e9e9adb844123fcf10b8a33d81d46f?d=mm&s=16",  
"32x32": "https://www.gravatar.com/avatar/18e9e9adb844123fcf10b8a33d81d46f?d=mm&s=32"  
},  
"displayName": "peter pan",  
"active": true,  
"deleted": false,  
"timeZone": "Etc/UTC",  
"locale": "en_US"  
}  
]  
```
Omdat dit een string is, moet dit eerst omgezet worden naar de Record [UserData](..%2F..%2Fwalking-skeleton%2Fsrc%2Fmain%2Fjava%2Fwalking-skeleton%2Frollen-beheer%2Fdatatransfer%2Fdomain%2FUserData.java) met behulp van de [JiraUserParser](..%2F..%2Fwalking-skeleton%2Fsrc%2Fmain%2Fjava%2Fwalking-skeleton%2Frollen-beheer%2Fdatatransfer%2FJsonParser%2FJiraUserParser.java).

## Uploaden

### Keycloak
Voor het uploaden naar keycloak is een API-key nodig. 
Dit wordt opgehaald in de getAccessToken functie in de [KeycloakUserService](..%2F..%2Fwalking-skeleton%2Fsrc%2Fmain%2Fjava%2Fwalking-skeleton%2Frollen-beheer%2Fdatatransfer%2Fservice%2FKeycloakUserService.java) door een POST-request naar ``` <Keycloak-base-url>/realms/master/protocol/openid-connect/token ``` te sturen.
<br>
Deze POST-request bevat een client_id, en admin- username en password.
De admin-cli is een client die automatisch in een Keycloak applicatie staat.

Met de API-key, een realm en de list van UserData wordt er voor elke user een POST-request gestuurd naar ``` <Keycloak-base-url>/admin/realms/<realm>/users ```. <br>
Omdat het niet mogelijk is om het wachtwoord op te halen van elke user, wordt er een tijdelijk wachtwoord ingesteld en een flag toegevoegd waardoor alle users een nieuw wachtwoord in moeten stellen.
De flag wordt toegevoegd met
``` user.put("requiredActions", List.of("UPDATE_PASSWORD")); ```
<br>

### Locale database
Er is geen prototype gemaakt voor de locale database, aangezien dat best voor zichzelf spreekt. Indien de data beschikaar is binnen de Spring Boot applicatie kan dit via Spring Data JDBC makkelijk aan een database worden toegevoegd.


## Conclusie
Gebruikersdata kan automatisch overgezet worden van huidige applicaties naar keycloak met de API-endpoints.
<br>
Een Keycloak account zal de volgende eigenschappen hebben:
- Keycloak username: Jira email
- Keycloak first name: Jira name
- Keycloak password: Tijdelijk wachtwoord
- Elke gebruiker heeft een flag dat het wachtwoord van zijn account verandert moet worden.

## Sources
- [Jira API documentation](https://developer.atlassian.com/cloud/jira/platform/rest/v3/intro/)<br>
- [Jira Docker container](https://hub.docker.com/r/atlassian/jira-software)<br>
- [Confluence Docker container](https://hub.docker.com/r/atlassian/confluence)<br>
- [Jenkins Docker container](https://hub.docker.com/r/jenkins/jenkins)<br>
- [Nexus Docker container](https://hub.docker.com/r/sonatype/nexus3/)<br>
- [Gitea Docker container](https://docs.gitea.com/installation/install-with-docker)<br>
- [Keycloak Docker container](https://www.keycloak.org/getting-started/getting-started-docker)<br>
- [Keycloak API documentation](https://www.keycloak.org/docs-api/latest/rest-api/index.html)<br>
- [ChatGPT mening over beste applicatie (1e prompt)](https://chatgpt.com/c/681b16a6-1684-8005-8524-ed6d4703f8b9)