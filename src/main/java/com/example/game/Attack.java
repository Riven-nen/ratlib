package com.example.game;

public interface Attack {
    void attack(Entity entity);
    boolean takeDamage(int amount);
}
