package pieces;

public class Position {
    private int column;
    private int row;
    public Position(final int col, final int row) {
        this.column = col;
        this.row = row;
    }

    /**
     *
     * @return
     */
    public int getColumn() {
        return column;
    }

    /**
     *
     * @param column
     */
    public void setColumn(final int column) {
        this.column = column;
    }

    /**
     *
     * @return
     */
    public int getRow() {
        return row;
    }

    /**
     *
     * @param row
     */
    public void setRow(final int row) {
        this.row = row;
    }
}
