package com.example.game;

public class BattleManager {
    private Player player;
    private EnemyManager enemyManager;
    
    private Battle battle = Battle.PLAYER_TURN;

    public BattleManager(Player player) {
        this.player = player;
        this.enemyManager = new EnemyManager(player.getLevel());
    }
    
    public void update() {
        switch (battle) {
            case PLAYER_TURN -> {
                if (player.getHp() <= 0) {
                    battle = Battle.DEFEAT;
                }
                while (player.getActionPoint() > 0) {

                }
            }

            case ENEMY_TURN -> {
                
            }

            case VICTORY -> {

            }

            case DEFEAT -> {
                
            }
        }
    }
}
