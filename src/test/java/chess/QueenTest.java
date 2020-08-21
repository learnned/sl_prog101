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

    @Test
    public void testMoveLeftDownQueen() {
        ChessBoard chessBoard1 = new ChessBoard();
        chessBoard1.crateAnEmptyChessBoard();
        chessBoard1.addPiece(new Queen(Color.WHITE, new Position(4, 4), chessBoard1));
        Queen piece = (Queen) chessBoard1.getBoard()[4][4];
        boolean po = piece.move(new Position(0, 0));
        assertTrue(po);
    }
    @Test
    public void testMoveLeftUpQueen() {
        ChessBoard chessBoard1 = new ChessBoard();
        chessBoard1.crateAnEmptyChessBoard();
        chessBoard1.addPiece(new Queen(Color.WHITE, new Position(4, 4), chessBoard1));
        Queen piece = (Queen) chessBoard1.getBoard()[4][4];
        boolean po = piece.move(new Position(1, 7));
        assertTrue(po);
    }
    @Test
    public void testMoveRighttUpQueen() {
        ChessBoard chessBoard1 = new ChessBoard();
        chessBoard1.crateAnEmptyChessBoard();
        chessBoard1.addPiece(new Queen(Color.WHITE, new Position(4, 4), chessBoard1));
        Queen piece = (Queen) chessBoard1.getBoard()[4][4];
        boolean po = piece.move(new Position(7, 7));
        assertTrue(po);
    }
    @Test
    public void testMoveRightDownQueenEnemy() {
        ChessBoard chessBoard1 = new ChessBoard();
        chessBoard1.crateAnEmptyChessBoard();
        chessBoard1.addPiece(new Queen(Color.WHITE, new Position(4, 4), chessBoard1));
        chessBoard1.addPiece(new Bishop(Color.BLACK, new Position(1, 1), chessBoard1));
        Queen piece = (Queen) chessBoard1.getBoard()[4][4];
        boolean po = piece.move(new Position(1, 1));
        assertTrue(po);
    }
    @Test
    public void testMoveRightDownQueenBehindEnemy() {
        ChessBoard chessBoard1 = new ChessBoard();
        chessBoard1.crateAnEmptyChessBoard();
        Queen proof = new Queen(Color.WHITE, new Position(4, 4), chessBoard1);
        chessBoard1.addPiece(proof);
        chessBoard1.addPiece(new Bishop(Color.BLACK,new Position(1, 1), chessBoard1));
        Queen piece = (Queen) chessBoard1.getBoard()[4][4];
        boolean po = piece.move(new Position(0, 0));
        assertFalse(po);
    }
    @Test
    public void testMoveRightDownQueenAllied() {
        ChessBoard chessBoard1 = new ChessBoard();
        chessBoard1.crateAnEmptyChessBoard();
        Queen proof = new Queen(Color.WHITE, new Position(4, 4), chessBoard1);
        chessBoard1.addPiece(proof);
        chessBoard1.addPiece(new Bishop(Color.WHITE, new Position(1, 1), chessBoard1));
        Queen piece = (Queen) chessBoard1.getBoard()[4][4];
        boolean po = piece.move(new Position(1, 1));
        assertFalse(po);
    }
    @Test
    public void testMoveRightDownQueenBehindAllied() {
        ChessBoard chessBoard1 = new ChessBoard();
        chessBoard1.crateAnEmptyChessBoard();
        Queen proof =new Queen(Color.WHITE, new Position(4, 4), chessBoard1);
        chessBoard1.addPiece(proof);
        chessBoard1.addPiece(new Bishop(Color.WHITE, new Position(1, 1), chessBoard1));
        Queen piece = (Queen) chessBoard1.getBoard()[4][4];
        boolean po = piece.move(new Position(0, 0));
        assertFalse(po);
    }

    @Test
    public void testMoveUpQueen() {
        ChessBoard chessBoard1 = new ChessBoard();
        chessBoard1.crateAnEmptyChessBoard();
        ChessBoard chessBoard = new ChessBoard(new Queen(Color.WHITE, new Position(4, 4), chessBoard1));
        Queen piece = (Queen) chessBoard.getBoard()[4][4];
        boolean po = piece.move(new Position(7, 4));
        assertTrue(po);
    }
    @Test
    public void testMoveDownQueen() {
        ChessBoard chessBoard1 = new ChessBoard();
        chessBoard1.crateAnEmptyChessBoard();
        chessBoard1.addPiece(new Queen(Color.WHITE, new Position(4, 4), chessBoard1));
        Queen piece = (Queen) chessBoard1.getBoard()[4][4];
        boolean po = piece.move(new Position(0, 4));
        assertTrue(po);
    }
    @Test
    public void testMoveLeftQueen() {
        ChessBoard chessBoard1 = new ChessBoard();
        chessBoard1.crateAnEmptyChessBoard();
        chessBoard1.addPiece(new Queen(Color.WHITE, new Position(4, 4), chessBoard1));
        Queen piece = (Queen) chessBoard1.getBoard()[4][4];
        boolean po = piece.move(new Position(4, 0));
        assertTrue(po);
    }
    @Test
    public void testMoveRightQueen() {
        ChessBoard chessBoard1 = new ChessBoard();
        chessBoard1.crateAnEmptyChessBoard();
        chessBoard1.addPiece(new Queen(Color.WHITE, new Position(4, 4), chessBoard1));
        Queen piece = (Queen) chessBoard1.getBoard()[4][4];
        boolean po= piece.move(new Position(4, 7));
        assertTrue(po);
    }

    @Test
    public void testMoveDownQueenBehindEnemy() {
        ChessBoard chessBoard1 = new ChessBoard();
        chessBoard1.crateAnEmptyChessBoard();
        Queen proof =new Queen(Color.WHITE, new Position(4, 4), chessBoard1);
        chessBoard1.addPiece(proof);
        chessBoard1.addPiece(new Rook(Color.BLACK, new Position(1, 4), chessBoard1));
        Queen piece = (Queen) chessBoard1.getBoard()[4][4];
        boolean po = piece.move(new Position(0, 4));
        assertFalse(po);
    }
    @Test
    public void testMoveDownQueenAllied() {
        ChessBoard chessBoard1 = new ChessBoard();
        chessBoard1.crateAnEmptyChessBoard();
        Queen proof =new Queen(Color.WHITE, new Position(4, 4), chessBoard1);
        chessBoard1.addPiece(proof);
        chessBoard1.addPiece(new Queen(Color.WHITE, new Position(1, 4), chessBoard1));
        Queen piece = (Queen) chessBoard1.getBoard()[4][4];
        boolean po = piece.move(new Position(1, 4));
        assertFalse(po);
    }
    @Test
    public void testMoveUpQueenBehindAllied() {
        ChessBoard chessBoard1 = new ChessBoard();
        chessBoard1.crateAnEmptyChessBoard();
        Queen proof =new Queen(Color.WHITE, new Position(4, 4), chessBoard1);
        chessBoard1.addPiece(proof);
        chessBoard1.addPiece(new Rook(Color.WHITE, new Position(6, 4), chessBoard1));
        Queen piece = (Queen) chessBoard1.getBoard()[4][4];
        boolean po = piece.move(new Position(7, 4));
        assertFalse(po);
    }
}
