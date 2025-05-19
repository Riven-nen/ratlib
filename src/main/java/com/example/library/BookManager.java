package com.example.library;

import java.util.ArrayList;

public class BookManager {
    ArrayList<Book> books = new ArrayList<>();

    /**
        Requirements:
        1. Add New Book
        2. View All Books
        3. Search Book
        4. Update Book
        5. Delete Book

     */

    /**
     * Add a book to the collection
     * @param book to be added
     */
    public void addBook(Book book) {
        books.add(book);
    }

    /**
     * Get the collection of books
     * @return an arraylist of books
     */
    public ArrayList<Book> getBooks() {
        return books;
    }

    /**
     * Search for the book in the collection and return the index of the book in the collection
     * @param book to search
     * @return the index of the searched book
     */
    public int searchBook(Book book) {
        return books.indexOf(book);
    }

    /**
     * Update the book if it is in the collection
     * @param book to be changed
     * @param name new name of the book
     */
    public void updateBook(Book book, String name) {
        if (books.contains(book)) {
            book.setName(name);
        }
    }

    /**
     * Update the book if it is in the collection
     * @param book to be changed
     * @param status new status of the book
     */
    public void updateBook(Book book, Status status) {
        if (books.contains(book)) {
            book.setStatus(status);
        }
    }

    /**
     * Update the book if it is in the collection
     * @param book to be changed
     * @param status new status of the book
     */
    public void updateBook(Book book, String name, Status status) {
        if (books.contains(book)) {
            book.setName(name);
            book.setStatus(status);
        }
    }

    /**
     * Remove the given book from the collection
     * @param book to be deleted
     */
    public void deleteBook(Book book) {
        books.remove(book);
    }
}
