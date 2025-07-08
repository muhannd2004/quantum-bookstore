import book.*;
import service.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws Exception {
        // Create InventoryService
        InventoryService inventory = new InventoryService();

        // Create books
        PaperBook paperBook = new PaperBook("111", "The Way I Am", 100.0, LocalDate.of(2008, 1, 1), "Eminem", 10);
        EBook eBook = new EBook("222", "Java Fundamentals", 50.0, LocalDate.of(2022, 5, 10), "will smith", "PDF");
        ShowcaseBook showcaseBook = new ShowcaseBook("333", "Rare Book", 1000.0, LocalDate.of(1949, 1, 1), "old folks", "Antique showcase");

        // Add books to inventory
        inventory.addBook(paperBook);
        inventory.addBook(eBook);
        inventory.addBook(showcaseBook);

        // Test getBook
        System.out.println("Get Book 111: " + inventory.getBook("111"));
        System.out.println("Get Book 222: " + inventory.getBook("222"));
        System.out.println("Get Book 333: " + inventory.getBook("333"));

        // Test buyBook for PaperBook
        try {
            inventory.buyBook("111", 2, "buyer@example.com", "123 Main St");
        } catch (Exception e) {
            System.out.println("Error buying PaperBook: " + e.getMessage());
        }

        // Test buyBook for EBook
        try {
            inventory.buyBook("222", 1, "reader@example.com", "");
        } catch (Exception e) {
            System.out.println("Error buying EBook: " + e.getMessage());
        }

        // Test buyBook for ShowcaseBook (should not be purchasable)
        try {
            inventory.buyBook("333", 1, "showcase@example.com", "Museum");
        } catch (Exception e) {
            System.out.println("Error buying ShowcaseBook: " + e.getMessage());
        }

        // Test removeBook
        inventory.removeBook("222");
        System.out.println("After removing 222, getBook(222): " + inventory.getBook("222"));

        // Test removeOutdatedBooks
        inventory.removeOutdatedBooks(LocalDate.of(1950, 1, 1));
        System.out.println("After removing outdated, getBook(333): " + inventory.getBook("333"));

        // Test PaperBook stock and error on over-buy
        try {
            inventory.buyBook("111", 20, "buyer2@example.com", "456 Main St");
        } catch (Exception e) {
            System.out.println("Expected error on over-buy: " + e.getMessage());
        }

        // Test invalid email for EBook
        try {
            inventory.addBook(new EBook("444", "Bad Email Book", 10.0, LocalDate.of(2022, 1, 1), "Author", "EPUB"));
            inventory.buyBook("444", 1, "", "");
        } catch (Exception e) {
            System.out.println("Expected error on invalid email: " + e.getMessage());
        }

        // Test invalid address for PaperBook
        try {
            inventory.addBook(new PaperBook("555", "No Address Book", 20.0, LocalDate.of(2022, 1, 1), "Author", 5));
            inventory.buyBook("555", 1, "buyer3@example.com", "");
        } catch (Exception e) {
            System.out.println("Expected error on invalid address: " + e.getMessage());
        }
    }
}
