package com.example.game;

import java.util.Random;

public class Enemy extends Entity {
    private Random rand = new Random();
    
    /**
     * Takes the player level and randomly assigns the core stats
     * from 0 to the level of the player.
     * @param level of the player
     */
    public Enemy(int level) {
        this.setHp(rand.nextInt(level)+1);
        this.setAgility(rand.nextInt(level));
        this.setDefense(rand.nextInt(level));
        this.setIntelligence(rand.nextInt(level));
        this.setStrength(rand.nextInt(level));
    }

    /**
     * Checks if the enemy entity is alive
     * @return
     */
    public boolean isAlive() {
        return this.getHp() > 0;
    }


}
