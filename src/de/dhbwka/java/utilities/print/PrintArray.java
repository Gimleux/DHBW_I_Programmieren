package de.dhbwka.java.utilities.print;

//TODO Rename Rows <-> Columns

public class PrintArray {
    ///////////////////////////////////////////////////////////////////////////
    //
    ///////////////////////////////////////////////////////////////////////////
    public static void printArrayInRowsWithTextBeforeAndTextBehind(String textBefore, int[] array, String textBehind) {
        for (int element : array) {
            System.out.println(textBefore + element + textBehind);
        }
    }

    public static void printArrayInRowsWithTextBeforeAndTextBehind(String textBefore, boolean[] array, String textBehind) {
        for (boolean element : array) {
            System.out.println(textBefore + (element ? "1" : "0") + textBehind);
        }
    }

    public static void printArrayInRowsWithTextBeforeAndTextBehind(String textBefore, double[] array, String textBehind) {
        for (double element : array) {
            System.out.println(textBefore + element + textBehind);
        }
    }

    public static void printArrayInRowsWithTextBeforeAndTextBehind(String textBefore, String[] array, String textBehind) {
        for (String element : array) {
            System.out.println(textBefore + element + textBehind);
        }
    }

    public static void printArrayInRowsWithTextBeforeAndTextBehind(String textBefore, char[] array, String textBehind) {
        for (char element : array) {
            System.out.println(textBefore + element + textBehind);
        }
    }

    ///////////////////////////////////////////////////////////////////////////
    //
    ///////////////////////////////////////////////////////////////////////////

    public static void printArrayWithoutZeroInRowsWithTextBeforeAndTextBehind(String textBefore, int[] array, String textBehind) {
        for (int element : array) {
            if (element != 0) {
                System.out.println(textBefore + element + textBehind);
            }
        }
    }

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

    public static void printArrayInColumnsWithDelimiter(int[] array, String delimiter) {
        for (int element : array) {
            if (element != 0) {
                System.out.print(element + delimiter);
            }
        }
    }

    public static void printArrayInColumnsWithDelimiter(boolean[] array, String delimiter) {
        for (boolean element : array) {
            System.out.print((element ? "1" : "0") + delimiter);
        }
    }

    public static void printArrayInColumnsWithDelimiter(double[] array, String delimiter) {
        for (double element : array) {
            if (element != 0) {
                System.out.print(element + delimiter);
            }
        }
    }

    public static void printArrayInColumnsWithDelimiter(String[] array, String delimiter) {
        for (String element : array) {
            if (element != null) {
                System.out.print(element + delimiter);
            }
        }
    }

    public static void printArrayInColumnsWithDelimiter(char[] array, String delimiter) {
        for (char element : array) {
            System.out.print(element + delimiter);
        }
    }

}
