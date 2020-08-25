package pieces;
import game.ChessBoard;
import enums.Color;
import enums.Status;
import enums.Symbol;
import java.util.ArrayList;

public class Bishop extends Piece {
    static final int NEGATIVEONE = -1;
    static final int POSITIVEONE = +1;
    private GetPossibleMovePiece getPossibleMovePiece;

    Bishop(final Color color, final Position source) {
        super.setColor(color);
        super.setSymbol(Symbol.B);
        super.setStatus(Status.ALIVE);
        super.setPosition(source);
        this.getPossibleMovePiece = new GetPossibleMovePiece(this);
    }

    public Bishop(final Color color, final Position source, final ChessBoard chessBoard) {
        super.setColor(color);
        super.setSymbol(Symbol.B);
        super.setStatus(Status.ALIVE);
        super.setPosition(source);
        super.setChessBoard(chessBoard);
        this.getPossibleMovePiece = new GetPossibleMovePiece(this);
        super.setPossibleMovements(getPossibleMoves());
    }

    /**
     * Verifies all the possible moves of the bishop
     * @return arrayList with the possible moves of bishop
     */
    public ArrayList<Position> getPossibleMoves() {
        int row = this.getPosition().getRow();
        int column = this.getPosition().getColumn();
        ArrayList<Position> arrayPositions = new ArrayList<Position>();
        getPossibleMovePiece.possibleMovement(arrayPositions, column + NEGATIVEONE, row + NEGATIVEONE, NEGATIVEONE, NEGATIVEONE);
        getPossibleMovePiece.possibleMovement(arrayPositions, column + POSITIVEONE, row + NEGATIVEONE, NEGATIVEONE, POSITIVEONE);
        getPossibleMovePiece.possibleMovement(arrayPositions, column + POSITIVEONE, row + POSITIVEONE, POSITIVEONE, POSITIVEONE);
        getPossibleMovePiece.possibleMovement(arrayPositions, column + NEGATIVEONE, row + POSITIVEONE, POSITIVEONE, NEGATIVEONE);
        return arrayPositions;
    }

    public void checkmate() {
    }
}
