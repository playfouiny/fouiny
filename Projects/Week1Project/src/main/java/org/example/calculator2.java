package org.example;

import java.util.Scanner;

public class calculator2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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
}
