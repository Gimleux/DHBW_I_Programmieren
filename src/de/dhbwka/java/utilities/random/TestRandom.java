package de.dhbwka.java.utilities.random;

import de.dhbwka.java.utilities.console.Console;

public class TestRandom {
    public static void main(String[] args) {
        System.out.print(Console.colorConsoleText("red"));
        System.out.println("DoubleInc1Exc3");
        for (int i = 0; i < 10; i++) {
            System.out.println(Random.RandomDoubleIncMinExcMax(1,3));
        }
        System.out.println();

        System.out.print(Console.colorConsoleText("yellow"));
        System.out.println("DoubleInc0Exc1");
        for (int i = 0; i < 10; i++) {
            System.out.println(Random.RandomDoubleInc0ExcMax(1));
        }
        System.out.println();

        System.out.print(Console.colorConsoleText("green"));
        System.out.println("IntegerExc1Exc3");
        for (int i = 0; i < 10; i++) {
            System.out.println(Random.RandomIntExcMinExcMax(1,3));
        }
        System.out.println();

        System.out.print(Console.colorConsoleText("red"));
        System.out.println("IntegerInc1Exc2");
        for (int i = 0; i < 10; i++) {
            System.out.println(Random.RandomIntIncMinExcMax(1,2));
        }
        System.out.println();

        System.out.print(Console.colorConsoleText("yellow"));
        System.out.println("IntegerExc1Inc2");
        for (int i = 0; i < 10; i++) {
            System.out.println(Random.RandomIntExcMinIncMax(1,2));
        }
        System.out.println();

        System.out.print(Console.colorConsoleText("green"));
        System.out.println("IntegerInc1Inc2");
        for (int i = 0; i < 10; i++) {
            System.out.println(Random.RandomIntIncMinIncMax(1,2));
        }
        System.out.println();
    }
}
