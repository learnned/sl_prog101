package chess;

import java.util.ArrayList;
class Rook extends Piece implements ICastling {

    private GetPossibleMovePiece getPossibleMovePiece;
    Rook(final Color color, final Position source, final ChessBoard chessBoard) {
        super.setColor(color);
        super.setSymbol(Symbol.R);
        super.setStatus(Status.ALIVE);
        super.setPosition(source);
        super.setChessBoard(chessBoard);
        this.getPossibleMovePiece = new GetPossibleMovePiece(this);
    }

    public ArrayList<Position> getPossibleMoves(final ChessBoard chb) {
        ArrayList<Position> arraypositions = new ArrayList<Position>();
        int row = this.getPosition().getRow();
        int column = this.getPosition().getColumn();
        getPossibleMovePiece.diagonal(arraypositions, column + 1, row, 0, +1);
        getPossibleMovePiece.diagonal(arraypositions, column - 1, row, 0, -1);
        getPossibleMovePiece.diagonal(arraypositions, column, row + 1, +1, 0);
        getPossibleMovePiece.diagonal(arraypositions, column, row - 1, -1, 0);
        return arraypositions;
    }


    public void checkmate() {
    }

    public void castling() {
    }
}
