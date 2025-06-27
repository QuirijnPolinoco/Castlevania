# Logboek Projectweek 6

## Maandag 26 mei

> Optionele opmerking.

| Tijd | Naam van de taak | Met Wie | Resultaat | Emoji | Link |
|:-----|-----------------|----------|-----------|--------|------|
| 1 | Review pull request | Met Yousif | Spike gereview van Yousif Verificatie en aanmeldstromingen. De review verliep vlot doordat Yousif's documentatie helder was en hij direct beschikbaar was voor vragen. Zijn documenten waren netjes gestructuurd met duidelijke naamgeving. het was makkelijk om alle bijhorende informatie te vinden die bij zijn spike hoorde. | tevreden | [Pull Request](https://github.com/AIM-ENE-feb25/castlevania/pull/162) |
| 2 | Iteratie review | Het team en opdrachtgever | Presentatie gegeven over de resultaten van de vorige iteratie met focus op de technische implementaties. Waardevolle feedback ontvangen over quality attributes. hierbij heeft iedereen verteld over zijn spike waarbij alles goed verliep op 1 klein ding na waar de prototype van Lucas van iteratie 1 een kleine bug had. Ik zelf heb ook verteld over mijn spike waar ik had gekeken naar wat er gebeurd bij uitval van keycloak en wat voor een oplossingen er zijn | tevreden | |
| 1,5 | Iteratie planning | Sander en het team | Grondige evaluatie van iteratie 2 uitgevoerd en planning gemaakt voor iteratie 3. De planning verliep efficiënt doordat we de spikes goed konden koppelen aan eerder onderzoek. Het team had een duidelijk beeld van de onderlinge afhankelijkheden tussen de verschillende onderzoeken. Ik heb er zelf voor gekozen om mijn spike verder te bouwen op mijn functionele spike over keycloak uitval aangezien een offline systeem niet de bedoeling is. | tevreden | [Issue](https://github.com/AIM-ENE-feb25/castlevania/issues/166) |
| 1 | Logboek en reflectie verbetering | Alleen | Stuk van mijn logboek geschreven en gekeken naar wat er nog mist in mijn reflectieverslag. hier aantekeningen voor gemaakt in Obsidian(markdown editor) zodat ik woensdag vragen kan stellen tijdens de meeting met Tineke Jacobs. Ook opzet gemaakt voor de kopjes die nog ontbreekte om te zorgen dat ik dit als guideline kon gebruiken voor het gesprek en of ik in de goeie richting dacht. | tevreden |  |
| 1,5 | Start Docker setup | Alleen | Begonnen met het opzetten van de Docker-infrastructuur voor het prototype. Basis Docker configuratie opgezet en eerste tests uitgevoerd van de prototype omgeving. De initiële setup verliep soepel door goede voorbereiding en duidelijke documentatie in combinatie met dat ik dit vaker heb gedaan. | tevreden | [Issue](https://github.com/orgs/AIM-ENE-feb25/projects/6/views/4?pane=issue&itemId=112521224&issue=AIM-ENE-feb25%7Ccastlevania%7C178) |

## Dinsdag 27 mei

> Optionele opmerking.

| Tijd | Naam van de taak | Met Wie | Resultaat | Emoji | Link |
|:-----|-----------------|----------|-----------|--------|------|
| 2,5 | Docker basis setup | Alleen | Uitgebreide Docker-infrastructuur opgezet met alle benodigde basis configuraties voor het prototype. Dockerfile en docker-compose bestanden gecreëerd met optimale instellingen voor de prototype omgeving. De configuratie verliep vlot door eerdere ervaring met Docker en duidelijke documentatie | tevreden | [Issue](https://github.com/orgs/AIM-ENE-feb25/projects/6/views/4?pane=issue&itemId=112521224&issue=AIM-ENE-feb25%7Ccastlevania%7C178), [Commit](https://github.com/AIM-ENE-feb25/castlevania/commit/d556afa0267dcd2b75223fe3a34097803a05a927) |
| 3 | Keycloak Instance 1 setup | Alleen | Eerste Keycloak instance succesvol opgezet in Docker. Configuratie van security settings, basis healthcheck met een basis admin en test gebruikers. dit verliep goed door de goeie documentatie vanuit keycloak in combinatie met de onderzoeken die we vooraf hebben gedaan waar ik extra informatie kon vinden over keycloak opzetten.  | tevreden |[Issue](https://github.com/orgs/AIM-ENE-feb25/projects/6/views/4?pane=issue&itemId=112521244&issue=AIM-ENE-feb25%7Ccastlevania%7C179), [Commit](https://github.com/AIM-ENE-feb25/castlevania/commit/d556afa0267dcd2b75223fe3a34097803a05a927) |
| 2,5 | Keycloak Instance 2 setup | Alleen | Tweede Keycloak instance opgezet en geconfigureerd met identieke instellingen voor het prototype. Bridge networking tussen instances succesvol geïmplementeerd. Extra aandacht besteed aan synchronisatie-instellingen tussen de instances voor de test omgeving. Dit was heel snel een copy paste werkje behalve dat ik moest zorgen dat de bridge goed werkte waarbij beide keycloak instancies dezelfde gegevens/gebruikers hebben dit koste mij minder tijd dan ik in eerste instantie had verwacht doordat er uitgebreide informatie online staat over keycloak en bridges. | tevreden | [Issue](https://github.com/orgs/AIM-ENE-feb25/projects/6/views/4?pane=issue&itemId=112521280&issue=AIM-ENE-feb25%7Ccastlevania%7C180), [Commit](https://github.com/AIM-ENE-feb25/castlevania/commit/d556afa0267dcd2b75223fe3a34097803a05a927) |

## Woensdag 28 mei

> Optionele opmerking.

| Tijd | Naam van de taak | Met Wie | Resultaat | Emoji | Link |
|:-----|-----------------|----------|-----------|--------|------|
| 5 | Shared Database Setup | Alleen | Implementatie van een gedeelde database voor beide Keycloak instances in het prototype. De setup was technisch uitdagend omdat de gewenste NoSQL oplossingen (MongoDB/CouchDB) niet compatibel bleken met Keycloak's architectuur vanwege transactie-management vereisten en schema-afhankelijkheden. Moest terugvallen op PostgreSQL wat wel werkt. Ik had liever geprobeerd om met MongoDb of CouchDb te werken in verband met lessen tijdens TeeX over de desbetreffende noSQL databases. | neutraal | [Issue](https://github.com/orgs/AIM-ENE-feb25/projects/6/views/4?pane=issue&itemId=113430727&issue=AIM-ENE-feb25%7Ccastlevania%7C206), [Commit](https://github.com/AIM-ENE-feb25/castlevania/commit/0032b373ce303d930ab859275ce6f977cf75663a) |
| 1,5 | HaProxy Research | Alleen | Onderzoek uitgevoerd naar HaProxy load balancing algoritmes en configuratie-opties voor het prototype. Specifiek gekeken naar round-robin, least-connection en IP-hash methodes voor onze prototype use-case. Documentatie opgesteld over de voor- en nadelen van elke methode in relatie tot Keycloak failover scenarios in de test omgeving. | tevreden | [Issue](https://github.com/orgs/AIM-ENE-feb25/projects/6/views/4?pane=issue&itemId=112521292&issue=AIM-ENE-feb25%7Ccastlevania%7C181) |
| 1,5 | Retrospectief meeting | Sander en het team | Gekeken naar hoe wij als team de vorige sprint hebben ervaren. Belangrijke verbeterpunten geïdentificeerd in de samenwerking binnen het team, vooral op gebied van communicatie en taakcoördinatie. Concrete actiepunten opgesteld voor de komende weken om de teamdynamiek te verbeteren. Team is uit zichzelf nog wat meer gesloten maar er was veel progressie in zeggen wat iedereen overal van vond. Dit hielp met zorgen voor een goede retrospective waar we bruikbare verbeterpunten uit hebben kunnen halen met als voorbeeld voor aan het einde van de dag zorgen dat we elkaars werk even bekijken. | tevreden | [Link](https://miro.com/welcomeonboard/OElXdWlzVmYvT1Q1K1FQazlqYStaVVZsbEVDd0NjN0JDUEZhSzRGVDNGQVg4VFJZaUJ0VEgxdHJzQ0VheDAzUHV6NGcwTlcrTEUzazJocXdLWVhnSjRZQjNoa0ZvZjFqUW5tdWoxWWQzU3hIcVZKOU0wa3NaZ2FBaFVsZkNtRU50R2lncW1vRmFBVnlLcVJzTmdFdlNRPT0hdjE=?share_link_id=21042429648) |
| 1 | Gesprek Tineke | Tineke en het team | Gedetailleerde feedback ontvangen over de kwaliteit en structuur van onze reflectieverslagen en logboeken. Hier hebben we allemaal vragen kunnen stellen over onzekerheden die we hadden bij onze reflectieverslagen. Vooral uitleg gekregen over het bob model en hoe we komen tot een besluit en waar allemaal besluiten liggen die nuttig zijn. Tussentijdse cijfers besproken die een goed beeld gaven van onze huidige prestaties en verbeterpunten. Het gesprek gaf duidelijke richting voor het verbeteren voor het team zijn samenwerken en individuele progressie. | tevreden | |

## Donderdag 29 mei

> Vrij

## Vrijdag 30 mei

> Vrij
