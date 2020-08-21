package chess;
import chess.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class RookTest {
   @Test
    public void testCreateRook() {
        Position pos = new Position(0, 0);
        ChessBoard chessBoard = new ChessBoard();
        Rook piece = new Rook(Color.BLACK, pos, chessBoard);
        assertNotNull(piece);
    }

    @Test
    public void testBlackRookToString() {
        Position pos = new Position(0, 0);
        ChessBoard chessBoard = new ChessBoard();
        Rook piece = new Rook(Color.BLACK, pos, chessBoard);
        String expected = "RB";
        String actual = piece.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testWhiteRookToString() {
        Position pos = new Position(0, 0);
        ChessBoard chessBoard = new ChessBoard();
        Rook piece = new Rook(Color.WHITE, pos, chessBoard);
        String expected = "RW";
        String actual = piece.toString();
        assertEquals(expected, actual);
    }
    @Test
    public void testMoveUpRook() {
        ChessBoard chessBoard1 = new ChessBoard();
        chessBoard1.crateAnEmptyChessBoard();
        chessBoard1.addPiece(new Rook(Color.WHITE, new Position(4, 4), chessBoard1));
        Rook piece = (Rook) chessBoard1.getBoard()[4][4];
        boolean po = piece.move(new Position(7, 4));
        assertTrue(po);
    }
    @Test
    public void testMoveDownRook() {
        ChessBoard chessBoard1 = new ChessBoard();
        chessBoard1.crateAnEmptyChessBoard();
        chessBoard1.addPiece(new Rook(Color.WHITE, new Position(4, 4), chessBoard1));
        Rook piece = (Rook) chessBoard1.getBoard()[4][4];
        boolean po = piece.move(new Position(0, 4));
        assertTrue(po);
    }
    @Test
    public void testMoveLeftRook() {
        ChessBoard chessBoard1 = new ChessBoard();
        chessBoard1.crateAnEmptyChessBoard();
        chessBoard1.addPiece(new Rook(Color.WHITE, new Position(4, 4), chessBoard1));
        Rook piece = (Rook) chessBoard1.getBoard()[4][4];
        boolean po = piece.move(new Position(4, 0));
        assertTrue(po);
    }
    @Test
    public void testMoveRightRook() {
        ChessBoard chessBoard1 = new ChessBoard();
        chessBoard1.crateAnEmptyChessBoard();
        chessBoard1.addPiece(new Rook(Color.WHITE, new Position(4, 4), chessBoard1));
        Rook piece = (Rook) chessBoard1.getBoard()[4][4];
        boolean po = piece.move(new Position(4, 7));
        assertTrue(po);
    }

    @Test
    public void testMoveDownRookBehindEnemy() {
        ChessBoard chessBoard1 = new ChessBoard();
        chessBoard1.crateAnEmptyChessBoard();
        Rook proof = new Rook(Color.WHITE, new Position(4, 4), chessBoard1);
        chessBoard1.addPiece(proof);
        chessBoard1.addPiece(new Queen(Color.BLACK, new Position(1, 4), chessBoard1));
        Rook piece = (Rook) chessBoard1.getBoard()[4][4];
        boolean po = piece.move(new Position(0, 4));
        assertFalse(po);
    }
    @Test
    public void testMoveDownRookAllied() {
        ChessBoard chessBoard1 = new ChessBoard();
        chessBoard1.crateAnEmptyChessBoard();
        Rook proof = new Rook(Color.WHITE, new Position(4, 4), chessBoard1);
        chessBoard1.addPiece(proof);
        chessBoard1.addPiece(new Queen(Color.WHITE, new Position(1, 4), chessBoard1));
        Rook piece = (Rook) chessBoard1.getBoard()[4][4];
        boolean po = piece.move(new Position(1, 4));
        assertFalse(po);
    }
    @Test
    public void testMoveUpRookBehindAllied() {
        ChessBoard chessBoard1 = new ChessBoard();
        chessBoard1.crateAnEmptyChessBoard();
        Rook proof = new Rook(Color.WHITE, new Position(4, 4), chessBoard1);
        chessBoard1.addPiece(proof);
        chessBoard1.addPiece(new Queen(Color.WHITE, new Position(6, 4), chessBoard1));
        Rook piece = (Rook) chessBoard1.getBoard()[4][4];
        boolean po = piece.move(new Position(7, 4));
        assertFalse(po);
    }
}
