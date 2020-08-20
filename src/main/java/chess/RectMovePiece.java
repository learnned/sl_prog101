package chess;

import java.util.ArrayList;

public class RectMovePiece {
    static final int LIMIT_OF_ARRAY = 8;
    private Piece piece;
    RectMovePiece(final Piece piece) {
        this.piece = piece;
    }
    /**Add all the possible moves on rect line**/
    void rect(final ArrayList<Position> arraypositions, final int column, final int row, final int rowIncrement, final int columnIncrement) {
        int c = column;
        int r = row;
        while ((r >= 0) && (c >= 0) && (r < LIMIT_OF_ARRAY) && (c < LIMIT_OF_ARRAY)) {
            if (isPosibleToContinue(piece.getChessBoard().getBoard()[c][r]) == -1) {
                arraypositions.add(piece.getChessBoard().getBoard()[c][r].getPosition());
                break;
            } else if (isPosibleToContinue(piece.getChessBoard().getBoard()[c][r]) == 0) {
                arraypositions.add(new Position(c, r));
                c += columnIncrement;
                r += rowIncrement;
            } else {
                break;
            }
        }
    }
    /**Control if is possible to continue**/
    public byte isPosibleToContinue(final Piece piece) {

        if (piece == null) {
            return 0;
        }
        if (piece.getColor() != piece.getColor()) {
            return -1;
        }
        return 1;
    }
}
