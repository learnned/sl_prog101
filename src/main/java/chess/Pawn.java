package chess;

import java.util.ArrayList;

class Pawn extends Piece implements IPawn {
    Pawn(final Color color, final Position source) {
        super.setColor(color);
        super.setSymbol(Symbol.p);
        super.setStatus(Status.ALIVE);
        super.setPosition(source);
    }

    public ArrayList<Position> getPosibleMoves(final ChessBoard chb) {
        ArrayList<Position> array = new ArrayList<Position>();
        return array;
    }

    public void checkmate() {
    }

    @Override
    public Piece promotion(final byte type) {
        return null;
    }

    @Override
    public void inPassant() {

    }
}
