package de.dhbwka.java.exercise.ui;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class TextfileViewer extends JFrame{
    public TextfileViewer(){
        this.setTitle("TextfileViewer");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        String path = getPath();

        if(path!=null) {
            File file = new File(path);
            String[] content;
            content = readFile(file);
            this.setLayout(new GridLayout(content.length, 1, 2, 0));

            for (int i = 0; i < content.length; i++) {
                this.add(new JLabel(content[i]));
            }
        } else {
            this.setLayout(new GridLayout(1,1));
            this.add(new JLabel("Keine Datei ausgewählt."));
        }
        this.pack();
        this.setVisible(true);
    }

    private String getPath(){
        JFileChooser fileChooser = new JFileChooser();
        int state = fileChooser.showOpenDialog(getParent());
        if(state == JFileChooser.APPROVE_OPTION){
            return fileChooser.getSelectedFile().getAbsolutePath();
        } else return null;
    }

    private String[] readFile(File file){
        String[] result;
        int length = 0;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
            while (bufferedReader.ready()){
                bufferedReader.readLine();
                length++;
            }
        } catch (Exception e){
            result = new String[1];
            result[0] = e.getMessage();
        }
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
            result = new String[length];
            for (int i = 0; i<result.length; i++){
                result[i] = bufferedReader.readLine();
            }
        } catch (Exception e){
            result = new String[1];
            result[0] = e.getMessage();
        }
        return result;
    }

    public static void main(String[] args) {
        new TextfileViewer();
    }
}
