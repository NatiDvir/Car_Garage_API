package com.example.demo.model;


public class ElectricMotorcycle extends Motorcycle{

    public ElectricMotorcycle(String name, String type, String number, float maxTire, float energy) {
        super(name, type, number, maxTire, energy);
        this.energySource = new EnergySource("Battery",energy);
        this.wheels = new Wheels(2,0);
    }
}
