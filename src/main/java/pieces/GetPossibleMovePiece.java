package pieces;
import java.util.ArrayList;

public class GetPossibleMovePiece {

    static final int BOARD_SIZE = 8;
    static final int NUMBER_ONE = 1;
    static final int NUMBER_TWO = 2;
    private Piece piece;
    GetPossibleMovePiece(final Piece piece) {
        this.piece = piece;
    }
    /**Add all the possible moves on diagonal**/
    void possibleMovement(final ArrayList<Position> arrayPositions, final int column, final int row, final int rowIncrement, final int columnIncrement) {
        int column1 = column;
        int row1 = row;
        while ((row1 >= 0) && (column1 >= 0) && (row1 < BOARD_SIZE) && (column1 < BOARD_SIZE)) {
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
     * Add all movements of the Horse
     *
     * @param arrayPositions
     */
    public void possibleMovementHorse(final ArrayList<Position> arrayPositions, final int column, final int row) {
        int newColumn = column;
        int newRow = row;
        //int[] arrayMovementColumn = {2, 2, 1, -1, -2, -2, -1, 1};
        //int[] arrayMovementRow = {1, -1, 2, 2, 1, -1, -2, -2};
        int[] arrayMovementColumn = {NUMBER_TWO, NUMBER_TWO, NUMBER_ONE, -NUMBER_ONE, -NUMBER_TWO, -NUMBER_TWO, -NUMBER_ONE, NUMBER_ONE};
        int[] arrayMovementRow = {NUMBER_ONE, -NUMBER_ONE, NUMBER_TWO, NUMBER_TWO, NUMBER_ONE, -NUMBER_ONE, -NUMBER_TWO, -NUMBER_TWO};
        for (int i = 0; i < arrayMovementColumn.length; i++) {
            newColumn = column + arrayMovementColumn[i];
            newRow = row + arrayMovementRow[i];
            if (newColumn >= 0 && newColumn < BOARD_SIZE && newRow >= 0 && newRow < BOARD_SIZE) {
                if (isPossibleToContinue(piece.getChessBoard().getBoard()[newColumn][newRow]) == -1) {
                    arrayPositions.add(piece.getChessBoard().getBoard()[newColumn][newRow].getPosition());
                } else if (isPossibleToContinue(piece.getChessBoard().getBoard()[newColumn][newRow]) == 0) {
                    arrayPositions.add(new Position(newColumn, newRow));
                }
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
