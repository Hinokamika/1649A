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
        books.add(new Book(4, "The Catcher in the Rye", "J.D. Salinger", 12, 11.99));
        books.add(new Book(5, "1984", "George Orwell", 18, 14.99));
        books.add(new Book(6, "The Lord of the Rings", "J.R.R. Tolkien", 25, 19.99));
        books.add(new Book(7, "The Hobbit", "J.R.R. Tolkien", 22, 16.99));
        return books;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void displayBooks() {
        System.out.println("Books available in the store:");
        for (Book book : books) {
            System.out.println(book);
        }
    }
}
