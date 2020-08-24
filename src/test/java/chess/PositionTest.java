package chess;
import pieces.Position;

import org.junit.Test;
import static org.junit.Assert.*;


public class PositionTest {

    @Test
    public void testCreateKing() {
        Position pos = new Position(0, 0);
        assertNotNull(pos);
    }
}
