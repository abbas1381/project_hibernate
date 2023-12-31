package model;

public class Book {
     int bookId;
     String title;
     int year;
     Author author;

    public Book(int bookId, String title, int year, Author author) {
        this.bookId = bookId;
        this.title = title;
        this.year = year;
        this.author = author;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public Author getAuthor() {
        return author;
    }

}
