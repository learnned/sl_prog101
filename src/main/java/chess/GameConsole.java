package chess;

public class GameConsole {
    private Player playerWhite;
    private Player playerBlack;
    private ChessBoard board;
    private boolean visualizationMode;

    static final String LETTERS_ROW = "   |  A   |  B   |  C   |  D   |  E   |  F   |  G   |  H   |  \n";
    static final String HYPHENS_ROW = "   +------+------+------+------+------+------+------+------+\n";
    static final int LAST_INDEX = 7;
    static final int FIRST_INDEX = 0;
    static final String BLANK = " ";
    static final String FOUR_BLANKS = "    ";
    static final String BAR = " | ";
    static final String END_LINE = "\n";
    static final boolean VISUALIZATION_TEXT = false;
    public static final boolean VISUALIZATION_ASCII = true;
    //Colors
    static final String COLOR_RESET = "\033[0m";
    // Regular Colors
    static final String COLOR_BLACK = "\033[0;30m";
    static final String COLOR_RED = "\033[0;31m";
    static final String COLOR_GREEN = "\033[0;32m";
    static final String COLOR_WHITE = "\033[0;37m";
    // Background
    public static final String COLOR_GREEN_BACKGROUND = "\033[42m";
    // High Intensity
    public static final String COLOR_WHITE_BRIGHT = "\033[0;97m";


    public GameConsole() {
        visualizationMode = VISUALIZATION_TEXT;
        this.board = new ChessBoard();
    }

    public GameConsole(final boolean visualizationMode) {
        if (visualizationMode == VISUALIZATION_ASCII) {
            this.visualizationMode = VISUALIZATION_ASCII;
        } else {
            this.visualizationMode = VISUALIZATION_TEXT;
        }
        board = new ChessBoard(this.visualizationMode);
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
        container =  addColorSymbols(HYPHENS_ROW);
        container += addColorSymbols(LETTERS_ROW);
        container += addColorSymbols(HYPHENS_ROW);
        for (int irow = LAST_INDEX; irow >= FIRST_INDEX; irow--) {
            container = container + addColorSymbols((irow + 1) + "") + addColorSymbols(BLANK + BAR);
            for (int icol = FIRST_INDEX; icol <= LAST_INDEX; icol++) {
                    if (board.getBoard()[icol][irow] == null) {
                        container = container + addColorBlack(FOUR_BLANKS);
                    } else {
                        String element = board.getBoard()[icol][irow].toString();
                        if (element.length() == 1) {
                            container = container + BLANK;
                        }
                        if ((icol + irow) % 2 == 0) {
                            container = container + addColorBlack(BLANK + element + BLANK);
                        } else {
                            container = container + addColorWhite(BLANK + element + BLANK);
                        }
                    }
                container = container + addColorSymbols(BAR);
            }
            container += addColorSymbols(END_LINE);
            container += addColorSymbols(HYPHENS_ROW);
        }
        container += addColorSymbols(LETTERS_ROW);
        container += addColorSymbols(HYPHENS_ROW);
        System.out.print(container);
    }

    /**
     * Return color for GUI
     * @param symbol
     * @return String whit the color
     */
    private String addColorSymbols(final String symbol) {
        return COLOR_GREEN + symbol + COLOR_RESET;
    }

    /**
     * Return color for GUI
     * @param symbol
     * @return String whit the color
     */
    private String addColorWhite(final String symbol) {
        return COLOR_WHITE_BRIGHT + COLOR_WHITE +  symbol + COLOR_RESET;
    }

    /**
     * Return color for GUI
     * @param symbol
     * @return String whit the color
     */
    private String addColorBlack(final String symbol) {
        return COLOR_BLACK + COLOR_GREEN_BACKGROUND + symbol + COLOR_RESET;
    }
}
