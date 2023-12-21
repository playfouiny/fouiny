package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Vehicle[] vehicle = new Vehicle[20];
        vehicle[0] = new Vehicle(101121, "Ford Explorer", "Red", 45000, 13500);
        vehicle[1] = new Vehicle(101122, "Toyota Camry", "Blue", 60000, 11000);
        vehicle[2] = new Vehicle(101123, "Chevrolet Malibu", "Black", 50000, 700);
        vehicle[3] = new Vehicle(101124, "Honda Civic", "White", 70000, 7500);
        vehicle[4] = new Vehicle(101125, "Subaru Outback", "Green", 55000, 14500);
        vehicle[5] = new Vehicle(101126, "Jeep Wrangler", "Yellow", 30000, 16000);
        System.out.println("What do you want to do?");
        System.out.println("1 - List all vehicles");
        System.out.println("2 - Search by make/model");
        System.out.println("3 - Search by price range");
        System.out.println("4 - Search by color");
        System.out.println("5 - Add a vehicle");
        System.out.println("6 - Quit");
        System.out.println("Enter 1, 2, 3, 4, 5, or 6: ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                displayVehicleList(vehicle);
                break;
            case 2:
                searchByMake(vehicle);
                break;
            case 3:
                searchByPrice(vehicle);
                break;
            case 4:
                searchByColor(vehicle);
                break;
            case 5:
                AddVehicle(vehicle);
                break;
            case 6:
                System.out.println("Have a good day.");
                break;
            default:
                System.out.println("Enter 1,2,3,4,5, or 6");
        }
    }

    public static void displayVehicleList(Vehicle[] vehicles) {
        for (Vehicle v : vehicles) {
            if (v != null) {
                System.out.printf("ID: %d, Make/Model: %s, Color: %s, Odometer: %d, Price: %.2f%n",
                        v.getVehicleId(), v.getMakeModel(), v.getColor(), v.getOdometerReading(), v.getPrice());
            }
        }
    }
    public static void searchByMake(Vehicle[] vehicles) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter Make/Model:");
        String car = scanner.nextLine();
        boolean done = false;
        for (Vehicle v : vehicles) {
            if (v != null && v.getMakeModel().equalsIgnoreCase(car)) {
                System.out.printf("ID: %d, Make/Model: %s, Color: %s, Odometer: %d, Price: %.2f%n", v.getVehicleId(), v.getMakeModel(), v.getColor(), v.getOdometerReading(), v.getPrice());
                done = true;
            }
        }
        if (!done) {
            System.out.println("Car not in inventory.");
        }
    }
    public static void searchByPrice(Vehicle[] vehicles) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter minimum price: ");
        double minimum = scanner.nextDouble();
        System.out.println("Please enter maximum price: ");
        double maximum = scanner.nextDouble();
        boolean done = false;
        for (Vehicle v : vehicles) {
            if (v != null && v.getPrice() >= minimum && v.getPrice() <= maximum) {
                System.out.printf("ID: %d, Make/Model: %s, Color: %s, Odometer: %d, Price: %.2f%n",
                        v.getVehicleId(), v.getMakeModel(), v.getColor(), v.getOdometerReading(), v.getPrice());
                done = true;
            }
        }
        if (!done) {
            System.out.println("No cars within the specified price range.");
        }
    }
    public static void searchByColor(Vehicle[] couleur) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter color:");
        String color = scanner.nextLine();
        boolean done=false;
        for (Vehicle v : couleur) {
            if (v != null && v.getColor().equalsIgnoreCase(color)) {
                System.out.printf("ID: %d, Make/Model: %s, Color: %s, Odometer: %d, Price: %.2f%n", v.getVehicleId(), v.getMakeModel(), v.getColor(), v.getOdometerReading(), v.getPrice());
                done = true;
            }
        }
            if (!done) {
                System.out.println("not in inventory");
        }
    }
    public static void AddVehicle(Vehicle[] vehicle) {
        Scanner scanner = new Scanner(System.in);
        Vehicle[] vehicles = new Vehicle[20];
        vehicles[0] = new Vehicle(101121, "Ford Explorer", "Red", 45000, 13500);
        vehicles[1] = new Vehicle(101122, "Toyota Camry", "Blue", 60000, 11000);
        vehicles[2] = new Vehicle(101123, "Chevrolet Malibu", "Black", 50000, 700);
        vehicles[3] = new Vehicle(101124, "Honda Civic", "White", 70000, 7500);
        vehicles[4] = new Vehicle(101125, "Subaru Outback", "Green", 55000, 14500);
        vehicles[5] = new Vehicle(101126, "Jeep Wrangler", "Yellow", 30000, 16000);
        int newIndex = 0;
        System.out.print("Enter vehicle ID: ");
        int vehicleId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter make/model: ");
        String makeModel = scanner.nextLine();
        System.out.print("Enter color: ");
        String color = scanner.nextLine();
        System.out.print("Enter odometer reading: ");
        int odometerReading = scanner.nextInt();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        vehicles[newIndex] = new Vehicle(vehicleId, makeModel, color, odometerReading, price);
        for (Vehicle newvehicle : vehicles) {
            if (newvehicle != null) {
                System.out.printf("ID: %d, Make/Model: %s, Color: %s, Odometer: %d, Price: %.2f%n", newvehicle.getVehicleId(), newvehicle.getMakeModel(), newvehicle.getColor(), newvehicle.getOdometerReading(), newvehicle.getPrice());
            }
        }
    }
}
