package chess;

public class ChessBoard {
    private Piece[][] board;
    static final int CHESSBOARD_SIZE = 8;
    static final int SOURCE_ROW_BLACK_PAWNS = 6;
    static final int SOURCE_ROW_WHITE_PAWNS = 1;
    static final int SOURCE_ROW_BLACK_NOT_PAWNS = 7;
    static final int SOURCE_ROW_WHITE_NOT_PAWNS = 0;
    static final int SOURCE_COL_LEFT_ROOKS = 0;
    static final int SOURCE_COL_RIGHT_ROOKS = 7;
    static final int SOURCE_COL_LEFT_HORSES = 1;
    static final int SOURCE_COL_RIGHT_HORSES = 6;
    static final int SOURCE_COL_LEFT_BISHOPS = 2;
    static final int SOURCE_COL_RIGHT_BISHOPS = 5;
    static final int SOURCE_COL_QUEENS = 3;
    static final int SOURCE_COL_KINGS = 4;

    public ChessBoard() {
        board = new  Piece[CHESSBOARD_SIZE][CHESSBOARD_SIZE];
        createPieces();
    }
    public ChessBoard(final Piece piece) {
        board = new  Piece[CHESSBOARD_SIZE][CHESSBOARD_SIZE];
        board[piece.getPosition().getColumn()][piece.getPosition().getRow()] = piece;
    }
    /**create the cheassboard without piecese**/
    public void crateAnEmptyChessBoard() {
        board = new  Piece[CHESSBOARD_SIZE][CHESSBOARD_SIZE];
    }

    /**add a new piece to the board the purpose of test**/
    public void addPiece(final Piece piece) {
        board[piece.getPosition().getColumn()][piece.getPosition().getRow()] = piece;
    }

    /**
     *
     * @return board of ChessBoard
     *
     * **/
    public Piece[][] getBoard() {
        return this.board;
    }

    /**method to move a piece**/
   /* public void move2(final Position p, final Piece piece) {
        board[p.getColumn()][p.getRow()] = piece;
    }*/

    /**Method that creates the pieces**/
    public void createPieces() {
        createPawns();
        createRooks();
        createHorses();
        createBishops();
        createQueens();
        createKings();
    }

    private void createPawns() {
        for (int icol = 0; icol < CHESSBOARD_SIZE; icol++) {
            Position posWhite = new Position(icol, SOURCE_ROW_BLACK_PAWNS);
            board[icol][SOURCE_ROW_BLACK_PAWNS] = new Pawn(Color.BLACK, posWhite);
            Position posBlack = new Position(icol, SOURCE_ROW_WHITE_PAWNS);
            board[icol][SOURCE_ROW_WHITE_PAWNS] = new Pawn(Color.WHITE, posBlack);
        }
    }

    private void createRooks() {
        Position posBLRook = new Position(SOURCE_COL_LEFT_ROOKS, SOURCE_ROW_BLACK_NOT_PAWNS);
        Position posBRRook = new Position(SOURCE_COL_RIGHT_ROOKS, SOURCE_ROW_BLACK_NOT_PAWNS);
        Position posWLRook = new Position(SOURCE_COL_LEFT_ROOKS, SOURCE_ROW_WHITE_NOT_PAWNS);
        Position posWRRook = new Position(SOURCE_COL_RIGHT_ROOKS, SOURCE_ROW_WHITE_NOT_PAWNS);
        board[SOURCE_COL_LEFT_ROOKS][SOURCE_ROW_BLACK_NOT_PAWNS] = new Rook(Color.BLACK, posBLRook, this);
        board[SOURCE_COL_RIGHT_ROOKS][SOURCE_ROW_BLACK_NOT_PAWNS] = new Rook(Color.BLACK, posBRRook, this);
        board[SOURCE_COL_LEFT_ROOKS][SOURCE_ROW_WHITE_NOT_PAWNS] = new Rook(Color.WHITE, posWLRook, this);
        board[SOURCE_COL_RIGHT_ROOKS][SOURCE_ROW_WHITE_NOT_PAWNS] = new Rook(Color.WHITE, posWRRook, this);
    }

