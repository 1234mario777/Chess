package pl.sdk;

import java.util.HashMap;
import java.util.Map;

public class Board {

    private final Map<Point, Piece> map;
    public final static int WIDTH = 20;
    public final static int HEIGHT = 15;

    Board() {
        map = new HashMap<>();
    }

    void add(Point aPoint, Piece aPiece) {
        throwExceptionWhenFieldIsTakenOrIsOutsideMap(aPoint);
        map.put(aPoint, aPiece);
    }

    Piece get(int aX, int aY) {
        return map.get(new Point(aX, aY));
    }

    private void throwExceptionWhenFieldIsTakenOrIsOutsideMap(Point aPoint) {
        if (aPoint.getX() < 0 || aPoint.getX() > WIDTH || aPoint.getY() < 0 || aPoint.getY() > HEIGHT || map.containsKey(aPoint)){
          throw new IllegalArgumentException("You can not move on this field");
        }
    }


        void move(Point aSourcePoint, Point aTargetPoint) {
        throwExceptionWhenFieldIsTakenOrIsOutsideMap(aTargetPoint);
        Piece pieceToMove = map.get(aSourcePoint);
        map.remove(aSourcePoint);
        map.put(aTargetPoint, pieceToMove);
    }
}
