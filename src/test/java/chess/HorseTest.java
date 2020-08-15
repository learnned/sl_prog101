package chess;
import chess.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class HorseTest {
    @Test
    public void testCreateHorse() {
        Position pos = new Position(0, 0);
        Horse piece = new Horse(Color.BLACK, pos);
        assertNotNull(piece);
    }

    @Test
    public void testBlackHorseToString() {
        Position pos = new Position(0, 0);
        Horse piece = new Horse(Color.BLACK, pos);
        String expected = "HB";
        String actual = piece.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testWhiteHorseToString() {
        Position pos = new Position(0, 0);
        Horse piece = new Horse(Color.WHITE, pos);
        String expected = "HW";
        String actual = piece.toString();
        assertEquals(expected, actual);
    }
}
