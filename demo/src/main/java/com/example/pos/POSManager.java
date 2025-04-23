package com.example.pos;

import java.util.ArrayList;

public class POSManager {
    /**
     * Initialize products and cart variable
     * products contains the inventory of the POS
     * cart contains the items to buy by the user
     */
    private ArrayList<Product> products = new ArrayList<>();

    // Side note: if cart is handled by another class and updated it will
    // still work because adding objects to an ArrayList keeps a reference
    // and not a new instantiation of an object.
    private ArrayList<CartItem> cart = new ArrayList<>();

    class CartItem {
        private Product product;
        private int quantity;

        CartItem(Product product, int quantity) {
            this.product = product;
            this.quantity = quantity;
        }

        Product getProduct() {
            return this.product;
        }

        int getQuantity() {
            return this.quantity;
        }
    }

    /**
     * Adds a product to the inventory
     * @param product product to add
     */
    public void addProduct(Product product) {
        products.add(product);
    }

    /**
     * Returns a list of all products in the inventory
     * @return a list of products
     */
    public ArrayList<Product> getProducts() {
        return products;
    }

    /**
     * Removes a product from the inventory
     * @param product product to remove
     */
    public void removeProduct(Product product) {
        products.remove(product);
    }

    /**
     * Removes a product from the inventory by index
     * @param index index of product to remove
     */
    public void removeProduct(int index) {
        products.remove(index);
    }

    /**
     * Removes a product from the inventory by name
     * @param name name of product to remove
     */
    public void removeProduct(String name) {
        for (Product product : products) {
            if (product.getName().equals(name)) {
                products.remove(product);
                break;
            }
        }
    }

    /**
     * Checks if the given product is null.
     * 
     * @param product the product to check
     * @return true if the product is null, false otherwise
     */
    public boolean isProductNull(Product product) {
        return product == null;
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
        // Check if the stock of the product is > 0 then just add it to the cart
        // for the transaction class to handle
        if (product.getStock() > 0) {
           cart.add(new CartItem(product, quantity)) ;
        }
    }

    /**
     * Removes a product from the cart if it exists in the cart.
     * 
     * @param product the product to remove from the cart
     */
    public void removeFromCart(Product product) {
        for (CartItem cItem : cart) {
            if (cItem.getProduct().equals(product)) {
                cart.remove(cItem);
            }
        }
     }

     public void removeFromCart(CartItem cartItem) {
        cart.remove(cartItem);
     }

    /**
     * Returns the current items in the cart
     * @return a list of products in the cart
     */
    public ArrayList<CartItem> getCart() {
        return cart;
    }

    /**
     * Removes all items from the cart.
     */
    public void clearCart() {
        cart.clear();
    }
}
