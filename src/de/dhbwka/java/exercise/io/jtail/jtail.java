package de.dhbwka.java.exercise.io.jtail;

import de.dhbwka.java.utilities.console.Console;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * @author Gimleux
 * @version 1.1
 */

public class jtail {
    private File file;
    private int lines;
    private int bytes;
    private String[] content;

    /**
     * Complete Program:<br>
     * Prints last n bytes or lines (depending on args) of _filename_ in Console <br>
     * - if neither lines nor bytes are passed, lines get a default value of 10 <br>
     * - if bytes as well as lines are passed, only lines will be used
     *
     * @param args _filename_ --lines=_n_ --bytes=_n_
     * @throws jtailIllegalParameterException No filename passed or _n_ !element of N+
     * @throws jtailIOException               Errors in file reading
     */
    public jtail(String[] args) throws jtailIllegalParameterException, jtailIOException {
        //sets attributes by args
        boolean gotFile = getArguments(args);
        if (gotFile) {
            //reads File and places wished content (by args/attributes) in content[] attribute
            readFile();
            //print content[] attribute
            printSelectedContent();
        }
    }

    /**
     * Analyses all passed arguments for a filename as well as a lines and bytes argument and calls the corresponding functions to store their values
     *
     * @param args argument passed in the call of the class/program
     * @return true if arguments contain a filepath
     * @throws jtailIllegalParameterException No filename passed or _n_ !element of N+
     */
    private boolean getArguments(String[] args) throws jtailIllegalParameterException {
        if (args.length == 0) {
            throw new jtailIllegalParameterException("Fehler: Kein Dateiname angegeben");
        } else {
            boolean foundLines = false;
            //Looking for usefull args
            for (String element : args) {
                if (!element.contains("--")) {
                    argContainsFile(element);
                } else
                    //looking for arg --lines=
                    if (element.contains("--lines=")) {
                        lines = argContainsArg(element, "--lines=");
                        foundLines = true;
                    } else
                        //Looking for arg --bytes=
                        if (element.contains("--bytes=")) {
                            bytes = argContainsArg(element, "--bytes=");
                        }
                //if both args are given, only foundLines is used -_ no need to keep searching for --bytes=
                if (foundLines && file != null) break;
            }
            if (file == null) {
                throw new jtailIllegalParameterException("Fehler: Kein Dateiname angegeben");
            }
            setLinesIfNoArgs();
            return true;
        }
    }

    /**
     * Sets lines argument to default value of 10 if neither lines nor bytes are given
     */
    private void setLinesIfNoArgs() {
        if (lines == 0 && bytes == 0) {
            Console.printlnColoredText("Keine nutzbaren Argumente angegeben. \n --lines wurde auf 10 gesetzt.", "yellow");
            lines = 10;
        }
    }

    /**
     * Verifies existence of passed file(name) and stores the file in attribute
     *
     * @param element single argument that seems to be a file(name)
     * @throws jtailIllegalParameterException thrown if more than one filename was passed
     */
    private void argContainsFile(String element) throws jtailIllegalParameterException {
        if (file != null) {
            throw new jtailIllegalParameterException("Falsche Parameter: Mehrere Dateien angegeben");
        } else {
            File file = new File(element);
            if (!file.exists()) {
                throw new jtailIllegalParameterException("Falsche Parameter: Datei existiert nicht!");
            } else {
                this.file = file;
            }
        }
    }

    /**
     * Checks if arguments were passed with right values and returns the value
     *
     * @param element single argument that contains wanted value
     * @param arg     tells which kind of argument the function was called with
     * @return value of the given argument
     * @throws jtailIllegalParameterException thrown if the argument's value is not element of N+
     */
    private int argContainsArg(String element, String arg) throws jtailIllegalParameterException {
        String param = element.substring(element.indexOf(arg) + arg.length());
        try {
            int argInt;
            argInt = Integer.parseInt(param);
            if (argInt < 1)
                throw new jtailIllegalParameterException("Falsche Parameter: Keine positive Ganzzahl bei '--lines=");
            return argInt;
        } catch (Exception e) {
            throw new jtailIllegalParameterException("Falsche Parameter: Keine Ganzzahl bei '" + arg + "'");
        }
    }

