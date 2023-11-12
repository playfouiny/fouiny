package org.example;

import java.io.*;
import java.util.List;

public class ContractFileManager {

    public static void saveContractsToFile(List<? extends Contract> contracts, String filePath, boolean append) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath, append))) {
            if (!append) {
                writer.println("ContractType|Vin|Year|Make|Model|Vehicle type|Color|Odometer|Price|DayOfContract|CustomerName|CustomerEmail|expectedEndingValue|leaseFee|totalPrice|monthlyPayment");
            }
            for (Contract contract : contracts) {
                if (contract instanceof SalesContract) {
                    SalesContract salesContract = (SalesContract) contract;
                    writer.println(String.format("Sale|%d|%d|%s|%s|%s|%s|%d|%.2f|%s|%s|%s|%s|%.2f|%.2f|%.2f|%.2f", salesContract.getVin(), salesContract.getYear(), salesContract.getMake(), salesContract.getModel(), salesContract.getVehicleType(), salesContract.getColor(), salesContract.getOdometer(), salesContract.getPrice(), salesContract.getDayOfContract(), salesContract.getCustomerName(), salesContract.getCustomerEmail(), salesContract.getSalesTaxAmount(), salesContract.getRecordingFees(), salesContract.getProcessingFees(), salesContract.getTotalPrice(), salesContract.getMonthlyPayment()));
                } else if (contract instanceof LeaseContract) {
                    LeaseContract leaseContract = (LeaseContract) contract;
                    writer.println(String.format("Lease|%d|%d|%s|%s|%s|%s|%d|%.2f|%s|%s|%s|%s|%.2f|%.2f|%.2f", leaseContract.getVin(), leaseContract.getYear(), leaseContract.getMake(), leaseContract.getModel(), leaseContract.getVehicleType(), leaseContract.getColor(), leaseContract.getOdometer(), leaseContract.getPrice(), leaseContract.getDayOfContract(), leaseContract.getCustomerName(), leaseContract.getCustomerEmail(), leaseContract.getExpectedEndingValue(), leaseContract.getLeaseFee(), leaseContract.getTotalPrice(), leaseContract.getMonthlyPayment()));
                }
            }
            System.out.println("Contracts data has been saved successfully.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}