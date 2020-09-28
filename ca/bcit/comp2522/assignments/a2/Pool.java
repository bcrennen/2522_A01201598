package ca.bcit.comp2522.assignments.a2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Random;

/**
 * Creates a Pool class to put the Guppies in.
 *
 * @author Brennen Chiu
 * @version 2020
 * */
public class Pool<volumeLitres> {

    /**The default pool name.*/
    static final String DEFAULT_POOL_NAME = "Unnamed";

    /**The default pool temperature in celsius.*/
    static final double DEFAULT_POOL_TEMP_CELSIUS = 40.0;

    /**The minimum pool temperature in celsius.*/
    static final double MINIMUM_POOL_TEMP_CELSIUS = 0.0;

    /**The maximum pool temperature in celsius.*/
    static final double MAXIMUM_POOL_TEMP_CELSIUS = 100.0;

    /**The neutral pH level.*/
    static final double NEUTRAL_PH = 7.0;

    /**The minimum pH level.*/
    static final double MINIMUM_PH = 0.0;

    /**The maximum pH level.*/
    static final double MAXIMUM_PH = 14.0;

    /**The default nutrient coefficient number.*/
    static final double DEFAULT_NUTRIENT_COEFFICIENT = 0.50;

    /**The minimum nutrient coefficient.*/
    static final double MINIMUM_NUTRIENT_COEFFICIENT = 0.0;

    /**The maximum nutrient coefficient.*/
    static final double MAXIMUM_NUTRIENT_COEFFICIENT = 1.0;

    /**The ml to L conversion.*/
    static final double ML_CONVERSION = 1000.0;


    private String name;
    private double volumeLitres;
    private double temperatureCelsius;
    private double pH;
    private double nutrientCoefficient;
    private int identificationNumber;
    private ArrayList<Guppy> guppiesInPool;
    private Random randomNumberGenerator;
    private static int numberOfPools = 0;

    public Pool() {
        name = DEFAULT_POOL_NAME;
        volumeLitres = 0.0;
        temperatureCelsius = DEFAULT_POOL_TEMP_CELSIUS;
        pH = NEUTRAL_PH;
        nutrientCoefficient = DEFAULT_NUTRIENT_COEFFICIENT;
        guppiesInPool = new ArrayList<>();
        randomNumberGenerator = new Random();

        numberOfPools++;
        identificationNumber += numberOfPools;
    }

    public Pool(final String name,
                final double volumeLitres,
                final double temperatureCelsius,
                final double pH,
                final double nutrientCoefficient) {

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("This name cannot be blank.");
        } else {
            this.name = Character.toUpperCase(name.charAt(0))
                    + name.substring(1).toLowerCase();
        }

        this.volumeLitres = Math.max(volumeLitres, 0.0);

        setTemperatureCelsius(temperatureCelsius);

        setPH(pH);

        guppiesInPool = new ArrayList<Guppy>();
        randomNumberGenerator = new Random();

