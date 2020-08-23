package chess;

import java.util.ArrayList;

class Pawn extends Piece implements IPawn {
    static final int LIMIT_OF_ARRAY = 8, EMPTY = 0, FRIEND = 1, ENEMY = -1, BEGGING_OF_ARRAY = 0;
    static final int ROCK = 0, BISHOP = 1, QUEEN = 3, HORSE = 2, NEGATIVE = -1, POSITIVE = 1;
    private static boolean firstMovement;
    Pawn(final Color color, final Position source) {
        super.setColor(color);
        super.setSymbol(Symbol.P);
        super.setStatus(Status.ALIVE);
        super.setPosition(source);
        firstMovement = true;
    }

    Pawn(final Color color, final Position source, final ChessBoard chessBoard) {
        super.setColor(color);
        super.setSymbol(Symbol.P);
        super.setStatus(Status.ALIVE);
        super.setPosition(source);
        super.setChessBoard(chessBoard);
        firstMovement = true;
    }

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

    public byte possibleMovement(final Piece targetPiece) {
        if (targetPiece == null) {
            return EMPTY;
        }
        if (this.getColor() != targetPiece.getColor()) {
            return ENEMY;
        }
        return FRIEND;
    }
    public void changeFirstMovementState() {
            this.firstMovement = false;
    }

    public void checkMovements(final ArrayList<Position> arrayPositions, final String color, final int column, final int row, final int negative, final int positive) {
        if ((super.getColor() + "").equals(color)) {
            if (firstMovement) {
                if (possibleMovement(this.getChessBoard().getBoard()[column][row + negative]) == EMPTY) {
                    arrayPositions.add(new Position(column, row + negative + negative));
                }
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

    @Override
    public Piece promotion(final byte type) {
        return null;
    }

    @Override
    public void inPassant() {

    }

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
