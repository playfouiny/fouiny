package org.example;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Please select 1 for Goldilocks story, 2 for Hansel and Gretel story, 3 for Mary Had a Little Lamb story, or 0 to exit");
            int choice = scanner.nextInt();

            if (choice == 0) {
                System.out.println("Exiting the program. Goodbye!");
                break;
            }

            switch (choice) {
                case 1:
                    printStory("src/main/resources/goldilocks.txt");
                    break;
                case 2:
                    printStory("src/main/resources/hansel_and_gretel.txt");
                    break;
                case 3:
                    printStory("src/main/resources/mary_had_a_little_lamb.txt");
                    break;
                default:
                    System.out.println("Invalid input. Please try again.");
                    break;
            }
        }
    }

    private static void printStory(String filePath) {
        try (FileInputStream fis = new FileInputStream(filePath);
             Scanner scanner = new Scanner(fis)) {

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}