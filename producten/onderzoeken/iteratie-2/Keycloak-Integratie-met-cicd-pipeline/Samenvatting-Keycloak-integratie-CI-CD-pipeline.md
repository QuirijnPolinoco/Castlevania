# **Hoe kan Keycloak geïntegreerd worden met een CI/CD pipeline?**


## 1. Integratie met Jenkins

Keycloak kan goed samenwerken met Jenkins voor geautomatiseerde configuratie. Via de [Keycloak Authentication Plugin](https://plugins.jenkins.io/keycloak/) kunnen gebruikers inloggen via Keycloak (Single Sign-On). Voor configuratiebeheer kan je gebruik maken van de tool [`keycloak-config-cli`](https://medium.com/@assahbismarkabah/keycloak-config-cli-a-guide-to-remote-state-management-03a2bcfdc27d), waarmee JSON/YAML-configuraties vanuit Git kunnen worden ingelezen en toegepast binnen een Jenkins pipeline.

Bijvoorbeeld:
- Gebruik `kc.sh` of de Admin REST API om via shellstappen Keycloak te beheren.
- Zorg voor `stage`-gebaseerde pipelines met duidelijke scheiding van build, deploy en test.
- Gebruik API tokens in plaats van wachtwoorden voor authenticatie.

[Meer over Jenkins-integratie](onderzoek-Keycloak-Pipline.md#integratievoorbeelden-verzamelen-113)

## 2. Integratie met GitLab
_Dit is slechts een voorbeeld: Bold Digital gebruikt geen GitLab_

Er zijn meerdere [communityvoorbeelden](https://gitlab.com/gitlab-org/gitlab/-/issues/273753) van CI/CD-integratie met Keycloak via GitLab. Je maakt hierbij gebruik van:
- Keycloak als **OpenID Connect (OIDC)** provider,
- Service-accounts in Keycloak om tokens te genereren,
- GitLab `.gitlab-ci.yml` pipelines die configuratie automatiseren via `keycloak-config-cli`.

Ook kun je Keycloak gebruiken als **authenticatieservice** voor GitLab CE via [OIDC](https://docs.gitlab.com/administration/auth/oidc/).

[Meer over GitLab-integratie](onderzoek-Keycloak-Pipline.md#technische-mogelijkheden-samenvatten-114)

## 3. Tools en Automatisering

**Belangrijke tools**:
- `keycloak-config-cli`: import/export via JSON/YAML
- **Keycloak Admin REST API**
- **Terraform Keycloak Provider**
- **Ansible Modules**
- **Kubernetes Operators**

Deze maken het mogelijk om declaratief, herhaalbaar en veilig configuraties te beheren in je CI/CD-pipeline.

[Meer over automatiseringstools](onderzoek-Keycloak-Pipline.md#onderzoek-tools-voor-geautomatiseerde-keycloak-configuratie-123)

## 4. Best Practices voor Veiligheid

- Gebruik PKCE in OAuth-flows
- Zet MFA aan voor gevoelige accounts
- Beperk tokenlevensduur
- Vermijd wildcard redirect URI's
- Gebruik rolgebaseerde toegang (RBAC)
- Activeer audit logging en verbind deze met CI/CD-tools zoals ELK of Prometheus

[Meer over security best practices](onderzoek-Keycloak-Pipline.md#onderzoek-naar-veilig-gebruik-van-keycloak-in-ci-cd-117)

## 5. Casestudies (Voorbeelden van Succes)

### App.Farm / RSHB-Intech
- GitOps via GitLab
- YAML-gestuurde Keycloak configuratie
- Gebruik van Kubernetes-operators

[Casestudy App.Farm](https://github.com/mathiznogoud/keycloak-blog/blob/master/How%20to%20implement%20CICD%20for%20all%20developers%20in%20a%20bank.%20CICD%20by%20App.Farm%20.md?utm)

### Gepardec / MediaKey
- Meerdere omgevingen (DEV/TEST/PROD)
- Configuratie via keycloak-config-cli
- GitLab pipelines met GitOps-principes

[Casestudy Gepardec](https://www.gepardec.com/blog/keycloak-configuration-mit-devops-prinzipien-cicd/?utm)

[Meer succesvoorbeelden](onderzoek-Keycloak-Pipline.md#succesverhalen-en-casestudys-verzamelen-118)

## 6. Voorbeeldstructuur van CI/CD met Keycloak

```text
Git Repo (config & code)
├── realm-config/       ← JSON/YAML configuratie
├── .gitlab-ci.yml      ← Automatisering
└── app/                ← Beveiligd via Keycloak

Pipeline Stappen:
1. Build Docker
2. Start Keycloak in dev-mode
3. Inject configuratie met CLI
4. Run tests
5. Deploy naar productie
````

## 7. Conclusie
Keycloak is prima te integreren met CI/CD pipelines via:

- Jenkins of GitLab met keycloak-config-cli
- Declaratieve configuratie via JSON/YAML
- OIDC-authenticatie met tokens
- GitOps en infrastructure-as-code tools zoals Terraform en Kubernetes Operators

Keycloak kan succesvol geïntegreerd worden in CI/CD pipelines via tools zoals Jenkins of GitLab. 
Hiervoor gebruik je keycloak-config-cli, OIDC-authenticatie en declaratieve configuratiebestanden. 
Door deze combinatie is het mogelijk om Keycloak automatisch te deployen, configureren en beveiligen binnen een CI/CD-proces.