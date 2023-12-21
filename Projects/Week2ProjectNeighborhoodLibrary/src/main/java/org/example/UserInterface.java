package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserInterface {
    private Library library;

    public UserInterface(Library library) {
        this.library = library;
        initializeUI();
    }

    private void initializeUI() {
        openMainMenu();
    }

    private void openMainMenu() {
        JFrame frame = new JFrame("Neighborhood Library");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new FlowLayout());

        JButton checkOutButton = new JButton("Check Out Books");
        JButton checkInButton = new JButton("Check In Books");
        JButton showAvailableButton = new JButton("Show Available Books");
        JButton showCheckedOutButton = new JButton("Show Checked Out Books");
        JButton exitButton = new JButton("Exit Application");

        checkOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openCheckOutBooks();
            }
        });

        checkInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openCheckInBooks();
            }
        });

        showAvailableButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openShowAvailableBooks();
            }
        });

        showCheckedOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openShowCheckedOutBooks();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                library.saveLibraryStatus();
                System.exit(0);
            }
        });

        frame.add(checkOutButton);
        frame.add(checkInButton);
        frame.add(showAvailableButton);
        frame.add(showCheckedOutButton);
        frame.add(exitButton);

        frame.setVisible(true);
    }

    private void openCheckOutBooks() {
        JFrame checkOutFrame = new JFrame("Check Out Books");
        checkOutFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        checkOutFrame.setSize(400, 300);
        checkOutFrame.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        JTextField nameField = new JTextField(20);
        JTextField titleField = new JTextField(20);
        JButton checkOutButton = new JButton("Check Out");
        inputPanel.add(new JLabel("Enter your name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Enter the title of the book to check out:"));
        inputPanel.add(titleField);
        inputPanel.add(checkOutButton);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textArea);
        checkOutFrame.add(scrollPane, BorderLayout.CENTER);

        for (Book book : library.getLibrary()) {
            if (book != null && !book.isCheckedOut()) {
                textArea.append(String.format("ID: %d, ISBN: %d, Title: %s%n",
                        book.getID(), book.getISBN(), book.getTitle()));
            }
        }

        checkOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String borrower = nameField.getText();
                String bookTitle = titleField.getText();

                if (!borrower.isEmpty() && !bookTitle.isEmpty()) {
                    library.checkOutBook(borrower, bookTitle);
                    checkOutFrame.dispose();
                } else {
                    JOptionPane.showMessageDialog(checkOutFrame, "Please enter both your name and a book title.");
                }
            }
        });

        checkOutFrame.add(inputPanel, BorderLayout.SOUTH);
        checkOutFrame.setVisible(true);
    }

    private void openCheckInBooks() {
        JFrame checkInFrame = new JFrame("Check In Books");
        checkInFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        checkInFrame.setSize(400, 300);
        checkInFrame.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        JTextField titleField = new JTextField(20);
        JButton checkInButton = new JButton("Check In");
        inputPanel.add(new JLabel("Enter the title of the book to check in:"));
        inputPanel.add(titleField);
        inputPanel.add(checkInButton);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textArea);
        checkInFrame.add(scrollPane, BorderLayout.CENTER);

        for (Book book : library.getLibrary()) {
            if (book != null && book.isCheckedOut()) {
                textArea.append(String.format("ID: %d, ISBN: %d, Title: %s, Checked Out To: %s%n",
                        book.getID(), book.getISBN(), book.getTitle(), book.getCheckedOutTo()));
            }
        }

        checkInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String bookTitle = titleField.getText();

                if (!bookTitle.isEmpty()) {
                    library.checkInBook(bookTitle);
                    checkInFrame.dispose();
                } else {
                    JOptionPane.showMessageDialog(checkInFrame, "Please enter the title of the book to check in.");
                }
            }
        });

        checkInFrame.add(inputPanel, BorderLayout.SOUTH);
        checkInFrame.setVisible(true);
    }
    private void openShowAvailableBooks() {
        JFrame showAvailableFrame = new JFrame("Show Available Books");
        showAvailableFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        showAvailableFrame.setSize(400, 300);
        showAvailableFrame.setLayout(new GridLayout(1, 1));

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);

        for (Book book : library.getLibrary()) {
            if (book != null && !book.isCheckedOut()) {
                textArea.append(String.format("ID: %d, ISBN: %d, Title: %s%n",
                        book.getID(), book.getISBN(), book.getTitle()));
            }
        }

        JScrollPane scrollPane = new JScrollPane(textArea);
        showAvailableFrame.add(scrollPane);

        showAvailableFrame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                openMainMenu();
            }
        });

        showAvailableFrame.setVisible(true);
    }

    private void openShowCheckedOutBooks() {
        JFrame showCheckedOutFrame = new JFrame("Show Checked Out Books");
        showCheckedOutFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        showCheckedOutFrame.setSize(400, 300);
        showCheckedOutFrame.setLayout(new GridLayout(1, 1));

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);

        for (Book book : library.getLibrary()) {
            if (book != null && book.isCheckedOut()) {
                textArea.append(String.format("ID: %d, ISBN: %d, Title: %s, Checked Out To: %s%n",
                        book.getID(), book.getISBN(), book.getTitle(), book.getCheckedOutTo()));
            }
        }

        JScrollPane scrollPane = new JScrollPane(textArea);
        showCheckedOutFrame.add(scrollPane);

        showCheckedOutFrame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                openMainMenu();
            }
        });

        showCheckedOutFrame.setVisible(true);
    }
}