package de.dhbwka.java.utilities.print;

public class PrintArray {

    /**
     * Prints Array in Console in rows with text in front of and text behind the single array elements
     * @param textBefore text which shall be written before every element
     * @param array array that shall be printed into the console
     * @param textBehind text which shall be written after every element
     */
    public static void printArrayInRowsWithTextBeforeAndTextBehind(String textBefore, int[] array, String textBehind) {
        for (int element : array) {
            System.out.println(textBefore + element + textBehind);
        }
    }

    /**
     * Prints Array in Console in rows with text in front of and text behind the single array elements
     * @param textBefore text which shall be written before every element
     * @param array array that shall be printed into the console
     * @param textBehind text which shall be written after every element
     */
    public static void printArrayInRowsWithTextBeforeAndTextBehind(String textBefore, boolean[] array, String textBehind) {
        for (boolean element : array) {
            System.out.println(textBefore + (element ? "1" : "0") + textBehind);
        }
    }

    /**
     * Prints Array in Console in rows with text in front of and text behind the single array elements
     * @param textBefore text which shall be written before every element
     * @param array array that shall be printed into the console
     * @param textBehind text which shall be written after every element
     */
    public static void printArrayInRowsWithTextBeforeAndTextBehind(String textBefore, double[] array, String textBehind) {
        for (double element : array) {
            System.out.println(textBefore + element + textBehind);
        }
    }

    /**
     * Prints Array in Console in rows with text in front of and text behind the single array elements
     * @param textBefore text which shall be written before every element
     * @param array array that shall be printed into the console
     * @param textBehind text which shall be written after every element
     */
    public static void printArrayInRowsWithTextBeforeAndTextBehind(String textBefore, String[] array, String textBehind) {
        for (String element : array) {
            System.out.println(textBefore + element + textBehind);
        }
    }

    /**
     * Prints Array in Console in rows with text in front of and text behind the single array elements
     * @param textBefore text which shall be written before every element
     * @param array array that shall be printed into the console
     * @param textBehind text which shall be written after every element
     */
    public static void printArrayInRowsWithTextBeforeAndTextBehind(String textBefore, char[] array, String textBehind) {
        for (char element : array) {
            System.out.println(textBefore + element + textBehind);
        }
    }

    ///////////////////////////////////////////////////////////////////////////
    //
    ///////////////////////////////////////////////////////////////////////////

    /**
     * Prints Array in Console in rows with text in front of and text behind the single array elements (ignores elements with value 0)
     * @param textBefore text which shall be written before every element
     * @param array array that shall be printed into the console
     * @param textBehind text which shall be written after every element
     */
    public static void printArrayWithoutZeroInRowsWithTextBeforeAndTextBehind(String textBefore, int[] array, String textBehind) {
        for (int element : array) {
            if (element != 0) {
                System.out.println(textBefore + element + textBehind);
            }
        }
    }

    /**
     * Prints Array in Console in rows with text in front of and text behind the single array elements (ignores elements with value 0)
     * @param textBefore text which shall be written before every element
     * @param array array that shall be printed into the console
     * @param textBehind text which shall be written after every element
     */
    public static void printArrayWithoutZeroInRowsWithTextBeforeAndTextBehind(String textBefore, double[] array, String textBehind) {
        for (double element : array) {
            if (element != 0) {
                System.out.println(textBefore + element + textBehind);
            }
        }
    }

    ///////////////////////////////////////////////////////////////////////////
    //
    ///////////////////////////////////////////////////////////////////////////

    /**
     * Prints array in console in collumn using a given delimiter to separate the single elements
     * @param array array that shall be printed into the console
     * @param delimiter delimiter which shall be printed between the single elements
     */
    public static void printArrayInColumnsWithDelimiter(int[] array, String delimiter) {
        for (int element : array) {
            if (element != 0) {
                System.out.print(element + delimiter);
            }
        }
    }

    /**
     * Prints array in console in collumn using a given delimiter to separate the single elements
     * @param array array that shall be printed into the console
     * @param delimiter delimiter which shall be printed between the single elements
     */
    public static void printArrayInColumnsWithDelimiter(boolean[] array, String delimiter) {
        for (boolean element : array) {
            System.out.print((element ? "1" : "0") + delimiter);
        }
    }

    /**
     * Prints array in console in collumn using a given delimiter to separate the single elements
     * @param array array that shall be printed into the console
     * @param delimiter delimiter which shall be printed between the single elements
     */
    public static void printArrayInColumnsWithDelimiter(double[] array, String delimiter) {
        for (double element : array) {
            if (element != 0) {
                System.out.print(element + delimiter);
            }
        }
    }

    /**
     * Prints array in console in collumn using a given delimiter to separate the single elements
     * @param array array that shall be printed into the console
     * @param delimiter delimiter which shall be printed between the single elements
     */
    public static void printArrayInColumnsWithDelimiter(String[] array, String delimiter) {
        for (String element : array) {
            if (element != null) {
                System.out.print(element + delimiter);
            }
        }
    }

    /**
     * Prints array in console in collumn using a given delimiter to separate the single elements
     * @param array array that shall be printed into the console
     * @param delimiter delimiter which shall be printed between the single elements
     */
    public static void printArrayInColumnsWithDelimiter(char[] array, String delimiter) {
        for (char element : array) {
            System.out.print(element + delimiter);
        }
    }
}
