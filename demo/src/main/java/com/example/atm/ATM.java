package com.example.atm;

import java.util.ArrayList;

public class ATM {
    static private ArrayList<User> userlist = new ArrayList<>();

    private User currUser;

    public ATM() {

    }

    public ATM(User user) {
        userlist.add(user);
    }

    public boolean isUserEmpty() {
        return userlist.isEmpty();
    }

    public void addUser(User user) {
        userlist.add(user);
    }

    public void login(String name, String password) {

        for (User user : userlist) {
            if (user.getName().equals(name) && user.getPassword().equals(password)) {
                this.currUser = user;
                System.out.println("Logged in as " + this.currUser.getName());
                break;
            }
        }
        if (currUser == null) {
            System.out.println("User does not exist, or invalid credentials.");
        }

    }

    public User getUser() {
        return this.currUser;
    }

    public void logout() {
        System.out.println("Logout successful. Goodbye!");
        currUser = null;
    }   

    

}
