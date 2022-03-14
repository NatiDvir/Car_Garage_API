package com.example.demo.api;

import com.example.demo.model.Vehicle;
import com.example.demo.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

@RequestMapping("api/v1/vehicle")
@RestController
public class VehicleController {
    private final VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) { this.vehicleService = vehicleService; }

    @PostMapping //(POST) localhost:8080/api/v1/vehicle
    public void addVehicle(@RequestBody Vehicle vehicle){ vehicleService.addVehicle(vehicle); }

    @GetMapping
    public List<Vehicle> getAllVehicles(@RequestParam(value = "sort",required = false) String sort ){
        List<Vehicle> lst = vehicleService.getAllVehicles();

        if(sort != null){
            if(sort.toLowerCase(Locale.ROOT).equals("asc")) {
                lst.sort(Comparator.comparing(Vehicle::getLicenseNumber));
            }
            else if(sort.toLowerCase(Locale.ROOT).equals("desc")) {
                lst.sort(Comparator.comparing(Vehicle::getLicenseNumber).reversed());
            }
        }
        return lst;
    }


    @GetMapping(path = "{licenseNumber}") //(GET) localhost:8080/api/v1/vehicle/{license number}
    public Vehicle getVehicleByLicenseNumber(@PathVariable("licenseNumber") String licenseNumber){
        return vehicleService.getVehicleByLicenceNumber(licenseNumber).orElse(null);
    }

    @DeleteMapping(path = "{licenseNumber}") //(DELETE) (GET) localhost:8080/api/v1/vehicle/{license number}
    public void deleteVehicleByLicenseNumber(@RequestBody Vehicle vehicle){ vehicleService.deleteVehicleByLicenseNumber(vehicle.getLicenseNumber()); }

    @PutMapping(path = "{licenseNumber}")
    @RequestMapping("/inflate/{licenseNumber}") //(GET) localhost:8080/api/v1/vehicle/inflate/{license number}
    public void inflateVehicleByLicenseNumber(@RequestBody Vehicle vehicle){ vehicleService.inflateVehicleByLicenseNumber(vehicle.getLicenseNumber()); }

    @PutMapping(path = "{licenseNumber}")
    @RequestMapping("/fuelOrCharge/{licenseNumber}")//(GET) localhost:8080/api/v1/vehicle/fuelOrCharge/{license number}
    public void fuelOrChargeVehicleByLicenseNumber(@RequestBody Vehicle vehicle){ vehicleService.fuelOrChargeVehicleByLicenseNumber(vehicle.getLicenseNumber()); }

}
