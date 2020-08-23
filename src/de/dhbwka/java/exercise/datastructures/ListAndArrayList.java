package de.dhbwka.java.exercise.datastructures;

import java.util.ArrayList;
import java.util.List;

//Variable vom Typ des Interfaces List
//Instanz vom Typ der Implementierung ArrayList

public class ListAndArrayList {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("Some");
        words.add("words");
        words.add("in");
        words.add("a");
        words.add("list.");
        System.out.println(words.get(2));
        System.out.println("------");
        for(String s:words){
            System.out.println(s);
        }
    }
}
