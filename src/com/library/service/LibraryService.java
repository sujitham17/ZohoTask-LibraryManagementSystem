package com.library.service;

import com.library.model.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class LibraryService {

    private Map<String, Book> books = new HashMap<>();
    private Map<String, Member> members = new HashMap<>();

    public void addBook(String id, String title, String author, int copies) {
        if (books.containsKey(id)) {
            System.out.println("Book ID already exists!");
            return;
        }
        books.put(id, new Book(id, title, author, copies));
        System.out.println("Book added successfully.");
    }

    public void registerMember(String id, String name) {
        if (members.containsKey(id)) {
            System.out.println("Member ID already exists!");
            return;
        }
        members.put(id, new Member(id, name));
        System.out.println("Member registered successfully.");
    }

    public void borrowBook(String memberId, String bookId) {

        if (!members.containsKey(memberId)) {
            System.out.println("Member not found!");
            return;
        }

        if (!books.containsKey(bookId)) {
            System.out.println("Book not found!");
            return;
        }

        Member member = members.get(memberId);
        Book book = books.get(bookId);

        if (member.getBorrowedBooks().size() >= 3) {
            System.out.println("Borrow limit exceeded (Max 3).");
            return;
        }

        if (member.getBorrowedBooks().containsKey(bookId)) {
            System.out.println("You already borrowed this book.");
            return;
        }

        if (book.getAvailableCopies() <= 0) {
            System.out.println("No copies available.");
            return;
        }

        BorrowRecord record = new BorrowRecord(bookId, LocalDate.now());

        member.getBorrowedBooks().put(bookId, record);
        member.incrementTotalBorrowed();
        book.decreaseAvailableCopies();
        book.getBorrowedByMembers().add(memberId);

        System.out.println("Book borrowed successfully.");
    }

    public void returnBook(String memberId, String bookId) {

        if (!members.containsKey(memberId) || !books.containsKey(bookId)) {
            System.out.println("Member or Book not found!");
            return;
        }

        Member member = members.get(memberId);
        Book book = books.get(bookId);

        if (!member.getBorrowedBooks().containsKey(bookId)) {
            System.out.println("This book was not borrowed by this member.");
            return;
        }

        BorrowRecord record = member.getBorrowedBooks().remove(bookId);
        book.increaseAvailableCopies();
        book.getBorrowedByMembers().remove(memberId);

        long overdueDays = ChronoUnit.DAYS.between(record.getDueDate(), LocalDate.now());

        if (overdueDays > 0) {
            System.out.println("Overdue! Fine: Rs." + (overdueDays * 2));
        } else {
            System.out.println("Book returned successfully. No fine.");
        }
    }

    public void searchBook(String keyword) {
        for (Book book : books.values()) {
            if (book.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                book.getAuthor().toLowerCase().contains(keyword.toLowerCase())) {

                System.out.println(book.getBookId() + " | " + book.getTitle() +
                        " | Available: " + book.getAvailableCopies());
            }
        }
    }

    public void memberReport(String memberId) {
        if (!members.containsKey(memberId)) {
            System.out.println("Member not found!");
            return;
        }

        Member member = members.get(memberId);

        for (BorrowRecord record : member.getBorrowedBooks().values()) {
            System.out.println("Book: " + record.getBookId() +
                    " Borrowed: " + record.getBorrowDate() +
                    " Due: " + record.getDueDate());
        }
    }

    public void bookReport(String bookId) {
        if (!books.containsKey(bookId)) {
            System.out.println("Book not found!");
            return;
        }

        Book book = books.get(bookId);

        System.out.println("Available Copies: " + book.getAvailableCopies());
        System.out.println("Borrowed By: " + book.getBorrowedByMembers());
    }

    public void topBorrowers() {

        List<Member> memberList = new ArrayList<>(members.values());

        memberList.sort((a, b) ->
                b.getTotalBooksBorrowed() - a.getTotalBooksBorrowed());

        for (Member m : memberList) {
            System.out.println(m.getName() + " - Total Borrowed: " +
                    m.getTotalBooksBorrowed());
        }
    }
}