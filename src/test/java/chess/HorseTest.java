package chess;

import enums.Color;
import game.ChessBoard;
import pieces.Horse;
import pieces.Position;

import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class HorseTest {
    @Test
    public void testCreateHorse() {
        ChessBoard chessBoard = new ChessBoard();
        Position pos = new Position(0, 0);
        Horse piece = new Horse(Color.BLACK, pos, chessBoard);
        assertNotNull(piece);
    }

    @Test
    public void testBlackHorseToString() {
        ChessBoard chessBoard = new ChessBoard();
        Position pos = new Position(0, 0);
        Horse piece = new Horse(Color.BLACK, pos, chessBoard);
        String expected = "HB";
        String actual = piece.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testWhiteHorseToString() {
        ChessBoard chessBoard = new ChessBoard();
        Position pos = new Position(0, 0);
        Horse piece = new Horse(Color.WHITE, pos, chessBoard);
        String expected = "HW";
        String actual = piece.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testMoveHorseRightTopRight() {
        ChessBoard chessBoard = new ChessBoard();
        Position position = new Position(3, 3);
        Horse piece = new Horse(Color.WHITE, position, chessBoard);
        List<Position> movements = piece.getPossibleMoves();
        boolean isPossibleMove = piece.move(new Position(2, 5));
        assertTrue(isPossibleMove);
    }

    @Test
    public void testMoveHorseRightTopLeft() {
        ChessBoard chessBoard = new ChessBoard();
        Position position = new Position(3, 3);
        Horse piece = new Horse(Color.WHITE, position, chessBoard);
        List<Position> movements = piece.getPossibleMoves();
        boolean isPossibleMove = piece.move(new Position(1, 4));
        assertTrue(isPossibleMove);
    }

    @Test
    public void testMoveHorseRighBottomRight() {
        ChessBoard chessBoard = new ChessBoard();
        Position position = new Position(3, 3);
        Horse piece = new Horse(Color.WHITE, position, chessBoard);
        List<Position> movements = piece.getPossibleMoves();
        boolean isPossibleMove = piece.move(new Position(4, 5));
        assertTrue(isPossibleMove);
    }

    @Test
    public void testMoveHorseRightBottomLeft() {
        ChessBoard chessBoard = new ChessBoard();
        Position position = new Position(3, 3);
        Horse piece = new Horse(Color.WHITE, position, chessBoard);
        List<Position> movements = piece.getPossibleMoves();
        boolean isPossibleMove = piece.move(new Position(5, 4));
        assertTrue(isPossibleMove);
    }

    @Test
    public void testMoveHorseLeftTopRight() {
        ChessBoard chessBoard = new ChessBoard();
        Position position = new Position(3, 3);
        Horse piece = new Horse(Color.WHITE, position, chessBoard);
        List<Position> movements = piece.getPossibleMoves();
        boolean isPossibleMove = piece.move(new Position(1, 2));
        assertTrue(isPossibleMove);
    }

    @Test
    public void testMoveHorseLeftTopLeft() {
        ChessBoard chessBoard = new ChessBoard();
        Position position = new Position(3, 3);
        Horse piece = new Horse(Color.WHITE, position, chessBoard);
        List<Position> movements = piece.getPossibleMoves();
        boolean isPossibleMove = piece.move(new Position(2, 1));
        assertFalse(isPossibleMove);
    }

    @Test
    public void testMoveHorseLeftBottomRight() {
        ChessBoard chessBoard = new ChessBoard();
        Position position = new Position(3, 3);
        Horse piece = new Horse(Color.WHITE, position, chessBoard);
        List<Position> movements = piece.getPossibleMoves();
        boolean isPossibleMove = piece.move(new Position(5, 2));
        assertTrue(isPossibleMove);
    }

    @Test
    public void testMoveHorseLeftBottomLeft() {
        ChessBoard chessBoard = new ChessBoard();
        Position position = new Position(3, 3);
        Horse piece = new Horse(Color.WHITE, position, chessBoard);
        List<Position> movements = piece.getPossibleMoves();
        boolean isPossibleMove = piece.move(new Position(4, 1));
        assertFalse(isPossibleMove);
    }
}
