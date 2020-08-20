package chess;
import java.util.ArrayList;

class Bishop extends Piece {

    private DiagonalMovePiece diagonalMovePiece;

    Bishop(final Color color, final Position source, final ChessBoard chessBoard) {
        super.setColor(color);
        super.setSymbol(Symbol.B);
        super.setStatus(Status.ALIVE);
        super.setPosition(source);
        super.setChessBoard(chessBoard);
        this.diagonalMovePiece = new DiagonalMovePiece(this);
    }


    public ArrayList<Position> getPosibleMoves(final ChessBoard chb) {
        int row = this.getPosition().getRow();
        int column = this.getPosition().getColumn();
        ArrayList<Position> arraypositions = new ArrayList<Position>();
        diagonalMovePiece.diagonal(arraypositions, column - 1, row - 1, -1, -1);
        diagonalMovePiece.diagonal(arraypositions, column + 1, row - 1, -1, +1);
        diagonalMovePiece.diagonal(arraypositions, column + 1, row + 1, +1, +1);
        diagonalMovePiece.diagonal(arraypositions, column - 1, row + 1, +1, -1);
        for (Position p: arraypositions) {
            System.out.print(p.getColumn() + "." + p.getRow() + " |");
        }
        System.out.println();

        return arraypositions;
    }

  /*
    /*void diagonal(final ArrayList<Position> arraypositions, final int column, final int row, final int rowIncrement, final int columnIncrement) {
        int c = column;
        int r = row;
        while ((r >= 0) && (c >= 0) && (r < LIMIT_OF_ARRAY) && (c < LIMIT_OF_ARRAY)) {
                    if (isPosibleToContinue(super.getChessBoard().getBoard()[c][r]) == -1) {
                        arraypositions.add(super.getChessBoard().getBoard()[c][r].getPosition());
                        break;
                    } else if (isPosibleToContinue(super.getChessBoard().getBoard()[c][r ]) == 0) {
                        arraypositions.add(new Position(c, r));
                        c += columnIncrement;
                        r += rowIncrement;
                    } else {
                        break;
                    }
        }
    }*/





    public void checkmate() {
    }
}
