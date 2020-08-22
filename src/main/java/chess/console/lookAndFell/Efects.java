package chess.console.lookAndFell;

public class Efects {

    public static String yourTurn(String figure) {
        //return figure;
        return "\033[5m" + figure + "\033[1m";
    }
}
