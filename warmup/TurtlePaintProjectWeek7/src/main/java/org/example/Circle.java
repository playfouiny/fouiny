package org.example;

import java.awt.*;

public class Circle extends Shapes {
    private int radius;

    public Circle(Turtle turtle, Point location, Color color, int border, int radius) {
        super(turtle, location, color, border);
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public void paint() {
        getTurtle().penUp();
        getTurtle().moveTo(getLocation());
        getTurtle().penDown();

        getTurtle().setPenColor(getColor());
        getTurtle().setPenWidth(getBorder());

        getTurtle().circle(radius);
    }
}