package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DealershipFileManager {

    //This method would be a good candidate to be static
    public Dealership getDealership() {
        //Why start off with a null dealership?
        Dealership dealership = null;
        //The dealership has the inventory, no?
        ArrayList<Vehicles> inventory = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream("src/main/resources/Inventory.csv");
            Scanner scanner = new Scanner(fis);
            scanner.nextLine();
            dealership = new Dealership("Steeven Motor", "123 address", "123-4567");
            //Isn't the inventory blank? You haven't added anything to it yet.
            dealership.setInventory(inventory);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] vehicleData = line.split("\\|");
                int vin = Integer.parseInt(vehicleData[0]);
                int year = Integer.parseInt(vehicleData[1]);
                String make = vehicleData[2];
                String model = vehicleData[3];
                String vehicleType = vehicleData[4];
                String color = vehicleData[5];
                int odometer = Integer.parseInt(vehicleData[6]);
                double price = Double.parseDouble(vehicleData[7]);
                Vehicles vehicle = new Vehicles(vin, year, make, model, vehicleType, color, odometer, price);
                inventory.add(vehicle);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }
        return dealership;
    }
    public void saveVehicleToFile(Vehicles vehicle) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("src/main/resources/Inventory.csv", true))) {
            writer.printf("%d|%d|%s|%s|%s|%s|%d|%.2f%n",
                    vehicle.getVin(), vehicle.getYear(), vehicle.getMake(), vehicle.getModel(),
                    vehicle.getVehicleType(), vehicle.getColor(), vehicle.getOdometer(), vehicle.getPrice());
            System.out.println("Vehicle data has been saved successfully.");
        } catch (IOException e) {
            System.out.println("Error occurred while saving vehicle data: " + e.getMessage());
        }
    }
    //nice use of buffered reader
    void removeVehicleFromFile(int vinToRemove) {
        List<Vehicles> updatedInventory = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/Inventory.csv"))) {
            String line;
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] vehicleData = line.split("\\|");
                int vin = Integer.parseInt(vehicleData[0]);
                if (vin != vinToRemove) {
                    updatedInventory.add(new Vehicles(vin, Integer.parseInt(vehicleData[1]), vehicleData[2],
                            vehicleData[3], vehicleData[4], vehicleData[5], Integer.parseInt(vehicleData[6]),
                            Double.parseDouble(vehicleData[7])));
                }
            }
        } catch (IOException e) {
            System.out.println("Error occurred while reading data from file: " + e.getMessage());
            return;
        }
        try (PrintWriter writer = new PrintWriter(new FileWriter("src/main/resources/Inventory.csv"))) {
            writer.println("Vin|Year|Make|Model|Vehicle type|Color|Odometer|Price");
            for (Vehicles vehicle : updatedInventory) {
                writer.printf("%d|%d|%s|%s|%s|%s|%d|%.2f%n",
                        vehicle.getVin(), vehicle.getYear(), vehicle.getMake(), vehicle.getModel(),
                        vehicle.getVehicleType(), vehicle.getColor(), vehicle.getOdometer(), vehicle.getPrice());
            }
            System.out.println("Vehicle data has been updated successfully.");
        } catch (IOException e) {
            System.out.println("Error occurred while saving updated vehicle data: " + e.getMessage());
        }
    }
}