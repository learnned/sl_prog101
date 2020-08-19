package chess;

abstract class Piece implements IMovable {
    private Color color;
    private Symbol symbol;
    private Status status;
    private Position position;
    static final String WHITE_STRING = "W";
    static final String BLACK_STRING = "B";

    public final void die() {
        this.status = Status.DEAD;
    }

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
    public void setPosition(final Position source) {
        this.position = source;
    }

    public boolean move(final Position position, final ChessBoard chess) {
        if (isPossibleMove(position, chess)) {
           if (chess.getBoard()[this.position.getColumn()][this.position.getRow()] != null) {
               chess.getBoard()[this.position.getColumn()][this.position.getRow()].die();
           }
           //chess.getBoard()[this.position.getColumn()][this.position.getRow()] = null;
           chess.move2(this.position, null);
           this.position = position;
           chess.getBoard()[this.position.getColumn()][this.position.getRow()] = this;
           return true;
       }
       return false;
    }
    public boolean isPossibleMove(final Position target, final ChessBoard chess) {
            for (Position pos : getPosibleMoves(chess)) {
                if ((pos.getColumn() == target.getColumn()) && (pos.getRow() == target.getRow())) {
                    return true;
                }
            }
            return false;
    }

    public String toString() {
        String initial;
        if (this.color == Color.WHITE) {
            initial = WHITE_STRING;
        } else {
            initial = BLACK_STRING;
        }
        return this.symbol.toString() + initial;
    }
}
