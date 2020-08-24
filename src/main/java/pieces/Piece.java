package pieces;
import static java.lang.Math.abs;
import game.ChessBoard;
import game.GameConsole;
import interfaces.IMovable;
import enums.Color;
import enums.Symbol;
import enums.Status;

 public abstract class Piece implements IMovable {
    private Color color;
    private Symbol symbol;
    private Status status;
    private Position position;
    private ChessBoard chessBoard;
    private boolean visualizationMode;
    static final String WHITE_STRING = "W";
    static final String BLACK_STRING = "B";
    static final int CASTLING_RIGHT = 2, CASTLING_LEFT_ROOK_COL_SOURCE = 0, CASTLING_RIGHT_ROOK_COL_SOURCE = 7, CASTLING_LEFT_ROOK_TARGET = 3, CASTLING_RIGHT_ROOK_TARGET = 5;
    private boolean firstMovement = true;

    public final void die() {
        this.status = Status.DEAD;
    }

     /**
      *
      * @return Position the actual position of the piece
      */
    public Position getPosition() {
        return this.position;
    }

     /**
      *
      * @return the color of the piece
      */
    public Color getColor() {
        return this.color;
    }

     /**
      *
      * @param color
      */
    public void setColor(final Color color) {
        this.color = color;
    }

     /**
      *
      * @return
      */
    public boolean getFirstMovement() {
        return firstMovement;
    }

     /**
      *
      * @param symbol
      */
    public void setSymbol(final Symbol symbol) {
        this.symbol = symbol;
    }

     /**
      *
      * @param status
      */
    public void setStatus(final Status status) {
        this.status = status;
    }

     /**
      *
      * @param source
      */
    public void setPosition(final Position source) {
        this.position = source;
    }

     /**
      *
      * @param chessBoard
      */
    public void setChessBoard(final ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
        this.visualizationMode = chessBoard.getVisualizationMode();
    }

     /**
      *
      * @param target
      * @return
      */
    public boolean move(final Position target) {
        if (isPossibleMove(target)) {
            Position previousPosition = this.getPosition();
            if (firstMovement) {
                firstMovement = false;
            }
            if (chessBoard.getBoard()[target.getColumn()][target.getRow()] != null) {
                chessBoard.getBoard()[target.getColumn()][target.getRow()].die();
            }
            this.position = target;
            chessBoard.movePiece(this, previousPosition);
            if (this instanceof King && abs(this.getPosition().getColumn() - previousPosition.getColumn()) == CASTLING_RIGHT) {
                int positionsDiff = this.getPosition().getColumn() - previousPosition.getColumn();
                if (positionsDiff == CASTLING_RIGHT) {
                    moveRookWhenCastling(CASTLING_RIGHT_ROOK_COL_SOURCE, target.getRow(), CASTLING_RIGHT_ROOK_TARGET);
                } else {
                    moveRookWhenCastling(CASTLING_LEFT_ROOK_COL_SOURCE, target.getRow(), CASTLING_LEFT_ROOK_TARGET);
                }
            }
            return true;
        }
        return false;
    }

     public void moveRookWhenCastling(final int sourceCol, final int row, final int targetCol) {
         Piece rookToMove = chessBoard.getBoard()[sourceCol][row];
         rookToMove.firstMovement = false;
         rookToMove.position.setColumn(targetCol);
         chessBoard.getBoard()[targetCol][row] = rookToMove;
         chessBoard.getBoard()[sourceCol][row] = null;
     }

     /**
      *
      * @param target
      * @return
      */
    public boolean isPossibleMove(final Position target) {
        for (Position pos : getPossibleMoves()) {
            if ((pos.getColumn() == target.getColumn()) && (pos.getRow() == target.getRow())) {
                return true;
            }
        }
        return false;
    }

     /**
      *
      * @return
      */
    public ChessBoard getChessBoard() {
        return chessBoard;
    }

     /**
      *
      * @return
      */
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
