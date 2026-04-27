package gui;

/**
 * Abstrakte Basisklasse für eine Bewertungsaufgabe.
 * Sie kapselt den gemeinsamen Abzugswert und stellt eine Basisstruktur
 * für verschiedene Bewertungsarten bereit.
 */
public abstract class Bewertung {
    private final double abzug;

    /**
     * Erzeugt eine Bewertung mit diesem Abzug.
     * @param abzug der Abzug in Punkten; darf nicht negativ sein.
     */
    public Bewertung(double abzug) {
        if (abzug < 0) {
            throw new IllegalArgumentException("Abzug darf nicht negativ sein.");
        }
        this.abzug = abzug;
    }

    /**
     * Liefert den Abzug für diese Bewertung zurück.
     * @return Abzug in Punkten
     */
    public double getAbzug() {
        return abzug;
    }

    /**
     * Berechnet die Basisnote ohne Abzüge.
     * @return Basisnote
     */
    protected abstract double berechneBasisnote();

    /**
     * Berechnet die Endnote inklusive Abzug.
     * Negative Werte werden automatisch auf 0 begrenzt.
     * @return Endnote
     */
    public double berechneEndnote() {
        return Math.max(berechneBasisnote() - abzug, 0.0);
    }

    /**
     * Beschreibt den Bewertungsfall für Debug und Anzeige.
     * @return Beschreibender Text zur Bewertung
     */
    public abstract String getBeschreibung();
}
