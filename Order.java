import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.time.LocalDate;

public class Order {
    private int orderId;
    private String orderDate;
    private String orderStatus = "Pending";
    private double orderTotal;
    private List<Book> orderItems;

    public Order() {
        this.orderId = generateOrderId();
        this.orderDate = LocalDate.now().toString();
        this.orderItems = new ArrayList<>();
    }

    // Generate a random order ID
    private static int generateOrderId() {
        Random random = new Random();
        return random.nextInt(99999) + 1; // Random ID between 1 and 99999
    }

    public int getOrderId() {
        return orderId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public void addBookToOrderInteractive(int bookId, List<Book> availableBooks, Scanner scanner) {
        // Find the book with the given ID in the availableBooks list
        for (Book book : availableBooks) {
            if (book.getId() == bookId) {
                System.out.println("Enter the quantity you want to order for: " + book.getName());

                // Validate quantity input
                while (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a valid quantity.");
                    scanner.next(); // Discard invalid input
                }
                int orderQuantity = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                if (book.getQuantity() >= orderQuantity) {
                    book.setQuantity(book.getQuantity() - orderQuantity); // Subtract stock
                    Book orderedBook = new Book(book.getId(), book.getName(), book.getAuthor(), orderQuantity, book.getPrice());
                    orderItems.add(orderedBook);
                    orderTotal += book.getPrice() * orderQuantity; // Update the total price
                    System.out.println("Book added to order: " + orderedBook);
                } else {
                    System.out.println("Insufficient stock for book: " + book.getName());
                }
                return;
            }
        }
        System.out.println("Book with ID " + bookId + " not found.");
    }

    public List<Book> getOrderItems() {
        return orderItems;
    }

    public void displayOrderDetails() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Order Date: " + orderDate);
        System.out.println("Order Status: " + orderStatus);
        System.out.println("Order Total: $" + String.format("%.2f", orderTotal));
        System.out.println("Order Items:");
        for (Book book : orderItems) {
            System.out.println(book);
        }
    }
}