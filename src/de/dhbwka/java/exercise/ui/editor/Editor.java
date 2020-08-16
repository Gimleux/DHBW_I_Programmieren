package de.dhbwka.java.exercise.ui.editor;

import de.dhbwka.java.exercise.ui.EditorSimple;
import de.dhbwka.java.utilities.files.read.wholeTextFiles.FileToString;
import de.dhbwka.java.utilities.files.write.overwrite.OverwriteFileWithString;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;

public class Editor {
    private JFrame frame;
    private JTextPane textArea;
    private JMenu fileMenu;
    private JMenu editMenu;
    private String pathname;
    private ActionClassFilesMenu actionClassFilesMenu = new ActionClassFilesMenu();
    private ActionClassEditMenu actionClassEditMenu = new ActionClassEditMenu();
    private final String HORIZONTAL_RULER = "__";
    private final String SEND_MENU = "SENDMENU";
    private final String MENU_TITLE_FILES = "Datei";
    private final String MENU_TITLE_EDIT = "Bearbeiten";
    private final String MENU_TITLE_SEND = "Senden an...";

    private final String[] filesMenuItems = {"Neu", "Öffnen", HORIZONTAL_RULER, "Schlie\u00DFen", HORIZONTAL_RULER, "Speichern", "Speichern unter...", "Als Webseite speichern", "Suchen", HORIZONTAL_RULER, "Versionen", HORIZONTAL_RULER, "Webseitenvorschau", HORIZONTAL_RULER, "Seite einrichten...", "Seitenansicht", "Drucken", HORIZONTAL_RULER, SEND_MENU, "Eigenschaften", HORIZONTAL_RULER, "bilanz_2017.doc", "bericht_2018_01.doc", "ziele.doc", HORIZONTAL_RULER, "Beenden"};
    private final int NEW_MENU = 0;
    private final int OPEN_MENU = 1;
    private final int CLOSE_MENU = 3;
    private final int SAVE_MENU = 5;
    private final int SAVEAS_MENU = 6;
    private final int EXIT_MENU = 25;

    private final String[] editMenuItems = {"Rückgängig", "Wiederholen", HORIZONTAL_RULER, "Ausschneiden", "Kopieren", "Office-Zwischenablage", "Einfügen", "Inhalte einfügen", "Als Hyperlink einfügen", HORIZONTAL_RULER, "Löschen", "Alles markieren", HORIZONTAL_RULER, "Suchen...", "Ersetzen...", "Gehe zu...", HORIZONTAL_RULER, "Verknüpfungen...", "Objekt"};

    private final String[] sendMenuItems = {"E-Mail-Empfpänger", "E-Mail-Empfänger (zur Überarbeitung)", "E-Mail-Empfänger (als Anlage)", HORIZONTAL_RULER, "Verteilerempfänger...", "Onlinebesprechungsteilnehmer", "Exchange-Ordner...", "Fax-Empfänger...", HORIZONTAL_RULER, "Microsoft PowerPoint"};

    public Editor() {
        frame = new JFrame("Editor");

        //Add Menus
        frame.add(getMenuBar(), BorderLayout.NORTH);
        //Add Content
        frame.add(getContentPane(), BorderLayout.CENTER);

        //Set size and show
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(640, 480);
        frame.setVisible(true);
    }

