package de.dhbwka.java.exercise.exam.jBay;

public class Ware {
    private String title;
    private String beschreibung;

    public Ware(String title, String beschreibung) {
        this.title = title;
        this.beschreibung = beschreibung;
    }

    public String getTitle() {
        return title;
    }

    public String getBeschreibung() {
        return beschreibung;
    }
}