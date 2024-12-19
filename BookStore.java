import java.util.ArrayList;
import java.util.List;

public class BookStore {
    private List<Book> books;

    public BookStore() {
        this.books = initializeBookStore();
    }

    private List<Book> initializeBookStore() {
        List<Book> books = new ArrayList<>();
        books.add(new Book(1, "The Great Gatsby", "F. Scott Fitzgerald", 10, 12.99));
        books.add(new Book(2, "To Kill a Mockingbird", "Harper Lee", 20, 9.99));
        books.add(new Book(3, "Pride and Prejudice", "Jane Austen", 15, 8.99));
        return books;
    }

    public void displayBooks() {
        System.out.println("Books available in the store:");
        for (Book book : books) {
            System.out.println(book);
        }
    }
}
