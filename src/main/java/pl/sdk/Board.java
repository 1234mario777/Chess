package pl.sdk;

import java.util.HashMap;
import java.util.Map;

public class Board {

    private final Map<Point, Piece> map;
    public final static int WIDTH = 8;
    public final static int HEIGHT = 8;

    Board() {
        map = new HashMap<>();
    }

    void add(Point aPoint, Piece aPiece) {
        if (map.containsKey(aPoint)){
            throw new IllegalArgumentException("There is a piece on this field");
        }
        throwExceptionWhenFieldIsOutsideMap(aPoint);
        map.put(aPoint, aPiece);
    }

    Piece get(int aX, int aY) {
        return map.get(new Point(aX, aY));
    }

    private void throwExceptionWhenFieldIsOutsideMap(Point aPoint) {
        if (aPoint.getX() < 0 || aPoint.getX() > WIDTH || aPoint.getY() < 0 || aPoint.getY() > HEIGHT){
          throw new IllegalArgumentException("You can not move on this field");
        }
    }

    void move(Point aSourcePoint, Point aTargetPoint) {
        throwExceptionWhenFieldIsOutsideMap(aTargetPoint);
        if (map.containsKey(aTargetPoint)) {
            map.remove(aTargetPoint, this);
        }
        Piece pieceToMove = map.get(aSourcePoint);
        map.remove(aSourcePoint);
        map.put(aTargetPoint, pieceToMove);
    }
}
