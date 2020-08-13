import java.util.ArrayList;

class Horse extends Piece {
    Horse(final Color color, final Position source) {
        super.setColor(color);
        super.setSymbol(Symbol.H);
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
}
