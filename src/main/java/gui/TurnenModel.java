package gui;

/**
 * Modelliert eine Turnen-Bewertung mit Athlet, Gert und Noten.
 * Diese Klasse vererbt von Bewertung, um Polymorphie zu demonstrieren.
 */
public class TurnenModel extends Bewertung {
    private final Athlet athlet;
    private final Geraet geraet;
    private final double dNote;
    private final double eNote;

    /**
     * Erstellt ein neues Turnen-Modell und prft die Eingaben.
     *
     * @param athlet der Athlet
     * @param geraet das Gert
     * @param dNote  D-Note
     * @param eNote  E-Note
     * @param abzug  Abzug in Punkten
     */
    public TurnenModel(Athlet athlet, Geraet geraet, double dNote, double eNote, double abzug) {
        super(abzug);

        if (athlet == null) {
            throw new IllegalArgumentException("Athlet darf nicht null sein.");
        }
        if (geraet == null) {
            throw new IllegalArgumentException("Geraet darf nicht null sein.");
        }
        if (dNote < 0) {
            throw new IllegalArgumentException("D-Note darf nicht negativ sein.");
        }
        if (eNote < 0 || eNote > 10) {
            throw new IllegalArgumentException("E-Note muss zwischen 0 und 10 liegen.");
        }

        this.athlet = athlet;
        this.geraet = geraet;
        this.dNote = dNote;
        this.eNote = eNote;
    }

    @Override
    protected double berechneBasisnote() {
        return dNote + eNote;
    }

    @Override
    public String getBeschreibung() {
        return String.format("%s, %s: D=%.2f, E=%.2f, Abzug=%.2f", athlet.getName(), geraet, dNote, eNote, getAbzug());
    }

    /**
     * Gibt den Athleten zurck.
     * @return Athlet
     */
    public Athlet getAthlet() {
        return athlet;
    }

    /**
     * Gibt das gewhlte Gert zurck.
     * @return Gert
     */
    public Geraet getGeraet() {
        return geraet;
    }
}
