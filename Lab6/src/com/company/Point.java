package com.company;

public class Point {

    Point(double x,
          double y) {}

    Point(double x,
          double y,
          double z) {}

    double getX() {

        return -1;
    }

    double getY() {

        return -1;
    }

    double getZ() {

        return -1;
    }

    double distanceTo(Point point) {

        return -1;
    }

    PolarPoint toPolar() {

        return new PolarPoint();
    }

    CylindricalPoint toCylindrical() {

        return new CylindricalPoint();
    }

    static public boolean isOneStraightLine(Point first,
                                            Point send,
                                            Point third) {

        return false;
    }

    static public boolean isOnePlane(Point first,
                                     Point send,
                                     Point third,
                                     Point fourth) {

        return false;
    }
}
