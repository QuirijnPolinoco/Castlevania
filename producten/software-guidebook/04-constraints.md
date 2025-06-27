# 5. Beperkingen

Dit hoofdstuk beschrijft de belangrijkste beperkingen die invloed hebben op de architectuur- en implementatiebeslissingen voor het gebruikersbeheersysteem bij Bold Digital, uitgevoerd door team Castlevania van de HAN.

## 5.1 Technische Beperkingen

### 5.1.1 Technologiestack
- De oplossing is Keycloak als centrale authenticatie- en autorisatieservice
- Een eigen Spring Boot applicatie wordt ontwikkeld die werkt met Keycloak
- Frontend ontwikkeling wordt gedaan met Vue 3
- Het systeem moet integratie ondersteunen met de volgende applicaties:
  - Jenkins
  - Gitea
  - Atlassian (Confluence, Jira)

### 5.1.2 Integratievereisten
- Moet Single Sign-On (SSO) functionaliteit ondersteunen via Keycloak
- Moet kunnen integreren met alle genoemde applicaties
- Moet standaard authenticatieprotocollen ondersteunen (OAuth2, OpenID Connect)
- Moet gecentraliseerde gebruikersbeheer mogelijkheden bieden
- Moet rollen per applicatie kunnen beheren

## 5.2 Project Beperkingen

### 5.2.1 Tijd en Team
- Projectduur: 8 weken (exclusief vakantiedagen)
- Teamgrootte: 5 studenten
- Beperkte beschikbaarheid door studie- en vakantieperiodes
- Omgevingen voor de applicaties moeten door het projectteam zelf worden ingericht

### 5.2.2 Beveiligingseisen
- Moet veilige gebruikersauthenticatie en -autorisatie ondersteunen via Keycloak
- Moet audit trails bijhouden voor gebruikers toegang en wijzigingen
- Gebruikers mogen niet meer rechtstreeks op individuele applicaties kunnen inloggen

## 5.3 Operationele Beperkingen

### 5.3.1 Onderhoud en Ondersteuning
- De oplossing moet onderhoudbaar zijn door het Bold Digital team
- Moet duidelijke documentatie bieden voor toekomstig
- Moet migratiestappen documenteren voor bestaande gebruikersdata