package ca.bcit.comp2522.labs.lab01;

import java.util.Random;

/**
 * Create a Race class to race one tortoise against one hare.
 *
 * @author Brennen Chiu
 * @version 2020
 */

public class Race {

    private Tortoise racerT;

    private Hare racerH;

    private int raceLength;

    static final int START_POSITION = 0;

    private int clockTicks;

    public Race(int raceTrackLength) {
        raceLength = raceTrackLength;
        racerT = new Tortoise();
        racerH = new Hare();
    }

    public Tortoise getRacerT() {
        return racerT;
    }

    public Hare getRacerH() {
        return racerH;
    }

    public int getclcokTicks(){
        return clockTicks;
    }

    public void reset() {
        racerT.setPosition(START_POSITION);
        racerH.setPosition(START_POSITION);
        clockTicks = 0;
    }

    public String simulateRace() {
        reset();
        return race();
    }

    private String race() {
        do {
            Random randNumbers = new Random();
            int firstMove = randNumbers.nextInt(2);
            if (firstMove == 0) {
                racerH.move();
                racerT.move();
            } else {
                racerT.move();
                racerH.move();
            }
            clockTicks++;
        } while (racerT.getPosition() < raceLength && racerH.getPosition() < raceLength);
        if (racerT.getPosition() >= raceLength) {
            return "Tortoise";
        } else {
            return "Hare";
        }
    }
}
