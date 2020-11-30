package ca.bcit.comp2522.assignments.a5;

import java.util.Date;
/**
 * A sales item subclass holds list of sale items.
 *
 * @author Brennen Chiu
 * @version 2020
 * */
public class SalesItem extends InventoryItem {
    /**Sale price of a sale item.*/
    private double salePrice;
    /**Sales ID of a sale item.*/
    private long salesID;
    /**Sellable of a sale item.*/
    private boolean sellable;
    /**UID of a sale item.*/
    private static long serialVersionUID = 222;
    /**Sold if ture or false.*/
    private boolean sold;
    /**
     * A constructor for a sale item.
     *
     * @param newIPD is the invoice purchase date of a sale item.
     * @param newSKU is the stock keeping units of a sale item.
     * @param newDesc is the description of a sale item.
     * @param newName is the name of a sale item.
     * @param newPurchasePrice is the price of a sale item.
     * @param newType is the type of a sale item.
     * @param newSalePrice is the sale price of a sale item.
     * @param newSalesID is the sale ID of a sale item.
     * @param newSellable is if the item is sellable.
     * @param newSold is if the item is sold.
     * */
    public SalesItem(final Date newIPD, final long newSKU,
                     final String newDesc, final String newName,
                     final double newPurchasePrice,
                     final String newType, final double newSalePrice,
                     final long newSalesID, final boolean newSellable,
                     final boolean newSold) {
        super(newIPD, newSKU, newDesc, newName,
                newPurchasePrice, newType);
        this.salePrice = newSalePrice;
        this.salesID = newSalesID;
        this.sellable = newSellable;
        this.sold = newSold;
    }
    /**
     * Getter for sale price.
     * @return salePrice
     * */
    public double getSalePrice() {
        return salePrice;
    }
    /**
     * Getter for sale ID.
     * @return salesID
     * */
    public long getSalesID() {
        return salesID;
    }
    @Override
    public boolean isSellable() {
        return sellable;
    }
    /**
     * See if the sale item is sold.
     * @return sold
     * */
    public boolean isSold() {
        return sold;
    }
    /**
     * Setter for the sale price of a sale item.
     * @param newSalePrice
     * */
    public void setSalePrice(final double newSalePrice) {
        this.salePrice = newSalePrice;
    }
    /**
     * Setter for the sale price of a sale item.
     * @param newSalesID
     * */
    public void setSalesID(final long newSalesID) {
        this.salesID = newSalesID;
    }
    @Override
    public void setSellable(final boolean newState) {
        this.sellable = newState;
    }
    /**
     * Setter for the sold item of a sale item.
     * @param newSold
     * */
    public void setSold(final boolean newSold) {
        this.sold = newSold;
    }
    /**
     * A toString method to return the representation of sale item.
     * @return string of sale item object
     * */
    public String toString() {
        return "SalesItem: {"
                + "salePrice=" + salePrice
                + ", salesID=" + salesID
                + ", sellable=" + sellable
                + ", sold=" + sold
                + '}';
    }
}
