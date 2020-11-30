package ca.bcit.comp2522.assignments.a5;

import java.io.Serializable;
/**
 * A sellable class holds list of sellable items.
 *
 * @author Brennen Chiu
 * @version 2020
 * */
public interface Sellable extends Serializable {
    /**
     * See if an item is sellable.
     * @return ture or false.
     * */
    boolean isSellable();
    /**
     * setter for sellable.
     * @param b
     * */
    void setSellable(boolean b);
}
