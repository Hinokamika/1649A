import java.util.List;

public class BookSorter {

    // Sort books by a specified field using Insertion Sort
    public static void insertionSort(List<Book> books, String sortBy) {
        for (int i = 1; i < books.size(); i++) {
            Book key = books.get(i);
            int j = i - 1;

            // Compare and shift elements to find the correct position
            while (j >= 0 && compare(books.get(j), key, sortBy) > 0) {
                books.set(j + 1, books.get(j));
                j--;
            }

            // Place the key in its correct position
            books.set(j + 1, key);
        }
    }

    // Helper method to compare two books based on the sorting field
    private static int compare(Book book1, Book book2, String sortBy) {
        switch (sortBy.toLowerCase()) {
            case "id":
                return book1.getId() - book2.getId();
            case "name":
                return book1.getName().compareTo(book2.getName());
            case "author":
                return book1.getAuthor().compareTo(book2.getAuthor());
            case "quantity":
                return book1.getQuantity() - book2.getQuantity();
            case "price":
                return Double.compare(book1.getPrice(), book2.getPrice());
            default:
                throw new IllegalArgumentException("Invalid sorting criteria: " + sortBy);
        }
    }
}
