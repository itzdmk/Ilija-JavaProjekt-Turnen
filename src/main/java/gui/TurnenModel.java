package gui;

public class TurnenModel {
    private Athlet athlet;
    private Geraet geraet;
    private double dNote;
    private double eNote;
    private double abzug;

    // Erstellt ein neues Modell und prüft, ob die Eingaben gültig sind
    public TurnenModel(Athlet athlet, Geraet geraet, double dNote, double eNote, double abzug) {
        // Verhindert leere Datenfelder für Athlet und Gerät
        if (athlet == null) {
            throw new IllegalArgumentException("Athlet darf nicht null sein.");
        }
        if (geraet == null) {
            throw new IllegalArgumentException("Geraet darf nicht null sein.");
        }
        // Verhindert negative Werte, wo sie keinen Sinn ergeben
        if (dNote < 0) {
            throw new IllegalArgumentException("D-Note darf nicht negativ sein.");
        }
        if (abzug < 0) {
            throw new IllegalArgumentException("Abzug darf nicht negativ sein.");
        }
        // Die E-Note muss zwingend in diesem Bereich liegen
        if (eNote < 0 || eNote > 10) {
            throw new IllegalArgumentException("E-Note muss zwischen 0 und 10 liegen.");
        }

        this.athlet = athlet;
        this.geraet = geraet;
        this.dNote = dNote;
        this.eNote = eNote;
        this.abzug = abzug;
    }

    // Rechnet D-Note und E-Note zusammen und zieht Abzüge ab
    public double berechneEndnote() {
        double endnote = dNote + eNote - abzug;
        // Das Ergebnis darf niemals kleiner als 0 sein
        return Math.max(endnote, 0.0);
    }

    // Gibt den Athleten zurück
    public Athlet getAthlet() {
        return athlet;
    }

    // Gibt das Gerät zurück
    public Geraet getGeraet() {
        return geraet;
    }
}