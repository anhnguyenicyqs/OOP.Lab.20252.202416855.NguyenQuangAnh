package hust.soict.dsai.test;

import hust.soict.dsai.aims.media.*;
import java.util.ArrayList;
import java.util.List;

public class PolymorphismDemo {
    public static void main(String[] args) {
        List<Media> mediae = new ArrayList<Media>();

        // Tạo các media
        CompactDisc cd = new CompactDisc("Abbey Road", "Rock", "George Martin", "The Beatles", 15.99f);
        cd.addTrack(new Track("Come Together", 4));
        cd.addTrack(new Track("Something", 3));

        DigitalVideoDisc dvd = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);

        Book book = new Book("Clean Code", "Technology", 29.99f);
        book.addAuthor("Robert C. Martin");

        mediae.add(cd);
        mediae.add(dvd);
        mediae.add(book);

        // Polymorphism: cùng gọi toString() nhưng mỗi class in ra khác nhau
        System.out.println("=== Polymorphism with toString() ===");
        for (Media m : mediae) {
            System.out.println(m.toString());
        }

        // Polymorphism với play()
        System.out.println("\n=== Polymorphism with play() ===");
        for (Media m : mediae) {
            if (m instanceof Playable) {
                ((Playable) m).play();
                System.out.println();
            }
        }
    }
}
