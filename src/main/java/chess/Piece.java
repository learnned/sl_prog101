enum Color {
    WHITE, BLACK
}

enum Symbol {
    p, B, H, R, Q, K;
}

enum Status {
    ALIVE, DEAD, VOID
}

abstract class Piece implements IMovable {
    private Color color;
    private Symbol symbol;
    private Status status;
    private Position position;

    public abstract void kill();

    public abstract void die();

    public Position getPosition() {
        return this.position;
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(final Color color) {
        this.color = color;
    }

    public void setSymbol(final Symbol symbol) {
        this.symbol = symbol;
    }

    public void setStatus(final Status status) {
        this.status = status;
    }

    public void setPosition(final Position position) {
        this.position = position;
    }

    public String toString() {
        String initial;
        if (this.color == Color.WHITE) {
            initial = "W";
        } else {
            initial = "B";
        }
        return "" + this.symbol + initial;
    }
}
