package ca.bcit.comp2522.assignments.a5;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
/**
 * An inventory item class holds list of sale and rental items.
 *
 * @author Brennen Chiu
 * @version 2020
 * */
public class InventoryItem implements Sellable, Serializable {
    /**String name of an inventory item.*/
    private String name;
    /**Date of an inventory item.*/
    private Date IPD;
    /**SKU of an inventory item.*/
    private long SKU;
    /**String description of an invenrotry item.*/
    private String desc;
    /**Purchase price of an inventory item.*/
    private double purchasePrice;
    /**UID of an inventory item.*/
    private static long serialVersionUID = 111;
    /**Type of an inventory item.*/
    private String type;
    /**
     * A constructor for an inventory item.
     *
     * @param newIPD is the invoice purchase date of an item.
     * @param newSKU is the stock keeping units of an item.
     * @param newDesc is the description of an item.
     * @param newName is the name of an item.
     * @param newPurchasePrice is the price of an item.
     * @param newType is the type of an item.
     * */
    public InventoryItem(final Date newIPD, final long newSKU,
                         final String newDesc, final String newName,
                         final double newPurchasePrice, final String newType) {
        IPD = newIPD;
        SKU = newSKU;
        desc = newDesc;
        name = newName;
        purchasePrice = newPurchasePrice;
        type = newType;
    }
    /**
     * Getter for description.
     * @return desc
     * */
    public String getDesc() {
        return desc;
    }
    /**
     * Getter for IPD.
     * @return IPD
     * */
    public Date getIPD() {
        return IPD;
    }
    /**
     * Getter for name.
     * @return name
     * */
    public String getName() {
        return name;
    }
    /**
     * Getter for price.
     * @return purchasePrice
     * */
    public double getPurchasePrice() {
        return purchasePrice;
    }
    /**
     * Getter for SKU.
     * @return SKU
     * */
    public long getSKU() {
        return SKU;
    }
    /**
     * Getter for type.
     * @return type
     * */
    public String getType() {
        return type;
    }
    /**
     * Setter for the description of an item.
     * @param newDesc
     * */
    public void setDesc(final String newDesc) {
        this.desc = newDesc;
    }
    /**
     * Setter for the IPD of an item.
     * @param newIPD
     * */
    public void setIPD(final Date newIPD) {
        this.IPD = newIPD;
    }
    /**
     * Setter for the name of an item.
     * @param newName
     * */
    public void setName(final String newName) {
        this.name = newName;
    }
    /**
     * Setter for the purchase price of an item.
     * @param newPurchasePrice
     * */
    public void setPurchasePrice(final double newPurchasePrice) {
        this.purchasePrice = newPurchasePrice;
    }
    /**
     * Setter for the SKU of an item.
     * @param newSKU
     * */
    public void setSKU(final long newSKU) {
        this.SKU = newSKU;
    }
    /**
     * Setter for the type of an item.
     * @param newType
     * */
    public void setType(final String newType) {
        this.type = newType;
    }
    /**
     * A toString method to return the representation of an inventory item.
     * @return string of inventory item object
     * */
    public String toString() {
        return "Inventory Item: {"
                + "type: " + type
                + " }";
    }
    /**
     * An equals method that checks if an inventory item equal to an object.
     * @param o
     * @return if object is equal to another inventory item object
     * */
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (!(o instanceof InventoryItem)) {
            return false;
        }
        InventoryItem that = (InventoryItem) o;
        return getSKU() == that.getSKU()
                && Double.compare(that.getPurchasePrice(),
                getPurchasePrice()) == 0 && Objects.equals(getName(),
                that.getName()) && Objects.equals(getIPD(),
                that.getIPD()) && Objects.equals(getDesc(),
                that.getDesc()) && Objects.equals(getType(),
                that.getType());
    }
    /**
     * Compare two objects with the use of integers.
     * @return if object is equal to each other by integers
     * */
    public int hashCode() {
        return Objects.hash(getName(), getIPD(), getSKU(),
                getDesc(), getPurchasePrice(), getType());
    }
    @Override
    public boolean isSellable() {
        return false;
    }
    @Override
    public void setSellable(final boolean b) {
    }
}
