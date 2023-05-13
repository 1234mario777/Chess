package pl.sdk.gui;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ChessField extends Rectangle {

    public ChessField() {
        super(40, 40, Color.WHITE);
        setStroke(Color.BLACK);
    }
}