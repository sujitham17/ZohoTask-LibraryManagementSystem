package com.library.model;

import java.util.HashSet;
import java.util.Set;

public class Book {
    private String bookId;
    private String title;
    private String author;
    private int totalCopies;
    private int availableCopies;

    private Set<String> borrowedByMembers = new HashSet<>();

    public Book(String bookId, String title, String author, int copies) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.totalCopies = copies;
        this.availableCopies = copies;
    }

    public String getBookId() { return bookId; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getAvailableCopies() { return availableCopies; }
    public int getTotalCopies() { return totalCopies; }
    public Set<String> getBorrowedByMembers() { return borrowedByMembers; }

    public void decreaseAvailableCopies() {
        availableCopies--;
    }

    public void increaseAvailableCopies() {
        availableCopies++;
    }
}