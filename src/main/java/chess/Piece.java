package chess;

abstract class Piece implements IMovable {
    private Color color;
    private Symbol symbol;
    private Status status;
    private Position position;
    private ChessBoard chessBoard;
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
    public void setChessBoard(final ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
    }

    public boolean move(final Position position) {
        if (isPossibleMove(position)) {
           if (chessBoard.getBoard()[this.position.getColumn()][this.position.getRow()] != null) {
               chessBoard.getBoard()[this.position.getColumn()][this.position.getRow()].die();
           }
           //chess.getBoard()[this.position.getColumn()][this.position.getRow()] = null;
            chessBoard.addPiece(this);
           this.position = position;
            chessBoard.getBoard()[this.position.getColumn()][this.position.getRow()] = this;
           return true;
       }
       return false;
    }
    public boolean isPossibleMove(final Position target) {
            for (Position pos : getPossibleMoves()) {
                if ((pos.getColumn() == target.getColumn()) && (pos.getRow() == target.getRow())) {
                    return true;
                }
            }
            return false;
    }
    public ChessBoard getChessBoard() {
        return chessBoard;
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
