package com.example.pos;

import java.util.ArrayList;

public class POSManager {
    /**
     * Initialize products and cart variable
     * products contains the inventory of the POS
     * cart contains the items to buy by the user
     */
    private ArrayList<Product> products = new ArrayList<>();

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

}
