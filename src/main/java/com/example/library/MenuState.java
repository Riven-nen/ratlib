package com.example.library;

import java.util.Scanner;

public class MenuState extends State {
    public MenuState(Menu menu) {
        super(menu);
    }

    public void handle() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Library Management System");
            System.out.println("1. Book Management");
            System.out.println("2. Member Management");
            System.out.println("3. Issue/Return Books");
            System.out.println("4. Reports");
            System.out.println("5. Exit");
            int choice = validateInt();
            
            switch (choice) {
                case 1 -> {
                    // menu.setState();
                }

                case 2 -> {
                    menu.setState(new MemberManagerState(menu));
                    return;
                }
            }
        }
    }
}
