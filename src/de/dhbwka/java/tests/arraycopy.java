package de.dhbwka.java.tests;

import de.dhbwka.java.utilities.print.PrintArray;
import de.dhbwka.java.utilities.print.PrintMatrix;

public class arraycopy {
    public static void main(String[] args) {
        double[][] a = {{1, 2, 4, 8, 16}, {1,4,8,16,25}};
        System.out.println("a: ");
        PrintMatrix.printRectangleMatrix(a);
        System.out.println();
        double[] b = {32,64,128,256,512,1024};
        System.out.println("b: ");
            PrintArray.printArrayInColumnsWithDelimiter(b, " ");
        double[][] c = new double[10][10];
        for (int i = 0; i < a.length; i++){
            System.arraycopy(a[i],0,c[i],0,a.length);
        }
        System.out.println();
        System.out.println("c: ");
        PrintMatrix.printRectangleMatrix(c);
        System.out.println();
        c[0][0] = 6969;
        System.out.println("a: ");
        PrintMatrix.printRectangleMatrix(a);
        System.out.println();
        System.out.println("c: ");
        PrintMatrix.printRectangleMatrix(c);
    }
}
