package org.example;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to the DMV ");
            System.out.println("Please select A for renewal, B for road test, C for paying a fine, or E to exit");
            String answer = scanner.nextLine();

            if (answer.equalsIgnoreCase("E")) {
                System.out.println("Exiting the program. Goodbye!");
                break;
            }

            if (answer.equalsIgnoreCase("A")) {
                renewLicense(scanner);
            } else if (answer.equalsIgnoreCase("B")) {
                scheduleRoadTest(scanner);
            } else if (answer.equalsIgnoreCase("C")) {
                payFine(scanner);
            } else {
                System.out.println("Invalid input. Please try again.");
            }
        }
    }

    private static void renewLicense(Scanner scanner) {
        System.out.println("Please enter your ID number. Please only digits.");
        double ID = scanner.nextDouble();
        System.out.println("Please enter your first and last name");
        scanner.nextLine();
        String name = scanner.nextLine();
        int ticketNumber = ThreadLocalRandom.current().nextInt(20, 41);
        System.out.println(name + ", your ticket number is " + ticketNumber);
    }

    private static void scheduleRoadTest(Scanner scanner) {
        System.out.println("Please enter your birthday. Please only digits D/M/Y.");
        String birthday = scanner.nextLine();
        System.out.println("Please enter your first and last name");
        scanner.nextLine();
        String name = scanner.nextLine();
        int ticketNumber = ThreadLocalRandom.current().nextInt(1, 19);
        System.out.println(name + ", your ticket number is " + ticketNumber);
    }

    private static void payFine(Scanner scanner) {
        System.out.println("Please enter your ID number. Please only digits.");
        double ID = scanner.nextDouble();
        System.out.println("Please enter your first and last name");
        scanner.nextLine();
        String name = scanner.nextLine();
        int ticketNumber = ThreadLocalRandom.current().nextInt(40, 61);
        System.out.println(name + ", your ticket number is " + ticketNumber);
    }
}