package chess;
import java.util.ArrayList;

class Bishop extends Piece {

    static final int LIMIT_OF_SIDE = 5;
    static final int SIDE_ONE = 1;
    static final int SIDE_TWO = 2;
    static final int SIDE_THREE = 3;
    static final int SIDE_FOUR = 4;
    static final int LIMIT_OF_ARRAY = 8;

    Bishop(final Color color, final Position source) {
        super.setColor(color);
        super.setSymbol(Symbol.B);
        super.setStatus(Status.ALIVE);
        super.setPosition(source);
    }



    public ArrayList<Position> getPosibleMoves(final ChessBoard chb) {
        ArrayList<Position> arraypositions = new ArrayList<Position>();//change name
        int row, y, side = 1;
        Piece[][] board = chb.getBoard(); //Implement possible kill
        leftDownDiagonal(arraypositions,board);
        leftUpDiagonal(arraypositions,board);
        rightUpDiagonal(arraypositions,board);
        rightDownDiagonal(arraypositions,board);
        for (Position p: arraypositions) {
            System.out.print(p.getColumn()+"." + p.getRow() + " |");
        }

        return arraypositions;
    }
    void leftDownDiagonal(ArrayList<Position> arraypositions,final Piece[][] board){
       int row = this.getPosition().getRow() - 1 ;
       int y = this.getPosition().getColumn() - 1 ;
        while ((row >= 0) && (y >= 0)) {
                    if (isPosibleToContinue(board[y ][row ]) == -1) {
                        arraypositions.add(board[y ][row ].getPosition());

                    } else if (isPosibleToContinue(board[y ][row ]) == 0) {
                        arraypositions.add(new Position(y , row ));
                        y--;
                        row--;
            }
        }
    }
    void leftUpDiagonal(ArrayList<Position> arraypositions,final Piece[][] board){
        int row = this.getPosition().getRow() - 1;
        int y = this.getPosition().getColumn() + 1;
        while ((row >= 0) && (y < LIMIT_OF_ARRAY)) {
                if (isPosibleToContinue(board[y ][row]) == -1) {
                    arraypositions.add(board[y ][row].getPosition());
                } else if (isPosibleToContinue(board[y][row - SIDE_ONE]) == 0) {
                    arraypositions.add(new Position(y , row ));
                    y++;
                    row--;
                }
        }
    }
    void rightUpDiagonal (ArrayList<Position> arraypositions,final Piece[][] board){
        int row = this.getPosition().getRow() + 1;
        int y = this.getPosition().getColumn() + 1;
        while ((row < LIMIT_OF_ARRAY) && (y < LIMIT_OF_ARRAY)) {
            if (isPosibleToContinue(board[y][row]) == -1) {
                arraypositions.add(board[y][row].getPosition());

            } else if (isPosibleToContinue(board[y][row]) == 0) {
                arraypositions.add( new Position(y, row ));
                y++;
                row++;
            }
        }
    }

    void rightDownDiagonal(ArrayList<Position> arraypositions,final Piece[][] board){
        int row = this.getPosition().getRow() + 1;
        int y = this.getPosition().getColumn() - 1;
        while((row < LIMIT_OF_ARRAY) && (y >= 0)) {
            if (isPosibleToContinue(board[y][row]) == -1) {
                arraypositions.add(board[y][row].getPosition());

            } else if (isPosibleToContinue(board[y][row]) == 0) {
                arraypositions.add(new Position(y, row));
                y--;
                row++;
            }
        }
    }

    public byte isPosibleToContinue(Piece piece) {

        if (piece == null) {
            return 0;
        }
        if (piece.getColor() != this.getColor()) {
            return -1;
        }
        return 1;
    }

    public void checkmate() {
    }
}
