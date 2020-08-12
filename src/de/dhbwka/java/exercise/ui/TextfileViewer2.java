package de.dhbwka.java.exercise.ui;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class TextfileViewer2 extends JFrame{
    public TextfileViewer2(){
        this.setTitle("TextfileViewer");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        String path = getPath();
        this.setLayout(new BorderLayout());

        if(path!=null) {
            File file = new File(path);
            String content = readFile(file);
            System.out.println(content);
            this.add( new JScrollPane(new JTextArea(content)));
        } else {
            this.add(new JTextArea("Keine Datei ausgewählt."));
        }

        this.setSize(300,300);
        this.setVisible(true);
    }

    private String getPath(){
        JFileChooser fileChooser = new JFileChooser();
        int state = fileChooser.showOpenDialog(getParent());
        if(state == JFileChooser.APPROVE_OPTION){
            return fileChooser.getSelectedFile().getAbsolutePath();
        } else return null;
    }

    private String readFile(File file){
        StringBuilder result = new StringBuilder();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
            while (bufferedReader.ready()){
                result.append(bufferedReader.readLine()).append(System.lineSeparator());
            }
        } catch (Exception e){
            result.append(e.getMessage());
        }
        return result.toString();
    }

    public static void main(String[] args) {
        new TextfileViewer2();
    }
}
