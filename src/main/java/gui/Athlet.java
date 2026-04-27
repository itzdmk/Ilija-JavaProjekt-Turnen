package gui;

public class Athlet {
    private String name;
    private String geschlecht;

    // Erstellt einen Athleten und prüft die Angaben
    public Athlet(String name, String geschlecht) {
        // Prüft, ob der Name leer ist oder nur aus Leerzeichen besteht
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Athletenname darf nicht leer sein.");
        }
        // Erlaubt nur 'M' (Männlich) oder 'W' (Weiblich)
        if (!geschlecht.equals("M") && !geschlecht.equals("W")) {
            throw new IllegalArgumentException("Geschlecht muss 'M' oder 'W' sein.");
        }
        this.name = name;
        this.geschlecht = geschlecht;
    }

    // Liefert den Namen zurück
    public String getName() {
        return name;
    }

    // Liefert das Geschlecht zurück
    public String getGeschlecht() {
        return geschlecht;
    }
}