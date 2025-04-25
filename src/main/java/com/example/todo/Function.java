package com.example.todo;

import java.util.ArrayList;

public class Function {
    private ArrayList<String> tasks = new ArrayList<>();

    public void addTask(String task) {
        tasks.add(task);
    }

    public void deleteTask(int index) {
        tasks.remove(index);
    }

    public ArrayList<String> getTask() {
        return tasks;
    }
    
}
