# User Roles & Permissions
-------------------------------------------------
# **fase 1**: Context & Vereisten Bepalen

### Rollen:
Zie bestand RollenTable.md in producten/onderzoeken/RollenSpike/RollenTable.md voor table

## Gebruiksscenario’s:
(Verzamel typische gebruiksscenario’s (bv. user-story mapping))
### Google Workspace:
- **Super Admin** kan alle instellingen beheren, gebruikers toevoegen/verwijderen en rechten aanpassen.
- **Admin** (afhankelijk van type) kan specifieke beheerfuncties uitvoeren, zoals groepsbeheer of gebruikersondersteuning.
- **Standaard User** kan inloggen, documenten openen en gedeelde bestanden bewerken.

## Atlassian (Jira):
- **Jira-SysteemBeheerders** kunnen nieuwe projecten aanmaken, gebruikersrollen toewijzen en workflows configureren.
- **Ontwikkelaars** kunnen issues aanmaken, toewijzen en de voortgang bijwerken.
- **Gebruikers** kunnen issues bekijken en commentaar geven, maar geen wijzigingen aanbrengen.

## Gitea (SonaType):
- **Admin Team** kan repositories beheren, teams aanmaken en instellingen aanpassen.
- **General Team** kan code inzien, pull requests indienen en bijdragen aan goedgekeurde projecten.

## Nexus:
- **Admin** kan repositories aanmaken, gebruikersrollen beheren en systeeminstellingen aanpassen.
- **Anonymous** gebruikers kunnen openbare content inzien zonder in te loggen.

## Jenkins:
- **Admin** kan pijplijnen configureren, gebruikersrechten instellen en builds beheren.
- **Developer** kan build scripts aanmaken en aanpassen, maar geen rechten wijzigen.
- **Viewer** kan de buildstatus volgen, logs bekijken, maar geen wijzigingen aanbrengen.

## Keycloak:
- **Admin** kan nieuwe clients configureren, gebruikersrechten beheren en authenticatieflows aanpassen.
- **User** kan toegang krijgen tot beveiligde applicaties via single sign-on (SSO).
- **Employee** kan toegang krijgen tot bedrijfsapplicaties binnen het systeem, maar heeft geen beheerrechten.

## GlassFrog:
- **Admin** kan cirkels en rollen beheren, nieuwe gebruikers toevoegen en rollen aanpassen.
- **Role-Filler** kan specifieke taken binnen een cirkel uitvoeren, maar heeft geen toegang tot beheertaken.

--------------------------------------------------
# **fase 2**: Rollen & Rechten Inventariseren  
Definieer gebruikersgroepen (Admin, Manager, Gebruiker, etc.)(Uitleg over wat deze groepen zijn)

### Administrators:
- **Systeembeheerder:** Heeft volledige toegang tot alle systeeminstellingen, gebruikersbeheer en veiligheidsopties.
- **Applicatiebeheerder:** Beheert specifieke applicatie-instellingen en gebruikersrechten binnen die applicatie.
- **Beveiligingsbeheerder:** Verantwoordelijk voor toegangscontrole, auditlogs en beveiligingsconfiguraties.

### Ontwikkelaars:
- **Backend Developer:** Heeft toegang tot server-side code, API's en systeemintegraties.
- **Frontend Developer:** Werkt aan de gebruikersinterface en client-side logica.
- **Full-Stack Developer:** Combineert de bevoegdheden van zowel backend- als frontend ontwikkelaars.
- **DevOps Engineer:** Heeft toegang tot CI/CD-pijplijnen, systeemmonitoring en infrastructuurbeheer.
7
### Projectleiders/Product Owners:
- **Product Owner:** Verantwoordelijk voor het beheren van productbacklogs en het prioriteren van features.
- **Scrum Master:** Faciliteert het ontwikkelproces en ondersteunt het team bij het bereiken van sprintdoelen.
- **Project Manager:** Houdt toezicht op de voortgang, planning en rapportage van projecten.

### Operationele Gebruikers:
- **Supportmedewerker:** Heeft toegang tot gebruikersbeheer en ondersteuningssystemen.
- **Systeemmonitor:** Toegang tot monitoring dashboards en logbestanden om systeemstatus te controleren.
- **Servicedesk Medewerker:** Beantwoordt gebruikersvragen en registreert problemen.

### Gasten/Externe Gebruikers:
- **Gastgebruiker:** Beperkte toegang tot publieke of gedeelde content, vaak alleen voor inzage.
- **Externe Samenwerker:** Tijdelijke toegang tot specifieke projecten of bestanden, zonder beheerrechten.
- **Adviseur/Consultant:** Kan projectrapporten bekijken en feedback geven, maar geen bewerkingen uitvoeren.

