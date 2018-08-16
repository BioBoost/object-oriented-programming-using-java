package webshop;

import java.util.Date;

public class Food extends Product {
    private Date expirationDate;

    public Food(String description, double price, Date expirationDate) {
        super(description, price);    // Call baseclass constructor FIRST !!!!

        // Rest of initialization for Food
        this.expirationDate = expirationDate;
    }

    public Date getExpirationDate() { return expirationDate; }
    
    public boolean hasExpired() {
        Date today = new Date();
        return expirationDate.before(today);
    }

    @Override
    public String toString() {
        String output = super.toString() + " Expires at " + expirationDate;
        if (hasExpired()) {
            output += " => HAS EXPIRED!";
        }
        return output;
    }
}
