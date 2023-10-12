package org.example;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the DMV ");
        System.out.println("please select A for renewal, B for road test and C for paying fine");
        String Answer = scanner.nextLine();
        if (Answer.equalsIgnoreCase("A")) {
            System.out.println("Please enter your ID number. Please only digits.");
            double ID = scanner.nextDouble();
            System.out.println("please enter your first and last name");
            scanner.nextLine();
            String Name = scanner.nextLine();
            int TicketNumber = ThreadLocalRandom.current().nextInt(20, 41);
            System.out.println(Name + " your ticket number is " + TicketNumber);
        }
        if (Answer.equalsIgnoreCase("B")) {
            System.out.println("Please enter your birthday. Please only digits D/M/Y.");
            String Birthday = scanner.nextLine();
            System.out.println("please enter your first and last name");
            scanner.nextLine();
            String Name = scanner.nextLine();
            int TicketNumber = ThreadLocalRandom.current().nextInt(1, 19);
            System.out.println(Name + " your ticket number is " + TicketNumber);
        }
        if (Answer.equalsIgnoreCase("C")) {
            System.out.println("Please enter your ID number. Please only digits.");
            double ID = scanner.nextDouble();
            System.out.println("please enter your first and last name");
            scanner.nextLine();
            String Name = scanner.nextLine();
            int TicketNumber = ThreadLocalRandom.current().nextInt(40, 61);
            System.out.println(Name + " your ticket number is " + TicketNumber);
        }
    }
}