## Taken per rol in kaart brengen:

#### **Administrators**
- Beheren van gebruikersaccounts en rollen in het systeem.
- Configureren van systeeminstellingen en beveiligingsopties.
- Monitoren van systeemactiviteit en logbestanden.
- Onderhouden van de infrastructuur (bijvoorbeeld servers en netwerken).
- Implementeren van beveiligingsupdates en patches.

#### **Ontwikkelaars**
- Schrijven en testen van code voor nieuwe functies.
- Fixen van bugs en uitvoeren van code reviews.
- Bijdragen aan technische documentatie.
- Integreren van API's en externe diensten.
- Samenwerken met andere ontwikkelaars via versiebeheersystemen (zoals Git).

#### **Projectleiders/Product Owners**
- Plannen en coördineren van projectactiviteiten.
- Stellen van prioriteiten voor ontwikkelteams.
- Communiceren met stakeholders over voortgang en problemen.
- Opstellen en beheren van productbacklogs.
- Zorgen voor de naleving van projectdoelen en deadlines.

#### **Operationele Gebruikers**
- Uitvoeren van dagelijkse taken binnen applicaties (bijvoorbeeld data invoeren).
- Gebruik maken van rapportage- en analysetools.
- Monitoren van operationele processen.
- Melden van problemen of storingen aan de technische teams.
- Gebruiken van door ontwikkelaars gemaakte tools en applicaties.

#### **Gasten/Externe Gebruikers**
- Beperkt toegang tot specifieke delen van de applicatie.
- Raadplegen van openbare gegevens en documenten.
- Eventueel gebruik maken van specifieke self-service functies.
- Geen rechten om gegevens te wijzigen of instellingen aan te passen.
- Alleen toegang met goedkeuring van een administrator.


--------------------------------------------------
# **fase 3**: Structuur Ontwerpen & Validatie
## Bepaal basismodel in JSON met als basis RBAC
Zie Basismodel.JSON in producten/onderzoeken/RollenSpike/Basismodel.JSON

### Randgevallen, Risico’s en Beperkingen

#### **Randgevallen:**
- **Ongeautoriseerde toegang:**
  Een gebruiker met onvoldoende rechten probeert toegang te krijgen tot een beheerderspagina.
  of een gastgebruiker probeert wijzigingen aan te brengen in een project.

- **Vergeten roltoewijzing:**
  Een nieuwe medewerker wordt aangemaakt zonder een toegewezen rol, wat kan leiden tot onverwachte toegang of beperkingen.

- **Verkeerde roltoewijzing:**
  Een ontwikkelaar wordt per ongeluk een admin-rol toegewezen, wat leidt tot ongeoorloofde configuratiewijzigingen.

- **Oude gebruikersaccounts:**
  Inactieve of voormalige medewerkers hebben nog steeds toegang tot systemen door ontbrekende accountverwijdering.

- **Tijdelijke rechten:**
  Een tijdelijke rol wordt toegekend (bijv. voor een consultant), maar niet tijdig ingetrokken, wat risico's oplevert.

#### **Risico’s:**
- **Beveiligingsrisico:**
  Administrators die hun wachtwoord delen of zwakke wachtwoorden gebruiken, waardoor kwaadwillenden toegang krijgen tot het systeem.

- **Dataverlies:**
  Onbevoegde gebruikers die gegevens kunnen verwijderen of wijzigen, omdat de rechten niet goed zijn geconfigureerd.

- **Onjuist rolbeheer:**
  Verkeerd toewijzen van rollen kan leiden tot bevoegdheidsescalatie of functieverlies.

- **Privacyrisico’s:**
  Operationele gebruikers die toegang hebben tot persoonsgegevens zonder dat dit noodzakelijk is voor hun taken.


#### **Beperkingen:**
- **RBAC-granulariteit:**
  Niet alle benodigde taken passen altijd binnen één rol, wat kan leiden tot conflicten bij de roltoewijzing.

- **Complexiteit:**
  Te veel gedetailleerde rollen maken het beheer ingewikkeld en foutgevoelig.

- **Gebrek aan flexibiliteit:**
  Starre rolmodellen passen mogelijk niet goed bij organisaties met veel variatie in verantwoordelijkheden.

- **Rolveranderingen:**
  Bij functiewijzigingen moeten rollen handmatig aangepast worden, wat fouten kan veroorzaken.

- **Afhankelijkheid van correcte configuratie:**
  Als rollen en rechten niet correct zijn gedefinieerd of toegewezen, kunnen gebruikers te veel of te weinig toegang krijgen.

--------------------------------------------------
