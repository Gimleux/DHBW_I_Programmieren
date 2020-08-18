package de.dhbwka.java.exercise.swing.scriptExamples;

import javax.swing.*;

public class MenuDemo1 extends JFrame {
    private JMenuItem newMenu, quit, info;

    public MenuDemo1(String title) {
        super(title);
        JMenuBar menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenu file = new JMenu("File");
        JMenu help = new JMenu("Help");
        menuBar.add(file);
        menuBar.add(help);
        this.newMenu = new JMenuItem("New");
        file.add(this.newMenu);
        this.quit = new JMenuItem("Quit");
        file.add(this.quit);
        this.info = new JMenuItem("Info");
        help.add(this.info);

        this.setSize(300,200);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new MenuDemo1("Example menu");
    }
}
