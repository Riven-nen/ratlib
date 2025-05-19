package com.example.library;

public class Book {
    private String name;
    private int id;
    private Status status;

    private static int idCounter = 0;

    public Book(String name) {
        this.id = ++idCounter;
        this.name = name;
        this.status = Status.AVAILABLE;
    } 

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }

    public void setStatus(Status status) {
        this.status = status;
    } 

    public Status geStatus() {
        return this.status;
    }
}
