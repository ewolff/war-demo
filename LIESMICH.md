Nanoservice WAR Demo
================

Dieses Projekt erzeugt eine VM mit der vollständigen Nanoservice-Demo in einem
Docker-Containern. Die Services sind mit Java und Spring Boot
implementiert.

Das System hat drei Nanoservices:
- Order um Bestellungen handzuhaben
- Customer für Kundendaten
- Catalog für die Waren

Jeder der Nanoservices ist eine WAR-Datei. Sie teilen sich einen
Tomcat server als Ablaufumgebung.


Ausführen
---------

- Installiere Maven, siehe https://maven.apache.org/download.cgi
- Installiere Docker, siehe https://docs.docker.com/installation/
- Installiere Virtual Box von
https://www.virtualbox.org/wiki/Downloads
- Intalliere Docker Machine, siehe https://docs.docker.com/machine/#installation
- Gehe zum Verzeichnis `war-demo`  und führe dort `mvn package` aus
- Führe `docker-machine create  --virtualbox-memory "4096" --driver
  virtualbox dev` aus. Das erzeugt eine neue Umgebung names`dev`mit Docker
  Machine. Es wird eine virtuelle Machine in Virtual Box mit 4GB RAM sein.
 - Führe `eval "$(docker-machine env dev)"` (Linux / Mac OS X) oder
    `docker-machine.exe env --shell powershell dev` (Windows,
    Powershell) /  `docker-machine.exe env --shell cmd dev` (Windows,
    cmd.exe) aus. Das docker Kommando nutzt nun die neue virtuelle
    Maschine als Umgebung.
- Gehe zum Verzeichnis `war-demo` und führe dort `docker build
  --tag=war-demo .` sowie `docker run -p 8080:8080 war-demo`  aus.

Das Ergebnis:

- Docker Machine erzeugt eine neue Virtual Box VN, auf der Docker
  installiert ist.
- Docker Images werden erzeugt und laufen in der VM.
-  Nutze `docker-machine ip dev` , um die IP-Addresse der VM herauszufinden.
- Du kannst die Anwendung unter http://ipadresss:8080/order/ ,
  http://ipadresss:8080/catalog/ und http://ipadresss:8080/customer/ ansprechen.

- Use `docker-machine rm dev` to löscht die virtuelle Maschine.
