package chess;
import java.util.ArrayList;

class Horse extends Piece {

    private GetPossibleMovePiece getPossibleMovePiece;

    Horse(final Color color, final Position source, final ChessBoard chessBoard) {
        super.setColor(color);
        super.setSymbol(Symbol.H);
        super.setStatus(Status.ALIVE);
        super.setPosition(source);
        super.setChessBoard(chessBoard);
        getPossibleMovePiece = new GetPossibleMovePiece(this);
    }
    Horse(final Color color, final Position source) {
        super.setColor(color);
        super.setSymbol(Symbol.H);
        super.setStatus(Status.ALIVE);
        super.setPosition(source);
        getPossibleMovePiece = new GetPossibleMovePiece(this);
    }

    public ArrayList<Position> getPossibleMoves() {
        ArrayList<Position> arrayPosition = new ArrayList<Position>();
        getPossibleMovePiece.possibleMovementHorse(arrayPosition, this.getPosition().getColumn(), this.getPosition().getRow());
        return arrayPosition;
    }

    public void checkmate() {
    }
}
