public class App {

    public static void main(String[] args) {
        System.out.println("Welcome to the Online Bookstore!");

        // Initialize the bookstore with predefined books
        BookStore bookstore = new BookStore();

        // Display the list of available books
        System.out.println("\nAvailable Books in the Bookstore:");
        bookstore.displayBooks();
    }
}
