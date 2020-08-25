package interfaces;
import pieces.Position;

import java.util.ArrayList;

public interface IMovable {
    boolean isPossibleMove(Position target);

    ArrayList<Position> getPossibleMoves();

    void checkmate();
}
