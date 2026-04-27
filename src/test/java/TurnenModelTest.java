package gui;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Testklasse für TurnenModel und die Vererbungsstruktur.
 */
public class TurnenModelTest {

    @Test
    public void testKorrekteBerechnung() {
        Athlet athlet = new Athlet("TestAthlet", "M");
        TurnenModel model = new TurnenModel(athlet, Geraet.BODEN, 5.0, 8.5, 0.5);

        assertEquals(13.0, model.berechneEndnote(), 0.001);
        assertTrue(model instanceof Bewertung);
        assertTrue(model.getBeschreibung().contains("TestAthlet"));
    }

    @Test
    public void testNegativeEndnoteAbfangen() {
        Athlet athlet = new Athlet("TestAthlet", "M");
        TurnenModel model = new TurnenModel(athlet, Geraet.BODEN, 1.0, 1.0, 5.0);

        assertEquals(0.0, model.berechneEndnote(), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullAthlet() {
        new TurnenModel(null, Geraet.BODEN, 5.0, 8.0, 0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeNote() {
        Athlet athlet = new Athlet("TestAthlet", "M");
        new TurnenModel(athlet, Geraet.BODEN, 5.0, -1.0, 0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testZuHoheNote() {
        Athlet athlet = new Athlet("TestAthlet", "M");
        new TurnenModel(athlet, Geraet.BODEN, 5.0, 11.0, 0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeDNote() {
        Athlet athlet = new Athlet("TestAthlet", "M");
        new TurnenModel(athlet, Geraet.BODEN, -1.0, 8.0, 0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativerAbzug() {
        Athlet athlet = new Athlet("TestAthlet", "M");
        new TurnenModel(athlet, Geraet.BODEN, 5.0, 8.0, -0.5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLeererName() {
        new Athlet("  ", "M");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFalschesGeschlecht() {
        new Athlet("Test", "X");
    }

    @Test
    public void testBerechnungGrenzwertNull() {
        Athlet athlet = new Athlet("Test", "W");
        TurnenModel model = new TurnenModel(athlet, Geraet.SPRUNG, 0.0, 0.0, 10.0);
        assertEquals(0.0, model.berechneEndnote(), 0.001);
    }
}
