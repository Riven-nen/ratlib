package com.example.game;

public class BattleManager {
    private Player player;
    private EnemyManager enemyManager;
    
    private BattleState battleState = BattleState.PLAYER_TURN;

    public BattleManager(Player player) {
        this.player = player;
        this.enemyManager = new EnemyManager(player.getLevel());
    }
    
    public void update() {
        switch (battleState) {
            case PLAYER_TURN -> {
                // TODO: ADD TURN LOGIC AND TARGETTING
                if (player.getHp() <= 0) {
                    System.out.println("You have lost...");
                    battleState = BattleState.DEFEAT;
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

    public boolean validateState(BattleState battleState) {
        return this.battleState == battleState;
    }
}
