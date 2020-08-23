package de.dhbwka.java.exercise.datastructures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListSortExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Karl");
        list.add("Otto");
        list.add("Hans");

        Collections.sort(list);

        for (String name : list) {
            System.out.println(name);
        }
    }
}
