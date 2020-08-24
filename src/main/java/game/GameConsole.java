package game;

import enums.Color;
import pieces.Position;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class GameConsole {
    private Player playerWhite;
    private Player playerBlack;
    private ChessBoard board;
    private boolean visualizationMode;
    private Scanner sc;

    static final String LETTERS_ROW = "   |  A   |  B   |  C   |  D   |  E   |  F   |  G   |  H   |  \n";
    static final String HYPHENS_ROW = "   +------+------+------+------+------+------+------+------+\n";
    static final int LAST_INDEX = 7;
    static final int FIRST_INDEX = 0;
    static final String BLANK = " ";
    static final String FOUR_BLANKS = "....";
    static final String BAR = " | ";
    static final String END_LINE = "\n";
    static final boolean VISUALIZATION_TEXT = false;
    public static final boolean VISUALIZATION_ASCII = true;
    //Colors
    static final String COLOR_RESET = "\033[0m";
    // Regular Colors
    static final String COLOR_BLACK = "\033[30m";
    static final String COLOR_RED = "\033[31m";
    static final String COLOR_GREEN = "\033[32m";
    static final String COLOR_WHITE = "\033[37m";
    // Background
    public static final String COLOR_GREEN_BACKGROUND = "\033[42m";
    public static final String COLOR_BLACK_BACKGROUND = "\u001b[40m";
    // High Intensity
    public static final String COLOR_WHITE_BRIGHT = "\033[97m";

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
                        if (board.getBoard()[icol][irow].getColor().equals(Color.BLACK)) {
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

    /**Method that prints or draws the board**/
    public void drawChessBoardSpecificElement(final int col, final int row) {
        String container;
        container =  addColorSymbols(HYPHENS_ROW);
        container += addColorSymbols(LETTERS_ROW);
        container += addColorSymbols(HYPHENS_ROW);
        for (int irow = LAST_INDEX; irow >= FIRST_INDEX; irow--) {
            container = container + addColorSymbols((irow + 1) + "") + addColorSymbols(BLANK + BAR);
            for (int icol = FIRST_INDEX; icol <= LAST_INDEX; icol++) {
                String tmpContainer = "";
                if (board.getBoard()[icol][irow] == null) {
                    tmpContainer = addColorBlack(FOUR_BLANKS);
                } else {
                    String element = board.getBoard()[icol][irow].toString();
                    if (element.length() == 1) {
                        tmpContainer = BLANK;
                    }
                    if (board.getBoard()[icol][irow].getColor().equals(Color.BLACK)) {
                        tmpContainer += COLOR_BLACK_BACKGROUND + addColorBlack(BLANK + element + BLANK);
                    } else {
                        tmpContainer += addColorWhite(BLANK + element + BLANK);
                    }
                }
                if (row == irow && col == icol){
                    tmpContainer = blink(tmpContainer);
                }
                container = container + tmpContainer + addColorSymbols(BAR);
            }
            container += addColorSymbols(END_LINE);
            container += addColorSymbols(HYPHENS_ROW);
        }
        container += addColorSymbols(LETTERS_ROW);
        container += addColorSymbols(HYPHENS_ROW);
        System.out.print(COLOR_BLACK_BACKGROUND + container);
    }

    /**Method that prints or draws the board**/
    public void drawChessBoardSpecificElement(final Map<Integer, Integer> mapPositions, final int sourceCol, final int sourceRow) {
        String container;
        container =  addColorSymbols(HYPHENS_ROW);
        container += addColorSymbols(LETTERS_ROW);
        container += addColorSymbols(HYPHENS_ROW);
        for (int irow = LAST_INDEX; irow >= FIRST_INDEX; irow--) {
            container = container + addColorSymbols((irow + 1) + "") + addColorSymbols(BLANK + BAR);
            for (int icol = FIRST_INDEX; icol <= LAST_INDEX; icol++) {
                String tmpContainer = "";
                if (board.getBoard()[icol][irow] == null) {
                    tmpContainer = FOUR_BLANKS;
                } else {
                    String element = board.getBoard()[icol][irow].toString();
                    if (element.length() == 1) {
                        tmpContainer = BLANK;
                    }
                    if (board.getBoard()[icol][irow].getColor().equals(Color.BLACK)) {
                        tmpContainer += addColorBlack(BLANK + element + BLANK);
                    } else {
                        tmpContainer += addColorWhite(BLANK + element + BLANK);
                    }
                }
                if (mapPositions.containsKey(icol) && mapPositions.get(icol) == irow || sourceCol == icol && sourceRow == irow) {
                    tmpContainer = blink(tmpContainer);
                }
                container = container + tmpContainer + addColorSymbols(BAR);
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
        return COLOR_GREEN_BACKGROUND + COLOR_BLACK + symbol + COLOR_RESET;
    }


    private String blink (final String element) {
        return "\033[5m" + element + "\033[0m";
    }

    public void clearDisplay(){
        System.out.println("\033[2J\033[1;1H");
    }

    public void legendDisplay(final String text){
        System.out.println(COLOR_GREEN + text);
    }

    public void welcome(){
        legendDisplay("********************************");
        legendDisplay("******Welcome Chess Game********");
        legendDisplay("********************************");
    }

    public void init() {
        sc = new Scanner(System.in);
        welcome();
        legendDisplay("First Player Name: ");

        String nameA  = sc.nextLine();
        clearDisplay();

        welcome();
        legendDisplay("Second Player Name: ");
        String nameB  = sc.nextLine();
        clearDisplay();

        welcome();
        drawChessBoard();
        playerBlack = new Player(Color.BLACK, false, nameA);
        playerWhite = new Player(Color.WHITE, true, nameB);
        boolean turn = true;

        while(true){
            if (turn) {
                legendDisplay(blink("Player 1 " + nameA + " is your turn"));
            } else {
                legendDisplay(blink("Player 2 " + nameA + " is your turn"));
            }
            turn = !turn;
            menu(turn);
        }
    }

    public void menu(final boolean turnPlayer) {
        System.out.println("1.- Select Piece");
        System.out.println("2.- View All movements");
        System.out.println("3.- Move Piece");
        int option = sc .nextInt();
        int row = 0;
        int col = 0;
        int[] userInput;
        switch (option) {
            case OPTION_ONE:
                userInput = userSelectPiece();
                //drawChessBoardSpecificElement(userInput[0], userInput[1]);
                clearDisplay();
                drawChessBoardSpecificElement(getPosibleMove(userInput[0], userInput[1]), userInput[0], userInput[1]);
                break;
            case 2:
                System.out.println("Coming soon");
                break;
            case 3:
                System.out.println("Coming soon");
                break;
            case 4:
                drawChessBoard();
                break;
            default:
                System.out.println("UPS");
        }
    }
     /**
     * userSelectPiece
     */
    public int[] userSelectPiece() {
        String cad = sc.next().toUpperCase();
        return convertInputUserToProgram(cad.charAt(0), String.valueOf(cad.charAt(1)));
    }
    /**
     * Convert input A7 to 0,6
     *  @param column, row
     */
    public int[] convertInputUserToProgram(final char column, final String row) {
        int[] position = {column - 'A', Integer.parseInt(row) - 1 };
        return position;
    }
    /**
     * Obtain a map whit all possible positions
     *  @param col, row
     */
    public Map<Integer, Integer> getPosibleMove(final int col, final int row) {
        List<Position> arrayMoves = board.getBoard()[col][row].getPossibleMoves();
        Map<Integer, Integer> mapPositions = new HashMap<Integer, Integer>();
        for (Position move : arrayMoves) {
            System.out.println("Debug  = " + move.getColumn() + " " + move.getRow() + " | " + (char) ('A' + move.getColumn()) + "   " + (move.getRow() + 1)); //debug
            mapPositions.put(move.getColumn(), move.getRow());
        }
        return mapPositions;
    }
}
