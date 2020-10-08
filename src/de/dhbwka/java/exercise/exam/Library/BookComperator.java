package de.dhbwka.java.exercise.exam.Library;

import java.util.Comparator;

public class BookComperator implements Comparator<Book> {

    @Override
    public int compare(Book a, Book b) {
        if (a == null && b == null) return 0;
        if (a == null) return -1;
        if (b == null) return 1;
        if (compareTitle(a, b) != 0) return compareTitle(a, b);
        if (compareAuthor(a, b) != 0) return compareAuthor(a, b);
        if (comparePublisher(a, b) != 0) return comparePublisher(a, b);
        return compareYear(a, b);
    }

    public int compareTitle(Book b, Book a) {
        return b.getTitle().compareTo(a.getTitle());
    }

    public int compareAuthor(Book b, Book a) {
        return b.getAuthor().compareTo(a.getAuthor());
    }

    public int comparePublisher(Book b, Book a) {
        return b.getPublisher().compareTo(a.getPublisher());
    }

    public int compareYear(Book b, Book a) {
        return b.getYear() - (a.getYear());
    }

}