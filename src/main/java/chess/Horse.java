package chess;
import java.util.ArrayList;
import java.util.List;

class Horse extends Piece {
    Horse(final Color color, final Position source) {
        super.setColor(color);
        super.setSymbol(Symbol.H);
        super.setStatus(Status.ALIVE);
        super.setPosition(source);
    }

    public void kill(final Piece target) {
    }

    public void move(final Piece target) {
    }

    public void die() {
    }

    public boolean isPosibleMove(final Piece target) {
        return true;
    }

    public List<Piece> getPosibleMoves(final ChessBoard chb) {
        List<Piece> array = new ArrayList<Piece>();
        return array;
    }

    public void checkmate() {
    }
}
