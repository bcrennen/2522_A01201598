package ca.bcit.comp2522.labs.lab03;
/**
 * Runing the program to see different shapes.
 *
 * @author Brennen
 * @version 2020
 * */
public class Driver {
    public static void main(String[] args) {
        Quadrilateral quadrilateral[] = {
                new Trapezoid(1.1, 1.2, 6.6, 2.8, 6.2, 9.9, 2.2, 7.4),
                new Parallelogram(5.0, 5.0, 11.0, 5.0, 12.0, 20.0, 6.0, 20.0),
                new Rectangle(17.0, 14.0, 30.0, 14.0, 30.0, 28.0, 17.0, 28.0),
                new Square(4.0, 0.0, 8.0, 0.0, 8.0, 4.0, 4.0, 4.0)};
        for (int i = 0; i < quadrilateral.length; i++) {
            System.out.println(quadrilateral[i]);
        }
    }
}
