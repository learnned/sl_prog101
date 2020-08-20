package chess;
import java.util.ArrayList;

class Bishop extends Piece {

    private GetPossibleMovePiece getPossibleMovePiece;

    Bishop(final Color color, final Position source, final ChessBoard chessBoard) {
        super.setColor(color);
        super.setSymbol(Symbol.B);
        super.setStatus(Status.ALIVE);
        super.setPosition(source);
        super.setChessBoard(chessBoard);
        this.getPossibleMovePiece = new GetPossibleMovePiece(this);
    }


    public ArrayList<Position> getPosibleMoves(final ChessBoard chb) {
        int row = this.getPosition().getRow();
        int column = this.getPosition().getColumn();
        ArrayList<Position> arraypositions = new ArrayList<Position>();
        getPossibleMovePiece.diagonal(arraypositions, column - 1, row - 1, -1, -1);
        getPossibleMovePiece.diagonal(arraypositions, column + 1, row - 1, -1, +1);
        getPossibleMovePiece.diagonal(arraypositions, column + 1, row + 1, +1, +1);
        getPossibleMovePiece.diagonal(arraypositions, column - 1, row + 1, +1, -1);
        for (Position p: arraypositions) {
            System.out.print(p.getColumn() + "." + p.getRow() + " |");
        }
        System.out.println();

        return arraypositions;
    }

    public void checkmate() {
    }
}
