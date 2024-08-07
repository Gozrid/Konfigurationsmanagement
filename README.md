# Konfigurationsmanagement

Beispiel für Konfigurationen auf dem Endsystem und mithilfe von GIT.

## Information

Die Aufgaben können lokal erledigt werden oder mithilfe eines Forks des Repos.

### Repo-Fork (empfohlen)

1. Fork (oben rechts) drücken
2. Reiter Actions aufrufen und auf den grünen Button drücken ("I understand...")

Hier muss einfach nur die Datei im Repo angepasst und committet werden.
Nach durchlaufen der GitHub Actions erhält man unter Releases (Reiter Code -> Rechte Seite) die JAR Datei.

### Lokal

Um die Maven Anwendung zu bauen (JAR erhalten) kann der Befehl
``./mvnw clean install --% -Dmaven.test.skip``
genutzt werden.

## Aufgabe 1
**Hintergrund**<br/>
*Ziel: Verwaltung von Konfigurationen durch VCS*<br/>
Wir haben ein JAVA-Backend entwickelt mit bereits eingerichteten DEV-Konfigurationen (`src/main/resources/application-dev.properties`)
und möchten dieses nun auf einen Test-Server deployen. Wir wollen die Konfiguration mithilfe des GIT-Repos versioniert haben.
- Die Anwendung soll den Port 39 nutzen
- Die Anwendung soll das Banner "Test-banner.txt" beim Start anzeigen
- Der Server soll Antworten "Testen..." [Controller - Swagger](http://localhost:39/swagger-ui/index.html#/prod-controller/saySomething)

**Vorgaben**<br/>
In der Konfiguration soll `server.type=test` und `server.name=Test-Server` sein.

**Tipps**<br/>
Nach durchlaufen der GitHub Actions kann die Anwendung heruntergeladen werden und mithilfe von
``java --% -jar -Dspring.profiles.active=test .\Konfigurationsmanagement.jar``
mit dem Test Profil gestartet werden.

<details>
<summary>Weitere Tipps</summary>
<ul>
<li>Die Konfigurationsdateien liegen unter `src/main/resources/application-dev.properties`</li>
<li>Es muss hier eine weitere config hinzugefügt werden ``application-test.properties``</li>
</ul>
</details>

## Aufgabe 2
**Hintergrund**<br/>
*Ziel: Anwendungsverhalten steuern durch Konfigurationen*<br/>
Die Tests mit den freiwilligen Personen sind gut verlaufen. Nun wollen wir die Anwendung komplett öffentlich schalten und
müssen dafür auf einen PROD-Server deployen.
Wir wollen die Konfiguration wieder im GIT-Repo versionieren.
- Die Anwendung soll den Port 80 nutzen
- Die Anwendung soll das Banner "PROD-banner.txt" beim Start anzeigen
- Der Server soll Antworten "Hallo Welt!" [Controller - Swagger](http://localhost:80/swagger-ui/index.html#/prod-controller/saySomething)
- Der Endpunkt /api/test/debug soll nicht verfügbar sein

**Vorgaben**<br/>
In der Konfiguration soll `server.name=Prod-Server` sein.

<details>
<summary><h2>Tipps</h2></summary>
<ul>
<li>Der Endpunkt /api/test/debug kann mithilfe von ``server.type`` umgestellt werden.</li>
<li> Der Start Befehl muss angepasst werden.</li>
</ul>
</details>

## Aufgabe 3
**Hintergrund**<br/>
*Ziel: Verwaltung von Konfigurationen auf Endsystemen*<br/>
Jemand würde gerne unsere Anwendung selber bereitstellen und hat uns gefragt,
ob wir ihm die Konfiguration und den notwendigen Befehl bereitstellen.
Wir haben für ihn ein Banner bereits hinzugefügt.
Er möchte die <u>Konfiguration gerne auf dem Server liegen haben</u> und per Befehl diese ausführen.
Seine Wünsche sind:
- Die Anwendung soll den Port 81 nutzen
- Die Anwendung soll das Banner "PROD2-banner.txt" beim Start anzeigen
- Der Server soll Antworten "Hallo Welt von Server 2!" [Controller - Swagger](http://localhost:81/swagger-ui/index.html#/prod-controller/saySomething)
- Der Endpunkt /api/test/debug soll nicht verfügbar sein

**Vorgaben**<br/>
In der Konfiguration soll `server.name=Prod2-Server` sein.

<details>
<summary><h2>Tipps</h2></summary>
<ul>
<li> Der Endpunkt /api/test/debug kann mithilfe von ``server.type`` umgestellt werden.</li>
<li> Der Start Befehl muss angepasst werden.</li>
<li> Konfigurationen werden auch neben der JAR akzeptiert.</li>
</ul>
</details>