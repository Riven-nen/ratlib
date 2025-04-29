package com.example.game;


/**
 * The main player class of the package, this will be controlled by the user.
 */
public class Player extends Entity implements Block {

    public Player() {
        this.setAgility(5);
        this.setDefense(5);
        this.setHp(10);
        this.setIntelligence(5);
        this.setStrength(5);
        this.setLevel(1);
    }
    
    /**
     *  Determines how many actions a player 
     *  can do in a single turn.
     */
    private int actionPoint = 3; // Default 3

    /**
     * Increases the action point of the player by 1.
     */
    public void addActionPoint() {
        this.actionPoint++;
    }

    /**
     * Returns the current action point of the player.
     * 
     * @return the action point of the player
     */
    public int getActionPoint() {
        return this.actionPoint;
    }

    /**
     * Decreases the action point of the player by 1.
     */
    public void removeActionPoint() {
        this.actionPoint--;
    }

    /**
     * Sets the action point of the player to the given amount.
     * 
     * @param actionPoint the new amount of action points
     */
    public void setActionPoint(int actionPoint) {
        this.actionPoint = actionPoint;
    }
    /**
     * Player only ability to brace damage. Temporarily raises defense by 4
     * and then calls takeDamage which calls passiveBlock which takes the defense
     * stat to negate damage.
     * 
     * @param damage the amount of hp to deduct
     */
    public void braceDamage(int damage) {
        this.addDefense(4);
        this.takeDamage(damage);
    }
}
