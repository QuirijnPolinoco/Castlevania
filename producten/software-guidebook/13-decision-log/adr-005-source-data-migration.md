## ADR-005: Oorsprong data applicatie

**Datum:** 13-05-2025

### Status
Accepted

### Context
Om het gebruik van Keycloak gemakkelijk te kunnen starten zou het automatisch overzetten van alle gebruikerdata handig zijn.<br>  
De data staat huidelijk opgeslagen op verschillende applicaties. <br>  
Deze ADR vergelijkt deze applicaties en kiest op basis van een aantal criteria de best passende uit.

### Considered Options
| Forces                       | Jira | Gitea | Google Cloud | Jenkins | Confluence | Nexus |
|------------------------------|------|-------|--------------|---------|------------|-------|
| Docker container beschikbaar | +    | +     | X            | +       | +          | +     |
| Necessary API's available    | ++   | ++    | ++           | X       | ++         | X     |
| Errors                       | +    | X     | +            | +       | X          | +     |

Legend:
- ++ : Excellent fit / Strong advantage
- + : Good fit / Advantage
- 0 : Neutral / Average
- - : Poor fit / Disadvantage
- -- : Very poor fit / Strong disadvantage
- X : Not fit / Unusable

### Decision
Alles behalve Jira tijdens het onderzoek af is gevallen, omdat deze niet voldoen aan de eisen, geen docker container beschikbaar hebben of niet toegankelijk is vanwege errors. Daarom is er voor Jira gekozen.

### Consequences
Door het gebruik van Jira, wordt alle gebruikers-data gehaald van Jira. Dit betekent dat de response er bijvoorbeeld zo uit komt te zien:
```Response
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
```
In de response zit de naam, de email en een username.
