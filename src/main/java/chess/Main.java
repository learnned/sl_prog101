class Main {

    private String aux;

    Main() {
        aux = "";
    }

    public static void main(final String[] args) {
        Position pos = new Position(0, 0);
        King k = new King(Color.BLACK, pos);
        Queen q = new Queen(Color.WHITE, pos);
        Pawn p = new Pawn(Color.WHITE, pos);
        Rook r = new Rook(Color.BLACK, pos);
        Bishop b = new Bishop(Color.BLACK, pos);
        Horse h = new Horse(Color.WHITE, pos);

        System.out.println(k.toString());
        System.out.println(q.toString());
        System.out.println(p.toString());
        System.out.println(r.toString());
        System.out.println(b.toString());
        System.out.println(h.toString());
    }
}
