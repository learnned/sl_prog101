//pacckage chess;
import org.junit.Test;
import static org.junit.Assert.*;

public class QueenTest {
    @Test
    public void testCreateQueen() {
        Position pos = new Position(0, 0);
        Queen piece = new Queen(Color.BLACK, pos);
        assertNotNull(piece);
    }

    @Test
    public void testBlackQueenToString() {
        Position pos = new Position(0, 0);
        Queen piece = new Queen(Color.BLACK, pos);
        String expected = "QB";
        String actual = piece.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testWhiteQueenToString() {
        Position pos = new Position(0, 0);
        Queen piece = new Queen(Color.WHITE, pos);
        String expected = "QW";
        String actual = piece.toString();
        assertEquals(expected, actual);
    }
}
