package interfaces;
import pieces.Position;
import java.util.ArrayList;
import pieces.Piece;

public interface IPawn {
    Piece promotion(byte type);

    void inPassant(ArrayList<Position>  arrayPositions, int column, int row, int increment);
}
