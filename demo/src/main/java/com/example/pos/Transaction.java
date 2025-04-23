package com.example.pos;

import java.util.ArrayList;

import com.example.pos.POSManager.CartItem;

public class Transaction {

    private ArrayList<CartItem

    /**
     * Prints the list of items in the cart, and their prices.
     * @param cart the cart to print
     */
    public void listCart(ArrayList<CartItem> cart) {
        if (cart.isEmpty()) {
            System.out.println("Cart is Empty!");
        }

        for (CartItem product : cart) {
            System.out.println(product.getProduct().getName()
                                + "\t Php" + product.getProduct().getPrice()
                                + " x" + product.getQuantity());
        }
    }

    /**
     * Prints the total sum of the price by iterating through
     * the cart list and adding the product of price and quantity 
     * to the variable total for every iteration
     * @param cart
     */
    public int total(ArrayList<CartItem> cart) {
        int total = 0;
        for (CartItem cItem : cart) {
            total = (total + cItem.getProduct().getPrice()) * cItem.getQuantity();
        }

        return total;
    }

    public ArrayList<CartItem> log(ArrayList<CartItem> cart) {
        for (CartItem cartItem : cart) {

        }
    }
}
