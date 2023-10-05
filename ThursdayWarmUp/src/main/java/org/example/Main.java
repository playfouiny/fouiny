package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("how's the weather today?");
        System.out.println("Sunny, Cloudy, Rainy");
        String userImput = scanner.nextLine();
        if (userImput.equalsIgnoreCase("sunny")){
            System.out.println("It's a great day for outdoor activities!");
        }
        else if (userImput.equalsIgnoreCase("rainy")){
            System.out.println("Don't forget your umbrella!");}
    else if (userImput.equalsIgnoreCase("cloudy")){
            System.out.println("The weather is a bit uncertain.");
        } else
            System.out.println("Sorry, I'm not sure about that weather type");

        }
    }

