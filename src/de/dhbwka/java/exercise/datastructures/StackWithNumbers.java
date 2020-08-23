package de.dhbwka.java.exercise.datastructures;

import java.util.Stack;

public class StackWithNumbers {
    public static void main(String[] args) {
        Stack<Integer> numbers = new Stack<>();
        numbers.push(42);
        numbers.push(4711);
        numbers.push(999);

        System.out.println("Count: " + numbers.size());
        System.out.println("Peek: " + numbers.peek());

        do {
            System.out.println("Pop: " + numbers.pop());
        } while ((!numbers.empty()));
    }
}
