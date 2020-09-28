package ca.bcit.comp2522.assignments.a2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * Creates a Ecosystem class to put the Guppies in.
 *
 * @author Brennen Chiu
 * @version 2020
 * */
public class Ecosystem {

    private ArrayList<Pool> pools;

    public Ecosystem() {
        this.pools = new ArrayList<>();
    }

    public void addPool(final Pool newPool) {
        if (newPool != null) {
            pools.add(newPool);
        }
    }

    public void reset() {
        pools.clear();
    }

    public int getGuppyPopulation() {
        int totalGuppyPopulation = 0;
        for (Pool guppyPool : pools) {
            totalGuppyPopulation += guppyPool.getPopulation();
        }
        return totalGuppyPopulation;
    }

    public int adjustForCrowding() {
        int totalGuppyKilled = 0;
        Iterator<Pool> iterator = pools.iterator();

        while (iterator.hasNext()) {
            Pool guppyPool = iterator.next();
            totalGuppyKilled += guppyPool.adjustForCrowding();
        }
        return totalGuppyKilled;
    }

    public void setupSimulation() {
        Pool pool1 = new Pool("Skookumchuk", 3000, 42, 7.9, 0.9);
        Pool pool2 = new Pool("Squamish", 15000, 39, 7.7, 0.85);
        Pool pool3 = new Pool("Semiahmoo", 4500, 37, 7.5, 1.0);

        Random r = new Random();
        Guppy guppy = null;

        for (int i = 0; i < 300; i++) {
            int age = r.nextInt(25 - 10) + 10;
            double healthCoe = 0.5 + (0.8 - 0.5) * r.nextDouble();
            guppy = new Guppy(Guppy.DEFAULT_GENUS, Guppy.DEFAULT_SPECIES, age, (r.nextDouble() < 0.75), 2, healthCoe);
            pool1.addGuppy(guppy);
        }

        for (int i = 0; i < 100; i++) {
            int age = r.nextInt(15 - 10) + 10;
            double healthCoe = 0.8 + (1.0 - 0.8) * r.nextDouble();
            guppy = new Guppy(Guppy.DEFAULT_GENUS, Guppy.DEFAULT_SPECIES, age, (r.nextDouble() < 0.75), 2, healthCoe);
            pool2.addGuppy(guppy);
        }

        for (int i = 0; i < 200; i++) {
            int age = r.nextInt(49 - 15) + 15;
            double healthCoe = 0.0 + (1.0 - 0.0) * r.nextDouble();
            guppy = new Guppy(Guppy.DEFAULT_GENUS, Guppy.DEFAULT_SPECIES, age, (r.nextDouble() < 0.35), 2, healthCoe);
            pool3.addGuppy(guppy);
        }
    }


}
