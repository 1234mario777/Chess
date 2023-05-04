package pl.sdk;

import java.util.Objects;

public class Point {

private int x;
private int y;

    Point(int aX, int aY) {
        x = aX;
        y = aY;
    }

    int getX() {
        return x;
    }

    void setX(int aX) {
        x = aX;
    }

    int getY() {
        return y;
    }

    void setY(int aY) {
        y = aY;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object aO) {
        if (this == aO) return true;
        if (aO == null || getClass() != aO.getClass()) return false;
        Point point = (Point) aO;
        return x == point.x &&
                y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
