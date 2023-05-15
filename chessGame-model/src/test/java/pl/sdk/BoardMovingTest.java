package pl.sdk;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardMovingTest {

    private Board board;
    private Piece piece;

    @BeforeEach
    void init() {
        board = new Board();
        piece = new Piece();
        board.add(new Point(1,1), piece);
    }

    @Test
    void pieceCanMove() {
        board.move(new Point(1,1), new Point(2,2));

        Piece pieceFromBoard = board.get(2,2);

        assertEquals(pieceFromBoard, piece);
        assertNull(board.get(1,1));
    }

    @Test
    void throwExceptionWhenFieldIsNotEmpty() {
        Piece piece1 = new Piece();
        board.add(new Point(1,2), piece1);

        board.move(new Point(1, 2), new Point(1, 1));

        Piece PieceFromBoard = board.get(1, 1);
        assertEquals(piece1, PieceFromBoard);

        assertEquals(piece1, PieceFromBoard);
    }

}
