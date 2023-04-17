package pl.sdk;

import static java.lang.StrictMath.pow;
import static java.lang.StrictMath.sqrt;

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

    double getDistanceToCenter() {
        double dist;

        dist = sqrt(pow(0 + x, 2) + (pow(0 + y, 2)));

        return dist;
    }

}
