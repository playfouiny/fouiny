package org.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try{
            FileInputStream fis = new FileInputStream("src/main/resources/products.csv");

            Scanner scanner = new Scanner(fis);

            ArrayList<Product> inventoryItems = new ArrayList<>();

            scanner.nextLine();
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();

                String[] inventory = line.split("\\|");

                String sku = inventory[0];
                String productName = inventory[1];
                String department = inventory[3];

                double price = Double.parseDouble(inventory[2]);

                Product newItem = new Product(sku, productName, price, department);

                inventoryItems.add(newItem);
            }

            for(Product item : inventoryItems){
                System.out.printf("SKU: %s Product Name: %s Price: $%.2f Department: %s %n",
                        item.getSKU(), item.getProductname(), item.getPrice(), item.getDepartment());
            }
            double sum = 0;
            for(Product item : inventoryItems){
                sum += item.getPrice();
            }
            double average = sum / inventoryItems.size();
            System.out.println("the Total of all items is : "+ sum);

            System.out.println("The average price of an item is " + average);
        }
        catch(FileNotFoundException ex){
            System.out.println("File not found");
        }
    }
}