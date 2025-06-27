| Role          | Read code | Write code | Deploy | Alter Permissions |
|---------------|-----------|------------|--------|-------------------|
| Backend Dev   | ✅         | ✅          | ✅      | ❌                 |
| Frontend Dev  | ✅         | ✅          | ❌      | ❌                 |
| Product owner | ✅         | ❌          | ❌      | ❌                 |
| HR / CO       | ✅         | ❌          | ❌      | ✅                 |

- Role | Action | Resource | Permission |
- Backend Developer | Alter | API-configurations | ✅ Yes
- Frontend Developer | Read | Userdata | ✅ Yes
- Opdrachtgever | Read | Sprint Planning | ✅ Yes
- Opdrachtgever | Alter | Codebase | ❌ No

| Role          | Read | Create | Update | Delete |
|---------------|------|--------|--------|--------|
| Backend Dev   | ✅    | ✅      | ✅      | ✅      |
| Frontend Dev  | ✅    | ✅      | ✅      | ✅      |
| Product owner | ✅    | ❌      | ❌      | ❌      |
| HR / CO       | ✅    | ❌      | ❌      | ❌      |

------------------------------------------------------------------

# Welke Rollen zijn er per App?

| **Rollen**             | **GlassFrog**                 | **Keycloak**   | **Jenkins**                                                           | **Nexus**   | **Gitea**              | **Atlassian (Jira)**               | **Google Workspace**                                                                                                                                                                              |
|------------------------|-------------------------------|----------------|-----------------------------------------------------------------------|-------------|------------------------|------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Beheerder**          | Circle Lead, Secretary, Admin | Admin, Manager | Admin                                                                 | Admin       | Owner Team, Admin Team | Super Admin, Admin                 | Super Admin, Groups Admin, User Management Admin, Help Desk Admin, Services Admin, Mobile Admin, Storage Admin, Google Voice Admin, Directory Sync Admin, Reseller Admin, Indirect Reseller Admin |
| **Ontwikkelaar**       | Role-Filler                   | User, Employee | Developer, Project Lead, QA Tester, Builder                           | -           | General Team           | Developer                          | -                                                                                                                                                                                                 |
| **Lezer**              | -                             | User           | Viewer                                                                | Anonymous   | -                      | User                               | Standaard User                                                                                                                                                                                    |
| **Gast**               | -                             | -              | -                                                                     | -           | -                      | -                                  | Gast, Temporary Role                                                                                                                                                                              |
| **Beheerder Platform** | Admin                         | -              | -                                                                     | -           | -                      | -                                  | Admin, User Management Admin, Help Desk Admin                                                                                                                                                     |
| **Overige**            | -                             | -              | Node Admin, Matrix-Based Security, Project-Based Matrix Authorization | Custom role | -                      | Jira-SysteemBeheerders, Beheerders | Directory Sync Admin, Reseller Admin, Indirect Reseller Admin                                                                                                                                     |

### Google Workspace:

- Super Admin
- Groups Admin
- User Management Admin
- Help Desk Admin
- Services Admin
- Mobile Admin
- Storage Admin
- Google Voice Admin
- Directory Sync Admin
- Reseller Admin & Indirect Reseller Admin
- Temporary Role
- Standaard User
- Custom Administrator roles

### Atlassian (Jira):

- Jira-SysteemBeheerders
- Beheerders
- Ontwikkelaars
- Gebruikers

### Gitea (SonaType):

- Owner Team
- Admin Team
- General Team

### Nexus:

- Admin
- Anonymous
- Custom role

### Jenkins:

- Admin
- Developer
- Viewer
- Project Lead
- QA Tester
- Node Admin
- Builder
- Matrix-Based Security
- Project-Based Matrix Authorization

### Keycloak:

- Admin
- Manager
- User
- Employee

### GlassFrog:

- Circle Lead
- Secretary
- Admin
- Role-Filler

-------------------------------------------

# Welke rollen zijn minimaal nodig?

| **Applicatie**       | **Rollen**                                        |
|----------------------|---------------------------------------------------|
| **Google Workspace** | Super Admin, (any) Admin, Standaard User          |
| **Atlassian (Jira)** | Jira-SysteemBeheerders, Ontwikkelaars, Gebruikers |
| **Gitea (SonaType)** | Admin Team, General Team                          |
| **Nexus**            | Admin, Anonymous                                  |
| **Jenkins**          | Admin, Developer, Viewer                          |
| **Keycloak**         | Admin, User, Employee                             |
| **GlassFrog**        | Admin                                             |

### Google Workspace:

- Super Admin
- (any)Admin
- Standaard User

### Atlassian (Jira):

- Jira-SysteemBeheerders
- Ontwikkelaars
- Gebruikers
-

### Gitea (SonaType):

- Admin Team
- General Team

### Nexus:

- Admin
- Anonymous

### Jenkins:

- Admin
- Developer
- Viewer

### Keycloak:

- Admin
- User
- Employee

### GlassFrog:

- Admin
