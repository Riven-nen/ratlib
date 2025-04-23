package com.example.atm;

public class User {
    private String name;
    private String pin;

    public User(String name, String pin) {
        this.name = name;
        this.pin = pin;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return pin;
    }

    public void setPassword(String pin) {
        this.pin = pin;
    }

    public void setName(String name) {
        this.name = name;
    }

    
}
