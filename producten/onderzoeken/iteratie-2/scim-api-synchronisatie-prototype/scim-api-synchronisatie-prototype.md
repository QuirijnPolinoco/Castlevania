# SCIM / API synchronisatie prototype

## Wat is de meest geschikte doelapplicatie om het prototype voor te maken?

De criteria om dit te bepalen zijn als volgt:

- Het moet überhaupt mogelijk zijn om een prototype te maken. Het kan zijn dat dit voor bepaalde applicaties niet mogelijk is, bijvoorbeeld wegens verplichte kosten, compatibiliteitsproblemen, of specifieke eisen.
- Er moet voldoende documentatie beschikbaar zijn. Dat betekent dat alle nodige bronnen in ieder geval op de officiële site van de betreffende applicatie te vinden zijn. Deze spike heeft immers een timebox, en als documentatie lastig te vinden is ga je hier eerder overheen.
- De applicatie moet een van de belangrijkste zijn. Niet alle applicaties zijn even belangrijk om werkend te krijgen met Keycloak, bijvoorbeeld omdat de ene meer moeite kost om te beheren dan de andere. Het prototype is dus ook het meest nuttig als het een van de belangrijkste applicaties betreft.

Laten we ze allemaal op een rijtje zetten om een overzicht te krijgen:

|           | Mogelijk                                                                                                                                                                                                                                                                    | Voldoende documentatie | Een van de belangrijkste |
| --------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ---------------------- | ------------------------ |
| Google    | ❌ nee ([betaling vereist](https://workspace.google.com/pricing.html))                                                                                                                                                                                                      | ❌ nee                 | ✅ ja                    |
| Nexus     | ❌ nee ([betaling vereist](https://www.sonatype.com/products/pricing))                                                                                                                                                                                                      | ✅ ja                  | ✅ ja                    |
| Jenkins   | ✅ ja                                                                                                                                                                                                                                                                       | ❌ nee                 | ✅ ja                    |
| Gitea     | ✅ ja                                                                                                                                                                                                                                                                       | ✅ ja                  | ✅ ja                    |
| Atlassian | ❌ nee ([het vereist Atlassian Guard](https://support.atlassian.com/provisioning-users/docs/configure-user-provisioning-with-an-identity-provider/) en dat [vereist betaling](https://support.atlassian.com/security-and-access-policies/docs/understand-atlassian-guard/)) | ✅ ja                  | ✅ ja                    |
| 1Password | ❌ nee ([betaling vereist](https://1password.com/pricing))                                                                                                                                                                                                                  | ❌ nee                 | ❌ nee                   |
| Slack     | ❌ nee ([betaling vereist](https://api.slack.com/admins/scim))                                                                                                                                                                                                              | ✅ ja                  | ❌ nee                   |
| Glassfrog | ✅ ja                                                                                                                                                                                                                                                                       | ❌ nee                 | ❌ nee                   |

Deze tabel maakt duidelijk welke optie het beste is: Gitea. Dit is immers de enige die zowel belangrijk als mogelijk is, en over goede documentatie beschikt.

## Wat kan er gesynchroniseerd worden tussen Keycloak en de doelapplicatie?

Keycloak kan ingesteld worden als authentication source in Gitea, want beide [Keycloak](https://www.keycloak.org/docs/25.0.6/securing_apps/index.html#:~:text=As%20an%20OAuth2%2C%20OpenID%20Connect,supports%20any%20of%20these%20protocols.) en [Gitea](https://docs.gitea.com/development/oauth2-provider) ondersteunen OAuth2. Gebruikers synchroniseren is dus niet nodig.

Wat bijvoorbeeld wél gesynchroniseerd kan worden, is groepen. Als je in Gitea met Keycloak inlogt, heb je wel een account maar zit je nog niet in een team. Dat terwijl je in Keycloak bijvoorbeeld al wel in een groep zit. Het zou dus handig zijn om na het inloggen met Keycloak automatisch toegevoegd te worden aan het team van de bijbehorende Keycloak groep.

## Hoe kan er gesynchroniseerd worden tussen Keycloak en de doelapplicatie?

Gitea beschikt over een API die [leden kan toevoegen aan een team](https://docs.gitea.com/api/1.20/#tag/organization/operation/orgAddTeamMember) met `PUT /teams/{id}/members/{username}`. Keycloak beschikt over een API die [groepen kan verkrijgen, evenals de leden ervan](https://www.keycloak.org/docs-api/latest/rest-api/index.html#_groups). Dit kan met `GET /admin/realms/{realm}/groups` en `GET /admin/realms/{realm}/groups/{group-id}/members`. Je zou dus een script kunnen schrijven die alle leden van elke groep opvraagt uit Keycloak en toevoegt aan een team in Gitea.
