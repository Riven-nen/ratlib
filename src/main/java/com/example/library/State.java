package com.example.library;

import java.util.Scanner;

public abstract class State {
    protected Menu menu;

    public State(Menu menu) {
        this.menu = menu;
    }

    public abstract void handle(); // Handle logic

    /**
     * Utility method
     */
    public int validateInt() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                int toValidate = sc.nextInt();
                sc.nextLine();
                return toValidate;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a correct number!");
            } finally {
                sc.close();
            }
        }
    }
}
