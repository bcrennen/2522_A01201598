package ca.bcit.comp2522.labs.lab05;

/*
 * SpyCar.java
 */
public class SpyCar extends Vehicle {

    private int mileage;
    private int maxDepth;

    public SpyCar(String make, String model, int topSpeed, int numPassengers, int maxDepth, int mileage, int maxDepth) {
        super(make, model, numPassengers, topSpeed);
        this.mileage = mileage;
        this.maxDepth = maxDepth;
    }
    public int getMileage() {
        return mileage;
    }
    public void setMileage(int mileage) {
        this.mileage = mileage;
    }
    public int getMaxDepth() {
        return maxDepth;
    }
    public void setMaxDepth(int maxDepth) {
        this.maxDepth = maxDepth;
    }
}
