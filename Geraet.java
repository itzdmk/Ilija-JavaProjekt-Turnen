package gui;

public enum Geraet {
    // Das sind die erlaubten Geräte
    BODEN("Boden"),
    PAUSCHENPFERD("Pauschenpferd"),
    RINGE("Ringe"),
    SPRUNG("Sprung"),
    BARREN("Barren"),
    RECK("Reck");

    private final String name;

    // Speichert den schönen Namen für das Gerät (z.B. "Pauschenpferd")
    Geraet(String name) {
        this.name = name;
    }

    // Sorgt dafür, dass in der Tabelle "Boden" steht statt "BODEN"
    public String toString() {
        return name;
    }
}