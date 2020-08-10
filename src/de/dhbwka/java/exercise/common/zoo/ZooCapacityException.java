package de.dhbwka.java.exercise.common.zoo;

import de.dhbwka.java.utilities.console.Console;

public class ZooCapacityException extends Exception{
    public ZooCapacityException() {
        super(Console.colorConsoleText("red") + "Fehler: Kapazität des Zoos ist erreicht" + Console.colorConsoleText("default"));
    }

    public ZooCapacityException(String message) {
        super(message);
    }
}
