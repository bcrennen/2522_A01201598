package ca.bcit.comp2522.assignments.a5;

import java.util.Date;
/**
 * An inventory item driver.
 *
 * @author Brennen Chiu
 * @version 2020
 * */
public class InventoryItemsDriver {
    /**
     * Method to print all the string.
     * @param args
     * */
    public static void main(final String[] args) {
        // create a list of rental array.
        Rental[] rentalsArray = {
                new Rental("Looks damage.", Condition.DAMAGED,
                        Condition.AVERAGE, new Date(), 10L),
                new Rental("Looks clean.", Condition.GREAT,
                        Condition.GREAT, new Date(), 20L),
                new Rental("Looks ok.", Condition.AVERAGE,
                        Condition.AVERAGE, new Date(), 30L)
        };
        // create a list of sale item.
        SalesItem item1 = new SalesItem(new Date(), 1L,
                "Textbook", "item1",
                100, "Book", 200,
                1, true, true);
        SalesItem item2 = new SalesItem(new Date(), 2L,
                "Comic Book", "item2",
                50, "Book", 60,
                2, true, false);
        SalesItem item3 = new SalesItem(new Date(), 3L,
                "Children Book", "item3",
                40, "Book", 50,
                3, true, true);
        SalesItem item4 = new SalesItem(new Date(), 4L,
                "Non-fiction", "item4",
                30, "Book", 40,
                4, true, false);
        SalesItem item5 = new SalesItem(new Date(), 5L,
                "Fiction", "item5",
                20, "Book", 30,
                5, true, false);
        SalesItem item5same = new SalesItem(new Date(), 5L,
                "Fiction", "item5",
                20, "Book", 30,
                5, true, false);
        // Create rental item lists.
        RentalItem rentalItem1 = new RentalItem(new Date(), 6L,
                "MacBook", "Electronics1",
                500, "Electronics",
                Condition.EXCELLENT, rentalsArray, 6,
                600, true, false);
        RentalItem rentalItem2 = new RentalItem(new Date(), 7L,
                "iPad", "Electronics2",
                250, "Electronics",
                Condition.EXCELLENT, rentalsArray, 7,
                350, true, false);
        RentalItem rentalItem3 = new RentalItem(new Date(), 8L,
                "iPod", "Electronics3",
                175, "Electronics",
                Condition.EXCELLENT, rentalsArray, 8,
                275, true, false);
        // Check the sales item to see which is equal to each other.
        System.out.println(
                "\nHashcode for item 1: " + item1.hashCode()
                        + "\nHashcode for item 2: " + item2.hashCode()
                        + "\nCompare both items: " + item1.equals(item2)
        );
        System.out.println(
                "\nHashcode for item 2: " + item2.hashCode()
                        + "\nHashcode for item 3: " + item3.hashCode()
                        + "\nCompare both items: " + item2.equals(item3)
        );
        System.out.println(
                "\nHashcode for item 5: " + item5.hashCode()
                        + "\nHashcode for item 5 same: " + item5same.hashCode()
                        + "\nCompare both items: " + item5.equals(item5same)
        );
        // Delete some sale items
        item5 = null;
        System.out.println("\nIs sale item 5 present? "
                + (item5 instanceof SalesItem));
        // Storing the sale items and rental items.
        InventoryItem[] myInventoryItem = {
                item1, item2, item3, item4, item5same,
                rentalItem1, rentalItem2, rentalItem3};
        // Print the list of stored items.
        for (int i = 0; i < myInventoryItem.length; i++) {
            System.out.println("\n" + myInventoryItem[i].toString());
        }
    }
}
