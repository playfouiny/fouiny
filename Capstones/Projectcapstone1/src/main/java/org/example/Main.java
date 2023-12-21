package org.example;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Transactions> depositsList = new ArrayList<>();
    private static ArrayList<Transactions> paymentsList = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Welcome to your CLI application");
            System.out.println("D) Add Deposit");
            System.out.println("P) Make Payment");
            System.out.println("L) Ledger");
            System.out.println("X) Exit");
            String choice = scanner.nextLine();
            switch (choice.toUpperCase()) {
                case "D":
                    adddeposit(depositsList);
                    break;
                case "P":
                    makepayment(paymentsList);
                    break;
                case "L":
                    ledger();
                    break;
                case "X":
                    System.out.println("have a good day");
                    System.exit(0);
                default:
                    System.out.println("invalid entry");
                    break;
            }

        }
    }

    public static void adddeposit(ArrayList<Transactions> depositsList) {
        try {
            depositsList = new ArrayList<>();

            Scanner scanner = new Scanner(System.in);
            System.out.println("enter Amount to Deposit");
            double deposit = scanner.nextDouble();
            System.out.println("Who is the payment for");
            scanner.nextLine();
            String payto = scanner.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String Time = LocalDateTime.now().format(formatter);
            String transaction = String.format("At %s |%s| %.2f", Time, payto, deposit);
            /* depositsList.add(transaction);*/
            FileWriter fis1 = new FileWriter("src/main/resources/Transactions.csv", true);
            PrintWriter print1 = new PrintWriter(fis1);
            formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            Time = LocalDateTime.now().format(formatter);
            fis1.write(String.format("At %s |%s| %.2f%n", Time, payto, deposit));
            fis1.close();


        } catch (java.io.IOException ex) {
            System.out.println("error");

        } catch (Exception ex) {
            System.out.println("sorry cant help you ");
        }

    }

    public static void makepayment(ArrayList<Transactions> paymentsList) {
        try {
            paymentsList = new ArrayList<>();
            Scanner scanner = new Scanner(System.in);
            System.out.println("enter Amount to Deposit");
            double deposit = scanner.nextDouble();
            System.out.println("Who is the payment for");
            scanner.nextLine();
            String payto = scanner.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String Time = LocalDateTime.now().format(formatter);
            String transaction = String.format("At %s |%s| %.2f", Time, payto, deposit);
            /*paymentsList.add(transaction);*/
            FileWriter fis1 = new FileWriter("src/main/resources/Transactions.csv", true);
            PrintWriter print1 = new PrintWriter(fis1);
            print1.printf("At %s |%s| -%.2f%n", Time, payto, deposit);
            fis1.close();
        } catch (java.io.IOException ex) {
            System.out.println("error");
        } catch (Exception ex) {
            System.out.println("sorry cant help you ");
        }
    }

    public static void ledger() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("A) Display all entries");
            System.out.println("D) Display Deposits");
            System.out.println("P) Display Payments");
            System.out.println("R) Reports");
            System.out.println("H) Home");
            String choice = scanner.nextLine();
            switch (choice.toUpperCase()) {
                case "A":
                    displayledger();
                    break;
                case "D":
                    displaydeposits(depositsList);
                    break;
                case "P":
                    displaypayments(paymentsList);
                    break;
                case "R":
                   /* reports();*/
                    break;
                case "H":
                    return;
                default:
                    System.out.println("invalid entry");
                    break;
            }
        }
    }

    private static void displayledger() {
        try {
            FileInputStream fis = new FileInputStream("src/main/resources/Transactions.csv");
            Scanner scanner = new Scanner(fis);

            ArrayList<Transactions> list1 = new ArrayList<>();
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String input = scanner.nextLine();
                String[] list = input.split("\\|");
                String date = list[0];
                String time= list[1];
                String description = list[2];
                String vendor= list[3];
                double amount = Double.parseDouble(list[4]);
                Transactions newitem = new Transactions(date,time, description,vendor, amount);
                list1.add(newitem);
                System.out.println(newitem);
            }
        } catch (Exception ex) {
            System.out.println("Error");
            ex.printStackTrace();
        }
    }

    private static void displaydeposits(ArrayList<Transactions> depositsList) {


        try {
            depositsList = new ArrayList<>();
            File file = new File("src/main/resources/Transactions.csv");
            Scanner scanner = new Scanner(file);
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("\\|");
                if (parts.length >= 6) {
                    String amountString = parts[4].trim();
                    try {
                        double amount = Double.parseDouble(amountString);
                        if (amount > 0) {
                            System.out.println(line);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid amount format in line: " + line);
                    }
                } else {
                    System.out.println("Invalid CSV format in line: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void displaypayments(ArrayList<Transactions> paymentsList) {


        try {
           paymentsList = new ArrayList<>();
            File file = new File("src/main/resources/Transactions.csv");
            Scanner scanner = new Scanner(file);
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("\\|");
                if (parts.length >= 6) {
                    String amountString = parts[4].trim();
                    try {
                        double amount = Double.parseDouble(amountString);
                        if (amount < 0) {
                            System.out.println(line);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid amount format in line: " + line);
                    }
                } else {
                    System.out.println("Invalid CSV format in line: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void reports() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1) Search Month to Date");
            System.out.println("2) Search Previous Month");
            System.out.println("3) Search Year to Date");
            System.out.println("4) Search Previous Year");
            System.out.println("5) Search Vendor");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    vendor();
                    break;
                default:
                    System.out.println("invalid entry");
            }

        }
    }

    private static void vendor() {
       try{ Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name of vendor");
        String vend = scanner.nextLine();
        File file = new File("src/main/resources/Transactions.csv");

         Scanner fileScanner = new Scanner(file);

            if (fileScanner.hasNextLine()) {
                fileScanner.nextLine();
            }
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split("\\|");
                if (parts.length >= 3) {
                  String vendo = parts[1].trim();
                 try{
                     if (vend.equalsIgnoreCase(vendo)) {
                         System.out.println(line);
                     }
                 }
                  catch (NumberFormatException e) {
                     System.out.println("Invalid format in line: " + line);
                                }
                }
                else {
                System.out.println("Invalid CSV format in line: " + line);
           }
            }
        }
          catch (FileNotFoundException e)
        {
      e.printStackTrace();
        }
    }
}



