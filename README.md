###Testaufgabe von Pavel Lezin

----------------------------

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
- User: `sa`, kein Passwort
- JDBC URL: `jdbc:h2:mem:telefonbuch`
- Fernverbindung URL: `jdbc:h2:tcp://localhost:9092/mem:telefonbuch`

### SoapUI Projekt

Aus dem Projektverzeichnis: `telefonbuch-soapui-project.xml`

-----------------------------

### Person CRUD


- <a href="http://localhost:8080/api/persons">Liste der Personen</a>
- <a href="http://localhost:8080/api/persons/1">Person 1</a>
- <a href="http://localhost:8080/api/persons/search/by-name?name=Vlad">Suche mit Name: Vlad</a>

CURL:

    curl 'http://localhost:8080/api/persons' -i
    curl 'http://localhost:8080/api/persons/1' -i
    curl -X POST 'http://localhost:8080/api/persons' -H "Content-Type: application/json" -d '{"name":"Santa Claus"}'
    curl -X PATCH 'http://localhost:8080/api/persons/3' -H "Content-Type: application/json" -d '{"name":"Donald Trump"}'
    curl -X DELETE 'http://localhost:8080/api/persons/4'
    curl 'http://localhost:8080/api/persons/search/by-name?name=Vlad' -i


### Telefon CRUD


- <a href="http://localhost:8080/api/phones">Telefonliste</a>
- <a href="http://localhost:8080/api/phones/1">Telefon 1</a>
- <a href="http://localhost:8080/api/phones/search/by-number?number=80">Suche nach Nummer: 80</a>

CURL:

    curl 'http://localhost:8080/api/phones' -i
    curl 'http://localhost:8080/api/phones/1' -i
    curl -X POST 'http://localhost:8080/api/phones' -H "Content-Type: application/json" -d '{"person":"http://localhost:8080/api/persons/1","code":"49","number":"012345678"}'
    curl -X PATCH 'http://localhost:8080/api/phones/3' -H "Content-Type: application/json" -d '{"number":"800800200"}'
    curl -X DELETE 'http://localhost:8080/api/phones/4'
    curl 'http://localhost:8080/api/phones/search/by-number?number=80' -i


