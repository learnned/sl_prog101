package chess;
import java.util.ArrayList;

class Bishop extends Piece {

    static final int LIMIT_OF_ARRAY = 8;

    Bishop(final Color color, final Position source) {
        super.setColor(color);
        super.setSymbol(Symbol.B);
        super.setStatus(Status.ALIVE);
        super.setPosition(source);
    }



    public ArrayList<Position> getPosibleMoves(final ChessBoard chb) {
        ArrayList<Position> arraypositions = new ArrayList<Position>();
        Piece[][] board = chb.getBoard(); //Implement possible kill
        leftDownDiagonal(arraypositions, board);
        leftUpDiagonal(arraypositions, board);
        rightUpDiagonal(arraypositions, board);
        rightDownDiagonal(arraypositions, board);
        for (Position p: arraypositions) {
            System.out.print(p.getColumn() + "." + p.getRow() + " |");
        }

        return arraypositions;
    }
    void leftDownDiagonal(final ArrayList<Position> arraypositions, final Piece[][] board) {
       int row = this.getPosition().getRow() - 1;
       int column = this.getPosition().getColumn() - 1;
        while ((row >= 0) && (column >= 0)) {
                    if (isPosibleToContinue(board[column][row]) == -1) {
                        arraypositions.add(board[column][row].getPosition());
                        break;
                    } else if (isPosibleToContinue(board[column][row ]) == 0) {
                        arraypositions.add(new Position(column, row));
                        column--;
                        row--;
                    } else {
                        break;
                    }
        }
    }
    void leftUpDiagonal(final ArrayList<Position> arraypositions, final Piece[][] board) {
        int row = this.getPosition().getRow() - 1;
        int column = this.getPosition().getColumn() + 1;
        while ((row >= 0) && (column < LIMIT_OF_ARRAY)) {
                if (isPosibleToContinue(board[column][row]) == -1) {
                    arraypositions.add(board[column][row].getPosition());
                    break;
                } else if (isPosibleToContinue(board[column][row]) == 0) {
                    arraypositions.add(new Position(column, row));
                    column++;
                    row--;
                } else {
                    break;
                }
        }
    }
    void rightUpDiagonal(final ArrayList<Position> arraypositions, final Piece[][] board) {
        int row = this.getPosition().getRow() + 1;
        int column = this.getPosition().getColumn() + 1;
        while ((row < LIMIT_OF_ARRAY) && (column < LIMIT_OF_ARRAY)) {
            if (isPosibleToContinue(board[column][row]) == -1) {
                arraypositions.add(board[column][row].getPosition());
                break;
            } else if (isPosibleToContinue(board[column][row]) == 0) {
                arraypositions.add(new Position(column, row));
                column++;
                row++;
            } else {
                break;
            }
        }
    }

    void rightDownDiagonal(final ArrayList<Position> arraypositions, final Piece[][] board) {
        int row = this.getPosition().getRow() + 1;
        int column = this.getPosition().getColumn() - 1;
        while ((row < LIMIT_OF_ARRAY) && (column >= 0)) {
            if (isPosibleToContinue(board[column][row]) == -1) {
                arraypositions.add(board[column][row].getPosition());
                break;
            } else if (isPosibleToContinue(board[column][row]) == 0) {
                arraypositions.add(new Position(column, row));
                column--;
                row++;
            } else {
                break;
            }
        }
    }

    public byte isPosibleToContinue(final Piece piece) {

        if (piece == null) {
            return 0;
        }
        if (piece.getColor() != this.getColor()) {
            return -1;
        }
        return 1;
    }

    public void checkmate() {
    }
}
