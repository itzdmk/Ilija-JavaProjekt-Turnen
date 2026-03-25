package gui;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

// Hauptfenster der Anwendung
public class MainWindow extends JFrame {

    // Eingabefelder
    private JTextField txtName;
    private JTextField txtDNote;
    private JTextField txtENote;
    private JTextField txtAbzug;

    // Auswahl und Buttons
    private JComboBox<Geraet> cbGeraet;
    private JRadioButton rbMaennlich;
    private JRadioButton rbWeiblich;
    private JButton btnBerechnen;

    // Anzeige
    private JLabel lblErgebnis;

    // Tabelle für Ergebnisse
    private DefaultTableModel tableModel;
    private JTable tblErgebnisse;

    // Konstruktor baut die ganze Oberfläche
    public MainWindow() {
        setTitle("Turn-Bewertungsrechner PRO");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 700);

        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(10, 15, 10, 15));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 10));

        // Logo oben
        JLabel lblImage = new JLabel("");
        lblImage.setHorizontalAlignment(SwingConstants.CENTER);

        try {
            java.net.URL imgURL = getClass().getResource("Logo.png");
            if (imgURL != null) {
                ImageIcon originalIcon = new ImageIcon(imgURL);
                Image scaledImage = originalIcon.getImage().getScaledInstance(150, 80, Image.SCALE_SMOOTH);
                lblImage.setIcon(new ImageIcon(scaledImage));
            } else {
                lblImage.setText("LOGO FEHLT");
            }
        } catch (Exception e) {
            lblImage.setText("FEHLER BEIM BILDLADEN");
        }

        contentPane.add(lblImage, BorderLayout.NORTH);

        // Eingabebereich in der Mitte
        JPanel pnlInput = new JPanel(new GridBagLayout());
        contentPane.add(pnlInput, BorderLayout.CENTER);

        Font labelFont = new Font("Arial", Font.BOLD, 12);
        Insets gridInsets = new Insets(3, 5, 3, 5);

        // Name
        addGridLabel(pnlInput, "Athlet Name:", 0, 0, labelFont, gridInsets);
        txtName = new JTextField();
        addGridField(pnlInput, txtName, 1, 0, gridInsets);

        // Gerät Auswahl
        addGridLabel(pnlInput, "Gerät:", 0, 1, labelFont, gridInsets);
        cbGeraet = new JComboBox<>();
        cbGeraet.setModel(new DefaultComboBoxModel<>(Geraet.values()));
        addGridField(pnlInput, cbGeraet, 1, 1, gridInsets);

        // Geschlecht Auswahl
        addGridLabel(pnlInput, "Geschlecht:", 0, 2, labelFont, gridInsets);
        JPanel pnlGender = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));

        rbMaennlich = new JRadioButton("M");
        rbMaennlich.setSelected(true);

        rbWeiblich = new JRadioButton("W");

        ButtonGroup bg = new ButtonGroup();
        bg.add(rbMaennlich);
        bg.add(rbWeiblich);

        pnlGender.add(rbMaennlich);
        pnlGender.add(rbWeiblich);

        addGridField(pnlInput, pnlGender, 1, 2, gridInsets);

        // D-Note
        addGridLabel(pnlInput, "D-Note:", 0, 3, labelFont, gridInsets);
        txtDNote = new JTextField();
        addGridField(pnlInput, txtDNote, 1, 3, gridInsets);

        // E-Note
        addGridLabel(pnlInput, "E-Note:", 0, 4, labelFont, gridInsets);
        txtENote = new JTextField();
        addGridField(pnlInput, txtENote, 1, 4, gridInsets);

        // Abzug
        addGridLabel(pnlInput, "Abzug:", 0, 5, labelFont, gridInsets);
        txtAbzug = new JTextField("0.0");
        addGridField(pnlInput, txtAbzug, 1, 5, gridInsets);

        // Unterer Bereich
        JPanel pnlSouth = new JPanel();
        pnlSouth.setLayout(new BoxLayout(pnlSouth, BoxLayout.Y_AXIS));
        contentPane.add(pnlSouth, BorderLayout.SOUTH);

        // Button zum Berechnen
        btnBerechnen = new JButton("WERTUNG HINZUFÜGEN");
        btnBerechnen.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnBerechnen.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        btnBerechnen.setFont(new Font("Copperplate Gothic Light", Font.BOLD | Font.ITALIC, 15));
        btnBerechnen.setBackground(Color.ORANGE);
        btnBerechnen.setForeground(Color.BLACK);

        pnlSouth.add(btnBerechnen);
        pnlSouth.add(Box.createVerticalStrut(5));

        // Ergebnis Anzeige
        lblErgebnis = new JLabel("Warte auf Eingabe...");
        lblErgebnis.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblErgebnis.setFont(new Font("Arial", Font.BOLD, 14));

        pnlSouth.add(lblErgebnis);
        pnlSouth.add(Box.createVerticalStrut(5));

        // Tabelle
        String[] columnNames = {"Name", "Geschlecht", "Gerät", "Endnote"};
        tableModel = new DefaultTableModel(columnNames, 0);

        tblErgebnisse = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tblErgebnisse);
        scrollPane.setPreferredSize(new Dimension(480, 180));

        pnlSouth.add(scrollPane);
    }

    // Fügt ein Label ins Grid ein
    private void addGridLabel(JPanel pnl, String text, int x, int y, Font font, Insets insets) {
        JLabel lbl = new JLabel(text);
        lbl.setFont(font);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = insets;
        gbc.gridx = x;
        gbc.gridy = y;

        pnl.add(lbl, gbc);
    }

    // Fügt ein Eingabefeld ins Grid ein
    private void addGridField(JPanel pnl, Component comp, int x, int y, Insets insets) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        gbc.insets = insets;
        gbc.gridx = x;
        gbc.gridy = y;

        pnl.add(comp, gbc);
    }

    // Listener für Button hinzufügen
    public void addBerechnenListener(ActionListener listener) {
        btnBerechnen.addActionListener(listener);
    }

    // Getter Methoden für Eingaben
    public String getAthletName() {
        return txtName.getText();
    }

    public Geraet getGeraet() {
        return (Geraet) cbGeraet.getSelectedItem();
    }

    public String getGeschlecht() {
        return rbMaennlich.isSelected() ? "M" : "W";
    }

    public String getRawDNote() {
        return txtDNote.getText();
    }

    public String getRawENote() {
        return txtENote.getText();
    }

    public String getRawAbzug() {
        return txtAbzug.getText();
    }

    // Ergebnis setzen
    public void setErgebnis(String text) {
        lblErgebnis.setText(text);
    }

    // Neue Zeile zur Tabelle hinzufügen
    public void addRow(Object[] row) {
        tableModel.addRow(row);
    }

    // Tabelle leeren
    public void clearTable() {
        tableModel.setRowCount(0);
    }

    // Fehlermeldung anzeigen
    public void zeigeFehler(String message, String title) {
        JOptionPane.showMessageDialog(this, message, title, JOptionPane.ERROR_MESSAGE);
    }

    // Startpunkt des Programms
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        EventQueue.invokeLater(() -> {
            try {
                MainWindow frame = new MainWindow();
                new TurnenController(frame);
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}