# 9. Data

BOLD Digital heeft gevraagd of we konden onderzoeken of de data van hun medewerkers kan worden overgezet naar Keycloak,
zodat medewerkers niet rechtstreeks op een applicatie afzonderlijk kunnen inloggen.

## 9.1 Data opslag

De data wordt binnen de applicatie opgeslagen in docker containers van Postgres databases. Deze worden automatisch ingericht. De Keycloak database wordt ingericht door het [realm-export.json](../walking-skeleton/realm-export.json) bestand, dit is wel enkel test-data. Dit moet niet op productie gerunt worden. Jira richt zelf zijn database in.

## 9.2 Data overzetten

Vanuit onderzoeken die gedaan zijn door ons kunnen we concluderen dat de data van externe applicaties zoals Jira en
Jenkins in Keycloak kunnen worden overgezet. Dit is te zien in het prototype "[data transfer](../walking-skeleton/src/main/java/nl/han/pexe/controller/DataTransferController.java)". Hier kan de email en de naam van het account opgehaald worden, en in Keycloak gezet worden. 

Groepen, medewerkers en beheerders kunnen worden overgezet naar Keycloak, zodat BOLD Digital de data van hun medewerkers
heel eenvoudig kunnen overzetten zonder moeite.

Ook is gebleken dat accounts vanuit keycloak naar andere applicaties gezet kan worden. Zo kunnen accounts in bulk overgezet worden naar Gitea. Dit is te zien in het "[Gitea sync](../walking-skeleton/src/main/java/nl/han/pexe/controller/GiteaSyncController.java)" onderzoek.

## 9.3 Data beheer

BOLD Digital kan de data beheren door middel van Keycloak, zodat medewerkers niet rechtstreeks op een applicatie
kunnen inloggen, maar alleen via Keycloak. Dit zorgt ervoor dat de data van medewerkers beter beveiligd is en dat
er minder kans is op datalekken. Keycloak biedt ook de mogelijkheid om gebruikers te beheren, zoals het toevoegen,
verwijderen en bewerken van gebruikers. Dit maakt het beheer van de data eenvoudiger en efficiënter
en zorgt ervoor dat BOLD Digital meer controle heeft over de toegang tot hun applicaties.