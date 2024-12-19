import java.util.*;

public class App {

    public static void main(String[] args) {
        System.out.println("Welcome to the Online Bookstore!");

        // Initialize the bookstore with predefined books
        BookStore bookstore = new BookStore();

        // Menu implementation
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Bookstore Menu ---");
            System.out.println("1. View Available Books");
            System.out.println("2. Purchase a Book");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("\nAvailable Books:");
                    bookstore.displayBooks();
                    break;
                case 2:
                    System.out.print("Enter the book ID to purchase: ");
                    break;
                case 3:
                    System.out.println("Exiting... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);

        scanner.close();
    }
}

