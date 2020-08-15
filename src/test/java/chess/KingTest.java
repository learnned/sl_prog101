package chess;
import chess.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class KingTest {
    @Test
    public void testCreateKing() {
        Position pos = new Position(0, 0);
        King piece = new King(Color.BLACK, pos);
        assertNotNull(piece);
    }

    @Test
    public void testBlackKingToString() {
        Position pos = new Position(0, 0);
        King piece = new King(Color.BLACK, pos);
        String expected = "KB";
        String actual = piece.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testWhiteKingToString() {
        Position pos = new Position(0, 0);
        King piece = new King(Color.WHITE, pos);
        String expected = "KW";
        String actual = piece.toString();
        assertEquals(expected, actual);
    }
}
