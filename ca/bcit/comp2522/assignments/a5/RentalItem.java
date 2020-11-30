package ca.bcit.comp2522.assignments.a5;

import java.util.Arrays;
import java.util.Date;
/**
 * A rental item subclass holds list of rental items.
 *
 * @author Brennen Chiu
 * @version 2020
 * */
public class RentalItem extends InventoryItem {
    /**Current condition of the rental item.*/
    private Condition currentCondition;
    /**Array list of the rental item.*/
    private Rental[] item;
    /**Rental ID of the rental item.*/
    private long rentalID;
    /**Rental price of the rental item.*/
    private double rentalPrice;
    /**Sellable of the rental item.*/
    private boolean sellable;
    /**UID of the rental item.*/
    private static long serialVersionUID = 333;
    /**If the is sold.*/
    private boolean sold;
    /**
     * A constructor for an rental item.
     *
     * @param newIPD is the invoice purchase date of an item.
     * @param newSKU is the stock keeping units of an item.
     * @param newDesc is the description of an item.
     * @param newName is the name of an item.
     * @param newPurchasePrice is the price of an item.
     * @param newType is the type of an item.
     * @param newCurrentCondition is current condition of an item.
     * @param newItem is the item array of a new items.
     * @param newRentalID is the rental ID of an item.
     * @param newRentalPrice is the rental price of an item.
     * @param newSellable is if the item is sellable.
     * @param newSold is if the item is sold.
     * */
    public RentalItem(final Date newIPD, final long newSKU,
                      final String newDesc, final String newName,
                      final double newPurchasePrice,
                      final String newType, final Condition newCurrentCondition,
                      final Rental[] newItem, final long newRentalID,
                      final double newRentalPrice, final boolean newSellable,
                      final boolean newSold) {
        super(newIPD, newSKU, newDesc, newName,
                newPurchasePrice, newType);
        this.currentCondition = newCurrentCondition;
        this.item = newItem;
        this.rentalID = newRentalID;
        this.rentalPrice = newRentalPrice;
        this.sellable = newSellable;
        this.sold = newSold;
    }
    /**
     * Getter for current condition.
     * @return currentCondition
     * */
    public Condition getCurrentCondition() {
        return currentCondition;
    }
    /**
     * Getter for an array item.
     * @return item
     * */
    public Rental[] getItem() {
        return item;
    }
    /**
     * Getter for rental ID.
     * @return rentalID
     * */
    public long getRentalID() {
        return rentalID;
    }
    /**
     * Getter for rental price.
     * @return rentalPrice
     * */
    public double getRentalPrice() {
        return rentalPrice;
    }
    @Override
    public boolean isSellable() {
        return sellable;
    }
    /**
     * Check if item is sold.
     * @return sold
     * */
    public boolean isSold() {
        return sold;
    }
    /**
     * Setter for the current condition of an item.
     * @param newCurrentCondition
     * */
    public void setCurrentCondition(final Condition newCurrentCondition) {
        this.currentCondition = newCurrentCondition;
    }
    /**
     * Setter for an item in array list.
     * @param newItem
     * */
    public void setItem(final Rental[] newItem) {
        this.item = newItem;
    }
    /**
     * Setter for rental ID.
     * @param newRentalID
     * */
    public void setRentalID(final long newRentalID) {
        this.rentalID = newRentalID;
    }
    /**
     * Setter for rental price.
     * @param newRentalPrice
     * */
    public void setRentalPrice(final double newRentalPrice) {
        this.rentalPrice = newRentalPrice;
    }
    @Override
    public void setSellable(final boolean newSellable) {
        this.sellable = newSellable;
    }
    /**
     * Setter for if the item is sold.
     * @param newSold
     * */
    public void setSold(final boolean newSold) {
        this.sold = newSold;
    }
    /**
     * A toString method to return the representation of rental item.
     * @return string of rental item object
     * */
    public String toString() {
        return "RentalItem: {"
                + "currentCondition: " + currentCondition
                + ", item: " + Arrays.toString(item)
                + ", rentalID: " + rentalID
                + ", rentalPrice: " + rentalPrice
                + ", sellable: " + sellable
                + ", sold: " + sold
                + '}';
    }
}
