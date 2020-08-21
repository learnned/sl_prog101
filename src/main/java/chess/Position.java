package chess;

class Position {
    private int column;
    private int row;
    Position(final int col, final int row) {
        this.column = col;
        this.row = row;
    }
    public int getColumn() {
        return column;
    }

    public void setColumn(final int column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(final int row) {
        this.row = row;
    }
}
