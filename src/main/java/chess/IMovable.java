package chess;
import java.util.List;

interface IMovable {
    boolean isPossibleMove(Position target,ChessBoard chess);
    List<Position> getPosibleMoves(ChessBoard ch);

    void checkmate();
}
