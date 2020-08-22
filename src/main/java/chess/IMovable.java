package chess;
import java.util.List;

interface IMovable {
    boolean isPossibleMove(Position target);

    List<Position> getPossibleMoves();

    void checkmate();
}
