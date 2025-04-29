package com.example.game;

import java.util.ArrayList;
import java.util.Random;

public class EnemyManager {
    private ArrayList<Enemy> enemies = new ArrayList<>();
    private Random rand;

    public EnemyManager(int level) {
        for (int i = rand.nextInt(level)+1; i >= 0; i--) {
            enemies.add(new Enemy(level));
        }
    }
}
