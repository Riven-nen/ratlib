package com.example.library;

import java.util.ArrayList;

public class BookManagerState extends State implements Manager<Book> {
    ArrayList<Book> books = new ArrayList<>();

    public BookManagerState(Menu menu) {
        super(menu);
    }

    public boolean isInBooks(Book book) {
        return books.contains(book);
    }

    public void add(Book book) {
        books.add(book);
    }

    public void view() {
        System.out.println("ID\tName\t\tStatus");
        for (Book book : books) {
            System.out.printf("%d\t%s\t\t%s\n",book.getId(),book.getName(),book.geStatus());
        }
    }

    public int search(Book book) {
        return books.indexOf(book);
    }

    public void update(Book book, String name) {
        if (!isInBooks(book)) {
            System.out.println("Invalid book!");
            return;
        }
        book.setName(name);
    }

    public void update(Book book, Status status) {
        if (!isInBooks(book)) {
            System.out.println("Invalid book!");
            return;
        }
        book.setStatus(status);
    }

    public void update(Book book, String name, Status status) {
        if (!isInBooks(book)) {
            System.out.println("Invalid book!");
            return;
        }
        book.setName(name);
        book.setStatus(status);
    }

    public boolean delete(Book book) {
        return books.remove(book);
    }

    public void back() {
        
    }

    public void handle() {
        
    }
}
