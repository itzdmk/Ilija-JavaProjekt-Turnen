# Abwehrtext fr das Projekt "Turn-Bewertungsrechner PRO"

## Einleitung (ca. 45 Sekunden)
Ich prsentiere hier mein Java-Projekt "Turn-Bewertungsrechner PRO". Ziel war es, eine klassische objektorientierte Anwendung fr eine Turnwertung zu bauen. Die Anwendung ermglicht die Eingabe von Athletendaten, D- und E-Note, sowie Abzgen, und berechnet daraus eine Endnote.

## Architektur und Struktur (ca. 90 Sekunden)
Das Projekt folgt dem MVC-Prinzip: die Klasse `MainWindow` bildet die View, `TurnenController` verbindet Benutzeroberflche und Modell, und `TurnenModel` speichert die Bewertungsdaten. Zustzlich habe ich eine abstrakte Basisklasse `Bewertung` erstellt, die gemeinsame Bewertungsvorgnge kapselt. Damit zeige ich Vererbung und Polymorphie:
- `Bewertung` definiert den Abzug und die Berechnung der Endnote,
- `TurnenModel` erbt von `Bewertung` und implementiert die konkrete Basisnote.

## Wichtige Klassen und Rollen (ca. 90 Sekunden)
- `Athlet`: Kapselt Name und Geschlecht, mit Validierung der Eingaben.
- `Geraet`: Enum mit allen Turngerten wie Boden, Pauschenpferd, Ringe.
- `TurnenModel`: Speichert Daten fr eine einzelne Bewertung und berechnet die Endnote.
- `TurnenController`: Liest die Eingaben aus der GUI, erstellt Modelle und aktualisiert die Tabelle.
- `MainWindow`: Stellt die GUI bereit, zeigt die Tabelle und den aktuellen Spitzenreiter.

## Erweiterungen gegen Benotungsanforderungen (ca. 70 Sekunden)
Fr die volle Punktzahl habe ich folgende Verbesserungen eingebaut:
- Dokumentation: alle Kernklassen besitzen Klassendokumentationen und kommentierte Methoden.
- OOP-Erweiterung: Durch die neue Klasse `Bewertung` und die Vererbungsstruktur ist eine erweiterte Objektorientierung vorhanden.
- Testbarkeit: Es gibt Unit-Tests fr die wichtigsten Modellregeln, inklusive Eingabevalidierung und Grenzwerte.
- Fehlerbehandlung: Schlecht formatierte Zahlen und falsche Eingaben werden sauber abgefangen.

## Ablauf der Anwendung (ca. 45 Sekunden)
Beim Start wird das Hauptfenster geffnet. Der Benutzer trgt Name, Geschlecht und Noten ein. Beim Klick auf "Wertung hinzufgen" erstellt der Controller ein neues `TurnenModel`. Dieses wird in einer Liste gespeichert und in der Tabelle angezeigt. Oben wird automatisch der derzeit beste Eintrag als Ergebnis angezeigt.

## Fazit (ca. 30 Sekunden)
Das Projekt zeigt sowohl die praktische Umsetzung einer GUI-Anwendung als auch die fachliche Strukturierung mit MVC und OOP. Die wichtigsten Anforderungen der Kopplung, Kapselung und Dokumentation sind erfllt. Damit ist es bereit fr die Abgabe und die Bewertung.
