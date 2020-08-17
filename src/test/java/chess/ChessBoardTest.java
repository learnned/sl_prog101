package chess;
import org.junit.Test;
import static org.junit.Assert.*;

public class ChessBoardTest {

    @Test
    public void testCreateChessBoard() {
        ChessBoard chessboard = new ChessBoard();
        assertNotNull(chessboard);
    }

    @Test
    public void testCreatePieces() {
        ChessBoard chessboard = new ChessBoard();
        String actual = "";
        for (int j = 7; j >= 0; j--) {
            for (int i = 0; i < 8; i++) {
                if (chessboard.getBoard()[i][j] == null) {
                    actual += "  ";
                } else {
                    actual += chessboard.getBoard()[i][j].toString();
                }
            }
        }
        final String expected = "RBHBBBQBKBBBHBRB" +
                                "pBpBpBpBpBpBpBpB" +
                                "                " +
                                "                " +
                                "                " +
                                "                " +
                                "pWpWpWpWpWpWpWpW" +
                                "RWHWBWQWKWBWHWRW";
        assertEquals(expected, actual);
    }
}
