package ca.bcit.comp2522.labs.lab03;
/**
 * @author Brennen Chiu
 * @version 2020
 */
public class Quadrilateral {
    /**The first point of a shape.*/
    private Point a;
    /**The second point of a shape.*/
    private Point b;
    /**The third point of a shape.*/
    private Point c;
    /**The fourth point of a shape.*/
    private Point d;

    /**A constructor for different points of a shape.
     * @param x1 for 1st x-coordinate.
     * @param y1 for 1st y-coordinate.
     * @param x2 for 2nd x-coordinate.
     * @param y2 for 2nd y-coordinate.
     * @param x3 for 3rd x-coordinate.
     * @param y3 for 3rd y-coordinate.
     * @param x4 for 4th x-coordinate.
     * @param y4 for 4th y-coordinate.
     * */
    public Quadrilateral(final double x1, final double y1,
                         final double x2, final double y2,
                         final double x3, final double y3,
                         final double x4, final double y4) {
        a = new Point(x1, y1);
        b = new Point(x2, y2);
        c = new Point(x3, y3);
        d = new Point(x4, y4);
    }
    /**
     * Accessor for point A.
     * @return a
     * */
    public Point getA() {
        return a;
    }
    /**
     * Accessor for point B.
     * @return b
     * */
    public Point getB() {
        return b;
    }
    /**
     * Accessor for point C.
     * @return c
     * */
    public Point getC() {
        return c;
    }
    /**
     * Accessor for point D.
     * @return d
     * */
    public Point getD() {
        return d;
    }
    /**
     * A mutator for point A.
     * @param p1
     * */
    public void setA(final Point p1) {
        a = p1;
    }
    /**
     * A mutator for point B.
     * @param p2
     * */
    public void setB(final Point p2) {
        b = p2;
    }
    /**
     * A mutator for point C.
     * @param p3
     * */
    public void setC(final Point p3) {
        c = p3;
    }
    /**
     * A mutator for point D.
     * @param p4
     * */
    public void setD(final Point p4) {
        d = p4;
    }
    /**
     * @return String of a, b, c, and d
     * */
    public String toString() {
        return a + ", " + b + ", " + c + ", " + d;
    }
}
