package org.example;

import java.util.Scanner;

/*
First some small stylistic things. Properties and method names should be camel case.
So like ShowCheckedOutBooks should be showCheckedOutBooks
I do this too so it's no biggie
When displaying books that are checked out, you may want to display ONLY the books that
are checked out. That way there is less info on the screen.
I was able to check in a book that wasn't checked out, but it wouldn't cause a bug
It just needs to give a message saying "That book has not been checked out."
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Book[] library = new Book[20];

        //The constructor makes for less typing since you know all the books are not checked out and are not checked out to anyone
        //in the beginning
        library[0] = new Book(1235, 3265, "Building Cars");
        library[1] = new Book(1, 9780061, "To Kill a Mockingbird", false, "");
        library[2] = new Book(2, 9724935, "1984", false, "");
        library[3] = new Book(3, 41439563, "Pride and Prejudice", false, "");
        library[4] = new Book(4, 9783275, "One Hundred Years of Solitude", false, "");
        library[5] = new Book(5, 97935467, "The Catcher in the Rye", false, "");
        library[6] = new Book(6, 96215007, "The Great Gatsby", false, "");
        library[7] = new Book(7, 94003415, "The Hobbit", false, "");
        library[8] = new Book(8, 97807435, "Lord of the Flies", false, "");
        library[9] = new Book(9, 97803188, "To Kill a Mockingbird", false, "");
        library[10] = new Book(10, 9780342, "In Cold Blood", false, "");
        library[11] = new Book(11, 9784842, "Into the Wild", false, "");
        library[12] = new Book(12, 97805534, "Moby-Dick", false, "");
        library[13] = new Book(13, 93432952, "Catch-22", false, "");
        library[14] = new Book(14, 978044789, "To Kill a Mockingbird", false, "");
        library[15] = new Book(15, 978045342, "Brave New World", false, "");
        library[16] = new Book(16, 9780346, "The Shining", false, "");
        library[17] = new Book(17, 9719952, "Jurassic Park", false, "");
        library[18] = new Book(18, 97869488, "The Da Vinci Code", false, "");
        library[19] = new Book(19, 90033416, "The Kite Runner", false, "");

        while (true) {
            System.out.println("welcome to your Neighborhood Library");
            System.out.println("please select the following: 1 to check out books, 2 to exit out, 3 to check books that are checked out");
            int Choice = scanner.nextInt();

            switch (Choice) {
                case 1:
                    AvailableBooks(library);
                    break;
                case 2:
                    System.out.println("have a good day my boy");
                    System.exit(0);
                    break;
                case 3:
                    ShowCheckedOut(library);

            }
        }
    }

//Good that you broke this down into methods
    public static void ShowCheckedOut(Book[] inventory) {
        Scanner scanner = new Scanner(System.in);
        boolean isCheckedOut = false;
        for (Book v : inventory) {
            if (v != null && !v.ischeckedOut()) {
                System.out.printf("ID: %d, ISBN: %d, Title: %s, Checked Out To: %s\n", v.getID(), v.getISBN(), v.getTitle(), v.getCheckedOutTo());
                isCheckedOut = true;
            }
        }
        if (isCheckedOut) {
            System.out.println("Please select A to check in a book, B to go back to the home screen");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("A")) {
                System.out.println("Please enter Book ID");
                int bookId = scanner.nextInt();
                boolean foundID = false;
                for (Book s : inventory) {
                    if (s != null  && s.getID() == bookId) {
                        s.setischeckedOut(false);
                        s.setCheckedOutTo("");
                        System.out.println("Book successfully checked in.");
                        foundID = true;
                        break;
                    }
                }
                if (!foundID) {
                    System.out.println("Invalid Book ID or the book is not checked out.");
                }
            } else if (choice.equalsIgnoreCase("B")) {
                System.out.println("Now returning to home screen");
                return;
            } else {
                System.out.println("Invalid input.");
            }
        } else {
            System.out.println("No checked out books.");
        }
    }
    public static void AvailableBooks(Book[] inventory) {
        Scanner scanner = new Scanner(System.in);
        for (Book v : inventory) {
            if (v != null && !v.ischeckedOut()) {
                System.out.println("Available Books:");
                System.out.printf("ID: %d, ISBN: %d, Title: %s\n", v.getID(), v.getISBN(), v.getTitle());
            }
        }
            System.out.println("enter your name");
            String Borrower = scanner.nextLine();
            System.out.println("enter book title");
            String BookTittle = scanner.nextLine();
            boolean FoundBook = false;
            for (Book v : inventory) {
                if (v != null && !v.ischeckedOut() && v.getTitle().equalsIgnoreCase(BookTittle)) {
                    v.setischeckedOut(true);
                    v.setCheckedOutTo(Borrower);
                    FoundBook = true;
                    System.out.printf("ID: %d, ISBN: %d, Title: %s,checked out to: %s \n", v.getID(), v.getISBN(), v.getTitle(), v.getCheckedOutTo());
                    break;
                }
            }
            if (!FoundBook) {
                System.out.println("Book not available or invalid title.");
            }
        }
    }




