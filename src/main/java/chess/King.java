package chess;

import java.util.ArrayList;

class King extends Piece implements ICastling, ICheck {
    King(final Color color, final Position source) {
        super.setColor(color);
        super.setSymbol(Symbol.K);
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
    public void castling() {

    }

    @Override
    public boolean doesCheck() {
        return false;
    }
}
