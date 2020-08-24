package chess;

import game.GameConsole;
import java.util.Scanner;

class Main {

    private String aux;

    Main() {
        aux = "";
    }

    public static void main(final String[] args) {
        System.out.println("********************************");
        System.out.println("******Welcome Chess Game********");
        System.out.println("********************************");
        System.out.println("Please select a option for display the board");
        System.out.println("1.- Mode TEXT");
        System.out.println("2.- Mode ASCII");
        Scanner sc = new Scanner(System.in);
        int modeVisualization = sc.nextByte();
        System.out.println(modeVisualization);
        GameConsole console = new GameConsole( );
        console.init();
    }
}
