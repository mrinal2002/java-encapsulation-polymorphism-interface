// Abstract class LibraryItem
abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;

    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    // Abstract method to get loan duration
    public abstract int getLoanDuration();

    // Concrete method to display item details
    public void getItemDetails() {
        System.out.println("Item ID: " + itemId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }

    // Getter and Setter methods
    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

// Interface Reservable
interface Reservable {
    void reserveItem();

    boolean checkAvailability();
}

// Subclass Book
class Book extends LibraryItem implements Reservable {
    public Book(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 14; // 14 days loan duration
    }

    @Override
    public void reserveItem() {
        System.out.println("Book reserved");
    }

    @Override
    public boolean checkAvailability() {
        return true; // Assume always available for simplicity
    }
}

// Main class to demonstrate polymorphism
public class LibraryManagementSystem {
    public static void main(String[] args) {
        LibraryItem item1 = new Book("B001", "Java Programming", "John Doe");
        item1.getItemDetails();
        System.out.println("Loan Duration: " + item1.getLoanDuration() + " days");
        ((Reservable) item1).reserveItem();
    }
}