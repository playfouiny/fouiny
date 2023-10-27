package org.example;

public class Book {
    //Small quibble, property names are camel case so they begin with lower case letters
    public int ID;
    //I would make ISBN a string since you are never going to do math with it
    public int ISBN;
    public String title;
    public boolean ischeckedOut;
    public  String CheckedOutTo;
    public String Name;

    public Book(int ID, int ISBN, String title, boolean ischeckedOut, String checkedOutTo) {
        this.ID = ID;
        this.ISBN = ISBN;
        this.title = title;
        this.ischeckedOut = ischeckedOut;
        this.CheckedOutTo = checkedOutTo;

    }

    //You could do the constructor like this for less typing since you know in the beginning it won't be checked out
    //and it's not checked out to anyone
    public Book(int id, int isbn, String title) {
        this.ID = id;
        this.ISBN = isbn;
        this.title = title;
        this.ischeckedOut = false;
        this.CheckedOutTo = "";
    }


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean ischeckedOut() {
        return ischeckedOut;
    }

    public void setischeckedOut(boolean ischeckedOut) {
        ischeckedOut = ischeckedOut;
    }

    public String getCheckedOutTo() {
        return CheckedOutTo;
    }

    public void setCheckedOutTo(String checkedOutTo) {
        CheckedOutTo = checkedOutTo;
    }



}
