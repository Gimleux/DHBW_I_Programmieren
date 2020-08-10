package de.dhbwka.java.exercise.common.zoo;

import de.dhbwka.java.utilities.console.Console;

public abstract class ZooAnimal {
    private String name;
    private String species;
    private String favouriteFood;

    public ZooAnimal(String name, String species, String favouriteFood) {
        this.name = name;
        this.species = species;
        this.favouriteFood = favouriteFood;
    }

    public void feed(String food) {
        Console.printlnColoredText(toString() + (food.equalsIgnoreCase(favouriteFood) ? " loves " : " despises ") + food, (food.equalsIgnoreCase(favouriteFood) ? "green" : "red"));
    }

    @Override
    public String toString() {
        return name + " (" + species + ")";
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public String getFavouriteFood() {
        return favouriteFood;
    }
}
