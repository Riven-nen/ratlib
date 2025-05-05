package com.example.game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BattleManager {
    private Player player;
    private EnemyManager enemyManager;
    
    private BattleState battleState = BattleState.PLAYER_TURN;
    private Actions playerAction;

    public BattleManager(Player player) {
        this.player = player;
        this.enemyManager = new EnemyManager(player.getLevel());
    }

    public void display() {
        System.out.print("Player\t\t");
        int counter = 1;
        for (Enemy enemy : enemyManager.getEnemies()) {
            System.out.print("Enemy " + counter + "\t");
            counter++;
        }

        System.out.println();
        System.out.print("Hp: " + player.getHp() + "\t\t");

        // Check first if enemy is dead
        for (Enemy enemy : enemyManager.getEnemies()) {
            if (enemy.isAlive()) {
                System.out.print("Hp: " + enemy.getHp()+ "\t");
            } else {
                System.out.print("Dead\t");
            }
            
        }
        System.out.println();
    }
    
    /**
     * A finite state machine that handles the turn based logic
     */
    public void update() {
        switch (battleState) {
            case PLAYER_TURN -> {
                player.setActionPoint(3);
                if (player.getHp() <= 0) {
                    System.out.println("You have lost...");
                    battleState = BattleState.DEFEAT;
                }
                while (player.getActionPoint() > 0) {
                    if (enemyManager.areEnemiesDead()) {
                        battleState = BattleState.VICTORY;
                        return;
                    }

                    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
                    int choice;
                    while (true) {
                        display();
                        System.out.println("Choose your move " + "- " + player.getActionPoint() + " Action Points -");
                        System.out.println("[1] Attack [2] Defend [3] Cast");
                        try {
                            System.out.print(">> ");
                            choice = Integer.parseInt(bf.readLine());
                            break;
                        } catch (IOException | NumberFormatException e) {
                            System.out.println("Please enter a valid number.");
                        }
                    }

                    switch (choice) {
                        case 1 -> {
                            playerAction = Actions.ATTACK;
                            int targetIndex;
                            while (true) {
                                try {
                                    System.out.print("Target: ");
                                    targetIndex = Integer.parseInt(bf.readLine());
                                    /*
                                        If the target index is less than or equal the size of the
                                        enemy arraylist, then we are sure there will be no out of bounds
                                        exception. (Probably)
                                        EDIT: yeah i forgot to add a condition where it must not be lower than 0
                                        EDIT EDIT: also added a condition that the target index must be alive
                                        getenemies array, get with target index, and then lastly check if alive with isAlive
                                     */ 
                                    if (targetIndex <= enemyManager.getEnemies().size() && targetIndex > 0 && enemyManager.getEnemies().get(targetIndex-1).isAlive()) {
                                        player.attack(enemyManager.getEnemies().get(targetIndex-1));
                                        System.out.println("You hit Enemy " + (targetIndex) + " for " + player.getStrength() + " damage!");
                                        player.removeActionPoint();
                                        break;
                                    } else {
                                        System.out.println("Please enter a valid target!");
                                        continue;
                                    }
                                } catch (IOException | NumberFormatException e) {
                                    System.out.println("Please enter a valid number.");
                                }
                            }
                        }

                        case 2 -> {
                            playerAction = Actions.DEFEND;
                        }
                    }
                }

                if (enemyManager.areEnemiesDead()) {
                    battleState = BattleState.VICTORY;
                    break;
                } else {
                    battleState = BattleState.ENEMY_TURN;
                }
            }

            case ENEMY_TURN -> {
                if (enemyManager.areEnemiesDead()) {
                    battleState = BattleState.VICTORY;
                    return;
                } else {
                    int counter = 0;
                    for (Enemy enemy : enemyManager.getEnemies()) {
                        if (playerAction == Actions.DEFEND) {
                            
                        }
                        enemy.attack(player);
                        System.out.println("Enemy " + counter + "has hit ");
                    }
                }
            }

            case VICTORY -> {
                System.out.println("You win!");
                return;
            }

            case DEFEAT -> {
                
            }
        }
    }

    public void start() {
        while (true) {
            update();
            if (battleState == BattleState.DEFEAT) break;
            if (battleState == BattleState.VICTORY) break;
        }
    }

    public boolean validateState(BattleState battleState) {
        return this.battleState == battleState;
    }
}
