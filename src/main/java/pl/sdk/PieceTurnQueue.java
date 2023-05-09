package pl.sdk;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PieceTurnQueue {

    private Collection<Piece> whitePieces;
    private Collection<Piece> blackPieces;
    private final Queue<Collection> piecesQueue;
    private Collection activePieces;

    public PieceTurnQueue(Collection<Piece> aWhitePieces, Collection<Piece> aBlackPieces) {
        whitePieces = aWhitePieces;
        blackPieces = aBlackPieces;
        piecesQueue = new LinkedList<>();
        piecesQueue.add(whitePieces);
        piecesQueue.add(blackPieces);
        next();
    }

    Collection getActivePieces() {
        return activePieces;
    }

    void next() {
        activePieces = piecesQueue.poll();
    }
}
