package hust.soict.dsai.test.store;

import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;

public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        Book book = new Book("Clean Code", "Technology", 29.99f);
        book.addAuthor("Robert C. Martin");
        CompactDisc cd = new CompactDisc("Abbey Road", "Rock", "George Martin", "The Beatles", 15.99f);
        cd.addTrack(new Track("Come Together", 4));

        // Test add
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(book);
        store.addMedia(cd);
        store.print();

        // Test remove
        System.out.println("=== Remove Star Wars ===");
        store.removeMedia(dvd2);
        store.print();

        // Test remove not found
        System.out.println("=== Remove not found ===");
        store.removeMedia(dvd2);
    }
}
