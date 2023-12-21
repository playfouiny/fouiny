package org.example;

public class Main {
    public static void main(String[] args) {
        Smartphone smartphone = new Smartphone();
        Laptop laptop = new Laptop();
        smartphone.turnOn();
        smartphone.turnOff();
        laptop.turnOn();
        laptop.turnOff();
    }
}