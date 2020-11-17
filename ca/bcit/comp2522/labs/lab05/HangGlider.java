package ca.bcit.comp2522.labs.lab05;

/*
 * HangGlider.java
 */
public class HangGlider extends Vehicle {

    private int maxHeight;

    /** Creates a new instance of HangGlider */
    public HangGlider(String make, String model, int numPassengers, int topSpeed, int maxHeight) {
        super(make, model, numPassengers, topSpeed);
        this.maxHeight = maxHeight;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public void setMaxHeight(int maxHeight) {
        this.maxHeight = maxHeight;
    }
}
