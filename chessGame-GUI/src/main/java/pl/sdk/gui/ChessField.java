package pl.sdk.gui;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class ChessField extends StackPane {

    private final Rectangle rec;


    public ChessField() {
        rec = new Rectangle(40, 40, Color.WHITE);
        rec.setStroke(Color.BLACK);
        getChildren().add(rec);
    }

    void addPiece(String aName){
        getChildren().add(new Text(aName));
    }

    void setBackground(Color aColor){
        rec.setFill(aColor);
    }
}