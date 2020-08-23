package de.dhbwka.java.exercise.datastructures;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class SetRandomExample {
    public static void main(String[] args) {
        Set<Integer> numbers = new TreeSet<>();
        Random rnd = new Random();
        do {
            numbers.add(rnd.nextInt(20) + 1);   //adds no duplicates
        } while (numbers.size() < 10);                  //stops when there are 10 numbers in numbers

        for (Integer n : numbers) {
            System.out.println(n + " ");
        }
    }
}
