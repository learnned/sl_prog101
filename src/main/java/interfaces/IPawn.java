package interfaces;
import pieces.Position;
import java.util.ArrayList;
import pieces.Piece;

public interface IPawn {
    Piece promotion(byte type);

    abstract void inPassant(ArrayList<Position>  arrayPositions, final int column, final int row, final int increment);
}
