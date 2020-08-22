package chess;

enum Symbol {
    P("P", "♙", "♟"),
    B("B", "♗", "♝"),
    R("R", "♖", "♜"),
    H("H", "♘", "♞"),
    Q("Q", "♕", "♛"),
    K("K", "♔", "♚");

    private String label;
    private String white;
    private String black;

    Symbol(final String label, final String white, final String black) {
        this.label = label;
        this.white = white;
        this.black = black;
    }

    public String getlabel() {
        return label;
    }

    public String getWhite() {
        return white;
    }

    public String getBlack() {
        return black;
    }
}
