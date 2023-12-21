package org.example;

import org.example.Vehicles;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DealershipFileManager {

    private static final String INVENTORY_FILE_PATH = "src/main/resources/Inventory.csv";

    public Dealership getDealership() {
        Dealership dealership = null;
        ArrayList<Vehicles> inventory = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(INVENTORY_FILE_PATH)) {
            try (Scanner scanner = new Scanner(fis)) {
                if (scanner.hasNextLine()) {
                    scanner.nextLine(); // Skip the header line
                }

                dealership = new Dealership("Steeven Motor", "123 address", "123-4567");
                dealership.setInventory(inventory);

                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String[] vehicleData = line.split("\\|");

                    if (vehicleData.length != 8) {
                        System.out.println("Invalid data format in line: " + line);
                        continue;
                    }

                    try {
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
                    } catch (NumberFormatException e) {
                        System.out.println("Error parsing data in line: " + line);
                    }
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error reading from file: " + ex.getMessage());
        }

        return dealership;
    }

    public static void saveVehicleToFile(List<Vehicles> inventory) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(INVENTORY_FILE_PATH))) {
            writer.println("Vin|Year|Make|Model|Vehicle type|Color|Odometer|Price");

            for (Vehicles vehicle : inventory) {
                writer.printf("%d|%d|%s|%s|%s|%s|%d|%.2f%n",
                        vehicle.getVin(), vehicle.getYear(), vehicle.getMake(), vehicle.getModel(),
                        vehicle.getVehicleType(), vehicle.getColor(), vehicle.getOdometer(), vehicle.getPrice());
            }

            System.out.println("Inventory data has been saved successfully.");
        } catch (IOException e) {
            System.out.println("Error occurred while saving inventory data: " + e.getMessage());
        }
    }

    public static void removeVehicleFromInventory(Vehicles vehicle) {
        List<String> updatedInventory = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/Inventory.csv"))) {
            String line;
            boolean headerSkipped = false;
            while ((line = reader.readLine()) != null) {
                if (!headerSkipped) {
                    headerSkipped = true;
                    updatedInventory.add(line);
                    continue;
                }
                String[] vehicleData = line.split("\\|");
                int vin = Integer.parseInt(vehicleData[0]);
                if (vin == vehicle.getVin()) {
                    // This is the existing vehicle, so we skip it.
                    continue;
                }
                updatedInventory.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error occurred while reading data from file: " + e.getMessage());
            return;
        }
        try (PrintWriter writer = new PrintWriter(new FileWriter("src/main/resources/Inventory.csv"))) {
            for (String vehicleLine : updatedInventory) {
                writer.println(vehicleLine);
            }
            System.out.println("Vehicle data has been removed from inventory successfully.");
        } catch (IOException e) {
            System.out.println("Error occurred while saving updated inventory data: " + e.getMessage());
        }
    }
}