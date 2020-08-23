package de.dhbwka.java.exercise.datastructures;

import java.util.HashMap;
import java.util.Map;

public class MapWithHashMap {
    public static void main(String[] args) {
        Map<String, String> bdays = new HashMap<>();
        bdays.put("Mia", "20.04.1992");
        bdays.put("Uli", "10.08.1993");
        bdays.put("Peter", "19.07.1994");
        bdays.put("Mia", "31.12.1991"); //duplicate overwritten

        for (String name: bdays.keySet()){ //key as Set
            System.out.println(name + " born on " + bdays.get(name));
        }
    }
}
