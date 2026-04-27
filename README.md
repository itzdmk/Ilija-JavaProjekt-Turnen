# Turnen Projekt

Dies ist ein Java-Projekt für eine Turn-Bewertungsanwendung mit GUI, MVC-Struktur und Docker-Unterstützung.

## Inhalte
- `src/main/java/gui/` - Quellcode der Anwendung
- `src/test/java/` - Unit-Tests
- `Dockerfile` - Docker-Konfiguration zum Bauen und Ausführen der App
- `DOCKER_ANLEITUNG.md` - Schritt-für-Schritt-Anleitung für Docker
- `ABWEHRTEXT.md` - vorbereiteter Abwehrtext für die Projektpräsentation

## Kurzbeschreibung
Die Anwendung erlaubt die Eingabe eines Athletennamens, Geschlechts, eines Geräts, einer D-Note, einer E-Note und eines Abzugs. Sie berechnet die Endnote, zeigt alle Ergebnisse in einer Tabelle und hebt den besten Beitrag hervor.

## Docker-Nutzung
Die vollständige Docker-Anleitung findest du in `DOCKER_ANLEITUNG.md`.

### Schnellstart
1. Image bauen:
   ```bash
   docker build -t turnen-app .
   ```
2. Container starten:
   ```bash
   docker run -d -p 5901:5901 -p 6080:6080 --name turnen-container turnen-app
   ```
3. Browser öffnen:
   ```text
   http://localhost:6080/vnc.html
   ```
4. Standard-Passwort: `password`

## Testen
Mit Maven kannst du die Tests ausführen:

```bash
mvn test
```

## Hinweis
Falls du den Container stoppen und entfernen möchtest:

```bash
docker stop turnen-container
```

```bash
docker rm turnen-container
```
