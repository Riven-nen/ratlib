package com.example.game;

public class GameLogic {
    
    private GameState gameState = GameState.START_COMBAT;

    public void update() {
        switch (gameState) {
            case START_COMBAT -> {
                System.out.println("Combat starts");
                gameState = GameState.PLAYER_TURN;
            }

            case PLAYER_TURN -> {
                System.out.println("Player Turn");
            }

            case ENEMY_TURN -> {
                
            }

            default -> {
                
            }
        }
    }

    public GameState getGameState() {
        return this.gameState;
    }
}
