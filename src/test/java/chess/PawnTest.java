package chess;
import enums.Color;
import game.ChessBoard;
import org.junit.Test;
import pieces.Pawn;
import pieces.Position;

import static org.junit.Assert.*;

public class PawnTest {

    @Test
    public void testCreatePawn() {
        ChessBoard chessBoardTest = new ChessBoard();
        chessBoardTest.crateAnEmptyChessBoard();
        chessBoardTest.addPiece(new Pawn(Color.WHITE, new Position(1, 1), chessBoardTest));
        Pawn piece = (Pawn) chessBoardTest.getBoard()[1][1];
        assertNotNull(piece);
    }

    @Test
    public void testBlackPawnToString() {
        ChessBoard chessBoardTest = new ChessBoard();
        chessBoardTest.crateAnEmptyChessBoard();
        chessBoardTest.addPiece(new Pawn(Color.BLACK, new Position(1, 1), chessBoardTest));
        Pawn piece = (Pawn) chessBoardTest.getBoard()[1][1];
        String expected = "PB";
        String actual = piece.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testWhitePawnToString() {
        ChessBoard chessBoardTest = new ChessBoard();
        chessBoardTest.crateAnEmptyChessBoard();
        chessBoardTest.addPiece(new Pawn(Color.WHITE, new Position(1, 1), chessBoardTest));
        Pawn piece = (Pawn) chessBoardTest.getBoard()[1][1];
        String expected = "PW";
        String actual = piece.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testAdvanceOneSquareAsPieceWhite() {
        ChessBoard chessBoardTest = new ChessBoard();
        chessBoardTest.crateAnEmptyChessBoard();
        chessBoardTest.addPiece(new Pawn(Color.WHITE, new Position(1, 1), chessBoardTest));
        Pawn piece = (Pawn) chessBoardTest.getBoard()[1][1];
        boolean movementAllowed = piece.move(new Position(1, 2));
        assertTrue(movementAllowed);
    }

    @Test
    public void testKillLeftDiagonalAsWhitePiece() {
        ChessBoard chessBoardTest = new ChessBoard();
        chessBoardTest.crateAnEmptyChessBoard();
        chessBoardTest.addPiece(new Pawn(Color.WHITE, new Position(4, 4), chessBoardTest));
        chessBoardTest.addPiece(new Pawn(Color.BLACK, new Position(3, 5), chessBoardTest));
        Pawn piece = (Pawn) chessBoardTest.getBoard()[4][4];
        boolean movementAllowed = piece.move(new Position(3, 5));
        assertTrue(movementAllowed);
    }

    @Test
    public void testKillRightDiagonalAsWhitePiece() {
        ChessBoard chessBoardTest = new ChessBoard();
        chessBoardTest.crateAnEmptyChessBoard();
        chessBoardTest.addPiece(new Pawn(Color.WHITE, new Position(4, 4), chessBoardTest));
        chessBoardTest.addPiece(new Pawn(Color.BLACK, new Position(5, 5), chessBoardTest));
        Pawn piece = (Pawn) chessBoardTest.getBoard()[4][4];
        boolean movementAllowed = piece.move(new Position(5, 5));
        assertTrue(movementAllowed);
    }

    @Test
    public void testAdvanceTwoSquaresAsPieceWhite() {
        ChessBoard chessBoardTest = new ChessBoard();
        chessBoardTest.crateAnEmptyChessBoard();
        chessBoardTest.addPiece(new Pawn(Color.WHITE, new Position(4, 1), chessBoardTest));
        Pawn piece = (Pawn) chessBoardTest.getBoard()[4][1];
        boolean movementAllowed = piece.move(new Position(4, 3));
        assertTrue(movementAllowed);
    }

    @Test
    public void testInvalidMovementForBlackPiecesAndValidForWhitePieces() {
        ChessBoard chessBoardTest = new ChessBoard();
        chessBoardTest.crateAnEmptyChessBoard();
        chessBoardTest.addPiece(new Pawn(Color.BLACK, new Position(4, 4), chessBoardTest));
        Pawn piece = (Pawn) chessBoardTest.getBoard()[4][4];
        boolean movementAllowed = piece.move(new Position(4, 5));
        assertFalse(movementAllowed);
    }

    @Test
    public void testInvalidDoubleMovementForBlackPiecesAndValidForWhitePieces() {
        ChessBoard chessBoardTest = new ChessBoard();
        chessBoardTest.crateAnEmptyChessBoard();
        chessBoardTest.addPiece(new Pawn(Color.BLACK, new Position(4, 4), chessBoardTest));
        Pawn piece = (Pawn) chessBoardTest.getBoard()[4][4];
        boolean movementAllowed = piece.move(new Position(4, 6));
        assertFalse(movementAllowed);
    }

    @Test
    public void testAdvanceOneSquareAsPieceBlack() {
        ChessBoard chessBoardTest = new ChessBoard();
        chessBoardTest.crateAnEmptyChessBoard();
        chessBoardTest.addPiece(new Pawn(Color.BLACK, new Position(4, 4), chessBoardTest));
        Pawn piece = (Pawn) chessBoardTest.getBoard()[4][4];
        boolean movementAllowed = piece.move(new Position(4, 3));
        assertTrue(movementAllowed);
    }

    @Test
    public void testAdvanceTwoSquaresAsPieceBlack() {
        ChessBoard chessBoardTest = new ChessBoard();
        chessBoardTest.crateAnEmptyChessBoard();
        chessBoardTest.addPiece(new Pawn(Color.BLACK, new Position(4, 4), chessBoardTest));
        Pawn piece = (Pawn) chessBoardTest.getBoard()[4][4];
        boolean movementAllowed = piece.move(new Position(4, 2));
        assertTrue(movementAllowed);
    }

    @Test
    public void testKillLeftDiagonalAsBlackPiece() {
        ChessBoard chessBoardTest = new ChessBoard();
        chessBoardTest.crateAnEmptyChessBoard();
        chessBoardTest.addPiece(new Pawn(Color.BLACK, new Position(4, 4), chessBoardTest));
        chessBoardTest.addPiece(new Pawn(Color.WHITE, new Position(3, 3), chessBoardTest));
        Pawn piece = (Pawn) chessBoardTest.getBoard()[4][4];
        boolean movementAllowed = piece.move(new Position(3, 3));
        assertTrue(movementAllowed);
    }

    @Test
    public void testKillRightDiagonalAsBlackPiece() {
        ChessBoard chessBoardTest = new ChessBoard();
        chessBoardTest.crateAnEmptyChessBoard();
        chessBoardTest.addPiece(new Pawn(Color.BLACK, new Position(4, 4), chessBoardTest));
        chessBoardTest.addPiece(new Pawn(Color.WHITE, new Position(5, 3), chessBoardTest));
        Pawn piece = (Pawn) chessBoardTest.getBoard()[4][4];
        boolean movementAllowed = piece.move(new Position(5, 3));
        assertTrue(movementAllowed);
    }

    @Test
    public void testInvalidMovementForWhitePiecesAndValidForBlackPieces() {
        ChessBoard chessBoardTest = new ChessBoard();
        chessBoardTest.crateAnEmptyChessBoard();
        chessBoardTest.addPiece(new Pawn(Color.WHITE, new Position(4, 4), chessBoardTest));
        Pawn piece = (Pawn) chessBoardTest.getBoard()[4][4];
        boolean movementAllowed = piece.move(new Position(4, 3));
        assertFalse(movementAllowed);
    }

    @Test
    public void testInvalidDoubleMovementForWhitePiecesAndValidForBlackPieces() {
        ChessBoard chessBoardTest = new ChessBoard();
        chessBoardTest.crateAnEmptyChessBoard();
        chessBoardTest.addPiece(new Pawn(Color.WHITE, new Position(4, 4), chessBoardTest));
        Pawn piece = (Pawn) chessBoardTest.getBoard()[4][4];
        boolean movementAllowed = piece.move(new Position(4, 2));
        assertFalse(movementAllowed);
    }

}
