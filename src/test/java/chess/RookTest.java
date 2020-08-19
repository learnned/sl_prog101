package chess;
import chess.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class RookTest {
    @Test
    public void testCreateRook() {
        Position pos = new Position(0, 0);
        Rook piece = new Rook(Color.BLACK, pos);
        assertNotNull(piece);
    }

    @Test
    public void testBlackRookToString() {
        Position pos = new Position(0, 0);
        Rook piece = new Rook(Color.BLACK, pos);
        String expected = "RB";
        String actual = piece.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testWhiteRookToString() {
        Position pos = new Position(0, 0);
        Rook piece = new Rook(Color.WHITE, pos);
        String expected = "RW";
        String actual = piece.toString();
        assertEquals(expected, actual);
    }
  /*  @Test
    public void testMoveRook() {
        ChessBoard chessBoard = new ChessBoard();
        Rook piece = (Rook) chessBoard.getBoard()[0][0];
        Position expected = piece.getPosition();
        Pawn pawn = (Pawn) chessBoard.getBoard()[0][1];
        piece.move(pawn);
        Position actual = piece.getPosition();
        assertEquals(expected, actual);
    }*/
}
