package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);

        try {
            System.out.println("please enter first number");
            int First= scanner.nextInt();
            System.out.println("please enter second number");
            int Second= scanner.nextInt();
            int Result= First/Second;
            System.out.println("result is");
            System.out.println(Result);
        }
        catch (NumberFormatException V){
            System.out.println("i need a integer");
            V.printStackTrace();

        }
        catch (InputMismatchException V){
            System.out.println("i need a whole number buddy!");
            V.printStackTrace();
        }
        catch (ArithmeticException V){
            System.out.println("i cant do this operation buddy!");
            V.printStackTrace();
        }
        System.out.println("see ya!");

    }
}