package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;

import java.util.Scanner;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Add some sample media to store
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        Book book1 = new Book("Clean Code", "Technology", 29.99f);
        book1.addAuthor("Robert C. Martin");
        CompactDisc cd1 = new CompactDisc("Abbey Road", "Rock", "George Martin", "The Beatles", 15.99f);
        cd1.addTrack(new Track("Come Together", 4));
        cd1.addTrack(new Track("Something", 3));
        store.addMedia(dvd1); store.addMedia(dvd2);
        store.addMedia(book1); store.addMedia(cd1);

        int choice = -1;
        while (choice != 0) {
            showMenu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1: viewStore(); break;
                case 2: updateStore(); break;
                case 3: seeCart(); break;
                case 0: System.out.println("Goodbye!"); break;
                default: System.out.println("Invalid choice.");
            }
        }
    }

    static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3: ");
    }

    static void viewStore() {
        store.print();
        System.out.println("Options: ");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.print("Please choose: ");
        int opt = scanner.nextInt(); scanner.nextLine();
        switch (opt) {
            case 1:
                System.out.print("Enter title: ");
                String t1 = scanner.nextLine();
                for (Media m : store.getItemsInStore()) {
                    if (m.isMatch(t1)) { System.out.println(m.toString()); return; }
                }
                System.out.println("Not found.");
                break;
            case 2:
                System.out.print("Enter title to add to cart: ");
                String t2 = scanner.nextLine();
                for (Media m : store.getItemsInStore()) {
                    if (m.isMatch(t2)) { cart.addMedia(m); return; }
                }
                System.out.println("Not found.");
                break;
            case 3:
                System.out.print("Enter title to play: ");
                String t3 = scanner.nextLine();
                for (Media m : store.getItemsInStore()) {
                    if (m.isMatch(t3) && m instanceof Playable) { ((Playable) m).play(); return; }
                }
                System.out.println("Not found or not playable.");
                break;
            case 4: seeCart(); break;
        }
    }

    static void updateStore() {
        System.out.println("1. Add media  2. Remove media  0. Back");
        System.out.print("Choose: ");
        int opt = scanner.nextInt(); scanner.nextLine();
        if (opt == 1) {
            System.out.print("Enter title: ");
            String title = scanner.nextLine();
            store.addMedia(new DigitalVideoDisc(title));
        } else if (opt == 2) {
            System.out.print("Enter title to remove: ");
            String title = scanner.nextLine();
            for (Media m : store.getItemsInStore()) {
                if (m.isMatch(title)) { store.removeMedia(m); return; }
            }
            System.out.println("Not found.");
        }
    }

    static void seeCart() {
        cart.print();
        System.out.println("1. Filter  2. Sort  3. Remove  4. Play  5. Place order  0. Back");
        System.out.print("Choose: ");
        int opt = scanner.nextInt(); scanner.nextLine();
        switch (opt) {
            case 1:
                System.out.println("1. By ID  2. By title");
                int f = scanner.nextInt(); scanner.nextLine();
                if (f == 1) { System.out.print("Enter ID: "); cart.searchById(scanner.nextInt()); scanner.nextLine(); }
                else { System.out.print("Enter title: "); cart.searchByTitle(scanner.nextLine()); }
                break;
            case 2:
                System.out.println("1. By title  2. By cost");
                int s = scanner.nextInt();
                if (s == 1) cart.sortByTitleCost(); else cart.sortByCostTitle();
                break;
            case 3:
                System.out.print("Enter title to remove: ");
                String rt = scanner.nextLine();
                for (Media m : cart.getItemsOrdered()) {
                    if (m.isMatch(rt)) { cart.removeMedia(m); return; }
                }
                System.out.println("Not found.");
                break;
            case 4:
                System.out.print("Enter title to play: ");
                String pt = scanner.nextLine();
                for (Media m : cart.getItemsOrdered()) {
                    if (m.isMatch(pt) && m instanceof Playable) { ((Playable) m).play(); return; }
                }
                System.out.println("Not found or not playable.");
                break;
            case 5:
                System.out.println("Order placed! Cart is now empty.");
                cart.getItemsOrdered().clear();
                break;
        }
    }
}
