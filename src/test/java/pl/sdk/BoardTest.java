package pl.sdk;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    private Board board;
    private Piece piece;

    @BeforeEach
    void init() {
        board = new Board();
        piece = new Piece();
    }

    @Test
    void shouldAddPieceOnBoard() {
        board.add(new Point(1,1), piece);

        Piece pieceFromBoard = board.get(1, 1);
        assertEquals(piece, pieceFromBoard);
    }

    @Test
    void shouldReturnNullWhenPointIsEmpty() {
        Piece pieceFromBoard = board.get(1, 1);
        assertNull(pieceFromBoard);
    }

    @Test
    void shouldThrowExceptionWhenFieldIsNotEmpty() {
        board.add(new Point(1,1), piece);

        Piece piece1 = new Piece();
        board.add(new Point(1,1), piece1);

        Piece pieceFromBoard = board.get(1, 1);

        assertEquals(piece, pieceFromBoard);



    }

}