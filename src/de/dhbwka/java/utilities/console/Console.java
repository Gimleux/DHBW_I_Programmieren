package de.dhbwka.java.utilities.console;

public class Console {

    //Gibt ANSI-String mit gewuenschter Farbe zurueck um Ausgaben in der Konsole einzufaerben
    /* System.out.println(ANSI_RED + "This text is red!" + ANSI_RESET);
        -> "\u001B" + Console.colorConsoleText + <Text> */

    //TODO [VG;BGm
    //TODO https://en.wikipedia.org/wiki/ANSI_escape_code#8-bit

    //TODO: Testen ob white (bright) und black (bright) vertauscht sind

    private static String get8BitTextColorNumber(String color) {
        int extension = 0;
        switch (color.toLowerCase()) {
            case "orange":
                extension = 202;
                break;
            case "orange bright":
                extension = 220;
                break;
            default:
                break;
        }
        return ";5;" + extension;
    }

    private static int getTextColorNumber(String color) {
        switch (color.toLowerCase()) {
            case "orange":
            case "orange bright":
                return 38;
            case "black":
                return 30;
            case "red":
                return 31;
            case "green":
                return 32;
            case "yellow":
                return 33;
            case "blue":
                return 34;
            case "magenta":
            case "purple":
                return 35;
            case "cyan":
                return 36;
            case "white":
                return 37;
            case "black bright":
            case "gray":
                return 90;
            case "red bright":
                return 91;
            case "green bright":
                return 92;
            case "yellow bright":
                return 93;
            case "blue bright":
                return 94;
            case "magenta bright":
            case "purple bright":
                return 95;
            case "cyan bright":
                return 96;
            case "white bright":
                return 97;
            case "reset":
            case "normal":
            case "default":
            default:
                return 39;
        }
    }

    public static String colorConsoleText(String color) {
        int colorNumber = getTextColorNumber(color);
        String extension8Bit = "";
        if (colorNumber == 38) {
            extension8Bit = get8BitTextColorNumber(color);
        }
        return ("\u001B[" + colorNumber + extension8Bit + "m");
    }
    public static void printlnColoredText(String text, String color) {
        System.out.println(colorConsoleText(color) + text + colorConsoleText("default"));
    }

    public static void printlnColoredText(char text, String color) {
        System.out.println(colorConsoleText(color) + text + colorConsoleText("default"));
    }

    public static void printColoredText(String text, String color) {
        System.out.print(colorConsoleText(color) + text + colorConsoleText("default"));
    }

    public static void printColoredText(char text, String color) {
        System.out.print(colorConsoleText(color) + text + colorConsoleText("default"));
    }

    public static String colorConsoleBackground(String color) {
        int colorNumber = getTextColorNumber(color)+10;
        String extension8Bit = "";
        if (colorNumber == 48) {
            extension8Bit = get8BitTextColorNumber(color);
        }
        return ("\u001B[" + colorNumber + extension8Bit + "m");
    }
    public static void printlnColoredBackground(String text, String color) {
        System.out.println(colorConsoleBackground(color) + text + colorConsoleBackground("default"));
    }

    public static void printlnColoredBackground(char text, String color) {
        System.out.println(colorConsoleBackground(color) + text + colorConsoleBackground("default"));
    }

    public static void printColoredBackground(String text, String color) {
        System.out.print(colorConsoleBackground(color) + text + colorConsoleBackground("default"));
    }

    public static void printColoredBackground(char text, String color) {
        System.out.print(colorConsoleBackground(color) + text + colorConsoleBackground("default"));
    }

    public static String colorConsoleTextAndBackground(String textColor, String backgroundColor) {
        //TODO: Fehler beheben bei 8Bit Farben (richtige Stellen fuer textColor- und bgColor-Teil finden und anpassen)
        //Text:
        int textColorNumber = getTextColorNumber(textColor);
        String textExtension8Bit = "";
//        if (textColorNumber == 38) {
//            textExtension8Bit = get8BitTextColorNumber(textColor);
//        }
        //Background:
        int backgroundcolorNumber = getTextColorNumber(backgroundColor)+10;
        String backgroundExtension8Bit = "";
//        if (backgroundcolorNumber == 48) {
//            backgroundExtension8Bit = get8BitTextColorNumber(backgroundColor);
//        }
        return ("\u001B[" + textColorNumber + textExtension8Bit + ";" + backgroundcolorNumber + backgroundExtension8Bit + "m");
    }
}
