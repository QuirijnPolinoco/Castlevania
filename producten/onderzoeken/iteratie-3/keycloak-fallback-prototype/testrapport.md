# Testrapport Keycloak Fallback Prototype

## 1. Load Balancing Tests

### Test Setup
- HaProxy geconfigureerd met leastconn balancer
- Twee Keycloak instances actief (primary en secondary)
- Sticky sessions geactiveerd via AUTH_SESSION_ID cookie

### Test Resultaten
1. **Load Distribution Test**
   - Verificatie van request verdeling tussen instances
   - Resultaat: Requests worden correct verdeeld tussen beide instances
   - Bevestiging via HaProxy statistieken

2. **Sticky Sessions Test**
   - Verificatie van sessie persistentie
   - Resultaat: Gebruikers blijven verbonden met dezelfde instance tijdens hun sessie
   - Bevestiging via cookie tracking

## 2. Health Check Tests

### Test Setup
- Health check endpoint geconfigureerd op beide instances
- HaProxy health check configuratie actief

### Test Resultaten
1. **Health Check Endpoint Test**
   - Verificatie van /health/ready endpoint
   - Resultaat: Beide instances rapporteren correcte health status
   - Response code 200 ontvangen van beide instances

## 3. Failover Tests

### Test Setup
- Beide Keycloak instances actief
- Gedeelde PostgreSQL database
- HaProxy als load balancer

### Test Resultaten
1. **Primaire Instance Uitval**
   - Simulatie: Container keycloak-primary gestopt
   - Resultaat: 
     - HaProxy detecteert uitval binnen 2 seconden
     - Verkeer automatisch gerouteerd naar secundaire instance
     - Bestaande sessies blijven actief

2. **Secundaire Instance Uitval**
   - Simulatie: Container keycloak-secondary gestopt
   - Resultaat:
     - HaProxy detecteert uitval binnen 2 seconden
     - Verkeer automatisch gerouteerd naar primaire instance
     - Bestaande sessies blijven actief

3. **User Synchronisatie Test**
   - Test: Nieuwe gebruiker toegevoegd via primaire instance
   - Resultaat:
     - Gebruiker direct beschikbaar op secundaire instance
     - Authenticatie mogelijk op beide instances

4. **User Synchronisatie Test (Omgekeerd)**
   - Test: Nieuwe gebruiker toegevoegd via secundaire instance
   - Resultaat:
     - Gebruiker direct beschikbaar op primaire instance
     - Authenticatie mogelijk op beide instances

## Conclusie

De tests tonen aan dat het Keycloak fallback prototype voldoet aan de gestelde eisen:
- Load balancing werkt correct met sticky sessions
- Health checks detecteren instance status accuraat en zorgt dat verkeer wordt geredict indien health niet ok.
- Failover mechanisme functioneert
- User synchronisatie tussen instances is direct en betrouwbaar

Het systeem biedt de gewenste hoge beschikbaarheid en data consistentie tussen de Keycloak instances.
