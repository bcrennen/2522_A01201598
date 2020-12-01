package ca.bcit.comp2522.labs.lab06;
/**
 * Resources class for a 2D object.
 *
 * @author brennen
 * @version 2020
 * */
public class Resources {
    /**Name of the level.*/
    private String levelName;
    /**Level number.*/
    private int levelNumber;
    /**X-coor for 2D object.*/
    private int x;
    /**Y-coor for 2D object.*/
    private int y;
    /**Player's health.*/
    private int playerHealth;
    /**Health Bar of player.*/
    private int healthBar;
    /**Enemies Alive.*/
    private int enemiesAlive;
    /**
     * Constructor for resources.
     *
     * @param newLevelName for level name.
     * @param newLevelNumber  for level number.
     * @param newX for x-coor.
     * @param newY for y-coor.
     * @param newPlayerHealth for player's health.
     * @param newHealthBar for health bar.
     * @param newEnemiesAlive for enemies alive.
     * */
    public Resources(final String newLevelName, final int newLevelNumber,
                     final int newX, final int newY,
                     final int newPlayerHealth,
                     final int newHealthBar, final int newEnemiesAlive) {
        this.levelName = newLevelName;
        this.levelNumber = newLevelNumber;
        this.x = newX;
        this.y = newY;
        this.playerHealth = newPlayerHealth;
        this.healthBar = newHealthBar;
        this.enemiesAlive = newEnemiesAlive;
    }
    /**
     * Getter for level name.
     * @return levelName
     * */
    public String getLevelName() {
        return levelName;
    }
    /**
     * Setter for level name.
     * @param newLevelName
     * */
    public void setLevelName(final String newLevelName) {
        this.levelName = newLevelName;
    }
    /**
     * Getter for level number.
     * @return levelNumber
     * */
    public int getLevelNumber() {
        return levelNumber;
    }
    /**
     * Setter for level number.
     * @param newLevelNumber
     * */
    public void setLevelNumber(final int newLevelNumber) {
        this.levelNumber = newLevelNumber;
    }
    /**
     * Getter for x-coor.
     * @return x
     * */
    public int getX() {
        return x;
    }
    /**
     * Setter for x-coor.
     * @param xC
     * */
    public void setX(final int xC) {
        this.x = xC;
    }
    /**
     * Getter for y-coor.
     * @return y
     * */
    public int getY() {
        return y;
    }
    /**
     * Setter for y-coor.
     * @param yC
     * */
    public void setY(final int yC) {
        this.y = yC;
    }
    /**
     * Getter for player health.
     * @return playerHealth
     * */
    public int getPlayerHealth() {
        return playerHealth;
    }
    /**
     * Setter for player's health between 0 - 100.
     * @param newPlayerHealth
     * */
    public void setPlayerHealth(final int newPlayerHealth) {
        if (newPlayerHealth >= 0 && newPlayerHealth <= 100) {
            this.playerHealth = newPlayerHealth;
        }
    }
    /**
     * Getter for health bar.
     * @return healthBar
     * */
    public int getHealthBar() {
        return healthBar;
    }
    /**
     * Setter for health bar.
     * @param newHealthBar
     * */
    public void setHealthBar(final int newHealthBar) {
        this.healthBar = newHealthBar;
    }
    /**
     * Getter for enemies alive.
     * @return enemiesAlive
     * */
    public int getEnemiesAlive() {
        return enemiesAlive;
    }
    /**
     * Setter for enemies alive.
     * @param newEnemiesAlive
     * */
    public void setEnemiesAlive(final int newEnemiesAlive) {
        if (newEnemiesAlive < 0) {
            this.enemiesAlive = 0;
        } else if (newEnemiesAlive > 100) {
            this.enemiesAlive = 100;
        } else {
            this.enemiesAlive = newEnemiesAlive;
        }
    }
}
