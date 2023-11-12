package org.example;

public class SalesContract extends Contract {
    private double salesTaxAmount;
    private double recordingFees;
    private double processingFees;
    private boolean isFinanced;

    public SalesContract(
            int vin, int year, String make, String model, String vehicleType, String color,
            int odometer, double price, String dayOfContract, String customerName, String customerEmail) {
        super(vin, year, make, model, vehicleType, color, odometer, price, dayOfContract, customerName, customerEmail);
        this.salesTaxAmount = 0.05; // Set default sales tax amount
        this.recordingFees = 100;   // Set default recording fees
        this.processingFees = 100;  // Set default processing fees
    }

    public double getSalesTaxAmount() {
        return getPrice() * 0.05;
    }

    public double getRecordingFees() {
        return 100;
    }

    public double getProcessingFees() {
        if (getPrice() <= 10000) {
            return 295;
        } else {
            return 495;
        }
    }
    public boolean isFinanced() {
        return isFinanced;
    }

    @Override
    public double getTotalPrice() {
        if (getPrice() >= 10000) {

            return getPrice() + getSalesTaxAmount() + getProcessingFees() + 495 + 0.0425;
        } else {
            return getPrice() + getSalesTaxAmount() + getProcessingFees() + 295 + 0.0525;
        }
    }

    @Override
    public double getMonthlyPayment() {
        double p = getPrice() + getSalesTaxAmount() + getProcessingFees() + getRecordingFees();
        double r = interestRate() / 12;
        if (getPrice() >= 10000) {
            return (p * r * Math.pow(1 + r, 48)) / (Math.pow(1 + r, 48) - 1);
        } else {
            return (p * r * Math.pow(1 + r, 24)) / (Math.pow(1 + r, 24) - 1);
        }
    }

    private double interestRate() {
        return isFinanced() ? 0.0425 : 0.0525;
    }

}



