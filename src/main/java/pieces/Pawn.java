package pieces;
import game.ChessBoard;
import enums.Color;
import enums.Status;
import enums.Symbol;
import interfaces.IPawn;
import java.util.ArrayList;

public class Pawn extends Piece implements IPawn {
    static final int LIMIT_OF_ARRAY = 8, EMPTY = 0, FRIEND = 1, ENEMY = -1, BEGGING_OF_ARRAY = 0;
    static final int ROCK = 0, BISHOP = 1, QUEEN = 3, HORSE = 2, NEGATIVE = -1, POSITIVE = 1;
    publi final int INCREMENT_BLACK = +1, INCREMENT_WHITE = -1;
    public Pawn(final Color color, final Position source) {
        super.setColor(color);
        super.setSymbol(Symbol.P);
        super.setStatus(Status.ALIVE);
        super.setPosition(source);
    }

    public Pawn(final Color color, final Position source, final ChessBoard chessBoard) {
        super.setColor(color);
        super.setSymbol(Symbol.P);
        super.setStatus(Status.ALIVE);
        super.setPosition(source);
        super.setChessBoard(chessBoard);
    }

    /**
     * Verifies all the possible position
     * @return ArrayList with the possible positions
     */
    public ArrayList<Position> getPossibleMoves() {
        int row = this.getPosition().getRow();
        int column = this.getPosition().getColumn();
        ArrayList<Position> arrayPositions = new ArrayList<Position>();
        if ((row >= BEGGING_OF_ARRAY) && (column >= BEGGING_OF_ARRAY) && (row < LIMIT_OF_ARRAY) && (column < LIMIT_OF_ARRAY)) {
            checkMovements(arrayPositions, "WHITE", column, row, POSITIVE, NEGATIVE);
            checkMovements(arrayPositions, "BLACK", column, row, NEGATIVE, POSITIVE);
        }
        return arrayPositions;
    }

    /**
     *
     * @param targetPiece
     * @return
     */
    public byte possibleMovement(final Piece targetPiece) {
        if (targetPiece == null) {
            return EMPTY;
        }
        if (this.getColor() != targetPiece.getColor()) {
            return ENEMY;
        }
        return FRIEND;
    }

    /**
     *
     * @param arrayPositions
     * @param color
     * @param column
     * @param row
     * @param negative
     * @param positive
     */
    public void checkMovements(final ArrayList<Position> arrayPositions, final String color, final int column, final int row, final int negative, final int positive) {
        if ((super.getColor() + "").equals(color)) {
            if (getFirstMovement()) {
                inPassant(arrayPositions, column, row, negative);
            }
            if (possibleMovement(this.getChessBoard().getBoard()[column][row + negative]) == EMPTY) {
                arrayPositions.add(new Position(column, row + negative));
            }
            if (possibleMovement(this.getChessBoard().getBoard()[column + negative][row + negative]) == ENEMY) {
                arrayPositions.add(this.getChessBoard().getBoard()[column + negative][row + negative].getPosition());
            }
            if (possibleMovement(this.getChessBoard().getBoard()[column + positive][row + negative]) == ENEMY) {
                arrayPositions.add(this.getChessBoard().getBoard()[column + positive][row + negative].getPosition());
            }
        }
    }

    public void checkmate() {
    }

    /**
     *
     * @param type
     * @return
     */
    @Override
    public Piece promotion(final byte type) {
        int row =  this.getPosition().getRow();
        int column = this.getPosition().getColumn();
        if (row == BEGGING_OF_ARRAY || row == LIMIT_OF_ARRAY) {
            this.getChessBoard().getBoard()[column][row] = getPiece(type);
        }
        return null;
    }

    /**
     *
     */
    @Override
    public void inPassant(final ArrayList<Position> arrayPositions, final int column, final int row, final int increment) {
        if (possibleMovement(this.getChessBoard().getBoard()[column][row + increment + increment]) == EMPTY) {
            arrayPositions.add(new Position(column, row + increment + increment));
        }
    }

    /**
     *
     * @param type
     * @return
     */
    public Piece getPiece(final byte type) {
        if (type == ROCK) {
            Piece rock =  new Rook(this.getColor(), this.getPosition());
            return rock;
        }
        if (type == BISHOP) {
            Piece bishop =  new Bishop(this.getColor(), this.getPosition());
            return bishop;
        }
        if (type == HORSE) {
            Piece horse =  new Horse(this.getColor(), this.getPosition());
            return horse;
        }
        if (type == QUEEN) {
            Piece queen =  new Queen(this.getColor(), this.getPosition());
            return queen;
        }
        return null;
    }
}
