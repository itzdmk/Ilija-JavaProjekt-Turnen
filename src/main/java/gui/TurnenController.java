package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Steuert die Interaktion zwischen GUI und Modell.
 * Der Controller liest Eingaben aus, erstellt Modelle und aktualisiert die Ansicht.
 */
public class TurnenController {

    private MainWindow view; // Referenz auf das Hauptfenster (GUI)
    private List<TurnenModel> wettkampfListe = new ArrayList<>(); // Liste zur Speicherung aller Ergebnisse

public TurnenController(MainWindow view) {
    this.view = view; // Initialisiert die View
    this.view.addBerechnenListener(new BerechnenListener()); // Registriert den Klick-Event für den Button
}

private class BerechnenListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        try {
            // Daten aus den Eingabefeldern der GUI auslesen
            String name = view.getAthletName();
            String geschlecht = view.getGeschlecht();
            Geraet geraet = view.getGeraet();
            
            String rawDNote = view.getRawDNote();
            String rawENote = view.getRawENote();
            String rawAbzug = view.getRawAbzug();

            // Text-Eingaben in Zahlen umwandeln
            double dNote = parseNote(rawDNote);
            double eNote = parseNote(rawENote);
            double abzug = parseNote(rawAbzug);

            // Datenobjekte erstellen und in der Liste speichern
            Athlet athlet = new Athlet(name, geschlecht);
            TurnenModel model = new TurnenModel(athlet, geraet, dNote, eNote, abzug);
            
            wettkampfListe.add(model);
            updateDisplay(); // Anzeige in der GUI aktualisieren

        } catch (NumberFormatException ex) {
            // Fehler bei falscher Zahleneingabe anzeigen
            view.zeigeFehler("Ungültiges Zahlenformat. Bitte numerische Werte eingeben.", "Formatfehler");
        } catch (IllegalArgumentException ex) {
            // Sonstige Logikfehler anzeigen
            view.zeigeFehler(ex.getMessage(), "Eingabefehler");
        }
    }
}

private double parseNote(String input) throws NumberFormatException {
    // Prüft auf leere Felder und ersetzt Komma durch Punkt für die Umwandlung
    if (input == null || input.trim().isEmpty()) {
        throw new NumberFormatException("Leere Eingabe");
    }
    return Double.parseDouble(input.replace(",", "."));
}

private void updateDisplay() {
    view.clearTable(); // Tabelle in der GUI leeren
    
    // Alle gespeicherten Ergebnisse in die Tabelle schreiben
    for (TurnenModel m : wettkampfListe) {
        view.addRow(new Object[]{
            m.getAthlet().getName(),
            m.getAthlet().getGeschlecht(),
            m.getGeraet().toString(),
            String.format("%.3f", m.berechneEndnote())
        });
    }

    // Den Teilnehmer mit der höchsten Endnote finden
    TurnenModel sieger = wettkampfListe.stream()
            .max(Comparator.comparingDouble(TurnenModel::berechneEndnote))
            .orElse(null);

    // Bestenliste/Sieger in der GUI anzeigen
    if (sieger != null) {
        view.setErgebnis(String.format("1. Platz: %s (%.3f)", 
            sieger.getAthlet().getName(), sieger.berechneEndnote()));
    }
}
}