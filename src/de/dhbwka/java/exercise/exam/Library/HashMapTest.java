package de.dhbwka.java.exercise.exam.Library;

import java.util.HashMap;

public class HashMapTest {
    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        HashMap<String, Integer> hashMap2 = new HashMap<>();

        hashMap.put("Hans", 4);
        hashMap.put("Fred", 3);
        hashMap.put("Fridolin", 5);

        System.out.println("Hans: " + hashMap.put("Hans", 2));
        System.out.println("Frodolin: " + hashMap.get("Fridolin"));
        System.out.println("Fridolin2: " + hashMap.get("Fridolin2"));
        System.out.println("hashMap.haspCode: " + hashMap.hashCode());
        System.out.println("hashMap2.haspCode: " + hashMap2.hashCode());
        hashMap2.put("Hans", 4);
        System.out.println("hashMap2.haspCode: " + hashMap2.hashCode());
        System.out.println("hashMap.entrySet(): " + hashMap.entrySet());

    }
}