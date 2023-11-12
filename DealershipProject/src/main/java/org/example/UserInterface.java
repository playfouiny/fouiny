package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private Dealership dealership;
    public ArrayList<Vehicles> inventory;

    public UserInterface() {
        this.scanner = new Scanner(System.in);  // Initialize the scanner object
        init();
    }
    private void init() {
        DealershipFileManager manager = new DealershipFileManager();
        this.dealership = manager.getDealership();
        this.inventory = dealership.getInventory();
    }
    public void display() {
        init();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("1. Get vehicles by price");
                System.out.println("2. Get vehicles by make and model");
                System.out.println("3. Get vehicles by year");
                System.out.println("4. Get vehicles by color");
                System.out.println("5. Get vehicles by mileage");
                System.out.println("6. Get vehicles by vehicle type");
                System.out.println("7. Get all vehicles");
                System.out.println("8. Add a vehicle");
                System.out.println("9. Remove a vehicle");
                System.out.println("10. SELL/LEASE A VEHICLE");
                System.out.println("0. Exit");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        processGetByPriceRequest();
                        break;
                    case 2:
                        processGetByMakeModelRequest();
                        break;
                    case 3:
                        processGetByYearRequest();
                        break;
                    case 4:
                        processGetByColorRequest();
                        break;
                    case 5:
                        processGetByMileageRequest();
                        break;
                    case 6:
                        processGetByVehicleTypeRequest();
                        break;
                    case 7:
                        processAllVehiclesRequest();
                        break;
                    case 8:
                        processAddVehicleRequest();
                        break;
                    case 9:
                        processRemoveVehicleRequest();
                        break;
                    case 10:
                        processSellOrLeaseRequest();
                        break;
                    case 0:
                        System.out.println("Exiting...");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            } catch (Exception ex) {
                System.out.println("error" + ex.getMessage());
                System.out.println("please select ");
                scanner.nextLine();
            }
        }
    }
    private void displayVehicles(List<Vehicles> vehicles) {
        for (Vehicles vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }
    private void processGetByPriceRequest() {
        Scanner scanner = new Scanner(System.in);
        int minPrice, maxPrice;
        boolean isValidMinPrice, isValidMaxPrice;
        do {
            System.out.println("Enter minimum price: ");
            isValidMinPrice = scanner.hasNextInt();
            if (isValidMinPrice) {
                minPrice = scanner.nextInt();
                scanner.nextLine();
                break;
            } else {
                System.out.println("Invalid entry. Please enter digits for minimum price.");
                scanner.nextLine();
            }
        } while (true);
        do {
            System.out.println("Enter maximum price: ");
            isValidMaxPrice = scanner.hasNextInt();
            if (isValidMaxPrice) {
                maxPrice = scanner.nextInt();
                scanner.nextLine();
                break;
            } else {
                System.out.println("Invalid entry. Please enter digits for maximum price.");
                scanner.nextLine();
            }
        } while (true);
        List<Vehicles> vehicles = dealership.getVehiclesByPrice(minPrice, maxPrice);
        displayVehicles(vehicles);
    }
    private void processGetByMakeModelRequest() {
        Scanner scanner = new Scanner(System.in);
        String make = null;
        String model = null;
        while (true) {
            try {
                while (true) {
                    System.out.println("Enter make: ");
                    make = scanner.nextLine();
                    if (make.matches("[A-Za-z]+")) {
                        break;
                    } else {
                        System.out.println("Invalid make format. Please enter alphabetic characters only.");
                    }
                }
                while (true) {
                    System.out.println("Enter model: ");
                    model = scanner.nextLine();
                    if (model.matches("[A-Za-z]+")) {
                        break;
                    } else {
                        System.out.println("Invalid model format. Please enter alphabetic characters only.");
                    }
                }
                List<Vehicles> vehicles = dealership.getVehiclesByMakeModel(make, model);
                displayVehicles(vehicles);
                break;
            } catch (Exception ex) {
                System.out.println("Error: " + ex.getMessage());

            }
        }
    }
    private void processGetByYearRequest() {
        scanner = new Scanner(System.in);
        boolean isValidInput = false;
        while (!isValidInput) {
            try {
                System.out.println("Enter minimum year: ");
                int minyear = scanner.nextInt();
                System.out.println("Enter maximum year: ");
                int maxyear = scanner.nextInt();
                List<Vehicles> vehicles = dealership.getVehiclesByYear(minyear, maxyear);
                displayVehicles(vehicles);
                isValidInput = true;
            } catch (Exception ex) {
                System.out.println("Invalid entry  " + ex.getMessage());
                scanner.nextLine();
            }
        }
    }
    private void processGetByColorRequest() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Enter color: ");
                String color = scanner.nextLine();
                if (color.matches("[A-Za-z]+")) {
                    List<Vehicles> vehicles = dealership.getVehiclesByColor(color);
                    displayVehicles(vehicles);
                    break;
                } else {
                    System.out.println("Invalid input format. Please enter alphabetic characters only.");
                }
            } catch (Exception ex) {
                System.out.println("An error occurred: " + ex.getMessage());
                break;
            }
        }
    }
    private void processGetByMileageRequest() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Enter minimum mileage: ");
                int minMileage = Integer.parseInt(scanner.nextLine());
                System.out.println("Enter maximum mileage: ");
                int maxMileage = Integer.parseInt(scanner.nextLine());
                List<Vehicles> vehicles = dealership.getVehiclesByMileage(minMileage, maxMileage);
                displayVehicles(vehicles);
                break;
            } catch (NumberFormatException ex) {
                System.out.println("Invalid mileage format. Please enter valid integers.");
            } catch (Exception ex) {
                System.out.println("An error occurred: " + ex.getMessage());
            }
        }
    }
    private void processGetByVehicleTypeRequest() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Enter vehicle type: ");
                String vehicleType = scanner.nextLine();
                if (vehicleType.matches("[A-Za-z]+")) {
                    List<Vehicles> vehicles = dealership.getVehiclesByType(vehicleType);
                    displayVehicles(vehicles);
                    break;
                } else {
                    System.out.println("Invalid input format. Please enter alphabetic characters only.");
                }
            } catch (Exception ex) {
                System.out.println("An error occurred: " + ex.getMessage());
                break;
            }
        }
    }
    private void processAllVehiclesRequest() {
        List<Vehicles> vehicles = dealership.getInventory();
        displayVehicles(vehicles);
    }
    private void processAddVehicleRequest() {
        Scanner scanner = new Scanner(System.in);
        int vin = 0;
        int year = 0;
        int odometer = 0;
        double price = 0.0;
        String make = null;
        String model = null;
        String vehicleType = null;
        String color = null;
        while (true) {
            try {
                System.out.println("Enter VIN: ");
                vin = Integer.parseInt(scanner.nextLine());
                if (String.valueOf(vin).matches("\\d{4}")) {
                    break;
                } else {
                    System.out.println("Invalid VIN format. Please enter a 4-digit number.");
                }
            } catch (NumberFormatException ex) {
                System.out.println("Invalid input format. Please enter a valid number for VIN.");
            }
        }
        while (true) {
            try {
                System.out.println("Enter Year: ");
                year = Integer.parseInt(scanner.nextLine());
                if (String.valueOf(year).matches("\\d{4}")) {
                    break;
                } else {
                    System.out.println("Invalid Year format. Please enter a 4-digit number.");
                }
            } catch (NumberFormatException ex) {
                System.out.println("Invalid input format. Please enter a valid number for Year.");
            }
        }
        while (true) {
            try {
                System.out.println("Enter Odometer Reading: ");
                odometer = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException ex) {
                System.out.println("Invalid input format. Please enter a valid number for Odometer Reading.");
            }
        }
        while (true) {
            try {
                System.out.println("Enter Price: ");
                price = Double.parseDouble(scanner.nextLine());

                break;
            } catch (NumberFormatException ex) {
                System.out.println("Invalid input format. Please enter a valid number for Price.");
            }
        }
        while (true) {
            System.out.println("Enter Make: ");
            make = scanner.nextLine();
            if (make.matches("[A-Za-z]+")) {
                break;
            } else {
                System.out.println("Invalid input format. Please enter alphabetic characters for Make.");
            }
        }
        while (true) {
            System.out.println("Enter Model: ");
            model = scanner.nextLine();
            if (model.matches("[A-Za-z]+")) {
                break;
            } else {
                System.out.println("Invalid input format. Please enter alphabetic characters for Model.");
            }
        }
        while (true) {
            System.out.println("Enter Vehicle Type: ");
            vehicleType = scanner.nextLine();
            if (vehicleType.matches("[A-Za-z]+")) {
                break;
            } else {
                System.out.println("Invalid input format. Please enter alphabetic characters for Vehicle Type.");
            }
        }
        while (true) {
            System.out.println("Enter Color: ");
            color = scanner.nextLine();
            if (color.matches("[A-Za-z]+")) {
                break;
            } else {
                System.out.println("Invalid input format. Please enter alphabetic characters for Color.");
            }
        }
        Vehicles vehicle = new Vehicles(vin, year, make, model, vehicleType, color, odometer, price);
        dealership.addVehicle(vehicle);
        System.out.println("Vehicle added successfully!");
    }
    private void processRemoveVehicleRequest() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("Enter VIN of the vehicle you want to remove: ");
                int vinToRemove = Integer.parseInt(scanner.nextLine());

                Vehicles vehicleToRemove = null;
                for (Vehicles vehicle : dealership.getInventory()) {
                    if (vehicle.getVin() == vinToRemove) {
                        vehicleToRemove = vehicle;
                        break;
                    }
                }

                if (vehicleToRemove != null) {
                    dealership.removeVehicle(vehicleToRemove);
                    System.out.println("Vehicle removed successfully!");
                } else {
                    System.out.println("No vehicle found with the provided VIN. Removal unsuccessful.");
                }

                break;
            } catch (NumberFormatException ex) {
                System.out.println("Invalid VIN format. Please enter a valid integer.");
            } catch (Exception ex) {
                System.out.println("An error occurred: " + ex.getMessage());
            }
        }
    }
    private void processSellOrLeaseRequest() {
        this.scanner = new Scanner(System.in);
        System.out.println("Do you want to (1) Sell or (2) Lease a vehicle?");
        int choice = this.scanner.nextInt();
        this.scanner.nextLine();
        switch (choice) {
            case 1:
                processSellVehicleRequest();
                break;
            case 2:
                processLeaseVehicleRequest();
                break;
            default:
                System.out.println("Invalid choice. Please enter 1 or 2.");
                break;
        }
    }
    public Vehicles findVehicleByVin(int vin) {
        for (Vehicles vehicle : inventory) {
            if (vehicle.getVin() == vin) {
                return vehicle;
            }
        }
        return null;
    }
    private void processLeaseVehicleRequest() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Available vehicles for lease:");
        processAllVehiclesRequest();
        System.out.println("Enter the VIN of the vehicle you want to lease: ");
        int vinToLease = scanner.nextInt();
        scanner.nextLine();
        Vehicles vehicleToLease = findVehicleByVin(vinToLease);
        if (vehicleToLease != null) {
            System.out.println("Enter the day of the lease (YYYY-MM-DD): ");
            String dayOfLease = scanner.nextLine();
            System.out.println("Enter customer name: ");
            String customerName = scanner.nextLine();
            System.out.println("Enter customer email: ");
            String customerEmail = scanner.nextLine();

            LeaseContract leaseContract = new LeaseContract(vehicleToLease.getVin(), vehicleToLease.getYear(), vehicleToLease.getMake(), vehicleToLease.getModel(), vehicleToLease.getVehicleType(), vehicleToLease.getColor(), vehicleToLease.getOdometer(), vehicleToLease.getPrice(), dayOfLease, customerName, customerEmail, vehicleToLease, 0,0 );
            System.out.println("Lease Contract Details:");
            System.out.println("Total Price: $" + leaseContract.getTotalPrice());
            System.out.println("Monthly Payment: $" + leaseContract.getMonthlyPayment());
            System.out.println(leaseContract);
            inventory.remove(vehicleToLease);
            DealershipFileManager.saveVehicleToFile(inventory);
            List<LeaseContract> leaseContractsList = new ArrayList<>();
            leaseContractsList.add(leaseContract);
            ContractFileManager.saveContractsToFile(leaseContractsList, "src/main/resources/Contracts.csv", true);
            DealershipFileManager.removeVehicleFromInventory(vehicleToLease);
            System.out.println("Vehicle leased successfully!");
        } else {
            System.out.println("No vehicle found with the provided VIN. Lease unsuccessful.");
        }
    }
    private void processSellVehicleRequest() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Available vehicles for sell:");
        processAllVehiclesRequest();
        System.out.println("Enter the VIN of the vehicle to sell:");
        int vinToSell = scanner.nextInt();
        scanner.nextLine();
        Vehicles vehicleToSell = findVehicleByVin(vinToSell);

        if (vehicleToSell != null) {
            System.out.println("Enter the day of the sale (YYYY-MM-DD):");
            String dayOfSale = scanner.nextLine();
            System.out.println("Enter the name of the customer:");
            String customerName = scanner.nextLine();
            System.out.println("Enter the email of the customer:");
            String customerEmail = scanner.nextLine();
            String contractsFilePath = "src/main/resources/Contracts.csv";
            SalesContract salesContract = new SalesContract(
                    vehicleToSell.getVin(),
                    vehicleToSell.getYear(),
                    vehicleToSell.getMake(),
                    vehicleToSell.getModel(),
                    vehicleToSell.getVehicleType(),
                    vehicleToSell.getColor(),
                    vehicleToSell.getOdometer(),
                    vehicleToSell.getPrice(),
                    dayOfSale,
                    customerName,
                    customerEmail);
            List<SalesContract> salesContractsList = new ArrayList<>();
            salesContractsList.add(salesContract);
            ContractFileManager.saveContractsToFile(salesContractsList, contractsFilePath, true);
            inventory.remove(vehicleToSell);
            System.out.println("Vehicle sold successfully!");
        } else {
            System.out.println("No vehicle found with the provided VIN. Sale unsuccessful.");
        }
    }
}