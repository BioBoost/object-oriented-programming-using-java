package webshop;

public class Clothing extends Product {
    private String size = "M";
    
    public Clothing(String description, double price) {
        super(description, price);      // Call correct base class constructor FIRST !!!!
    }
    
    public void setSize(String size) { this.size = size; }
    
    public String getSize() { return size; }

    @Override
    public String toString() {
        // We can use the super keyword to specify we want to call a
        // method of the base class
        return super.toString() + " Size = " + size;
    }
}