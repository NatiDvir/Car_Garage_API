
                                                             Home Task: Car Garage
                                                                By Natanel Dvir
                                                        github.com/NatiDvir/Car_Garage_API
                                                        
                                                        
Modularity of classes:
  
  
                                                            -> Car         -> Electric/Regular Car
                                                 Vehicle   -> Motorcycle  -> Electric/Regular Motorcycle
                                                           -> Truck    


Installation:


                                • Use IntelliJ IDE (Or any other IDE) , and start server from "CarGarageApplication".   
                                • Use Postman to send/get requests with the URLs ill provide.
    
Endpoints:


                                  Provide a JSON of this format:
                                  "modelName":"SubaroPesha",
                                  "vehicleType":"regularcar",
                                  "licenseNumber":"991",
                                  "maxTirePres":"36",
                                  "availableEnergy":"100"

Add a new vehicle to the vehicle's collection :


                                  (POST) localhost:8080/api/v1/vehicle

Retrieve a single vehicle by license number:


                                  (GET) localhost:8080/api/v1/vehicle/{license number}


Retrieve all of the available vehicles:


                                  (GET) localhost:8080/api/v1/vehicle 

BONUS: Get vehicles by ascending or descending license number:


                                  localhost:8080/api/v1/vehicle?sort=asc
                                  localhost:8080/api/v1/vehicle?sort=desc


Inflate vehicle tires to maximum pressure:


                                  (PUT) localhost:8080/api/v1/vehicle/inflate/{license number}

Add energy (Refuel a vehicle or recharge) by license number:


                                  (PUT) localhost:8080/api/v1/vehicle/fuelOrCharge/{license number}
