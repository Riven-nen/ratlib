package com.example.classes;
import java.util.ArrayList;

public interface Inventory<T> {
    void add(T item);
    void drop(String name);
    ArrayList<T> getInventory();
}
