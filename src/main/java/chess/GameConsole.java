package chess;

public class GameConsole {
    private Player playerWhite;
    private Player playerBlack;
    private ChessBoard board;

    public GameConsole() { }

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
        System.out.println("board printed");
    }

}
