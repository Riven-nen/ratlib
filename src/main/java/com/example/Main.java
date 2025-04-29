package com.example;

import com.example.game.*;;

public class Main {
    public static void main(String[] args) {
        GameLogic gameLogic = new GameLogic();

        while (!gameLogic.validateGameState(GameState.EXIT_GAME)) {
            gameLogic.update();    
        }
        
    }
}