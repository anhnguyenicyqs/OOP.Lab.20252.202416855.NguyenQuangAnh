package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.media.Media;
import java.util.ArrayList;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<>();

    public void addMedia(Media media) {
        itemsInStore.add(media);
        System.out.println("Added \"" + media.getTitle() + "\" to store.");
    }

    public void removeMedia(Media media) {
        if (itemsInStore.remove(media)) {
            System.out.println("Removed \"" + media.getTitle() + "\" from store.");
        } else {
            System.out.println("\"" + media.getTitle() + "\" not found in store.");
        }
    }

    public void print() {
        System.out.println("===== STORE =====");
        for (int i = 0; i < itemsInStore.size(); i++) {
            System.out.println((i + 1) + ". " + itemsInStore.get(i).toString());
        }
        System.out.println("=================");
    }

    public ArrayList<Media> getItemsInStore() { return itemsInStore; }
}
