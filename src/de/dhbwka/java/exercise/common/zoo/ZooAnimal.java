package de.dhbwka.java.exercise.common.zoo;

import de.dhbwka.java.utilities.console.Console;

/**
 * @author Gimleux
 * @version 1.0
 */
public abstract class ZooAnimal {
    private final String name;
    private final String species;
    private final String favouriteFood;

    /**
     * @param species       Spezies des zu erstellenden ZooAnimals
     * @param name          Name des zu erstellenden ZooAnimals
     * @param favouriteFood Lieblingsfutter des zu erstellenden ZooAnimals
     */
    public ZooAnimal(String species, String name, String favouriteFood) {
        this.name = name;
        this.species = species;
        this.favouriteFood = favouriteFood;
    }

    /**
     * Gibt auf der Konsole aus, ob das Tier das an übergebene Futter mag oder nicht (abhängig von this.favouriteFoos)
     *
     * @param food Futter, welches dem Tier gefüttert werden soll
     */
    public void feed(String food) {
        Console.printlnColoredText(toString() + (food.equalsIgnoreCase(favouriteFood) ? " loves " : " despises ") + food, (food.equalsIgnoreCase(favouriteFood) ? "green" : "red"));
    }

    /**
     * @return Name und Spezies eines ZooAnimals
     */
    @Override
    public String toString() {
        return name + " (" + species + ")";
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @return species
     */
    public String getSpecies() {
        return species;
    }

    /**
     * @return favourite food
     */
    public String getFavouriteFood() {
        return favouriteFood;
    }
}
