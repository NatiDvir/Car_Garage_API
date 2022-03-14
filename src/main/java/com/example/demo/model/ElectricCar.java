package com.example.demo.model;

public class ElectricCar extends Car{
    public ElectricCar(String name, String type, String number, float maxTire, float energy) {
        super(name, type, number, maxTire, energy);
        this.energySource = new EnergySource("Battery",energy);
        this.wheels = new Wheels(4,0);
    }
}
