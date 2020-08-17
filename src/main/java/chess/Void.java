package chess;

import java.util.ArrayList;

class Void extends Piece {
    Void(final Position source) {
        super.setSymbol(Symbol.v);
        super.setStatus(Status.VOID);
        super.setPosition(source);
    }

    public void kill() {
    }

    public void die() {
    }

    public Position move(final Piece target) {
        return super.getPosition();
    }

    public boolean isPosibleMove(final Piece target) {
        return true;
    }

    public ArrayList<Position> getPosibleMoves() {
        ArrayList<Position> array = new ArrayList<Position>();
        return array;
    }

    public void checkmate() {
    }
}
