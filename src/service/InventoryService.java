package service;

import java.time.LocalDate;
import java.time.Year;
import java.util.HashMap;
import java.util.Map;

import book.Book;


public class InventoryService {
    // the string is for isbn
    private Map<String, Book> inventory = new HashMap<>();

    public void addBook(Book book) {
        if (book == null || book.getIsbn() == null || book.getIsbn().isEmpty()) {
            throw new IllegalArgumentException("Book or ISBN cannot be null or empty");
        }
        inventory.put(book.getIsbn(), book);
    }

    public Book getBook(String isbn) {
        return inventory.get(isbn);
    }

    public void removeBook(String isbn) {
        if (isbn == null || isbn.isEmpty()) {
            throw new IllegalArgumentException("ISBN cannot be null or empty");
        }
        inventory.remove(isbn);
    }

    public void removeOutdatedBooks(LocalDate maxAge) {

        for (String isbn : inventory.keySet()) {
            Book book = inventory.get(isbn);
            if (book != null && book.getYearPublished().isBefore(maxAge)) {
                inventory.remove(isbn);
                System.out.println("Removed outdated book: " + book.getTitle());
            }
        }
        
    }

    public void buyBook(String isbn, int quantity, String email, String address){
        if (isbn == null || isbn.isEmpty()) {
            throw new IllegalArgumentException("ISBN cannot be null or empty");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }
        Book book = inventory.get(isbn);
        if (book == null) {
            throw new RuntimeException("Book with ISBN " + isbn + " not found in inventory");
        }
        double totalPrice = book.buy(quantity, email, address);
        System.out.println("Total price for " + quantity + " copies of " + book.getTitle() + ": " + totalPrice);
    }
}
