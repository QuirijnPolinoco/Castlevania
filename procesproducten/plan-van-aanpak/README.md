# 1. Inleiding

Dit document is een plan van aanpak die beschrijft de aanpak van het ontwikkelen van een rollenbeheer applicatie voor  
BOLD Digital. Het doel van dit PvA is om een overzicht te geven van de aanpak, de planning en de deliverables van het  
project. Dit document is bedoeld voor het team dat aan het project werkt, maar ook voor de opdrachtgever en andere  
belanghebbenden.

### Het Plan van aanpak is als volgt opgebouwd:

- [Inleiding](01-inleiding.md)
- [Achtergrond-project](02-achtergrond-project.md)
- [doel-opdracht-resultaten](03-doel-opdracht-resultaten.md)
- [Projectgrenzen](04-projectgrenzen.md)
- [Randvoorwaarden](05-randvoorwaarden.md)
- [Producten-kwaliteitseisen](06-producten-kwaliteitseisen.md)
- [Ontwikkelmethoden](07-ontwikkelmethoden.md)
- [Projectorganisatie-communicatie](08-projectorganisatie-communicatie.md)
- [Planning](09-planning.md)
- [Risico's](10-risicos.md)

Dit plan van aanpak vormt een stevige basis voor de succesvolle realisatie van het project.

# 2. Achtergrond project

## 2.1 Beschrijving Bold digital

BOLD Digital is een softwarebedrijf dat zich richt op het optimaliseren en automatiseren van complexe
bedrijfsprocessen.  
Ze ontwikkelen gebruiksvriendelijke webapplicaties en apps op maat, met een focus op strategisch advies en snelle  
realisatie.  
Dankzij hun eigen backoffice kunnen ze binnen 24 uur een werkend fundament van een applicatie presenteren.  
Het bedrijf heeft meer dan 25 jaar ervaring en heeft meer dan 450 projecten succesvol afgerond.

## 2.2 Initieel Gegeven opdracht

Medewerkers hebben toegang tot verschillende applicaties. Dit is afhankelijk van hun functie. Wanneer een medewerker
in  
of uit dienst treedt of wanneer de functie verandert, betekent dit dat de gebruiker in alle applicaties aangepast moet  
worden.  
Het gaat om de volgende applicaties: Keycloak, Google (Drive, Calendar, etc.), Nexus, Jenkins, Gitea en Atlassian (  
Confluence, Jira).

## 2.3 Stakeholders

### 2.3.1 Jurri van Loenen - opdrachtgever

De opdrachtgever heeft belang bij een opgeleverd product op basis van de door hun aangeleverde opdracht. Daarnaast is  
het belangrijk dat het product tijdig wordt opgeleverd, zodat de investering in tijd en middelen gerechtvaardigd is.

### 2.3.2 Castlevania - projectteam

Voor het projectteam is het behalen van het project cruciaal om de studiepunten voor deze course te behalen en hun  
studievoortgang te waarborgen. Daarnaast biedt het project waardevolle praktijkervaring en een kans om de theoretische  
kennis in de praktijk te brengen. Mislukking heeft directe gevolgen voor hun opleiding en de beoordeling van hun  
competenties.

### 2.3.3 Developer team - development

Voor de developers is het van belang dat het projectteam goede documentatie opleveren om een goed kwalitatief product
te  
leveren aan de eindgebruikers.

## 2.4 Organisatiestructuur

Hier is een inzicht van het structuur van de organisatie van BOLD Digital. Dit is een vereenvoudigde weergave van de  
organisatiestructuur, maar geeft een goed beeld van de verschillende afdelingen en hun verantwoordelijkheden.

Jarno Eggink - CEO BOLD Digital: Voor vragen over de organisatie en de opdracht kan je bij Jarno terecht. Hij is de
CEO  
van BOLD Digital en heeft een goed overzicht van de organisatie en haar processen.

Jurri van Loenen - Opdracht gever: Voor vragen over de opdracht kan je bij Jurri terecht. Hij is de opdrachtgever en  
heeft uitsluitende keuze over de opdracht en de producten die geleverd moeten worden.

## 2.5 Aanleiding

Het huidige gebruikersbeheerproces bij BOLD Digital is versnipperd en tijdrovend. Elke keer wanneer een medewerker in-  
of uit dienst treedt of van functie verandert, moeten de toegangsrechten handmatig in zes verschillende systemen
worden  
aangepast. Dit leidt tot:

- Onnodige administratieve overhead
- Verhoogd risico op menselijke fouten
- Potentiële beveiligingslekken door verouderde toegangsrechten
- Vertraging in het onboarding- en offboardingproces van medewerkers

Deze inefficiëntie heeft geleid tot de wens om het gebruikersbeheer te centraliseren en te automatiseren. Hoewel het  
project niet als urgent wordt beschouwd, biedt het een belangrijke kans om de operationele efficiëntie te verbeteren
en  
de beveiliging te versterken.

# 3. Probleem/uitdaging die Bold digital heeft

Het "Probleem" bij Bold digital is dat ze een beter overzicht willen hebben van  
medewerkers rechten en dit makkelijker willen kunnen aanpassen wanneer iemand bijvoorbeeld ontslagen wordt.

## 3.1 Doelstelling

Het bedrijf wil het gebruikersbeheer centraliseren en automatiseren,  
zodat gebruikersrechten consistent en efficiënt worden toegekend op basis van de rol of functie van de medewerker.  
En daarmee de kans op fouten en misbruik van rechten te minimaliseren.

## 3.2 Opdracht

De opdracht is om onderzoek te doen naar welke methode het meest geschikt is voor het beheren van gebruikers over  
meerdere applicaties.  
Dit doen wij door verschillende benaderingen te analyseren en te toetsen via prototyping en de ADR-methodiek.  
Op basis van deze inzichten realiseren wij een Walking Skeleton: een werkend, minimalistisch prototype dat de kern van  
een geautomatiseerd gebruikersbeheerproces laat zien.

## 3.3 Resultaten

Het eindresultaat hiervan is een technisch werkende Walking Skeleton die gebruikersbeheer over meerdere systemen  
integreert of automatiseert.  
Daarnaast leveren wij documentatie en een Software guidebook op over de gekozen methode en onderbouwing op basis van
de  
prototypes en het onderzoek.

# 4. Projectgrenzen

## 4.1 Projectduur

Het project loopt van 14 april 2025 tot en met 13 juni 2025. Hier zijn wij aanwezig op locatie HAN R26 vanaf 9:00 tot  
16:15.

### 4.1.1 Vakantiedagen

Tijdens de vrije dagen zullen er geen werkzaamheden worden verricht. deze dagen zijn:

- 18-4-2025
- 21-4-2025
- 26-4 t/m 5-5-2025
- 29-5 en 30-5-2025
- 9-6-2025

### 4.1.2 Afspraken & gezondheid

De balans tussen werk en privé wordt gerespecteerd: belangrijke persoonlijke afspraken (medische afspraken en andere  
verplichtingen) hebben voorrang op werkverplichtingen.

## 4.4 Wat valt buiten de scope:

- Implementatie in productieomgevingen
- Beheer en onderhoud van de uiteindelijke oplossing
- Aanpassingen aan bestaande systemen
- Migratie van bestaande data
- Ondersteuning van eindgebruikers
- Training van beheerders
- Ontwikkeling van een volledig productieklare applicatie

## 4.5 Technische context

**De oplossing moet uitsluitend rekening houden met de volgende bestaande systemen:**

- Keycloak (identiteitsbeheer) **versie:26.2.0**
- Google Suite (Drive, Calendar, etc.) **versie:Er is geen actuele versie te vinden van deze applicatie.**
- Nexus (artefactenbeheer) **versie:3.79.1**
- Jenkins (CI/CD) **versie:2.492.3**
- Gitea (versiebeheer) **versie:1.23.7**
- Atlassian Suite (Confluence, Jira) **versie:8.0**

**Voor de ontwikkeling van prototypes gebruiken we:**

- Spring Boot (backend) **versie:3.4.4**
- Vue3 (frontend) **versie:3.5.13**

# 5. Randvoorwaarden

In dit project zijn er geen randvoorwaarden, het team heeft niks nodig van externe partijen om het project uit te  
voeren.

# 6. Op te leveren producten, kwaliteitseisen en uit te voeren activiteiten

| **Deelproduct**           | **Productkwaliteitseisen (SMART + inhoudelijk + met bronnen)**                                                                                                                                                                                                                                                                                                                                                                                                     | **Benodigde activiteiten om te komen tot het product**                                                                                                                                                                                                                                                                                                                                                                                                                                                                         | **Proceskwaliteit (5xW + 1xH)**                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           |
|---------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Plan van Aanpak (PvA)** | - Goedgekeurd door begeleiders voor start van 1e iteratie.<br> - Voldoet aan [AIM PvA 4.0](https://aim-cnp.github.io/pwac/assets/files/Toelichting_op_PvA_4.0-c06038e25669cca4f595c2c14aecde24.pdf).                                                                                                                                                                                                                                                               | - PvA wordt opgesplitst per hoofdstuk om zo kleinere taken te kunnen opdelen binnen het team.<br> - 24 uur na assessment om PvA aan te passen/bij te werken.<br> - Onderzoek proces [BOLD Digital](https://www.wearebold.digital/?gad_source=1&gbraid=0AAAAADcUYWmxPfeP2uChHD_HSZLDkdx4F&gclid=CjwKCAjwwqfABhBcEiwAZJjC3o1l4UxUFlygRl1NBsdKHpPynPl3YVqmgGThlPbjufU4L2vaYj5dnBoCqr8QAvD_BwE)<br> - Onderzoek casus [Rollenbeheer](https://github.com/AIM-ENE-feb25/castlevania/blob/main/Bold%20Digital%20-%20Rollenbeheer.pdf) | - PvA wordt gecontroleerd door Tineke Jacobs en Sander Leer tijdens PvA assessment.  <br>  <br>- Nadat een issue op Review wordt gezet betreft het PvA zal minimaal 1 andere teamgenoot dit reviewen binnen 24 uur na het gemaakte werk. Op basis van de review wordt de issue op done (hoofdstuk is afgerond) gezet of op in-progress (hoofdstuk heeft aanpassingen nodig voor 2de review). <br>  <br>- PvA is beschikbaar in de [GitHub Repo](https://github.com/AIM-ENE-feb25/castlevania/blob/main/procesproducten/plan-van-aanpak/README.md).        |
| **Software Guidebook**    | - Bevat context-, container- , component- , dynamische component- en klassendiagram volgens het [C4-model](https://c4model.com/).<br> - Alle ADR’s zijn geschreven in [ADR-formaat](https://adr.github.io/), met onderbouwing vanuit [SoEx](https://aim-ene.github.io/soex/week-1/les-4/Voorbereiding).<br><br> - Alle domain story telling diagrammen moet voldoen aan de eisen van [DoEx](https://aim-ene.github.io/doex/week-1/les-2/Lesprogramma/Criteria)<br> | - Spikes uitvoeren.<br> - Diagrammen maken (context, container, etc).<br> - ADR’s schrijven.<br> - Reviews verwerken.<br> - Gesprekken voeren met domain expert.                                                                                                                                                                                                                                                                                                                                                               | Elke iteratie werkt ieder teamlid een spike uit en verwerkt deze via een pull request in het Software Guidebook. Binnen 48 uur wordt elk PR gereviewd door een ander teamlid. De documentatieverantwoordelijke checkt consistentie met ADR en C4-richtlijnen. De finalisatie van het Software Guidebook gebeurt in de post-game, met eindbeoordeling door docent en akkoord opdrachtgever.<br><br>- Software guidebook is beschikbaar in de [GitHub Repo](https://github.com/AIM-ENE-feb25/castlevania/blob/main/producten/software-guidebook/README.md). |
| **Walking Skeleton**      | - Bevat minimaal twee werkende prototypes voor authenticatie, en autorisatie.                                                                                                                                                                                                                                                                                                                                                                                      | - Code schrijven met gebruik van Java springboot en VueJS3.<br> - Spikes uitvoeren.<br> - Prototypes bouwen.                                                                                                                                                                                                                                                                                                                                                                                                                   | Gedurende het project werkt het team aan de walking skeleton met gebruik van spikes om risico's af te dekken. Deze spikes worden gecontrolleerd door middel van PR en minimaal door een teamgenoot gecontrolleerd voordat die naar main wordt doorgewezen.<br><br>- Walking skeleton is beschikbaar in de [GitHub Repo](https://github.com/AIM-ENE-feb25/castlevania/blob/main/producten/walking-skeleton/README.md).                                                                                                                                     |

# 7. Ontwikkelmethoden

Tijdens dit project gaat het team gebruik maken van Spikes. Spikes zijn een techniek die wordt gebruikt in Agile  
softwareontwikkeling om onzekerheden of risico's te verkennen en te verminderen.  
Het idee is om een korte, tijdgebonden inspanning te leveren om een specifiek probleem of vraagstuk te onderzoeken,  
zodat het team beter geïnformeerd is over hoe verder te gaan met de ontwikkeling. <br> Spikes kunnen worden gebruikt
om  
technische haalbaarheid te beoordelen, nieuwe technologieën uit te proberen, of om meer inzicht te krijgen in de  
vereisten van een project.<br>  
Spikes zitten in zogenaamde Iteraties. Een iteratie is een korte periode waarin een team werkt aan een specifiek doel
of  
resultaat. Het idee is om in korte, herhalende cycli te werken, zodat het team snel kan inspelen op veranderingen en  
feedback kan verwerken. Iteraties zijn een belangrijk onderdeel van Agile softwareontwikkeling en helpen teams om  
flexibel en responsief te blijven. In dit project duren de Iteratie maximaal 2 weken.

## 7.1 Spikes

Een spike bevat de volgende 3 onderdelen:

- **Onderzoeksvraag of onderzoeksdoel**  Dit is de vraag of het doel dat je wilt onderzoeken. Het moet specifiek en  
  meetbaar zijn, zodat je kunt bepalen of je het doel hebt bereikt. Bijvoorbeeld: "Hoe kunnen we de laadtijd van onze  
  website verbeteren?" of "Wat zijn de belangrijkste functies die onze gebruikers nodig hebben?"
- **Type onzekerheid die je wilt onderzoeken** Er zijn 3 verschillende soorten onzekerheden:
    - **Technisch**: Dit betreft onzekerheden over de technische haalbaarheid van een oplossing. Bijvoorbeeld: "Is het  
      mogelijk om deze technologie te gebruiken voor ons project?"
    - **Functioneel**: Dit betreft onzekerheden over de functionele vereisten van een oplossing. Bijvoorbeeld: "Wat
      zijn  
      de belangrijkste functies die onze gebruikers nodig hebben?"
    - **Organisatorisch**: Dit betreft onzekerheden over de organisatorische aspecten van een oplossing.
      Bijvoorbeeld: "  
      Hoe kunnen we deze oplossing het beste implementeren binnen onze organisatie?"
- **Timebox** Dit is de tijd die je aan de spike wilt besteden. Het is belangrijk dat jouw onderzoek niet uit de hand  
  loopt, dus stel een duidelijke tijdslimiet in. Bijvoorbeeld: "We besteden maximaal 2 dagen aan deze spike."

## 7.2 Iteraties

Een iteratie bevat een of meerdere spikes. Spikes worden verdeeld over de groepsleden van het project, waarbij elk lid  
verantwoordelijk is voor het uitvoeren en documenteren van de toegewezen spike.  
Tijdens een iteratie wordt er regelmatig geëvalueerd om de voortgang te bewaken en eventuele obstakels te  
identificeren.    
Aan het einde van een iteratie wordt een retrospectieve gehouden om te reflecteren op wat goed ging, wat beter kan, en  
welke lessen geleerd zijn.  
De resultaten van de spikes worden gebruikt om beslissingen te nemen over de volgende stappen in het project.
Iteraties  
zorgen ervoor dat het team flexibel blijft en snel kan inspelen op veranderingen of nieuwe inzichten.  
Aan het einde van elke iteratie hebben we een walking skeleton, dat is een werkend prototype dat de belangrijkste  
functionaliteit van het systeem demonstreert. Dit prototype wordt gebruikt om feedback te verzamelen van de  
opdrachtgever.

## 7.3 GitHub

Voor het bijhouden van de voortgang in het project maakt het team gebruik van GitHub.  
Hierin werkte iedereen gezamenlijk en wordt gebruikt gemaakt van branches. Deze branches bevatten elk uitsluitend de  
uitvoering van een taak.  
Zo blijven de branches klein en voorkomen we grote hoeveelheden merge-conflicten.

Daarnaast maakt het team gebruik van het planbord van GitHub. Hierin worden de uren van de taken verdeeld en  
bijgehouden. Zo kan je zien waar iedereen mee bezig is en wat er nog gedaan moet worden.

## 7.4 Projectfasen

Het project is opgedeeld in verschillende fasen:

### 7.4.1 Pre-game fase

In deze fase leggen we de basis voor het project door:

- Het opstellen van een duidelijk projectplan
- Het identificeren van belangrijke stakeholders
- Het definiëren van de belangrijkste uitdagingen

### 7.4.2 Elaboratiefase (3 iteraties)

Tijdens deze fase werken we in drie iteraties van 2 werkweken op uitzondering van vrije dagen aan het oplossen van  
verschillende soorten onzekerheden:

### 7.4.3 Post-game fase

In deze fase ronden we het project af door:

- Het samenstellen van het definitieve software guidebook
- Het presenteren van de resultaten
- Het overdragen van kennis

# 8. Projectorganisatie en communicatie

## 8.1 Contactinformatie

| Naam                   | Rol               | E-mailadres                       | Telefoonnummer |  
|------------------------|-------------------|-----------------------------------|----------------|  
| Jurri van Loenen       | Opdrachtgever     | <j.vanloenen@wearebold.digital>   | 085-00 473 57  |  
| Jarno Eggink           | Domeinexpert      | <j.eggink@wearebold.digital>      | 085-00 473 57  |  
| Sander Leer            | Projectbegeleider | <sander.leer@han.nl>              | +31 2636 58237 |  
| Tineke Jacobs          | Skills-docent     | <tineke.jacobs@han.nl>            | +31 6 55206329 |  
| Rens de Vreede         | Groepslid         | <RJ.deVreede@student.han.nl>      | -              |  
| Yousif Rihmani         | Groepslid         | <YBG.Rihmani@student.han.nl>      | -              |  
| Quirijn van der Zanden | Groepslid         | <QRT.vanderZanden@student.han.nl> | -              |  
| Emil Garibov           | Groepslid         | <E.Garibov@student.han.nl>        | -              |  
| Lucas Weijs            | Groepslid         | <L.Weijs@student.han.nl>          | -              |  

## 8.2 Contactfrequentie

| Naam             | Frequentie                                                                                       | Onderwerp                                                        |  
|------------------|--------------------------------------------------------------------------------------------------|------------------------------------------------------------------|  
| Jurri van Loenen | Afhankelijk van het aantal vragen van onze kant, minstens één maal per iteratie (de presentatie) | Inhoudelijke vragen over de casus                                |  
| Jarno Eggink     | Afhankelijk van de duidelijkheid van het domein, minstens één maal gedurende het project         | Inhoudelijke vragen over het domein                              |  
| Sander Leer      | Minstens één maal per week, eventueel een extra keer indien nodig                                | Inhoudelijke vragen over de opdracht en de procedure             |  
| Tineke Jacobs    | Één maal per week                                                                                | Begeleiding m.b.t. ieders reflectieverslagen en het groepsproces |  

## 8.3 Rollen

| Naam                   | Rol                    | Verantwoordelijkheid                              | Taken                                                                                                                                                                                                                                                                                                                                                                                                                                                                   |  
|------------------------|------------------------|---------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|  
| Rens de Vreede         | Voortgangsbewaker      | Overzicht/planning                                | Houdt de voortgang nauwlettend in de gaten en wijst het team op eventuele achterstanden. Draagt actief bij aan het vaststellen van tijdsinschattingen en controleert of deze nagestreefd worden.                                                                                                                                                                                                                                                                        |  
| Yousif Rihmani         | Requirements Engineer  | Externe contacten (Opdrachtgever en stakeholders) | - Zorgt voor duidelijke communicatie met opdrachtgever. <br> - Zorgt dat de DST-gesprekken kwalitatief zijn. <br> - Goed kunnen uitleggen van technische zaken aan niet technische mensen. <br> - Gesprekken voeren met opdrachtgever. <br> - User story's maken en veranderen O.B.V feedback. <br> - Dringende vragen vanuit het team communiceren met product owner/opdrachtgever. <br> - Domain story's maken en bespreken met stakeholders.                         |  
| Quirijn van der Zanden | Kwaliteitscoördinator  | Teamfunctioneren                                  | Zorgt voor kwaliteitsborging van projectproducten en structurering van het interne werkproces. Reviewt producten intern aan de hand van KOET, zorgt dat er resultaten worden vast gelegd. Onderbouwt adviezen met sterke argumenten en bewaakt juiste productoplevering aan opdrachtgever. Definieert projectgrenzen en randvoorwaarden voor helder werkproces.                                                                                                         |  
| Emil Garibov           | Documentatiebeheerder  | Documentatie                                      | - Houdt alle projectdocumentatie actueel en overzichtelijk. <br> - Zorgt voor duidelijke structuur en vindbaarheid van documenten binnen het project (zoals Notion, Confluence of repo's). <br> - Legt technische en functionele informatie vast op een begrijpelijke manier. <br> - Werkt samen met teamleden om documentatie volledig en correct te houden. <br> - Zorgt dat toekomstige ontwikkelaars of stakeholders de documentatie kunnen begrijpen en gebruiken. |  
| Lucas Weijs            | Implementation Manager | Integratie                                        | Zorgt ervoor dat alle technische processen binnen het project soepel lopen. Denk hierbij aan een CI/CD pipeline, voldoende en zinnige tests en overal kwaliteit ophouden. Ook zorgt ervoor dat de uitwerkingen op tijd afkomen.                                                                                                                                                                                                                                         |  

## 8.4 Bijeenkomsten

| Bijeenkomst    | Moment                                                           | Aanwezigen                                       | Doel                                                                                                                                     |  
|----------------|------------------------------------------------------------------|--------------------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------|  
| Retrospective  | Een van de eerste dagen na een iteratie, bij voorkeur de dinsdag | De projectgroep en de projectbegeleider (Sander) | Terugblikken op vorige iteratie: wat ging er goed, wat niet en wat kunnen we daar aan doen?                                              |  
| Presentatie    | Een van de eerste dagen na een iteratie, bij voorkeur de maandag | De projectgroep en de opdrachtgever (Jurri)      | De opdrachtgever laten zien wat we gemaakt hebben en daarop feedback ontvangen                                                           |  
| Daily stand-up | Begin van elke werkdag                                           | De projectgroep                                  | Duidelijk maken waar iedereen binnen mee bezig is geweest, de progressie daarin, eventuele belemmeringen en waar iedereen mee bezig gaat |  

# 9. Planning

## 9.1 Algemene planning

De onderstaande tabel geeft een overzicht van welke week wanneer begint en wat het projectteam zich mee bezig zal  
houden. Deze tabel houdt wel rekening met vrije weken, maar geen rekening met losse vrije dagen.

| Weeknummer | Week van | Bezigheid               |  
|------------|----------|-------------------------|  
| 1          | 14 april | Project startup (PSU)   |  
| 2          | 21 april | Iteratie 1              |  
| 3          | 5 mei    | Iteratie 1              |  
| 4          | 12 mei   | Iteratie 2              |  
| 5          | 19 mei   | Iteratie 2              |  
| 6          | 26 mei   | Iteratie 3              |  
| 7          | 2 juni   | Iteratie 3              |  
| 8          | 9 juni   | Transitie en oplevering |  
| 9          | 16 juni  | Beoordelingsmoment      |  

## 9.2 Projectmijlpalen en oplevermomenten

De onderstaande tabel geeft een overzicht van de belangrijkste mijlpalen en opleveringen binnen het project, inclusief  
de bijbehorende deadlines en status. De datums zijn afgestemd op de project startup van maandag 14 april 2025.

| Mijlpaal/Oplevering                  | Geplande datum         | Beschrijving                                                                            | Status      |  
|--------------------------------------|------------------------|-----------------------------------------------------------------------------------------|-------------|  
| Planbord en platforms ingericht      | Maandag 21 april 17:30 | Planbord ingericht, eerste spikes gedefinieerd, platforms voor USM en guidebook gekozen | In progress |  
| Plan van Aanpak opgeleverd           | Dinsdag 22 april 22:00 | Plan van Aanpak gereed, geplaatst op GitHub en ingeleverd op iSAS                       | In progress |  
| TT werk gereed op GitHub             | Vrijdag 23 mei 22:00   | TT werk (groep en individueel) gereed voor beoordeling op GitHub                        | In progress |  
| Alle producten gereed op GitHub/iSAS | Vrijdag 13 juni 22:00  | Alle producten gereed voor beoordeling op GitHub en export van de repository in iSAS    | In progress |  

## 9.3 Belangrijke afspraken

De onderstaande tabel geeft een overzicht van de belangrijke afspraken binnen het project, inclusief de bijbehorende  
data en betrokkenen. De onderstaande data worden aangepast zodra de afspraken ingepland zijn.

| Datum       | Tijd | Onderwerp                | Betrokkenen                |  
|-------------|------|--------------------------|----------------------------|  
| Eind week 3 | x    | Eerste presentatie       | Projectteam, Opdrachtgever |  
| Eind week 5 | x    | Tweede presentatie       | Projectteam, Opdrachtgever |  
| Eind week 7 | x    | Derde presentatie        | Projectteam, Opdrachtgever |  
| Eind week 8 | x    | Opleveringspresentatie   | Projectteam, Opdrachtgever |  
| Week 9      | x    | Eindpresentatie (30 min) | Projectteam, Beoordelaars  |  

[Source van bovenstaande van data](https://aim-ene.github.io/pexe/docs/Tijdlijn)

## 9.4 Planning voor iteratie 1

Doel: opbouwen van basiskennis en eerste technische verkenning.

| Type        | Titel                                         | Beschrijving                                                              | Timebox |  
|-------------|-----------------------------------------------|---------------------------------------------------------------------------|---------|  
| Kennis      | Security features in Keycloak                 | MFA, policies en "least privilege" configureren                           | 32 uur  |  
| Functioneel | Minimale rollen & rechten definiëren          | Uitwerken van basale gebruikersrollen en bijbehorende rechten             | 32 uur  |  
| Kennis      | RBAC model vs projecteisen                    | Analyse van hoe RBAC in Keycloak aansluit bij de eisen van de casus       | 40 uur  |  
| Technisch   | Gebruikersdata migreren uit losse applicaties | Methodes verkennen + PoC/script maken voor migratie uit Gitea, Jira, etc. | 44 uur  |  
| Kennis      | SCIM / API synchronisatie                     | Onderzoek SCIM of custom API-sync tussen Keycloak en andere tools         | 40 uur  |  

## 9.5 Planning voor iteratie 2

Doel: Verdiepen in authenticatiestromen, integratiemogelijkheden en functionele randvoorwaarden voor een
toekomstbestendige Keycloak-implementatie.

| Type        | Titel                                             | Beschrijving                                                                                                                                                                                                                | Timebox |  
|-------------|---------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|---------|  
| Kennis      | Keycloak integratie met CI/CD pipeline            | Onderzoek hoe Keycloak Geïntegreerd kan worden met de CI/CD pipeline                                                                                                                                                        | 32 uur  |  
| Technisch   | Prototype maken voor SCIM / API synchronisatie    | prototype ontwikkelen voor SCIM of custom API-sync tussen Keycloak en andere tools                                                                                                                                          | 44 uur  |  
| Kennis      | Configuratie in Keycloak en Custom IAM applicatie | Hoe zorg je ervoor dat er goede configuratie stappen genomen zijn? <br> Wat zijn de stappen die genomen moeten worden voor een goede configuratie?                                                                          | 36 uur  |  
| Functioneel | Verificatie- en aanmeldstromen vergelijken        | Vergelijken van verschillende standaard login/verificatieflows (Bijv. met en zonder MFA, social login) en hun implicaties voor gebruikerservaring en veiligheid                                                             | 40 uur  |  
| Functioneel | Functionele impact en eisen bij Keycloak-uitval   | Onderzoeken wat de functionele gevolgen zijn voor eindgebruikers en applicaties als Keycloak tijdelijk niet beschikbaar is. Wat zijn de minimale eisen aan beschikbaarheid, fallback-functionaliteit en gebruikerservaring? | 40 uur  |  

## 9.6 Planning voor iteratie 3

Doel: technische implementatie en integratie van gekozen oplossing.

| Type        | Titel                                          | Beschrijving                                                           | Timebox |  
|-------------|------------------------------------------------|------------------------------------------------------------------------|---------|  
| Technisch   | Keycloak uitval fallback systeem prototype | Prototype van een redundant Keycloak systeem met load balancing en fallback mechanismen. Het prototype demonstreert hoe het systeem blijft functioneren bij Keycloak uitval  | 40 uur  |  
| Technisch   | SSO integratie met Keycloak                    | Proof-of-concept met SSO tussen Keycloak en bijv. Gitea of Jenkins     | 44 uur  |  
| Technisch   | OAuth2 integratie met Spring Boot              | Spring Boot koppelen aan Keycloak via OAuth2                           | 44 uur  |  
| Functioneel | Logging en auditing met Keycloak               | Onderzoek toegangsinzichten, audit logs en compliance opties           | 32 uur  |  
| Functioneel | Eindgebruikersvriendelijkheid beheeroplossing  | Beoordeling beheerportal op eenvoud + gebruiksgemak (voor niet-IT'ers) | 32 uur  |  

# 10. Risico's

In dit hoofdstuk bekijken we welke zaken het project kunnen vertragen of zorgen voor minder functionaliteit bij  
oplevering. Het gaat hierbij alleen om risico’s die buiten onze directe invloed liggen.

Per risico geven we aan hoe groot de kans is dat het gebeurt, wat de impact zou zijn, en wat we kunnen doen om het  
risico te verkleinen (de tegenmaatregel). Ook beschrijven we wat er gedaan kan worden als het risico toch optreedt (de  
uitwijkstrategie).

*De onderstaande tabel geeft een overzicht van deze risico’s.*

| Risico                                                                                                   | Kans   | Impact | Tegenmaatregel                                                                                                                                                                                                                                                    | Uitwijkstrategie                                                                                                     |  
|----------------------------------------------------------------------------------------------------------|--------|--------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------|  
| Documentatie van huidige gebruikte applicaties (bijv. Keycloak, Jenkins) blijkt verouderd of incompleet. | Middel | Middel | Ruim op tijd checken of de documentatie volledig en compleet is.                                                                                                                                                                                                  | Contact opnemen met opdrachtgever en vragen of hij (of iemand die hij kent) ons op weg kan helpen met de applicatie. |  
| Onverwachte en verlengde afwezigheid van meerdere teamgenoten.                                           | Middel | Laag   | Taken zo klein mogelijk houden, zodat bij uitval van een teamgenoot een ander de task kan oppakken zonder al te veel tijdverspilling. Ook voldoende status updates binnen het team door middel van DSU's, waardoor de kennis verdeeld is over alle groepsgenoten. | Contact opnemen met opdrachtgever om te bespreken wat wel- en wat niet meer mogelijk is.                             |  
| Een van de huidig gebruikte applicaties (bijv. Keycloak, Jenkins) heeft bug tijdens ontwikkelperiode.    | Laag   | Middel | Stabiele versies gebruiken indien mogelijk.                                                                                                                                                                                                                       | Oudere (en stabiele) versie gebruiken. Dit kan er wel voor zorgen dat wat code herschreven moet worden.              |  
| Apparatuur (laptop) gaat stuk.                                                                           | Middel | Laag   | Gebruik maken van een versiebeheer-applicatie (Github) zodat er weinig progressie verloren zal raken.                                                                                                                                                             | Nieuwe apparatuur regelen en de github repository clonen.                                                            |