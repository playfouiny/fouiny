package org.example;

public class Smartphone implements Device {
    @Override
    public void turnOn() {
        System.out.println("Smartphone is turning on");
    }

    @Override
    public void turnOff() {
        System.out.println("Smartphone is shutting down");
    }
}
