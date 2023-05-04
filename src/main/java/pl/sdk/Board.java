package pl.sdk;

import java.util.HashMap;
import java.util.Map;

public class Board {

    private final Map<Point, Piece> map;

    Board() {
        map = new HashMap<>();
    }

    void add(Point aPoint, Piece aPiece) {
        if (map.containsKey(aPoint)){
            throw new IllegalArgumentException("There is a piece in this field");
        }

        map.put(aPoint, aPiece);
    }

    Piece get(int aX, int aY) {
        return map.get(new Point(aX, aY));
    }
}
