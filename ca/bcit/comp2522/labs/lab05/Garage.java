package ca.bcit.comp2522.labs.lab05;
/*
 * Garage.java
 */

import java.util.*;

/**
 * @author Jim
 */
public class Garage {

    private ArrayList<Vehicle> garage = null;

    /** Creates a new instance of Garage.*/
    public Garage() {
        garage = new ArrayList<Vehicle>();
    }

    public void add(final Vehicle x) {
        garage.add(x);
    }

    public void report() {
        System.out.println("My garage has ...");
        for (Vehicle x:garage) {
            System.out.println(x.toString());
        }

        System.out.print("If I filled them all, I could hold ");
        int count = 0;
        for (Vehicle x:garage) {
            if (x instanceof Car) {
                Car car = (Car) x;
                count += car.getNumPassengers();
            }
            if (x instanceof Truck) {
                Truck truck = (Truck) x;
                count += truck.getNumPassengers();
            }
            if (x instanceof Submarine) {
                Submarine submarine = (Submarine) x;
                count += submarine.getNumPassengers();
            }
            if (x instanceof Motorcycle) {
                Motorcycle motorcycle = (Motorcycle) x;
                count += motorcycle.getNumPassengers();
            }
            if (x instanceof HangGlider) {
                HangGlider hangGlider = (HangGlider) x;
                count += hangGlider.getNumPassengers();
            }
            if (x instanceof SpyCar) {
                SpyCar spyCar = (SpyCar) x;
                count += spyCar.getNumPassengers();
            }
        }
        System.out.println("" + count + " passengers");
    }

}
