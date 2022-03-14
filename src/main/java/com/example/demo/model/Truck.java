package com.example.demo.model;

public class Truck extends Car{
    public Truck(String name, String type, String number, float maxTire, float energy) {
        super(name,type, number, maxTire, energy);
        this.energySource = new EnergySource("Fuel",energy);
        this.wheels = new Wheels(16,0);
    }
}