    /**
     * stores last _n_ lines/bytes (depending on arguments)
     * @throws jtailIOException thrown if file cannot be read
     */
    private void readFile() throws jtailIOException {
        if (lines != 0) {
            int numberOfLines = getNumberOfLinesInFile();
            if (numberOfLines < lines) {
                lines = numberOfLines;
            }
            content = new String[lines];
            readLastInContentArray(numberOfLines, true);

        } else {
            int numberOfBytes = getNumberOfBytesInFile();
            if (numberOfBytes < bytes) {
                bytes = numberOfBytes;
            }
            content = new String[1];
            readLastInContentArray(numberOfBytes, false);

        }
    }

    /**
     * Gets Number of all lines in passed file
     * @return number of all lines in file
     * @throws jtailIOException thrown if file cannot be read
     */
    private int getNumberOfLinesInFile() throws jtailIOException {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            int numberOfLines = 0;
            while (br.ready()) {
                br.readLine();
                numberOfLines++;
            }
            return numberOfLines;
        } catch (Exception e) {
            throw new jtailIOException("Fehler: Datei konnte nicht gelesen werden" + System.lineSeparator() + e.getMessage());
        }
    }

    /**
     * Gets Number of all bytes in passed file
     * @return number of all bytes in file
     * @throws jtailIOException thrown if file cannot be read
     */
    private int getNumberOfBytesInFile() throws jtailIOException {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            int numberOfLines = 0;
            while (br.ready()) {
                br.read();
                numberOfLines++;
            }
            return numberOfLines;
        } catch (Exception e) {
            throw new jtailIOException("Fehler: Datei konnte nicht gelesen werden" + System.lineSeparator() + e.getMessage());
        }
    }

    /**
     * reads last _n_ (depending on arguments) lines/bytes (depending on arguments) of file and stores them
     * @param numberOfInFile Number of all lines/bytes (depending on lookingForLines param) in file
     * @param lookingForLines true if whole lines shall be stores, false if only bytes shall be stored
     * @throws jtailIOException thrown if file cannot be read
     */
    private void readLastInContentArray(int numberOfInFile, boolean lookingForLines) throws jtailIOException {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            int actualPositionInFile = 0;
            while (actualPositionInFile < (numberOfInFile - lines)) {
                //jump whole lines
                if (lookingForLines) {
                    br.readLine();
                }
                //only jump bytes
                else {
                    br.read();
                }
                actualPositionInFile++;
            }
            //Read whole lines
            if (lookingForLines) {
                for (int i = 0; i < content.length; i++) {
                    content[i] = br.readLine();
                }
            }
            //only read bytes
            else {
                StringBuilder lastBytesContent = new StringBuilder();
                for (int i = 0; i < bytes; i++) {
                    lastBytesContent.append(br.read());
                }
                content[0] = lastBytesContent.toString();
            }
        } catch (Exception e) {
            throw new jtailIOException("Fehler: Datei konnte nicht gelesen werden" + System.lineSeparator() + e.getMessage());
        }
    }

    /**
     * print stored data in Console
     */
    private void printSelectedContent() {
        for (String line : content) {
            System.out.println(line);
        }
    }

    /**
     * Starts a jtail program with given arguments (see more at the jtail constructor's informations)
     * @param args _filename_ --lines=_n_ --bytes=_n_
     * @throws jtailIllegalParameterException No filename passed or _n_ !element of N+
     * @throws jtailIOException               Errors in file reading
     */
    public static void main(String[] args) throws jtailIOException, jtailIllegalParameterException {
        new jtail(args);
    }
}