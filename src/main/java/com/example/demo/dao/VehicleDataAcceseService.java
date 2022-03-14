package com.example.demo.dao;

import com.example.demo.model.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("VDao")
public class VehicleDataAcceseService implements VehicleDao{

    private static List<Vehicle> DB = new ArrayList<>(); // Get collection's items
    @Override
    public int insertVehicle(String licenseNumber, Vehicle vehicle) {
        Optional<Vehicle> check = selectVehicleByLicenseNumber(licenseNumber);
        if((check.isPresent())){ // If vehicle already exist , do not add him again.
            return 0;
        }
        switch (vehicle.getVehicleType()){  // Each type has his own constructor,I chose Regular Car as defualte value.

            case "regularcar":
                DB.add(new RegularCar(vehicle.getModelName(), vehicle.getVehicleType(), vehicle.getLicenseNumber(),vehicle.getMaxTirePres(),vehicle.getEnergySource().getEnergyAmount()));
                break;

            case "electriccar":
                DB.add(new ElectricCar(vehicle.getModelName(), vehicle.getVehicleType(), vehicle.getLicenseNumber(),vehicle.getMaxTirePres(),vehicle.getEnergySource().getEnergyAmount()));
                break;

            case "regularmotorcycle":
                DB.add(new RegularMotorcycle(vehicle.getModelName(), vehicle.getVehicleType(), vehicle.getLicenseNumber(),vehicle.getMaxTirePres(),vehicle.getEnergySource().getEnergyAmount()));
                break;

            case "electricmotorcycle":
                DB.add(new ElectricMotorcycle(vehicle.getModelName(), vehicle.getVehicleType(), vehicle.getLicenseNumber(),vehicle.getMaxTirePres(),vehicle.getEnergySource().getEnergyAmount()));
                break;

            case "truck":
                DB.add(new Truck(vehicle.getModelName(), vehicle.getVehicleType(), vehicle.getLicenseNumber(),vehicle.getMaxTirePres(),vehicle.getEnergySource().getEnergyAmount()));
                break;
            default:
                DB.add(new RegularCar(vehicle.getModelName(), vehicle.getVehicleType(), vehicle.getLicenseNumber(),vehicle.getMaxTirePres(),vehicle.getEnergySource().getEnergyAmount()));
        }
        return 1;
    }

    @Override
    public List<Vehicle> selectAllVehicles() {
        return DB;
    }

    @Override
    public Optional<Vehicle> selectVehicleByLicenseNumber(String licenseNumber) {
        return DB.stream()
                .filter(Vehicle->Vehicle.getLicenseNumber().equalsIgnoreCase(licenseNumber)) // Get vehicle by license number
                .findFirst();
    }

    @Override
    public int deleteVehicleByLicenseNumber(String licenseNumber) {
            Optional<Vehicle> check = selectVehicleByLicenseNumber(licenseNumber);
            if(!(check.isPresent())){ //If vehicle does not exist - do nothing
                return 0;
            }
            DB.remove(check.get());
            return 1;
    }

    @Override
    public int inflateVehicleByLicenseNumber(String licenseNumber) {
        return selectVehicleByLicenseNumber(licenseNumber).map
                (v -> {
                    int indexToInflate = DB.indexOf(v);
                    if (indexToInflate >= 0) {
                        System.out.println("Should Inflate");
                        DB.get(indexToInflate).inflateTire();
                        return 1;
                    } // First find vehicle by license number - then inflate his tires to their max pressure.
                    return 0;
                }).orElse(0);
    }
    public int fuelOrChargeVehicleByLicenseNumber(String licenseNumber){
        return selectVehicleByLicenseNumber(licenseNumber).map
                (v -> {
                    int indexToInflate = DB.indexOf(v);
                    if (indexToInflate >= 0) {
                        DB.get(indexToInflate).fuelOrCharge();
                        return 1;  // First find vehicle by license number - then add a value of 200 to their energy/fuel.
                    }
                    return 0; }).orElse(0);
    }
}

