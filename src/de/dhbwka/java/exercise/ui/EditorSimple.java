package de.dhbwka.java.exercise.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class EditorSimple {
    private final String HORIZONTAL_RULER = "__";
    private final String SEND_MENU = "SENDMENU";

    private final String[] filesMenuItems = {"Neu", "Öffnen", HORIZONTAL_RULER, "Schlie\u00DFen", HORIZONTAL_RULER, "Speichern", "Speichern unter...", "Als Webseite speichern", "Suchen", HORIZONTAL_RULER, "Versionen", HORIZONTAL_RULER, "Webseitenvorschau", HORIZONTAL_RULER, "Seite einrichten...", "Seitenansicht", "Drucken", HORIZONTAL_RULER, SEND_MENU, "Eigenschaften", HORIZONTAL_RULER, "bilanz_2017.doc", "bericht_2018_01.doc", "ziele.doc", HORIZONTAL_RULER, "Beenden"};

    private final String[] editMenuItems = {"Rückgängig", "Wiederholen", HORIZONTAL_RULER, "Ausschneiden", "Kopieren", "Office-Zwischenablage", "Einfügen", "Inhalte einfügen", "Als Hyperlink einfügen", HORIZONTAL_RULER, "Löschen", "Alles markieren", HORIZONTAL_RULER, "Suchen...", "Ersetzen...", "Gehe zu...", HORIZONTAL_RULER, "Verknüpfungen...", "Objekt"};

    private final String[] sendMenuItems = {"E-Mail-Empfpänger", "E-Mail-Empfänger (zur Überarbeitung)", "E-Mail-Empfänger (als Anlage)", HORIZONTAL_RULER, "Verteilerempfänger...", "Onlinebesprechungsteilnehmer", "Exchange-Ordner...", "Fax-Empfänger...", HORIZONTAL_RULER, "Microsoft PowerPoint"};

    public EditorSimple() {
        JFrame frame = new JFrame();
        frame.setTitle("Simple Editor");

        //Add Menus
        frame.add(getMenuBar(), BorderLayout.NORTH);
        //Add Content
        frame.add(getContent(), BorderLayout.CENTER);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(640, 500);
        frame.setVisible(true);
    }

    private JScrollPane getContent() {
        JPanel content = new JPanel();
        content.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));

        // Return mit Scroll Bar
        return new JScrollPane(content);
    }

    private JMenuBar getMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(getMenu("Datei", KeyEvent.VK_D, filesMenuItems));
        menuBar.add(getMenu("Bearbeiten", KeyEvent.VK_B, editMenuItems));

        return menuBar;
    }

    /**
     * Produces a JMenu with items for given String[]
     * @param title name of Menu
     * @param mnemonic for Menu (KeyEvent.VK_ + 1st Letter of title)
     * @param content String[] with Labels of MenuItems
     * @return JMenu
     */
    private JMenu getMenu(String title, int mnemonic, String[] content) {
        JMenu menu = new JMenu(title);
        menu.setMnemonic(mnemonic);
        for (String s : content) {
            switch (s) {
                case HORIZONTAL_RULER:
                    menu.add(new JSeparator());
                    break;
                case SEND_MENU:
                    menu.add(getMenu("Senden an", KeyEvent.VK_S, sendMenuItems));
                    break;
                default:
                    menu.add(s);
            }
        }
        return menu;
    }

    //TODO: Erste Listener siehe 20_Swing Aufgaben 2(3)

    public static void main(String[] args) {
        new EditorSimple();
    }
}
