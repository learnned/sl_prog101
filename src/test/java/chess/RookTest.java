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
}
