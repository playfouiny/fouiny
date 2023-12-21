package org.example;

import java.awt.*;

public class Turtle {
    private int x;
    private int y;
    private Color penColor;
    private int penWidth;

    public Turtle() {

        this.x = 0;
        this.y = 0;
        this.penColor = Color.BLACK;
        this.penWidth = 1;
    }

    public void penUp() {
        System.out.println("Pen up");
    }

    public void penDown() {
        System.out.println("Pen down");
    }

    public void moveTo(Point point) {
        this.x = point.x;
        this.y = point.y;
        System.out.println("Move to: (" + x + ", " + y + ")");
    }

    public void setPenColor(Color color) {
        this.penColor = color;
        System.out.println("Set pen color to: " + color);
    }

    public void setPenWidth(int width) {
        this.penWidth = width;
        System.out.println("Set pen width to: " + width);
    }

    public void forward(int distance) {
        System.out.println("Move forward by: " + distance);

        System.out.println("Draw line from (" + x + ", " + y + ") to (" + (x + distance) + ", " + y + ")");
        this.x += distance;
    }

    public void turnRight(int angle) {
        System.out.println("Turn right by: " + angle + " degrees");
    }

    public void circle(int radius) {
        System.out.println("Draw circle with radius: " + radius);

        System.out.println("Draw circle centered at (" + x + ", " + y + ") with radius " + radius);
    }
}