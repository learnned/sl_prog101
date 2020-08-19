package chess;

import java.util.ArrayList;
import java.util.List;

class Rook extends Piece implements ICastling {
    static final int LIMIT_OF_SIDE = 5;
    static final int SIDE_ONE = 1;
    static final int SIDE_TWO = 2;
    static final int SIDE_THREE = 3;
    static final int SIDE_FOUR = 4;
    static final int LIMIT_OF_ARRAY = 8;
    Rook(final Color color, final Position source) {
        super.setColor(color);
        super.setSymbol(Symbol.R);
        super.setStatus(Status.ALIVE);
        super.setPosition(source);
    }

    public ArrayList<Position> getPosibleMoves(final ChessBoard chb) {
        ArrayList<Position> array = new ArrayList<Position>();
        int x, y, side = 1;
        Piece[][] board = chb.getBoard();

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
        return array;

    }

    public void checkmate() {
    }

    public void castling() {
    }
}
