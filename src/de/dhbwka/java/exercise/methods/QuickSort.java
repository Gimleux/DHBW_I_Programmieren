package de.dhbwka.java.exercise.methods;

import de.dhbwka.java.utilities.print.PrintArray;
import de.dhbwka.java.utilities.random.Random;

import java.util.Arrays;

public class QuickSort {
    private int[] numbers;

    public QuickSort() {
        this.numbers = new int[20];
        System.out.println("Arraylänge wurde auf 20 Elemente festgelegt.");
    }

    public QuickSort(int length) {
        this.numbers = new int[length];
        System.out.printf("Arraylänge wurde auf %d Elemente festgelegt.\n", length);
    }

    public void fillArray(int max){
        for (int i = 0; i<numbers.length; ++i){
            numbers[i] = (int)(Random.RandomIntIncMinIncMax(0,max));
        }
    }

    public void sort(){
        quicksort(0, numbers.length-1);
    }

    private void quicksort(int left, int right){
        if (left < right){
            int pivot = split(left, right);
            quicksort(left, pivot-1);
            quicksort(pivot+1, right);
        }
    }

    private int split(int left, int right){
        int i = left;
        int j = right-1;
        int pivot = numbers[right];
        //While i did not run past j
        while (i<j){
            //search for element>Pivot from the left
            while (numbers[i] <= pivot && i < right){
                i++;
            }
            //search for Element <Pivot from the Right
            while (numbers[j] >= pivot && j > left){
                j--;
            }
            if (i < j){
                int help = numbers[i];
                numbers[i] = numbers[j];
                numbers[j] = help;
            }
        }
        //Swap Pivot to final position
        if (numbers[i] > pivot){
            int help = numbers[i];
            numbers[i] = numbers[right];
            numbers[right] = help;
        }
        //position Pivot
        return i;
    }

    public int[] getNumbers() {
        return numbers;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort(100);
        quickSort.fillArray(10000000);
        System.out.println("Unsortierte Zahlenfolge:");
        PrintArray.printArrayInColumnsWithDelimiter(quickSort.getNumbers(), " ");
        System.out.println();
        quickSort.sort();
        System.out.println("Sortierte Zahlenfolge:");
        PrintArray.printArrayInColumnsWithDelimiter(quickSort.getNumbers(), " ");
        System.out.println();
    }
}
