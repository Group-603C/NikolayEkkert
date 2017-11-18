package com.company;

public class Point {

    private double x;
    private double y;
    private double z;

    Point(double x,
          double y) {

        this.x = x;
        this.y = y;
        this.z = 0;
    }

    Point(double x,
          double y,
          double z) {

        this.x = x;
        this.y = y;
        this.z = z;
    }

    double getX() {

        return x;
    }

    double getY() {

        return y;
    }

    double getZ() {

        return z;
    }

    double distanceTo(Point point) {

        return Math.sqrt(Math.pow(x - point.getX(), 2.0) + Math.pow(y - point.getY(), 2.0) + Math.pow(z - point.getZ(), 2.0));
    }

    PolarPoint toPolar() {

        return new PolarPoint(Math.sqrt(Math.pow(x, 2.0) + Math.pow(y, 2.0)), convertToPhi());
    }

    CylindricalPoint toCylindrical() {

        return new CylindricalPoint(Math.sqrt(Math.pow(x, 2.0) + Math.pow(y, 2.0)), convertToPhi(), z);
    }

    static public boolean isOneStraightLine(Point first,
                                            Point second,
                                            Point third) {

        double x = (third.getX() - first.getX()) * (second.getY() - first.getY()) * (second.getZ() - first.getZ());
        double y = (third.getY() - first.getY()) * (second.getX() - first.getX()) * (second.getZ() - first.getZ());
        double z = (third.getZ() - first.getZ()) * (second.getY() - first.getY()) * (second.getX() - first.getX());

        return x == y && y == z;
    }

    static public boolean isOnePlane(Point first,
                                     Point send,
                                     Point third,
                                     Point fourth) {

        return false;
    }

    private double convertToPhi() {

        if (x < 0) {
            return (double) Math.atan2(y, x) + Math.PI;
        }

        else if (x > 0 && y < 0) {
            return (double) Math.atan2(y, x) + 2 * Math.PI;
        }

        else if (x > 0 && y >= 0) {
            return (double) Math.atan2(y, x);
        }

        else if (x == 0 && y > 0) {
            return (double) Math.PI / 2;
        }

        else if (x == 0 && y < 0) {
            return (double) 3 * Math.PI / 2;
        }

        return -1d;
    }
}