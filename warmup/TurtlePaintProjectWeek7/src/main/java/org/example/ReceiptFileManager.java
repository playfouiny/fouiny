package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ReceiptFileManager {
    private String fileName;

    public ReceiptFileManager(String fileName) {
        this.fileName = fileName;
    }

    public void writeShapesToFile(Shapes[] shapes) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (Shapes shape : shapes) {
                writer.println("Shape Type: " + shape.getClass().getSimpleName());
                writer.println("Location: " + shape.getLocation());
                writer.println("Color: " + shape.getColor());
                writer.println("Border Width: " + shape.getBorder());
                writer.println();
            }
            System.out.println("Receipt saved successfully!");
        } catch (IOException e) {
            System.err.println("Error writing receipt to file: " + e.getMessage());
        }
    }
}