package com.example.game;

public class BattleManager {
    private Player player;
    private EnemyManager enemyManager;

    public BattleManager(Player player) {
        this.player = player;
        this.enemyManager = new EnemyManager(player.getLevel());
    }

    
    
}
