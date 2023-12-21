package org.example;

import java.util.ArrayList;

public class Library {
    private String libraryName;
    private ArrayList<Book> books;

    public Library(String libraryName, ArrayList<Book> books) {
        this.libraryName = libraryName;
        this.books = books;
    }

    public void addBook(Book book){

    }
    public Book findBookByISBN(String isbn){
        return null;

    }
    public void listAvailableBooks(){

    }
//Manages a collection of books.
//has methods to add books, find books by ISBN, and list available books.
// directly interact with the book class
}
