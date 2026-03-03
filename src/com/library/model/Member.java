package com.library.model;

import java.util.HashMap;
import java.util.Map;

public class Member {

    private String memberId;
    private String name;

    private Map<String, BorrowRecord> borrowedBooks = new HashMap<>();

    private int totalBooksBorrowed = 0;

    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }

    public String getMemberId() { return memberId; }
    public String getName() { return name; }
    public Map<String, BorrowRecord> getBorrowedBooks() { return borrowedBooks; }

    public int getTotalBooksBorrowed() { return totalBooksBorrowed; }

    public void incrementTotalBorrowed() {
        totalBooksBorrowed++;
    }
}