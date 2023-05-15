package pl.sdk;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class PieceTurnQueue {

    private List<Piece> whitePieces;
    private List<Piece> blackPieces;
    private final Queue<List> piecesQueue;
    private List activePieces;

    public PieceTurnQueue(List<Piece> aWhitePieces, List<Piece> aBlackPieces) {
        whitePieces = aWhitePieces;
        blackPieces = aBlackPieces;
        piecesQueue = new LinkedList<>();
        initQueue();
        next();
    }

    private void initQueue() {
        piecesQueue.add(whitePieces);
        piecesQueue.add(blackPieces);
    }

    List getActivePieces() {
        return activePieces;
    }

    void next() {
        if (piecesQueue.isEmpty()) {
            initQueue();
        }
        activePieces = piecesQueue.poll();
    }
}
