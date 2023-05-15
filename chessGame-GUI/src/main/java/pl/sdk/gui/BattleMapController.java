package pl.sdk.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import pl.sdk.GameEngine;
import pl.sdk.Piece;
import pl.sdk.Point;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BattleMapController implements PropertyChangeListener {

    @FXML
    private GridPane gridMap;

    @FXML
    private Button moveForwardButton;

    private final GameEngine gameEngine;

    public BattleMapController() {

        Piece white1 = new Piece();
        Piece white2 = new Piece();
        Piece black1 = new Piece();
        Piece black2 = new Piece();

        List<Piece> whitePieces = new ArrayList<>();
        whitePieces.add(white1);
        whitePieces.add(white2);
        whitePieces.add(new Piece());
        whitePieces.add(new Piece());
        whitePieces.add(new Piece());
        whitePieces.add(new Piece());
        whitePieces.add(new Piece());

        List<Piece> blackPieces = new ArrayList<>();
        blackPieces.add(black1);
        blackPieces.add(black2);
        blackPieces.add(new Piece());
        blackPieces.add(new Piece());
        blackPieces.add(new Piece());
        blackPieces.add(new Piece());
        blackPieces.add(new Piece());


        gameEngine = new GameEngine(whitePieces, blackPieces);
    }

    @FXML
    void initialize() {
        gameEngine.addObserver(GameEngine.CURRENT_PIECE_CHANGED,this);
        moveForwardButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {
            gameEngine.move(new Point(7,1), new Point(3,3));
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
//                if(p == gameEngine.getActivePieces().stream().filter(a -> gameEngine.getActivePieces().equals(p)).findAny().get()){
                if(gameEngine.getActivePieces().stream().anyMatch(a -> a.equals(p))){
                    rec.setBackground(Color.GREEN);
                }
            }
        }
    }
    @Override
    public void propertyChange(PropertyChangeEvent aPropertyChangeEvent) {
        refreshGui();
    }
}