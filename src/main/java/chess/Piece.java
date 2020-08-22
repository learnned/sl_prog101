package chess;

abstract class Piece implements IMovable {
    private Color color;
    private Symbol symbol;
    private Status status;
    private Position position;
    private ChessBoard chessBoard;
    static final String WHITE_STRING = "W";
    static final String BLACK_STRING = "B";
    private boolean firstMovement = true;

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

    public boolean getFirstMovement() {
        return firstMovement;
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

    public boolean move(final Position target) {
        if (isPossibleMove(target)) {
            Position previousPosition = this.getPosition();
            if (firstMovement) {
                firstMovement = false;
            }
            if (chessBoard.getBoard()[target.getColumn()][target.getRow()] != null) {
                chessBoard.getBoard()[target.getColumn()][target.getRow()].die();
            }
            chessBoard.addPiece(this);
            this.position = target;
            chessBoard.getBoard()[previousPosition.getColumn()][previousPosition.getRow()] = null;
            if (this instanceof King && (this.getPosition().getColumn() - previousPosition.getColumn() == -2 || this.getPosition().getColumn() - previousPosition.getColumn() == 2)) {
                Piece rookMoved;
                int targetCol;
                if (this.getPosition().getColumn() - previousPosition.getColumn() == 2){
                    rookMoved = chessBoard.getBoard()[7][previousPosition.getRow()];
                    targetCol = 5;
                } else {
                    rookMoved = chessBoard.getBoard()[0][previousPosition.getRow()];
                    targetCol = 3;
                }
                Position previousRookPos = rookMoved.getPosition();
                if (rookMoved.firstMovement) {
                    firstMovement = false;
                }
                chessBoard.addPiece(rookMoved);
                rookMoved.position = new Position(targetCol, previousPosition.getRow());
                chessBoard.getBoard()[previousRookPos.getColumn()][previousRookPos.getRow()] = null;
            }
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
