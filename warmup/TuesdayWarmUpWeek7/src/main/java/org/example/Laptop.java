package org.example;

public class Laptop implements Device {
    @Override
    public void turnOn() {
        System.out.println("Laptop is turning on");
    }

    @Override
    public void turnOff() {
        System.out.println("Laptop is shutting down");
    }
}
