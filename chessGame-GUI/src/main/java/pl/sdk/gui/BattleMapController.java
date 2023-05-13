package pl.sdk.gui;

import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import pl.sdk.GameEngine;
import pl.sdk.Piece;

import java.util.ArrayList;
import java.util.List;

public class BattleMapController {

    @FXML
    private GridPane gridMap;

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
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                ChessField rec = new ChessField();
                gridMap.add(rec, x, y);

                Piece p = gameEngine.get(x, y);
                if (p != null) {
                    rec.addPiece(p.getName());
                }
            }
        }
    }
}