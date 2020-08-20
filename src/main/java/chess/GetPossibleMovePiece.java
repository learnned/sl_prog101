package chess;

import java.util.ArrayList;

public class GetPossibleMovePiece {

    static final int LIMIT_OF_ARRAY = 8;
    private Piece piece;
    GetPossibleMovePiece(final Piece piece) {
        this.piece = piece;
    }
    /**Add all the possible moves on diagonal**/
    void possibleMovement(final ArrayList<Position> arrayPositions, final int column, final int row, final int rowIncrement, final int columnIncrement) {
        int column1 = column;
        int row1 = row;
        while ((row1 >= 0) && (column1 >= 0) && (row1 < LIMIT_OF_ARRAY) && (column1 < LIMIT_OF_ARRAY)) {
            if (isPossibleToContinue(piece.getChessBoard().getBoard()[column1][row1]) == -1) {
                arrayPositions.add(piece.getChessBoard().getBoard()[column1][row1].getPosition());
                break;
            } else if (isPossibleToContinue(piece.getChessBoard().getBoard()[column1][row1]) == 0) {
                arrayPositions.add(new Position(column1, row1));
                column1 += columnIncrement;
                row1 += rowIncrement;
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
