package de.dhbwka.java.exercise.swing.basics;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.io.File;

public class JFileChooserDemo {
    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory() || pathname.getName().toLowerCase().endsWith(".txt");
            }
            public String getDescription(){
                return "Text Files";
            }
        });
        int state = fileChooser.showOpenDialog(null); //Variante öffnen/zeigen
//        int state = fileChooser.showSaveDialog(null); //Variante speichern
//        int state = fileChooser.showDialog(null, "Delete"); //freie Variante

        if(state == JFileChooser.APPROVE_OPTION){
            System.out.println(fileChooser.getSelectedFile().getAbsolutePath());
        } else {
            System.out.println("No Selection");
        }
    }
}
