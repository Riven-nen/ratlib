package com.example.library;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberManagerState extends State implements Manager<Member> {
    
    private ArrayList<Member> members;

    public MemberManagerState(Menu menu) {
        super(menu);
        this.members = menu.getMembers();
    }

    public boolean isInMembers(Member member) {
        return members.contains(member);
    }

    public void add(Member member) {
        members.add(member);
    }

    public void view() {
        System.out.println("ID\tName");
        for (Member member : members) {
            System.out.printf("%d\t%s\n",member.getId(),member.getName());
        }
    }
    
    public int search(Member member) {
        return members.indexOf(member);
    }

    public boolean delete(Member member) {
        return members.remove(member);
    }

    public void back() {

    }

    public void update(Member member, String name) {
        if (!isInMembers(member)) {
            System.out.println("Member not found.");
            return;
        }
        member.setName(name);
    }

    @Override
    public void handle() {
        while (true) {
            System.out.println();
        }
    }
}
