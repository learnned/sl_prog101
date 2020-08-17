package chess;

import java.util.ArrayList;
import java.util.List;

class Pawn extends Piece implements IPawn {
    Pawn(final Color color, final Position source) {
        super.setColor(color);
        super.setSymbol(Symbol.p);
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

    public Piece promotion(final byte type) {
        Position pos = new Position(0, 0);
        Pawn piece = new Pawn(Color.WHITE, pos);
        return piece;
    }

    public void inPassant() {
    }
}
