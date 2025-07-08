# quantum-bookstore

This project is a simple, extensible online book store implemented in Java. It demonstrates object-oriented design, service abstraction, and basic inventory management for different types of books.

## Project Structure

```
quantum-bookstore/
├── README.md
├── bin/
│   └── ... (compiled .class files)
├── lib/
├── src/
│   ├── Main.java
│   ├── book/
│   │   ├── Book.java
│   │   ├── EBook.java
│   │   ├── PaperBook.java
│   │   └── ShowcaseBook.java
│   └── service/
│       ├── InventoryService.java
│       ├── MailService.java
│       └── ShippingService.java
```

## Main Components

- **Book (abstract class):** Base for all book types, with common fields and an abstract `buy` method.
- **EBook, PaperBook, ShowcaseBook:** Concrete book types, each with specific purchase logic.
- **InventoryService:** Manages adding, removing, and purchasing books.
- **MailService, ShippingService:** Simulate external services for email and shipping.
- **Main.java:** Contains test cases and demonstrates all core functionalities.

## Extensibility

- **Add new book types:**
  - Create a new class in `src/book/` extending `Book` and implement the `buy` method.
  - Register the new book type in your application logic (e.g., add to inventory).
- **Add new services:**
  - Add new service classes in `src/service/` and use them in your book or inventory logic.
- **Business logic:**
  - Easily modify or extend purchase, validation, or notification logic in each book or service class.

## How to Run

1. Compile all Java files:
   ```bash
   javac -d bin src/**/*.java
   ```
2. Run the main class:
   ```bash
   java -cp bin Main
   ```

## Test Cases (in Main.java)

The `main` method in `Main.java` covers:

- Adding, retrieving, and removing books from inventory
- Buying PaperBook, EBook, and handling ShowcaseBook (not purchasable)
- Error handling for:
  - Not enough stock
  - Invalid email (for EBook)
  - Invalid address (for PaperBook)
  - Outdated books removal
- Printing results and error messages for each operation

---

### Example Output

```
Get Book 111: PaperBook [isbn=111, title=The Way I Am, price=100.0, yearPublished=2008-01-01, author=Eminem, stock=10]
Get Book 222: EBook [isbn=222, title=Java Fundamentals, price=50.0, yearPublished=2022-05-10, author=will smith, fileType=PDF]
Get Book 333: ShowcaseBook [isbn=333, title=Rare Book, price=1000.0, yearPublished=1949-01-01, author=old folks, showcaseDetails=Antique showcase]
Sending book to "123 Main St"
Purchased 2 copies of The Way I Am for a total of 200.0
Total price for 2 copies of The Way I Am: 200.0
Sending email to  "reader@example.com"
Purchased 1 copies of Java Fundamentals for a total of 50.0
Total price for 1 copies of Java Fundamentals: 50.0
Showcase book cannot be purchased.
Total price for 1 copies of Rare Book: 0.0
After removing 222, getBook(222): null
Removed outdated book: Rare Book
After removing outdated, getBook(333): null
Expected error on over-buy: Not enough stock
Expected error on invalid email: Invalid email provided.
Expected error on invalid address: Invalid address provided.
```

---