    private void createHorses() {
        Position posBLHorse = new Position(SOURCE_COL_LEFT_HORSES, SOURCE_ROW_BLACK_NOT_PAWNS);
        Position posBRHorse = new Position(SOURCE_COL_RIGHT_HORSES, SOURCE_ROW_BLACK_NOT_PAWNS);
        Position posWLHorse = new Position(SOURCE_COL_LEFT_HORSES, SOURCE_ROW_WHITE_NOT_PAWNS);
        Position posWRHorse = new Position(SOURCE_COL_RIGHT_HORSES, SOURCE_ROW_WHITE_NOT_PAWNS);
        board[SOURCE_COL_LEFT_HORSES][SOURCE_ROW_BLACK_NOT_PAWNS] = new Horse(Color.BLACK, posBLHorse);
        board[SOURCE_COL_RIGHT_HORSES][SOURCE_ROW_BLACK_NOT_PAWNS] = new Horse(Color.BLACK, posBRHorse);
        board[SOURCE_COL_LEFT_HORSES][SOURCE_ROW_WHITE_NOT_PAWNS] = new Horse(Color.WHITE, posWLHorse);
        board[SOURCE_COL_RIGHT_HORSES][SOURCE_ROW_WHITE_NOT_PAWNS] = new Horse(Color.WHITE, posWRHorse);
    }

    private void createBishops() {
        Position posBLBishop = new Position(SOURCE_COL_LEFT_BISHOPS, SOURCE_ROW_BLACK_NOT_PAWNS);
        Position posBRBishop = new Position(SOURCE_COL_RIGHT_BISHOPS, SOURCE_ROW_BLACK_NOT_PAWNS);
        Position posWLBishop = new Position(SOURCE_COL_LEFT_BISHOPS, SOURCE_ROW_WHITE_NOT_PAWNS);
        Position posWRBishop = new Position(SOURCE_COL_RIGHT_BISHOPS, SOURCE_ROW_WHITE_NOT_PAWNS);
        board[SOURCE_COL_LEFT_BISHOPS][SOURCE_ROW_BLACK_NOT_PAWNS] = new Bishop(Color.BLACK, posBLBishop, this);
        board[SOURCE_COL_RIGHT_BISHOPS][SOURCE_ROW_BLACK_NOT_PAWNS] = new Bishop(Color.BLACK, posBRBishop, this);
        board[SOURCE_COL_LEFT_BISHOPS][SOURCE_ROW_WHITE_NOT_PAWNS] = new Bishop(Color.WHITE, posWLBishop, this);
        board[SOURCE_COL_RIGHT_BISHOPS][SOURCE_ROW_WHITE_NOT_PAWNS] = new Bishop(Color.WHITE, posWRBishop, this);
    }

    private void createQueens() {
        Position posBQueen = new Position(SOURCE_COL_QUEENS, SOURCE_ROW_BLACK_NOT_PAWNS);
        Position posWQueen = new Position(SOURCE_COL_QUEENS, SOURCE_ROW_WHITE_NOT_PAWNS);
        board[SOURCE_COL_QUEENS][SOURCE_ROW_BLACK_NOT_PAWNS] = new Queen(Color.BLACK, posBQueen, this);
        board[SOURCE_COL_QUEENS][SOURCE_ROW_WHITE_NOT_PAWNS] = new Queen(Color.WHITE, posWQueen, this);
    }

    private void createKings() {
        Position posBKing = new Position(SOURCE_COL_KINGS, SOURCE_ROW_BLACK_NOT_PAWNS);
        Position posWKing = new Position(SOURCE_COL_KINGS, SOURCE_ROW_WHITE_NOT_PAWNS);
        board[SOURCE_COL_KINGS][SOURCE_ROW_BLACK_NOT_PAWNS] = new King(Color.BLACK, posBKing);
        board[SOURCE_COL_KINGS][SOURCE_ROW_WHITE_NOT_PAWNS] = new King(Color.WHITE, posWKing);
    }
}
