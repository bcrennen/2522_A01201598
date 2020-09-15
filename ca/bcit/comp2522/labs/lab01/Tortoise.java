package ca.bcit.comp2522.labs.lab01;

import java.util.Random;

/**
 * Create a Tortoise class for Tortoise's movement to be use in Driver class for a race.
 *
 * @author Brennen Chiu
 * @version 2020
 */
public class Tortoise {

    private int position = 0;

    static final int FASTPLOD = 3;

    static final int BACKPLOD = -6;

    static final int SLOWPLOD = 1;

    static final int FASTPLODODDS_LOW = 1;

    static final int FASTPLODODDS_HIGH = 5;

    static final int BACKPLODODDS_LOW = 6;

    static final int BACKPLODODDS_HIGH = 7;

    static final int SLOWPLODODDS_LOW = 8;

    static final int SLOWPLODODDS_HIGH = 10;

    public int getPosition() {
        return position;
    }

    public void setPosition(int newPosition) {
        position = newPosition;
    }

    public int move() {
        // generate random numbers between 1 - 10 (inclusive)
        final Random numbers = new Random();
        final int result = numbers.nextInt(10) + 1;

        if (result >= FASTPLODODDS_LOW && result <= FASTPLODODDS_HIGH ) {
            setPosition(getPosition() + FASTPLOD);
        } else if (result >= BACKPLODODDS_LOW && result <= BACKPLODODDS_HIGH) {
            setPosition(getPosition() + BACKPLOD);
        } else {
            setPosition(getPosition() + SLOWPLOD);
        }
        return getPosition();
    }

    public String toString() {
        return "Tortoise position = " + position;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ( obj == null) {
            return false;
        }
        if (!(obj instanceof Tortoise)) {
            return false;
        }
        Tortoise tortoise = (Tortoise) obj;
        return getPosition() == tortoise.getPosition();
    }
}
