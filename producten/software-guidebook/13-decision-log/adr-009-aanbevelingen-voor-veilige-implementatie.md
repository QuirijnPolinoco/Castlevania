## ADR-009: Aanbevelingen voor veilige implementatie

**Datum:** 20-05-2025

### Status
Accepted

### Context

In de huidige Keycloak-configuratie wordt social login ondersteund via Identity Brokering (bijv. Google, Apple,
Facebook). Echter, wanneer deze externe providers tijdelijk niet beschikbaar zijn of een gebruiker geen toegang meer
heeft, kan dit leiden tot lockouts of gebruikersfrustratie.

Om risico's van afhankelijkheid te beperken, willen we fallback-loginmethodes aanbieden, zoals username/password of
magic link, zonder daarbij afbreuk te doen aan veiligheid en gebruikerservaring.

#### Considered Options

| Forces                              | Alleen social login | Social login met fallback (e-mail/wachtwoord) | Social login + fallback + account linking | Passwordless login only |
|-------------------------------------|---------------------|-----------------------------------------------|-------------------------------------------|-------------------------|
| Gebruikersgemak                     | +-                  | ++                                            | ++                                        | +-                      |
| Beveiliging bij storing third-party | --                  | ++                                            | ++                                        | ++                      |
| Beheerbaarheid / complexiteit       | ++                  | +-                                            | +-                                        | -+                      |
| Privacycontrole voor gebruiker      | -+                  | +-                                            | ++                                        | ++                      |
| Kans op dubbele accounts            | 0                   | 0                                             | ++                                        | +-                      |
| Ondersteuning in Keycloak           | ++                  | ++                                            | +-                                        | +-                      |

### Decision

We kiezen voor de **combinatie van social login met fallback login via e-mail/wachtwoord**, in combinatie met **account
linking via e-mailadres** in Keycloak.  
We implementeren de volgende maatregelen:

- **Meerdere authenticatie-opties** tonen op de loginpagina (IdP's + standaard login).
- **Account linking** activeren in de identity brokering flow.
- **Review Profile** flow inschakelen bij nieuwe IdP-logins.
- **Gebruikers informeren** over alternatieven bij social login-fouten.
- **Logging en monitoring** instellen voor mislukte loginpogingen.

### Consequences

Gebruikers blijven toegang houden, ook als social login tijdelijk niet werkt.

- Minder afhankelijkheid van derde partijen.
- Betere beveiliging bij social login-failures.
- Iets complexere configuratie van login flows in Keycloak.
- ️Duidelijke communicatie aan de gebruiker is vereist om verwarring te voorkomen.

*Legenda:*

- ++ Zeer tevreden
- +- Tevreden
- 0 Neutraal
- -+ Ontevreden
- -- Zeer ontevreden

---