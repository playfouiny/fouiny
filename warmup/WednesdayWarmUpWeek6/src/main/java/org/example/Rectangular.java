package org.example;

public class Rectangular extends Shape{
    private double length;
    private double width;
    public Rectangular(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double area() {
        return length * width;
    }
}
