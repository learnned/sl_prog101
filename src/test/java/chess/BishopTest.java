package chess;
import chess.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class BishopTest {
    @Test
    public void testCreateBishop() {
        Position pos = new Position(0, 0);
        Bishop piece = new Bishop(Color.BLACK, pos);
        assertNotNull(piece);
    }

    @Test
    public void testBlackBishopToString() {
        Position pos = new Position(0, 0);
        Bishop piece = new Bishop(Color.BLACK, pos);
        String expected = "BB";
        String actual = piece.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testWhiteBishopToString() {
        Position pos = new Position(0, 0);
        Bishop piece = new Bishop(Color.WHITE, pos);
        String expected = "BW";
        String actual = piece.toString();
        assertEquals(expected, actual);
    }
}
