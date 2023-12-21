package org.example;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Product> productlist = new ArrayList<>();
        ArrayList<String> cart = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("welcome to our online store");
        System.out.println("please select 1 to view product, 2 to view cart,3 exit");
        int choice = scanner.nextInt();
        while(true){
        switch (choice) {
            case 1:
                viewproduct(productlist);
                break;
            case 2:
                viewCart();

                break;
            case 3:
                System.out.println("see you soon");
                System.exit(0);
                break;
            default:
                System.out.println("invalid entry");
                break;
        }

        }
    }
private static void viewproduct(ArrayList<Product> productlist) {
        try {
            Scanner scanner = new Scanner(System.in);
            FileInputStream fis = new FileInputStream("src/main/resources/Products.csv");
            scanner = new Scanner(fis);
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String Input = scanner.nextLine();
                String[] line = Input.split("\\|");
                String SKU = line[0];
                String productname = line[1];
                Double price = Double.parseDouble(line[2]);
                String department = line[3];
                Product newitem = new Product(SKU, productname, price, department);
                productlist.add(newitem);
                System.out.println(newitem);
            }

        } catch (Exception ex) {
            System.out.println("not found");
        }
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("Please enter product SKU to to search product or 'exit' to go back:");
        String SKU = inputScanner.nextLine();
        if (!SKU.equalsIgnoreCase("exit")) {
            boolean found = false;
            for (Product product : productlist) {
                if (product.getSKU().equals(SKU)) {
                    found = true;
                    System.out.println("Results:");
                    System.out.printf("SKU: %s Product Name: %s Price: $%.2f Department: %s%n",
                            product.getSKU(), product.getProductname(), product.getPrice(), product.getDepartment());
                }
                System.out.println("Select 1 to add this item to your cart, 2 to continue shopping:");
                int choice = inputScanner.nextInt();
                if (choice == 1) {

                    addToCart(product);
                    System.out.println("Product added to cart!");
                }
                else if(choice == 2){
                    return;
                }
            }
            if (!found) {
                System.out.println("Product not found in stock.");
            }
        }
    }
    public static void addToCart(Product product) {
        try {
            FileWriter cartWriter = new FileWriter("src/main/resources/cart.txt", true);
            cartWriter.write(product.getSKU() + " " + product.getProductname() + " " +
                    product.getPrice() + " " + product.getDepartment() + "\n");
            cartWriter.close();
        } catch (Exception ex) {
            System.out.println("Error writing to cart file.");
        }
    }
    public static void viewCart(){
        try {
            ArrayList<Product> productlist = new ArrayList<>();
            Scanner scanner = new Scanner(System.in);
            FileInputStream fis = new FileInputStream("src/main/resources/Cart.txt");
            scanner = new Scanner(fis);
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String Input = scanner.nextLine();
                String[] line = Input.split("\\|");
                String SKU = line[0];
                String productname = line[1];
                Double price = Double.parseDouble(line[2]);
                String department = line[3];
                Product newitem = new Product(SKU, productname, price, department);
                productlist.add(newitem);
                System.out.println(newitem);
            }
        } catch (Exception ex)
        {
            System.out.println("not found");
        }
    }


}