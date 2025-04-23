package com.example.pos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Transaction {

    // Side note: if cart is handled by another class and updated it will
    // still work because adding objects to an ArrayList keeps a reference
    // and not a new instantiation of an object.
    private ArrayList<Map<Product,Integer>> cart = new ArrayList<>();

    private ArrayList<Map<Product,Integer>> log = new ArrayList<>();

    /**
     * Checks if the given product is null.
     * 
     * @param product the product to check
     * @return true if the product is null, false otherwise
     */
    public boolean isProductNull(Product product) {
        return product == null;
    }

    // function to check if the product already exists in the arraylist
    public boolean isProductInCart(Product product) {
        for (Map<Product,Integer> item : cart) {
            for (Product entry : item.keySet()) {
                if (entry.equals(product)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Adds a product to the cart if it is not null and has more than 0 stock
     * @param product product to add to the cart
     */
    public void addToCart(Product product,int quantity) {
        // Check first if its null then just print an error and break out of method
        if (isProductNull(product)) {
            System.out.println("The selected product is null.");
            return;
        }

        if (isProductInCart(product)) {
            System.out.println("Product is already in cart!");
            return;
        }

        // Check if the stock of the product is > 0 then just add it to the cart
        // for the transaction class to handle
        if (product.getStock() > 0 ) {
           Map<Product,Integer> item = new HashMap<>();
           item.put(product, quantity);
           cart.add(item);
        } 
    }

    /**
     * Prints the list of items in the cart, and their prices.
     */
    public void listCart(ArrayList<Map<Product,Integer>> cart) {
        if (cart.isEmpty()) {
            System.out.println("Cart is Empty!");
        }

        for (Map<Product,Integer> item : cart) {
            for (Map.Entry<Product,Integer> entry : item.entrySet()) {
                System.out.println(entry.getKey().getName()
                + "\t Php" + entry.getKey().getPrice()
                + " x" + entry.getValue());
            }

        }
    }

    /**
     * Prints the total sum of the price by iterating through
     * the cart list and adding the product of price and quantity 
     * to the variable total for every iteration
     */
    public int total(ArrayList<Map<Product,Integer>> cart) {
        int total = 0;
        for (Map<Product,Integer> item : cart) {
            for (Map.Entry<Product,Integer> entry : item.entrySet()) {
                total = (total + entry.getKey().getPrice()) * entry.getValue();
            }
       }

        return total;
    }

    /**
     * Stores the current contents of the cart in the log and clears the cart.
     * The log is a list of lists, where each inner list represents a transaction.
     * The inner lists contain the products purchased and the quantity of each 
     * product purchased in the transaction.
     */
    public void log() {
        for (Map<Product,Integer> item : cart) {
            log.add(item);
        }
        clearCart();
    }

    /**
     * Removes a product from the cart if it exists in the cart.
     * 
     * @param product the product to remove from the cart
     */
    public void removeFromCart(Product product) {
        for (Map<Product,Integer> item : cart) {
            for (Map.Entry<Product,Integer> entry : item.entrySet()) {
                if (entry.getKey().equals(product)) {
                    cart.remove(item);
                }
            }
        }
     }

    /**
     * Returns the current items in the cart
     * @return a list of products in the cart
     */
    public ArrayList<Map<Product,Integer>> getCart() {
        return cart;
    }

    /**
     * Removes all items from the cart.
     */
    public void clearCart() {
        cart.clear();
    }

    public void printLog() {
        listCart(log);
        System.out.println("Total = " + total(log));
    }
}
