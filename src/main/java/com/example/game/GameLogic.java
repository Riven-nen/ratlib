package com.example.game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameLogic {
    
    private Player player;

    public GameLogic(Player player) {
        this.player = player;
    }
    
    private GameState gameState = GameState.START_GAME;

    public void update() {
        switch (gameState) {
            case START_GAME -> {
                
                System.out.print("Starting game");
                // This is just for loading Starting game...
                for (int i = 0 ; i <= 2 ; i++) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.print(".");
                }
                System.out.println();
                // After displaying the message change the state to menu
                gameState = GameState.MENU_SCREEN;

            }

            /**
             * This is where the user will choose options
             * First initialize a bufferedreader to read from the system input
             * Next a while loop to validate the input is an integer
             * Lastly handle the choice with a switch statement,
             * if choice is not 1, 2, or 3 then it will just update again
             * since the gamestate is still menu_screen they will be prompted to
             * choose again.
             */ 
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
                        this.gameState = GameState.START_COMBAT;
                    }

                    case 2 -> {
                        System.out.println("Nothing here yet.");
                    }
                    
                    case 3 -> {
                        this.gameState = GameState.EXIT_GAME;
                    }

                    default -> {
                        System.out.println("Invalid Choice!");
                    }
                }
            }

            /**
             *  transition to battle mode - i probably should remove this
             * it doesnt really do anything lmao lmao lmao
             */
            case START_COMBAT -> {
                gameState = GameState.BATTLE;
            }

            case BATTLE -> {
                BattleManager battleManager = new BattleManager(player);
                battleManager.start(); 
                gameState = GameState.MENU_SCREEN;     
            }

            case EXIT_GAME -> {
                System.out.println("Exiting...");  
                System.exit(0);
            }
        }
    }

    /**
     * NOTE: MIGHT DEPRECATE THIS, MIGHT NOT BE NEEDED
     * balls
     * Compares the current GameState with the given GameState.
     *
     * @param gameState The GameState to compare with.
     * @return True if the GameStates are equal, false otherwise.
     */
    public boolean validateState(GameState gameState) {
        return this.gameState == gameState;
    }

    public void start() {
        while (true) {
            update();
        }
    }
}
