package webshop;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class WebShop {

    public static void main(String[] args) throws ParseException {
        // Some date helper object
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        // Creating a Food object
        Food canOfTomatoSoup = new Food("Can of tomato soup with meat balls",
                2.99, dateFormat.parse("21/12/2034"));
        
        // Creating a Food object that has expired
        Food chips = new Food("Lays paprika chips",
                1.30, dateFormat.parse("10/1/2016"));

        // Creating a piece of clothing
        Clothing socks = new Clothing("Pair of black socks for men", 3.45);

        // Changing the size of clothing piece
        Clothing metallicaShirt = new Clothing("Cool t-shirt of Metallica", 18.99);
        metallicaShirt.setSize("XL");

        // Lets print everything
        System.out.println(canOfTomatoSoup);
        System.out.println(chips);
        System.out.println(socks);
        System.out.println(metallicaShirt);
    }
    
}
