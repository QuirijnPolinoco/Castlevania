# 4. Quality attributes
Tijdens het ontwerp en de evaluatie van de Single Sign-On (SSO)-oplossing voor Bold Digital worden zes vooraf gedefinieerde kwaliteitseisen gehanteerd:
interoperabiliteit, fouttolerantie, modulariteit, aanpasbaarheid, integriteit en vertrouwelijkheid.
Deze eisen vormen een toetsingskader voor architectuurkeuzes en implementatiebeslissingen.
De oplossing moet vóór het einde van het project, op 30 juni 2025, voldoen aan deze eisen.
Elke eigenschap wordt aantoonbaar beoordeeld aan de hand van concrete criteria.
Zo moet de oplossing minstens twee bestaande applicaties kunnen koppelen, de verwachte downtime mag niet meer bedragen dan één minuut per maand, configuraties moeten beheersbaar zijn zonder dat codewijzigingen nodig zijn, en gevoelige gegevens zoals tokens moeten veilig worden opgeslagen en verzonden.
Deze kwaliteitsdoelen zijn haalbaar binnen de beschikbare teamcapaciteit en worden gedragen door de betrokken stakeholders, waaronder DevOps, security en beheer.

#### Lijst met kwaliteitseisen
- Interoperabiliteit
- Fault tolerance
- Modularity
- Modifiability
- Integrity
- Confidentiality

## 4.1 Welke kwaliteitseisen zijn het meest belangrijk voor deze software?
Hoewel alle bovenstaande aspecten relevant zijn, zijn een aantal kwaliteitseisen cruciaal voor het slagen van de SSO-oplossing. Deze worden hieronder toegelicht.

### 4.1.1 Modularity
Modulariteit is essentieel om de oplossing schaalbaar en onderhoudbaar te houden. Het systeem moet eenvoudig uitbreidbaar zijn met nieuwe applicaties of functies, zonder dat bestaande onderdelen aangepast hoeven te worden. Denk aan een scheiding tussen authenticatie, gebruikersbeheer en autorisatie.
Een modulaire aanpak maakt het mogelijk om een bestaande identity provider zoals Keycloak te gebruiken, terwijl aanvullende componenten zoals audit logging of analytics apart kunnen worden toegevoegd.
Dit ondersteunt hergebruik, onafhankelijk testen en flexibel beheer.

### 4.1.2 Confidentiality
Vertrouwelijkheid is cruciaal in een SSO-context, gezien de verwerking van gevoelige gegevens zoals gebruikersidentiteiten, rollen, tokens en toegangsrechten.
Indien deze informatie in verkeerde handen valt, kan dit leiden tot datalekken of ongeautoriseerde toegang tot kritieke systemen.
De oplossing moet daarom voorzien in:

- Veilige communicatie (bijv. via TLS),
- Sterke authenticatie (bijv. MFA),
- Versleuteling van tokens,
- Beperking van toegangsrechten volgens het least privilege-principe, en
- Gedetailleerde logging zonder privacygevoelige informatie prijs te geven.

### 4.2.3 Fault Tolerance
Fouttolerantie is noodzakelijk omdat de SSO-oplossing een centrale toegangspoort vormt tot andere systemen. Wanneer deze dienst niet beschikbaar is, kunnen gebruikers mogelijk niet meer inloggen op kritieke applicaties zoals Gitea of Nexus, wat directe impact heeft op de dagelijkse werkzaamheden. Een storing in SSO mag dan ook niet leiden tot uitval van andere applicaties. De oplossing moet daarom ontworpen worden met mechanismen voor hoge beschikbaarheid, zoals redundante instanties, automatische failover en load balancing. Daarnaast is het belangrijk om monitoring en alerting te integreren, zodat incidenten snel kunnen worden gedetecteerd en opgelost voordat ze escaleren. Ook caching van tokens of sessies kan helpen om tijdelijk beperkte functionaliteit te behouden bij een gedeeltelijke storing. Een betrouwbare en veerkrachtige SSO-oplossing verhoogt het vertrouwen van gebruikers, ondersteunt continuïteit van bedrijfsprocessen en beperkt het risico op productiviteitsverlies bij technische problemen.
### 4.2.4 Interoperability
Interoperabiliteit betekent dat de oplossing goed moet kunnen samenwerken met zowel bestaande interne tools zoals Gitea en Nexus, als externe cloudapplicaties.
Hiervoor moet ondersteuning aanwezig zijn voor gangbare protocollen zoals OAuth2, OpenID Connect en eventueel SAML.
Ongeacht de gebruikte programmeertaal of technologie moet een applicatie zich eenvoudig kunnen aansluiten op de SSO-infrastructuur.
Dit verhoogt de toepasbaarheid en vermindert de afhankelijkheid van specifieke systemen.
