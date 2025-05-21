package com.example.library;

import java.util.ArrayList;

public class Menu {
    private State state;
    private ArrayList<Member> members = new ArrayList<>();

    public void setState(State state) {
        this.state = state;
    }

    public ArrayList<Member> getMembers() {
        return members;
    }

    public void start() {
        state = new MenuState(this);
        state.handle();
    }
}
