package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.exception.LimitExceededException;
import hust.soict.dsai.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.Collections;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

    public void addMedia(Media media) throws LimitExceededException {
        if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
            throw new LimitExceededException("ERROR: The number of media has reached its limit");
        } else if (itemsOrdered.contains(media)) {
            System.out.println("\"" + media.getTitle() + "\" is already in the cart.");
        } else {
            itemsOrdered.add(media);
            System.out.println("Added \"" + media.getTitle() + "\" to cart. Total items: " + itemsOrdered.size());
        }
    }

    public void removeMedia(Media media) {
        if (itemsOrdered.remove(media)) {
            System.out.println("Removed \"" + media.getTitle() + "\" from cart.");
        } else {
            System.out.println("\"" + media.getTitle() + "\" not found in cart.");
        }
    }

    public float totalCost() {
        float total = 0;
        for (Media m : itemsOrdered) total += m.getCost();
        return total;
    }

    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < itemsOrdered.size(); i++) {
            System.out.println((i + 1) + ". " + itemsOrdered.get(i).toString());
        }
        System.out.printf("Total cost: %.2f%n", totalCost());
        System.out.println("***************************************************");
    }

    public void searchById(int id) {
        boolean found = false;
        for (Media m : itemsOrdered) {
            if (m.getId() == id) {
                System.out.println("Found: " + m.toString());
                found = true;
                break;
            }
        }
        if (!found) System.out.println("No media found with ID: " + id);
    }

    public void searchByTitle(String title) {
        boolean found = false;
        for (Media m : itemsOrdered) {
            if (m.isMatch(title)) {
                System.out.println("Found: " + m.toString());
                found = true;
            }
        }
        if (!found) System.out.println("No media found with title: " + title);
    }

    public void sortByTitleCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
        System.out.println("Sorted by title then cost.");
        print();
    }

    public void sortByCostTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
        System.out.println("Sorted by cost then title.");
        print();
    }

    public ObservableList<Media> getItemsOrdered() { return itemsOrdered; }
}
