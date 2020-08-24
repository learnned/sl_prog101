package chess;
import enums.Color;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    @Test
    public void testGetName() {
        Player player = new Player(Color.BLACK, true,"Pepe");
        String expected = "Pepe";
        String actual = player.getName();
        assertEquals(expected, actual);
    }

    @Test
    public void testShowWin() {
        Player player = new Player(Color.BLACK, true,"Pepe");
        String expected = "The winner is:Pepe";
        String actual = player.showWin();
        assertEquals(expected, actual);
    }
    @Test
    public void testShowLoser() {
        Player player = new Player(Color.BLACK, true,"Pepe");
        String expected = "The loser is:Pepe";
        String actual = player.showLoser();
        assertEquals(expected, actual);
    }
    @Test
    public void testShowSurrender() {
        Player player = new Player(Color.BLACK, true,"Pepe");
        String expected = "The player Pepe surrender";
        String actual = player.showSurrender();
        assertEquals(expected, actual);
    }
}
