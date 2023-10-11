package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your score: ");
        int Score = scanner.nextInt();
        if (Score >= 90 && Score <= 100) {
            System.out.println("your grade is A");
        } else if (Score >= 80 && Score <= 89) {
            System.out.println("your grade is B");
        } else if (Score >= 70 && Score <= 79) {
            System.out.println("your grade is C");
        } else if (Score >= 60 && Score <= 69) {
            System.out.println("your grade is D");
        } else if (Score >= 0 && Score < 60) {
            System.out.println("your grade is F");
        } else {
            System.out.println("Invalid score. Please enter a score between 0 and 100.");
        }
    }
}


