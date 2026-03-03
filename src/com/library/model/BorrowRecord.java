package com.library.model;

import java.time.LocalDate;

public class BorrowRecord {

    private String bookId;
    private LocalDate borrowDate;
    private LocalDate dueDate;

    public BorrowRecord(String bookId, LocalDate borrowDate) {
        this.bookId = bookId;
        this.borrowDate = borrowDate;
        this.dueDate = borrowDate.plusDays(14);
    }

    public String getBookId() { return bookId; }
    public LocalDate getBorrowDate() { return borrowDate; }
    public LocalDate getDueDate() { return dueDate; }
}