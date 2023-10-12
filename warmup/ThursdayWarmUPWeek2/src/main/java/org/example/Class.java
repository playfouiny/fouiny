package org.example;

public class Class {
    public String FirstName;
    public String LastName;
    public int StudentID;
    public int YearInCollege;
    public String International;
    public String Address;
    public String Greetings;

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public int getStudentID() {
        return StudentID;
    }

    public void setStudentID(int studentID) {
        StudentID = studentID;
    }

    public int getYearInCollege() {
        return YearInCollege;
    }

    public void setYearInCollege(int yearInCollege) {
        YearInCollege = yearInCollege;
    }

    public String getInternational() {
        return International;
    }

    public void setInternational(String international) {
        International = international;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public Class(String firstName, String lastName, int studentID, int yearInCollege, String address) {
        this.FirstName = firstName;
        this.LastName = lastName;
        this.StudentID = studentID;
        this.YearInCollege = yearInCollege;
        this.Address = address;
    }

    public Class(String firstName, String lastName, int studentID) {
        this.FirstName = firstName;
        this.LastName = lastName;
        this.StudentID = studentID;
    }

    public Class(String firstName, String lastName) {
        this.FirstName = firstName;
        this.LastName = lastName;
    }

    public void Greetings(){
        System.out.println("hi my name is "+getFirstName()+" "+getLastName()+" it is nice to meet you!");



    }
}
