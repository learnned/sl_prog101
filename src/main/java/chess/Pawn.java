package chess;

import java.util.ArrayList;

class Pawn extends Piece implements IPawn {
    static final int LIMIT_OF_ARRAY = 8, EMPTY = 0, FRIEND = 1, ENEMY = -1;
    private static boolean firstMovement;
    Pawn(final Color color, final Position source) {
        super.setColor(color);
        super.setSymbol(Symbol.p);
        super.setStatus(Status.ALIVE);
        super.setPosition(source);
        firstMovement = true;
    }

    Pawn(final Color color, final Position source, final ChessBoard chessBoard) {
        super.setColor(color);
        super.setSymbol(Symbol.p);
        super.setStatus(Status.ALIVE);
        super.setPosition(source);
        super.setChessBoard(chessBoard);
        firstMovement = true;
    }

    public ArrayList<Position> getPossibleMoves() {
        int row = this.getPosition().getRow();
        int column = this.getPosition().getColumn();
        ArrayList<Position> arrayPositions = new ArrayList<Position>();
        if ((row >= 0) && (column >= 0) && (row < LIMIT_OF_ARRAY) && (column < LIMIT_OF_ARRAY)) {
            checkMovements(arrayPositions, "WHITE", column, row, 1, -1);
            checkMovements(arrayPositions, "BLACK", column, row, -1, 1);
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
        if (firstMovement) {
            this.firstMovement = false;
        }
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
}
