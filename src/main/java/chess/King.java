package chess;

import java.util.ArrayList;

class King extends Piece implements ICastling, ICheck {
    static final int LEFT_BOTTOM_LIMIT = 0;
    static final int RIGHT_TOP_LIMIT = 7;
    static final int MAX_STEPS_PER_SIDE = 2;
    static final int TOTAL_SIDES = 4;
    static final int SIDE1 = 1;
    static final int SIDE2 = 2;
    static final int SIDE3 = 3;
    static final int A_COL = 0, B_COL = 1, C_COL = 2, D_COL = 3, E_COL = 4, F_COL = 5, G_COL = 6, H_COL = 7;

    King(final Color color, final Position source, final ChessBoard chessBoard) {
        super.setColor(color);
        super.setSymbol(Symbol.K);
        super.setStatus(Status.ALIVE);
        super.setPosition(source);
        super.setChessBoard(chessBoard);
    }

    public ArrayList<Position> getPossibleMoves() {
        ArrayList<Position> arrayPosition = new ArrayList<Position>();
        int col = this.getPosition().getColumn() + 1;
        int row = this.getPosition().getRow() + 1;
        Piece temp;
        int rowIncrement = -1;
        int colIncrement = 0;
        for (int sidesChecked = 0; sidesChecked < TOTAL_SIDES; sidesChecked++) {
            switch (sidesChecked) {
                case SIDE1:
                    rowIncrement = 0;
                    colIncrement = -1;
                    break;
                case SIDE2:
                    rowIncrement = 1;
                    colIncrement = 0;
                    break;
                case SIDE3:
                    rowIncrement = 0;
                    colIncrement = 1;
                    break;
                default:
                    break;
            }
            for (int step = 1; step <= MAX_STEPS_PER_SIDE; step++) {
                col += colIncrement;
                row += rowIncrement;
                if (col >= LEFT_BOTTOM_LIMIT && row >= LEFT_BOTTOM_LIMIT && col <= RIGHT_TOP_LIMIT && row <= RIGHT_TOP_LIMIT) {
                    temp = this.getChessBoard().getBoard()[col][row];
                    if (!this.getChessBoard().isUnderAtack(col, row, this.getColor())) {
                        if (temp == null) {
                            arrayPosition.add(new Position(col, row));
                        } else if (this.getColor() != temp.getColor()) {
                            arrayPosition.add(temp.getPosition());
                        }
                    }
                }
            }
        }
        if (getFirstMovement() && !isChecked()) {
            castling(arrayPosition);
        }
        /*for (Position pos : arrayPosition) {
            System.out.print("[" + pos.getColumn() + "," + pos.getRow() + "]");
        }
        System.out.println();*/
        return arrayPosition;
    }

    public void checkmate() {
    }

    public void castling(final ArrayList arrayPosition) {
        int kingRow = this.getPosition().getRow();
        if (!getChessBoard().isUnderAtack(E_COL, kingRow, this.getColor())) {
            if (getChessBoard().getBoard()[A_COL][kingRow] instanceof Rook && getChessBoard().getBoard()[A_COL][kingRow].getFirstMovement()
                    && getChessBoard().getBoard()[B_COL][kingRow] == null && getChessBoard().getBoard()[C_COL][kingRow] == null
                    && getChessBoard().getBoard()[D_COL][kingRow] == null) {
                if (!getChessBoard().isUnderAtack(C_COL, kingRow, this.getColor()) && !getChessBoard().isUnderAtack(D_COL, kingRow, this.getColor())) {
                    arrayPosition.add(new Position(C_COL, kingRow));
                }
            }
            if (getChessBoard().getBoard()[H_COL][kingRow] instanceof Rook && getChessBoard().getBoard()[H_COL][kingRow].getFirstMovement()
                    && getChessBoard().getBoard()[G_COL][kingRow] == null && getChessBoard().getBoard()[F_COL][kingRow] == null) {
                if (!getChessBoard().isUnderAtack(G_COL, kingRow, this.getColor()) && !getChessBoard().isUnderAtack(F_COL, kingRow, this.getColor())) {
                    arrayPosition.add(new Position(G_COL, kingRow));
                }
            }
        }
    }

    public boolean isChecked() {
        if (getChessBoard().isUnderAtack(this.getPosition().getColumn(), this.getPosition().getRow(), this.getColor())) {
            return true;
        }
        return false;
    }
}
