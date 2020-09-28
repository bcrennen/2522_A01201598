package ca.bcit.comp2522.assignments.a2;

import java.util.ArrayList;
import java.util.Random;

/**
 * Creates a Guppy class with symbolic constants,
 * instance variables, constructors and methods.
 *
 * @author Brennen Chiu
 * @version 2020
 */
public class Guppy {
    /**The age of a female to reproduce.*/
    static final int FEMALE_REPRODUCE_AGE = 8;
    /**The lowest amount of fry produce by a female.*/
    static final int MINIMUM_NUMBER_OF_FRY_PRODUCE = 1;

    /**The highest amount of fry produce by a female.*/
    static final int MAXIMUM_NUMBER_OF_FRY_PRODUCE = 100;


    /**The age of a young fish in weeks.*/
    static final int YOUNG_FISH_AGE_IN_WEEKS = 10;

    /**The age of a mature fish in weeks.*/
    static final int MATURE_FISH_AGE_IN_WEEKS = 30;

    /**The maximum age of a fish in weeks.*/
    static final int MAXIMUM_AGE_IN_WEEKS = 50;

    /**The minimum water volume to hold a fish in mL .*/
    static final double MINIMUM_WATER_VOLUME_ML = 250.0;

    /**The genus name for guppy.*/
    static final String DEFAULT_GENUS = "Poecilia";

    /**The species name for guppy.*/
    static final String DEFAULT_SPECIES = "reticulata";

    /**The default health coefficient for a guppy to have.*/
    static final double DEFAULT_HEALTH_COEFFICIENT = 0.5;

    /**The minimum health coefficient for a guppy to have.*/
    static final double MINIMUM_HEALTH_COEFFICIENT = 0.0;

    /**The maximum health coefficient for a guppy to have.*/
    static final double MAXIMUM_HEALTH_COEFFICIENT = 1.0;

    /**Private instance variables for genus in the guppy class.*/
    private final String genus;

    /**Private instance variables for species in the guppy class.*/
    private final String species;

    /**Private instance variables for age in weeks in the guppy class.*/
    private int ageInWeeks;

    /**Private instance variables for is guppy female in the guppy class.*/
    private boolean isFemale;

    /**Private instance variables for generation number in the guppy class.*/
    private int generationNumber;

    /**Private instance variables for is guppy alive in the guppy class.*/
    private boolean isAlive;

    /**Private instance variables for health coefficient in the guppy class.*/
    private double healthCoefficient;

    /**Private instance variables for
     * identification number in the guppy class.*/
    private int identificationNumber;

    /**Private instance variables for
     * number of guppies born in the guppy class.*/
    private static int numberOfGuppiesBorn = 0;

    /**
     * A zero-parameter constructor for a guppy.
     * */
    public Guppy() {

        ageInWeeks = 0;
        generationNumber = 0;
        genus = DEFAULT_GENUS;
        species = DEFAULT_SPECIES;
        isFemale = true;
        isAlive = true;
        healthCoefficient = DEFAULT_HEALTH_COEFFICIENT;

        numberOfGuppiesBorn++;
        identificationNumber = numberOfGuppiesBorn;
    }

