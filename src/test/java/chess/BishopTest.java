package chess;
import enums.Color;
import org.junit.Test;
import pieces.Bishop;
import pieces.Position;
import pieces.Queen;

import static org.junit.Assert.*;

public class BishopTest {

    @Test
    public void testCreateBishop() {
        Position pos = new Position(0, 0);
        ChessBoard chessBoard = new ChessBoard();
        Bishop piece = new Bishop(Color.BLACK, pos, chessBoard);
        assertNotNull(piece);
    }

    @Test
    public void testBlackBishopToString() {
        Position pos = new Position(0, 0);
        ChessBoard chessBoard = new ChessBoard();
        Bishop piece = new Bishop(Color.BLACK, pos, chessBoard);
        String expected = "BB";
        String actual = piece.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testWhiteBishopToString() {
        Position pos = new Position(0, 0);
        ChessBoard chessBoard = new ChessBoard();
        Bishop piece = new Bishop(Color.WHITE, pos, chessBoard);
        String expected = "BW";
        String actual = piece.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testMoveLeftDownBishop() {
        ChessBoard chessBoard1 = new ChessBoard();
        chessBoard1.crateAnEmptyChessBoard();
        chessBoard1.addPiece(new Bishop(Color.WHITE, new Position(4,4), chessBoard1));
        Bishop piece = (Bishop) chessBoard1.getBoard()[4][4];
        boolean po = piece.move(new Position(0, 0));
        assertTrue(po);
    }
    @Test
    public void testMoveLeftUpBishop() {
        ChessBoard chessBoard1 = new ChessBoard();
        chessBoard1.crateAnEmptyChessBoard();
        chessBoard1.addPiece(new Bishop(Color.WHITE, new Position(4, 4), chessBoard1));
        Bishop piece = (Bishop) chessBoard1.getBoard()[4][4];
        boolean po = piece.move(new Position(1, 7));
        assertTrue(po);
    }
    @Test
    public void testMoveRighttUpBishop() {
        ChessBoard chessBoard1 = new ChessBoard();
        chessBoard1.crateAnEmptyChessBoard();
        chessBoard1.addPiece(new Bishop(Color.WHITE, new Position(4, 4), chessBoard1));
        Bishop piece = (Bishop) chessBoard1.getBoard()[4][4];
        boolean po = piece.move(new Position(7, 7));
        assertTrue(po);
    }
    @Test
    public void testMoveRightDownBishopEnemy() {
        ChessBoard chessBoard1 = new ChessBoard();
        chessBoard1.crateAnEmptyChessBoard();
        chessBoard1.addPiece(new Bishop(Color.WHITE, new Position(4, 4), chessBoard1));
        chessBoard1.addPiece(new Queen(Color.BLACK, new Position(1, 1), chessBoard1));
        Bishop piece = (Bishop) chessBoard1.getBoard()[4][4];
        boolean po = piece.move(new Position(1, 1));
        assertTrue(po);
    }
    @Test
    public void testMoveRightDownBishopBehindEnemy() {
        ChessBoard chessBoard1 = new ChessBoard();
        chessBoard1.crateAnEmptyChessBoard();
        Bishop proof =new Bishop(Color.WHITE, new Position(4, 4), chessBoard1);
        chessBoard1.addPiece(proof);
        chessBoard1.addPiece(new Queen(Color.BLACK, new Position(1, 1), chessBoard1));
        Bishop piece = (Bishop) chessBoard1.getBoard()[4][4];
        boolean po = piece.move(new Position(0, 0));
        assertFalse(po);
    }
    @Test
    public void testMoveRightDownBishopAllied() {
        ChessBoard chessBoard1 = new ChessBoard();
        chessBoard1.crateAnEmptyChessBoard();
        Bishop proof =new Bishop(Color.WHITE, new Position(4, 4), chessBoard1);
        chessBoard1.addPiece(proof);
        chessBoard1.addPiece(new Queen(Color.WHITE, new Position(1, 1), chessBoard1));
        Bishop piece = (Bishop) chessBoard1.getBoard()[4][4];
        boolean po = piece.move(new Position(1, 1));
        assertFalse(po);
    }
    @Test
    public void testMoveRightDownBishopBehindAllied() {
        ChessBoard chessBoard1 = new ChessBoard();
        chessBoard1.crateAnEmptyChessBoard();
        Bishop proof =new Bishop(Color.WHITE, new Position(4, 4), chessBoard1);
        chessBoard1.addPiece(proof);
        chessBoard1.addPiece(new Queen(Color.WHITE, new Position(1, 1), chessBoard1));
        Bishop piece = (Bishop) chessBoard1.getBoard()[4][4];
        boolean po = piece.move(new Position(0, 0));
        assertFalse(po);
    }
}
