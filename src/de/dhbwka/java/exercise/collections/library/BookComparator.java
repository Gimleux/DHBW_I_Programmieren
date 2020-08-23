package de.dhbwka.java.exercise.collections.library;

import java.util.Comparator;

public class BookComparator implements Comparator<Book> {

    private int attribute;
    //0 = Title
    //1 = Author
    //2 = Year
    //3 = Publisher

    public BookComparator(int attribute) {
        this.attribute = attribute;
    }

    @Override
    public int compare(Book o1, Book o2) {
        switch (attribute) {
            case 0:
                return o1.getTitle().compareTo(o2.getTitle());
            case 1:
                return o1.getAuthor().compareTo(o2.getAuthor());
            case 2:
                return o1.getYear() - o2.getYear();
            case 3:
                return o1.getPublisher().compareTo(o2.getPublisher());
        }
        return 0;
    }
}
