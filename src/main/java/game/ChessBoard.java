package game;

import enums.Color;
import pieces.Piece;
import pieces.Bishop;
import pieces.Horse;
import pieces.King;
import pieces.Pawn;
import pieces.Queen;
import pieces.Rook;
import pieces.Position;

import java.util.List;

public class ChessBoard {
    private Piece[][] board;
    private boolean visualizationMode;
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
        board = new Piece[CHESSBOARD_SIZE][CHESSBOARD_SIZE];
        visualizationMode = GameConsole.VISUALIZATION_TEXT;
        createPieces();
    }

    public ChessBoard(final Piece piece) {
        board = new  Piece[CHESSBOARD_SIZE][CHESSBOARD_SIZE];
        board[piece.getPosition().getColumn()][piece.getPosition().getRow()] = piece;
    }

    public ChessBoard(final boolean visualizationMode) {
        board = new Piece[CHESSBOARD_SIZE][CHESSBOARD_SIZE];
        this.visualizationMode = visualizationMode;
        createPieces();
    }

    /**
     * Return type of visualization of the game
     */

    public boolean getVisualizationMode() {
        return this.visualizationMode;
    }

    /**create the cheassboard without piecese**/
    public void crateAnEmptyChessBoard() {
        board = new  Piece[CHESSBOARD_SIZE][CHESSBOARD_SIZE];
    }

    /**add a new piece to the board the purpose of test**/
    public void addPiece(final Piece piece) {
        board[piece.getPosition().getColumn()][piece.getPosition().getRow()] = piece;
    }

    /** move a Piece into ChessBoard and become null previous position**/
    public void movePiece(final Piece piece, final Position previousPosition) {
        board[piece.getPosition().getColumn()][piece.getPosition().getRow()] = piece;
        board[previousPosition.getColumn()][previousPosition.getRow()] = null;
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
        board[SOURCE_COL_LEFT_HORSES][SOURCE_ROW_BLACK_NOT_PAWNS] = new Horse(Color.BLACK, posBLHorse, this);
        board[SOURCE_COL_RIGHT_HORSES][SOURCE_ROW_BLACK_NOT_PAWNS] = new Horse(Color.BLACK, posBRHorse, this);
        board[SOURCE_COL_LEFT_HORSES][SOURCE_ROW_WHITE_NOT_PAWNS] = new Horse(Color.WHITE, posWLHorse, this);
        board[SOURCE_COL_RIGHT_HORSES][SOURCE_ROW_WHITE_NOT_PAWNS] = new Horse(Color.WHITE, posWRHorse, this);
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
        board[SOURCE_COL_KINGS][SOURCE_ROW_BLACK_NOT_PAWNS] = new King(Color.BLACK, posBKing, this);
        board[SOURCE_COL_KINGS][SOURCE_ROW_WHITE_NOT_PAWNS] = new King(Color.WHITE, posWKing, this);
    }

    /**
     *
     * @return if a Piece of Void space is under enemy attack or not
     *
     **/
    public boolean isUnderAttack(final int col, final int row, final Color color) {
        for (int irow = 0; irow < CHESSBOARD_SIZE; irow++) {
            for (int icol = 0; icol < CHESSBOARD_SIZE; icol++) {
                if (this.board[icol][irow] != null && this.board[icol][irow].getColor() != color) {
                    List<Position> arrayMoves;
                    arrayMoves = board[icol][irow].getPossibleMoves();
                    for (Position move : arrayMoves) {
                        if (move.getColumn() == col && move.getRow() == row) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
