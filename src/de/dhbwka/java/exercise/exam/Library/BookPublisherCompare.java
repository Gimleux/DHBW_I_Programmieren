package de.dhbwka.java.exercise.exam.Library;

public class BookPublisherCompare extends BookComperator {

    @Override
    public int compare(Book a, Book b) {
        if (comparePublisher(a,b) !=0) return comparePublisher(a,b);
        else if (compareTitle(a,b) !=0) return compareTitle(a,b);
        else if (compareAuthor(a,b) !=0) return compareAuthor(a,b);
        else  return compareYear(a,b);
    }
}