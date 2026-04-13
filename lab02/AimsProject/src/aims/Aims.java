package aims;

import aims.cart.Cart;
import aims.media.DigitalVideoDisc;

public class Aims {
    public static void main(String[] args) {

        // Section 12: Create cart and add DVDs
        Cart anOrder = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        anOrder.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        anOrder.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", "Ron Clements", 90, 18.99f);
        anOrder.addDigitalVideoDisc(dvd3);

        anOrder.displayCart();

        // Section 13: Remove item and display again
        System.out.println(">> Removing 'Star Wars'...");
        anOrder.removeDigitalVideoDisc(dvd2);
        anOrder.displayCart();

        // Section 14: Overloaded add (two DVDs at once)
        System.out.println(">> Adding two DVDs at once...");
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Frozen", "Animation", "Chris Buck", 102, 15.99f);
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("Interstellar", "Sci-Fi", "Christopher Nolan", 169, 22.50f);
        anOrder.addDigitalVideoDisc(dvd4, dvd5);
        anOrder.displayCart();

        // Section 16: Classifier member
        System.out.println("Total DVDs created: " + DigitalVideoDisc.getNbDigitalVideoDiscs());
    }
}