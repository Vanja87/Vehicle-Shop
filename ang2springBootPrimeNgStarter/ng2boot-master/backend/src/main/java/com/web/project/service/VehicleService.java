package com.web.project.service;

import java.util.List;

import com.web.project.model.Vehicle;
import com.web.project.model.VehicleManufacturer;
import com.web.project.model.VehicleModel;

public interface VehicleService {
	
	public List<Vehicle> findAll();
	
	public List<Vehicle> getVehiclesByModelAndManufacturer(String manufacturerName, String modelName, String typeName);
	
	public List<VehicleModel> getVehicleModelsByManufacturer(String manufacturerName, String typeName);
	
	public List<VehicleManufacturer> getVehicleManufacturersByType(String typeName);

}
