package de.dhbwka.java.exercise.exam.Library;

public class BookYearCompare extends BookComperator {
    @Override
    public int compare(Book a, Book b) {
        if (compareYear(a,b) !=0) return compareYear(a,b);
        else if (compareTitle(a,b) !=0) return compareTitle(a,b);
        else if (compareAuthor(a,b) !=0) return compareAuthor(a,b);
        else return comparePublisher(a,b);

    }
}