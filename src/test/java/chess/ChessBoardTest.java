package chess;
import org.junit.Test;
import static org.junit.Assert.*;

public class ChessBoardTest {

    final static int VISUALITATION_MODE = 0;

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
                    actual += chessboard.getBoard()[i][j].toString(VISUALITATION_MODE);
                }
            }
        }
        final String expected = "RBHBBBQBKBBBHBRB" +
                                "PBPBPBPBPBPBPBPB" +
                                "                " +
                                "                " +
                                "                " +
                                "                " +
                                "PWPWPWPWPWPWPWPW" +
                                "RWHWBWQWKWBWHWRW";
        assertEquals(expected, actual);
    }
}
