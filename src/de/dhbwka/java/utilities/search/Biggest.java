package de.dhbwka.java.utilities.search;

public class Biggest {
    ///////////////////////////////////////////////////////////////////////////
    // Get Biggest Digit in Matrix of Numbers
    ///////////////////////////////////////////////////////////////////////////

    /**
     * returns biggest digit in two dimensional matrix
     * @param matrix matrix in which the biggest number shall be found
     * @return biggest number
     */
    public static double getBiggestDigitInMatrix (double[][] matrix){
        double biggest = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++){
                biggest = Math.max(Math.abs(matrix[row][column]), biggest);
            }
        }
        return biggest;
    }

    /**
     * returns biggest digit in two dimensional matrix
     * @param matrix matrix in which the biggest number shall be found
     * @return biggest number
     */
    public static int getBiggestDigitInMatrix (int[][] matrix){
        int biggest = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++){
                biggest = Math.max(Math.abs(matrix[row][column]), biggest);
            }
        }
        return biggest;
    }

    ///////////////////////////////////////////////////////////////////////////
    // Get row with biggest Entry in given column of Matrix of Strings
    ///////////////////////////////////////////////////////////////////////////
    /**
     * returns StringArray with row including the biggest entry (numeric value) (in given column) of a two dimensional matrix -> matrix[row][column]
     * @param array matrix in which the biggest entry shall be found
     * @param columnFrom1 column whose elements shall be compared (counting from 1, not 0)
     * @return biggest number
     */
    public static String[] getBiggestEntryInStringMatrix(String[][] array, int columnFrom1){
        //human to IT numbers
        columnFrom1--;

        //array -> [row][column]
        if (array.length==0 || columnFrom1>=array[0].length){
            return null;
        }
        int posWithBiggest = 0;
        double biggest =  0;
        for (int i = 0; i<array.length;i++){
            try {
                double valueOnPosition = Double.parseDouble(array[i][columnFrom1]);
                if(valueOnPosition>biggest){
                    posWithBiggest = i;
                    biggest = valueOnPosition;
                }
            } catch (Exception e){
                return null;
            }
        }
        return array[posWithBiggest];
    }
    
    
}
