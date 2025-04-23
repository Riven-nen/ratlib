package com.example.pos;

public class Product {
    private int id;
    private String name;
    private int price;
    private int stock;
    private static int idCount = 0;

    /**
     * Returns the name of the product
     * @return the name of the product
     */
    @Override
    public String toString() {
        return name;
    }

    /**
     * Instantiates a new Product object
     * @param name Name of product object
     * @param price Price of product object
     * @param stock Stock of product object
     */
    public Product(String name, int price, int stock) {
        id = ++idCount;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    /**
     * @return the ID of the product
     */
    public int getID() {
        return id;
    }

    /**
     * @return the name of the product
     */
    public String getName() {        
        return name;
    }


    /**
     * @return the price of the product
     */
    public int getPrice() {        
        return price;
    }

    /**
     * @return the stock of the product
     */
    public int getStock() {        
        return stock;
    }

    /**
     * Sets the ID of the product
     * @param ID the new ID of the product
     */
    public void setID(int ID) {
        this.id = ID;
    }    

    /**
     * Sets the name of the product
     * @param name the new name of the product
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the price of the product
     * @param price the new price of the product
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Sets the stock of the product
     * @param stock the new stock of the product
     */
    public void setStock(int stock) {
        this.stock = stock;
    }
}
