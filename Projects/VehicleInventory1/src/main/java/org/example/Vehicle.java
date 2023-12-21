package org.example;

public class Vehicle {
    public int VehicleId;
    public String MakeModel;
    public String Color;
    public int OdometerReading;
    public double Price;

    public Vehicle(int vehicleId, String makeModel, String color, int odometerReading, double price) {
        this.VehicleId = vehicleId;
        this.MakeModel = makeModel;
        this.Color = color;
        this.OdometerReading = odometerReading;
        this.Price = price;


    }

    public int getVehicleId() {
        return VehicleId;
    }

    public void setVehicleId(int vehicleId) {
        VehicleId = vehicleId;
    }

    public String getMakeModel() {
        return MakeModel;
    }

    public void setMakeModel(String makeModel) {
        MakeModel = makeModel;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public int getOdometerReading() {
        return OdometerReading;
    }

    public void setOdometerReading(int odometerReading) {
        OdometerReading = odometerReading;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }
    public class Add {
        public int VehicleId;
        public String MakeModel;
        public String Color;
        public int OdometerReading;
        public double Price;

        public Add(int vehicleId, String makeModel, String color, int odometerReading, double price) {
            this.VehicleId = vehicleId;
            this.MakeModel = makeModel;
            this.Color = color;
            this.OdometerReading = odometerReading;
            this.Price = price;


        }
    }
}

