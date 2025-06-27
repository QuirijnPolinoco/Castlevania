# 1. Introduction

Dit software guidebook dient als centrale documentatie voor het onderzoek naar de meest geschikte oplossing voor rollenbeheer binnen Bold Digital. Het doel is om te bepalen welke van de volgende twee opties het beste aansluit bij de behoeften van het bedrijf:

- Het inzetten van Keycloak als centrale gebruikersbeheerapplicatie.
- Het ontwikkelen van een nieuwe applicatie met Spring Boot en Vue 3 voor centraal gebruikersbeheer.

Bold Digital streeft naar een Single Sign-On (SSO)-oplossing waarmee alle medewerkers kunnen inloggen en waarbij de bevoegdheden van gebruikers centraal beheerd worden.

## 1.1 Doel van dit document
Dit guidebook is bedoeld om:
- De technische keuzes, prototypes en onderzoeksresultaten te documenteren.
- Een basis te bieden voor toekomstige ontwikkeling.

## 1.2 Inhoud van het guidebook
Het Software Guidebook bevat onder andere:
- Beschrijving van architecturale beslissingen.
- Prototypes; een Walking Skeleton en throwaway prototypes.
- Onderzoeken naar onzekerheden rondom de oplossingen.

De Walking Skeleton is te vinden in de [walking-skeleton folder](../walking-skeleton/).  
De documentatie van de onderzoeken bevindt zich in de [onderzoeken folder](../onderzoeken/).

## 1.3 Doelgroep
Dit document is bedoeld voor:
- Ontwikkelaars en software-architecten binnen Bold Digital.
- Besluitvormers binnen Bold Digital die inzicht willen in de opties.

## 1.4 Inhoudsopgave
Hieronder staat een inhoudsopgave, zodat het software guidebook makkelijker is om te navigeren:

1. [Context](#2-context)
2. [Functional Overview](#3-functional-overview)
3. [Quality Overview](#4-quality-overview)
4. [Constraints](#5-constraints)
5. [Principles](#6-principles)
6. [Software Architecture](#7-software-architecture)
7. [Code](#8-code)
8. [Data](#9-data)
9. [Infrastructure Architecture](#10-infrastructure-architecture)
10. [Deployment](#11-deployment)
11. [Operation and Support](#12-operation-and-support)
12. [Development Enviroment](#13-development-enviroment)
