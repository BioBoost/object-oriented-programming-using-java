package webshop;

public class Product {
    private String description = "";
    private double price = 0;
    private int id = 0;
    
    public Product(String descrString, double price) {
        this.description = descrString;
        this.price = price;
    }
    
    public String getDescription() { return description; }
    public double getPrice() { return price; }
    public int getId() { return id; }
    
    public void setId(int id) { this.id = id; }
    
    @Override
    public String toString() {
        return "|" + id + "| " + description + " [" + price + "eur]";
    }
}
