package hust.soict.dsai.test.cart;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;

public class CartTest {
    public static void main(String[] args) {
        Cart cart = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);

        cart.addMedia(dvd1);
        cart.addMedia(dvd2);
        cart.addMedia(dvd3);

        // Test print
        cart.print();

        // Test search by ID
        System.out.println("=== Search by ID: 1 ===");
        cart.searchById(1);

        System.out.println("=== Search by ID: 99 ===");
        cart.searchById(99);

        // Test search by title
        System.out.println("=== Search by title: 'star' ===");
        cart.searchByTitle("star");

        System.out.println("=== Search by title: 'xyz' ===");
        cart.searchByTitle("xyz");

        // Test add duplicate
        System.out.println("=== Add duplicate ===");
        cart.addMedia(dvd1);

        // Test remove
        System.out.println("=== Remove Star Wars ===");
        cart.removeMedia(dvd2);
        cart.print();

        // Test sort by title
        System.out.println("=== Sort by title ===");
        cart.sortByTitleCost();

        // Test sort by cost
        System.out.println("=== Sort by cost ===");
        cart.sortByCostTitle();

        // Test with Book and CD
        Book book = new Book("Clean Code", "Technology", 29.99f);
        book.addAuthor("Robert C. Martin");

        CompactDisc cd = new CompactDisc("Abbey Road", "Rock", "George Martin", "The Beatles", 15.99f);
        cd.addTrack(new Track("Come Together", 4));
        cd.addTrack(new Track("Something", 3));

        cart.addMedia(book);
        cart.addMedia(cd);
        cart.print();
    }
}
