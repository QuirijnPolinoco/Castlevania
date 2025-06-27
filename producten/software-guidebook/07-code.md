# 8. Code

## 8.1 Logging Keycloak Code

Om een custom logging optie binnen keycloak op te zetten, moet er een .jar bestand in de "/opt/keycloak/providers/" van keycloak gedaan worden. Voor een diepere uitleg van dat process zie het [deployment](#keycloak-logging-deployment) hoofdstuk.
Om de .jar op te zetten wordt er gebruik gemaakt van een Maven project. Hierin worden de volgende dependencies gebruikt: 
```pom.xml
        <dependency>
            <groupId>org.keycloak</groupId>
            <artifactId>keycloak-core</artifactId>
            <version>${keycloak.version}</version>
            <scope>provided</scope>
        </dependency>
        <dependency>
            <groupId>org.keycloak</groupId>
            <artifactId>keycloak-server-spi</artifactId>
            <version>${keycloak.version}</version>
            <scope>provided</scope>
        </dependency>
        <dependency>
            <groupId>org.keycloak</groupId>
            <artifactId>keycloak-server-spi-private</artifactId>
            <version>${keycloak.version}</version>
            <scope>provided</scope>
        </dependency>
        <dependency>
            <groupId>org.keycloak</groupId>
            <artifactId>keycloak-services</artifactId>
            <version>${keycloak.version}</version>
            <scope>provided</scope>
        </dependency>
```
### 8.1.1 Uitleg Classes
Eerst moet er een class die EventListenerProviderFactory extend en een EventListenerProvider extend opgezet worden. De factory maakt een instantie van de EventListenerProvider-class aanmaken. De EventListenerProvider-class heeft twee onEvent functies, een voor een admin-event en een voor een user-event.
Hier binnen wordt gecheckt of de event degene is die gewenst is. Zo ja, wordt uigevoerd wat gewenst is. Binnen de EventListenerProvider moet een unieke ID ingesteld worden. Deze moet later bij de deployment ingevuld worden.

[documentatie keycloak event](https://www.keycloak.org/docs-api/latest/javadocs/org/keycloak/events/package-summary.html)
### 8.1.2 Class Diagram Logging
![logging class diagram](/diagram/logging/logging-class-diagram.svg)