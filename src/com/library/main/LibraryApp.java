package com.library.main;

import com.library.service.LibraryService;
import java.util.Scanner;

public class LibraryApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        LibraryService service = new LibraryService();
        int choice;

        do {
            System.out.println("LIBRARY MANAGEMENT SYSTEM ");
            System.out.println("1. Add Book");
            System.out.println("2. Register Member");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Search Book");
            System.out.println("6. Member Report");
            System.out.println("7. Book Report");
            System.out.println("8. Top Borrowers");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            while (!sc.hasNextInt()) {
                System.out.print("Invalid input! Enter a number: ");
                sc.next();
            }

            choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {

                case 1:
                    System.out.print("Enter Book ID: ");
                    String bookId = sc.nextLine();

                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Author Name: ");
                    String author = sc.nextLine();

                    System.out.print("Enter Number of Copies: ");
                    int copies = sc.nextInt();
                    sc.nextLine();

                    service.addBook(bookId, title, author, copies);
                    break;

                case 2:
                    System.out.print("Enter Member ID: ");
                    String memberId = sc.nextLine();

                    System.out.print("Enter Member Name: ");
                    String name = sc.nextLine();

                    service.registerMember(memberId, name);
                    break;

                case 3:
                    System.out.print("Enter Member ID: ");
                    String borrowMemberId = sc.nextLine();

                    System.out.print("Enter Book ID: ");
                    String borrowBookId = sc.nextLine();

                    service.borrowBook(borrowMemberId, borrowBookId);
                    break;

                case 4:
                    System.out.print("Enter Member ID: ");
                    String returnMemberId = sc.nextLine();

                    System.out.print("Enter Book ID: ");
                    String returnBookId = sc.nextLine();

                    service.returnBook(returnMemberId, returnBookId);
                    break;

                case 5:
                    System.out.print("Enter Title or Author keyword to search: ");
                    String keyword = sc.nextLine();

                    service.searchBook(keyword);
                    break;

                case 6:
                    System.out.print("Enter Member ID: ");
                    String reportMemberId = sc.nextLine();

                    service.memberReport(reportMemberId);
                    break;

                case 7:
                    System.out.print("Enter Book ID: ");
                    String reportBookId = sc.nextLine();

                    service.bookReport(reportBookId);
                    break;

                case 8:
                    service.topBorrowers();
                    break;

                case 9:
                    System.out.println("Thank you for using Library Management System!");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 9);

        sc.close();
    }
}