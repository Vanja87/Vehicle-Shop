package com.web.project.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.web.project.model.Vehicle;
import com.web.project.model.VehicleManufacturer;
import com.web.project.model.VehicleModel;
import com.web.project.service.VehicleService;

@RestController()
@RequestMapping("api/")
public class VehicleController {
	
	@Autowired
	private VehicleService vehicleService;
	
	@RequestMapping(path = "vehicles/{typeName}/{model}/{manufacturer}", method = RequestMethod.GET)
    public List<Vehicle> getVehicleByModelAndManufacturer(@PathVariable String model,
    													  @PathVariable String manufacturer,
    													  @PathVariable String typeName) {
        return this.vehicleService.getVehiclesByModelAndManufacturer(model, manufacturer, typeName);
    }
	
	@RequestMapping(path = "vehicle-manufacturers/{type}", method = RequestMethod.GET)
    public List<VehicleManufacturer> getVehicleManufacturersByType(@PathVariable String type) {
        return this.vehicleService.getVehicleManufacturersByType(type);
    }
	
	@RequestMapping(path = "vehicle-models/{typeName}/{manufacturer}", method = RequestMethod.GET)
    public List<VehicleModel> getVehicleModelsByManufacturer(@PathVariable String manufacturer,
    														 @PathVariable String typeName) {
        return this.vehicleService.getVehicleModelsByManufacturer(manufacturer, typeName);
    }

}
