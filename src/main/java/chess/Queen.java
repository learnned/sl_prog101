package chess;

import java.util.ArrayList;
class Queen extends Piece {
    private GetPossibleMovePiece getPossibleMovePiece;
    static final int NEGATIVEONE = -1;
    static final int POSITIVEONE = +1;
    static final int ZERO = 0;

    Queen(final Color color, final Position source) {
        super.setColor(color);
        super.setSymbol(Symbol.Q);
        super.setStatus(Status.ALIVE);
        super.setPosition(source);
        this.getPossibleMovePiece = new GetPossibleMovePiece(this);
    }

    Queen(final Color color, final Position source, final ChessBoard chessBoard) {
        super.setColor(color);
        super.setSymbol(Symbol.Q);
        super.setStatus(Status.ALIVE);
        super.setChessBoard(chessBoard);
        super.setPosition(source);
        this.getPossibleMovePiece = new GetPossibleMovePiece(this);
    }

    public ArrayList<Position> getPossibleMoves() {
        int row = this.getPosition().getRow();
        int column = this.getPosition().getColumn();
        ArrayList<Position> possibleMovementsArray = new ArrayList<Position>();
        getPossibleMovePiece.possibleMovement(possibleMovementsArray, column + NEGATIVEONE, row + NEGATIVEONE, NEGATIVEONE, NEGATIVEONE);
        getPossibleMovePiece.possibleMovement(possibleMovementsArray, column + POSITIVEONE, row + NEGATIVEONE, NEGATIVEONE, POSITIVEONE);
        getPossibleMovePiece.possibleMovement(possibleMovementsArray, column + POSITIVEONE, row + POSITIVEONE, POSITIVEONE, POSITIVEONE);
        getPossibleMovePiece.possibleMovement(possibleMovementsArray, column + NEGATIVEONE, row + POSITIVEONE, POSITIVEONE, NEGATIVEONE);
        getPossibleMovePiece.possibleMovement(possibleMovementsArray, column + POSITIVEONE, row, ZERO, POSITIVEONE);
        getPossibleMovePiece.possibleMovement(possibleMovementsArray, column + NEGATIVEONE, row, ZERO, NEGATIVEONE);
        getPossibleMovePiece.possibleMovement(possibleMovementsArray, column, row + POSITIVEONE, POSITIVEONE, ZERO);
        getPossibleMovePiece.possibleMovement(possibleMovementsArray, column, row + NEGATIVEONE, NEGATIVEONE, ZERO);
        return possibleMovementsArray;
    }

    public void checkmate() {
    }
}
