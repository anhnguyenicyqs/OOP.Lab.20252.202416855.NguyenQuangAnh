package hust.soict.dsai.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

    @FXML
    private Pane drawingAreaPane;

    @FXML
    private RadioButton radioBtnPen;

    @FXML
    private RadioButton radioBtnEraser;

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        double x = event.getX();
        double y = event.getY();

        if (radioBtnEraser != null && radioBtnEraser.isSelected()) {
            Circle eraser = new Circle(x, y, 10, Color.WHITE);
            drawingAreaPane.getChildren().add(eraser);
        } else {
            Circle dot = new Circle(x, y, 4, Color.BLACK);
            drawingAreaPane.getChildren().add(dot);
        }
    }
}
