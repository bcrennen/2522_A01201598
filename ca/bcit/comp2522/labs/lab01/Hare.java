package ca.bcit.comp2522.labs.lab01;

import java.util.Random;

/**
 * Create a Hare class for Hare's movement to be use in Driver class for a race.
 *
 * @author Brennen Chiu
 * @version 2020
 */
public class Hare {

    private int position = 0;

    static final int BIGHOP = 9;

    static final int BIGSLIP = -12;

    static final int SMALLHOP = 1;

    static final int SMALLSLIP = -2;

    static final int BIGHOPODDS = 2;

    static final int BIGSLIPODDS = 3;

    static final int SMALLHOPODDS_LOW = 4;

    static final int SMALLHOPODDS_HIGH = 6;

    static final int SMALLSLIPODDS_LOW = 7;

    static final int SMALLSLIPODDS_HIGH = 9;

    // accessor method
    public int getPosition(){
        return position;
    }

    //mutator method
    public void setPosition(int newPosition){
        position = newPosition;
    }

    public int move() {

        // generate random numbers between 1 - 10 (inclusive)
        final Random numbers = new Random();
        final int result = numbers.nextInt(10) + 1;

        // 1 - 10 numbers, if generate random number 2, that's 10% chance or 1/10 of landing on 2, resulting big hop.
        // this is same with big slip, if generate random number 3, that's 10% chance 1/10 of landing on 3, resulting big slip.
        // to get 30%, if random number generate between 4-6 within 10 numbers, 3/10 that's 30% chance of landing small hop.
        // 30% is the same as getting small slip.
        // this will leave 20% left, which is 1 and 10 which is the rest of the 20%.
        if (result == BIGHOPODDS) {
            setPosition(getPosition() + BIGHOP);
        } else if (result == BIGSLIPODDS) {
            setPosition(getPosition() + BIGSLIP);
        } else if (result >= SMALLHOPODDS_LOW && result <= SMALLHOPODDS_HIGH) {
            setPosition(getPosition() + SMALLHOP);
        } else if (result >= SMALLSLIPODDS_LOW && result <= SMALLSLIPODDS_HIGH) {
            setPosition(getPosition() + SMALLSLIP);
        }
        return position;
    }

    // toString method
    public String toString(){
        return "Hare position = " + position;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ( obj == null) {
            return false;
        }
        if (!(obj instanceof Hare)) {
            return false;
        }
        Hare hare = (Hare) obj;
        return getPosition() == hare.getPosition();
    }
}
