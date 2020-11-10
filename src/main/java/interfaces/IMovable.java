package interfaces;
import pieces.Position;

import java.util.List;

public interface IMovable {
    boolean isPossibleMove(Position target);

    List<Position> getPossibleMoves();

    void checkmate();
}
