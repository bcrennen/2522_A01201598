package ca.bcit.comp2522.labs.lab06;


import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.Serializable;
import java.util.ArrayList;

public class Sprite implements Serializable {
    /**X-Coordinates for the 2D object.*/
    private int xCoordinates;
    /**Y-Coordinates for the 2D object.*/
    private int yCoordinates;
    /**Health for the 2D object.*/
    private int health;
    /**Gravity for the 2D object.*/
    private transient float gravity;
    /**Weapon list for the 2D object.*/
    private ArrayList<String> weapons;
    /**Pixel data for the 2D object.*/
    private byte[] pixelData;
    /**
     * Method for getting image data.
     * @param image for a 2D object
     * @param newXCoordinates for a 2D object
     * @param newYCoordinates for a 2D object
     * @param newHealth for health of a 2D object
     * @param newGravity for gravity of a 2D object environment
     * @param newWeapons for a 2D object
     * */
    public Sprite(final BufferedImage image,
                  final int newXCoordinates,
                  final int newYCoordinates,
                  final int newHealth,
                  final float newGravity,
                  final ArrayList<String> newWeapons) {
        pixelData = ((DataBufferByte)
                image.getRaster().getDataBuffer()).getData();
        this.xCoordinates = newXCoordinates;
        this.yCoordinates = newYCoordinates;
        this.health = newHealth;
        this.gravity = newGravity;
        this.weapons = newWeapons;
    }
    /**
     * Getter for pixel data.
     * @return pixelData
     * */
    public byte[] getPixelData() {
        return pixelData;
    }
    /**
     * Getter for x-Coordinates of a 2D image.
     * @return xCoordinates
     * */
    public int getXCoordinates() {
        return xCoordinates;
    }
    /**
     * Getter for y-Coordinates of a 2D image.
     * @return yCoordinates
     * */
    public int getYCoordinates() {
        return yCoordinates;
    }
    /**
     * Getter for health of a 2D image.
     * @return yCoordinates
     * */
    public int getHealth() {
        return health;
    }
    /**
     * Getter for gravity of a 2D image.
     * @return gravity
     * */
    public float getGravity() {
        return gravity;
    }
    /**
     * Getter for a list of weapons of a 2D image.
     * @return weapons
     * */
    public ArrayList<String> getWeapons() {
        return weapons;
    }
    /**
     * Setter for x-Coordinates of a 2D image.
     * @param newXCoordinates
     * */
    public void setXCoordinates(final int newXCoordinates) {
        this.xCoordinates = newXCoordinates;
    }
    /**
     * Setter for y-Coordinates of a 2D image.
     * @param newYCoordinates
     * */
    public void setYCoordinates(final int newYCoordinates) {
        this.yCoordinates = newYCoordinates;
    }
    /**
     * Setter for health of a 2D image.
     * @param newHealth
     * */
    public void setHealth(final int newHealth) {
        if (newHealth >= 0 && newHealth <= 100) {
            this.health = newHealth;
        }
    }
    /**
     * Setter for gravity of a 2D image.
     * @param newGravity
     * */
    public void setGravity(final float newGravity) {
        this.gravity = newGravity;
    }
    /**
     * Setter for list of weapons of a 2D image.
     * @param newWeapons
     * */
    public void setWeapons(final ArrayList<String> newWeapons) {
        this.weapons = newWeapons;
    }
    /**
     * Setter for pixel data of a 2D image.
     * @param newPixelData
     * */
    public void setPixelData(final byte[] newPixelData) {
        this.pixelData = newPixelData;
    }
}
