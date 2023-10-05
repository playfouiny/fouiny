package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("please enter pick up date with day and month");
        String PickUp = scanner.nextLine();
        System.out.println("please enter total days or rental");
        double RentalDays = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("please enter YES or NO to add toll tag for $3.94/day");
        String TT = scanner.nextLine();
        System.out.println("please enter YES or NO to add road side assistance for $3.95/day");
        String rAssist = scanner.nextLine();
        System.out.println("please enter YES or NO to add GPS for $2.95");
        String GPS = scanner.nextLine();
        System.out.println("please enter age in digits");
        int Age = scanner.nextInt();
        double TotBaseprice = 29.99 * RentalDays;
        System.out.println("the basic total price is "+" "+(TotBaseprice));
        double ExPrice1=0;
        double ExPrice2=0;
        double ExPrice3=0;
        double Exprice4=0;
         if (TT.equalsIgnoreCase("yes")) {
             ExPrice1 += RentalDays * 3.95;
             System.out.println("Toll Tag charges"+" " + ExPrice1);
        }
        if (GPS.equalsIgnoreCase("yes")) {
            ExPrice2 += RentalDays * 2.95;
            System.out.println("GPS charges"+" " + ExPrice2);
        }
        if (rAssist.equalsIgnoreCase("yes")) {
            ExPrice3 += RentalDays * 3.95;
            System.out.println("road side assistance charges"+" " + ExPrice3);
        }
        if (Age <= 25)
        {
            Exprice4 += RentalDays * 1.30;
            System.out.println("Under Age charges" +" " +Exprice4);
        }
        double FinalPrice = TotBaseprice+ ExPrice1+ ExPrice2+ ExPrice3+ Exprice4;
        System.out.println("the Final price is"+" "+FinalPrice);
    }
}