package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Calculator Menu");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 150);
            frame.setLayout(new FlowLayout());

            JButton calculatorButton = new JButton("Use Calculator");
            JButton exitButton = new JButton("Exit Application");

            calculatorButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.dispose();
                    openCalculator();
                }
            });

            exitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });

            frame.add(calculatorButton);
            frame.add(exitButton);

            frame.setVisible(true);
        });
    }

    public static void openCalculator() {
        SwingUtilities.invokeLater(() -> {
            JFrame calcFrame = new JFrame("Calculator");
            calcFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            calcFrame.setSize(300, 200);
            calcFrame.setLayout(new GridLayout(4, 2));

            String[] operations = {"Addition", "Subtraction", "Multiplication", "Division"};
            JComboBox<String> operationComboBox = new JComboBox<>(operations);

            JLabel firstNumberLabel = new JLabel("Enter first number: ");
            JTextField firstNumberField = new JTextField();

            JLabel secondNumberLabel = new JLabel("Enter second number: ");
            JTextField secondNumberField = new JTextField();

            JButton calculateButton = new JButton("Calculate");

            calculateButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String selectedOperation = (String) operationComboBox.getSelectedItem();
                    float firstNumber = Float.parseFloat(firstNumberField.getText());
                    float secondNumber = Float.parseFloat(secondNumberField.getText());

                    float result = 0;

                    switch (selectedOperation) {
                        case "Addition":
                            result = firstNumber + secondNumber;
                            break;
                        case "Subtraction":
                            result = firstNumber - secondNumber;
                            break;
                        case "Multiplication":
                            result = firstNumber * secondNumber;
                            break;
                        case "Division":
                            result = firstNumber / secondNumber;
                            break;
                        default:
                            JOptionPane.showMessageDialog(calcFrame, "Invalid operation. Please try again.");
                            return;
                    }

                    JOptionPane.showMessageDialog(calcFrame, "Result: " + result);
                }
            });

            calcFrame.add(new JLabel("Select operation: "));
            calcFrame.add(operationComboBox);
            calcFrame.add(firstNumberLabel);
            calcFrame.add(firstNumberField);
            calcFrame.add(secondNumberLabel);
            calcFrame.add(secondNumberField);
            calcFrame.add(calculateButton);

            calcFrame.setVisible(true);
        });
    }
}