package de.dhbwka.java.utilities.console;

public class Console {

    //Gibt ANSI-String mit gewuenschter Farbe zurueck um Ausgaben in der Konsole einzufaerben
    /* System.out.println(ANSI_RED + "This text is red!" + ANSI_RESET);
        -> "\u001B" + Console.colorConsoleText + <Text> */
    public static String colorConsoleText(String color){

        switch (color.toLowerCase()) {
            case "black"    : return "\u001B[30m";
            case "red"      : return "\u001B[31m";
            case "green"    : return "\u001B[32m";
            case "yellow"   : return "\u001B[33m";
            case "blue"     : return "\u001B[34m";
            case "purple"   : return "\u001B[35m";
            case "cyan"     : return "\u001B[36m";
            case "white"    : return "\u001B[37m";
            case "reset"    :
            case "normal"   :
            case "default"  :
            default         : return "\u001B[0m";
        }
    }

    public static void printlnColoredText(String text, String color){
        System.out.println(colorConsoleText(color) + text + colorConsoleText("default"));
    }
}
