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
        System.out.println("2. Sort Books");
        System.out.println("3. Place an Order");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");

        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next();
        }
        choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                System.out.println("\nAvailable Books:");
                bookstore.displayBooks();
                break;

            case 2:
                System.out.println("\nChoose sorting criteria:");
                System.out.println("1. Name");
                System.out.println("2. Author");
                System.out.println("3. Quantity");
                System.out.println("4. Price");
                System.out.print("Enter your choice: ");

                int sortChoice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                String sortBy = "";
                switch (sortChoice) {
                    case 1:
                        sortBy = "name";
                        break;
                    case 2:
                        sortBy = "author";
                        break;
                    case 3:
                        sortBy = "quantity";
                        break;
                    case 4:
                        sortBy = "price";
                        break;
                    default:
                        System.out.println("Invalid choice. Returning to menu.");
                        continue;
                }

                BookSorter.insertionSort(bookstore.getBooks(), sortBy);
                System.out.println("\nBooks sorted by " + sortBy + ":");
                bookstore.displayBooks();
                break;

            case 3:
                System.out.println("\nPlacing an Order:");
                Order order = new Order();

                boolean addingBooks = true;
                while (addingBooks) {
                    System.out.println("Enter the book ID to order (or 0 to finish):");

                    while (!scanner.hasNextInt()) {
                        System.out.println("Invalid input. Please enter a valid book ID or 0 to finish.");
                        scanner.next();
                    }
                    int bookId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    if (bookId == 0) {
                        addingBooks = false;
                    } else {
                        order.addBookToOrderInteractive(bookId, bookstore.getBooks(), scanner);

                        System.out.println("Do you want to add more books? (yes/no):");
                        String decision = scanner.nextLine().trim().toLowerCase();

                        if (decision.equals("no")) {
                            addingBooks = false;
                        }
                    }
                }

                System.out.println("\nOrder Summary:");
                order.displayOrderDetails();
                break;

            case 4:
                System.out.println("Exiting... Goodbye!");
                break;

            default:
                System.out.println("Invalid choice. Please try again.");
        }
    } while (choice != 4);

    scanner.close();
}