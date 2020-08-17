package chess;
import java.util.ArrayList;

interface IMovable {
    Position move(Piece target);

    boolean isPosibleMove(Piece target);

    ArrayList<Position> getPosibleMoves();

    void checkmate();
}
