package ca.bcit.comp2522.labs.lab05;

/*
 * Vehicle.java
 */
public class Vehicle {
    private String make;
    private String model;
    private int numPassengers;
    private int topSpeed;

    public Vehicle(String make, String model, int numPassengers, int topSpeed) {
        this.make = make;
        this.model = model;
        this.numPassengers = numPassengers;
        this.topSpeed = topSpeed;
    }

    // make
    public String getMake() {
        return make;
    }
    public void setMake(String make) {
        this.make = make;
    }
    // model
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    // number passengers
    public int getNumPassengers() {
        return numPassengers;
    }
    public void setNumPassengers(int numPassengers) {
        this.numPassengers = numPassengers;
    }
    // top speed
    public int getTopSpeed() {
        return topSpeed;
    }
    public void setTopSpeed(int topSpeed) {
        this.topSpeed = topSpeed;
    }

    // toString method
    public String toSting() {
        return "Make: " + getMake() + "Model: " + getModel();
    }
}
