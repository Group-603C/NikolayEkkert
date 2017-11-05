public class Point {

    private double x;
    private double y;
    private double z;

    Point(double x,
          double y) {

        this.x = x;
        this.y = y;
    }

    Point(double x,
          double y,
          double z) {

        this.x = x;
        this.y = y;
        this.z = z;
    }

    double getX() {
        return this.x;
    }

    double getY() {
        return this.y;
    }


    double getZ() {
        return this.z;
    }

    double distanceTo(Point point) {

        try {

            return Math.sqrt(Math.pow(point.x - this.x, 2) + Math.pow(point.y - this.y, 2) + Math.pow(point.z - this.z, 2));
        }
        catch (NullPointerException e) {

            return Math.sqrt(Math.pow(point.x - this.x, 2) + Math.pow(point.y - this.y, 2));
        }
    }
}