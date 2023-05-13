package pl.sdk;

import java.util.ArrayList;
import java.util.List;

public class GameEngine {

    private final Board board;
    private final PieceTurnQueue queue;

    public GameEngine(List<Piece> aWhitePieces, List<Piece> aBlackPieces) {
        board = new Board();
        putPiecesToBoard(aWhitePieces, aBlackPieces);
        List<Piece> whitePieces = new ArrayList<>();
        List<Piece> blackPieces = new ArrayList<>();
        whitePieces.addAll(aWhitePieces);
        blackPieces.addAll(aBlackPieces);
        queue = new PieceTurnQueue(aWhitePieces, aBlackPieces);

    }

    public void move(Point aSourcePoint, Point aTargetPoint){
        board.move(aSourcePoint, aTargetPoint);
    }

    private void putPiecesToBoard(List<Piece> aWhitePieces, List<Piece> aBlackPieces) {
        putPiecesFromOneSideToBoard(aWhitePieces, 0);
        putPiecesFromOneSideToBoard(aBlackPieces, Board.HEIGHT-2);
    }


    private void putPiecesFromOneSideToBoard(List<Piece> aPieces, int aY) {
        for (int i = 0; i < (aPieces.size()-1)/2; i++) {
            board.add(new Point(i, aY), aPieces.get(i));
        }
        for (int i = 0; i < (aPieces.size()-1)/2; i++) {
            board.add(new Point(i, aY+1), aPieces.get(i));
        }
    }

    public Piece get(int aX, int aY) {
        return board.get(aX,aY);
    }
}
