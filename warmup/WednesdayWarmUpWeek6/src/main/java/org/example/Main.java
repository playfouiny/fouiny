package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
         ArrayList<Shape>shapeList=new ArrayList<>();
         shapeList.add(new Circle(3));
         shapeList.add(new Rectangular(8.0,3.0));
        shapeList.add(new Rectangular(5.0,2.0));
        shapeList.add(new Circle(6));
        for (Shape shape : shapeList) {
            if (shape instanceof Circle) {
                System.out.println("Circle Area: " + shape.area());
            } else if (shape instanceof Rectangular) {
                System.out.println("Rectangle Area: " + shape.area());
            }
        }
    }
}