package book;

import java.time.LocalDate;

public abstract class Book {

    protected String isbn;
    protected String title;
    protected double price;
    protected LocalDate yearPublished;
    protected String author;
    
    public Book(String isbn,String title, double price, LocalDate yearPublished, String author) {
        this.isbn =isbn;
        this.title = title;
        this.price = price;
        this.yearPublished = yearPublished;
        this.author = author;
    }

 
    public abstract double buy(int quantity,String email, String address);
    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public LocalDate getYearPublished() {
        return yearPublished;
    }

    public String getAuthor() {
        return author;
    }

    
public String toString() {
        return "Book [isbn=" + isbn + ", title=" + title + ", price=" + price + ", yearPublished=" + yearPublished
                + ", author=" + author + "]";
    }

}
