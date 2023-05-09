package pl.sdk;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class PieceTurnQueueTest {

    private Piece white1;
    private Piece white2;
    private Piece black1;
    private Piece black2;
    private Collection<Piece> whitePieces;
    private Collection<Piece> blackPieces;

    @BeforeEach
    void init(){
        whitePieces = new ArrayList<>();
        whitePieces.add(white1);
        whitePieces.add(white2);
        blackPieces = new ArrayList<>();
        blackPieces.add(black1);
        blackPieces.add(black2);


    }

    @Test
    void shouldChangeActivePieces(){
        PieceTurnQueue piecesTurnQueue = new PieceTurnQueue(whitePieces, blackPieces);

        assertEquals(whitePieces, piecesTurnQueue.getActivePieces());
        piecesTurnQueue.next();

        assertEquals(blackPieces, piecesTurnQueue.getActivePieces());
        piecesTurnQueue.next();

        assertEquals(whitePieces, piecesTurnQueue.getActivePieces());
        piecesTurnQueue.next();

        assertEquals(blackPieces, piecesTurnQueue.getActivePieces());
    }
}