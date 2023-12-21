package org.example;

import java.io.*;

public class Library implements Serializable {
    private static final long serialVersionUID = 1L;

    private Book[] library;

    public Library() {
        loadLibraryStatus();
        initializeLibrary();
    }

    public Book[] getLibrary() {
        return library;
    }

    public void checkOutBook(String borrower, String bookTitle) {
        Book[] library = getLibrary();
        for (Book book : library) {
            if (book != null && !book.isCheckedOut() && book.getTitle().equalsIgnoreCase(bookTitle)) {
                book.setCheckedOut(true);
                book.setCheckedOutTo(borrower);
                saveLibraryStatus();
                System.out.printf("Book '%s' successfully checked out to %s.%n", bookTitle, borrower);
                return;
            }
        }
        System.out.println("Book not available or invalid title.");
    }

    public void checkInBook(String bookTitle) {
        Book[] library = getLibrary();
        for (Book book : library) {
            if (book != null && book.isCheckedOut() && book.getTitle().equalsIgnoreCase(bookTitle)) {
                book.setCheckedOut(false);
                book.setCheckedOutTo("");
                saveLibraryStatus();
                System.out.printf("Book '%s' successfully checked in.%n", bookTitle);
                return;
            }
        }
        System.out.println("Invalid Book title or the book is not checked out.");
    }

    public void showAvailableBooks() {
        Book[] library = getLibrary();
        for (Book book : library) {
            if (book != null && !book.isCheckedOut()) {
                System.out.printf("ID: %d, ISBN: %d, Title: %s%n",
                        book.getID(), book.getISBN(), book.getTitle());
            }
        }
    }

    public void showCheckedOutBooks() {
        Book[] library = getLibrary();
        for (Book book : library) {
            if (book != null && book.isCheckedOut()) {
                System.out.printf("ID: %d, ISBN: %d, Title: %s, Checked Out To: %s%n",
                        book.getID(), book.getISBN(), book.getTitle(), book.getCheckedOutTo());
            }
        }
    }

    private void loadLibraryStatus() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("libraryStatus.dat"))) {
            library = (Book[]) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Library status file not found. Starting with a clean library.");
            initializeLibrary();
            saveLibraryStatus();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    void saveLibraryStatus() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("libraryStatus.dat"))) {
            oos.writeObject(library);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initializeLibrary() {
        library = new Book[20];
        library[0] = new Book(1235, 3265, "Building Cars", false, "");
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
    }
}