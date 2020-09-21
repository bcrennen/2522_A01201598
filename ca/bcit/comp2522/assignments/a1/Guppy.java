package ca.bcit.comp2522.assignments.a1;

import ca.bcit.comp2522.labs.lab01.Hare;

/**
 * Creates a Guppy class with symbolic constants, instance variables, constructors and methods.
 *
 * @author Brennen Chiu
 * @version 2020
 */
public class Guppy {

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

    /**Below are private instance variables for this guppy class.*/
    private String genus;
    private String species;
    private int ageInWeeks;
    private boolean isFemale;
    private int generationNumber;
    private boolean isAlive;
    private double healthCoefficient;
    private int identificationNumber;
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
     * */
    public Guppy(String newGenus, String newSpecies, int newAgeInWeeks,
                 boolean newIsFemale, int newGenerationNumber, double newHealthCoefficient) {

        if (newGenus.isEmpty() || newGenus == null) {
            genus = DEFAULT_GENUS;
        } else {
            genus = Character.toUpperCase(newGenus.charAt(0)) + newGenus.substring(1).toLowerCase();
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

        if (newGenerationNumber < 0 ) {
            generationNumber = 1;
        } else {
            generationNumber = newGenerationNumber;
        }

        if (newHealthCoefficient < MINIMUM_HEALTH_COEFFICIENT ||
            newHealthCoefficient > MAXIMUM_HEALTH_COEFFICIENT) {
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
     * */
    public String getGenus() {
        return genus;
    }

    /**
     * Accessor for the species of a guppy.
     * */
    public String getSpecies() {
        return species;
    }

    /**
     * Accessor for the age in weeks of a guppy.
     * */
    public int getAgeInWeeks() {
        return ageInWeeks;
    }

    /**
     * Accessor for a guppy if it is a female or not.
     * */
    public boolean getIsFemale() {
        return isFemale;
    }

    /**
     * Accessor for the generation number of a guppy.
     * */
    public int getGenerationNumber() {
        return generationNumber;
    }

    /**
     * Accessor a guppy if it is alive or not.
     * */
    public boolean getIsAlive() {
        return isAlive;
    }

    /**
     * Accessor for health coefficient of a guppy.
     * */
    public double getHealthCoefficient() {
        return healthCoefficient;
    }

    /**
     * Accessor for the identification number of a guppy.
     * */
    public int getIdentificationNumber() {
        return identificationNumber;
    }

    /**
     * Accessor for number of guppies are born.
     * */
    public static int getNumberOfGuppiesBorn() {
        return numberOfGuppiesBorn;
    }

    /**
     * Accessor for the volume needed of a guppy.
     * */
    public double getVolumeNeeded() {
        if (getAgeInWeeks() < YOUNG_FISH_AGE_IN_WEEKS) {
            return MINIMUM_WATER_VOLUME_ML;
        }
        else if (getAgeInWeeks() <= MATURE_FISH_AGE_IN_WEEKS) {
            return (MINIMUM_WATER_VOLUME_ML * getAgeInWeeks()) / YOUNG_FISH_AGE_IN_WEEKS;
        }
        else if (getAgeInWeeks() <= MAXIMUM_AGE_IN_WEEKS) {
            return MINIMUM_WATER_VOLUME_ML * 1.5;
        }
        else {
            return 0.0;
        }
    }

    /**
     * A method for changing health coefficient.
     * */
    public void changeHealthCoefficient(double delta) {
        healthCoefficient += delta;
        if (healthCoefficient <= MINIMUM_HEALTH_COEFFICIENT) {
            setHealthCoefficient(0.0);
            setIsAlive(false);
        }
        else if (healthCoefficient > MAXIMUM_HEALTH_COEFFICIENT) {
            setHealthCoefficient(MAXIMUM_HEALTH_COEFFICIENT);
        }
        else {
            setHealthCoefficient(healthCoefficient + delta);
        }
    }

    /**
     * A mutator for the age in weeks of a guppy.
     * */
    public void setAgeInWeeks(int newAgeInWeeks) {
        if (ageInWeeks >= 0 && ageInWeeks <= MAXIMUM_AGE_IN_WEEKS) {
            ageInWeeks = newAgeInWeeks;
        }
    }

    /**
     * A mutator for guppy is alive or not.
     * */
    public void setIsAlive(boolean alive) {
        isAlive = alive;
    }

    /**
     * A mutator for the health coefficient of a guppy.
     * */
    public void setHealthCoefficient(double newHealthCoefficient) {
        if (newHealthCoefficient >= MINIMUM_HEALTH_COEFFICIENT &&
            newHealthCoefficient <= MAXIMUM_HEALTH_COEFFICIENT) {
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
     * A toString method to return the representation of a guppy.
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
     * */
    public boolean equals(Object obj) {
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
                && Double.compare(myGuppy.getHealthCoefficient(), getHealthCoefficient()) == 0
                && getIdentificationNumber() == myGuppy.getIdentificationNumber();
    }
}
