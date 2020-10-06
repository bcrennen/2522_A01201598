package ca.bcit.comp2522.labs.lab03;

import java.text.DecimalFormat;

public class Trapezoid extends Quadrilateral {
    private double base1;
    private double base2;
    private double height;
    public Trapezoid (final double x1, final double y1,
                      final double x2, final double y2,
                      final double x3, final double y3,
                      final double x4, final double y4) {
        super(x1, y1, x2, y2, x3, y3, x4, y4);

        height = Math.abs(x1 - x2);
        base1 = y2 - y3;
        base2 = y1 - y4;
    }
    public double area() {
        return Math.abs(0.5 * (base1 + base2) * height);
    }
    /**
     * @Override
     * */
    public String toString() {
        DecimalFormat df = new DecimalFormat(".0");
        return "\nCoordinates of the Trapezoid are:\n"
                + super.toString()
                + "\nBase1 is: " + df.format(base1)
                + "\nBase2 is: " + df.format(base2)
                + "\nHeight is: " + df.format(height)
                + "\nArea is: " + df.format(area());
    }
}
