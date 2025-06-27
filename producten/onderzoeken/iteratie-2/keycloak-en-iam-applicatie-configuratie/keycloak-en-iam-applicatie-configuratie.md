# Configuratie
Dit onderzoek is bedoelt om in kaart te brengen welke configuratiestappen gezet moeten worden om een basislevel Keycloak applicatie op te zetten.
In dit onderzoek wordt gebruik gemaakt van Docker containers om de productie applicaties te simuleren.
Deze container is hieronder te vinden:
- [Keycloak Docker Documentation]("https://www.keycloak.org/getting-started/getting-started-docker")

Letop: Alle containers moeten een zelfde network delen. Voeg hiervoor een --network <network-naam> parameter toe aan een compose command.

## Configuratie binnen Keycloak
Keycloak is een SSO applicatie dat zowel login, als authorisatie regelt. Dit wordt gedaan via Users, Roles, Clients en Realms.
Voor meer informatie over wat deze begrippen betekent, zie dit [onderzoek](..%2F..%2Fiteratie-1%2Frbac-keycloak-analyse%2Frbac-keycloak-analysis.md#hoe-werkt-rbac-in-keycloak).
Het is aangeraden om het RBAC-onderzoek eerst te lezen, om een beter beeld bij de begrippen te krijgen.
Op zichzelf doen Users, Clients, Realms en Roles niet al te veel. Eerst moeten ze geconfigureerd worden, zodat ze de juiste waarden en de juiste links onderling hebben.
Dit onderzoek is erop gericht om dit beter in beeld te krijgen.

### Realms
Realms zijn de verschillende organisaties of omgevingen waarin gewerkt kan worden. Het komt vaak voor dat er verschillende bevoegdheden zijn voor verschillende omgevingen. Denk hierbij bijvoorbeeld aan een dev- en productie-omgeving.
Hiervoor kunnen verschillende Realms gemaakt worden. Een Realm is dus de hoogste "scope".
#### Om een nieuwe Realm te maken,
- Navigeer binnen Keycloak naar "Manage Realms". 
- Klik op "Create Realm"
- Vul de data in en maak de realm

### Roles
Een Role is een groep waarden die aan een User of Client gelinkt kunnen worden. 
Een Role bevatten 1 of meerdere "attributes". Door middel van attributes wordt de authorisatie geregeld. 
Een attribute bevat een "Key" en een "Value".
Wanneer een gebruiker via een applicatie bij Keycloak inlogd, krijgt de applicatie de attributes die geassosieerd zijn met dat account.
Een attribute kan er bijvoorbeeld als volgt uitzien:
> key: access-level, value: admin

Als een login wordt gemaakt via een account met deze rol, dan zou de applicatie de volgende JSON binnen krijgen:

```json
{
  "roles_metadata": {
    "data-analyst": {
      "access-level": "admin"
    }
  }
}
```
De daadwerkelijke logica achter de authorisatie moet de applicatie zelf regelen.
Bij het aanmaken van een [Client](#clients) voor een applicatie, wordt er vaak al automatisch een Role aangemaakt voor de auth.

#### Om een Role aan te maken,
- navigeer naar "Realm Roles" 
- klik op "Create roles"
- Geef het de juiste naam en save de role.
- Navigeer naar de nieuw gemaakte role en creer de juiste attributes.

### Clients
Clients zijn de applicaties die gebruik maken van keycloak als SSO. Denk hierbij bijvoorbeeld aan Gitea, Google Workspace, etc.<br>
Bij het maken van een Client moet er eerst gekozen worden of de client gebruik maakt van OpenID of SAML. Het ligt aan wat de applicatie support. Zie [deze tabel](..%2F..%2Fiteratie-1%2Frbac-keycloak-analyse%2Frbac-keycloak.md#adr-002-keycloak-integratie-strategie-per-applicatie) voor reference.
Er moet een ClientID en naam ingevult worden. De ClientID moet uniek zijn.
Er moet ook een Access-type bepaalt worden. Dit staat onder het hoofdstuk "Capability config".
Als de applicatie een "Secret Key" nodig heeft, moet dit aangezet worden.
- Als laatst moet een root-url opgegeven worden. Dit is de base-url van de applicatie. 
> Bv. https://www.gitea.com.

- De home-url is de homepagina's path.
>Bv. / of /home

- Redirect URI's zijn de URI's waar Keycloak de browser naar redirect na een succesvolle login.
- Web origins zijn de URL's waar de inlog request vandaan kan komen. Dit is vaak de front-end van de applicatie.
- Scopes zijn groepen claims die beschikbaar worden gesteld via het token.
- Roles kunnen toegevoegd worden om deze aan Users te linken.

#### Om een Client aan te maken,
- Check of de applicatie waaraan Keycloak gekoppeld moet worden SAML of OpenID Connect gebruikt.
- Navigeer naar "Clients" in Keycloak.
- Selecteer "Create client".
- Selecteer de juiste Client type.
- Vul een Client ID in (onthoud deze)
- Bij "Capability config" check Client authorization als de applicatie een "Secret Key" nodig heeft.
- Vul de URL- en URI's in bij Login settings.
- Save de Client
- Navigeer naar de Client
- Voeg eventueel rollen toe aan de Client.

### Users
Een user is een entiteit in Keycloak. Hierbij wordt alle data bij de user ingesteld. Bijvoorbeeld:
- Username
- First- and lastname
- Password
- Email
- Roles
- Groups
- etc
Ook kan een user action ingelsteld worden. Deze moet complete worden voordat er ingelogd kan worden op het account.

#### Om een User aan te maken, 
- Mavigeer naar "Users".
- "Add User"
- Vul alle data in
- "Create"
- Navigeer naar de User
- Voeg bij Credentials een wachtwoord toe
- Voeg eventueel de juiste Roles toe


### Groups
Een group is een collectie van Roles en Attributes die aan users assigned kunnen worden.
#### Om een nieuwe Group aan te maken,
- In Keycloak navigeer naar Groups
- Selecteer "Create Group"
- Vul een naam in
- "Create"
- Navigeer naar de group en voeg de benodigde Roles en Attributes toe.

## Connect Keycloak naar een Applicatie
1. [Maak](#om-een-nieuwe-realm-te-maken) en/of navigeer naar de juiste realm.
2. [Maak een Client voor de applicatie](#om-een-client-aan-te-maken).
- Zorg ervoor dat de juiste Client type geselecteerd is
- Als de applicatie een Client Secret nodig heeft, zet Client auth aan
- Voeg de URL en URI's toe.
- Maak de client aan.
- Selecteer de client in de lijst van clients
- Indien Client Auth aan staat, kopieer de Client Secret
3. Navigeer naar de admin console van de applicatie
4. Vul alle data in en maak de connectie aan.
5. Indien een gebruiker probeert in te loggen, staat er nu een "login met Keycloak" optie.


## Conclusie

Het is nu duidelijk hoe elk van de begrippen binnen Keycloak geconfigureerd kunnen worden.

## Bronnen
[Keycloak docker documentation](https://www.keycloak.org/getting-started/getting-started-docker)
<br>[Keycloak administration guide](https://www.keycloak.org/docs/latest/server_admin/index.html)

