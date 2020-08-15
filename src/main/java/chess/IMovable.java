package chess;
import java.util.ArrayList;

interface IMovable {
    Position move(Position target);

    boolean isPosibleMove(Position target);

    ArrayList<Position> getPosibleMoves();

    void checkmate();
}
