package pl.sdk;

import java.util.ArrayList;
import java.util.List;

public class GameEngine {

    private final Board board;

    GameEngine(List<Piece> aPieces1, List<Piece> aPieces2) {
        board = new Board();
        putPiecesToBoard(aPieces1, aPieces2);
        List<Piece> twoSidesPieces = new ArrayList<>();
        twoSidesPieces.addAll(aPieces1);
        twoSidesPieces.addAll(aPieces2);
    }

    void move(Point aSourcePoint, Point aTargetPoint){
        board.move(aSourcePoint, aTargetPoint);
    }

    private void putPiecesToBoard(List<Piece> aPieces1, List<Piece> aPieces2) {
        putPiecesFromOneSideToBoard(aPieces1, 0);
        putPiecesFromOneSideToBoard(aPieces2, Board.HEIGHT-2);
    }


    private void putPiecesFromOneSideToBoard(List<Piece> aPieces, int aY) {
        for (int i = 0; i < (aPieces.size()-1)/2; i++) {
            board.add(new Point(i, aY), aPieces.get(i));
        }
        for (int i = 0; i < (aPieces.size()-1)/2; i++) {
            board.add(new Point(i, aY+1), aPieces.get(i));
        }
    }
}