    private JScrollPane getContentPane() {
        textArea = new JTextPane();
        textArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));

        //Return mit Scroll Bar
        return new JScrollPane(textArea);
    }

    private JMenuBar getMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        //Create all Menus
        fileMenu = getMenu(MENU_TITLE_FILES, KeyEvent.VK_D, filesMenuItems);
        editMenu = getMenu(MENU_TITLE_EDIT, KeyEvent.VK_B, editMenuItems);
        menuBar.add(fileMenu);
        menuBar.add(editMenu);

        //Special MenuItems
        int[] enabledMenuItems = {NEW_MENU, OPEN_MENU, EXIT_MENU};
        for (int menuItemIdentifier : enabledMenuItems) {
            JMenuItem menuItem = fileMenu.getItem(menuItemIdentifier);
            menuItem.setEnabled(true);
            menuItem.setAccelerator(KeyStroke.getKeyStroke("control " + menuItem.getText().charAt(0)));
        }
        //Add special shortcuts (that cannot be handled by for-loop)
        JMenuItem saveMenuItem;
        saveMenuItem = fileMenu.getItem(SAVE_MENU);
        saveMenuItem.setAccelerator(KeyStroke.getKeyStroke("control S"));
        saveMenuItem = fileMenu.getItem(OPEN_MENU);
        saveMenuItem.setAccelerator(KeyStroke.getKeyStroke("control O"));

        return menuBar;
    }

    /**
     * Produces a JMenu with items for given String[]
     *
     * @param title    name of Menu
     * @param mnemonic for Menu (KeyEvent.VK_ + 1st Letter of title)
     * @param content  String[] with Labels of MenuItems
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
                    menu.add(getMenu(MENU_TITLE_SEND, KeyEvent.VK_S, sendMenuItems));
                    break;
                default:
                    addMenuItem(menu, s);
            }
        }
        return menu;
    }

    private void addMenuItem(JMenu menu, String content) {
        JMenuItem menuItem = new JMenuItem(content);
        if (menu.getText().equals(MENU_TITLE_FILES) || menu.getText().equals(MENU_TITLE_SEND)) {
            menuItem.addActionListener(this.actionClassFilesMenu);
        } else {
            menuItem.addActionListener(this.actionClassEditMenu);
        }
        menuItem.setName(content);
        menuItem.setEnabled(false);
        menu.add(menuItem);
    }

    public static void main(String[] args) {
        new Editor();
    }

    ///////////////////////////////////////////////////////////////////////////
    // Action Class Events - Files Menu
    ///////////////////////////////////////////////////////////////////////////

    class ActionClassFilesMenu implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JMenuItem src = ((JMenuItem) e.getSource());
            //NEW
            if (src.equals(fileMenu.getItem(NEW_MENU))) {
                newMenuEvent();
            }
            //OPEN
            else if (src.equals(fileMenu.getItem(OPEN_MENU))) {
                openMenuEvent();
            }
            //SAVE
            else if (src.equals(fileMenu.getItem(SAVE_MENU))) {
                saveMenuEvent();
            }
            //EXIT
            else if (src.equals(fileMenu.getItem(EXIT_MENU))) {
                exitMenuEvent();
            }
        }

        //Save before close
        private boolean saveChangesDialogAndCloseFile() {
            if (pathname != null && !pathname.equals("")) {
                int result = JOptionPane.showConfirmDialog(frame, "Do you want to save your changes?");
                if (result == 0) {
                    //Yes
                    saveMenuEvent();
                    return true;
                } else if (result == 1) {
                    //No
                    return true;
                } else if (result == 2) {
                    //Cancel
                    return false;
                }
            }
            //No open file
            return true;
        }

        //NEW
        private void newMenuEvent() {
            if (saveChangesDialogAndCloseFile()) {
                textArea.setText("");
                pathname = "";
                fileMenu.getItem(SAVE_MENU).setEnabled(false);
            }
        }

        //OPEN
        private void openMenuEvent() {
            if (saveChangesDialogAndCloseFile()) {
                if (openFile()) {
                    fileMenu.getItem(SAVE_MENU).setEnabled(true);
                }
            }
        }

        private boolean openFile() {
            String path = getFilePath();
            if (path != null) {
                pathname = path;
                String fileContent = FileToString.getFileToString_WithErrorDescription(new File(pathname));
                textArea.setText(fileContent);
                return true;
            }
            return false;
        }

        private String getFilePath() {
            JFileChooser fileChooser = new JFileChooser();
            int state = fileChooser.showOpenDialog(null);
            if (state == JFileChooser.APPROVE_OPTION) {
                return fileChooser.getSelectedFile().getAbsolutePath();
            } else return null;
        }

        //SAVE
        private void saveMenuEvent() {
            OverwriteFileWithString.overwriteFileWithString_WithErrorDescription(pathname, textArea.getText());
        }

        //EXIT
        private void exitMenuEvent() {
            if (saveChangesDialogAndCloseFile()) {
                System.exit(0);
            }
        }
    }


    ///////////////////////////////////////////////////////////////////////////
    // Action Class Events - Edit Menu
    ///////////////////////////////////////////////////////////////////////////
    class ActionClassEditMenu implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
}