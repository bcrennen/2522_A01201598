package ca.bcit.comp2522.assignments.a2;

import org.junit.Rule;
import org.junit.Test;


import static org.junit.Assert.*;
import org.junit.rules.*;

public class GuppyTest {

    private Guppy defaultGuppy;
    private Guppy testGuppy;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @org.junit.Before
    public void setUp() throws Exception {

        defaultGuppy = new Guppy();
        testGuppy = new Guppy(  "Poecilia",
                                "elegans",
                                1,
                                true,
                                3,
                                0.75);
    }

    @Test
    public void containsConstantCalledYOUNG_FISH_AGE_IN_WEEKS() {
        assertEquals(10, Guppy.YOUNG_FISH_AGE_IN_WEEKS);
    }

    @Test
    public void containsConstantCalledMATURE_FISH_AGE_IN_WEEKS() {
        assertEquals(30, Guppy.MATURE_FISH_AGE_IN_WEEKS);
    }

    @Test
    public void containsConstantCalledMAXIMUM_AGE_IN_WEEKS() {
        assertEquals(50, Guppy.MAXIMUM_AGE_IN_WEEKS);
    }

    @Test
    public void containsConstantCalledMINIMUM_WATER_VOLUME_ML() {
        assertEquals(250.0, Guppy.MINIMUM_WATER_VOLUME_ML, 0.0);
    }

    @Test
    public void containsConstantCalledDEFAULT_GENUS() {
        assertTrue(Guppy.DEFAULT_GENUS.equals("Poecilia"));
    }

    @Test
    public void containsConstantCalledDEFAULT_SPECIES() {
        assertTrue(Guppy.DEFAULT_SPECIES.equals("reticulata"));
    }

    @Test
    public void containsConstantCalledDEFAULT_HEALTH_COEFFICIENT() {
        assertEquals(0.5, Guppy.DEFAULT_HEALTH_COEFFICIENT, 0.0);
    }

    @Test
    public void containsConstantCalledMINIMUM_HEALTH_COEFFICIENT() {
        assertEquals(0.0, Guppy.MINIMUM_HEALTH_COEFFICIENT, 0.0);
    }

    @Test
    public void containsConstantCalledMAXIMUM_HEALTH_COEFFICIENT() {
        assertEquals(1.0, Guppy.MAXIMUM_HEALTH_COEFFICIENT, 0.0);
    }

    @Test
    public void staticGuppyCounterIsCorrectlyTrackingNewbornGuppiesInDefaultConstructor() {
        final int numberAlreadyCreated = Guppy.getNumberOfGuppiesBorn();
        final int numberCreated = 100;
        for (int i = 0; i < numberCreated; ++i) {
            Guppy someGuppy = new Guppy();
        }
        assertEquals(numberAlreadyCreated + numberCreated, Guppy.getNumberOfGuppiesBorn());
    }

    @Test
    public void staticGuppyCounterIsCorrectlyTrackingNewbornGuppiesInMultiParamConstructor() {
        final int numberAlreadyCreated = Guppy.getNumberOfGuppiesBorn();
        final int numberCreated = 100;
        for (int i = 0; i < numberCreated; ++i)
            new Guppy("Poecilia",
                    "elegans",
                    1,
                    true,
                    3,
                    0.75);
        assertEquals(numberAlreadyCreated + numberCreated, Guppy.getNumberOfGuppiesBorn());
    }

    @Test
    public void defaultGuppyIsSetToCorrectValues() {
        assertTrue(defaultGuppy.getGenus().equals("Poecilia"));
        assertTrue(defaultGuppy.getSpecies().equals("reticulata"));
        assertEquals(0, defaultGuppy.getAgeInWeeks());
        assertTrue(defaultGuppy.getIsFemale());
        assertEquals(0, defaultGuppy.getGenerationNumber());
        assertTrue(defaultGuppy.getIsAlive());
        assertEquals(0.5, defaultGuppy.getHealthCoefficient(), 0.0);
    }

    @Test
    public void multiParamGuppyIsSetToCorrectValues() {
        assertTrue(testGuppy.getGenus().equals("Poecilia"));
        assertTrue(testGuppy.getSpecies().equals("elegans"));
        assertEquals(1, testGuppy.getAgeInWeeks());
        assertTrue(testGuppy.getIsFemale());
        assertEquals(3, testGuppy.getGenerationNumber());
        assertTrue(testGuppy.getIsAlive());
        assertEquals(0.75, testGuppy.getHealthCoefficient(), 0.0);
    }

