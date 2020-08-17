package chess;

public class GameConsole {
    private Player playerWhite;
    private Player playerBlack;
    private ChessBoard board;

    static final String LETTERS_ROW = "     a   b   c   d   e   f   g   h  \n";
    static final String HYPHENS_ROW = "  ---------------------------------\n";
    static final int LAST_INDEX = 7;
    static final int FIRST_INDEX = 0;
    static final String BLANK = " ";
    static final String BAR = "|";
    static final String END_LINE = "\n";

    public GameConsole() {
        this.board = new ChessBoard();
    }

    /**Method that starts the game**/
    public void start() {
        System.out.println("the game has started");
    }
    /**Method that finish the game**/
    public void over() {
        System.out.println("the game has over");
    }
    /**Method that resets the game**/
    public void reset() {
        System.out.println("Reset game");
    }
    /**Method that show the check**/
    public void showCheck() {
        System.out.println("Check");
    }
    /**Method that prints or draws the board**/
    public void drawChessBoard() {
        String container;
        container = LETTERS_ROW;
        container += HYPHENS_ROW;
        for (int irow = LAST_INDEX; irow >= FIRST_INDEX; irow--) {
            container += (irow + 1) + BLANK + BAR;
            for (int icol = FIRST_INDEX; icol <= LAST_INDEX; icol++) {
                if (this.board.getBoard()[icol][irow].getColor() == Color.BLACK) {
                    container += BLANK + this.board.getBoard()[icol][irow].toString() + BAR;
                } else {
                    container += this.board.getBoard()[icol][irow].toString() + BLANK + BAR;
                }
            }
            container += END_LINE;
            container += HYPHENS_ROW;
        }
        System.out.print(container);
    }

}
