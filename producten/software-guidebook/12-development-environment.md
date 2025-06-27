# 13. Development Environment

## 13.1 Overzicht
Hieronder staat een overzicht van: 
- Gebruikte tools 
- Gebruikte versies in de omgeving
- Gebruikte Docker containers

## 13.2 Benodigde applicaties & programeer taal
- Java [Versie 17]
- Docker [Versie 28.2.2]


## 13.3 Build- en Deploymentproces
- Build-tool: [Maven 3.9.9]
- CI/CD-pipeline: [GitHub Actions] 
  - `backend-pipeline.yaml` 
  - `compose-pipeline.yaml`
- Spring Boot [Versie 3.4.5]

## 13.4 Configuratie en Instellingen
- Configuratiebestanden: [`application.properties`, `haproxy.cfg`]
- Import van data [`realm-export.json`] (Alleen voor testdoeleinden, niet voor productiegebruik)
  - Bevat testgebruikers en rollen voor het testen van de authenticatie en autorisatie
  - Inclusief test-realm configuratie voor Keycloak
  - Gebruikt voor het valideren van de security architectuur en integratie

## 13.5 Samenwerking en versiebeheer
- [Github-project](https://github.com/orgs/AIM-ENE-feb25/projects/6)
- [Git-repository](https://github.com/AIM-ENE-feb25/castlevania)
- Code review-processen.

## 13.6 Docker containers
- [Keycloak docker container](https://hub.docker.com/r/keycloak/keycloak) [Version 26.2.5]
- [PostgreSQL docker container](https://hub.docker.com/_/postgres) [Version 15]
- [Gitea Docker Container](https://hub.docker.com/r/gitea/gitea) [Version 1.23.7]
- [Mailhog Docker Container](https://hub.docker.com/r/mailhog/mailhog) [Version 1.0.1]
- [Jira Docker Container](https://hub.docker.com/r/atlassian/jira-software) [Version 9.12.9]
- [Jenkins Docker Container](https://hub.docker.com/r/jenkins/jenkins) [Version latest]
- [Haproxy Docker Container](https://hub.docker.com/_/haproxy/) [Version 3.1.7]