    /**
     * A constructor for a new guppy.
     * @param newGenus is the guppy's genus name.
     * @param newSpecies is the guppy's species name.
     * @param newAgeInWeeks is the guppy's age in weeks.
     * @param newIsFemale is the guppy a female or not.
     * @param newGenerationNumber is the generation number for the guppy.
     * @param newHealthCoefficient is the health coefficient for the guppy.
     */
    public Guppy(final String newGenus,
                 final String newSpecies,
                 final int newAgeInWeeks,
                 final boolean newIsFemale,
                 final int newGenerationNumber,
                 final double newHealthCoefficient) {

        if (newGenus.isEmpty() || newGenus == null) {
            genus = DEFAULT_GENUS;
        } else {
            genus = Character.toUpperCase(newGenus.charAt(0))
                    + newGenus.substring(1).toLowerCase();
        }

        if (newSpecies.isEmpty() || newSpecies == null) {
            species = DEFAULT_SPECIES;
        } else {
            species = newSpecies.toLowerCase();
        }

        if (newAgeInWeeks < 0 || newAgeInWeeks >= MAXIMUM_AGE_IN_WEEKS) {
            ageInWeeks = 0;
        } else {
            ageInWeeks = newAgeInWeeks;
        }

        isFemale = newIsFemale;

        if (newGenerationNumber < 0) {
            generationNumber = 1;
        } else {
            generationNumber = newGenerationNumber;
        }

        if (newHealthCoefficient < MINIMUM_HEALTH_COEFFICIENT
                || newHealthCoefficient > MAXIMUM_HEALTH_COEFFICIENT) {
            healthCoefficient = DEFAULT_HEALTH_COEFFICIENT;
        } else {
            healthCoefficient = newHealthCoefficient;
        }

        isAlive = true;

        numberOfGuppiesBorn++;
        identificationNumber = numberOfGuppiesBorn;
    }

    /**
     * Accessor for the genus of a guppy.
     * @return genus
     * */
    public String getGenus() {
        return genus;
    }

    /**
     * Accessor for the species of a guppy.
     * @return species
     * */
    public String getSpecies() {
        return species;
    }

    /**
     * Accessor for the age in weeks of a guppy.
     * @return ageInWeeks
     * */
    public int getAgeInWeeks() {
        return ageInWeeks;
    }

    /**
     * Accessor for a guppy if it is a female or not.
     * @return isFemale
     * */
    public boolean getIsFemale() {
        return isFemale;
    }

    /**
     * Accessor for the generation number of a guppy.
     * @return generationNumber
     * */
    public int getGenerationNumber() {
        return generationNumber;
    }

    /**
     * Accessor a guppy if it is alive or not.
     * @return isAlive
     * */
    public boolean getIsAlive() {
        return isAlive;
    }

    /**
     * Accessor for health coefficient of a guppy.
     * @return healthCoefficient
     * */
    public double getHealthCoefficient() {
        return healthCoefficient;
    }

    /**
     * Accessor for the identification number of a guppy.
     * @return identificationNumber
     * */
    public int getIdentificationNumber() {
        return identificationNumber;
    }

    /**
     * Accessor for number of guppies are born.
     * @return numberOfGuppiesBorn
     * */
    public static int getNumberOfGuppiesBorn() {
        return numberOfGuppiesBorn;
    }

    /**
     * Accessor for the volume needed of a guppy.
     * @return WATER_VOLUME_ML
     * */
    public double getVolumeNeeded() {
        final double oneDotFive = 1.5;
        if (getAgeInWeeks() < YOUNG_FISH_AGE_IN_WEEKS) {
            return MINIMUM_WATER_VOLUME_ML;
        } else if (getAgeInWeeks() <= MATURE_FISH_AGE_IN_WEEKS) {
            return (MINIMUM_WATER_VOLUME_ML * getAgeInWeeks())
                    / YOUNG_FISH_AGE_IN_WEEKS;
        } else if (getAgeInWeeks() <= MAXIMUM_AGE_IN_WEEKS) {
            return MINIMUM_WATER_VOLUME_ML * oneDotFive;
        } else {
            return 0.0;
        }
    }

    /**
     * A method for changing health coefficient.
     * @param delta
     * */
    public void changeHealthCoefficient(final double delta) {
        healthCoefficient += delta;
        if (healthCoefficient <= MINIMUM_HEALTH_COEFFICIENT) {
            setHealthCoefficient(0.0);
            setIsAlive(false);
        } else if (healthCoefficient > MAXIMUM_HEALTH_COEFFICIENT) {
            setHealthCoefficient(MAXIMUM_HEALTH_COEFFICIENT);
        } else {
            setHealthCoefficient(healthCoefficient + delta);
        }
    }

