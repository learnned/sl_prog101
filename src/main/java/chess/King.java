import java.util.ArrayList;

class King extends Piece implements ICastling, ICheck {
    King(final Color color, final Position source) {
        super.setColor(color);
        super.setSymbol(Symbol.K);
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

    public void castling() {
    }

    public boolean doesCheck() {
        return false;
    }
}
