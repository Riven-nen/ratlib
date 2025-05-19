package com.example.library;

public class Member {
    private int id;
    private String name;

    private static int idCounter = 0;

    public Member(String name) {
        this.id = idCounter;
        this.name = name;
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
}
