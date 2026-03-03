package com.library.main;

import com.library.service.LibraryService;
import java.util.Scanner;

public class LibraryApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        LibraryService service = new LibraryService();

        while (true) {

            System.out.println("\n Library Menu ");
            System.out.println("1. Add Book");
            System.out.println("2. Register Member");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Search Book");
            System.out.println("6. Member Report");
            System.out.println("7. Book Report");
            System.out.println("8. Top Borrowers");
            System.out.println("9. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Book ID: ");
                    String id = sc.nextLine();
                    System.out.print("Title: ");
                    String title = sc.nextLine();
                    System.out.print("Author: ");
                    String author = sc.nextLine();
                    System.out.print("Copies: ");
                    int copies = sc.nextInt();
                    service.addBook(id, title, author, copies);
                    break;

                case 2:
                    System.out.print("Member ID: ");
                    String mid = sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    service.registerMember(mid, name);
                    break;

                case 3:
                    System.out.print("Member ID: ");
                    service.borrowBook(sc.nextLine(), sc.nextLine());
                    break;

                case 4:
                    System.out.print("Member ID: ");
                    service.returnBook(sc.nextLine(), sc.nextLine());
                    break;

                case 9:
                    System.out.println("Exiting...");
                    return;
            }
        }
    }
}