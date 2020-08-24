package chess;
import enums.Color;
import org.junit.Test;
import pieces.Bishop;
import pieces.Position;
import pieces.Queen;
import pieces.Rook;

import static org.junit.Assert.*;

public class QueenTest {

    @Test
    public void testCreateQueen() {
        Position position = new Position(0, 0);
        ChessBoard chessBoard = new ChessBoard();
        Queen piece = new Queen(Color.BLACK, position,chessBoard);
        assertNotNull(piece);
    }

    @Test
    public void testBlackQueenToString() {
        Position position = new Position(0, 0);
        ChessBoard chessBoard = new ChessBoard();
        Queen piece = new Queen(Color.BLACK, position,chessBoard);
        String expected = "QB";
        String actual = piece.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testWhiteQueenToString() {
        Position position = new Position(0, 0);
        ChessBoard chessBoard = new ChessBoard();
        Queen piece = new Queen(Color.WHITE, position,chessBoard);
        String expected = "QW";
        String actual = piece.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testMoveLeftDownQueen() {
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.crateAnEmptyChessBoard();
        chessBoard.addPiece(new Queen(Color.WHITE, new Position(4, 4), chessBoard));
        Queen queen = (Queen) chessBoard.getBoard()[4][4];
        assertTrue(queen.move(new Position(0, 0)));
    }
    @Test
    public void testMoveLeftUpQueen() {
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.crateAnEmptyChessBoard();
        chessBoard.addPiece(new Queen(Color.WHITE, new Position(4, 4), chessBoard));
        Queen queen = (Queen) chessBoard.getBoard()[4][4];
        assertTrue(queen.move(new Position(1, 7)));
    }
    @Test
    public void testMoveRightUpQueen() {
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.crateAnEmptyChessBoard();
        chessBoard.addPiece(new Queen(Color.WHITE, new Position(4, 4), chessBoard));
        Queen queen = (Queen) chessBoard.getBoard()[4][4];
        assertTrue(queen.move(new Position(7, 7)));
    }
    @Test
    public void testMoveLeftDownQueenEnemy() {
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.crateAnEmptyChessBoard();
        chessBoard.addPiece(new Queen(Color.WHITE, new Position(4, 4), chessBoard));
        chessBoard.addPiece(new Bishop(Color.BLACK, new Position(1, 1), chessBoard));
        Queen queen = (Queen) chessBoard.getBoard()[4][4];
        assertTrue(queen.move(new Position(1, 1)));
    }
    @Test
    public void testMoveLeftDownQueenBehindEnemy() {
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.crateAnEmptyChessBoard();
        chessBoard.addPiece(new Queen(Color.WHITE, new Position(4, 4), chessBoard));
        chessBoard.addPiece(new Bishop(Color.BLACK,new Position(1, 1), chessBoard));
        Queen queen = (Queen) chessBoard.getBoard()[4][4];
        assertFalse(queen.move(new Position(0, 0)));
    }
    @Test
    public void testMoveLeftDownQueenAllied() {
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.crateAnEmptyChessBoard();
        chessBoard.addPiece(new Queen(Color.WHITE, new Position(4, 4), chessBoard));
        chessBoard.addPiece(new Bishop(Color.WHITE, new Position(1, 1), chessBoard));
        Queen queen = (Queen) chessBoard.getBoard()[4][4];
        assertFalse(queen.move(new Position(1, 1)));
    }
    @Test
    public void testMoveLeftDownQueenBehindAllied() {
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.crateAnEmptyChessBoard();
        chessBoard.addPiece(new Queen(Color.WHITE, new Position(4, 4), chessBoard));
        chessBoard.addPiece(new Bishop(Color.WHITE, new Position(1, 1), chessBoard));
        Queen queen = (Queen) chessBoard.getBoard()[4][4];
        assertFalse(queen.move(new Position(0, 0)));
    }

    @Test
    public void testMoveUpQueen() {
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.crateAnEmptyChessBoard();
        chessBoard.addPiece(new Queen(Color.WHITE, new Position(4, 4), chessBoard));
        Queen queen = (Queen) chessBoard.getBoard()[4][4];
        assertTrue(queen.move(new Position(7, 4)));
    }
    @Test
    public void testMoveDownQueen() {
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.crateAnEmptyChessBoard();
        chessBoard.addPiece(new Queen(Color.WHITE, new Position(4, 4), chessBoard));
        Queen queen = (Queen) chessBoard.getBoard()[4][4];
        assertTrue(queen.move(new Position(0, 4)));
    }
    @Test
    public void testMoveLeftQueen() {
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.crateAnEmptyChessBoard();
        chessBoard.addPiece(new Queen(Color.WHITE, new Position(4, 4), chessBoard));
        Queen piece = (Queen) chessBoard.getBoard()[4][4];
        assertTrue(piece.move(new Position(4, 0)));
    }
    @Test
    public void testMoveRightQueen() {
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.crateAnEmptyChessBoard();
        chessBoard.addPiece(new Queen(Color.WHITE, new Position(4, 4), chessBoard));
        Queen queen = (Queen) chessBoard.getBoard()[4][4];
        assertTrue(queen.move(new Position(4, 7)));
    }

    @Test
    public void testMoveDownQueenBehindEnemy() {
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.crateAnEmptyChessBoard();
        chessBoard.addPiece(new Queen(Color.WHITE, new Position(4, 4), chessBoard));
        chessBoard.addPiece(new Rook(Color.BLACK, new Position(1, 4), chessBoard));
        Queen queen = (Queen) chessBoard.getBoard()[4][4];
        assertFalse(queen.move(new Position(0, 4)));
    }
    @Test
    public void testMoveDownQueenAllied() {
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.crateAnEmptyChessBoard();
        chessBoard.addPiece(new Queen(Color.WHITE, new Position(4, 4), chessBoard));
        chessBoard.addPiece(new Queen(Color.WHITE, new Position(1, 4), chessBoard));
        Queen queen = (Queen) chessBoard.getBoard()[4][4];
        assertFalse(queen.move(new Position(1, 4)));
    }
    @Test
    public void testMoveUpQueenBehindAllied() {
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.crateAnEmptyChessBoard();
        chessBoard.addPiece(new Queen(Color.WHITE, new Position(4, 4), chessBoard));
        chessBoard.addPiece(new Rook(Color.WHITE, new Position(6, 4), chessBoard));
        Queen queen = (Queen) chessBoard.getBoard()[4][4];
        assertFalse(queen.move(new Position(7, 4)));
    }
}
