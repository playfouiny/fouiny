package org.example;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Shapes> shapeList = new ArrayList<>();

        UserInterface userInterface = new UserInterface();
        ReceiptFileManager fileManager = new ReceiptFileManager("customer_receipt.txt");

        int choice;
        do {
            choice = userInterface.showHomeScreen();

            switch (choice) {
                case 1:
                    Shapes newShape = userInterface.createShape();
                    shapeList.add(newShape);
                    newShape.paint();
                    break;

                case 2:

                    System.out.println("Saving image...");
                    break;

                case 3:
                    fileManager.writeShapesToFile(shapeList.toArray(new Shapes[0]));
                    break;

                case 4:

                    System.out.println("Opening painting...");
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 0);
    }
}