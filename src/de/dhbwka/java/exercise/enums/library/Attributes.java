package de.dhbwka.java.exercise.enums.library;

public enum Attributes {
    TITLE("Title"),
    AUTHOR("Author"),
    YEAR("Year"),
    PUBLISHER("Publisher");

    private String name;

    private Attributes(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
