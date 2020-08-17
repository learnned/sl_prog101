package chess;

public class ChessBoard {
    private Piece[][] board;
    static final int CHESSBOARD_SIZE = 8;
    static final int SOURCE_ROW_BLACK_PAWNS = 1;
    static final int SOURCE_ROW_WHITE_PAWNS = 6;
    static final int BEGINNING_OF_SOURCE_ROW_VOID = 2;
    static final int END_OF_SOURCE_ROW_VOID = 5;

    public ChessBoard() {
        board = new  Piece[CHESSBOARD_SIZE][CHESSBOARD_SIZE];
        createPieces();
    }

    /**Method that creates the pieces**/
    private void createPieces() {
        createVoids();
        createPawns();
    }

    private void createVoids() {
        for (int irow = BEGINNING_OF_SOURCE_ROW_VOID; irow <= END_OF_SOURCE_ROW_VOID; irow++) {
            for (int icol = 0; icol < CHESSBOARD_SIZE; icol++) {
                Position pos = new Position(icol, irow);
                board[icol][irow] = new Void(pos);
            }
        }
    }

    private void createPawns() {
        for (int icol = 0; icol < CHESSBOARD_SIZE; icol++) {
            Position posWhite = new Position(icol, SOURCE_ROW_BLACK_PAWNS);
            board[icol][SOURCE_ROW_BLACK_PAWNS] = new Pawn(Color.WHITE, posWhite);
            Position posBlack = new Position(icol, SOURCE_ROW_WHITE_PAWNS);
            board[icol][SOURCE_ROW_WHITE_PAWNS] = new Pawn(Color.BLACK, posBlack);
        }
    }

    private void createRooks() {
    }
}
