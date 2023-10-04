package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("what do you want to do?");
        System.out.println("pick A to add, S to subtract, M to multiply, D to divide");
        Scanner scanner = new Scanner(System.in);
        String Answer = scanner.nextLine();
        System.out.println("enter first number");
        Float firstNumber = scanner.nextFloat();
        System.out.println("enter second number");
        Float secondNumber = scanner.nextFloat();
        if (Answer.equalsIgnoreCase("A")) {
            Float Sum1 = firstNumber + secondNumber;
            System.out.println(Sum1);
        }
        if (Answer.equalsIgnoreCase("S")) {
            Float Sum2 = firstNumber - secondNumber;
            System.out.println(Sum2);
        }
        if (Answer.equalsIgnoreCase("M")) {
            Float Sum3 = firstNumber * secondNumber;
            System.out.println(Sum3);
        }

        if (Answer.equalsIgnoreCase("D")) {
            Float Sum4 = firstNumber / secondNumber;
            System.out.println(Sum4);
        }
    }
}