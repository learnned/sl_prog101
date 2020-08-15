//package chess;

import java.util.ArrayList;

class Pawn extends Piece implements IPawn {
    Pawn(final Color color, final Position source) {
        super.setColor(color);
        super.setSymbol(Symbol.p);
        super.setStatus(Status.ALIVE);
        super.setPosition(source);
    }

    public void kill() {
    }

    public void die() {
    }

    public Position move(final Position target) {
        return super.getPosition();
    }

    public boolean isPosibleMove(final Position target) {
        return true;
    }

    public ArrayList<Position> getPosibleMoves() {
        ArrayList<Position> array = new ArrayList<Position>();
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
