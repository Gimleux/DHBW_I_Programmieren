package de.dhbwka.java.utilities.files.read.wholeFiles;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileToStringArray {
    ///////////////////////////////////////////////////////////////////////////
    // get Text from File - With Error Description
    ///////////////////////////////////////////////////////////////////////////

    /**
     * Read a file by given pathname and return its content as String
     *
     * @param pathname path to file (with filename)
     * @return StringArray with file's content or written Error description
     */
    public static String[] getFileToStringArray_WithErrorDescription(String pathname) {
        return getFileToStringArray_WithErrorDescription(new File(pathname));
    }

    /**
     * Read a file by given pathname and return its content as String
     *
     * @param file file that shall be read
     * @return StringArray with file's content or written Error description
     */
    public static String[] getFileToStringArray_WithErrorDescription(File file) {
        return getFileContentWithErrorDescription(file);
    }

    private static String[] getFileContentWithErrorDescription(File file) {
        if (!file.exists()) {
            return new String[]{"Fehler: Datei nicht vorhanden"};
        }
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            ArrayList<String> arrayList = new ArrayList<>();
            while (bufferedReader.ready()) {
                arrayList.add(bufferedReader.readLine());
            }
            return arrayList.toArray(new String[0]);
        } catch (IOException e) {
            return new String[]{"Fehler: Auf Datei konnte nicht zugegriffen werden"};
        }
    }

    ///////////////////////////////////////////////////////////////////////////
    // get Text from File - With Null if Error
    ///////////////////////////////////////////////////////////////////////////

    /**
     * Read a file by given pathname and return its content as String
     *
     * @param pathname path to file (with filename)
     * @return StringArray with file's content or null if Error occurs
     */
    public static String[] getFileToString_NullIfError(String pathname) {
        return getFileToString_NullIfError(new File(pathname));
    }

    /**
     * Read a file by given pathname and return its content as String
     *
     * @param file file that shall be read
     * @return StringArray with file's content or null if Error occurs
     */
    public static String[] getFileToString_NullIfError(File file) {
        return getFileContentWithNullIfError(file);
    }

    private static String[] getFileContentWithNullIfError(File file) {
        if (!file.exists()) {
            return null;
        }
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            ArrayList<String> arrayList = new ArrayList<>();
            while (bufferedReader.ready()) {
                arrayList.add(bufferedReader.readLine());
            }
            return arrayList.toArray(new String[0]);
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
     * @return StringArray with file's content or String with Exception message
     */
    public static String[] getFileToString_WithExceptionMessage(String pathname) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(pathname)))) {
            ArrayList<String> arrayList = new ArrayList<>();
            while (bufferedReader.ready()) {
                arrayList.add(bufferedReader.readLine());
            }
            return arrayList.toArray(new String[0]);
        } catch (IOException e) {
            return new String[]{e.getMessage()};
        }
    }

    /**
     * Read a file by given pathname and return its content as String
     *
     * @param file file that shall be read
     * @return StringArray with file's content or String with Exception message
     */
    public static String[] getFileToString_WithExceptionMessage(File file) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            ArrayList<String> arrayList = new ArrayList<>();
            while (bufferedReader.ready()) {
                arrayList.add(bufferedReader.readLine());
            }
            return arrayList.toArray(new String[0]);
        } catch (IOException e) {
            return new String[]{e.getMessage()};
        }
    }
}