        numberOfPools++;
        identificationNumber += numberOfPools;
    }

    public String getName() {
        return name;
    }

    public double getVolumeLitres() {
        return volumeLitres;
    }

    public double getTemperatureCelsius() {
        return temperatureCelsius;
    }

    public double getpH() {
        return pH;
    }

    public double getNutrientCoefficient() {
        return nutrientCoefficient;
    }

    public int getIdentificationNumber() {
        return identificationNumber;
    }

    public void setVolumeLitres(final double newVolumeLitres) { /////////////////////////////
        if (newVolumeLitres >= 0) {
            this.volumeLitres = newVolumeLitres;
        }
    }

    public void setTemperatureCelsius(final double newTemperatureCelsius) {
        if (newTemperatureCelsius >= MINIMUM_POOL_TEMP_CELSIUS && newTemperatureCelsius <= MAXIMUM_POOL_TEMP_CELSIUS) {
            this.temperatureCelsius = newTemperatureCelsius;
        } else {
           this.temperatureCelsius = DEFAULT_POOL_TEMP_CELSIUS;
        }
    }

    public void setPH(final double newPH) {
        if (newPH >= 0.0 && newPH <= MAXIMUM_PH) {
            this.pH = newPH;
        } else {
            this.pH = NEUTRAL_PH;
        }
    }

    public void setNutrientCoefficient(final double newNutrientCoefficient) {
        if (newNutrientCoefficient >= MINIMUM_NUTRIENT_COEFFICIENT && newNutrientCoefficient <= MAXIMUM_NUTRIENT_COEFFICIENT) {
            this.nutrientCoefficient = newNutrientCoefficient;
        } else {
            this.nutrientCoefficient = DEFAULT_NUTRIENT_COEFFICIENT;
        }
    }

    public void changeNutrientCoefficient(final double delta) {
        double newNutrientCoefficient = getNutrientCoefficient() + delta;
        if (newNutrientCoefficient < MINIMUM_NUTRIENT_COEFFICIENT) {
            setNutrientCoefficient(MINIMUM_NUTRIENT_COEFFICIENT);
        } else if (newNutrientCoefficient > MAXIMUM_NUTRIENT_COEFFICIENT) {
            setNutrientCoefficient(MAXIMUM_NUTRIENT_COEFFICIENT);
        } else {
            setNutrientCoefficient(newNutrientCoefficient);
        }
    }

    public void changeTemperature(final double delta) {
        double newTemperature = getTemperatureCelsius() + delta;
        if (newTemperature < MINIMUM_POOL_TEMP_CELSIUS) {
            setTemperatureCelsius(MINIMUM_POOL_TEMP_CELSIUS);
        } else if (newTemperature > MAXIMUM_POOL_TEMP_CELSIUS) {
            setTemperatureCelsius(MAXIMUM_POOL_TEMP_CELSIUS);
        } else {
            setTemperatureCelsius(newTemperature);
        }
    }

    public static int getNumberCreated() {
        return numberOfPools;
    }

    public boolean addGuppy(Guppy guppy) {
        if (guppy == null) {
            return false;
        }
        guppiesInPool.add(guppy);
        return true;
    }

    public int getPopulation() {
        int livingGuppies = 0;
        for (Guppy guppy : guppiesInPool) {
            if (guppy.getIsAlive()) {
                livingGuppies++;
            }
        }
        return livingGuppies;
    }

    public int applyNutrientCoefficient() {
        int starvedGuppy = 0;
        Iterator<Guppy> iterator = guppiesInPool.iterator();

        while (iterator.hasNext()) {
            Guppy guppy = iterator.next();
            if (guppy.getIsAlive() && randomNumberGenerator.nextDouble() > getNutrientCoefficient()) {
                guppy.setIsAlive(false);
                starvedGuppy++;
            }
        }
        return starvedGuppy;
    }

    public int removeDeadGuppies() {
        int removeGuppy = 0;
        Iterator<Guppy> iterator = guppiesInPool.iterator();

        while (iterator.hasNext()) {
            if (!iterator.next().getIsAlive()) {
                iterator.remove();
                removeGuppy++;
            }
        }
        return removeGuppy;
    }

    public double getGuppyVolumeRequirementLitres() {
        double totalVolumeNeededML = 0.0;
        Iterator<Guppy> iterator = guppiesInPool.iterator();

        while (iterator.hasNext()) {
            Guppy poolGuppy = iterator.next();
            if (poolGuppy.getIsAlive()) {
                totalVolumeNeededML += poolGuppy.getVolumeNeeded();
            }
        }
        return totalVolumeNeededML / ML_CONVERSION;
    }

    public double getAverageAgeInWeeks() {
        double totalGuppyAge = 0.0;
        int livingGuppiesInPool = 0;

        Iterator<Guppy> iterator = guppiesInPool.iterator();

        while (iterator.hasNext()) {
            Guppy poolGuppy = iterator.next();
            if (poolGuppy.getIsAlive()) {
                livingGuppiesInPool++;
                totalGuppyAge += poolGuppy.getAgeInWeeks();
            }
        }
        return totalGuppyAge / livingGuppiesInPool;
    }

    public double getAverageHealthCoefficient() {
        double totalGuppyHealthCoefficient = 0.0;
        int livingGuppiesInPool = 0;

        Iterator<Guppy> iterator = guppiesInPool.iterator();

        while (iterator.hasNext()) {
            Guppy poolGuppy = iterator.next();
            if (poolGuppy.getIsAlive()) {
                livingGuppiesInPool++;
                totalGuppyHealthCoefficient += poolGuppy.getHealthCoefficient();
            }
        }
        return totalGuppyHealthCoefficient / livingGuppiesInPool;
    }

    public double getFemalePercentage() {
        double femaleGuppy = 0.0;
        int livingGuppiesInPool = 0;

        Iterator<Guppy> iterator = guppiesInPool.iterator();

        while (iterator.hasNext()) {
            Guppy poolGuppy = iterator.next();
            if (poolGuppy.getIsAlive()) {
                livingGuppiesInPool++;
                if (poolGuppy.getIsFemale()) {
                    femaleGuppy += 1.0;
                }
            }
        }
        return femaleGuppy / livingGuppiesInPool;
    }

    public double getMedianAge() {
        ArrayList<Integer> guppyAge = new ArrayList<>();

        Iterator<Guppy> iterator = guppiesInPool.iterator();
        while (iterator.hasNext()) {
            Guppy poolGuppy = iterator.next();
            guppyAge.add(poolGuppy.getAgeInWeeks());
        }
        Collections.sort(guppyAge);
        int numberOfGuppies = guppyAge.size();

        if (numberOfGuppies % 2 == 0) {
            return (guppyAge.get((numberOfGuppies / 2) - 1)
                    + guppyAge.get(numberOfGuppies / 2)) / 2;
        }
        return guppyAge.get(numberOfGuppies / 2);
    }

    public int spawn() {
        Iterator<Guppy> iterator = guppiesInPool.iterator();
        int newBorn = 0;
        ArrayList<Guppy> newGuppies = new ArrayList<>();

        while (iterator.hasNext()) {
            ArrayList<Guppy> newBabies = iterator.next().spawn();
            if (newBabies != null) {
                newBorn += newBabies.size();
                newGuppies.addAll(newBabies);
            }
        }
        guppiesInPool.addAll(newGuppies);
        return newBorn;
    }

    public int incrementAges() {
        int deadGuppy = 0;
        Iterator<Guppy> iterator = guppiesInPool.iterator();

        while (iterator.hasNext()) {
            Guppy poolGuppy = iterator.next();
            poolGuppy.incrementAge();
            if (!poolGuppy.getIsAlive()) {
                deadGuppy++;
            }
        }
        return deadGuppy;
    }

    public int adjustForCrowding() {
        int deadGuppy = 0;

        Collections.sort(guppiesInPool, new Comparator<Guppy>() {
            @Override
            public int compare(final Guppy o1, final Guppy o2) {
                return Double.compare(o1.getHealthCoefficient(), o2.getHealthCoefficient());
            }
        });

        double requiredVolume = this.getGuppyVolumeRequirementLitres();
        Iterator<Guppy> iterator = guppiesInPool.iterator();
        while (iterator.hasNext() && requiredVolume > this.getVolumeLitres()) {
            Guppy weakGuppy = iterator.next();
            requiredVolume -= weakGuppy.getVolumeNeeded() / ML_CONVERSION;
            deadGuppy++;
        }
        return deadGuppy;
    }

    public String toString() {
        return "This Guppy Pool: "
                + "\n"
                + "name = " + getName()
                + "\n"
                + "volumeLitres = " + getVolumeLitres()
                + "\n"
                + "temperatureCelsius = " + getTemperatureCelsius()
                + "\n"
                + "pH level = " + getpH()
                + "\n"
                + "nutrientCoefficient = " + getNutrientCoefficient()
                + "\n"
                + "ID number = " + getIdentificationNumber()
                + "\n"
                + "guppies in pool = " + guppiesInPool;
    }
}