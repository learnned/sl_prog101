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

    @Test
    public void testMoveBishop() {
        ChessBoard chessBoard = new ChessBoard(new Bishop(Color.WHITE,new Position(4,4)));
        Bishop piece = (Bishop) chessBoard.getBoard()[4][4];
        boolean po= piece.move(new Position(0,0),chessBoard);
        assertTrue(po);
    }
    @Test
    public void testMoveLeftUpBishop() {
        ChessBoard chessBoard = new ChessBoard(new Bishop(Color.WHITE,new Position(4,4)));
        Bishop piece = (Bishop) chessBoard.getBoard()[4][4];
        boolean po= piece.move(new Position(1,7),chessBoard);
        assertTrue(po);
    }
    @Test
    public void testMoveRighttUpBishop() {
        ChessBoard chessBoard = new ChessBoard(new Bishop(Color.WHITE,new Position(4,4)));
        Bishop piece = (Bishop) chessBoard.getBoard()[4][4];
        boolean po= piece.move(new Position(7,7),chessBoard);
        assertTrue(po);
    }
    @Test
    public void testMoveRightDownBishop() {
        ChessBoard chessBoard = new ChessBoard(new Bishop(Color.WHITE,new Position(4,4)));
        Bishop piece = (Bishop) chessBoard.getBoard()[4][4];
        boolean po= piece.move(new Position(7,1),chessBoard);
        assertTrue(po);
    }

}
