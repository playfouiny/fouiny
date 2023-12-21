package org.example;

import java.awt.*;
import java.util.Scanner;

public class UserInterface {
    private static final Scanner scanner = new Scanner(System.in);

    public static int showHomeScreen() {
        System.out.println("1) Add Shape");
        System.out.println("2) Save Image");
        System.out.println("3) Save Painting");
        System.out.println("4) Open Painting");
        System.out.println("0) Exit");
        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }

    public static Shapes createShape() {
        System.out.println("Which shape (1. square, 2. circle, 3. triangle, 4. hexagon)?");
        int choice = scanner.nextInt();

        System.out.println("What is the border width?");
        int border = scanner.nextInt();

        System.out.println("What is the border color?");
        scanner.nextLine();
        String color = scanner.nextLine();

        System.out.println("What is the location of the shape (x,y)?");
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        Point location = new Point(x, y);

        String colorString = null;
        switch (ShapeType.values()[choice - 1]) {
            case SQUARE:
                System.out.println("What is the side length?");
                int sideLength = scanner.nextInt();
                return new Square(new Turtle(), location, getColorFromString(color), border, sideLength);

            case CIRCLE:
                System.out.println("What is the radius?");
                int radius = scanner.nextInt();
                System.out.println("Enter the color:");
                colorString = scanner.next();
                return new Circle(new Turtle(), location, getColorFromString(colorString), border, radius);

            case TRIANGLE:
                System.out.println("What is the side length?");
                int triSideLength = scanner.nextInt();
                System.out.println("Enter the color:");
                colorString = scanner.next();
                return new Triangle(new Turtle(), location, getColorFromString(colorString), border, triSideLength);

            case HEXAGON:
                System.out.println("What is the side length?");
                int hexSideLength = scanner.nextInt();
                System.out.println("Enter the color:");
                colorString = scanner.next();
                return new Hexagon(new Turtle(), location, getColorFromString(colorString), border, hexSideLength);

            default:
                throw new IllegalArgumentException("Invalid shape choice");
        }
    }

    private static Color getColorFromString(String color) {
        try {
            return Color.decode(color);
        } catch (NumberFormatException e) {
            try {
                return (Color) Color.class.getField(color.toUpperCase()).get(null);
            } catch (Exception ex) {
                System.err.println("Error decoding color: " + color);
                return Color.BLACK;
            }
        }
    }
}