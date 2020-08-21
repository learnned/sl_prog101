package chess;

import java.util.ArrayList;
class Rook extends Piece implements ICastling {

    private GetPossibleMovePiece getPossibleMovePiece;
    Rook(final Color color, final Position source, final ChessBoard chessBoard) {
        super.setColor(color);
        super.setSymbol(Symbol.R);
        super.setStatus(Status.ALIVE);
        super.setPosition(source);
        super.setChessBoard(chessBoard);
        this.getPossibleMovePiece = new GetPossibleMovePiece(this);
    }

    public ArrayList<Position> getPossibleMoves() {
        ArrayList<Position> arrayPositions = new ArrayList<Position>();
        int row = this.getPosition().getRow();
        int column = this.getPosition().getColumn();
        getPossibleMovePiece.possibleMovement(arrayPositions, column + 1, row, 0, +1);
        getPossibleMovePiece.possibleMovement(arrayPositions, column - 1, row, 0, -1);
        getPossibleMovePiece.possibleMovement(arrayPositions, column, row + 1, +1, 0);
        getPossibleMovePiece.possibleMovement(arrayPositions, column, row - 1, -1, 0);
        return arrayPositions;
    }


    public void checkmate() {
    }

    public void castling() {
    }
}
