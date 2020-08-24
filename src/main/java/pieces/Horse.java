package pieces;
import game.ChessBoard;
import enums.Color;
import enums.Status;
import enums.Symbol;
import java.util.ArrayList;

public class Horse extends Piece {

    private GetPossibleMovePiece getPossibleMovePiece;

    public Horse(final Color color, final Position source, final ChessBoard chessBoard) {
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

    /**
     * verifies all the possible movemento of the horse
     * @return arrayList with the possible moves of horse
     */
    public ArrayList<Position> getPossibleMoves() {
        ArrayList<Position> arrayPosition = new ArrayList<Position>();
        getPossibleMovePiece.possibleMovementHorse(arrayPosition, this.getPosition().getColumn(), this.getPosition().getRow());
        return arrayPosition;
    }

    public void checkmate() {
    }
}
