public class Book {
    private int id;
    private String name;
    private String author;
    private int stockQuantity;
    private double price;

    public Book(int id, String name, String author, int stockQuantity, double price) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.stockQuantity = stockQuantity;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getQuantity() {
        return stockQuantity;
    }

    public double getPrice() {
        return price;
    }

    public void setQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + author + "," + stockQuantity + "," + price;
    }
}
