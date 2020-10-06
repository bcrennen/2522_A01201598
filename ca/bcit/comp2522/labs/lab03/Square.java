package ca.bcit.comp2522.labs.lab03;

import java.text.DecimalFormat;

public class Square extends Quadrilateral {
    private double side;

    public Square(final double x1, final double y1,
                  final double x2, final double y2,
                  final double x3, final double y3,
                  final double x4, final double y4) {
        super(x1, y1, x2, y2, x3, y3, x4, y4);

        side = Math.sqrt(Math.pow((getB().getX() - getA().getX()), 2)
                + Math.pow((getB().getY() - getA().getY()), 2));
    }

    public double area() {
        return 4 * side;
    }

    /**
     * @Override
     * */
    public String toString() {
        DecimalFormat df = new DecimalFormat(".0");
        return "\nCoordinates of the Square are:\n"
                + super.toString()
                + "\nSide is: " + df.format(side)
                + "\nArea is: " + df.format(area());
    }
}
