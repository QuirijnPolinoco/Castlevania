# 6. Principles

## 6.1 Programmeer principes

### 6.1.1 Programmeertaal

Om tot een werkende walking skeleton te komen moeten we natuurlijk de programmeertaal en frameworks die door BOLD
Digital
gebruikt gebruiken.

De volgende programmeertalen en frameworks moeten gebruikt worden zodat ze goed kunnen aansluiten bij de BOLD Digital
stack:

- JAVA(17)
- Spring Boot
- Vue3

Deze programmeertalen gebruik je alleen als je aan de constructie fase zit en je moet de custom oplossing gaan bouwen.

## 6.2 Agile principes

### 6.2.1 Sub-issues

Om goed voortgang te kunnen boeken in de iteratie is ervoor gekozen om sub-issues te koppelen aan de spike issues.

Elke sub-issue is een taak die uitgevoerd moet worden om de spike te kunnen voltooien. Een sub-issue mag niet langer dan
4 uur duren, zodat het team snel kan schakelen en de voortgang goed in de gaten kan houden.

**Alle regels op een rijtje:**

- Sub-issues moeten gekoppeld zijn aan de spike issues.
- Sub-issues mogen niet langer duren dan 4 uur.
- Sub-issues moeten duidelijk beschrijven wat er gedaan moet worden.
- Sub-issues hebben acceptatiecriteria die duidelijk beschrijven wat er gedaan moet worden om de sub-issue te kunnen
  sluiten.

### 6.2.2 Pull-requests

Als een teamgenoot iets heeft gedaan en het is af! Dan moet er een pull-request worden aangemaakt. Een teamgenoot mag
nooit naar main pushen zonder dat er een pull-request is aangemaakt.

De pull-request wordt minimaal door 1 teamgenoot bekeken en goedgekeurd voordat het naar main wordt gepusht.

## 6.3 Design principes

### 6.3.1 Single Responsibility Principle

Elke klasse heeft een duidelijke verantwoordelijkheid:

- **DataTransferController:** haalt data op uit Jira en stuurt deze naar Keycloak.

- **GiteaSyncController:** triggert synchronisatie van groepen naar Gitea.

- **KeycloakUserService:** verantwoordelijk voor gebruikersbeheer in Keycloak.

- **GiteaSyncService:** verantwoordelijk voor de Gitea synchronisatie.

- **JiraUserParser:** verantwoordelijk voor het parsen van JSON-data naar UserData.

#### 6.3.1.1 Waarom het Single Responsibility Principle?

Voorkomt dat klassen te complex worden.

- Maakt het makkelijker om bugs op te sporen en te verhelpen.
- Zorgt dat wijzigingen in één functionaliteit niet onbedoeld andere delen van het systeem beïnvloeden.

Als elke klasse maar één verantwoordelijkheid heeft, blijft de codebase overzichtelijk en logisch gestructureerd.

### 6.3.2 Dependency Injection

Klassen zoals `DataTransferController`, `GiteaSyncController`, en services krijgen hun afhankelijkheden via constructors
geïnjecteerd. Dit volgt het principe van `Inversion of Control` en maakt de code testbaar en uitbreidbaar.

#### 6.3.2.1 Waarom het Dependency Injection principe?

- Maakt de code flexibel en testbaar, doordat afhankelijkheden losgekoppeld zijn van de implementatie.
- Zorgt voor betere samenwerking tussen componenten, zonder dat ze elkaar direct aanmaken of beheren.
- Ondersteunt unit testing, want je kunt eenvoudig mocks of stubs injecteren.

Door afhankelijkheden in te injecteren, worden klassen minder afhankelijk van concrete implementaties.

### 6.3.3 Open/Closed Principle

De code is open voor uitbreiding, maar gesloten voor wijziging. Nieuwe functionaliteit kan eenvoudig worden toegevoegd
zonder bestaande klassen aan te passen, door bijvoorbeeld nieuwe services of controllers toe te voegen.

#### 6.3.3.1 Waarom het Open/Closed Principle?

- Voorkomt dat je bestaande werkende code moet aanpassen bij nieuwe features (minder risico op regressies).
- Stimuleert het gebruik van extensies (zoals nieuwe services of modules) in plaats van wijzigingen.
- Bevordert een robuuste architectuur waarin nieuwe eisen soepel kunnen worden geïntegreerd.

Nieuwe functionaliteit toevoegen zonder bestaande code te breken, maakt het systeem duurzaam en wendbaar.