package interfaces;

import pieces.Piece;

public interface IPawn {
    Piece promotion(byte type);

    void inPassant();
}
