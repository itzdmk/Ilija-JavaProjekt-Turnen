package gui;

/**
 * Aufzählung für Turngeräte.
 * Diese Enum-Klasse bietet die möglichen Wettkampfgeräte der Anwendung.
 */
public enum Geraet {
    BODEN("Boden"),
    PAUSCHENPFERD("Pauschenpferd"),
    RINGE("Ringe"),
    SPRUNG("Sprung"),
    BARREN("Barren"),
    RECK("Reck");

    private final String name;

    /**
     * Speichert die Anzeigeform des Geräts.
     * @param name Anzeigename
     */
    Geraet(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
