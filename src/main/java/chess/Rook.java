package chess;

import java.util.ArrayList;
class Rook extends Piece implements ICastling {

    private RectMovePiece rectMovePiece;
    Rook(final Color color, final Position source, final ChessBoard chessBoard) {
        super.setColor(color);
        super.setSymbol(Symbol.R);
        super.setStatus(Status.ALIVE);
        super.setPosition(source);
        super.setChessBoard(chessBoard);
        this.rectMovePiece = new RectMovePiece(this);
    }

    public ArrayList<Position> getPosibleMoves(final ChessBoard chb) {
        ArrayList<Position> arraypositions = new ArrayList<Position>();
        int row = this.getPosition().getRow();
        int column = this.getPosition().getColumn();
        rectMovePiece.rect(arraypositions, column + 1, row, 0, +1);
        rectMovePiece.rect(arraypositions, column - 1, row, 0, -1);
        rectMovePiece.rect(arraypositions, column, row + 1, +1, 0);
        rectMovePiece.rect(arraypositions, column, row - 1, -1, 0);
        for (Position p: arraypositions) {
            System.out.print(p.getColumn() + "." + p.getRow() + " |");
        }

        return arraypositions;
    }


    public void checkmate() {
    }

    public void castling() {
    }
}