    @Test
    public void identificationNumbersAreSequentialAndUniqueInDefaultConstruction() {
        Guppy first = new Guppy();
        int firstID = first.getIdentificationNumber() + 1;
        int numberCreated = 100;
        for (int i = 0; i < numberCreated; ++i) {
            Guppy fry = new Guppy();
            assertEquals(firstID + i, fry.getIdentificationNumber());
        }
    }

    @Test
    public void identificationNumbersAreSequentialAndUniqueInMultiParamConstruction() {
        Guppy first = new Guppy();
        int firstID = first.getIdentificationNumber() + 1;
        int numberCreated = 100;
        for (int i = 0; i < numberCreated; ++i) {
            Guppy fry = new Guppy("Poecilia",
                    "elegans",
                    1,
                    true,
                    3,
                    0.75);
            assertEquals(firstID + i, fry.getIdentificationNumber());
        }
    }

    @Test
    public void genusAndSpeciesAreCorrectlyFormattedAndStored() {
        Guppy fry = new Guppy("  poECILIA    ",
                "  ELEgans   ",
                1,
                true,
                3,
                0.75);
        assertTrue(fry.getGenus().equals("Poecilia"));
        assertTrue(fry.getSpecies().equals("elegans"));
    }

    @Test
    public void createExceptionWithNoGenus() {
        thrown.expect(IllegalArgumentException.class);
        Guppy fry = new Guppy(null,
                "a",
                0,
                true,
                0 ,
                0.5);
    }

    @Test
    public void createExceptionWithEmptyGenus() {
        thrown.expect(IllegalArgumentException.class);
        Guppy fry = new Guppy("    ",
                "a",
                0,
                true,
                0 ,
                0.5);
    }

    @Test
    public void createExceptionWithNoSpecies() {
        thrown.expect(IllegalArgumentException.class);
        Guppy fry = new Guppy("a",
                null,
                0,
                true,
                0 ,
                0.5);
    }

    @Test
    public void createExceptionWithEmptySpecies() {
        thrown.expect(IllegalArgumentException.class);
        Guppy fry = new Guppy("a",
                "    ",
                0,
                true,
                0 ,
                0.5);
    }

    @Test
    public void createExceptionWithNegativeAgeInWeeks() {
        thrown.expect(IllegalArgumentException.class);
        Guppy fry = new Guppy("a",
                "b",
                -1,
                true,
                0 ,
                0.5);
    }

    @Test
    public void createExceptionWithMaximumAgeInWeeks() {
        thrown.expect(IllegalArgumentException.class);
        Guppy fry = new Guppy("a",
                "b",
                50,
                true,
                0 ,
                0.5);
    }

    @Test
    public void createExceptionWithNegativeGenerationNumber() {
        thrown.expect(IllegalArgumentException.class);
        Guppy fry = new Guppy("a",
                "b",
                0,
                true,
                -1,
                0.5);
    }

    @Test
    public void createExceptionWithNegativeHealthCoefficient() {
        thrown.expect(IllegalArgumentException.class);
        Guppy fry = new Guppy("a",
                "b",
                0,
                true,
                0,
                -0.5);
    }

//    @Test
//    public void createExceptionWithOverlargeHealthCoefficient() {
//        thrown.expect(IllegalArgumentException.class);
//        Guppy fry = new Guppy("a",
//                "b",
//                0,
//                true,
//                0,
//                1.01);
//    }

    @Test
    public void testIncrementAge() {
        int oldAge = testGuppy.getAgeInWeeks();
        testGuppy.incrementAge();
        int newAge = testGuppy.getAgeInWeeks();
        assertTrue(newAge == (oldAge + 1));
    }

    @Test
    public void testIncrementAgeKillsGuppyWhenMaxAgeIsReached() {
        testGuppy.setAgeInWeeks(50);
        testGuppy.incrementAge();
        assertFalse(testGuppy.getIsAlive());
    }

    @Test
    public void ageMutatorIgnoresInvalidArguments() {
        int age = defaultGuppy.getAgeInWeeks();
        defaultGuppy.setAgeInWeeks(-1);
        assertEquals(age, defaultGuppy.getAgeInWeeks());

        defaultGuppy.setAgeInWeeks(51);
        assertEquals(age, defaultGuppy.getAgeInWeeks());
    }

