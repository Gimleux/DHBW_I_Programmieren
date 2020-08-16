package de.dhbwka.java.utilities.files.write.append;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AppendStringToFile {
    ///////////////////////////////////////////////////////////////////////////
    // Append String To File - With Error Message
    ///////////////////////////////////////////////////////////////////////////
    /**
     * Append given text to given file
     * @param pathname String with path to file to which the text shall be appended
     * @param text text that shall be written in file
     * @return String with error message or null if no error
     */
    public static String appendStringToFile_WithErrorDescription(String pathname, String text){
        return appendStringToFile_WithErrorDescription(new File(pathname), text);
    }
    /**
     * Append given text to given file
     * @param file to which the text shall be appended
     * @param text text that shall be written in file
     * @return String with error message or null if no error
     */
    public static String appendStringToFile_WithErrorDescription(File file, String text){
        return appendContentWithErrorDescription(file, text);
    }

    private static String appendContentWithErrorDescription(File file, String content){
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))){
            bufferedWriter.append(content);
            return null;
        } catch (IOException e){
            return e.getMessage();
        }
    }
}