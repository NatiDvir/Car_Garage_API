package com.example.demo.model;

public class RegularCar extends Car {
    public RegularCar(String name, String type, String number, float maxTire, float energy) {
        super(name, type, number, maxTire, energy);
        this.energySource = new EnergySource("Fuel",energy);
        this.wheels = new Wheels(4,0);
    }
}
