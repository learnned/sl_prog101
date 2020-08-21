package chess;
import org.junit.Test;
import static org.junit.Assert.*;

public class QueenTest {
    @Test
    public void testCreateQueen() {
        Position pos = new Position(0, 0);
        ChessBoard chessBoard = new ChessBoard();
        Queen piece = new Queen(Color.BLACK, pos,chessBoard);
        assertNotNull(piece);
    }

    @Test
    public void testBlackQueenToString() {
        Position pos = new Position(0, 0);
        ChessBoard chessBoard = new ChessBoard();
        Queen piece = new Queen(Color.BLACK, pos,chessBoard);
        String expected = "QB";
        String actual = piece.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testWhiteQueenToString() {
        Position pos = new Position(0, 0);
        ChessBoard chessBoard = new ChessBoard();
        Queen piece = new Queen(Color.WHITE, pos,chessBoard);
        String expected = "QW";
        String actual = piece.toString();
        assertEquals(expected, actual);
    }
}
