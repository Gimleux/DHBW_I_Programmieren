package de.dhbwka.java.exercise.exam.Library;

public class BookAutherCompare extends BookComperator {

    @Override
    public int compare(Book a, Book b) {
        if (compareAuthor(a,b) !=0)return compareAuthor(a,b);
        else if (compareTitle(a,b) !=0)  return compareTitle(a,b);
        else if (comparePublisher(a,b) !=0) return comparePublisher(a,b);
        else  return compareYear(a,b);
    }
}