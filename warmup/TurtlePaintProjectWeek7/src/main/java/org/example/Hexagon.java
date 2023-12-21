package org.example;

import java.awt.*;

public class Hexagon extends Shapes {
    private int sideLength;

    public Hexagon(Turtle turtle, Point location, Color color, int border, int sideLength) {
        super(turtle, location, color, border);
        this.sideLength = sideLength;
    }

    @Override
    public void paint() {
        getTurtle().penUp();
        getTurtle().moveTo(getLocation());
        getTurtle().penDown();

        getTurtle().setPenColor(getColor());
        getTurtle().setPenWidth(getBorder());

        for (int i = 0; i < 6; i++) {
            getTurtle().forward(sideLength);
            getTurtle().turnRight(60);
        }
    }
}