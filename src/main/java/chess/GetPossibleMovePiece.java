package chess;

import java.util.ArrayList;

public class GetPossibleMovePiece {

    static final int LIMIT_OF_ARRAY = 8;
    private Piece piece;
    GetPossibleMovePiece(final Piece piece) {
        this.piece = piece;
    }
    /**Add all the possible moves on diagonal**/
    void diagonal(final ArrayList<Position> arraypositions, final int column, final int row, final int rowIncrement, final int columnIncrement) {
        int c = column;
        int r = row;
        while ((r >= 0) && (c >= 0) && (r < LIMIT_OF_ARRAY) && (c < LIMIT_OF_ARRAY)) {
            if (isPossibleToContinue(piece.getChessBoard().getBoard()[c][r]) == -1) {
                arraypositions.add(piece.getChessBoard().getBoard()[c][r].getPosition());
                break;
            } else if (isPossibleToContinue(piece.getChessBoard().getBoard()[c][r]) == 0) {
                arraypositions.add(new Position(c, r));
                c += columnIncrement;
                r += rowIncrement;
            } else {
                break;
            }
        }
    }

    /**
     * Compares the state of the target piece target against with the target piece
     * @param targetPiece the target piece
     * @return Byte     0,-1 When possible movement, 1 Otherwise.
     */
    public byte isPossibleToContinue(final Piece targetPiece) {

        if (targetPiece == null) {
            return 0;
        }
        if (this.piece.getColor() != targetPiece.getColor()) {
            return -1;
        }
        return 1;
    }
}
