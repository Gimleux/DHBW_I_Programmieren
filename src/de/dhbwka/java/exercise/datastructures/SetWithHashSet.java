package de.dhbwka.java.exercise.datastructures;

import java.util.HashSet;
import java.util.Set;

public class SetWithHashSet {

    //Wird nicht sortiert
    //Ausgabenreihenfolge kann aber von Eingabenreihenfolge abweichen
    public static void main(String[] args) {
        Set<String> mySet = new HashSet<>();
        mySet.add("Mia");
        mySet.add("Uli");
        mySet.add("Peter");
        mySet.add("Mia");
        for (String s : mySet) {
            System.out.println(s);
        }
        System.out.println("Element count: " + mySet.size());
    }
}
