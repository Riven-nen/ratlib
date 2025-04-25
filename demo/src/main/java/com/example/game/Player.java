package com.example.game;

public class Player extends Entity implements Block {
    

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
