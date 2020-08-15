package chess;

interface IPawn {
    Piece promotion(byte type);

    void inPassant();
}
