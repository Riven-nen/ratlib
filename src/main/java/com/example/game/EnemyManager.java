package com.example.game;

import java.util.ArrayList;
import java.util.Random;

public class EnemyManager {
    private ArrayList<Enemy> enemies = new ArrayList<>();
    private Random rand = new Random();

    /**
     * Takes the player level as the bound of a random
     * number generator to generate between at least 1 to the level
     * of the player
     * @param level level of the player
     */
    public EnemyManager(int level) {
        for (int i = rand.nextInt(level)+1; i >= 0; i--) {
            enemies.add(new Enemy(level));
        }
    }

    // For debug
    public EnemyManager() {

    }

    /**
     * Returns this object's enemy arraylist
     * @return enemies arraylist
     */
    public ArrayList<Enemy> getEnemies() {
        return this.enemies;
    }

    /**
     * Iterates through the enemies and checks if all enemy
     * objects are dead
     * @return true if all enemies in the list are dead, else false.
     */
    public boolean areEnemiesDead() {
        int counter = 0;
        for (Enemy enemy : enemies) {
            if (!enemy.isAlive()) {
                counter++;
            }
        }

        return counter == enemies.size();
    }

    public boolean areEnemiesDead(ArrayList<Enemy> enemies) {
        int counter = 0;
        for (Enemy enemy : enemies) {
            if (!enemy.isAlive()) {
                counter++;
            }
        }

        return counter == enemies.size();
    }
}
