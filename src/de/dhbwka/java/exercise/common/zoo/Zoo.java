package de.dhbwka.java.exercise.common.zoo;

import de.dhbwka.java.utilities.console.Console;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 * @author Gimleux
 * @version 1.0
 */
public class Zoo {
    private final int MAX;
    private ArrayList<ZooAnimal> animalsInZoo = new ArrayList<>();

    /**
     * Generates new zoo with default capacity of 5
     */
    public Zoo() {
        MAX = 5;
    }

    /**
     * Generates new zoo with given capacity // max number of animals in zoo
     *
     * @param MAX capacity of zoo
     */
    public Zoo(int MAX) {
        this.MAX = MAX;
    }

    /**
     * Adds an given animal to zoo, if zoo has not reached its capacity
     *
     * @param animal animal that shall be added
     * @throws ZooCapacityException thrown if zoo's capacity is already reached
     */
    public void addAnimal(ZooAnimal animal) throws ZooCapacityException {
        if (animalsInZoo.size() >= MAX) {
            throw new ZooCapacityException(Console.colorConsoleText("red") + "Fehler: Kapazität des Zoos ist erreicht" + Console.colorConsoleText("default"));
        }
        animalsInZoo.add(animal);
        Console.printlnColoredText(animal.toString() + " wurde dem Zoo hinzugefügt", "green");
    }

    /**
     * returns ZooAnimal array with all animals in the zoo
     *
     * @return ZooAnimal[] with all animals in the zoo
     */
    public ZooAnimal[] getAnimals() {
        return animalsInZoo.toArray(new ZooAnimal[0]);
    }

    /**
     * Checks by name if animal is in zoo
     *
     * @param name name of animal that shall be verified
     * @return true: animal in zoo || false: animal not in zoo
     */
    public boolean existsAnimal(String name) {
        for (ZooAnimal animal : animalsInZoo) {
            if (name.equalsIgnoreCase(animal.getName())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Feed given food to all animals in zoo
     *
     * @param food String with name of food
     */
    public void feed(String food) {
        for (ZooAnimal animal : animalsInZoo) {
            animal.feed(food);
        }
    }

    /**
     * prints to console if given animal (by name) exists in zoo
     *
     * @param name String with name of animal
     */
    public void printExistsAnimal(String name) {
        System.out.print("Ist '" + name + "' im Zoo? ");
        boolean exists = existsAnimal(name);
        Console.printlnColoredText((exists ? "Ja" : "Nein"), (exists ? "green" : "red"));
    }

    /**
     * saves all of zoo's animals in given file: "_name_;_species_;_className.getSimpleName(aka simplified genus)_"
     *
     * @param filename path to file in which animals shall be printed
     * @throws ZooFileException thrown if it is not possible to print in file
     */
    public void saveToFile(String filename) throws ZooFileException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (ZooAnimal animal : getAnimals()) {
                bw.write(animal.getName() + ";" + animal.getSpecies() + ";" + animal.getClass().getSimpleName());
                bw.newLine();
            }
            Console.printlnColoredText("Saved animals to file " + filename, "blue");
        } catch (Exception e) {
            throw new ZooFileException("Fehler beim Schreiben der Datei " + filename + ": " + e.getMessage());
        }
    }

    public static void main(String[] args){
        Zoo z = new Zoo();

        /* add ZooAnimals */
        try {
            z.addAnimal(new Predator("Tiger", "Fred"));
            z.addAnimal(new Predator("Tiger", "Lisa"));
            z.addAnimal(new Predator("Lion", "Simba"));
            z.addAnimal(new Songbird("Nuthatch", "Hansi"));
            z.addAnimal(new Songbird("Backbird", "Sina"));
            z.addAnimal(new Songbird("Wren", "Henry"));
        } catch (ZooCapacityException e) {
            Console.printlnColoredText("Fehler: Kapazität des Zoos ist erreicht", "red");
        }
        System.out.println();
        // Save animals to file
        try {
            z.saveToFile("ZooAnimals.txt");
        } catch (ZooFileException e) {
            Console.printlnColoredText("Fehler beim Lesen der Datei: " + e.getMessage(), "red");
        }
        System.out.println();
        // Feed the animals
        z.feed("grains");
        System.out.println();
        //Is in zoo?
        z.printExistsAnimal("Fred");
        z.printExistsAnimal("Kimba");
        z.printExistsAnimal("Henry");
        z.printExistsAnimal("Sina");
        z.printExistsAnimal("Lotte");
    }
}
