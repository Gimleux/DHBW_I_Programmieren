package de.dhbwka.java.utilities.files.write.overwrite;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class OverwriteFileWithString {
    ///////////////////////////////////////////////////////////////////////////
    // Overwrite File With String - With Error Message
    ///////////////////////////////////////////////////////////////////////////
    /**
     * Overwrite file with given text
     * @param pathname String with path to file in which the text shall be written
     * @param text text that shall be written in file
     * @return String with error message or null if no error
     */
    public static String overwriteFileWithString_WithErrorDescription(String pathname, String text){
        return overwriteFileWithString_WithErrorDescription(new File(pathname), text);
    }

    /**
     * Append given text to given file
     * @param file to which the text shall be appended
     * @param text text that shall be written in file
     * @return String with error message or null if no error
     */
    public static String overwriteFileWithString_WithErrorDescription(File file, String text){
        return overwriteContentWithErrorDescription(file, text);
    }

    /**
     * Overwrite file with given text
     * @param pathname String with path to file in which the text shall be written
     * @param text text that shall be written in file
     * @return String with error message or null if no error
     */
    public static void overwriteFileWithString_WithException(String pathname, String text) throws IOException {
        overwriteFileWithString_WithException(new File(pathname), text);
    }

    /**
     * Append given text to given file
     * @param file to which the text shall be appended
     * @param text text that shall be written in file
     * @return String with error message or null if no error
     */
    public static void overwriteFileWithString_WithException(File file, String text) throws IOException {
        overwriteContentWithException(file, text);
    }

    private static String overwriteContentWithErrorDescription(File file, String content){
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))){
            bufferedWriter.write(content);
            bufferedWriter.close();
            return null;
        } catch (IOException e){
            return e.getMessage();
        }
    }

    private static void overwriteContentWithException(File file, String content) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write(content);
        bufferedWriter.close();
    }
}
