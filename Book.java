public class Book {
    private int id;
    private String name;
    private String author;
    private int Stockquantity;
    private double price;

    public Book(int id, String name, String author, int Stockquantity, double price) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.Stockquantity = Stockquantity;
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
        return Stockquantity;
    }

    public double getPrice() {
        return price;
    }

    public void setQuantity(int Stockquantity) {
        this.Stockquantity = Stockquantity;
    }

    public boolean inStock(int quantity) {
        if (Stockquantity >= quantity) {
            Stockquantity -= quantity;
            return true;
        }else {
            System.out.println("Sorry, the book is out of stock");
            return false;
        }
        
    }

    public String toString() {
        return 
                id +
                "," + name +
                "," + author +
                "," + Stockquantity +
                "," + price ;
    }
}

