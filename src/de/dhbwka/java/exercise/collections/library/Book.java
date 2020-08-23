package de.dhbwka.java.exercise.collections.library;

public class Book {
    private String title;
    private String author;
    private int year;
    private String publisher;

    public Book(String title, String author, int year, String publisher) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.publisher = publisher;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public boolean equals( Object obj ) {
        if ( this == obj ) {
            return true;
        }
        if ( obj == null ) {
            return false;
        }
        if ( this.getClass() != obj.getClass() ) {
            return false;
        }
        Book other = (Book) obj;
        return this.title.equals(other.title) && this.author.equals(other.author )
                && this.publisher.equals(other.publisher ) && this.year == other.year;
    }

    @Override
    public String toString() {
        return title + ';' + author + ';' + year + ";" + publisher;
    }
}
