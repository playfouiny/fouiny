package org.example;

public class Grade {
    public int Courses;

    public Grade(String courses) {
        Courses = courses;
    }

    public String getCourses() {
        return Courses;
    }

    public void setCourses(String courses) {
        Courses = courses;
    }
}
