package hust.soict.dsai.aims.screen.customer.controller;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.LimitExceededException;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class ItemController {

    @FXML
    private Label lblTitle;

    @FXML
    private Label lblCost;

    @FXML
    private Button btnAddToCart;

    @FXML
    private Button btnPlay;

    private Cart cart;
    private Media media;

    public ItemController(Cart cart) {
        this.cart = cart;
    }

    public void setData(Media media) {
        this.media = media;
        lblTitle.setText(media.getTitle());
        lblCost.setText(media.getCost() + " $");
        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
            HBox.setMargin(btnAddToCart, new Insets(0, 0, 0, 60));
        }
    }

    @FXML
    void btnAddToCartClicked(ActionEvent event) {
        try {
            cart.addMedia(media);
        } catch (LimitExceededException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Cart Full");
            alert.setHeaderText("Cannot add item");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void btnPlayClicked(ActionEvent event) {
        if (media instanceof Playable) {
            try {
                ((Playable) media).play();
            } catch (PlayerException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Play Error");
                alert.setHeaderText("Cannot play media");
                alert.setContentText(e.getMessage());
                alert.showAndWait();
            }
        }
    }
}
