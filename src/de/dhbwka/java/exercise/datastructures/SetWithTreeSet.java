package de.dhbwka.java.exercise.datastructures;

import java.util.Set;
import java.util.TreeSet;

public class SetWithTreeSet {

    //Wird sortiert
    public static void main(String[] args) {
        Set<String> mySet = new TreeSet<>();
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
