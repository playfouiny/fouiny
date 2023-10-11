package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your score: ");
        int score = scanner.nextInt();
        char grade;
        if (score < 0 || score > 100) {
            grade = 'X';
            System.out.println("Invalid entry: Score should be between 0 and 100.");
        } else {
            switch (score/10) {
                case 10:
                    grade = 'A';
                case 9:
                    grade = 'A';
                    break;
                case 8:
                    grade = 'B';
                    break;
                case 7:
                    grade = 'C';
                    break;
                case 6:
                    grade = 'D';
                    break;
                default:
                    grade = 'F';
            }
            System.out.println("The grade is: " + grade);
        }
    }
}