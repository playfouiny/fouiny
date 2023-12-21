package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Financial Calculator Menu");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 150);
            frame.setLayout(new FlowLayout());

            JButton financeButton = new JButton("Use Financial Calculator");
            JButton exitButton = new JButton("Exit Application");

            financeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.dispose();
                    openFinanceCalculator();
                }
            });

            exitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });

            frame.add(financeButton);
            frame.add(exitButton);

            frame.setVisible(true);
        });
    }

    public static void openFinanceCalculator() {
        SwingUtilities.invokeLater(() -> {
            JFrame financeFrame = new JFrame("Financial Calculator");
            financeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            financeFrame.setSize(400, 300);
            financeFrame.setLayout(new GridLayout(7, 2));

            String[] financialOptions = {"Mortgage", "Future Value", "Present Value"};
            JComboBox<String> financeComboBox = new JComboBox<>(financialOptions);

            JLabel label1 = new JLabel("Enter amount:");
            JTextField field1 = new JTextField();

            JLabel label2 = new JLabel("Enter time (in years):");
            JTextField field2 = new JTextField();

            JLabel label3 = new JLabel("Enter interest rate:");
            JTextField field3 = new JTextField();

            JButton calculateButton = new JButton("Calculate");

            calculateButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String selectedOption = (String) financeComboBox.getSelectedItem();
                    double amount = Double.parseDouble(field1.getText());
                    double time = Double.parseDouble(field2.getText());
                    double interestRate = Double.parseDouble(field3.getText());

                    double result = 0;

                    if (selectedOption.equalsIgnoreCase("Mortgage")) {
                        double loanLength = time * 12;
                        double monthlyRate = ((interestRate / 12) / 100);
                        double monthlyPayments = (amount * monthlyRate) * Math.pow(1 + monthlyRate, loanLength) / (Math.pow(1 + monthlyRate, loanLength) - 1);
                        double totMonthlyPayments = monthlyPayments * loanLength;
                        double interestRates = totMonthlyPayments - amount;

                        JOptionPane.showMessageDialog(financeFrame, String.format(
                                "Your monthly payments will be %.2f$\nYour total payment is %.2f$\nYour total interest rate is %.2f$",
                                monthlyPayments, totMonthlyPayments, interestRates));
                    } else if (selectedOption.equalsIgnoreCase("Future Value")) {
                        double maturityLength = time * 365;
                        double dailyRates = (interestRate / 365) / 100;
                        double futureValue = amount * Math.pow(1 + dailyRates, maturityLength);
                        double interestRates = futureValue - amount;

                        JOptionPane.showMessageDialog(financeFrame, String.format(
                                "Your CD future value is %.2f$\nWith interest of %.2f$ included", futureValue, interestRates));
                    } else if (selectedOption.equalsIgnoreCase("Present Value")) {
                        double monthlyPayout = amount;
                        double monthlyRate = ((interestRate / 12) / 100);
                        double totMonths = time * 12;
                        double presentValue = monthlyPayout * ((1 - Math.pow(1 + monthlyRate, -totMonths)) / monthlyRate);

                        JOptionPane.showMessageDialog(financeFrame,
                                String.format("The present value of your annuity is %.2f$", presentValue));
                    }
                }
            });

            financeFrame.add(new JLabel("Select financial option:"));
            financeFrame.add(financeComboBox);
            financeFrame.add(label1);
            financeFrame.add(field1);
            financeFrame.add(label2);
            financeFrame.add(field2);
            financeFrame.add(label3);
            financeFrame.add(field3);
            financeFrame.add(new JLabel());
            financeFrame.add(calculateButton);

            financeFrame.setVisible(true);
        });
    }
}