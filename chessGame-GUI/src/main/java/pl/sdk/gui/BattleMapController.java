package pl.sdk.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import pl.sdk.GameEngine;
import pl.sdk.Piece;
import pl.sdk.Point;

import java.util.ArrayList;
import java.util.List;

public class BattleMapController {

    @FXML
    private GridPane gridMap;

    @FXML
    private Button moveForwardButton;

    private final GameEngine gameEngine;

    public BattleMapController() {
        List<Piece> whitePieces = new ArrayList<>();
        whitePieces.add(new Piece());
        whitePieces.add(new Piece());
        whitePieces.add(new Piece());

        List<Piece> blackPieces = new ArrayList<>();
        blackPieces.add(new Piece());
        blackPieces.add(new Piece());
        blackPieces.add(new Piece());


        gameEngine = new GameEngine(whitePieces, blackPieces);
    }

    @FXML
    void initialize() {
        moveForwardButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {
            gameEngine.move(new Point(1,1), new Point(3,3));
            refreshGui();
        });

        refreshGui();
    }

    private void refreshGui() {
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                ChessField rec = new ChessField();
                gridMap.add(rec, x, y);

                Piece p = gameEngine.get(x, y);
                if (p != null) {
                    rec.addPiece(p.getName());
                }
                if(p == gameEngine.getActivePieces()){
                    rec.setBackground(Color.GREEN);
                }
            }
        }
    }
}