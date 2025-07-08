package book;

import java.time.LocalDate;

import service.ShippingService;

public class PaperBook extends Book{
    private int stock;

    public PaperBook(String isbn, String title, double price, LocalDate yearPublished, String author, int stock) {
        super(isbn, title, price, yearPublished, author);
        this.stock = stock;
    }

    @Override
    public double buy(int quantity, String email, String address) {
        if (quantity > stock) {
            throw new RuntimeException("Not enough stock");
        }
        if (address == null || address.isEmpty()) {
            throw new RuntimeException("Invalid address provided.");
        }
        if (quantity <= 0) {
            throw new RuntimeException("Quantity must be greater than zero.");
        }
        
        stock -= quantity;
        double totalPrice = price * quantity;

        // Simulate sending the book to the address
        System.out.println("Sending book to \"" + address+ "\"");
        ShippingService.send(this, address);
        System.out.println("Purchased " + quantity + " copies of " + title + " for a total of " + totalPrice);

        return totalPrice;
    }

    public int getStock() {
        return stock;
    }

    public String toString() {
        return "PaperBook [isbn=" + isbn + ", title=" + title + ", price=" + price + ", yearPublished=" + yearPublished
                + ", author=" + author + ", stock=" + stock + "]";
    }
}
