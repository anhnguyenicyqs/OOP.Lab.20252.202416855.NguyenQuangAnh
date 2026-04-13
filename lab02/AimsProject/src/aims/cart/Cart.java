package aims.cart;

import aims.media.DigitalVideoDisc;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;

    // Section 11: Add a single DVD
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered == MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is full. Cannot add more DVDs.");
        } else {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc \"" + disc.getTitle() + "\" has been added to the cart.");
            if (qtyOrdered == MAX_NUMBERS_ORDERED) {
                System.out.println("The cart is almost full.");
            }
        }
    }

    // Section 14.1: Overloading - add an array of DVDs
    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
        for (DigitalVideoDisc disc : dvdList) {
            if (disc != null) addDigitalVideoDisc(disc);
        }
    }

    // Section 14.2: Overloading - add two DVDs at once
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        addDigitalVideoDisc(dvd1);
        addDigitalVideoDisc(dvd2);
    }

    // Section 11 & 13: Remove a DVD
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i] == disc) {
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                itemsOrdered[qtyOrdered - 1] = null;
                qtyOrdered--;
                found = true;
                System.out.println("The disc \"" + disc.getTitle() + "\" has been removed from the cart.");
                break;
            }
        }
        if (!found) {
            System.out.println("The disc \"" + disc.getTitle() + "\" was not found in the cart.");
        }
    }

    // Section 11: Total cost
    public float totalCost() {
        float total = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i] != null) total += itemsOrdered[i].getCost();
        }
        return total;
    }

    // Section 12: Display cart with numbered list
    public void displayCart() {
        System.out.println("\n===== Cart Contents =====");
        for (int i = 0; i < qtyOrdered; i++) {
            System.out.printf("%-5d %-30s %.2f%n",
                    (i + 1),
                    itemsOrdered[i].getTitle(),
                    itemsOrdered[i].getCost());
        }
        System.out.printf("%-5s %-30s %.2f%n", "", "Total Cost", totalCost());
        System.out.println("=========================\n");
    }

    public int getQtyOrdered() { return qtyOrdered; }
}