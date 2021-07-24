Testaufgabe von Pavel Lezin
----
###Aufgabe:

Baue für uns ein kleines Telefonbuch.
Es soll möglich sein in einem Web-Anwendung alle Telefonbuch-Einträge zu sehen. Neue Einträge hinzuzufügen, Einträge ändern, Einträge löschen. (CRUD-Anwendung)
Außerdem soll man einen Eintrag suchen können.
Die Funktionalität reicht, es muss nicht optisch ansprechend sein.

###Voraussetzungen:

* Web-Applikation
* SpringBoot-Applikation mit H2-DB

-----------------------------

### Installieren:

    git clone https://github.com/pavellezin/telefonbuch

### Ausführung (aus dem Projektverzeichnis):

    $ mvn spring-boot:run

### oder

    $ mvn clean package
    $ java -Dfile.encoding=UTF8 -jar target/telefonbuch.jar

- <a href="http://localhost:8082/">H2 console</a>
- User: `sa`, no password
- JDBC URL: `jdbc:h2:mem:telefonbuch`
- Remote connection URL: `jdbc:h2:tcp://localhost:9092/mem:telefonbuch`

### SoapUI Projekt

Aus dem Projektverzeichnis: `telefonbuch-soapui-project.xml`

