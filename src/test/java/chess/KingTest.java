package chess;
import chess.*;
import org.junit.Test;

import java.sql.SQLOutput;
import java.util.ArrayList;

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
    public void testKingcanMoveToEmpty() {
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.crateAnEmptyChessBoard();
        King k = new King(Color.BLACK, new Position(7, 7), chessBoard);
        chessBoard.addPiece(k);
        boolean actual = k.move(new Position(6, 7));
        assertTrue(actual);
    }

    @Test
    public void testKingCannotMovetoAlly() {
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.crateAnEmptyChessBoard();
        King k = new King(Color.BLACK, new Position(6, 5), chessBoard);
        chessBoard.addPiece(k);
        Bishop b = new Bishop(Color.BLACK, new Position(7, 6), chessBoard);
        chessBoard.addPiece(b);
        boolean actual = k.move(new Position(6, 5));
        assertFalse(actual);
    }

    @Test
    public void testKingCannotMovetoAVoidPositionUnderAttack() {
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.crateAnEmptyChessBoard();
        King k = new King(Color.BLACK, new Position(3, 3), chessBoard);
        chessBoard.addPiece(k);
        Bishop b = new Bishop(Color.WHITE, new Position(6, 4), chessBoard);
        chessBoard.addPiece(b);
        boolean actual = k.move(new Position(4, 2));
        assertFalse(actual);
    }

    @Test
    public void testKingCannotGetMovementsUnderAttack() {
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.crateAnEmptyChessBoard();
        King bk = new King(Color.BLACK, new Position(3, 3), chessBoard);
        chessBoard.addPiece(bk);
        Rook wr = new Rook(Color.WHITE, new Position(6, 4), chessBoard);
        chessBoard.addPiece(wr);
        Bishop wb = new Bishop(Color.WHITE, new Position(3, 4), chessBoard);
        chessBoard.addPiece(wb);
        int actual = bk.getPossibleMoves().size();
        int expected = 5;
        assertEquals(expected, actual);
    }

    @Test
    public void testKingCanMovetoEnemy() {
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.crateAnEmptyChessBoard();
        King k = new King(Color.WHITE, new Position(0, 0), chessBoard);
        chessBoard.addPiece(k);
        Bishop b = new Bishop(Color.BLACK, new Position(0, 1), chessBoard);
        chessBoard.addPiece(b);
        boolean actual = k.move(new Position(0, 1));
        assertTrue(actual);
    }

    @Test
    public void testBlackKingMovesQueenSideCastling() {
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.crateAnEmptyChessBoard();
        King k = new King(Color.BLACK, new Position(4, 7), chessBoard);
        chessBoard.addPiece(k);
        Rook r = new Rook(Color.BLACK, new Position(0, 7), chessBoard);
        chessBoard.addPiece(r);
        boolean actual = k.move(new Position(2, 7));
        assertTrue(actual);
    }

    @Test
    public void testBlackKingMovesKingSideCastling() {
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.crateAnEmptyChessBoard();
        King k = new King(Color.BLACK, new Position(4, 7), chessBoard);
        chessBoard.addPiece(k);
        Rook r = new Rook(Color.BLACK, new Position(7, 7), chessBoard);
        chessBoard.addPiece(r);
        boolean actual = k.move(new Position(6, 7));
        assertTrue(actual);
    }

    @Test
    public void testBlackKingAddsQueenSideAndKingSideCastling() {
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.crateAnEmptyChessBoard();
        King k = new King(Color.BLACK, new Position(4, 7), chessBoard);
        chessBoard.addPiece(k);
        Rook leftR = new Rook(Color.BLACK, new Position(0, 7), chessBoard);
        chessBoard.addPiece(leftR);
        Rook rightR = new Rook(Color.BLACK, new Position(7, 7), chessBoard);
        chessBoard.addPiece(rightR);
        int actual = k.getPossibleMoves().size();
        int expected = 7;
        assertEquals(expected, actual);
    }

    @Test
    public void testWhiteKingMovesQueenSideCastling() {
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.crateAnEmptyChessBoard();
        King k = new King(Color.WHITE, new Position(4, 0), chessBoard);
        chessBoard.addPiece(k);
        Rook r = new Rook(Color.WHITE, new Position(0, 0), chessBoard);
        chessBoard.addPiece(r);
        boolean actual = k.move(new Position(2, 0));
        assertTrue(actual);
    }

    @Test
    public void testWhiteKingMovesKingSideCastling() {
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.crateAnEmptyChessBoard();
        King k = new King(Color.WHITE, new Position(4, 0), chessBoard);
        chessBoard.addPiece(k);
        Rook r = new Rook(Color.WHITE, new Position(7, 0), chessBoard);
        chessBoard.addPiece(r);
        boolean actual = k.move(new Position(6, 0));
        assertTrue(actual);
    }

    @Test
    public void testWhiteKingAddsQueenSideAndKingSideCastling() {
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.crateAnEmptyChessBoard();
        King k = new King(Color.WHITE, new Position(4, 0), chessBoard);
        chessBoard.addPiece(k);
        Rook leftR = new Rook(Color.WHITE, new Position(0, 0), chessBoard);
        chessBoard.addPiece(leftR);
        Rook rightR = new Rook(Color.WHITE, new Position(7, 0), chessBoard);
        chessBoard.addPiece(rightR);
        int actual = k.getPossibleMoves().size();
        int expected = 7;
        assertEquals(expected, actual);
    }

    @Test
    public void testKingIsChecked() {
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.crateAnEmptyChessBoard();
        King wk = new King(Color.WHITE, new Position(4, 0), chessBoard);
        chessBoard.addPiece(wk);
        Bishop bb = new Bishop(Color.BLACK, new Position(6, 2), chessBoard);
        chessBoard.addPiece(bb);
        assertTrue(wk.isChecked());
    }

    @Test
    public void testKingCannotAddCastlingWhenIsChecked() {
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.crateAnEmptyChessBoard();
        King wk = new King(Color.WHITE, new Position(4, 0), chessBoard);
        chessBoard.addPiece(wk);
        Rook leftR = new Rook(Color.WHITE, new Position(0, 0), chessBoard);
        chessBoard.addPiece(leftR);
        Rook rightR = new Rook(Color.WHITE, new Position(7, 0), chessBoard);
        chessBoard.addPiece(rightR);
        Bishop bb = new Bishop(Color.BLACK, new Position(6, 2), chessBoard);
        chessBoard.addPiece(bb);
        boolean actual = wk.move(new Position(6, 0));
        assertFalse(actual);
    }

    @Test
    public void testKingCannotAddCastlingWhenItsLeftPositionIsUnderAttack() {
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.crateAnEmptyChessBoard();
        King wk = new King(Color.WHITE, new Position(4, 0), chessBoard);
        chessBoard.addPiece(wk);
        Rook leftR = new Rook(Color.WHITE, new Position(0, 0), chessBoard);
        chessBoard.addPiece(leftR);
        Rook rightR = new Rook(Color.WHITE, new Position(7, 0), chessBoard);
        chessBoard.addPiece(rightR);
        Bishop bb = new Bishop(Color.BLACK, new Position(5, 2), chessBoard);
        chessBoard.addPiece(bb);
        boolean actual = wk.move(new Position(2, 0));
        assertFalse(actual);
    }

    @Test
    public void testKingCannotAddCastlingWhenItsRightPositionIsUnderAttack() {
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.crateAnEmptyChessBoard();
        King wk = new King(Color.WHITE, new Position(4, 0), chessBoard);
        chessBoard.addPiece(wk);
        Rook leftR = new Rook(Color.WHITE, new Position(0, 0), chessBoard);
        chessBoard.addPiece(leftR);
        Rook rightR = new Rook(Color.WHITE, new Position(7, 0), chessBoard);
        chessBoard.addPiece(rightR);
        Bishop bb = new Bishop(Color.BLACK, new Position(7, 2), chessBoard);
        chessBoard.addPiece(bb);
        boolean actual = wk.move(new Position(6, 0));
        assertFalse(actual);
    }

    @Test
    public void testKingCannotAddCastlingWhenTargetLeftPositionIsUnderAttack() {
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.crateAnEmptyChessBoard();
        King wk = new King(Color.WHITE, new Position(4, 0), chessBoard);
        chessBoard.addPiece(wk);
        Rook leftR = new Rook(Color.WHITE, new Position(0, 0), chessBoard);
        chessBoard.addPiece(leftR);
        Rook rightR = new Rook(Color.WHITE, new Position(7, 0), chessBoard);
        chessBoard.addPiece(rightR);
        Bishop bb = new Bishop(Color.BLACK, new Position(0, 2), chessBoard);
        chessBoard.addPiece(bb);
        boolean actual = wk.move(new Position(2, 0));
        assertFalse(actual);
    }

    @Test
    public void testKingCannotAddCastlingWhenTargetRightPositionIsUnderAttack() {
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.crateAnEmptyChessBoard();
        King wk = new King(Color.WHITE, new Position(4, 0), chessBoard);
        chessBoard.addPiece(wk);
        Rook leftR = new Rook(Color.WHITE, new Position(0, 0), chessBoard);
        chessBoard.addPiece(leftR);
        Rook rightR = new Rook(Color.WHITE, new Position(7, 0), chessBoard);
        chessBoard.addPiece(rightR);
        Bishop bb = new Bishop(Color.BLACK, new Position(4, 2), chessBoard);
        chessBoard.addPiece(bb);
        boolean actual = wk.move(new Position(6, 0));
        assertFalse(actual);
    }
}
