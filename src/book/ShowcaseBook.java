package book;

import java.time.LocalDate;

public class ShowcaseBook extends Book {

    private String showcaseDetails;

    public ShowcaseBook(String isbn, String title, double price, LocalDate yearPublished, String author, String showcaseDetails) {
        super(isbn, title, price, yearPublished, author);
        this.showcaseDetails = showcaseDetails;
    }

    @Override
    public double buy(int quantity, String email, String address) {
        // Showcase books are not for sale
        System.out.println("Showcase book cannot be purchased.");
        return 0;
    }

    @Override
    public String toString() {
        return "ShowcaseBook [isbn=" + isbn + ", title=" + title + ", price=" + price + ", yearPublished=" + yearPublished
                + ", author=" + author + ", showcaseDetails=" + showcaseDetails + "]";
    }
}
