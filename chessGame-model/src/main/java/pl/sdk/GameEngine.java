package pl.sdk;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GameEngine {

    public static final String CURRENT_PIECE_CHANGED = "CURRENT_PIECE_CHANGED";
    private final Board board;
    private final PieceTurnQueue queue;
    private final PropertyChangeSupport observerSupport;


    public GameEngine(List<Piece> aWhitePieces, List<Piece> aBlackPieces) {
        board = new Board();
        putPiecesToBoard(aWhitePieces, aBlackPieces);
        List<Piece> whitePieces = new ArrayList<>();
        List<Piece> blackPieces = new ArrayList<>();
        whitePieces.addAll(aWhitePieces);
        blackPieces.addAll(aBlackPieces);
        queue = new PieceTurnQueue(aWhitePieces, aBlackPieces);
        observerSupport = new PropertyChangeSupport(this);
    }

    public void addObserver(String aEventType, PropertyChangeListener aObs){
        observerSupport.addPropertyChangeListener(aEventType, aObs);
    }

    public void removeObserver(PropertyChangeListener aObs){
        observerSupport.removePropertyChangeListener(aObs);
    }

    void notifyObservers(PropertyChangeEvent aEvent){
        observerSupport.firePropertyChange(aEvent);
    }

    public void move(Point aSourcePoint, Point aTargetPoint){
        board.move(aSourcePoint, aTargetPoint);
    }

    private void putPiecesToBoard(List<Piece> aWhitePieces, List<Piece> aBlackPieces) {
        putPiecesFromOneSideToBoard(aWhitePieces, Board.HEIGHT-2);
        putPiecesFromOneSideToBoard(aBlackPieces, 0);
    }


    private void putPiecesFromOneSideToBoard(List<Piece> aPieces, int aY) {
        for (int i = 0; i < (aPieces.size())/2; i++) {
            board.add(new Point(i, aY), aPieces.get(i));
        }
        for (int i = (int) Math.ceil((aPieces.size())/2); i < (aPieces.size()); i++) {
            board.add(new Point(i - (int) Math.ceil((aPieces.size())/2), aY+1), aPieces.get(i));
        }
    }

    public Piece get(int aX, int aY) {
        return board.get(aX,aY);
    }

    public List getActivePieces() {
        return queue.getActivePieces();
    }

}
