package pl.sdk;

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


}
