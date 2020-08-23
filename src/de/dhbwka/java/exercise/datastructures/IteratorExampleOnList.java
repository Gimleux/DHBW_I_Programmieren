package de.dhbwka.java.exercise.datastructures;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorExampleOnList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Karl");
        list.add("Otto");
        list.add("Hans");
        Iterator<String> iter = list.iterator();
        for (; iter.hasNext(); ) {
            System.out.println(iter.next());
        }
    }
}