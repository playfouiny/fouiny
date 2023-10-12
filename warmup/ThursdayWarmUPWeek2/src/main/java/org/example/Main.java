package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       /* Class Class = new Class("bob","irakoze",23123);*/
       /* Class.Greetings();*/
        Scanner scanner=new Scanner(System.in);
        System.out.println("please enter school year choose between 1-4");
        int SchoolYear= scanner.nextInt();

        System.out.println("are you an international student?");
        scanner.nextLine();
        String International= scanner.nextLine();
        if (International.equalsIgnoreCase("yes")){
            System.out.println("you are an international Student");
        }
        else
            System.out.println("you are not an international student");
        String Freshman="you are a Freshman";
        String Sophomore="you are a Sophomore";
        String Junior="you are a Junior";
        String Senior="you are a Senior";


        switch (SchoolYear){
            case 1:
                System.out.println(Freshman);
                break;
            case 2:
                System.out.println(Sophomore);
                break;
            case 3:
                System.out.println(Junior);
                break;
            case 4:
                System.out.println(Senior);
        }


    }
}