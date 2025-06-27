# SCIM / API synchronisatie

Doel: Onderzoek SCIM of custom API-sync tussen Keycloak en andere tools

## Wat is SCIM?

SCIM staat voor **S**ystem for **C**ross-domain **I**dentity **M**anagement.
Het is een specificatie die "ontworpen is om het beheer van gebruikersidentiteiten in cloudgebaseerde applicaties en services te vereenvoudigen".
Het is gebaseerd op bestaande implementaties, zoals op het gebied van authenticatie-, autorisatie- en privacymodellen.
Dit zou kosten verlagen en de complexiteit van gebruikersbeheer verminderen.

([scim.cloud](https://scim.cloud/))

## Ondersteunt Keycloak SCIM?

[Keycloak ondersteunt SCIM niet standaard](https://github.com/keycloak/keycloak/issues/13484): daar is een plugin voor nodig, zoals [SCIM for Keycloak](https://scim-for-keycloak.de/).

## Wordt SCIM ondersteund door de doelapplicaties?

### Google

Dit is niet heel duidelijk gedocumenteerd.
Er is wel een [Reddit post](https://www.reddit.com/r/gsuite/comments/15y7016/saml_sso_and_scim_auto_provisioning_integration/) die verwijst naar [een lijst van applicaties die SCIM ondersteunen](https://support.google.com/a/topic/10018788), maar dit zijn niet allemaal Google applicaties.

Conclusie: **onbekend** ❔

### Nexus

[Geen ondersteuning voor SCIM](https://help.sonatype.com/en/user-authentication.html#:~:text=SCIM%20Not%20Supported,identity%20provider%20and%20Nexus%20Repository.).

Conclusie: **nee** ❌

### Jenkins

Ook Jenkins ondersteunt SCIM niet. Er is wel een [plugin voor SAML Single Sign On (SSO)](https://plugins.jenkins.io/miniorange-saml-sp/).
Dit biedt de mogelijkheid om Jenkins te laten authenticeren via Keycloak.
Dit zou dan echter niet volgens SCIM gaan, dus de conclusie is toch negatief.

Conclusie: **nee** ❌

### Gitea

[(Nog) geen ondersteuning voor SCIM](https://github.com/go-gitea/gitea/issues/23794#issue-1646128434).
Er is ook geen plugin te vinden die het implementeert.

Conclusie: **nee** ❌

### Atlassian

[Ondersteunt SCIM](https://support.atlassian.com/provisioning-users/docs/understand-user-provisioning/).
Er is tevens een uitgebreide documentatiepagina, wat zeker een pluspunt is.

Conclusie: **ja** ✅

### 1Password

[Ondersteunt SCIM in de Business versie](https://support.1password.com/scim/#:~:text=With%201Password%20Business%2C%20you%20can%20automate%20many%20common%20administrative%20tasks%20by%20connecting%20your%20identity%20provider%20with%20your%201Password%20account%20using%201Password%20SCIM%20Bridge.).
Ook 1Password beschikt over [uitgebreide documentatie op het gebied van SCIM](https://support.1password.com/scim-best-practices/).

Conclusie: **ja** _(in de Business versie)_ ✅

### Slack

[Ondersteunt SCIM](https://slack.com/intl/en-gb/help/articles/212572638-Manage-members-with-SCIM-provisioning#:~:text=Slack%20supports%20member%20provisioning%20with,alongside%20a%20supported%20identity%20provider.).
Er is zelfs [specificatie documentatie voor het bouwen van een eigen script voor SCIM](https://api.slack.com/scim).

Conclusie: **ja** ✅

### Glassfrog

Er is online niks te vinden over of er ondersteuning is voor SCIM.
We gaan er dus van uit dat er ook geen ondersteuning is.

Conclusie: **nee** ❌

## Wat zijn de voor- en nadelen van het gebruik van SCIM t.o.v. een custom API-sync?

|                  | SCIM | Custom API-sync |
| ---------------- | ---- | --------------- |
| Onderhoud        | +    | -               |
| Uitbreidbaarheid | -    | +               |
| Beveiliging      | +    | -               |

SCIM scoort hoog op onderhoud en beveiliging, omdat het een al bestaand systeem is. Developers ervan doen het grootste deel van het onderhoud dus al voor je. Ook is er door hun nagedacht over security, en hier zullen ook updates voor uitgevoerd worden. Als je een custom API-sync zou gebruiken, moet je dit allemaal zelf doen.
Wat betreft uitbreidbaarheid is een custom API-sync wel ideaal, omdat je dat systeem volledig in eigen handen hebt. Je bent dus vrij om aan te passen of toe te voegen wat je maar wilt.

## Technische beschrijving van de werking van SCIM met Atlassian en Keycloak

Als eerste wordt er een gebruikersobject gewijzigd in Keycloak (bijv. registratie, activatie, etc.). De Keycloak SCIM plugin stuurt vervolgens een SCIM call naar Atlassian. De hoofd-endpoint hiervoor is `https://api.atlassian.com/scim/directory/{directory_id}`. Authenticatie wordt gedaan middels een Bearer-token. Dit is een API-token die gegenereerd is in Atlassian.

Stel er wordt een gebruiker aangemaakt, dan zou bijvoorbeeld de volgende API-request gebruikt kunnen worden:

```http
POST https://api.atlassian.com/scim/directory/{directory_id}/Users
Authorization: Bearer <api_token>
Content-Type: application/json

{
  "schemas": ["urn:ietf:params:scim:schemas:core:2.0:User"],
  "userName": "voorbeeld@voorbeeld.nl",
  "name": {
    "givenName": "Voorbeeld",
    "familyName": "Voorbeeld"
  },
  "emails": [
    {
      "value": "voorbeeld@voorbeeld.nl",
      "primary": true
    }
  ],
  "active": true
}
```

## Kan SCIM ook rollen en permissies tussen systemen synchroniseren?

SCIM is ontworpen om identiteiten, zoals gebruikers en groepen, te synchroniseren tussen systemen. Een groep kan bestaan uit meerdere rollen, dus je zou op die manier rollen kunnen synchroniseren. Ook is het mogelijk om attributen toe te voegen aan gebruikers of groepen. Dit biedt echter geen precies permissiebeheer, dus het op deze manier doen zou niet ideaal zijn. Het zou dus eventueel wel kunnen, maar gezien de hoeveelheid applicaties zou dit niet bepaald een geschikte oplossing zijn.

## Wat zijn de implicaties voor beveiliging van beide oplossingen?

SCIM gebruikt meestal OAuth2 bearer tokens of een API-token. Als je een custom API-sync zou gebruiken, zou je ook wat anders kunnen kiezen. Hiermee ben je echter wel verantwoordelijk voor een veilige implementatie.

Wat betreft toegangsbeheer is een custom API-sync wel logischer, omdat je dan volledige, precieze controle hebt over wie waarbij kan.
Met SCIM ben je gelimiteerd tot gebruikers en groepen.

Daarnaast heeft SCIM al ondersteuning voor sommige applicaties. Met een custom API-sync ben je afhankelijk van de API's van de doelapplicaties, en daar moet je je dan ook in verdiepen. Dit kan dus meer tijd kosten.
