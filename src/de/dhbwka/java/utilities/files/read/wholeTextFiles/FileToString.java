package de.dhbwka.java.utilities.files.read.wholeTextFiles;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileToString {

    private static String readFile(BufferedReader bufferedReader) throws Exception {
        StringBuilder stringBuilder = new StringBuilder();
        while (bufferedReader.ready()) {
            stringBuilder.append(bufferedReader.readLine()).append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
    ///////////////////////////////////////////////////////////////////////////
    // get Text from File - With Error Description
    ///////////////////////////////////////////////////////////////////////////

    /**
     * Read a file by given pathname and return its content as String
     *
     * @param pathname path to file (with filename)
     * @return String with file's content or written Error description
     */
    public static String getFileToString_WithErrorDescription(String pathname) {
        File file = new File(pathname);
        return getFileContentWithErrorDescription(file);
    }

    /**
     * Read a file by given pathname and return its content as String
     *
     * @param file file that shall be read
     * @return String with file's content or written Error description
     */
    public static String getFileToString_WithErrorDescription(File file) {
        return getFileContentWithErrorDescription(file);
    }

    private static String getFileContentWithErrorDescription(File file) {
        if (!file.exists()) {
            return "Fehler: Datei nicht vorhanden";
        }
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            StringBuilder stringBuilder = new StringBuilder();
            while (bufferedReader.ready()) {
                stringBuilder.append(bufferedReader.readLine()).append(System.lineSeparator());
            }
            return stringBuilder.toString();
        } catch (IOException e) {
            return "Fehler: Auf Datei konnte nicht zugegriffen werden";
        }
    }

    ///////////////////////////////////////////////////////////////////////////
    // get Text from File - With Null if Error
    ///////////////////////////////////////////////////////////////////////////

    /**
     * Read a file by given pathname and return its content as String
     *
     * @param pathname path to file (with filename)
     * @return String with file's content or null if Error occurs
     */
    public static String getFileToString_NullIfError(String pathname) {
        File file = new File(pathname);
        return getFileContentWithNullIfError(file);
    }

    /**
     * Read a file by given pathname and return its content as String
     *
     * @param file file that shall be read
     * @return String with file's content or null if Error occurs
     */
    public static String getFileToString_NullIfError(File file) {
        return getFileContentWithNullIfError(file);
    }

    private static String getFileContentWithNullIfError(File file) {
        if (!file.exists()) {
            return null;
        }
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            StringBuilder stringBuilder = new StringBuilder();
            while (bufferedReader.ready()) {
                stringBuilder.append(bufferedReader.readLine()).append(System.lineSeparator());
            }
            return stringBuilder.toString();
        } catch (IOException e) {
            return null;
        }
    }

    ///////////////////////////////////////////////////////////////////////////
    // get Text from File - With Exception Message if Error
    ///////////////////////////////////////////////////////////////////////////

    /**
     * Read a file by given pathname and return its content as String
     *
     * @param pathname path to file (with filename)
     * @return String with file's content or String with Exception message
     */
    public static String getFileToString_WithExceptionMessage(String pathname) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(pathname)))) {
            StringBuilder stringBuilder = new StringBuilder();
            while (bufferedReader.ready()) {
                stringBuilder.append(bufferedReader.readLine()).append(System.lineSeparator());
            }
            return stringBuilder.toString();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    /**
     * Read a file by given pathname and return its content as String
     *
     * @param file file that shall be read
     * @return String with file's content or String with Exception message
     */
    public static String getFileToString_WithExceptionMessage(File file) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            StringBuilder stringBuilder = new StringBuilder();
            while (bufferedReader.ready()) {
                stringBuilder.append(bufferedReader.readLine()).append(System.lineSeparator());
            }
            return stringBuilder.toString();
        } catch (IOException e) {
            return e.getMessage();
        }
    }
}
