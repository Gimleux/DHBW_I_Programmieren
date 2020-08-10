package de.dhbwka.java.exercise.common.zoo;

import de.dhbwka.java.utilities.console.Console;

import java.util.ArrayList;

public class Zoo {
    private final int MAX;
    private ArrayList<ZooAnimal> animalsInZoo  = new ArrayList<>();

    public Zoo() {
        MAX = 5;
    }

    public Zoo(int MAX) {
        this.MAX = MAX;
    }

    public void addAnimal(ZooAnimal animal) throws ZooCapacityException{
        if (animalsInZoo.size() >= MAX){
            throw new ZooCapacityException();
        }
        animalsInZoo.add(animal);
        Console.printlnColoredText(animal.toString() + " wurde dem Zoo hinzugefügt", "green");
    }

    public ZooAnimal[] getAnimals(){
        return animalsInZoo.toArray(new ZooAnimal[0]);
    }

    public boolean existsAnimal(String name){
        for (ZooAnimal animal : animalsInZoo){
            if (name.equalsIgnoreCase(animal.getName())){
                return true;
            }
        }
        return false;
    }

    public void feed(String food){
        for(ZooAnimal animal : animalsInZoo){
            animal.feed(food);
        }
    }

    public void saveToFile(String filename){

    }
}
