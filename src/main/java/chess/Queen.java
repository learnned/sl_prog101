package chess;

import java.util.ArrayList;
class Queen extends Piece {
    private GetPossibleMovePiece getPossibleMovePiece;

    Queen(final Color color, final Position source, final ChessBoard chessBoard) {
        super.setColor(color);
        super.setSymbol(Symbol.Q);
        super.setStatus(Status.ALIVE);
        super.setChessBoard(chessBoard);
        super.setPosition(source);

        this.getPossibleMovePiece = new GetPossibleMovePiece(this);
    }

    public ArrayList<Position> getPossibleMoves() {
        int row = this.getPosition().getRow();
        int column = this.getPosition().getColumn();
        ArrayList<Position> arrayPositions = new ArrayList<Position>();
        return arrayPositions;
    }

    public void checkmate() {
    }
}
