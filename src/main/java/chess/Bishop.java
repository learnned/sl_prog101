package chess;
import java.util.ArrayList;

class Bishop extends Piece {

    private GetPossibleMovePiece getPossibleMovePiece;

    Bishop(final Color color, final Position source) {
        super.setColor(color);
        super.setSymbol(Symbol.B);
        super.setStatus(Status.ALIVE);
        super.setPosition(source);
        this.getPossibleMovePiece = new GetPossibleMovePiece(this);
    }

    Bishop(final Color color, final Position source, final ChessBoard chessBoard) {
        super.setColor(color);
        super.setSymbol(Symbol.B);
        super.setStatus(Status.ALIVE);
        super.setPosition(source);
        super.setChessBoard(chessBoard);
        this.getPossibleMovePiece = new GetPossibleMovePiece(this);
    }


    public ArrayList<Position> getPossibleMoves() {
        int row = this.getPosition().getRow();
        int column = this.getPosition().getColumn();
        ArrayList<Position> arrayPositions = new ArrayList<Position>();
        getPossibleMovePiece.possibleMovement(arrayPositions, column - 1, row - 1, -1, -1);
        getPossibleMovePiece.possibleMovement(arrayPositions, column + 1, row - 1, -1, +1);
        getPossibleMovePiece.possibleMovement(arrayPositions, column + 1, row + 1, +1, +1);
        getPossibleMovePiece.possibleMovement(arrayPositions, column - 1, row + 1, +1, -1);
        return arrayPositions;
    }

    public void checkmate() {
    }
}
