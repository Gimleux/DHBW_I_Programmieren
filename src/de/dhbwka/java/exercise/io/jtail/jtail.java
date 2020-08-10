package de.dhbwka.java.exercise.io.jtail;

import de.dhbwka.java.utilities.console.Console;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class jtail {
    private File file;
    private int lines;
    private int bytes;
    private String[] content;

    public jtail(String[] args) throws jtailIllegalParameterException, jtailIOException {
        boolean gotArguments = getArguments(args);
        if (gotArguments) {
            readFile();
            printSelectedContent();
        }
    }

    private boolean getArguments(String[] args) throws jtailIllegalParameterException {
        if (args.length == 0) {
            Console.printlnColoredText("Fehler: Kein Dateiname angegeben", "red");
            return false;
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
                //if both args are given, only foundLines is used -> no need to keep searching for --bytes=
                if (foundLines && file != null) break;
            }
            if (file == null) {
                Console.printlnColoredText("Fehler: Kein Dateiname angegeben", "red");
                return false;
            }
            setLinesIfNoArgs();
            return true;
        }
    }

    private void setLinesIfNoArgs() {
        if (lines == 0 && bytes == 0) {
            Console.printlnColoredText("Keine nutzbaren Argumente angegeben. \n --lines wurde auf 10 gesetzt.", "yellow");
            lines = 10;
        }
    }

    private void argContainsFile(String element) throws jtailIllegalParameterException {
        if (file != null) {
            throw new jtailIllegalParameterException("Falsche Parameter: Mehrere Dateien angegeben");
        } else {
            File file = new File(element);
            if (!file.exists()) {
                throw new jtailIllegalParameterException("Falsche Parameter: Date existiert nicht!");
            } else {
                this.file = file;
            }
        }
    }

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

    private void readFile() throws jtailIOException, jtailIllegalParameterException {
        if (lines != 0) {
            int numberOfLines = getNumberOfLinesInFile();
            if (numberOfLines < lines) {
                throw new jtailIllegalParameterException("Fehler: Datei hat weniger Zeilen als gelesen werden sollen");
            } else {
                content = new String[lines];
                readLastInContentArray(numberOfLines, true);
            }
        } else {
            int numberOfBytes = getNumberOfBytesInFile();
            if (numberOfBytes < bytes) {
                throw new jtailIllegalParameterException("Fehler: Datei hat weniger Bytes als gelesen werden sollen");
            } else {
                content = new String[1];
                readLastInContentArray(numberOfBytes, false);
            }
        }
    }

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

    private int getNumberOfBytesInLine(int line) throws jtailIOException {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            int actualLineInFile = 0;
            while (actualLineInFile < (line) + 1) {
                br.readLine();
                actualLineInFile++;
            }
            int actualByteInFile = 0;
            while (br.ready()) {
                br.read();
                actualByteInFile++;
            }
            return actualByteInFile;
        } catch (Exception e) {
            throw new jtailIOException("Fehler: Datei konnte nicht gelesen werden" + System.lineSeparator() + e.getMessage());
        }
    }

    private void printSelectedContent() {
        for (String line : content) {
            System.out.println(line);
        }
    }

    public static void main(String[] args) throws jtailIOException, jtailIllegalParameterException {
        new jtail(args);
    }
}