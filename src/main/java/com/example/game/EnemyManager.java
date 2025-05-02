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

    /**
     * Returns this object's enemy arraylist
     * @return enemies arraylist
     */
    public ArrayList<Enemy> getEnemies() {
        return this.enemies;
    }

    public void removeEnemy(int index) {
        enemies.remove(index);
    }

    public void removeEnemy(Enemy enemy) {
        enemies.remove(enemy);
    }

    public boolean isEmpty() {
        return enemies.isEmpty();
    }
}
