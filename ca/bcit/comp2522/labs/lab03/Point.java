package ca.bcit.comp2522.labs.lab03;

public class Point {
    /**X-Coordinate.*/
    private double x;
    /**Y-Coordinate.*/
    private double y;
    /**A constructor for different x and y coordinate.
     * @param x for x-coordinate.
     * @param y for y-coordinate.
     * */
    public Point(final double x, final double y) {
        this.x = x;
        this.y = y;
    }
    /**
     * Accessor for x.
     * @return x
     * */
    public double getX() {
        return x;
    }
    /**
     * Accessor for y.
     * @return y
     * */
    public double getY() {
        return y;
    }
    /**
     * Accessor for point x.
     * @return x
     * */
    public void setX(final double x) {
        this.x = x;
    }
    /**
     * Accessor for point y.
     * @return y
     * */
    public void setY(final double y) {
        this.y = y;
    }

    /**
     * @Override
     * */
    public String toString() {
        return "{x=" + x + ", y=" + y + '}';
    }
}
