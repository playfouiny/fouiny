package org.example;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) {
            //this is the home screen which will be the first screen users will see
            //on here users will select what option they want depending on their needs for the app
            //in case of wrong entry i added loops throughout this program so that the app will give users unlimited chances to try again
            Scanner scanner = new Scanner(System.in);
            System.out.println("Welcome please make a selection");
            System.out.println("D) Add Deposit");
            System.out.println("P) Make Payment");
            System.out.println("L) Ledger");
            System.out.println("X) Exit");
            //below i created a switch method that will go ta the screen of the user's choice
            //if user would like to leave app they will see a goodbye message and the app will close
            String choice = scanner.nextLine();
            switch (choice.toUpperCase()) {
                case "D":
                    adddeposit();
                    break;
                case "P":
                    makepayment();
                    break;
                case "L":
                    ledger();
                    break;
                case "X":
                    System.out.println("Have a wonderful day");
                    System.out.println("See you soon");
                    System.exit(0);
                default:
                    System.out.println("Invalid entry");
                    System.out.println("Please try again");
                    break;
            }
        }
    }
    private static void adddeposit() {
        //this methode is the screen of what the user will see when they select to add deposit from home screen
        try {
            //this part below will take user payment info
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter Amount to deposit");
            double deposit = scanner.nextDouble();
            System.out.println("What is this for?");
            scanner.nextLine();
            String description = scanner.nextLine();
            System.out.println("Who is the payment for?");
            String payto = scanner.nextLine();
            //this part below grabs the current date and time of user entry to get accurate local time
            DateTimeFormatter dateformatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String date = LocalDateTime.now().format(dateformatter);
            DateTimeFormatter timeformatter = DateTimeFormatter.ofPattern("hh:mm:ss");
            String time = LocalDateTime.now().format(timeformatter);
            //this part below grabs all info and send it to transactions list in this format
            String newEntry = String.format("%s| %s| %s| %s| %.2f", date, time, description, payto, deposit);
            List<String> lines = new ArrayList<>();
            FileInputStream fis = new FileInputStream("src/main/resources/Transactions.csv");
            Scanner fileScanner = new Scanner(fis);
            while (fileScanner.hasNextLine()) {
                lines.add(fileScanner.nextLine());
            }
            fileScanner.close();
            fis.close();
            //this part below make sure that the most recent entry will be on spot number one after the header which is at spot 0
            lines.add(1, newEntry);
            FileOutputStream fos = new FileOutputStream("src/main/resources/Transactions.csv");
            PrintWriter printWriter = new PrintWriter(fos);
            for (String entry : lines) {
                printWriter.println(entry);
            }
            printWriter.close();
            fos.close();
            System.out.println("Added successfully.");
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Sorry, can't make deposit try again.");
        }
    }
    private static void makepayment() {
        //this methode is the screen of what the user will see when they select add payment from home screen
        try {
            //this part below will take user payment info
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter Amount to pay");
            double deposit = scanner.nextDouble();
            System.out.println("what is this for?");
            scanner.nextLine();
            String description = scanner.nextLine();
            System.out.println("Who is the payment for?");
            String payto = scanner.nextLine();
            //this part below grabs the current date and time of user entry to get accurate local time
            DateTimeFormatter dateformatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String date = LocalDateTime.now().format(dateformatter);
            DateTimeFormatter timeformatter = DateTimeFormatter.ofPattern("hh:mm:ss");
            String time = LocalDateTime.now().format(timeformatter);
            //this part below grabs all info and send it to transactions list in this format
            String newEntry = String.format("%s| %s| %s| %s| -%.2f", date, time, description, payto, deposit);
            List<String> lines = new ArrayList<>();
            FileInputStream fis = new FileInputStream("src/main/resources/Transactions.csv");
            Scanner fileScanner = new Scanner(fis);
            while (fileScanner.hasNextLine()) {
                lines.add(fileScanner.nextLine());
            }
            fileScanner.close();
            fis.close();
            //this part below make sure that the most recent entry will be on spot number one after the header which is at spot 0
            lines.add(1, newEntry);
            FileOutputStream fos = new FileOutputStream("src/main/resources/Transactions.csv");
            PrintWriter printWriter = new PrintWriter(fos);
            for (String entry : lines) {
                printWriter.println(entry);
            }
            printWriter.close();
            fos.close();
            System.out.println("Added successfully.");
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Sorry, can't help you.");
        }

    }
    private static void ledger() {
        //this methode has multiple screens that will give users a choice of what they would like to see
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("A) Display all entries");
            System.out.println("D) Display Deposits");
            System.out.println("P) Display Payments");
            System.out.println("R) Reports");
            System.out.println("H) Home");
            String choice1 = scanner.nextLine();

            switch (choice1.toUpperCase()) {
                case "A":
                    displayledger();
                    break;
                case "D":
                    displaydeposits();
                    break;
                case "P":
                    displaypayments();
                    break;
                case "R":
                    reports();
                    break;
                case "H":
                    return;
                default:
                    System.out.println("Invalid entry");
                    System.out.println("Please try again");
                    break;
            }
        }
    }
    private static void displayledger() {
        try {
            //this part below goes into transactions list following this path on line 130
            FileInputStream fis = new FileInputStream("src/main/resources/Transactions.csv");
            Scanner scanner = new Scanner(fis);
            //this part below create a list to store Transactions objects and skip the first spot which has the header
            ArrayList<Transactions> transactionslist = new ArrayList<>();
            scanner.nextLine();
            //this part below read data from each line then create Transactions objects and splits into selected parts and add them to the list
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] list = line.split("\\|");
                String date = list[0];
                String time = list[1];
                String description = list[2];
                String vendor = list[3];
                double amount = Double.parseDouble(list[4]);
                Transactions newline = new Transactions(date, time, description, vendor, amount);
                transactionslist.add(newline);
            }
            //this part below prints objects stored in the transactions list
            for (Transactions item : transactionslist) {
                System.out.printf("%s|%s|%s|%s|%.2f%n",
                        item.getDate(), item.getTime(), item.getDescription(), item.getVendor(), item.getAmount());
            }
        } catch (Exception ex) {
            System.out.println("error");
        }
    }
    private static void displaydeposits() {
        try {
            //this part below opens the "Transactions.csv" file for reading
            FileInputStream fis = new FileInputStream("src/main/resources/Transactions.csv");
            Scanner scanner = new Scanner(fis);
            //this part below skip the header line in the CSV file
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }
            //this part below Read data from each line, splits it in parts and goes to the amount spot that i assigned to 4
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("\\|");
                if (parts.length >= 4) {
                    String amountString = parts[4].trim();
                    try {
                        double amount = Double.parseDouble(amountString);
                        //this part below check is the amount is positive if yes then it prints it since deposit is money going into your account
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
        } catch (Exception ex) {
            System.out.println("Error" + ex.getMessage());
        }
    }
    private static void displaypayments() {
        try {
            //this part below opens the "Transactions.csv" file for reading
            FileInputStream fis = new FileInputStream("src/main/resources/Transactions.csv");
            Scanner scanner = new Scanner(fis);
            //this part below skip the header line in the CSV file
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }
            //this part below Read data from each line, splits it in parts and goes to the amount spot that i assigned to 4
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("\\|");
                if (parts.length >= 4) {
                    String amountString = parts[4].trim();
                    try {
                        double amount = Double.parseDouble(amountString);
                        //this part below check is the amount is negative if yes then it prints it since payment is money going out of your account
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
        } catch (Exception ex) {
            System.out.println("Error" + ex.getMessage());
        }
    }
    private static void reports(){
        //this part below will take users to report screen where they will pick what type of report they would like to see
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1) Search Month to Date");
            System.out.println("2) Search Previous Month");
            System.out.println("3) Search Year to Date");
            System.out.println("4) Search Previous Year");
            System.out.println("5) Search Vendor");
            System.out.println("6) Search using filters");
            System.out.println("0) To go back");
            int choice2 = scanner.nextInt();
            switch (choice2) {
                case 1:
                    //i provided the path to transaction.csv file to "file" in the paramater parts
                    searchEntriesByMonthToDate("src/main/resources/Transactions.csv");
                    break;
                case 2:
                    searchEntriesByPreviousMonth("src/main/resources/Transactions.csv");
                    break;
                case 3:
                    searchEntriesByYearToDate("src/main/resources/Transactions.csv");
                    break;
                case 4:
                    searchEntriesByPreviousYear("src/main/resources/Transactions.csv");
                    break;
                case 5:
                    vendor();
                    break;
                case 6:
                    customSearch();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("invalid entry");
                    break;
            }
        }
    }
    public static void searchEntriesByMonthToDate(String file) {
        //this screen will show all entries from the first day of the month to the last day
        try {
            //this part below open the file(transactions.csv) and get local date
            LocalDate currentDate = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            FileInputStream fis = new FileInputStream(file);
            Scanner scanner = new Scanner(fis);
            scanner.nextLine();
            System.out.println("Entries for Month-to-Date:");
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("\\|");
                String dateString = parts[0];
                LocalDate entryDate = LocalDate.parse(dateString, formatter);
                //this part below is the formula to print out entries that matches current month dates
                if (entryDate.getMonthValue() == currentDate.getMonthValue() &&
                        entryDate.getYear() == currentDate.getYear() &&
                        entryDate.getDayOfMonth() <= currentDate.getDayOfMonth()) {
                    System.out.println(line);
                }
            }
            fis.close();
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
    public static void searchEntriesByPreviousMonth(String file) {
        //this screen will show all entries from previous month
        try {
            //this part first takes current date then takes first day of current month and first day of last month to give you what is in between
            LocalDate currentDate = LocalDate.now();
            LocalDate firstDayOfCurrentMonth = currentDate.withDayOfMonth(1);
            LocalDate firstDayOfPreviousMonth = firstDayOfCurrentMonth.minusMonths(1);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            FileInputStream fis = new FileInputStream(file);
            Scanner scanner = new Scanner(fis);
            scanner.nextLine();
            System.out.println("Entries for Previous Month:");
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("\\|");
                String dateString = parts[0];
                LocalDate entryDate = LocalDate.parse(dateString, formatter);
                //this part below is the formula to print out entries that matches last month dates
                if (entryDate.isAfter(firstDayOfPreviousMonth) && entryDate.isBefore(firstDayOfCurrentMonth)) {
                    System.out.println(line);
                }
            }
            fis.close();
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
    public static void searchEntriesByYearToDate(String file) {
        //this screen will show all entries from the first day of the year to the last day of the year
        try {
            //this part below open the file(transactions.csv) and get local date
            LocalDate currentDate = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            FileInputStream fis = new FileInputStream(file);
            Scanner scanner = new Scanner(fis);
            scanner.nextLine();
            System.out.println("Entries for Year-to-Date:");
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("\\|");
                String dateString = parts[0];
                LocalDate entryDate = LocalDate.parse(dateString, formatter);
                //this part below is the formula to print out entries that matches current year dates
                if (entryDate.getYear() == currentDate.getYear() &&
                        entryDate.getDayOfYear() <= currentDate.getDayOfYear()) {
                    System.out.println(line);
                }
            }
            fis.close();
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
    public static void searchEntriesByPreviousYear(String file) {
        //this screen will show all entries from last year
        try {
            //this part first takes current date then takes first day of current year and first day of last year to give you what is in between
            LocalDate currentDate = LocalDate.now();
            LocalDate firstDayOfCurrentYear = currentDate.withDayOfYear(1);
            LocalDate firstDayOfPreviousYear = firstDayOfCurrentYear.minusYears(1);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            FileInputStream fis = new FileInputStream(file);
            Scanner scanner = new Scanner(fis);
            scanner.nextLine();
            System.out.println("Entries for Previous Year:");
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("\\|");
                String dateString = parts[0];
                LocalDate entryDate = LocalDate.parse(dateString, formatter);
                //this part below is the formula to print out entries that matches last year dates
                if (entryDate.isAfter(firstDayOfPreviousYear) && entryDate.isBefore(firstDayOfCurrentYear)) {
                    System.out.println(line);
                }
            }
            fis.close();
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
    private static void vendor() {
        //this screen will show all entries that matches vendor selected by user from transactions list
        try {
            //this part below asks user which vendor to look up the opens the csv file
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter name of vendor");
            String vend = scanner.nextLine();
            File file = new File("src/main/resources/Transactions.csv");
            Scanner fileScanner = new Scanner(file);
            if (fileScanner.hasNextLine()) {
                fileScanner.nextLine();
            }
            //this part below Read data from each line, splits it in parts and goes to the vendor spot that i assigned to 3
            boolean vendorFound = false;
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split("\\|");
                if (parts.length >= 4) {
                    String vendo = parts[3].trim();

                        //this part below matches user input with vendors names in the transaction list and print all lines that matches
                        if (vend.equalsIgnoreCase(vendo)) {
                            System.out.println(line);
                            vendorFound = true;
                        }
                }
            }fileScanner.close();
            if (!vendorFound) {
                System.out.println("Vendor not found");
            }return;
        } catch (Exception ex) {
            System.out.println("Error" + ex.getMessage());
        }


    }
    private static void customSearch() {
       /* while (true) {*/ //I would use this loop if project asked to give user an option to go back added to this menu so user is not stuck in this loop
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Please select which filter you would like to use");
                System.out.println("A) To search by dates");
                System.out.println("B) To search by description");
                System.out.println("C) To search by amount");
                String choice = scanner.nextLine();
                if (choice.equalsIgnoreCase("A")) {
                    System.out.println("Please enter start date");
                    String startDate1 = scanner.nextLine();
                    LocalDate startDate = LocalDate.parse(startDate1, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    System.out.println("Please enter end date");
                    String endDate1 = scanner.nextLine();
                    LocalDate endDate = LocalDate.parse(endDate1, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    LocalDate startdate = LocalDate.parse(startDate1);
                    LocalDate enddate = LocalDate.parse(endDate1);
                    File file = new File("src/main/resources/Transactions.csv");
                    Scanner fileScanner = new Scanner(file);
                    if (fileScanner.hasNextLine()) {
                        fileScanner.nextLine();
                    }
                    while (fileScanner.hasNextLine()) {
                        String line = fileScanner.nextLine();
                        String[] parts = line.split("\\|");
                        if (parts.length >= 4) {
                            String date1 = parts[0].trim();
                            LocalDate date = LocalDate.parse(date1, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

                            if (date.isAfter(startDate) && date.isBefore(endDate)) {
                                System.out.println(line);
                            }
                        }
                    }
                }
                else if (choice.equalsIgnoreCase("B")) {
                    System.out.println("Enter name of the description");
                    String input = scanner.nextLine();
                    File file = new File("src/main/resources/Transactions.csv");
                    Scanner fileScanner = new Scanner(file);
                    if (fileScanner.hasNextLine()) {
                        fileScanner.nextLine();
                    }
                    //this part below Read data from each line, splits it in parts and goes to the description spot that i assigned to 2
                    while (fileScanner.hasNextLine()) {
                        String line = fileScanner.nextLine();
                        String[] parts = line.split("\\|");
                        if (parts.length >= 4) {
                            String description = parts[2].trim();

                            //this part below matches user input with description details in the transaction list and print all lines that matches
                            if (input.equalsIgnoreCase(description)) {
                                System.out.println(line);
                            }
                        }
                    }
                }
                else if (choice.equalsIgnoreCase("C")) {
                    System.out.println("Please enter minimum amount: ");
                    double minimum = scanner.nextDouble();
                    System.out.println("Please enter maximum amount: ");
                    double maximum = scanner.nextDouble();
                    File file = new File("src/main/resources/Transactions.csv");
                    Scanner fileScanner = new Scanner(file);
                    if (fileScanner.hasNextLine()) {
                        fileScanner.nextLine();
                    }
                    boolean found = false;
                    while (fileScanner.hasNextLine()) {
                        String line = fileScanner.nextLine();
                        String[] parts = line.split("\\|");
                        if (parts.length >= 4) {
                            double amount = Double.parseDouble(parts[4].trim());

                            // this part below compare the amount with the minimum and maximum values
                            if (amount >= minimum && amount <= maximum) {
                                System.out.println(line);
                                found = true;
                            }
                        }
                    }
                    if (!found) {
                        System.out.println("No entries within the specified amount range.");
                    }
                }
                else {
                    System.out.println("Invalid entry");
                }
            } catch (Exception ex) {
                System.out.println("Error" + ex.getMessage());
            }
        }
  /*  }*/
}