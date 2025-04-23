package com.example.pos;

import java.util.ArrayList;

public class AuthManager {
    private ArrayList<User> users = new ArrayList<>();
    private User currUser;

    /**
     * Creates a new AuthManager object
     */
    public AuthManager() {

    }

    /**
     * Returns a list of all users that have been registered.
     * @return a list of users
     */
    public ArrayList<User> getUsers() {
        return users;
    }

    /**
     * Registers a new user with the given name and password.
     *
     * @param name the name of the user to register
     * @param password the password for the user
     */
    public void registerUser(String name, String password) {
        users.add(new User(name, password));
    }

    /**
     * Logs in a user with the given name and password.
     *
     * @param name the name of the user to log in
     * @param password the password for the user
     */
    public void login(String name, String password) {

        for (User user : users) {
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

    /**
     * Logs out the current user by setting currUser to null.
     * If there is no current user, does nothing.
     */
    public void logout() {
        if (currUser == null) {
            System.out.println("You are already logged out.");
            return;
        }

        System.out.println("Logout successful. Goodbye!");
        currUser = null;
    }

    /**
     * Checks if there is a currently logged-in user
     * this can be checked if the currUser is not null
     * meaning there is a current user.
     *
     * @return true if a user is logged in, false otherwise
     */
    public boolean isLoggedIn() {
        return currUser != null;
    }

    /**
     * Returns the currently logged-in user.
     * If there is no current user (i.e. isLoggedIn() is false),
     * returns null.
     *
     * @return the currently logged-in user, or null if none
     */
    public User getUser() {
        return currUser;
    }

    /**
     * Prompts the user to confirm the given password by re-entering it.
     * Continues to prompt until the entered password matches the given password.
     *
     * @param password the password to be confirmed
     * @return true once the password is successfully confirmed
     */
    public boolean confirmPassword(String password) {
        String confirmPassword = null;
        while (!password.equals(confirmPassword)) {
            System.out.print("Confirm Password: ");
            confirmPassword = new String(System.console().readPassword());
            System.out.println("Passwords do not match.");
        }

        return true;
    }
}
