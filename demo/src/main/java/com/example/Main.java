package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;

import com.example.pos.*;

public class Main {
    
    /**
     * Reads an integer from the console input.
     * If a prompt string is provided, it is displayed before reading the input.
     * 
     * @param string optional prompt to display before reading input
     * @return the integer value obtained from the console input
     * @throws IOException if an I/O error occurs
     */
    public static int consoleInt(String... string) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        if (string.length > 0) {
            System.out.print(string[0]);
            return Integer.parseInt(bf.readLine());
        } else {
            System.out.print(">> ");
            return Integer.parseInt(bf.readLine());
        }
    }

    /**
     * Reads a string from the console input.
     * If a prompt string is provided, it is displayed before reading the input.
     * 
     * @param string optional prompt to display before reading input
     * @return the string value obtained from the console input
     * @throws IOException if an I/O error occurs
     */
    public static String consoleString(String... string) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        if (string.length > 0) {
            System.out.print(string[0]);
            return bf.readLine();
        } else {
            System.out.print(">> ");
            return bf.readLine();
        }
    }

    public static void main(String[] args) throws IOException {
        
        POSManager posManager = new POSManager();

        posManager.addProduct(new Product("Laptop", 1000, 50));
        posManager.addProduct(new Product("Monitor", 500, 100));
        posManager.addProduct(new Product("Keyboard", 100, 200));
        posManager.addProduct(new Product("Mouse", 50, 300));

        AuthManager authManager = new AuthManager();
        // debug purposes - comment out
        authManager.registerUser("mau","mau");
        Transaction transaction = new Transaction();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        while (!authManager.isLoggedIn()) {
            System.out.println("------------------------------------------------------ " + LocalTime.now().withNano(0));
            System.out.println("\r\n" + //
                                "  _____   ____   _____      _____           _                 \r\n" + //
                                " |  __ \\ / __ \\ / ____|    / ____|         | |                \r\n" + //
                                " | |__) | |  | | (___     | (___  _   _ ___| |_ ___ _ __ ___  \r\n" + //
                                " |  ___/| |  | |\\___ \\     \\___ \\| | | / __| __/ _ \\ '_ ` _ \\ \r\n" + //
                                " | |    | |__| |____) |    ____) | |_| \\__ \\ ||  __/ | | | | |\r\n" + //
                                " |_|     \\____/|_____/    |_____/ \\__, |___/\\__\\___|_| |_| |_|\r\n" + //
                                "                                   __/ |                      \r\n" + //
                                "                                  |___/        source by mau  \r\n" + //
                                "");
            System.out.println("[1] Register\t[2] Login\t[3] Exit");

            int choice = 0;
            
            try {
                choice = consoleInt();
            } catch (Exception e) {
                System.out.println("Please enter a valid number.");
            }
            
            switch (choice) {
                case 1:
                    System.out.println("\nRegister User");

                    try {
                        System.out.print("Name: ");
                        String name = bf.readLine();
                        System.out.print("Password: ");

                        // Linux-like password reader that blanks the console
                        String password = new String(System.console().readPassword());
                        authManager.confirmPassword(password);
                        
                        authManager.registerUser(name, password);
                    } catch (Exception e) {
                        System.out.println("Something went wrong registering.");
                    }
                    
                    break;

                case 2:
                    System.out.println("\nLogin User");

                    try {
                        System.out.print("Name: ");
                        String name = bf.readLine();
                        System.out.print("Password: ");
                        String password = new String(System.console().readPassword());

                        authManager.login(name, password);

                    } catch (Exception e) {
                        System.out.println("Something went wrong logging in.");
                    }
                    break;

                case 3:
                    System.out.println("Goodbye.");
                    System.exit(0);
                    break;         

                default:
                    System.out.println("Invalid choice.");
                    continue;
            }
            
            while (authManager.isLoggedIn()) {
                System.out.println("---------------------------------------------------------------- " + LocalTime.now().withNano(0));
                System.out.println("Welcome " + authManager.getUser().getName());
                System.out.println("[1] Add Product\t\t[2] View Products\t[3] Create Transactions\n[4] View Sales Summary\t[5] Update Product\t[6] Delete Product\n\n[0] Logout");
                int subMenuChoice = consoleInt();

                switch (subMenuChoice) {
                    case 0:
                        authManager.logout();
                        break;
                        
                    case 1:
                        System.out.println("Add product");
                        System.out.println("Product Name:");
                        String productName = consoleString();
                        System.out.println("Product Price:");
                        int productPrice = consoleInt();
                        System.out.println("Product Stock");
                        int productStock = consoleInt();

                        posManager.addProduct(new Product(productName,productPrice,productStock));
                        break;

                    case 2:
                        posManager.printProducts();
                        break;

                    case 3:
                        posManager.printProducts();

                        boolean checkout = false;
                        int chooseId = 0;

                        while (!checkout) {
                            System.out.println("Enter the ID of the item.\t\t Enter 0 to checkout.");
                            
                            chooseId = consoleInt();

                            for (Product product : posManager.getProducts()) {
                                if (product.getID() == chooseId) {
                                    System.out.println("How many " + product.getName() + " to buy?");
                                    int qty = consoleInt();
                                    transaction.addToCart(product, qty);
                                } else if (chooseId == 0) {
                                    System.out.println("Checking out...");
                                    System.out.println("The total is " + transaction.total(transaction.getCart()));
                                    checkout = true;
                                    transaction.log();
                                    break;
                                }
                            }                            
                        }

                        
                        break;
                    case 4:
                        transaction.printLog();
                        break;

                    case 5:
                        posManager.printProducts();

                        int chooseProduct = consoleInt();

                        for (Product product : posManager.getProducts()) {
                            if (product.getID() == chooseProduct) {
                                System.out.println("New Name:");
                                String name = consoleString();
                                System.out.println("New Price:");
                                int price = consoleInt();
                                System.out.println("New Stock:");
                                int stock = consoleInt();
                                product.setName(name);
                                product.setPrice(price);
                                product.setStock(stock);
                                break;
                            }
                        }

                        System.out.println("Invalid id");
                        break;
                        
                    case 6:
                        posManager.printProducts();

                        System.out.println("Select id to delete:");
                        int deleteId = consoleInt();

                        for (Product product : posManager.getProducts()) {
                            if (product.getID() == deleteId) {
                                posManager.removeProduct(product);
                            }
                        }

                    default:
                        System.out.println("Invalid choice.");
                        continue;
                }
            }
        }
    }   
}