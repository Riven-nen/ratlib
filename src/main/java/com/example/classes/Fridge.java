package com.example.classes;

import java.util.ArrayList;

public class Fridge implements Inventory<Food> {

    ArrayList<Food> inventory = new ArrayList<>();


    public Fridge() {}

    public Fridge(Food food) {
       inventory.add(food); 
    }

    public Fridge(ArrayList<Food> foods) {
        this.inventory.addAll(foods);
        
    }

    @Override
    public void add(Food food) {
        this.inventory.add(food);
    }

    public void add(ArrayList<Food> foods) {
        this.inventory.addAll(foods);
    }

    @Override
    public void drop(String name) {
        this.inventory.removeIf(n -> n.getName().equals(name)); 
    }

    @Override
    public ArrayList<Food> getInventory() {
        return this.inventory;
    }
}
