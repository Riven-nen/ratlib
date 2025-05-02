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
        for (Enemy enemy : enemyManager.getEnemies()) {
            System.out.print("Enemy\t");
        }
        System.out.println();
        System.out.print("Hp: " + player.getHp() + "\t\t");
        for (Enemy enemy : enemyManager.getEnemies()) {
            System.out.print("Hp: " + enemy.getHp()+ "\t");
        }
        System.out.println();
    }
    
    public void update() {
        display();
        switch (battleState) {
            case PLAYER_TURN -> {
                // TODO: ADD TURN LOGIC AND TARGETTING
                if (player.getHp() <= 0) {
                    System.out.println("You have lost...");
                    battleState = BattleState.DEFEAT;
                }
                while (player.getActionPoint() > 0) {
                    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
                    int choice;
                    while (true) {
                        System.out.println("Choose your move " + "- " + player.getActionPoint() + " Action Points -");
                        System.out.println("[1] Attack [2] Defend [3] Cast");
                        try {
                            choice = Integer.parseInt(bf.readLine());
                            break;
                        } catch (IOException | NumberFormatException e) {
                            System.out.println("Please enter a valid number.");
                        }
                    }

                    switch (choice) {
                        case 1 -> {
                            playerAction = Actions.ATTACK;
                            System.out.print("Target: ");
                            int targetIndex;
                            while (true) {
                                try {
                                    targetIndex = Integer.parseInt(bf.readLine());
                                    break;
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

                battleState = BattleState.ENEMY_TURN;
            }

            case ENEMY_TURN -> {
                if (enemyManager.isEmpty()) {
                    battleState = BattleState.VICTORY;
                } else {
                    for (Enemy enemy : enemyManager.getEnemies()) {
                        if (enemy.getHp() <= 0) {
                            enemyManager.removeEnemy(enemy);
                        }
                    }
                }
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
