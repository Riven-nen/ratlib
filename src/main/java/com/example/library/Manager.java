package com.example.library;

public interface Manager <T> {
    void add(T item);
    void view();
    int search(T item);
    boolean delete(T item);
    void back();
}
