package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter amount of loan you would like to request. Please only digits.");
        double Loan = scanner.nextDouble();
        System.out.println("Please enter how long you would your loan to be. please enter amount of years.");
        double length = scanner.nextDouble();
        System.out.println("Please enter desired interest rate");
        double Annualrates= scanner.nextDouble();
        double LoanLength= length *12;
        double Monthlyrate=((Annualrates/12)/100);
        double MonthlyPaments = (Loan * Monthlyrate) * Math.pow(1 + Monthlyrate, LoanLength) / (Math.pow(1 + Monthlyrate, LoanLength) - 1);
        double InterestRates= ((MonthlyPaments*LoanLength)-Loan);
        System.out.printf("your monthly payments will be %.2f $ ",MonthlyPaments);
        System.out.printf(" and your total interest rate is %.2f $", InterestRates);
    }
    }
