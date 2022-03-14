package com.example.demo.service;

import com.example.demo.dao.VehicleDao;
import com.example.demo.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {
    private final VehicleDao vehicleDao;

    @Autowired
    public VehicleService(@Qualifier("VDao") VehicleDao vehicleDao) {
        this.vehicleDao = vehicleDao;
    }

    public int addVehicle(Vehicle vehicle){
        return vehicleDao.insertVehicle(vehicle);
    }

    public List<Vehicle> getAllVehicles(){
        return vehicleDao.selectAllVehicles();
    }

    public Optional<Vehicle> getVehicleByLicenceNumber(String licenceNumber) {
        return vehicleDao.selectVehicleByLicenseNumber(licenceNumber);
    }

    public int deleteVehicleByLicenseNumber(String licenseNumber) {
        return vehicleDao.deleteVehicleByLicenseNumber((licenseNumber));
    }
    public int inflateVehicleByLicenseNumber(String licenseNumber){
        return vehicleDao.inflateVehicleByLicenseNumber(licenseNumber);
    }
    public int fuelOrChargeVehicleByLicenseNumber(String licenseNumber){
        return vehicleDao.fuelOrChargeVehicleByLicenseNumber(licenseNumber);
    }

}
