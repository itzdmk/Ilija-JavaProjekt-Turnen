# Docker-Anleitung für das Projekt

Diese Datei erklärt dir, wie du das Docker-Image baust, den Container startest und die Anwendung nutzt.

## Voraussetzungen
- Docker muss auf deinem System installiert sein.
- Wenn du in VS Code / Codespaces arbeitest, stelle sicher, dass Port-Weiterleitungen für `6080` aktiviert sind.

## Image bauen
Führe im Projektverzeichnis (dort, wo `Dockerfile` und `pom.xml` liegen) folgenden Befehl aus:

```bash
docker build -t turnen-app .
```

Dieser Befehl erstellt das Docker-Image `turnen-app`.

## Container starten
Starte den Container mit den Ports für VNC und noVNC:

```bash
docker run -d -p 5901:5901 -p 6080:6080 --name turnen-container turnen-app
```

- `-d`: startet den Container im Hintergrund
- `-p 5901:5901`: öffnet den normalen VNC-Port
- `-p 6080:6080`: öffnet den noVNC-Webzugang
- `--name turnen-container`: Name des Containers

## Anwendung im Browser öffnen
Die Anwendung läuft im Container über noVNC. Öffne im Browser:

```text
http://localhost:6080/vnc.html
```

Damit kommst du direkt zur noVNC-Oberfläche und kannst die Anwendung im Browser bedienen.

### Passwort
- Standard-Passwort: `password`

Wenn du das Passwort ändern möchtest, kannst du den Container mit der Umgebungsvariable `VNC_PASSWORD` starten:

```bash
docker run -d -p 5901:5901 -p 6080:6080 -e VNC_PASSWORD=meinPasswort --name turnen-container turnen-app
```

## Alternative: normaler VNC-Client
Falls du statt des Browsers einen VNC-Client nutzen willst, verbinde ihn mit:

```text
localhost:5901
```

## Logs und Kontrolle
Falls etwas nicht funktioniert, kannst du die Container-Logs prüfen:

```bash
docker logs turnen-container
```

Um eine interaktive Shell im Container zu öffnen:

```bash
docker exec -it turnen-container bash
```

## Container stoppen und entfernen
Stoppe den Container:

```bash
docker stop turnen-container
```

Entferne den Container:

```bash
docker rm turnen-container
```

## Hinweise für Codespaces / VS Code
- Wenn du in einem Codespace arbeitest, musst du möglicherweise Port `6080` in der Ports-Ansicht weiterleiten.
- Danach kannst du `http://localhost:6080/vnc.html` in VS Code öffnen.

## Zusammenfassung
1. `docker build -t turnen-app .`
2. `docker run -d -p 5901:5901 -p 6080:6080 --name turnen-container turnen-app`
3. Browser öffnen: `http://localhost:6080/vnc.html`
4. Standard-Passwort: `password`

Viel Erfolg beim Starten der Anwendung!