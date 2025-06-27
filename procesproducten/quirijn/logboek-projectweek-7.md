# Logboek Projectweek 7

> [!TIP]
> [Gebruik deze handige plugin voor het invullen van markdown tabellen in vscode](https://marketplace.visualstudio.com/items?itemName=zaaack.markdown-editor)
>
> [Hier kun je een cheatsheet met alle GitHub emojis vinden](https://github.com/ikatyang/emoji-cheat-sheet/blob/master/README.md)

## Maandag 2 juni

| Tijd | Met Wie | Taak | Resultaat | Emoji | Link |
| :----- | --------- | --------- | ----------- | ------- | ------ |
| 6 | Alleen | HaProxy basis setup | Basis HaProxy opgezet voor het prototype. Ondanks dat het lang duurde wat ik al had verwacht in verband met complexiteit, is het gelukt om een goede basis proxy op te zetten. Ik heb veel nieuwe dingen geleerd over wat een proxy exact doet en hoe het voor HaProxy exact werkt. Dit zorgde ervoor dat ik blij bezig was met dit onderdeel door de mooie combinatie tussen onderzoeken, uitvoeren en testen. | tevreden | [Issue](https://github.com/orgs/AIM-ENE-feb25/projects/6/views/4?filterQuery=milestone%3A%22Iteratie+3%22+assignee%3AQuirijnPolinoco&pane=issue&itemId=112521292&issue=AIM-ENE-feb25%7Ccastlevania%7C181), [Commit](https://github.com/AIM-ENE-feb25/castlevania/commit/46f6240d0c9dd4f71b4c1efb696d91622eaa7ffe) |
| 2 | Alleen | HaProxy configuratie | Configuratie van HaProxy voor het beheren van beide Keycloak instances. Er waren veel tegenslagen met het zorgen dat het werkte als front voor beide instances. Het lukte niet om een goede failover te implementeren waarbij het systeem blijft werken als één instance uitvalt. Dit kostte meer tijd dan verwacht door de complexiteit van de failover configuratie. | neutraal | [Issue](https://github.com/orgs/AIM-ENE-feb25/projects/6/views/4?filterQuery=milestone%3A%22Iteratie+3%22+assignee%3AQuirijnPolinoco&pane=issue&itemId=112521294&issue=AIM-ENE-feb25%7Ccastlevania%7C182), [Commit](https://github.com/AIM-ENE-feb25/castlevania/commit/46f6240d0c9dd4f71b4c1efb696d91622eaa7ffe) |

## Dinsdag 3 juni

| Tijd | Met Wie | Taak | Resultaat | Emoji | Link |
| :----- | --------- | --------- | ----------- | ------- | ------ |
| 2 | Alleen | HaProxy basis setup vervolg | Verder gegaan met mijn taak van maandag om de basis setup van HaProxy in te stellen, hierbij de laatste puntjes op de i neergezet om te zorgen dat de port en portforward goed werkt voor beide keycloak instancies. Ondanks dat ik wat problemen had met de redirect naar de correcte url en dus realm van keycloak is het me uiteindelijk wel gelukt met een resultaat waar ik meer dan tevreden mee ben. | zeer tevreden | [Issue](https://github.com/orgs/AIM-ENE-feb25/projects/6/views/4?filterQuery=milestone%3A%22Iteratie+3%22+assignee%3AQuirijnPolinoco&pane=issue&itemId=112521292&issue=AIM-ENE-feb25%7Ccastlevania%7C181), [Commit](https://github.com/AIM-ENE-feb25/castlevania/commit/2566aaf74d8c28a67f32ee137628202c00e77b09) |
| 2 | Alleen | HaProxy configuratie vervolg | Vervolg op de HaProxy configuratie voor de Keycloak instances. Probleem opgelost van gister door gebruik te maken van een sticky session waardoor de gebruiker op dezelfde instancie blijft en dit zorgt dat de gebruiker goed kan inloggen, healthcheck toegevoegd zodat de configuratie ook goed controleert of er een keycloak instancie uit staat voordat hij hier een gebruiker naar toe door stuurt via de proxy. | tevreden | [Issue](https://github.com/orgs/AIM-ENE-feb25/projects/6/views/4?filterQuery=milestone%3A%22Iteratie+3%22+assignee%3AQuirijnPolinoco&pane=issue&itemId=112521294&issue=AIM-ENE-feb25%7Ccastlevania%7C182), [Commit](https://github.com/AIM-ENE-feb25/castlevania/commit/2566aaf74d8c28a67f32ee137628202c00e77b09) |
| 1 | Alleen | Insert script verbeteren | Testscript bijgewerkt om te zorgen dat je als gebruiker in de correcte realm terecht komt in combinatie met dat de permissies ingesteld zijn dat je daadwerkelijk lijkt alsof je inlogt op je eigen account. Permissies gebonden aan een group. Paar keer het script moeten herschrijven om te testen per onderdeel maar in vond dit een leuke taak omdat het even anders was dan het HaProxy configuratie stuk. | tevreden | [Issue](https://github.com/orgs/AIM-ENE-feb25/projects/6/views/4?filterQuery=milestone%3A%22Iteratie+3%22+assignee%3AQuirijnPolinoco&pane=issue&itemId=112521324&issue=AIM-ENE-feb25%7Ccastlevania%7C183), [Commit](https://github.com/AIM-ENE-feb25/castlevania/commit/eafc9395d2ad9ebc38474bf1f365e86bb6e9e594) |
| 3 | Met Yousif | Keycloak redirect probleem oplossen | Samen met Yousif geprobeerd een 500 error op te lossen vanuit keycloak redirect terug naar gitea naar inliggen. Hard geprobeerd te zoeken naar waardoor het kwam en hoe we het konden oplossen alleen zijn er helaas niet achter komen op dit moment wat ervoor zorgde dat we er ook niet heel veel zin meer in hadden hierna. | neutraal | [Commit](https://github.com/AIM-ENE-feb25/castlevania/commit/3eb7e986a1cc1c0ec329bf528f5b6fbc9e922b37) |

## Woensdag 4 juni

| Tijd | Met Wie | Taak | Resultaat | Emoji | Link |
| :----- | --------- | --------- | ----------- | ------- | ------ |
| 3 | Alleen | Prototype testen | Uitgebreid testen van het Keycloak fallback prototype met focus op load balancing, health checks en failover mechanismen. Alle tests waren succesvol uitgevoerd waardoor ik makkelijk mijn rapport kon schrijven. Dit kwam met namen ook door het continue testen tijdens het opzetten van mijn prototype. | neutraal | [Issue](https://github.com/orgs/AIM-ENE-feb25/projects/6/views/4?filterQuery=milestone%3A%22Iteratie+3%22+assignee%3AQuirijnPolinoco&pane=issue&itemId=112521345&issue=AIM-ENE-feb25%7Ccastlevania%7C184), [Commit](https://github.com/AIM-ENE-feb25/castlevania/commit/d1d9b66743232796591eca5da8dd57ef305087c1) |
| 4 | Alleen | Software Guidebook | Uitbreiden en verbeteren van de software guidebook op basis van mijn gemaakte prototype. Meerdere diagrammen toegevoegd met bijbehorende uitleg om de architectuur en werking van het systeem duidelijk te documenteren. Het was een productieve dag waarbij ik de diagrammen goed verder kon maken op basis van de diagrammen uit de pre-game en ik op een goed tempo de hoofdstukken kon bewerken doordat er voorheen weinig informatie erin stond en ik de informatie al concreet had vanuit mijn proxy.cfg en compose bestanden. | tevreden | [Issue](https://github.com/orgs/AIM-ENE-feb25/projects/6/views/4?filterQuery=milestone%3A%22Iteratie+3%22+assignee%3AQuirijnPolinoco&pane=issue&itemId=112521357&issue=AIM-ENE-feb25%7Ccastlevania%7C185), [Commit](https://github.com/AIM-ENE-feb25/castlevania/commit/d1d9b66743232796591eca5da8dd57ef305087c1) |
| 2 | Met Tineke Jacobs en Sander Leer | IPV gesprek | Gesprek gehad over persoonlijke voortgang met spikes en teamontwikkeling. Positief gesprek met ruimte voor tips en tops. Blij met de open communicatie binnen het team, vooral met Lucas en Emil, wat zorgt voor betere ontwikkeling. Goede indruk van mogelijke verbeteringen in de toekomst. | tevreden | |

## Donderdag 5 juni

> Optionele opmerking.


| Tijd | Met Wie | Taak | Resultaat | Emoji | Link |
| :----- | --------- | --------- | ----------- | ------- | ------ |
| 2 | Alleen | Docker Compose integratie | Meerdere docker composes samengevoegd om te zorgen dat onze containers samenwerken. Er waren een paar kleine problemen met het correct opzetten van sommige ports, maar in het algemeen verliep het allemaal super soepel. | tevreden | [Issue](https://github.com/orgs/AIM-ENE-feb25/projects/6/views/4?filterQuery=milestone%3A%22Iteratie+3%22+assignee%3AQuirijnPolinoco&pane=issue&itemId=113953461&issue=AIM-ENE-feb25%7Ccastlevania%7C221), [Commit](https://github.com/AIM-ENE-feb25/castlevania/commit/69b481f46ba23ce2295a02937241f099f52c9ab9) |
| 5 | Met Lucas | Prototype integratie | Samen met Lucas gekeken naar de integratie van onze 2 prototypes om te zorgen dat ze goed samenwerken. Geprobeerd om te zorgen dat er automatisch een script wordt gerunned en dat de gebruikers vanuit Confluence/Jira goed worden toegevoegd en toegankelijk zijn via de Proxy. De samenwerking verliep goed waarbij er ruimte was om te overleggen waar wat hoort te staan en hoe het in elkaar zit. | tevreden | [Issue](https://github.com/orgs/AIM-ENE-feb25/projects/6/views/4?pane=issue&itemId=114537356&issue=AIM-ENE-feb25%7Ccastlevania%7C228), [Commit](https://github.com/AIM-ENE-feb25/castlevania/commit/c0b026b6d21247160e2f88c1140a13cd70545b10) |

## Vrijdag 6 juni

> Optionele opmerking.


| Tijd | Met Wie | Taak | Resultaat | Emoji | Link |
| :----- | --------- | --------- | ----------- | ------- | ------ |
| 4 | Alleen | Yousif prototype integratie | Gewerkt aan het proberen te integreren van Yousif zijn prototype op zijn branch. Meerdere wegen geprobeerd om de port en init aan te passen om te zorgen dat Keycloak samen werkt met Gitea. Helaas lukte dit niet ondanks dat meerdere pogingen voor integratie liep ik vast. Door het proberen heen was het wel allemaal leuk om te proberen te vinden. De verschillende wegen waar het fout kan gaan in combinatie met de hoeveelheid oplossingen die er zijn maakte het probleem complex en een beetje leuk. | tevreden | |
