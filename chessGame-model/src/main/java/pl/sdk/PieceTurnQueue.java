package pl.sdk;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

class PieceTurnQueue {

    private Collection<Piece> whitePieces;
    private Collection<Piece> blackPieces;
    private final Queue<Collection> piecesQueue;
    private Collection activePieces;

    public PieceTurnQueue(Collection<Piece> aWhitePieces, Collection<Piece> aBlackPieces) {
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

    Collection getActivePieces() {
        return activePieces;
    }

    void next() {
        if (piecesQueue.isEmpty()) {
            initQueue();
        }
        activePieces = piecesQueue.poll();
    }
}
