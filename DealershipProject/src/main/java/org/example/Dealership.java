package org.example;


import java.util.ArrayList;
import java.util.List;


public class Dealership {
    private String name;
    private String address;
    private String phone;

    private ArrayList<Vehicles> inventory;
    public ArrayList<Vehicles> getInventory() {
        return inventory;
    }
    public void setInventory(ArrayList<Vehicles> inventory) {
        this.inventory = inventory;
    }
    public Dealership(String name, String address, String phone) {

        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public List<Vehicles> getVehiclesByPrice(double min, double max) {
        List<Vehicles> priceInRange = new ArrayList<>();
        for (Vehicles v : getInventory()) {
            if (v.getPrice() >= min && v.getPrice() <= max) {
                priceInRange.add(v);
            }
        }
        return priceInRange;

    }
    public List<Vehicles> getVehiclesByMakeModel(String make, String model) {
        List<Vehicles> makemodel = new ArrayList<>();
        for (Vehicles v : getInventory()) {
            if (v.getMake().equalsIgnoreCase(make) || v.getModel().equalsIgnoreCase(model)) {
                makemodel.add(v);
            }
        }
        return makemodel;
    }
    public List<Vehicles> getVehiclesByYear(int min, int max) {
        List<Vehicles> yearsInRange = new ArrayList<>();
        for (Vehicles v : getInventory()) {
            if (v.getYear() >= min && v.getYear() <= max) {
                yearsInRange.add(v);
            }
        }
        return yearsInRange;
    }
    public List<Vehicles> getVehiclesByColor(String color) {
        List<Vehicles> colors = new ArrayList<>();
        for (Vehicles v : getInventory()) {
            if (v.getColor().equalsIgnoreCase(color) ) {
                colors.add(v);
            }
        }
        return colors;
    }
    public List<Vehicles> getVehiclesByMileage(int min, int max) {
        List<Vehicles> vehiclesInRange = new ArrayList<>();
        for (Vehicles v : getInventory()) {
            if (v.getOdometer() >= min && v.getOdometer() <= max) {
                vehiclesInRange.add(v);
            }
        }
        return vehiclesInRange;
    }
    public List<Vehicles> getVehiclesByType(String vehicleType) {
        List<Vehicles> type = new ArrayList<>();
        for (Vehicles v : getInventory()) {
            if (v.getVehicleType().equalsIgnoreCase(vehicleType)) {
                type.add(v);
            }
        }
        return type;
    }
    public void getAllVehicles() {
        for (Vehicles v : inventory) {
            System.out.println(v);
        }
    }
    public void addVehicle(Vehicles vehicle) {
        inventory.add(vehicle);
        DealershipFileManager manager = new DealershipFileManager();
        manager.saveVehicleToFile(vehicle);
    }
    public void removeVehicle(Vehicles vehicle) {
        inventory.remove(vehicle);
        DealershipFileManager manager = new DealershipFileManager();
        manager.removeVehicleFromFile(vehicle.getVin());
    }
}