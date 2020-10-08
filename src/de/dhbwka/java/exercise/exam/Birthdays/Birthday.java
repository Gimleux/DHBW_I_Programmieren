package de.dhbwka.java.exercise.exam.Birthdays;
import java.util.Objects;

public class Birthday {
    private String name;
    private int year;
    private int month;
    private int day;


    public Birthday(String name, int year, int month, int day) {
        this.name = name;
        this.year = year;
        this.month = month;
        this.day = day;
    }


    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Birthday birthday = (Birthday) o;
        return year == birthday.year &&
                month == birthday.month &&
                day == birthday.day &&
                Objects.equals(name, birthday.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, year, month, day);
    }
}