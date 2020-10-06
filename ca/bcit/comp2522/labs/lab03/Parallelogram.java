package ca.bcit.comp2522.labs.lab03;

import java.text.DecimalFormat;

public class Parallelogram extends Quadrilateral {

    private double width;
    private double height;

    public Parallelogram (final double x1, final double y1,
                          final double x2, final double y2,
                          final double x3, final double y3,
                          final double x4, final double y4) {
        super(x1, y1, x2, y2, x3, y3, x4, y4);

        width = Math.sqrt(Math.pow((getB().getX() - getA().getX()), 2)
        + Math.pow((getB().getY() - getA().getY()), 2));

        height = Math.sqrt(Math.pow((getD().getX() - getA().getX()), 2)
        + Math.pow((getD().getY() - getA().getY()), 2));
    }

    public double area() {
        return width * height;
    }

    /**
     * @Override
     * */
    public String toString() {
        DecimalFormat df = new DecimalFormat(".0");
        return "\nCoordinates of the Parallelogram are:\n"
                + super.toString()
                + "\nWidth is: " + df.format(width)
                + "\nHeight is: " + df.format(height)
                + "\nArea is: " + df.format(area());
    }
}
