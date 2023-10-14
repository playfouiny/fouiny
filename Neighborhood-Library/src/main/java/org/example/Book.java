package org.example;

public class Book {
    public int ID;
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
