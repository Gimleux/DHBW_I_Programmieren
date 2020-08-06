package de.dhbwka.java.utilities.console;

public class Console {

    //Gibt ANSI-String mit gewuenschter Farbe zurueck um Ausgaben in der Konsole einzufaerben
    /* System.out.println(ANSI_RED + "This text is red!" + ANSI_RESET);
        -> "\u001B" + Console.colorConsoleText + <Text> */
    public static String colorConsoleText(String color) {
        //TODO: BG = Zahl+10
        //TODO [VG;BGm
        //TODO https://en.wikipedia.org/wiki/ANSI_escape_code#8-bit
        switch (color.toLowerCase()) {
            case "black":
                return "\u001B[30m";
            case "red":
                return "\u001B[31m";
            case "green":
                return "\u001B[32m";
            case "yellow":
                return "\u001B[33m";
            case "blue":
                return "\u001B[34m";
            case "magenta":
            case "purple":
                return "\u001B[35m";
            case "cyan":
                return "\u001B[36m";
            case "white":
                return "\u001B[37m";
            case "orange":
                return "\u001B[38;5;202m";
            case "black bright":
            case "gray":
                return "\u001B[90m";
            case "red bright":
                return "\u001B[91m";
            case "green bright":
                return "\u001B[92m";
            case "yellow bright":
                return "\u001B[93m";
            case "blue bright":
                return "\u001B[94m";
            case "magenta bright":
            case "purple bright":
                return "\u001B[95m";
            case "cyan bright":
                return "\u001B[96m";
            case "white bright":
                return "\u001B[97m";
            case "orange bright":
                return "\u001B[38;5;220m";
            case "reset":
            case "normal":
            case "default":
            default:
                return "\u001B[0m";
        }
    }

    public static void printlnColoredText(String text, String color) {
        System.out.println(colorConsoleText(color) + text + colorConsoleText("default"));
    }
}
