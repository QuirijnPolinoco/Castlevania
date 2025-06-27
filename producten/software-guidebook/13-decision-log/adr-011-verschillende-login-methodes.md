## ADR-011: Verschillende Login-methodes

**Datum:** 14-05-2025

### Status
Accepted

### Context

Voor de applicatie is veilige en gebruiksvriendelijke authenticatie essentieel. In deze ADR vergelijken we verschillende
loginmethodes om een onderbouwde keuze te maken die aansluit bij de functionele eisen, gebruikerservaring en
beveiligingsbehoeften van het systeem.

De keuze voor de juiste loginmethode is bepalend voor het vertrouwen van gebruikers, de beveiliging van data en de
schaalbaarheid van het platform.

#### Considered Options

| Forces                    | Password & Username | MFA | Passwordless | Social login |
|---------------------------|---------------------|-----|--------------|--------------|
| Beveiliging               | 0                   | ++  | --           | +-           |
| Gebruikerservaring        | ++                  | 0   | ++           | ++           |
| Implementatiecomplexiteit | ++                  | -+  | 0            | +-           |
| Bekendheid bij gebruikers | ++                  | 0   | +-           | ++           |
| Onderhoud en beheer       | ++                  | ++  | +-           | +-           |

### Decision

We kiezen voor MFA (Multi-Factor Authentication) als standaard authenticatiemethode.

Hoewel traditionele username-wachtwoord combinaties nog steeds breed worden toegepast, zijn ze kwetsbaar voor onder
andere brute force-aanvallen, credential stuffing, en phishing. MFA voegt een extra laag van beveiliging toe door
gebruikers te verplichten twee of meer vormen van verificatie te doorlopen — bijvoorbeeld iets wat ze weten (
wachtwoord), iets wat ze hebben (authenticator app of sms-code), of iets wat ze zijn (biometrie).

In onze context, waar veiligheid en betrouwbaarheid van gebruikersdata essentieel zijn, biedt MFA de juiste balans
tussen veiligheid en gebruikersgemak. Daarnaast sluit deze methode goed aan op mogelijke toekomstige uitbreidingen zoals
single sign-on of federated identity.

### Consequences

* Gebruikers ervaren mogelijk een iets hogere drempel bij het inloggen, maar dit wordt gecompenseerd door verhoogde
  veiligheid.
* De implementatie van MFA vereist integratie met een externe service (zoals Auth0, Firebase, of Microsoft/Google
  Authenticator), wat extra ontwikkeltijd vraagt.
* Phishing-aanvallen worden moeilijker, omdat gebruikers niet alleen hun wachtwoord hoeven in te voeren.
* Gebruiker kan de tweede stap kwijtraken.

*Legenda:*

- ++ Zeer tevreden
- +- Tevreden
- 0 Neutraal
- -+ Ontevreden
- -- Zeer ontevreden
