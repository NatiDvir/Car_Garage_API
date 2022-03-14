package com.example.demo.dao;

import com.example.demo.model.Vehicle;

import java.util.List;
import java.util.Optional;

public interface VehicleDao {
    int insertVehicle(String licenseNumber, Vehicle vehicle);

    default int insertVehicle(Vehicle vehicle){
        String licenseNumber = vehicle.getLicenseNumber();
        return insertVehicle(licenseNumber,vehicle);
    }

    List<Vehicle> selectAllVehicles();
    Optional<Vehicle> selectVehicleByLicenseNumber(String licenseNumber);
    int deleteVehicleByLicenseNumber(String licenseNumber);
    int inflateVehicleByLicenseNumber(String licenseNumber);
    int fuelOrChargeVehicleByLicenseNumber(String licenseNumber);
}
