package pl.sdk;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void ShouldAddPieceOnBoard() {

        Board board = new Board();
        Piece piece = new Piece();

        board.add(new Point(1,1), piece);

        Piece pieceFromBoard = board.get(1, 1);
        assertEquals(piece, pieceFromBoard);
    }

}