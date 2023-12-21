package org.example;

import java.util.Scanner;

public class calculator3 {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
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
}
