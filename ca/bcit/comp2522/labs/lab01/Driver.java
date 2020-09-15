package ca.bcit.comp2522.labs.lab01;

/**
 * A Driver class that has a simulation race between Tortoise and Hare.
 *
 * @author Brennen Chiu
 * @version 2020
 */
public class Driver {

    static final int RACES = 100;

    static final int RACELENGHT100 = 100;

    static final int RACELENGTH1000 = 1000;

    private static String simulateRaces(int numberOfRaces, int lengthOfRace) {
        Race raceExample = new Race(lengthOfRace);

        int tWins = 0;
        int hWins = 0;

        for (int x = 0; x < numberOfRaces; x++) {
            String winner = raceExample.simulateRace();
            if (winner.equals("Tortoise")) {
                tWins++;
            } else {
                hWins++;
            }
        }

        String outputMessage = "Tortoise won " + tWins + " times." + "\n"
                             + "Tortoise final positions: "
                             + raceExample.getRacerT().getPosition() + ".\n";

        outputMessage += "Hare won " + hWins + " times." + "\n"
                      + "Hare final positions: "
                      + raceExample.getRacerH().getPosition() + ".\n";

        outputMessage += "It took " + raceExample.getclcokTicks() + " ticks to complete.\n";

        if (tWins > hWins) {
            outputMessage += "Overall Tortoise won the most!";
        } else if (hWins > tWins) {
            outputMessage += "Overall Hare won the most!";
        } else {
            outputMessage += "The two of them were equal! SURPRISE!";
        }
        outputMessage += "\n";
        return outputMessage;

    }

    public static void main(String[] args) {
        System.out.println(simulateRaces(RACES, RACELENGHT100));
        System.out.println(simulateRaces(RACES, RACELENGTH1000));
    }
}
