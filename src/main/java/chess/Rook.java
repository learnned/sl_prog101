package chess;

import java.util.ArrayList;
class Rook extends Piece implements ICastling {
    static final int LIMIT_OF_ARRAY = 8;
    Rook(final Color color, final Position source) {
        super.setColor(color);
        super.setSymbol(Symbol.R);
        super.setStatus(Status.ALIVE);
        super.setPosition(source);
    }

    public ArrayList<Position> getPosibleMoves(final ChessBoard chb) {
        ArrayList<Position> arraypositions = new ArrayList<Position>();
        Piece[][] board = chb.getBoard(); //Implement possible kill
        up(arraypositions, board);
        /*left(arraypositions, board);
        right(arraypositions, board);
        down(arraypositions, board);*/
        for (Position p: arraypositions) {
            System.out.print(p.getColumn() + "." + p.getRow() + " |");
        }

        return arraypositions;
    }
    void up(final ArrayList<Position> arraypositions, final Piece[][] board) {
        int row = this.getPosition().getRow();
        int column = this.getPosition().getColumn();
        while ((column < LIMIT_OF_ARRAY) && (column >= 0)) {
            if (isPosibleToContinue(board[column][row]) == -1) {
                arraypositions.add(board[column][row].getPosition());
                break;
            } else if (isPosibleToContinue(board[column][row]) == 0) {
                arraypositions.add(new Position(column, row));
                column++;
            } else {
                break;
            }
        }
    }
   /* void left(final ArrayList<Position> arraypositions, final Piece[][] board) {
        int row = this.getPosition().getRow() - 1;
        int column = this.getPosition().getColumn();
        while ((row >= 0) && (column < LIMIT_OF_ARRAY)) {
            if (isPosibleToContinue(board[column][row]) == -1) {
                arraypositions.add(board[column][row].getPosition());
                break;
            } else if (isPosibleToContinue(board[column][row]) == 0) {
                arraypositions.add(new Position(column, row));
                row--;
            } else {
                break;
            }
        }
    }
    void right(final ArrayList<Position> arraypositions, final Piece[][] board) {
        int row = this.getPosition().getRow() + 1;
        int column = this.getPosition().getColumn();
        while ((row < LIMIT_OF_ARRAY) && (column < LIMIT_OF_ARRAY)) {
            if (isPosibleToContinue(board[column][row]) == -1) {
                arraypositions.add(board[column][row].getPosition());
                break;
            } else if (isPosibleToContinue(board[column][row]) == 0) {
                arraypositions.add(new Position(column, row));
                row++;
            } else {
                break;
            }
        }
    }

    void down(final ArrayList<Position> arraypositions, final Piece[][] board) {
        int row = this.getPosition().getRow();
        int column = this.getPosition().getColumn() - 1;
        while ((row < LIMIT_OF_ARRAY) && (column >= 0)) {
            if (isPosibleToContinue(board[column][row]) == -1) {
                arraypositions.add(board[column][row].getPosition());
                break;
            } else if (isPosibleToContinue(board[column][row]) == 0) {
                arraypositions.add(new Position(column, row));
                column--;
            } else {
                break;
            }
        }
    }
*/
    public byte isPosibleToContinue(final Piece piece) {

        if (piece == null) {
            return 0;
        }
        if (piece.getColor() != this.getColor()) {
            return -1;
        }
        return 1;
    }


      /*  while (side != LIMIT_OF_SIDE) {
            x = 0;
            y = 2;*/
            /** down **/
            /*if (side == SIDE_ONE) {
                if (y > 0) {
                    if ((isPosibleMove(board[y - SIDE_ONE][x]))) {
                        array.add(board[y][x]);
                    } else {
                        side++;
                    }
                } else {
                    side++;
                }
            }*/
            /**Right**/
          /*  if (side == SIDE_TWO) {
                if (x < LIMIT_OF_ARRAY) {
                    if (isPosibleMove(board[y][x + 1])) {
                        array.add(board[y][x]);
                    } else {
                        side++;
                    }
                } else {
                    side++;
                }
            }*/
            /**Left**/
         /*   if (side == SIDE_THREE) {
                if (x > 0) {
                    if (isPosibleMove(board[y][x - 1])) {
                        array.add(board[y][x]);
                    } else {
                        side++;
                    }
                } else {
                    side++;
                }
            }*/
            /**Up**/
          /*  if (side == SIDE_FOUR) {
                if (y < LIMIT_OF_ARRAY) {
                    if (isPosibleMove(board[y + SIDE_ONE][x])) {
                        array.add(board[y][x]);
                    } else {
                        side++;
                    }
                } else {
                    side++;
                }
            }

        }*/



    public void checkmate() {
    }

    public void castling() {
    }
}
