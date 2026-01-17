import java.io.Serializable;

public class Product implements Serializable {
    private static final long serialVersionUID = 1L; // Ensures version compatibility during serialization
    private String sku;
    private String name;
    private int quantity;
    private double price;

    public Product(String sku, String name, int quantity, double price) {
        this.sku = sku;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    // Helper method for CSV Export
    public String toCsv() {
        return sku + "," + name + "," + quantity + "," + price;
    }

    @Override
    public String toString() {
        return "SKU: " + sku + " | Name: " + name + " | Qty: " + quantity + " | Price: $" + price;
    }
}