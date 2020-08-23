package chess;

abstract class Piece implements IMovable {
    private Color color;
    private Symbol symbol;
    private Status status;
    private Position position;
    private ChessBoard chessBoard;
    private int visualizationMode;
    static final String WHITE_STRING = "W";
    static final String BLACK_STRING = "B";
    static final int CASTLING_LEFT = -2, CASTLING_RIGHT = 2, CASTLING_LEFT_ROOK_SOURCE = 0, CASTLING_RIGHT_ROOK_SOURCE = 7, CASTLING_LEFT_ROOK_TARGET = 3, CASTLING_RIGHT_ROOK_TARGET = 5;
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
        this.visualizationMode = chessBoard.getVisualizationMode();
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
            if (this instanceof King && (this.getPosition().getColumn() - previousPosition.getColumn() == CASTLING_LEFT || this.getPosition().getColumn() - previousPosition.getColumn() == CASTLING_RIGHT)) {
                Piece rookMoved;
                int targetCol;
                if (this.getPosition().getColumn() - previousPosition.getColumn() == CASTLING_RIGHT) {
                    rookMoved = chessBoard.getBoard()[CASTLING_RIGHT_ROOK_SOURCE][previousPosition.getRow()];
                    targetCol = CASTLING_RIGHT_ROOK_TARGET;
                } else {
                    rookMoved = chessBoard.getBoard()[CASTLING_LEFT_ROOK_SOURCE][previousPosition.getRow()];
                    targetCol = CASTLING_LEFT_ROOK_TARGET;
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
        try {
            if (this.chessBoard.getVisualizationMode() == GameConsole.VISUALIZATION_ASCII) {
                if (this.color == Color.WHITE) {
                    return this.symbol.getWhite();
                } else {
                    return this.symbol.getWhite();
                }
            } else {
                if (this.color == Color.WHITE) {
                    return this.symbol.getlabel() + WHITE_STRING;
                } else {
                    return this.symbol.getlabel() + BLACK_STRING;
                }
            }
        } catch (Exception e) {
            if (this.color == Color.WHITE) {
                return this.symbol.getlabel() + WHITE_STRING;
            } else {
                return this.symbol.getlabel() + BLACK_STRING;
            }
        }
    }
}
