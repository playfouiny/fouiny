package org.example;

public class LeaseContract extends Contract {
    private double expectedEndingValue;
    private double leaseFee;

    public LeaseContract(int vin, int year, String make, String model, String vehicleType, String color, int odometer, double price, String dayOfContract, String customerName, String customerEmail, Vehicles vehicleSold, double totalPrice, double monthlyPayment) {
        super(vin, year, make, model, vehicleType, color, odometer, price, dayOfContract, customerName, customerEmail);
        this.expectedEndingValue = getExpectedEndingValue();
        this.leaseFee = getLeaseFee();
    }

    public double getExpectedEndingValue(){
        return 0.5*getPrice();
    }
    public double getLeaseFee(){
        return 0.07*getPrice();
    }

    @Override
    public double getTotalPrice() {
        double p = getPrice();
        double leasefee = getLeaseFee();
        double leaseLength = 36;
        double interestRate = 0.04;
        return p + leasefee + getMonthlyPayment();
    }

    @Override
    public double getMonthlyPayment() {
        double p = getPrice();
        double rv = getExpectedEndingValue();
        double r = 0.04 / 12;
        double n = 36;
        return (p - rv) * r / (1 - Math.pow(1 + r, -n));
    }
    public String toString() {
        return String.format("Lease Contract Details:%nTotal Price: $%.2f%nMonthly Payment: $%.2f",
                getTotalPrice(), getMonthlyPayment());
    }
}