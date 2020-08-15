package chess;
import chess.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class PawnTest {
    @Test
    public void testCreatePawn() {
        Position pos = new Position(0, 0);
        Pawn piece = new Pawn(Color.BLACK, pos);
        assertNotNull(piece);
    }

    @Test
    public void testBlackPawnToString() {
        Position pos = new Position(0, 0);
        Pawn piece = new Pawn(Color.BLACK, pos);
        String expected = "pB";
        String actual = piece.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testWhitePawnToString() {
        Position pos = new Position(0, 0);
        Pawn piece = new Pawn(Color.WHITE, pos);
        String expected = "pW";
        String actual = piece.toString();
        assertEquals(expected, actual);
    }
}
