package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Vehicle {
    String modelName = "";
    String vehicleType = "";
    String licenseNumber = "";
    EnergySource energySource = new EnergySource("", 0);
    float maxTirePres = 36;

    Wheels wheels = new Wheels(0, 0);

    public Vehicle(@JsonProperty("modelName") String modelName,
                   @JsonProperty("vehicleType") String vehicleType,
                   @JsonProperty("licenseNumber") String licenseNumber,
                   @JsonProperty("maxTirePres") float maxTirePres,
                   @JsonProperty("availableEnergy") float availableEnergy) {
        this.modelName = modelName;
        this.vehicleType = vehicleType;
        this.licenseNumber = licenseNumber;
        this.maxTirePres = maxTirePres;
        this.energySource.availableEnergy = availableEnergy;
    }

    //Vehicle Getters
    public String getModelName() {
        return modelName;
    }

    public String getVehicleType() {
        return this.vehicleType;
    }

    public String getLicenseNumber() {
        return this.licenseNumber;
    }

    public float getMaxTirePres() {
        return this.maxTirePres;
    }



    public EnergySource getEnergySource() {
        return energySource;
    }

    public Wheels getWheels() {
        return this.wheels;
    }

    //Vehicle Setters
    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public void setVehicleType(String type) {
        this.vehicleType = type;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public void setMaxTirePres(float max) {
        this.maxTirePres = max;
    }

    public void setEnergySource(EnergySource es) {
        this.energySource = es;
    }

    public void setWheels(Wheels wheels) {
        this.wheels = wheels;
    }

    //Charge,Fuel and infalte
    public void fuelOrCharge() {
        this.energySource.setEnergyAmount(this.energySource.availableEnergy + 200);

    }

    public void inflateTire() {
        this.wheels.pressure = this.maxTirePres;
    }


    public class EnergySource {
        String energyType = ""; // Battery/Fuel
        float availableEnergy = 0;

        public EnergySource(String type, float energy) {
            this.energyType = type;
            this.availableEnergy = energy;
        }

        public String getEnergyType() {
            return energyType;
        }

        public float getEnergyAmount() {
            return availableEnergy;
        }

        public void setEnergyType(String type) {
            this.energyType = type;
        }

        public void setEnergyAmount(float amount) {
            this.availableEnergy = amount;
        }
    }


    public class Wheels {
        int numOfWheels = 0;
        float pressure = 0;

        public Wheels(int numberOfWheels, float pressure) {
            this.numOfWheels = numberOfWheels;
            this.pressure = pressure;
        }

        public int getNumOfWheels() {
            return this.numOfWheels;
        }

        public float getPressure() {
            return this.pressure;
        }

        public void setNumOfWheels(int numOfWheels) {
            this.numOfWheels = numOfWheels;
        }

        public void setPressure(float pressure) {
            this.pressure = pressure;
        }

    }
}


