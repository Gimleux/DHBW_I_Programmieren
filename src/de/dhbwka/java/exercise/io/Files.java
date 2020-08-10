package de.dhbwka.java.exercise.io;

import de.dhbwka.java.utilities.Input.OneLineInput;

import java.io.File;
import java.io.IOException;

public class Files {
    public Files() {
    }

    public void createFiles() {
        String path = "myDir";
        File file = new File(path);
        file.mkdir();
        for (int i = 1; i <= 3; i++) {
            file = new File(path, "foo" + i + ".txt");
            try {
                file.createNewFile();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
    }

    public void deleteFiles() {
        String path = "myDir";
        File file;
        for (int i = 1; i <= 3; i++) {
            file = new File(path, "foo" + i + ".txt");
            file.delete();
        }
        file = new File(path);
        file.delete();
    }

    public static void main(String[] args) {
        Files file = new Files();
        file.createFiles();
        OneLineInput.getStringValueOfDescriptionOneWay("beliebige Taste");
        file.deleteFiles();
    }
}