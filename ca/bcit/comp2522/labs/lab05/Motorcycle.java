package ca.bcit.comp2522.labs.lab05;

/*
 * Motorcycle.java
 */
public class Motorcycle extends Vehicle {

    private int mileage;
    private int decibels;

    /** Creates a new instance of Motorcycle */
    public Motorcycle(String make, String model, int numPassengers, int topSpeed, int mileage, int decibels) {
        super(make, model, numPassengers, topSpeed);
        this.mileage = mileage;
        this.decibels = decibels;
    }

    public int getMileage() {
        return mileage;
    }
    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getDecibels() {
        return decibels;
    }
    public void setDecibels(int decibels) {
        this.decibels = decibels;
    }

}
