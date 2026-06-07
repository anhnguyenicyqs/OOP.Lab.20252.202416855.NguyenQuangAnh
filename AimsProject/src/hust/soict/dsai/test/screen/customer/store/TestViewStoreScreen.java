package hust.soict.dsai.test.screen.customer.store;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.screen.customer.controller.ViewStoreController;
import hust.soict.dsai.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestViewStoreScreen extends Application {

    private static Store store;
    private static Cart  cart;

    @Override
    public void start(Stage primaryStage) throws Exception {
        final String STORE_FXML_FILE_PATH =
                "/hust/soict/dsai/aims/screen/customer/view/Store.fxml";

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
        ViewStoreController viewStoreController = new ViewStoreController(store, cart);
        fxmlLoader.setController(viewStoreController);
        Parent root = fxmlLoader.load();

        primaryStage.setTitle("Store");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        store = new Store();
        cart  = new Cart();

        store.addMedia(new DigitalVideoDisc(
                "Harry Potter and the Philosopher's Stone (2001)", "Fantasy", "Chris Columbus", 152, 3.0f));
        store.addMedia(new DigitalVideoDisc(
                "Harry Potter and the Chamber of Secrets (2002)", "Fantasy", "Chris Columbus", 161, 3.5f));
        store.addMedia(new DigitalVideoDisc(
                "Harry Potter and the Prisoner of Azkaban (2004)", "Fantasy", "Alfonso Cuaron", 141, 5.0f));
        store.addMedia(new DigitalVideoDisc(
                "Harry Potter and the Goblet of Fire (2005)", "Fantasy", "Mike Newell", 157, 4.5f));
        store.addMedia(new DigitalVideoDisc(
                "Harry Potter and the Order of the Phoenix (2007)", "Fantasy", "David Yates", 138, 6.5f));
        store.addMedia(new DigitalVideoDisc(
                "Harry Potter and the Half-Blood Prince (2009)", "Fantasy", "David Yates", 153, 5.8f));
        store.addMedia(new DigitalVideoDisc(
                "Harry Potter and the Deathly Hallows - Part 1 (2010)", "Fantasy", "David Yates", 146, 6.3f));
        store.addMedia(new DigitalVideoDisc(
                "Harry Potter and the Deathly Hallows - Part 2 (2011)", "Fantasy", "David Yates", 130, 7.0f));

        Book book = new Book("Green Eggs and Ham", "Children", 3.3f);
        book.addAuthor("Dr. Seuss");
        store.addMedia(book);

        CompactDisc cd = new CompactDisc("Abbey Road", "Rock", "George Martin", "The Beatles", 5.5f);
        cd.addTrack(new Track("Come Together", 4));
        cd.addTrack(new Track("Something", 3));
        store.addMedia(cd);

        launch(args);
    }
}