    /**
     * A mutator for the age in weeks of a guppy.
     * @param newAgeInWeeks
     * */
    public void setAgeInWeeks(final int newAgeInWeeks) {
        if (ageInWeeks >= 0 && ageInWeeks <= MAXIMUM_AGE_IN_WEEKS) {
            ageInWeeks = newAgeInWeeks;
        }
    }

    /**
     * A mutator for guppy is alive or not.
     * @param alive
     * */
    public void setIsAlive(final boolean alive) {
        isAlive = alive;
    }

    /**
     * A mutator for the health coefficient of a guppy.
     * @param newHealthCoefficient
     * */
    public void setHealthCoefficient(final double newHealthCoefficient) {
        if (newHealthCoefficient >= MINIMUM_HEALTH_COEFFICIENT
                && newHealthCoefficient <= MAXIMUM_HEALTH_COEFFICIENT) {
            this.healthCoefficient = newHealthCoefficient;
        }
    }

    /**
     * An increment age method of a guppy.
     * */
    public void incrementAge() {
        ageInWeeks++;
        if (ageInWeeks > MAXIMUM_AGE_IN_WEEKS) {
            isAlive = false;
        }
    }
    /**
     * This to spawn a Guppy and creating a list of different fry.
     * @return babyGuppies as an arraylist.
     * */
    public ArrayList<Guppy> spawn() {
        if (!getIsFemale() || getAgeInWeeks() < FEMALE_REPRODUCE_AGE) {
            return null;
        }
        ArrayList<Guppy> babyGuppies = new ArrayList<>();

        Random femaleSpawn = new Random();
        if (femaleSpawn.nextDouble() <= 0.5) {

            Random fryGenerator = new Random();
            int fryBorn = fryGenerator.nextInt(MAXIMUM_NUMBER_OF_FRY_PRODUCE
                    + MINIMUM_NUMBER_OF_FRY_PRODUCE);

            int fryAgeInWeeks = 0;
            boolean fryIsFemale;
            double fryHealthCoefficient;
            int fryGenerationNumber = getGenerationNumber() + 1;

            for (int x = 0; x < fryBorn; x++) {
                fryIsFemale = new Random().nextBoolean();
                fryHealthCoefficient = (1.0 + getHealthCoefficient()) / 2.0;
                Guppy fryGuppy = new Guppy(getGenus(),
                                           getSpecies(),
                                           fryAgeInWeeks,
                                           fryIsFemale,
                                           fryGenerationNumber,
                                           fryHealthCoefficient);

                babyGuppies.add(fryGuppy);
            }

        }
        return babyGuppies;
    }




    /**
     * A toString method to return the representation of a guppy.
     * @return string of Guppy object
     * */
    public String toString() {
        return "This Guppy: "
                + "\n"
                + "genus = " + genus
                + "\n"
                + "species = " + species
                + "\n"
                + "age in weeks = " + ageInWeeks
                + "\n"
                + "is female = " + isFemale
                + "\n"
                + "generation number = " + generationNumber
                + "\n"
                + "is alive = " + isAlive
                + "\n"
                + "health coefficient = " + healthCoefficient
                + "\n"
                + "identification number = " + identificationNumber;
    }

    /**
     * An equals method that checks if a guppy equal to another object.
     * @param obj
     * @return if object is equal to another guppy object
     * */
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Guppy)) {
            return false;
        }
        Guppy myGuppy = (Guppy) obj;
        return getGenus().equals(myGuppy.getGenus())
                && getSpecies().equals(myGuppy.getSpecies())
                && getAgeInWeeks() == myGuppy.getAgeInWeeks()
                && isFemale == myGuppy.isFemale
                && getGenerationNumber() == myGuppy.getGenerationNumber()
                && isAlive == myGuppy.isAlive
                && Double.compare(myGuppy.getHealthCoefficient(),
                getHealthCoefficient()) == 0
                && getIdentificationNumber()
                == myGuppy.getIdentificationNumber();
    }
}
