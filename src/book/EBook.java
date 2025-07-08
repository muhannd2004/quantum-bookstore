package book;

import java.time.LocalDate;

import service.MailService;

public class EBook  extends Book {

    private String fileType;

    private enum EBookType {
    PDF,
    EPUB,
    MOBI,
    AZW,
    AZW3,
    KFX,
    TXT,
    DOCX,
    HTML,
    CBZ,
    RTF,
    DJVU,
    IBA,
    FB2
}

    public EBook(String isbn, String title, double price, LocalDate yearPublished, String author, String fileType) {
        super(isbn, title, price, yearPublished, author);
        if (EBookType.valueOf(fileType.toUpperCase()) == null) {
            throw new RuntimeException("Invalid file type provided.");
        }
        this.fileType = fileType.toUpperCase();
    }


    @Override
    public double buy(int quantity, String email, String address) {
        if (email == null || email.isEmpty() ) {

            throw new RuntimeException("Invalid email provided.");
        }
        if (quantity <= 0) {
            throw new RuntimeException("Quantity must be greater than zero.");
        }
        double totalPrice = price * quantity;
        // Simulate sending an email
        System.out.println("Sending email to  \"" + email+ "\"");
        MailService.send(this, email);
        System.out.println("Purchased " + quantity + " copies of " + title + " for a total of " + totalPrice);
        return totalPrice;
    }

    public String getFileType() {
        return fileType;
    }

    @Override
    public String toString() {
        return "EBook [isbn=" + isbn + ", title=" + title + ", price=" + price + ", yearPublished=" + yearPublished
                + ", author=" + author + ", fileType=" + fileType + "]";
    }

}
