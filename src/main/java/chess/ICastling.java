package chess;
import java.util.ArrayList;

interface ICastling {
    void addCastling(ArrayList arrayList);

    void addQueensideCastling(ArrayList arrayList, int kingRow);

    void addKingsideCastling(ArrayList arrayList, int kingRow);
}
