package com.example;

import com.example.game.*;;

public class Main {
    public static void main(String[] args) {
        
        Player player = new Player();
        GameLogic gameLogic = new GameLogic(player);

        gameLogic.start();
        
    }
}