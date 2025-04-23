package com.example.pos;

public class User {
    private String name;
    private String password;

    // Constructor
    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    /**
     * @return the name of the user
     */
    public String getName() {
        return name;
    }

    /**
     * @return the password of the user
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password for the user.
     * @param password the new password to set
     */

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Sets the name for the user.
     * @param name the new name to set
     */
    public void setName(String name) {
        this.name = name;
    }
}
