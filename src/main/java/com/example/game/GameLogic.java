package com.example.game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameLogic {
    
    private GameState gameState = GameState.START_GAME;

    public void update() {
        switch (gameState) {
            case START_GAME -> {
                
                // This is just for loading Starting game...
                for (int i = 0 ; i <= 3 ; i++) {
                    StringBuilder sb = new StringBuilder("Starting game.");
                    for (int j = 0 ; j < i ; j++) {
                        sb.append(".");
                    }
                    System.out.println(sb.toString());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // After displaying the message change the state to menu
                gameState = GameState.MENU_SCREEN;

            }

            case MENU_SCREEN -> {
                BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
                
                System.out.println("[1] New Game\n[2] Multiplayer\n[3] Exit Game");

                // Needs to be outside to access this outside of the while loop scope
                int choice;

                // Validates choice input to only be int
                while (true) {
                    try {
                        choice = Integer.parseInt(bf.readLine());
                        break;
                    } catch (IOException | NumberFormatException e) {
                        System.out.println("Please input a valid number!");
                    }
                }
                
                switch (choice) {
                    case 1 -> {
                        System.out.println("Nothing here yet.");
                    }

                    case 2 -> {
                        System.out.println("Nothing here yet.");
                    }
                    
                    case 3 -> {
                        this.gameState = GameState.EXIT_GAME;
                    }
                }
            }

            case START_COMBAT -> {
                gameState = GameState.PLAYER_TURN;
            }

            case PLAYER_TURN -> {
                System.out.println("Player Turn");
            }

            case ENEMY_TURN -> {
                
            }

            case VICTORY -> {

            }

            case DEFEAT -> {
                
            }

            case EXIT_GAME -> {
                System.out.println("Exiting...");  
                System.exit(0);
            }
        }
    }

    /**
     * Compares the current GameState with the given GameState.
     *
     * @param gameState The GameState to compare with.
     * @return True if the GameStates are equal, false otherwise.
     */
    public boolean validateGameState(GameState gameState) {
        return this.gameState == gameState;
    }
}
