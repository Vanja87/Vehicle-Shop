package com.web.project.persistence;

import java.util.List;

import com.web.project.model.Vehicle;

public interface VehicleDaoCustom {
	
	public List<Vehicle> getVehiclesByModelAndManufacturer(String manufacturerName, 
														   String modelName, 
														   String typeName);

}
