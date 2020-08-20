package chess;
import java.util.ArrayList;

class Horse extends Piece {
    Horse(final Color color, final Position source) {
        super.setColor(color);
        super.setSymbol(Symbol.H);
        super.setStatus(Status.ALIVE);
        super.setPosition(source);
    }

    public ArrayList<Position> getPossibleMoves() {
        ArrayList<Position> array = new ArrayList<Position>();
        return array;
    }

    public void checkmate() {
    }
}