    @Test
    public void ageMutatorAcceptsValidArguments() {
        int age = testGuppy.getAgeInWeeks();
        testGuppy.setAgeInWeeks(0);
        assertEquals(0, testGuppy.getAgeInWeeks());

        testGuppy.setAgeInWeeks(50);
        assertEquals(50, testGuppy.getAgeInWeeks());

        testGuppy.setAgeInWeeks(25);
        assertEquals(25, testGuppy.getAgeInWeeks());
    }

    @Test
    public void healthCoefficientMutatorIgnoresInvalidArguments() {
        double healthCoefficient = defaultGuppy.getHealthCoefficient();
        defaultGuppy.setHealthCoefficient(-0.01);
        assertEquals(healthCoefficient, defaultGuppy.getHealthCoefficient(), 0.0);

        defaultGuppy.setHealthCoefficient(1.01);
        assertEquals(healthCoefficient, defaultGuppy.getHealthCoefficient(), 0.0);
    }

    @Test
    public void healthCoefficientMutatorAcceptsValidArguments() {
        double healthCoefficient = testGuppy.getHealthCoefficient();
        testGuppy.setHealthCoefficient(0.0);
        assertEquals(0.0, testGuppy.getHealthCoefficient(), 0.0);

        testGuppy.setHealthCoefficient(1.0);
        assertEquals(1.0, testGuppy.getHealthCoefficient(), 0.0);

        testGuppy.setHealthCoefficient(0.5);
        assertEquals(0.5, testGuppy.getHealthCoefficient(), 0.0);
    }

    @Test
    public void babyFishNeedMinimalVolumeOfWater() {
        Guppy fry = new Guppy();
        for (int i = 0; i < Guppy.YOUNG_FISH_AGE_IN_WEEKS; ++i) {
            fry.setAgeInWeeks(i);
            assertEquals(Guppy.MINIMUM_WATER_VOLUME_ML, fry.getVolumeNeeded(), 0.0);
        }
    }

    @Test
    public void youngFishNeedCorrectVolumeOfWater() {
        Guppy fry = new Guppy();
        for (int i = Guppy.YOUNG_FISH_AGE_IN_WEEKS; i <= Guppy.MATURE_FISH_AGE_IN_WEEKS; ++i) {
            fry.setAgeInWeeks(i);
            double volumeNeeded = Guppy.MINIMUM_WATER_VOLUME_ML * fry.getAgeInWeeks() / Guppy.YOUNG_FISH_AGE_IN_WEEKS;
            assertEquals(volumeNeeded, fry.getVolumeNeeded(), 0.001);
        }
    }

    @Test
    public void matureFishNeedCorrectVolumeOfWater() {
        Guppy fry = new Guppy();
        for (int i = Guppy.MATURE_FISH_AGE_IN_WEEKS + 1; i <= Guppy.MAXIMUM_AGE_IN_WEEKS; ++i) {
            fry.setAgeInWeeks(i);
            double volumeNeeded = Guppy.MINIMUM_WATER_VOLUME_ML * 1.5;
            assertEquals(volumeNeeded, fry.getVolumeNeeded(), 0.001);
        }
    }

    @Test
    public void deadFishNeedNoWater() {
        Guppy fry = new Guppy();
        fry.setAgeInWeeks(50);
        fry.incrementAge();
        assertEquals(0.0, fry.getVolumeNeeded(), 0.0);
    }

    @Test
    public void changeHealthCoefficientWillNotPermitOverlargeHealthCoefficients() {
        testGuppy.changeHealthCoefficient(1.5);
        assertEquals(1.0, testGuppy.getHealthCoefficient(), 0.0);
    }


    @Test
    public void changeHealthCoefficientWillNotPermitNegativeHealthCoefficients() {
        testGuppy.changeHealthCoefficient(-1.5);
        assertEquals(0.0, testGuppy.getHealthCoefficient(), 0.0);
    }

    @Test
    public void changeHealthCoefficientToZeroOrLowerKillsTheGuppy() {
        testGuppy.changeHealthCoefficient(-1.5);
        assertFalse(testGuppy.getIsAlive());
    }
}
