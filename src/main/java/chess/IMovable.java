package chess;
import java.util.List;

interface IMovable {
    void move(Piece target);

    boolean isPosibleMove(Piece target);

    List<Piece> getPosibleMoves(ChessBoard ch);

    void checkmate();
}
