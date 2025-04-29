package com.example;

import com.example.game.*;;

public class Main {
    public static void main(String[] args) {
        GameLogic gameLogic = new GameLogic();
        Player player = new Player();

        while (true) {
            gameLogic.update();    
        }
        
    }
}