package de.dhbwka.java.exercise.collections;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Lottery {
    public static void main(String[] args) {
        Set<Integer> numbers = new TreeSet<Integer>();
        Random random = new Random();
        Integer lastAddedNumber = null;

        do {
            lastAddedNumber = random.nextInt(49) + 1;
            numbers.add(lastAddedNumber);
        } while (numbers.size() < 7);

        for (Integer number : numbers) {
            if (!number.equals(lastAddedNumber)) {
                System.out.print(number + " ");
            }
        }
        System.out.println("Zusatzzahl: " + lastAddedNumber);
    }
}
