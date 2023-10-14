package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to your financial Calculator");
        System.out.println("please select A for Mortgage, B for Future Value and C for present value");
        String Answer = scanner.nextLine();
        if (Answer.equalsIgnoreCase("A")) {
            System.out.println("Please enter amount of loan you would like to request. Please only digits.");
            double Loan = scanner.nextDouble();
            System.out.println("Please enter how long you would your loan to be. please enter amount of years.");
            double length = scanner.nextDouble();
            System.out.println("Please enter desired interest rate");
            double Annualrates = scanner.nextDouble();
            double LoanLength = length * 12;
            double Monthlyrate = ((Annualrates / 12) / 100);
            double MonthlyPaments = (Loan * Monthlyrate) * Math.pow(1 + Monthlyrate, LoanLength) / (Math.pow(1 + Monthlyrate, LoanLength) - 1);
            Double TotMonthlyPayments = MonthlyPaments * LoanLength;
            double InterestRates = TotMonthlyPayments - Loan;
            System.out.printf("your monthly payments will be %.2f $ ", MonthlyPaments);
            System.out.printf("your total payment is %.2f $ ", TotMonthlyPayments);
            System.out.printf(" and your total interest rate is %.2f $", InterestRates);
        }
        else if (Answer.equalsIgnoreCase("B")){
            System.out.println("Please enter amount of cash to deposit. Please only digits.");
            double Deposit = scanner.nextDouble();
            System.out.println("Please enter how long you would like to mature your CD. please enter amount of years.");
            double length = scanner.nextDouble();
            System.out.println("please enter desired interest rate");
            double AnnualRates= scanner.nextDouble();
            double MaturityLength= length *365;
            double DailyRates= (AnnualRates/365)/100;
            double FutureValue=Deposit*Math.pow(1+DailyRates,MaturityLength);
            double InterestRates= FutureValue-Deposit;
            System.out.printf("your CD future value is %.2f $",FutureValue);
            System.out.printf(" with interest of %.2f $ included",InterestRates);
        }
        else if (Answer.equalsIgnoreCase("C")){
            System.out.println("please enter your monthly payout");
            double MonthlyPayout= scanner.nextDouble();
            System.out.println("please enter your desired Annual interest rate");
            double InterestRate= scanner.nextDouble();
            System.out.println("enter number of years to payout");
            double LoanLength= scanner.nextDouble();
            double MonthlyRate=((InterestRate/12)/100);
            double TotMonths= LoanLength*12;
            double PresentValue =MonthlyPayout * ((1 - Math.pow(1 + MonthlyRate, -TotMonths))/MonthlyRate);
            System.out.printf("the present value of your annuity is %.2f $ ", PresentValue);
        }
        else{
            System.out.printf("please enter valid entry");
        }
    }
}
