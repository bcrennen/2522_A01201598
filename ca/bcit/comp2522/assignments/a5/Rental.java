package ca.bcit.comp2522.assignments.a5;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
/**
 * A rental class holds list of rental items.
 *
 * @author Brennen Chiu
 * @version 2020
 * */
public class Rental implements Serializable {
    /**Comments of a rental item.*/
    private String comments;
    /**Condition after of a rental item.*/
    private Condition conditionAfter;
    /**Condition before of a rental item.*/
    private Condition conditionBefore;
    /**Date of a rental item.*/
    private Date date;
    /**Rental ID of a rental item.*/
    private long rentalID;
    /**UID of a rental item.*/
    private static long serialVersionUID = 444;
    /**
     * A constructor for an inventory item.
     *
     * @param newComments is the comment of an item.
     * @param newConditionAfter is the condition after of an item.
     * @param newConditionBefore is the condition before of an item.
     * @param newDate is the date of an item.
     * @param newRentalID is the rental ID of an item.
     * */
    public Rental(final String newComments, final Condition newConditionAfter,
                  final Condition newConditionBefore, final Date newDate,
                  final long newRentalID) {
        this.comments = newComments;
        this.conditionAfter = newConditionAfter;
        this.conditionBefore = newConditionBefore;
        this.date = newDate;
        this.rentalID = newRentalID;
    }
    /**
     * Getter for comments.
     * @return comments
     * */
    public String getComments() {
        return comments;
    }
    /**
     * Getter for condition after.
     * @return conditionAfter
     * */
    public Condition getConditionAfter() {
        return conditionAfter;
    }
    /**
     * Getter for condition before.
     * @return conditionBefore
     * */
    public Condition getConditionBefore() {
        return conditionBefore;
    }
    /**
     * Getter for date.
     * @return date
     * */
    public Date getDate() {
        return date;
    }
    /**
     * Getter for rental ID.
     * @return rentalID
     * */
    public long getRentalID() {
        return rentalID;
    }
    /**
     * Setter for the comments of a rental item.
     * @param newComments
     * */
    public void setComments(final String newComments) {
        this.comments = newComments;
    }
    /**
     * Setter for the condition after of a rental item.
     * @param newConditionAfter
     * */
    public void setConditionAfter(final Condition newConditionAfter) {
        this.conditionAfter = newConditionAfter;
    }
    /**
     * Setter for the condition before of a rental item.
     * @param newConditionBefore
     * */
    public void setConditionBefore(final Condition newConditionBefore) {
        this.conditionBefore = newConditionBefore;
    }
    /**
     * Setter for the rental ID of a rental item.
     * @param newRentalID
     * */
    public void setRentalID(final long newRentalID) {
        this.rentalID = newRentalID;
    }
    /**
     * An equals method that checks if a rental item equal to an object.
     * @param o
     * @return if object is equal to another rental item object
     * */
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (!(o instanceof Rental)) {
            return false;
        }
        Rental rental = (Rental) o;
        return getRentalID() == rental.getRentalID()
                && getComments().equals(rental.getComments())
                && getConditionAfter() == rental.getConditionAfter()
                && getConditionBefore() == rental.getConditionBefore()
                && getDate().equals(rental.getDate());
    }
    /**
     * Compare two objects with the use of integers.
     * @return if object is equal to each other by integers
     * */
    public int hashCode() {
        return Objects.hash(getComments(),
                getConditionAfter(),
                getConditionBefore(),
                getDate(),
                getRentalID());
    }
    /**
     * A toString method to return the representation of a rental item.
     * @return string of rental object
     * */
    @Override
    public String toString() {
        return "Rental: {"
                + "comments: '" + comments + '\''
                + ", conditionAfter: " + conditionAfter
                + ", conditionBefore: " + conditionBefore
                + ", date: " + date
                + ", rentalID; " + rentalID
                + '}';
    }
}
