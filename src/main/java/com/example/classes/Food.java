package com.example.classes;

public class Food {
    private int calories;
    private String name;

    public Food(String name) {
        this.name = name;
    }
    
    public void setCalories(int calories) {
        this.calories = calories;
    }
    public int getCalories() {
        return this.calories;
    }

    public String getName() {
        return this.name;
    }
}
