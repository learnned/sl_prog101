package chess;
import org.junit.Test;

import static org.junit.Assert.*;

public class KingTest {
    @Test
    public void testCreateKing() {
        Position pos = new Position(0, 0);
        ChessBoard chessBoard = new ChessBoard();
        King piece = new King(Color.BLACK, pos, chessBoard);
        assertNotNull(piece);
    }

    @Test
    public void testBlackKingToString() {
        Position pos = new Position(0, 0);
        ChessBoard chessBoard = new ChessBoard();
        King piece = new King(Color.BLACK, pos, chessBoard);
        String expected = "KB";
        String actual = piece.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testWhiteKingToString() {
        Position pos = new Position(0, 0);
        ChessBoard chessBoard = new ChessBoard();
        King piece = new King(Color.WHITE, pos, chessBoard);
        String expected = "KW";
        String actual = piece.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testKingCanMoveToEmpty() {
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.crateAnEmptyChessBoard();
        chessBoard.addPiece(new King(Color.BLACK, new Position(7, 7), chessBoard));
        boolean actual = chessBoard.getBoard()[7][7].move(new Position(6, 7));
        assertTrue(actual);
    }

    @Test
    public void testKingCannotMovetoAlly() {
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.crateAnEmptyChessBoard();
        chessBoard.addPiece(new King(Color.BLACK, new Position(6, 5), chessBoard));
        chessBoard.addPiece(new Bishop(Color.BLACK, new Position(7, 6), chessBoard));
        boolean actual = chessBoard.getBoard()[6][5].move(new Position(6, 5));
        assertFalse(actual);
    }

    @Test
    public void testKingCannotMovetoAVoidPositionUnderAttack() {
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.crateAnEmptyChessBoard();
        chessBoard.addPiece(new King(Color.BLACK, new Position(3, 3), chessBoard));
        chessBoard.addPiece(new Bishop(Color.WHITE, new Position(6, 4), chessBoard));
        boolean actual = chessBoard.getBoard()[3][3].move(new Position(4, 2));
        assertFalse(actual);
    }

    @Test
    public void testKingCannotGetMovementsUnderAttack() {
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.crateAnEmptyChessBoard();
        chessBoard.addPiece(new King(Color.BLACK, new Position(3, 3), chessBoard)); // adding a Black King
        chessBoard.addPiece(new Rook(Color.WHITE, new Position(7, 4), chessBoard)); // adding a White Rook that attacks all row above the king
        chessBoard.addPiece(new Bishop(Color.WHITE, new Position(3, 4), chessBoard)); // adding a White Bishop, it usually can be killed by king, but now king cannot because Rook could attack king
        int actual = chessBoard.getBoard()[3][3].getPossibleMoves().size();
        int expected = 5;
        assertEquals(expected, actual);
    }

    @Test
    public void testKingCanMovetoEnemy() {
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.crateAnEmptyChessBoard();
        chessBoard.addPiece(new King(Color.WHITE, new Position(0, 0), chessBoard));// adding White King
        chessBoard.addPiece(new Bishop(Color.BLACK, new Position(0, 1), chessBoard));// adding a Black Bishop
        boolean actual = chessBoard.getBoard()[0][0].move(new Position(0, 1));
        assertTrue(actual);
    }

    @Test
    public void testBlackKingMovesQueensideCastling() {
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.crateAnEmptyChessBoard();
        chessBoard.addPiece(new King(Color.BLACK, new Position(4, 7), chessBoard));// adding a Black King
        chessBoard.addPiece(new Rook(Color.BLACK, new Position(0, 7), chessBoard));// adding an allied Left Rook
        boolean actual = chessBoard.getBoard()[4][7].move(new Position(2, 7)); // King and Rook can do a Castling
        assertTrue(actual);
    }

    @Test
    public void testBlackKingMovesKingsideCastling() {
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.crateAnEmptyChessBoard();
        chessBoard.addPiece(new King(Color.BLACK, new Position(4, 7), chessBoard));// adding a Black King
        chessBoard.addPiece(new Rook(Color.BLACK, new Position(7, 7), chessBoard));// adding an allied Right Rook
        boolean actual = chessBoard.getBoard()[4][7].move(new Position(6, 7));// King and Rook can do a Castling
        assertTrue(actual);
    }

    @Test
    public void testBlackKingAddsQueensideAndKingsideCastling() {
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.crateAnEmptyChessBoard();
        chessBoard.addPiece(new King(Color.BLACK, new Position(4, 7), chessBoard));// adding a Black King
        chessBoard.addPiece(new Rook(Color.BLACK, new Position(0, 7), chessBoard));// adding an allied Left Rook
        chessBoard.addPiece(new Rook(Color.BLACK, new Position(7, 7), chessBoard));// adding an allied Right Rook
        int actual = chessBoard.getBoard()[4][7].getPossibleMoves().size(); //Possible moves of King are 5 normal and +2 for Castling moves
        int expected = 7;
        assertEquals(expected, actual);
    }

    @Test
    public void testWhiteKingMovesQueenSideCastling() {
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.crateAnEmptyChessBoard();
        chessBoard.addPiece(new King(Color.WHITE, new Position(4, 0), chessBoard));// adding a White King
        chessBoard.addPiece(new Rook(Color.WHITE, new Position(0, 0), chessBoard));// adding an allied Left Rook
        boolean actual = chessBoard.getBoard()[4][0].move(new Position(2, 0));// King can do the Castling
        assertTrue(actual);
    }

    @Test
    public void testWhiteKingMovesKingSideCastling() {
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.crateAnEmptyChessBoard();
        chessBoard.addPiece(new King(Color.WHITE, new Position(4, 0), chessBoard));// adding a White King
        chessBoard.addPiece(new Rook(Color.WHITE, new Position(7, 0), chessBoard));// adding an allied Right Rook
        boolean actual = chessBoard.getBoard()[4][0].move(new Position(6, 0));// King can do the Castling
        assertTrue(actual);
    }

    @Test
    public void testWhiteKingAddsQueenSideAndKingSideCastling() {
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.crateAnEmptyChessBoard();
        King k = new King(Color.WHITE, new Position(4, 0), chessBoard);
        chessBoard.addPiece(new King(Color.WHITE, new Position(4, 0), chessBoard));// adding a White King
        chessBoard.addPiece(new Rook(Color.WHITE, new Position(0, 0), chessBoard));// adding an allied Left Rook
        chessBoard.addPiece(new Rook(Color.WHITE, new Position(7, 0), chessBoard));// adding an allied Right Rook
        int actual = chessBoard.getBoard()[4][0].getPossibleMoves().size();//Possible moves of King are 5 normal and +2 for Castling moves
        int expected = 7;
        assertEquals(expected, actual);
    }

    @Test
    public void testKingIsChecked() {
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.crateAnEmptyChessBoard();
        chessBoard.addPiece(new King(Color.WHITE, new Position(4, 0), chessBoard));// adding a White King
        chessBoard.addPiece(new Bishop(Color.BLACK, new Position(6, 2), chessBoard));// adding a Black Bishop attacking the King
        assertTrue( ((King)chessBoard.getBoard()[4][0]).isChecked());// King should be Checked
    }

    @Test
    public void testKingCannotAddCastlingWhenIsChecked() {
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.crateAnEmptyChessBoard();
        chessBoard.addPiece(new King(Color.WHITE, new Position(4, 0), chessBoard));// adding a White King
        chessBoard.addPiece(new Rook(Color.WHITE, new Position(0, 0), chessBoard));// adding an allied Left Rook
        chessBoard.addPiece(new Rook(Color.WHITE, new Position(7, 0), chessBoard));// adding an allied Right Rook
        chessBoard.addPiece(new Bishop(Color.BLACK, new Position(6, 2), chessBoard));// adding a Black Bishop attacking the King
        boolean actual = chessBoard.getBoard()[4][0].move(new Position(6, 0));// King cannot do any Castling
        assertFalse(actual);
    }

    @Test
    public void testKingCannotAddCastlingWhenItsLeftPositionIsUnderAttack() {
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.crateAnEmptyChessBoard();
        chessBoard.addPiece(new King(Color.WHITE, new Position(4, 0), chessBoard));// adding a White King
        chessBoard.addPiece(new Rook(Color.WHITE, new Position(0, 0), chessBoard));// adding an allied Left Rook
        chessBoard.addPiece(new Rook(Color.WHITE, new Position(7, 0), chessBoard));// adding an allied Right Rook
        chessBoard.addPiece(new Bishop(Color.BLACK, new Position(1, 2), chessBoard));// adding a Black Bishop attacking position in King's left
        int actual = chessBoard.getBoard()[4][0].getPossibleMoves().size();// Left Castling should not be added to possible moves
        int expected = 5;
        assertEquals(expected, actual);
    }

    @Test
    public void testKingCannotAddCastlingWhenItsRightPositionIsUnderAttack() {
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.crateAnEmptyChessBoard();
        chessBoard.addPiece(new King(Color.WHITE, new Position(4, 0), chessBoard));// adding a White King
        chessBoard.addPiece(new Rook(Color.WHITE, new Position(0, 0), chessBoard));// adding an allied Left Rook
        chessBoard.addPiece(new Rook(Color.WHITE, new Position(7, 0), chessBoard));// adding an allied Right Rook
        chessBoard.addPiece(new Bishop(Color.BLACK, new Position(7, 2), chessBoard));// adding a Black Bishop attacking position in King's right
        int actual = chessBoard.getBoard()[4][0].getPossibleMoves().size();// Right Castling should not be added to possible moves
        int expected = 5;
        assertEquals(expected, actual);
    }

    @Test
    public void testKingCannotAddCastlingWhenTargetLeftPositionIsUnderAttack() {
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.crateAnEmptyChessBoard();
        chessBoard.addPiece(new King(Color.WHITE, new Position(4, 0), chessBoard));// adding a White King
        chessBoard.addPiece(new Rook(Color.WHITE, new Position(0, 0), chessBoard));// adding an allied Left Rook
        chessBoard.addPiece(new Rook(Color.WHITE, new Position(7, 0), chessBoard));// adding an allied Right Rook
        chessBoard.addPiece(new Rook(Color.BLACK, new Position(2, 7), chessBoard));// adding a Black Rook attacking target Left Castling position
        int actual = chessBoard.getBoard()[4][0].getPossibleMoves().size();// Right Castling should not be added to possible moves
        int expected = 6;
        assertEquals(expected, actual);
    }

    @Test
    public void testKingCannotAddCastlingWhenTargetRightPositionIsUnderAttack() {
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.crateAnEmptyChessBoard();
        chessBoard.addPiece(new King(Color.WHITE, new Position(4, 0), chessBoard));// adding a White King
        chessBoard.addPiece(new Rook(Color.WHITE, new Position(0, 0), chessBoard));// adding an allied Left Rook
        chessBoard.addPiece(new Rook(Color.WHITE, new Position(7, 0), chessBoard));// adding an allied Right Rook
        chessBoard.addPiece(new Rook(Color.BLACK, new Position(6, 7), chessBoard));// adding a Black Rook attacking target Right Castling position
        int actual = chessBoard.getBoard()[4][0].getPossibleMoves().size();// Right Castling should not be added to possible moves
        int expected = 6;
        assertEquals(expected, actual);
    }
}
